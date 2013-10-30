package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCouchDBCloseMainJava
{
  protected static String nl;
  public static synchronized TCouchDBCloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBCloseMainJava result = new TCouchDBCloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.jcouchdb.db.Server server_";
  protected final String TEXT_3 = " = (org.jcouchdb.db.Server)globalMap.get(\"server_";
  protected final String TEXT_4 = "\");" + NL + "\tif(server_";
  protected final String TEXT_5 = " != null){" + NL + "\t\tjava.util.List<java.util.Map<String, Object>> replicates_";
  protected final String TEXT_6 = " = (java.util.List<java.util.Map<String, Object>>)globalMap.get(\"replicates_";
  protected final String TEXT_7 = "\");" + NL + "\t\torg.jcouchdb.db.Response reponse_";
  protected final String TEXT_8 = " = null;" + NL + "\t\tif(replicates_";
  protected final String TEXT_9 = " != null && replicates_";
  protected final String TEXT_10 = ".size()>0){" + NL + "\t\t\tfor(java.util.Map<String,Object> cancelParams_";
  protected final String TEXT_11 = " : replicates_";
  protected final String TEXT_12 = "){" + NL + "\t\t\t\treponse_";
  protected final String TEXT_13 = " = server_";
  protected final String TEXT_14 = ".post(\"/_replicate\",org.svenson.JSON.defaultJSON().forValue(cancelParams_";
  protected final String TEXT_15 = "));" + NL + "\t\t\t\tif(!reponse_";
  protected final String TEXT_16 = ".isOk()){" + NL + "\t\t\t\t\tSystem.err.println(reponse_";
  protected final String TEXT_17 = ".getContentAsString());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tserver_";
  protected final String TEXT_18 = ".shutDown();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_19 = NL;

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
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
