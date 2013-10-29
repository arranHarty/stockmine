package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;

public class TPaloInputMultiEndJava
{
  protected static String nl;
  public static synchronized TPaloInputMultiEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloInputMultiEndJava result = new TPaloInputMultiEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String strOutputConnectionName="";
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
 	if(conns!=null){
		if (conns.size()>0){
            IConnection conn =conns.get(0);
            if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	strOutputConnectionName=conn.getName();
		    }
		}
	}
	if(strOutputConnectionName != null && strOutputConnectionName.length()>0){

    stringBuffer.append(TEXT_1);
    
	}

    return stringBuffer.toString();
  }
}
