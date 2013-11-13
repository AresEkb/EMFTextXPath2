/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractXpath2Interpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.xpath2.Expr) {
			result = interprete_org_emftext_language_xpath2_Expr((org.emftext.language.xpath2.Expr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ForExpr) {
			result = interprete_org_emftext_language_xpath2_ForExpr((org.emftext.language.xpath2.ForExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.QuantifiedExpr) {
			result = interprete_org_emftext_language_xpath2_QuantifiedExpr((org.emftext.language.xpath2.QuantifiedExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.IfExpr) {
			result = interprete_org_emftext_language_xpath2_IfExpr((org.emftext.language.xpath2.IfExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AndExpr) {
			result = interprete_org_emftext_language_xpath2_AndExpr((org.emftext.language.xpath2.AndExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ComparisonExpr) {
			result = interprete_org_emftext_language_xpath2_ComparisonExpr((org.emftext.language.xpath2.ComparisonExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.RangeExpr) {
			result = interprete_org_emftext_language_xpath2_RangeExpr((org.emftext.language.xpath2.RangeExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AdditiveExpr) {
			result = interprete_org_emftext_language_xpath2_AdditiveExpr((org.emftext.language.xpath2.AdditiveExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.MultiplicativeExpr) {
			result = interprete_org_emftext_language_xpath2_MultiplicativeExpr((org.emftext.language.xpath2.MultiplicativeExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.UnionExpr) {
			result = interprete_org_emftext_language_xpath2_UnionExpr((org.emftext.language.xpath2.UnionExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.IntersectExceptExpr) {
			result = interprete_org_emftext_language_xpath2_IntersectExceptExpr((org.emftext.language.xpath2.IntersectExceptExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.InstanceofExpr) {
			result = interprete_org_emftext_language_xpath2_InstanceofExpr((org.emftext.language.xpath2.InstanceofExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.TreatExpr) {
			result = interprete_org_emftext_language_xpath2_TreatExpr((org.emftext.language.xpath2.TreatExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.TreatExprChild) {
			result = interprete_org_emftext_language_xpath2_TreatExprChild((org.emftext.language.xpath2.TreatExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.InstanceofExprChild) {
			result = interprete_org_emftext_language_xpath2_InstanceofExprChild((org.emftext.language.xpath2.InstanceofExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.IntersectExceptExprChild) {
			result = interprete_org_emftext_language_xpath2_IntersectExceptExprChild((org.emftext.language.xpath2.IntersectExceptExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.UnionExprChild) {
			result = interprete_org_emftext_language_xpath2_UnionExprChild((org.emftext.language.xpath2.UnionExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.MultiplicativeExprChild) {
			result = interprete_org_emftext_language_xpath2_MultiplicativeExprChild((org.emftext.language.xpath2.MultiplicativeExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AdditiveExprChild) {
			result = interprete_org_emftext_language_xpath2_AdditiveExprChild((org.emftext.language.xpath2.AdditiveExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.RangeExprChild) {
			result = interprete_org_emftext_language_xpath2_RangeExprChild((org.emftext.language.xpath2.RangeExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ComparisonExprChild) {
			result = interprete_org_emftext_language_xpath2_ComparisonExprChild((org.emftext.language.xpath2.ComparisonExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AndExprChild) {
			result = interprete_org_emftext_language_xpath2_AndExprChild((org.emftext.language.xpath2.AndExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.OrExprChild) {
			result = interprete_org_emftext_language_xpath2_OrExprChild((org.emftext.language.xpath2.OrExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ExprSingle) {
			result = interprete_org_emftext_language_xpath2_ExprSingle((org.emftext.language.xpath2.ExprSingle) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SimpleForClause) {
			result = interprete_org_emftext_language_xpath2_SimpleForClause((org.emftext.language.xpath2.SimpleForClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SimpleForClauseIterator) {
			result = interprete_org_emftext_language_xpath2_SimpleForClauseIterator((org.emftext.language.xpath2.SimpleForClauseIterator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.OrExpr) {
			result = interprete_org_emftext_language_xpath2_OrExpr((org.emftext.language.xpath2.OrExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.CastableExpr) {
			result = interprete_org_emftext_language_xpath2_CastableExpr((org.emftext.language.xpath2.CastableExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.CastExpr) {
			result = interprete_org_emftext_language_xpath2_CastExpr((org.emftext.language.xpath2.CastExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.UnaryExpr) {
			result = interprete_org_emftext_language_xpath2_UnaryExpr((org.emftext.language.xpath2.UnaryExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SinglePathExpr) {
			result = interprete_org_emftext_language_xpath2_SinglePathExpr((org.emftext.language.xpath2.SinglePathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DoublePathExpr) {
			result = interprete_org_emftext_language_xpath2_DoublePathExpr((org.emftext.language.xpath2.DoublePathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.RelativePathExpr) {
			result = interprete_org_emftext_language_xpath2_RelativePathExpr((org.emftext.language.xpath2.RelativePathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.PathExpr) {
			result = interprete_org_emftext_language_xpath2_PathExpr((org.emftext.language.xpath2.PathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ValueExpr) {
			result = interprete_org_emftext_language_xpath2_ValueExpr((org.emftext.language.xpath2.ValueExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.UnaryExprChild) {
			result = interprete_org_emftext_language_xpath2_UnaryExprChild((org.emftext.language.xpath2.UnaryExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.CastExprChild) {
			result = interprete_org_emftext_language_xpath2_CastExprChild((org.emftext.language.xpath2.CastExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.CastableExprChild) {
			result = interprete_org_emftext_language_xpath2_CastableExprChild((org.emftext.language.xpath2.CastableExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.FilterExpr) {
			result = interprete_org_emftext_language_xpath2_FilterExpr((org.emftext.language.xpath2.FilterExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AxisStep) {
			result = interprete_org_emftext_language_xpath2_AxisStep((org.emftext.language.xpath2.AxisStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.StepExpr) {
			result = interprete_org_emftext_language_xpath2_StepExpr((org.emftext.language.xpath2.StepExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SingleTailPathExpr) {
			result = interprete_org_emftext_language_xpath2_SingleTailPathExpr((org.emftext.language.xpath2.SingleTailPathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DoubleTailPathExpr) {
			result = interprete_org_emftext_language_xpath2_DoubleTailPathExpr((org.emftext.language.xpath2.DoubleTailPathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.TailPathExpr) {
			result = interprete_org_emftext_language_xpath2_TailPathExpr((org.emftext.language.xpath2.TailPathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ForwardStep) {
			result = interprete_org_emftext_language_xpath2_ForwardStep((org.emftext.language.xpath2.ForwardStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AbbrevReverseStep) {
			result = interprete_org_emftext_language_xpath2_AbbrevReverseStep((org.emftext.language.xpath2.AbbrevReverseStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ReverseStep) {
			result = interprete_org_emftext_language_xpath2_ReverseStep((org.emftext.language.xpath2.ReverseStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.GeneralForwardStep) {
			result = interprete_org_emftext_language_xpath2_GeneralForwardStep((org.emftext.language.xpath2.GeneralForwardStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AbbrevForwardStep) {
			result = interprete_org_emftext_language_xpath2_AbbrevForwardStep((org.emftext.language.xpath2.AbbrevForwardStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DirectionalStep) {
			result = interprete_org_emftext_language_xpath2_DirectionalStep((org.emftext.language.xpath2.DirectionalStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ForwardAxis) {
			result = interprete_org_emftext_language_xpath2_ForwardAxis((org.emftext.language.xpath2.ForwardAxis) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.GeneralReverseStep) {
			result = interprete_org_emftext_language_xpath2_GeneralReverseStep((org.emftext.language.xpath2.GeneralReverseStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ReverseAxis) {
			result = interprete_org_emftext_language_xpath2_ReverseAxis((org.emftext.language.xpath2.ReverseAxis) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NodeKindTest) {
			result = interprete_org_emftext_language_xpath2_NodeKindTest((org.emftext.language.xpath2.NodeKindTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.QNameTest) {
			result = interprete_org_emftext_language_xpath2_QNameTest((org.emftext.language.xpath2.QNameTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AnyWildcard) {
			result = interprete_org_emftext_language_xpath2_AnyWildcard((org.emftext.language.xpath2.AnyWildcard) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.LocalNameWildcard) {
			result = interprete_org_emftext_language_xpath2_LocalNameWildcard((org.emftext.language.xpath2.LocalNameWildcard) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NamespaceWildcard) {
			result = interprete_org_emftext_language_xpath2_NamespaceWildcard((org.emftext.language.xpath2.NamespaceWildcard) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Wildcard) {
			result = interprete_org_emftext_language_xpath2_Wildcard((org.emftext.language.xpath2.Wildcard) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NameTest) {
			result = interprete_org_emftext_language_xpath2_NameTest((org.emftext.language.xpath2.NameTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NodeTest) {
			result = interprete_org_emftext_language_xpath2_NodeTest((org.emftext.language.xpath2.NodeTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Predicate) {
			result = interprete_org_emftext_language_xpath2_Predicate((org.emftext.language.xpath2.Predicate) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.StringLiteral) {
			result = interprete_org_emftext_language_xpath2_StringLiteral((org.emftext.language.xpath2.StringLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DecimalLiteral) {
			result = interprete_org_emftext_language_xpath2_DecimalLiteral((org.emftext.language.xpath2.DecimalLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Literal) {
			result = interprete_org_emftext_language_xpath2_Literal((org.emftext.language.xpath2.Literal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.VarRef) {
			result = interprete_org_emftext_language_xpath2_VarRef((org.emftext.language.xpath2.VarRef) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ContextItemExpr) {
			result = interprete_org_emftext_language_xpath2_ContextItemExpr((org.emftext.language.xpath2.ContextItemExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.FunctionCall) {
			result = interprete_org_emftext_language_xpath2_FunctionCall((org.emftext.language.xpath2.FunctionCall) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.IntegerLiteral) {
			result = interprete_org_emftext_language_xpath2_IntegerLiteral((org.emftext.language.xpath2.IntegerLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.PrimaryExpr) {
			result = interprete_org_emftext_language_xpath2_PrimaryExpr((org.emftext.language.xpath2.PrimaryExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.VarName) {
			result = interprete_org_emftext_language_xpath2_VarName((org.emftext.language.xpath2.VarName) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ParenthesizedExpr) {
			result = interprete_org_emftext_language_xpath2_ParenthesizedExpr((org.emftext.language.xpath2.ParenthesizedExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DoubleLiteral) {
			result = interprete_org_emftext_language_xpath2_DoubleLiteral((org.emftext.language.xpath2.DoubleLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NumericLiteral) {
			result = interprete_org_emftext_language_xpath2_NumericLiteral((org.emftext.language.xpath2.NumericLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.GeneralComp) {
			result = interprete_org_emftext_language_xpath2_GeneralComp((org.emftext.language.xpath2.GeneralComp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ValueComp) {
			result = interprete_org_emftext_language_xpath2_ValueComp((org.emftext.language.xpath2.ValueComp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NodeComp) {
			result = interprete_org_emftext_language_xpath2_NodeComp((org.emftext.language.xpath2.NodeComp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Comp) {
			result = interprete_org_emftext_language_xpath2_Comp((org.emftext.language.xpath2.Comp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SingleType) {
			result = interprete_org_emftext_language_xpath2_SingleType((org.emftext.language.xpath2.SingleType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AtomicType) {
			result = interprete_org_emftext_language_xpath2_AtomicType((org.emftext.language.xpath2.AtomicType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.EmptySequenceType) {
			result = interprete_org_emftext_language_xpath2_EmptySequenceType((org.emftext.language.xpath2.EmptySequenceType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ItemSequenceType) {
			result = interprete_org_emftext_language_xpath2_ItemSequenceType((org.emftext.language.xpath2.ItemSequenceType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SequenceType) {
			result = interprete_org_emftext_language_xpath2_SequenceType((org.emftext.language.xpath2.SequenceType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ItemKindTest) {
			result = interprete_org_emftext_language_xpath2_ItemKindTest((org.emftext.language.xpath2.ItemKindTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AnyItemType) {
			result = interprete_org_emftext_language_xpath2_AnyItemType((org.emftext.language.xpath2.AnyItemType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AtomicItemType) {
			result = interprete_org_emftext_language_xpath2_AtomicItemType((org.emftext.language.xpath2.AtomicItemType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ItemType) {
			result = interprete_org_emftext_language_xpath2_ItemType((org.emftext.language.xpath2.ItemType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DocumentTest) {
			result = interprete_org_emftext_language_xpath2_DocumentTest((org.emftext.language.xpath2.DocumentTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NameElementTest) {
			result = interprete_org_emftext_language_xpath2_NameElementTest((org.emftext.language.xpath2.NameElementTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.WildcardElementTest) {
			result = interprete_org_emftext_language_xpath2_WildcardElementTest((org.emftext.language.xpath2.WildcardElementTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ElementTest) {
			result = interprete_org_emftext_language_xpath2_ElementTest((org.emftext.language.xpath2.ElementTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NameAttributeTest) {
			result = interprete_org_emftext_language_xpath2_NameAttributeTest((org.emftext.language.xpath2.NameAttributeTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.WildcardAttributeTest) {
			result = interprete_org_emftext_language_xpath2_WildcardAttributeTest((org.emftext.language.xpath2.WildcardAttributeTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AttributeTest) {
			result = interprete_org_emftext_language_xpath2_AttributeTest((org.emftext.language.xpath2.AttributeTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SchemaElementTest) {
			result = interprete_org_emftext_language_xpath2_SchemaElementTest((org.emftext.language.xpath2.SchemaElementTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SchemaAttributeTest) {
			result = interprete_org_emftext_language_xpath2_SchemaAttributeTest((org.emftext.language.xpath2.SchemaAttributeTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.NCNamePITest) {
			result = interprete_org_emftext_language_xpath2_NCNamePITest((org.emftext.language.xpath2.NCNamePITest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.StringLiteralPITest) {
			result = interprete_org_emftext_language_xpath2_StringLiteralPITest((org.emftext.language.xpath2.StringLiteralPITest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.PITest) {
			result = interprete_org_emftext_language_xpath2_PITest((org.emftext.language.xpath2.PITest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.CommentTest) {
			result = interprete_org_emftext_language_xpath2_CommentTest((org.emftext.language.xpath2.CommentTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.TextTest) {
			result = interprete_org_emftext_language_xpath2_TextTest((org.emftext.language.xpath2.TextTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.AnyKindTest) {
			result = interprete_org_emftext_language_xpath2_AnyKindTest((org.emftext.language.xpath2.AnyKindTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.KindTest) {
			result = interprete_org_emftext_language_xpath2_KindTest((org.emftext.language.xpath2.KindTest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Comment) {
			result = interprete_org_emftext_language_xpath2_Comment((org.emftext.language.xpath2.Comment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.QName) {
			result = interprete_org_emftext_language_xpath2_QName((org.emftext.language.xpath2.QName) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Expr(org.emftext.language.xpath2.Expr expr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ExprSingle(org.emftext.language.xpath2.ExprSingle exprSingle, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ForExpr(org.emftext.language.xpath2.ForExpr forExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_QuantifiedExpr(org.emftext.language.xpath2.QuantifiedExpr quantifiedExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IfExpr(org.emftext.language.xpath2.IfExpr ifExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SimpleForClause(org.emftext.language.xpath2.SimpleForClause simpleForClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SimpleForClauseIterator(org.emftext.language.xpath2.SimpleForClauseIterator simpleForClauseIterator, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_OrExpr(org.emftext.language.xpath2.OrExpr orExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_OrExprChild(org.emftext.language.xpath2.OrExprChild orExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AndExpr(org.emftext.language.xpath2.AndExpr andExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AndExprChild(org.emftext.language.xpath2.AndExprChild andExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ComparisonExpr(org.emftext.language.xpath2.ComparisonExpr comparisonExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ComparisonExprChild(org.emftext.language.xpath2.ComparisonExprChild comparisonExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RangeExpr(org.emftext.language.xpath2.RangeExpr rangeExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RangeExprChild(org.emftext.language.xpath2.RangeExprChild rangeExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AdditiveExpr(org.emftext.language.xpath2.AdditiveExpr additiveExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AdditiveExprChild(org.emftext.language.xpath2.AdditiveExprChild additiveExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_MultiplicativeExpr(org.emftext.language.xpath2.MultiplicativeExpr multiplicativeExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_MultiplicativeExprChild(org.emftext.language.xpath2.MultiplicativeExprChild multiplicativeExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnionExpr(org.emftext.language.xpath2.UnionExpr unionExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnionExprChild(org.emftext.language.xpath2.UnionExprChild unionExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntersectExceptExpr(org.emftext.language.xpath2.IntersectExceptExpr intersectExceptExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntersectExceptExprChild(org.emftext.language.xpath2.IntersectExceptExprChild intersectExceptExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_InstanceofExpr(org.emftext.language.xpath2.InstanceofExpr instanceofExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_InstanceofExprChild(org.emftext.language.xpath2.InstanceofExprChild instanceofExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TreatExpr(org.emftext.language.xpath2.TreatExpr treatExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TreatExprChild(org.emftext.language.xpath2.TreatExprChild treatExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastableExpr(org.emftext.language.xpath2.CastableExpr castableExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastableExprChild(org.emftext.language.xpath2.CastableExprChild castableExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastExpr(org.emftext.language.xpath2.CastExpr castExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastExprChild(org.emftext.language.xpath2.CastExprChild castExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnaryExpr(org.emftext.language.xpath2.UnaryExpr unaryExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnaryExprChild(org.emftext.language.xpath2.UnaryExprChild unaryExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ValueExpr(org.emftext.language.xpath2.ValueExpr valueExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PathExpr(org.emftext.language.xpath2.PathExpr pathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SinglePathExpr(org.emftext.language.xpath2.SinglePathExpr singlePathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DoublePathExpr(org.emftext.language.xpath2.DoublePathExpr doublePathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RelativePathExpr(org.emftext.language.xpath2.RelativePathExpr relativePathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StepExpr(org.emftext.language.xpath2.StepExpr stepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TailPathExpr(org.emftext.language.xpath2.TailPathExpr tailPathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SingleTailPathExpr(org.emftext.language.xpath2.SingleTailPathExpr singleTailPathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DoubleTailPathExpr(org.emftext.language.xpath2.DoubleTailPathExpr doubleTailPathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_FilterExpr(org.emftext.language.xpath2.FilterExpr filterExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AxisStep(org.emftext.language.xpath2.AxisStep axisStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DirectionalStep(org.emftext.language.xpath2.DirectionalStep directionalStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ForwardStep(org.emftext.language.xpath2.ForwardStep forwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ReverseStep(org.emftext.language.xpath2.ReverseStep reverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralForwardStep(org.emftext.language.xpath2.GeneralForwardStep generalForwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AbbrevForwardStep(org.emftext.language.xpath2.AbbrevForwardStep abbrevForwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ForwardAxis(org.emftext.language.xpath2.ForwardAxis forwardAxis, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralReverseStep(org.emftext.language.xpath2.GeneralReverseStep generalReverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AbbrevReverseStep(org.emftext.language.xpath2.AbbrevReverseStep abbrevReverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ReverseAxis(org.emftext.language.xpath2.ReverseAxis reverseAxis, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeTest(org.emftext.language.xpath2.NodeTest nodeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeKindTest(org.emftext.language.xpath2.NodeKindTest nodeKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameTest(org.emftext.language.xpath2.NameTest nameTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_QNameTest(org.emftext.language.xpath2.QNameTest qNameTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Wildcard(org.emftext.language.xpath2.Wildcard wildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyWildcard(org.emftext.language.xpath2.AnyWildcard anyWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_LocalNameWildcard(org.emftext.language.xpath2.LocalNameWildcard localNameWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NamespaceWildcard(org.emftext.language.xpath2.NamespaceWildcard namespaceWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Predicate(org.emftext.language.xpath2.Predicate predicate, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PrimaryExpr(org.emftext.language.xpath2.PrimaryExpr primaryExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Literal(org.emftext.language.xpath2.Literal literal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_VarRef(org.emftext.language.xpath2.VarRef varRef, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_VarName(org.emftext.language.xpath2.VarName varName, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ParenthesizedExpr(org.emftext.language.xpath2.ParenthesizedExpr parenthesizedExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ContextItemExpr(org.emftext.language.xpath2.ContextItemExpr contextItemExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_FunctionCall(org.emftext.language.xpath2.FunctionCall functionCall, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NumericLiteral(org.emftext.language.xpath2.NumericLiteral numericLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StringLiteral(org.emftext.language.xpath2.StringLiteral stringLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntegerLiteral(org.emftext.language.xpath2.IntegerLiteral integerLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DecimalLiteral(org.emftext.language.xpath2.DecimalLiteral decimalLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DoubleLiteral(org.emftext.language.xpath2.DoubleLiteral doubleLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Comp(org.emftext.language.xpath2.Comp comp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralComp(org.emftext.language.xpath2.GeneralComp generalComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ValueComp(org.emftext.language.xpath2.ValueComp valueComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeComp(org.emftext.language.xpath2.NodeComp nodeComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SingleType(org.emftext.language.xpath2.SingleType singleType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AtomicType(org.emftext.language.xpath2.AtomicType atomicType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SequenceType(org.emftext.language.xpath2.SequenceType sequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_EmptySequenceType(org.emftext.language.xpath2.EmptySequenceType emptySequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemSequenceType(org.emftext.language.xpath2.ItemSequenceType itemSequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemType(org.emftext.language.xpath2.ItemType itemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemKindTest(org.emftext.language.xpath2.ItemKindTest itemKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyItemType(org.emftext.language.xpath2.AnyItemType anyItemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AtomicItemType(org.emftext.language.xpath2.AtomicItemType atomicItemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_KindTest(org.emftext.language.xpath2.KindTest kindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DocumentTest(org.emftext.language.xpath2.DocumentTest documentTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ElementTest(org.emftext.language.xpath2.ElementTest elementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameElementTest(org.emftext.language.xpath2.NameElementTest nameElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_WildcardElementTest(org.emftext.language.xpath2.WildcardElementTest wildcardElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AttributeTest(org.emftext.language.xpath2.AttributeTest attributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameAttributeTest(org.emftext.language.xpath2.NameAttributeTest nameAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_WildcardAttributeTest(org.emftext.language.xpath2.WildcardAttributeTest wildcardAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SchemaElementTest(org.emftext.language.xpath2.SchemaElementTest schemaElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SchemaAttributeTest(org.emftext.language.xpath2.SchemaAttributeTest schemaAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PITest(org.emftext.language.xpath2.PITest pITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NCNamePITest(org.emftext.language.xpath2.NCNamePITest nCNamePITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StringLiteralPITest(org.emftext.language.xpath2.StringLiteralPITest stringLiteralPITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CommentTest(org.emftext.language.xpath2.CommentTest commentTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TextTest(org.emftext.language.xpath2.TextTest textTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyKindTest(org.emftext.language.xpath2.AnyKindTest anyKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Comment(org.emftext.language.xpath2.Comment comment, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_QName(org.emftext.language.xpath2.QName qName, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
