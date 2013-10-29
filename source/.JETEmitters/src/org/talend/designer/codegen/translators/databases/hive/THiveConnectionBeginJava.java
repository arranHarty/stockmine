package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");";
  protected final String TEXT_4 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_7 = " = SharedDBConnection.getDBConnection(\"";
  protected final String TEXT_8 = "\",url_";
  protected final String TEXT_9 = ",userName_";
  protected final String TEXT_10 = " , password_";
  protected final String TEXT_11 = " , sharedConnectionName_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tconn_";
  protected final String TEXT_14 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_15 = ",userName_";
  protected final String TEXT_16 = ",password_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\tconn_";
  protected final String TEXT_19 = ".setAutoCommit(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = NL + "\t\t\t\tconn_";
  protected final String TEXT_23 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\t\t\tSystem.setProperty(";
  protected final String TEXT_27 = " ,";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_32 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", ";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_34 = ");\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_41 = "\", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_44 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_45 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_46 = " + \":\" + ";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_48 = " = \"jdbc:";
  protected final String TEXT_49 = "://\";";
  protected final String TEXT_50 = NL + "\t\t\t\t\tString dbUser_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";" + NL + "\t\t\t\t\tif(dbUser_";
  protected final String TEXT_53 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_54 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"dbUser_";
  protected final String TEXT_57 = "\",dbUser_";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_59 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_60 = " = \"jdbc:";
  protected final String TEXT_61 = "://\" + ";
  protected final String TEXT_62 = " + \":\" + ";
  protected final String TEXT_63 = " + \"/\" + ";
  protected final String TEXT_64 = " + \";principal=\" + ";
  protected final String TEXT_65 = ";";
  protected final String TEXT_66 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_67 = " = \"jdbc:";
  protected final String TEXT_68 = "://\" + ";
  protected final String TEXT_69 = " + \":\" + ";
  protected final String TEXT_70 = " + \"/\" + ";
  protected final String TEXT_71 = ";";
  protected final String TEXT_72 = NL + "\t\t\tconn_";
  protected final String TEXT_73 = ".setAutoCommit(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + NL + "\t";
  protected final String TEXT_76 = NL + NL + "\tString userName_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + "\tString password_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_82 = " = null;" + NL;
  protected final String TEXT_83 = NL + "\t";
  protected final String TEXT_84 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_85 = ")) {" + NL + "\t\t";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_88 = "\", conn_";
  protected final String TEXT_89 = ");" + NL + "\t}";
  protected final String TEXT_90 = NL + "\tif (null != conn_";
  protected final String TEXT_91 = ") {" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t}";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_95 = ");" + NL + "\t" + NL + "\tjava.sql.Statement init_";
  protected final String TEXT_96 = " = conn_";
  protected final String TEXT_97 = ".createStatement();";
  protected final String TEXT_98 = NL + "        init_";
  protected final String TEXT_99 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_100 = ");" + NL + "\t    init_";
  protected final String TEXT_101 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "    \tinit_";
  protected final String TEXT_104 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "    \tinit_";
  protected final String TEXT_105 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t\tinit_";
  protected final String TEXT_108 = ".execute(\"SET \"+";
  protected final String TEXT_109 = "+\"=\"+";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\tinit_";
  protected final String TEXT_112 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_113 = NL + "\t\tjava.sql.Statement statement_";
  protected final String TEXT_114 = " = conn_";
  protected final String TEXT_115 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_116 = NL + "\t\t\tstatement_";
  protected final String TEXT_117 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_118 = ");" + NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\t\tstatement_";
  protected final String TEXT_121 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_122 = ");" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_125 = ".execute(\"add jar \"+";
  protected final String TEXT_126 = ");" + NL + "\t\t";
  protected final String TEXT_127 = NL + "\t\tstatement_";
  protected final String TEXT_128 = ".close();" + NL + "\t";
  protected final String TEXT_129 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_130 = "\",conn_";
  protected final String TEXT_131 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_132 = "\",";
  protected final String TEXT_133 = ");" + NL + "\t" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_134 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_135 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_136 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString currentClientUsername_";
  protected final String TEXT_137 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\tif(currentClientUsername_";
  protected final String TEXT_138 = "!=null) {" + NL + "\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_139 = ");" + NL + "\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_140 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_141 = "\");" + NL + "\tif(originalHadoopUsername_";
  protected final String TEXT_142 = "!=null) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_143 = ");" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_144 = "\", null);" + NL + "\t} else {" + NL + "\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_20);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    stringBuffer.append(TEXT_21);
    

	class ConnectionUtil extends DefaultConnectionUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		
		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			} else {
				super.createConnection(node);
			}
		}
	
		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			
			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
			
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			
			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion)))) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}
			if(!isCustom && (("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			 || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MapR_EMR".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_25);
    
			}
			
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_28);
    
				} 
			}
			
			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				String metastorePassword = ElementParameterParser.getValue(node, "__METASTORE_PASSWORD__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_29);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(metastorePassword);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_34);
    
				if(useKeytab) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_37);
    
				}
			}
			
			if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion))) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_38);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_39);
    
			}
			
			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_40);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_42);
    
			}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_49);
    
				if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,Cloudera_CDH4,Cloudera_CDH4_YARN,PIVOTAL_HD_1_0_1".contains(hiveVersion)))) {
					String dbuser = ElementParameterParser.getValue(node, "__USER__");

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
				}
			} else {
				if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_65);
    
				} else {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_71);
    
				}
			}
		}
		
		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_74);
    
			}
		}
		
		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_75);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	
	connUtil.createURL(node);

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_78);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append((dbpass != null && dbpass.trim().length() == 0)? "null":dbpass);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_83);
    connUtil.useShareConnection(node);
    
	} else {
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_84);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_85);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_86);
    connUtil.createConnection(node);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_92);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_93);
    
	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_94);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_102);
    
	}
	if(((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion)))) && setResourceManager) {
		String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_106);
    
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_110);
    
		}
	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
			for(Map<String, String> jar : registerJarForHBase){
				String path = jar.get("JAR_PATH");
				if(path == null || "".equals(path) || "\"\"".equals(path)) {
					continue;
				}
		
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_126);
    
			}
		}
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    return stringBuffer.toString();
  }
}
