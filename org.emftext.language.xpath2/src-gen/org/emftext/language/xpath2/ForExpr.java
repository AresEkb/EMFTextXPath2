/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ForExpr#getOwnedSimpleForClause <em>Owned Simple For Clause</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.ForExpr#getReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getForExpr()
 * @model
 * @generated
 */
public interface ForExpr extends ExprSingle {
	/**
   * Returns the value of the '<em><b>Owned Simple For Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Simple For Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Simple For Clause</em>' containment reference.
   * @see #setOwnedSimpleForClause(SimpleForClause)
   * @see org.emftext.language.xpath2.Xpath2Package#getForExpr_OwnedSimpleForClause()
   * @model containment="true" required="true"
   * @generated
   */
	SimpleForClause getOwnedSimpleForClause();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.ForExpr#getOwnedSimpleForClause <em>Owned Simple For Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Simple For Clause</em>' containment reference.
   * @see #getOwnedSimpleForClause()
   * @generated
   */
	void setOwnedSimpleForClause(SimpleForClause value);

	/**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getForExpr_Return()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getReturn();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.ForExpr#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
	void setReturn(ExprSingle value);

} // ForExpr
