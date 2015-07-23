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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class Xpath2DebugVariable extends org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugElement implements IVariable {
	
	private String name;
	private IValue value;
	private String referenceTypeName;
	
	public Xpath2DebugVariable(IDebugTarget debugTarget, String name, IValue value, String referenceTypeName) {
		super(debugTarget);
		this.name = name;
		this.value = value;
		this.referenceTypeName = referenceTypeName;
	}
	
	public boolean supportsValueModification() {
		return false;
	}
	
	public void setValue(IValue value) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public void setValue(String expression) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(IValue value) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(String expression) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public IValue getValue() throws DebugException {
		return value;
	}
	
	public String getName() throws DebugException {
		return name;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return referenceTypeName;
	}
	
	public boolean hasValueChanged() throws DebugException {
		return true;
	}
	
}
