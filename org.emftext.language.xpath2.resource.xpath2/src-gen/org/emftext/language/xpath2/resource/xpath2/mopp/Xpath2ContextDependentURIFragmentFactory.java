/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class Xpath2ContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public Xpath2ContextDependentURIFragmentFactory(org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
