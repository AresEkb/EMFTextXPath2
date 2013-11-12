/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class Xpath2ExpectedStructuralFeature extends org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AbstractExpectedElement {
	
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder placeholder;
	
	public Xpath2ExpectedStructuralFeature(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Xpath2ExpectedStructuralFeature) {
			return getFeature().equals(((Xpath2ExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
