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
			if (type.getInstanceClass() == org.emftext.language.xpath2.SimpleForClause.class) {
				return parse_org_emftext_language_xpath2_SimpleForClause();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SimpleForClauseIterator.class) {
				return parse_org_emftext_language_xpath2_SimpleForClauseIterator();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QuantifiedExpr.class) {
				return parse_org_emftext_language_xpath2_QuantifiedExpr();
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
			if (type.getInstanceClass() == org.emftext.language.xpath2.AdditiveExpr.class) {
				return parse_org_emftext_language_xpath2_AdditiveExpr();
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
			if (type.getInstanceClass() == org.emftext.language.xpath2.SinglePathExpr.class) {
				return parse_org_emftext_language_xpath2_SinglePathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DoublePathExpr.class) {
				return parse_org_emftext_language_xpath2_DoublePathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.RelativePathExpr.class) {
				return parse_org_emftext_language_xpath2_RelativePathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SingleTailPathExpr.class) {
				return parse_org_emftext_language_xpath2_SingleTailPathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DoubleTailPathExpr.class) {
				return parse_org_emftext_language_xpath2_DoubleTailPathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AxisStep.class) {
				return parse_org_emftext_language_xpath2_AxisStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralForwardStep.class) {
				return parse_org_emftext_language_xpath2_GeneralForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevForwardStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ForwardAxis.class) {
				return parse_org_emftext_language_xpath2_ForwardAxis();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralReverseStep.class) {
				return parse_org_emftext_language_xpath2_GeneralReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevReverseStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ReverseAxis.class) {
				return parse_org_emftext_language_xpath2_ReverseAxis();
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
			if (type.getInstanceClass() == org.emftext.language.xpath2.FilterExpr.class) {
				return parse_org_emftext_language_xpath2_FilterExpr();
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
			if (type.getInstanceClass() == org.emftext.language.xpath2.FunctionCall.class) {
				return parse_org_emftext_language_xpath2_FunctionCall();
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
		int followSetID = 197;
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[35]);
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
		a0_0 = parse_org_emftext_language_xpath2_ExprSingle		{
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
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__OWNED_EXPR_SINGLE, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[39]);
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
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[63]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[64]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[65]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[66]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[67]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[68]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[69]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[70]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[72]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[75]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_ExprSingle				{
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
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.EXPR__OWNED_EXPR_SINGLE, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[79]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[83]);
	}
	
;

parse_org_emftext_language_xpath2_ForExpr returns [org.emftext.language.xpath2.ForExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_SimpleForClause		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[84]);
	}
	
	a1 = 'return' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[120]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_ExprSingle		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FOR_EXPR__RETURN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[129]);
	}
	
;

parse_org_emftext_language_xpath2_SimpleForClause returns [org.emftext.language.xpath2.SimpleForClause element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClause(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[130]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_SimpleForClauseIterator		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClause();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[132]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClause(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[133]);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SimpleForClauseIterator				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClause();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.SIMPLE_FOR_CLAUSE__ITERATOR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[134]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[135]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[137]);
	}
	
;

parse_org_emftext_language_xpath2_SimpleForClauseIterator returns [org.emftext.language.xpath2.SimpleForClauseIterator element = null]
@init{
}
:
	a0 = '$' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClauseIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[138]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClauseIterator();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SIMPLE_FOR_CLAUSE_ITERATOR__VAR_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SIMPLE_FOR_CLAUSE_ITERATOR__VAR_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[139]);
	}
	
	a2 = 'in' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClauseIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSimpleForClauseIterator(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[175]);
	}
	
	(
		a3_0 = parse_org_emftext_language_xpath2_ExprSingle		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSimpleForClauseIterator();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SIMPLE_FOR_CLAUSE_ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[179]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_0, null, true);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[180]);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_SimpleForClauseIterator		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_1, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[182]);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[183]);
			}
			
			(
				a6_0 = parse_org_emftext_language_xpath2_SimpleForClauseIterator				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_2_0_0_1, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[184]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[185]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[187]);
	}
	
	a7 = 'satisfies' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQuantifiedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[215]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[216]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[217]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[218]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[219]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[223]);
	}
	
	(
		a8_0 = parse_org_emftext_language_xpath2_ExprSingle		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_4, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[228]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[232]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[233]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[269]);
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
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.IF_EXPR__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[270]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[271]);
	}
	
	a4 = 'then' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[278]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[284]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[285]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[286]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[287]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[288]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[289]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[290]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[291]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[292]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[293]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[294]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[295]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[299]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[300]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[301]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[303]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[305]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[306]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[307]);
	}
	
	(
		a5_0 = parse_org_emftext_language_xpath2_ExprSingle		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_5, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[308]);
	}
	
	a6 = 'else' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[311]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[312]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[313]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[315]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[316]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[317]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[318]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[319]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[320]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[321]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[322]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[323]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[324]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[325]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[326]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[327]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[328]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[329]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[330]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[331]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[332]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[333]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[335]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[338]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[339]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[340]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[344]);
	}
	
	(
		a7_0 = parse_org_emftext_language_xpath2_ExprSingle		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_7, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[347]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[351]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[352]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[353]);
	}
	
