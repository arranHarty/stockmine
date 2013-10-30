package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCassandraOutputEndJava
{
  protected static String nl;
  public static synchronized TCassandraOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputEndJava result = new TCassandraOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tif (batchCounter_";
  protected final String TEXT_2 = " != 0) {" + NL + "\t\t\tmutator_";
  protected final String TEXT_3 = ".execute();" + NL + "\t\t}" + NL + "\t}catch (Exception e_";
  protected final String TEXT_4 = "){";
  protected final String TEXT_5 = NL + "        throw(e_";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_8 = ".getMessage());";
  protected final String TEXT_9 = "    " + NL + "\t}";
  protected final String TEXT_10 = NL + "\tfinally{" + NL + "\t\tif(cluster_";
  protected final String TEXT_11 = "!=null){" + NL + "\t\t\tcluster_";
  protected final String TEXT_12 = ".getConnectionManager().shutdown();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_13 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_14 = "_NB_LINE\", nb_line_";
  protected final String TEXT_15 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
	}else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	}

    stringBuffer.append(TEXT_9);
    
	if (!useExistingConnection){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
