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
package org.emftext.language.xpath2.resource.xpath2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended diagnostic that gives access to the exact position of the problem
 * in a character stream.
 */
public interface IXpath2TextDiagnostic extends Resource.Diagnostic {
	
	/**
	 * Returns the position of the first character of the problem area.
	 */
	public int getCharStart();
	
	/**
	 * Returns the position of the last character of the problem area.
	 */
	public int getCharEnd();
	
	/**
	 * Returns the column of the problem area.
	 */
	public int getColumn();
	
	/**
	 * Returns the line that contains the problem area.
	 */
	public int getLine();
	
	/**
	 * Returns the problem that was found.
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2Problem getProblem();
	
	/**
	 * Checks whether the problem was caused by the given element.
	 * 
	 * @return true if the problem was caused by <code>element</code>
	 */
	public boolean wasCausedBy(EObject element);
	
}
