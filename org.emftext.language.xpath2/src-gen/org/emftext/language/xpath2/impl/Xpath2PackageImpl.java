/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.xpath2.AbbrevForwardStep;
import org.emftext.language.xpath2.AbbrevForwardStepKind;
import org.emftext.language.xpath2.AbbrevReverseStep;
import org.emftext.language.xpath2.AbbrevReverseStepKind;
import org.emftext.language.xpath2.AdditiveExpr;
import org.emftext.language.xpath2.AdditiveExprChild;
import org.emftext.language.xpath2.AdditiveOpKind;
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
import org.emftext.language.xpath2.DirectionalStep;
import org.emftext.language.xpath2.DocumentTest;
import org.emftext.language.xpath2.DoubleLiteral;
import org.emftext.language.xpath2.ElementTest;
import org.emftext.language.xpath2.EmptySequenceType;
import org.emftext.language.xpath2.Expr;
import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.FilterExpr;
import org.emftext.language.xpath2.FilterExprChild;
import org.emftext.language.xpath2.ForExpr;
import org.emftext.language.xpath2.ForwardAxisKind;
import org.emftext.language.xpath2.ForwardStep;
import org.emftext.language.xpath2.FunctionCall;
import org.emftext.language.xpath2.GeneralComp;
import org.emftext.language.xpath2.GeneralCompKind;
import org.emftext.language.xpath2.GeneralForwardStep;
import org.emftext.language.xpath2.GeneralReverseStep;
import org.emftext.language.xpath2.IfExpr;
import org.emftext.language.xpath2.InstanceofExpr;
import org.emftext.language.xpath2.InstanceofExprChild;
import org.emftext.language.xpath2.IntegerLiteral;
import org.emftext.language.xpath2.IntersectExceptExpr;
import org.emftext.language.xpath2.IntersectExceptExprChild;
import org.emftext.language.xpath2.IntersectExceptOpKind;
import org.emftext.language.xpath2.ItemKindTest;
import org.emftext.language.xpath2.ItemSequenceType;
import org.emftext.language.xpath2.ItemType;
import org.emftext.language.xpath2.Iterator;
import org.emftext.language.xpath2.KindTest;
import org.emftext.language.xpath2.Literal;
import org.emftext.language.xpath2.LocalNameWildcard;
import org.emftext.language.xpath2.MultiplicativeExpr;
import org.emftext.language.xpath2.MultiplicativeExprChild;
import org.emftext.language.xpath2.MultiplicativeOpKind;
import org.emftext.language.xpath2.NCNamePITest;
import org.emftext.language.xpath2.NameAttributeTest;
import org.emftext.language.xpath2.NameElementTest;
import org.emftext.language.xpath2.NameTest;
import org.emftext.language.xpath2.NamespaceWildcard;
import org.emftext.language.xpath2.NodeComp;
import org.emftext.language.xpath2.NodeCompKind;
import org.emftext.language.xpath2.NodeKindTest;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.NumericLiteral;
import org.emftext.language.xpath2.OccurrenceIndicatorKind;
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
import org.emftext.language.xpath2.QName;
import org.emftext.language.xpath2.QNameTest;
import org.emftext.language.xpath2.QuantifiedExpr;
import org.emftext.language.xpath2.QuantifierKind;
import org.emftext.language.xpath2.RangeExpr;
import org.emftext.language.xpath2.RangeExprChild;
import org.emftext.language.xpath2.ReverseAxisKind;
import org.emftext.language.xpath2.ReverseStep;
import org.emftext.language.xpath2.RootStepExpr;
import org.emftext.language.xpath2.SchemaAttributeTest;
import org.emftext.language.xpath2.SchemaElementTest;
import org.emftext.language.xpath2.SelfStepExpr;
import org.emftext.language.xpath2.SelfStepExprChild;
import org.emftext.language.xpath2.SequenceType;
import org.emftext.language.xpath2.SingleType;
import org.emftext.language.xpath2.StepExpr;
import org.emftext.language.xpath2.StringLiteral;
import org.emftext.language.xpath2.StringLiteralPITest;
import org.emftext.language.xpath2.TextTest;
import org.emftext.language.xpath2.TreatExpr;
import org.emftext.language.xpath2.TreatExprChild;
import org.emftext.language.xpath2.UnaryExpr;
import org.emftext.language.xpath2.UnaryExprChild;
import org.emftext.language.xpath2.UnaryOp;
import org.emftext.language.xpath2.UnionExpr;
import org.emftext.language.xpath2.UnionExprChild;
import org.emftext.language.xpath2.UnionOp;
import org.emftext.language.xpath2.ValueComp;
import org.emftext.language.xpath2.ValueExpr;
import org.emftext.language.xpath2.VarName;
import org.emftext.language.xpath2.VarRef;
import org.emftext.language.xpath2.Wildcard;
import org.emftext.language.xpath2.WildcardAttributeTest;
import org.emftext.language.xpath2.WildcardElementTest;
import org.emftext.language.xpath2.Xpath2Factory;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xpath2PackageImpl extends EPackageImpl implements Xpath2Package {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass anyExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass exprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass exprSingleEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass forExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass quantifiedExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass ifExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass iteratorEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass orExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass orExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass andExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass andExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass comparisonExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass comparisonExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass rangeExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass rangeExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass additiveExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass additiveExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass multiplicativeExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass multiplicativeExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass unionExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass unionExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass intersectExceptExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass intersectExceptExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass instanceofExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass instanceofExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass treatExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass treatExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass castableExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass castableExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass castExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass castExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass unaryExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass unaryExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass valueExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass pathExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass pathExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass rootStepExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass childStepExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass descOrSelfStepExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass selfStepExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass selfStepExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass stepExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass filterExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass filterExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass axisStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass directionalStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass forwardStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass reverseStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass generalForwardStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass abbrevForwardStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass generalReverseStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass abbrevReverseStepEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nodeTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nodeKindTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nameTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass qNameTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass wildcardEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass anyWildcardEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass localNameWildcardEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass namespaceWildcardEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass predicateEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass primaryExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass literalEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass varRefEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass varNameEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass parenthesizedExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass parenthesizedExprChildEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass contextItemExprEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass functionCallEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass numericLiteralEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass stringLiteralEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass integerLiteralEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass decimalLiteralEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass doubleLiteralEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass compEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass generalCompEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass valueCompEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nodeCompEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass singleTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass atomicTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass optionalAtomicTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass sequenceTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass emptySequenceTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass itemSequenceTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass itemTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass itemKindTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass anyItemTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass atomicItemTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass kindTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass documentTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass elementTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nameElementTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass wildcardElementTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass attributeTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nameAttributeTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass wildcardAttributeTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass schemaElementTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass schemaAttributeTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass piTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass ncNamePITestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass stringLiteralPITestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass commentTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass textTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass anyKindTestEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass commentEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass qNameEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum forwardAxisKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum abbrevForwardStepKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum reverseAxisKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum abbrevReverseStepKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum unionOpEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum additiveOpKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum multiplicativeOpKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum quantifierKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum intersectExceptOpKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum unaryOpEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum generalCompKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum nodeCompKindEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum occurrenceIndicatorKindEEnum = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.emftext.language.xpath2.Xpath2Package#eNS_URI
   * @see #init()
   * @generated
   */
	private Xpath2PackageImpl() {
    super(eNS_URI, Xpath2Factory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Xpath2Package#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static Xpath2Package init() {
    if (isInited) return (Xpath2Package)EPackage.Registry.INSTANCE.getEPackage(Xpath2Package.eNS_URI);

    // Obtain or create and register package
    Xpath2PackageImpl theXpath2Package = (Xpath2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Xpath2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Xpath2PackageImpl());

    isInited = true;

    // Create package meta-data objects
    theXpath2Package.createPackageContents();

    // Initialize created meta-data
    theXpath2Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theXpath2Package.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Xpath2Package.eNS_URI, theXpath2Package);
    return theXpath2Package;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAnyExpr() {
    return anyExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getExpr() {
    return exprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getExpr_Expr() {
    return (EReference)exprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getExprSingle() {
    return exprSingleEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getForExpr() {
    return forExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getForExpr_Iterator() {
    return (EReference)forExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getForExpr_Return() {
    return (EReference)forExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getQuantifiedExpr() {
    return quantifiedExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getQuantifiedExpr_Quantifier() {
    return (EAttribute)quantifiedExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getQuantifiedExpr_Iterator() {
    return (EReference)quantifiedExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getQuantifiedExpr_Satisfies() {
    return (EReference)quantifiedExprEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIfExpr() {
    return ifExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIfExpr_Test() {
    return (EReference)ifExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIfExpr_Then() {
    return (EReference)ifExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIfExpr_Else() {
    return (EReference)ifExprEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIterator() {
    return iteratorEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIterator_VarName() {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIterator_List() {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getOrExpr() {
    return orExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getOrExpr_Operand() {
    return (EReference)orExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getOrExprChild() {
    return orExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAndExpr() {
    return andExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAndExpr_Operand() {
    return (EReference)andExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAndExprChild() {
    return andExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getComparisonExpr() {
    return comparisonExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getComparisonExpr_Left() {
    return (EReference)comparisonExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getComparisonExpr_Operator() {
    return (EReference)comparisonExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getComparisonExpr_Right() {
    return (EReference)comparisonExprEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getComparisonExprChild() {
    return comparisonExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRangeExpr() {
    return rangeExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getRangeExpr_From() {
    return (EReference)rangeExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getRangeExpr_To() {
    return (EReference)rangeExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRangeExprChild() {
    return rangeExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAdditiveExpr() {
    return additiveExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAdditiveExpr_Operand() {
    return (EReference)additiveExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAdditiveExpr_Operator() {
    return (EAttribute)additiveExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAdditiveExprChild() {
    return additiveExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getMultiplicativeExpr() {
    return multiplicativeExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getMultiplicativeExpr_Operand() {
    return (EReference)multiplicativeExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getMultiplicativeExpr_Operator() {
    return (EAttribute)multiplicativeExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getMultiplicativeExprChild() {
    return multiplicativeExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getUnionExpr() {
    return unionExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getUnionExpr_Operand() {
    return (EReference)unionExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getUnionExpr_Operation() {
    return (EAttribute)unionExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getUnionExprChild() {
    return unionExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIntersectExceptExpr() {
    return intersectExceptExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIntersectExceptExpr_Operand() {
    return (EReference)intersectExceptExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIntersectExceptExpr_Operator() {
    return (EAttribute)intersectExceptExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIntersectExceptExprChild() {
    return intersectExceptExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getInstanceofExpr() {
    return instanceofExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getInstanceofExpr_Operand() {
    return (EReference)instanceofExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getInstanceofExpr_Type() {
    return (EReference)instanceofExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getInstanceofExprChild() {
    return instanceofExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getTreatExpr() {
    return treatExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getTreatExpr_Operand() {
    return (EReference)treatExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getTreatExpr_Type() {
    return (EReference)treatExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getTreatExprChild() {
    return treatExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCastableExpr() {
    return castableExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCastableExpr_Operand() {
    return (EReference)castableExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCastableExpr_Type() {
    return (EReference)castableExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCastableExprChild() {
    return castableExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCastExpr() {
    return castExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCastExpr_Operand() {
    return (EReference)castExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCastExpr_Type() {
    return (EReference)castExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCastExprChild() {
    return castExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getUnaryExpr() {
    return unaryExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getUnaryExpr_Operand() {
    return (EReference)unaryExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getUnaryExpr_Operator() {
    return (EAttribute)unaryExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getUnaryExprChild() {
    return unaryExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getValueExpr() {
    return valueExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPathExpr() {
    return pathExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getPathExpr_Step() {
    return (EReference)pathExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPathExprChild() {
    return pathExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRootStepExpr() {
    return rootStepExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getChildStepExpr() {
    return childStepExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getChildStepExpr_Step() {
    return (EReference)childStepExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDescOrSelfStepExpr() {
    return descOrSelfStepExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getDescOrSelfStepExpr_Step() {
    return (EReference)descOrSelfStepExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSelfStepExpr() {
    return selfStepExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getSelfStepExpr_Step() {
    return (EReference)selfStepExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSelfStepExprChild() {
    return selfStepExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getStepExpr() {
    return stepExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getFilterExpr() {
    return filterExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getFilterExpr_PrimaryExpr() {
    return (EReference)filterExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getFilterExpr_Predicate() {
    return (EReference)filterExprEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getFilterExprChild() {
    return filterExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAxisStep() {
    return axisStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAxisStep_Step() {
    return (EReference)axisStepEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAxisStep_Predicate() {
    return (EReference)axisStepEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDirectionalStep() {
    return directionalStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getForwardStep() {
    return forwardStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getReverseStep() {
    return reverseStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getGeneralForwardStep() {
    return generalForwardStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getGeneralForwardStep_Axis() {
    return (EAttribute)generalForwardStepEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getGeneralForwardStep_NodeTest() {
    return (EReference)generalForwardStepEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAbbrevForwardStep() {
    return abbrevForwardStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAbbrevForwardStep_Kind() {
    return (EAttribute)abbrevForwardStepEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAbbrevForwardStep_NodeTest() {
    return (EReference)abbrevForwardStepEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getGeneralReverseStep() {
    return generalReverseStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getGeneralReverseStep_Axis() {
    return (EAttribute)generalReverseStepEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getGeneralReverseStep_NodeTest() {
    return (EReference)generalReverseStepEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAbbrevReverseStep() {
    return abbrevReverseStepEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAbbrevReverseStep_Kind() {
    return (EAttribute)abbrevReverseStepEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNodeTest() {
    return nodeTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNodeKindTest() {
    return nodeKindTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getNodeKindTest_Test() {
    return (EReference)nodeKindTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNameTest() {
    return nameTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getQNameTest() {
    return qNameTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getQNameTest_Name() {
    return (EReference)qNameTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getWildcard() {
    return wildcardEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAnyWildcard() {
    return anyWildcardEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getLocalNameWildcard() {
    return localNameWildcardEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getLocalNameWildcard_Namespace() {
    return (EAttribute)localNameWildcardEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNamespaceWildcard() {
    return namespaceWildcardEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getNamespaceWildcard_LocalName() {
    return (EAttribute)namespaceWildcardEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPredicate() {
    return predicateEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getPredicate_Expr() {
    return (EReference)predicateEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPrimaryExpr() {
    return primaryExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getLiteral() {
    return literalEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getVarRef() {
    return varRefEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getVarRef_VarName() {
    return (EReference)varRefEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getVarName() {
    return varNameEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getParenthesizedExpr() {
    return parenthesizedExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getParenthesizedExpr_Expr() {
    return (EReference)parenthesizedExprEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getParenthesizedExprChild() {
    return parenthesizedExprChildEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getContextItemExpr() {
    return contextItemExprEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getFunctionCall() {
    return functionCallEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getFunctionCall_Name() {
    return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getFunctionCall_Arg() {
    return (EReference)functionCallEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNumericLiteral() {
    return numericLiteralEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getStringLiteral() {
    return stringLiteralEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getStringLiteral_Value() {
    return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIntegerLiteral() {
    return integerLiteralEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIntegerLiteral_Value() {
    return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDecimalLiteral() {
    return decimalLiteralEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDecimalLiteral_Value() {
    return (EAttribute)decimalLiteralEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDoubleLiteral() {
    return doubleLiteralEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDoubleLiteral_Value() {
    return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getComp() {
    return compEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getGeneralComp() {
    return generalCompEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getGeneralComp_Operator() {
    return (EAttribute)generalCompEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getValueComp() {
    return valueCompEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getValueComp_Operator() {
    return (EAttribute)valueCompEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNodeComp() {
    return nodeCompEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getNodeComp_Operator() {
    return (EAttribute)nodeCompEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSingleType() {
    return singleTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getSingleType_Type() {
    return (EReference)singleTypeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getSingleType_Optional() {
    return (EAttribute)singleTypeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAtomicType() {
    return atomicTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getOptionalAtomicType() {
    return optionalAtomicTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getOptionalAtomicType_Optional() {
    return (EAttribute)optionalAtomicTypeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSequenceType() {
    return sequenceTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getEmptySequenceType() {
    return emptySequenceTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getItemSequenceType() {
    return itemSequenceTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getItemSequenceType_ItemType() {
    return (EReference)itemSequenceTypeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getItemSequenceType_Occurrence() {
    return (EAttribute)itemSequenceTypeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getItemType() {
    return itemTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getItemKindTest() {
    return itemKindTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getItemKindTest_Test() {
    return (EReference)itemKindTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAnyItemType() {
    return anyItemTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAtomicItemType() {
    return atomicItemTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAtomicItemType_Type() {
    return (EReference)atomicItemTypeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getKindTest() {
    return kindTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDocumentTest() {
    return documentTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getDocumentTest_Test() {
    return (EReference)documentTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getElementTest() {
    return elementTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNameElementTest() {
    return nameElementTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getNameElementTest_Name() {
    return (EReference)nameElementTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getNameElementTest_Type() {
    return (EReference)nameElementTestEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getWildcardElementTest() {
    return wildcardElementTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getWildcardElementTest_Type() {
    return (EReference)wildcardElementTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAttributeTest() {
    return attributeTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNameAttributeTest() {
    return nameAttributeTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getNameAttributeTest_Name() {
    return (EReference)nameAttributeTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getNameAttributeTest_Type() {
    return (EReference)nameAttributeTestEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getWildcardAttributeTest() {
    return wildcardAttributeTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getWildcardAttributeTest_Type() {
    return (EReference)wildcardAttributeTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSchemaElementTest() {
    return schemaElementTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getSchemaElementTest_Name() {
    return (EReference)schemaElementTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSchemaAttributeTest() {
    return schemaAttributeTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getSchemaAttributeTest_Name() {
    return (EReference)schemaAttributeTestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPITest() {
    return piTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getNCNamePITest() {
    return ncNamePITestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getNCNamePITest_Name() {
    return (EAttribute)ncNamePITestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getStringLiteralPITest() {
    return stringLiteralPITestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getStringLiteralPITest_Literal() {
    return (EReference)stringLiteralPITestEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCommentTest() {
    return commentTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getTextTest() {
    return textTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAnyKindTest() {
    return anyKindTestEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getComment() {
    return commentEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getComment_Text() {
    return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getComment_Comment() {
    return (EReference)commentEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getQName() {
    return qNameEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getQName_Name() {
    return (EAttribute)qNameEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getQName_Prefix() {
    return (EAttribute)qNameEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getForwardAxisKind() {
    return forwardAxisKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getAbbrevForwardStepKind() {
    return abbrevForwardStepKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getReverseAxisKind() {
    return reverseAxisKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getAbbrevReverseStepKind() {
    return abbrevReverseStepKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getUnionOp() {
    return unionOpEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getAdditiveOpKind() {
    return additiveOpKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getMultiplicativeOpKind() {
    return multiplicativeOpKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getQuantifierKind() {
    return quantifierKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getIntersectExceptOpKind() {
    return intersectExceptOpKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getUnaryOp() {
    return unaryOpEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getGeneralCompKind() {
    return generalCompKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getNodeCompKind() {
    return nodeCompKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getOccurrenceIndicatorKind() {
    return occurrenceIndicatorKindEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Xpath2Factory getXpath2Factory() {
    return (Xpath2Factory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    anyExprEClass = createEClass(ANY_EXPR);

    exprEClass = createEClass(EXPR);
    createEReference(exprEClass, EXPR__EXPR);

    exprSingleEClass = createEClass(EXPR_SINGLE);

    forExprEClass = createEClass(FOR_EXPR);
    createEReference(forExprEClass, FOR_EXPR__ITERATOR);
    createEReference(forExprEClass, FOR_EXPR__RETURN);

    quantifiedExprEClass = createEClass(QUANTIFIED_EXPR);
    createEAttribute(quantifiedExprEClass, QUANTIFIED_EXPR__QUANTIFIER);
    createEReference(quantifiedExprEClass, QUANTIFIED_EXPR__ITERATOR);
    createEReference(quantifiedExprEClass, QUANTIFIED_EXPR__SATISFIES);

    ifExprEClass = createEClass(IF_EXPR);
    createEReference(ifExprEClass, IF_EXPR__TEST);
    createEReference(ifExprEClass, IF_EXPR__THEN);
    createEReference(ifExprEClass, IF_EXPR__ELSE);

    iteratorEClass = createEClass(ITERATOR);
    createEReference(iteratorEClass, ITERATOR__VAR_NAME);
    createEReference(iteratorEClass, ITERATOR__LIST);

    orExprEClass = createEClass(OR_EXPR);
    createEReference(orExprEClass, OR_EXPR__OPERAND);

    orExprChildEClass = createEClass(OR_EXPR_CHILD);

    andExprEClass = createEClass(AND_EXPR);
    createEReference(andExprEClass, AND_EXPR__OPERAND);

    andExprChildEClass = createEClass(AND_EXPR_CHILD);

    comparisonExprEClass = createEClass(COMPARISON_EXPR);
    createEReference(comparisonExprEClass, COMPARISON_EXPR__LEFT);
    createEReference(comparisonExprEClass, COMPARISON_EXPR__OPERATOR);
    createEReference(comparisonExprEClass, COMPARISON_EXPR__RIGHT);

    comparisonExprChildEClass = createEClass(COMPARISON_EXPR_CHILD);

    rangeExprEClass = createEClass(RANGE_EXPR);
    createEReference(rangeExprEClass, RANGE_EXPR__FROM);
    createEReference(rangeExprEClass, RANGE_EXPR__TO);

    rangeExprChildEClass = createEClass(RANGE_EXPR_CHILD);

    additiveExprEClass = createEClass(ADDITIVE_EXPR);
    createEReference(additiveExprEClass, ADDITIVE_EXPR__OPERAND);
    createEAttribute(additiveExprEClass, ADDITIVE_EXPR__OPERATOR);

    additiveExprChildEClass = createEClass(ADDITIVE_EXPR_CHILD);

    multiplicativeExprEClass = createEClass(MULTIPLICATIVE_EXPR);
    createEReference(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__OPERAND);
    createEAttribute(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__OPERATOR);

    multiplicativeExprChildEClass = createEClass(MULTIPLICATIVE_EXPR_CHILD);

    unionExprEClass = createEClass(UNION_EXPR);
    createEReference(unionExprEClass, UNION_EXPR__OPERAND);
    createEAttribute(unionExprEClass, UNION_EXPR__OPERATION);

    unionExprChildEClass = createEClass(UNION_EXPR_CHILD);

    intersectExceptExprEClass = createEClass(INTERSECT_EXCEPT_EXPR);
    createEReference(intersectExceptExprEClass, INTERSECT_EXCEPT_EXPR__OPERAND);
    createEAttribute(intersectExceptExprEClass, INTERSECT_EXCEPT_EXPR__OPERATOR);

    intersectExceptExprChildEClass = createEClass(INTERSECT_EXCEPT_EXPR_CHILD);

    instanceofExprEClass = createEClass(INSTANCEOF_EXPR);
    createEReference(instanceofExprEClass, INSTANCEOF_EXPR__OPERAND);
    createEReference(instanceofExprEClass, INSTANCEOF_EXPR__TYPE);

    instanceofExprChildEClass = createEClass(INSTANCEOF_EXPR_CHILD);

    treatExprEClass = createEClass(TREAT_EXPR);
    createEReference(treatExprEClass, TREAT_EXPR__OPERAND);
    createEReference(treatExprEClass, TREAT_EXPR__TYPE);

    treatExprChildEClass = createEClass(TREAT_EXPR_CHILD);

    castableExprEClass = createEClass(CASTABLE_EXPR);
    createEReference(castableExprEClass, CASTABLE_EXPR__OPERAND);
    createEReference(castableExprEClass, CASTABLE_EXPR__TYPE);

    castableExprChildEClass = createEClass(CASTABLE_EXPR_CHILD);

    castExprEClass = createEClass(CAST_EXPR);
    createEReference(castExprEClass, CAST_EXPR__OPERAND);
    createEReference(castExprEClass, CAST_EXPR__TYPE);

    castExprChildEClass = createEClass(CAST_EXPR_CHILD);

    unaryExprEClass = createEClass(UNARY_EXPR);
    createEReference(unaryExprEClass, UNARY_EXPR__OPERAND);
    createEAttribute(unaryExprEClass, UNARY_EXPR__OPERATOR);

    unaryExprChildEClass = createEClass(UNARY_EXPR_CHILD);

    valueExprEClass = createEClass(VALUE_EXPR);

    pathExprEClass = createEClass(PATH_EXPR);
    createEReference(pathExprEClass, PATH_EXPR__STEP);

    pathExprChildEClass = createEClass(PATH_EXPR_CHILD);

    rootStepExprEClass = createEClass(ROOT_STEP_EXPR);

    childStepExprEClass = createEClass(CHILD_STEP_EXPR);
    createEReference(childStepExprEClass, CHILD_STEP_EXPR__STEP);

    descOrSelfStepExprEClass = createEClass(DESC_OR_SELF_STEP_EXPR);
    createEReference(descOrSelfStepExprEClass, DESC_OR_SELF_STEP_EXPR__STEP);

    selfStepExprEClass = createEClass(SELF_STEP_EXPR);
    createEReference(selfStepExprEClass, SELF_STEP_EXPR__STEP);

    selfStepExprChildEClass = createEClass(SELF_STEP_EXPR_CHILD);

    stepExprEClass = createEClass(STEP_EXPR);

    filterExprEClass = createEClass(FILTER_EXPR);
    createEReference(filterExprEClass, FILTER_EXPR__PRIMARY_EXPR);
    createEReference(filterExprEClass, FILTER_EXPR__PREDICATE);

    filterExprChildEClass = createEClass(FILTER_EXPR_CHILD);

    axisStepEClass = createEClass(AXIS_STEP);
    createEReference(axisStepEClass, AXIS_STEP__STEP);
    createEReference(axisStepEClass, AXIS_STEP__PREDICATE);

    directionalStepEClass = createEClass(DIRECTIONAL_STEP);

    forwardStepEClass = createEClass(FORWARD_STEP);

    reverseStepEClass = createEClass(REVERSE_STEP);

    generalForwardStepEClass = createEClass(GENERAL_FORWARD_STEP);
    createEAttribute(generalForwardStepEClass, GENERAL_FORWARD_STEP__AXIS);
    createEReference(generalForwardStepEClass, GENERAL_FORWARD_STEP__NODE_TEST);

    abbrevForwardStepEClass = createEClass(ABBREV_FORWARD_STEP);
    createEAttribute(abbrevForwardStepEClass, ABBREV_FORWARD_STEP__KIND);
    createEReference(abbrevForwardStepEClass, ABBREV_FORWARD_STEP__NODE_TEST);

    generalReverseStepEClass = createEClass(GENERAL_REVERSE_STEP);
    createEAttribute(generalReverseStepEClass, GENERAL_REVERSE_STEP__AXIS);
    createEReference(generalReverseStepEClass, GENERAL_REVERSE_STEP__NODE_TEST);

    abbrevReverseStepEClass = createEClass(ABBREV_REVERSE_STEP);
    createEAttribute(abbrevReverseStepEClass, ABBREV_REVERSE_STEP__KIND);

    nodeTestEClass = createEClass(NODE_TEST);

    nodeKindTestEClass = createEClass(NODE_KIND_TEST);
    createEReference(nodeKindTestEClass, NODE_KIND_TEST__TEST);

    nameTestEClass = createEClass(NAME_TEST);

    qNameTestEClass = createEClass(QNAME_TEST);
    createEReference(qNameTestEClass, QNAME_TEST__NAME);

    wildcardEClass = createEClass(WILDCARD);

    anyWildcardEClass = createEClass(ANY_WILDCARD);

    localNameWildcardEClass = createEClass(LOCAL_NAME_WILDCARD);
    createEAttribute(localNameWildcardEClass, LOCAL_NAME_WILDCARD__NAMESPACE);

    namespaceWildcardEClass = createEClass(NAMESPACE_WILDCARD);
    createEAttribute(namespaceWildcardEClass, NAMESPACE_WILDCARD__LOCAL_NAME);

    predicateEClass = createEClass(PREDICATE);
    createEReference(predicateEClass, PREDICATE__EXPR);

    primaryExprEClass = createEClass(PRIMARY_EXPR);

    literalEClass = createEClass(LITERAL);

    varRefEClass = createEClass(VAR_REF);
    createEReference(varRefEClass, VAR_REF__VAR_NAME);

    varNameEClass = createEClass(VAR_NAME);

    parenthesizedExprEClass = createEClass(PARENTHESIZED_EXPR);
    createEReference(parenthesizedExprEClass, PARENTHESIZED_EXPR__EXPR);

    parenthesizedExprChildEClass = createEClass(PARENTHESIZED_EXPR_CHILD);

    contextItemExprEClass = createEClass(CONTEXT_ITEM_EXPR);

    functionCallEClass = createEClass(FUNCTION_CALL);
    createEReference(functionCallEClass, FUNCTION_CALL__NAME);
    createEReference(functionCallEClass, FUNCTION_CALL__ARG);

    numericLiteralEClass = createEClass(NUMERIC_LITERAL);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    integerLiteralEClass = createEClass(INTEGER_LITERAL);
    createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

    decimalLiteralEClass = createEClass(DECIMAL_LITERAL);
    createEAttribute(decimalLiteralEClass, DECIMAL_LITERAL__VALUE);

    doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
    createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__VALUE);

    compEClass = createEClass(COMP);

    generalCompEClass = createEClass(GENERAL_COMP);
    createEAttribute(generalCompEClass, GENERAL_COMP__OPERATOR);

    valueCompEClass = createEClass(VALUE_COMP);
    createEAttribute(valueCompEClass, VALUE_COMP__OPERATOR);

    nodeCompEClass = createEClass(NODE_COMP);
    createEAttribute(nodeCompEClass, NODE_COMP__OPERATOR);

    singleTypeEClass = createEClass(SINGLE_TYPE);
    createEReference(singleTypeEClass, SINGLE_TYPE__TYPE);
    createEAttribute(singleTypeEClass, SINGLE_TYPE__OPTIONAL);

    atomicTypeEClass = createEClass(ATOMIC_TYPE);

    optionalAtomicTypeEClass = createEClass(OPTIONAL_ATOMIC_TYPE);
    createEAttribute(optionalAtomicTypeEClass, OPTIONAL_ATOMIC_TYPE__OPTIONAL);

    sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

    emptySequenceTypeEClass = createEClass(EMPTY_SEQUENCE_TYPE);

    itemSequenceTypeEClass = createEClass(ITEM_SEQUENCE_TYPE);
    createEReference(itemSequenceTypeEClass, ITEM_SEQUENCE_TYPE__ITEM_TYPE);
    createEAttribute(itemSequenceTypeEClass, ITEM_SEQUENCE_TYPE__OCCURRENCE);

    itemTypeEClass = createEClass(ITEM_TYPE);

    itemKindTestEClass = createEClass(ITEM_KIND_TEST);
    createEReference(itemKindTestEClass, ITEM_KIND_TEST__TEST);

    anyItemTypeEClass = createEClass(ANY_ITEM_TYPE);

    atomicItemTypeEClass = createEClass(ATOMIC_ITEM_TYPE);
    createEReference(atomicItemTypeEClass, ATOMIC_ITEM_TYPE__TYPE);

    kindTestEClass = createEClass(KIND_TEST);

    documentTestEClass = createEClass(DOCUMENT_TEST);
    createEReference(documentTestEClass, DOCUMENT_TEST__TEST);

    elementTestEClass = createEClass(ELEMENT_TEST);

    nameElementTestEClass = createEClass(NAME_ELEMENT_TEST);
    createEReference(nameElementTestEClass, NAME_ELEMENT_TEST__NAME);
    createEReference(nameElementTestEClass, NAME_ELEMENT_TEST__TYPE);

    wildcardElementTestEClass = createEClass(WILDCARD_ELEMENT_TEST);
    createEReference(wildcardElementTestEClass, WILDCARD_ELEMENT_TEST__TYPE);

    attributeTestEClass = createEClass(ATTRIBUTE_TEST);

    nameAttributeTestEClass = createEClass(NAME_ATTRIBUTE_TEST);
    createEReference(nameAttributeTestEClass, NAME_ATTRIBUTE_TEST__NAME);
    createEReference(nameAttributeTestEClass, NAME_ATTRIBUTE_TEST__TYPE);

    wildcardAttributeTestEClass = createEClass(WILDCARD_ATTRIBUTE_TEST);
    createEReference(wildcardAttributeTestEClass, WILDCARD_ATTRIBUTE_TEST__TYPE);

    schemaElementTestEClass = createEClass(SCHEMA_ELEMENT_TEST);
    createEReference(schemaElementTestEClass, SCHEMA_ELEMENT_TEST__NAME);

    schemaAttributeTestEClass = createEClass(SCHEMA_ATTRIBUTE_TEST);
    createEReference(schemaAttributeTestEClass, SCHEMA_ATTRIBUTE_TEST__NAME);

    piTestEClass = createEClass(PI_TEST);

    ncNamePITestEClass = createEClass(NC_NAME_PI_TEST);
    createEAttribute(ncNamePITestEClass, NC_NAME_PI_TEST__NAME);

    stringLiteralPITestEClass = createEClass(STRING_LITERAL_PI_TEST);
    createEReference(stringLiteralPITestEClass, STRING_LITERAL_PI_TEST__LITERAL);

    commentTestEClass = createEClass(COMMENT_TEST);

    textTestEClass = createEClass(TEXT_TEST);

    anyKindTestEClass = createEClass(ANY_KIND_TEST);

    commentEClass = createEClass(COMMENT);
    createEAttribute(commentEClass, COMMENT__TEXT);
    createEReference(commentEClass, COMMENT__COMMENT);

    qNameEClass = createEClass(QNAME);
    createEAttribute(qNameEClass, QNAME__NAME);
    createEAttribute(qNameEClass, QNAME__PREFIX);

    // Create enums
    forwardAxisKindEEnum = createEEnum(FORWARD_AXIS_KIND);
    abbrevForwardStepKindEEnum = createEEnum(ABBREV_FORWARD_STEP_KIND);
    reverseAxisKindEEnum = createEEnum(REVERSE_AXIS_KIND);
    abbrevReverseStepKindEEnum = createEEnum(ABBREV_REVERSE_STEP_KIND);
    unionOpEEnum = createEEnum(UNION_OP);
    additiveOpKindEEnum = createEEnum(ADDITIVE_OP_KIND);
    multiplicativeOpKindEEnum = createEEnum(MULTIPLICATIVE_OP_KIND);
    quantifierKindEEnum = createEEnum(QUANTIFIER_KIND);
    intersectExceptOpKindEEnum = createEEnum(INTERSECT_EXCEPT_OP_KIND);
    unaryOpEEnum = createEEnum(UNARY_OP);
    generalCompKindEEnum = createEEnum(GENERAL_COMP_KIND);
    nodeCompKindEEnum = createEEnum(NODE_COMP_KIND);
    occurrenceIndicatorKindEEnum = createEEnum(OCCURRENCE_INDICATOR_KIND);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    anyExprEClass.getESuperTypes().add(this.getParenthesizedExprChild());
    exprEClass.getESuperTypes().add(this.getAnyExpr());
    exprSingleEClass.getESuperTypes().add(this.getAnyExpr());
    forExprEClass.getESuperTypes().add(this.getExprSingle());
    quantifiedExprEClass.getESuperTypes().add(this.getExprSingle());
    ifExprEClass.getESuperTypes().add(this.getExprSingle());
    orExprEClass.getESuperTypes().add(this.getExprSingle());
    orExprChildEClass.getESuperTypes().add(this.getExprSingle());
    andExprEClass.getESuperTypes().add(this.getOrExprChild());
    andExprChildEClass.getESuperTypes().add(this.getOrExprChild());
    comparisonExprEClass.getESuperTypes().add(this.getAndExprChild());
    comparisonExprChildEClass.getESuperTypes().add(this.getAndExprChild());
    rangeExprEClass.getESuperTypes().add(this.getComparisonExprChild());
    rangeExprChildEClass.getESuperTypes().add(this.getComparisonExprChild());
    additiveExprEClass.getESuperTypes().add(this.getRangeExprChild());
    additiveExprChildEClass.getESuperTypes().add(this.getRangeExprChild());
    multiplicativeExprEClass.getESuperTypes().add(this.getAdditiveExprChild());
    multiplicativeExprChildEClass.getESuperTypes().add(this.getAdditiveExprChild());
    unionExprEClass.getESuperTypes().add(this.getMultiplicativeExprChild());
    unionExprChildEClass.getESuperTypes().add(this.getMultiplicativeExprChild());
    intersectExceptExprEClass.getESuperTypes().add(this.getUnionExprChild());
    intersectExceptExprChildEClass.getESuperTypes().add(this.getUnionExprChild());
    instanceofExprEClass.getESuperTypes().add(this.getIntersectExceptExprChild());
    instanceofExprChildEClass.getESuperTypes().add(this.getIntersectExceptExprChild());
    treatExprEClass.getESuperTypes().add(this.getInstanceofExprChild());
    treatExprChildEClass.getESuperTypes().add(this.getInstanceofExprChild());
    castableExprEClass.getESuperTypes().add(this.getTreatExprChild());
    castableExprChildEClass.getESuperTypes().add(this.getTreatExprChild());
    castExprEClass.getESuperTypes().add(this.getCastableExprChild());
    castExprChildEClass.getESuperTypes().add(this.getCastableExprChild());
    unaryExprEClass.getESuperTypes().add(this.getCastExprChild());
    unaryExprChildEClass.getESuperTypes().add(this.getCastExprChild());
    valueExprEClass.getESuperTypes().add(this.getUnaryExprChild());
    pathExprEClass.getESuperTypes().add(this.getValueExpr());
    pathExprChildEClass.getESuperTypes().add(this.getUnaryExprChild());
    rootStepExprEClass.getESuperTypes().add(this.getPathExprChild());
    childStepExprEClass.getESuperTypes().add(this.getPathExprChild());
    descOrSelfStepExprEClass.getESuperTypes().add(this.getPathExprChild());
    selfStepExprEClass.getESuperTypes().add(this.getPathExprChild());
    selfStepExprChildEClass.getESuperTypes().add(this.getPathExprChild());
    stepExprEClass.getESuperTypes().add(this.getSelfStepExprChild());
    filterExprEClass.getESuperTypes().add(this.getStepExpr());
    filterExprChildEClass.getESuperTypes().add(this.getSelfStepExprChild());
    axisStepEClass.getESuperTypes().add(this.getStepExpr());
    forwardStepEClass.getESuperTypes().add(this.getDirectionalStep());
    reverseStepEClass.getESuperTypes().add(this.getDirectionalStep());
    generalForwardStepEClass.getESuperTypes().add(this.getForwardStep());
    abbrevForwardStepEClass.getESuperTypes().add(this.getForwardStep());
    generalReverseStepEClass.getESuperTypes().add(this.getReverseStep());
    abbrevReverseStepEClass.getESuperTypes().add(this.getReverseStep());
    nodeKindTestEClass.getESuperTypes().add(this.getNodeTest());
    nameTestEClass.getESuperTypes().add(this.getNodeTest());
    qNameTestEClass.getESuperTypes().add(this.getNameTest());
    wildcardEClass.getESuperTypes().add(this.getNameTest());
    anyWildcardEClass.getESuperTypes().add(this.getWildcard());
    localNameWildcardEClass.getESuperTypes().add(this.getWildcard());
    namespaceWildcardEClass.getESuperTypes().add(this.getWildcard());
    primaryExprEClass.getESuperTypes().add(this.getFilterExprChild());
    literalEClass.getESuperTypes().add(this.getPrimaryExpr());
    varRefEClass.getESuperTypes().add(this.getPrimaryExpr());
    varNameEClass.getESuperTypes().add(this.getQName());
    parenthesizedExprEClass.getESuperTypes().add(this.getPrimaryExpr());
    contextItemExprEClass.getESuperTypes().add(this.getPrimaryExpr());
    functionCallEClass.getESuperTypes().add(this.getPrimaryExpr());
    numericLiteralEClass.getESuperTypes().add(this.getLiteral());
    stringLiteralEClass.getESuperTypes().add(this.getLiteral());
    integerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
    decimalLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
    doubleLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
    generalCompEClass.getESuperTypes().add(this.getComp());
    valueCompEClass.getESuperTypes().add(this.getComp());
    nodeCompEClass.getESuperTypes().add(this.getComp());
    atomicTypeEClass.getESuperTypes().add(this.getQName());
    optionalAtomicTypeEClass.getESuperTypes().add(this.getQName());
    emptySequenceTypeEClass.getESuperTypes().add(this.getSequenceType());
    itemSequenceTypeEClass.getESuperTypes().add(this.getSequenceType());
    itemKindTestEClass.getESuperTypes().add(this.getItemType());
    anyItemTypeEClass.getESuperTypes().add(this.getItemType());
    atomicItemTypeEClass.getESuperTypes().add(this.getItemType());
    documentTestEClass.getESuperTypes().add(this.getKindTest());
    elementTestEClass.getESuperTypes().add(this.getKindTest());
    nameElementTestEClass.getESuperTypes().add(this.getElementTest());
    wildcardElementTestEClass.getESuperTypes().add(this.getElementTest());
    attributeTestEClass.getESuperTypes().add(this.getKindTest());
    nameAttributeTestEClass.getESuperTypes().add(this.getAttributeTest());
    wildcardAttributeTestEClass.getESuperTypes().add(this.getAttributeTest());
    schemaElementTestEClass.getESuperTypes().add(this.getKindTest());
    schemaAttributeTestEClass.getESuperTypes().add(this.getKindTest());
    piTestEClass.getESuperTypes().add(this.getKindTest());
    ncNamePITestEClass.getESuperTypes().add(this.getPITest());
    stringLiteralPITestEClass.getESuperTypes().add(this.getPITest());
    commentTestEClass.getESuperTypes().add(this.getKindTest());
    textTestEClass.getESuperTypes().add(this.getKindTest());
    anyKindTestEClass.getESuperTypes().add(this.getKindTest());

    // Initialize classes and features; add operations and parameters
    initEClass(anyExprEClass, AnyExpr.class, "AnyExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exprEClass, Expr.class, "Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpr_Expr(), this.getExprSingle(), null, "expr", null, 1, -1, Expr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exprSingleEClass, ExprSingle.class, "ExprSingle", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(forExprEClass, ForExpr.class, "ForExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForExpr_Iterator(), this.getIterator(), null, "iterator", null, 1, -1, ForExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForExpr_Return(), this.getExprSingle(), null, "return", null, 1, 1, ForExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(quantifiedExprEClass, QuantifiedExpr.class, "QuantifiedExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQuantifiedExpr_Quantifier(), this.getQuantifierKind(), "quantifier", null, 1, 1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQuantifiedExpr_Iterator(), this.getIterator(), null, "iterator", null, 1, -1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQuantifiedExpr_Satisfies(), this.getExprSingle(), null, "satisfies", null, 1, 1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifExprEClass, IfExpr.class, "IfExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfExpr_Test(), this.getAnyExpr(), null, "test", null, 1, 1, IfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExpr_Then(), this.getExprSingle(), null, "then", null, 1, 1, IfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExpr_Else(), this.getExprSingle(), null, "else", null, 1, 1, IfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iteratorEClass, Iterator.class, "Iterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIterator_VarName(), this.getVarName(), null, "varName", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterator_List(), this.getExprSingle(), null, "list", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExprEClass, OrExpr.class, "OrExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpr_Operand(), this.getOrExprChild(), null, "operand", null, 1, -1, OrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExprChildEClass, OrExprChild.class, "OrExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(andExprEClass, AndExpr.class, "AndExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpr_Operand(), this.getAndExprChild(), null, "operand", null, 1, -1, AndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExprChildEClass, AndExprChild.class, "AndExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(comparisonExprEClass, ComparisonExpr.class, "ComparisonExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComparisonExpr_Left(), this.getComparisonExprChild(), null, "left", null, 1, 1, ComparisonExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComparisonExpr_Operator(), this.getComp(), null, "operator", null, 0, 1, ComparisonExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComparisonExpr_Right(), this.getComparisonExprChild(), null, "right", null, 0, 1, ComparisonExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(comparisonExprChildEClass, ComparisonExprChild.class, "ComparisonExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rangeExprEClass, RangeExpr.class, "RangeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRangeExpr_From(), this.getRangeExprChild(), null, "from", null, 1, 1, RangeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRangeExpr_To(), this.getRangeExprChild(), null, "to", null, 0, 1, RangeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeExprChildEClass, RangeExprChild.class, "RangeExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(additiveExprEClass, AdditiveExpr.class, "AdditiveExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdditiveExpr_Operand(), this.getAdditiveExprChild(), null, "operand", null, 1, -1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdditiveExpr_Operator(), this.getAdditiveOpKind(), "operator", null, 0, -1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additiveExprChildEClass, AdditiveExprChild.class, "AdditiveExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(multiplicativeExprEClass, MultiplicativeExpr.class, "MultiplicativeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicativeExpr_Operand(), this.getMultiplicativeExprChild(), null, "operand", null, 1, -1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicativeExpr_Operator(), this.getMultiplicativeOpKind(), "operator", null, 0, -1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicativeExprChildEClass, MultiplicativeExprChild.class, "MultiplicativeExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unionExprEClass, UnionExpr.class, "UnionExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnionExpr_Operand(), this.getUnionExprChild(), null, "operand", null, 1, -1, UnionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnionExpr_Operation(), this.getUnionOp(), "operation", null, 0, -1, UnionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unionExprChildEClass, UnionExprChild.class, "UnionExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intersectExceptExprEClass, IntersectExceptExpr.class, "IntersectExceptExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntersectExceptExpr_Operand(), this.getIntersectExceptExprChild(), null, "operand", null, 1, -1, IntersectExceptExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIntersectExceptExpr_Operator(), this.getIntersectExceptOpKind(), "operator", null, 0, -1, IntersectExceptExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intersectExceptExprChildEClass, IntersectExceptExprChild.class, "IntersectExceptExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(instanceofExprEClass, InstanceofExpr.class, "InstanceofExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceofExpr_Operand(), this.getInstanceofExprChild(), null, "operand", null, 1, 1, InstanceofExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceofExpr_Type(), this.getSequenceType(), null, "type", null, 0, 1, InstanceofExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceofExprChildEClass, InstanceofExprChild.class, "InstanceofExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(treatExprEClass, TreatExpr.class, "TreatExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTreatExpr_Operand(), this.getTreatExprChild(), null, "operand", null, 1, 1, TreatExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTreatExpr_Type(), this.getSequenceType(), null, "type", null, 0, 1, TreatExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(treatExprChildEClass, TreatExprChild.class, "TreatExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(castableExprEClass, CastableExpr.class, "CastableExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCastableExpr_Operand(), this.getCastableExprChild(), null, "operand", null, 1, 1, CastableExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCastableExpr_Type(), this.getSingleType(), null, "type", null, 0, 1, CastableExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(castableExprChildEClass, CastableExprChild.class, "CastableExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(castExprEClass, CastExpr.class, "CastExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCastExpr_Operand(), this.getCastExprChild(), null, "operand", null, 1, 1, CastExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCastExpr_Type(), this.getSingleType(), null, "type", null, 0, 1, CastExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(castExprChildEClass, CastExprChild.class, "CastExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unaryExprEClass, UnaryExpr.class, "UnaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryExpr_Operand(), this.getUnaryExprChild(), null, "operand", null, 1, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpr_Operator(), this.getUnaryOp(), "operator", null, 0, -1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExprChildEClass, UnaryExprChild.class, "UnaryExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueExprEClass, ValueExpr.class, "ValueExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pathExprEClass, PathExpr.class, "PathExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPathExpr_Step(), this.getPathExprChild(), null, "step", null, 1, -1, PathExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pathExprChildEClass, PathExprChild.class, "PathExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rootStepExprEClass, RootStepExpr.class, "RootStepExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(childStepExprEClass, ChildStepExpr.class, "ChildStepExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChildStepExpr_Step(), this.getStepExpr(), null, "step", null, 1, 1, ChildStepExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descOrSelfStepExprEClass, DescOrSelfStepExpr.class, "DescOrSelfStepExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDescOrSelfStepExpr_Step(), this.getStepExpr(), null, "step", null, 1, 1, DescOrSelfStepExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selfStepExprEClass, SelfStepExpr.class, "SelfStepExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelfStepExpr_Step(), this.getSelfStepExprChild(), null, "step", null, 1, 1, SelfStepExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selfStepExprChildEClass, SelfStepExprChild.class, "SelfStepExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stepExprEClass, StepExpr.class, "StepExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(filterExprEClass, FilterExpr.class, "FilterExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFilterExpr_PrimaryExpr(), this.getFilterExprChild(), null, "primaryExpr", null, 1, 1, FilterExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFilterExpr_Predicate(), this.getPredicate(), null, "predicate", null, 0, -1, FilterExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(filterExprChildEClass, FilterExprChild.class, "FilterExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(axisStepEClass, AxisStep.class, "AxisStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAxisStep_Step(), this.getDirectionalStep(), null, "step", null, 1, 1, AxisStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAxisStep_Predicate(), this.getPredicate(), null, "predicate", null, 0, -1, AxisStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directionalStepEClass, DirectionalStep.class, "DirectionalStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(forwardStepEClass, ForwardStep.class, "ForwardStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reverseStepEClass, ReverseStep.class, "ReverseStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(generalForwardStepEClass, GeneralForwardStep.class, "GeneralForwardStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneralForwardStep_Axis(), this.getForwardAxisKind(), "axis", null, 1, 1, GeneralForwardStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralForwardStep_NodeTest(), this.getNodeTest(), null, "nodeTest", null, 1, 1, GeneralForwardStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abbrevForwardStepEClass, AbbrevForwardStep.class, "AbbrevForwardStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbbrevForwardStep_Kind(), this.getAbbrevForwardStepKind(), "kind", null, 1, 1, AbbrevForwardStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbbrevForwardStep_NodeTest(), this.getNodeTest(), null, "nodeTest", null, 1, 1, AbbrevForwardStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(generalReverseStepEClass, GeneralReverseStep.class, "GeneralReverseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneralReverseStep_Axis(), this.getReverseAxisKind(), "axis", null, 1, 1, GeneralReverseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralReverseStep_NodeTest(), this.getNodeTest(), null, "nodeTest", null, 1, 1, GeneralReverseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abbrevReverseStepEClass, AbbrevReverseStep.class, "AbbrevReverseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbbrevReverseStep_Kind(), this.getAbbrevReverseStepKind(), "kind", null, 1, 1, AbbrevReverseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeTestEClass, NodeTest.class, "NodeTest", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nodeKindTestEClass, NodeKindTest.class, "NodeKindTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeKindTest_Test(), this.getKindTest(), null, "test", null, 1, 1, NodeKindTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameTestEClass, NameTest.class, "NameTest", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qNameTestEClass, QNameTest.class, "QNameTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQNameTest_Name(), this.getQName(), null, "name", null, 1, 1, QNameTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(wildcardEClass, Wildcard.class, "Wildcard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(anyWildcardEClass, AnyWildcard.class, "AnyWildcard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(localNameWildcardEClass, LocalNameWildcard.class, "LocalNameWildcard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalNameWildcard_Namespace(), ecorePackage.getEString(), "namespace", null, 1, 1, LocalNameWildcard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namespaceWildcardEClass, NamespaceWildcard.class, "NamespaceWildcard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamespaceWildcard_LocalName(), ecorePackage.getEString(), "localName", null, 1, 1, NamespaceWildcard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPredicate_Expr(), this.getAnyExpr(), null, "expr", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primaryExprEClass, PrimaryExpr.class, "PrimaryExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(varRefEClass, VarRef.class, "VarRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVarRef_VarName(), this.getVarName(), null, "varName", null, 1, 1, VarRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varNameEClass, VarName.class, "VarName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parenthesizedExprEClass, ParenthesizedExpr.class, "ParenthesizedExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParenthesizedExpr_Expr(), this.getParenthesizedExprChild(), null, "expr", null, 0, 1, ParenthesizedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parenthesizedExprChildEClass, ParenthesizedExprChild.class, "ParenthesizedExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(contextItemExprEClass, ContextItemExpr.class, "ContextItemExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionCall_Name(), this.getQName(), null, "name", null, 1, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionCall_Arg(), this.getExprSingle(), null, "arg", null, 0, -1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerLiteral_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(decimalLiteralEClass, DecimalLiteral.class, "DecimalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDecimalLiteral_Value(), ecorePackage.getEFloat(), "value", null, 1, 1, DecimalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleLiteral_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compEClass, Comp.class, "Comp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(generalCompEClass, GeneralComp.class, "GeneralComp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneralComp_Operator(), this.getGeneralCompKind(), "operator", null, 1, 1, GeneralComp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueCompEClass, ValueComp.class, "ValueComp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueComp_Operator(), this.getGeneralCompKind(), "operator", null, 1, 1, ValueComp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeCompEClass, NodeComp.class, "NodeComp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNodeComp_Operator(), this.getNodeCompKind(), "operator", null, 1, 1, NodeComp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleTypeEClass, SingleType.class, "SingleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSingleType_Type(), this.getAtomicType(), null, "type", null, 1, 1, SingleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleType_Optional(), ecorePackage.getEBoolean(), "optional", null, 1, 1, SingleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicTypeEClass, AtomicType.class, "AtomicType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(optionalAtomicTypeEClass, OptionalAtomicType.class, "OptionalAtomicType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalAtomicType_Optional(), ecorePackage.getEBoolean(), "optional", null, 1, 1, OptionalAtomicType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(emptySequenceTypeEClass, EmptySequenceType.class, "EmptySequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(itemSequenceTypeEClass, ItemSequenceType.class, "ItemSequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getItemSequenceType_ItemType(), this.getItemType(), null, "itemType", null, 1, 1, ItemSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getItemSequenceType_Occurrence(), this.getOccurrenceIndicatorKind(), "occurrence", null, 1, 1, ItemSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(itemTypeEClass, ItemType.class, "ItemType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(itemKindTestEClass, ItemKindTest.class, "ItemKindTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getItemKindTest_Test(), this.getKindTest(), null, "test", null, 1, 1, ItemKindTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(anyItemTypeEClass, AnyItemType.class, "AnyItemType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atomicItemTypeEClass, AtomicItemType.class, "AtomicItemType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicItemType_Type(), this.getAtomicType(), null, "type", null, 1, 1, AtomicItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(kindTestEClass, KindTest.class, "KindTest", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(documentTestEClass, DocumentTest.class, "DocumentTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDocumentTest_Test(), this.getKindTest(), null, "test", null, 0, 1, DocumentTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementTestEClass, ElementTest.class, "ElementTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameElementTestEClass, NameElementTest.class, "NameElementTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameElementTest_Name(), this.getQName(), null, "name", null, 1, 1, NameElementTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameElementTest_Type(), this.getOptionalAtomicType(), null, "type", null, 0, 1, NameElementTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(wildcardElementTestEClass, WildcardElementTest.class, "WildcardElementTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWildcardElementTest_Type(), this.getOptionalAtomicType(), null, "type", null, 0, 1, WildcardElementTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeTestEClass, AttributeTest.class, "AttributeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameAttributeTestEClass, NameAttributeTest.class, "NameAttributeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameAttributeTest_Name(), this.getQName(), null, "name", null, 1, 1, NameAttributeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameAttributeTest_Type(), this.getQName(), null, "type", null, 0, 1, NameAttributeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(wildcardAttributeTestEClass, WildcardAttributeTest.class, "WildcardAttributeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWildcardAttributeTest_Type(), this.getQName(), null, "type", null, 0, 1, WildcardAttributeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(schemaElementTestEClass, SchemaElementTest.class, "SchemaElementTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSchemaElementTest_Name(), this.getQName(), null, "name", null, 1, 1, SchemaElementTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(schemaAttributeTestEClass, SchemaAttributeTest.class, "SchemaAttributeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSchemaAttributeTest_Name(), this.getQName(), null, "name", null, 1, 1, SchemaAttributeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(piTestEClass, PITest.class, "PITest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ncNamePITestEClass, NCNamePITest.class, "NCNamePITest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNCNamePITest_Name(), ecorePackage.getEString(), "name", null, 1, 1, NCNamePITest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralPITestEClass, StringLiteralPITest.class, "StringLiteralPITest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringLiteralPITest_Literal(), this.getStringLiteral(), null, "literal", null, 1, 1, StringLiteralPITest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commentTestEClass, CommentTest.class, "CommentTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(textTestEClass, TextTest.class, "TextTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(anyKindTestEClass, AnyKindTest.class, "AnyKindTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComment_Text(), ecorePackage.getEString(), "text", null, 0, -1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComment_Comment(), this.getComment(), null, "comment", null, 0, -1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qNameEClass, QName.class, "QName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQName_Name(), ecorePackage.getEString(), "name", "", 1, 1, QName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQName_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, QName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(forwardAxisKindEEnum, ForwardAxisKind.class, "ForwardAxisKind");
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.CHILD);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.DESCENDANT);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.ATTRIBUTE);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.SELF);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.DESCENDANT_OR_SELF);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.FOLLOWING_SIBLING);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.FOLLOWING);
    addEEnumLiteral(forwardAxisKindEEnum, ForwardAxisKind.NAMESPACE);

    initEEnum(abbrevForwardStepKindEEnum, AbbrevForwardStepKind.class, "AbbrevForwardStepKind");
    addEEnumLiteral(abbrevForwardStepKindEEnum, AbbrevForwardStepKind.CHILD);
    addEEnumLiteral(abbrevForwardStepKindEEnum, AbbrevForwardStepKind.ATTRIBUTE);

    initEEnum(reverseAxisKindEEnum, ReverseAxisKind.class, "ReverseAxisKind");
    addEEnumLiteral(reverseAxisKindEEnum, ReverseAxisKind.PARENT);
    addEEnumLiteral(reverseAxisKindEEnum, ReverseAxisKind.ANCESTOR);
    addEEnumLiteral(reverseAxisKindEEnum, ReverseAxisKind.PRECEDING_SIBLING);
    addEEnumLiteral(reverseAxisKindEEnum, ReverseAxisKind.PRECEDING);
    addEEnumLiteral(reverseAxisKindEEnum, ReverseAxisKind.ANCESTOR_OR_SELF);

    initEEnum(abbrevReverseStepKindEEnum, AbbrevReverseStepKind.class, "AbbrevReverseStepKind");
    addEEnumLiteral(abbrevReverseStepKindEEnum, AbbrevReverseStepKind.PARENT);

    initEEnum(unionOpEEnum, UnionOp.class, "UnionOp");
    addEEnumLiteral(unionOpEEnum, UnionOp.UNION);
    addEEnumLiteral(unionOpEEnum, UnionOp.VERTICAL_BAR);

    initEEnum(additiveOpKindEEnum, AdditiveOpKind.class, "AdditiveOpKind");
    addEEnumLiteral(additiveOpKindEEnum, AdditiveOpKind.ADDITION);
    addEEnumLiteral(additiveOpKindEEnum, AdditiveOpKind.SUBTRACTION);

    initEEnum(multiplicativeOpKindEEnum, MultiplicativeOpKind.class, "MultiplicativeOpKind");
    addEEnumLiteral(multiplicativeOpKindEEnum, MultiplicativeOpKind.MULTIPLICATION);
    addEEnumLiteral(multiplicativeOpKindEEnum, MultiplicativeOpKind.DIV);
    addEEnumLiteral(multiplicativeOpKindEEnum, MultiplicativeOpKind.IDIV);
    addEEnumLiteral(multiplicativeOpKindEEnum, MultiplicativeOpKind.MOD);

    initEEnum(quantifierKindEEnum, QuantifierKind.class, "QuantifierKind");
    addEEnumLiteral(quantifierKindEEnum, QuantifierKind.SOME);
    addEEnumLiteral(quantifierKindEEnum, QuantifierKind.EVERY);

    initEEnum(intersectExceptOpKindEEnum, IntersectExceptOpKind.class, "IntersectExceptOpKind");
    addEEnumLiteral(intersectExceptOpKindEEnum, IntersectExceptOpKind.INTERSECT);
    addEEnumLiteral(intersectExceptOpKindEEnum, IntersectExceptOpKind.EXCEPT);

    initEEnum(unaryOpEEnum, UnaryOp.class, "UnaryOp");
    addEEnumLiteral(unaryOpEEnum, UnaryOp.PLUS);
    addEEnumLiteral(unaryOpEEnum, UnaryOp.MINUS);

    initEEnum(generalCompKindEEnum, GeneralCompKind.class, "GeneralCompKind");
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.EQ);
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.NE);
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.LT);
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.LE);
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.GT);
    addEEnumLiteral(generalCompKindEEnum, GeneralCompKind.GE);

    initEEnum(nodeCompKindEEnum, NodeCompKind.class, "NodeCompKind");
    addEEnumLiteral(nodeCompKindEEnum, NodeCompKind.IS);
    addEEnumLiteral(nodeCompKindEEnum, NodeCompKind.PRECEDES);
    addEEnumLiteral(nodeCompKindEEnum, NodeCompKind.FOLLOWS);

    initEEnum(occurrenceIndicatorKindEEnum, OccurrenceIndicatorKind.class, "OccurrenceIndicatorKind");
    addEEnumLiteral(occurrenceIndicatorKindEEnum, OccurrenceIndicatorKind.MANDATORY);
    addEEnumLiteral(occurrenceIndicatorKindEEnum, OccurrenceIndicatorKind.OPTIONAL);
    addEEnumLiteral(occurrenceIndicatorKindEEnum, OccurrenceIndicatorKind.STAR);
    addEEnumLiteral(occurrenceIndicatorKindEEnum, OccurrenceIndicatorKind.PLUS);

    // Create resource
    createResource(eNS_URI);
  }

} //Xpath2PackageImpl
