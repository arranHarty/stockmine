package org.talend.designer.codegen.translators.databases.vertica;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;

public class TVerticaOutputEndJava
{
  protected static String nl;
  public static synchronized TVerticaOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVerticaOutputEndJava result = new TVerticaOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_3 = " !=null && batchSizeCounter_";
  protected final String TEXT_4 = " > 0 ) { ";
  protected final String TEXT_5 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_6 = " !=null && commitCounter_";
  protected final String TEXT_7 = " > 0 ) {";
  protected final String TEXT_8 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_9 = " !=null) {";
  protected final String TEXT_10 = " " + NL + "\ttry {" + NL + "\t\t\tpstmt_";
  protected final String TEXT_11 = ".executeBatch();                \t" + NL + "\t    \t";
  protected final String TEXT_12 = NL + "\t    \t\tinsertedCount_";
  protected final String TEXT_13 = " +=pstmt_";
  protected final String TEXT_14 = ".getUpdateCount(); " + NL + "\t    \t";
  protected final String TEXT_15 = NL + "\t    \t\tupdatedCount_";
  protected final String TEXT_16 = " += pstmt_";
  protected final String TEXT_17 = ".getUpdateCount();" + NL + "\t    \t";
  protected final String TEXT_18 = NL + "\t    \t    deletedCount_";
  protected final String TEXT_19 = " += pstmt_";
  protected final String TEXT_20 = ".getUpdateCount();" + NL + "\t    \t";
  protected final String TEXT_21 = "            \t    " + NL + "    }catch (java.sql.BatchUpdateException e){" + NL + "    \t";
  protected final String TEXT_22 = NL + "    \t\tthrow(e);" + NL + "    \t";
  protected final String TEXT_23 = NL + "    \tSystem.out.println(e.getMessage());" + NL + "    \t";
  protected final String TEXT_24 = "                \t" + NL + "\t}                                  " + NL + "\t}";
  protected final String TEXT_25 = NL + "        pstmt_";
  protected final String TEXT_26 = " = conn_";
  protected final String TEXT_27 = ".prepareStatement(\"COMMIT;\");              " + NL + "        pstmtInsert_";
  protected final String TEXT_28 = " = conn_";
  protected final String TEXT_29 = ".prepareStatement(\"COMMIT;\");   " + NL + "        pstmtUpdate_";
  protected final String TEXT_30 = " = conn_";
  protected final String TEXT_31 = ".prepareStatement(\"COMMIT;\");   " + NL + "        pstmt_";
  protected final String TEXT_32 = ".executeUpdate();" + NL + "        pstmtInsert_";
  protected final String TEXT_33 = ".executeUpdate();" + NL + "        pstmtUpdate_";
  protected final String TEXT_34 = ".executeUpdate();";
  protected final String TEXT_35 = "         " + NL + "        pstmtInsert_";
  protected final String TEXT_36 = " = conn_";
  protected final String TEXT_37 = ".prepareStatement(\"COMMIT;\");   " + NL + "        pstmtUpdate_";
  protected final String TEXT_38 = " = conn_";
  protected final String TEXT_39 = ".prepareStatement(\"COMMIT;\");    " + NL + "        pstmtInsert_";
  protected final String TEXT_40 = ".executeUpdate();" + NL + "        pstmtUpdate_";
  protected final String TEXT_41 = ".executeUpdate();      ";
  protected final String TEXT_42 = "   " + NL + "    \t";
  protected final String TEXT_43 = NL + "        pstmt_";
  protected final String TEXT_44 = " = conn_";
  protected final String TEXT_45 = ".prepareStatement(\"COMMIT;\");    " + NL + "        pstmt_";
  protected final String TEXT_46 = ".executeUpdate();";
  protected final String TEXT_47 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_48 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_49 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_50 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_51 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_52 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_53 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_54 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_55 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_56 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_57 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_58 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_59 = NL + "\t        if(pstmt_";
  protected final String TEXT_60 = " != null) {" + NL + "\t" + NL + "\t            pstmt_";
  protected final String TEXT_61 = ".close();" + NL + "\t            " + NL + "\t        }        ";
  protected final String TEXT_62 = NL + "\tif (stmtBuilder_";
  protected final String TEXT_63 = " != null && stmtBuilder_";
  protected final String TEXT_64 = ".length() != 0 ) {" + NL + "\t\ttry {" + NL + "\t\t    java.io.ByteArrayInputStream bais_";
  protected final String TEXT_65 = " = new ByteArrayInputStream(stmtBuilder_";
  protected final String TEXT_66 = ".toString().getBytes());" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\tcom.vertica.jdbc.VerticaCopyStream vcs_";
  protected final String TEXT_68 = " = new com.vertica.jdbc.VerticaCopyStream((com.vertica.jdbc.VerticaConnection)conn_";
  protected final String TEXT_69 = ",template_";
  protected final String TEXT_70 = ");" + NL + "\t\t\tvcs_";
  protected final String TEXT_71 = ".start();" + NL + "\t\t\tvcs_";
  protected final String TEXT_72 = ".addStream(bais_";
  protected final String TEXT_73 = ");" + NL + "\t\t\tvcs_";
  protected final String TEXT_74 = ".execute();" + NL + "\t\t\tvcs_";
  protected final String TEXT_75 = ".finish();" + NL + "\t\t\tcopiedCount_";
  protected final String TEXT_76 = " +=vcs_";
  protected final String TEXT_77 = ".getRowCount();" + NL + "\t\t\tvcs_";
  protected final String TEXT_78 = " = null;" + NL + "\t    \t\t";
  protected final String TEXT_79 = NL + "\t\t    ((com.vertica.PGStatement)stmt_";
  protected final String TEXT_80 = ").executeCopyIn(template_";
  protected final String TEXT_81 = ", bais_";
  protected final String TEXT_82 = ");" + NL + "\t\t\tcopiedCount_";
  protected final String TEXT_83 = " +=stmt_";
  protected final String TEXT_84 = ".getUpdateCount(); " + NL + "\t\t\tif (stmt_";
  protected final String TEXT_85 = " != null) {" + NL + "\t\t\t\tstmt_";
  protected final String TEXT_86 = ".close();" + NL + "\t\t\t\tstmt_";
  protected final String TEXT_87 = " = null;" + NL + "\t\t\t}" + NL + "\t    \t\t";
  protected final String TEXT_88 = NL + "\t\t\tif (bais_";
  protected final String TEXT_89 = " != null ) {" + NL + "\t\t\t\tbais_";
  protected final String TEXT_90 = ".close();" + NL + "\t\t\t\tbais_";
  protected final String TEXT_91 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\tstmtBuilder_";
  protected final String TEXT_92 = " = null;" + NL + "        }catch (java.sql.SQLException e){" + NL + "        \t";
  protected final String TEXT_93 = NL + "\t\t\t\tthrow(e);" + NL + "        \t";
  protected final String TEXT_94 = NL + "                System.out.println(e.getMessage());" + NL + "        \t";
  protected final String TEXT_95 = NL + "        }  " + NL + "\t}";
  protected final String TEXT_96 = NL + "\t        conn_";
  protected final String TEXT_97 = ".commit();" + NL + "\t        ";
  protected final String TEXT_98 = NL + "\t     conn_";
  protected final String TEXT_99 = ".close();" + NL + "\t";
  protected final String TEXT_100 = NL + NL + "    nb_line_deleted_";
  protected final String TEXT_101 = "=nb_line_deleted_";
  protected final String TEXT_102 = "+ deletedCount_";
  protected final String TEXT_103 = ";" + NL + "    nb_line_update_";
  protected final String TEXT_104 = "=nb_line_update_";
  protected final String TEXT_105 = " + updatedCount_";
  protected final String TEXT_106 = ";" + NL + "    nb_line_inserted_";
  protected final String TEXT_107 = "=nb_line_inserted_";
  protected final String TEXT_108 = " + insertedCount_";
  protected final String TEXT_109 = ";" + NL + "    nb_line_rejected_";
  protected final String TEXT_110 = "=nb_line_rejected_";
  protected final String TEXT_111 = " + rejectedCount_";
  protected final String TEXT_112 = ";" + NL + "\tnb_line_copied_";
  protected final String TEXT_113 = "=nb_line_copied_";
  protected final String TEXT_114 = " + copiedCount_";
  protected final String TEXT_115 = ";" + NL + "    globalMap.put(\"";
  protected final String TEXT_116 = "_NB_LINE\",nb_line_";
  protected final String TEXT_117 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_118 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_119 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_120 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_121 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_122 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_123 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_124 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_125 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_126 = "_NB_LINE_COPIED\",nb_line_copied_";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    
    String cid = node.getUniqueName();
    
    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    
     boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    
	//batch mode
	if (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) {
		boolean batchMode = ("true").equals(ElementParameterParser.getValue(node, "__BATCH_MODE__"));
		if(batchMode) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		} else if (!useExistingConnection) { //use batch is not ticked

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		}else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
		} 

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if (("INSERT").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
	    	}else if (("UPDATE").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
	    	}else if (("DELETE").equals(dataAction)) {
	    	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
	    	}
    stringBuffer.append(TEXT_21);
    if(("true").equals(dieOnError)) {
    	
    stringBuffer.append(TEXT_22);
    
    	}else {
    	
    stringBuffer.append(TEXT_23);
    
    	}
    stringBuffer.append(TEXT_24);
    
	}

    if(!useExistingConnection && ("INSERT_OR_UPDATE").equals(dataAction)){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }else if(!useExistingConnection && ("UPDATE_OR_INSERT").equals(dataAction)){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }else{
    stringBuffer.append(TEXT_42);
       
    	 if(!useExistingConnection && !"COPY".equals(dataAction))	{
    	 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
    	}
    }

    
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
    } else {
       if (!"COPY".equals(dataAction)) {
        
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
		}
    }   

	//////////////// Copy Action //////////////////////
	if ("COPY".equals(dataAction)) { // COPY
		String db_version = ElementParameterParser.getValue(node,"__DB_VERSION__");
	    if(useExistingConnection){
			String connName = ElementParameterParser.getValue(node,"__CONNECTION__");
			INode con_node = NodeUtil.getNodeByUniqueName(node.getProcess(),connName);
			if(con_node!=null){
				db_version = ElementParameterParser.getValue(con_node,"__DB_VERSION__");
			}
	    }

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    if("VERTICA_6_1_X".equals(db_version) || "VERTICA_6_0".equals(db_version) || "VERTICA_5_1".equals(db_version)){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    if(("true").equals(dieOnError)) {
        	
    stringBuffer.append(TEXT_93);
    
        	}else {
        	
    stringBuffer.append(TEXT_94);
    
        	}
    stringBuffer.append(TEXT_95);
    
	}
	/////// commit end/////////////
	if(!useExistingConnection) {
	    if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){
	        
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	    }
	   
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
    }
   
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    return stringBuffer.toString();
  }
}
