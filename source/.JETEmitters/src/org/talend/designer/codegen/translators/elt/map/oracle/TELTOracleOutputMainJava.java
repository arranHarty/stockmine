package org.talend.designer.codegen.translators.elt.map.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import org.talend.core.model.metadata.MetadataToolHelper;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TELTOracleOutputMainJava
{
  protected static String nl;
  public static synchronized TELTOracleOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTOracleOutputMainJava result = new TELTOracleOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString select_query = null;\t" + NL + "\tString tableName_";
  protected final String TEXT_3 = " = null;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_5 = "\"+\"QUERY\"+\"";
  protected final String TEXT_6 = "\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\tString dbschema_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\tif(dbschema_";
  protected final String TEXT_10 = " != null && dbschema_";
  protected final String TEXT_11 = ".trim().length() > 0) {" + NL + "\t\ttableName_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = " + \".\" + ";
  protected final String TEXT_14 = ";" + NL + "\t}else {" + NL + "\t\ttableName_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_17 = NL + NL;
  protected final String TEXT_18 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_19 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_20 = "\");";
  protected final String TEXT_21 = NL + "    java.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");";
  protected final String TEXT_22 = NL + "        String url_";
  protected final String TEXT_23 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_24 = " + \":\" + ";
  protected final String TEXT_25 = " + \":\" + ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "        String url_";
  protected final String TEXT_28 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_29 = " + \")(port=\" + ";
  protected final String TEXT_30 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_31 = " + \")))\";";
  protected final String TEXT_32 = NL + "        String url_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "    String dbUser_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "    String dbPwd_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ",dbUser_";
  protected final String TEXT_43 = ",dbPwd_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\tString atnParams_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";" + NL + "\tatnParams_";
  protected final String TEXT_48 = " = atnParams_";
  protected final String TEXT_49 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_50 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_51 = ".put(\"user\",dbUser_";
  protected final String TEXT_52 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_53 = ".put(\"password\",dbPwd_";
  protected final String TEXT_54 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_55 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_56 = ".getBytes()));" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_57 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_58 = ", atnParamsPrope_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_63 = " =null;" + NL + "\t";
  protected final String TEXT_64 = "\t" + NL + "\tString insertQuery = \"INSERT INTO \"+tableName_";
  protected final String TEXT_65 = "+\"(";
  protected final String TEXT_66 = ") (\"+select_query+\")\";";
  protected final String TEXT_67 = "\t" + NL + "\t    StringBuffer insertStringBuffer_";
  protected final String TEXT_68 = " = new StringBuffer(insertQuery);" + NL + "\t    insertStringBuffer_";
  protected final String TEXT_69 = ".insert(insertQuery.indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_70 = " + \" \");" + NL + "\t    insertQuery =insertStringBuffer_";
  protected final String TEXT_71 = ".toString(); ";
  protected final String TEXT_72 = "   " + NL + "\tpstmt_";
  protected final String TEXT_73 = " = conn_";
  protected final String TEXT_74 = ".prepareStatement(insertQuery);" + NL;
  protected final String TEXT_75 = NL + "\tString updateQuery = \"UPDATE \"+tableName_";
  protected final String TEXT_76 = "+\" SET (";
  protected final String TEXT_77 = ") = (\"+select_query+\") \"";
  protected final String TEXT_78 = NL + "\t\t+\"  WHERE \" + ";
  protected final String TEXT_79 = NL + "\t;";
  protected final String TEXT_80 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_81 = " = new StringBuffer(updateQuery);" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_82 = ".insert(updateQuery.indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_83 = "  + \" \");" + NL + "\t    updateQuery =updateStringBuffer_";
  protected final String TEXT_84 = ".toString(); ";
  protected final String TEXT_85 = NL + "\tpstmt_";
  protected final String TEXT_86 = " = conn_";
  protected final String TEXT_87 = ".prepareStatement(updateQuery);" + NL;
  protected final String TEXT_88 = NL + "\t" + NL + "String deleteQuery = \"DELETE  FROM \"+ tableName_";
  protected final String TEXT_89 = "+\" WHERE EXISTS (\"+select_query+\") \" ";
  protected final String TEXT_90 = NL + "+\"  AND \" + ";
  protected final String TEXT_91 = NL + ";";
  protected final String TEXT_92 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_93 = " = new StringBuffer(deleteQuery);" + NL + "    deleteStringBuffer_";
  protected final String TEXT_94 = ".insert(deleteQuery.indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_95 = "  + \" \" );" + NL + "    deleteQuery =deleteStringBuffer_";
  protected final String TEXT_96 = ".toString();  ";
  protected final String TEXT_97 = NL + "pstmt_";
  protected final String TEXT_98 = " = conn_";
  protected final String TEXT_99 = ".prepareStatement(deleteQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_100 = NL + "\tString mergeQuery = \"MERGE INTO \"+ tableName_";
  protected final String TEXT_101 = " +\" target\"  + \" USING (\" + select_query + \") source ON (\" +" + NL + "\t" + NL + "\t\t\"";
  protected final String TEXT_102 = "\" + \")\" ;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\t\tmergeQuery += \" WHEN MATCHED THEN UPDATE SET ";
  protected final String TEXT_104 = " \" ;\t" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\tmergeQuery += \"WHERE \" + \"\";" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\tmergeQuery += \"WHERE \" + ";
  protected final String TEXT_107 = ";" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\tmergeQuery += \" DELETE WHERE \" + \"\" ;" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\tmergeQuery += \" DELETE WHERE \" + ";
  protected final String TEXT_111 = " ;" + NL + "\t\t  ";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\tmergeQuery += \" WHEN NOT MATCHED THEN INSERT ( ";
  protected final String TEXT_115 = ") VALUES ( ";
  protected final String TEXT_116 = ") \";" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\tmergeQuery += \" WHERE \" + \"\";" + NL + "\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\tmergeQuery += \" WHERE \" + ";
  protected final String TEXT_119 = " ;" + NL + "\t\t\t";
  protected final String TEXT_120 = "\t" + NL + " \t\t\tpstmt_";
  protected final String TEXT_121 = " = conn_";
  protected final String TEXT_122 = ".prepareStatement(mergeQuery);" + NL + "\t";
  protected final String TEXT_123 = NL + "int nb_line_";
  protected final String TEXT_124 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_125 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_126 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_127 = " = 0;" + NL + "int nb_line_merged_";
  protected final String TEXT_128 = " = 0;" + NL + "\t";
  protected final String TEXT_129 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "nb_line_inserted_";
  protected final String TEXT_130 = " = pstmt_";
  protected final String TEXT_131 = ".executeUpdate();" + NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_132 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_133 = NL + "System.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "nb_line_update_";
  protected final String TEXT_134 = " = pstmt_";
  protected final String TEXT_135 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_136 = " + \" rows updated. \\n\");" + NL + "\t";
  protected final String TEXT_137 = NL + "\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\tnb_line_deleted_";
  protected final String TEXT_138 = " = pstmt_";
  protected final String TEXT_139 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_140 = " + \" rows deleted. \\n\");" + NL + "\t\t";
  protected final String TEXT_141 = "\t" + NL + "\tSystem.out.println(\"Merge with : \\n\" + mergeQuery +\"\\n\");" + NL + "\t    nb_line_merged_";
  protected final String TEXT_142 = " = pstmt_";
  protected final String TEXT_143 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_merged_";
  protected final String TEXT_144 = " + \" rows merged. \\n\");" + NL + "\t";
  protected final String TEXT_145 = NL + NL + "pstmt_";
  protected final String TEXT_146 = ".close();" + NL;
  protected final String TEXT_147 = NL + "    if(conn_";
  protected final String TEXT_148 = " != null && !conn_";
  protected final String TEXT_149 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_150 = " .close();" + NL + "    }";
  protected final String TEXT_151 = NL + "nb_line_";
  protected final String TEXT_152 = " = nb_line_update_";
  protected final String TEXT_153 = " + nb_line_inserted_";
  protected final String TEXT_154 = " + nb_line_deleted_";
  protected final String TEXT_155 = " + nb_line_merged_";
  protected final String TEXT_156 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_157 = "_NB_LINE\",nb_line_";
  protected final String TEXT_158 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_159 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_160 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_161 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_162 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_163 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_164 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_165 = "_NB_LINE_MERGED\",nb_line_merged_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();

	String dbtable = null;
	String dbschema = ElementParameterParser.getValue(node,"__ELT_SCHEMA_NAME__");
	String uniqueNameConnection = null;
	INode previousNode = null;

	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));

	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();
		
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_6);
    
	}
	
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_16);
    
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbport = null;
        String dbname = null;
        String dbuser = null;
        String dbpwd = null;
	    String connectionType = null;
	    boolean useExistingConn = false;
	    String dbproperties = null;
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
	    	connectionType = ElementParameterParser.getValue(previousNode, "__CONNECTION_TYPE__");
	    	useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
	    	dbproperties = ElementParameterParser.getValue(previousNode, "__PROPERTIES__");
        }

        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_17);
    
