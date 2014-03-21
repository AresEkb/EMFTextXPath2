/**
 * Copyright (c) 2013, 2014 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

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
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(IFile file) {
		return new org.emftext.language.xpath2.resource.xpath2.util.Xpath2EclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(File file, Map<?,?> options) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(URI uri) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(
	 * ) instead.
	 */
	@Deprecated
	public static org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource getResource(URI uri, Map<?,?> options) {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2ResourceUtil.getResource(uri, options);
	}
	
}
