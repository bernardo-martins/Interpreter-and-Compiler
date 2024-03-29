/* Generated By:JavaCC: Do not edit this line. Parser0.java */
package ICLCompiler;
import java.util.List;
import java.util.LinkedList;
import java.io.PrintStream;
import java.io.File;

  public class Parser0 implements Parser0Constants {

  static final public ASTNode Start() throws ParseException {
ASTNode t1, t2=new ASTEmpty();
    t1 = ES();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOUBSEMICOLON:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(DOUBSEMICOLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Num:
      case DEF:
      case TRUE:
      case FALSE:
      case IF:
      case WHILE:
      case DEREF:
      case NEW:
      case PRINT:
      case PRINTLN:
      case NOT:
      case MINUS:
      case LPAR:
      case ID:
        t2 = ES();
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
         {if (true) return new ASTSeq(t1, t2);}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode ES() throws ParseException {
  ASTNode t1, t2 = null;
    t1 = EB();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(SEMICOLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Num:
      case DEF:
      case TRUE:
      case FALSE:
      case IF:
      case WHILE:
      case DEREF:
      case NEW:
      case PRINT:
      case PRINTLN:
      case NOT:
      case MINUS:
      case LPAR:
      case ID:
        t2 = ES();
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
    }
   {if (true) return new ASTSeq(t1,t2);}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode EB() throws ParseException {
  ASTNode t1, t2 = null;
  Token tok = null;
    t1 = EE();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        tok = jj_consume_token(OR);
        break;
      case AND:
        tok = jj_consume_token(AND);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = EE();
      if(tok.kind == OR)
        t1 = new ASTOrAnd(t1,t2, "OR");
      else
        t1 = new ASTOrAnd(t1,t2, "AND");
    }
   {if (true) return t1;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode EE() throws ParseException {
  ASTNode t1, t2 = null;
  Token tok = null;
    t1 = Exp();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
      case EQUALS:
      case HIGHEREQ:
      case HIGHER:
      case SMALLEREQ:
      case SMALLER:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        tok = jj_consume_token(EQUALS);
        break;
      case HIGHEREQ:
        tok = jj_consume_token(HIGHEREQ);
        break;
      case HIGHER:
        tok = jj_consume_token(HIGHER);
        break;
      case SMALLER:
        tok = jj_consume_token(SMALLER);
        break;
      case SMALLEREQ:
        tok = jj_consume_token(SMALLEREQ);
        break;
      case ASSIGN:
        tok = jj_consume_token(ASSIGN);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Exp();
      if(tok.kind == EQUALS)
        t1 = new ASTBoolOp(t1,t2,"EQUALS");
      else if(tok.kind == HIGHEREQ)
        t1 = new ASTBoolOp(t1, t2,"HIGHEREQUALS");
      else if(tok.kind == HIGHER)
        t1 = new ASTBoolOp(t1,t2,"HIGHER");
      else if(tok.kind == SMALLER)
        t1 = new ASTBoolOp(t1,t2, "SMALLER");
      else if(tok.kind == SMALLEREQ)
        t1 = new ASTBoolOp(t1,t2,"SMALLEREQUALS");
      else if(tok.kind == ASSIGN)
        t1 = new ASTAssign(t1,t2);
    }
   {if (true) return t1;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode Exp() throws ParseException {
  ASTNode t1,t2 = null;
  Token tok = null;
    t1 = Term();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        tok = jj_consume_token(PLUS);
        break;
      case MINUS:
        tok = jj_consume_token(MINUS);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Term();
                   if (tok.kind == PLUS)
                      t1 = new ASTAdd(t1,t2);
                   else if (tok.kind == MINUS)
                      t1 = new ASTSub(t1,t2);
    }
       {if (true) return t1;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode Term() throws ParseException {
  ASTNode t1,t2 = null;
  Token tok;
    t1 = Fact();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case MOD:
      case DIV:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
        tok = jj_consume_token(MUL);
        break;
      case DIV:
        tok = jj_consume_token(DIV);
        break;
      case MOD:
        tok = jj_consume_token(MOD);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Fact();
      if(tok.kind == MUL)
        t1 = new ASTMul(t1,t2);
      else if(tok.kind == DIV)
        t1 = new ASTDiv(t1,t2, "DIV");
      else if(tok.kind == MOD)
        t1 = new ASTDiv(t1,t2, "MOD");
    }
       {if (true) return t1;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode Fact() throws ParseException {
  ASTNode t1 = null;
  ASTNode exp, exp1 =null;
  List<Binding> binds = null;
  Token tok, n = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Num:
      tok = jj_consume_token(Num);
                      t1 = new ASTNum(Integer.parseInt(tok.image));
      break;
    case ID:
      tok = jj_consume_token(ID);
                      t1 = new ASTId(tok.image);
      break;
    case TRUE:
    case FALSE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TRUE:
        tok = jj_consume_token(TRUE);
        break;
      case FALSE:
        tok = jj_consume_token(FALSE);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                    t1 = new ASTBool(Boolean.parseBoolean(tok.image));
      break;
    case MINUS:
      jj_consume_token(MINUS);
      t1 = Fact();
                             t1 = new ASTMinun(t1);
      break;
    case NEW:
      jj_consume_token(NEW);
      t1 = Fact();
                           t1 = new ASTNew(t1);
      break;
    case DEREF:
      jj_consume_token(DEREF);
      t1 = Fact();
                             t1 = new ASTDeref(t1);
      break;
    case LPAR:
      jj_consume_token(LPAR);
      t1 = EB();
      jj_consume_token(RPAR);
      break;
    case DEF:
      jj_consume_token(DEF);
                binds = new LinkedList<Binding>();
      label_7:
      while (true) {
        n = jj_consume_token(ID);
        jj_consume_token(EQUAL);
        t1 = Exp();
                                                     binds.add(new Binding(n.image, t1));
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_7;
        }
      }
      jj_consume_token(IN);
      exp = ES();
      jj_consume_token(END);
                                               t1 = new ASTDef(binds, exp);
      break;
    case IF:
      jj_consume_token(IF);
      t1 = EE();
      jj_consume_token(THEN);
      exp = Exp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        jj_consume_token(ELSE);
        exp1 = Exp();
        break;
      default:
        jj_la1[15] = jj_gen;
        ;
      }
                                                                  t1 = new ASTIf(t1, exp, exp1);
      break;
    case PRINT:
      jj_consume_token(PRINT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Num:
      case DEF:
      case TRUE:
      case FALSE:
      case IF:
      case WHILE:
      case DEREF:
      case NEW:
      case PRINT:
      case PRINTLN:
      case NOT:
      case MINUS:
      case LPAR:
      case ID:
        t1 = Exp();
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
                               t1 = new ASTPrint(t1, false);
      break;
    case PRINTLN:
      jj_consume_token(PRINTLN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Num:
      case DEF:
      case TRUE:
      case FALSE:
      case IF:
      case WHILE:
      case DEREF:
      case NEW:
      case PRINT:
      case PRINTLN:
      case NOT:
      case MINUS:
      case LPAR:
      case ID:
        t1 = Exp();
        break;
      default:
        jj_la1[17] = jj_gen;
        ;
      }
                                 t1 = new ASTPrint(t1, true);
      break;
    case NOT:
      jj_consume_token(NOT);
      exp = Fact();
                             t1 = new ASTNot(exp);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      exp = EB();
      jj_consume_token(DO);
      exp1 = ES();
      jj_consume_token(END);
                                                   t1 = new ASTWhile(exp, exp1);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return t1;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public Parser0TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x201e4e60,0x1,0x0,0x201e4e60,0x6000000,0x6000000,0x11e10000,0x11e10000,0x80000000,0x80000000,0x0,0x0,0x600,0x0,0x2000,0x201e4e60,0x201e4e60,0x201e4e60,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x4,0x141,0x0,0x2,0x141,0x0,0x0,0x0,0x0,0x1,0x1,0x38,0x38,0x0,0x100,0x0,0x141,0x141,0x141,};
   }

  /** Constructor with InputStream. */
  public Parser0(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser0(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new Parser0TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser0(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new Parser0TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser0(Parser0TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Parser0TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[41];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 41; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  /** ID lister. */

  }
