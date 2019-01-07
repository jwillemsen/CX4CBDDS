/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.validation;

import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec;

/**
 * A sample validator interface for {@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ParamDclValidator {
	boolean validate();

	boolean validateDirection(ParamDirection value);
	boolean validateType(ParamTypeSpec value);
	boolean validateName(String value);
}
