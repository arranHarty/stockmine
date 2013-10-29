package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSalesforceOutputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBeginJava result = new TSalesforceOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_2 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_3 = ";" + NL + "\t\t\tString endpointURL_";
  protected final String TEXT_4 = " = null;" + NL + "\t\t\tString accessToken_";
  protected final String TEXT_5 = " = null;" + NL + "\t\t\toauthClient_";
  protected final String TEXT_6 = ".setBaseOAuthURL(";
  protected final String TEXT_7 = ");" + NL + "\t\t\toauthClient_";
  protected final String TEXT_8 = ".setClientID(";
  protected final String TEXT_9 = ");" + NL + "\t\t\toauthClient_";
  protected final String TEXT_10 = ".setClientSecret(";
  protected final String TEXT_11 = ");" + NL + "\t\t\tString refreshToken_";
  protected final String TEXT_12 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\t\tString tokenFile_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "\t\t\t\tif(tokenFile_";
  protected final String TEXT_16 = " != null){" + NL + "\t\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_17 = " = new java.util.Properties();" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_18 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t\t\tproperties_";
  protected final String TEXT_20 = ".load(inputStream_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\t\tinputStream_";
  protected final String TEXT_22 = ".close();" + NL + "\t\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_23 = "){" + NL + "\t\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_24 = "){" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_25 = " = (String) properties_";
  protected final String TEXT_26 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t\t// access token." + NL + "\t\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_27 = " != null){" + NL + "\t\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\t\ttoken_";
  protected final String TEXT_28 = " = oauthClient_";
  protected final String TEXT_29 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_31 = " = oauthClient_";
  protected final String TEXT_32 = ".getSOAPEndpoint(token_";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");" + NL + "\t\t\t\t\t\taccessToken_";
  protected final String TEXT_35 = " = token_";
  protected final String TEXT_36 = ".getAccess_token();" + NL + "\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_37 = " = token_";
  protected final String TEXT_38 = ".getRefresh_token();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\tif(accessToken_";
  protected final String TEXT_40 = " == null || endpointURL_";
  protected final String TEXT_41 = " == null){" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\toauthClient_";
  protected final String TEXT_43 = ".setCallbackHost(";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\toauthClient_";
  protected final String TEXT_45 = ".setCallbackPort(";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\ttoken_";
  protected final String TEXT_47 = " = oauthClient_";
  protected final String TEXT_48 = ".getToken();" + NL + "\t\t\t\tendpointURL_";
  protected final String TEXT_49 = " = oauthClient_";
  protected final String TEXT_50 = ".getSOAPEndpoint(token_";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\taccessToken_";
  protected final String TEXT_53 = " = token_";
  protected final String TEXT_54 = ".getAccess_token();" + NL + "\t\t\t\trefreshToken_";
  protected final String TEXT_55 = " = token_";
  protected final String TEXT_56 = ".getRefresh_token();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tif(tokenFile_";
  protected final String TEXT_58 = " != null && refreshToken_";
  protected final String TEXT_59 = " != null){" + NL + "\t\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_60 = " = new java.util.Properties();" + NL + "\t\t\t\t\tstoreProperties_";
  protected final String TEXT_61 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_63 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\tstoreProperties_";
  protected final String TEXT_65 = ".store(outputStream_";
  protected final String TEXT_66 = ", null);" + NL + "\t\t\t\t\tif(outputStream_";
  protected final String TEXT_67 = " != null){" + NL + "\t\t\t\t\t    outputStream_";
  protected final String TEXT_68 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_69 = "       " + NL + "        int nb_line_";
  protected final String TEXT_70 = " = 0;" + NL + "        int nb_success_";
  protected final String TEXT_71 = " = 0;" + NL + "        int nb_reject_";
  protected final String TEXT_72 = " = 0;" + NL + "        System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "        org.talend.salesforce.SforceManagement sforceManagement_";
  protected final String TEXT_73 = " = new org.talend.salesforce.SforceManagementImpl();";
  protected final String TEXT_74 = NL + "\t        if(globalMap.get(\"stub_";
  protected final String TEXT_75 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_76 = "\")==null){" + NL + "\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_77 = "\");" + NL + "\t\t\t}" + NL + "\t\t\tif(globalMap.get(\"callOptions_";
  protected final String TEXT_78 = "\")!=null ){" + NL + "\t\t\t\tsforceManagement_";
  protected final String TEXT_79 = ".setCallOptions((com.salesforce.soap.partner.CallOptions)globalMap.get(\"callOptions_";
  protected final String TEXT_80 = "\"));" + NL + "\t\t\t}" + NL + "\t\t\tsforceManagement_";
  protected final String TEXT_81 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_82 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_83 = "\"), ";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ");\t" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\tsforceManagement_";
  protected final String TEXT_88 = ".setClientID(";
  protected final String TEXT_89 = ");" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tboolean result_";
  protected final String TEXT_91 = " = sforceManagement_";
  protected final String TEXT_92 = ".login(accessToken_";
  protected final String TEXT_93 = ", endpointURL_";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\tif(!result_";
  protected final String TEXT_97 = "){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "\t\t        boolean result_";
  protected final String TEXT_99 = " = sforceManagement_";
  protected final String TEXT_100 = ".login(";
  protected final String TEXT_101 = ",";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ",";
  protected final String TEXT_104 = ",";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ", ";
  protected final String TEXT_108 = ");" + NL + "\t\t        if(!result_";
  protected final String TEXT_109 = "){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t\t\t}" + NL + "        \t";
  protected final String TEXT_110 = NL + "        ";
  protected final String TEXT_111 = NL + " \t\t\torg.apache.axiom.om.OMFactory fac_";
  protected final String TEXT_112 = " = org.apache.axiom.om.OMAbstractFactory.getOMFactory();       ";
  protected final String TEXT_113 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String commitLevel = ElementParameterParser.getValue(node, "__COMMIT_LEVEL__");
	boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
	String logFile = ElementParameterParser.getValue(node, "__LOGFILENAME__").trim();
	boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));
	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
	String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	// if the extended insert is disabled set the commit level to 1
	if (!extendedInsert) commitLevel = "1";
	
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	if(!useExistingConn){
		if(useOAuth){
			String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			}
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
				String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
				String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(callbackPort);
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
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
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
    
			}
		}
	}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
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
    stringBuffer.append(commitLevel);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ceaseForError );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(logFile );
    stringBuffer.append(TEXT_86);
    
		}else{
			if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
			
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_89);
    
			}
			if(useOAuth){
			
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
			}else{
			
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(commitLevel);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ceaseForError );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(logFile );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
        	}
        }
        
    stringBuffer.append(TEXT_110);
    if("upsert".equals(action)){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}
