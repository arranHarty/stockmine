package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMongoDBCloseMainJava
{
  protected static String nl;
  public static synchronized TMongoDBCloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBCloseMainJava result = new TMongoDBCloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_3 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_4 = "\");" + NL + "\tif(mongo_";
  protected final String TEXT_5 = " != null )" + NL + "\t{" + NL + "\t\tmongo_";
  protected final String TEXT_6 = ".close();" + NL + "\t}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

   	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
