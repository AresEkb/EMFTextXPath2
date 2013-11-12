/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.DocumentTest#getTest <em>Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getDocumentTest()
 * @model
 * @generated
 */
public interface DocumentTest extends KindTest {
	/**
   * Returns the value of the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Test</em>' containment reference.
   * @see #setTest(KindTest)
   * @see org.emftext.language.xpath2.Xpath2Package#getDocumentTest_Test()
   * @model containment="true"
   * @generated
   */
	KindTest getTest();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.DocumentTest#getTest <em>Test</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Test</em>' containment reference.
   * @see #getTest()
   * @generated
   */
	void setTest(KindTest value);

} // DocumentTest
