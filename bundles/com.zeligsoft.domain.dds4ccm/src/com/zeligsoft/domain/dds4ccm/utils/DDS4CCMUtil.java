/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.utils;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DestroyEObjectCommand;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * A set of utilities that help when working with the DDS4CCM domain.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class DDS4CCMUtil {

	public static final DDS4CCMUtil INSTANCE;

	private static final String registerNaming = "edu.vanderbilt.dre.DAnCE.RegisterNaming"; //$NON-NLS-1$

	static {
		INSTANCE = new DDS4CCMUtil();
	}

	/**
	 * Create me
	 */
	protected DDS4CCMUtil() {
		// I have no state, so we will use a singleton
	}



	public static void addStereotypesToResource(EObject container,
			EObject containee) {
		if (container == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContainerParameter);
		}

		if (containee == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContaineeParameter);
		}

		if (container.eResource() == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContainerNotInResource);
		}

		// make sure that the stereotypes applied are contained in the same
		// resource
		Resource resource = container.eResource();
		if (containee instanceof Element && resource != null) {
			resource.getContents().addAll(
					((Element) containee).getStereotypeApplications());
		}
	}

	public static void configureDDSMessageField(
			org.eclipse.uml2.uml.Property prop) {
		prop.setVisibility(VisibilityKind.PUBLIC_LITERAL);
	}



	/**
	 * Returns true if a CORBAInterface types a port that is asynchronous.
	 * Certain IDL pragmas and D&C descriptors are generated when this is the
	 * case.
	 * 
	 * @param intf
	 * @return
	 */
	public static boolean isUsedAsynchronously(Interface intf) {

		if (ZDLUtil.isZDLConcept(intf, CORBADomainNames.CORBAINTERFACE) == false) {
			return false;
		}

		return (Boolean) ZDLUtil.getValue(intf,
				CORBADomainNames.CORBAINTERFACE,
				CORBADomainNames.CORBAINTERFACE__IS_ASYNCHRONOUS);
	}

	/**
	 * 
	 * 
	 * @param containerProcess
	 */
	public static boolean setupContainerProcessResources(
			Component containerProcess) {

		final String cpuAffinity = "edu.vanderbilt.dre.DAnCE.LocalityManager.CPUAffinity"; //$NON-NLS-1$
		final String processName = "edu.vanderbilt.dre.DAnCE.LocalityManager.ProcessName"; //$NON-NLS-1$
		final String processPriority = "edu.vanderbilt.dre.DAnCE.LocalityManager.ProcessPriority"; //$NON-NLS-1$
		final String localityArgs = "edu.vanderbilt.dre.DAnCE.LocalityArguments"; //$NON-NLS-1$

		EObject corbaStringType = CORBAUtil.getCORBAPrimitiveType(containerProcess, "CORBAString"); //$NON-NLS-1$
		boolean b_containerProcessModified = false;

		boolean b_hasAffinity = false;
		boolean b_hasProcessName = false;
		boolean b_hasProcessPriority = false;
		boolean b_hasLocalityArgs = false;

		if (ZDLUtil.isZDLConcept(containerProcess, CCMNames.CONTAINER_PROCESS)) {
			for (Property p : containerProcess.getOwnedAttributes()) {
				if (p.getName().matches(cpuAffinity)) {
					b_hasAffinity = true;
				} else if (p.getName().matches(processName)) {
					b_hasProcessName = true;
				} else if (p.getName().matches(processPriority)) {
					b_hasProcessPriority = true;
				} else if (p.getName().matches(localityArgs)) {
					b_hasLocalityArgs = true;
				}
			}

			if (!b_hasAffinity) {
				b_containerProcessModified = true;
				EObject property = ZDLUtil.createZDLConceptIn(containerProcess,
						CCMNames.PROPERTY);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.NAMED_ELEMENT__NAME, cpuAffinity);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.TYPED_ELEMENT__TYPE, corbaStringType);
			}
			if (b_hasProcessName) {
				DestroyEObjectCommand command = new DestroyEObjectCommand(
						TransactionUtil.getEditingDomain(containerProcess),
						Messages.DDS4CCMUtil_DeleteProcessNameCommandLabel,
						containerProcess.getOwnedMember(processName));
				try {
					command.execute(null, null);
				} catch (ExecutionException e) {
					Activator
							.getDefault()
							.error(Messages.DDS4CCMUtil_DeleteProcessNameFailedMessage,
									e);
				}
			}
			if (!b_hasProcessPriority) {
				b_containerProcessModified = true;
				EObject property = ZDLUtil.createZDLConceptIn(containerProcess,
						CCMNames.PROPERTY);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.NAMED_ELEMENT__NAME, processPriority);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.TYPED_ELEMENT__TYPE, corbaStringType);
			}
			if (!b_hasLocalityArgs) {
				b_containerProcessModified = true;
				EObject property = ZDLUtil.createZDLConceptIn(containerProcess,
						CCMNames.PROPERTY);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.NAMED_ELEMENT__NAME, localityArgs);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.TYPED_ELEMENT__TYPE, corbaStringType);
			}
		}

		return b_containerProcessModified;
	}
	
	public static boolean addRegisterNamingProperty(Class zdlClass) {
		
		boolean b_componentModified = false;
		
		EObject corbaStringType = CORBAUtil.getCORBAPrimitiveType(zdlClass, "CORBAString"); //$NON-NLS-1$
		
		if (ZDLUtil.isZDLConcept(zdlClass, CCMNames.CCMCOMPONENT)
			|| ZDLUtil.isZDLConcept(zdlClass, CCMNames.HOME)) {
			
			boolean b_hasRegisterNaming = false;
			
			for (Property p : zdlClass.getOwnedAttributes()) {
				if (p.getName().matches(registerNaming)) {
					b_hasRegisterNaming = true;
				}
			}
			
			if (!b_hasRegisterNaming) {
				b_componentModified = true;
				EObject property = ZDLUtil.createZDLConceptIn(zdlClass,
						CCMNames.PROPERTY);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.NAMED_ELEMENT__NAME, registerNaming);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.TYPED_ELEMENT__TYPE, corbaStringType);
			}
		}
		
		return b_componentModified;
	}

	@SuppressWarnings("nls")
	public static void convertCORBAStructToDDSMessage(Element struct) {
		// Because structs and fields don't have any useful information that
		// isn't already stored in UML, it's safe to unapply
		// and reapply the stereotypes. This logic is specific to the DDS4CCM
		// profile.
		Stereotype s = struct.getAppliedStereotype("cxDDS4CCM::CORBAStruct");
		struct.unapplyStereotype(s);
		ZDLUtil.addZDLConcept(struct, DDS4CCMNames.DDSMESSAGE);
		for (Element sub : struct.getOwnedElements()) {
			s = sub.getAppliedStereotype("cxDDS4CCM::CORBAField");
			if (s != null) {
				sub.unapplyStereotype(s);
				ZDLUtil.addZDLConcept(sub, DDS4CCMNames.MESSAGE_FIELD);
			}
			for (Comment comment : sub.getOwnedComments()) {
				if (comment.getBody().contains("@key")) {
					sub.getOwnedComments().remove(comment);
					ZDLUtil.setValue(sub, DDS4CCMNames.MESSAGE_FIELD,
							DDS4CCMNames.MESSAGE_FIELD__IS_KEY, true);
					break;
				}
			}
		}
	}
	
	/**
	 * Converts DDSMeesage to CORBAStruct
	 * @param ddsMessage
	 */
	@SuppressWarnings("nls")
	public static void convertDDSMessageToCORBAStruct(Element ddsMessage) {
		Stereotype stereotype = ddsMessage
				.getAppliedStereotype("cxDDS4CCM::DDSMessage"); 
		ddsMessage.unapplyStereotype(stereotype);
		ZDLUtil.addZDLConcept(ddsMessage, CORBADomainNames.CORBASTRUCT);

		for (Element element : ddsMessage.getOwnedElements()) {
			stereotype = element
					.getAppliedStereotype("cxDDS4CCM::MessageField"); 

			if (stereotype != null) {
				element.unapplyStereotype(stereotype);
				ZDLUtil.addZDLConcept(element, CORBADomainNames.CORBAFIELD);
			}	
		}
	}
	
	/**
	 * Reapplies stereotypes to fields of CORBAStruct and DDSMessage
	 * 
	 * @param element
	 * @return
	 */
	public static boolean reapplyFieldStereotypes(Element element) {
		Boolean stereotypeApplied = false;
		if (ZDLUtil.isZDLConcept(element, DDS4CCMNames.DDSMESSAGE)) {
			for (Element field : element.getOwnedElements()) {
				if(!ZDLUtil.isZDLConcept(field, CORBADomainNames.CORBAFIELD)){
					continue;
				}
				Stereotype stereotype = field
						.getAppliedStereotype("cxDDS4CCM::CORBAField"); //$NON-NLS-1$
				if (stereotype != null) {
					field.unapplyStereotype(stereotype);
					ZDLUtil.addZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD);
					stereotypeApplied = true;
				} else {
					if (!ZDLUtil.isZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD)) {
						ZDLUtil.addZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD);
						stereotypeApplied = true;
					}
				}
			}
		} else if (ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBASTRUCT)) {
			for (Element field : element.getOwnedElements()) {
				if(!ZDLUtil.isZDLConcept(field, CORBADomainNames.CORBAFIELD)){
					continue;
				}
				Stereotype stereotype = field
						.getAppliedStereotype("cxDDS4CCM::MessageField"); //$NON-NLS-1$
				if (stereotype != null) {
					field.unapplyStereotype(stereotype);
					ZDLUtil.addZDLConcept(field, CORBADomainNames.CORBAFIELD);
					stereotypeApplied = true;
				} else {
					if (!ZDLUtil.isZDLConcept(field, CORBADomainNames.CORBAFIELD)) {
						ZDLUtil.addZDLConcept(field,
								CORBADomainNames.CORBAFIELD);
						stereotypeApplied = true;
					}
				}
			}
		}
		return stereotypeApplied;
	}
	
	/**
	 * Remove register naming property from the given component
	 * 
	 * @param component
	 */
	public static void removeRegisterNamingProperty(Component component) {
		Property p = component.getOwnedAttribute(registerNaming, null);
		if (p == null) {
			return;
		}
		DestroyEObjectCommand cmd = new DestroyEObjectCommand(
				TransactionUtil.getEditingDomain(component),
				Messages.DDS4CCMUtil_RemoveRegisterNamingCommandLabel, p);
		try {
			OperationHistoryFactory.getOperationHistory().execute(cmd, null,
					null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(
					Messages.DDS4CCMUtil_RemoveRegisterNamingFailedMessage, e);
		}
	}

	public static Status createStatus(String pluginId, int severity, String msg) {
		Status status = new Status(severity, pluginId, IStatus.OK, msg, null);
		return status;
	}
}