/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2Problem implements org.emftext.language.xpath2.resource.xpath2.IXpath2Problem {
	
	private String message;
	private org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type;
	private org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity;
	private java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> quickFixes;
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>emptySet());
	}
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity, org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity, java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType getType() {
		return type;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
