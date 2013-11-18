/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
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

import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.Iterator;
import org.emftext.language.xpath2.QuantifiedExpr;
import org.emftext.language.xpath2.QuantifierKind;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quantified Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.QuantifiedExprImpl#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.QuantifiedExprImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.QuantifiedExprImpl#getSatisfies <em>Satisfies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuantifiedExprImpl extends ExprSingleImpl implements QuantifiedExpr {
	/**
   * The default value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
	protected static final QuantifierKind QUANTIFIER_EDEFAULT = QuantifierKind.SOME;

	/**
   * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
	protected QuantifierKind quantifier = QUANTIFIER_EDEFAULT;

	/**
   * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIterator()
   * @generated
   * @ordered
   */
	protected EList<Iterator> iterator;

	/**
   * The cached value of the '{@link #getSatisfies() <em>Satisfies</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSatisfies()
   * @generated
   * @ordered
   */
	protected ExprSingle satisfies;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected QuantifiedExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.QUANTIFIED_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public QuantifierKind getQuantifier() {
    return quantifier;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setQuantifier(QuantifierKind newQuantifier) {
    QuantifierKind oldQuantifier = quantifier;
    quantifier = newQuantifier == null ? QUANTIFIER_EDEFAULT : newQuantifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER, oldQuantifier, quantifier));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Iterator> getIterator() {
    if (iterator == null)
    {
      iterator = new EObjectContainmentEList<Iterator>(Iterator.class, this, Xpath2Package.QUANTIFIED_EXPR__ITERATOR);
    }
    return iterator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExprSingle getSatisfies() {
    return satisfies;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSatisfies(ExprSingle newSatisfies, NotificationChain msgs) {
    ExprSingle oldSatisfies = satisfies;
    satisfies = newSatisfies;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.QUANTIFIED_EXPR__SATISFIES, oldSatisfies, newSatisfies);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setSatisfies(ExprSingle newSatisfies) {
    if (newSatisfies != satisfies)
    {
      NotificationChain msgs = null;
      if (satisfies != null)
        msgs = ((InternalEObject)satisfies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.QUANTIFIED_EXPR__SATISFIES, null, msgs);
      if (newSatisfies != null)
        msgs = ((InternalEObject)newSatisfies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.QUANTIFIED_EXPR__SATISFIES, null, msgs);
      msgs = basicSetSatisfies(newSatisfies, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.QUANTIFIED_EXPR__SATISFIES, newSatisfies, newSatisfies));
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
      case Xpath2Package.QUANTIFIED_EXPR__ITERATOR:
        return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
      case Xpath2Package.QUANTIFIED_EXPR__SATISFIES:
        return basicSetSatisfies(null, msgs);
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
      case Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER:
        return getQuantifier();
      case Xpath2Package.QUANTIFIED_EXPR__ITERATOR:
        return getIterator();
      case Xpath2Package.QUANTIFIED_EXPR__SATISFIES:
        return getSatisfies();
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
      case Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER:
        setQuantifier((QuantifierKind)newValue);
        return;
      case Xpath2Package.QUANTIFIED_EXPR__ITERATOR:
        getIterator().clear();
        getIterator().addAll((Collection<? extends Iterator>)newValue);
        return;
      case Xpath2Package.QUANTIFIED_EXPR__SATISFIES:
        setSatisfies((ExprSingle)newValue);
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
      case Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER:
        setQuantifier(QUANTIFIER_EDEFAULT);
        return;
      case Xpath2Package.QUANTIFIED_EXPR__ITERATOR:
        getIterator().clear();
        return;
      case Xpath2Package.QUANTIFIED_EXPR__SATISFIES:
        setSatisfies((ExprSingle)null);
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
      case Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER:
        return quantifier != QUANTIFIER_EDEFAULT;
      case Xpath2Package.QUANTIFIED_EXPR__ITERATOR:
        return iterator != null && !iterator.isEmpty();
      case Xpath2Package.QUANTIFIED_EXPR__SATISFIES:
        return satisfies != null;
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
    result.append(" (quantifier: ");
    result.append(quantifier);
    result.append(')');
    return result.toString();
  }

} //QuantifiedExprImpl
