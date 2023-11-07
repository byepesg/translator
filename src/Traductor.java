import java.util.*;
public class Traductor extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int indentationLevel = 0;
    private boolean isAsign = false;
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
    }
    @Override public void exitAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.isAsign = false;
    }
    @Override public void enterEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.isPrint = true;
        this.codeBuilder.append("print(");
    }
    @Override public void exitEscribir(LPP_grammarParser.EscribirContext ctx) {
        this.isPrint = false;
        this.codeBuilder.append("print(");
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
