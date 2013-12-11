grammar Xpath2;

options {
	superClass = Xpath2ANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.xpath2.resource.xpath2.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.xpath2.resource.xpath2.mopp;
}

@members{
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory tokenResolverFactory = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.xpath2.resource.xpath2.IXpath2Problem() {
					public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity getSeverity() {
						return org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity.ERROR;
					}
					public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType getType() {
						return org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement terminal = org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2FollowSetProvider.TERMINALS[terminalID];
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[] containmentFeatures = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2FollowSetProvider.LINKS[ids[i]];
		}
		org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace containmentTrace = new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new Xpath2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new Xpath2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new Xpath2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new Xpath2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public Xpath2Parser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((Xpath2Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((Xpath2Lexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.xpath2.Expr.class) {
				return parse_org_emftext_language_xpath2_Expr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ForExpr.class) {
				return parse_org_emftext_language_xpath2_ForExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QuantifiedExpr.class) {
				return parse_org_emftext_language_xpath2_QuantifiedExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.Iterator.class) {
				return parse_org_emftext_language_xpath2_Iterator();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IfExpr.class) {
				return parse_org_emftext_language_xpath2_IfExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.OrExpr.class) {
				return parse_org_emftext_language_xpath2_OrExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AndExpr.class) {
				return parse_org_emftext_language_xpath2_AndExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ComparisonExpr.class) {
				return parse_org_emftext_language_xpath2_ComparisonExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.RangeExpr.class) {
				return parse_org_emftext_language_xpath2_RangeExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralComp.class) {
				return parse_org_emftext_language_xpath2_GeneralComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ValueComp.class) {
				return parse_org_emftext_language_xpath2_ValueComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NodeComp.class) {
				return parse_org_emftext_language_xpath2_NodeComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AdditiveExpr.class) {
				return parse_org_emftext_language_xpath2_AdditiveExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.MultiplicativeExpr.class) {
				return parse_org_emftext_language_xpath2_MultiplicativeExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.UnionExpr.class) {
				return parse_org_emftext_language_xpath2_UnionExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IntersectExceptExpr.class) {
				return parse_org_emftext_language_xpath2_IntersectExceptExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.InstanceofExpr.class) {
				return parse_org_emftext_language_xpath2_InstanceofExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.TreatExpr.class) {
				return parse_org_emftext_language_xpath2_TreatExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CastableExpr.class) {
				return parse_org_emftext_language_xpath2_CastableExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CastExpr.class) {
				return parse_org_emftext_language_xpath2_CastExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.UnaryExpr.class) {
				return parse_org_emftext_language_xpath2_UnaryExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.FilterExpr.class) {
				return parse_org_emftext_language_xpath2_FilterExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.FunctionCall.class) {
				return parse_org_emftext_language_xpath2_FunctionCall();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.PathExpr.class) {
				return parse_org_emftext_language_xpath2_PathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ChildStepExpr.class) {
				return parse_org_emftext_language_xpath2_ChildStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DescOrSelfStepExpr.class) {
				return parse_org_emftext_language_xpath2_DescOrSelfStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.RootStepExpr.class) {
				return parse_org_emftext_language_xpath2_RootStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SelfStepExpr.class) {
				return parse_org_emftext_language_xpath2_SelfStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralForwardStep.class) {
				return parse_org_emftext_language_xpath2_GeneralForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevForwardStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralReverseStep.class) {
				return parse_org_emftext_language_xpath2_GeneralReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevReverseStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NodeKindTest.class) {
				return parse_org_emftext_language_xpath2_NodeKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QNameTest.class) {
				return parse_org_emftext_language_xpath2_QNameTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyWildcard.class) {
				return parse_org_emftext_language_xpath2_AnyWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.LocalNameWildcard.class) {
				return parse_org_emftext_language_xpath2_LocalNameWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NamespaceWildcard.class) {
				return parse_org_emftext_language_xpath2_NamespaceWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.Predicate.class) {
				return parse_org_emftext_language_xpath2_Predicate();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.VarRef.class) {
				return parse_org_emftext_language_xpath2_VarRef();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.VarName.class) {
				return parse_org_emftext_language_xpath2_VarName();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ParenthesizedExpr.class) {
				return parse_org_emftext_language_xpath2_ParenthesizedExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ContextItemExpr.class) {
				return parse_org_emftext_language_xpath2_ContextItemExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SingleType.class) {
				return parse_org_emftext_language_xpath2_SingleType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.EmptySequenceType.class) {
				return parse_org_emftext_language_xpath2_EmptySequenceType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ItemSequenceType.class) {
				return parse_org_emftext_language_xpath2_ItemSequenceType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ItemKindTest.class) {
				return parse_org_emftext_language_xpath2_ItemKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyItemType.class) {
				return parse_org_emftext_language_xpath2_AnyItemType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AtomicItemType.class) {
				return parse_org_emftext_language_xpath2_AtomicItemType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AtomicType.class) {
				return parse_org_emftext_language_xpath2_AtomicType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.OptionalAtomicType.class) {
				return parse_org_emftext_language_xpath2_OptionalAtomicType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyKindTest.class) {
				return parse_org_emftext_language_xpath2_AnyKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DocumentTest.class) {
				return parse_org_emftext_language_xpath2_DocumentTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.TextTest.class) {
				return parse_org_emftext_language_xpath2_TextTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CommentTest.class) {
				return parse_org_emftext_language_xpath2_CommentTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.PITest.class) {
				return parse_org_emftext_language_xpath2_PITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NCNamePITest.class) {
				return parse_org_emftext_language_xpath2_NCNamePITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.StringLiteralPITest.class) {
				return parse_org_emftext_language_xpath2_StringLiteralPITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AttributeTest.class) {
				return parse_org_emftext_language_xpath2_AttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.WildcardAttributeTest.class) {
				return parse_org_emftext_language_xpath2_WildcardAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NameAttributeTest.class) {
				return parse_org_emftext_language_xpath2_NameAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SchemaAttributeTest.class) {
				return parse_org_emftext_language_xpath2_SchemaAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ElementTest.class) {
				return parse_org_emftext_language_xpath2_ElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.WildcardElementTest.class) {
				return parse_org_emftext_language_xpath2_WildcardElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NameElementTest.class) {
				return parse_org_emftext_language_xpath2_NameElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SchemaElementTest.class) {
				return parse_org_emftext_language_xpath2_SchemaElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IntegerLiteral.class) {
				return parse_org_emftext_language_xpath2_IntegerLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DecimalLiteral.class) {
				return parse_org_emftext_language_xpath2_DecimalLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DoubleLiteral.class) {
				return parse_org_emftext_language_xpath2_DoubleLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.StringLiteral.class) {
				return parse_org_emftext_language_xpath2_StringLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QName.class) {
				return parse_org_emftext_language_xpath2_QName();
			}
		}
		throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2UnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>>();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ParseResult parseResult = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.emftext.language.xpath2.resource.xpath2.IXpath2ParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
		java.util.List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 236;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace containmentTrace = new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace(null, newFollowerPair.getRight());
							org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal newFollowTerminal = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal(container, newFollower, followSetID, containmentTrace);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[25]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_xpath2_Expr{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_xpath2_Expr returns [org.emftext.language.xpath2.Expr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[29]);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[30]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[35]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[37]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[38]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[39]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[52]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[53]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[54]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[55]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_IfExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_2, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_org_emftext_language_xpath2_ForExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_2, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_org_emftext_language_xpath2_QuantifiedExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_2, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_org_emftext_language_xpath2_OrExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_2, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[59]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[63]);
	}
	
;

parse_org_emftext_language_xpath2_ForExpr returns [org.emftext.language.xpath2.ForExpr element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[64]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_Iterator		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FOR_EXPR__ITERATOR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[66]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[67]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_Iterator				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FOR_EXPR__ITERATOR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_3_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[68]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[69]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[71]);
	}
	
	a4 = 'return' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[97]);
	}
	
	(
		a5_0 = parse_org_emftext_language_xpath2_ExprSingle		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FOR_EXPR__RETURN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_7, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[103]);
	}
	
