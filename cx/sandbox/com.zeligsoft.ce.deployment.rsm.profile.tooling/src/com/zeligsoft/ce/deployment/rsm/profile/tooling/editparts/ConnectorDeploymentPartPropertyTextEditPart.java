
package com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.l10n.ZDLDeploymentMessages;

import org.eclipse.draw2d.IFigure;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public class ConnectorDeploymentPartPropertyTextEditPart
        extends TextCompartmentEditPart {

    /**
     * @generated
     */
    public ConnectorDeploymentPartPropertyTextEditPart(View view) {
        super(view);
    }
    
    /**
     * @generated
     */
    protected String getLabelText() {
        assert getModel() instanceof View;
        EObject eObj = (((View) getModel()).getElement());
        if (eObj instanceof NamedElement) {
            return ((NamedElement) eObj).getName();
        }
        return ZDLDeploymentMessages.UnnamedElement;
    }
    
    /**
     * @generated
     */
    public void setFigure(IFigure figure) {
        super.setFigure(figure);
    }
}