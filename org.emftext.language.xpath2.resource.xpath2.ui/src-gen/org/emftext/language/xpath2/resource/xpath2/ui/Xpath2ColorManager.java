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
package org.emftext.language.xpath2.resource.xpath2.ui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * A class for RGB-based color objects.
 */
public class Xpath2ColorManager {
	
	protected Map<RGB, Color> fColorTable = new LinkedHashMap<RGB, Color>(10);
	
	/**
	 * Disposes all colors in the cache.
	 */
	public void dispose() {
		Iterator<Color> e = fColorTable.values().iterator();
		while (e.hasNext()) {
			e.next().dispose();
		}
	}
	
	/**
	 * Constructs and caches the given color.
	 * 
	 * @param rgb The color as RGB
	 * 
	 * @return The color (from cache or newly constructed)
	 */
	public Color getColor(RGB rgb) {
		Color color = fColorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}
