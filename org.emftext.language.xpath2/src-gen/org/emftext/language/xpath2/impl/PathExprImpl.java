/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.PathExpr;
import org.emftext.language.xpath2.PathSeparator;
import org.emftext.language.xpath2.RelativePathExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.PathExprImpl#getInitialSeparator <em>Initial Separator</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.PathExprImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathExprImpl extends ValueExprImpl implements PathExpr {
	/**
   * The cached value of the '{@link #getInitialSeparator() <em>Initial Separator</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInitialSeparator()
   * @generated
   * @ordered
   */
	protected PathSeparator initialSeparator;

	/**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
	protected RelativePathExpr path;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected PathExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.PATH_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PathSeparator getInitialSeparator() {
    return initialSeparator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetInitialSeparator(PathSeparator newInitialSeparator, NotificationChain msgs) {
    PathSeparator oldInitialSeparator = initialSeparator;
    initialSeparator = newInitialSeparator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR, oldInitialSeparator, newInitialSeparator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setInitialSeparator(PathSeparator newInitialSeparator) {
    if (newInitialSeparator != initialSeparator)
    {
      NotificationChain msgs = null;
      if (initialSeparator != null)
        msgs = ((InternalEObject)initialSeparator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR, null, msgs);
      if (newInitialSeparator != null)
        msgs = ((InternalEObject)newInitialSeparator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR, null, msgs);
      msgs = basicSetInitialSeparator(newInitialSeparator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR, newInitialSeparator, newInitialSeparator));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RelativePathExpr getPath() {
    return path;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetPath(RelativePathExpr newPath, NotificationChain msgs) {
    RelativePathExpr oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.PATH_EXPR__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setPath(RelativePathExpr newPath) {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.PATH_EXPR__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.PATH_EXPR__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.PATH_EXPR__PATH, newPath, newPath));
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
      case Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR:
        return basicSetInitialSeparator(null, msgs);
      case Xpath2Package.PATH_EXPR__PATH:
        return basicSetPath(null, msgs);
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
      case Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR:
        return getInitialSeparator();
      case Xpath2Package.PATH_EXPR__PATH:
        return getPath();
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
      case Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR:
        setInitialSeparator((PathSeparator)newValue);
        return;
      case Xpath2Package.PATH_EXPR__PATH:
        setPath((RelativePathExpr)newValue);
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
      case Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR:
        setInitialSeparator((PathSeparator)null);
        return;
      case Xpath2Package.PATH_EXPR__PATH:
        setPath((RelativePathExpr)null);
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
      case Xpath2Package.PATH_EXPR__INITIAL_SEPARATOR:
        return initialSeparator != null;
      case Xpath2Package.PATH_EXPR__PATH:
        return path != null;
    }
    return super.eIsSet(featureID);
  }

} //PathExprImpl
