package org.talend.designer.codegen.translators.elt.map.hive;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;

public class TELTHiveOutputMainJava
{
  protected static String nl;
  public static synchronized TELTHiveOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTHiveOutputMainJava result = new TELTHiveOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString select_query_";
  protected final String TEXT_3 = " = null;\t" + NL + "\tString tableName_";
  protected final String TEXT_4 = " = null;" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tselect_query_";
  protected final String TEXT_6 = " = (String) globalMap.get(\"";
  protected final String TEXT_7 = "\"+\"QUERY\"+\"";
  protected final String TEXT_8 = "\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\tString dbschema_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "\t\tif(dbschema_";
  protected final String TEXT_12 = " != null && dbschema_";
  protected final String TEXT_13 = ".trim().length() > 0) {" + NL + "\t\t \ttableName_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = " + \".\" + ";
  protected final String TEXT_16 = ";" + NL + "\t\t} else {" + NL + "\t\t\ttableName_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_19 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_20 = " = null;" + NL;
  protected final String TEXT_21 = NL + "globalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "System.setProperty(\"path.separator\", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "    conn_";
  protected final String TEXT_24 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_25 = "\");" + NL + "    " + NL + "\tString dbname_";
  protected final String TEXT_26 = " = (String)globalMap.get(\"";
  protected final String TEXT_27 = "\");" + NL + "\tif(dbname_";
  protected final String TEXT_28 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_29 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_30 = ".trim())) {" + NL + "    \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_31 = " = conn_";
  protected final String TEXT_32 = ".createStatement();" + NL + "    \tgoToDatabase_";
  protected final String TEXT_33 = ".execute(\"use \" + dbname_";
  protected final String TEXT_34 = ");" + NL + "    \tgoToDatabase_";
  protected final String TEXT_35 = ".close();" + NL + "\t}" + NL + "\t" + NL + "\tString dbUser_";
  protected final String TEXT_36 = " = (String)globalMap.get(\"";
  protected final String TEXT_37 = "\");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_38 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\tif(dbUser_";
  protected final String TEXT_39 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_40 = ".trim())) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_41 = ");" + NL + "\t\t//make relative file path work for hive" + NL + "\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_42 = ");" + NL + "\t}";
  protected final String TEXT_43 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_44 = NL + "\t\tString dbUser_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "\t\tString dbPwd_";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = "; " + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_49 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_50 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_51 = " + \":\" + ";
  protected final String TEXT_52 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_53 = " = \"jdbc:";
  protected final String TEXT_54 = "://\";";
  protected final String TEXT_55 = NL + "    \t\t\tif(dbUser_";
  protected final String TEXT_56 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_57 = ".trim())) {" + NL + "    \t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_58 = ");" + NL + "    \t\t\t\t//make relative file path work for hive" + NL + "    \t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_59 = ");" + NL + "    \t\t\t}";
  protected final String TEXT_60 = NL + "\t\t\t\tString url_";
  protected final String TEXT_61 = " = \"jdbc:";
  protected final String TEXT_62 = "://\" + ";
  protected final String TEXT_63 = " + \":\" + ";
  protected final String TEXT_64 = " + \"/\" + ";
  protected final String TEXT_65 = " + \";principal=\" + ";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = NL + "\t\t\t\tString url_";
  protected final String TEXT_68 = " = \"jdbc:";
  protected final String TEXT_69 = "://\" + ";
  protected final String TEXT_70 = " + \":\" + ";
  protected final String TEXT_71 = " + \"/\" + ";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = NL + "\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_74 = "\");\t";
  protected final String TEXT_75 = NL + "\t\t\tconn_";
  protected final String TEXT_76 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t\tconn_";
  protected final String TEXT_79 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_80 = ", dbUser_";
  protected final String TEXT_81 = ", dbPwd_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_84 = " = conn_";
  protected final String TEXT_85 = ".createStatement();";
  protected final String TEXT_86 = NL + "\t        init_";
  protected final String TEXT_87 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_88 = ");" + NL + "\t\t    init_";
  protected final String TEXT_89 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = NL + "        \tinit_";
  protected final String TEXT_92 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \tinit_";
  protected final String TEXT_93 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t\tinit_";
  protected final String TEXT_96 = ".execute(\"SET \"+";
  protected final String TEXT_97 = "+\"=\"+";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = "\t\t" + NL + "\t\tinit_";
  protected final String TEXT_100 = ".close();" + NL + "\t\t" + NL + "    \tString dbname_";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_103 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_104 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_105 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_106 = " = conn_";
  protected final String TEXT_107 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_108 = ".execute(\"use \" + dbname_";
  protected final String TEXT_109 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_110 = ".close();" + NL + "    \t}";
  protected final String TEXT_111 = NL + "        \tjava.sql.Statement statement_";
  protected final String TEXT_112 = " = conn_";
  protected final String TEXT_113 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_114 = NL + "        \t\tstatement_";
  protected final String TEXT_115 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_116 = ");" + NL + "        \t";
  protected final String TEXT_117 = NL + "        \t" + NL + "        \t";
  protected final String TEXT_118 = NL + "        \t\tstatement_";
  protected final String TEXT_119 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_120 = ");" + NL + "        \t";
  protected final String TEXT_121 = NL + "        \t" + NL + "        \t";
  protected final String TEXT_122 = NL + "        \t\t\tstatement_";
  protected final String TEXT_123 = ".execute(\"add jar \"+";
  protected final String TEXT_124 = ");" + NL + "        \t";
  protected final String TEXT_125 = NL + "        \tstatement_";
  protected final String TEXT_126 = ".close();";
  protected final String TEXT_127 = NL + NL + "java.sql.Statement stmt_";
  protected final String TEXT_128 = " = conn_";
  protected final String TEXT_129 = ".createStatement();" + NL + "" + NL + "\tStringBuffer partitionSql = new StringBuffer();" + NL + "\tString startPartition = \"\";" + NL + "\tString endPartition = \"\";" + NL + "\tString bodyPartition = \"\";";
  protected final String TEXT_130 = NL + "\tstartPartition = \" PARTITION(\";" + NL + "\tendPartition = \")\";";
  protected final String TEXT_131 = NL + "    \t\t\tbodyPartition = bodyPartition + ";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = NL + "   \t\t\t\t    bodyPartition = bodyPartition + \"=\";" + NL + "   \t\t\t\t    bodyPartition = bodyPartition + ";
  protected final String TEXT_134 = ";";
  protected final String TEXT_135 = NL + "\t\t\t        bodyPartition = bodyPartition + \",\";";
  protected final String TEXT_136 = NL + "\tpartitionSql.append(startPartition).append(bodyPartition).append(endPartition);" + NL + "\t";
  protected final String TEXT_137 = "\t" + NL + "\tString insertQuery_";
  protected final String TEXT_138 = " = \"INSERT INTO TABLE \"+tableName_";
  protected final String TEXT_139 = " + partitionSql.toString() + \" \"+select_query_";
  protected final String TEXT_140 = ";" + NL + "\tstmt_";
  protected final String TEXT_141 = ".execute(insertQuery_";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\tString overwriteQuery_";
  protected final String TEXT_144 = " = \"INSERT OVERWRITE TABLE \"+tableName_";
  protected final String TEXT_145 = "+ partitionSql.toString() + \" \"+select_query_";
  protected final String TEXT_146 = ";" + NL + "\tstmt_";
  protected final String TEXT_147 = ".execute(overwriteQuery_";
  protected final String TEXT_148 = ");" + NL;
  protected final String TEXT_149 = NL + "int nb_line_overwrite_";
  protected final String TEXT_150 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_151 = " = 0;";
  protected final String TEXT_152 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery_";
  protected final String TEXT_153 = " + \"\\n\");" + NL + "nb_line_inserted_";
  protected final String TEXT_154 = " = stmt_";
  protected final String TEXT_155 = ".executeUpdate();" + NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_156 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_157 = NL + "System.out.println(\"Overwriting with : \\n\" + overwriteQuery_";
  protected final String TEXT_158 = " +\"\\n\");" + NL + "nb_line_overwrite_";
  protected final String TEXT_159 = " = stmt_";
  protected final String TEXT_160 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_overwrite_";
  protected final String TEXT_161 = " + \" rows overwrited. \\n\");" + NL + "\t";
  protected final String TEXT_162 = NL + "stmt_";
  protected final String TEXT_163 = ".close();" + NL;
  protected final String TEXT_164 = NL + "    if(conn_";
  protected final String TEXT_165 = " != null && !conn_";
  protected final String TEXT_166 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_167 = " .close();" + NL + "    }";
  protected final String TEXT_168 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_169 = "_NB_LINE_OVERWRITE\",nb_line_overwrite_";
  protected final String TEXT_170 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_171 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_172 = ");" + NL + "" + NL + "String currentClientPathSeparator_";
  protected final String TEXT_173 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_174 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_175 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_176 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_177 = "!=null) {" + NL + "\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_178 = ");" + NL + "\tglobalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_179 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_180 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_181 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_182 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_183 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();

	String dbtable = null;
	String uniqueNameConnection = null;
	INode previousNode = null;

	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();
		
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_8);
    
	}
	
	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));
    
   	String dbschema = ElementParameterParser.getValue(node,"__ELT_SCHEMA_NAME__");
	
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

	List<Map<String, String>> fieldPartitions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_PARTITION__");

    String dbhost = null;
    String dbport = null;
    String dbname = null;
    String dbuser = null;
    String dbpwd = null;
    
    //hbase settings
   	String storeByHBase = null;
	String zookeeperQuorumForHBase = null;
	String zookeeperClientPortForHBase = null;
	String defineRegisterJar = null;
	List<Map<String, String>> registerJarForHBase = null;
	
    boolean useExistingConn = false;
    if(previousNode != null) {
        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
    	useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
    	
    	storeByHBase = ElementParameterParser.getValue(previousNode, "__STORE_BY_HBASE__");
    	zookeeperQuorumForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_QUORUM__");
    	zookeeperClientPortForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_CLIENT_PORT__");
    	defineRegisterJar = ElementParameterParser.getValue(previousNode, "__DEFINE_REGISTER_JAR__");
    	registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(previousNode, "__REGISTER_JAR__");
    }

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
String connectionMode = ElementParameterParser.getValue(previousNode, "__CONNECTION_MODE__");
String hiveVersion = ElementParameterParser.getValue(previousNode, "__HIVE_VERSION__");

