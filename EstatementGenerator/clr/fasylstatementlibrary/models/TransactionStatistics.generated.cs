//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace FasylStatementLibrary.Models {
    
    
    #region Component Designer generated code 
    public partial class TransactionStatistics_ {
        
        public static global::java.lang.Class _class {
            get {
                return global::FasylStatementLibrary.Models.@__TransactionStatistics.staticClass;
            }
        }
    }
    #endregion
    
    #region Component Designer generated code 
    [global::net.sf.jni4net.attributes.JavaProxyAttribute(typeof(global::FasylStatementLibrary.Models.TransactionStatistics), typeof(global::FasylStatementLibrary.Models.TransactionStatistics_))]
    [global::net.sf.jni4net.attributes.ClrWrapperAttribute(typeof(global::FasylStatementLibrary.Models.TransactionStatistics), typeof(global::FasylStatementLibrary.Models.TransactionStatistics_))]
    internal sealed partial class @__TransactionStatistics : global::java.lang.Object {
        
        internal new static global::java.lang.Class staticClass;
        
        private @__TransactionStatistics(global::net.sf.jni4net.jni.JNIEnv @__env) : 
                base(@__env) {
        }
        
        private static void InitJNI(global::net.sf.jni4net.jni.JNIEnv @__env, java.lang.Class @__class) {
            global::FasylStatementLibrary.Models.@__TransactionStatistics.staticClass = @__class;
        }
        
        private static global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> @__Init(global::net.sf.jni4net.jni.JNIEnv @__env, global::java.lang.Class @__class) {
            global::System.Type @__type = typeof(__TransactionStatistics);
            global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> methods = new global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod>();
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalNumOfTransaction", "TotalNumOfTransaction0", "()I"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalNumOfTransaction", "TotalNumOfTransaction1", "(I)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalCredits", "TotalCredits2", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalCredits", "TotalCredits3", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalDebits", "TotalDebits4", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalDebits", "TotalDebits5", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalAtmTransaction", "TotalAtmTransaction6", "()I"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalAtmTransaction", "TotalAtmTransaction7", "(I)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalAtmCredits", "TotalAtmCredits8", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalAtmCredits", "TotalAtmCredits9", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalAtmDebits", "TotalAtmDebits10", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalAtmDebits", "TotalAtmDebits11", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalAtmPercent", "TotalAtmPercent12", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalAtmPercent", "TotalAtmPercent13", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalPosTransaction", "TotalPosTransaction14", "()I"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalPosTransaction", "TotalPosTransaction15", "(I)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalPosCredits", "TotalPosCredits16", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalPosCredits", "TotalPosCredits17", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalPosDebits", "TotalPosDebits18", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalPosDebits", "TotalPosDebits19", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTotalPosPercent", "TotalPosPercent20", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTotalPosPercent", "TotalPosPercent21", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getOthersTotalTransaction", "OthersTotalTransaction22", "()I"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setOthersTotalTransaction", "OthersTotalTransaction23", "(I)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getOthersTotalCredits", "OthersTotalCredits24", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setOthersTotalCredits", "OthersTotalCredits25", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getOthersTotalDebits", "OthersTotalDebits26", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setOthersTotalDebits", "OthersTotalDebits27", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getOthersTotalPercent", "OthersTotalPercent28", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setOthersTotalPercent", "OthersTotalPercent29", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "__ctorTransactionStatistics0", "__ctorTransactionStatistics0", "(Lnet/sf/jni4net/inj/IClrProxy;)V"));
            return methods;
        }
        
        private static int TotalNumOfTransaction0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()I
            // ()I
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            int @__return = default(int);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((int)(@__real.TotalNumOfTransaction));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalNumOfTransaction1(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, int value) {
            // (I)V
            // (I)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalNumOfTransaction = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalCredits2(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalCredits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalCredits3(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalCredits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalDebits4(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalDebits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalDebits5(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalDebits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static int TotalAtmTransaction6(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()I
            // ()I
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            int @__return = default(int);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((int)(@__real.TotalAtmTransaction));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalAtmTransaction7(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, int value) {
            // (I)V
            // (I)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalAtmTransaction = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalAtmCredits8(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalAtmCredits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalAtmCredits9(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalAtmCredits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalAtmDebits10(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalAtmDebits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalAtmDebits11(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalAtmDebits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalAtmPercent12(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalAtmPercent));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalAtmPercent13(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalAtmPercent = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static int TotalPosTransaction14(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()I
            // ()I
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            int @__return = default(int);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((int)(@__real.TotalPosTransaction));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalPosTransaction15(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, int value) {
            // (I)V
            // (I)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalPosTransaction = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalPosCredits16(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalPosCredits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalPosCredits17(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalPosCredits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalPosDebits18(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalPosDebits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalPosDebits19(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalPosDebits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double TotalPosPercent20(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.TotalPosPercent));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TotalPosPercent21(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.TotalPosPercent = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static int OthersTotalTransaction22(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()I
            // ()I
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            int @__return = default(int);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((int)(@__real.OthersTotalTransaction));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void OthersTotalTransaction23(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, int value) {
            // (I)V
            // (I)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.OthersTotalTransaction = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double OthersTotalCredits24(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.OthersTotalCredits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void OthersTotalCredits25(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.OthersTotalCredits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double OthersTotalDebits26(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.OthersTotalDebits));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void OthersTotalDebits27(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.OthersTotalDebits = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double OthersTotalPercent28(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__return = ((double)(@__real.OthersTotalPercent));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void OthersTotalPercent29(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.TransactionStatistics>(@__env, @__obj);
            @__real.OthersTotalPercent = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void @__ctorTransactionStatistics0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__class, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.TransactionStatistics @__real = new global::FasylStatementLibrary.Models.TransactionStatistics();
            global::net.sf.jni4net.utils.Convertor.InitProxy(@__env, @__obj, @__real);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        new internal sealed class ContructionHelper : global::net.sf.jni4net.utils.IConstructionHelper {
            
            public global::net.sf.jni4net.jni.IJvmProxy CreateProxy(global::net.sf.jni4net.jni.JNIEnv @__env) {
                return new global::FasylStatementLibrary.Models.@__TransactionStatistics(@__env);
            }
        }
    }
    #endregion
}
