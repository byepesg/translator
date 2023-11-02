// Generated from C:/Users/Asus/Desktop/UNAL/SEMESTRE11/Lenguajes_programacion/TRADUCTOR/translator/grammar/LPP_grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LPP_grammarParser}.
 */
public interface LPP_grammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LPP_grammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LPP_grammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(LPP_grammarParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(LPP_grammarParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#rutina}.
	 * @param ctx the parse tree
	 */
	void enterRutina(LPP_grammarParser.RutinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#rutina}.
	 * @param ctx the parse tree
	 */
	void exitRutina(LPP_grammarParser.RutinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimiento(LPP_grammarParser.ProcedimientoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimiento(LPP_grammarParser.ProcedimientoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(LPP_grammarParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(LPP_grammarParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#retorne}.
	 * @param ctx the parse tree
	 */
	void enterRetorne(LPP_grammarParser.RetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#retorne}.
	 * @param ctx the parse tree
	 */
	void exitRetorne(LPP_grammarParser.RetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LPP_grammarParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LPP_grammarParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(LPP_grammarParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(LPP_grammarParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LPP_grammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LPP_grammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#tipo_dato}.
	 * @param ctx the parse tree
	 */
	void enterTipo_dato(LPP_grammarParser.Tipo_datoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#tipo_dato}.
	 * @param ctx the parse tree
	 */
	void exitTipo_dato(LPP_grammarParser.Tipo_datoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void enterListaIDs(LPP_grammarParser.ListaIDsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void exitListaIDs(LPP_grammarParser.ListaIDsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#listaEnteros}.
	 * @param ctx the parse tree
	 */
	void enterListaEnteros(LPP_grammarParser.ListaEnterosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#listaEnteros}.
	 * @param ctx the parse tree
	 */
	void exitListaEnteros(LPP_grammarParser.ListaEnterosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#estructura}.
	 * @param ctx the parse tree
	 */
	void enterEstructura(LPP_grammarParser.EstructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#estructura}.
	 * @param ctx the parse tree
	 */
	void exitEstructura(LPP_grammarParser.EstructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccion(LPP_grammarParser.AccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccion(LPP_grammarParser.AccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(LPP_grammarParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(LPP_grammarParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#listaExpr}.
	 * @param ctx the parse tree
	 */
	void enterListaExpr(LPP_grammarParser.ListaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#listaExpr}.
	 * @param ctx the parse tree
	 */
	void exitListaExpr(LPP_grammarParser.ListaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#escribir}.
	 * @param ctx the parse tree
	 */
	void enterEscribir(LPP_grammarParser.EscribirContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#escribir}.
	 * @param ctx the parse tree
	 */
	void exitEscribir(LPP_grammarParser.EscribirContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#leer}.
	 * @param ctx the parse tree
	 */
	void enterLeer(LPP_grammarParser.LeerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#leer}.
	 * @param ctx the parse tree
	 */
	void exitLeer(LPP_grammarParser.LeerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#llamar}.
	 * @param ctx the parse tree
	 */
	void enterLlamar(LPP_grammarParser.LlamarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#llamar}.
	 * @param ctx the parse tree
	 */
	void exitLlamar(LPP_grammarParser.LlamarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(LPP_grammarParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(LPP_grammarParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#sino}.
	 * @param ctx the parse tree
	 */
	void enterSino(LPP_grammarParser.SinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#sino}.
	 * @param ctx the parse tree
	 */
	void exitSino(LPP_grammarParser.SinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#casos}.
	 * @param ctx the parse tree
	 */
	void enterCasos(LPP_grammarParser.CasosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#casos}.
	 * @param ctx the parse tree
	 */
	void exitCasos(LPP_grammarParser.CasosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#opcionCaso}.
	 * @param ctx the parse tree
	 */
	void enterOpcionCaso(LPP_grammarParser.OpcionCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#opcionCaso}.
	 * @param ctx the parse tree
	 */
	void exitOpcionCaso(LPP_grammarParser.OpcionCasoContext ctx);
	/**
	 * E
	 * @param ctx the parse tree
	 */
	void enterDefault(LPP_grammarParser.DefaultContext ctx);
	/**
	 * Ex
	 * @param ctx the parse tree
	 */
	void exitDefault(LPP_grammarParser.DefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#ciclos}.
	 * @param ctx the parse tree
	 */
	void enterCiclos(LPP_grammarParser.CiclosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#ciclos}.
	 * @param ctx the parse tree
	 */
	void exitCiclos(LPP_grammarParser.CiclosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#valores}.
	 * @param ctx the parse tree
	 */
	void enterValores(LPP_grammarParser.ValoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#valores}.
	 * @param ctx the parse tree
	 */
	void exitValores(LPP_grammarParser.ValoresContext ctx);
	/**
	 * Ente
	 * @param ctx the parse tree
	 */
	void enterExpresion(LPP_grammarParser.ExpresionContext ctx);
	/**
	 * Exit a pa
	 * @param ctx the parse tree
	 */
	void exitExpresion(LPP_grammarParser.ExpresionContext ctx);
}