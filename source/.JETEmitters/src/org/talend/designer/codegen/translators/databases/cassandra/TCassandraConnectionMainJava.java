package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCassandraConnectionMainJava
{
  protected static String nl;
  public static synchronized TCassandraConnectionMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraConnectionMainJava result = new TCassandraConnectionMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    String hostIps_";
  protected final String TEXT_2 = "=";
  protected final String TEXT_3 = "+\":\"+";
  protected final String TEXT_4 = ";" + NL + "    me.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_5 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_6 = ");" + NL + "    hosts_";
  protected final String TEXT_7 = ".setAutoDiscoverHosts(true);" + NL + "    java.util.Map<String, String> credentials_";
  protected final String TEXT_8 = " =new java.util.HashMap<String,String>();";
  protected final String TEXT_9 = NL + "    credentials_";
  protected final String TEXT_10 = ".put(\"username\",";
  protected final String TEXT_11 = ");" + NL + "    credentials_";
  protected final String TEXT_12 = ".put(\"password\",";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "    me.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_15 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_16 = "_\"+pid,hosts_";
  protected final String TEXT_17 = ",credentials_";
  protected final String TEXT_18 = ");" + NL + "" + NL + "\tglobalMap.put(\"cluster_";
  protected final String TEXT_19 = "\", cluster_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	if (authentication){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
