package org.talend.designer.codegen.translators.databases.paraccel;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TParAccelOutputEndJava
{
  protected static String nl;
  public static synchronized TParAccelOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParAccelOutputEndJava result = new TParAccelOutputEndJava();
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
  protected final String TEXT_18 = NL + "\t\t\tconn_";
  protected final String TEXT_19 = ".commit();";
  protected final String TEXT_20 = "\t" + NL + "    \tconn_";
  protected final String TEXT_21 = " .close();" + NL + "    \t";
  protected final String TEXT_22 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_23 = "=nb_line_deleted_";
  protected final String TEXT_24 = "+ deletedCount_";
  protected final String TEXT_25 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_26 = "=nb_line_update_";
  protected final String TEXT_27 = " + updatedCount_";
  protected final String TEXT_28 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_29 = "=nb_line_inserted_";
  protected final String TEXT_30 = " + insertedCount_";
  protected final String TEXT_31 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_32 = "=nb_line_rejected_";
  protected final String TEXT_33 = " + rejectedCount_";
  protected final String TEXT_34 = ";" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_35 = "_NB_LINE\",nb_line_";
  protected final String TEXT_36 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_37 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_38 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_39 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_40 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_41 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_42 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_43 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		}
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
	}
    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
