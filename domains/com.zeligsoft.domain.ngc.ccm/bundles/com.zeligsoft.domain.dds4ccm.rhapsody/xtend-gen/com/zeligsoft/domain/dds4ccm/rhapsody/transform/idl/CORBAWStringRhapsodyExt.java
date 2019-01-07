package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAWString;
import java.util.Arrays;
import org.eclipse.uml2.uml.DataType;

@SuppressWarnings("all")
public class CORBAWStringRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBAWString _importCorbaWString(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAWSTRING, CORBAWString.class);
    final CORBAWString string = ((CORBAWString) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    DataType _asDataType = string.asDataType();
    this.typeCache.put(_fullPathName, _asDataType);
    return string;
  }
  
  protected CORBAWString _importCorbaWString(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAWString importCorbaWString(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaWString((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaWString(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
