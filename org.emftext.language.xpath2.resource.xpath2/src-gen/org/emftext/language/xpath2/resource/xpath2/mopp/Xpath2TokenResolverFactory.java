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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Xpath2TokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class Xpath2TokenResolverFactory implements org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory {
	
	private Map<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver> tokenName2TokenResolver;
	private Map<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver defaultResolver = new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultTokenResolver();
	
	public Xpath2TokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver>();
		registerTokenResolver("INTEGER_LITERAL", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2INTEGER_LITERALTokenResolver());
		registerTokenResolver("DECIMAL_LITERAL", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DECIMAL_LITERALTokenResolver());
		registerTokenResolver("DOUBLE_LITERAL", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DOUBLE_LITERALTokenResolver());
		registerTokenResolver("QNAME", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2QNAMETokenResolver());
		registerTokenResolver("NCNAME", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2NCNAMETokenResolver());
		registerTokenResolver("STRING_LITERAL", new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2STRING_LITERALTokenResolver());
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver internalCreateResolver(Map<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver> resolverMap, String key, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
