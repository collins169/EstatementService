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
    public partial class StvwTransaction_ {
        
        public static global::java.lang.Class _class {
            get {
                return global::FasylStatementLibrary.Models.@__StvwTransaction.staticClass;
            }
        }
    }
    #endregion
    
    #region Component Designer generated code 
    [global::net.sf.jni4net.attributes.JavaProxyAttribute(typeof(global::FasylStatementLibrary.Models.StvwTransaction), typeof(global::FasylStatementLibrary.Models.StvwTransaction_))]
    [global::net.sf.jni4net.attributes.ClrWrapperAttribute(typeof(global::FasylStatementLibrary.Models.StvwTransaction), typeof(global::FasylStatementLibrary.Models.StvwTransaction_))]
    internal sealed partial class @__StvwTransaction : global::java.lang.Object {
        
        internal new static global::java.lang.Class staticClass;
        
        private @__StvwTransaction(global::net.sf.jni4net.jni.JNIEnv @__env) : 
                base(@__env) {
        }
        
        private static void InitJNI(global::net.sf.jni4net.jni.JNIEnv @__env, java.lang.Class @__class) {
            global::FasylStatementLibrary.Models.@__StvwTransaction.staticClass = @__class;
        }
        
        private static global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> @__Init(global::net.sf.jni4net.jni.JNIEnv @__env, global::java.lang.Class @__class) {
            global::System.Type @__type = typeof(__StvwTransaction);
            global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> methods = new global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod>();
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTrnRefNo", "TrnRefNo0", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTrnRefNo", "TrnRefNo1", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAcEntrySrNo", "AcEntrySrNo2", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAcEntrySrNo", "AcEntrySrNo3", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAcNo", "AcNo4", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAcNo", "AcNo5", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAcCcy", "AcCcy6", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAcCcy", "AcCcy7", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getDrCrInd", "DrCrInd8", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setDrCrInd", "DrCrInd9", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getNarration", "Narration10", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setNarration", "Narration11", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getFcyAmount", "FcyAmount12", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setFcyAmount", "FcyAmount13", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getLcyAmount", "LcyAmount14", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setLcyAmount", "LcyAmount15", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getTrnDt", "TrnDt16", "()Lsystem/DateTime;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setTrnDt", "TrnDt17", "(Lsystem/DateTime;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getValueDt", "ValueDt18", "()Lsystem/DateTime;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setValueDt", "ValueDt19", "(Lsystem/DateTime;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getInstrumentCode", "InstrumentCode20", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setInstrumentCode", "InstrumentCode21", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAcDesc", "AcDesc22", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAcDesc", "AcDesc23", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getDescription", "Description24", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setDescription", "Description25", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAcyOpeningBal", "AcyOpeningBal26", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAcyOpeningBal", "AcyOpeningBal27", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getDebit", "Debit28", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setDebit", "Debit29", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getCredit", "Credit30", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setCredit", "Credit31", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getRunningBal", "RunningBal32", "()Ljava/lang/String;"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setRunningBal", "RunningBal33", "(Ljava/lang/String;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "getAmount", "Amount34", "()D"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "setAmount", "Amount35", "(D)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "__ctorStvwTransaction0", "__ctorStvwTransaction0", "(Lnet/sf/jni4net/inj/IClrProxy;)V"));
            return methods;
        }
        
        private static global::net.sf.jni4net.utils.JniHandle TrnRefNo0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.TrnRefNo);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TrnRefNo1(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.TrnRefNo = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle AcEntrySrNo2(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.AcEntrySrNo);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void AcEntrySrNo3(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.AcEntrySrNo = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle AcNo4(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.AcNo);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void AcNo5(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.AcNo = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle AcCcy6(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.AcCcy);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void AcCcy7(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.AcCcy = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle DrCrInd8(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.DrCrInd);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void DrCrInd9(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.DrCrInd = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle Narration10(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.Narration);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void Narration11(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.Narration = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double FcyAmount12(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.FcyAmount));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void FcyAmount13(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.FcyAmount = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double LcyAmount14(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.LcyAmount));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void LcyAmount15(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.LcyAmount = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle TrnDt16(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Lsystem/DateTime;
            // ()LSystem/DateTime;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2Jp<global::System.DateTime>(@__env, @__real.TrnDt);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void TrnDt17(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Lsystem/DateTime;)V
            // (LSystem/DateTime;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.TrnDt = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::System.DateTime>(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle ValueDt18(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Lsystem/DateTime;
            // ()LSystem/DateTime;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2Jp<global::System.DateTime>(@__env, @__real.ValueDt);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void ValueDt19(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Lsystem/DateTime;)V
            // (LSystem/DateTime;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.ValueDt = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::System.DateTime>(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle InstrumentCode20(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.InstrumentCode);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void InstrumentCode21(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.InstrumentCode = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle AcDesc22(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.AcDesc);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void AcDesc23(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.AcDesc = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle Description24(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.Description);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void Description25(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.Description = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double AcyOpeningBal26(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.AcyOpeningBal));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void AcyOpeningBal27(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.AcyOpeningBal = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double Debit28(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.Debit));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void Debit29(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.Debit = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double Credit30(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.Credit));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void Credit31(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.Credit = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static global::net.sf.jni4net.utils.JniHandle RunningBal32(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Ljava/lang/String;
            // ()LSystem/String;
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            global::net.sf.jni4net.utils.JniHandle @__return = default(global::net.sf.jni4net.utils.JniHandle);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = global::net.sf.jni4net.utils.Convertor.StrongC2JString(@__env, @__real.RunningBal);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void RunningBal33(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle value) {
            // (Ljava/lang/String;)V
            // (LSystem/String;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.RunningBal = global::net.sf.jni4net.utils.Convertor.StrongJ2CString(@__env, value);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static double Amount34(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()D
            // ()D
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            double @__return = default(double);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__return = ((double)(@__real.Amount));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void Amount35(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, double value) {
            // (D)V
            // (D)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::FasylStatementLibrary.Models.StvwTransaction>(@__env, @__obj);
            @__real.Amount = value;
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void @__ctorStvwTransaction0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__class, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::FasylStatementLibrary.Models.StvwTransaction @__real = new global::FasylStatementLibrary.Models.StvwTransaction();
            global::net.sf.jni4net.utils.Convertor.InitProxy(@__env, @__obj, @__real);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        new internal sealed class ContructionHelper : global::net.sf.jni4net.utils.IConstructionHelper {
            
            public global::net.sf.jni4net.jni.IJvmProxy CreateProxy(global::net.sf.jni4net.jni.JNIEnv @__env) {
                return new global::FasylStatementLibrary.Models.@__StvwTransaction(@__env);
            }
        }
    }
    #endregion
}