;

parse_org_emftext_language_xpath2_QuantifiedExpr returns [org.emftext.language.xpath2.QuantifiedExpr element = null]
@init{
}
:
	(
		(
			a0 = 'some' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifierKind().getEEnumLiteral(org.emftext.language.xpath2.QuantifierKind.SOME_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER), value);
				completedElement(value, false);
			}
			|			a1 = 'every' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifierKind().getEEnumLiteral(org.emftext.language.xpath2.QuantifierKind.EVERY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__QUANTIFIER), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[104]);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_Iterator		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__ITERATOR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_2, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[106]);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[107]);
			}
			
			(
				a6_0 = parse_org_emftext_language_xpath2_Iterator				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__ITERATOR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_3_0_0_2, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[108]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[109]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[111]);
	}
	
	a7 = 'satisfies' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[137]);
	}
	
	(
		a8_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
		|		a8_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_1 != null) {
				if (a8_1 != null) {
					Object value = a8_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_1, true);
				copyLocalizationInfos(a8_1, element);
			}
		}
		|		a8_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_2 != null) {
				if (a8_2 != null) {
					Object value = a8_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_2, true);
				copyLocalizationInfos(a8_2, element);
			}
		}
		|		a8_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_3 != null) {
				if (a8_3 != null) {
					Object value = a8_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_3, true);
				copyLocalizationInfos(a8_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[143]);
	}
	
;

parse_org_emftext_language_xpath2_Iterator returns [org.emftext.language.xpath2.Iterator element = null]
@init{
}
:
	a0 = '$' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[145]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_VarName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITERATOR__VAR_NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[146]);
	}
	
	a2 = 'in' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[172]);
	}
	
	(
		a3_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
		|		a3_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a3_1 != null) {
				if (a3_1 != null) {
					Object value = a3_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a3_1, true);
				copyLocalizationInfos(a3_1, element);
			}
		}
		|		a3_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a3_2 != null) {
				if (a3_2 != null) {
					Object value = a3_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a3_2, true);
				copyLocalizationInfos(a3_2, element);
			}
		}
		|		a3_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a3_3 != null) {
				if (a3_3 != null) {
					Object value = a3_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a3_3, true);
				copyLocalizationInfos(a3_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[176]);
	}
	
;

parse_org_emftext_language_xpath2_IfExpr returns [org.emftext.language.xpath2.IfExpr element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[177]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[203]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_Expr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
		|		a2_3 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_3 != null) {
				if (a2_3 != null) {
					Object value = a2_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_3, true);
				copyLocalizationInfos(a2_3, element);
			}
		}
		|		a2_4 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_4 != null) {
				if (a2_4 != null) {
					Object value = a2_4;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_4, true);
				copyLocalizationInfos(a2_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[204]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[205]);
	}
	
	a4 = 'then' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[215]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[216]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[217]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[218]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[219]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[228]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[231]);
	}
	
	(
		a5_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
		|		a5_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_3 != null) {
				if (a5_3 != null) {
					Object value = a5_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_3, true);
				copyLocalizationInfos(a5_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[232]);
	}
	
	a6 = 'else' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[243]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[258]);
	}
	
	(
		a7_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
		|		a7_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_1 != null) {
				if (a7_1 != null) {
					Object value = a7_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_1, true);
				copyLocalizationInfos(a7_1, element);
			}
		}
		|		a7_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_2 != null) {
				if (a7_2 != null) {
					Object value = a7_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_2, true);
				copyLocalizationInfos(a7_2, element);
			}
		}
		|		a7_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_3 != null) {
				if (a7_3 != null) {
					Object value = a7_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_3, true);
				copyLocalizationInfos(a7_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[264]);
	}
	
;

parse_org_emftext_language_xpath2_OrExpr returns [org.emftext.language.xpath2.OrExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AndExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOrExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.OR_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[271]);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOrExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[272]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[273]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[274]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[275]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[276]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[277]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[278]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[279]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[280]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[281]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[282]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[283]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[284]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[285]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[286]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[287]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[288]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[289]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[290]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[291]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[292]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[293]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[294]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_AndExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOrExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.OR_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[295]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[296]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[297]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[298]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[299]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[300]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[301]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[303]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[305]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[306]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[307]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[308]);
	}
	
;

parse_org_emftext_language_xpath2_AndExpr returns [org.emftext.language.xpath2.AndExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ComparisonExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAndExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.AND_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[311]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[312]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[313]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[315]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[316]);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAndExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[317]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[318]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[319]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[320]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[321]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[322]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[323]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[324]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[325]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[326]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[327]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[328]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[329]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[330]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[331]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[332]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[333]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[334]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[335]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[336]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[337]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[338]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[339]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_ComparisonExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAndExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.AND_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[340]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[341]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[342]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[343]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[344]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[345]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[346]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[347]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[351]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[352]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[353]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[354]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[355]);
	}
	
;

parse_org_emftext_language_xpath2_ComparisonExpr returns [org.emftext.language.xpath2.ComparisonExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_RangeExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createComparisonExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.COMPARISON_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[356]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[359]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[360]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[363]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[364]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[365]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[366]);
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_language_xpath2_Comp				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createComparisonExpr();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.COMPARISON_EXPR__OPERATOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_1, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[367]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[368]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[369]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[370]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[371]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[372]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[373]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[374]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[375]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[376]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[377]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[378]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[379]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[380]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[381]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[382]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[383]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[384]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[385]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[386]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[387]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[388]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[389]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_RangeExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createComparisonExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.COMPARISON_EXPR__RIGHT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[390]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[391]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[392]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[393]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[394]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[395]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[396]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[397]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[405]);
	}
	
;

parse_org_emftext_language_xpath2_RangeExpr returns [org.emftext.language.xpath2.RangeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AdditiveExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRangeExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.RANGE_EXPR__FROM), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[406]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[407]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[417]);
	}
	
	(
		(
			a1 = 'to' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRangeExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[418]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[419]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[420]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[421]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[422]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[423]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[424]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[425]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[426]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[427]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[428]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[429]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[430]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[431]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[432]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[433]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[434]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[435]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[436]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[437]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[438]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[439]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[440]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_AdditiveExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRangeExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.RANGE_EXPR__TO), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[441]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[442]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[443]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[444]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[445]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[446]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[447]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[448]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[449]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[450]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[451]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[452]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[453]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[454]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[455]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[456]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[457]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[458]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[459]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[460]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[462]);
	}
	
;

