/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Factory
 * @model kind="package"
 * @generated
 */
public interface Xpath2Package extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "xpath2";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/xpath2";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "xpath2";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	Xpath2Package eINSTANCE = org.emftext.language.xpath2.impl.Xpath2PackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getExpr()
   * @generated
   */
	int EXPR = 0;

	/**
   * The feature id for the '<em><b>Owned Expr Single</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR__OWNED_EXPR_SINGLE = 0;

	/**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ExprSingleImpl <em>Expr Single</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ExprSingleImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getExprSingle()
   * @generated
   */
	int EXPR_SINGLE = 1;

	/**
   * The number of structural features of the '<em>Expr Single</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR_SINGLE_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ForExprImpl <em>For Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ForExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForExpr()
   * @generated
   */
	int FOR_EXPR = 2;

	/**
   * The feature id for the '<em><b>Owned Simple For Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE = EXPR_SINGLE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FOR_EXPR__RETURN = EXPR_SINGLE_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>For Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FOR_EXPR_FEATURE_COUNT = EXPR_SINGLE_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.QuantifiedExprImpl <em>Quantified Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.QuantifiedExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQuantifiedExpr()
   * @generated
   */
	int QUANTIFIED_EXPR = 3;

	/**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QUANTIFIED_EXPR__QUANTIFIER = EXPR_SINGLE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QUANTIFIED_EXPR__ITERATOR = EXPR_SINGLE_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Satisfies</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QUANTIFIED_EXPR__SATISFIES = EXPR_SINGLE_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Quantified Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QUANTIFIED_EXPR_FEATURE_COUNT = EXPR_SINGLE_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.IfExprImpl <em>If Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.IfExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIfExpr()
   * @generated
   */
	int IF_EXPR = 4;

	/**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_EXPR__CONDITION = EXPR_SINGLE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_EXPR__THEN = EXPR_SINGLE_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_EXPR__ELSE = EXPR_SINGLE_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>If Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_EXPR_FEATURE_COUNT = EXPR_SINGLE_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SimpleForClauseImpl <em>Simple For Clause</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SimpleForClauseImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSimpleForClause()
   * @generated
   */
	int SIMPLE_FOR_CLAUSE = 5;

	/**
   * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SIMPLE_FOR_CLAUSE__ITERATOR = 0;

	/**
   * The number of structural features of the '<em>Simple For Clause</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SIMPLE_FOR_CLAUSE_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SimpleForClauseIteratorImpl <em>Simple For Clause Iterator</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SimpleForClauseIteratorImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSimpleForClauseIterator()
   * @generated
   */
	int SIMPLE_FOR_CLAUSE_ITERATOR = 6;

	/**
   * The feature id for the '<em><b>Var Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SIMPLE_FOR_CLAUSE_ITERATOR__VAR_NAME = 0;

	/**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SIMPLE_FOR_CLAUSE_ITERATOR__LIST = 1;

	/**
   * The number of structural features of the '<em>Simple For Clause Iterator</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SIMPLE_FOR_CLAUSE_ITERATOR_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.OrExprImpl <em>Or Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.OrExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOrExpr()
   * @generated
   */
	int OR_EXPR = 7;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OR_EXPR__OPERAND = EXPR_SINGLE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Or Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OR_EXPR_FEATURE_COUNT = EXPR_SINGLE_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.OrExprChildImpl <em>Or Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.OrExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOrExprChild()
   * @generated
   */
	int OR_EXPR_CHILD = 8;

	/**
   * The number of structural features of the '<em>Or Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OR_EXPR_CHILD_FEATURE_COUNT = EXPR_SINGLE_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AndExprImpl <em>And Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AndExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAndExpr()
   * @generated
   */
	int AND_EXPR = 9;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AND_EXPR__OPERAND = OR_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>And Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AND_EXPR_FEATURE_COUNT = OR_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AndExprChildImpl <em>And Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AndExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAndExprChild()
   * @generated
   */
	int AND_EXPR_CHILD = 10;

	/**
   * The number of structural features of the '<em>And Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AND_EXPR_CHILD_FEATURE_COUNT = OR_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ComparisonExprImpl <em>Comparison Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ComparisonExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComparisonExpr()
   * @generated
   */
	int COMPARISON_EXPR = 11;

	/**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPARISON_EXPR__LEFT = AND_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPARISON_EXPR__OPERATOR = AND_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPARISON_EXPR__RIGHT = AND_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Comparison Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPARISON_EXPR_FEATURE_COUNT = AND_EXPR_CHILD_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ComparisonExprChildImpl <em>Comparison Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ComparisonExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComparisonExprChild()
   * @generated
   */
	int COMPARISON_EXPR_CHILD = 12;

	/**
   * The number of structural features of the '<em>Comparison Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPARISON_EXPR_CHILD_FEATURE_COUNT = AND_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.RangeExprImpl <em>Range Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.RangeExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRangeExpr()
   * @generated
   */
	int RANGE_EXPR = 13;

	/**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RANGE_EXPR__FROM = COMPARISON_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RANGE_EXPR__TO = COMPARISON_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Range Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RANGE_EXPR_FEATURE_COUNT = COMPARISON_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.RangeExprChildImpl <em>Range Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.RangeExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRangeExprChild()
   * @generated
   */
	int RANGE_EXPR_CHILD = 14;

	/**
   * The number of structural features of the '<em>Range Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RANGE_EXPR_CHILD_FEATURE_COUNT = COMPARISON_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AdditiveExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveExpr()
   * @generated
   */
	int ADDITIVE_EXPR = 15;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADDITIVE_EXPR__OPERAND = RANGE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADDITIVE_EXPR__OPERATOR = RANGE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Additive Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADDITIVE_EXPR_FEATURE_COUNT = RANGE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AdditiveExprChildImpl <em>Additive Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AdditiveExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveExprChild()
   * @generated
   */
	int ADDITIVE_EXPR_CHILD = 16;

	/**
   * The number of structural features of the '<em>Additive Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADDITIVE_EXPR_CHILD_FEATURE_COUNT = RANGE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.MultiplicativeExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeExpr()
   * @generated
   */
	int MULTIPLICATIVE_EXPR = 17;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICATIVE_EXPR__OPERAND = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICATIVE_EXPR__OPERATOR = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Multiplicative Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICATIVE_EXPR_FEATURE_COUNT = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.MultiplicativeExprChildImpl <em>Multiplicative Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.MultiplicativeExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeExprChild()
   * @generated
   */
	int MULTIPLICATIVE_EXPR_CHILD = 18;

	/**
   * The number of structural features of the '<em>Multiplicative Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.UnionExprImpl <em>Union Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.UnionExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionExpr()
   * @generated
   */
	int UNION_EXPR = 19;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNION_EXPR__OPERAND = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operation</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNION_EXPR__OPERATION = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Union Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNION_EXPR_FEATURE_COUNT = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.UnionExprChildImpl <em>Union Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.UnionExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionExprChild()
   * @generated
   */
	int UNION_EXPR_CHILD = 20;

	/**
   * The number of structural features of the '<em>Union Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNION_EXPR_CHILD_FEATURE_COUNT = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.IntersectExceptExprImpl <em>Intersect Except Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.IntersectExceptExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptExpr()
   * @generated
   */
	int INTERSECT_EXCEPT_EXPR = 21;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTERSECT_EXCEPT_EXPR__OPERAND = UNION_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTERSECT_EXCEPT_EXPR__OPERATOR = UNION_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Intersect Except Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTERSECT_EXCEPT_EXPR_FEATURE_COUNT = UNION_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.IntersectExceptExprChildImpl <em>Intersect Except Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.IntersectExceptExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptExprChild()
   * @generated
   */
	int INTERSECT_EXCEPT_EXPR_CHILD = 22;

	/**
   * The number of structural features of the '<em>Intersect Except Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTERSECT_EXCEPT_EXPR_CHILD_FEATURE_COUNT = UNION_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.InstanceofExprImpl <em>Instanceof Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.InstanceofExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getInstanceofExpr()
   * @generated
   */
	int INSTANCEOF_EXPR = 23;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCEOF_EXPR__OPERAND = INTERSECT_EXCEPT_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCEOF_EXPR__TYPE = INTERSECT_EXCEPT_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Instanceof Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCEOF_EXPR_FEATURE_COUNT = INTERSECT_EXCEPT_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.InstanceofExprChildImpl <em>Instanceof Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.InstanceofExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getInstanceofExprChild()
   * @generated
   */
	int INSTANCEOF_EXPR_CHILD = 24;

	/**
   * The number of structural features of the '<em>Instanceof Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCEOF_EXPR_CHILD_FEATURE_COUNT = INTERSECT_EXCEPT_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.TreatExprImpl <em>Treat Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.TreatExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTreatExpr()
   * @generated
   */
	int TREAT_EXPR = 25;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TREAT_EXPR__OPERAND = INSTANCEOF_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TREAT_EXPR__TYPE = INSTANCEOF_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Treat Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TREAT_EXPR_FEATURE_COUNT = INSTANCEOF_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.TreatExprChildImpl <em>Treat Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.TreatExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTreatExprChild()
   * @generated
   */
	int TREAT_EXPR_CHILD = 26;

	/**
   * The number of structural features of the '<em>Treat Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TREAT_EXPR_CHILD_FEATURE_COUNT = INSTANCEOF_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CastableExprImpl <em>Castable Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CastableExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastableExpr()
   * @generated
   */
	int CASTABLE_EXPR = 27;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CASTABLE_EXPR__OPERAND = TREAT_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CASTABLE_EXPR__TYPE = TREAT_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Castable Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CASTABLE_EXPR_FEATURE_COUNT = TREAT_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CastableExprChildImpl <em>Castable Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CastableExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastableExprChild()
   * @generated
   */
	int CASTABLE_EXPR_CHILD = 28;

	/**
   * The number of structural features of the '<em>Castable Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CASTABLE_EXPR_CHILD_FEATURE_COUNT = TREAT_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CastExprImpl <em>Cast Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CastExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastExpr()
   * @generated
   */
	int CAST_EXPR = 29;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CAST_EXPR__OPERAND = CASTABLE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CAST_EXPR__TYPE = CASTABLE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Cast Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CAST_EXPR_FEATURE_COUNT = CASTABLE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CastExprChildImpl <em>Cast Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CastExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastExprChild()
   * @generated
   */
	int CAST_EXPR_CHILD = 30;

	/**
   * The number of structural features of the '<em>Cast Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CAST_EXPR_CHILD_FEATURE_COUNT = CASTABLE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.UnaryExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryExpr()
   * @generated
   */
	int UNARY_EXPR = 31;

	/**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNARY_EXPR__OPERAND = CAST_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNARY_EXPR__OPERATOR = CAST_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNARY_EXPR_FEATURE_COUNT = CAST_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.UnaryExprChildImpl <em>Unary Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.UnaryExprChildImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryExprChild()
   * @generated
   */
	int UNARY_EXPR_CHILD = 32;

	/**
   * The number of structural features of the '<em>Unary Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNARY_EXPR_CHILD_FEATURE_COUNT = CAST_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ValueExprImpl <em>Value Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ValueExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueExpr()
   * @generated
   */
	int VALUE_EXPR = 33;

	/**
   * The number of structural features of the '<em>Value Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VALUE_EXPR_FEATURE_COUNT = UNARY_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.PathExprImpl <em>Path Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.PathExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathExpr()
   * @generated
   */
	int PATH_EXPR = 34;

	/**
   * The feature id for the '<em><b>Initial Separator</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATH_EXPR__INITIAL_SEPARATOR = VALUE_EXPR_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATH_EXPR__PATH = VALUE_EXPR_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Path Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATH_EXPR_FEATURE_COUNT = VALUE_EXPR_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.PathSeparatorImpl <em>Path Separator</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.PathSeparatorImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathSeparator()
   * @generated
   */
	int PATH_SEPARATOR = 35;

	/**
   * The number of structural features of the '<em>Path Separator</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATH_SEPARATOR_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SinglePathSeparatorImpl <em>Single Path Separator</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SinglePathSeparatorImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSinglePathSeparator()
   * @generated
   */
	int SINGLE_PATH_SEPARATOR = 36;

	/**
   * The number of structural features of the '<em>Single Path Separator</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SINGLE_PATH_SEPARATOR_FEATURE_COUNT = PATH_SEPARATOR_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.DoublePathSeparatorImpl <em>Double Path Separator</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.DoublePathSeparatorImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDoublePathSeparator()
   * @generated
   */
	int DOUBLE_PATH_SEPARATOR = 37;

	/**
   * The number of structural features of the '<em>Double Path Separator</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOUBLE_PATH_SEPARATOR_FEATURE_COUNT = PATH_SEPARATOR_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.RelativePathExprImpl <em>Relative Path Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.RelativePathExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRelativePathExpr()
   * @generated
   */
	int RELATIVE_PATH_EXPR = 38;

	/**
   * The feature id for the '<em><b>Step</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIVE_PATH_EXPR__STEP = 0;

	/**
   * The feature id for the '<em><b>Separator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIVE_PATH_EXPR__SEPARATOR = 1;

	/**
   * The number of structural features of the '<em>Relative Path Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIVE_PATH_EXPR_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.StepExprImpl <em>Step Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.StepExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getStepExpr()
   * @generated
   */
	int STEP_EXPR = 39;

	/**
   * The number of structural features of the '<em>Step Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STEP_EXPR_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.FilterExprImpl <em>Filter Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.FilterExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getFilterExpr()
   * @generated
   */
	int FILTER_EXPR = 40;

	/**
   * The feature id for the '<em><b>Primary Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FILTER_EXPR__PRIMARY_EXPR = STEP_EXPR_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FILTER_EXPR__PREDICATE = STEP_EXPR_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Filter Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FILTER_EXPR_FEATURE_COUNT = STEP_EXPR_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AxisStepImpl <em>Axis Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AxisStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAxisStep()
   * @generated
   */
	int AXIS_STEP = 41;

	/**
   * The feature id for the '<em><b>Step</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AXIS_STEP__STEP = STEP_EXPR_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AXIS_STEP__PREDICATE = STEP_EXPR_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Axis Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AXIS_STEP_FEATURE_COUNT = STEP_EXPR_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.DirectionalStepImpl <em>Directional Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.DirectionalStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDirectionalStep()
   * @generated
   */
	int DIRECTIONAL_STEP = 42;

	/**
   * The number of structural features of the '<em>Directional Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DIRECTIONAL_STEP_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ForwardStepImpl <em>Forward Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ForwardStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardStep()
   * @generated
   */
	int FORWARD_STEP = 43;

	/**
   * The number of structural features of the '<em>Forward Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FORWARD_STEP_FEATURE_COUNT = DIRECTIONAL_STEP_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ReverseStepImpl <em>Reverse Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ReverseStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseStep()
   * @generated
   */
	int REVERSE_STEP = 44;

	/**
   * The number of structural features of the '<em>Reverse Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REVERSE_STEP_FEATURE_COUNT = DIRECTIONAL_STEP_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.GeneralForwardStepImpl <em>General Forward Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.GeneralForwardStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralForwardStep()
   * @generated
   */
	int GENERAL_FORWARD_STEP = 45;

	/**
   * The feature id for the '<em><b>Axis</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_FORWARD_STEP__AXIS = FORWARD_STEP_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Node Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_FORWARD_STEP__NODE_TEST = FORWARD_STEP_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>General Forward Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_FORWARD_STEP_FEATURE_COUNT = FORWARD_STEP_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl <em>Abbrev Forward Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AbbrevForwardStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAbbrevForwardStep()
   * @generated
   */
	int ABBREV_FORWARD_STEP = 46;

	/**
   * The feature id for the '<em><b>At</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABBREV_FORWARD_STEP__AT = FORWARD_STEP_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Node Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABBREV_FORWARD_STEP__NODE_TEST = FORWARD_STEP_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Abbrev Forward Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABBREV_FORWARD_STEP_FEATURE_COUNT = FORWARD_STEP_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ForwardAxisImpl <em>Forward Axis</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ForwardAxisImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardAxis()
   * @generated
   */
	int FORWARD_AXIS = 47;

	/**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FORWARD_AXIS__KIND = 0;

	/**
   * The number of structural features of the '<em>Forward Axis</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FORWARD_AXIS_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.GeneralReverseStepImpl <em>General Reverse Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.GeneralReverseStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralReverseStep()
   * @generated
   */
	int GENERAL_REVERSE_STEP = 48;

	/**
   * The feature id for the '<em><b>Axis</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_REVERSE_STEP__AXIS = REVERSE_STEP_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Node Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_REVERSE_STEP__NODE_TEST = REVERSE_STEP_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>General Reverse Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_REVERSE_STEP_FEATURE_COUNT = REVERSE_STEP_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AbbrevReverseStepImpl <em>Abbrev Reverse Step</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AbbrevReverseStepImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAbbrevReverseStep()
   * @generated
   */
	int ABBREV_REVERSE_STEP = 49;

	/**
   * The number of structural features of the '<em>Abbrev Reverse Step</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABBREV_REVERSE_STEP_FEATURE_COUNT = REVERSE_STEP_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ReverseAxisImpl <em>Reverse Axis</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ReverseAxisImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseAxis()
   * @generated
   */
	int REVERSE_AXIS = 50;

	/**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REVERSE_AXIS__KIND = 0;

	/**
   * The number of structural features of the '<em>Reverse Axis</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REVERSE_AXIS_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NodeTestImpl <em>Node Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NodeTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeTest()
   * @generated
   */
	int NODE_TEST = 51;

	/**
   * The number of structural features of the '<em>Node Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NODE_TEST_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NodeKindTestImpl <em>Node Kind Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NodeKindTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeKindTest()
   * @generated
   */
	int NODE_KIND_TEST = 52;

	/**
   * The feature id for the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NODE_KIND_TEST__TEST = NODE_TEST_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Node Kind Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NODE_KIND_TEST_FEATURE_COUNT = NODE_TEST_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NameTestImpl <em>Name Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NameTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNameTest()
   * @generated
   */
	int NAME_TEST = 53;

	/**
   * The number of structural features of the '<em>Name Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NAME_TEST_FEATURE_COUNT = NODE_TEST_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.QNameTestImpl <em>QName Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.QNameTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQNameTest()
   * @generated
   */
	int QNAME_TEST = 54;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QNAME_TEST__NAME = NAME_TEST_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>QName Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QNAME_TEST_FEATURE_COUNT = NAME_TEST_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.WildcardImpl <em>Wildcard</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.WildcardImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getWildcard()
   * @generated
   */
	int WILDCARD = 55;

	/**
   * The number of structural features of the '<em>Wildcard</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WILDCARD_FEATURE_COUNT = NAME_TEST_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AnyWildcardImpl <em>Any Wildcard</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AnyWildcardImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyWildcard()
   * @generated
   */
	int ANY_WILDCARD = 56;

	/**
   * The number of structural features of the '<em>Any Wildcard</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANY_WILDCARD_FEATURE_COUNT = WILDCARD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.LocalNameWildcardImpl <em>Local Name Wildcard</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.LocalNameWildcardImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getLocalNameWildcard()
   * @generated
   */
	int LOCAL_NAME_WILDCARD = 57;

	/**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOCAL_NAME_WILDCARD__NAMESPACE = WILDCARD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Local Name Wildcard</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOCAL_NAME_WILDCARD_FEATURE_COUNT = WILDCARD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NamespaceWildcardImpl <em>Namespace Wildcard</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NamespaceWildcardImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNamespaceWildcard()
   * @generated
   */
	int NAMESPACE_WILDCARD = 58;

	/**
   * The feature id for the '<em><b>Local Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NAMESPACE_WILDCARD__LOCAL_NAME = WILDCARD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Namespace Wildcard</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NAMESPACE_WILDCARD_FEATURE_COUNT = WILDCARD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.PredicateImpl <em>Predicate</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.PredicateImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPredicate()
   * @generated
   */
	int PREDICATE = 59;

	/**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PREDICATE__EXPR = 0;

	/**
   * The number of structural features of the '<em>Predicate</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PREDICATE_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.PrimaryExprImpl <em>Primary Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.PrimaryExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPrimaryExpr()
   * @generated
   */
	int PRIMARY_EXPR = 60;

	/**
   * The number of structural features of the '<em>Primary Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRIMARY_EXPR_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.LiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getLiteral()
   * @generated
   */
	int LITERAL = 61;

	/**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LITERAL_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.VarRefImpl <em>Var Ref</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.VarRefImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getVarRef()
   * @generated
   */
	int VAR_REF = 62;

	/**
   * The feature id for the '<em><b>Var Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_REF__VAR_NAME = PRIMARY_EXPR_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Var Ref</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_REF_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.VarNameImpl <em>Var Name</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.VarNameImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getVarName()
   * @generated
   */
	int VAR_NAME = 63;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_NAME__NAME = 0;

	/**
   * The number of structural features of the '<em>Var Name</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_NAME_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ParenthesizedExprImpl <em>Parenthesized Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ParenthesizedExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getParenthesizedExpr()
   * @generated
   */
	int PARENTHESIZED_EXPR = 64;

	/**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PARENTHESIZED_EXPR__EXPR = PRIMARY_EXPR_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Parenthesized Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PARENTHESIZED_EXPR_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ContextItemExprImpl <em>Context Item Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ContextItemExprImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getContextItemExpr()
   * @generated
   */
	int CONTEXT_ITEM_EXPR = 65;

	/**
   * The number of structural features of the '<em>Context Item Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONTEXT_ITEM_EXPR_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.FunctionCallImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getFunctionCall()
   * @generated
   */
	int FUNCTION_CALL = 66;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FUNCTION_CALL__NAME = PRIMARY_EXPR_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Arg</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FUNCTION_CALL__ARG = PRIMARY_EXPR_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FUNCTION_CALL_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NumericLiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNumericLiteral()
   * @generated
   */
	int NUMERIC_LITERAL = 67;

	/**
   * The number of structural features of the '<em>Numeric Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NUMERIC_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.StringLiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getStringLiteral()
   * @generated
   */
	int STRING_LITERAL = 68;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.IntegerLiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntegerLiteral()
   * @generated
   */
	int INTEGER_LITERAL = 69;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTEGER_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTEGER_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.DecimalLiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDecimalLiteral()
   * @generated
   */
	int DECIMAL_LITERAL = 70;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECIMAL_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Decimal Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECIMAL_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.DoubleLiteralImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDoubleLiteral()
   * @generated
   */
	int DOUBLE_LITERAL = 71;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOUBLE_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Double Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOUBLE_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CompImpl <em>Comp</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CompImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComp()
   * @generated
   */
	int COMP = 72;

	/**
   * The number of structural features of the '<em>Comp</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMP_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.GeneralCompImpl <em>General Comp</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.GeneralCompImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralComp()
   * @generated
   */
	int GENERAL_COMP = 73;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_COMP__OPERATOR = COMP_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>General Comp</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERAL_COMP_FEATURE_COUNT = COMP_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ValueCompImpl <em>Value Comp</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ValueCompImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueComp()
   * @generated
   */
	int VALUE_COMP = 74;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VALUE_COMP__OPERATOR = COMP_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Value Comp</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VALUE_COMP_FEATURE_COUNT = COMP_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.NodeCompImpl <em>Node Comp</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.NodeCompImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeComp()
   * @generated
   */
	int NODE_COMP = 75;

	/**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NODE_COMP__OPERATOR = COMP_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Node Comp</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NODE_COMP_FEATURE_COUNT = COMP_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SingleTypeImpl <em>Single Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SingleTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSingleType()
   * @generated
   */
	int SINGLE_TYPE = 76;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SINGLE_TYPE__TYPE = 0;

	/**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SINGLE_TYPE__OPTIONAL = 1;

	/**
   * The number of structural features of the '<em>Single Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SINGLE_TYPE_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AtomicTypeImpl <em>Atomic Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AtomicTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAtomicType()
   * @generated
   */
	int ATOMIC_TYPE = 77;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATOMIC_TYPE__NAME = 0;

	/**
   * The number of structural features of the '<em>Atomic Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATOMIC_TYPE_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SequenceTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSequenceType()
   * @generated
   */
	int SEQUENCE_TYPE = 78;

	/**
   * The number of structural features of the '<em>Sequence Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SEQUENCE_TYPE_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.EmptySequenceTypeImpl <em>Empty Sequence Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.EmptySequenceTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getEmptySequenceType()
   * @generated
   */
	int EMPTY_SEQUENCE_TYPE = 79;

	/**
   * The number of structural features of the '<em>Empty Sequence Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EMPTY_SEQUENCE_TYPE_FEATURE_COUNT = SEQUENCE_TYPE_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ItemSequenceTypeImpl <em>Item Sequence Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ItemSequenceTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemSequenceType()
   * @generated
   */
	int ITEM_SEQUENCE_TYPE = 80;

	/**
   * The feature id for the '<em><b>Item Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_SEQUENCE_TYPE__ITEM_TYPE = SEQUENCE_TYPE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Occurrence</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_SEQUENCE_TYPE__OCCURRENCE = SEQUENCE_TYPE_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Item Sequence Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_SEQUENCE_TYPE_FEATURE_COUNT = SEQUENCE_TYPE_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ItemTypeImpl <em>Item Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ItemTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemType()
   * @generated
   */
	int ITEM_TYPE = 81;

	/**
   * The number of structural features of the '<em>Item Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_TYPE_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ItemKindTestImpl <em>Item Kind Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ItemKindTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemKindTest()
   * @generated
   */
	int ITEM_KIND_TEST = 82;

	/**
   * The feature id for the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_KIND_TEST__TEST = ITEM_TYPE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Item Kind Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ITEM_KIND_TEST_FEATURE_COUNT = ITEM_TYPE_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AnyItemTypeImpl <em>Any Item Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AnyItemTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyItemType()
   * @generated
   */
	int ANY_ITEM_TYPE = 83;

	/**
   * The number of structural features of the '<em>Any Item Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANY_ITEM_TYPE_FEATURE_COUNT = ITEM_TYPE_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AtomicItemTypeImpl <em>Atomic Item Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AtomicItemTypeImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAtomicItemType()
   * @generated
   */
	int ATOMIC_ITEM_TYPE = 84;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATOMIC_ITEM_TYPE__TYPE = ITEM_TYPE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Atomic Item Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATOMIC_ITEM_TYPE_FEATURE_COUNT = ITEM_TYPE_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.KindTestImpl <em>Kind Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.KindTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getKindTest()
   * @generated
   */
	int KIND_TEST = 85;

	/**
   * The number of structural features of the '<em>Kind Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KIND_TEST_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.DocumentTestImpl <em>Document Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.DocumentTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDocumentTest()
   * @generated
   */
	int DOCUMENT_TEST = 86;

	/**
   * The feature id for the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOCUMENT_TEST__TEST = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Document Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOCUMENT_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.ElementTestImpl <em>Element Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.ElementTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getElementTest()
   * @generated
   */
	int ELEMENT_TEST = 87;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TEST__NAME = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TEST__WILDCARD = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TEST__TYPE = KIND_TEST_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Type Is Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TEST__TYPE_IS_OPTIONAL = KIND_TEST_FEATURE_COUNT + 3;

	/**
   * The number of structural features of the '<em>Element Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ELEMENT_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 4;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AttributeTestImpl <em>Attribute Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AttributeTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAttributeTest()
   * @generated
   */
	int ATTRIBUTE_TEST = 88;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_TEST__NAME = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_TEST__WILDCARD = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_TEST__TYPE = KIND_TEST_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Attribute Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SchemaElementTestImpl <em>Schema Element Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SchemaElementTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSchemaElementTest()
   * @generated
   */
	int SCHEMA_ELEMENT_TEST = 89;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SCHEMA_ELEMENT_TEST__NAME = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Schema Element Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SCHEMA_ELEMENT_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.SchemaAttributeTestImpl <em>Schema Attribute Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.SchemaAttributeTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSchemaAttributeTest()
   * @generated
   */
	int SCHEMA_ATTRIBUTE_TEST = 90;

	/**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SCHEMA_ATTRIBUTE_TEST__NAME = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Schema Attribute Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SCHEMA_ATTRIBUTE_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.PITestImpl <em>PI Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.PITestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPITest()
   * @generated
   */
	int PI_TEST = 91;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PI_TEST__NAME = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PI_TEST__LITERAL = KIND_TEST_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>PI Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PI_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CommentTestImpl <em>Comment Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CommentTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCommentTest()
   * @generated
   */
	int COMMENT_TEST = 92;

	/**
   * The number of structural features of the '<em>Comment Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMMENT_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.TextTestImpl <em>Text Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.TextTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTextTest()
   * @generated
   */
	int TEXT_TEST = 93;

	/**
   * The number of structural features of the '<em>Text Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TEXT_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.AnyKindTestImpl <em>Any Kind Test</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.AnyKindTestImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyKindTest()
   * @generated
   */
	int ANY_KIND_TEST = 94;

	/**
   * The number of structural features of the '<em>Any Kind Test</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANY_KIND_TEST_FEATURE_COUNT = KIND_TEST_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.CommentImpl <em>Comment</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.CommentImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComment()
   * @generated
   */
	int COMMENT = 95;

	/**
   * The feature id for the '<em><b>Text</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMMENT__TEXT = 0;

	/**
   * The feature id for the '<em><b>Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMMENT__COMMENT = 1;

	/**
   * The number of structural features of the '<em>Comment</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMMENT_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.impl.QNameImpl <em>QName</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.impl.QNameImpl
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQName()
   * @generated
   */
	int QNAME = 96;

	/**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QNAME__PREFIX = 0;

	/**
   * The feature id for the '<em><b>Local Part</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QNAME__LOCAL_PART = 1;

	/**
   * The number of structural features of the '<em>QName</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QNAME_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.PathSeparatorKind <em>Path Separator Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.PathSeparatorKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathSeparatorKind()
   * @generated
   */
	int PATH_SEPARATOR_KIND = 97;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.ForwardAxisKind <em>Forward Axis Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.ForwardAxisKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardAxisKind()
   * @generated
   */
	int FORWARD_AXIS_KIND = 98;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.ReverseAxisKind <em>Reverse Axis Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.ReverseAxisKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseAxisKind()
   * @generated
   */
	int REVERSE_AXIS_KIND = 99;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.UnionOp <em>Union Op</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.UnionOp
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionOp()
   * @generated
   */
	int UNION_OP = 100;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.AdditiveOpKind <em>Additive Op Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.AdditiveOpKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveOpKind()
   * @generated
   */
	int ADDITIVE_OP_KIND = 101;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.MultiplicativeOpKind <em>Multiplicative Op Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.MultiplicativeOpKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeOpKind()
   * @generated
   */
	int MULTIPLICATIVE_OP_KIND = 102;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.QuantifierKind <em>Quantifier Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.QuantifierKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQuantifierKind()
   * @generated
   */
	int QUANTIFIER_KIND = 103;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.IntersectExceptOpKind <em>Intersect Except Op Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.IntersectExceptOpKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptOpKind()
   * @generated
   */
	int INTERSECT_EXCEPT_OP_KIND = 104;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.UnaryOp <em>Unary Op</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.UnaryOp
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryOp()
   * @generated
   */
	int UNARY_OP = 105;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.GeneralCompKind <em>General Comp Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.GeneralCompKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralCompKind()
   * @generated
   */
	int GENERAL_COMP_KIND = 106;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.ValueCompKind <em>Value Comp Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.ValueCompKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueCompKind()
   * @generated
   */
	int VALUE_COMP_KIND = 107;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.NodeCompKind <em>Node Comp Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.NodeCompKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeCompKind()
   * @generated
   */
	int NODE_COMP_KIND = 108;

	/**
   * The meta object id for the '{@link org.emftext.language.xpath2.OccurrenceIndicatorKind <em>Occurrence Indicator Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.xpath2.OccurrenceIndicatorKind
   * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOccurrenceIndicatorKind()
   * @generated
   */
	int OCCURRENCE_INDICATOR_KIND = 109;


	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see org.emftext.language.xpath2.Expr
   * @generated
   */
	EClass getExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.Expr#getOwnedExprSingle <em>Owned Expr Single</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Expr Single</em>'.
   * @see org.emftext.language.xpath2.Expr#getOwnedExprSingle()
   * @see #getExpr()
   * @generated
   */
	EReference getExpr_OwnedExprSingle();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ExprSingle <em>Expr Single</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Single</em>'.
   * @see org.emftext.language.xpath2.ExprSingle
   * @generated
   */
	EClass getExprSingle();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ForExpr <em>For Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Expr</em>'.
   * @see org.emftext.language.xpath2.ForExpr
   * @generated
   */
	EClass getForExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ForExpr#getOwnedSimpleForClause <em>Owned Simple For Clause</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Simple For Clause</em>'.
   * @see org.emftext.language.xpath2.ForExpr#getOwnedSimpleForClause()
   * @see #getForExpr()
   * @generated
   */
	EReference getForExpr_OwnedSimpleForClause();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ForExpr#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see org.emftext.language.xpath2.ForExpr#getReturn()
   * @see #getForExpr()
   * @generated
   */
	EReference getForExpr_Return();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.QuantifiedExpr <em>Quantified Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quantified Expr</em>'.
   * @see org.emftext.language.xpath2.QuantifiedExpr
   * @generated
   */
	EClass getQuantifiedExpr();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.QuantifiedExpr#getQuantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quantifier</em>'.
   * @see org.emftext.language.xpath2.QuantifiedExpr#getQuantifier()
   * @see #getQuantifiedExpr()
   * @generated
   */
	EAttribute getQuantifiedExpr_Quantifier();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.QuantifiedExpr#getIterator <em>Iterator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Iterator</em>'.
   * @see org.emftext.language.xpath2.QuantifiedExpr#getIterator()
   * @see #getQuantifiedExpr()
   * @generated
   */
	EReference getQuantifiedExpr_Iterator();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.QuantifiedExpr#getSatisfies <em>Satisfies</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Satisfies</em>'.
   * @see org.emftext.language.xpath2.QuantifiedExpr#getSatisfies()
   * @see #getQuantifiedExpr()
   * @generated
   */
	EReference getQuantifiedExpr_Satisfies();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.IfExpr <em>If Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Expr</em>'.
   * @see org.emftext.language.xpath2.IfExpr
   * @generated
   */
	EClass getIfExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.IfExpr#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.emftext.language.xpath2.IfExpr#getCondition()
   * @see #getIfExpr()
   * @generated
   */
	EReference getIfExpr_Condition();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.IfExpr#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see org.emftext.language.xpath2.IfExpr#getThen()
   * @see #getIfExpr()
   * @generated
   */
	EReference getIfExpr_Then();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.IfExpr#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see org.emftext.language.xpath2.IfExpr#getElse()
   * @see #getIfExpr()
   * @generated
   */
	EReference getIfExpr_Else();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SimpleForClause <em>Simple For Clause</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple For Clause</em>'.
   * @see org.emftext.language.xpath2.SimpleForClause
   * @generated
   */
	EClass getSimpleForClause();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.SimpleForClause#getIterator <em>Iterator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Iterator</em>'.
   * @see org.emftext.language.xpath2.SimpleForClause#getIterator()
   * @see #getSimpleForClause()
   * @generated
   */
	EReference getSimpleForClause_Iterator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SimpleForClauseIterator <em>Simple For Clause Iterator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple For Clause Iterator</em>'.
   * @see org.emftext.language.xpath2.SimpleForClauseIterator
   * @generated
   */
	EClass getSimpleForClauseIterator();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.SimpleForClauseIterator#getVarName <em>Var Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var Name</em>'.
   * @see org.emftext.language.xpath2.SimpleForClauseIterator#getVarName()
   * @see #getSimpleForClauseIterator()
   * @generated
   */
	EAttribute getSimpleForClauseIterator_VarName();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.SimpleForClauseIterator#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see org.emftext.language.xpath2.SimpleForClauseIterator#getList()
   * @see #getSimpleForClauseIterator()
   * @generated
   */
	EReference getSimpleForClauseIterator_List();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expr</em>'.
   * @see org.emftext.language.xpath2.OrExpr
   * @generated
   */
	EClass getOrExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.OrExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.OrExpr#getOperand()
   * @see #getOrExpr()
   * @generated
   */
	EReference getOrExpr_Operand();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.OrExprChild <em>Or Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expr Child</em>'.
   * @see org.emftext.language.xpath2.OrExprChild
   * @generated
   */
	EClass getOrExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expr</em>'.
   * @see org.emftext.language.xpath2.AndExpr
   * @generated
   */
	EClass getAndExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.AndExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.AndExpr#getOperand()
   * @see #getAndExpr()
   * @generated
   */
	EReference getAndExpr_Operand();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AndExprChild <em>And Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expr Child</em>'.
   * @see org.emftext.language.xpath2.AndExprChild
   * @generated
   */
	EClass getAndExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ComparisonExpr <em>Comparison Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comparison Expr</em>'.
   * @see org.emftext.language.xpath2.ComparisonExpr
   * @generated
   */
	EClass getComparisonExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ComparisonExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.emftext.language.xpath2.ComparisonExpr#getLeft()
   * @see #getComparisonExpr()
   * @generated
   */
	EReference getComparisonExpr_Left();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ComparisonExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.ComparisonExpr#getOperator()
   * @see #getComparisonExpr()
   * @generated
   */
	EReference getComparisonExpr_Operator();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ComparisonExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.emftext.language.xpath2.ComparisonExpr#getRight()
   * @see #getComparisonExpr()
   * @generated
   */
	EReference getComparisonExpr_Right();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ComparisonExprChild <em>Comparison Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comparison Expr Child</em>'.
   * @see org.emftext.language.xpath2.ComparisonExprChild
   * @generated
   */
	EClass getComparisonExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.RangeExpr <em>Range Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Expr</em>'.
   * @see org.emftext.language.xpath2.RangeExpr
   * @generated
   */
	EClass getRangeExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.RangeExpr#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From</em>'.
   * @see org.emftext.language.xpath2.RangeExpr#getFrom()
   * @see #getRangeExpr()
   * @generated
   */
	EReference getRangeExpr_From();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.RangeExpr#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see org.emftext.language.xpath2.RangeExpr#getTo()
   * @see #getRangeExpr()
   * @generated
   */
	EReference getRangeExpr_To();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.RangeExprChild <em>Range Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Expr Child</em>'.
   * @see org.emftext.language.xpath2.RangeExprChild
   * @generated
   */
	EClass getRangeExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AdditiveExpr <em>Additive Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expr</em>'.
   * @see org.emftext.language.xpath2.AdditiveExpr
   * @generated
   */
	EClass getAdditiveExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.AdditiveExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.AdditiveExpr#getOperand()
   * @see #getAdditiveExpr()
   * @generated
   */
	EReference getAdditiveExpr_Operand();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.AdditiveExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.AdditiveExpr#getOperator()
   * @see #getAdditiveExpr()
   * @generated
   */
	EAttribute getAdditiveExpr_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AdditiveExprChild <em>Additive Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expr Child</em>'.
   * @see org.emftext.language.xpath2.AdditiveExprChild
   * @generated
   */
	EClass getAdditiveExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expr</em>'.
   * @see org.emftext.language.xpath2.MultiplicativeExpr
   * @generated
   */
	EClass getMultiplicativeExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.MultiplicativeExpr#getOperand()
   * @see #getMultiplicativeExpr()
   * @generated
   */
	EReference getMultiplicativeExpr_Operand();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.MultiplicativeExpr#getOperator()
   * @see #getMultiplicativeExpr()
   * @generated
   */
	EAttribute getMultiplicativeExpr_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.MultiplicativeExprChild <em>Multiplicative Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expr Child</em>'.
   * @see org.emftext.language.xpath2.MultiplicativeExprChild
   * @generated
   */
	EClass getMultiplicativeExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.UnionExpr <em>Union Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Expr</em>'.
   * @see org.emftext.language.xpath2.UnionExpr
   * @generated
   */
	EClass getUnionExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.UnionExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.UnionExpr#getOperand()
   * @see #getUnionExpr()
   * @generated
   */
	EReference getUnionExpr_Operand();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.UnionExpr#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operation</em>'.
   * @see org.emftext.language.xpath2.UnionExpr#getOperation()
   * @see #getUnionExpr()
   * @generated
   */
	EAttribute getUnionExpr_Operation();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.UnionExprChild <em>Union Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Expr Child</em>'.
   * @see org.emftext.language.xpath2.UnionExprChild
   * @generated
   */
	EClass getUnionExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.IntersectExceptExpr <em>Intersect Except Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Intersect Except Expr</em>'.
   * @see org.emftext.language.xpath2.IntersectExceptExpr
   * @generated
   */
	EClass getIntersectExceptExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.IntersectExceptExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.IntersectExceptExpr#getOperand()
   * @see #getIntersectExceptExpr()
   * @generated
   */
	EReference getIntersectExceptExpr_Operand();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.IntersectExceptExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.IntersectExceptExpr#getOperator()
   * @see #getIntersectExceptExpr()
   * @generated
   */
	EAttribute getIntersectExceptExpr_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.IntersectExceptExprChild <em>Intersect Except Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Intersect Except Expr Child</em>'.
   * @see org.emftext.language.xpath2.IntersectExceptExprChild
   * @generated
   */
	EClass getIntersectExceptExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.InstanceofExpr <em>Instanceof Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instanceof Expr</em>'.
   * @see org.emftext.language.xpath2.InstanceofExpr
   * @generated
   */
	EClass getInstanceofExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.InstanceofExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.InstanceofExpr#getOperand()
   * @see #getInstanceofExpr()
   * @generated
   */
	EReference getInstanceofExpr_Operand();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.InstanceofExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.InstanceofExpr#getType()
   * @see #getInstanceofExpr()
   * @generated
   */
	EReference getInstanceofExpr_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.InstanceofExprChild <em>Instanceof Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instanceof Expr Child</em>'.
   * @see org.emftext.language.xpath2.InstanceofExprChild
   * @generated
   */
	EClass getInstanceofExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.TreatExpr <em>Treat Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Treat Expr</em>'.
   * @see org.emftext.language.xpath2.TreatExpr
   * @generated
   */
	EClass getTreatExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.TreatExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.TreatExpr#getOperand()
   * @see #getTreatExpr()
   * @generated
   */
	EReference getTreatExpr_Operand();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.TreatExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.TreatExpr#getType()
   * @see #getTreatExpr()
   * @generated
   */
	EReference getTreatExpr_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.TreatExprChild <em>Treat Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Treat Expr Child</em>'.
   * @see org.emftext.language.xpath2.TreatExprChild
   * @generated
   */
	EClass getTreatExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.CastableExpr <em>Castable Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Castable Expr</em>'.
   * @see org.emftext.language.xpath2.CastableExpr
   * @generated
   */
	EClass getCastableExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.CastableExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.CastableExpr#getOperand()
   * @see #getCastableExpr()
   * @generated
   */
	EReference getCastableExpr_Operand();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.CastableExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.CastableExpr#getType()
   * @see #getCastableExpr()
   * @generated
   */
	EReference getCastableExpr_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.CastableExprChild <em>Castable Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Castable Expr Child</em>'.
   * @see org.emftext.language.xpath2.CastableExprChild
   * @generated
   */
	EClass getCastableExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.CastExpr <em>Cast Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expr</em>'.
   * @see org.emftext.language.xpath2.CastExpr
   * @generated
   */
	EClass getCastExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.CastExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.CastExpr#getOperand()
   * @see #getCastExpr()
   * @generated
   */
	EReference getCastExpr_Operand();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.CastExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.CastExpr#getType()
   * @see #getCastExpr()
   * @generated
   */
	EReference getCastExpr_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.CastExprChild <em>Cast Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expr Child</em>'.
   * @see org.emftext.language.xpath2.CastExprChild
   * @generated
   */
	EClass getCastExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see org.emftext.language.xpath2.UnaryExpr
   * @generated
   */
	EClass getUnaryExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.UnaryExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.emftext.language.xpath2.UnaryExpr#getOperand()
   * @see #getUnaryExpr()
   * @generated
   */
	EReference getUnaryExpr_Operand();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.UnaryExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.UnaryExpr#getOperator()
   * @see #getUnaryExpr()
   * @generated
   */
	EAttribute getUnaryExpr_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.UnaryExprChild <em>Unary Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr Child</em>'.
   * @see org.emftext.language.xpath2.UnaryExprChild
   * @generated
   */
	EClass getUnaryExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ValueExpr <em>Value Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Expr</em>'.
   * @see org.emftext.language.xpath2.ValueExpr
   * @generated
   */
	EClass getValueExpr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.PathExpr <em>Path Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Expr</em>'.
   * @see org.emftext.language.xpath2.PathExpr
   * @generated
   */
	EClass getPathExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.PathExpr#getInitialSeparator <em>Initial Separator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Separator</em>'.
   * @see org.emftext.language.xpath2.PathExpr#getInitialSeparator()
   * @see #getPathExpr()
   * @generated
   */
	EReference getPathExpr_InitialSeparator();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.PathExpr#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.emftext.language.xpath2.PathExpr#getPath()
   * @see #getPathExpr()
   * @generated
   */
	EReference getPathExpr_Path();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.PathSeparator <em>Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Separator</em>'.
   * @see org.emftext.language.xpath2.PathSeparator
   * @generated
   */
	EClass getPathSeparator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SinglePathSeparator <em>Single Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Path Separator</em>'.
   * @see org.emftext.language.xpath2.SinglePathSeparator
   * @generated
   */
	EClass getSinglePathSeparator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.DoublePathSeparator <em>Double Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Path Separator</em>'.
   * @see org.emftext.language.xpath2.DoublePathSeparator
   * @generated
   */
	EClass getDoublePathSeparator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.RelativePathExpr <em>Relative Path Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relative Path Expr</em>'.
   * @see org.emftext.language.xpath2.RelativePathExpr
   * @generated
   */
	EClass getRelativePathExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.RelativePathExpr#getStep <em>Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Step</em>'.
   * @see org.emftext.language.xpath2.RelativePathExpr#getStep()
   * @see #getRelativePathExpr()
   * @generated
   */
	EReference getRelativePathExpr_Step();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.RelativePathExpr#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Separator</em>'.
   * @see org.emftext.language.xpath2.RelativePathExpr#getSeparator()
   * @see #getRelativePathExpr()
   * @generated
   */
	EReference getRelativePathExpr_Separator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.StepExpr <em>Step Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Step Expr</em>'.
   * @see org.emftext.language.xpath2.StepExpr
   * @generated
   */
	EClass getStepExpr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.FilterExpr <em>Filter Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Filter Expr</em>'.
   * @see org.emftext.language.xpath2.FilterExpr
   * @generated
   */
	EClass getFilterExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.FilterExpr#getPrimaryExpr <em>Primary Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary Expr</em>'.
   * @see org.emftext.language.xpath2.FilterExpr#getPrimaryExpr()
   * @see #getFilterExpr()
   * @generated
   */
	EReference getFilterExpr_PrimaryExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.FilterExpr#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Predicate</em>'.
   * @see org.emftext.language.xpath2.FilterExpr#getPredicate()
   * @see #getFilterExpr()
   * @generated
   */
	EReference getFilterExpr_Predicate();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AxisStep <em>Axis Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Axis Step</em>'.
   * @see org.emftext.language.xpath2.AxisStep
   * @generated
   */
	EClass getAxisStep();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AxisStep#getStep <em>Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Step</em>'.
   * @see org.emftext.language.xpath2.AxisStep#getStep()
   * @see #getAxisStep()
   * @generated
   */
	EReference getAxisStep_Step();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.AxisStep#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Predicate</em>'.
   * @see org.emftext.language.xpath2.AxisStep#getPredicate()
   * @see #getAxisStep()
   * @generated
   */
	EReference getAxisStep_Predicate();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.DirectionalStep <em>Directional Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Directional Step</em>'.
   * @see org.emftext.language.xpath2.DirectionalStep
   * @generated
   */
	EClass getDirectionalStep();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ForwardStep <em>Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Forward Step</em>'.
   * @see org.emftext.language.xpath2.ForwardStep
   * @generated
   */
	EClass getForwardStep();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ReverseStep <em>Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reverse Step</em>'.
   * @see org.emftext.language.xpath2.ReverseStep
   * @generated
   */
	EClass getReverseStep();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.GeneralForwardStep <em>General Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>General Forward Step</em>'.
   * @see org.emftext.language.xpath2.GeneralForwardStep
   * @generated
   */
	EClass getGeneralForwardStep();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.GeneralForwardStep#getAxis <em>Axis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Axis</em>'.
   * @see org.emftext.language.xpath2.GeneralForwardStep#getAxis()
   * @see #getGeneralForwardStep()
   * @generated
   */
	EReference getGeneralForwardStep_Axis();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.GeneralForwardStep#getNodeTest <em>Node Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Test</em>'.
   * @see org.emftext.language.xpath2.GeneralForwardStep#getNodeTest()
   * @see #getGeneralForwardStep()
   * @generated
   */
	EReference getGeneralForwardStep_NodeTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AbbrevForwardStep <em>Abbrev Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abbrev Forward Step</em>'.
   * @see org.emftext.language.xpath2.AbbrevForwardStep
   * @generated
   */
	EClass getAbbrevForwardStep();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.AbbrevForwardStep#isAt <em>At</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>At</em>'.
   * @see org.emftext.language.xpath2.AbbrevForwardStep#isAt()
   * @see #getAbbrevForwardStep()
   * @generated
   */
	EAttribute getAbbrevForwardStep_At();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest <em>Node Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Test</em>'.
   * @see org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest()
   * @see #getAbbrevForwardStep()
   * @generated
   */
	EReference getAbbrevForwardStep_NodeTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ForwardAxis <em>Forward Axis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Forward Axis</em>'.
   * @see org.emftext.language.xpath2.ForwardAxis
   * @generated
   */
	EClass getForwardAxis();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ForwardAxis#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.emftext.language.xpath2.ForwardAxis#getKind()
   * @see #getForwardAxis()
   * @generated
   */
	EAttribute getForwardAxis_Kind();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.GeneralReverseStep <em>General Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>General Reverse Step</em>'.
   * @see org.emftext.language.xpath2.GeneralReverseStep
   * @generated
   */
	EClass getGeneralReverseStep();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.GeneralReverseStep#getAxis <em>Axis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Axis</em>'.
   * @see org.emftext.language.xpath2.GeneralReverseStep#getAxis()
   * @see #getGeneralReverseStep()
   * @generated
   */
	EReference getGeneralReverseStep_Axis();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.GeneralReverseStep#getNodeTest <em>Node Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Test</em>'.
   * @see org.emftext.language.xpath2.GeneralReverseStep#getNodeTest()
   * @see #getGeneralReverseStep()
   * @generated
   */
	EReference getGeneralReverseStep_NodeTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AbbrevReverseStep <em>Abbrev Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abbrev Reverse Step</em>'.
   * @see org.emftext.language.xpath2.AbbrevReverseStep
   * @generated
   */
	EClass getAbbrevReverseStep();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ReverseAxis <em>Reverse Axis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reverse Axis</em>'.
   * @see org.emftext.language.xpath2.ReverseAxis
   * @generated
   */
	EClass getReverseAxis();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ReverseAxis#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.emftext.language.xpath2.ReverseAxis#getKind()
   * @see #getReverseAxis()
   * @generated
   */
	EAttribute getReverseAxis_Kind();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NodeTest <em>Node Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Test</em>'.
   * @see org.emftext.language.xpath2.NodeTest
   * @generated
   */
	EClass getNodeTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NodeKindTest <em>Node Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Kind Test</em>'.
   * @see org.emftext.language.xpath2.NodeKindTest
   * @generated
   */
	EClass getNodeKindTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.NodeKindTest#getTest <em>Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Test</em>'.
   * @see org.emftext.language.xpath2.NodeKindTest#getTest()
   * @see #getNodeKindTest()
   * @generated
   */
	EReference getNodeKindTest_Test();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NameTest <em>Name Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Test</em>'.
   * @see org.emftext.language.xpath2.NameTest
   * @generated
   */
	EClass getNameTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.QNameTest <em>QName Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>QName Test</em>'.
   * @see org.emftext.language.xpath2.QNameTest
   * @generated
   */
	EClass getQNameTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.QNameTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.QNameTest#getName()
   * @see #getQNameTest()
   * @generated
   */
	EReference getQNameTest_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard</em>'.
   * @see org.emftext.language.xpath2.Wildcard
   * @generated
   */
	EClass getWildcard();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AnyWildcard <em>Any Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any Wildcard</em>'.
   * @see org.emftext.language.xpath2.AnyWildcard
   * @generated
   */
	EClass getAnyWildcard();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.LocalNameWildcard <em>Local Name Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Name Wildcard</em>'.
   * @see org.emftext.language.xpath2.LocalNameWildcard
   * @generated
   */
	EClass getLocalNameWildcard();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.LocalNameWildcard#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.emftext.language.xpath2.LocalNameWildcard#getNamespace()
   * @see #getLocalNameWildcard()
   * @generated
   */
	EAttribute getLocalNameWildcard_Namespace();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NamespaceWildcard <em>Namespace Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Namespace Wildcard</em>'.
   * @see org.emftext.language.xpath2.NamespaceWildcard
   * @generated
   */
	EClass getNamespaceWildcard();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.NamespaceWildcard#getLocalName <em>Local Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local Name</em>'.
   * @see org.emftext.language.xpath2.NamespaceWildcard#getLocalName()
   * @see #getNamespaceWildcard()
   * @generated
   */
	EAttribute getNamespaceWildcard_LocalName();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Predicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Predicate</em>'.
   * @see org.emftext.language.xpath2.Predicate
   * @generated
   */
	EClass getPredicate();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.Predicate#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.emftext.language.xpath2.Predicate#getExpr()
   * @see #getPredicate()
   * @generated
   */
	EReference getPredicate_Expr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.PrimaryExpr <em>Primary Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expr</em>'.
   * @see org.emftext.language.xpath2.PrimaryExpr
   * @generated
   */
	EClass getPrimaryExpr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.emftext.language.xpath2.Literal
   * @generated
   */
	EClass getLiteral();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.VarRef <em>Var Ref</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Ref</em>'.
   * @see org.emftext.language.xpath2.VarRef
   * @generated
   */
	EClass getVarRef();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.VarRef#getVarName <em>Var Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Name</em>'.
   * @see org.emftext.language.xpath2.VarRef#getVarName()
   * @see #getVarRef()
   * @generated
   */
	EReference getVarRef_VarName();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.VarName <em>Var Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Name</em>'.
   * @see org.emftext.language.xpath2.VarName
   * @generated
   */
	EClass getVarName();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.VarName#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.VarName#getName()
   * @see #getVarName()
   * @generated
   */
	EReference getVarName_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ParenthesizedExpr <em>Parenthesized Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parenthesized Expr</em>'.
   * @see org.emftext.language.xpath2.ParenthesizedExpr
   * @generated
   */
	EClass getParenthesizedExpr();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ParenthesizedExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.emftext.language.xpath2.ParenthesizedExpr#getExpr()
   * @see #getParenthesizedExpr()
   * @generated
   */
	EReference getParenthesizedExpr_Expr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ContextItemExpr <em>Context Item Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Item Expr</em>'.
   * @see org.emftext.language.xpath2.ContextItemExpr
   * @generated
   */
	EClass getContextItemExpr();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see org.emftext.language.xpath2.FunctionCall
   * @generated
   */
	EClass getFunctionCall();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.FunctionCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.FunctionCall#getName()
   * @see #getFunctionCall()
   * @generated
   */
	EReference getFunctionCall_Name();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.FunctionCall#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arg</em>'.
   * @see org.emftext.language.xpath2.FunctionCall#getArg()
   * @see #getFunctionCall()
   * @generated
   */
	EReference getFunctionCall_Arg();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Literal</em>'.
   * @see org.emftext.language.xpath2.NumericLiteral
   * @generated
   */
	EClass getNumericLiteral();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.emftext.language.xpath2.StringLiteral
   * @generated
   */
	EClass getStringLiteral();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.language.xpath2.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
	EAttribute getStringLiteral_Value();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.emftext.language.xpath2.IntegerLiteral
   * @generated
   */
	EClass getIntegerLiteral();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.IntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.language.xpath2.IntegerLiteral#getValue()
   * @see #getIntegerLiteral()
   * @generated
   */
	EAttribute getIntegerLiteral_Value();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.DecimalLiteral <em>Decimal Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Literal</em>'.
   * @see org.emftext.language.xpath2.DecimalLiteral
   * @generated
   */
	EClass getDecimalLiteral();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.DecimalLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.language.xpath2.DecimalLiteral#getValue()
   * @see #getDecimalLiteral()
   * @generated
   */
	EAttribute getDecimalLiteral_Value();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.DoubleLiteral <em>Double Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Literal</em>'.
   * @see org.emftext.language.xpath2.DoubleLiteral
   * @generated
   */
	EClass getDoubleLiteral();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.DoubleLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.language.xpath2.DoubleLiteral#getValue()
   * @see #getDoubleLiteral()
   * @generated
   */
	EAttribute getDoubleLiteral_Value();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Comp <em>Comp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comp</em>'.
   * @see org.emftext.language.xpath2.Comp
   * @generated
   */
	EClass getComp();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.GeneralComp <em>General Comp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>General Comp</em>'.
   * @see org.emftext.language.xpath2.GeneralComp
   * @generated
   */
	EClass getGeneralComp();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.GeneralComp#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.GeneralComp#getOperator()
   * @see #getGeneralComp()
   * @generated
   */
	EAttribute getGeneralComp_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ValueComp <em>Value Comp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Comp</em>'.
   * @see org.emftext.language.xpath2.ValueComp
   * @generated
   */
	EClass getValueComp();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ValueComp#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.ValueComp#getOperator()
   * @see #getValueComp()
   * @generated
   */
	EAttribute getValueComp_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.NodeComp <em>Node Comp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Comp</em>'.
   * @see org.emftext.language.xpath2.NodeComp
   * @generated
   */
	EClass getNodeComp();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.NodeComp#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.emftext.language.xpath2.NodeComp#getOperator()
   * @see #getNodeComp()
   * @generated
   */
	EAttribute getNodeComp_Operator();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SingleType <em>Single Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Type</em>'.
   * @see org.emftext.language.xpath2.SingleType
   * @generated
   */
	EClass getSingleType();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.SingleType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.SingleType#getType()
   * @see #getSingleType()
   * @generated
   */
	EReference getSingleType_Type();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.SingleType#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.emftext.language.xpath2.SingleType#isOptional()
   * @see #getSingleType()
   * @generated
   */
	EAttribute getSingleType_Optional();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AtomicType <em>Atomic Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Type</em>'.
   * @see org.emftext.language.xpath2.AtomicType
   * @generated
   */
	EClass getAtomicType();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AtomicType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.AtomicType#getName()
   * @see #getAtomicType()
   * @generated
   */
	EReference getAtomicType_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SequenceType <em>Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence Type</em>'.
   * @see org.emftext.language.xpath2.SequenceType
   * @generated
   */
	EClass getSequenceType();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.EmptySequenceType <em>Empty Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Sequence Type</em>'.
   * @see org.emftext.language.xpath2.EmptySequenceType
   * @generated
   */
	EClass getEmptySequenceType();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ItemSequenceType <em>Item Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item Sequence Type</em>'.
   * @see org.emftext.language.xpath2.ItemSequenceType
   * @generated
   */
	EClass getItemSequenceType();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ItemSequenceType#getItemType <em>Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Item Type</em>'.
   * @see org.emftext.language.xpath2.ItemSequenceType#getItemType()
   * @see #getItemSequenceType()
   * @generated
   */
	EReference getItemSequenceType_ItemType();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ItemSequenceType#getOccurrence <em>Occurrence</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Occurrence</em>'.
   * @see org.emftext.language.xpath2.ItemSequenceType#getOccurrence()
   * @see #getItemSequenceType()
   * @generated
   */
	EAttribute getItemSequenceType_Occurrence();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ItemType <em>Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item Type</em>'.
   * @see org.emftext.language.xpath2.ItemType
   * @generated
   */
	EClass getItemType();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ItemKindTest <em>Item Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item Kind Test</em>'.
   * @see org.emftext.language.xpath2.ItemKindTest
   * @generated
   */
	EClass getItemKindTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ItemKindTest#getTest <em>Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Test</em>'.
   * @see org.emftext.language.xpath2.ItemKindTest#getTest()
   * @see #getItemKindTest()
   * @generated
   */
	EReference getItemKindTest_Test();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AnyItemType <em>Any Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any Item Type</em>'.
   * @see org.emftext.language.xpath2.AnyItemType
   * @generated
   */
	EClass getAnyItemType();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AtomicItemType <em>Atomic Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Item Type</em>'.
   * @see org.emftext.language.xpath2.AtomicItemType
   * @generated
   */
	EClass getAtomicItemType();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AtomicItemType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.AtomicItemType#getType()
   * @see #getAtomicItemType()
   * @generated
   */
	EReference getAtomicItemType_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.KindTest <em>Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Kind Test</em>'.
   * @see org.emftext.language.xpath2.KindTest
   * @generated
   */
	EClass getKindTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.DocumentTest <em>Document Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Test</em>'.
   * @see org.emftext.language.xpath2.DocumentTest
   * @generated
   */
	EClass getDocumentTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.DocumentTest#getTest <em>Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Test</em>'.
   * @see org.emftext.language.xpath2.DocumentTest#getTest()
   * @see #getDocumentTest()
   * @generated
   */
	EReference getDocumentTest_Test();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.ElementTest <em>Element Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Test</em>'.
   * @see org.emftext.language.xpath2.ElementTest
   * @generated
   */
	EClass getElementTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ElementTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.ElementTest#getName()
   * @see #getElementTest()
   * @generated
   */
	EReference getElementTest_Name();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ElementTest#isWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see org.emftext.language.xpath2.ElementTest#isWildcard()
   * @see #getElementTest()
   * @generated
   */
	EAttribute getElementTest_Wildcard();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.ElementTest#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.ElementTest#getType()
   * @see #getElementTest()
   * @generated
   */
	EReference getElementTest_Type();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.ElementTest#isTypeIsOptional <em>Type Is Optional</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Is Optional</em>'.
   * @see org.emftext.language.xpath2.ElementTest#isTypeIsOptional()
   * @see #getElementTest()
   * @generated
   */
	EAttribute getElementTest_TypeIsOptional();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AttributeTest <em>Attribute Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Test</em>'.
   * @see org.emftext.language.xpath2.AttributeTest
   * @generated
   */
	EClass getAttributeTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AttributeTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.AttributeTest#getName()
   * @see #getAttributeTest()
   * @generated
   */
	EReference getAttributeTest_Name();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.AttributeTest#isWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see org.emftext.language.xpath2.AttributeTest#isWildcard()
   * @see #getAttributeTest()
   * @generated
   */
	EAttribute getAttributeTest_Wildcard();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.AttributeTest#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.xpath2.AttributeTest#getType()
   * @see #getAttributeTest()
   * @generated
   */
	EReference getAttributeTest_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SchemaElementTest <em>Schema Element Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema Element Test</em>'.
   * @see org.emftext.language.xpath2.SchemaElementTest
   * @generated
   */
	EClass getSchemaElementTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.SchemaElementTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.SchemaElementTest#getName()
   * @see #getSchemaElementTest()
   * @generated
   */
	EReference getSchemaElementTest_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.SchemaAttributeTest <em>Schema Attribute Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema Attribute Test</em>'.
   * @see org.emftext.language.xpath2.SchemaAttributeTest
   * @generated
   */
	EClass getSchemaAttributeTest();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.xpath2.SchemaAttributeTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.emftext.language.xpath2.SchemaAttributeTest#getName()
   * @see #getSchemaAttributeTest()
   * @generated
   */
	EReference getSchemaAttributeTest_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.PITest <em>PI Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>PI Test</em>'.
   * @see org.emftext.language.xpath2.PITest
   * @generated
   */
	EClass getPITest();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.PITest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.xpath2.PITest#getName()
   * @see #getPITest()
   * @generated
   */
	EAttribute getPITest_Name();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.PITest#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Literal</em>'.
   * @see org.emftext.language.xpath2.PITest#getLiteral()
   * @see #getPITest()
   * @generated
   */
	EAttribute getPITest_Literal();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.CommentTest <em>Comment Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comment Test</em>'.
   * @see org.emftext.language.xpath2.CommentTest
   * @generated
   */
	EClass getCommentTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.TextTest <em>Text Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Test</em>'.
   * @see org.emftext.language.xpath2.TextTest
   * @generated
   */
	EClass getTextTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.AnyKindTest <em>Any Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any Kind Test</em>'.
   * @see org.emftext.language.xpath2.AnyKindTest
   * @generated
   */
	EClass getAnyKindTest();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.Comment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comment</em>'.
   * @see org.emftext.language.xpath2.Comment
   * @generated
   */
	EClass getComment();

	/**
   * Returns the meta object for the attribute list '{@link org.emftext.language.xpath2.Comment#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Text</em>'.
   * @see org.emftext.language.xpath2.Comment#getText()
   * @see #getComment()
   * @generated
   */
	EAttribute getComment_Text();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.xpath2.Comment#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment</em>'.
   * @see org.emftext.language.xpath2.Comment#getComment()
   * @see #getComment()
   * @generated
   */
	EReference getComment_Comment();

	/**
   * Returns the meta object for class '{@link org.emftext.language.xpath2.QName <em>QName</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>QName</em>'.
   * @see org.emftext.language.xpath2.QName
   * @generated
   */
	EClass getQName();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.QName#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see org.emftext.language.xpath2.QName#getPrefix()
   * @see #getQName()
   * @generated
   */
	EAttribute getQName_Prefix();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.xpath2.QName#getLocalPart <em>Local Part</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local Part</em>'.
   * @see org.emftext.language.xpath2.QName#getLocalPart()
   * @see #getQName()
   * @generated
   */
	EAttribute getQName_LocalPart();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.PathSeparatorKind <em>Path Separator Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Path Separator Kind</em>'.
   * @see org.emftext.language.xpath2.PathSeparatorKind
   * @generated
   */
	EEnum getPathSeparatorKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.ForwardAxisKind <em>Forward Axis Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Forward Axis Kind</em>'.
   * @see org.emftext.language.xpath2.ForwardAxisKind
   * @generated
   */
	EEnum getForwardAxisKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.ReverseAxisKind <em>Reverse Axis Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Reverse Axis Kind</em>'.
   * @see org.emftext.language.xpath2.ReverseAxisKind
   * @generated
   */
	EEnum getReverseAxisKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.UnionOp <em>Union Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Union Op</em>'.
   * @see org.emftext.language.xpath2.UnionOp
   * @generated
   */
	EEnum getUnionOp();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.AdditiveOpKind <em>Additive Op Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Op Kind</em>'.
   * @see org.emftext.language.xpath2.AdditiveOpKind
   * @generated
   */
	EEnum getAdditiveOpKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.MultiplicativeOpKind <em>Multiplicative Op Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Op Kind</em>'.
   * @see org.emftext.language.xpath2.MultiplicativeOpKind
   * @generated
   */
	EEnum getMultiplicativeOpKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.QuantifierKind <em>Quantifier Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Quantifier Kind</em>'.
   * @see org.emftext.language.xpath2.QuantifierKind
   * @generated
   */
	EEnum getQuantifierKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.IntersectExceptOpKind <em>Intersect Except Op Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Intersect Except Op Kind</em>'.
   * @see org.emftext.language.xpath2.IntersectExceptOpKind
   * @generated
   */
	EEnum getIntersectExceptOpKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.UnaryOp <em>Unary Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Op</em>'.
   * @see org.emftext.language.xpath2.UnaryOp
   * @generated
   */
	EEnum getUnaryOp();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.GeneralCompKind <em>General Comp Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>General Comp Kind</em>'.
   * @see org.emftext.language.xpath2.GeneralCompKind
   * @generated
   */
	EEnum getGeneralCompKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.ValueCompKind <em>Value Comp Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Value Comp Kind</em>'.
   * @see org.emftext.language.xpath2.ValueCompKind
   * @generated
   */
	EEnum getValueCompKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.NodeCompKind <em>Node Comp Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Node Comp Kind</em>'.
   * @see org.emftext.language.xpath2.NodeCompKind
   * @generated
   */
	EEnum getNodeCompKind();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.xpath2.OccurrenceIndicatorKind <em>Occurrence Indicator Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Occurrence Indicator Kind</em>'.
   * @see org.emftext.language.xpath2.OccurrenceIndicatorKind
   * @generated
   */
	EEnum getOccurrenceIndicatorKind();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	Xpath2Factory getXpath2Factory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getExpr()
     * @generated
     */
		EClass EXPR = eINSTANCE.getExpr();

		/**
     * The meta object literal for the '<em><b>Owned Expr Single</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference EXPR__OWNED_EXPR_SINGLE = eINSTANCE.getExpr_OwnedExprSingle();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ExprSingleImpl <em>Expr Single</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ExprSingleImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getExprSingle()
     * @generated
     */
		EClass EXPR_SINGLE = eINSTANCE.getExprSingle();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ForExprImpl <em>For Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ForExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForExpr()
     * @generated
     */
		EClass FOR_EXPR = eINSTANCE.getForExpr();

		/**
     * The meta object literal for the '<em><b>Owned Simple For Clause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE = eINSTANCE.getForExpr_OwnedSimpleForClause();

		/**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FOR_EXPR__RETURN = eINSTANCE.getForExpr_Return();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.QuantifiedExprImpl <em>Quantified Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.QuantifiedExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQuantifiedExpr()
     * @generated
     */
		EClass QUANTIFIED_EXPR = eINSTANCE.getQuantifiedExpr();

		/**
     * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute QUANTIFIED_EXPR__QUANTIFIER = eINSTANCE.getQuantifiedExpr_Quantifier();

		/**
     * The meta object literal for the '<em><b>Iterator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference QUANTIFIED_EXPR__ITERATOR = eINSTANCE.getQuantifiedExpr_Iterator();

		/**
     * The meta object literal for the '<em><b>Satisfies</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference QUANTIFIED_EXPR__SATISFIES = eINSTANCE.getQuantifiedExpr_Satisfies();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.IfExprImpl <em>If Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.IfExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIfExpr()
     * @generated
     */
		EClass IF_EXPR = eINSTANCE.getIfExpr();

		/**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_EXPR__CONDITION = eINSTANCE.getIfExpr_Condition();

		/**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_EXPR__THEN = eINSTANCE.getIfExpr_Then();

		/**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_EXPR__ELSE = eINSTANCE.getIfExpr_Else();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SimpleForClauseImpl <em>Simple For Clause</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SimpleForClauseImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSimpleForClause()
     * @generated
     */
		EClass SIMPLE_FOR_CLAUSE = eINSTANCE.getSimpleForClause();

		/**
     * The meta object literal for the '<em><b>Iterator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference SIMPLE_FOR_CLAUSE__ITERATOR = eINSTANCE.getSimpleForClause_Iterator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SimpleForClauseIteratorImpl <em>Simple For Clause Iterator</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SimpleForClauseIteratorImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSimpleForClauseIterator()
     * @generated
     */
		EClass SIMPLE_FOR_CLAUSE_ITERATOR = eINSTANCE.getSimpleForClauseIterator();

		/**
     * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute SIMPLE_FOR_CLAUSE_ITERATOR__VAR_NAME = eINSTANCE.getSimpleForClauseIterator_VarName();

		/**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference SIMPLE_FOR_CLAUSE_ITERATOR__LIST = eINSTANCE.getSimpleForClauseIterator_List();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.OrExprImpl <em>Or Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.OrExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOrExpr()
     * @generated
     */
		EClass OR_EXPR = eINSTANCE.getOrExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OR_EXPR__OPERAND = eINSTANCE.getOrExpr_Operand();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.OrExprChildImpl <em>Or Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.OrExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOrExprChild()
     * @generated
     */
		EClass OR_EXPR_CHILD = eINSTANCE.getOrExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AndExprImpl <em>And Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AndExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAndExpr()
     * @generated
     */
		EClass AND_EXPR = eINSTANCE.getAndExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AND_EXPR__OPERAND = eINSTANCE.getAndExpr_Operand();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AndExprChildImpl <em>And Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AndExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAndExprChild()
     * @generated
     */
		EClass AND_EXPR_CHILD = eINSTANCE.getAndExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ComparisonExprImpl <em>Comparison Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ComparisonExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComparisonExpr()
     * @generated
     */
		EClass COMPARISON_EXPR = eINSTANCE.getComparisonExpr();

		/**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMPARISON_EXPR__LEFT = eINSTANCE.getComparisonExpr_Left();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMPARISON_EXPR__OPERATOR = eINSTANCE.getComparisonExpr_Operator();

		/**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMPARISON_EXPR__RIGHT = eINSTANCE.getComparisonExpr_Right();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ComparisonExprChildImpl <em>Comparison Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ComparisonExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComparisonExprChild()
     * @generated
     */
		EClass COMPARISON_EXPR_CHILD = eINSTANCE.getComparisonExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.RangeExprImpl <em>Range Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.RangeExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRangeExpr()
     * @generated
     */
		EClass RANGE_EXPR = eINSTANCE.getRangeExpr();

		/**
     * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RANGE_EXPR__FROM = eINSTANCE.getRangeExpr_From();

		/**
     * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RANGE_EXPR__TO = eINSTANCE.getRangeExpr_To();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.RangeExprChildImpl <em>Range Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.RangeExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRangeExprChild()
     * @generated
     */
		EClass RANGE_EXPR_CHILD = eINSTANCE.getRangeExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AdditiveExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveExpr()
     * @generated
     */
		EClass ADDITIVE_EXPR = eINSTANCE.getAdditiveExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADDITIVE_EXPR__OPERAND = eINSTANCE.getAdditiveExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ADDITIVE_EXPR__OPERATOR = eINSTANCE.getAdditiveExpr_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AdditiveExprChildImpl <em>Additive Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AdditiveExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveExprChild()
     * @generated
     */
		EClass ADDITIVE_EXPR_CHILD = eINSTANCE.getAdditiveExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.MultiplicativeExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeExpr()
     * @generated
     */
		EClass MULTIPLICATIVE_EXPR = eINSTANCE.getMultiplicativeExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MULTIPLICATIVE_EXPR__OPERAND = eINSTANCE.getMultiplicativeExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MULTIPLICATIVE_EXPR__OPERATOR = eINSTANCE.getMultiplicativeExpr_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.MultiplicativeExprChildImpl <em>Multiplicative Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.MultiplicativeExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeExprChild()
     * @generated
     */
		EClass MULTIPLICATIVE_EXPR_CHILD = eINSTANCE.getMultiplicativeExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.UnionExprImpl <em>Union Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.UnionExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionExpr()
     * @generated
     */
		EClass UNION_EXPR = eINSTANCE.getUnionExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference UNION_EXPR__OPERAND = eINSTANCE.getUnionExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Operation</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute UNION_EXPR__OPERATION = eINSTANCE.getUnionExpr_Operation();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.UnionExprChildImpl <em>Union Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.UnionExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionExprChild()
     * @generated
     */
		EClass UNION_EXPR_CHILD = eINSTANCE.getUnionExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.IntersectExceptExprImpl <em>Intersect Except Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.IntersectExceptExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptExpr()
     * @generated
     */
		EClass INTERSECT_EXCEPT_EXPR = eINSTANCE.getIntersectExceptExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INTERSECT_EXCEPT_EXPR__OPERAND = eINSTANCE.getIntersectExceptExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INTERSECT_EXCEPT_EXPR__OPERATOR = eINSTANCE.getIntersectExceptExpr_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.IntersectExceptExprChildImpl <em>Intersect Except Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.IntersectExceptExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptExprChild()
     * @generated
     */
		EClass INTERSECT_EXCEPT_EXPR_CHILD = eINSTANCE.getIntersectExceptExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.InstanceofExprImpl <em>Instanceof Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.InstanceofExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getInstanceofExpr()
     * @generated
     */
		EClass INSTANCEOF_EXPR = eINSTANCE.getInstanceofExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INSTANCEOF_EXPR__OPERAND = eINSTANCE.getInstanceofExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INSTANCEOF_EXPR__TYPE = eINSTANCE.getInstanceofExpr_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.InstanceofExprChildImpl <em>Instanceof Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.InstanceofExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getInstanceofExprChild()
     * @generated
     */
		EClass INSTANCEOF_EXPR_CHILD = eINSTANCE.getInstanceofExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.TreatExprImpl <em>Treat Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.TreatExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTreatExpr()
     * @generated
     */
		EClass TREAT_EXPR = eINSTANCE.getTreatExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TREAT_EXPR__OPERAND = eINSTANCE.getTreatExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TREAT_EXPR__TYPE = eINSTANCE.getTreatExpr_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.TreatExprChildImpl <em>Treat Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.TreatExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTreatExprChild()
     * @generated
     */
		EClass TREAT_EXPR_CHILD = eINSTANCE.getTreatExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CastableExprImpl <em>Castable Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CastableExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastableExpr()
     * @generated
     */
		EClass CASTABLE_EXPR = eINSTANCE.getCastableExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CASTABLE_EXPR__OPERAND = eINSTANCE.getCastableExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CASTABLE_EXPR__TYPE = eINSTANCE.getCastableExpr_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CastableExprChildImpl <em>Castable Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CastableExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastableExprChild()
     * @generated
     */
		EClass CASTABLE_EXPR_CHILD = eINSTANCE.getCastableExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CastExprImpl <em>Cast Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CastExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastExpr()
     * @generated
     */
		EClass CAST_EXPR = eINSTANCE.getCastExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CAST_EXPR__OPERAND = eINSTANCE.getCastExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CAST_EXPR__TYPE = eINSTANCE.getCastExpr_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CastExprChildImpl <em>Cast Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CastExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCastExprChild()
     * @generated
     */
		EClass CAST_EXPR_CHILD = eINSTANCE.getCastExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.UnaryExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryExpr()
     * @generated
     */
		EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

		/**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference UNARY_EXPR__OPERAND = eINSTANCE.getUnaryExpr_Operand();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute UNARY_EXPR__OPERATOR = eINSTANCE.getUnaryExpr_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.UnaryExprChildImpl <em>Unary Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.UnaryExprChildImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryExprChild()
     * @generated
     */
		EClass UNARY_EXPR_CHILD = eINSTANCE.getUnaryExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ValueExprImpl <em>Value Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ValueExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueExpr()
     * @generated
     */
		EClass VALUE_EXPR = eINSTANCE.getValueExpr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.PathExprImpl <em>Path Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.PathExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathExpr()
     * @generated
     */
		EClass PATH_EXPR = eINSTANCE.getPathExpr();

		/**
     * The meta object literal for the '<em><b>Initial Separator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PATH_EXPR__INITIAL_SEPARATOR = eINSTANCE.getPathExpr_InitialSeparator();

		/**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PATH_EXPR__PATH = eINSTANCE.getPathExpr_Path();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.PathSeparatorImpl <em>Path Separator</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.PathSeparatorImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathSeparator()
     * @generated
     */
		EClass PATH_SEPARATOR = eINSTANCE.getPathSeparator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SinglePathSeparatorImpl <em>Single Path Separator</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SinglePathSeparatorImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSinglePathSeparator()
     * @generated
     */
		EClass SINGLE_PATH_SEPARATOR = eINSTANCE.getSinglePathSeparator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.DoublePathSeparatorImpl <em>Double Path Separator</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.DoublePathSeparatorImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDoublePathSeparator()
     * @generated
     */
		EClass DOUBLE_PATH_SEPARATOR = eINSTANCE.getDoublePathSeparator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.RelativePathExprImpl <em>Relative Path Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.RelativePathExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getRelativePathExpr()
     * @generated
     */
		EClass RELATIVE_PATH_EXPR = eINSTANCE.getRelativePathExpr();

		/**
     * The meta object literal for the '<em><b>Step</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATIVE_PATH_EXPR__STEP = eINSTANCE.getRelativePathExpr_Step();

		/**
     * The meta object literal for the '<em><b>Separator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATIVE_PATH_EXPR__SEPARATOR = eINSTANCE.getRelativePathExpr_Separator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.StepExprImpl <em>Step Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.StepExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getStepExpr()
     * @generated
     */
		EClass STEP_EXPR = eINSTANCE.getStepExpr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.FilterExprImpl <em>Filter Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.FilterExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getFilterExpr()
     * @generated
     */
		EClass FILTER_EXPR = eINSTANCE.getFilterExpr();

		/**
     * The meta object literal for the '<em><b>Primary Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FILTER_EXPR__PRIMARY_EXPR = eINSTANCE.getFilterExpr_PrimaryExpr();

		/**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FILTER_EXPR__PREDICATE = eINSTANCE.getFilterExpr_Predicate();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AxisStepImpl <em>Axis Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AxisStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAxisStep()
     * @generated
     */
		EClass AXIS_STEP = eINSTANCE.getAxisStep();

		/**
     * The meta object literal for the '<em><b>Step</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AXIS_STEP__STEP = eINSTANCE.getAxisStep_Step();

		/**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AXIS_STEP__PREDICATE = eINSTANCE.getAxisStep_Predicate();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.DirectionalStepImpl <em>Directional Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.DirectionalStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDirectionalStep()
     * @generated
     */
		EClass DIRECTIONAL_STEP = eINSTANCE.getDirectionalStep();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ForwardStepImpl <em>Forward Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ForwardStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardStep()
     * @generated
     */
		EClass FORWARD_STEP = eINSTANCE.getForwardStep();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ReverseStepImpl <em>Reverse Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ReverseStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseStep()
     * @generated
     */
		EClass REVERSE_STEP = eINSTANCE.getReverseStep();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.GeneralForwardStepImpl <em>General Forward Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.GeneralForwardStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralForwardStep()
     * @generated
     */
		EClass GENERAL_FORWARD_STEP = eINSTANCE.getGeneralForwardStep();

		/**
     * The meta object literal for the '<em><b>Axis</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference GENERAL_FORWARD_STEP__AXIS = eINSTANCE.getGeneralForwardStep_Axis();

		/**
     * The meta object literal for the '<em><b>Node Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference GENERAL_FORWARD_STEP__NODE_TEST = eINSTANCE.getGeneralForwardStep_NodeTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl <em>Abbrev Forward Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AbbrevForwardStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAbbrevForwardStep()
     * @generated
     */
		EClass ABBREV_FORWARD_STEP = eINSTANCE.getAbbrevForwardStep();

		/**
     * The meta object literal for the '<em><b>At</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ABBREV_FORWARD_STEP__AT = eINSTANCE.getAbbrevForwardStep_At();

		/**
     * The meta object literal for the '<em><b>Node Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ABBREV_FORWARD_STEP__NODE_TEST = eINSTANCE.getAbbrevForwardStep_NodeTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ForwardAxisImpl <em>Forward Axis</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ForwardAxisImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardAxis()
     * @generated
     */
		EClass FORWARD_AXIS = eINSTANCE.getForwardAxis();

		/**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute FORWARD_AXIS__KIND = eINSTANCE.getForwardAxis_Kind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.GeneralReverseStepImpl <em>General Reverse Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.GeneralReverseStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralReverseStep()
     * @generated
     */
		EClass GENERAL_REVERSE_STEP = eINSTANCE.getGeneralReverseStep();

		/**
     * The meta object literal for the '<em><b>Axis</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference GENERAL_REVERSE_STEP__AXIS = eINSTANCE.getGeneralReverseStep_Axis();

		/**
     * The meta object literal for the '<em><b>Node Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference GENERAL_REVERSE_STEP__NODE_TEST = eINSTANCE.getGeneralReverseStep_NodeTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AbbrevReverseStepImpl <em>Abbrev Reverse Step</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AbbrevReverseStepImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAbbrevReverseStep()
     * @generated
     */
		EClass ABBREV_REVERSE_STEP = eINSTANCE.getAbbrevReverseStep();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ReverseAxisImpl <em>Reverse Axis</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ReverseAxisImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseAxis()
     * @generated
     */
		EClass REVERSE_AXIS = eINSTANCE.getReverseAxis();

		/**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute REVERSE_AXIS__KIND = eINSTANCE.getReverseAxis_Kind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NodeTestImpl <em>Node Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NodeTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeTest()
     * @generated
     */
		EClass NODE_TEST = eINSTANCE.getNodeTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NodeKindTestImpl <em>Node Kind Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NodeKindTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeKindTest()
     * @generated
     */
		EClass NODE_KIND_TEST = eINSTANCE.getNodeKindTest();

		/**
     * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference NODE_KIND_TEST__TEST = eINSTANCE.getNodeKindTest_Test();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NameTestImpl <em>Name Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NameTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNameTest()
     * @generated
     */
		EClass NAME_TEST = eINSTANCE.getNameTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.QNameTestImpl <em>QName Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.QNameTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQNameTest()
     * @generated
     */
		EClass QNAME_TEST = eINSTANCE.getQNameTest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference QNAME_TEST__NAME = eINSTANCE.getQNameTest_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.WildcardImpl <em>Wildcard</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.WildcardImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getWildcard()
     * @generated
     */
		EClass WILDCARD = eINSTANCE.getWildcard();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AnyWildcardImpl <em>Any Wildcard</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AnyWildcardImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyWildcard()
     * @generated
     */
		EClass ANY_WILDCARD = eINSTANCE.getAnyWildcard();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.LocalNameWildcardImpl <em>Local Name Wildcard</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.LocalNameWildcardImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getLocalNameWildcard()
     * @generated
     */
		EClass LOCAL_NAME_WILDCARD = eINSTANCE.getLocalNameWildcard();

		/**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute LOCAL_NAME_WILDCARD__NAMESPACE = eINSTANCE.getLocalNameWildcard_Namespace();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NamespaceWildcardImpl <em>Namespace Wildcard</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NamespaceWildcardImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNamespaceWildcard()
     * @generated
     */
		EClass NAMESPACE_WILDCARD = eINSTANCE.getNamespaceWildcard();

		/**
     * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute NAMESPACE_WILDCARD__LOCAL_NAME = eINSTANCE.getNamespaceWildcard_LocalName();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.PredicateImpl <em>Predicate</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.PredicateImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPredicate()
     * @generated
     */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PREDICATE__EXPR = eINSTANCE.getPredicate_Expr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.PrimaryExprImpl <em>Primary Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.PrimaryExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPrimaryExpr()
     * @generated
     */
		EClass PRIMARY_EXPR = eINSTANCE.getPrimaryExpr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.LiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getLiteral()
     * @generated
     */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.VarRefImpl <em>Var Ref</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.VarRefImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getVarRef()
     * @generated
     */
		EClass VAR_REF = eINSTANCE.getVarRef();

		/**
     * The meta object literal for the '<em><b>Var Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference VAR_REF__VAR_NAME = eINSTANCE.getVarRef_VarName();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.VarNameImpl <em>Var Name</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.VarNameImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getVarName()
     * @generated
     */
		EClass VAR_NAME = eINSTANCE.getVarName();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference VAR_NAME__NAME = eINSTANCE.getVarName_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ParenthesizedExprImpl <em>Parenthesized Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ParenthesizedExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getParenthesizedExpr()
     * @generated
     */
		EClass PARENTHESIZED_EXPR = eINSTANCE.getParenthesizedExpr();

		/**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PARENTHESIZED_EXPR__EXPR = eINSTANCE.getParenthesizedExpr_Expr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ContextItemExprImpl <em>Context Item Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ContextItemExprImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getContextItemExpr()
     * @generated
     */
		EClass CONTEXT_ITEM_EXPR = eINSTANCE.getContextItemExpr();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.FunctionCallImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getFunctionCall()
     * @generated
     */
		EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FUNCTION_CALL__NAME = eINSTANCE.getFunctionCall_Name();

		/**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FUNCTION_CALL__ARG = eINSTANCE.getFunctionCall_Arg();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NumericLiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNumericLiteral()
     * @generated
     */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.StringLiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getStringLiteral()
     * @generated
     */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.IntegerLiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntegerLiteral()
     * @generated
     */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.DecimalLiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDecimalLiteral()
     * @generated
     */
		EClass DECIMAL_LITERAL = eINSTANCE.getDecimalLiteral();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DECIMAL_LITERAL__VALUE = eINSTANCE.getDecimalLiteral_Value();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.DoubleLiteralImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDoubleLiteral()
     * @generated
     */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CompImpl <em>Comp</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CompImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComp()
     * @generated
     */
		EClass COMP = eINSTANCE.getComp();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.GeneralCompImpl <em>General Comp</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.GeneralCompImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralComp()
     * @generated
     */
		EClass GENERAL_COMP = eINSTANCE.getGeneralComp();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute GENERAL_COMP__OPERATOR = eINSTANCE.getGeneralComp_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ValueCompImpl <em>Value Comp</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ValueCompImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueComp()
     * @generated
     */
		EClass VALUE_COMP = eINSTANCE.getValueComp();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute VALUE_COMP__OPERATOR = eINSTANCE.getValueComp_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.NodeCompImpl <em>Node Comp</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.NodeCompImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeComp()
     * @generated
     */
		EClass NODE_COMP = eINSTANCE.getNodeComp();

		/**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute NODE_COMP__OPERATOR = eINSTANCE.getNodeComp_Operator();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SingleTypeImpl <em>Single Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SingleTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSingleType()
     * @generated
     */
		EClass SINGLE_TYPE = eINSTANCE.getSingleType();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference SINGLE_TYPE__TYPE = eINSTANCE.getSingleType_Type();

		/**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute SINGLE_TYPE__OPTIONAL = eINSTANCE.getSingleType_Optional();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AtomicTypeImpl <em>Atomic Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AtomicTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAtomicType()
     * @generated
     */
		EClass ATOMIC_TYPE = eINSTANCE.getAtomicType();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATOMIC_TYPE__NAME = eINSTANCE.getAtomicType_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SequenceTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSequenceType()
     * @generated
     */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.EmptySequenceTypeImpl <em>Empty Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.EmptySequenceTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getEmptySequenceType()
     * @generated
     */
		EClass EMPTY_SEQUENCE_TYPE = eINSTANCE.getEmptySequenceType();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ItemSequenceTypeImpl <em>Item Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ItemSequenceTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemSequenceType()
     * @generated
     */
		EClass ITEM_SEQUENCE_TYPE = eINSTANCE.getItemSequenceType();

		/**
     * The meta object literal for the '<em><b>Item Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ITEM_SEQUENCE_TYPE__ITEM_TYPE = eINSTANCE.getItemSequenceType_ItemType();

		/**
     * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ITEM_SEQUENCE_TYPE__OCCURRENCE = eINSTANCE.getItemSequenceType_Occurrence();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ItemTypeImpl <em>Item Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ItemTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemType()
     * @generated
     */
		EClass ITEM_TYPE = eINSTANCE.getItemType();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ItemKindTestImpl <em>Item Kind Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ItemKindTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getItemKindTest()
     * @generated
     */
		EClass ITEM_KIND_TEST = eINSTANCE.getItemKindTest();

		/**
     * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ITEM_KIND_TEST__TEST = eINSTANCE.getItemKindTest_Test();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AnyItemTypeImpl <em>Any Item Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AnyItemTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyItemType()
     * @generated
     */
		EClass ANY_ITEM_TYPE = eINSTANCE.getAnyItemType();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AtomicItemTypeImpl <em>Atomic Item Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AtomicItemTypeImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAtomicItemType()
     * @generated
     */
		EClass ATOMIC_ITEM_TYPE = eINSTANCE.getAtomicItemType();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATOMIC_ITEM_TYPE__TYPE = eINSTANCE.getAtomicItemType_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.KindTestImpl <em>Kind Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.KindTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getKindTest()
     * @generated
     */
		EClass KIND_TEST = eINSTANCE.getKindTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.DocumentTestImpl <em>Document Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.DocumentTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getDocumentTest()
     * @generated
     */
		EClass DOCUMENT_TEST = eINSTANCE.getDocumentTest();

		/**
     * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DOCUMENT_TEST__TEST = eINSTANCE.getDocumentTest_Test();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.ElementTestImpl <em>Element Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.ElementTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getElementTest()
     * @generated
     */
		EClass ELEMENT_TEST = eINSTANCE.getElementTest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ELEMENT_TEST__NAME = eINSTANCE.getElementTest_Name();

		/**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ELEMENT_TEST__WILDCARD = eINSTANCE.getElementTest_Wildcard();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ELEMENT_TEST__TYPE = eINSTANCE.getElementTest_Type();

		/**
     * The meta object literal for the '<em><b>Type Is Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ELEMENT_TEST__TYPE_IS_OPTIONAL = eINSTANCE.getElementTest_TypeIsOptional();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AttributeTestImpl <em>Attribute Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AttributeTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAttributeTest()
     * @generated
     */
		EClass ATTRIBUTE_TEST = eINSTANCE.getAttributeTest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATTRIBUTE_TEST__NAME = eINSTANCE.getAttributeTest_Name();

		/**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ATTRIBUTE_TEST__WILDCARD = eINSTANCE.getAttributeTest_Wildcard();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATTRIBUTE_TEST__TYPE = eINSTANCE.getAttributeTest_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SchemaElementTestImpl <em>Schema Element Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SchemaElementTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSchemaElementTest()
     * @generated
     */
		EClass SCHEMA_ELEMENT_TEST = eINSTANCE.getSchemaElementTest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference SCHEMA_ELEMENT_TEST__NAME = eINSTANCE.getSchemaElementTest_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.SchemaAttributeTestImpl <em>Schema Attribute Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.SchemaAttributeTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getSchemaAttributeTest()
     * @generated
     */
		EClass SCHEMA_ATTRIBUTE_TEST = eINSTANCE.getSchemaAttributeTest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference SCHEMA_ATTRIBUTE_TEST__NAME = eINSTANCE.getSchemaAttributeTest_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.PITestImpl <em>PI Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.PITestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPITest()
     * @generated
     */
		EClass PI_TEST = eINSTANCE.getPITest();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute PI_TEST__NAME = eINSTANCE.getPITest_Name();

		/**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute PI_TEST__LITERAL = eINSTANCE.getPITest_Literal();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CommentTestImpl <em>Comment Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CommentTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getCommentTest()
     * @generated
     */
		EClass COMMENT_TEST = eINSTANCE.getCommentTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.TextTestImpl <em>Text Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.TextTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getTextTest()
     * @generated
     */
		EClass TEXT_TEST = eINSTANCE.getTextTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.AnyKindTestImpl <em>Any Kind Test</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.AnyKindTestImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAnyKindTest()
     * @generated
     */
		EClass ANY_KIND_TEST = eINSTANCE.getAnyKindTest();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.CommentImpl <em>Comment</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.CommentImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getComment()
     * @generated
     */
		EClass COMMENT = eINSTANCE.getComment();

		/**
     * The meta object literal for the '<em><b>Text</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute COMMENT__TEXT = eINSTANCE.getComment_Text();

		/**
     * The meta object literal for the '<em><b>Comment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMMENT__COMMENT = eINSTANCE.getComment_Comment();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.impl.QNameImpl <em>QName</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.impl.QNameImpl
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQName()
     * @generated
     */
		EClass QNAME = eINSTANCE.getQName();

		/**
     * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute QNAME__PREFIX = eINSTANCE.getQName_Prefix();

		/**
     * The meta object literal for the '<em><b>Local Part</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute QNAME__LOCAL_PART = eINSTANCE.getQName_LocalPart();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.PathSeparatorKind <em>Path Separator Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.PathSeparatorKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getPathSeparatorKind()
     * @generated
     */
		EEnum PATH_SEPARATOR_KIND = eINSTANCE.getPathSeparatorKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.ForwardAxisKind <em>Forward Axis Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.ForwardAxisKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getForwardAxisKind()
     * @generated
     */
		EEnum FORWARD_AXIS_KIND = eINSTANCE.getForwardAxisKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.ReverseAxisKind <em>Reverse Axis Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.ReverseAxisKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getReverseAxisKind()
     * @generated
     */
		EEnum REVERSE_AXIS_KIND = eINSTANCE.getReverseAxisKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.UnionOp <em>Union Op</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.UnionOp
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnionOp()
     * @generated
     */
		EEnum UNION_OP = eINSTANCE.getUnionOp();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.AdditiveOpKind <em>Additive Op Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.AdditiveOpKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getAdditiveOpKind()
     * @generated
     */
		EEnum ADDITIVE_OP_KIND = eINSTANCE.getAdditiveOpKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.MultiplicativeOpKind <em>Multiplicative Op Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.MultiplicativeOpKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getMultiplicativeOpKind()
     * @generated
     */
		EEnum MULTIPLICATIVE_OP_KIND = eINSTANCE.getMultiplicativeOpKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.QuantifierKind <em>Quantifier Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.QuantifierKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getQuantifierKind()
     * @generated
     */
		EEnum QUANTIFIER_KIND = eINSTANCE.getQuantifierKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.IntersectExceptOpKind <em>Intersect Except Op Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.IntersectExceptOpKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getIntersectExceptOpKind()
     * @generated
     */
		EEnum INTERSECT_EXCEPT_OP_KIND = eINSTANCE.getIntersectExceptOpKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.UnaryOp <em>Unary Op</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.UnaryOp
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getUnaryOp()
     * @generated
     */
		EEnum UNARY_OP = eINSTANCE.getUnaryOp();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.GeneralCompKind <em>General Comp Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.GeneralCompKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getGeneralCompKind()
     * @generated
     */
		EEnum GENERAL_COMP_KIND = eINSTANCE.getGeneralCompKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.ValueCompKind <em>Value Comp Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.ValueCompKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getValueCompKind()
     * @generated
     */
		EEnum VALUE_COMP_KIND = eINSTANCE.getValueCompKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.NodeCompKind <em>Node Comp Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.NodeCompKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getNodeCompKind()
     * @generated
     */
		EEnum NODE_COMP_KIND = eINSTANCE.getNodeCompKind();

		/**
     * The meta object literal for the '{@link org.emftext.language.xpath2.OccurrenceIndicatorKind <em>Occurrence Indicator Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.xpath2.OccurrenceIndicatorKind
     * @see org.emftext.language.xpath2.impl.Xpath2PackageImpl#getOccurrenceIndicatorKind()
     * @generated
     */
		EEnum OCCURRENCE_INDICATOR_KIND = eINSTANCE.getOccurrenceIndicatorKind();

	}

} //Xpath2Package
