package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;

public class TTeradataMultiLoadMainJava
{
  protected static String nl;
  public static synchronized TTeradataMultiLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataMultiLoadMainJava result = new TTeradataMultiLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String tableFullName_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = " + \".\" + ";
  protected final String TEXT_4 = ";" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_5 = " = new java.io.FileWriter(";
  protected final String TEXT_6 = "+";
  protected final String TEXT_7 = "+\".script\");" + NL;
  protected final String TEXT_8 = NL + NL + "StringBuilder script_";
  protected final String TEXT_9 = " = new StringBuilder();";
  protected final String TEXT_10 = NL + "\tfw_";
  protected final String TEXT_11 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_12 = "+\".\"+";
  protected final String TEXT_13 = "+\"_lt;\"+ \"";
  protected final String TEXT_14 = "\");";
  protected final String TEXT_15 = NL + "\tfw_";
  protected final String TEXT_16 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_17 = "+\";\"+ \"";
  protected final String TEXT_18 = "\");";
  protected final String TEXT_19 = NL + "fw_";
  protected final String TEXT_20 = ".write(\".LOGON \"+";
  protected final String TEXT_21 = "+\"/\"+";
  protected final String TEXT_22 = "+\",\"+";
  protected final String TEXT_23 = "+\";\"+ \"";
  protected final String TEXT_24 = "\");" + NL;
  protected final String TEXT_25 = NL + "fw_";
  protected final String TEXT_26 = ".write(\".BEGIN IMPORT MLOAD TABLES \"+tableFullName_";
  protected final String TEXT_27 = "+\" \"+";
  protected final String TEXT_28 = "+\";\"+ \"";
  protected final String TEXT_29 = "\");" + NL + "fw_";
  protected final String TEXT_30 = ".write(\".LAYOUT customer_layout;\"+ \"";
  protected final String TEXT_31 = "\");";
  protected final String TEXT_32 = NL + "fw_";
  protected final String TEXT_33 = ".write(\".FIELD \"+\"";
  protected final String TEXT_34 = "\"+\" * VARCHAR(";
  protected final String TEXT_35 = ");\"+ \"";
  protected final String TEXT_36 = "\");";
  protected final String TEXT_37 = NL + "fw_";
  protected final String TEXT_38 = ".write(\".DML LABEL DML_LABEL;\"+ \"";
  protected final String TEXT_39 = "\");" + NL;
  protected final String TEXT_40 = NL + "fw_";
  protected final String TEXT_41 = ".write(\"UPDATE \"+tableFullName_";
  protected final String TEXT_42 = "+\" SET \"+\"";
  protected final String TEXT_43 = "\"" + NL + "\t+\" WHERE \"+\"";
  protected final String TEXT_44 = "\"+\";\"+ \"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "fw_";
  protected final String TEXT_47 = ".write(\"INSERT INTO \"+tableFullName_";
  protected final String TEXT_48 = "+\"(\"" + NL + "\t+\"";
  protected final String TEXT_49 = "\"+\") VAlUES(\"+\"";
  protected final String TEXT_50 = "\"+\");\"+ \"";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "fw_";
  protected final String TEXT_53 = ".write(\"DELETE FROM \"+tableFullName_";
  protected final String TEXT_54 = "+\" \"+";
  protected final String TEXT_55 = "+\" ;\"+ \"";
  protected final String TEXT_56 = "\");";
  protected final String TEXT_57 = NL + NL;
  protected final String TEXT_58 = NL + "fw_";
  protected final String TEXT_59 = ".write(\".IMPORT INFILE \\\"\"+";
  protected final String TEXT_60 = " +\"\\\"\");" + NL + "fw_";
  protected final String TEXT_61 = ".write(\" FORMAT VARText '\"+";
  protected final String TEXT_62 = "+\"' LAYOUT customer_layout APPLY DML_LABEL;\"+ \"";
  protected final String TEXT_63 = "\");" + NL + "fw_";
  protected final String TEXT_64 = ".write(\".END MLOAD;\"+ \"";
  protected final String TEXT_65 = "\");" + NL + "fw_";
  protected final String TEXT_66 = ".write(\".LOGOFF;\"+ \"";
  protected final String TEXT_67 = "\");" + NL;
  protected final String TEXT_68 = NL + "fw_";
  protected final String TEXT_69 = ".close();" + NL;
  protected final String TEXT_70 = NL + "String sb_";
  protected final String TEXT_71 = "= new String(\"mload -c \"+";
  protected final String TEXT_72 = "+\" < \\\"\"+";
  protected final String TEXT_73 = "+";
  protected final String TEXT_74 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_75 = "+\"\\\" 2>&1\");";
  protected final String TEXT_76 = "\t" + NL + "String sb_";
  protected final String TEXT_77 = "= new String(\"mload < \\\"\"+";
  protected final String TEXT_78 = "+";
  protected final String TEXT_79 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_80 = "+\"\\\" 2>&1\");";
  protected final String TEXT_81 = NL + "final Process process_";
  protected final String TEXT_82 = " = Runtime.getRuntime().exec(new String[]{\"cmd\",\"/c\",sb_";
  protected final String TEXT_83 = "}); ";
  protected final String TEXT_84 = NL + "final Process process_";
  protected final String TEXT_85 = " = Runtime.getRuntime().exec(new String[]{\"sh\",\"-c\",sb_";
  protected final String TEXT_86 = "});";
  protected final String TEXT_87 = NL + "Thread normal_";
  protected final String TEXT_88 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_89 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {" + NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_90 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_91 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_92 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_93 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_94 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_95 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_96 = ".interrupt();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_97 = "_EXIT_VALUE\", process_";
  protected final String TEXT_98 = ".exitValue());" + NL;
  protected final String TEXT_99 = NL + "\tif(process_";
  protected final String TEXT_100 = ".exitValue()>=";
  protected final String TEXT_101 = ") {" + NL + "\t\tthrow new RuntimeException(\"Multiload returned exit code \"+process_";
  protected final String TEXT_102 = ".exitValue());" + NL + "\t}";
  protected final String TEXT_103 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbhost= ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String action= ElementParameterParser.getValue(node, "__ACTION__");
String where= ElementParameterParser.getValue(node, "__WHERE__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");
String beginLoad= ElementParameterParser.getValue(node, "__BEGINLOAD_ADVANCEDPARAM__");
boolean returnCodeDie= ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__").equals("true");
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");
boolean specifyLogTable= ElementParameterParser.getValue(node, "__SPECIFY_LOG_TABLE__").equals("true");
String logTable= ElementParameterParser.getValue(node, "__LOG_TABLE_TABLE__");

String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
//windows line separator as default
String lineSeparator = "\\r\\n";
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}else {
	//Unix line separator
	lineSeparator = "\\n";
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_7);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
if(!specifyLogTable) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_14);
    
} else {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_18);
    
}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    if(dbhost!=null && !"\"\"".equals(dbhost)){
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_24);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(beginLoad);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_31);
    
