/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

public class Xpath2Compound extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	public Xpath2Compound(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice choice, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality, new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
