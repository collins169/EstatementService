@echo off
if not exist target mkdir target
if not exist target\classes mkdir target\classes

set PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_271\bin;C:\Windows\Microsoft.NET\Framework64\v4.0.30319

echo compile classes
javac -nowarn -d target\classes -sourcepath jvm -cp "f:\devs\java\jni4net-0.8.8.0-bin\lib\jni4net.j-0.8.8.0.jar"; "jvm\fasylstatementlibrary/models\AllCustomerAccount.java" "jvm\fasylstatementlibrary/models\CustomerInformation.java" "jvm\fasylstatementlibrary/models\CustomerInformations.java" "jvm\fasylstatementlibrary/models\SttbScheduledStatements.java" "jvm\fasylstatementlibrary/models\StvwTransaction.java" "jvm\fasylstatementlibrary/models\TransactionHistories.java" "jvm\fasylstatementlibrary/models\TransactionHistory.java" "jvm\fasylstatementlibrary/models\TransactionStatistics.java" "jvm\fasylstatementlibrary\StatementGenerator.java" 
IF %ERRORLEVEL% NEQ 0 goto end


echo FasylStatementLibrary.j4n.jar 
jar cvf FasylStatementLibrary.j4n.jar  -C target\classes "fasylstatementlibrary\models\AllCustomerAccount.class"  -C target\classes "fasylstatementlibrary\models\CustomerInformation.class"  -C target\classes "fasylstatementlibrary\models\CustomerInformations.class"  -C target\classes "fasylstatementlibrary\models\SttbScheduledStatements.class"  -C target\classes "fasylstatementlibrary\models\StvwTransaction.class"  -C target\classes "fasylstatementlibrary\models\TransactionHistories.class"  -C target\classes "fasylstatementlibrary\models\TransactionHistory.class"  -C target\classes "fasylstatementlibrary\models\TransactionStatistics.class"  -C target\classes "fasylstatementlibrary\StatementGenerator.class"  > nul 
IF %ERRORLEVEL% NEQ 0 goto end


echo FasylStatementLibrary.j4n.dll 
csc /nologo /warn:0 /t:library /out:FasylStatementLibrary.j4n.dll /recurse:clr\*.cs  /reference:"F:\Devs\JAVA\EstatementService\EstatementGenerator\lib\FasylStatementLibrary.dll" /reference:"F:\Devs\JAVA\jni4net-0.8.8.0-bin\lib\jni4net.n-0.8.8.0.dll"
IF %ERRORLEVEL% NEQ 0 goto end


:end