;

parse_org_emftext_language_xpath2_OrExpr returns [org.emftext.language.xpath2.OrExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_OrExprChild		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[354]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[355]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[356]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[359]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[360]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[363]);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createOrExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[364]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[365]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[366]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[367]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[368]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[369]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[370]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[371]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[372]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[373]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[374]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[375]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[376]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[377]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[378]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[379]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[380]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[381]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[382]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[383]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[384]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[385]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[386]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[387]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[388]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[389]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[390]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[391]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[392]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[393]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[394]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[395]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[396]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_OrExprChild				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[397]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[398]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[399]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[400]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[401]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[402]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[403]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[404]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[405]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[406]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[407]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[416]);
	}
	
;

parse_org_emftext_language_xpath2_AndExpr returns [org.emftext.language.xpath2.AndExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AndExprChild		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[417]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[419]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[421]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[427]);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAndExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[428]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[429]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[430]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[431]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[432]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[433]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[434]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[435]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[436]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[437]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[438]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[439]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[440]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[441]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[442]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[443]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[444]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[445]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[446]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[447]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[448]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[449]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[450]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[451]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[452]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[453]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[454]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[455]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[456]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[457]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[458]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[459]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[460]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_AndExprChild				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[461]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[462]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[463]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[464]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[465]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[466]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[467]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[468]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[469]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[470]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[471]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[474]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[477]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[478]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[479]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[482]);
	}
	
;

parse_org_emftext_language_xpath2_ComparisonExpr returns [org.emftext.language.xpath2.ComparisonExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ComparisonExprChild		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[483]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[484]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[485]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[486]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[487]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[493]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[496]);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
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
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_ComparisonExprChild				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[530]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[531]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[532]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[533]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[534]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[535]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[536]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[537]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[538]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[539]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[540]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[544]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[545]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[546]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[547]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[548]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[549]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[550]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[551]);
	}
	
;

parse_org_emftext_language_xpath2_RangeExpr returns [org.emftext.language.xpath2.RangeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_RangeExprChild		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[552]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[553]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[554]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[555]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[556]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[557]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[558]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[559]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[560]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[561]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[562]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[563]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[564]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[565]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[566]);
	}
	
	(
		(
			a1 = 'to' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRangeExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[567]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[568]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[569]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[570]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[571]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[572]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[573]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[574]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[575]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[576]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[577]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[578]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[579]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[580]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[581]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[582]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[583]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[584]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[585]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[586]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[587]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[588]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[589]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[590]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[591]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[592]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[593]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[594]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[595]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[596]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[597]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[598]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[599]);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_RangeExprChild				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[600]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[601]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[602]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[603]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[604]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[605]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[606]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[607]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[608]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[609]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[610]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[611]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[612]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[613]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[614]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[615]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[616]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[617]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[618]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[619]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[620]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[621]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[622]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[623]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[624]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[625]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[626]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[627]);
	}
	
;

