package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THiveRowEndJava
{
  protected static String nl;
  public static synchronized THiveRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowEndJava result = new THiveRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\tpstmt_";
  protected final String TEXT_4 = ".close();\t";
  protected final String TEXT_5 = NL + "\tstmt_";
  protected final String TEXT_6 = ".close();\t";
  protected final String TEXT_7 = NL + "            if(commitEvery_";
  protected final String TEXT_8 = " > commitCounter_";
  protected final String TEXT_9 = ") {" + NL + "            " + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Starting to commit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "            \tconn_";
  protected final String TEXT_13 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Commit has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "            \t" + NL + "            \tcommitCounter_";
  protected final String TEXT_17 = " = 0;" + NL + "            \t" + NL + "            }";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_21 = NL + "    \tconn_";
  protected final String TEXT_22 = " .close();" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "    \t";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\tlog.info(\"";
  protected final String TEXT_28 = " - Has finished!\");";
  protected final String TEXT_29 = NL + NL + "String currentClientPathSeparator_";
  protected final String TEXT_30 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_31 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_32 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_33 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_34 = "!=null) {" + NL + "\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_35 = ");" + NL + "\tglobalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_36 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_37 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_38 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_39 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_40 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String commitEvery = "0"; ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    stringBuffer.append(TEXT_2);
    		
	if (usePrepareStatement) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	}
	if(!("true").equals(useExistingConn)) {
    	if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
            
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
        }
    	
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    
    }

    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