parse_org_emftext_language_xpath2_GeneralComp returns [org.emftext.language.xpath2.GeneralComp element = null]
@init{
}
:
	(
		(
			a0 = '=' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.EQ_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '!=' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.NE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '<' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '<=' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>=' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[464]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[465]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[466]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[470]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[471]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[474]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[477]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[478]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[479]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[482]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[483]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[484]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[485]);
	}
	
;

parse_org_emftext_language_xpath2_ValueComp returns [org.emftext.language.xpath2.ValueComp element = null]
@init{
}
:
	(
		(
			a0 = 'eq' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.EQ_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = 'ne' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.NE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = 'lt' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = 'le' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = 'gt' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = 'ge' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[486]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[487]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[493]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[496]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[498]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[499]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[500]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[505]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[508]);
	}
	
;

parse_org_emftext_language_xpath2_NodeComp returns [org.emftext.language.xpath2.NodeComp element = null]
@init{
}
:
	(
		(
			a0 = 'is' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.IS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '<<' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.PRECEDES_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '>>' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.FOLLOWS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[509]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[510]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[512]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[513]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[514]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[515]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[517]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[518]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[520]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[521]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[522]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[523]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[524]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[525]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[526]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[527]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[528]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[529]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[530]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[531]);
	}
	
;

parse_org_emftext_language_xpath2_AdditiveExpr returns [org.emftext.language.xpath2.AdditiveExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAdditiveExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ADDITIVE_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[532]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[533]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[534]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[535]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[536]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[537]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[538]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[539]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[540]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[544]);
	}
	
	(
		(
			(
				(
					a1 = '+' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveOpKind().getEEnumLiteral(org.emftext.language.xpath2.AdditiveOpKind.ADDITION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ADDITIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = '-' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveOpKind().getEEnumLiteral(org.emftext.language.xpath2.AdditiveOpKind.SUBTRACTION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ADDITIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[545]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[546]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[547]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[548]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[549]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[550]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[551]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[552]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[553]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[554]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[555]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[556]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[557]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[558]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[559]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[560]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[561]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[562]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[563]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[564]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[565]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[566]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[567]);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_MultiplicativeExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAdditiveExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ADDITIVE_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[568]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[569]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[570]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[571]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[572]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[573]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[574]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[575]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[576]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[577]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[578]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[579]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[580]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[581]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[582]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[583]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[584]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[585]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[586]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[587]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[588]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[589]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[590]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[591]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[592]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[593]);
	}
	
;

parse_org_emftext_language_xpath2_MultiplicativeExpr returns [org.emftext.language.xpath2.MultiplicativeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_UnionExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[594]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[595]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[596]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[597]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[598]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[599]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[600]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[601]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[602]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[603]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[604]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[605]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[606]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[607]);
	}
	
	(
		(
			(
				(
					a1 = '*' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.MULTIPLICATION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = 'div' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.DIV_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a3 = 'idiv' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.IDIV_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a4 = 'mod' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.MOD_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[608]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[609]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[610]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[611]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[612]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[613]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[614]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[615]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[616]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[617]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[618]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[619]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[620]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[621]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[622]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[623]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[624]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[625]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[626]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[627]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[628]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[629]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[630]);
			}
			
			(
				a7_0 = parse_org_emftext_language_xpath2_UnionExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createMultiplicativeExpr();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.MULTIPLICATIVE_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_3, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[631]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[632]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[633]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[634]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[635]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[636]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[637]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[638]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[639]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[640]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[641]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[642]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[643]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[644]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[645]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[646]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[647]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[648]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[649]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[650]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[651]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[652]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[653]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[654]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[655]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[656]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[657]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[658]);
	}
	
;

parse_org_emftext_language_xpath2_UnionExpr returns [org.emftext.language.xpath2.UnionExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_IntersectExceptExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnionExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNION_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[659]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[660]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[661]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[662]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[663]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[664]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[665]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[666]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[667]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[668]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[669]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[670]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[671]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[672]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[673]);
	}
	
	(
		(
			(
				(
					a1 = 'union' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnionExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionOp().getEEnumLiteral(org.emftext.language.xpath2.UnionOp.UNION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNION_EXPR__OPERATION, value);
						completedElement(value, false);
					}
					|					a2 = '|' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnionExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionOp().getEEnumLiteral(org.emftext.language.xpath2.UnionOp.VERTICAL_BAR_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNION_EXPR__OPERATION, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[674]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[675]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[676]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[677]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[678]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[679]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[680]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[681]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[682]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[683]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[684]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[685]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[686]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[687]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[688]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[689]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[690]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[691]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[692]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[693]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[694]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[695]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[696]);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_IntersectExceptExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnionExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNION_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[697]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[698]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[699]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[700]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[701]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[702]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[703]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[704]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[705]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[706]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[707]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[708]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[709]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[710]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[711]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[712]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[713]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[714]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[715]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[716]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[717]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[726]);
	}
	
;

parse_org_emftext_language_xpath2_IntersectExceptExpr returns [org.emftext.language.xpath2.IntersectExceptExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_InstanceofExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIntersectExceptExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.INTERSECT_EXCEPT_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[730]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[731]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[732]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[733]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[734]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[735]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[736]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[737]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[738]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[739]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[740]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[741]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[742]);
	}
	
	(
		(
			(
				(
					a1 = 'intersect' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIntersectExceptExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptOpKind().getEEnumLiteral(org.emftext.language.xpath2.IntersectExceptOpKind.INTERSECT_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = 'except' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIntersectExceptExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptOpKind().getEEnumLiteral(org.emftext.language.xpath2.IntersectExceptOpKind.EXCEPT_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[743]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[744]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[745]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[746]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[747]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[748]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[749]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[750]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[751]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[752]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[753]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[754]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[755]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[756]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[757]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[758]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[759]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[760]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[761]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[762]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[763]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[764]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[765]);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_InstanceofExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIntersectExceptExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.INTERSECT_EXCEPT_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[766]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[767]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[768]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[769]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[770]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[771]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[772]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[773]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[774]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[775]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[776]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[777]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[778]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[779]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[780]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[781]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[782]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[783]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[784]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[785]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[786]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[787]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[788]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[789]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[790]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[791]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[792]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[793]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[794]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[795]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[796]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[797]);
	}
	
;

parse_org_emftext_language_xpath2_InstanceofExpr returns [org.emftext.language.xpath2.InstanceofExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_TreatExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createInstanceofExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.INSTANCEOF_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[798]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[799]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[800]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[801]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[802]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[803]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[804]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[805]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[806]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[807]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[808]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[809]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[810]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[811]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[812]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[813]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[814]);
	}
	
	(
		(
			a1 = 'instance' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createInstanceofExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[815]);
			}
			
			a2 = 'of' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createInstanceofExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[816]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[817]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[818]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[819]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[820]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[821]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[822]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[823]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[824]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[825]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[826]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[827]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[828]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[829]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[830]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[831]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[832]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[833]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[834]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SequenceType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createInstanceofExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.INSTANCEOF_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[835]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[836]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[837]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[838]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[839]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[840]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[841]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[842]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[843]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[844]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[845]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[846]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[847]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[848]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[849]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[850]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[851]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[852]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[853]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[854]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[855]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[856]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[857]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[858]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[859]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[860]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[861]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[862]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[863]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[864]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[865]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[866]);
	}
	
;

parse_org_emftext_language_xpath2_TreatExpr returns [org.emftext.language.xpath2.TreatExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_CastableExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTreatExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.TREAT_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[867]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[868]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[869]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[870]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[871]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[872]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[873]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[874]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[875]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[876]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[877]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[878]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[879]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[880]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[881]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[882]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[883]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[884]);
	}
	
	(
		(
			a1 = 'treat' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTreatExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[885]);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTreatExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[886]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[887]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[888]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[889]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[890]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[891]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[892]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[893]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[894]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[895]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[896]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[897]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[898]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[899]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[900]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[901]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[902]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[903]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[904]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SequenceType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTreatExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.TREAT_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[905]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[906]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[907]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[908]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[909]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[910]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[911]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[912]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[913]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[914]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[915]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[916]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[917]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[918]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[919]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[920]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[921]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[922]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[923]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[924]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[925]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[926]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[927]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[931]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[932]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[933]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[934]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[935]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[936]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[937]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[938]);
	}
	
;

