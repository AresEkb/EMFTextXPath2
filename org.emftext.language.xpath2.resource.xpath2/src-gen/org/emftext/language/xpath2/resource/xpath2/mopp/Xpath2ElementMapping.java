/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.xpath2.resource.xpath2.IXpath2ElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class Xpath2ElementMapping<ReferenceType> implements org.emftext.language.xpath2.resource.xpath2.IXpath2ElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public Xpath2ElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
