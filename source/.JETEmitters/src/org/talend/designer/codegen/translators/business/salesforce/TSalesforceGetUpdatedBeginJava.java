package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSalesforceGetUpdatedBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceGetUpdatedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetUpdatedBeginJava result = new TSalesforceGetUpdatedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL;
  protected final String TEXT_4 = NL + "\t\t\t\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_5 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\t\t\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_6 = ";" + NL + "\t\t\t\t\tString endpointURL_";
  protected final String TEXT_7 = " = null;" + NL + "\t\t\t\t\tString accessToken_";
  protected final String TEXT_8 = " = null;" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_9 = ".setBaseOAuthURL(";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_11 = ".setClientID(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_13 = ".setClientSecret(";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\t\tString refreshToken_";
  protected final String TEXT_15 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\t\t\t\tString tokenFile_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_19 = " != null){" + NL + "\t\t\t\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_20 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_21 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t\t\t\tproperties_";
  protected final String TEXT_23 = ".load(inputStream_";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\t\t\t\t\tinputStream_";
  protected final String TEXT_25 = ".close();" + NL + "\t\t\t\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_26 = "){" + NL + "\t\t\t\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_27 = "){" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_28 = " = (String) properties_";
  protected final String TEXT_29 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t\t\t\t// access token." + NL + "\t\t\t\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_30 = " != null){" + NL + "\t\t\t\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\t\t\t\ttoken_";
  protected final String TEXT_31 = " = oauthClient_";
  protected final String TEXT_32 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_34 = " = oauthClient_";
  protected final String TEXT_35 = ".getSOAPEndpoint(token_";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t\t\t\t\taccessToken_";
  protected final String TEXT_38 = " = token_";
  protected final String TEXT_39 = ".getAccess_token();" + NL + "\t\t\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_40 = " = token_";
  protected final String TEXT_41 = ".getRefresh_token();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\tif(accessToken_";
  protected final String TEXT_43 = " == null || endpointURL_";
  protected final String TEXT_44 = " == null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_46 = ".setCallbackHost(";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_48 = ".setCallbackPort(";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t\t\ttoken_";
  protected final String TEXT_50 = " = oauthClient_";
  protected final String TEXT_51 = ".getToken();" + NL + "\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_52 = " = oauthClient_";
  protected final String TEXT_53 = ".getSOAPEndpoint(token_";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t\taccessToken_";
  protected final String TEXT_56 = " = token_";
  protected final String TEXT_57 = ".getAccess_token();" + NL + "\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_58 = " = token_";
  protected final String TEXT_59 = ".getRefresh_token();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_61 = " != null && refreshToken_";
  protected final String TEXT_62 = " != null){" + NL + "\t\t\t\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_63 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_64 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_66 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_67 = ");" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_68 = ".store(outputStream_";
  protected final String TEXT_69 = ", null);" + NL + "\t\t\t\t\t\t\tif(outputStream_";
  protected final String TEXT_70 = " != null){" + NL + "\t\t\t\t\t\t\t    outputStream_";
  protected final String TEXT_71 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_73 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t    java.text.SimpleDateFormat enddf_";
  protected final String TEXT_74 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t" + NL + "\t\t\tstartdf_";
  protected final String TEXT_75 = ".parse(";
  protected final String TEXT_76 = ");" + NL + "\t\t    enddf_";
  protected final String TEXT_77 = ".parse(";
  protected final String TEXT_78 = ");" + NL + "\t\t    " + NL + "\t\t    java.util.Calendar startCal_";
  protected final String TEXT_79 = " = startdf_";
  protected final String TEXT_80 = ".getCalendar();" + NL + "\t\t    java.util.Calendar endCal_";
  protected final String TEXT_81 = " = enddf_";
  protected final String TEXT_82 = ".getCalendar();" + NL + "\t\t\t" + NL + "\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_83 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\tif(globalMap.get(\"stub_";
  protected final String TEXT_85 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_86 = "\")==null){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_87 = "\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(globalMap.get(\"callOptions_";
  protected final String TEXT_88 = "\")!=null ){" + NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_89 = ".setCallOptions((com.salesforce.soap.partner.CallOptions)globalMap.get(\"callOptions_";
  protected final String TEXT_90 = "\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsfMgr_";
  protected final String TEXT_91 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_92 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_93 = "\"));" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_96 = ".setClientID(";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_99 = " = sfMgr_";
  protected final String TEXT_100 = ".login(accessToken_";
  protected final String TEXT_101 = ", endpointURL_";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = ",";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_105 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_107 = " = System.getProperties();" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_108 = ".put(\"socksProxyHost\",";
  protected final String TEXT_109 = ");  " + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_110 = ".put(\"socksProxyPort\",";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_112 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_113 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_114 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_115 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_117 = " = sfMgr_";
  protected final String TEXT_118 = ".login(";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = ",";
  protected final String TEXT_122 = ",";
  protected final String TEXT_123 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_124 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_125 = "\t\t\t\t" + NL + "" + NL + "\tcom.salesforce.soap.partner.sobject.SObject[] so_";
  protected final String TEXT_126 = " = null;" + NL + "\tcom.salesforce.soap.partner.ID[] ids_";
  protected final String TEXT_127 = " = sfMgr_";
  protected final String TEXT_128 = ".getUpdated(";
  protected final String TEXT_129 = ", startCal_";
  protected final String TEXT_130 = ", endCal_";
  protected final String TEXT_131 = ");" + NL + "\t" + NL + "\tif(ids_";
  protected final String TEXT_132 = " !=null && ids_";
  protected final String TEXT_133 = ".length > 0){" + NL + "\t\t\t\t\t\t" + NL + "\t\tint newMax_";
  protected final String TEXT_134 = " = 0;" + NL + "\t\tint newBase_";
  protected final String TEXT_135 = " = 0;" + NL + "\t\t" + NL + "\t\twhile (newMax_";
  protected final String TEXT_136 = " < ids_";
  protected final String TEXT_137 = ".length){" + NL + "\t\t" + NL + "\t\t\tnewBase_";
  protected final String TEXT_138 = " = newMax_";
  protected final String TEXT_139 = ";" + NL + "\t\t\tnewMax_";
  protected final String TEXT_140 = " += 2000;" + NL + "\t\t\t" + NL + "\t\t\tif (newMax_";
  protected final String TEXT_141 = " > ids_";
  protected final String TEXT_142 = ".length){" + NL + "\t\t\t\tnewMax_";
  protected final String TEXT_143 = " = ids_";
  protected final String TEXT_144 = ".length;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tcom.salesforce.soap.partner.ID[] localIds_";
  protected final String TEXT_145 = " = new com.salesforce.soap.partner.ID[newMax_";
  protected final String TEXT_146 = "-newBase_";
  protected final String TEXT_147 = "];" + NL + "" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_148 = "=newBase_";
  protected final String TEXT_149 = ";i_";
  protected final String TEXT_150 = " < newMax_";
  protected final String TEXT_151 = ";i_";
  protected final String TEXT_152 = "++){" + NL + "\t\t\t\tlocalIds_";
  protected final String TEXT_153 = "[i_";
  protected final String TEXT_154 = "-newBase_";
  protected final String TEXT_155 = "] = ids_";
  protected final String TEXT_156 = "[i_";
  protected final String TEXT_157 = "];" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tso_";
  protected final String TEXT_158 = " = sfMgr_";
  protected final String TEXT_159 = ".retrieve(localIds_";
  protected final String TEXT_160 = ",";
  protected final String TEXT_161 = ",\"";
  protected final String TEXT_162 = "\");" + NL + "    \t\t" + NL + "    \t\tif(so_";
  protected final String TEXT_163 = " != null){" + NL + "    \t\t" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_164 = "=0;i_";
  protected final String TEXT_165 = "<so_";
  protected final String TEXT_166 = ".length;i_";
  protected final String TEXT_167 = "++){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_168 = " ++;" + NL + "\t\t\t\t" + NL + "\t\t\t  if(so_";
  protected final String TEXT_169 = "[i_";
  protected final String TEXT_170 = "]!=null){" + NL + "\t\t\t\torg.apache.axiom.om.OMElement[] fields_";
  protected final String TEXT_171 = " = so_";
  protected final String TEXT_172 = "[i_";
  protected final String TEXT_173 = "].getExtraElement();" + NL + "\t\t\t\tint len_";
  protected final String TEXT_174 = " = fields_";
  protected final String TEXT_175 = ".length;";
  protected final String TEXT_176 = "\t\t\t\t\t\t" + NL + "\t\t\t\t    if (";
  protected final String TEXT_177 = " < len_";
  protected final String TEXT_178 = " &&  fields_";
  protected final String TEXT_179 = "[";
  protected final String TEXT_180 = "]!=null && fields_";
  protected final String TEXT_181 = "[";
  protected final String TEXT_182 = "].getText() != null && !\"\".equals(fields_";
  protected final String TEXT_183 = "[";
  protected final String TEXT_184 = "].getText())){";
  protected final String TEXT_185 = NL + "\t\t\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = fields_";
  protected final String TEXT_188 = "[";
  protected final String TEXT_189 = "].getText();";
  protected final String TEXT_190 = NL + "\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = ParserUtils.parseTo_Date(fields_";
  protected final String TEXT_193 = "[";
  protected final String TEXT_194 = "].getText(), ";
  protected final String TEXT_195 = ");";
  protected final String TEXT_196 = NL + "\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = fields_";
  protected final String TEXT_199 = "[";
  protected final String TEXT_200 = "].getText().getBytes();";
  protected final String TEXT_201 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = ParserUtils.parseTo_";
  protected final String TEXT_204 = "(fields_";
  protected final String TEXT_205 = "[";
  protected final String TEXT_206 = "].getText());";
  protected final String TEXT_207 = "\t\t\t" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = ";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_211 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
   	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));

String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns(); 
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		if (outgoingConns != null && outgoingConns.size() > 0){
			
			String sd = ElementParameterParser.getValue(node, "__START_DATE__");
			String ed = ElementParameterParser.getValue(node, "__END_DATE__");

			String username = ElementParameterParser.getValue(node, "__USER__");
			String password = ElementParameterParser.getValue(node, "__PASS__");
			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String module = ElementParameterParser.getValue(node, "__MODULENAME__");
			String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__").trim();
			module = (("CustomModule").equals(module)) ? customModulename : "\""+module+"\"";
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
			
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);
			if(!useExistingConn){
				if(useOAuth){
					String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
					String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
					String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
					
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(oauthSecret);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
					String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tokenFile);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
					}
					
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
						String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
						String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
						
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(callbackPort);
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
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
					}
				}
			}		
			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sd);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ed);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    if(useExistingConn){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_93);
    }else{
    stringBuffer.append(TEXT_94);
    if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_97);
    
				}
				if(useOAuth){
				
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
				}else{
					if(useProxy){
					
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_115);
    
					}
					
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
				}
			}
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (IMetadataColumn column: columnList){
				if(sb.length() == 0){
					sb.append(column.getLabel());
				}else{
					sb.append(","+column.getLabel());
				}
			}
			
			String fieldlist = sb.toString();
			
			IConnection outgoingConn = outgoingConns.get(0);
			
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(module );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(fieldlist );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
     
						for( int i = 0; i < columnList.size(); i++) {
						
							IMetadataColumn column = columnList.get(i);
							
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_176);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_184);
    
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object

    stringBuffer.append(TEXT_185);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_189);
    
									} else if(javaType == JavaTypesManager.DATE) { // Date

    stringBuffer.append(TEXT_190);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_195);
    
									} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]

    stringBuffer.append(TEXT_196);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
    
									} else  { // other

    stringBuffer.append(TEXT_201);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
     
									}

    stringBuffer.append(TEXT_207);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_210);
     
						}
			}
		
		}
	}
}

    stringBuffer.append(TEXT_211);
    return stringBuffer.toString();
  }
}
