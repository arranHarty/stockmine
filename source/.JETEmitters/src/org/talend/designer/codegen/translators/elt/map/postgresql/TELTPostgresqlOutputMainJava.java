package org.talend.designer.codegen.translators.elt.map.postgresql;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TELTPostgresqlOutputMainJava
{
  protected static String nl;
  public static synchronized TELTPostgresqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTPostgresqlOutputMainJava result = new TELTPostgresqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString select_query = null;\t" + NL + "\tString tableName_";
  protected final String TEXT_3 = " = null;" + NL + "\tString selectQueryColumnsName = null;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_5 = "\"+\"QUERY\"+\"";
  protected final String TEXT_6 = "\");" + NL + "\t\tselectQueryColumnsName = (String) globalMap.get(\"";
  protected final String TEXT_7 = "\"+\"QUERY_COLUMNS_NAME\"+\"";
  protected final String TEXT_8 = "\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\tString dbschema_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "\tif(dbschema_";
  protected final String TEXT_12 = " != null && dbschema_";
  protected final String TEXT_13 = ".trim().length() > 0) {" + NL + "\t\ttableName_";
  protected final String TEXT_14 = " = \"\\\"\"+";
  protected final String TEXT_15 = " + \"\\\".\\\"\" + ";
  protected final String TEXT_16 = " + \"\\\"\";" + NL + "\t}else {" + NL + "\t\ttableName_";
  protected final String TEXT_17 = " = \"\\\"\"+";
  protected final String TEXT_18 = " + \"\\\"\";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_19 = NL + NL;
  protected final String TEXT_20 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_21 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_22 = "\");";
  protected final String TEXT_23 = NL + "    java.lang.Class.forName(\"org.postgresql.Driver\");    " + NL + "    String url_";
  protected final String TEXT_24 = " = \"jdbc:postgresql://\"+";
  protected final String TEXT_25 = "+\":\"+";
  protected final String TEXT_26 = "+\"/\"+";
  protected final String TEXT_27 = ";    " + NL + "    String dbUser_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "    String dbPwd_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";   " + NL + "    java.sql.Connection conn_";
  protected final String TEXT_32 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_33 = ",dbUser_";
  protected final String TEXT_34 = ",dbPwd_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_37 = " =null;" + NL + "\t";
  protected final String TEXT_38 = "\t" + NL + "\tString insertQuery = \"INSERT INTO \"+tableName_";
  protected final String TEXT_39 = "+\"(";
  protected final String TEXT_40 = ")  (\"+select_query+\")\";" + NL + "\tpstmt_";
  protected final String TEXT_41 = " = conn_";
  protected final String TEXT_42 = ".prepareStatement(insertQuery);" + NL;
  protected final String TEXT_43 = NL + "\tString updateQuery = \"UPDATE \"+tableName_";
  protected final String TEXT_44 = "+\" SET ";
  protected final String TEXT_45 = " \"";
  protected final String TEXT_46 = NL + "\t\t+\"  WHERE \" + ";
  protected final String TEXT_47 = NL + "\t;" + NL + "\tpstmt_";
  protected final String TEXT_48 = " = conn_";
  protected final String TEXT_49 = ".prepareStatement(updateQuery);" + NL;
  protected final String TEXT_50 = NL + "\t" + NL + "\tString deleteQuery = \"DELETE  FROM \"+ tableName_";
  protected final String TEXT_51 = "+\" WHERE EXISTS (\"+select_query+\") \" " + NL + "\t";
  protected final String TEXT_52 = NL + "\t+\"  AND \" + ";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = NL + "\t;" + NL + "\tpstmt_";
  protected final String TEXT_55 = " = conn_";
  protected final String TEXT_56 = ".prepareStatement(deleteQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_57 = NL + "int nb_line_";
  protected final String TEXT_58 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_59 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_60 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_61 = " = 0;" + NL + "\t";
  protected final String TEXT_62 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "nb_line_inserted_";
  protected final String TEXT_63 = " = pstmt_";
  protected final String TEXT_64 = ".executeUpdate();" + NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_65 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_66 = NL + "System.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "nb_line_update_";
  protected final String TEXT_67 = " = pstmt_";
  protected final String TEXT_68 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_69 = " + \" rows updated. \\n\");" + NL + "\t";
  protected final String TEXT_70 = NL + "\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\tnb_line_deleted_";
  protected final String TEXT_71 = " = pstmt_";
  protected final String TEXT_72 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_73 = " + \" rows deleted. \\n\");" + NL + "\t\t";
  protected final String TEXT_74 = NL + NL + "pstmt_";
  protected final String TEXT_75 = ".close();" + NL;
  protected final String TEXT_76 = NL + "    if(conn_";
  protected final String TEXT_77 = " != null && !conn_";
  protected final String TEXT_78 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_79 = " .close();" + NL + "    }";
  protected final String TEXT_80 = NL + "nb_line_";
  protected final String TEXT_81 = " = nb_line_update_";
  protected final String TEXT_82 = " + nb_line_inserted_";
  protected final String TEXT_83 = " + nb_line_deleted_";
  protected final String TEXT_84 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_85 = "_NB_LINE\",nb_line_";
  protected final String TEXT_86 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_87 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_88 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_89 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_90 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_91 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL;

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
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_8);
    
	}
	
	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_18);
    
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbport = null;
        String dbname = null;
        String dbuser = null;
        String dbpwd = null;
	    boolean useExistingConn = false;
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
	    	useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
        }

        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_19);
    
if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_22);
    
} else {
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
}
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
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
	
	public void setName(String name){
		this.name = name;
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


List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}


int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;
boolean isfirstKey = true;
for(Column colStmt:stmtStructure){
	String suffix = ",";
	String colName="\\\""+colStmt.getName()+"\\\"";
	colStmt.setName(colName);
	if (colStmt.getColumn().isKey()){
		if (isfirstKey) {
			isfirstKey = false;
		}
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
			updateSetStmt.append(colStmt.getName()+"=(\"+select_query.replaceFirst(selectQueryColumnsName,selectQueryColumnsName.split(\",\")[ "+ counterOuter + "])+\")" +suffix);
		}
	}
	counterOuter ++;
}


	if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	}else if (("UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_45);
    
		if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    
		}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    		
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
	if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    stringBuffer.append(TEXT_53);
    
	}
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    		
	}
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
	
}

if(dbtable != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	}else if(("UPDATE").equals(dataAction)){

	
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}else if (("DELETE").equals(dataAction)){
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	}
}

// END

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    return stringBuffer.toString();
  }
}
