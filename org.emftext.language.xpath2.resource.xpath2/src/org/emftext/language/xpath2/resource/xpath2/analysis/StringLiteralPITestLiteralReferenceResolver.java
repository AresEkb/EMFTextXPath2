/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.analysis;

public class StringLiteralPITestLiteralReferenceResolver implements org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral> {
	
	private org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultResolverDelegate<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral> delegate = new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultResolverDelegate<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral>();
	
	public void resolve(String identifier, org.emftext.language.xpath2.StringLiteralPITest container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<org.emftext.language.xpath2.StringLiteral> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.xpath2.StringLiteral element, org.emftext.language.xpath2.StringLiteralPITest container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
