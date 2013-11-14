package org.emftext.language.xpath2.resource.xpath2.post;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.xpath2.ChildStepExpr;
import org.emftext.language.xpath2.DescOrSelfStepExpr;
import org.emftext.language.xpath2.Expr;
import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.ParenthesizedExpr;
import org.emftext.language.xpath2.RootStepExpr;
import org.emftext.language.xpath2.resource.xpath2.IXpath2OptionProvider;
import org.emftext.language.xpath2.resource.xpath2.IXpath2Options;
import org.emftext.language.xpath2.resource.xpath2.IXpath2ResourcePostProcessor;
import org.emftext.language.xpath2.resource.xpath2.IXpath2ResourcePostProcessorProvider;
import org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource;

/*
	<extension point="org.emftext.language.xpath2.resource.xpath2.default_load_options">
		<provider
			class="org.emftext.language.xpath2.resource.xpath2.post.PostProcessor"
			id="org.emftext.language.xpath2.resource.xpath2.post.PostProcessor"> 
  		</provider>
  	</extension>
 */

public class PostProcessor implements IXpath2OptionProvider,
		IXpath2ResourcePostProcessorProvider, IXpath2ResourcePostProcessor {

	@Override
	public void process(Xpath2Resource resource) {
		simplifyExpressions(resource);
	}

	@Override
	public void terminate() {
	}

	@Override
	public IXpath2ResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IXpath2Options.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public static void simplifyExpressions(Resource resource) {
		simplifyDown(resource.getContents());
	}

	private static void simplifyDown(EList<EObject> parentList) {
		for (EObject child : new BasicEList<EObject>(parentList)) {
			EObject singleContained = getSingleContained(child);
			EObject next = singleContained;
			while (next != null) {
				next = getSingleContained(singleContained);
				if (next != null) {
					singleContained = next;
				}
			}
			if (singleContained != null) {
				EcoreUtil.replace(child, singleContained);
				child = singleContained;
			}
			simplifyDown(child.eContents());
		}
	}

	private static EObject getSingleContained(EObject parent) {
		if (!(parent instanceof Expr || parent instanceof ExprSingle)) {
			return null;
		}
		// TODO: THe logic could be more intellectual
		if (parent instanceof ParenthesizedExpr) {
			return null;
		}
		if (parent instanceof RootStepExpr) {
			return null;
		}
		if (parent instanceof ChildStepExpr) {
			return null;
		}
		if (parent instanceof DescOrSelfStepExpr) {
			return null;
		}

		EObject singleContained = null;
		for (EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(parent instanceof Expr || parent instanceof ExprSingle)) {
			return null;
		}

		return singleContained;
	}
}