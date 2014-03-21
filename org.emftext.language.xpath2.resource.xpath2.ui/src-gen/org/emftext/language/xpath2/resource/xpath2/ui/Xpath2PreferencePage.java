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

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The root preference page.
 */
public class Xpath2PreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	public void init(IWorkbench workbench) {
		setPreferenceStore(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIPlugin.getDefault().getPreferenceStore());
		setDescription(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIResourceBundle.ROOT_PREFERENCE_PAGE_DESCRIPTION);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Composite settingComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		GridData gd;
		layout.numColumns= 1;
		layout.marginHeight= 0;
		layout.marginWidth= 0;
		gd = new GridData(GridData.BEGINNING);
		settingComposite.setLayout(layout);
		settingComposite.setLayoutData(gd);
		
		Link link = new Link(settingComposite, SWT.NONE);
		link.setText(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIResourceBundle.ROOT_PREFERENCE_PAGE_TEXT);
		link.setSize(140, 40);
		link.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (e.text.startsWith("http")) Program.launch(e.text);
			}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		return settingComposite;
	}
	
}
