/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class Xpath2Keyword extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	private final String value;
	
	public Xpath2Keyword(String value, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
