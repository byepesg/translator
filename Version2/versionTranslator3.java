//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Translator extends LPP_grammarBaseListener {
    private final StringBuilder codeBuilder = new StringBuilder();
    private int identationLevel = 0;
    private boolean isLoop = false;
    private final boolean control_structure_conditonal = false;
    private String builtinName = "";
    private String builtinFunction = "";
    private List<String> builtinArguments = new ArrayList();
    private Set<String> addons = new HashSet();
    private int counterCharactersImport = 0;
    private int counterCharactersFunction = 0;
    private Map<String, Object[]> tags = new HashMap();
    private String activeTag = "";
    private String code = "";

    public Translator() {
    }

    public void enterPrograma(LPP_grammarParser$ProgramaContext ctx) {
        System.out.println("###This is the python translation");
    }

    public void enterVariable(LPP_grammarParser$VariableContext ctx) {
        if (ctx.listaIDs() != null) {
            int countIDs = false;
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

    public void enterAccion(LPP_grammarParser$AccionContext ctx) {
    }

    public void exitAccion(LPP_grammarParser$AccionContext ctx) {
    }

    public void enterAsignacion(LPP_grammarParser$AsignacionContext ctx) {
        if (!this.isLoop && !this.isLoop) {
            StringBuilder var10000 = this.codeBuilder;
            String var10001 = ctx.getChild(0).getText();
            var10000.append(var10001 + "=" + ctx.getChild(2).getText() + 
"\n");
        }

    }

    public void enterExpresion(LPP_grammarParser$ExpresionContext ctx) {
    }

    public void exitExpresion(LPP_grammarParser$ExpresionContext ctx) {
    }

    public void enterListaIDs(LPP_grammarParser$ListaIDsContext ctx) {
    }

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

    public void enterCiclos(LPP_grammarParser$CiclosContext ctx) {
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

    public void exitCiclos(LPP_grammarParser$CiclosContext ctx) {
        --this.identationLevel;
        this.isLoop = true;
    }

    public void enterEscribir(LPP_grammarParser$EscribirContext ctx) {
        this.applyIdentation();
        this.codeBuilder.append("print(" + ctx.getChild(1).getText() + 
")\n");
    }

    public void exitEscribir(LPP_grammarParser$EscribirContext ctx) {
    }

    public void enterListaExpr(LPP_grammarParser$ListaExprContext ctx) {
    }

    public void exitListaExpr(LPP_grammarParser$ListaExprContext ctx) {
    }

    public String getCode() {
        return this.codeBuilder.toString();
    }
}

