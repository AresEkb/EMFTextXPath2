/**
 */
package org.emftext.language.xpath2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.UnionExpr;
import org.emftext.language.xpath2.UnionExprChild;
import org.emftext.language.xpath2.UnionOp;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Union Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.UnionExprImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.UnionExprImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnionExprImpl extends MultiplicativeExprChildImpl implements UnionExpr {
    /**
   * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
    protected EList<UnionExprChild> operand;

    /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
    protected EList<UnionOp> operation;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected UnionExprImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Xpath2Package.Literals.UNION_EXPR;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public EList<UnionExprChild> getOperand() {
    if (operand == null)
    {
      operand = new EObjectContainmentEList<UnionExprChild>(UnionExprChild.class, this, Xpath2Package.UNION_EXPR__OPERAND);
    }
    return operand;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public EList<UnionOp> getOperation() {
    if (operation == null)
    {
      operation = new EDataTypeUniqueEList<UnionOp>(UnionOp.class, this, Xpath2Package.UNION_EXPR__OPERATION);
    }
    return operation;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case Xpath2Package.UNION_EXPR__OPERAND:
        return ((InternalEList<?>)getOperand()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case Xpath2Package.UNION_EXPR__OPERAND:
        return getOperand();
      case Xpath2Package.UNION_EXPR__OPERATION:
        return getOperation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case Xpath2Package.UNION_EXPR__OPERAND:
        getOperand().clear();
        getOperand().addAll((Collection<? extends UnionExprChild>)newValue);
        return;
      case Xpath2Package.UNION_EXPR__OPERATION:
        getOperation().clear();
        getOperation().addAll((Collection<? extends UnionOp>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eUnset(int featureID) {
    switch (featureID)
    {
      case Xpath2Package.UNION_EXPR__OPERAND:
        getOperand().clear();
        return;
      case Xpath2Package.UNION_EXPR__OPERATION:
        getOperation().clear();
        return;
    }
    super.eUnset(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case Xpath2Package.UNION_EXPR__OPERAND:
        return operand != null && !operand.isEmpty();
      case Xpath2Package.UNION_EXPR__OPERATION:
        return operation != null && !operation.isEmpty();
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operation: ");
    result.append(operation);
    result.append(')');
    return result.toString();
  }

} //UnionExprImpl
