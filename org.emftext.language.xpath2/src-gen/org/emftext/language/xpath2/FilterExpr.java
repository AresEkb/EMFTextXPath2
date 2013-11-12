/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.FilterExpr#getPrimaryExpr <em>Primary Expr</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.FilterExpr#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getFilterExpr()
 * @model
 * @generated
 */
public interface FilterExpr extends StepExpr {
	/**
   * Returns the value of the '<em><b>Primary Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Expr</em>' containment reference.
   * @see #setPrimaryExpr(PrimaryExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getFilterExpr_PrimaryExpr()
   * @model containment="true" required="true"
   * @generated
   */
	PrimaryExpr getPrimaryExpr();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.FilterExpr#getPrimaryExpr <em>Primary Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Expr</em>' containment reference.
   * @see #getPrimaryExpr()
   * @generated
   */
	void setPrimaryExpr(PrimaryExpr value);

	/**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.Predicate}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getFilterExpr_Predicate()
   * @model containment="true"
   * @generated
   */
	EList<Predicate> getPredicate();

} // FilterExpr
