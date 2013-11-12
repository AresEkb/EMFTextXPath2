/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Comp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ValueComp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getValueComp()
 * @model
 * @generated
 */
public interface ValueComp extends Comp {
	/**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.ValueCompKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.emftext.language.xpath2.ValueCompKind
   * @see #setOperator(ValueCompKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getValueComp_Operator()
   * @model required="true"
   * @generated
   */
	ValueCompKind getOperator();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.ValueComp#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.emftext.language.xpath2.ValueCompKind
   * @see #getOperator()
   * @generated
   */
	void setOperator(ValueCompKind value);

} // ValueComp