parse_org_emftext_language_xpath2_CastableExpr returns [org.emftext.language.xpath2.CastableExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_CastExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastableExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.CASTABLE_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[939]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[940]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[941]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[942]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[943]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[944]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[945]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[946]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[947]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[948]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[949]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[950]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[951]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[952]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[953]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[954]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[955]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[956]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[957]);
	}
	
	(
		(
			a1 = 'castable' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastableExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[958]);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastableExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastableExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[959]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastableExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[960]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SingleType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastableExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.CASTABLE_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[961]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[962]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[963]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[964]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[965]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[966]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[967]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[968]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[969]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[970]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[971]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[972]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[973]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[974]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[975]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[976]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[977]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[978]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[979]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[980]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[981]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[982]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[983]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[984]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[985]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[986]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[987]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[988]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[989]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[990]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[991]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[992]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[993]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[994]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[995]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[996]);
	}
	
;

parse_org_emftext_language_xpath2_CastExpr returns [org.emftext.language.xpath2.CastExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_UnaryExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.CAST_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[997]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[998]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[999]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1000]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1001]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1002]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1008]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1009]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1010]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1016]);
	}
	
	(
		(
			a1 = 'cast' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1017]);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1018]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1019]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SingleType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCastExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.CAST_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1020]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1021]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1022]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1023]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1024]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1025]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1026]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1027]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1028]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1029]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1030]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1031]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1032]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1033]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1034]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1035]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1036]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1037]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1038]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1039]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1040]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1041]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1042]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1043]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1044]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1045]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1046]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1047]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1048]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1049]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1050]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1051]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1052]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1053]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1054]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1055]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1056]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1057]);
	}
	
;

parse_org_emftext_language_xpath2_UnaryExpr returns [org.emftext.language.xpath2.UnaryExpr element = null]
@init{
}
:
	(
		(
			(
				a0 = '+' {
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnaryExpr();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
					// set value of enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryOp().getEEnumLiteral(org.emftext.language.xpath2.UnaryOp.PLUS_VALUE).getInstance();
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNARY_EXPR__OPERATOR, value);
					completedElement(value, false);
				}
				|				a1 = '-' {
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnaryExpr();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
					// set value of enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryOp().getEEnumLiteral(org.emftext.language.xpath2.UnaryOp.MINUS_VALUE).getInstance();
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.UNARY_EXPR__OPERATOR, value);
					completedElement(value, false);
				}
			)
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1058]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1059]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1060]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1061]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1062]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1063]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1064]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1065]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1066]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1067]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1068]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1069]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1070]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1071]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1072]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1073]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1074]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1075]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1076]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1077]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1078]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1079]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1080]);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_ValueExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createUnaryExpr();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.UNARY_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_1, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1081]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1082]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1083]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1084]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1085]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1086]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1087]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1088]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1089]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1090]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1091]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1092]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1093]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1094]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1095]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1096]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1097]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1098]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1099]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1100]);
	}
	
;

parse_org_emftext_language_xpath2_FilterExpr returns [org.emftext.language.xpath2.FilterExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_PrimaryExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFilterExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FILTER_EXPR__PRIMARY_EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1101]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1102]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1103]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1104]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1105]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1106]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1107]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1108]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1109]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1110]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1111]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1112]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1113]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1114]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1115]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1116]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1117]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1118]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1119]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1120]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1121]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1122]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1123]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFilterExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FILTER_EXPR__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1124]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1125]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1126]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1127]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1128]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1129]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1130]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1131]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1132]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1133]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1134]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1135]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1136]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1137]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1138]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1139]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1140]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1141]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1142]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1143]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1144]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1145]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1146]);
	}
	
;

parse_org_emftext_language_xpath2_FunctionCall returns [org.emftext.language.xpath2.FunctionCall element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1147]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1148]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1149]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1150]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1151]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1152]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1153]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1154]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1155]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1156]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1157]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1158]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1159]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1160]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1161]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1162]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1163]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1164]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1165]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1166]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1167]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1168]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1169]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1170]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1171]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1172]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1173]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1174]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_xpath2_IfExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_org_emftext_language_xpath2_ForExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_org_emftext_language_xpath2_QuantifiedExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_org_emftext_language_xpath2_OrExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1175]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1176]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1177]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1178]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1179]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1180]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1181]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1182]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1183]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1184]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1185]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1186]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1187]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1188]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1189]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1190]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1191]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1192]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1193]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1194]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1195]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1196]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1197]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1198]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1199]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1200]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1201]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1202]);
					}
					
					(
						a4_0 = parse_org_emftext_language_xpath2_IfExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
						|						a4_1 = parse_org_emftext_language_xpath2_ForExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a4_1 != null) {
								if (a4_1 != null) {
									Object value = a4_1;
									addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a4_1, true);
								copyLocalizationInfos(a4_1, element);
							}
						}
						|						a4_2 = parse_org_emftext_language_xpath2_QuantifiedExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a4_2 != null) {
								if (a4_2 != null) {
									Object value = a4_2;
									addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a4_2, true);
								copyLocalizationInfos(a4_2, element);
							}
						}
						|						a4_3 = parse_org_emftext_language_xpath2_OrExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a4_3 != null) {
								if (a4_3 != null) {
									Object value = a4_3;
									addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a4_3, true);
								copyLocalizationInfos(a4_3, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1203]);
						addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1204]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1205]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1206]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1207]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1208]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1209]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1210]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1211]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1212]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1213]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1214]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1215]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1216]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1217]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1218]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1219]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1220]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1221]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1222]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1223]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1224]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1225]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1226]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1227]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1228]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1229]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1230]);
	}
	
;

parse_org_emftext_language_xpath2_PathExpr returns [org.emftext.language.xpath2.PathExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_PathExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPathExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.PATH_EXPR__STEP, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1231]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1232]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1233]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1234]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1235]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1236]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1237]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1238]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1239]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1240]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1241]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1242]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1243]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1244]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1245]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1246]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1247]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1248]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1249]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1250]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1251]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1252]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_ChildStepExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPathExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.PATH_EXPR__STEP, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
			|			a1_1 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPathExpr();
					startIncompleteElement(element);
				}
				if (a1_1 != null) {
					if (a1_1 != null) {
						Object value = a1_1;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.PATH_EXPR__STEP, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_1, a1_1, true);
					copyLocalizationInfos(a1_1, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1253]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1254]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1255]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1256]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1257]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1258]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1259]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1260]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1261]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1262]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1263]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1264]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1265]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1266]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1267]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1268]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1269]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1270]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1271]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1272]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1273]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1274]);
	}
	
;

parse_org_emftext_language_xpath2_ChildStepExpr returns [org.emftext.language.xpath2.ChildStepExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createChildStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1275]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1276]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1277]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1278]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1279]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1280]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1281]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1282]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1283]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1284]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1285]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1286]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1287]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1288]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1289]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1290]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1291]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1292]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1293]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createChildStepExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.CHILD_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_24_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1294]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1295]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1296]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1297]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1298]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1299]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1300]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1301]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1302]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1303]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1304]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1305]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1306]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1307]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1308]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1309]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1310]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1311]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1312]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1313]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1314]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1315]);
	}
	
;

parse_org_emftext_language_xpath2_DescOrSelfStepExpr returns [org.emftext.language.xpath2.DescOrSelfStepExpr element = null]
@init{
}
:
	a0 = '//' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDescOrSelfStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1316]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1317]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1318]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1319]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1320]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1321]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1322]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1323]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1324]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1325]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1326]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1327]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1328]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1329]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1330]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1331]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1332]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1333]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1334]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDescOrSelfStepExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DESC_OR_SELF_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1335]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1336]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1337]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1338]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1339]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1340]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1341]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1342]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1343]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1344]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1345]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1346]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1347]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1348]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1349]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1350]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1351]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1352]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1353]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1354]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1355]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1356]);
	}
	
;

parse_org_emftext_language_xpath2_RootStepExpr returns [org.emftext.language.xpath2.RootStepExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRootStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_26_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1357]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1358]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1359]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1360]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1361]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1362]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1363]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1364]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1365]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1366]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1367]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1368]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1369]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1370]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1371]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1372]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1373]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1374]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1375]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1376]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1377]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1378]);
	}
	
