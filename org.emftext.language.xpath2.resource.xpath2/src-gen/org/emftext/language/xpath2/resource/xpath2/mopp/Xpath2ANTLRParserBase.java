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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.Parser;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.TokenStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public abstract class Xpath2ANTLRParserBase extends Parser implements org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser {
	
	/**
	 * The index of the last token that was handled by retrieveLayoutInformation().
	 */
	private int lastPosition2;
	
	/**
	 * A collection to store all anonymous tokens.
	 */
	protected List<CommonToken> anonymousTokens = new ArrayList<CommonToken>();
	
	/**
	 * A collection that is filled with commands to be executed after parsing. This
	 * collection is cleared before parsing starts and returned as part of the parse
	 * result object.
	 */
	protected Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>> postParseCommands;
	
	/**
	 * A copy of the options that were used to load the text resource. This map is
	 * filled when the parser is created.
	 */
	private Map<?, ?> options;
	
	/**
	 * A flag that indicates whether this parser runs in a special mode where the
	 * location map is not filled. If this flag is set to true, copying localization
	 * information for elements is not performed. This improves time and memory
	 * consumption.
	 */
	protected boolean disableLocationMap = false;
	
	/**
	 * A flag that indicates whether this parser runs in a special mode where layout
	 * information is not recorded. If this flag is set to true, no layout information
	 * adapters are created. This improves time and memory consumption.
	 */
	protected boolean disableLayoutRecording = false;
	
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	protected boolean terminateParsing;
	
	/**
	 * A reusable container for the result of resolving tokens.
	 */
	private org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolveResult tokenResolveResult = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolveResult();
	
	protected org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation metaInformation = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation();
	
	public Xpath2ANTLRParserBase(TokenStream input) {
		super(input);
	}
	
	public Xpath2ANTLRParserBase(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	protected void retrieveLayoutInformation(EObject element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement syntaxElement, Object object, boolean ignoreTokensAfterLastVisibleToken) {
		if (disableLayoutRecording || element == null) {
			return;
		}
		// null must be accepted, since the layout information that is found at the end of
		// documents (just before the EOF character) is not associated with a particular
		// syntax element.
		boolean isElementToStore = syntaxElement == null;
		isElementToStore |= syntaxElement instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder;
		isElementToStore |= syntaxElement instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword;
		isElementToStore |= syntaxElement instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal;
		isElementToStore |= syntaxElement instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal;
		if (!isElementToStore) {
			return;
		}
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		StringBuilder anonymousText = new StringBuilder();
		for (CommonToken anonymousToken : anonymousTokens) {
			anonymousText.append(anonymousToken.getText());
		}
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		if (ignoreTokensAfterLastVisibleToken) {
			for (; endPos >= this.lastPosition2; endPos--) {
				Token token = getTokenStream().get(endPos);
				int _channel = token.getChannel();
				if (_channel != 99) {
					break;
				}
			}
		}
		StringBuilder hiddenTokenText = new StringBuilder();
		hiddenTokenText.append(anonymousText);
		StringBuilder visibleTokenText = new StringBuilder();
		CommonToken firstToken = null;
		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
			Token token = getTokenStream().get(pos);
			if (firstToken == null) {
				firstToken = (CommonToken) token;
			}
			if (anonymousTokens.contains(token)) {
				continue;
			}
			int _channel = token.getChannel();
			if (_channel == 99) {
				hiddenTokenText.append(token.getText());
			} else {
				visibleTokenText.append(token.getText());
			}
		}
		int offset = -1;
		if (firstToken != null) {
			offset = firstToken.getStartIndex();
		}
		layoutInformationAdapter.addLayoutInformation(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformation(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
		anonymousTokens.clear();
	}
	
	protected org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter getLayoutInformationAdapter(EObject element) {
		for (Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter) {
				return (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter) adapter;
			}
		}
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter newAdapter = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	protected <ContainerType extends EObject, ReferenceType extends EObject> void registerContextDependentProxy(final org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType container, final EReference reference, final String id, final EObject proxy) {
		final int position;
		if (reference.isMany()) {
			position = ((List<?>) container.eGet(reference)).size();
		} else {
			position = -1;
		}
		
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, container, reference, id, proxy, position);
				return true;
			}
		});
	}
	
	protected Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
		this.disableLocationMap = !isLocationMapEnabled();
		this.disableLayoutRecording = !isLayoutInformationRecordingEnabled();
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	public <T> T createDynamicProxy(Class<T> clazz) {
		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{clazz, EObject.class, InternalEObject.class}, new InvocationHandler() {
			
			private EObject dummyObject = new EObjectImpl() {};
			
			public Object invoke(Object object, Method method, Object[] args) throws Throwable {
				// search in dummyObject for the requested method
				Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								Class<?> parameterType = parameterTypes[p];
								Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
		});
		return (T) proxy;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void addMapEntry(EObject element, EStructuralFeature structuralFeature, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof EMap<?, ?>) {
			EMap<Object, Object> valueMap = org.emftext.language.xpath2.resource.xpath2.util.Xpath2MapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean addObjectToList(EObject container, int featureID, Object object) {
		EClass eClass = container.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(featureID);
		Object value = container.eGet(eStructuralFeature);
		return ((List<Object>) value).add(object);
	}
	
	@SuppressWarnings("unchecked")
	public boolean addObjectToList(EObject container, EStructuralFeature feature, Object object) {
		Object value = container.eGet(feature);
		return ((List<Object>) value).add(object);
	}
	
	protected EObject apply(EObject target, List<EObject> dummyEObjects) {
		EObject currentTarget = target;
		for (EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DummyEObject);
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DummyEObject dummy = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DummyEObject) object;
			EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	protected org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolverSwitch resolverSwitch = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolverSwitch) metaInformation.getReferenceResolverSwitch();
		resolverSwitch.setOptions(options);
		return resolverSwitch;
	}
	
	public boolean isLayoutInformationRecordingEnabled() {
		if (options == null) {
			return true;
		}
		Object value = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.DISABLE_LAYOUT_INFORMATION_RECORDING);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLocationMapEnabled() {
		if (options == null) {
			return true;
		}
		Object value = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.DISABLE_LOCATION_MAP);
		return value == null || Boolean.FALSE.equals(value);
	}
	
}
