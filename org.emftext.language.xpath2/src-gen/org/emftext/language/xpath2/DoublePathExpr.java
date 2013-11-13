/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.DoublePathExpr#getRelativePathExpr <em>Relative Path Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getDoublePathExpr()
 * @model
 * @generated
 */
public interface DoublePathExpr extends PathExpr {
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
   * @see org.emftext.language.xpath2.Xpath2Package#getDoublePathExpr_RelativePathExpr()
   * @model containment="true" required="true"
   * @generated
   */
	RelativePathExpr getRelativePathExpr();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.DoublePathExpr#getRelativePathExpr <em>Relative Path Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relative Path Expr</em>' containment reference.
   * @see #getRelativePathExpr()
   * @generated
   */
	void setRelativePathExpr(RelativePathExpr value);

} // DoublePathExpr