;

parse_org_emftext_language_xpath2_SelfStepExpr returns [org.emftext.language.xpath2.SelfStepExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_SelfStepExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSelfStepExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SELF_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_27_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1379]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1380]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1381]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1382]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1383]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1384]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1385]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1386]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1387]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1388]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1389]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1390]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1391]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1392]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1393]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1394]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1395]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1396]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1397]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1398]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1399]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1400]);
	}
	
;

parse_org_emftext_language_xpath2_GeneralForwardStep returns [org.emftext.language.xpath2.GeneralForwardStep element = null]
@init{
}
:
	(
		(
			a0 = 'child' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.CHILD_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a1 = 'descendant' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a2 = 'attribute' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.ATTRIBUTE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a3 = 'self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a4 = 'descendant-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a5 = 'following-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a6 = 'following' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a7 = 'namespace' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.NAMESPACE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1401]);
	}
	
	a10 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1402]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1403]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1404]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1405]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1406]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1407]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1408]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1409]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1410]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1411]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1412]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1413]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1414]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1415]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1416]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1417]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1418]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1419]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1420]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1421]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1422]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1423]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1424]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1425]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1426]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1427]);
	}
	
	(
		a11_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
				startIncompleteElement(element);
			}
			if (a11_0 != null) {
				if (a11_0 != null) {
					Object value = a11_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_2, a11_0, true);
				copyLocalizationInfos(a11_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1428]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1429]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1430]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1431]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1432]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1433]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1434]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1435]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1436]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1437]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1438]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1439]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1440]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1441]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1442]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1443]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1444]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1445]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1446]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1447]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1448]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1449]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1450]);
	}
	
	(
		(
			a12_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				if (a12_0 != null) {
					if (a12_0 != null) {
						Object value = a12_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_3, a12_0, true);
					copyLocalizationInfos(a12_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1451]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1452]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1453]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1454]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1455]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1456]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1457]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1458]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1459]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1460]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1461]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1462]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1463]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1464]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1465]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1466]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1467]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1468]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1469]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1470]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1471]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1472]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1473]);
	}
	
;

parse_org_emftext_language_xpath2_AbbrevForwardStep returns [org.emftext.language.xpath2.AbbrevForwardStep element = null]
@init{
}
:
	(
		(
			a0 = '@' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevForwardStep();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__KIND), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.ATTRIBUTE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__KIND), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1474]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1475]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1476]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1477]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1478]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1479]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1480]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1481]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1482]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1483]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1484]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1485]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1486]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1487]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1488]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1489]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1490]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1491]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1492]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1493]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1494]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1495]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1496]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1497]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1498]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1499]);
	}
	
	(
		a3_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevForwardStep();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__KIND), value);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_1, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1500]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1501]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1502]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1503]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1504]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1505]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1506]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1507]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1508]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1509]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1510]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1511]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1512]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1513]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1514]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1515]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1516]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1517]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1518]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1519]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1520]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1521]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1522]);
	}
	
	(
		(
			a4_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevForwardStep();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__KIND), value);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_2, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1523]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1524]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1525]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1526]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1527]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1528]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1529]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1530]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1531]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1532]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1533]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1534]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1535]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1536]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1537]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1538]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1539]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1540]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1541]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1542]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1543]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1544]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1545]);
	}
	
;

parse_org_emftext_language_xpath2_GeneralReverseStep returns [org.emftext.language.xpath2.GeneralReverseStep element = null]
@init{
}
:
	(
		(
			a0 = 'parent' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PARENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a1 = 'ancestor' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a2 = 'preceding-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a3 = 'preceding' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a4 = 'ancestor-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1546]);
	}
	
	a7 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1547]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1548]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1549]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1550]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1551]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1552]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1553]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1554]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1555]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1556]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1557]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1558]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1559]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1560]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1561]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1562]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1563]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1564]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1565]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1566]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1567]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1568]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1569]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1570]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1571]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1572]);
	}
	
	(
		a8_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_2, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1573]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1574]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1575]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1576]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1577]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1578]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1579]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1580]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1581]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1582]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1583]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1584]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1585]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1586]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1587]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1588]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1589]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1590]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1591]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1592]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1593]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1594]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1595]);
	}
	
	(
		(
			a9_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				if (a9_0 != null) {
					if (a9_0 != null) {
						Object value = a9_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_3, a9_0, true);
					copyLocalizationInfos(a9_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1596]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1597]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1598]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1599]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1600]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1601]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1602]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1603]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1604]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1605]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1606]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1607]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1608]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1609]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1610]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1611]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1612]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1613]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1614]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1615]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1616]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1617]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1618]);
	}
	
;

parse_org_emftext_language_xpath2_AbbrevReverseStep returns [org.emftext.language.xpath2.AbbrevReverseStep element = null]
@init{
}
:
	(
		(
			a0 = '..' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevReverseStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevReverseStepKind.PARENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_REVERSE_STEP__KIND), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1619]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1620]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1621]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1622]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1623]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1624]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1625]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1626]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1627]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1628]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1629]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1630]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1631]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1632]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1633]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1634]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1635]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1636]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1637]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1638]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1639]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1640]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1641]);
	}
	
	(
		(
			a3_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevReverseStep();
					startIncompleteElement(element);
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						Object value = a3_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.ABBREV_REVERSE_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_1, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1642]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1643]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1644]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1645]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1646]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1647]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1648]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1649]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1650]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1651]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1652]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1653]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1654]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1655]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1656]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1657]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1658]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1659]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1660]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1661]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1662]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1663]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1664]);
	}
	
;

parse_org_emftext_language_xpath2_NodeKindTest returns [org.emftext.language.xpath2.NodeKindTest element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_KindTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNodeKindTest();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NODE_KIND_TEST__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_32_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1665]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1666]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1667]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1668]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1669]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1670]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1671]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1672]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1673]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1674]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1675]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1676]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1677]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1678]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1679]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1680]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1681]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1682]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1683]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1684]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1685]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1686]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1687]);
	}
	
;

parse_org_emftext_language_xpath2_QNameTest returns [org.emftext.language.xpath2.QNameTest element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQNameTest();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_33_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1688]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1689]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1690]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1691]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1692]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1693]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1694]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1695]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1696]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1697]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1698]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1699]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1700]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1701]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1702]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1703]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1704]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1705]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1706]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1707]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1708]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1709]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1710]);
	}
	
;

parse_org_emftext_language_xpath2_AnyWildcard returns [org.emftext.language.xpath2.AnyWildcard element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_34_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1711]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1712]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1713]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1714]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1715]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1716]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1717]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1718]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1719]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1720]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1721]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1722]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1723]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1724]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1725]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1726]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1727]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1728]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1729]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1730]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1731]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1732]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1733]);
	}
	
;

parse_org_emftext_language_xpath2_LocalNameWildcard returns [org.emftext.language.xpath2.LocalNameWildcard element = null]
@init{
}
:
	(
		a0 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.LOCAL_NAME_WILDCARD__NAMESPACE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.LOCAL_NAME_WILDCARD__NAMESPACE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1734]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1735]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1736]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1737]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1738]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1739]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1740]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1741]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1742]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1743]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1744]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1745]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1746]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1747]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1748]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1749]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1750]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1751]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1752]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1753]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1754]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1755]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1756]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1757]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1758]);
	}
	
;

parse_org_emftext_language_xpath2_NamespaceWildcard returns [org.emftext.language.xpath2.NamespaceWildcard element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNamespaceWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1759]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNamespaceWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1760]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNamespaceWildcard();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAMESPACE_WILDCARD__LOCAL_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAMESPACE_WILDCARD__LOCAL_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1761]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1762]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1763]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1764]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1765]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1766]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1767]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1768]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1769]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1770]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1771]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1772]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1773]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1774]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1775]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1776]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1777]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1778]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1779]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1780]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1781]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1782]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1783]);
	}
	
