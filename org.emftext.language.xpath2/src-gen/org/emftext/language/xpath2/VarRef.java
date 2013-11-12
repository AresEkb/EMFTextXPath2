/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.VarRef#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getVarRef()
 * @model
 * @generated
 */
public interface VarRef extends PrimaryExpr {
	/**
   * Returns the value of the '<em><b>Var Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Var Name</em>' containment reference.
   * @see #setVarName(VarName)
   * @see org.emftext.language.xpath2.Xpath2Package#getVarRef_VarName()
   * @model containment="true" required="true"
   * @generated
   */
	VarName getVarName();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.VarRef#getVarName <em>Var Name</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Name</em>' containment reference.
   * @see #getVarName()
   * @generated
   */
	void setVarName(VarName value);

} // VarRef
