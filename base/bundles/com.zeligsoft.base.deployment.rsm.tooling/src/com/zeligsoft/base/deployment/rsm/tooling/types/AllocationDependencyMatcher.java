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
package com.zeligsoft.base.deployment.rsm.tooling.types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

import org.eclipse.uml2.uml.Element;

/**
 * @generated
 */
public class AllocationDependencyMatcher
        implements IElementMatcher {
    
    /**
     * @generated
     */
    public boolean matches(EObject eObject) {
        return  ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY.getEClass() == eObject.eClass() &&
                ((Element)eObject).getAppliedStereotype(ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY.getStereotypeName()) != null;
    }
}