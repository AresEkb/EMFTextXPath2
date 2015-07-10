/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2;


/**
 * A simple interface to access information about bracket handling.
 */
public interface IXpath2BracketPair {
	
	/**
	 * Returns the opening bracket.
	 */
	public String getOpeningBracket();
	
	/**
	 * Returns the closing bracket.
	 */
	public String getClosingBracket();
	
	/**
	 * Returns whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public boolean isClosingEnabledInside();
	
	/**
	 * Sets whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public void setClosingEnabledInside(boolean closingEnabledInside);
	
	/**
	 * Returns whether this bracket pair shall be automatically closed, when a line
	 * break is entered. If this method returns false, the closing bracket is inserted
	 * right away when the opening bracket is typed.
	 */
	public boolean isCloseAfterEnter();
	
	/**
	 * Sets whether this bracket pair shall be automatically closed, when a line break
	 * is entered. If this method returns false, the closing bracket is inserted right
	 * away when the opening bracket is typed.
	 */
	public void setCloseAfterEnter(boolean closingAfterEnter);
	
}