parse_org_emftext_language_xpath2_AdditiveExpr returns [org.emftext.language.xpath2.AdditiveExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AdditiveExprChild		{
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[628]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[629]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[630]);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_1_0_0_0, null, true);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_1_0_0_0, null, true);
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
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[644]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[645]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[646]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[647]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[648]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[649]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[650]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[651]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[652]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[653]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[654]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[655]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[656]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[657]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[658]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[659]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[660]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[661]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[662]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[663]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[664]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[665]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[666]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[667]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[668]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[669]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[670]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[671]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[672]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[673]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[674]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[675]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[676]);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_AdditiveExprChild				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[677]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[678]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[679]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[680]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[681]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[682]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[683]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[684]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[685]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[686]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[687]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[688]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[689]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[690]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[691]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[692]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[693]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[694]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[695]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[696]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[697]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[698]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[699]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[700]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[701]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[702]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[703]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[704]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[705]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[706]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[707]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[708]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[709]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[710]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[711]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[712]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[713]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[714]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[715]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[716]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[717]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[726]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[730]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[731]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[732]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[733]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[734]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[735]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[736]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[737]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[738]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[739]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[740]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[741]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, null, true);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[742]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[743]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[744]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[745]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[746]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[747]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[748]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[749]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[750]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[751]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[752]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[753]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[754]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[755]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[756]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[757]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[758]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[759]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[760]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[761]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[762]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[763]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[764]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[765]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[766]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[767]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[768]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[769]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[770]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[771]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[772]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[773]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[774]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_0, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_0, null, true);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[775]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[776]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[777]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[778]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[779]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[780]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[781]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[782]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[783]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[784]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[785]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[786]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[787]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[788]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[789]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[790]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[791]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[792]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[793]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[794]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[795]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[796]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[797]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[798]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[799]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[800]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[801]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[802]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[803]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[804]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[805]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[806]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[807]);
	}
	
;

parse_org_emftext_language_xpath2_SinglePathExpr returns [org.emftext.language.xpath2.SinglePathExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSinglePathExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[808]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[809]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[810]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[811]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[812]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[813]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[814]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[815]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[816]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[817]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[818]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[819]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[820]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[821]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[822]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[823]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[824]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[825]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[826]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[827]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[828]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[829]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[830]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[831]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[832]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[833]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[834]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[835]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[836]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[837]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSinglePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[838]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[839]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[840]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[841]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[842]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[843]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[844]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[845]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[846]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[847]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[848]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[849]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[850]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[851]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[852]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[853]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[854]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_RelativePathExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSinglePathExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[855]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[856]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[857]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[858]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[859]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[860]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[861]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[862]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[863]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[864]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[865]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[866]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[867]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[868]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[869]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[870]);
	}
	
;

parse_org_emftext_language_xpath2_DoublePathExpr returns [org.emftext.language.xpath2.DoublePathExpr element = null]
@init{
}
:
	a0 = '//' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDoublePathExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[871]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[872]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[873]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[874]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[875]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[876]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[877]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[878]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[879]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[880]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[881]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[882]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[883]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[884]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[885]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[886]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[887]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[888]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[889]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[890]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[891]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[892]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[893]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[894]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[895]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[896]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[897]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[898]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[899]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[900]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoublePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[901]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_RelativePathExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDoublePathExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOUBLE_PATH_EXPR__RELATIVE_PATH_EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[902]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[903]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[904]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[905]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[906]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[907]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[908]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[909]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[910]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[911]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[912]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[913]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[914]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[915]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[916]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[917]);
	}
	
;

parse_org_emftext_language_xpath2_RelativePathExpr returns [org.emftext.language.xpath2.RelativePathExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_StepExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRelativePathExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.RELATIVE_PATH_EXPR__HEAD), value);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[918]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[919]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[920]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[921]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[922]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[923]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[924]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[925]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[926]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[927]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[931]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[932]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[933]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[934]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[935]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_TailPathExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createRelativePathExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.RELATIVE_PATH_EXPR__TAIL, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[936]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[937]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[938]);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[949]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[950]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[951]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[952]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[953]);
	}
	
;

parse_org_emftext_language_xpath2_SingleTailPathExpr returns [org.emftext.language.xpath2.SingleTailPathExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSingleTailPathExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[954]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[955]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[956]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[957]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[958]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[959]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[960]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[961]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[962]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[963]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[964]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[965]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[966]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[967]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[968]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[969]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[970]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[971]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[972]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[973]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[974]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[975]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[976]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[977]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[978]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[979]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[980]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[981]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[982]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[983]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[984]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSingleTailPathExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TAIL_PATH_EXPR__STEP_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[985]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[986]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[987]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[988]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[989]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[990]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[991]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[992]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[993]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[994]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[995]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[996]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[997]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[998]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[999]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1000]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1001]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1002]);
	}
	
;