;

parse_org_emftext_language_xpath2_Predicate returns [org.emftext.language.xpath2.Predicate element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPredicate();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1784]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1785]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1786]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1787]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1788]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1789]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1790]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1791]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1792]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1793]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1794]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1795]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1796]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1797]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1798]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1799]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1800]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1801]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1802]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1803]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1804]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1805]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1806]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1807]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1808]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1809]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_Expr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPredicate();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.PREDICATE__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1810]);
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPredicate();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1811]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1812]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1813]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1814]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1815]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1816]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1817]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1818]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1819]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1820]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1821]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1822]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1823]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1824]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1825]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1826]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1827]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1828]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1829]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1830]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1831]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1832]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1833]);
	}
	
;

parse_org_emftext_language_xpath2_VarRef returns [org.emftext.language.xpath2.VarRef element = null]
@init{
}
:
	a0 = '$' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarRef();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarRef(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1834]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarRef(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1835]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_VarName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarRef();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_REF__VAR_NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1836]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1837]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1838]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1839]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1840]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1841]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1842]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1843]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1844]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1845]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1846]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1847]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1848]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1849]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1850]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1851]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1852]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1853]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1854]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1855]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1856]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1857]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1858]);
	}
	
;

parse_org_emftext_language_xpath2_VarName returns [org.emftext.language.xpath2.VarName element = null]
@init{
}
:
	(
		(
			(
				a0 = NCNAME				
				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarName();
						startIncompleteElement(element);
					}
					if (a0 != null) {
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_NAME__PREFIX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_NAME__PREFIX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1859]);
			}
			
			a1 = ':' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarName();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1860]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1861]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarName();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_NAME__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_NAME__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1862]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1863]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1864]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1865]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1866]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1867]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1868]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1869]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1870]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1871]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1872]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1873]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1874]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1875]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1876]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1877]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1878]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1879]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1880]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1881]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1882]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1883]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1884]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1885]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1886]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1887]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1888]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1889]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1890]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1891]);
	}
	
;

parse_org_emftext_language_xpath2_ParenthesizedExpr returns [org.emftext.language.xpath2.ParenthesizedExpr element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createParenthesizedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1892]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1893]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1894]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1895]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1896]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1897]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1898]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1899]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1900]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1901]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1902]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1903]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1904]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1905]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1906]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1907]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1908]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1909]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1910]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1911]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1912]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1913]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1914]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1915]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1916]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1917]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1918]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_Expr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createParenthesizedExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.PARENTHESIZED_EXPR__EXPR), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1919]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createParenthesizedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1920]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1921]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1922]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1923]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1924]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1925]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1926]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1927]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1928]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1929]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1930]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1931]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1932]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1933]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1934]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1935]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1936]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1937]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1938]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1939]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1940]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1941]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1942]);
	}
	
;

parse_org_emftext_language_xpath2_ContextItemExpr returns [org.emftext.language.xpath2.ContextItemExpr element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createContextItemExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_41_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1943]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1944]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1945]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1946]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1947]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1948]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1949]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1950]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1951]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1952]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1953]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1954]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1955]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1956]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1957]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1958]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1959]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1960]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1961]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1962]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1963]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1964]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1965]);
	}
	
;

parse_org_emftext_language_xpath2_SingleType returns [org.emftext.language.xpath2.SingleType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AtomicType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSingleType();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TYPE__OPTIONAL), value);
				}
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TYPE__TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1966]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1967]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1968]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1969]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1970]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1971]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1972]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1973]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1974]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1975]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1976]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1977]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1978]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1979]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1980]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1981]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1982]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1983]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1984]);
	}
	
	(
		(
			a1 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSingleType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TYPE__OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TYPE__OPTIONAL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1985]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1986]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1987]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1988]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1989]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1990]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1991]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1992]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1993]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1994]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1995]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1996]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1997]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1998]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1999]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2000]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2001]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2002]);
	}
	
;

parse_org_emftext_language_xpath2_EmptySequenceType returns [org.emftext.language.xpath2.EmptySequenceType element = null]
@init{
}
:
	a0 = 'empty-sequence' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2003]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2004]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2005]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2006]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2007]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2008]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2009]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2010]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2011]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2012]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2013]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2014]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2015]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2016]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2017]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2018]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2019]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2020]);
	}
	
;

parse_org_emftext_language_xpath2_ItemSequenceType returns [org.emftext.language.xpath2.ItemSequenceType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ItemType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createItemSequenceType();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_44_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2021]);
	}
	
	(
		(
			a1 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_44_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.OPTIONAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
			|			a2 = '*' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_44_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
			|			a3 = '+' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_44_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2022]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2023]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2024]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2025]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2026]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2027]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2028]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2029]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2030]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2031]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2032]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2033]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2034]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2035]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2036]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2037]);
	}
	
;

parse_org_emftext_language_xpath2_ItemKindTest returns [org.emftext.language.xpath2.ItemKindTest element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_KindTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createItemKindTest();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_KIND_TEST__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2038]);
	}
	
;

parse_org_emftext_language_xpath2_AnyItemType returns [org.emftext.language.xpath2.AnyItemType element = null]
@init{
}
:
	a0 = 'item' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2039]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2040]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2041]);
	}
	
;

parse_org_emftext_language_xpath2_AtomicItemType returns [org.emftext.language.xpath2.AtomicItemType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AtomicType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAtomicItemType();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_ITEM_TYPE__TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2042]);
	}
	
;

parse_org_emftext_language_xpath2_AtomicType returns [org.emftext.language.xpath2.AtomicType element = null]
@init{
}
:
	(
		(
			(
				a0 = NCNAME				
				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAtomicType();
						startIncompleteElement(element);
					}
					if (a0 != null) {
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_TYPE__PREFIX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_TYPE__PREFIX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2043]);
			}
			
			a1 = ':' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAtomicType();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2044]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2045]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAtomicType();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_TYPE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_TYPE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2046]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2047]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2048]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2049]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2050]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2051]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2052]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2053]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2054]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2055]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2056]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2057]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2058]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2059]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2060]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2061]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2062]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2063]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2064]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2065]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2066]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2067]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2068]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2069]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2070]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2071]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2072]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2073]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2074]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2075]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2076]);
	}
	
;

parse_org_emftext_language_xpath2_OptionalAtomicType returns [org.emftext.language.xpath2.OptionalAtomicType element = null]
@init{
}
:
	(
		(
			(
				a0 = NCNAME				
				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOptionalAtomicType();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
						}
					}
					if (a0 != null) {
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__PREFIX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__PREFIX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2077]);
			}
			
			a1 = ':' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOptionalAtomicType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2078]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2079]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOptionalAtomicType();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
				}
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2080]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2081]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2082]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2083]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2084]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2085]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2086]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2087]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2088]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2089]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2090]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2091]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2092]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2093]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2094]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2095]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2096]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2097]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2098]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2099]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2100]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2101]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2102]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2103]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2104]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2105]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2106]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2107]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2108]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2109]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2110]);
	}
	
	(
		(
			a3 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOptionalAtomicType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_2, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2111]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2112]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2113]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2114]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2115]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2116]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2117]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2118]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2119]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2120]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2121]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2122]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2123]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2124]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2125]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2126]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2127]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2128]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2129]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2130]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2131]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2132]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2133]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2134]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2135]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2136]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2137]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2138]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2139]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2140]);
	}
	
;

