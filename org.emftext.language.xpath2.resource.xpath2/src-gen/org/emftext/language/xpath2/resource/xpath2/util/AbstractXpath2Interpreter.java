/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.xpath2.AbbrevForwardStep;
import org.emftext.language.xpath2.AbbrevReverseStep;
import org.emftext.language.xpath2.AdditiveExpr;
import org.emftext.language.xpath2.AdditiveExprChild;
import org.emftext.language.xpath2.AndExpr;
import org.emftext.language.xpath2.AndExprChild;
import org.emftext.language.xpath2.AnyExpr;
import org.emftext.language.xpath2.AnyItemType;
import org.emftext.language.xpath2.AnyKindTest;
import org.emftext.language.xpath2.AnyWildcard;
import org.emftext.language.xpath2.AtomicItemType;
import org.emftext.language.xpath2.AtomicType;
import org.emftext.language.xpath2.AttributeTest;
import org.emftext.language.xpath2.AxisStep;
import org.emftext.language.xpath2.CastExpr;
import org.emftext.language.xpath2.CastExprChild;
import org.emftext.language.xpath2.CastableExpr;
import org.emftext.language.xpath2.CastableExprChild;
import org.emftext.language.xpath2.ChildStepExpr;
import org.emftext.language.xpath2.Comment;
import org.emftext.language.xpath2.CommentTest;
import org.emftext.language.xpath2.Comp;
import org.emftext.language.xpath2.ComparisonExpr;
import org.emftext.language.xpath2.ComparisonExprChild;
import org.emftext.language.xpath2.ContextItemExpr;
import org.emftext.language.xpath2.DecimalLiteral;
import org.emftext.language.xpath2.DescOrSelfStepExpr;
import org.emftext.language.xpath2.DocumentTest;
import org.emftext.language.xpath2.DoubleLiteral;
import org.emftext.language.xpath2.ElementTest;
import org.emftext.language.xpath2.EmptySequenceType;
import org.emftext.language.xpath2.Expr;
import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.FilterExpr;
import org.emftext.language.xpath2.FilterExprChild;
import org.emftext.language.xpath2.ForExpr;
import org.emftext.language.xpath2.ForwardStep;
import org.emftext.language.xpath2.FunctionCall;
import org.emftext.language.xpath2.GeneralComp;
import org.emftext.language.xpath2.GeneralForwardStep;
import org.emftext.language.xpath2.GeneralReverseStep;
import org.emftext.language.xpath2.IfExpr;
import org.emftext.language.xpath2.InstanceofExpr;
import org.emftext.language.xpath2.InstanceofExprChild;
import org.emftext.language.xpath2.IntegerLiteral;
import org.emftext.language.xpath2.IntersectExceptExpr;
import org.emftext.language.xpath2.IntersectExceptExprChild;
import org.emftext.language.xpath2.ItemKindTest;
import org.emftext.language.xpath2.ItemSequenceType;
import org.emftext.language.xpath2.ItemType;
import org.emftext.language.xpath2.Iterator;
import org.emftext.language.xpath2.KindTest;
import org.emftext.language.xpath2.Literal;
import org.emftext.language.xpath2.LocalNameWildcard;
import org.emftext.language.xpath2.MultiplicativeExpr;
import org.emftext.language.xpath2.MultiplicativeExprChild;
import org.emftext.language.xpath2.NCNamePITest;
import org.emftext.language.xpath2.NameAttributeTest;
import org.emftext.language.xpath2.NameElementTest;
import org.emftext.language.xpath2.NameTest;
import org.emftext.language.xpath2.NamespaceWildcard;
import org.emftext.language.xpath2.NodeComp;
import org.emftext.language.xpath2.NodeKindTest;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.NumericLiteral;
import org.emftext.language.xpath2.OptionalAtomicType;
import org.emftext.language.xpath2.OrExpr;
import org.emftext.language.xpath2.OrExprChild;
import org.emftext.language.xpath2.PITest;
import org.emftext.language.xpath2.ParenthesizedExpr;
import org.emftext.language.xpath2.ParenthesizedExprChild;
import org.emftext.language.xpath2.PathExpr;
import org.emftext.language.xpath2.PathExprChild;
import org.emftext.language.xpath2.Predicate;
import org.emftext.language.xpath2.PrimaryExpr;
import org.emftext.language.xpath2.QNameTest;
import org.emftext.language.xpath2.QuantifiedExpr;
import org.emftext.language.xpath2.RangeExpr;
import org.emftext.language.xpath2.RangeExprChild;
import org.emftext.language.xpath2.ReverseStep;
import org.emftext.language.xpath2.RootStepExpr;
import org.emftext.language.xpath2.SchemaAttributeTest;
import org.emftext.language.xpath2.SchemaElementTest;
import org.emftext.language.xpath2.SelfStepExpr;
import org.emftext.language.xpath2.SequenceType;
import org.emftext.language.xpath2.SingleType;
import org.emftext.language.xpath2.StepExpr;
import org.emftext.language.xpath2.StepExprChild;
import org.emftext.language.xpath2.StringLiteral;
import org.emftext.language.xpath2.StringLiteralPITest;
import org.emftext.language.xpath2.TextTest;
import org.emftext.language.xpath2.TreatExpr;
import org.emftext.language.xpath2.TreatExprChild;
import org.emftext.language.xpath2.UnaryExpr;
import org.emftext.language.xpath2.UnaryExprChild;
import org.emftext.language.xpath2.UnionExpr;
import org.emftext.language.xpath2.UnionExprChild;
import org.emftext.language.xpath2.ValueComp;
import org.emftext.language.xpath2.ValueExpr;
import org.emftext.language.xpath2.VarRef;
import org.emftext.language.xpath2.Wildcard;
import org.emftext.language.xpath2.WildcardAttributeTest;
import org.emftext.language.xpath2.WildcardElementTest;

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
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener> listeners = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener>();
	private EObject nextObjectToInterprete;
	private ContextType currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (EmptyStackException ese) {
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
	
	public ResultType interprete(EObject object, ContextType context) {
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
		if (object instanceof org.emftext.language.xpath2.OrExpr) {
			result = interprete_org_emftext_language_xpath2_OrExpr((org.emftext.language.xpath2.OrExpr) object, context);
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
		if (object instanceof org.emftext.language.xpath2.AnyExpr) {
			result = interprete_org_emftext_language_xpath2_AnyExpr((org.emftext.language.xpath2.AnyExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.Iterator) {
			result = interprete_org_emftext_language_xpath2_Iterator((org.emftext.language.xpath2.Iterator) object, context);
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
		if (object instanceof org.emftext.language.xpath2.RootStepExpr) {
			result = interprete_org_emftext_language_xpath2_RootStepExpr((org.emftext.language.xpath2.RootStepExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ChildStepExpr) {
			result = interprete_org_emftext_language_xpath2_ChildStepExpr((org.emftext.language.xpath2.ChildStepExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.DescOrSelfStepExpr) {
			result = interprete_org_emftext_language_xpath2_DescOrSelfStepExpr((org.emftext.language.xpath2.DescOrSelfStepExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.SelfStepExpr) {
			result = interprete_org_emftext_language_xpath2_SelfStepExpr((org.emftext.language.xpath2.SelfStepExpr) object, context);
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
		if (object instanceof org.emftext.language.xpath2.ReverseStep) {
			result = interprete_org_emftext_language_xpath2_ReverseStep((org.emftext.language.xpath2.ReverseStep) object, context);
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
		if (object instanceof org.emftext.language.xpath2.AbbrevReverseStep) {
			result = interprete_org_emftext_language_xpath2_AbbrevReverseStep((org.emftext.language.xpath2.AbbrevReverseStep) object, context);
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
		if (object instanceof org.emftext.language.xpath2.FilterExprChild) {
			result = interprete_org_emftext_language_xpath2_FilterExprChild((org.emftext.language.xpath2.FilterExprChild) object, context);
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
		if (object instanceof org.emftext.language.xpath2.ForwardStep) {
			result = interprete_org_emftext_language_xpath2_ForwardStep((org.emftext.language.xpath2.ForwardStep) object, context);
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
		if (object instanceof org.emftext.language.xpath2.AxisStep) {
			result = interprete_org_emftext_language_xpath2_AxisStep((org.emftext.language.xpath2.AxisStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.StepExprChild) {
			result = interprete_org_emftext_language_xpath2_StepExprChild((org.emftext.language.xpath2.StepExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.PathExprChild) {
			result = interprete_org_emftext_language_xpath2_PathExprChild((org.emftext.language.xpath2.PathExprChild) object, context);
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
		if (object instanceof org.emftext.language.xpath2.TreatExprChild) {
			result = interprete_org_emftext_language_xpath2_TreatExprChild((org.emftext.language.xpath2.TreatExprChild) object, context);
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
		if (object instanceof org.emftext.language.xpath2.ParenthesizedExpr) {
			result = interprete_org_emftext_language_xpath2_ParenthesizedExpr((org.emftext.language.xpath2.ParenthesizedExpr) object, context);
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
		if (object instanceof org.emftext.language.xpath2.PrimaryExpr) {
			result = interprete_org_emftext_language_xpath2_PrimaryExpr((org.emftext.language.xpath2.PrimaryExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.xpath2.ParenthesizedExprChild) {
			result = interprete_org_emftext_language_xpath2_ParenthesizedExprChild((org.emftext.language.xpath2.ParenthesizedExprChild) object, context);
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
		if (object instanceof org.emftext.language.xpath2.OptionalAtomicType) {
			result = interprete_org_emftext_language_xpath2_OptionalAtomicType((org.emftext.language.xpath2.OptionalAtomicType) object, context);
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
		return result;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyExpr(AnyExpr anyExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Expr(Expr expr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ExprSingle(ExprSingle exprSingle, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ForExpr(ForExpr forExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_QuantifiedExpr(QuantifiedExpr quantifiedExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IfExpr(IfExpr ifExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Iterator(Iterator iterator, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_OrExpr(OrExpr orExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_OrExprChild(OrExprChild orExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AndExpr(AndExpr andExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AndExprChild(AndExprChild andExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ComparisonExpr(ComparisonExpr comparisonExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ComparisonExprChild(ComparisonExprChild comparisonExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RangeExpr(RangeExpr rangeExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RangeExprChild(RangeExprChild rangeExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AdditiveExpr(AdditiveExpr additiveExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AdditiveExprChild(AdditiveExprChild additiveExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_MultiplicativeExpr(MultiplicativeExpr multiplicativeExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_MultiplicativeExprChild(MultiplicativeExprChild multiplicativeExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnionExpr(UnionExpr unionExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnionExprChild(UnionExprChild unionExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntersectExceptExpr(IntersectExceptExpr intersectExceptExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntersectExceptExprChild(IntersectExceptExprChild intersectExceptExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_InstanceofExpr(InstanceofExpr instanceofExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_InstanceofExprChild(InstanceofExprChild instanceofExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TreatExpr(TreatExpr treatExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TreatExprChild(TreatExprChild treatExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastableExpr(CastableExpr castableExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastableExprChild(CastableExprChild castableExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastExpr(CastExpr castExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CastExprChild(CastExprChild castExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnaryExpr(UnaryExpr unaryExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_UnaryExprChild(UnaryExprChild unaryExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ValueExpr(ValueExpr valueExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PathExpr(PathExpr pathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PathExprChild(PathExprChild pathExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_RootStepExpr(RootStepExpr rootStepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ChildStepExpr(ChildStepExpr childStepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DescOrSelfStepExpr(DescOrSelfStepExpr descOrSelfStepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SelfStepExpr(SelfStepExpr selfStepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StepExprChild(StepExprChild stepExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StepExpr(StepExpr stepExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_FilterExpr(FilterExpr filterExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_FilterExprChild(FilterExprChild filterExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AxisStep(AxisStep axisStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ForwardStep(ForwardStep forwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ReverseStep(ReverseStep reverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralForwardStep(GeneralForwardStep generalForwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AbbrevForwardStep(AbbrevForwardStep abbrevForwardStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralReverseStep(GeneralReverseStep generalReverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AbbrevReverseStep(AbbrevReverseStep abbrevReverseStep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeTest(NodeTest nodeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeKindTest(NodeKindTest nodeKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameTest(NameTest nameTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_QNameTest(QNameTest qNameTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Wildcard(Wildcard wildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyWildcard(AnyWildcard anyWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_LocalNameWildcard(LocalNameWildcard localNameWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NamespaceWildcard(NamespaceWildcard namespaceWildcard, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Predicate(Predicate predicate, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PrimaryExpr(PrimaryExpr primaryExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Literal(Literal literal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_VarRef(VarRef varRef, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ParenthesizedExpr(ParenthesizedExpr parenthesizedExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ParenthesizedExprChild(ParenthesizedExprChild parenthesizedExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ContextItemExpr(ContextItemExpr contextItemExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_FunctionCall(FunctionCall functionCall, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NumericLiteral(NumericLiteral numericLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StringLiteral(StringLiteral stringLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_IntegerLiteral(IntegerLiteral integerLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DecimalLiteral(DecimalLiteral decimalLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DoubleLiteral(DoubleLiteral doubleLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Comp(Comp comp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_GeneralComp(GeneralComp generalComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ValueComp(ValueComp valueComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NodeComp(NodeComp nodeComp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SingleType(SingleType singleType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AtomicType(AtomicType atomicType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_OptionalAtomicType(OptionalAtomicType optionalAtomicType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SequenceType(SequenceType sequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_EmptySequenceType(EmptySequenceType emptySequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemSequenceType(ItemSequenceType itemSequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemType(ItemType itemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ItemKindTest(ItemKindTest itemKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyItemType(AnyItemType anyItemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AtomicItemType(AtomicItemType atomicItemType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_KindTest(KindTest kindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_DocumentTest(DocumentTest documentTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_ElementTest(ElementTest elementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameElementTest(NameElementTest nameElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_WildcardElementTest(WildcardElementTest wildcardElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AttributeTest(AttributeTest attributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NameAttributeTest(NameAttributeTest nameAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_WildcardAttributeTest(WildcardAttributeTest wildcardAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SchemaElementTest(SchemaElementTest schemaElementTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_SchemaAttributeTest(SchemaAttributeTest schemaAttributeTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_PITest(PITest pITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_NCNamePITest(NCNamePITest nCNamePITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_StringLiteralPITest(StringLiteralPITest stringLiteralPITest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_CommentTest(CommentTest commentTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_TextTest(TextTest textTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_AnyKindTest(AnyKindTest anyKindTest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_xpath2_Comment(Comment comment, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.emftext.language.xpath2.resource.xpath2.IXpath2InterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(Collection<? extends EObject> objects) {
		for (EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(Collection<? extends EObject> objects) {
		List<EObject> reverse = new ArrayList<EObject>(objects.size());
		reverse.addAll(objects);
		Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(EObject root) {
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(root);
		java.util.Iterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
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
	
	public EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public Stack<EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public ContextType getCurrentContext() {
		return currentContext;
	}
	
}
