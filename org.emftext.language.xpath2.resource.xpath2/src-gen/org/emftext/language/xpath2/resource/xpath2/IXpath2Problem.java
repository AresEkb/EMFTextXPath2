/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2;

public interface IXpath2Problem {
	public String getMessage();
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity getSeverity();
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType getType();
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes();
}
