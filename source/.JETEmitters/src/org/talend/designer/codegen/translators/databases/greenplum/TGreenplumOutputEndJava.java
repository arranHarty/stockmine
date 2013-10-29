package org.talend.designer.codegen.translators.databases.greenplum;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TGreenplumOutputEndJava
{
  protected static String nl;
  public static synchronized TGreenplumOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGreenplumOutputEndJava result = new TGreenplumOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_3 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_4 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_5 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_6 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_7 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_8 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_9 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_10 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_11 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_12 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_13 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_14 = NL + "        if(pstmt_";
  protected final String TEXT_15 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_16 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Starting to commit.\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tconn_";
  protected final String TEXT_22 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Commit has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_25 = "\t" + NL + "\t \t";
  protected final String TEXT_26 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_28 = NL + "    \tconn_";
  protected final String TEXT_29 = " .close();" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_31 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_32 = NL + "    \t";
  protected final String TEXT_33 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_34 = "=nb_line_deleted_";
  protected final String TEXT_35 = "+ deletedCount_";
  protected final String TEXT_36 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_37 = "=nb_line_update_";
  protected final String TEXT_38 = " + updatedCount_";
  protected final String TEXT_39 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_40 = "=nb_line_inserted_";
  protected final String TEXT_41 = " + insertedCount_";
  protected final String TEXT_42 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_43 = "=nb_line_rejected_";
  protected final String TEXT_44 = " + rejectedCount_";
  protected final String TEXT_45 = ";" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_46 = "_NB_LINE\",nb_line_";
  protected final String TEXT_47 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_48 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_49 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_51 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_52 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_53 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_54 = "_NB_LINE_REJECTED\",nb_line_deleted_";
  protected final String TEXT_55 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_56 = NL + "\t\tlog.info(\"";
  protected final String TEXT_57 = " - There are \" + nb_line_";
  protected final String TEXT_58 = " + \" counts be effected. Inesrted count: \" + nb_line_inserted_";
  protected final String TEXT_59 = " + \", Updated count: \" + nb_line_update_";
  protected final String TEXT_60 = " + \", Deleted count: \" + nb_line_deleted_";
  protected final String TEXT_61 = " + \", Rejected count: \" + nb_line_rejected_";
  protected final String TEXT_62 = " );" + NL + "\t\tlog.info(\"";
  protected final String TEXT_63 = " - Has finished.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
    } else {
        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
    }   
    
    stringBuffer.append(TEXT_17);
    
	if(!("true").equals(useExistingConn))
	{
		if(!("").equals(commitEvery) && !("0").equals(commitEvery))
		{
			
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    
		}
		
    stringBuffer.append(TEXT_25);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
	}
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    return stringBuffer.toString();
  }
}
