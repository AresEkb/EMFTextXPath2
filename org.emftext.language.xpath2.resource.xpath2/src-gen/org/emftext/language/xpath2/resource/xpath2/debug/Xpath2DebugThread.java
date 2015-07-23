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

import java.util.List;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

public class Xpath2DebugThread extends org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugElement implements IThread, org.emftext.language.xpath2.resource.xpath2.debug.IXpath2DebugEventListener {
	
	private boolean suspended = false;
	private org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugTarget debugTarget;
	
	public Xpath2DebugThread(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugTarget target) {
		super(target);
		this.debugTarget = target;
	}
	
	public IBreakpoint[] getBreakpoints() {
		return null;
	}
	
	public String getName() throws DebugException {
		return "Thread [main]";
	}
	
	public int getPriority() throws DebugException {
		return 0;
	}
	
	public IStackFrame[] getStackFrames() throws DebugException {
		if (isSuspended()) {
			org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage stack = this.debugTarget.getDebugProxy().getStack();
			String framesData = stack.getArgument(0);
			if (framesData != null && !"".equals(framesData)) {
				List<String> frames = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.decode(framesData, '#');
				IStackFrame[] theFrames = new IStackFrame[frames.size()];
				for (int i = 0; i < frames.size(); i++) {
					String data = frames.get(i);
					theFrames[frames.size() - i - 1] = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2StackFrame(getTarget(), data);
				}
				return theFrames;
			}
		}
		return new IStackFrame[0];
	}
	
	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame[] frames = getStackFrames();
		if (frames.length > 0) {
			return frames[0];
		}
		return null;
	}
	
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}
	
	public boolean canResume() {
		return isSuspended();
	}
	
	public boolean canSuspend() {
		return !isSuspended();
	}
	
	public boolean isSuspended() {
		return suspended && !isTerminated();
	}
	
	public void resume() throws DebugException {
		debugTarget.getDebugProxy().resume();
		suspended = false;
	}
	
	public void suspend() throws DebugException {
		suspended = true;
		fireSuspendEvent(DebugEvent.BREAKPOINT);
	}
	
	public boolean canStepInto() {
		return true;
	}
	
	public boolean canStepOver() {
		return true;
	}
	
	public boolean canStepReturn() {
		return true;
	}
	
	public boolean isStepping() {
		return false;
	}
	
	public void stepInto() throws DebugException {
		getTarget().getDebugProxy().stepInto();
	}
	
	public void stepOver() throws DebugException {
		getTarget().getDebugProxy().stepOver();
	}
	
	public void stepReturn() throws DebugException {
		getTarget().getDebugProxy().stepReturn();
	}
	
	public boolean canTerminate() {
		return !isTerminated();
	}
	
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}
	
	public void terminate() throws DebugException {
		getTarget().getDebugProxy().terminate();
	}
	
	public void handleMessage(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message) {
		if (message.hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.STARTED)) {
			fireCreationEvent();
		} else if (message.hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.RESUMED)) {
			suspended = false;
			fireResumeEvent(0);
		} else if (message.hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.SUSPENDED)) {
			suspended = true;
			fireSuspendEvent(DebugEvent.BREAKPOINT);
		} else if (message.hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.TERMINATED)) {
			// ignore this event
		} else {
			System.out.println("ERROR " + this.getClass().getName() + ".handleMessage(" + message + ") unknown event");
		}
	}
	
	public org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugTarget getTarget() {
		return debugTarget;
	}
	
}
