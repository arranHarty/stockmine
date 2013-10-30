package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TCouchDBWriteConfEndJava
{
  protected static String nl;
  public static synchronized TCouchDBWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBWriteConfEndJava result = new TCouchDBWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif(server_";
  protected final String TEXT_3 = " != null){";
  protected final String TEXT_4 = NL + "\t\t\tif(replicates_";
  protected final String TEXT_5 = " != null && replicates_";
  protected final String TEXT_6 = ".size()>0){" + NL + "\t\t\t\tfor(java.util.Map<String,Object> cancelParams_";
  protected final String TEXT_7 = " : replicates_";
  protected final String TEXT_8 = "){" + NL + "\t\t\t\t\treponse_";
  protected final String TEXT_9 = " = server_";
  protected final String TEXT_10 = ".post(\"/_replicate\",org.svenson.JSON.defaultJSON().forValue(cancelParams_";
  protected final String TEXT_11 = "));" + NL + "\t\t\t\t\tif(!reponse_";
  protected final String TEXT_12 = ".isOk()){" + NL + "\t\t\t\t\t\tSystem.err.println(reponse_";
  protected final String TEXT_13 = ".getContentAsString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\tserver_";
  protected final String TEXT_15 = ".shutDown();" + NL + "\t\t}  ";
  protected final String TEXT_16 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE\",nb_line_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    cid = cid.replace("_Out", "");
    boolean useTriggerReplicate="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_TRIGGER_REPLICATE__"));
    boolean useExistingConn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    
	if(!useExistingConn){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if(useTriggerReplicate){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
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
    
		}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
