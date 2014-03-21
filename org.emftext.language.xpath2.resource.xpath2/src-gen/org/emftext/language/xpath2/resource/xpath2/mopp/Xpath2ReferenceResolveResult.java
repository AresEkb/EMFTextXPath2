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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * A basic implementation of the
 * org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class Xpath2ReferenceResolveResult<ReferenceType> implements org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<ReferenceType> {
	
	private Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> quickFixes;
	
	public Xpath2ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2URIMapping<ReferenceType>(identifier, uri, warning));
	}
}
