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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.Iterator;
import org.emftext.language.xpath2.VarName;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.IteratorImpl#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.IteratorImpl#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IteratorImpl extends EObjectImpl implements Iterator {
	/**
   * The cached value of the '{@link #getVarName() <em>Var Name</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVarName()
   * @generated
   * @ordered
   */
	protected VarName varName;

	/**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
	protected ExprSingle list;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IteratorImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.ITERATOR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public VarName getVarName() {
    return varName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetVarName(VarName newVarName, NotificationChain msgs) {
    VarName oldVarName = varName;
    varName = newVarName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.ITERATOR__VAR_NAME, oldVarName, newVarName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setVarName(VarName newVarName) {
    if (newVarName != varName)
    {
      NotificationChain msgs = null;
      if (varName != null)
        msgs = ((InternalEObject)varName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ITERATOR__VAR_NAME, null, msgs);
      if (newVarName != null)
        msgs = ((InternalEObject)newVarName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ITERATOR__VAR_NAME, null, msgs);
      msgs = basicSetVarName(newVarName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.ITERATOR__VAR_NAME, newVarName, newVarName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExprSingle getList() {
    return list;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetList(ExprSingle newList, NotificationChain msgs) {
    ExprSingle oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.ITERATOR__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setList(ExprSingle newList) {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ITERATOR__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ITERATOR__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.ITERATOR__LIST, newList, newList));
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
      case Xpath2Package.ITERATOR__VAR_NAME:
        return basicSetVarName(null, msgs);
      case Xpath2Package.ITERATOR__LIST:
        return basicSetList(null, msgs);
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
      case Xpath2Package.ITERATOR__VAR_NAME:
        return getVarName();
      case Xpath2Package.ITERATOR__LIST:
        return getList();
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
      case Xpath2Package.ITERATOR__VAR_NAME:
        setVarName((VarName)newValue);
        return;
      case Xpath2Package.ITERATOR__LIST:
        setList((ExprSingle)newValue);
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
      case Xpath2Package.ITERATOR__VAR_NAME:
        setVarName((VarName)null);
        return;
      case Xpath2Package.ITERATOR__LIST:
        setList((ExprSingle)null);
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
      case Xpath2Package.ITERATOR__VAR_NAME:
        return varName != null;
      case Xpath2Package.ITERATOR__LIST:
        return list != null;
    }
    return super.eIsSet(featureID);
  }

} //IteratorImpl
