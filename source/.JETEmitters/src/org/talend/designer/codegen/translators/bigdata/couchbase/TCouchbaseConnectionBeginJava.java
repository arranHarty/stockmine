package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TCouchbaseConnectionBeginJava
{
  protected static String nl;
  public static synchronized TCouchbaseConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseConnectionBeginJava result = new TCouchbaseConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.couchbase.client.CouchbaseClient client_";
  protected final String TEXT_2 = " = null;" + NL + "java.util.ArrayList<java.net.URI> uris_";
  protected final String TEXT_3 = " = new java.util.ArrayList<java.net.URI>();";
  protected final String TEXT_4 = NL + "uris_";
  protected final String TEXT_5 = ".add(java.net.URI.create(";
  protected final String TEXT_6 = "));";
  protected final String TEXT_7 = NL + "    client_";
  protected final String TEXT_8 = " = new com.couchbase.client.CouchbaseClient(uris_";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = ");" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_14 = "\",client_";
  protected final String TEXT_15 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String username = ElementParameterParser.getValue(node, "__USER__");
String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
List<Map<String, String>> URIList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__URIS__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
    for(java.util.Map<String,String> map:URIList){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(map.get("URI"));
    stringBuffer.append(TEXT_6);
    
    }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    if(username!=null && !"".equals(username)){
    stringBuffer.append(username);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
