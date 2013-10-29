package org.talend.designer.codegen.translators.business.salesforce;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSalesforceInputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceInputBeginJava result = new TSalesforceInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "int limit_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_5 = NL + "\t\t\t\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_6 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\t\t\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_7 = ";" + NL + "\t\t\t\t\tString endpointURL_";
  protected final String TEXT_8 = " = null;" + NL + "\t\t\t\t\tString accessToken_";
  protected final String TEXT_9 = " = null;" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_10 = ".setBaseOAuthURL(";
  protected final String TEXT_11 = ");" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_12 = ".setClientID(";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_14 = ".setClientSecret(";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\tString refreshToken_";
  protected final String TEXT_16 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\t\t\t\tString tokenFile_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";" + NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_20 = " != null){" + NL + "\t\t\t\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_21 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_22 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\t\t\t\tproperties_";
  protected final String TEXT_24 = ".load(inputStream_";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t\t\t\t\tinputStream_";
  protected final String TEXT_26 = ".close();" + NL + "\t\t\t\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_27 = "){" + NL + "\t\t\t\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_28 = "){" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_29 = " = (String) properties_";
  protected final String TEXT_30 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t\t\t\t// access token." + NL + "\t\t\t\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_31 = " != null){" + NL + "\t\t\t\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\t\t\t\ttoken_";
  protected final String TEXT_32 = " = oauthClient_";
  protected final String TEXT_33 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_34 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_36 = " = oauthClient_";
  protected final String TEXT_37 = ".getSOAPEndpoint(token_";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_41 = " = oauthClient_";
  protected final String TEXT_42 = ".getBulkEndpoint(token_";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\taccessToken_";
  protected final String TEXT_46 = " = token_";
  protected final String TEXT_47 = ".getAccess_token();" + NL + "\t\t\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_48 = " = token_";
  protected final String TEXT_49 = ".getRefresh_token();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tif(accessToken_";
  protected final String TEXT_51 = " == null || endpointURL_";
  protected final String TEXT_52 = " == null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_54 = ".setCallbackHost(";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_56 = ".setCallbackPort(";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\t\t\ttoken_";
  protected final String TEXT_58 = " = oauthClient_";
  protected final String TEXT_59 = ".getToken();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_61 = " = oauthClient_";
  protected final String TEXT_62 = ".getSOAPEndpoint(token_";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_66 = " = oauthClient_";
  protected final String TEXT_67 = ".getBulkEndpoint(token_";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\taccessToken_";
  protected final String TEXT_71 = " = token_";
  protected final String TEXT_72 = ".getAccess_token();" + NL + "\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_73 = " = token_";
  protected final String TEXT_74 = ".getRefresh_token();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_76 = " != null && refreshToken_";
  protected final String TEXT_77 = " != null){" + NL + "\t\t\t\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_78 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_79 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_81 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_83 = ".store(outputStream_";
  protected final String TEXT_84 = ", null);" + NL + "\t\t\t\t\t\t\tif(outputStream_";
  protected final String TEXT_85 = " != null){" + NL + "\t\t\t\t\t\t\t    outputStream_";
  protected final String TEXT_86 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_88 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\tif(globalMap.get(\"stub_";
  protected final String TEXT_90 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_91 = "\")==null){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_92 = "\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(globalMap.get(\"callOptions_";
  protected final String TEXT_93 = "\")!=null ){" + NL + "\t\t\t\t\t\tsfMgr_";
  protected final String TEXT_94 = ".setCallOptions((com.salesforce.soap.partner.CallOptions)globalMap.get(\"callOptions_";
  protected final String TEXT_95 = "\"));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_96 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_97 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_98 = "\"));" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\tsfMgr_";
  protected final String TEXT_100 = ".setClientID(";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\tboolean result_";
  protected final String TEXT_103 = " = false;" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tresult_";
  protected final String TEXT_104 = " = sfMgr_";
  protected final String TEXT_105 = ".login(accessToken_";
  protected final String TEXT_106 = ", endpointURL_";
  protected final String TEXT_107 = ",";
  protected final String TEXT_108 = ",";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t//ignore exception when login" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(!result_";
  protected final String TEXT_110 = "){" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_112 = " = System.getProperties();" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_113 = ".put(\"socksProxyHost\",";
  protected final String TEXT_114 = ");  " + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_115 = ".put(\"socksProxyPort\",";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_117 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_118 = ");" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_119 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_120 = "); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\tboolean result_";
  protected final String TEXT_122 = " = false;" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tresult_";
  protected final String TEXT_123 = " = sfMgr_";
  protected final String TEXT_124 = ".login(";
  protected final String TEXT_125 = ",";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ",";
  protected final String TEXT_128 = ",";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t//ignore exception when login" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(!result_";
  protected final String TEXT_130 = "){" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_132 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_134 = "\")==null){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_135 = "\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tsforceBulk_";
  protected final String TEXT_136 = ".login((com.sforce.async.BulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_137 = "\"));" + NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\tsforceBulk_";
  protected final String TEXT_139 = ".setNeedCompression(";
  protected final String TEXT_140 = ");" + NL + "\t\t\t\t\tsforceBulk_";
  protected final String TEXT_141 = ".setNeedTraceMessage(";
  protected final String TEXT_142 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\tsforceBulk_";
  protected final String TEXT_144 = ".login(accessToken_";
  protected final String TEXT_145 = ", endpointURL_";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\tsforceBulk_";
  protected final String TEXT_148 = ".setProxy(true,";
  protected final String TEXT_149 = ",";
  protected final String TEXT_150 = ",";
  protected final String TEXT_151 = ",";
  protected final String TEXT_152 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\tsforceBulk_";
  protected final String TEXT_154 = ".login(";
  protected final String TEXT_155 = ",";
  protected final String TEXT_156 = ",";
  protected final String TEXT_157 = ",";
  protected final String TEXT_158 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_159 = "\t\t\t\t" + NL + "\t\t\t\tStringBuilder sql_";
  protected final String TEXT_160 = " = new StringBuilder(";
  protected final String TEXT_161 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\tString condition_";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = ";" + NL + "\t\t\t\t\tif (condition_";
  protected final String TEXT_165 = " !=null && !(\"\".equals(condition_";
  protected final String TEXT_166 = "))){" + NL + "\t\t\t\t\t\tsql_";
  protected final String TEXT_167 = ".append(\" where \").append(condition_";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_169 = "\t" + NL + "\t\t\t\t\tcom.salesforce.soap.partner.QueryResult qr_";
  protected final String TEXT_170 = " = null; " + NL + "\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\tqr_";
  protected final String TEXT_172 = " = sfMgr_";
  protected final String TEXT_173 = ".queryAll(sql_";
  protected final String TEXT_174 = ".toString(),new Integer(";
  protected final String TEXT_175 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\tqr_";
  protected final String TEXT_177 = " = sfMgr_";
  protected final String TEXT_178 = ".query(sql_";
  protected final String TEXT_179 = ".toString(),new Integer(";
  protected final String TEXT_180 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t" + NL + "\t\t\t\t\torg.talend.salesforce.TopConfig.VALUE_DELIMITER = ";
  protected final String TEXT_182 = ";" + NL + "\t\t\t\t\torg.talend.salesforce.TopConfig.COLUMNNAME_DELIMTER = ";
  protected final String TEXT_183 = ";" + NL + "\t\t\t\t\t" + NL + "\t    \t\t\torg.talend.salesforce.TopQueryResult topqr_";
  protected final String TEXT_184 = " = null;    \t\t\t" + NL + "\t    \t\t\ttopqr_";
  protected final String TEXT_185 = " = new org.talend.salesforce.TopQueryResult();" + NL + "\t    \t\t\ttopqr_";
  protected final String TEXT_186 = ".processTopQueryResult(qr_";
  protected final String TEXT_187 = ");\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tboolean bContinue_";
  protected final String TEXT_188 = " = true;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twhile (bContinue_";
  protected final String TEXT_189 = " && qr_";
  protected final String TEXT_190 = " != null && qr_";
  protected final String TEXT_191 = ".getRecords() != null) {" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tjava.util.List<org.talend.salesforce.TopRecord> allTopRecords_";
  protected final String TEXT_192 = " = topqr_";
  protected final String TEXT_193 = ".getAllTopRecords();" + NL + "\t\t\t\t\t    // process the query results" + NL + "\t\t\t\t\t    for (int i_";
  protected final String TEXT_194 = " = 0; i_";
  protected final String TEXT_195 = " < allTopRecords_";
  protected final String TEXT_196 = ".size(); i_";
  protected final String TEXT_197 = "++) {\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\torg.talend.salesforce.TopRecord topRecord_";
  protected final String TEXT_198 = " = allTopRecords_";
  protected final String TEXT_199 = ".get(i_";
  protected final String TEXT_200 = ");" + NL + "" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_201 = "++;" + NL + "\t\t\t\t\t\t\tObject value_";
  protected final String TEXT_202 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\tsforceBulk_";
  protected final String TEXT_204 = ".doBulkQuery(";
  protected final String TEXT_205 = ", sql_";
  protected final String TEXT_206 = ".toString(), 30);" + NL + "\t\t\t\t\tString[] queryResultIDs_";
  protected final String TEXT_207 = " = sforceBulk_";
  protected final String TEXT_208 = ".getQueryResultIDs();" + NL + "\t\t\t\t\tfor(String queryResultId_";
  protected final String TEXT_209 = " : queryResultIDs_";
  protected final String TEXT_210 = "){" + NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_211 = " = sforceBulk_";
  protected final String TEXT_212 = ".getQueryResult(queryResultId_";
  protected final String TEXT_213 = ");" + NL + "\t\t\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_214 = " : resultListMessage_";
  protected final String TEXT_215 = "){" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_216 = "++;\t\t" + NL + "\t\t\t\t\t\t\tObject value_";
  protected final String TEXT_217 = " = null;\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_218 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t//get the real value according the columnName" + NL + "\t\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_219 = " = topRecord_";
  protected final String TEXT_220 = ".getValue(\"";
  protected final String TEXT_221 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_223 = " = resultMessage_";
  protected final String TEXT_224 = ".get(\"";
  protected final String TEXT_225 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\t\t\t\t\tif (value_";
  protected final String TEXT_227 = " != null){" + NL + "\t\t\t\t\t\t\t\t \tString valueStr_";
  protected final String TEXT_228 = " = (String) value_";
  protected final String TEXT_229 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = valueStr_";
  protected final String TEXT_233 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_237 = ", ";
  protected final String TEXT_238 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = " = valueStr_";
  protected final String TEXT_242 = ".getBytes();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = ParserUtils.parseTo_";
  protected final String TEXT_246 = "(valueStr_";
  protected final String TEXT_247 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_248 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_252 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

   	String limit = ElementParameterParser.getValue(node,"__LIMIT__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_4);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String api = ElementParameterParser.getValue(node,"__API__");
			
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			String username = ElementParameterParser.getValue(node, "__USER__");
			String password = ElementParameterParser.getValue(node, "__PASS__");
			boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
			
			String modulename = ElementParameterParser.getValue(node, "__MODULENAME__").trim();
			String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE__").trim();
			String sObject = (("CustomModule").equals(modulename)) ? customModulename : "\""+modulename+"\"";

			//for bulk query
		   	String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
		   	boolean needTraceMessage = ("true").equals(ElementParameterParser.getValue(node,"__HTTP_TRACEMESSAGE__"));
		   	
		   	//for soap query
		   	String batchSize = ElementParameterParser.getValue(node,"__BATCH_SIZE__");
			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String normalize_delimiter = ElementParameterParser.getValue(node, "__NORMALIZE_DELIMITER__");
			String columnname_delimiter = ElementParameterParser.getValue(node, "__COLUMNNAME_DELIMITER__");
			boolean queryAll = ("true").equals(ElementParameterParser.getValue(node,"__QUERY_ALL__"));
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
			
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);
			if(!useExistingConn){
				if(useOAuth){
					String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
					String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
					
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(oauthSecret);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tokenFile);
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
    
								if("soap".equals(api)){
								
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_39);
    
								}else{
								
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_44);
    
								}
								
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
					}
					
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
						String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
						String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
						
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
						if("soap".equals(api)){
						
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_64);
    
						}else{
						
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_69);
    
						}
						
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
					}
				}
			}
			if("soap".equals(api)){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    if(useExistingConn){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_98);
    
				}else{
					if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
					
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_101);
    
					}
					if(useOAuth){
					
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
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
					}else{
						if(useProxy){
						
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_120);
    
						}
						
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
					}
				}
			}else{
			
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
				if(useExistingConn){
				
    stringBuffer.append(TEXT_133);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_137);
    
				}else{
				
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(needTraceMessage);
    stringBuffer.append(TEXT_142);
    
					if(useOAuth){
					
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
					}else{
						if(useProxy){
						
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_152);
    
						}
						
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_158);
    
					}
				}
			}
						
			boolean bIsManualQuery = ("true").equals(ElementParameterParser.getValue(node, "__MANUAL_QUERY__"));
			String sql = "";
			String condition = null;
			
			if (bIsManualQuery){

				sql = ElementParameterParser.getValue(node, "__QUERY__");
				sql = sql.replaceAll("\n", " ").replaceAll("\r", " ");

			} else{
				
				condition = ElementParameterParser.getValue(node, "__CONDITION__").trim();

				StringBuilder sb = new StringBuilder("\"select ");

				for (IMetadataColumn column: columnList){
					sb.append(column.getLabel());
					sb.append(",");
				}
				sb.deleteCharAt(sb.lastIndexOf(","));
				sb.append(" from ");
				sb.append("\"+");
				sb.append(sObject);
				
				sql = sb.toString();
			}

			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
			
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_161);
    
				if(!("".equals(condition))) {
				
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(condition );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
				}
				if("soap".equals(api)){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    
					if(queryAll){
					
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_175);
    			
					}else{
					
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_180);
    
					}
					
    stringBuffer.append(TEXT_181);
    stringBuffer.append(normalize_delimiter );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(columnname_delimiter );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
				}else{
				
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
				}
							for( int i = 0; i < columnList.size(); i++) {
							
								IMetadataColumn column = columnList.get(i);
								
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
								if("soap".equals(api)){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_221);
    }else{
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_225);
    }
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
									
    stringBuffer.append(TEXT_230);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
									} else if(javaType == JavaTypesManager.DATE) { // Date
									
    stringBuffer.append(TEXT_234);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_238);
    
									} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
									
    stringBuffer.append(TEXT_239);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
									} else  { // other
									
    stringBuffer.append(TEXT_243);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_245);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
									}
									
    stringBuffer.append(TEXT_248);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_251);
    
							}
			}// end 1
		}
	}
}

    stringBuffer.append(TEXT_252);
    return stringBuffer.toString();
  }
}