parse_org_emftext_language_xpath2_DoubleTailPathExpr returns [org.emftext.language.xpath2.DoubleTailPathExpr element = null]
@init{
}
:
	a0 = '//' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDoubleTailPathExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1008]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1009]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1010]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1017]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1018]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1019]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1025]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1026]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1027]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1028]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1029]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1030]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1031]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1032]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleTailPathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1033]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDoubleTailPathExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.DOUBLE_TAIL_PATH_EXPR__STEP_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1034]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1035]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1036]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1037]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1038]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1039]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1040]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1041]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1042]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1043]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1044]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1045]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1046]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1047]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1048]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1049]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1050]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1051]);
	}
	
;

parse_org_emftext_language_xpath2_AxisStep returns [org.emftext.language.xpath2.AxisStep element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_DirectionalStep		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAxisStep();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.AXIS_STEP__STEP), value);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1052]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1053]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1054]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1055]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1056]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1057]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1058]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1059]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1060]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1061]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1062]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1063]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1064]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1065]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1066]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1067]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1068]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1069]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1070]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAxisStep();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.Xpath2Package.AXIS_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1071]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1072]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1073]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1074]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1075]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1076]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1077]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1078]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1079]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1080]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1081]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1082]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1083]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1084]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1085]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1086]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1087]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1088]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1089]);
	}
	
;

parse_org_emftext_language_xpath2_GeneralForwardStep returns [org.emftext.language.xpath2.GeneralForwardStep element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ForwardAxis		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__AXIS), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1090]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1091]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1092]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1093]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1094]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1095]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1096]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1097]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1098]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1099]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1100]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1101]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1102]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1103]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1104]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1105]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1106]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1107]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1108]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1109]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralForwardStep();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1110]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1111]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1112]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1113]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1114]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1115]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1116]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1117]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1118]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1119]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1120]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1121]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1122]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1123]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1124]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1125]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1126]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1127]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1128]);
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
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__AT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_0, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__AT), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1129]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1130]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1131]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1132]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1133]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1134]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1135]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1136]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1137]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1138]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1139]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1140]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1141]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1142]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1143]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1144]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1145]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1146]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1147]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1148]);
	}
	
	(
		a3_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevForwardStep();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__AT), value);
				}
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_1, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1149]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1150]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1151]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1152]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1153]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1154]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1155]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1156]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1157]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1158]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1159]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1160]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1161]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1162]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1163]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1164]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1165]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1166]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1167]);
	}
	
;

parse_org_emftext_language_xpath2_ForwardAxis returns [org.emftext.language.xpath2.ForwardAxis element = null]
@init{
}
:
	(
		(
			a0 = 'child' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.CHILD_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a1 = 'descendant' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a2 = 'attribute' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.ATTRIBUTE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a3 = 'self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a4 = 'descendant-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a5 = 'following-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a6 = 'following' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a7 = 'namespace' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.NAMESPACE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.FORWARD_AXIS__KIND), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1168]);
	}
	
	a10 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createForwardAxis();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1169]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1170]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1171]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1172]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1173]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1174]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1175]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1176]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1177]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1178]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1179]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1180]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1181]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1182]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1183]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1184]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1185]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1186]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1187]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1188]);
	}
	
;

parse_org_emftext_language_xpath2_GeneralReverseStep returns [org.emftext.language.xpath2.GeneralReverseStep element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ReverseAxis		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__AXIS), value);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1189]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1190]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1191]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1192]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1193]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1194]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1195]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1196]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1197]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1198]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1199]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1200]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1201]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1202]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1203]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1204]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1205]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1206]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1207]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1208]);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createGeneralReverseStep();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.GENERAL_REVERSE_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1209]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1210]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1211]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1212]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1213]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1214]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1215]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1216]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1217]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1218]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1219]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1220]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1221]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1222]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1223]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1224]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1225]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1226]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1227]);
	}
	
;

parse_org_emftext_language_xpath2_AbbrevReverseStep returns [org.emftext.language.xpath2.AbbrevReverseStep element = null]
@init{
}
:
	a0 = '..' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAbbrevReverseStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1228]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1229]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1230]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1231]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1232]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1233]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1234]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1235]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1236]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1237]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1238]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1239]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1240]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1241]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1242]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1243]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1244]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1245]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1246]);
	}
	
;

