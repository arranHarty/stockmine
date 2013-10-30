package org.talend.designer.codegen.translators.databases.hbase;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class THBaseOutputEndJava
{
  protected static String nl;
  public static synchronized THBaseOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputEndJava result = new THBaseOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tif(table_";
  protected final String TEXT_2 = "!=null){" + NL + "\t\t\ttable_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t}" + NL + "\t}catch (java.lang.Exception e){";
  protected final String TEXT_4 = NL + "        throw(e);";
  protected final String TEXT_5 = NL + "\t\tSystem.out.println(e.getMessage());";
  protected final String TEXT_6 = "                \t" + NL + "\t}";
  protected final String TEXT_7 = NL + "\tfinally{" + NL + "\t\tif(conn_";
  protected final String TEXT_8 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_13 = ",true);";
  protected final String TEXT_14 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_15 = NL + "globalMap.put(\"";
  protected final String TEXT_16 = "_NB_LINE\",nb_line_";
  protected final String TEXT_17 = "); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_4);
    
	   	}else {

    stringBuffer.append(TEXT_5);
    
		}

    stringBuffer.append(TEXT_6);
    
//use existing connection
if(!"true".equals(useExistingConn)){
	String hbaseVersion = ElementParameterParser.getValue(node,"__HBASE_VERSION__");
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    } else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
