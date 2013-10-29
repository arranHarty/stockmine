package org.talend.designer.codegen.translators.databases.db2;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TDB2OutputEndJava
{
  protected static String nl;
  public static synchronized TDB2OutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDB2OutputEndJava result = new TDB2OutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        if(pstmtUpdate_";
  protected final String TEXT_2 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_3 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_4 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_5 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_6 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_7 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_8 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_9 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_10 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_11 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_12 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_13 = "                " + NL + "    try {" + NL + "\t\t\tint countSum_";
  protected final String TEXT_14 = " = 0;" + NL + "\t\t\tif (pstmt_";
  protected final String TEXT_15 = " != null) {" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_16 = ": pstmt_";
  protected final String TEXT_17 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_18 = " += (countEach_";
  protected final String TEXT_19 = " < 0 ? 0 : countEach_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t}                 \t" + NL + "\t\t\t}" + NL + "\t    \t";
  protected final String TEXT_21 = NL + "\t    \t\tinsertedCount_";
  protected final String TEXT_22 = " += countSum_";
  protected final String TEXT_23 = "; " + NL + "\t    \t";
  protected final String TEXT_24 = NL + "\t    \t\tupdatedCount_";
  protected final String TEXT_25 = " += countSum_";
  protected final String TEXT_26 = ";" + NL + "\t    \t";
  protected final String TEXT_27 = NL + "\t    \t    deletedCount_";
  protected final String TEXT_28 = " += countSum_";
  protected final String TEXT_29 = ";" + NL + "\t    \t";
  protected final String TEXT_30 = "            \t    " + NL + "    }catch (java.sql.BatchUpdateException e){" + NL + "    \t";
  protected final String TEXT_31 = NL + "    \t\tthrow(e);" + NL + "    \t";
  protected final String TEXT_32 = NL + "    \tint countSum_";
  protected final String TEXT_33 = " = 0;" + NL + "\t\tfor(int countEach_";
  protected final String TEXT_34 = ": e.getUpdateCounts()) {" + NL + "\t\t\tcountSum_";
  protected final String TEXT_35 = " += (countEach_";
  protected final String TEXT_36 = " < 0 ? 0 : countEach_";
  protected final String TEXT_37 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_38 = NL + "    \t\tinsertedCount_";
  protected final String TEXT_39 = " += countSum_";
  protected final String TEXT_40 = "; " + NL + "    \t";
  protected final String TEXT_41 = NL + "    \t\tupdatedCount_";
  protected final String TEXT_42 = " += countSum_";
  protected final String TEXT_43 = ";" + NL + "    \t";
  protected final String TEXT_44 = NL + "    \t    deletedCount_";
  protected final String TEXT_45 = " += countSum_";
  protected final String TEXT_46 = ";" + NL + "    \t";
  protected final String TEXT_47 = " " + NL + "    \tSystem.out.println(e.getMessage());" + NL + "    \t";
  protected final String TEXT_48 = "                \t" + NL + "\t}                                  ";
  protected final String TEXT_49 = "   " + NL + "                " + NL + "        if(pstmt_";
  protected final String TEXT_50 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_51 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_52 = NL + "            conn_";
  protected final String TEXT_53 = ".commit();";
  protected final String TEXT_54 = NL + "        conn_";
  protected final String TEXT_55 = " .close();";
  protected final String TEXT_56 = NL + "\tnb_line_deleted_";
  protected final String TEXT_57 = "=nb_line_deleted_";
  protected final String TEXT_58 = "+ deletedCount_";
  protected final String TEXT_59 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_60 = "=nb_line_update_";
  protected final String TEXT_61 = " + updatedCount_";
  protected final String TEXT_62 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_63 = "=nb_line_inserted_";
  protected final String TEXT_64 = " + insertedCount_";
  protected final String TEXT_65 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_66 = "=nb_line_rejected_";
  protected final String TEXT_67 = " + rejectedCount_";
  protected final String TEXT_68 = ";" + NL + "" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_69 = "_NB_LINE\",nb_line_";
  protected final String TEXT_70 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_71 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_72 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_73 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_74 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_75 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_76 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_77 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
	String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    
    if(("INSERT_OR_UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
    } else {
        
    if ((rejectConnName==null && useBatchSize) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if (("INSERT").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	    	}else if (("UPDATE").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
	    	}else if (("DELETE").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	    	}
    stringBuffer.append(TEXT_30);
    if(("true").equals(dieOnError)) {
    	
    stringBuffer.append(TEXT_31);
    
    	}else {
    	
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
    if (("INSERT").equals(dataAction)) {
    	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
    	}else if (("UPDATE").equals(dataAction)) {
    	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
    	}else if (("DELETE").equals(dataAction)) {
    	
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
    	}
    stringBuffer.append(TEXT_47);
    
    	}
    stringBuffer.append(TEXT_48);
    
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
    }   
    if(!("true").equals(useExistingConn)) {
        if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
        }        
        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
	}
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    return stringBuffer.toString();
  }
}
