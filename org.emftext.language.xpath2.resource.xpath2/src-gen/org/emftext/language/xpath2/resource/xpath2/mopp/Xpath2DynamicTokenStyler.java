/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2DynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle getDynamicTokenStyle(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken token, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
