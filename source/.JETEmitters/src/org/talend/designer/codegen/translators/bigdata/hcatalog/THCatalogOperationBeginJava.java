package org.talend.designer.codegen.translators.bigdata.hcatalog;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;

public class THCatalogOperationBeginJava
{
  protected static String nl;
  public static synchronized THCatalogOperationBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogOperationBeginJava result = new THCatalogOperationBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tString err_";
  protected final String TEXT_3 = " = \"\";" + NL + "\t\t\torg.json.simple.JSONObject jsonRow_";
  protected final String TEXT_4 = " = new org.json.simple.JSONObject();" + NL + "\t\t\tjava.io.InputStream is_";
  protected final String TEXT_5 = ";" + NL + "\t\t\tObject obj_";
  protected final String TEXT_6 = ";" + NL + "\t\t\torg.json.simple.JSONObject object_";
  protected final String TEXT_7 = ";" + NL + "\t\t\tObject error_";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "\t\t\tis_";
  protected final String TEXT_10 = " = (java.io.InputStream) response_";
  protected final String TEXT_11 = ".getEntity();" + NL + "\t\t\tString result_";
  protected final String TEXT_12 = " = org.apache.cxf.helpers.IOUtils.toString(is_";
  protected final String TEXT_13 = ");" + NL + "\t\t\tobj_";
  protected final String TEXT_14 = "=org.json.simple.JSONValue.parse(result_";
  protected final String TEXT_15 = ");" + NL + "\t\t\tobject_";
  protected final String TEXT_16 = "=(org.json.simple.JSONObject)obj_";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\t\t\terror_";
  protected final String TEXT_19 = " = object_";
  protected final String TEXT_20 = ".get(\"error\");" + NL + "\t\t\tif(error_";
  protected final String TEXT_21 = "!=null) {" + NL + "\t\t\t\terr_";
  protected final String TEXT_22 = " = error_";
  protected final String TEXT_23 = ".toString();" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t\tif(((org.json.simple.JSONObject)object_";
  protected final String TEXT_25 = ".get(\"exec\"))!=null) {" + NL + "\t\t\t\t\tString time_";
  protected final String TEXT_26 = " = TalendDate.formatDate(\"yyyyMMddHHmmss\", TalendDate.getCurrentDate());" + NL + "\t\t\t\t\tObject stdout_";
  protected final String TEXT_27 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_28 = ".get(\"exec\")).get(\"stdout\");" + NL + "\t\t\t\t\tObject stderr_";
  protected final String TEXT_29 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_30 = ".get(\"exec\")).get(\"stderr\");" + NL + "\t\t\t\t\tString stdout_filename_";
  protected final String TEXT_31 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_32 = " + \"_\" + \"";
  protected final String TEXT_33 = "\" + \"_stdout.log\";" + NL + "\t\t\t\t\tString stderr_filename_";
  protected final String TEXT_34 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_35 = " + \"_\" + \"";
  protected final String TEXT_36 = "\" + \"_stderr.log\";" + NL + "\t\t\t\t\tjava.io.FileWriter fw_out_";
  protected final String TEXT_37 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_38 = "+stdout_filename_";
  protected final String TEXT_39 = "));" + NL + "\t\t\t\t\tjava.io.FileWriter fw_err_";
  protected final String TEXT_40 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_41 = "+stderr_filename_";
  protected final String TEXT_42 = "));" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_43 = ".write(stdout_";
  protected final String TEXT_44 = "!=null?stdout_";
  protected final String TEXT_45 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_46 = ".write(stderr_";
  protected final String TEXT_47 = "!=null?stderr_";
  protected final String TEXT_48 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_49 = ".close();" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\tif(response_";
  protected final String TEXT_52 = ".getStatus()!=200) {" + NL + "\t\t\t\tif(response_";
  protected final String TEXT_53 = ".getStatus()==400) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 400 (Bad request): The request was invalid.\\n--->\" + err_";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_55 = ".getStatus()==401) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 401 (Unauthorized): Credentials were missing or incorrect.\\n--->\" + err_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_57 = ".getStatus()==404) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 404 (Not found): The URI requested is invalid or the resource requested does not exist.\\n--->\" + err_";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_59 = ".getStatus()==500) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 500 (Internal Server Error): We received an unexpected result.\\n--->\" + err_";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_61 = ".getStatus()==503) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 503 (Busy, please retry): The server is busy.\\n--->\" + err_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthrow new Exception(object_";
  protected final String TEXT_63 = ".get(\"errorCode\") + \":\" + object_";
  protected final String TEXT_64 = ".get(\"error\") + object_";
  protected final String TEXT_65 = ".get(\"errorDetail\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_66 = NL + "\ttry {";
  protected final String TEXT_67 = NL + "\t\t\tclass KerberosPolicyConfig_";
  protected final String TEXT_68 = " extends javax.security.auth.login.Configuration {" + NL + "\t\t\t\tprivate java.util.Map<String, String> properties;" + NL + "" + NL + "\t\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_69 = "() {" + NL + "\t\t\t\t\tproperties = java.util.Collections" + NL + "\t\t\t\t\t\t\t.<String, String> emptyMap();" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_70 = "(" + NL + "\t\t\t\t\t\tjava.util.Map<String, String> properties) {" + NL + "\t\t\t\t\tthis.properties = properties;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic javax.security.auth.login.AppConfigurationEntry[] getAppConfigurationEntry(" + NL + "\t\t\t\t\t\tString name) {" + NL + "\t\t\t\t\treturn new javax.security.auth.login.AppConfigurationEntry[] { new javax.security.auth.login.AppConfigurationEntry(" + NL + "\t\t\t\t\t\t\tcom.sun.security.auth.module.Krb5LoginModule.class" + NL + "\t\t\t\t\t\t\t\t\t.getName()," + NL + "\t\t\t\t\t\t\tjavax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag.REQUIRED," + NL + "\t\t\t\t\t\t\tproperties) };" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\torg.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor kbInterceptor_";
  protected final String TEXT_71 = " = new org.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor();" + NL + "" + NL + "\t\t\torg.apache.cxf.configuration.security.AuthorizationPolicy policy_";
  protected final String TEXT_72 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\tpolicy_";
  protected final String TEXT_73 = ".setAuthorizationType(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_NEGOTIATE);" + NL + "" + NL + "\t\t\tkbInterceptor_";
  protected final String TEXT_74 = ".setPolicy(policy_";
  protected final String TEXT_75 = ");" + NL + "\t\t\tjava.util.Map<String, String> properties_";
  protected final String TEXT_76 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\tkbInterceptor_";
  protected final String TEXT_77 = ".setServicePrincipalName(";
  protected final String TEXT_78 = ");" + NL + "\t\t\tkbInterceptor_";
  protected final String TEXT_79 = ".setRealm(";
  protected final String TEXT_80 = ");" + NL + "\t\t\tproperties_";
  protected final String TEXT_81 = ".put(\"useTicketCache\", \"true\");" + NL + "\t\t\tproperties_";
  protected final String TEXT_82 = ".put(\"refreshKrb5Config\", \"true\");" + NL + "\t\t\tproperties_";
  protected final String TEXT_83 = ".put(\"renewTGT\", \"true\");" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_85 = ".put(\"useKeyTab\", \"true\");" + NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_86 = ".put(\"keyTab\", ";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_88 = ".put(\"principal\", ";
  protected final String TEXT_89 = ");" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\tkbInterceptor_";
  protected final String TEXT_91 = ".setLoginConfig(new KerberosPolicyConfig_";
  protected final String TEXT_92 = "(properties_";
  protected final String TEXT_93 = "));";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_drop_";
  protected final String TEXT_96 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_97 = " + \":\" + ";
  protected final String TEXT_98 = " + \"?user.name=\" + ";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_drop_";
  protected final String TEXT_101 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t\t\t" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_104 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_106 = ".accept(\"application/json\");" + NL + "\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_drop_";
  protected final String TEXT_107 = " = client_drop_";
  protected final String TEXT_108 = ".delete();";
  protected final String TEXT_109 = NL + "\t\t\t\t\torg.json.simple.JSONObject columnPropertiesJSON_";
  protected final String TEXT_110 = " = new org.json.simple.JSONObject();";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\tcolumnPropertiesJSON_";
  protected final String TEXT_112 = ".put(";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_116 = ".put(\"properties\", columnPropertiesJSON_";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\t\t\tjsonRow_";
  protected final String TEXT_119 = ".put(\"comment\", ";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\tjsonRow_";
  protected final String TEXT_121 = ".put(\"location\", ";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_create_";
  protected final String TEXT_123 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_124 = " + \":\" + ";
  protected final String TEXT_125 = " + \"?user.name=\" + ";
  protected final String TEXT_126 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_create_";
  protected final String TEXT_128 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t\t\t" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_131 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_132 = ");" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_133 = ".type(\"application/json\").accept(\"application/json\");" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_create_";
  protected final String TEXT_134 = " = client_create_";
  protected final String TEXT_135 = ".put(jsonRow_";
  protected final String TEXT_136 = ".toJSONString());";
  protected final String TEXT_137 = NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_drop_";
  protected final String TEXT_138 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_139 = " + \":\" + ";
  protected final String TEXT_140 = " + \"?user.name=\" + ";
  protected final String TEXT_141 = ");" + NL;
  protected final String TEXT_142 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_drop_";
  protected final String TEXT_143 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\t\t\t" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_146 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_147 = " + \"/table/\" + ";
  protected final String TEXT_148 = ");" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_149 = ".accept(\"application/json\");" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_drop_";
  protected final String TEXT_150 = " = client_drop_";
  protected final String TEXT_151 = ".delete();";
  protected final String TEXT_152 = NL + "\t\t\t\t\torg.json.simple.JSONObject columnPropertiesJSON_";
  protected final String TEXT_153 = " = new org.json.simple.JSONObject();";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\tcolumnPropertiesJSON_";
  protected final String TEXT_155 = ".put(";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_159 = ".put(\"properties\", columnPropertiesJSON_";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_162 = ".put(\"ifNotExists\", \"true\");";
  protected final String TEXT_163 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_164 = ".put(\"ifNotExists\", \"false\");";
  protected final String TEXT_165 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_166 = ".put(\"external\", \"true\");";
  protected final String TEXT_167 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_168 = ".put(\"location\", ";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\t\t\tjsonRow_";
  protected final String TEXT_171 = ".put(\"comment\", ";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\torg.json.simple.JSONObject storage_";
  protected final String TEXT_173 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\tstorage_";
  protected final String TEXT_174 = ".put(\"storedAs\", \"";
  protected final String TEXT_175 = "\");";
  protected final String TEXT_176 = NL + "\t\t\t\t\torg.json.simple.JSONObject rowFormat_";
  protected final String TEXT_177 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t\t";
  protected final String TEXT_178 = "rowFormat_";
  protected final String TEXT_179 = ".put(\"fieldsTerminatedBy\", ";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "\t\t\t\t\t";
  protected final String TEXT_182 = "rowFormat_";
  protected final String TEXT_183 = ".put(\"collectionItemsTerminatedBy\", ";
  protected final String TEXT_184 = ");";
  protected final String TEXT_185 = NL + "\t\t\t\t\t";
  protected final String TEXT_186 = "rowFormat_";
  protected final String TEXT_187 = ".put(\"mapKeysTerminatedBy\", ";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "\t\t\t\t\t";
  protected final String TEXT_190 = "rowFormat_";
  protected final String TEXT_191 = ".put(\"linesTerminatedBy\", ";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "\t\t\t\t\torg.json.simple.JSONObject serde_";
  protected final String TEXT_194 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t\tserde_";
  protected final String TEXT_195 = ".put(\"name\", \"org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\trowFormat_";
  protected final String TEXT_196 = ".put(\"serde\", serde_";
  protected final String TEXT_197 = ");" + NL + "\t\t\t\t\tstorage_";
  protected final String TEXT_198 = ".put(\"rowFormat\", rowFormat_";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t\t\tjsonRow_";
  protected final String TEXT_201 = ".put(\"format\", storage_";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t\torg.json.simple.JSONArray columnListForJson_";
  protected final String TEXT_204 = " = new org.json.simple.JSONArray();" + NL + "\t\t\t\t\t\t\torg.json.simple.JSONObject columnObjJson_";
  protected final String TEXT_205 = ";";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\tcolumnObjJson_";
  protected final String TEXT_207 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t\t\t\t\tcolumnObjJson_";
  protected final String TEXT_208 = ".put(\"name\", \"";
  protected final String TEXT_209 = "\");" + NL + "\t\t\t\t\t\t\t\tcolumnObjJson_";
  protected final String TEXT_210 = ".put(\"type\", \"";
  protected final String TEXT_211 = "\");" + NL + "\t\t\t\t\t\t\t\tcolumnObjJson_";
  protected final String TEXT_212 = ".put(\"comment\", \"";
  protected final String TEXT_213 = "\");" + NL + "\t\t\t\t\t\t\t\tcolumnListForJson_";
  protected final String TEXT_214 = ".add(columnObjJson_";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_217 = ".put(\"columns\", columnListForJson_";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\t\torg.json.simple.JSONArray partitionListForJson_";
  protected final String TEXT_220 = " = new org.json.simple.JSONArray();" + NL + "\t\t\t\t\t\t\t\torg.json.simple.JSONObject partitionObjJson_";
  protected final String TEXT_221 = ";";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\t\t\tpartitionObjJson_";
  protected final String TEXT_223 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t\t\t\t\t\tpartitionObjJson_";
  protected final String TEXT_224 = ".put(\"name\", \"";
  protected final String TEXT_225 = "\");" + NL + "\t\t\t\t\t\t\t\t\tpartitionObjJson_";
  protected final String TEXT_226 = ".put(\"type\", \"";
  protected final String TEXT_227 = "\");" + NL + "\t\t\t\t\t\t\t\t\tpartitionObjJson_";
  protected final String TEXT_228 = ".put(\"comment\", \"";
  protected final String TEXT_229 = "\");" + NL + "\t\t\t\t\t\t\t\t\tpartitionListForJson_";
  protected final String TEXT_230 = ".add(partitionObjJson_";
  protected final String TEXT_231 = ");";
  protected final String TEXT_232 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_233 = ".put(\"partitionedBy\", partitionListForJson_";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "\t\t\t\t" + NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_create_";
  protected final String TEXT_236 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_237 = " + \":\" + ";
  protected final String TEXT_238 = " + \"?user.name=\" + ";
  protected final String TEXT_239 = ");" + NL;
  protected final String TEXT_240 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_create_";
  protected final String TEXT_241 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\t\t\t\t" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_244 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_245 = " + \"/table/\" + ";
  protected final String TEXT_246 = ");" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_247 = ".type(\"application/json\").accept(\"application/json\");" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_create_";
  protected final String TEXT_248 = " = client_create_";
  protected final String TEXT_249 = ".put(jsonRow_";
  protected final String TEXT_250 = ".toJSONString());";
  protected final String TEXT_251 = NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_drop_";
  protected final String TEXT_252 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_253 = " + \":\" + ";
  protected final String TEXT_254 = " + \"?user.name=\" + ";
  protected final String TEXT_255 = ");" + NL;
  protected final String TEXT_256 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_drop_";
  protected final String TEXT_257 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_258 = ");";
  protected final String TEXT_259 = "\t\t\t\t" + NL + "" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_260 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_261 = " +\"/table/\" + ";
  protected final String TEXT_262 = " + \"/partition/\" + ";
  protected final String TEXT_263 = ");" + NL + "\t\t\t\tclient_drop_";
  protected final String TEXT_264 = ".accept(\"application/json\");" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_drop_";
  protected final String TEXT_265 = " = client_drop_";
  protected final String TEXT_266 = ".delete();";
  protected final String TEXT_267 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_268 = ".put(\"location\", ";
  protected final String TEXT_269 = ");";
  protected final String TEXT_270 = NL + "\t\t\t\torg.apache.cxf.jaxrs.client.WebClient client_create_";
  protected final String TEXT_271 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_272 = " + \":\" + ";
  protected final String TEXT_273 = " + \"?user.name=\" + ";
  protected final String TEXT_274 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_create_";
  protected final String TEXT_276 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_277 = ");";
  protected final String TEXT_278 = NL + "\t\t\t\t" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_279 = ".path(\"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_280 = "+\"/table/\" + ";
  protected final String TEXT_281 = " + \"/partition/\" + ";
  protected final String TEXT_282 = ");" + NL + "\t\t\t\tclient_create_";
  protected final String TEXT_283 = ".type(\"application/json\").accept(\"application/json\");" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.ws.rs.core.Response response_create_";
  protected final String TEXT_284 = " = client_create_";
  protected final String TEXT_285 = ".put(jsonRow_";
  protected final String TEXT_286 = ".toJSONString());";
  protected final String TEXT_287 = "\t\t" + NL + "\t} catch (Exception e_";
  protected final String TEXT_288 = ") {";
  protected final String TEXT_289 = NL + "\t\t\tthrow e_";
  protected final String TEXT_290 = ";";
  protected final String TEXT_291 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_292 = ".getMessage());";
  protected final String TEXT_293 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

	String templeton_host = ElementParameterParser.getValue(node, "__TEMPLETON_HOST__");
	String templeton_port = ElementParameterParser.getValue(node, "__TEMPLETON_PORT__");
	
	String database = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String table = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String partition = ElementParameterParser.getValue(node, "__PARTITION_NAME__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	boolean setFileLocation = "true".equals(ElementParameterParser.getValue(node, "__SET_FILE_LOCATION__"));
	String fileLocation = ElementParameterParser.getValue(node, "__FILE_LOCATION__");
	
	String operationOn = ElementParameterParser.getValue(node, "__OPERATION_ON__");
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	String option = ElementParameterParser.getValue(node, "__OPTION__");
	
	boolean setUserGroup = "true".equals(ElementParameterParser.getValue(node, "__SET_USER_GROUP__"));
	boolean setPermissions = "true".equals(ElementParameterParser.getValue(node, "__SET_PERMISSIONS__"));
	String userGroup = ElementParameterParser.getValue(node, "__USER_GROUP__");
	String permissions = ElementParameterParser.getValue(node, "__PERMISSIONS__");
	
	String dbLocation = ElementParameterParser.getValue(node, "__DB_LOCATION__");
	String dbDescription = ElementParameterParser.getValue(node, "__DB_DESCRIPTION__");
	
	boolean createExternal = "true".equals(ElementParameterParser.getValue(node, "__CREATE_EXTERNAL__"));
	boolean setPartitions = "true".equals(ElementParameterParser.getValue(node, "__SET_PARTITIONS__"));
	boolean setHDFSLocation = "true".equals(ElementParameterParser.getValue(node, "__SET_HDFS_LOCATION__"));
	String hdfsLocation = ElementParameterParser.getValue(node, "__HDFS_LOCATION__");
	String tableComment = ElementParameterParser.getValue(node, "__TABLE_COMMENT__");
	String storageFormat = ElementParameterParser.getValue(node, "__STORAGE_FORMAT__");
	
	boolean setRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_ROW_FORMAT__"));
	String fieldsTerminatedBy = ElementParameterParser.getValue(node, "__FIELD_TERMINATED_BY__");
	String collectionItemsTerminatedBy = ElementParameterParser.getValue(node, "__COLLECTION_ITEM_TERMINATED_BY__");
	String mapKeysTerminatedBy = ElementParameterParser.getValue(node, "__MAP_KEY_TERMINATED_BY__");
	String linesTerminatedBy = ElementParameterParser.getValue(node, "__LINES_TERMINATED_BY__");
	
	boolean setFieldsTerminatedBy = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_TERMINATED_BY__"));
	boolean setCollectionItemsTerminatedBy = "true".equals(ElementParameterParser.getValue(node, "__SET_COLLECTION_ITEM_TERMINATED_BY__"));
	boolean setMapKeysTerminatedBy = "true".equals(ElementParameterParser.getValue(node, "__SET_MAP_KEY_TERMINATED_BY__"));
	boolean setLinesTerminatedBy = "true".equals(ElementParameterParser.getValue(node, "__SET_LINES_TERMINATED_BY__"));
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean activateLog = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_LOG__"));
	
	String stdout = ElementParameterParser.getValue(node, "__STDOUT__");
	String stderr = ElementParameterParser.getValue(node, "__STDERR__");
	
	List<Map<String, String>> templetonProperties = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__TEMPLETON_PROPERTIES__");
	
	boolean useKerberos = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String krb_realm = ElementParameterParser.getValue(node, "__KRB_REALM__");
	String krb_princ = ElementParameterParser.getValue(node, "__KRB_PRINC__");
	
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
	
	boolean drop=false;
	boolean dropIfExist=false;
	boolean create=false;
	boolean createIfNotExist=false;
	boolean dropIfExistAndCreate=false;
	boolean dropAndCreate=false;
	
	if("DROP".equals(operation))
		drop=true;
	if("DROP_IF_EXIST".equals(operation))
		dropIfExist=true;
	if("CREATE".equals(operation))
		create=true;
	if("DROP_IF_EXIST_CREATE".equals(operation))
		dropIfExistAndCreate=true;
	if("DROP_CREATE".equals(operation))
		dropAndCreate=true;
		
	boolean checkIfExist = "true".equals(ElementParameterParser.getValue(node, "__CREATE_TABLE_IF_NOT_EXIST__"));
		
	StringBuilder parameters=new StringBuilder();

    stringBuffer.append(TEXT_1);
    
	class ParseRestResult {
	
		protected String cid;
		protected boolean activateLog;
		protected String stdout;
		protected String stderr;
	
	
		public void declareVariable(INode node) {
			this.cid = node.getUniqueName();

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
	
		public void getJSONObject(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void manageError(INode node, boolean activateLog) {
			this.cid = node.getUniqueName();
			this.activateLog = activateLog;

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
    
			if(this.activateLog) {
				this.stdout = ElementParameterParser.getValue(node, "__STDOUT__");
				this.stderr = ElementParameterParser.getValue(node, "__STDERR__");

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
    stringBuffer.append(this.stdout);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(this.stderr);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			}
		}
		
		public void manageResponseStatus(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_51);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(context==null?"":context+"_");
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
    
		}
	}

    
	ParseRestResult parserResult = new ParseRestResult();

    stringBuffer.append(TEXT_66);
    
		parserResult.declareVariable(node);
		if(useKerberos) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
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
    stringBuffer.append(krb_princ);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(krb_realm);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
				if(useKeytab) {
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_89);
    
				}
			
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		}

    stringBuffer.append(TEXT_94);
    
		if("OP_DATABASE".equals(operationOn)) {
		
			/* ---------------------------------------------------------------- 
			   ------------DROP DATABASE or DROP DATABASE IF EXIST ------------
			   ---------------------------------------------------------------- */
			if(drop || dropIfExist || dropIfExistAndCreate || dropAndCreate) { // DROP DATABASE or DROP DATABASE IF EXIST
				if(drop || dropAndCreate)
					parameters.append(" + \"&ifExists=false" + "\"");
				if(dropIfExist || dropIfExistAndCreate)
					parameters.append(" + \"&ifExists=true" + "\"");
				if(!("none".equals(option)))
					parameters.append(" + \"&option=\" + \"" + option + "\"");
				if(setUserGroup) {
					parameters.append(" + \"&group=\" + " + userGroup);
				}
				if(setPermissions) {
					parameters.append(" + \"&permissions=\" + " + permissions);
				}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_99);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
				}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
				parserResult.getJSONObject(node, "drop");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "drop");
			}
			
			/* ----------------------------------------------------------------- 
			   ---------------------- CREATE DATABASE --------------------------
			   ----------------------------------------------------------------- */
			if(create ||  dropIfExistAndCreate ||  dropAndCreate) {
				if(templetonProperties.size()>0) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
					for(Map<String, String> item : templetonProperties){

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(item.get("KEY"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_114);
    
					}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
				}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(dbDescription);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(dbLocation);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_126);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
				}

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
				parserResult.getJSONObject(node, "create");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "create");
			}
			// -------------------------------------------------------
		} else if("OP_TABLE".equals(operationOn)) {

			/* ---------------------------------------------------------------- 
			   -------------- DROP TABLE or DROP TABLE IF EXIST ---------------
			   ---------------------------------------------------------------- */
			if(drop || dropIfExist || dropIfExistAndCreate || dropAndCreate) {
				if(drop || dropAndCreate)
					parameters.append(" + \"&ifExists=false" + "\"");
				if(dropIfExist || dropIfExistAndCreate)
					parameters.append(" + \"&ifExists=true" + "\"");
				if(!("none".equals(option)))
					parameters.append(" + \"&option=\" + \"" + option + "\"");
				if(setUserGroup) {
					parameters.append(" + \"&group=\" + " + userGroup );
				}
				if(setPermissions) {
					parameters.append(" + \"&permissions=\" + " + permissions);
				}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_141);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
				}

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
				parserResult.getJSONObject(node, "drop");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "drop");
			}
			
			/* ---------------------------------------------------------------- 
			   ------------------------ CREATE TABLE --------------------------
			   ---------------------------------------------------------------- */
			if(create ||  dropIfExistAndCreate ||  dropAndCreate) {
				if(templetonProperties.size()>0) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
					for(Map<String, String> item : templetonProperties){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(item.get("KEY"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_157);
    
					}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
				}
				
				if(checkIfExist) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
				} else {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
				}
				
				if(createExternal) {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
				}
				
				if(setHDFSLocation) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(hdfsLocation);
    stringBuffer.append(TEXT_169);
    
				}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(dbDescription);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(storageFormat);
    stringBuffer.append(TEXT_175);
    
				if(setRowFormat) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    if(setFieldsTerminatedBy){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(fieldsTerminatedBy);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    if(setCollectionItemsTerminatedBy){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(collectionItemsTerminatedBy);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    if(setMapKeysTerminatedBy){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(mapKeysTerminatedBy);
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    if(setLinesTerminatedBy){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(linesTerminatedBy);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
				}

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
				List<IMetadataTable> metadatas = node.getMetadataList();
				if ((metadatas!=null)&&(metadatas.size()>0)) {
					IMetadataTable metadata = metadatas.get(0);
					if (metadata!=null) {
						List<IMetadataColumn> columnList = metadata.getListColumns();
						if(columnList != null && columnList.size() > 0) {

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
							for(int i=0; i<columnList.size(); i++) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(Java2STLangTypesHelper.getHCatType(metadata, columnList.get(i).getLabel()));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(columnList.get(i).getComment());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
							}

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
						}
					}
				}
				if(setPartitions) {
					metadatas = node.getMetadataList();
					if ((metadatas!=null)&&(metadatas.size()>0)) {
						IMetadataTable metadata = metadatas.get(1);
						if (metadata!=null) {
							List<IMetadataColumn> columnList = metadata.getListColumns();
							if(columnList != null && columnList.size() > 0) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
								for(int i=0; i<columnList.size(); i++) {

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(Java2STLangTypesHelper.getHCatType(metadata, columnList.get(i).getLabel()));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(columnList.get(i).getComment());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
								}

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
							}
						}
					}
				}

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_239);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
				}

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
				parserResult.getJSONObject(node, "create");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "create");
			}
			
		} else if("OP_PARTITION".equals(operationOn)) {		
			/* ---------------------------------------------------------------- 
			   ------------DROP PARTITION or DROP PARTITION IF EXIST ------------
			   ---------------------------------------------------------------- */
			if(drop || dropIfExist || dropIfExistAndCreate || dropAndCreate) {
				if(drop || dropAndCreate)
					parameters.append(" + \"&ifExists=false" + "\"");
				if(dropIfExist || dropIfExistAndCreate)
					parameters.append(" + \"&ifExists=true" + "\"");
				if(!("none".equals(option)))
					parameters.append(" + \"&option=\" + \"" + option + "\"");
				if(setUserGroup) {
					parameters.append(" + \"&group=\" + " + userGroup );
				}
				if(setPermissions) {
					parameters.append(" + \"&permissions=\" + " + permissions);
				}

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_255);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
				}

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
				parserResult.getJSONObject(node, "drop");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "drop");
			}
			
			/* ----------------------------------------------------------------- 
			   ---------------------- CREATE PARTITION --------------------------
			   ----------------------------------------------------------------- */
			if(create ||  dropIfExistAndCreate ||  dropAndCreate) {
				if(setFileLocation) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(fileLocation);
    stringBuffer.append(TEXT_269);
    
				}

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(templeton_host);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(templeton_port);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(username);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_274);
    
				if(useKerberos) {

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
				}

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    
				parserResult.getJSONObject(node, "create");
				parserResult.manageError(node, activateLog);
				parserResult.manageResponseStatus(node, "create");
			}
			// -------------------------------------------------------
		}

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
		} else {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
		}


    stringBuffer.append(TEXT_293);
    return stringBuffer.toString();
  }
}
