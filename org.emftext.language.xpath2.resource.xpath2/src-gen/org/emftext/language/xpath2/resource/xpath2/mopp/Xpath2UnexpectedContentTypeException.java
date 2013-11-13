/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * org.emftext.language.xpath2.resource.xpath2.IXpath2Options.RESOURCE_CONTENT_TYPE
 */
public class Xpath2UnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  Xpath2UnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
