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

import java.util.Arrays;

public class Xpath2TokenStyle implements org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle {
	
	private int[] colorAsRGB;
	
	private int[] backgroundColorAsRGB;
	
	private boolean bold;
	
	private boolean italic;
	
	private boolean strikethrough;
	
	private boolean underline;
	
	public Xpath2TokenStyle(int[] colorAsRGB, int[] backgroundColorAsRGB, boolean bold, boolean italic, boolean striketrough, boolean underline) {
		super();
		this.colorAsRGB = colorAsRGB;
		this.backgroundColorAsRGB = backgroundColorAsRGB;
		this.bold = bold;
		this.italic = italic;
		this.strikethrough = striketrough;
		this.underline = underline;
	}
	
	public Xpath2TokenStyle(org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle styleToCopy) {
		this(styleToCopy.getColorAsRGB(), styleToCopy.getBackgroundColorAsRGB(), styleToCopy.isBold(), styleToCopy.isItalic(), styleToCopy.isStrikethrough(), styleToCopy.isUnderline());
	}
	
	public int[] getColorAsRGB() {
		return colorAsRGB;
	}
	
	public int[] getBackgroundColorAsRGB() {
		return backgroundColorAsRGB;
	}
	
	public boolean isBold() {
		return bold;
	}
	
	public boolean isItalic() {
		return italic;
	}
	
	public boolean isStrikethrough() {
		return strikethrough;
	}
	
	public boolean isUnderline() {
		return underline;
	}
	
	public void setColorAsRGB(int[] colorAsRGB) {
		this.colorAsRGB = colorAsRGB;
	}
	
	public void setBackgroundColorAsRGB(int[] backgroundColorAsRGB) {
		this.backgroundColorAsRGB = backgroundColorAsRGB;
	}
	
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	
	public void setItalic(boolean italic) {
		this.italic = italic;
	}
	
	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}
	
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(backgroundColorAsRGB);
		result = prime * result + (bold ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(colorAsRGB);
		result = prime * result + (italic ? 1231 : 1237);
		result = prime * result + (strikethrough ? 1231 : 1237);
		result = prime * result + (underline ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)		return true;
		if (obj == null)		return false;
		if (getClass() != obj.getClass())		return false;
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyle other = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyle) obj;
		if (!Arrays.equals(backgroundColorAsRGB, other.backgroundColorAsRGB))		return false;
		if (bold != other.bold)		return false;
		if (!Arrays.equals(colorAsRGB, other.colorAsRGB))		return false;
		if (italic != other.italic)		return false;
		if (strikethrough != other.strikethrough)		return false;
		if (underline != other.underline)		return false;
		return true;
	}
	
}