parse_org_emftext_language_xpath2_ReverseAxis returns [org.emftext.language.xpath2.ReverseAxis element = null]
@init{
}
:
	(
		(
			a0 = 'parent' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PARENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.REVERSE_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a1 = 'ancestor' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.REVERSE_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a2 = 'preceding-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.REVERSE_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a3 = 'preceding' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.REVERSE_AXIS__KIND), value);
				completedElement(value, false);
			}
			|			a4 = 'ancestor-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.REVERSE_AXIS__KIND), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1247]);
	}
	
	a7 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createReverseAxis();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1248]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1249]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1250]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1251]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1252]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1253]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1254]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1255]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1256]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1257]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1258]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1259]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1260]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1261]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1262]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1263]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1264]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1265]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1266]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1267]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_26_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1268]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1269]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1270]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1271]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1272]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1273]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1274]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1275]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1276]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1277]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1278]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1279]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1280]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1281]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1282]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1283]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1284]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1285]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1286]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_27_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1287]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1288]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1289]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1290]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1291]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1292]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1293]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1294]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1295]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1296]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1297]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1298]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1299]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1300]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1301]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1302]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1303]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1304]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1305]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1306]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1307]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1308]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1309]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1310]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1311]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1312]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1313]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1314]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1315]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1316]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1317]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1318]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1319]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1320]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1321]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1322]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1323]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1324]);
	}
	
;

parse_org_emftext_language_xpath2_LocalNameWildcard returns [org.emftext.language.xpath2.LocalNameWildcard element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1325]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1326]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1327]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1328]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1329]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1330]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1331]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1332]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1333]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1334]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1335]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1336]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1337]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1338]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1339]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1340]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1341]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1342]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1343]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1344]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1345]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1346]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNamespaceWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1347]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNamespaceWildcard();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1348]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1349]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1350]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1351]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1352]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1353]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1354]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1355]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1356]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1357]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1358]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1359]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1360]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1361]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1362]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1363]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1364]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1365]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1366]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1367]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1368]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1369]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1370]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1371]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1372]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1373]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1374]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1375]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1376]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1377]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1378]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1379]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1380]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1381]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1382]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1383]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1384]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1385]);
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
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1386]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1387]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1388]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1389]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1390]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1391]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1392]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1393]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1394]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1395]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1396]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1397]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1398]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1399]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1400]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1401]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1402]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1403]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1404]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_32_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1405]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1406]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1407]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1408]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1409]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1410]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1411]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1412]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1413]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1414]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1415]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1416]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1417]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1418]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1419]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1420]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1421]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1422]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1423]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1424]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1425]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1426]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1427]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1428]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1429]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1430]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1431]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1432]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1433]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1434]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1435]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1436]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1437]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1438]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1439]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1440]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_32_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1441]);
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPredicate();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_32_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1442]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1443]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1444]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1445]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1446]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1447]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1448]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1449]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1450]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1451]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1452]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1453]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1454]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1455]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1456]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1457]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1458]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1459]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1460]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_33_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarRef(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1461]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarRef(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1462]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_33_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1463]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1464]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1465]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1466]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1467]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1468]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1469]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1470]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1471]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1472]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1473]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1474]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1475]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1476]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1477]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1478]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1479]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1480]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1481]);
	}
	
;

parse_org_emftext_language_xpath2_VarName returns [org.emftext.language.xpath2.VarName element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createVarName();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.VAR_NAME__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_34_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1482]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1483]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1484]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1485]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1486]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1487]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1488]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1489]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1490]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1491]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1492]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1493]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1494]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1495]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1496]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1497]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1498]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1499]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1500]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1501]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1502]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1503]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1504]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1505]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1506]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1507]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1508]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1509]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1510]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1511]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1512]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1513]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1514]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1515]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1516]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1517]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1518]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1519]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1520]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1521]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1522]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1523]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1524]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1525]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1526]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1527]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1528]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1529]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1530]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1531]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1532]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1533]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1534]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1535]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1536]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1537]);
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
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1538]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createParenthesizedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1539]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1540]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1541]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1542]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1543]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1544]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1545]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1546]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1547]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1548]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1549]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1550]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1551]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1552]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1553]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1554]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1555]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1556]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1557]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1558]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1559]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1560]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1561]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1562]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1563]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1564]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1565]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1566]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1567]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1568]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1569]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1570]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1571]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1572]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1573]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1574]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1575]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1576]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1577]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1578]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1579]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1580]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1581]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1582]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1583]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1584]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1585]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1586]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1587]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1588]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1589]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1590]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1591]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1592]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1593]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1594]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1595]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1596]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1597]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1598]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1599]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1600]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1601]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1602]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1603]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1604]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1605]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1606]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1607]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1608]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1609]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1610]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1611]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1612]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1613]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1614]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_xpath2_ExprSingle				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1615]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1616]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1617]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1618]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1619]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1620]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1621]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1622]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1623]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1624]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1625]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1626]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1627]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1628]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1629]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1630]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1631]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1632]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1633]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1634]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1635]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1636]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1637]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1638]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1639]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1640]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1641]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1642]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1643]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1644]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1645]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1646]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1647]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1648]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1649]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1650]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1651]);
						addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1652]);
					}
					
					(
						a4_0 = parse_org_emftext_language_xpath2_ExprSingle						{
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
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_2_0_0_1_0_0_1, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1653]);
						addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1654]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1655]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1656]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1657]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1658]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1659]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1660]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1661]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1662]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1663]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1664]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1665]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1666]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1667]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1668]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1669]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1670]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1671]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1672]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1673]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1674]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1675]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1676]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1677]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.SINGLE_TYPE__OPTIONAL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1678]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1679]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1680]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_1, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_1, null, true);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_41_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1681]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1682]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1683]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1684]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1685]);
	}
	
