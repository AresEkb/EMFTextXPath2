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
package org.emftext.language.xpath2.resource.xpath2.ui;


/**
 * An interface that defines some constants used to create the keys for
 * preferences.
 */
public interface Xpath2PreferenceConstants {
	
	// Constants for syntax highlighting
	/**
	 * Preference key suffix to enable syntax highlighting for a token type.
	 */
	public static final String EDITOR_ENABLE_SUFFIX = "_enable";
	public static final String EDITOR_COLOR_SUFFIX = "_color";
	
	// Constants for brackets
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "_matchingBracketsColor";
	public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = "_matchingBracketsCheckbox";
	public static final String EDITOR_BRACKETS_SUFFIX = "_brackets";
	
}
