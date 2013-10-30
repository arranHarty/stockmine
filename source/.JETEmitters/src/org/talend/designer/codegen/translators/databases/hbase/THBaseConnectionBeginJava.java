package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THBaseConnectionBeginJava
{
  protected static String nl;
  public static synchronized THBaseConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseConnectionBeginJava result = new THBaseConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    org.apache.hadoop.conf.Configuration config";
  protected final String TEXT_2 = " = org.apache.hadoop.hbase.HBaseConfiguration.create();" + NL + "\tconfig";
  protected final String TEXT_3 = ".clear();" + NL + "\tconfig";
  protected final String TEXT_4 = ".set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_5 = "); " + NL + "\tconfig";
  protected final String TEXT_6 = ".set(\"hbase.zookeeper.property.clientPort\",";
  protected final String TEXT_7 = "); " + NL + "\tconfig";
  protected final String TEXT_8 = ".set(\"hbase.cluster.distributed\",\"true\"); ";
  protected final String TEXT_9 = NL + "\t\tconfig";
  protected final String TEXT_10 = ".set(";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_14 = "\",config";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	List<Map<String, String>> properties =
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");
   for(int i=0;i<properties.size();i++){
   		Map<String, String> map = properties.get(i);
   		String property = map.get("PROPERTY");
   		String value= map.get("VALUE");

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_12);
    
   }

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
