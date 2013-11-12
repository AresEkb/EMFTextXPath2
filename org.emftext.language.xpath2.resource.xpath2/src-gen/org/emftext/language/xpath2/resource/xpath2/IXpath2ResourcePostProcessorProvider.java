/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IXpath2ResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ResourcePostProcessor getResourcePostProcessor();
	
}
