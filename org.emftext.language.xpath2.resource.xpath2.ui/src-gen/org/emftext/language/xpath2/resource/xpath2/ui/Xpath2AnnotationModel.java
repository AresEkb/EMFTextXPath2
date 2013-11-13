/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2AnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public Xpath2AnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2MarkerAnnotation(marker);
	}
	
}
