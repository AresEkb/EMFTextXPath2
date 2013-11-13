/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.SinglePathExpr#getRelativePathExpr <em>Relative Path Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getSinglePathExpr()
 * @model
 * @generated
 */
public interface SinglePathExpr extends PathExpr {
	/**
   * Returns the value of the '<em><b>Relative Path Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Path Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Relative Path Expr</em>' containment reference.
   * @see #setRelativePathExpr(RelativePathExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getSinglePathExpr_RelativePathExpr()
   * @model containment="true"
   * @generated
   */
	RelativePathExpr getRelativePathExpr();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.SinglePathExpr#getRelativePathExpr <em>Relative Path Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relative Path Expr</em>' containment reference.
   * @see #getRelativePathExpr()
   * @generated
   */
	void setRelativePathExpr(RelativePathExpr value);

} // SinglePathExpr
