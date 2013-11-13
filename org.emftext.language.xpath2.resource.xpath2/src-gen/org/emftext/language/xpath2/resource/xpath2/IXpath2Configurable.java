/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IXpath2Configurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(java.util.Map<?,?> options);
}
