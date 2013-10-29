package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TS3BucketListEndJava
{
  protected static String nl;
  public static synchronized TS3BucketListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3BucketListEndJava result = new TS3BucketListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t}";
  protected final String TEXT_3 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_4 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_6 = NL + "globalMap.put(\"";
  protected final String TEXT_7 = "_NB_BUCKET\", nb_bucket_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    
	if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
