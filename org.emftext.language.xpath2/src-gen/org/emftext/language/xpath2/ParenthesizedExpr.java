/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parenthesized Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ParenthesizedExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getParenthesizedExpr()
 * @model
 * @generated
 */
public interface ParenthesizedExpr extends PrimaryExpr {
    /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(ParenthesizedExprChild)
   * @see org.emftext.language.xpath2.Xpath2Package#getParenthesizedExpr_Expr()
   * @model containment="true"
   * @generated
   */
    ParenthesizedExprChild getExpr();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.ParenthesizedExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
    void setExpr(ParenthesizedExprChild value);

} // ParenthesizedExpr
