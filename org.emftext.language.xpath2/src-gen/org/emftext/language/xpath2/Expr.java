/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.Expr#getOwnedExprSingle <em>Owned Expr Single</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getExpr()
 * @model
 * @generated
 */
public interface Expr extends EObject {
	/**
   * Returns the value of the '<em><b>Owned Expr Single</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.ExprSingle}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expr Single</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Expr Single</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getExpr_OwnedExprSingle()
   * @model containment="true" required="true"
   * @generated
   */
	EList<ExprSingle> getOwnedExprSingle();

} // Expr
