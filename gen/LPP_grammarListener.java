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
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionesTipos}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionesTipos(LPP_grammarParser.DeclaracionesTiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionesTipos}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionesTipos(LPP_grammarParser.DeclaracionesTiposContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionRegistro}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionRegistro(LPP_grammarParser.DeclaracionRegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionRegistro}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionRegistro(LPP_grammarParser.DeclaracionRegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionTipo}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionTipo(LPP_grammarParser.DeclaracionTipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionTipo}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionTipo(LPP_grammarParser.DeclaracionTipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionesSubprogramas}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionesSubprogramas(LPP_grammarParser.DeclaracionesSubprogramasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionesSubprogramas}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionesSubprogramas(LPP_grammarParser.DeclaracionesSubprogramasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionProcedimiento}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionProcedimiento(LPP_grammarParser.DeclaracionProcedimientoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionProcedimiento}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionProcedimiento(LPP_grammarParser.DeclaracionProcedimientoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuncion(LPP_grammarParser.DeclaracionFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuncion(LPP_grammarParser.DeclaracionFuncionContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionesVariables}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionesVariables(LPP_grammarParser.DeclaracionesVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionesVariables}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionesVariables(LPP_grammarParser.DeclaracionesVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#declaracionVariables}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionVariables(LPP_grammarParser.DeclaracionVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#declaracionVariables}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionVariables(LPP_grammarParser.DeclaracionVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LPP_grammarParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LPP_grammarParser.TipoContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#sentenciasSubprograma}.
	 * @param ctx the parse tree
	 */
	void enterSentenciasSubprograma(LPP_grammarParser.SentenciasSubprogramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#sentenciasSubprograma}.
	 * @param ctx the parse tree
	 */
	void exitSentenciasSubprograma(LPP_grammarParser.SentenciasSubprogramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#sentenciasPrograma}.
	 * @param ctx the parse tree
	 */
	void enterSentenciasPrograma(LPP_grammarParser.SentenciasProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#sentenciasPrograma}.
	 * @param ctx the parse tree
	 */
	void exitSentenciasPrograma(LPP_grammarParser.SentenciasProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void enterSentencias(LPP_grammarParser.SentenciasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void exitSentencias(LPP_grammarParser.SentenciasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(LPP_grammarParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(LPP_grammarParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#escriba}.
	 * @param ctx the parse tree
	 */
	void enterEscriba(LPP_grammarParser.EscribaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#escriba}.
	 * @param ctx the parse tree
	 */
	void exitEscriba(LPP_grammarParser.EscribaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#lea}.
	 * @param ctx the parse tree
	 */
	void enterLea(LPP_grammarParser.LeaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#lea}.
	 * @param ctx the parse tree
	 */
	void exitLea(LPP_grammarParser.LeaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#asignar}.
	 * @param ctx the parse tree
	 */
	void enterAsignar(LPP_grammarParser.AsignarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#asignar}.
	 * @param ctx the parse tree
	 */
	void exitAsignar(LPP_grammarParser.AsignarContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#procedimientoLibreriaEstandar}.
	 * @param ctx the parse tree
	 */
	void enterProcedimientoLibreriaEstandar(LPP_grammarParser.ProcedimientoLibreriaEstandarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#procedimientoLibreriaEstandar}.
	 * @param ctx the parse tree
	 */
	void exitProcedimientoLibreriaEstandar(LPP_grammarParser.ProcedimientoLibreriaEstandarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#si}.
	 * @param ctx the parse tree
	 */
	void enterSi(LPP_grammarParser.SiContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#si}.
	 * @param ctx the parse tree
	 */
	void exitSi(LPP_grammarParser.SiContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#caso}.
	 * @param ctx the parse tree
	 */
	void enterCaso(LPP_grammarParser.CasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#caso}.
	 * @param ctx the parse tree
	 */
	void exitCaso(LPP_grammarParser.CasoContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#listaExprOpcion}.
	 * @param ctx the parse tree
	 */
	void enterListaExprOpcion(LPP_grammarParser.ListaExprOpcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#listaExprOpcion}.
	 * @param ctx the parse tree
	 */
	void exitListaExprOpcion(LPP_grammarParser.ListaExprOpcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#exprOpcion}.
	 * @param ctx the parse tree
	 */
	void enterExprOpcion(LPP_grammarParser.ExprOpcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#exprOpcion}.
	 * @param ctx the parse tree
	 */
	void exitExprOpcion(LPP_grammarParser.ExprOpcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#rangoExpr}.
	 * @param ctx the parse tree
	 */
	void enterRangoExpr(LPP_grammarParser.RangoExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#rangoExpr}.
	 * @param ctx the parse tree
	 */
	void exitRangoExpr(LPP_grammarParser.RangoExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#casoSino}.
	 * @param ctx the parse tree
	 */
	void enterCasoSino(LPP_grammarParser.CasoSinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#casoSino}.
	 * @param ctx the parse tree
	 */
	void exitCasoSino(LPP_grammarParser.CasoSinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#mientras}.
	 * @param ctx the parse tree
	 */
	void enterMientras(LPP_grammarParser.MientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#mientras}.
	 * @param ctx the parse tree
	 */
	void exitMientras(LPP_grammarParser.MientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(LPP_grammarParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(LPP_grammarParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#repita}.
	 * @param ctx the parse tree
	 */
	void enterRepita(LPP_grammarParser.RepitaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#repita}.
	 * @param ctx the parse tree
	 */
	void exitRepita(LPP_grammarParser.RepitaContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#abrir}.
	 * @param ctx the parse tree
	 */
	void enterAbrir(LPP_grammarParser.AbrirContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#abrir}.
	 * @param ctx the parse tree
	 */
	void exitAbrir(LPP_grammarParser.AbrirContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(LPP_grammarParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(LPP_grammarParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#cerrar}.
	 * @param ctx the parse tree
	 */
	void enterCerrar(LPP_grammarParser.CerrarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#cerrar}.
	 * @param ctx the parse tree
	 */
	void exitCerrar(LPP_grammarParser.CerrarContext ctx);
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
	 * Enter a parse tree produced by {@link LPP_grammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LPP_grammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LPP_grammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#funcionLibreriaEstandar}.
	 * @param ctx the parse tree
	 */
	void enterFuncionLibreriaEstandar(LPP_grammarParser.FuncionLibreriaEstandarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#funcionLibreriaEstandar}.
	 * @param ctx the parse tree
	 */
	void exitFuncionLibreriaEstandar(LPP_grammarParser.FuncionLibreriaEstandarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPP_grammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LPP_grammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPP_grammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LPP_grammarParser.LiteralContext ctx);
}