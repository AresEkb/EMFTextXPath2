/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2ParseResult implements org.emftext.language.xpath2.resource.xpath2.IXpath2ParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>> commands = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>>();
	
	public Xpath2ParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>> getPostParseCommands() {
		return commands;
	}
	
}
