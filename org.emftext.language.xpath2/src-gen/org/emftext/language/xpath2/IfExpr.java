/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.IfExpr#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.IfExpr#getThen <em>Then</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.IfExpr#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getIfExpr()
 * @model
 * @generated
 */
public interface IfExpr extends ExprSingle {
	/**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expr)
   * @see org.emftext.language.xpath2.Xpath2Package#getIfExpr_Condition()
   * @model containment="true" required="true"
   * @generated
   */
	Expr getCondition();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.IfExpr#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
	void setCondition(Expr value);

	/**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getIfExpr_Then()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getThen();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.IfExpr#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
	void setThen(ExprSingle value);

	/**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getIfExpr_Else()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getElse();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.IfExpr#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
	void setElse(ExprSingle value);

} // IfExpr
