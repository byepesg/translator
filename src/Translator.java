import java.util.*;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */

public class Translator extends LPP_grammarBaseListener{
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
    @Override public void enterPrograma(LPP_grammarParser.ProgramaContext ctx) {

        System.out.println("import sys");
        System.out.println("\t");
    }
    @Override public void enterDeclaracionesVariables(LPP_grammarParser.DeclaracionesVariablesContext ctx) {
        if ((!this.activeTag.equals("entero"))){
            System.out.println("");
        }
        if ((!this.activeTag.equals("real"))){
            System.out.println("");
        }
        if ((!this.activeTag.equals("cadena"))){
            System.out.println("");
        }
        if ((!this.activeTag.equals("booleano"))){
            System.out.println("");
        }
        if ((!this.activeTag.equals("caracter"))){
            System.out.println("");
        }


    }
    @Override public void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx) {

    }

}

