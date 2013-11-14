/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard Element Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.WildcardElementTest#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.WildcardElementTest#isTypeIsOptional <em>Type Is Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getWildcardElementTest()
 * @model
 * @generated
 */
public interface WildcardElementTest extends ElementTest {
    /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(QName)
   * @see org.emftext.language.xpath2.Xpath2Package#getWildcardElementTest_Type()
   * @model containment="true"
   * @generated
   */
    QName getType();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.WildcardElementTest#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
    void setType(QName value);

    /**
   * Returns the value of the '<em><b>Type Is Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Is Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Type Is Optional</em>' attribute.
   * @see #setTypeIsOptional(boolean)
   * @see org.emftext.language.xpath2.Xpath2Package#getWildcardElementTest_TypeIsOptional()
   * @model
   * @generated
   */
    boolean isTypeIsOptional();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.WildcardElementTest#isTypeIsOptional <em>Type Is Optional</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Is Optional</em>' attribute.
   * @see #isTypeIsOptional()
   * @generated
   */
    void setTypeIsOptional(boolean value);

} // WildcardElementTest
