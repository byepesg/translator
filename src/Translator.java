import java.util.*;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */

public class Translator extends LPP_grammarBaseListener{
    private final StringBuilder codeBuilder = new StringBuilder();
    private int identationLevel = 0;
    private boolean isLoop = false;
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
        if(ctx.listaIDs()!=null){
            int countIDs = 0;
            String varTmp = null;
            countIDs=ctx.getChild(1).getChildCount();
            for (int i =0;i<countIDs;i++){
                if (i%2==0){
                    varTmp = ctx.getChild(1).getChild(i).getText()+" = 0"+"\t"+"\n";
                    //System.out.println(varTmp);
                    codeBuilder.append(varTmp);

                }
            }
            code = varTmp;

        }

    }
    @Override public void enterAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void exitAccion(LPP_grammarParser.AccionContext ctx) { }

    @Override public void enterAsignacion(LPP_grammarParser.AsignacionContext ctx) {

        //System.out.println(ctx.getChild(0).getText());
        //System.out.println(ctx.getChild(1).getText());
        //System.out.println(ctx.getChild(2).getText());

        //************
        if(isLoop==true){
            codeBuilder.append(ctx.getChild(0).getText()+ "=" + ctx.getChild(2).getText()+" ");
        }
        else if(isLoop==false){
            codeBuilder.append(ctx.getChild(0).getText()+ "=" + ctx.getChild(2).getText()+"\n");
        }
//************
           /* if (ctx.getChild(1).getText().equals("<-")) {
                codeBuilder.append("=");

            }*/

        //codeBuilder.append("\n");

        //System.out.println(codeBuilder);
    }
    @Override public void enterExpresion(LPP_grammarParser.ExpresionContext ctx) {





    }

    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) { }

    @Override public void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx) {

    }
    @Override public void enterCiclos(LPP_grammarParser.CiclosContext ctx) {
        //System.out.println("This is control str.");
        isLoop = true;
        this.identationLevel += 1;
        if (this.identationLevel > 0){
            for (int i = 0; i<=this.identationLevel;i++){
                codeBuilder.append("\t");
            }
        }

        if(ctx.getChild(0).getText().equals("para")) {
            codeBuilder.append("for "+ctx.getChild(1).getChild(0).getText()+" ");
            if(ctx.getChild(4).getText().equals("hasta")) {
                codeBuilder.append(":");
                codeBuilder.append("\n");
            }
            if(ctx.getChild(4).getText().equals("haga")) {
                codeBuilder.append("in range"+"("+ctx.getChild(1).getChild(2).getText()+","+ctx.getChild(3).getText()+")");

            }
        }

        else if(ctx.getChild(0).getText().equals("mientras")) {
            codeBuilder.append("mientras");
        }
        else if(ctx.getChild(0).getText().equals("repita")) {
            codeBuilder.append("repita");
        }

        //System.out.println("This is the first"+ctx.getChild(1).getText());



        //System.out.println(ctx.getChild(1).getText());
            //System.out.println(ctx.getChild(2).getText());
            //System.out.println(ctx.getChild(3).getText());
            //System.out.println(ctx.getChild(4).getText());
            //System.out.println(ctx.getChild(5).getText());
            //System.out.println(ctx.getChild(6).getText());


    }

    @Override public void exitCiclos(LPP_grammarParser.CiclosContext ctx) {

        this.identationLevel -= 1;
        isLoop = true;

    }
    public String getCode() {
        //System.out.println(codeBuilder.toString());
        return codeBuilder.toString();
    }
}

