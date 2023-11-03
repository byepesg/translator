import java.util.*;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */

public class Translator extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int identationLevel = 0;

    private int parametros = 0;
    private boolean isLoop = false;

    private boolean isFunction = false;
    //params for special cases
    //check if we are in a condition
    private final boolean control_structure_conditonal = false;

    //check if we are in a builtin
    private String builtinName = "";
    private String builtinFunction = "";
    private List<String> builtinArguments = new ArrayList<String>();

    //check if an import type, a definition signature exists
    private Set<String> addons = new HashSet<>();
    private int counterCharactersImport = 0 ;
    private int counterCharactersFunction = 0;

    //tags : list of tuples, with
    //A : name of the tag
    //B : isActive : bool
    //C : start : (nameStart || gotoStart)
    private Map<String, Object []> tags = new HashMap<>();
    private String activeTag ="";
    private String code ="";
    public Translator() {
    }
    @Override public void enterPrograma(LPP_grammarParser.ProgramaContext ctx) {

        System.out.println("###This is the python translation");

    }

    @Override public void enterVariable(LPP_grammarParser.VariableContext ctx) {
        if (ctx.listaIDs() != null) {
            //int countIDs = false;
            String varTmp = null;
            int countIDs = ctx.getChild(1).getChildCount();

            for(int i = 0; i < countIDs; ++i) {
                if (i % 2 == 0) {
                    String var10000 =
                            ctx.getChild(1).getChild(i).getText();
                    varTmp = var10000 + " = 0\t\n";
                    this.codeBuilder.append(varTmp);
                }
            }

            this.code = varTmp;
        }

        }


    @Override public void enterAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void exitAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void enterAsignacion(LPP_grammarParser.AsignacionContext ctx) {

        if (!this.isLoop && !this.isLoop) {
            StringBuilder var10000 = this.codeBuilder;
            String var10001 = ctx.getChild(0).getText();
            var10000.append(var10001 + "=" + ctx.getChild(2).getText() +
                    "\n");
        }
    }
    @Override public void enterExpresion(LPP_grammarParser.ExpresionContext ctx) {





    }

    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) { }

    @Override public void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx) {

    }
    @Override public void enterCiclos(LPP_grammarParser.CiclosContext ctx) {
        this.isLoop = true;
        this.setIdentationLevel();
        this.applyIdentation();
        if (ctx.getChild(0).getText().equals("para")) {
            StringBuilder var10000 = this.codeBuilder;
            String var10001 = ctx.getChild(1).getChild(0).getText();
            var10000.append("for " + var10001 + " in range(" +
                    ctx.getChild(1).getChild(2).getText() + "," + ctx.getChild(3).getText() +
                    "):\n");
        } else if (ctx.getChild(0).getText().equals("mientras")) {
            this.codeBuilder.append("mientras");
        } else if (ctx.getChild(0).getText().equals("repita")) {
            this.codeBuilder.append("repita");
        }

    }

    @Override public void exitCiclos(LPP_grammarParser.CiclosContext ctx) {

        this.identationLevel -= 1;
        isLoop = false;

    }

    @Override public void enterEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.applyIdentation();
        this.codeBuilder.append("print(" + ctx.getChild(1).getText() +
                ")\n");
    }

    @Override public void exitEscribir(LPP_grammarParser.EscribirContext ctx) {
    }


    @Override public void enterFuncion(LPP_grammarParser.FuncionContext ctx) {

        this.identationLevel += 1;
        codeBuilder.append("def " + ctx.getChild(1).toString());

    }

    @Override public void exitFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.identationLevel -= 1;
        codeBuilder.append("\n");
    }

    @Override public void enterParametros(LPP_grammarParser.ParametrosContext ctx) {
        this.parametros = ctx.getChildCount();
        codeBuilder.append(" (");
    }

    @Override public void exitParametros(LPP_grammarParser.ParametrosContext ctx) {
        codeBuilder.append("):\n");
    }

    @Override public void enterParametro(LPP_grammarParser.ParametroContext ctx) {

        if (this.parametros == 1) {
            codeBuilder.append(ctx.getChild(1).toString());
        }
        else {
            codeBuilder.append(ctx.getChild(1).toString() + ctx.getParent().getChild(1));
            this.parametros -= 2;
        }
    }

    @Override public void enterTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) {

    }

    @Override public void exitTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) { }
    public int getIdentationLevel() {
        return this.identationLevel;
    }

    public void setIdentationLevel() {
        ++this.identationLevel;
    }

    public void applyIdentation() {
        if (this.getIdentationLevel() > 0) {
            for(int i = 0; i <= this.getIdentationLevel(); ++i) {
                this.codeBuilder.append("\t");
            }
        }

    }
    public String getCode() {
        //System.out.println(codeBuilder.toString());
        return codeBuilder.toString();
    }

}

