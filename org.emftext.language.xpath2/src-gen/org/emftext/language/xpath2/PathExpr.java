/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.PathExpr#getInitialSeparator <em>Initial Separator</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.PathExpr#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getPathExpr()
 * @model
 * @generated
 */
public interface PathExpr extends ValueExpr {
	/**
   * Returns the value of the '<em><b>Initial Separator</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Separator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Separator</em>' containment reference.
   * @see #setInitialSeparator(PathSeparator)
   * @see org.emftext.language.xpath2.Xpath2Package#getPathExpr_InitialSeparator()
   * @model containment="true"
   * @generated
   */
	PathSeparator getInitialSeparator();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.PathExpr#getInitialSeparator <em>Initial Separator</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Separator</em>' containment reference.
   * @see #getInitialSeparator()
   * @generated
   */
	void setInitialSeparator(PathSeparator value);

	/**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(RelativePathExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getPathExpr_Path()
   * @model containment="true"
   * @generated
   */
	RelativePathExpr getPath();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.PathExpr#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
	void setPath(RelativePathExpr value);

} // PathExpr
