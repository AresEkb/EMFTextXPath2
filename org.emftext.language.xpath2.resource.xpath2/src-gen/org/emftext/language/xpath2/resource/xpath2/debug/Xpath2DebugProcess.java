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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class Xpath2DebugProcess extends org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugElement implements IProcess, org.emftext.language.xpath2.resource.xpath2.debug.IXpath2DebugEventListener {
	
	private ILaunch launch;
	
	private boolean terminated = false;
	
	public Xpath2DebugProcess(ILaunch launch) {
		super(launch.getDebugTarget());
		this.launch = launch;
	}
	
	public boolean canTerminate() {
		return !terminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void terminate() throws DebugException {
		terminated = true;
	}
	
	public String getLabel() {
		return null;
	}
	
	public ILaunch getLaunch() {
		return launch;
	}
	
	public IStreamsProxy getStreamsProxy() {
		return null;
	}
	
	public void setAttribute(String key, String value) {
	}
	
	public String getAttribute(String key) {
		return null;
	}
	
	public int getExitValue() throws DebugException {
		return 0;
	}
	
	public void handleMessage(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message) {
		if (message.hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.TERMINATED)) {
			terminated = true;
		} else {
			// ignore other events
		}
	}
	
}
