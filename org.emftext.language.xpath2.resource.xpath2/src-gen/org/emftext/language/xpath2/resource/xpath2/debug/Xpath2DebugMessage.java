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

import java.util.ArrayList;
import java.util.List;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class Xpath2DebugMessage {
	
	private static final char DELIMITER = ':';
	private org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes messageType;
	private String[] arguments;
	
	public Xpath2DebugMessage(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public Xpath2DebugMessage(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes messageType, List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		List<String> parts = new ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.encode(DELIMITER, parts);
	}
	
	public static Xpath2DebugMessage deserialize(String response) {
		List<String> parts = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes type = org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes.valueOf(messageType);
		Xpath2DebugMessage message = new Xpath2DebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.emftext.language.xpath2.resource.xpath2.debug.EXpath2DebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.explode(arguments, ", ") + "]";
	}
	
}