if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_20);
    
} else {
    
    stringBuffer.append(TEXT_21);
    
    if(connectionType == null || ("ORACLE_SID").equals(connectionType)) {
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_26);
    
    } else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_31);
    
    } else if("ORACLE_RAC".equals(connectionType)) {
    	String rac_url = ElementParameterParser.getValue(previousNode, "__RAC_URL__");
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_34);
    
    }
    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_39);
    
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
	} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
	}

    stringBuffer.append(TEXT_60);
    
}

    stringBuffer.append(TEXT_61);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if(metadatas !=null && metadatas.size()>0){
	metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
	String validateName;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(IMetadataColumn column){
		this.column = column;
		String columname = column.getOriginalDbColumnName();
		if(columname!=null && columname.trim().length()>0){
			this.name = columname;
		}else{
			this.name = column.getLabel();
		}
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
		this.validateName=MetadataToolHelper.validateValue(this.name);
		if(!this.name.equals(this.validateName)){
    		this.name = "\\\""+this.name+"\\\"";
    	}
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public String getValue(){
		return this.value;
	}
	
}

StringBuilder insertColName = new StringBuilder();

StringBuilder insertValueStmt = new StringBuilder();

StringBuilder updateSetStmt = new StringBuilder();

StringBuilder updateWhereStmt = new StringBuilder();

StringBuilder mergeCondition = new StringBuilder ();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}


