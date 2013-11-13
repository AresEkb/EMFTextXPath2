/**
 */
package org.emftext.language.xpath2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.Iterator;
import org.emftext.language.xpath2.SimpleForClause;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple For Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.SimpleForClauseImpl#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleForClauseImpl extends EObjectImpl implements SimpleForClause {
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
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected SimpleForClauseImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.SIMPLE_FOR_CLAUSE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Iterator> getIterator() {
    if (iterator == null)
    {
      iterator = new EObjectContainmentEList<Iterator>(Iterator.class, this, Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR);
    }
    return iterator;
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
      case Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR:
        return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
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
      case Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR:
        return getIterator();
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
      case Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR:
        getIterator().clear();
        getIterator().addAll((Collection<? extends Iterator>)newValue);
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
      case Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR:
        getIterator().clear();
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
      case Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR:
        return iterator != null && !iterator.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SimpleForClauseImpl
