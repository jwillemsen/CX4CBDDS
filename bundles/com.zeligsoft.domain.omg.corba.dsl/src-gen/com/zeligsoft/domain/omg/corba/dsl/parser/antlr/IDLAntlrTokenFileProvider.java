/*
* generated by Xtext
*/
package com.zeligsoft.domain.omg.corba.dsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class IDLAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.tokens");
	}
}
