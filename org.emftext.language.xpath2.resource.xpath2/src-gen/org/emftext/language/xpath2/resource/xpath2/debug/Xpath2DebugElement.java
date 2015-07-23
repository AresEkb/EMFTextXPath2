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
package org.emftext.language.xpath2.resource.xpath2.debug;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class Xpath2DebugElement extends DebugElement {
	
	/**
	 * Constructs a new debug element in the given target.
	 */
	public Xpath2DebugElement(IDebugTarget target) {
		super(target);
	}
	
	public String getModelIdentifier() {
		return org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.DEBUG_MODEL_ID;
	}
	
	/**
	 * <p>
	 * Returns the breakpoint manager.
	 * </p>
	 * 
	 * @return the breakpoint manager
	 */
	protected IBreakpointManager getBreakpointManager() {
		return DebugPlugin.getDefault().getBreakpointManager();
	}
	
}
