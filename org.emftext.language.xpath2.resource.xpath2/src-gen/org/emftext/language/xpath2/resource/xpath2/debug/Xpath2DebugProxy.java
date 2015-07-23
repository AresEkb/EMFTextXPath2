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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class Xpath2DebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private PrintStream output;
	
	private BufferedReader reader;
	
	private org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugTarget debugTarget;
	
	private org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugCommunicationHelper communicationHelper = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugCommunicationHelper();
	
	public Xpath2DebugProxy(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugTarget debugTarget, int requestPort) throws UnknownHostException, IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws UnknownHostException, IOException {
		// creating client proxy socket (trying to connect)...
		Socket client = new Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			BufferedInputStream input = new BufferedInputStream(client.getInputStream());
			reader = new BufferedReader(new InputStreamReader(input));
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			output = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.EXIT);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage getStack() {
		return sendCommandAndRead(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public IVariable[] getStackVariables(String stackFrame) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage response = sendCommandAndRead(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public IVariable[] getVariables(String... requestedIDs) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage response = sendCommandAndRead(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable[] variables  = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			Map<String, String> properties = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			Map<String, Long> childVariables = new TreeMap<String, Long>(new Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			IValue value = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable variable = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes command, String... parameters) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage sendCommandAndRead(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes command, String... parameters) {
		org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message = new org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
