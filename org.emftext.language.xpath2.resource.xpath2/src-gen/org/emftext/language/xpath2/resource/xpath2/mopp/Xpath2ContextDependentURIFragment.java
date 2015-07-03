/**
 * Copyright (c) 2013, 2014 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <p>
 * Standard implementation of <code>IContextDependentURIFragment</code>.
 * </p>
 * 
 * @param <ContainerType> the type of the object that contains the reference which
 * shall be resolved by this fragment.
 * @param <ReferenceType> the type of the reference which shall be resolved by
 * this fragment.
 */
public abstract class Xpath2ContextDependentURIFragment<ContainerType extends EObject, ReferenceType extends EObject> implements org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment<ReferenceType> {
	
	protected String identifier;
	protected ContainerType container;
	protected EReference reference;
	protected int positionInReference;
	protected EObject proxy;
	protected org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<ReferenceType> result;
	
	private boolean resolving;
	
	public Xpath2ContextDependentURIFragment(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		this.identifier = identifier;
		this.container = container;
		this.reference = reference;
		this.positionInReference = positionInReference;
		this.proxy = proxy;
	}
	
	public boolean isResolved() {
		return result != null;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<ReferenceType> resolve() {
		if (resolving) {
			return null;
		}
		resolving = true;
		if (result == null || !result.wasResolved()) {
			result = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolveResult<ReferenceType>(false);
			// set an initial default error message
			result.setErrorMessage(getStdErrorMessage());
			
			org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> resolver = getResolver();
			// do the actual resolving
			resolver.resolve(getIdentifier(), getContainer(), getReference(), getPositionInReference(), false, result);
			
			// EMFText allows proxies to resolve to multiple objects. The first one is
			// returned, the others are added here to the reference.
			if (result.wasResolvedMultiple()) {
				handleMultipleResults();
			}
		}
		resolving = false;
		return result;
	}
	
	public abstract org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> getResolver();
	
	private void handleMultipleResults() {
		EList<EObject> list = null;
		Object temp = container.eGet(reference);
		if (temp instanceof EList<?>) {
			list = org.emftext.language.xpath2.resource.xpath2.util.Xpath2CastUtil.cast(temp);
		}
		
		boolean first = true;
		for (org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType> mapping : result.getMappings()) {
			if (first) {
				first = false;
			} else if (list != null) {
				addResultToList(mapping, proxy, list);
			} else {
				new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logError(container.eClass().getName() + "." + reference.getName() + " has multiplicity 1 but was resolved to multiple elements", null);
			}
		}
	}
	
	private void addResultToList(org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType> mapping, EObject proxy, EList<EObject> list) {
		EObject target = null;
		int proxyPosition = list.indexOf(proxy);
		
		if (mapping instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2ElementMapping<?>) {
			target = ((org.emftext.language.xpath2.resource.xpath2.IXpath2ElementMapping<ReferenceType>) mapping).getTargetElement();
		} else if (mapping instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2URIMapping<?>) {
			target = EcoreUtil.copy(proxy);
			URI uri = ((org.emftext.language.xpath2.resource.xpath2.IXpath2URIMapping<ReferenceType>) mapping).getTargetIdentifier();
			((InternalEObject) target).eSetProxyURI(uri);
		} else {
			assert false;
		}
		try {
			// if target is an another proxy and list is "unique" add() will try to resolve
			// the new proxy to check for uniqueness. There seems to be no way to avoid that.
			// Until now this does not cause any problems.
			if (proxyPosition + 1 == list.size()) {
				list.add(target);
			} else {
				list.add(proxyPosition + 1, target);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private String getStdErrorMessage() {
		String typeName = this.getReference().getEType().getName();
		String msg = typeName + " '" + identifier + "' not declared";
		return msg;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public ContainerType getContainer() {
		return container;
	}
	
	public EReference getReference() {
		return reference;
	}
	
	public int getPositionInReference() {
		return positionInReference;
	}
	
	public EObject getProxy() {
		return proxy;
	}
	
}
