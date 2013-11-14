/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.xpath2.QName;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QName</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.QNameImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.QNameImpl#getLocalPart <em>Local Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QNameImpl extends EObjectImpl implements QName {
    /**
   * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
    protected static final String PREFIX_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
    protected String prefix = PREFIX_EDEFAULT;

    /**
   * The default value of the '{@link #getLocalPart() <em>Local Part</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLocalPart()
   * @generated
   * @ordered
   */
    protected static final String LOCAL_PART_EDEFAULT = "";

    /**
   * The cached value of the '{@link #getLocalPart() <em>Local Part</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLocalPart()
   * @generated
   * @ordered
   */
    protected String localPart = LOCAL_PART_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected QNameImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Xpath2Package.Literals.QNAME;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public String getPrefix() {
    return prefix;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setPrefix(String newPrefix) {
    String oldPrefix = prefix;
    prefix = newPrefix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.QNAME__PREFIX, oldPrefix, prefix));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public String getLocalPart() {
    return localPart;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setLocalPart(String newLocalPart) {
    String oldLocalPart = localPart;
    localPart = newLocalPart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.QNAME__LOCAL_PART, oldLocalPart, localPart));
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
      case Xpath2Package.QNAME__PREFIX:
        return getPrefix();
      case Xpath2Package.QNAME__LOCAL_PART:
        return getLocalPart();
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
      case Xpath2Package.QNAME__PREFIX:
        setPrefix((String)newValue);
        return;
      case Xpath2Package.QNAME__LOCAL_PART:
        setLocalPart((String)newValue);
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
      case Xpath2Package.QNAME__PREFIX:
        setPrefix(PREFIX_EDEFAULT);
        return;
      case Xpath2Package.QNAME__LOCAL_PART:
        setLocalPart(LOCAL_PART_EDEFAULT);
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
      case Xpath2Package.QNAME__PREFIX:
        return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
      case Xpath2Package.QNAME__LOCAL_PART:
        return LOCAL_PART_EDEFAULT == null ? localPart != null : !LOCAL_PART_EDEFAULT.equals(localPart);
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
    result.append(" (prefix: ");
    result.append(prefix);
    result.append(", localPart: ");
    result.append(localPart);
    result.append(')');
    return result.toString();
  }

} //QNameImpl
