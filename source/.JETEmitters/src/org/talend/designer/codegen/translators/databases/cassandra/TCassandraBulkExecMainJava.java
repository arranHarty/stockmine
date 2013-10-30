package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TCassandraBulkExecMainJava
{
  protected static String nl;
  public static synchronized TCassandraBulkExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraBulkExecMainJava result = new TCassandraBulkExecMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " \t" + NL + "java.io.File file_";
  protected final String TEXT_2 = " = new java.io.File(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "+\"/\"+";
  protected final String TEXT_5 = ");" + NL + "" + NL + "java.util.List<String> args_";
  protected final String TEXT_6 = " = new java.util.ArrayList<String>();" + NL + "args_";
  protected final String TEXT_7 = ".add(\"-d\"+";
  protected final String TEXT_8 = ");" + NL + "args_";
  protected final String TEXT_9 = ".add(\"-p\"+";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "args_";
  protected final String TEXT_12 = ".add(\"-pw\"+";
  protected final String TEXT_13 = ");" + NL + "args_";
  protected final String TEXT_14 = ".add(\"-u\"+";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "args_";
  protected final String TEXT_17 = ".add(file_";
  protected final String TEXT_18 = ".getAbsolutePath());" + NL + "org.apache.cassandra.tools.BulkLoader.main(args_";
  protected final String TEXT_19 = ".toArray(new String[args_";
  protected final String TEXT_20 = ".size()]));";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String sstablePath = ElementParameterParser.getValue(node,"__SSTABLE_STORE_PATH__");
String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
String host = ElementParameterParser.getValue(node,"__HOST__");
String port = ElementParameterParser.getValue(node,"__PORT__");
String version = ElementParameterParser.getValue(node,"__DB_VERSION__");
boolean requireAuth = "true".equals(ElementParameterParser.getValue(node,"__REQUIRED_AUTHENTICATION__"));
boolean needAuth = !"CASSANDRA_1_1_2".equals(version) && requireAuth;
String username = ElementParameterParser.getValue(node,"__USERNAME__");
String password = ElementParameterParser.getValue(node,"__PASSWORD__"); 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(sstablePath);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_10);
    if(needAuth){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_15);
    }
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
