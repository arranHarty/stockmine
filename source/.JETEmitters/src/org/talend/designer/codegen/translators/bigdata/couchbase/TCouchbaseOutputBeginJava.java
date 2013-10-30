package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TCouchbaseOutputBeginJava
{
  protected static String nl;
  public static synchronized TCouchbaseOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseOutputBeginJava result = new TCouchbaseOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.couchbase.client.CouchbaseClient client_";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    client_";
  protected final String TEXT_4 = " = (com.couchbase.client.CouchbaseClient)globalMap.get(\"conn_";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + "    java.util.ArrayList<java.net.URI> uris_";
  protected final String TEXT_7 = " = new java.util.ArrayList<java.net.URI>();";
  protected final String TEXT_8 = NL + "    uris_";
  protected final String TEXT_9 = ".add(java.net.URI.create(";
  protected final String TEXT_10 = "));";
  protected final String TEXT_11 = NL + "        client_";
  protected final String TEXT_12 = " = new com.couchbase.client.CouchbaseClient(uris_";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "int nb_line_";
  protected final String TEXT_19 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_20 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_21 = " = 0;" + NL + "int nb_line_inserted_updated_";
  protected final String TEXT_22 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_23 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_24 = " = 0;" + NL + "boolean whetherReject_";
  protected final String TEXT_25 = " = false;";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
if(useExistingConn){
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_5);
    
}else{
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String username = ElementParameterParser.getValue(node, "__USER__");
    String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
    List<Map<String, String>> URIList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__URIS__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
        for(java.util.Map<String,String> map:URIList){
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(map.get("URI"));
    stringBuffer.append(TEXT_10);
    
        }
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_14);
    if(username!=null && !"".equals(username)){
    stringBuffer.append(username);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
