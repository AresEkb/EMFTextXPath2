/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.util;

/**
 * A utility class that encapsulates some case operations that need to be
 * performed unchecked, because of Java's type erasure.
 */
public class Xpath2ListUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> java.util.List<T> castListUnchecked(Object list) {
		return (java.util.List<T>) list;
	}
	
	public static java.util.List<Object> copySafelyToObjectList(java.util.List<?> list) {
		java.util.Iterator<?> it = list.iterator();
		java.util.List<Object> castedCopy = new java.util.ArrayList<Object>();
		while (it.hasNext()) {
			castedCopy.add(it.next());
		}
		return castedCopy;
	}
}
