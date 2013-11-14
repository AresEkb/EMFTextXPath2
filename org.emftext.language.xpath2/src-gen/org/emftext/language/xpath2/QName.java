/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QName</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.QName#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.QName#getLocalPart <em>Local Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getQName()
 * @model
 * @generated
 */
public interface QName extends EObject {
    /**
   * Returns the value of the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix</em>' attribute.
   * @see #setPrefix(String)
   * @see org.emftext.language.xpath2.Xpath2Package#getQName_Prefix()
   * @model
   * @generated
   */
    String getPrefix();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.QName#getPrefix <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' attribute.
   * @see #getPrefix()
   * @generated
   */
    void setPrefix(String value);

    /**
   * Returns the value of the '<em><b>Local Part</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Part</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Local Part</em>' attribute.
   * @see #setLocalPart(String)
   * @see org.emftext.language.xpath2.Xpath2Package#getQName_LocalPart()
   * @model default="" required="true"
   * @generated
   */
    String getLocalPart();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.QName#getLocalPart <em>Local Part</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Part</em>' attribute.
   * @see #getLocalPart()
   * @generated
   */
    void setLocalPart(String value);

} // QName
