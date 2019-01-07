
package com.zeligsoft.ce.deployment.rsm.profile.tooling.utils;

import com.ibm.xtools.modeler.ui.UMLModeler;

import com.ibm.xtools.uml.type.IStereotypedElementType;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.ZDLDeploymentPlugin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.graphics.ImageData;

import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * @generated
 */
public class ZDLDeploymentUtil {
    
    /**
     * @generated
     */
    public static final String ZDLDEPLOYMENT_TOOLING_ACTIVITY_ID = "com.zeligsoft.ce.deployment.rsm.profile.tooling.uireduction.activity"; // $NON-NLS-1$
    
    /**
     * @generated
     */
    public static final String ZDLDEPLOYMENT_CORE_ACTIVITY_ID = "com.zeligsoft.ce.deployment.rsm.profile.tooling.core.activity"; // $NON-NLS-1$
    
    /**
     * @generated
     */
    public static final String PROFILE_NAME = "ZDLDeployment"; // $NON-NLS-1$
    
    /**
     * @generated
     */
    public static final URI PROFILE_URI = URI.createURI("pathmap://ZDLDEPLOYMENT/ZDLDeployment.epx"); //$NON-NLS-1$
    
    /**
     * @generated
     */
    private static Profile profile = null;
    
    /**
     * @generated
     */
    public static Profile getProfile() {
        if (profile == null) {
            try {
                Resource resource = 
                    UMLModeler.getEditingDomain().getResourceSet().getResource(PROFILE_URI, true);
                profile = (Profile)resource.getContents().get(0);
            } catch (Exception e) {
                // ignore
            }
        }
        return profile;
    }
	
    /**
     * @generated
     */
    public static ImageDescriptor getImageDescriptor(String imageFilePath) {
        if (imageFilePath == null || imageFilePath.length() == 0) {
            return null;
        }
        URL result = ZDLDeploymentPlugin.getDefault().getBundle().getEntry(imageFilePath);
        return result == null ? ImageDescriptor.getMissingImageDescriptor() : ImageDescriptor.createFromURL(result);
    }

    /**
     * @generated
     */
    private final static String PROP_VAL_EXTENDEDIMAGE_USAGEHINT_ICON = "Icon"; //$NON-NLS-1$;
    
    /**
     * @generated
     */
    private final static String STEREOTYPE_EXTENDEDIMAGE = "ProfileBase::ExtendedImage"; //$NON-NLS-1$
    
    /**
     * @generated
     */
    private final static String PROP_EXTENDEDIMAGE_USAGEHINT = "usageHint"; //$NON-NLS-1$
    
    /**
     * @generated
     */
    private final static String PROP_EXTENDEDIMAGE_DATA = "data"; //$NON-NLS-1$
    
    /**
     * @generated
     */
    private static final String EXPLORER_IMAGE_ANNOTATION = "uml2.explorerImage"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static ImageDescriptor getSmallImage(IElementType elementType, ResourceSet resourceSet) {
        return getImage(elementType, resourceSet, 16, 16);
    }
    
    /**
     * @generated
     */
    public static ImageDescriptor getLargeImage(IElementType elementType, ResourceSet resourceSet) {
        return getImage(elementType, resourceSet, 32, 32);
    }    
    
    /**
     * @generated
     */
    private static InputStream getStereotypeImageStream(String stereotypeName, ResourceSet resourceSet) {
        Collection found = UMLUtil.findNamedElements(resourceSet, stereotypeName);
        
        if (!found.isEmpty()) {
            Object obj = found.iterator().next();
            if (obj instanceof Stereotype) {
                byte[] imageData = getImageData((Stereotype)obj);
                if (imageData != null) {
                    return new ByteArrayInputStream(imageData);
                }
            }
        }
        
        return null;
    }
    
    /**
     * @generated
     */
    private static ImageDescriptor getImage(IElementType elementType, ResourceSet resourceSet, final int width, final int height) {
        if (!(elementType instanceof IStereotypedElementType)) {
            return new ElementTypeImageDescriptor(elementType);
        }
        String stereotypeName = ((IStereotypedElementType)elementType).getStereotypeName();
        final InputStream imageStream = getStereotypeImageStream(stereotypeName, resourceSet);
        if (imageStream == null) {
            //return default
            return new ElementTypeImageDescriptor(elementType);
        }

        //return the image descriptor from the stereotype's stream
        return new ImageDescriptor() {
            public ImageData getImageData() {
            	try {
            		imageStream.reset();
            	} catch(IOException e) {
            		ZDLDeploymentPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, ZDLDeploymentPlugin.ID, -1, "getImage Failed", e)); //$NON-NLS-1$
            	}
                ImageData data = new ImageData(imageStream);

                int transparentPixel = data.transparentPixel;
                ImageData newData = data.scaledTo(width, height);
                newData.transparentPixel = transparentPixel;
                
                return newData;
            }
        };    
    }
    
    /**
     * @generated
     */
    private static byte[] getImageData(Stereotype stereotype) {

        byte[] imageData = null;
        Image image = getImage(stereotype);

        if (image != null) {
            Stereotype extImg = image
                .getAppliedStereotype(STEREOTYPE_EXTENDEDIMAGE);
            if (extImg != null) {
                imageData = (byte[]) image
                    .getValue(extImg, PROP_EXTENDEDIMAGE_DATA);
            }

        } else {
            String annotationSource = EXPLORER_IMAGE_ANNOTATION;
            if (annotationSource != null) {
                EAnnotation annotation = stereotype
                    .getEAnnotation(annotationSource);
                if (annotation != null) {
                    org.eclipse.gmf.runtime.notation.Image notationImage = (org.eclipse.gmf.runtime.notation.Image) annotation
                        .getContents().get(0);
                    imageData = notationImage.getData();
                }
            }
        }

        return imageData;
    }
    
    /**
     * @generated
     */
    private static Image getImage(Stereotype stereotype) {
        Iterator it = stereotype.getIcons().iterator();
        while (it.hasNext()) {
            Image image = (Image) it.next();
            Stereotype extendedImage = image
                .getAppliedStereotype(STEREOTYPE_EXTENDEDIMAGE);
            if (extendedImage != null) {
                EnumerationLiteral value = (EnumerationLiteral) image
                    .getValue(extendedImage, PROP_EXTENDEDIMAGE_USAGEHINT);
                if (PROP_VAL_EXTENDEDIMAGE_USAGEHINT_ICON.equals(value.getName())) {
                    return image;
                }
            }
        }

        return null;
    }
}