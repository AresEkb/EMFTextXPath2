/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class Xpath2Placeholder extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Terminal {
	
	private final String tokenName;
	
	public Xpath2Placeholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
