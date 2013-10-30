package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TCouchbaseOutputEndJava
{
  protected static String nl;
  public static synchronized TCouchbaseOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseOutputEndJava result = new TCouchbaseOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    client_";
  protected final String TEXT_3 = ".shutdown();";
  protected final String TEXT_4 = NL + "globalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE\",nb_line_";
  protected final String TEXT_6 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_8 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_9 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_10 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE_INSERTED_UPDATED\",nb_line_inserted_updated_";
  protected final String TEXT_12 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_14 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_15 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

if(!("true").equals(useExistingConn))
{
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
}
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String strJobCid="";
if(destination !=null && !("").equals(destination.trim()))
    strJobCid=destination;
else{
    strJobCid= cid;
}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
