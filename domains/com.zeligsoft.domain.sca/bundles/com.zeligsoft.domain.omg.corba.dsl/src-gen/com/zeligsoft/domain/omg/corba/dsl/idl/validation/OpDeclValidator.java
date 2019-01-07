/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.validation;

import com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface OpDeclValidator {
	boolean validate();

	boolean validateComments(EList<IDLComment> value);
	boolean validateIsOneway(boolean value);
	boolean validateType(OpTypeDecl value);
	boolean validateName(String value);
	boolean validateParams(ParameterDecls value);
	boolean validateRaises(ExceptionList value);
	boolean validateContext(ContextExpr value);
}
