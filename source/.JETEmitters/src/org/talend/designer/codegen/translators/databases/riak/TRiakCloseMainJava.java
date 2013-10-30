package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TRiakCloseMainJava
{
  protected static String nl;
  public static synchronized TRiakCloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakCloseMainJava result = new TRiakCloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.basho.riak.client.IRiakClient client_";
  protected final String TEXT_3 = " = (com.basho.riak.client.IRiakClient)globalMap.get(\"client_";
  protected final String TEXT_4 = "\");" + NL + "\tif(client_";
  protected final String TEXT_5 = " !=null){" + NL + "\t\t\tclient_";
  protected final String TEXT_6 = ".shutdown();" + NL + "\t}";

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
    return stringBuffer.toString();
  }
}
