package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCassandraInputEndJava
{
  protected static String nl;
  public static synchronized TCassandraInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraInputEndJava result = new TCassandraInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}";
  protected final String TEXT_2 = NL + "\t}";
  protected final String TEXT_3 = NL + "\t}finally{" + NL + "\t\tif(cluster_";
  protected final String TEXT_4 = "!=null){" + NL + "\t\t\tcluster_";
  protected final String TEXT_5 = ".getConnectionManager().shutdown();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_6 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE\", nb_line_";
  protected final String TEXT_8 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String columnFamilyType = ElementParameterParser.getValue(node,"__COLUMN_FAMILY_TYPE__");

    stringBuffer.append(TEXT_1);
    
	if("SUPER".equals(columnFamilyType)){

    stringBuffer.append(TEXT_2);
    
	}
	if (!useExistingConnection){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
