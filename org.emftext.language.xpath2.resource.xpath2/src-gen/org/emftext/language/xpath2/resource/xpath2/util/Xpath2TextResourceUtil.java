/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.util;

/**
 * Class Xpath2TextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.
 */
public class Xpath2TextResourceUtil {
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated	
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.language.xpath2.resource.xpath2.util.Xpath2EclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated	
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated	
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated	
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(uri, options);
	}
	
}