parse_org_emftext_language_xpath2_AnyKindTest returns [org.emftext.language.xpath2.AnyKindTest element = null]
@init{
}
:
	a0 = 'node' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2141]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2142]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2143]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2144]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2145]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2146]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2147]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2148]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2149]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2150]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2151]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2152]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2153]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2154]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2155]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2156]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2157]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2158]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2159]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2160]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2161]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2162]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2163]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2164]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2165]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2166]);
	}
	
;

parse_org_emftext_language_xpath2_DocumentTest returns [org.emftext.language.xpath2.DocumentTest element = null]
@init{
}
:
	a0 = 'document-node' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2167]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2168]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2169]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2170]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2171]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2172]);
	}
	
	(
		(
			a2_0 = parse_org_emftext_language_xpath2_ElementTest			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOCUMENT_TEST__TEST), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
			|			a2_1 = parse_org_emftext_language_xpath2_SchemaElementTest			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
					startIncompleteElement(element);
				}
				if (a2_1 != null) {
					if (a2_1 != null) {
						Object value = a2_1;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOCUMENT_TEST__TEST), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_2, a2_1, true);
					copyLocalizationInfos(a2_1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2173]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2174]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2175]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2176]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2177]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2178]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2179]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2180]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2181]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2182]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2183]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2184]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2185]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2186]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2187]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2188]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2189]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2190]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2191]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2192]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2193]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2194]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2195]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2196]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2197]);
	}
	
;

parse_org_emftext_language_xpath2_TextTest returns [org.emftext.language.xpath2.TextTest element = null]
@init{
}
:
	a0 = 'text' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2198]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2199]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2200]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2201]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2202]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2203]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2204]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2205]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2206]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2207]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2208]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2209]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2210]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2211]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2212]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2213]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2214]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2215]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2216]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2217]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2218]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2219]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2220]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2221]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2222]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2223]);
	}
	
;

parse_org_emftext_language_xpath2_CommentTest returns [org.emftext.language.xpath2.CommentTest element = null]
@init{
}
:
	a0 = 'comment' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2224]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2225]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2226]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2227]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2228]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2229]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2230]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2231]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2232]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2233]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2234]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2235]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2236]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2237]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2238]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2239]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2240]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2241]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2242]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2243]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2244]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2245]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2246]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2247]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2248]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2249]);
	}
	
;

parse_org_emftext_language_xpath2_PITest returns [org.emftext.language.xpath2.PITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2250]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2251]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2252]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2253]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2254]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2255]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2256]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2257]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2258]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2259]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2260]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2261]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2262]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2263]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2264]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2265]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2266]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2267]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2268]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2269]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2270]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2271]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2272]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2273]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2274]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2275]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_NCNamePITest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_StringLiteralPITest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_NCNamePITest returns [org.emftext.language.xpath2.NCNamePITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2276]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2277]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NC_NAME_PI_TEST__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NC_NAME_PI_TEST__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2278]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2279]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2280]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2281]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2282]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2283]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2284]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2285]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2286]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2287]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2288]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2289]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2290]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2291]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2292]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2293]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2294]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2295]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2296]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2297]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2298]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2299]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2300]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2301]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2302]);
	}
	
;

parse_org_emftext_language_xpath2_StringLiteralPITest returns [org.emftext.language.xpath2.StringLiteralPITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2303]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2304]);
	}
	
	(
		a2 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.STRING_LITERAL_PI_TEST__LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.xpath2.StringLiteral proxy = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContextDependentURIFragmentFactory<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getStringLiteralPITestLiteralReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.STRING_LITERAL_PI_TEST__LITERAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.STRING_LITERAL_PI_TEST__LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2305]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2306]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2307]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2308]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2309]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2310]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2311]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2312]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2313]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2314]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2315]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2316]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2317]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2318]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2319]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2320]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2321]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2322]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2323]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2324]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2325]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2326]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2327]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2328]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2329]);
	}
	
;

parse_org_emftext_language_xpath2_AttributeTest returns [org.emftext.language.xpath2.AttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2330]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2331]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2332]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2333]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2334]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2335]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2336]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2337]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2338]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2339]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2340]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2341]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2342]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2343]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2344]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2345]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2346]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2347]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2348]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2349]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2350]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2351]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2352]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2353]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2354]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2355]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_WildcardAttributeTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_NameAttributeTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_WildcardAttributeTest returns [org.emftext.language.xpath2.WildcardAttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2356]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2357]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2358]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2359]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2360]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2361]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2362]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2363]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2364]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2365]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2366]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2367]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_QName				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2368]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2369]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2370]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2371]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2372]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2373]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2374]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2375]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2376]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2377]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2378]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2379]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2380]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2381]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2382]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2383]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2384]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2385]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2386]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2387]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2388]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2389]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2390]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2391]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2392]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2393]);
	}
	
;

parse_org_emftext_language_xpath2_NameAttributeTest returns [org.emftext.language.xpath2.NameAttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2394]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2395]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2396]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2397]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2398]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2399]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2400]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2401]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2402]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ATTRIBUTE_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2403]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2404]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2405]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2406]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2407]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2408]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2409]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2410]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2411]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2412]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_QName				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ATTRIBUTE_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2413]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2414]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2415]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2416]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2417]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2418]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2419]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2420]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2421]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2422]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2423]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2424]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2425]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2426]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2427]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2428]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2429]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2430]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2431]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2432]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2433]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2434]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2435]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2436]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2437]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2438]);
	}
	
;

parse_org_emftext_language_xpath2_SchemaAttributeTest returns [org.emftext.language.xpath2.SchemaAttributeTest element = null]
@init{
}
:
	a0 = 'schema-attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2439]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2440]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2441]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2442]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2443]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2444]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2445]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2446]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2447]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2448]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2449]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2450]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2451]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2452]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2453]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2454]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2455]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2456]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2457]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2458]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2459]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2460]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2461]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2462]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2463]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2464]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2465]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2466]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2467]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2468]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2469]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2470]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2471]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2472]);
	}
	
;

parse_org_emftext_language_xpath2_ElementTest returns [org.emftext.language.xpath2.ElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2473]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2474]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2475]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2476]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2477]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2478]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2479]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2480]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2481]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2482]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2483]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2484]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2485]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2486]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2487]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2488]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2489]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2490]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2491]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2492]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2493]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2494]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2495]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2496]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2497]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2498]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2499]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_WildcardElementTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_NameElementTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_WildcardElementTest returns [org.emftext.language.xpath2.WildcardElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2500]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2501]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2502]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2503]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2504]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2505]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_OptionalAtomicType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2506]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2507]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2508]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2509]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2510]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2511]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2512]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2513]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2514]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2515]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2516]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2517]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2518]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2519]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2520]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2521]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2522]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2523]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2524]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2525]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2526]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2527]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2528]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2529]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2530]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2531]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2532]);
	}
	
;

parse_org_emftext_language_xpath2_NameElementTest returns [org.emftext.language.xpath2.NameElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2533]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2534]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2535]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2536]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2537]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2538]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2539]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2540]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2541]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2542]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2543]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2544]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2545]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_OptionalAtomicType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2546]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2547]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2548]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2549]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2550]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2551]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2552]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2553]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2554]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2555]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2556]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2557]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2558]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2559]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2560]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2561]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2562]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2563]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2564]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2565]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2566]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2567]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2568]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2569]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2570]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2571]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2572]);
	}
	
;

parse_org_emftext_language_xpath2_SchemaElementTest returns [org.emftext.language.xpath2.SchemaElementTest element = null]
@init{
}
:
	a0 = 'schema-element' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2573]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2574]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2575]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2576]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2577]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2578]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2579]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2580]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2581]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SCHEMA_ELEMENT_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2582]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2583]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2584]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2585]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2586]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2587]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2588]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2589]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2590]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2591]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2592]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2593]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2594]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2595]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2596]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2597]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2598]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2599]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2600]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2601]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2602]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2603]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2604]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2605]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2606]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2607]);
	}
	
;

