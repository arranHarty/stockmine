package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMongoDBOutputEndJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputEndJava result = new TMongoDBOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}finally{" + NL + "\t\t\tif(mongo_";
  protected final String TEXT_2 = " != null )" + NL + "\t\t\t{" + NL + "\t\t\t\tmongo_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_4 = NL + "globalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE\", nb_line_";
  protected final String TEXT_6 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
