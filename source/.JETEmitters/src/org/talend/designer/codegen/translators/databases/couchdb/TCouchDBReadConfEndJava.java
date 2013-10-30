package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TCouchDBReadConfEndJava
{
  protected static String nl;
  public static synchronized TCouchDBReadConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBReadConfEndJava result = new TCouchDBReadConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}";
  protected final String TEXT_3 = NL + "\tif(server_";
  protected final String TEXT_4 = " != null){";
  protected final String TEXT_5 = NL + "\t\tif(replicates_";
  protected final String TEXT_6 = " != null && replicates_";
  protected final String TEXT_7 = ".size()>0){" + NL + "\t\t\tfor(java.util.Map<String,Object> cancelParams_";
  protected final String TEXT_8 = " : replicates_";
  protected final String TEXT_9 = "){" + NL + "\t\t\t\treponse_";
  protected final String TEXT_10 = " = server_";
  protected final String TEXT_11 = ".post(\"/_replicate\",org.svenson.JSON.defaultJSON().forValue(cancelParams_";
  protected final String TEXT_12 = "));" + NL + "\t\t\t\tif(!reponse_";
  protected final String TEXT_13 = ".isOk()){" + NL + "\t\t\t\t\tSystem.err.println(reponse_";
  protected final String TEXT_14 = ".getContentAsString());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t\tserver_";
  protected final String TEXT_16 = ".shutDown();" + NL + "\t}  ";
  protected final String TEXT_17 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_18 = "_NB_LINE\",nb_line_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    cid = cid.replace("_In", "");
    boolean useTriggerReplicate="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_TRIGGER_REPLICATE__"));
    boolean useExistingConn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    
	if(!useExistingConn){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if(useTriggerReplicate){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
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
    
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
	}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
