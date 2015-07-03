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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Xpath2ReferenceResolverSwitch implements org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected org.emftext.language.xpath2.resource.xpath2.analysis.StringLiteralPITestLiteralReferenceResolver stringLiteralPITestLiteralReferenceResolver = new org.emftext.language.xpath2.resource.xpath2.analysis.StringLiteralPITestLiteralReferenceResolver();
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral> getStringLiteralPITestLiteralReferenceResolver() {
		return getResolverChain(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest_Literal(), stringLiteralPITestLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		stringLiteralPITestLiteralReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest().isInstance(container)) {
			Xpath2FuzzyResolveResult<org.emftext.language.xpath2.StringLiteral> frr = new Xpath2FuzzyResolveResult<org.emftext.language.xpath2.StringLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("literal")) {
				stringLiteralPITestLiteralReferenceResolver.resolve(identifier, (org.emftext.language.xpath2.StringLiteralPITest) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest_Literal()) {
			return getResolverChain(reference, stringLiteralPITestLiteralReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver) {
			org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver replacingResolver = (org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceCache) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver nextResolver = (org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver) next;
					if (nextResolver instanceof org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.xpath2.resource.xpath2.IXpath2DelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
