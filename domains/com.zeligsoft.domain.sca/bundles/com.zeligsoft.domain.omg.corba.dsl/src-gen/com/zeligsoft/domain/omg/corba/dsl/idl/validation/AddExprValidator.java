/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.validation;

import com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr;

/**
 * A sample validator interface for {@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AddExprValidator {
	boolean validate();

	boolean validateLhs(MultExpr value);
	boolean validateOp(String value);
	boolean validateRhs(AddExpr value);
}