parse_org_emftext_language_xpath2_IntegerLiteral returns [org.emftext.language.xpath2.IntegerLiteral element = null]
@init{
}
:
	(
		a0 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIntegerLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.INTEGER_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.INTEGER_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_65_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2608]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2609]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2610]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2611]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2612]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2613]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2614]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2615]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2616]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2617]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2618]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2619]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2620]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2621]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2622]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2623]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2624]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2625]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2626]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2627]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2628]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2629]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2630]);
	}
	
;

parse_org_emftext_language_xpath2_DecimalLiteral returns [org.emftext.language.xpath2.DecimalLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDecimalLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DECIMAL_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Float resolved = (java.lang.Float) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DECIMAL_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_66_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2631]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2632]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2633]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2634]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2635]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2636]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2637]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2638]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2639]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2640]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2641]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2642]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2643]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2644]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2645]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2646]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2647]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2648]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2649]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2650]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2651]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2652]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2653]);
	}
	
;

parse_org_emftext_language_xpath2_DoubleLiteral returns [org.emftext.language.xpath2.DoubleLiteral element = null]
@init{
}
:
	(
		a0 = DOUBLE_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDoubleLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DOUBLE_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOUBLE_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Double resolved = (java.lang.Double) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOUBLE_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_67_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2654]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2655]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2656]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2657]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2658]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2659]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2660]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2661]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2662]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2663]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2664]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2665]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2666]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2667]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2668]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2669]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2670]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2671]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2672]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2673]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2674]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2675]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2676]);
	}
	
;

parse_org_emftext_language_xpath2_StringLiteral returns [org.emftext.language.xpath2.StringLiteral element = null]
@init{
}
:
	(
		a0 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.STRING_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.STRING_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_68_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2677]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2678]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2679]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2680]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2681]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2682]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2683]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2684]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2685]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2686]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2687]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2688]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2689]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2690]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2691]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2692]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2693]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2694]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2695]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2696]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2697]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2698]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2699]);
	}
	
;

parse_org_emftext_language_xpath2_QName returns [org.emftext.language.xpath2.QName element = null]
@init{
}
:
	(
		(
			(
				a0 = NCNAME				
				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQName();
						startIncompleteElement(element);
					}
					if (a0 != null) {
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__PREFIX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__PREFIX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_69_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2700]);
			}
			
			a1 = ':' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQName();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_69_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2701]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2702]);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQName();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_69_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2703]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2704]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2705]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2706]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2707]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2708]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2709]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2710]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2711]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2712]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2713]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2714]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2715]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2716]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2717]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2718]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2719]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2720]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2721]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2722]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2723]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2724]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2725]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2726]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2727]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2728]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2729]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2730]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2731]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_VarName{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_AtomicType{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_OptionalAtomicType{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ExprSingle returns [org.emftext.language.xpath2.ExprSingle element = null]
:
	c0 = parse_org_emftext_language_xpath2_ForExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_QuantifiedExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_IfExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_OrExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_AndExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_ComparisonExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_RangeExpr{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_MultiplicativeExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_UnionExpr{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_IntersectExceptExpr{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_InstanceofExpr{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_TreatExpr{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_CastableExpr{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_CastExpr{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_org_emftext_language_xpath2_UnaryExpr{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_org_emftext_language_xpath2_FilterExpr{ element = c16; /* this is a subclass or primitive expression choice */ }
	|	c17 = parse_org_emftext_language_xpath2_FunctionCall{ element = c17; /* this is a subclass or primitive expression choice */ }
	|	c18 = parse_org_emftext_language_xpath2_PathExpr{ element = c18; /* this is a subclass or primitive expression choice */ }
	|	c19 = parse_org_emftext_language_xpath2_ChildStepExpr{ element = c19; /* this is a subclass or primitive expression choice */ }
	|	c20 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr{ element = c20; /* this is a subclass or primitive expression choice */ }
	|	c21 = parse_org_emftext_language_xpath2_RootStepExpr{ element = c21; /* this is a subclass or primitive expression choice */ }
	|	c22 = parse_org_emftext_language_xpath2_SelfStepExpr{ element = c22; /* this is a subclass or primitive expression choice */ }
	|	c23 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c23; /* this is a subclass or primitive expression choice */ }
	|	c24 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c24; /* this is a subclass or primitive expression choice */ }
	|	c25 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c25; /* this is a subclass or primitive expression choice */ }
	|	c26 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c26; /* this is a subclass or primitive expression choice */ }
	|	c27 = parse_org_emftext_language_xpath2_VarRef{ element = c27; /* this is a subclass or primitive expression choice */ }
	|	c28 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c28; /* this is a subclass or primitive expression choice */ }
	|	c29 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c29; /* this is a subclass or primitive expression choice */ }
	|	c30 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c30; /* this is a subclass or primitive expression choice */ }
	|	c31 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c31; /* this is a subclass or primitive expression choice */ }
	|	c32 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c32; /* this is a subclass or primitive expression choice */ }
	|	c33 = parse_org_emftext_language_xpath2_StringLiteral{ element = c33; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_Comp returns [org.emftext.language.xpath2.Comp element = null]
:
	c0 = parse_org_emftext_language_xpath2_GeneralComp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ValueComp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_NodeComp{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_SequenceType returns [org.emftext.language.xpath2.SequenceType element = null]
:
	c0 = parse_org_emftext_language_xpath2_EmptySequenceType{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ItemSequenceType{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ValueExpr returns [org.emftext.language.xpath2.ValueExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_PathExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_PrimaryExpr returns [org.emftext.language.xpath2.PrimaryExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_FunctionCall{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_VarRef{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_StringLiteral{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_PathExprChild returns [org.emftext.language.xpath2.PathExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_FilterExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_FunctionCall{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_ChildStepExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_RootStepExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_SelfStepExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_VarRef{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_org_emftext_language_xpath2_StringLiteral{ element = c16; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_StepExpr returns [org.emftext.language.xpath2.StepExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_FilterExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_SelfStepExprChild returns [org.emftext.language.xpath2.SelfStepExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_FilterExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_FunctionCall{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_VarRef{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_StringLiteral{ element = c12; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_NodeTest returns [org.emftext.language.xpath2.NodeTest element = null]
:
	c0 = parse_org_emftext_language_xpath2_NodeKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_QNameTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AnyWildcard{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_LocalNameWildcard{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_NamespaceWildcard{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_KindTest returns [org.emftext.language.xpath2.KindTest element = null]
:
	c0 = parse_org_emftext_language_xpath2_AnyKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_DocumentTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_TextTest{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_CommentTest{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_PITest{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_NCNamePITest{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_StringLiteralPITest{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AttributeTest{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_WildcardAttributeTest{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_NameAttributeTest{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_SchemaAttributeTest{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_ElementTest{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_WildcardElementTest{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_NameElementTest{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_SchemaElementTest{ element = c14; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ItemType returns [org.emftext.language.xpath2.ItemType element = null]
:
	c0 = parse_org_emftext_language_xpath2_ItemKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_AnyItemType{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AtomicItemType{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

INTEGER_LITERAL:
	(('0'..'9')+)
;
DECIMAL_LITERAL:
	(('.'('0'..'9')+)|(('0'..'9')+'.'('0'..'9')*))
;
DOUBLE_LITERAL:
	(('.'('0'..'9')+)|(('0'..'9')+('.'('0'..'9')*)?)('e'|'E')('+'|'-')?('0'..'9')+)
;
NCNAME:
	(('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD')('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040')*)
;
STRING_LITERAL:
	(('\"')('\"\"'|~('\"'))*('\"')|('\'')('\'\''|~('\''))*('\''))
;
WHITESPACE:
	((' '|'\t'|'\f'|'\r'|'\n')+)
	{ _channel = 99; }
;

