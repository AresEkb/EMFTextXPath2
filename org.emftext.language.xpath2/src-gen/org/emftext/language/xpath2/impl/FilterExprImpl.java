/**
 */
package org.emftext.language.xpath2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.FilterExpr;
import org.emftext.language.xpath2.Predicate;
import org.emftext.language.xpath2.PrimaryExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.FilterExprImpl#getPrimaryExpr <em>Primary Expr</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.FilterExprImpl#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilterExprImpl extends StepExprImpl implements FilterExpr {
    /**
   * The cached value of the '{@link #getPrimaryExpr() <em>Primary Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getPrimaryExpr()
   * @generated
   * @ordered
   */
    protected PrimaryExpr primaryExpr;

    /**
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
    protected EList<Predicate> predicate;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected FilterExprImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Xpath2Package.Literals.FILTER_EXPR;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public PrimaryExpr getPrimaryExpr() {
    return primaryExpr;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public NotificationChain basicSetPrimaryExpr(PrimaryExpr newPrimaryExpr, NotificationChain msgs) {
    PrimaryExpr oldPrimaryExpr = primaryExpr;
    primaryExpr = newPrimaryExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.FILTER_EXPR__PRIMARY_EXPR, oldPrimaryExpr, newPrimaryExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setPrimaryExpr(PrimaryExpr newPrimaryExpr) {
    if (newPrimaryExpr != primaryExpr)
    {
      NotificationChain msgs = null;
      if (primaryExpr != null)
        msgs = ((InternalEObject)primaryExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FILTER_EXPR__PRIMARY_EXPR, null, msgs);
      if (newPrimaryExpr != null)
        msgs = ((InternalEObject)newPrimaryExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FILTER_EXPR__PRIMARY_EXPR, null, msgs);
      msgs = basicSetPrimaryExpr(newPrimaryExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.FILTER_EXPR__PRIMARY_EXPR, newPrimaryExpr, newPrimaryExpr));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public EList<Predicate> getPredicate() {
    if (predicate == null)
    {
      predicate = new EObjectContainmentEList<Predicate>(Predicate.class, this, Xpath2Package.FILTER_EXPR__PREDICATE);
    }
    return predicate;
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
      case Xpath2Package.FILTER_EXPR__PRIMARY_EXPR:
        return basicSetPrimaryExpr(null, msgs);
      case Xpath2Package.FILTER_EXPR__PREDICATE:
        return ((InternalEList<?>)getPredicate()).basicRemove(otherEnd, msgs);
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
      case Xpath2Package.FILTER_EXPR__PRIMARY_EXPR:
        return getPrimaryExpr();
      case Xpath2Package.FILTER_EXPR__PREDICATE:
        return getPredicate();
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
      case Xpath2Package.FILTER_EXPR__PRIMARY_EXPR:
        setPrimaryExpr((PrimaryExpr)newValue);
        return;
      case Xpath2Package.FILTER_EXPR__PREDICATE:
        getPredicate().clear();
        getPredicate().addAll((Collection<? extends Predicate>)newValue);
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
      case Xpath2Package.FILTER_EXPR__PRIMARY_EXPR:
        setPrimaryExpr((PrimaryExpr)null);
        return;
      case Xpath2Package.FILTER_EXPR__PREDICATE:
        getPredicate().clear();
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
      case Xpath2Package.FILTER_EXPR__PRIMARY_EXPR:
        return primaryExpr != null;
      case Xpath2Package.FILTER_EXPR__PREDICATE:
        return predicate != null && !predicate.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FilterExprImpl
