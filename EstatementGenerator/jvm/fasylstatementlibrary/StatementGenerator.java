// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

package fasylstatementlibrary;

@net.sf.jni4net.attributes.ClrType
public class StatementGenerator extends system.Object {
    
    //<generated-proxy>
    private static system.Type staticType;
    
    protected StatementGenerator(net.sf.jni4net.inj.INJEnv __env, long __handle) {
            super(__env, __handle);
    }
    
    @net.sf.jni4net.attributes.ClrConstructor("()V")
    public StatementGenerator() {
            super(((net.sf.jni4net.inj.INJEnv)(null)), 0);
        fasylstatementlibrary.StatementGenerator.__ctorStatementGenerator0(this);
    }
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    private native static void __ctorStatementGenerator0(net.sf.jni4net.inj.IClrProxy thiz);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;LSystem/String;LFasylStatementLibrary/Models/TransactionStatistics;LFasylStatementLibrary/Models/SttbScheduledStatements;)LSystem/String;")
    public native java.lang.String GenerateStatement(java.lang.String custId, java.lang.String CustomerInfo, java.lang.String Transactions, fasylstatementlibrary.models.TransactionStatistics statistics, fasylstatementlibrary.models.SttbScheduledStatements statement);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;)LSystem/String;")
    public native java.lang.String GenerateStatmentTest(java.lang.String name);
    
    public static system.Type typeof() {
        return fasylstatementlibrary.StatementGenerator.staticType;
    }
    
    private static void InitJNI(net.sf.jni4net.inj.INJEnv env, system.Type staticType) {
        fasylstatementlibrary.StatementGenerator.staticType = staticType;
    }
    //</generated-proxy>
}