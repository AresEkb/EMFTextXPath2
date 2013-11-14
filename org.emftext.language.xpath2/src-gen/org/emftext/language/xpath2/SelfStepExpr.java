/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Self Step Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.SelfStepExpr#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getSelfStepExpr()
 * @model
 * @generated
 */
public interface SelfStepExpr extends PathExprChild {
	/**
   * Returns the value of the '<em><b>Step</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' containment reference.
   * @see #setStep(StepExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getSelfStepExpr_Step()
   * @model containment="true" required="true"
   * @generated
   */
	StepExpr getStep();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.SelfStepExpr#getStep <em>Step</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Step</em>' containment reference.
   * @see #getStep()
   * @generated
   */
	void setStep(StepExpr value);

} // SelfStepExpr
