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
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2MetaInformation implements org.emftext.language.xpath2.resource.xpath2.IXpath2MetaInformation {
	
	public String getSyntaxName() {
		return "xpath2";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/xpath2";
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TextScanner createLexer() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AntlrScanner(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Lexer());
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Parser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Printer2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2SyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2SyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolverSwitch();
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.xpath2/metamodel/xpath2.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Parser.tokenNames;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair> getBracketPairs() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2BracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ResourceFactory();
	}
	
	public org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2NewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2NewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.language.xpath2.resource.xpath2.ui.launchConfigurationType";
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2NameProvider createNameProvider() {
		return new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AntlrTokenHelper tokenHelper = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
