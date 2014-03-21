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


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IXpath2Command<ContextType> {
	
	public boolean execute(ContextType context);
}
