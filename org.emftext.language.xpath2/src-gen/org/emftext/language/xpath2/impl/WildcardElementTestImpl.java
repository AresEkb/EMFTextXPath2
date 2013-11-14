/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.QName;
import org.emftext.language.xpath2.WildcardElementTest;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wildcard Element Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.WildcardElementTestImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.WildcardElementTestImpl#isTypeIsOptional <em>Type Is Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WildcardElementTestImpl extends ElementTestImpl implements WildcardElementTest {
    /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
    protected QName type;

    /**
   * The default value of the '{@link #isTypeIsOptional() <em>Type Is Optional</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isTypeIsOptional()
   * @generated
   * @ordered
   */
    protected static final boolean TYPE_IS_OPTIONAL_EDEFAULT = false;

    /**
   * The cached value of the '{@link #isTypeIsOptional() <em>Type Is Optional</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isTypeIsOptional()
   * @generated
   * @ordered
   */
    protected boolean typeIsOptional = TYPE_IS_OPTIONAL_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected WildcardElementTestImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Xpath2Package.Literals.WILDCARD_ELEMENT_TEST;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public QName getType() {
    return type;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public NotificationChain basicSetType(QName newType, NotificationChain msgs) {
    QName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setType(QName newType) {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE, newType, newType));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public boolean isTypeIsOptional() {
    return typeIsOptional;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setTypeIsOptional(boolean newTypeIsOptional) {
    boolean oldTypeIsOptional = typeIsOptional;
    typeIsOptional = newTypeIsOptional;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL, oldTypeIsOptional, typeIsOptional));
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
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE:
        return basicSetType(null, msgs);
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
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE:
        return getType();
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL:
        return isTypeIsOptional();
    }
    return super.eGet(featureID, resolve, coreType);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE:
        setType((QName)newValue);
        return;
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL:
        setTypeIsOptional((Boolean)newValue);
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
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE:
        setType((QName)null);
        return;
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL:
        setTypeIsOptional(TYPE_IS_OPTIONAL_EDEFAULT);
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
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE:
        return type != null;
      case Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL:
        return typeIsOptional != TYPE_IS_OPTIONAL_EDEFAULT;
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
    result.append(" (typeIsOptional: ");
    result.append(typeIsOptional);
    result.append(')');
    return result.toString();
  }

} //WildcardElementTestImpl