if(columnList!=null){
	for(IMetadataColumn column:columnList){	

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_36);
    
	}
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_39);
    //SQL statements-------------------------------------------------------
    
StringBuilder updateSetSQL = new StringBuilder();
StringBuilder updateWhereSQL = new StringBuilder();
StringBuilder insertColSQL = new StringBuilder();
StringBuilder insertValueSQL = new StringBuilder();
if(columnList!=null){
	String columnName = "";
 	for(IMetadataColumn column:columnList){	
 		columnName= column.getOriginalDbColumnName();
 		if(insertColSQL.length()>0){
 			insertColSQL.append(",");
 		}
 		insertColSQL.append(columnName);
 		
 		if(insertValueSQL.length()>0){
 			insertValueSQL.append(",");
 		}
 		insertValueSQL.append(":").append(columnName);
 		
 		if(column.isKey()){
 			if(updateWhereSQL.length()>0){
     			updateWhereSQL.append(" AND ");
     		}
     		updateWhereSQL.append(columnName).append("=:").append(columnName);
 		}else{
     		if(updateSetSQL.length()>0){
     			updateSetSQL.append(",");
     		}
     		updateSetSQL.append(columnName).append("=:").append(columnName);
 		}
	}
}
if(("Update").equals(action) || ("InsertOrUpdate").equals(action)){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(updateSetSQL.toString());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(updateWhereSQL);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_45);
    
}
if(("Insert").equals(action) || ("InsertOrUpdate").equals(action)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(insertColSQL);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_51);
    
}
if(("Delete").equals(action)){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(where);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_56);
    
}

    stringBuffer.append(TEXT_57);
    //Import file----------------------------------------------------------
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_67);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    //run mload command----------------------------------------------------
    if("true".equals(defineCharset)) {
	if(!("".equals(charset))) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_75);
    }} else {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_80);
    }
    if(("Windows").equals(execution)){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    }else{
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
if(returnCodeDie) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    	
}

    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}
