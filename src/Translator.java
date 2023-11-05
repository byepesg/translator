import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */

public class Translator extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int identationLevel = 0;

    private int parametros = 0;
    private boolean isLoop = false;

    private boolean isList = false;
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
    @Override public void enterPrograma(LPP_grammarParser.ProgramaContext ctx) {

        System.out.println("###This is the python translation");

    }

    @Override public void enterVariable(LPP_grammarParser.VariableContext ctx) {
        this.applyIdentation();
        if (ctx.listaIDs() != null) {
            //int countIDs = false;
            String varTmp = null;
            int countIDs = ctx.getChild(1).getChildCount();

            for(int i = 0; i < countIDs; ++i) {
                if (i % 2 == 0) {
                    String var10000 =
                            ctx.getChild(1).getChild(i).getText().toLowerCase();
                    varTmp = var10000 + " = 0\n";
                    this.codeBuilder.append(varTmp);
                }
            }

            this.code = varTmp;
        }

    }


    @Override public void enterAccion(LPP_grammarParser.AccionContext ctx) {
        this.applyIdentation();
    }

    @Override public void exitAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void enterAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        if (!this.isLoop && !this.isLoop) {
            StringBuilder var10000 = this.codeBuilder;
            String var10001 = ctx.getChild(0).getText().toLowerCase();
            var10000.append(var10001 + " = ");
        }
    }

    @Override public void exitAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.codeBuilder.append("\n");
    }

    @Override public void enterExpresion(LPP_grammarParser.ExpresionContext ctx) {
        if(this.isList) {
            if (ctx.getChild(0).getText().equals("(")) {
                this.codeBuilder.append("( " + ctx.getChild(1).getText() + " ), ");
            } else if (ctx.getChildCount() == 3) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + ctx.getChild(1).getText() + ctx.getChild(2).getText().toLowerCase()+", ");
            }
            if(ctx.ID() != null){
                //this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase()+", ");
            }
        }
        else {
            if (ctx.getChild(0).getText().equals("(")) {
                this.codeBuilder.append("( " + ctx.getChild(1).getText() + " )");
            } else if (ctx.getChildCount() == 3) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + ctx.getChild(1).getText() + ctx.getChild(2).getText().toLowerCase());
            }
            if(ctx.ID() != null){
                //this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            }
            /*else if (ctx.getChildCount() == 1){
                String txt = ctx.getChild(0).getText();
                String regex = "\"(.*?)\"|'(.)'";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(txt);
                if (!matcher.find()){
                    //this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
             }*/
        }
    }

    @Override public void enterListaExpr(LPP_grammarParser.ListaExprContext ctx) {
        this.isList = true;
    }
    @Override public void exitListaExpr(LPP_grammarParser.ListaExprContext ctx) {
        this.isList = false;
    }

    @Override public void enterValores(LPP_grammarParser.ValoresContext ctx) {
        this.codeBuilder.append(ctx.getChild(0).getText());
    }

    @Override public void exitValores(LPP_grammarParser.ValoresContext ctx) {
    }

    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) { }

    @Override public void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx) {

    }
    @Override public void enterCiclos(LPP_grammarParser.CiclosContext ctx) {
        this.isLoop = true;
        this.setIdentationLevelUp();
        this.applyIdentation();
        if (ctx.getChild(0).getText().equals("para")) {
            StringBuilder var10000 = this.codeBuilder;
            String var10001 = ctx.getChild(1).getChild(0).getText().toLowerCase();
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
        this.codeBuilder.append("print(");
    }

    @Override public void exitEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.codeBuilder.append(")\n");
    }


    @Override public void enterFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.identationLevel += 1;
        if(ctx.getChild(2).getText().equals("(")) {
            codeBuilder.append("def " + ctx.getChild(1).toString().toLowerCase());
        }
        else {
            codeBuilder.append("def " + ctx.getChild(1).toString().toLowerCase()+" (): ");
        }
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
        if(ctx.getParent().getStart().getText().equalsIgnoreCase("funcion")){
            codeBuilder.append("):\n");
        }
        else {
            codeBuilder.append(")");
        }
    }

    @Override public void enterParametro(LPP_grammarParser.ParametroContext ctx) {

        if (this.parametros == 1) {
            codeBuilder.append(ctx.getChild(1).toString().toLowerCase());
        }
        else {
            codeBuilder.append(ctx.getChild(1).toString().toLowerCase() + ctx.getParent().getChild(1) + " ");
            this.parametros -= 2;
        }
    }

    @Override public void enterTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) {

    }
    @Override public void enterLlamar(LPP_grammarParser.LlamarContext ctx) {

        if(ctx.getChild(1).getText().equalsIgnoreCase("nueva_linea")){
            codeBuilder.append("print(\""+"\\n\")"+"\n");
        }

    }

    @Override public void exitLlamar(LPP_grammarParser.LlamarContext ctx) { }
    @Override public void exitTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) { }
    public int getIdentationLevel() {
        return this.identationLevel;
    }
    @Override public void enterCondicional(LPP_grammarParser.CondicionalContext ctx) {
        setIdentationLevelUp();
        applyIdentation();
        System.out.println("if "+ctx.getChild(1).getText()+":");



    }

    @Override public void exitCondicional(LPP_grammarParser.CondicionalContext ctx) {
        setIdentationLevelDown();
    }
    public void setIdentationLevelUp() {
        ++this.identationLevel;
    }
    public void setIdentationLevelDown() {
        --this.identationLevel;
    }

    public void applyIdentation() {
        if (this.getIdentationLevel() > 0) {
            for(int i = 0; i < this.getIdentationLevel(); ++i) {
                this.codeBuilder.append("\t");
            }
        }

    }
    public String getCode() {
        //System.out.println(codeBuilder.toString());
        return codeBuilder.toString();
    }

}

