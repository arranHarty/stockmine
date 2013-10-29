package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TTeradataRowEndJava
{
  protected static String nl;
  public static synchronized TTeradataRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataRowEndJava result = new TTeradataRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tpstmt_";
  protected final String TEXT_3 = ".close();\t";
  protected final String TEXT_4 = NL + "\tstmt_";
  protected final String TEXT_5 = ".close();\t";
  protected final String TEXT_6 = NL + "            if(commitEvery_";
  protected final String TEXT_7 = " > commitCounter_";
  protected final String TEXT_8 = ") {" + NL + "            " + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Starting to commit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "            \tconn_";
  protected final String TEXT_12 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Commit has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "            \t" + NL + "            \tcommitCounter_";
  protected final String TEXT_16 = " = 0;" + NL + "            \t" + NL + "            }";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_20 = NL + "    \tconn_";
  protected final String TEXT_21 = " .close();" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_23 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_24 = NL + "    \t";
  protected final String TEXT_25 = NL + "\tlog.info(\"";
  protected final String TEXT_26 = " - Done.\");";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    		
	if (usePrepareStatement) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
	}
    if(!useExistingConn){
    	if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    	    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}
    	
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
	}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
