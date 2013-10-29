package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TJDBCTableListBeginJava
{
  protected static String nl;
  public static synchronized TJDBCTableListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCTableListBeginJava result = new TJDBCTableListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\tif (null == conn_";
  protected final String TEXT_5 = ") {";
  protected final String TEXT_6 = " " + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_7 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\tconn_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "\t}" + NL + "" + NL + "int nb_table_";
  protected final String TEXT_11 = " = 0;" + NL;
  protected final String TEXT_12 = NL + "java.sql.Statement stmt2_";
  protected final String TEXT_13 = " = conn_";
  protected final String TEXT_14 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_15 = " = stmt2_";
  protected final String TEXT_16 = ".executeQuery(\"SELECT table_name from user_tables\");";
  protected final String TEXT_17 = NL + "java.sql.Statement stmt2_";
  protected final String TEXT_18 = " = conn_";
  protected final String TEXT_19 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_20 = " = stmt2_";
  protected final String TEXT_21 = ".executeQuery(\"SHOW tables\");";
  protected final String TEXT_22 = NL + "java.sql.CallableStatement stmt2_";
  protected final String TEXT_23 = " = conn_";
  protected final String TEXT_24 = ".prepareCall(\"{call sp_tables()}\", java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_25 = " = null;" + NL + "boolean resultSetFound_";
  protected final String TEXT_26 = " = stmt2_";
  protected final String TEXT_27 = ".execute();" + NL + "while (!resultSetFound_";
  protected final String TEXT_28 = ") {" + NL + "\tresultSetFound_";
  protected final String TEXT_29 = " = stmt2_";
  protected final String TEXT_30 = ".getMoreResults();" + NL + "\tif (!resultSetFound_";
  protected final String TEXT_31 = " && stmt2_";
  protected final String TEXT_32 = ".getUpdateCount() == -1) {" + NL + "\t\tbreak;" + NL + "\t}" + NL + "}" + NL + "if (resultSetFound_";
  protected final String TEXT_33 = ") {" + NL + "\trs_";
  protected final String TEXT_34 = " = stmt2_";
  protected final String TEXT_35 = ".getResultSet();" + NL + "}";
  protected final String TEXT_36 = NL + "String dbschema_";
  protected final String TEXT_37 = " = (String)globalMap.get(\"";
  protected final String TEXT_38 = "\");" + NL + "String query_";
  protected final String TEXT_39 = " = \"\";" + NL + "if(dbschema_";
  protected final String TEXT_40 = " != null && dbschema_";
  protected final String TEXT_41 = ".trim().length() > 0){" + NL + "\tquery_";
  protected final String TEXT_42 = " = \"SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema = ' + dbschema_";
  protected final String TEXT_43 = " + '\";" + NL + "}else{" + NL + "\tquery_";
  protected final String TEXT_44 = " = \"SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema NOT IN ('pg_catalog', 'information_schema')\";" + NL + "}" + NL + "java.sql.Statement stmt2_";
  protected final String TEXT_45 = " = conn_";
  protected final String TEXT_46 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_47 = " = stmt2_";
  protected final String TEXT_48 = ".executeQuery(query_";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "String dbschema_";
  protected final String TEXT_51 = " = (String)globalMap.get(\"";
  protected final String TEXT_52 = "\");" + NL + "String query_";
  protected final String TEXT_53 = " = \"\";" + NL + "if(dbschema_";
  protected final String TEXT_54 = " != null && dbschema_";
  protected final String TEXT_55 = ".trim().length() > 0){" + NL + "\tquery_";
  protected final String TEXT_56 = " = \"select tabname from syscat.tables where type='T' and tabschema='\"+ dbschema_";
  protected final String TEXT_57 = " +\"' order by tabschema, tabname\";" + NL + "}else{" + NL + "\tquery_";
  protected final String TEXT_58 = " = \"select tabname from syscat.tables where type='T' order by tabschema, tabname\";" + NL + "}" + NL + "java.sql.Statement stmt2_";
  protected final String TEXT_59 = " = conn_";
  protected final String TEXT_60 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_61 = " = stmt2_";
  protected final String TEXT_62 = ".executeQuery(query_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + NL + "while (rs_";
  protected final String TEXT_65 = ".next()) {";
  protected final String TEXT_66 = NL + "\tif(!(\"TABLE\").equals(rs_";
  protected final String TEXT_67 = ".getString(4))){" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tString currentTableName_";
  protected final String TEXT_68 = " = rs_";
  protected final String TEXT_69 = ".getString(3);";
  protected final String TEXT_70 = NL + "\tString currentTableName_";
  protected final String TEXT_71 = " = rs_";
  protected final String TEXT_72 = ".getString(1);";
  protected final String TEXT_73 = "\t";
  protected final String TEXT_74 = NL + "\tjava.util.regex.Pattern tableNamePattern_";
  protected final String TEXT_75 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = " " + NL + "\tif(!tableNamePattern_";
  protected final String TEXT_78 = ".matcher(currentTableName_";
  protected final String TEXT_79 = ").matches()){" + NL + "\t\tcontinue;" + NL + "\t}";
  protected final String TEXT_80 = "       " + NL + "\tif(tableNamePattern_";
  protected final String TEXT_81 = ".matcher(currentTableName_";
  protected final String TEXT_82 = ").matches()){" + NL + "\t\tcontinue;" + NL + "\t}";
  protected final String TEXT_83 = " " + NL + "" + NL + "\tnb_table_";
  protected final String TEXT_84 = "++;" + NL + "        " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_85 = "_CURRENT_TABLE\", currentTableName_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();
    
    String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");

    String connection = ElementParameterParser.getValue(node,"__CONNECTION_" + dbType + "__");
    
    String conn = "conn_" + connection;
    
    String schema = "dbschema_" + connection;
    
    boolean useFilter = ("true").equals(ElementParameterParser.getValue(node,"__USEFILTER__"));
    String nameRegex = ElementParameterParser.getValue(node,"__NAME_REGEX__");
    String criteria = ElementParameterParser.getValue(node,"__CRITERIA__");
    boolean isInclude = ("INCLUDE").equals(criteria);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    	
		INode connectionNode = null; 
		for (INode processNode : node.getProcess().getGeneratingNodes()) { 
			if(connection.equals(processNode.getUniqueName())) { 
				connectionNode = processNode; 
				break; 
			} 
		} 
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
	if(("DBORACLE").equals(dbType)){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
	}else if(("MYSQL").equals(dbType)){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
	}else if(("MSSQL").equals(dbType)){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
	}else if(("POSTGRE").equals(dbType)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
	}else if(("DB2").equals(dbType)){
		schema = "tableschema_" + connection;

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
	}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
	if(("MSSQL").equals(dbType)){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
	}else{

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
	}

    stringBuffer.append(TEXT_73);
    
if(useFilter){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(nameRegex );
    stringBuffer.append(TEXT_76);
    
	if(isInclude){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
	}else{
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
	}
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
