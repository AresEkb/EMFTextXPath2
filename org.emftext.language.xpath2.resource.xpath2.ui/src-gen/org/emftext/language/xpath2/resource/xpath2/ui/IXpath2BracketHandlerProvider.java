/**
 * Copyright (c) 2013 Denis Nikiforov.
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
 * A provider for BracketHandler objects.
 */
public interface IXpath2BracketHandlerProvider {
	
	/**
	 * Returns the bracket handler.
	 */
	public org.emftext.language.xpath2.resource.xpath2.ui.IXpath2BracketHandler getBracketHandler();
	
}
