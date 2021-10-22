package com.fasylgroup.engineering.EstatementDispatcher.Controller;

import com.fasylgroup.engineering.EstatementDispatcher.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementDispatcher.Model.CustomerInfo;
import com.fasylgroup.engineering.EstatementDispatcher.Model.SttbScheduledStatements;
import com.fasylgroup.engineering.EstatementDispatcher.Repository.CustomRepository;
import com.fasylgroup.engineering.EstatementDispatcher.Repository.SttbScheduledStatementsRepository;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Controller
public class StatementController {
    private Logger logger = LoggerFactory.getLogger(StatementController.class);
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private SttbScheduledStatementsRepository statementsRepository;
    @Autowired
    private EmailController emailController;
    List<String> processed = new ArrayList<>();

    public StatementController(CustomRepository customRepository, SttbScheduledStatementsRepository statementsRepository, EmailController emailController) {
        this.customRepository = customRepository;
        this.statementsRepository = statementsRepository;
        this.emailController = emailController;
    }

    public void fetchAndDispatch(){
        logger.info("================== Fetching All pending emails ==================");
        try {
            List<SttbScheduledStatements> sttbScheduledStatements = statementsRepository.findByStatusAndPdfPathIsNotNull("PENDING");
            logger.info("Total pending emails to be sent: {}", sttbScheduledStatements.size());
            if (sttbScheduledStatements.size() > 0) {
                //Let use parallel Stream to increase the efficiency
                sttbScheduledStatements.parallelStream().forEach(statement -> {
                    try {
                        if(!processed.contains(statement.getAcNo())) {
                            processed.add(statement.getAcNo());
                            CustomerInfo info = customRepository.GetCustomerName(statement.getAcNo());
//                        cleanUpFiles(statement, info.getCustNo());
                            boolean emailSent = emailController.sendEmail(info, statement);
                            statement.setStatus(emailSent ? "PROCESSED" : "FAILED");
                            statement.setStmtDtSend(new Date());
//                        statementsRepository.save(statement);
                            customRepository.UpdateLog(statement);
                            if (emailSent) {
                                ZipFolderAndBackup(statement, info.getCustNo());
                            }
                        }
                    } catch (Exception ex) {
                        logger.error(ex.toString(), ex);
                    }
                });
                Thread.sleep(1000);
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    public void cleanUpFiles(SttbScheduledStatements statement, String custNo){
        try {
            String month = new SimpleDateFormat("MMM").format(new Date());
            File location = new File(MessageFormat.format("C:\\eaes\\statementPdf\\{0}\\{1}\\{2}", month, statement.getStmntType(), custNo));
            if(location.exists() && location.isDirectory()){
                File[] files = location.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.getName().equals(statement.getAcNo()+".pdf")){
                            file.delete();
                        }
                    }
                }
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    public void ZipFolderAndBackup(SttbScheduledStatements statement, String custNo){
        try{
            File backupDir = new File("C:\\eaes\\statementPdf\\pdf_backups_" + new SimpleDateFormat("dd_MMM_yyyy").format(new Date()));
            if(!backupDir.exists()){
                backupDir.mkdirs();
            }
            String maskedAcct = statement.getAcNo().substring(0, 6) + "xxxxxx" + statement.getAcNo().substring(12);
            String month = new SimpleDateFormat("MMM").format(new Date());
            String inputDir = MessageFormat.format("C:\\eaes\\statementPdf\\{0}\\{1}\\{2}", month, statement.getStmntType(), custNo);
            String outputDir = MessageFormat.format(backupDir.getAbsolutePath()+"\\{0}_{1}.zip", new SimpleDateFormat("dd_MMM_yyyy").format(new Date()), maskedAcct);
            File move = new File(outputDir);
            if(move.exists()){
                move.delete();
            }
            // Creating encryption zipParameters
            // for passward protection
            ZipParameters zipParameters = new ZipParameters();

            // Setting encryption files
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            // Setting encryption of files to true
            zipParameters.setEncryptFiles(true);

            // Setting encryption method
            zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

            // Set the key strength
            zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

            // Set the password
            zipParameters.setPassword(statement.getStmtPass());

            // Creating ZIP file
            ZipFile zipFile = new ZipFile(outputDir);

            // Pass and ZIP parameters
            // for Zip folder to be created
            zipFile.addFolder(new File(inputDir), zipParameters);
            File f = new File(inputDir);
            if(f.exists()) {
                f.delete();
            }

        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
    }

}
