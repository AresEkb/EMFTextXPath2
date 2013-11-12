/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

public class Xpath2Containment extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Terminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public Xpath2Containment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.explode(allowedTypes, ", ", new org.emftext.language.xpath2.resource.xpath2.IXpath2Function1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
