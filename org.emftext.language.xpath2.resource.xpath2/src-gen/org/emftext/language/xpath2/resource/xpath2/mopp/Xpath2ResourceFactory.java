/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2ResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Xpath2ResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource(uri);
	}
	
}
