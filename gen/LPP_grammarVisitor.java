// Generated from /Users/byepesg/Documents/Unal/2023-II/ProgrammingLanguages/Translator_V2/grammar/LPP_grammar.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link LPP_grammarParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(LPP_grammarParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#rutina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRutina(LPP_grammarParser.RutinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#procedimiento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedimiento(LPP_grammarParser.ProcedimientoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(LPP_grammarParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#retorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorne(LPP_grammarParser.RetorneContext ctx);
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
	 * Visit a parse tree produced by {@link LPP_grammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LPP_grammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#tipo_dato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_dato(LPP_grammarParser.Tipo_datoContext ctx);
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
	 * Visit a parse tree produced by {@link LPP_grammarParser#estructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructura(LPP_grammarParser.EstructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccion(LPP_grammarParser.AccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(LPP_grammarParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#listaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpr(LPP_grammarParser.ListaExprContext ctx);
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
	 * Visit a parse tree produced by {@link LPP_grammarParser#llamar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamar(LPP_grammarParser.LlamarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(LPP_grammarParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#sino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSino(LPP_grammarParser.SinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#casos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasos(LPP_grammarParser.CasosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#opcionCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcionCaso(LPP_grammarParser.OpcionCasoContext ctx);
	/**
	 * Visit a parse tree produced by
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault(LPP_grammarParser.DefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#ciclos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclos(LPP_grammarParser.CiclosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#valores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValores(LPP_grammarParser.ValoresContext ctx);
	/**
	 * Visit a parse tree produced by
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(LPP_grammarParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LPP_grammarParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(LPP_grammarParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(LPP_grammarParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(LPP_grammarParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPP_grammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(LPP_grammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(LPP_grammarParser.BooleanContext ctx);
}