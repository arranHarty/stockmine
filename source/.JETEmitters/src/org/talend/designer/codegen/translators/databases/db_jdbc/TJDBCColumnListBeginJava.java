package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TJDBCColumnListBeginJava
{
  protected static String nl;
  public static synchronized TJDBCColumnListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCColumnListBeginJava result = new TJDBCColumnListBeginJava();
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
  protected final String TEXT_10 = ").getConnection();" + NL + "\t}" + NL + "" + NL + "String tableName_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "String dbschema_";
  protected final String TEXT_14 = " = (String)globalMap.get(\"";
  protected final String TEXT_15 = "\");" + NL + "" + NL + "if(dbschema_";
  protected final String TEXT_16 = " != null && dbschema_";
  protected final String TEXT_17 = ".trim().length() > 0){" + NL + "\ttableName_";
  protected final String TEXT_18 = " = \"[\" + dbschema_";
  protected final String TEXT_19 = " + \"].[\" + tableName_";
  protected final String TEXT_20 = " + \"]\";" + NL + "}else{" + NL + "\ttableName_";
  protected final String TEXT_21 = " = \"[\" + tableName_";
  protected final String TEXT_22 = " + \"]\";" + NL + "}";
  protected final String TEXT_23 = NL + "String dbschema_";
  protected final String TEXT_24 = " = (String)globalMap.get(\"";
  protected final String TEXT_25 = "\");" + NL + "" + NL + "if(dbschema_";
  protected final String TEXT_26 = " != null && dbschema_";
  protected final String TEXT_27 = ".trim().length() > 0){" + NL + "\ttableName_";
  protected final String TEXT_28 = " = dbschema_";
  protected final String TEXT_29 = " + \".\" + tableName_";
  protected final String TEXT_30 = ";" + NL + "}";
  protected final String TEXT_31 = NL + "String dbschema_";
  protected final String TEXT_32 = " = (String)globalMap.get(\"";
  protected final String TEXT_33 = "\");" + NL + "" + NL + "if(dbschema_";
  protected final String TEXT_34 = " != null && dbschema_";
  protected final String TEXT_35 = ".trim().length() > 0){" + NL + "\ttableName_";
  protected final String TEXT_36 = " = \"\\\"\" + dbschema_";
  protected final String TEXT_37 = " + \"\\\".\\\"\" + ";
  protected final String TEXT_38 = " + \"\\\"\";" + NL + "}else{" + NL + "\ttableName_";
  protected final String TEXT_39 = " = \"\\\"\" + ";
  protected final String TEXT_40 = " + \"\\\"\";" + NL + "}";
  protected final String TEXT_41 = NL + "int nb_column_";
  protected final String TEXT_42 = " = 0;" + NL + "" + NL + "int column_count_";
  protected final String TEXT_43 = " = 0;" + NL + "" + NL + "java.sql.Statement stmt2_";
  protected final String TEXT_44 = " = conn_";
  protected final String TEXT_45 = ".createStatement();" + NL + "" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_46 = " = stmt2_";
  protected final String TEXT_47 = ".executeQuery(\"SELECT * from \" + tableName_";
  protected final String TEXT_48 = " + \" where 1<>1\");" + NL + "" + NL + "java.sql.ResultSetMetaData rsMetaData_";
  protected final String TEXT_49 = " = rs_";
  protected final String TEXT_50 = ".getMetaData();" + NL + "" + NL + "column_count_";
  protected final String TEXT_51 = " = rsMetaData_";
  protected final String TEXT_52 = ".getColumnCount();" + NL + "" + NL + "for(int i_";
  protected final String TEXT_53 = " = 1; i_";
  protected final String TEXT_54 = " <= column_count_";
  protected final String TEXT_55 = "; i_";
  protected final String TEXT_56 = "++) {" + NL + "" + NL + "\tString currentColumnName_";
  protected final String TEXT_57 = " = rsMetaData_";
  protected final String TEXT_58 = ".getColumnName(i_";
  protected final String TEXT_59 = ");" + NL + "\tint currentColumnType_";
  protected final String TEXT_60 = " = rsMetaData_";
  protected final String TEXT_61 = ".getColumnType(i_";
  protected final String TEXT_62 = ");" + NL + "\tString currentColumnTypeName_";
  protected final String TEXT_63 = " = rsMetaData_";
  protected final String TEXT_64 = ".getColumnTypeName(i_";
  protected final String TEXT_65 = ");" + NL + "\tint currentColumnPrecision_";
  protected final String TEXT_66 = " = rsMetaData_";
  protected final String TEXT_67 = ".getPrecision(i_";
  protected final String TEXT_68 = ");" + NL + "\tint currentColumnScale_";
  protected final String TEXT_69 = " = rsMetaData_";
  protected final String TEXT_70 = ".getScale(i_";
  protected final String TEXT_71 = ");" + NL + "\tnb_column_";
  protected final String TEXT_72 = "++;" + NL + "        " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_73 = "_CURRENT_COLUMN\", currentColumnName_";
  protected final String TEXT_74 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_75 = "_CURRENT_COLUMN_TYPE\", currentColumnType_";
  protected final String TEXT_76 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_77 = "_CURRENT_COLUMN_TYPE_NAME\", currentColumnTypeName_";
  protected final String TEXT_78 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_79 = "_CURRENT_COLUMN_PRECISION\", currentColumnPrecision_";
  protected final String TEXT_80 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_81 = "_CURRENT_COLUMN_SCALE\", currentColumnScale_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL;

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
    
    String tableName = ElementParameterParser.getValue(node,"__TABLE_NAME__");

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
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_12);
    
	if(("MSSQL").equals(dbType)){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	}else if(("DBORACLE").equals(dbType)){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(schema);
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
    
	}else if(("DB2").equals(dbType)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_40);
    
	}

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
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
