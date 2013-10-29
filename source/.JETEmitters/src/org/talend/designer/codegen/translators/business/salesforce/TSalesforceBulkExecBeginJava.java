package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;

public class TSalesforceBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceBulkExecBeginJava result = new TSalesforceBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_3 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_4 = ";" + NL + "\t\tString endpointURL_";
  protected final String TEXT_5 = " = null;" + NL + "\t\tString accessToken_";
  protected final String TEXT_6 = " = null;" + NL + "\t\toauthClient_";
  protected final String TEXT_7 = ".setBaseOAuthURL(";
  protected final String TEXT_8 = ");" + NL + "\t\toauthClient_";
  protected final String TEXT_9 = ".setClientID(";
  protected final String TEXT_10 = ");" + NL + "\t\toauthClient_";
  protected final String TEXT_11 = ".setClientSecret(";
  protected final String TEXT_12 = ");" + NL + "\t\tString refreshToken_";
  protected final String TEXT_13 = " = null;" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\tString tokenFile_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\t\t\tif(tokenFile_";
  protected final String TEXT_17 = " != null){" + NL + "\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_18 = " = new java.util.Properties();" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_19 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_21 = ".load(inputStream_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\tinputStream_";
  protected final String TEXT_23 = ".close();" + NL + "\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_24 = "){" + NL + "\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_25 = "){" + NL + "\t\t\t\t}" + NL + "\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_26 = " = (String) properties_";
  protected final String TEXT_27 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t" + NL + "\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t// access token." + NL + "\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_28 = " != null){" + NL + "\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\ttoken_";
  protected final String TEXT_29 = " = oauthClient_";
  protected final String TEXT_30 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\tendpointURL_";
  protected final String TEXT_32 = " = oauthClient_";
  protected final String TEXT_33 = ".getBulkEndpoint(token_";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t\taccessToken_";
  protected final String TEXT_36 = " = token_";
  protected final String TEXT_37 = ".getAccess_token();" + NL + "\t\t\t\t\trefreshToken_";
  protected final String TEXT_38 = " = token_";
  protected final String TEXT_39 = ".getRefresh_token();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\tif(accessToken_";
  protected final String TEXT_41 = " == null || endpointURL_";
  protected final String TEXT_42 = " == null){" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\toauthClient_";
  protected final String TEXT_44 = ".setCallbackHost(";
  protected final String TEXT_45 = ");" + NL + "\t\t\toauthClient_";
  protected final String TEXT_46 = ".setCallbackPort(";
  protected final String TEXT_47 = ");" + NL + "\t\t\ttoken_";
  protected final String TEXT_48 = " = oauthClient_";
  protected final String TEXT_49 = ".getToken();" + NL + "\t\t\tendpointURL_";
  protected final String TEXT_50 = " = oauthClient_";
  protected final String TEXT_51 = ".getBulkEndpoint(token_";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");" + NL + "\t\t\taccessToken_";
  protected final String TEXT_54 = " = token_";
  protected final String TEXT_55 = ".getAccess_token();" + NL + "\t\t\trefreshToken_";
  protected final String TEXT_56 = " = token_";
  protected final String TEXT_57 = ".getRefresh_token();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t\tif(tokenFile_";
  protected final String TEXT_59 = " != null && refreshToken_";
  protected final String TEXT_60 = " != null){" + NL + "\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_61 = " = new java.util.Properties();" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_62 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_64 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_66 = ".store(outputStream_";
  protected final String TEXT_67 = ", null);" + NL + "\t\t\t\tif(outputStream_";
  protected final String TEXT_68 = " != null){" + NL + "\t\t\t\t    outputStream_";
  protected final String TEXT_69 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\tint nb_line_";
  protected final String TEXT_71 = " = 0;" + NL + "    int nb_success_";
  protected final String TEXT_72 = " = 0;" + NL + "    int nb_reject_";
  protected final String TEXT_73 = " = 0;" + NL + "\t" + NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_74 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\tsforceBulk_";
  protected final String TEXT_75 = ".setConcurrencyMode(\"";
  protected final String TEXT_76 = "\");" + NL + "\tsforceBulk_";
  protected final String TEXT_77 = ".setAwaitTime(";
  protected final String TEXT_78 = ");" + NL + "\t";
  protected final String TEXT_79 = NL + "\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_80 = "\")==null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_81 = "\");" + NL + "\t\t}" + NL + "\t\tsforceBulk_";
  protected final String TEXT_82 = ".login((com.sforce.async.BulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_83 = "\"));" + NL + "\t";
  protected final String TEXT_84 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_85 = ".login(accessToken_";
  protected final String TEXT_86 = ", endpointURL_";
  protected final String TEXT_87 = ");" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\tsforceBulk_";
  protected final String TEXT_89 = ".setProxy(true,";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_95 = ".login(";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ",";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ");" + NL + "\t\t";
  protected final String TEXT_100 = NL + NL + NL + "\tsforceBulk_";
  protected final String TEXT_101 = ".executeBulk(";
  protected final String TEXT_102 = ",\"";
  protected final String TEXT_103 = "\",";
  protected final String TEXT_104 = ",\"";
  protected final String TEXT_105 = "\",";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = ",";
  protected final String TEXT_108 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_109 = NL + "\t\t\tint j_";
  protected final String TEXT_110 = "=0;" + NL + "\t\t\tint batchCount_";
  protected final String TEXT_111 = " = sforceBulk_";
  protected final String TEXT_112 = ".getBatchCount();" + NL + "\t\t\tfor(int i = 0; i < batchCount_";
  protected final String TEXT_113 = "; i++){" + NL + "\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_114 = " = sforceBulk_";
  protected final String TEXT_115 = ".getBatchLog(i);" + NL + "\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_116 = " : resultListMessage_";
  protected final String TEXT_117 = "){" + NL + "\t\t\t\t\tj_";
  protected final String TEXT_118 = "++;" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_120 = " = null;\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = "\t" + NL + "\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_122 = ".get(\"Success\"))){" + NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\tnb_success_";
  protected final String TEXT_124 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = " = new ";
  protected final String TEXT_126 = "Struct();" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = ".salesforce_created = resultMessage_";
  protected final String TEXT_128 = ".get(\"Created\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_129 = ".salesforce_id = resultMessage_";
  protected final String TEXT_130 = ".get(\"Id\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_131 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_132 = ".get(\"";
  protected final String TEXT_133 = "\")))){" + NL + "\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_134 = ".put(\"";
  protected final String TEXT_135 = "\",null);" + NL + "\t\t\t\t        \t}" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_136 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " = resultMessage_";
  protected final String TEXT_139 = ".get(\"";
  protected final String TEXT_140 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_144 = ".get(\"";
  protected final String TEXT_145 = "\"), ";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_147 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = ParserUtils.parseTo_";
  protected final String TEXT_150 = "(resultMessage_";
  protected final String TEXT_151 = ".get(\"";
  protected final String TEXT_152 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = " = ParserUtils.parseTo_";
  protected final String TEXT_156 = "(resultMessage_";
  protected final String TEXT_157 = ".get(\"";
  protected final String TEXT_158 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t           \t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\tnb_reject_";
  protected final String TEXT_162 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = " = new ";
  protected final String TEXT_164 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_165 = ".error = resultMessage_";
  protected final String TEXT_166 = ".get(\"Error\");" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_168 = ".get(\"";
  protected final String TEXT_169 = "\")))){" + NL + "\t\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_170 = ".put(\"";
  protected final String TEXT_171 = "\",null);" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_172 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " = resultMessage_";
  protected final String TEXT_175 = ".get(\"";
  protected final String TEXT_176 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_180 = ".get(\"";
  protected final String TEXT_181 = "\"), ";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_183 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = " = ParserUtils.parseTo_";
  protected final String TEXT_186 = "(resultMessage_";
  protected final String TEXT_187 = ".get(\"";
  protected final String TEXT_188 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = " = ParserUtils.parseTo_";
  protected final String TEXT_192 = "(resultMessage_";
  protected final String TEXT_193 = ".get(\"";
  protected final String TEXT_194 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\tSystem.err.print(\"Row \"+j_";
  protected final String TEXT_197 = "+\":\"+resultMessage_";
  protected final String TEXT_198 = ".get(\"Error\"));" + NL + "\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_200 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String apiVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");
	
	String sObject = ElementParameterParser.getValue(node, "__MODULENAME__");
	String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	if ("CustomModule".equals(sObject)) {
		//modulename = customModulename; 
		sObject = customModulename;
	}else{
		sObject = "\""+sObject+"\"";
	}
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String externalId = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
	//String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
	String contentType = "csv";
	String bulkFileName = ElementParameterParser.getValue(node, "__BULKFILENAME__").trim();
	
	String maxBytes = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_BYTES__");
	String maxRows = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_ROWS__");
	
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	
	String concurrencyMode = ElementParameterParser.getValue(node,"__CONCURRENCY_MODE__");
	String awaitTime = ElementParameterParser.getValue(node,"__AWAIT_TIME__");
	
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	if(useOAuth){
		String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(oauthSecret);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
		if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tokenFile);
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
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
		}
		
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
			String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(callbackPort);
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
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
		if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		}
	}
	
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(concurrencyMode);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(awaitTime);
    stringBuffer.append(TEXT_78);
    
	if(useExistingConn){
	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_83);
    
	}else{
		if(useOAuth){
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
		}else{
			if(useProxy){
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_93);
    
			}
			
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_99);
    
		}
	}
	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(externalId);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(bulkFileName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(maxBytes);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_108);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
		
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
     
			List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
			if(outgoingConns!=null){
				for (int i=0;i<outgoingConns.size();i++) {
			    IConnection outgoingConn = outgoingConns.get(i);
			    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_120);
    
			    	}
			    }
			}
    	
			List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
			List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
			
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
				if (connsSuccess != null && connsSuccess.size() == 1) {
					IConnection connSuccess = connsSuccess.get(0);
					if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_136);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    
					        }else if(javaType == JavaTypesManager.DATE){
					        
    stringBuffer.append(TEXT_141);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_146);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_147);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    
					        }else { 
							
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    
							}
							
    stringBuffer.append(TEXT_159);
    					 
						}
					}
				}
				
    stringBuffer.append(TEXT_160);
    
				if (connsReject != null && connsReject.size() == 1) {
					IConnection connReject = connsReject.get(0);
					if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_172);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    
					        }else if(javaType == JavaTypesManager.DATE && pattern != null){
					        
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_182);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_188);
    
					        }else { 
							
    stringBuffer.append(TEXT_189);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_194);
    
							}
							
    stringBuffer.append(TEXT_195);
    					 
						}
					}
				}else{
				
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
				}
		}//2
	}//1
	
    stringBuffer.append(TEXT_199);
    stringBuffer.append(TEXT_200);
    return stringBuffer.toString();
  }
}
