import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */

public class Translator extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int indentationLevel = 0;

    private int parametros = 0;
    private boolean isLoop = false;
    private boolean isParametro = false;
    private boolean isFunction = false;
    private boolean isAsign = false;
    private boolean isVariable = false;

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
        this.applyIndentation();
        this.isVariable = true;
        if (ctx.getChildCount() != 1){
            this.isList = true;
        }
    }
    @Override public void exitVariable(LPP_grammarParser.VariableContext ctx) {
        this.isVariable = false;
        this.isList = false;
    }

    @Override public void enterAccion(LPP_grammarParser.AccionContext ctx) {
        this.applyIndentation();
    }

    @Override public void exitAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void enterAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.isAsign = true;
    }

    @Override public void exitAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.codeBuilder.append("\n");
        this.isAsign = false;
    }

    @Override public void enterExpresion(LPP_grammarParser.ExpresionContext ctx) {
        if(ctx.getChildCount() == 1){

        }
        else if(ctx.getChildCount() == 3){
            this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase()+ctx.getChild(1).toString()+ctx.getChild(2).getText().toLowerCase()+"\n");
        }
    }

    @Override public void enterListaExpr(LPP_grammarParser.ListaExprContext ctx) {
        this.isList = true;
    }
    @Override public void exitListaExpr(LPP_grammarParser.ListaExprContext ctx) {
        this.isList = false;
    }

    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) {
        if (this.isList){
            this.codeBuilder.append(", ");
        }
    }

    @Override public void enterString(LPP_grammarParser.StringContext ctx) {
        this.codeBuilder.append(ctx.getChild(0).getText());
    }

    @Override public void enterInteger(LPP_grammarParser.IntegerContext ctx) {
        if (ctx.getParent().getParent().getParent().getChild(0).getText().equals("-")) {
            this.codeBuilder.append(ctx.getParent().getParent().getParent().getChild(0).getText()+ctx.getChild(0).getText().toLowerCase());
        }
        else{
            this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
        }
    }

    @Override public void enterDouble(LPP_grammarParser.DoubleContext ctx) {
        if (ctx.getParent().getParent().getParent().getChild(0).getText().equals("-")) {
            this.codeBuilder.append(ctx.getParent().getParent().getParent().getChild(0).getText()+ctx.getChild(0).getText().toLowerCase());
        }
        else{
            this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
        }
    }

    @Override public void enterChar(LPP_grammarParser.CharContext ctx) {
        this.codeBuilder.append(ctx.getChild(0).getText());
    }
    @Override public void enterId(LPP_grammarParser.IdContext ctx) {
        if (this.parametros == 1) {
            if(this.isAsign) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + " = ");
            }
            else if (this.isVariable) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + " = 0\n");
            }
            else if (this.isParametro){
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            }
            else if (this.isFunction){
                this.isFunction = false;
            }
            else{
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            }
        }
        else {
            if(this.isAsign) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + " = ");
            }
            else if (this.isVariable) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + " = 0\n");
            }
            else if(this.isParametro) {
                codeBuilder.append(ctx.getChild(0).getText().toLowerCase() + ", ");
                this.parametros -= 2;
            }
            else{
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            }
        }
    }

    @Override public void exitId(LPP_grammarParser.IdContext ctx) {
        if (this.isAsign){
            this.isAsign = false;
        }
    }


    @Override public void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx) {
        this.parametros = ctx.getChildCount();
    }
    @Override public void enterCiclos(LPP_grammarParser.CiclosContext ctx) {
        this.isLoop = true;

        if (getIndentationLevel() ==0){
            this.applyIndentation();
            this.setIndentationLevelUp();
        }
        else{

            this.applyIndentation();
            this.setIndentationLevelUp();
        }

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

        this.indentationLevel -= 1;
        isLoop = false;

    }

    @Override public void enterEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.applyIndentation();
        this.codeBuilder.append("print(");
    }

    @Override public void exitEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.codeBuilder.append(")\n");
    }


    @Override public void enterFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.indentationLevel += 1;
        this.isFunction = true;
        if (ctx.getChild(2).toString().equals("(")) {
            this.codeBuilder.append("def " + ctx.getChild(1).getText().toLowerCase());
        }
        else {
            this.codeBuilder.append("def " + ctx.getChild(1).getText().toLowerCase()+"():\n");
        }
    }

    @Override public void exitFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.indentationLevel -= 1;
        this.isFunction = false;
        codeBuilder.append("\n");
    }

    @Override public void enterRetorne(LPP_grammarParser.RetorneContext ctx) {
        this.applyIndentation();
        this.codeBuilder.append("return ");
    }

    @Override public void exitRetorne(LPP_grammarParser.RetorneContext ctx) {
        this.codeBuilder.append("\n");
    }

    @Override public void enterParametros(LPP_grammarParser.ParametrosContext ctx) {
        this.parametros = ctx.getChildCount();
        this.codeBuilder.append(" (");
        this.isParametro = true;
    }

    @Override public void exitParametros(LPP_grammarParser.ParametrosContext ctx) {
        if(ctx.getParent().getStart().getText().equalsIgnoreCase("funcion")){
            codeBuilder.append("):\n");
        }
        else {
            codeBuilder.append(")");
        }
        this.parametros = 0;
        this.isParametro = false;
        this.isFunction = false;
    }

    @Override public void enterParametro(LPP_grammarParser.ParametroContext ctx) {

        /*if (this.parametros == 1) {
            codeBuilder.append(ctx.getChild(1).toString().toLowerCase());
        }
        else {
            codeBuilder.append(ctx.getChild(1).toString().toLowerCase() + ctx.getParent().getChild(1) + " ");
            this.parametros -= 2;
        }*/
    }

    @Override public void enterTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) {

    }
    @Override public void enterLlamar(LPP_grammarParser.LlamarContext ctx) {

        if(ctx.getChild(1).getText().equalsIgnoreCase("nueva_linea")){
            this.codeBuilder.append("print(\""+"\\n\")"+"\n");
        }

    }

    @Override public void exitLlamar(LPP_grammarParser.LlamarContext ctx) { }
    @Override public void exitTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) { }
    public int getIndentationLevel() {
        return this.indentationLevel;
    }
    @Override public void enterCondicional(LPP_grammarParser.CondicionalContext ctx) {
        setIndentationLevelUp();
        applyIndentation();
        String logicOperator = "";


        int length = ctx.getChild(1).getChildCount();
        for(int i= 0; i<length;i++){
            if(i%2!=0){
                if(ctx.getChild(1).getChild(i).getText().equals("o")){
                    logicOperator = "or" ;
                }
                else if(ctx.getChild(i).equals("y")){
                    logicOperator = "and" ;
                }
            }
        }

        if(ctx.getChild(3).getText().contains("sino") || ctx.getChild(3).getText().equals("null")){

        }
        else{
            codeBuilder.append("if ");
            codeBuilder.append(ctx.getChild(1).getChild(0).getText());
            codeBuilder.append(logicOperator+ctx.getChild(1).getChild(2).getText());
            codeBuilder.append(":\n");
            setIndentationLevelUp();
            applyIndentation();
            codeBuilder.append(ctx.getChild(3).getText());
            setIndentationLevelDown();
            codeBuilder.append(":\n");
            //System.out.println("if "+ctx.getChild(1).getChild(0).getText()+logicOperator+ctx.getChild(1).getChild(2).getText()+":");
        }


    }

    @Override public void exitCondicional(LPP_grammarParser.CondicionalContext ctx) {
        setIndentationLevelDown();
    }
    @Override public void enterSino(LPP_grammarParser.SinoContext ctx) {
        applyIndentation();
        this.setIndentationLevelUp();
        if(ctx.getChildCount()==2){
            codeBuilder.append("else:\n");
            this.applyIndentation();
            codeBuilder.append(ctx.getChild(1).getText()+"\n");
        }
    }

    @Override public void exitSino(LPP_grammarParser.SinoContext ctx) {
        this.setIndentationLevelDown();
    }
    public void setIndentationLevelUp() {
        ++this.indentationLevel;
    }
    public void setIndentationLevelDown() {
        --this.indentationLevel;
    }

    public void applyIndentation() {
        if (this.getIndentationLevel() > 0) {
            for(int i = 0; i < this.getIndentationLevel(); ++i) {
                this.codeBuilder.append("\t");
            }
        }

    }
    public String getCode() {
        //System.out.println(codeBuilder.toString());
        return codeBuilder.toString();
    }

}