/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

public class Xpath2Sequence extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	public Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.explode(getChildren(), " ");
	}
	
}
