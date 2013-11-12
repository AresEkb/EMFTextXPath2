/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.analysis;

public class Xpath2DOUBLE_LITERALTokenResolver implements org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver {
	
	private org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultTokenResolver defaultTokenResolver = new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
