/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tail Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.TailPathExpr#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getTailPathExpr()
 * @model abstract="true"
 * @generated
 */
public interface TailPathExpr extends EObject {
	/**
   * Returns the value of the '<em><b>Step Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Step Expression</em>' containment reference.
   * @see #setStepExpression(StepExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getTailPathExpr_StepExpression()
   * @model containment="true" required="true"
   * @generated
   */
	StepExpr getStepExpression();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.TailPathExpr#getStepExpression <em>Step Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Step Expression</em>' containment reference.
   * @see #getStepExpression()
   * @generated
   */
	void setStepExpression(StepExpr value);

} // TailPathExpr
