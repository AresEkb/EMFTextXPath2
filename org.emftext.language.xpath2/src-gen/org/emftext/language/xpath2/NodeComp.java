/**
 */
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Comp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.NodeComp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getNodeComp()
 * @model
 * @generated
 */
public interface NodeComp extends Comp {
    /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.NodeCompKind}.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.emftext.language.xpath2.NodeCompKind
   * @see #setOperator(NodeCompKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getNodeComp_Operator()
   * @model required="true"
   * @generated
   */
    NodeCompKind getOperator();

    /**
   * Sets the value of the '{@link org.emftext.language.xpath2.NodeComp#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.emftext.language.xpath2.NodeCompKind
   * @see #getOperator()
   * @generated
   */
    void setOperator(NodeCompKind value);

} // NodeComp
