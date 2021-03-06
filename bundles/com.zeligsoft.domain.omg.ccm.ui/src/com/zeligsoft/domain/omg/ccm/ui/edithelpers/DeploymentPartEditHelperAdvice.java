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
package com.zeligsoft.domain.omg.ccm.ui.edithelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * DeploymentPart edit helper advice.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class DeploymentPartEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyElementCommand(final DestroyElementRequest request) {

		final EObject container = request.getContainer();
		if (!ZDLUtil.isZDLConcept(container, ZMLMMNames.DEPLOYMENT_PART)) {
			return null;
		}

		if (!(request.getElementToDestroy() instanceof InstanceValue)) {
			return null;
		}
		final InstanceValue instanceValue = (InstanceValue) request.getElementToDestroy();

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getElementToDestroy()),
				"Delete Deployment Instance Value", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				InstanceSpecification partInstance = instanceValue.getInstance();
				if (partInstance != null) {
					Package instanceContainer = (Package) partInstance.eContainer();
					UMLElementFactory.destroyElement(instanceContainer, null);
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
