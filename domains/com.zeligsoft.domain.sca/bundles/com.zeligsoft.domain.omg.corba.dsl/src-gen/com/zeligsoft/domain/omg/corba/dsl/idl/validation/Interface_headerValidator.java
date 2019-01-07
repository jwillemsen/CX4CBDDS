/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.validation;

import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface Interface_headerValidator {
	boolean validate();

	boolean validateIsAbstract(boolean value);
	boolean validateIsLocal(boolean value);
	boolean validateName(String value);
	boolean validateSpecializes(EList<ScopedName> value);
	boolean validateComments(EList<IDLComment> value);
}
