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

import org.emftext.language.xpath2.PathSeparator;
import org.emftext.language.xpath2.RelativePathExpr;
import org.emftext.language.xpath2.StepExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relative Path Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.RelativePathExprImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.RelativePathExprImpl#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelativePathExprImpl extends EObjectImpl implements RelativePathExpr {
	/**
   * The cached value of the '{@link #getStep() <em>Step</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStep()
   * @generated
   * @ordered
   */
	protected EList<StepExpr> step;

	/**
   * The cached value of the '{@link #getSeparator() <em>Separator</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSeparator()
   * @generated
   * @ordered
   */
	protected EList<PathSeparator> separator;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected RelativePathExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.RELATIVE_PATH_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<StepExpr> getStep() {
    if (step == null)
    {
      step = new EObjectContainmentEList<StepExpr>(StepExpr.class, this, Xpath2Package.RELATIVE_PATH_EXPR__STEP);
    }
    return step;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<PathSeparator> getSeparator() {
    if (separator == null)
    {
      separator = new EObjectContainmentEList<PathSeparator>(PathSeparator.class, this, Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR);
    }
    return separator;
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
      case Xpath2Package.RELATIVE_PATH_EXPR__STEP:
        return ((InternalEList<?>)getStep()).basicRemove(otherEnd, msgs);
      case Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR:
        return ((InternalEList<?>)getSeparator()).basicRemove(otherEnd, msgs);
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
      case Xpath2Package.RELATIVE_PATH_EXPR__STEP:
        return getStep();
      case Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR:
        return getSeparator();
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
      case Xpath2Package.RELATIVE_PATH_EXPR__STEP:
        getStep().clear();
        getStep().addAll((Collection<? extends StepExpr>)newValue);
        return;
      case Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR:
        getSeparator().clear();
        getSeparator().addAll((Collection<? extends PathSeparator>)newValue);
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
      case Xpath2Package.RELATIVE_PATH_EXPR__STEP:
        getStep().clear();
        return;
      case Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR:
        getSeparator().clear();
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
      case Xpath2Package.RELATIVE_PATH_EXPR__STEP:
        return step != null && !step.isEmpty();
      case Xpath2Package.RELATIVE_PATH_EXPR__SEPARATOR:
        return separator != null && !separator.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RelativePathExprImpl
