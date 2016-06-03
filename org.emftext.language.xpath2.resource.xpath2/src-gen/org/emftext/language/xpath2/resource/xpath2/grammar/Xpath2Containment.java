/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Xpath2Containment extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Terminal {
	
	private final EClass[] allowedTypes;
	
	public Xpath2Containment(EStructuralFeature feature, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	@Override
	public boolean hasContainment(EClass metaclass) {
		for (EClass allowedType : allowedTypes) {
			if (allowedType == metaclass) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.explode(allowedTypes, ", ", new org.emftext.language.xpath2.resource.xpath2.IXpath2Function1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