int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;
boolean isfirstKey = true;
for(Column colStmt:stmtStructure){
	String colName=colStmt.getName();
	String suffix = ",";
	
	if (colStmt.getColumn().isKey()){
		if (isfirstKey) {
			isfirstKey = false;
		}else {
			mergeCondition.append(" AND ");
		}
		mergeCondition.append("target." + colName + "=source." + colName);
	}
	if(colStmt.isReplaced()){		
		List<Column> replacedColumns = colStmt.getReplacement();
		int counterReplace = 0;
		if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
			suffix = "";
		}
		for(Column replacement:replacedColumns){
			insertColName.append(replacement.getName()+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(replacement.getName());
				updateSetStmt.append(replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(replacement.getName());
				updateWhereStmt.append(replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append(colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(colStmt.getName());
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(colStmt.getName());
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}

///// hint options/////
boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
Map<String, String> hintsValues = null; 
if (useHintOptions) {
	List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
	hintsValues = new HashMap<String, String>();
	String hintValue = null;
	boolean firstInsert = true;
	boolean firstUpdate = true;
	boolean firstDelete = true;
	boolean firstTableName = true;
	for(java.util.Map<String, String> option : hintOptions) {
		//get
		if(option.get("HINT").matches("\"/\\*NORMALIZED_HINT\\*/\"")) {
			String id = cid.replace(node.getComponent().getName() + "_", "");
			hintValue = "\"/*\"+" + dbtable + "+\".\" + "  + "\"" + option.get("SQL_STMT")+ ".\"" + "+" +  id   +  "+\"*/\" " ;
		}else if (option.get("HINT").matches("\"/\\*+.*\\*/\"")) {
			hintValue = option.get("HINT");	
		}
		//set
		if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
			if(firstInsert){
				hintsValues.put("INSERT", hintValue) ;
				firstInsert = false;
			}else {
				hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
			}									
		}else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if(firstUpdate){
				hintsValues.put("UPDATE", hintValue) ;
				firstUpdate = false;
			}else {
				hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
			}
		}else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if (firstDelete){
				hintsValues.put("DELETE", hintValue) ;
				firstDelete =false;
			}else {
				hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
			}		
		}else if ("TABLE_NAME".equalsIgnoreCase(option.get("SQL_STMT"))){
			if (firstTableName){
				hintsValues.put("TABLE_NAME", hintValue) ;
				firstTableName = false;
			}else {
				hintsValues.put("TABLE_NAME", hintsValues.get("TABLE_NAME") + "+" + hintValue) ;
			}
		}
	}
} 
//// hint options end ////

	if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_66);
    	   
		if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	}else if (("UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_77);
    
		if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    
		}

    stringBuffer.append(TEXT_79);
    		if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    		
		}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    		
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_91);
    
	if(useHintOptions && hintsValues.get("DELETE") != null) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
  }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    		
	}else if ("MERGE".equals(dataAction)) {	
	// get parameter
	boolean useMergeUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE__")); 
	boolean useMergeInsert = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_INSERT__"));
	
	boolean useUpdateWhere =  "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE_WHERE__"));
	boolean useUpdateDeleteWhere = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE_DELETE_WHERE__"));
	boolean useInsertWhere = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_INSERT_WHERE__"));
	
	
	
	List<Map<String, String>> updateColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMA_UPDATE__");
	List<Map<String, String>> insertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMA_INSERT__");
	
	StringBuilder mergeUpdate = new StringBuilder() ;
	StringBuilder mergeInsertName = new StringBuilder() ;
	StringBuilder mergeInsertValue = new StringBuilder() ;
	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(mergeCondition);
    stringBuffer.append(TEXT_102);
    
		if(!useMergeUpdate)
			useUpdateWhere =false;
		if (useMergeUpdate) {
		boolean isfirstUpdateSet = true; 
		String keyColumnName=null;
			for(Map<String, String> keyColumn:updateColumns){
				if (keyColumn.get("UPDATE").equals("true")) {
					if (isfirstUpdateSet) {
					  	isfirstUpdateSet = false;
					}else {
						mergeUpdate.append(",");
					}
					keyColumnName=keyColumn.get("SCHEMA_COLUMN");
					keyColumnName=new Column(metadata.getColumn(keyColumnName)).getName();
					mergeUpdate.append("target."  + keyColumnName + "=source." + keyColumnName);
				}				
			}
		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(mergeUpdate);
    stringBuffer.append(TEXT_104);
    if (useUpdateWhere) { 
				String useUpdateWhereString = ElementParameterParser.getValue(node,"__MERGE_UPDATE_WHERE_STRING__");
				if(useUpdateWhereString == null || useUpdateWhereString.length() == 0){
					
			
    stringBuffer.append(TEXT_105);
    
				}
				else {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(useUpdateWhereString );
    stringBuffer.append(TEXT_107);
    	}
			}
    stringBuffer.append(TEXT_108);
    if (useUpdateDeleteWhere) { 
				String useUpdateDeleteWhereString = ElementParameterParser.getValue(node,"__MERGE_UPDATE_DELETE_WHERE_STRING__");
				if(useUpdateDeleteWhereString == null || useUpdateDeleteWhereString.length() == 0){
			
    stringBuffer.append(TEXT_109);
    
				}
				else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(useUpdateDeleteWhereString);
    stringBuffer.append(TEXT_111);
    	}
			}
    stringBuffer.append(TEXT_112);
    
		}
    stringBuffer.append(TEXT_113);
    
		if(!useMergeInsert)
			useInsertWhere = false;
		if (useMergeInsert) {
		    boolean isfirstInsertWhere = true;
		    String keyColumnName=null;
			for(Map<String, String> keyColumn:insertColumns){
				if (isfirstInsertWhere) {
	 			 	isfirstInsertWhere = false;
				}else {
					mergeInsertName.append(",");
					mergeInsertValue.append(",");
					
				}
				if (keyColumn.get("INSERT").equals("true")) {
					keyColumnName=keyColumn.get("SCHEMA_COLUMN");
					keyColumnName = new Column(metadata.getColumn(keyColumnName)).getName();
					mergeInsertName.append(keyColumnName);
					mergeInsertValue.append("source." + keyColumnName);
				}				
			}
			
    stringBuffer.append(TEXT_114);
    stringBuffer.append(mergeInsertName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(mergeInsertValue);
    stringBuffer.append(TEXT_116);
    
			}
			if (useInsertWhere) {
			String useInsertWhereString = ElementParameterParser.getValue(node,"__MERGE_INSERT_WHERE_STRING__");
			if(useInsertWhereString == null || useInsertWhereString.length() == 0){
			
    stringBuffer.append(TEXT_117);
    
			} else {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(useInsertWhereString);
    stringBuffer.append(TEXT_119);
    }
			}
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	}
	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
	
}
if(dbtable != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
	}else if(("UPDATE").equals(dataAction)){

	
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
	}else if (("DELETE").equals(dataAction)){
		
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
	}else if (("MERGE").equals(dataAction)){
	
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
	}
}
// END


    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
}

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    return stringBuffer.toString();
  }
}
