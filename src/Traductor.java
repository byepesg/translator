import java.util.*;
import java.util.regex.*;
public class Traductor extends LPP_grammarBaseListener{

    private final StringBuilder codeBuilder = new StringBuilder();
    private int indentationLevel = 0;
    private boolean isAsign = false;
    private boolean isObject = false;
    private ArrayList<String> classesList = new ArrayList<>();
    private ArrayList<String> procedureList = new ArrayList<>();
    private ArrayList<String> procedureListTmp = new ArrayList<>();
    private boolean isExpresionAsignacion = false;
    private boolean isPrint = false;
    private boolean isRead = false;
    private boolean isFuntion = false;
    private boolean isProcedimiento = false;
    private boolean isCall = false;
    private boolean isCondicion = false;
    private boolean isRegister = false;
    private boolean isCasos = false;
    private boolean isCiclos = false;
    private boolean isArray = false;
    private boolean stillArray = false;
    private String nombre = new String();
    private List<String> Arrays = new ArrayList<>();
    private List<String> AsArr = new ArrayList<>();
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return the input string as is if it's null or empty.
        }

        char firstChar = Character.toUpperCase(input.charAt(0));
        return firstChar + input.substring(1);
    }
    public boolean containsRegisterElement(String element) {
        return classesList.contains(element);
    }

    public int indexRegisterElement(String element) {
        if (containsRegisterElement(element)) {
            return classesList.indexOf(element);
        }
        return -1; // Devolver -1 si el elemento no se encuentra
    }
    public void imprimirElementos() {
        for (int i = 0; i < this.classesList.size(); i++) {
            System.out.println("Elemento " + i + ": " + this.classesList.get(i));
        }
    }
    public boolean containsProcedureElement(String element) {

        return procedureList.contains(element);
    }
    public int indexProcedureElement(String element) {
        if (containsProcedureElement(element)) {
            return procedureList.indexOf(element);
        }
        return -1; // Devolver -1 si el elemento no se encuentra
    }

    public void printProcedureElements() {
        for (int i = 0; i < this.procedureList.size(); i++) {
            System.out.println("Elemento " + i + ": " + this.procedureList.get(i));
        }
    }

    public void printProcedureTmpElements() {

        for (int i = 0; i < this.procedureList.size(); i++) {
            System.out.println("Elemento " + i + ": " + this.procedureList.get(i));
        }
    }




    ///////////////////////////////////////////////////////////
    @Override public void enterPrograma(LPP_grammarParser.ProgramaContext ctx) {
        System.out.println("###This is the python translation");
        this.codeBuilder.append("import numpy as np\n\n");
    }
    @Override public void enterRegistro(LPP_grammarParser.RegistroContext ctx) {
        isRegister = true;
        this.setIndentationLevelUp();
        if(ctx.getChild(0).getText().equalsIgnoreCase("registro")){
            this.codeBuilder.append("class ");
            this.codeBuilder.append(capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase())+":\n");
            this.classesList.add(capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase()));
        }

    }

    @Override public void exitRegistro(LPP_grammarParser.RegistroContext ctx) {


        this.setIndentationLevelDown();

    }
    @Override public void enterProcedimiento(LPP_grammarParser.ProcedimientoContext ctx) {

        this.setIndentationLevelUp();

        if(ctx.getChild(0).getText().equalsIgnoreCase("procedimiento")){
            this.codeBuilder.append("def ");
            this.codeBuilder.append(ctx.getChild(1).getText().toLowerCase()+"():\n");
            this.procedureList.add(capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase()));

        }
    }

    @Override public void exitProcedimiento(LPP_grammarParser.ProcedimientoContext ctx) {
    this.setIndentationLevelDown();
    }
    @Override public void enterVariable(LPP_grammarParser.VariableContext ctx) {
        //When is needed assign class objects
        //******************************************************************************************************
        this.applyIndentation();
        boolean isRegisterVariable;
        int indexVariable;
        isRegisterVariable = this.containsRegisterElement(capitalizeFirstLetter(ctx.getChild(0).getText()));
        indexVariable = this.indexRegisterElement(capitalizeFirstLetter(ctx.getChild(0).getText()));

        if( isRegisterVariable) {
            this.isObject = true;
                if(this.isRegister){
                    codeBuilder.append("def __init__(self):\n");
                    setIndentationLevelUp();
                    applyIndentation();
                    codeBuilder.append("self.");
                    codeBuilder.append(ctx.getChild(1).getText() + "=" + this.classesList.get(indexVariable) + "()\n");
                    setIndentationLevelDown();
                    this.isRegister= false;
                }
                else{
                    codeBuilder.append(ctx.getChild(1).getText() + "=" + this.classesList.get(indexVariable) + "()\n");
                }

        }
        //******************************************************************************************************
        if (ctx.getChild(0).getChildCount() != 1 && ctx.getChild(0).getChild(0).getText().equalsIgnoreCase("arreglo")) {
            this.isArray = true;
            for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
                if (!ctx.getChild(1).getChild(i).getText().equals(",")) {
                    this.Arrays.add(ctx.getChild(1).getChild(i).getText().toLowerCase());
                }
            }
        }
        else{
            //When is needed to assign objects
            if(this.isObject){

            }
            else {
                for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
                    if (!ctx.getChild(1).getChild(i).getText().equals(",")) {
                        this.codeBuilder.append(ctx.getChild(1).getChild(i).getText().toLowerCase());
                        this.codeBuilder.append(" = 0\n");
                    }
                }
            }
        }
    }
    @Override public void exitVariable(LPP_grammarParser.VariableContext ctx) {
        this.isArray = false;
        this.isObject = false;
    }
    @Override public void enterFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.setIndentationLevelUp();

        if (ctx.getChild(2).toString().equals("(")) {
            this.codeBuilder.append("def ");
            this.codeBuilder.append(ctx.getChild(1).getText().toLowerCase());
            this.codeBuilder.append(" (");
            this.isFuntion = true;
            //this.codeBuilder.append("):\n");
        }
        else {
            this.codeBuilder.append("def " + ctx.getChild(1).getText().toLowerCase()+"():\n");
        }
    }
    @Override public void exitFuncion(LPP_grammarParser.FuncionContext ctx) {
        this.setIndentationLevelDown();
    }
    @Override public void enterParametros(LPP_grammarParser.ParametrosContext ctx) {
        if(this.isFuntion || this.isProcedimiento){
            for (int i = 0; i < ctx.getChildCount()-2; i = i+2){
                this.codeBuilder.append(ctx.getChild(i).getChild(1).getText().toLowerCase());
                this.codeBuilder.append(", ");
            }
            this.codeBuilder.append(ctx.getChild(ctx.getChildCount()-1).getChild(1).getText().toLowerCase());
            this.codeBuilder.append("):\n");
        }
    }
    @Override public void exitParametros(LPP_grammarParser.ParametrosContext ctx) {
        this.isFuntion = false;
        this.isProcedimiento = false;
    }
    @Override public void enterRetorne(LPP_grammarParser.RetorneContext ctx) {
        this.applyIndentation();
        this.codeBuilder.append("return ");
        if (ctx.getChild(1).getText().contains("\"") || ctx.getChild(1).getText().contains("'")) {
            this.codeBuilder.append(ctx.getChild(1).getText());
            this.codeBuilder.append("\n");
        }
        else{
            this.codeBuilder.append(ctx.getChild(1).getText().toLowerCase());
            this.codeBuilder.append("\n");
        }
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
                    nombre = this.Arrays.get(0);
                    this.codeBuilder.append(nombre);
                    this.codeBuilder.append(" = np.full((");
                    if (!this.stillArray) {
                        for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                            this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                            this.codeBuilder.append(", ");
                            this.AsArr.add(ctx.getChild(2).getChild(i).getText());
                        }
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append("), 0)\n");
                        this.isArray = false;
                        this.AsArr.add(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                    }
                    else {
                        for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                            this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                            this.codeBuilder.append(", ");
                            this.AsArr.add(ctx.getChild(2).getChild(i).getText());
                        }
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append(", ");
                        this.AsArr.add(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                    }
                    this.Arrays.remove(0);
                }
                catch (IndexOutOfBoundsException e){
                    for (int i = 0; i < ctx.getChild(2).getChildCount() - 2; i = i + 2) {
                        this.codeBuilder.append(ctx.getChild(2).getChild(i).getText());
                        this.codeBuilder.append(", ");
                        this.AsArr.add(ctx.getChild(2).getChild(i).getText());
                    }
                    if (!this.stillArray) {
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append("), 0)\n");
                        this.isArray = false;
                        this.AsArr.add(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                    }
                    else {
                        this.codeBuilder.append(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
                        this.codeBuilder.append(", ");
                        this.AsArr.add(ctx.getChild(2).getChild(ctx.getChild(2).getChildCount() - 1).getText());
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
        if (ctx.getChild(0).getText().toLowerCase().contains("[")){
            String na = ctx.getChild(0).getText().toLowerCase();
            String patron = "[0-9]";
            String res = "";
            String res2 = "";
            Pattern pattern = Pattern.compile(patron);
            for(char caracter : na.toCharArray()){
                Matcher matcher = pattern.matcher(String.valueOf(caracter));
                if (matcher.find()){
                    res = res + caracter;
                }
            }
            for(char caracter : na.toCharArray()){
                if (caracter == '['){
                    break;
                }
                else{
                    res2 = res2 + caracter;
                }
            }
            this.codeBuilder.append(res2);
            this.getString(res);
            this.codeBuilder.append(" = ");
            if (ctx.getChild(2).getText().equalsIgnoreCase("falso") || ctx.getChild(2).getText().equalsIgnoreCase("verdadero")) {
            }
            else {
                this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                this.codeBuilder.append("\n");
                this.isExpresionAsignacion = false;
            }
        }
        else {
            if (!this.isCiclos) {
                this.codeBuilder.append(ctx.getChild(0).getText().toLowerCase());
                this.codeBuilder.append(" = ");
                if (ctx.getChild(2).getChildCount() == 1) {
                    if (ctx.getChild(2).getText().equalsIgnoreCase("falso") || ctx.getChild(2).getText().equalsIgnoreCase("verdadero")) {

                    } else {
                        this.codeBuilder.append(ctx.getChild(2).getText().toLowerCase());
                        this.codeBuilder.append("\n");
                        this.isExpresionAsignacion = false;
                    }
                } else {
                    this.isExpresionAsignacion = true;
                }
            } else {
                this.isCiclos = false;
            }
        }
    }
    @Override public void exitAsignacion(LPP_grammarParser.AsignacionContext ctx) {
        this.isAsign = false;
        this.isExpresionAsignacion = false;
        this.AsArr.clear();
    }
    @Override public void enterBoolean(LPP_grammarParser.BooleanContext ctx) {
        if(ctx.getChild(0).getText().equalsIgnoreCase("falso")){
            this.codeBuilder.append("False");
            this.codeBuilder.append("\n");
        }
        else if(ctx.getChild(0).getText().equalsIgnoreCase("verdadero")){
            this.codeBuilder.append("True");
            this.codeBuilder.append("\n");
        }
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
        int openingPar=(ctx.getChildCount()-2);
        int closingPar=(ctx.getChildCount()-1);
        boolean isProcedureVariable = false;
        int indexVariable= 0;

        isProcedureVariable = this.containsProcedureElement(capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase()));
        indexVariable = this.indexProcedureElement(capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase()));



        if(ctx.getChild(1).getText().equalsIgnoreCase("nueva_linea")){
            this.codeBuilder.append("print(\""+"\\n\")"+"\n");
        }
        else if(ctx.getChild(openingPar).getText().equals("(") &&ctx.getChild(closingPar).getText().equals(")")){
            codeBuilder.append(this.procedureList.get(indexVariable)+"()\n");

            //printProcedureElements();
            //System.out.println("Variable a buscar:"+capitalizeFirstLetter(ctx.getChild(1).getText().toLowerCase()));
            //System.out.println("pv"+isProcedureVariable+"Index"+indexVariable);


        }


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
            this.codeBuilder.append("while ");
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
                    this.codeBuilder.append(ctx.getChild(1).getText().toLowerCase());
                    this.codeBuilder.append("\n");
                    this.isExpresionAsignacion = false;
                }
                else if(ctx.getChild(0).getText().equalsIgnoreCase("no")){
                    this.codeBuilder.append("not ");
                    this.codeBuilder.append(ctx.getChild(1).getText().toLowerCase());
                    this.codeBuilder.append("\n");
                    this.isExpresionAsignacion = false;
                }
            }
        }
        else if(this.isCondicion) {
        }
    }
    @Override public void exitExpresion(LPP_grammarParser.ExpresionContext ctx) { }
    @Override public void enterListaExpr(LPP_grammarParser.ListaExprContext ctx) {
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
                    if (ctx.getChild(i).getText().contains("\"") || ctx.getChild(i).getText().contains("'")) {
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
    public void getString(String lista){
        int con = 0;
        this.codeBuilder.append("[");
        for(char c : lista.toCharArray()){
            if (con == lista.length()-1){
                this.codeBuilder.append(c);
                this.codeBuilder.append("]");
            }
            else{
                this.codeBuilder.append(c);
                this.codeBuilder.append(", ");
                con++;
            }
        }
    }
    public void getExpresion(String p){
        for(char c : p.toCharArray()){

        }
    }
    public String getCode() {
        //System.out.println(codeBuilder.toString());
        return codeBuilder.toString();
    }
}
