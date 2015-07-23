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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Xpath2DebugCommunicationHelper {
	
	public void sendEvent(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message, PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * <p>
	 * Sends a message using the given stream and waits for an answer.
	 * </p>
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage sendAndReceive(org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage message, PrintStream stream, BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * <p>
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * </p>
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage receive(BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage receivedMessage = org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugMessage.deserialize(response);
			return receivedMessage;
		} catch (IOException e) {
			return null;
		}
	}
	
}
