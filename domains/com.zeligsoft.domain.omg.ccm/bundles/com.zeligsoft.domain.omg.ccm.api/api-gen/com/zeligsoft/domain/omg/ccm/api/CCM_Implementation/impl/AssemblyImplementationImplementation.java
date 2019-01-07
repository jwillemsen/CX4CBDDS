package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.StructuralRealizationImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class AssemblyImplementationImplementation
    extends StructuralRealizationImplementation implements AssemblyImplementation{
    public AssemblyImplementationImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public String getQualifiedName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
            return (String) rawValue;
    }
    public String getName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "name");
            return (String) rawValue;
    }
    public void setName(String val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
    			}
    
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
