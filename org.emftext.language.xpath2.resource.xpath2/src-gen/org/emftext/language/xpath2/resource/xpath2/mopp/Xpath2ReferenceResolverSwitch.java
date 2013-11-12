/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2ReferenceResolverSwitch implements org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.xpath2.resource.xpath2.IXpath2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
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
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
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
