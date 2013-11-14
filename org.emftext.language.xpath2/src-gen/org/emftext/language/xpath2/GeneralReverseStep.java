/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Reverse Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.GeneralReverseStep#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.GeneralReverseStep#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getGeneralReverseStep()
 * @model
 * @generated
 */
public interface GeneralReverseStep extends ReverseStep {
	/**
   * Returns the value of the '<em><b>Axis</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.ReverseAxisKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Axis</em>' attribute.
   * @see org.emftext.language.xpath2.ReverseAxisKind
   * @see #setAxis(ReverseAxisKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getGeneralReverseStep_Axis()
   * @model required="true"
   * @generated
   */
	ReverseAxisKind getAxis();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.GeneralReverseStep#getAxis <em>Axis</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Axis</em>' attribute.
   * @see org.emftext.language.xpath2.ReverseAxisKind
   * @see #getAxis()
   * @generated
   */
	void setAxis(ReverseAxisKind value);

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
   * @see org.emftext.language.xpath2.Xpath2Package#getGeneralReverseStep_NodeTest()
   * @model containment="true" required="true"
   * @generated
   */
	NodeTest getNodeTest();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.GeneralReverseStep#getNodeTest <em>Node Test</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Test</em>' containment reference.
   * @see #getNodeTest()
   * @generated
   */
	void setNodeTest(NodeTest value);

} // GeneralReverseStep
