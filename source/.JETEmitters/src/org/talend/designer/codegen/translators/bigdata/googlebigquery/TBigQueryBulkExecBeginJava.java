package org.talend.designer.codegen.translators.bigdata.googlebigquery;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class TBigQueryBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TBigQueryBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryBulkExecBeginJava result = new TBigQueryBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tfinal String CLIENT_ID_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";" + NL + "\tfinal String CLIENT_SECRET_";
  protected final String TEXT_4 = " = \"{\\\"web\\\": {\\\"client_id\\\": \\\"\"+";
  protected final String TEXT_5 = "+\"\\\",\\\"client_secret\\\": \\\"\" +";
  protected final String TEXT_6 = "+ \"\\\",\\\"auth_uri\\\": \\\"https://accounts.google.com/o/oauth2/auth\\\",\\\"token_uri\\\": \\\"https://accounts.google.com/o/oauth2/token\\\"}}\";" + NL + "\tfinal String PROJECT_ID_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "\t// Static variables for API scope, callback URI, and HTTP/JSON functions" + NL + "\tfinal List<String> SCOPES_";
  protected final String TEXT_9 = " = java.util.Arrays.asList(\"https://www.googleapis.com/auth/bigquery\");" + NL + "\tfinal String REDIRECT_URI_";
  protected final String TEXT_10 = " = \"urn:ietf:wg:oauth:2.0:oob\";" + NL + "\tfinal com.google.api.client.http.HttpTransport TRANSPORT_";
  protected final String TEXT_11 = " = new com.google.api.client.http.javanet.NetHttpTransport();" + NL + "\tfinal com.google.api.client.json.JsonFactory JSON_FACTORY_";
  protected final String TEXT_12 = " = new com.google.api.client.json.jackson.JacksonFactory();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets clientSecrets_";
  protected final String TEXT_13 = " = com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.load(" + NL + "\t\t\t\t\tnew com.google.api.client.json.jackson.JacksonFactory(), new java.io.ByteArrayInputStream(" + NL + "\t\t\t\t\t\t\tCLIENT_SECRET_";
  protected final String TEXT_14 = ".getBytes()));" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow flow_";
  protected final String TEXT_15 = " = null;" + NL + "\tcom.google.api.services.bigquery.Bigquery bigqueryclient_";
  protected final String TEXT_16 = " = null;" + NL + "" + NL + "\t// Attempt to load existing refresh token" + NL + "\tString tokenFile_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_19 = " = new java.util.Properties();" + NL + "\ttry {" + NL + "\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_20 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_21 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_22 = ".load(inputStream_";
  protected final String TEXT_23 = ");" + NL + "\t\tinputStream_";
  protected final String TEXT_24 = ".close();" + NL + "\t} catch (java.io.FileNotFoundException e_";
  protected final String TEXT_25 = ") {" + NL + "\t} catch (java.io.IOException ee_";
  protected final String TEXT_26 = ") {" + NL + "\t}" + NL + "\tString storedRefreshToken_";
  protected final String TEXT_27 = " = (String) properties_";
  protected final String TEXT_28 = ".get(\"refreshtoken\");" + NL + "" + NL + "\t// Check to see if the an existing refresh token was loaded." + NL + "\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t// access token." + NL + "\tif (storedRefreshToken_";
  protected final String TEXT_29 = " != null) {" + NL + "\t\t// Request a new Access token using the refresh token." + NL + "\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential_";
  protected final String TEXT_30 = " = new com.google.api.client.googleapis.auth.oauth2. GoogleCredential.Builder().setTransport(TRANSPORT_";
  protected final String TEXT_31 = ")" + NL + "\t\t\t\t.setJsonFactory(JSON_FACTORY_";
  protected final String TEXT_32 = ").setClientSecrets(clientSecrets_";
  protected final String TEXT_33 = ")" + NL + "\t\t\t\t.build().setFromTokenResponse(new com.google.api.client.auth.oauth2.TokenResponse().setRefreshToken(storedRefreshToken_";
  protected final String TEXT_34 = "));" + NL + "" + NL + "\t\tcredential_";
  protected final String TEXT_35 = ".refreshToken();" + NL + "" + NL + "\t\tbigqueryclient_";
  protected final String TEXT_36 = " = com.google.api.services.bigquery.Bigquery.builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson.JacksonFactory()).setHttpRequestInitializer(credential_";
  protected final String TEXT_37 = ").setApplicationName(\"Talend\").build();" + NL + "\t} else {";
  protected final String TEXT_38 = NL + "\t\t\tString authorizeUrl_";
  protected final String TEXT_39 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl(" + NL + "\t\t\t\t\tclientSecrets_";
  protected final String TEXT_40 = ", REDIRECT_URI_";
  protected final String TEXT_41 = ", SCOPES_";
  protected final String TEXT_42 = ").setState(\"\").build();" + NL + "" + NL + "\t\t\tSystem.out" + NL + "\t\t\t\t\t.println(\"Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_43 = ");" + NL + "\t\t\tSystem.exit(0);";
  protected final String TEXT_44 = NL + "\t\t\tString authorizationCode_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "" + NL + "\t\t\t// Exchange the auth code for an access token and refesh token" + NL + "\t\t\tif (flow_";
  protected final String TEXT_47 = " == null) {" + NL + "\t\t\t\tflow_";
  protected final String TEXT_48 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder(new com.google.api.client.http.javanet.NetHttpTransport()," + NL + "\t\t\t\t\t\tnew com.google.api.client.json.jackson.JacksonFactory(), clientSecrets_";
  protected final String TEXT_49 = ", SCOPES_";
  protected final String TEXT_50 = ")" + NL + "\t\t\t\t\t\t.setAccessType(\"offline\").setApprovalPrompt(\"force\")" + NL + "\t\t\t\t\t\t.build();" + NL + "\t\t\t}" + NL + "\t\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse response_";
  protected final String TEXT_51 = " = flow_";
  protected final String TEXT_52 = ".newTokenRequest(authorizationCode_";
  protected final String TEXT_53 = ").setRedirectUri(REDIRECT_URI_";
  protected final String TEXT_54 = ").execute();" + NL + "\t\t\tcom.google.api.client.auth.oauth2.Credential credential_";
  protected final String TEXT_55 = " = flow_";
  protected final String TEXT_56 = ".createAndStoreCredential(response_";
  protected final String TEXT_57 = ", null);" + NL + "" + NL + "\t\t\t// Store the refresh token for future use." + NL + "\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_58 = " = new java.util.Properties();" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_59 = ".setProperty(\"refreshtoken\", credential_";
  protected final String TEXT_60 = ".getRefreshToken());" + NL + "\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_61 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_62 = ");" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_63 = ".store(outputStream_";
  protected final String TEXT_64 = ",null);" + NL + "\t\t\tif (outputStream_";
  protected final String TEXT_65 = " != null) {" + NL + "\t\t\t    outputStream_";
  protected final String TEXT_66 = ".close();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tbigqueryclient_";
  protected final String TEXT_67 = " = com.google.api.services.bigquery.Bigquery.builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson.JacksonFactory()).setHttpRequestInitializer(credential_";
  protected final String TEXT_68 = ").build();";
  protected final String TEXT_69 = NL + "\t}" + NL + "" + NL + "" + NL + "/* -------------------------------------- */" + NL + "" + NL + "\t" + NL + NL;
  protected final String TEXT_70 = NL + NL + "\t\torg.jets3t.service.security.GSCredentials gsCredentials = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ");" + NL + "\t\t" + NL + "\t\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService gsService = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(gsCredentials);" + NL + "\t\t//org.jets3t.service.model.GSBucket[] myBuckets = gsService.listAllBuckets();" + NL + "\t\t//System.out.println(\"How many buckets to I have in GS? \" + myBuckets.length);" + NL + "" + NL + "\t\tjava.io.File fileData = new java.io.File(";
  protected final String TEXT_73 = ");" + NL + "\t\torg.jets3t.service.model.GSObject fileObject = new org.jets3t.service.model.GSObject(fileData);" + NL + "" + NL + "\t\tgsService.putObject(";
  protected final String TEXT_74 = ", fileObject);" + NL;
  protected final String TEXT_75 = NL + NL + "/* ------------------------------------------- */" + NL + "" + NL + "" + NL + "\tcom.google.api.services.bigquery.model.Job job_";
  protected final String TEXT_76 = " = new com.google.api.services.bigquery.model.Job();" + NL + "\tjob_";
  protected final String TEXT_77 = ".setJobReference(new com.google.api.services.bigquery.model.JobReference().setProjectId(PROJECT_ID_";
  protected final String TEXT_78 = "));" + NL + "" + NL + "\tcom.google.api.services.bigquery.model.JobConfiguration config_";
  protected final String TEXT_79 = " = new com.google.api.services.bigquery.model.JobConfiguration();" + NL + "\tcom.google.api.services.bigquery.model.JobConfigurationLoad queryLoad_";
  protected final String TEXT_80 = " = new com.google.api.services.bigquery.model.JobConfigurationLoad();" + NL + "\tcom.google.api.services.bigquery.model.TableSchema schema_";
  protected final String TEXT_81 = " = new com.google.api.services.bigquery.model.TableSchema();" + NL + "" + NL + "\tjava.util.List<com.google.api.services.bigquery.model.TableFieldSchema> fields_";
  protected final String TEXT_82 = " = new java.util.ArrayList<com.google.api.services.bigquery.model.TableFieldSchema>();";
  protected final String TEXT_83 = NL + "\tcom.google.api.services.bigquery.model.TableFieldSchema ";
  protected final String TEXT_84 = " = new com.google.api.services.bigquery.model.TableFieldSchema();" + NL + "\t";
  protected final String TEXT_85 = ".setName(\"";
  protected final String TEXT_86 = "\");" + NL + "\t";
  protected final String TEXT_87 = ".setType(\"";
  protected final String TEXT_88 = "\");" + NL + "\tfields_";
  protected final String TEXT_89 = ".add(";
  protected final String TEXT_90 = ");\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t" + NL + "" + NL + "\tschema_";
  protected final String TEXT_92 = ".setFields(fields_";
  protected final String TEXT_93 = ");" + NL + "" + NL + "\tqueryLoad_";
  protected final String TEXT_94 = ".setSchema(schema_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\tqueryLoad_";
  protected final String TEXT_97 = ".setCreateDisposition(\"CREATE_IF_NEEDED\");";
  protected final String TEXT_98 = NL + "\t\tqueryLoad_";
  protected final String TEXT_99 = ".setCreateDisposition(\"CREATE_NEVER\");";
  protected final String TEXT_100 = NL + "\t\tqueryLoad_";
  protected final String TEXT_101 = ".setFieldDelimiter(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + NL + "\tqueryLoad_";
  protected final String TEXT_104 = ".setWriteDisposition(\"WRITE_";
  protected final String TEXT_105 = "\");" + NL + "\tcom.google.api.services.bigquery.model.TableReference destinationTable_";
  protected final String TEXT_106 = " = new com.google.api.services.bigquery.model.TableReference();" + NL + "\tdestinationTable_";
  protected final String TEXT_107 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_108 = ");" + NL + "\tdestinationTable_";
  protected final String TEXT_109 = ".setDatasetId(";
  protected final String TEXT_110 = ");" + NL + "\tdestinationTable_";
  protected final String TEXT_111 = ".setTableId(";
  protected final String TEXT_112 = ");" + NL + "" + NL + "\tqueryLoad_";
  protected final String TEXT_113 = ".setDestinationTable(destinationTable_";
  protected final String TEXT_114 = ");" + NL + "\tqueryLoad_";
  protected final String TEXT_115 = ".setSourceUris(java.util.Arrays.asList(";
  protected final String TEXT_116 = "));" + NL + "\tqueryLoad_";
  protected final String TEXT_117 = ".setSkipLeadingRows(";
  protected final String TEXT_118 = ");" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_119 = ".setLoad(queryLoad_";
  protected final String TEXT_120 = ");" + NL + "\t" + NL + "\tjob_";
  protected final String TEXT_121 = ".setConfiguration(config_";
  protected final String TEXT_122 = ");" + NL + "" + NL + "\tcom.google.api.services.bigquery.Bigquery.Jobs.Insert insertReq_";
  protected final String TEXT_123 = " = bigqueryclient_";
  protected final String TEXT_124 = ".jobs().insert(\"\", job_";
  protected final String TEXT_125 = ");" + NL + "\tinsertReq_";
  protected final String TEXT_126 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_127 = ");" + NL + "\tSystem.out.println(\"Starting load job.\");" + NL + "\tcom.google.api.services.bigquery.model.Job jobExec_";
  protected final String TEXT_128 = " = null;" + NL + "\ttry {" + NL + "\t\tjobExec_";
  protected final String TEXT_129 = " = insertReq_";
  protected final String TEXT_130 = ".execute();" + NL + "\t} catch (Exception ee_";
  protected final String TEXT_131 = ") {";
  protected final String TEXT_132 = NL + "\t\tthrow ee_";
  protected final String TEXT_133 = ";";
  protected final String TEXT_134 = NL + "\t\tSystem.err.println(ee_";
  protected final String TEXT_135 = ".getMessage() + \"\\n\" + ee_";
  protected final String TEXT_136 = ".getCause());";
  protected final String TEXT_137 = NL + "\t}" + NL + "\tif (jobExec_";
  protected final String TEXT_138 = ".getStatus().getState().equals(\"RUNNING\")" + NL + "\t\t\t|| jobExec_";
  protected final String TEXT_139 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\tcom.google.api.services.bigquery.model.Job pollJob_";
  protected final String TEXT_140 = " = bigqueryclient_";
  protected final String TEXT_141 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_142 = ",jobExec_";
  protected final String TEXT_143 = ".getJobReference().getJobId()).execute();" + NL + "\t\twhile (pollJob_";
  protected final String TEXT_144 = ".getStatus().getState().equals(\"RUNNING\") || pollJob_";
  protected final String TEXT_145 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\t\tThread.sleep(1000);" + NL + "\t\t\tpollJob_";
  protected final String TEXT_146 = " = bigqueryclient_";
  protected final String TEXT_147 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_148 = ",jobExec_";
  protected final String TEXT_149 = ".getJobReference().getJobId()).execute();" + NL + "\t\t\tSystem.out.println(String.format(" + NL + "\t\t\t\t\t\"Waiting on job %s ... Current status: %s\", jobExec_";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t\t.getJobReference().getJobId(), pollJob_";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\t\t.getStatus().getState()));" + NL + "\t\t}" + NL + "" + NL + "\t\tcom.google.api.services.bigquery.model.Job doneJob_";
  protected final String TEXT_152 = " = pollJob_";
  protected final String TEXT_153 = ";" + NL + "\t\tSystem.out.println(\"Done: \" + doneJob_";
  protected final String TEXT_154 = ".toString());" + NL + "\t} else {";
  protected final String TEXT_155 = NL + "\t\tthrow new Exception(jobExec_";
  protected final String TEXT_156 = ".toString());";
  protected final String TEXT_157 = NL + "\t\tSystem.err.println(\"Error: \" + jobExec_";
  protected final String TEXT_158 = ".toString());";
  protected final String TEXT_159 = NL + "\t}";
  protected final String TEXT_160 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

	INode node = (INode)codeGenArgument.getArgument();

	String cid = node.getUniqueName();

	String clientId = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	String clientSecret = ElementParameterParser.getValue(node,"__CLIENT_SECRET__");
	String projectId = ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String authorizationCode = ElementParameterParser.getValue(node,"__AUTHORIZATION_CODE__");

	String actionOnData = ElementParameterParser.getValue(node, "__ACTION_ON_DATA__");
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    String tokenFile = ElementParameterParser.getValue(node,"__TOKEN_NAME__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(clientId );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(clientSecret);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(projectId );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
		if(authorizationCode==null || "".equals(authorizationCode) || "\"\"".equals(authorizationCode)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(authorizationCode);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
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
    
		}

    stringBuffer.append(TEXT_69);
    
	boolean bulkFileAlreadyExists = "true".equals(ElementParameterParser.getValue(node, "__BULK_FILE_ALREADY_EXIST__"));
	String accessKey = ElementParameterParser.getValue(node, "__GS_ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__GS_SECRET_KEY__");
	String localFilename = ElementParameterParser.getValue(node, "__GS_LOCAL_FILE__");
	String bucketName = ElementParameterParser.getValue(node, "__BUCKET_NAME__");
	if(!bulkFileAlreadyExists) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(localFilename);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_74);
    
	}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null) && (metadatas.size() > 0)) {
			IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();
					for (int i = 0; i < nbColumns; i++ ) {
						IMetadataColumn column = columns.get(i);
						String columnName = column.getLabel();
						String typeToGenerate = "string";
						if("id_Float".equals(column.getTalendType())) {
							typeToGenerate = "float";
						}
						if("id_Integer".equals(column.getTalendType())) {
							typeToGenerate = "integer";
						}
						if("id_Boolean".equals(column.getTalendType())) {
							typeToGenerate = "boolean";
						}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_90);
    

			}
		}
	}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	if("true".equals(ElementParameterParser.getValue(node, "__CREATE_TABLE_IF_NOT_EXIST__"))) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	} else {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	}

	if("true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_DELIMITER__"))) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELD_DELIMITER__"));
    stringBuffer.append(TEXT_102);
    
	}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(actionOnData);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DATASET__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE__"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE_HEADER__"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
	} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
	}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
	} else {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
	}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    return stringBuffer.toString();
  }
}
