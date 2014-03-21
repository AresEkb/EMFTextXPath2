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

import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.Token;

public class Xpath2ANTLRTextToken extends org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TextToken {
	
	private final static org.emftext.language.xpath2.resource.xpath2.IXpath2MetaInformation metaInformation = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation();
	
	public Xpath2ANTLRTextToken(Token antlrToken) {
		super(getTokenName(metaInformation.getTokenNames(), antlrToken.getType()), antlrToken.getText(), ((CommonToken) antlrToken).getStartIndex(), ((CommonToken) antlrToken).getStopIndex() - ((CommonToken) antlrToken).getStartIndex() + 1, antlrToken.getLine(), antlrToken.getCharPositionInLine(), canBeUsedForSyntaxHighlighting(antlrToken.getType()));
	}
	
	public static String getTokenName(String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
	public static boolean canBeUsedForSyntaxHighlighting(int tokenType) {
		if (tokenType < 0) {
			return false;
		}
		if (tokenType == Token.UP) {
			return false;
		}
		if (tokenType == Token.DOWN) {
			return false;
		}
		if (tokenType == Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
}
