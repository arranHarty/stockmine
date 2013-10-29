package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSalesforceConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceConnectionBeginJava result = new TSalesforceConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_2 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_3 = ";" + NL + "\tString endpointURL_";
  protected final String TEXT_4 = " = null;" + NL + "\tString accessToken_";
  protected final String TEXT_5 = " = null;" + NL + "\toauthClient_";
  protected final String TEXT_6 = ".setBaseOAuthURL(";
  protected final String TEXT_7 = ");" + NL + "\toauthClient_";
  protected final String TEXT_8 = ".setClientID(";
  protected final String TEXT_9 = ");" + NL + "\toauthClient_";
  protected final String TEXT_10 = ".setClientSecret(";
  protected final String TEXT_11 = ");" + NL + "\tString refreshToken_";
  protected final String TEXT_12 = " = null;" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t// Attempt to load existing refresh token" + NL + "\t\tString tokenFile_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "\t\tif(tokenFile_";
  protected final String TEXT_16 = " != null){" + NL + "\t\t\tjava.util.Properties properties_";
  protected final String TEXT_17 = " = new java.util.Properties();" + NL + "\t\t\ttry{" + NL + "\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_18 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_20 = ".load(inputStream_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_22 = ".close();" + NL + "\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_23 = "){" + NL + "\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_24 = "){" + NL + "\t\t\t}" + NL + "\t\t\tString storedRefreshToken_";
  protected final String TEXT_25 = " = (String) properties_";
  protected final String TEXT_26 = ".get(\"refreshtoken\");" + NL + "\t\t\t" + NL + "\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t// access token." + NL + "\t\t\tif(storedRefreshToken_";
  protected final String TEXT_27 = " != null){" + NL + "\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\ttoken_";
  protected final String TEXT_28 = " = oauthClient_";
  protected final String TEXT_29 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\tendpointURL_";
  protected final String TEXT_32 = " = oauthClient_";
  protected final String TEXT_33 = ".getBulkEndpoint(token_";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tendpointURL_";
  protected final String TEXT_37 = " = oauthClient_";
  protected final String TEXT_38 = ".getSOAPEndpoint(token_";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\taccessToken_";
  protected final String TEXT_42 = " = token_";
  protected final String TEXT_43 = ".getAccess_token();" + NL + "\t\t\t\trefreshToken_";
  protected final String TEXT_44 = " = token_";
  protected final String TEXT_45 = ".getRefresh_token();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_46 = NL + "\tif(accessToken_";
  protected final String TEXT_47 = " == null || endpointURL_";
  protected final String TEXT_48 = " == null){" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\toauthClient_";
  protected final String TEXT_50 = ".setCallbackHost(";
  protected final String TEXT_51 = ");" + NL + "\t\toauthClient_";
  protected final String TEXT_52 = ".setCallbackPort(";
  protected final String TEXT_53 = ");" + NL + "\t\ttoken_";
  protected final String TEXT_54 = " = oauthClient_";
  protected final String TEXT_55 = ".getToken();" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\tendpointURL_";
  protected final String TEXT_57 = " = oauthClient_";
  protected final String TEXT_58 = ".getBulkEndpoint(token_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ");" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tendpointURL_";
  protected final String TEXT_62 = " = oauthClient_";
  protected final String TEXT_63 = ".getSOAPEndpoint(token_";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\taccessToken_";
  protected final String TEXT_67 = " = token_";
  protected final String TEXT_68 = ".getAccess_token();" + NL + "\t\trefreshToken_";
  protected final String TEXT_69 = " = token_";
  protected final String TEXT_70 = ".getRefresh_token();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_71 = NL + "\t\tif(tokenFile_";
  protected final String TEXT_72 = " != null && refreshToken_";
  protected final String TEXT_73 = " != null){" + NL + "\t\t\t// Store the refresh token for future use." + NL + "\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_74 = " = new java.util.Properties();" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_75 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_76 = ");" + NL + "\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_77 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_78 = ");" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_79 = ".store(outputStream_";
  protected final String TEXT_80 = ", null);" + NL + "\t\t\tif(outputStream_";
  protected final String TEXT_81 = " != null){" + NL + "\t\t\t    outputStream_";
  protected final String TEXT_82 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_83 = NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_84 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\tsforceBulk_";
  protected final String TEXT_85 = ".setNeedCompression(";
  protected final String TEXT_86 = ");" + NL + "\tsforceBulk_";
  protected final String TEXT_87 = ".setNeedTraceMessage(";
  protected final String TEXT_88 = ");" + NL + "\t";
  protected final String TEXT_89 = NL + "\t\tsforceBulk_";
  protected final String TEXT_90 = ".login(accessToken_";
  protected final String TEXT_91 = ", endpointURL_";
  protected final String TEXT_92 = ");" + NL + "\t";
  protected final String TEXT_93 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_94 = ".setProxy(true,";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ",";
  protected final String TEXT_98 = ");" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\tsforceBulk_";
  protected final String TEXT_100 = ".login(";
  protected final String TEXT_101 = ",";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = ",";
  protected final String TEXT_104 = ");" + NL + "\t";
  protected final String TEXT_105 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_106 = "\", sforceBulk_";
  protected final String TEXT_107 = ".getConnection());";
  protected final String TEXT_108 = NL + "\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_109 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\tsfMgr_";
  protected final String TEXT_111 = ".setClientID(";
  protected final String TEXT_112 = ");" + NL + "\t\tglobalMap.put(\"callOptions_";
  protected final String TEXT_113 = "\", sfMgr_";
  protected final String TEXT_114 = ".getCallOptions());" + NL + "\t";
  protected final String TEXT_115 = NL + "\t\tboolean result_";
  protected final String TEXT_116 = " = sfMgr_";
  protected final String TEXT_117 = ".login(accessToken_";
  protected final String TEXT_118 = ", endpointURL_";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ",";
  protected final String TEXT_121 = ");" + NL + "\t\tif(!result_";
  protected final String TEXT_122 = "){" + NL + "\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_123 = NL + "\t\t    java.util.Properties props_";
  protected final String TEXT_124 = " = System.getProperties();" + NL + "\t\t    props_";
  protected final String TEXT_125 = ".put(\"socksProxyHost\",";
  protected final String TEXT_126 = ");  " + NL + "\t\t    props_";
  protected final String TEXT_127 = ".put(\"socksProxyPort\",";
  protected final String TEXT_128 = ");" + NL + "\t\t    props_";
  protected final String TEXT_129 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_130 = ");" + NL + "\t\t    props_";
  protected final String TEXT_131 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_132 = "); " + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\tboolean result_";
  protected final String TEXT_134 = " = sfMgr_";
  protected final String TEXT_135 = ".login(";
  protected final String TEXT_136 = ",";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = ",";
  protected final String TEXT_139 = ",";
  protected final String TEXT_140 = ");" + NL + "\t\tif(!result_";
  protected final String TEXT_141 = "){" + NL + "\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_142 = NL + "\tglobalMap.put(\"stub_";
  protected final String TEXT_143 = "\", sfMgr_";
  protected final String TEXT_144 = ".getStub());" + NL + "\tglobalMap.put(\"sessionHeader_";
  protected final String TEXT_145 = "\", sfMgr_";
  protected final String TEXT_146 = ".getSessionHeader());";
  protected final String TEXT_147 = "\t\t\t" + NL + "\t\t\t" + NL;
  protected final String TEXT_148 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
String username = ElementParameterParser.getValue(node, "__USER__");
String password = ElementParameterParser.getValue(node, "__PASS__");
String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
boolean httpTraceMessage = ("true").equals(ElementParameterParser.getValue(node,"__HTTP_TRACEMESSAGE__"));

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

boolean bulkConnection = ("true").equals(ElementParameterParser.getValue(node,"__BULK_CONNECTION__"));
String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");

String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
boolean useOAuth = "OAUTH".equals(loginType);
if(useOAuth){
	String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
	String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(oauthSecret);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
	if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(tokenFile);
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
    
				if(bulkConnection){
				
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_35);
    
				}else{
				
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(apiVersion);
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
    
	}
	
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		if(bulkConnection){
		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_60);
    
		}else{
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_65);
    
		}
		
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
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
    
	}
}
if(bulkConnection){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(httpTraceMessage);
    stringBuffer.append(TEXT_88);
    
	if(useOAuth){
	
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	}else{
		if(useProxy){
		
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_98);
    
		}
		
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_104);
    
	}
	
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
}else{

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
	}
	if(useOAuth){
	
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	}else{
		if(useProxy){
		
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_132);
    
		}
		
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	}
	
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    return stringBuffer.toString();
  }
}
