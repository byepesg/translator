// Generated from C:/Users/Asus/Desktop/UNAL/SEMESTRE11/Lenguajes_programacion/TRADUCTOR/translator/grammar/LPP_grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LPP_grammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LPP_grammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LPP_grammarParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionesTipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionesTipos(LPP_grammarParser.DeclaracionesTiposContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionRegistro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionRegistro(LPP_grammarParser.DeclaracionRegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionTipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionTipo(LPP_grammarParser.DeclaracionTipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionesSubprogramas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionesSubprogramas(LPP_grammarParser.DeclaracionesSubprogramasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionProcedimiento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionProcedimiento(LPP_grammarParser.DeclaracionProcedimientoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuncion(LPP_grammarParser.DeclaracionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(LPP_grammarParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(LPP_grammarParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionesVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionesVariables(LPP_grammarParser.DeclaracionesVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#declaracionVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionVariables(LPP_grammarParser.DeclaracionVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LPP_grammarParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#listaIDs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIDs(LPP_grammarParser.ListaIDsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#listaEnteros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaEnteros(LPP_grammarParser.ListaEnterosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sentenciasSubprograma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciasSubprograma(LPP_grammarParser.SentenciasSubprogramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sentenciasPrograma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciasPrograma(LPP_grammarParser.SentenciasProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sentencias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencias(LPP_grammarParser.SentenciasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(LPP_grammarParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#escriba}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscriba(LPP_grammarParser.EscribaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#lea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLea(LPP_grammarParser.LeaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#asignar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignar(LPP_grammarParser.AsignarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#llamar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamar(LPP_grammarParser.LlamarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#procedimientoLibreriaEstandar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedimientoLibreriaEstandar(LPP_grammarParser.ProcedimientoLibreriaEstandarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSi(LPP_grammarParser.SiContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSino(LPP_grammarParser.SinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#caso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaso(LPP_grammarParser.CasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#opcionCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcionCaso(LPP_grammarParser.OpcionCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#listaExprOpcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExprOpcion(LPP_grammarParser.ListaExprOpcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#exprOpcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOpcion(LPP_grammarParser.ExprOpcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#rangoExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangoExpr(LPP_grammarParser.RangoExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#casoSino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasoSino(LPP_grammarParser.CasoSinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#mientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMientras(LPP_grammarParser.MientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(LPP_grammarParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#repita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepita(LPP_grammarParser.RepitaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#retorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorne(LPP_grammarParser.RetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#abrir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbrir(LPP_grammarParser.AbrirContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(LPP_grammarParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#cerrar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCerrar(LPP_grammarParser.CerrarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#escribir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscribir(LPP_grammarParser.EscribirContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#leer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeer(LPP_grammarParser.LeerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#listaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpr(LPP_grammarParser.ListaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LPP_grammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#funcionLibreriaEstandar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncionLibreriaEstandar(LPP_grammarParser.FuncionLibreriaEstandarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LPP_grammarParser.LiteralContext ctx);
}