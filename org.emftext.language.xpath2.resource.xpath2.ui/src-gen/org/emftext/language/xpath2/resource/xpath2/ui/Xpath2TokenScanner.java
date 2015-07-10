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
package org.emftext.language.xpath2.resource.xpath2.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class Xpath2TokenScanner implements org.emftext.language.xpath2.resource.xpath2.ui.IXpath2TokenScanner {
	
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TextScanner lexer;
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken currentToken;
	private List<org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager colorManager;
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource;
	
	/**
	 * <p>
	 * Creates a new Xpath2TokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public Xpath2TokenScanner(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().createLexer();
		this.languageId = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getSyntaxName();
		org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIPlugin plugin = org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new Token(textAttribute);
	}
	
	public void setRange(IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2SyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle getDynamicTokenStyle(org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle staticStyle) {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DynamicTokenStyler dynamicTokenStyler = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		Color backgroundColor = null;
		if (backgroundColorArray != null) {
			RGB backgroundRGB = new RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | TextAttribute.UNDERLINE;
		}
		return new TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem> taskItems = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken> newItems = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken>();
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TextToken(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
