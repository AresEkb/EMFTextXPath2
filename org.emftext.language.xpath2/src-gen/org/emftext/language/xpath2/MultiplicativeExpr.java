/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getMultiplicativeExpr()
 * @model
 * @generated
 */
public interface MultiplicativeExpr extends AdditiveExprChild {
	/**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.MultiplicativeExprChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getMultiplicativeExpr_Operand()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<MultiplicativeExprChild> getOperand();

	/**
   * Returns the value of the '<em><b>Operator</b></em>' attribute list.
   * The list contents are of type {@link org.emftext.language.xpath2.MultiplicativeOpKind}.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.MultiplicativeOpKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute list.
   * @see org.emftext.language.xpath2.MultiplicativeOpKind
   * @see org.emftext.language.xpath2.Xpath2Package#getMultiplicativeExpr_Operator()
   * @model required="true"
   * @generated
   */
	EList<MultiplicativeOpKind> getOperator();

} // MultiplicativeExpr
