/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abbrev Forward Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.AbbrevForwardStep#isAt <em>At</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getAbbrevForwardStep()
 * @model
 * @generated
 */
public interface AbbrevForwardStep extends ForwardStep {
	/**
   * Returns the value of the '<em><b>At</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>At</em>' attribute.
   * @see #setAt(boolean)
   * @see org.emftext.language.xpath2.Xpath2Package#getAbbrevForwardStep_At()
   * @model required="true"
   * @generated
   */
	boolean isAt();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.AbbrevForwardStep#isAt <em>At</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>At</em>' attribute.
   * @see #isAt()
   * @generated
   */
	void setAt(boolean value);

	/**
   * Returns the value of the '<em><b>Node Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Test</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Node Test</em>' containment reference.
   * @see #setNodeTest(NodeTest)
   * @see org.emftext.language.xpath2.Xpath2Package#getAbbrevForwardStep_NodeTest()
   * @model containment="true" required="true"
   * @generated
   */
	NodeTest getNodeTest();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest <em>Node Test</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Test</em>' containment reference.
   * @see #getNodeTest()
   * @generated
   */
	void setNodeTest(NodeTest value);

} // AbbrevForwardStep
