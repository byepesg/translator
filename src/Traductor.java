import java.util.*;
public class Traductor extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int indentationLevel = 0;
    private boolean isAsign = false;
    private boolean isExpresionAsignacion = false;
    private boolean isPrint = false;
    private boolean isRead = false;
    private boolean isCall = false;
    private boolean isCondicion = false;
    private boolean isCasos = false;
    private boolean isCiclos = false;
    private boolean isArray = false;
    private boolean stillArray = false;
    private List<String> Arrays = new ArrayList<>();

    @Override public void enterPrograma(LPP_grammarParser.ProgramaContext ctx) {
        System.out.println("###This is the python translation");
        this.codeBuilder.append("import numpy as np\n\n");
    }
    @Override public void enterVariable(LPP_grammarParser.VariableContext ctx) {
        this.applyIndentation();
        if (ctx.getChild(0).getChildCount() != 1 && ctx.getChild(0).getChild(0).getText().equalsIgnoreCase("arreglo")) {
            this.isArray = true;
            for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
                if (!ctx.getChild(1).getChild(i).getText().equals(",")) {
                    this.Arrays.add(ctx.getChild(1).getChild(i).getText().toLowerCase());
                }
            }
        }
        else{
            for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
                if (!ctx.getChild(1).getChild(i).getText().equals(",")) {
                    this.codeBuilder.append(ctx.getChild(1).getChild(i).getText().toLowerCase());
                    this.codeBuilder.append(" = 0\n");
                }
            }
        }
    }
    @Override public void exitVariable(LPP_grammarParser.VariableContext ctx) {
        this.isArray = false;
    }
    @Override public void enterTipo_dato(LPP_grammarParser.Tipo_datoContext ctx) {
        if(this.isArray){
            if (ctx.getChildCount() > 1) {
                if (ctx.getChild(5).getChild(0).getText().equalsIgnoreCase("arreglo")){
                    this.stillArray = true;
                }
                else{
                    this.stillArray = false;
                }
                try {
                    this.codeBuilder.append(this.Arrays.get(0));
                    this.codeBuilder.append(" = ");
                    this.codeBuilder.append("np.array([");
                    if (!this.stillArray) {
                        this.codeBuilder.append("np.zeros((");
                        for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                            this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                            this.codeBuilder.append(", ");
                        }
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append("))])\n");
                        this.isArray = false;
                    } else {
                        this.codeBuilder.append("np.zeros((");
                        for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                            this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                            this.codeBuilder.append(", ");
                        }
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append(")), ");
                    }
                    this.Arrays.remove(0);
                }
                catch (IndexOutOfBoundsException e){
                    this.codeBuilder.append("np.zeros((");
                    for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                        this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                        this.codeBuilder.append(", ");
                    }
                    if (!this.stillArray) {
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append("))])\n");
                        this.isArray = false;
                    } else {
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append(")), ");
                    }
                }
            }
        }
    }
    @Override public void enterAccion(LPP_grammarParser.AccionContext ctx) {
        this.applyIndentation();
    }
    @Override public void enterAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.isAsign = true;
        if(!this.isCiclos) {
            this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            this.codeBuilder.append(" = ");
            if(ctx.getChild(2).getChildCount() == 1){
                this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                this.codeBuilder.append("\n");
                this.isExpresionAsignacion = false;
            }
            else{
                this.isExpresionAsignacion = true;
            }
        }
        else{
            this.isCiclos = false;
        }
    }
    @Override public void exitAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.isAsign = false;
        this.isExpresionAsignacion = false;
    }
    @Override public void enterEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.isPrint = true;
        this.codeBuilder.append("print(");
    }
    @Override public void exitEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.isPrint = false;
        this.codeBuilder.append(", end=' ')\n");
    }
    @Override public void enterLeer(LPP_grammarParser.LeerContext ctx) {
        this.isRead = true;
    }
    @Override public void exitLeer(LPP_grammarParser.LeerContext ctx) {
        this.isRead = false;
    }
    @Override public void enterLlamar(LPP_grammarParser.LlamarContext ctx) {
        this.isCall = true;
    }
    @Override public void exitLlamar(LPP_grammarParser.LlamarContext ctx) {
        this.isCall = false;
    }
    @Override public void enterCondicional(LPP_grammarParser.CondicionalContext ctx) {
        this.isCondicion = true;
        this.setIndentationLevelUp();
        this.codeBuilder.append("if ");

    }
    @Override public void exitCondicional(LPP_grammarParser.CondicionalContext ctx) {
        this.isCondicion = false;
        this.setIndentationLevelDown();
    }
    @Override public void enterSino(LPP_grammarParser.SinoContext ctx) { }
    @Override public void exitSino(LPP_grammarParser.SinoContext ctx) { }
    @Override public void enterCasos(LPP_grammarParser.CasosContext ctx) {
        this.isCasos = true;
    }
    @Override public void exitCasos(LPP_grammarParser.CasosContext ctx) {
        this.isCasos = false;
    }
    @Override public void enterCiclos(LPP_grammarParser.CiclosContext ctx) {
        this.isCiclos = true;
        this.setIndentationLevelUp();
        if (ctx.getChild(0).getText().equalsIgnoreCase("para")){
            this.codeBuilder.append("for ");
            this.codeBuilder.append(ctx.getChild(1).getChild(0).getText().toLowerCase());
            this.codeBuilder.append(" in range(");
            this.codeBuilder.append(ctx.getChild(1).getChild(2).getText());
            this.codeBuilder.append(", ");
            this.codeBuilder.append(ctx.getChild(3).getText().toLowerCase());
            this.codeBuilder.append("(+1)):\n");
        }
        else if(ctx.getChild(0).getText().equalsIgnoreCase("repita")){

        }
        else if (ctx.getChild(0).getText().equalsIgnoreCase("mientras")) {

        }
    }
    @Override public void exitCiclos(LPP_grammarParser.CiclosContext ctx) {
        this.isCiclos = false;
        this.setIndentationLevelDown();
    }
    @Override public void enterExpresion(LPP_grammarParser.ExpresionContext ctx) {
        if(this.isExpresionAsignacion){
            if (ctx.getChildCount() == 3) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                this.codeBuilder.append(ctx.getChild(1).getText());
                this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                this.codeBuilder.append("\n");
                this.isExpresionAsignacion = false;
            }
            else if (ctx.getChildCount() == 2){
                if (ctx.getChild(0).getText().equals("-")) {
                    this.codeBuilder.append(ctx.getChild(0).getText());
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append("\n");
                    this.isExpresionAsignacion = false;
                }
                else if(ctx.getChild(0).getText().equalsIgnoreCase("no")){
                    this.codeBuilder.append("not ");
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append("\n");
                    this.isExpresionAsignacion = false;
                }
            }
        }
        else if(this.isCondicion){
            if(ctx.getChildCount() == 1){
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
            }
            else if(ctx.getChildCount() == 2){
                if (ctx.getChild(0).getText().equals("-")) {
                    this.codeBuilder.append(ctx.getChild(0).getText());
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                }
                else if(ctx.getChild(0).getText().equalsIgnoreCase("no")){
                    this.codeBuilder.append("not ");
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                }
            }
            else if(ctx.getChildCount() == 3){
                if (ctx.getChild(1).getText().equals("=")) {
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append(" == ");
                    this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                } else if (ctx.getChild(1).getText().equals("<>")) {
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append(" != ");
                    this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                } else if (ctx.getChild(1).getText().equals("o")) {
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append(" or ");
                    this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                } else if (ctx.getChild(1).getText().equals("y")) {
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append(" and ");
                    this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                } else {
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                    this.codeBuilder.append(ctx.getChild(1).getText());
                    this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                }
            }
        }
    }
    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) { }
    @Override public void enterListaExpr(LPP_grammarParser.ListaExprContext ctx) {
        //this.codeBuilder.append(ctx.getChild(0).getText());
        if(this.isPrint){
            if(ctx.getChildCount() == 1){
                if (ctx.getChild(0).getText().contains("\"") || ctx.getChild(0).getText().contains("'")) {
                    this.codeBuilder.append(ctx.getChild(0).getText());
                }
                else{
                    this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                }
            }
            else {
                for (int i = 0; i < ctx.getChildCount()-2; i=i+2) {
                    if (ctx.getChild(0).getText().contains("\"") || ctx.getChild(0).getText().contains("'")) {
                        this.codeBuilder.append(ctx.getChild(i).getText());
                        this.codeBuilder.append(", ");
                    }
                    else{
                        this.codeBuilder.append(ctx.getChild(i).getText().toLowerCase());
                        this.codeBuilder.append(", ");
                    }
                }
                if (ctx.getChild(ctx.getChildCount() - 1).getText().contains("\"") || ctx.getChild(ctx.getChildCount() - 1).getText().contains("'")) {
                    this.codeBuilder.append(ctx.getChild(ctx.getChildCount() - 1).getText());
                }
                else {
                    this.codeBuilder.append(ctx.getChild(ctx.getChildCount() - 1).getText().toLowerCase());
                }
            }
        }
    }
    public void setIndentationLevelUp() {
        ++this.indentationLevel;
    }
    public void setIndentationLevelDown() {
        --this.indentationLevel;
    }
    public int getIndentationLevel() {
        return this.indentationLevel;
    }
    public void applyIndentation() {
        if (this.getIndentationLevel() >= 0) {
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