;

parse_org_emftext_language_xpath2_AtomicType returns [org.emftext.language.xpath2.AtomicType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAtomicType();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.ATOMIC_TYPE__NAME), value);
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
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1686]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1687]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1688]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1689]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1690]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1691]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1692]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1693]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1694]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1695]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1696]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1697]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1698]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1699]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1700]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1701]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1702]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1703]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1704]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1705]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1706]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1707]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1708]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1709]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1710]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1711]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1712]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1713]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1714]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1715]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_xpath2_ElementTest				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_org_emftext_language_xpath2_SchemaElementTest				{
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_2_0_0_0, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1716]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1717]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1718]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1719]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1720]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1721]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1722]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1723]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1724]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1725]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1726]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1727]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1728]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1729]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1730]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1731]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1732]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1733]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1734]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1735]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1736]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1737]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1738]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1739]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1740]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1741]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1742]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1743]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1744]);
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
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1759]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1760]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1761]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1762]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1763]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1764]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1765]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1766]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1767]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1768]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1769]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1770]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1771]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1772]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1773]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1774]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1775]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1776]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1777]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1778]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1779]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1780]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1781]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1782]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1783]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1784]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1785]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1786]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1787]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1788]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1789]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1790]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1791]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1792]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1793]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1794]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1795]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1796]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1797]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1798]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1799]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1800]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1801]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1802]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1803]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1804]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1805]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1806]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1807]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1808]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1809]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1810]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1811]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1812]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1813]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1814]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1815]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1816]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1817]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1818]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1819]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1820]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1821]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1822]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1823]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1824]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1825]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1826]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1827]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1828]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1829]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1830]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1831]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1832]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1833]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1834]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1835]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1836]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1837]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1838]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1839]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1840]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1841]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1842]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1843]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1844]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1845]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1846]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1847]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1848]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1849]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1850]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1851]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1852]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1853]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1854]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1855]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1856]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1857]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1858]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1859]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1860]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1861]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1862]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1863]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1864]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1865]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1866]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1867]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1868]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1869]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1870]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1871]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1872]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1873]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1874]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1875]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1876]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1877]);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_3_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1878]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1879]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1880]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1881]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1882]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1883]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1884]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1885]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1886]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1887]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1888]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1889]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1890]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1891]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1892]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1893]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1894]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1895]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1896]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1897]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1898]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1899]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1900]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1901]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1902]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1903]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1904]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1905]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1906]);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_3_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1907]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1908]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1909]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1910]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1911]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1912]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1913]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1914]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1915]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1916]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1917]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1918]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1919]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1920]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1921]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1922]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1923]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1924]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1925]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1926]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1927]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1928]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1929]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1930]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1931]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1932]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1933]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1934]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1935]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1936]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1937]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1938]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1939]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1940]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1941]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1942]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1943]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1944]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1945]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1946]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1947]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1948]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1949]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1950]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1951]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1952]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1953]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1954]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1955]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1956]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1957]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1958]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1959]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1960]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1961]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1962]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1963]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1964]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1965]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1966]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1967]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1968]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1969]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1970]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1971]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1972]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1973]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1974]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1975]);
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
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1976]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1977]);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1978]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1979]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1980]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1981]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_QName				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
						}
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1982]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1983]);
			}
			
			(
				(
					a5 = '?' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_2, true, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
						// set value of boolean attribute
						Object value = true;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1984]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1985]);
	}
	
	a8 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.WILDCARD_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1986]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1987]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1988]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1989]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1990]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1991]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1992]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1993]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1994]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1995]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1996]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1997]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1998]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[1999]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2000]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2001]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2002]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2003]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2004]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2005]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2006]);
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
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2007]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2008]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2009]);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_QName		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
				}
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__NAME), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2010]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2011]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2012]);
				addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2013]);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_QName				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
						}
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2014]);
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2015]);
			}
			
			(
				(
					a5 = '?' {
						if (element == null) {
							element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_2, true, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
						// set value of boolean attribute
						Object value = true;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2016]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2017]);
	}
	
	a8 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.NAME_ELEMENT_TEST__TYPE_IS_OPTIONAL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2018]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2019]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2020]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2021]);
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
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2032]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2033]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2034]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2035]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2036]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2037]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2038]);
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
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2039]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2040]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2041]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2042]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2043]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2044]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2045]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2046]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2047]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2048]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2049]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2050]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2051]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2052]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2053]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2054]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2055]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2056]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2057]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2058]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2059]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2060]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2061]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2062]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2063]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2064]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2065]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2066]);
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
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2077]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2078]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2079]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2080]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2081]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2082]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2083]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2084]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2085]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2086]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2087]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2088]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2089]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2090]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2091]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2092]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2093]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2094]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2095]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2096]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2097]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2098]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2099]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2100]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2101]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2102]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2103]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2104]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2105]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2106]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2107]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2108]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2109]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2110]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2111]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2112]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2113]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2114]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2115]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2116]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2117]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2118]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2119]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2120]);
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
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2121]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2122]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2123]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2124]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2125]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2126]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2127]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2128]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2129]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2130]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2131]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2132]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2133]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2134]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2135]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2136]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2137]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2138]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2139]);
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
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2140]);
			}
			
			a1 = ':' {
				if (element == null) {
					element = org.emftext.language.xpath2.Xpath2Factory.eINSTANCE.createQName();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2141]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2142]);
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
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__LOCAL_PART), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.Xpath2Package.QNAME__LOCAL_PART), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAxisStep(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2143]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2144]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRelativePathExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2145]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2146]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2147]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2148]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2149]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2150]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2151]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2152]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2153]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2154]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2155]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2156]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2157]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2158]);
		addExpectedElement(org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(), org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2159]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2160]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2161]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2162]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2163]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2164]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2165]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2166]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2167]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2168]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2169]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2170]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2171]);
		addExpectedElement(null, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[2172]);
	}
	
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
	|	c8 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c10; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_OrExprChild returns [org.emftext.language.xpath2.OrExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_AndExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ComparisonExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_RangeExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c6; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_AndExprChild returns [org.emftext.language.xpath2.AndExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_ComparisonExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_RangeExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ComparisonExprChild returns [org.emftext.language.xpath2.ComparisonExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_RangeExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_Comp returns [org.emftext.language.xpath2.Comp element = null]
:
	c0 = parse_org_emftext_language_xpath2_GeneralComp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ValueComp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_NodeComp{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_RangeExprChild returns [org.emftext.language.xpath2.RangeExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_AdditiveExprChild returns [org.emftext.language.xpath2.AdditiveExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_SinglePathExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_DoublePathExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_RelativePathExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_StepExpr returns [org.emftext.language.xpath2.StepExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_AxisStep{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_FilterExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_TailPathExpr returns [org.emftext.language.xpath2.TailPathExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_SingleTailPathExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_DoubleTailPathExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_DirectionalStep returns [org.emftext.language.xpath2.DirectionalStep element = null]
:
	c0 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c3; /* this is a subclass or primitive expression choice */ }
	
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

parse_org_emftext_language_xpath2_PrimaryExpr returns [org.emftext.language.xpath2.PrimaryExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_VarRef{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_FunctionCall{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_StringLiteral{ element = c7; /* this is a subclass or primitive expression choice */ }
	
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
STRING_LITERAL:
	(('\"')('\"\"'|~('\"'))*('\"')|('\'')('\'\''|~('\''))*('\''))
;
COMMENT_CONTENTS:
	('\u0009'|'\u000A'|'\u000D'|'\u0020'..'\uD7FF'|'\uE000'..'\uFFFD'+)
	{ _channel = 99; }
;
NCNAME:
	('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040')*)
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;

