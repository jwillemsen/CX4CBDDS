package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBASupports extends ZObject {
	org.eclipse.uml2.uml.Generalization asGeneralization();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBASupports
	 */
	static final TypeSelectPredicate<CORBASupports> type = new TypeSelectPredicate<CORBASupports>(
			"CORBADomain::IDL::CORBASupports", //$NON-NLS-1$
			CORBASupports.class);
}
