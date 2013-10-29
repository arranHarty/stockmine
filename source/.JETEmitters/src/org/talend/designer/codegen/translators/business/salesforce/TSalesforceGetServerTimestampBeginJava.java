package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TSalesforceGetServerTimestampBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceGetServerTimestampBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetServerTimestampBeginJava result = new TSalesforceGetServerTimestampBeginJava();
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
  protected final String TEXT_72 = NL + "\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_73 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tif(globalMap.get(\"stub_";
  protected final String TEXT_75 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_76 = "\")==null){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_77 = "\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(globalMap.get(\"callOptions_";
  protected final String TEXT_78 = "\")!=null ){" + NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_79 = ".setCallOptions((com.salesforce.soap.partner.CallOptions)globalMap.get(\"callOptions_";
  protected final String TEXT_80 = "\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsfMgr_";
  protected final String TEXT_81 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_82 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_83 = "\"));" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_86 = ".setClientID(";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_89 = " = sfMgr_";
  protected final String TEXT_90 = ".login(accessToken_";
  protected final String TEXT_91 = ", endpointURL_";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_95 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_97 = " = System.getProperties();" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_98 = ".put(\"socksProxyHost\",";
  protected final String TEXT_99 = ");  " + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_100 = ".put(\"socksProxyPort\",";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_102 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_104 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_105 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_107 = " = sfMgr_";
  protected final String TEXT_108 = ".login(";
  protected final String TEXT_109 = ",";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = ",";
  protected final String TEXT_112 = ",";
  protected final String TEXT_113 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_114 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = NL;

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
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		if (outgoingConns != null && outgoingConns.size() > 0){
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			String username = ElementParameterParser.getValue(node, "__USER__");
			String password = ElementParameterParser.getValue(node, "__PASS__");
			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
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
    if(useExistingConn){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_83);
    }else{
    stringBuffer.append(TEXT_84);
    if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_87);
    
				}
				if(useOAuth){
				
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				}else{
					if(useProxy){
					
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_105);
    
					}
					
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
				}
				
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    
		}
	}
}

    stringBuffer.append(TEXT_117);
    return stringBuffer.toString();
  }
}
