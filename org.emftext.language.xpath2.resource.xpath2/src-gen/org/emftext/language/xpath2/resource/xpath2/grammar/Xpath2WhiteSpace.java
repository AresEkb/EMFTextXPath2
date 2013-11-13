/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

public class Xpath2WhiteSpace extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2FormattingElement {
	
	private final int amount;
	
	public Xpath2WhiteSpace(int amount, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
