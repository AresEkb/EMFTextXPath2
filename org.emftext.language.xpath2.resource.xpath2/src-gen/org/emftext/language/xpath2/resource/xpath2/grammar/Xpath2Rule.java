/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class Xpath2Rule extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public Xpath2Rule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice choice, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality, new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getDefinition() {
		return (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice) getChildren()[0];
	}
	
}

