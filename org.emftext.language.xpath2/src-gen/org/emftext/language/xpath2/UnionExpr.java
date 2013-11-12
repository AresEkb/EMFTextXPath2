/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.UnionExpr#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.UnionExpr#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getUnionExpr()
 * @model
 * @generated
 */
public interface UnionExpr extends MultiplicativeExprChild {
	/**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.UnionExprChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getUnionExpr_Operand()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<UnionExprChild> getOperand();

	/**
   * Returns the value of the '<em><b>Operation</b></em>' attribute list.
   * The list contents are of type {@link org.emftext.language.xpath2.UnionOp}.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.UnionOp}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' attribute list.
   * @see org.emftext.language.xpath2.UnionOp
   * @see org.emftext.language.xpath2.Xpath2Package#getUnionExpr_Operation()
   * @model required="true"
   * @generated
   */
	EList<UnionOp> getOperation();

} // UnionExpr
