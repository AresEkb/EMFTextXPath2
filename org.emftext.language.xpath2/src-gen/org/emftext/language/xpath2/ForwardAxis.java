/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forward Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ForwardAxis#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getForwardAxis()
 * @model
 * @generated
 */
public interface ForwardAxis extends EObject {
	/**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.ForwardAxisKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.emftext.language.xpath2.ForwardAxisKind
   * @see #setKind(ForwardAxisKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getForwardAxis_Kind()
   * @model required="true"
   * @generated
   */
	ForwardAxisKind getKind();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.ForwardAxis#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.emftext.language.xpath2.ForwardAxisKind
   * @see #getKind()
   * @generated
   */
	void setKind(ForwardAxisKind value);

} // ForwardAxis