String yarnClasspathSeparator = ElementParameterParser.getValue(previousNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_21);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_22);
    

if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    String db = "db_" + connection;
    String dbUser = "dbUser_" + connection;
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(db);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String hiveServer = ElementParameterParser.getValue(previousNode, "__HIVE_SERVER__");

		boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__"));
		
		boolean useKrb = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_KRB__"));
		boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		String hivePrincipal = ElementParameterParser.getValue(previousNode, "__HIVE_PRINCIPAL__");

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion))) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}
		
		if(!isCustom && (("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
		 || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MapR_EMR".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_43);
    
		}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_54);
    
			if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,Cloudera_CDH4,Cloudera_CDH4_YARN,PIVOTAL_HD_1_0_1".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
			}
		} else {
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_66);
    
			} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_72);
    
			}
		}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_74);
    		
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
		} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		}


    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
	    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
	        String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_MAP_MEMORY_MB__");
	        String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_90);
    
		}
		boolean useYarn = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_YARN__"));
    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_RESOURCE_MANAGER__"));
    	
    	if(((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion)))) && setResourceManager) {
    		String resourceManager = ElementParameterParser.getValue(previousNode, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_94);
    
		}
		
		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_98);
    
			}
		}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(dbname);
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
    
        if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_124);
    
        		}
        	}
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
        }
}

List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
	//For Bug TDI-24105,support context variables
	if(fieldPartitions != null && !fieldPartitions.isEmpty()) {
		String columnName = null;
		String columnValue = null;
		int count = 0 ;

    stringBuffer.append(TEXT_130);
    
		for(Map<String, String> line : fieldPartitions ) {// search in the configuration table
		     columnName = line.get("COLUMN_NAME");
		     columnValue = line.get("COLUMN_VALUE");  
			if (columnName!=null && !"".equals(columnName)) {
			    count++;

    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_132);
    
   				if (columnValue!=null && !"".equals(columnValue)) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(columnValue);
    stringBuffer.append(TEXT_134);
    
				}
    			if(count < fieldPartitions.size()){

    stringBuffer.append(TEXT_135);
    
			    }
			}
		}
	}

    stringBuffer.append(TEXT_136);
    

if(columnList != null && columnList.size()>0){
	if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
	}else if (("OVERWRITE").equals(dataAction)){

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
	}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
}


// MAIN

	String incomingConnName = null;
	columnList = null;
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}

if(incomingConnName != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
	}else if(("OVERWRITE").equals(dataAction)){
	
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	}
}


// END


    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    return stringBuffer.toString();
  }
}
