/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Name Wildcard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.LocalNameWildcard#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getLocalNameWildcard()
 * @model
 * @generated
 */
public interface LocalNameWildcard extends Wildcard {
    /**
   * Returns the value of the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' attribute.
   * @see #setNamespace(String)
   * @see org.emftext.language.xpath2.Xpath2Package#getLocalNameWildcard_Namespace()
   * @model required="true"
   * @generated
   */
    String getNamespace();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.LocalNameWildcard#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' attribute.
   * @see #getNamespace()
   * @generated
   */
    void setNamespace(String value);

} // LocalNameWildcard
