/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.AxisStep#getStep <em>Step</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.AxisStep#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getAxisStep()
 * @model
 * @generated
 */
public interface AxisStep extends StepExpr {
	/**
   * Returns the value of the '<em><b>Step</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' containment reference.
   * @see #setStep(DirectionalStep)
   * @see org.emftext.language.xpath2.Xpath2Package#getAxisStep_Step()
   * @model containment="true" required="true"
   * @generated
   */
	DirectionalStep getStep();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.AxisStep#getStep <em>Step</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Step</em>' containment reference.
   * @see #getStep()
   * @generated
   */
	void setStep(DirectionalStep value);

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
   * @see org.emftext.language.xpath2.Xpath2Package#getAxisStep_Predicate()
   * @model containment="true"
   * @generated
   */
	EList<Predicate> getPredicate();

} // AxisStep
