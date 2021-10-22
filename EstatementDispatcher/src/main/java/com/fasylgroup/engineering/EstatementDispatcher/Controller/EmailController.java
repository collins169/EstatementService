package com.fasylgroup.engineering.EstatementDispatcher.Controller;

import com.fasylgroup.engineering.EstatementDispatcher.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementDispatcher.Model.CustomerInfo;
import com.fasylgroup.engineering.EstatementDispatcher.Model.SttbScheduledStatements;
import com.fasylgroup.engineering.EstatementDispatcher.Repository.CustomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class EmailController {
    private Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private DBConfiguration dbConfiguration;
    @Autowired
    private CustomRepository customRepository;
    @Value("${STATEMENT_TEMPLATE}")
    private String template;
    private List<String> exist = new ArrayList<>();

    public EmailController(DBConfiguration dbConfiguration, CustomRepository customRepository) {
        this.dbConfiguration = dbConfiguration;
        this.customRepository = customRepository;
    }

    //    @Async
    public Boolean sendEmail(CustomerInfo info, SttbScheduledStatements statement){
        boolean sent = false;
        String[] tmpEmails;

        try{
            if(info.getCustEmail() == null || info.getCustEmail().isEmpty()){
                return false;
            }
            Map<String, String> appConfig = dbConfiguration.getAppConfig();
            Properties props = new Properties();
            props.put("mail.smtp.auth", appConfig.get("IsAuthRequired").toUpperCase().equals("TRUE"));
            props.put("mail.smtp.starttls.enable", appConfig.get("EnableSSL").toUpperCase().equals("TRUE"));
            props.put("mail.smtp.host", appConfig.get("SmtpHost"));
            props.put("mail.smtp.ssl.enable", Boolean.valueOf(appConfig.get("EnableSSL")));
            props.put("mail.smtp.port", Integer.parseInt(appConfig.get("SmtpPort")));
            props.put("mail.debug", true);
            info.setCustEmail(info.getCustEmail().replaceAll(";", ","));
            if(info.getCustEmail().contains(",")){
                tmpEmails = info.getCustEmail().trim().split(",");
            }else{
                tmpEmails = new String []{info.getCustEmail()};
            }

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(appConfig.get("User"), appConfig.get("Password"));
                        }
                    });
            MimeMessage message = new MimeMessage(session);
            message.setHeader("X-Priority", "1");
            MimeMessageHelper helper = new MimeMessageHelper(message,true, "UTF-8");
            helper.setSubject("Statements Of Account");
            helper.setFrom(appConfig.get("DefaultEmailAddress"), "Access Bank Statement Alert");
//                helper.setTo(InternetAddress.parse(email));
            InternetAddress[] recipientAddress = new InternetAddress[tmpEmails.length];
            int counter = 0;
            for (String recipient : tmpEmails) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            helper.setTo(recipientAddress);
            helper.setText(GetMessageTemplate(statement, info.getCustName()), true);
            ByteArrayDataSource attachment = new ByteArrayDataSource(new FileInputStream(statement.getPdfPath()), "application/pdf");
            helper.addAttachment(new SimpleDateFormat("dd-MMM-yyyy").format(new Date())+"Statment.pdf", attachment);
            Transport.send(message);
            sent = true;
        }catch (Exception ex){
            logger.error("Exception Occurred | sendEmail |: {}", ex.toString());
        }
        String msg = MessageFormat.format("{0} => Email sent to {1} {2}", new SimpleDateFormat("dd-MMM-yy HH:mm:ss").format(new Date()), info.getCustEmail().trim(), sent ? "successfully" : "failed");
        logger.info(msg);
        return sent;
    }

    public String GetMessageTemplate(SttbScheduledStatements statement, String customerName){
        String messageTemplate = "";
        try{
            messageTemplate = readFile(template);
            messageTemplate = MessageFormat.format(messageTemplate, customerName, new SimpleDateFormat("dd-MMM-yyyy").format(statement.getStartDate()), new SimpleDateFormat("dd-MMM-yyyy").format(statement.getEndDate()));
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return messageTemplate;
    }

    public String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
