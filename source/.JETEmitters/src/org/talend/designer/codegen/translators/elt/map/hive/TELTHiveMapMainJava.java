package org.talend.designer.codegen.translators.elt.map.hive;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.designer.dbmap.external.data.ExternalDbMapData;
import org.talend.designer.dbmap.external.data.ExternalDbMapTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.dbmap.DbMapComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class TELTHiveMapMainJava
{
  protected static String nl;
  public static synchronized TELTHiveMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTHiveMapMainJava result = new TELTHiveMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_2 = "); " + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tSystem.setProperty(";
  protected final String TEXT_4 = " ,";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_8 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_9 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", ";
  protected final String TEXT_10 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_11 = ");\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\tSystem.setProperty(\"";
  protected final String TEXT_18 = "\", ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL + "\t\t\tglobalMap.put(" + NL + "\t\t\t\t\"";
  protected final String TEXT_21 = "\"+\"QUERY\" + \"";
  protected final String TEXT_22 = "\"," + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t);" + NL + "\t\t\tglobalMap.put(" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_24 = "\"+\"QUERY_COLUMNS_NAME\" + \"";
  protected final String TEXT_25 = "\"," + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_27 = "       " + NL + "                Object ";
  protected final String TEXT_28 = " = new Object();         ";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	DbMapComponent node = (DbMapComponent) codeGenArgument.getArgument();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    org.talend.designer.dbmap.language.hive.HiveGenerationManager gm = new org.talend.designer.dbmap.language.hive.HiveGenerationManager();
    String uniqueNameComponent = null;

    List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
    ExternalDbMapData data = (ExternalDbMapData) node.getExternalData();
    uniqueNameComponent = node.getUniqueName();
    
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String fsDefalutName = "fs.default.name";
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_2);
     
	}
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("false").equals(useExistingConn)) {
	boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
	boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
	boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");

	if(hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_5);
    
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

    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(metastorePassword);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_11);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_14);
    
			}
		}
	
	if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion))) && setMapredJT) {
		String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_15);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_16);
    
	}
		
	if(setNamenode) {
		String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_17);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_19);
    
	}			
}   			
	
    List<ExternalDbMapTable> outputTables = data.getOutputTables();

    Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
    for (IConnection connection : outputConnections) {
        nameToOutputConnection.put(connection.getUniqueName(), connection);
    }

	Set<String> tablesProcessed = new HashSet<String>();
    int lstOutputTablesSize = outputTables.size();
    for (int i = 0; i < lstOutputTablesSize; i++) {
        ExternalDbMapTable outputTable = outputTables.get(i);
        String outputTableName = outputTable.getName();

			IConnection connection = nameToOutputConnection.get(outputTableName);

        if (connection == null) {
        	continue;
        }

        String sqlQuery = gm.buildSqlSelect((DbMapComponent) node, outputTable.getName());
        
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( connection.getUniqueName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( sqlQuery.replaceAll("[\r\n]", " ") );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( connection.getUniqueName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( gm.getQueryColumnsName() );
    stringBuffer.append(TEXT_26);
    
            if(!tablesProcessed.contains(outputTable.getTableName())) {          
            
    stringBuffer.append(TEXT_27);
    stringBuffer.append( outputTable.getTableName() );
    stringBuffer.append(TEXT_28);
           
            } 
			tablesProcessed.add(outputTable.getTableName());
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
