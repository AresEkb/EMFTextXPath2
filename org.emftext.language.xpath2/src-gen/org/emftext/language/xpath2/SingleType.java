/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.SingleType#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.SingleType#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getSingleType()
 * @model
 * @generated
 */
public interface SingleType extends EObject {
    /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(AtomicType)
   * @see org.emftext.language.xpath2.Xpath2Package#getSingleType_Type()
   * @model containment="true" required="true"
   * @generated
   */
    AtomicType getType();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.SingleType#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
    void setType(AtomicType value);

    /**
   * Returns the value of the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' attribute.
   * @see #setOptional(boolean)
   * @see org.emftext.language.xpath2.Xpath2Package#getSingleType_Optional()
   * @model required="true"
   * @generated
   */
    boolean isOptional();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.SingleType#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
    void setOptional(boolean value);

} // SingleType
