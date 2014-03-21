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
package org.emftext.language.xpath2.resource.xpath2.mopp;


public class Xpath2LocalizedMessage {
	
	public Xpath2LocalizedMessage(String message, int column, int line, int charStart, int charEnd) {
		super();
		this.message = message;
		this.column = column;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}
	
	private String message;
	
	private int column;
	
	private int line;
	
	private int charStart;
	
	private int charEnd;
	
	public String getMessage() {
		return message;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
	
}
