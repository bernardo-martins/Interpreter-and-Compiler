.class public source
.super java/lang/Object
;
; standard initializer
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
       ; set limits used by this method
       .limit locals 10
       .limit stack 256

       ;    1 - the PrintStream object held in java.lang.System.out
       getstatic java/lang/System/out Ljava/io/PrintStream;

       ; place your bytecodes here between START and END
       ; START


      new frame_0
      dup
      invokespecial frame_0/<init>()V
      dup
      astore_3
      dup
      sipush 1
      putfield frame_0/x I
      pop
      putfield frame_0/x I
      sipush 13
      iadd



       ; END



       ; convert to String;
       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
       ; call println
       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
       return
.end method
