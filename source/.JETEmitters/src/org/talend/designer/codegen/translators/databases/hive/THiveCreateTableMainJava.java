package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveCreateTableMainJava
{
  protected static String nl;
  public static synchronized THiveCreateTableMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveCreateTableMainJava result = new THiveCreateTableMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");";
  protected final String TEXT_3 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_6 = " - Driver ClassName: ";
  protected final String TEXT_7 = ".\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_11 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_15 = " = log4jDebugParamters_";
  protected final String TEXT_16 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_17 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_22 = " = log4jDebugParamters_";
  protected final String TEXT_23 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_24 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_29 = " = log4jDebugParamters_";
  protected final String TEXT_30 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_31 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_36 = " = log4jDebugParamters_";
  protected final String TEXT_37 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_38 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_43 = " = log4jDebugParamters_";
  protected final String TEXT_44 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_45 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_48 = " = log4jDebugParamters_";
  protected final String TEXT_49 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_50 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_53 = " = log4jDebugParamters_";
  protected final String TEXT_54 = " + \"DBVERSION = ";
  protected final String TEXT_55 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_60 = " = log4jDebugParamters_";
  protected final String TEXT_61 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_65 = " = log4jDebugParamters_";
  protected final String TEXT_66 = " + \"USE_CURSOR = ";
  protected final String TEXT_67 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_70 = " = log4jDebugParamters_";
  protected final String TEXT_71 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_72 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_75 = " = log4jDebugParamters_";
  protected final String TEXT_76 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_77 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_82 = " = log4jDebugParamters_";
  protected final String TEXT_83 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_84 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_89 = " = log4jDebugParamters_";
  protected final String TEXT_90 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_91 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_93 = " = \"";
  protected final String TEXT_94 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_95 = ";";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + NL + "\t";
  protected final String TEXT_98 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_99 = " = null;";
  protected final String TEXT_100 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_101 = "); ";
  protected final String TEXT_102 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\tconn_";
  protected final String TEXT_105 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_106 = "\");" + NL + "\t\t" + NL + "\t\tString dbname_";
  protected final String TEXT_107 = " = (String)globalMap.get(\"";
  protected final String TEXT_108 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_109 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_110 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_111 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_112 = " = conn_";
  protected final String TEXT_113 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_114 = ".execute(\"use \" + dbname_";
  protected final String TEXT_115 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_116 = ".close();" + NL + "    \t}" + NL + "    \t" + NL + "    \tString dbUser_";
  protected final String TEXT_117 = " = (String)globalMap.get(\"";
  protected final String TEXT_118 = "\");" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_119 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_120 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_121 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_123 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "    \t\t    \tlog.fatal(\"";
  protected final String TEXT_126 = " - The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "    \t\t    ";
  protected final String TEXT_127 = NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_128 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_129 = " ,";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_132 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_133 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_134 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", ";
  protected final String TEXT_135 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_136 = ");\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_138 = ", ";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_143 = "\", ";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\tString dbUser_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ";" + NL + "\t\tString dbPwd_";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ";" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_150 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_151 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_152 = " + \":\" + ";
  protected final String TEXT_153 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_154 = " = \"jdbc:";
  protected final String TEXT_155 = "://\";";
  protected final String TEXT_156 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_157 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_158 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_159 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_160 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_161 = NL + "\t\t\t\tString url_";
  protected final String TEXT_162 = " = \"jdbc:";
  protected final String TEXT_163 = "://\" + ";
  protected final String TEXT_164 = " + \":\" + ";
  protected final String TEXT_165 = " + \"/\" + ";
  protected final String TEXT_166 = " + \";principal=\" + ";
  protected final String TEXT_167 = ";";
  protected final String TEXT_168 = NL + "\t\t\t\tString url_";
  protected final String TEXT_169 = " = \"jdbc:";
  protected final String TEXT_170 = "://\" + ";
  protected final String TEXT_171 = " + \":\" + ";
  protected final String TEXT_172 = " + \"/\" + ";
  protected final String TEXT_173 = ";";
  protected final String TEXT_174 = NL + "\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_175 = "\");" + NL + "\t\t";
  protected final String TEXT_176 = "\t" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_178 = " - Connection attempt to '\" + url_";
  protected final String TEXT_179 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_180 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_181 = NL + "\t\t\tconn_";
  protected final String TEXT_182 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\t\t\tconn_";
  protected final String TEXT_185 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_186 = ", dbUser_";
  protected final String TEXT_187 = ", dbPwd_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "\t\t";
  protected final String TEXT_190 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_191 = " - Connection to '\" + url_";
  protected final String TEXT_192 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t\t" + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_194 = " = conn_";
  protected final String TEXT_195 = ".createStatement();";
  protected final String TEXT_196 = NL + "        \tinit_";
  protected final String TEXT_197 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_198 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_199 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_200 = ");";
  protected final String TEXT_201 = NL + "        \tinit_";
  protected final String TEXT_202 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \tinit_";
  protected final String TEXT_203 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\t\t\tinit_";
  protected final String TEXT_206 = ".execute(\"SET \"+";
  protected final String TEXT_207 = "+\"=\"+";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "\t\tinit_";
  protected final String TEXT_210 = ".close();" + NL + "\t\t" + NL + "    \tString dbname_";
  protected final String TEXT_211 = " = ";
  protected final String TEXT_212 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_213 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_214 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_215 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_216 = " = conn_";
  protected final String TEXT_217 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_218 = ".execute(\"use \" + dbname_";
  protected final String TEXT_219 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_220 = ".close();" + NL + "    \t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_221 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_222 = " = conn_";
  protected final String TEXT_223 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_224 = NL + "    \t\t\tstatement_";
  protected final String TEXT_225 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_226 = ");" + NL + "    \t\t";
  protected final String TEXT_227 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_228 = NL + "        \t\tstatement_";
  protected final String TEXT_229 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_230 = ");" + NL + "        \t";
  protected final String TEXT_231 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_232 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_233 = ".execute(\"add jar \"+";
  protected final String TEXT_234 = ");" + NL + "    \t\t";
  protected final String TEXT_235 = NL + "    \t\tstatement_";
  protected final String TEXT_236 = ".close();";
  protected final String TEXT_237 = NL + "\t";
  protected final String TEXT_238 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_239 = " = conn_";
  protected final String TEXT_240 = ".createStatement();" + NL + "\tString query_";
  protected final String TEXT_241 = " = \"\";" + NL + "\tString tableName_";
  protected final String TEXT_242 = " = ";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = NL + "\tString likeTableName_";
  protected final String TEXT_245 = " = ";
  protected final String TEXT_246 = ";";
  protected final String TEXT_247 = NL + "\t\tString location_";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = ";";
  protected final String TEXT_250 = NL + "\tString querySQL_";
  protected final String TEXT_251 = " = \"";
  protected final String TEXT_252 = "\";" + NL + "\ttry {" + NL + "    \tstmt_";
  protected final String TEXT_253 = ".execute(querySQL_";
  protected final String TEXT_254 = ");" + NL + "    } catch(java.sql.SQLException e_";
  protected final String TEXT_255 = ") {" + NL + "    \t";
  protected final String TEXT_256 = NL + "    \t\tthrow(e_";
  protected final String TEXT_257 = ");" + NL + "    \t";
  protected final String TEXT_258 = " " + NL + "    \t\tSystem.err.println(e_";
  protected final String TEXT_259 = ".getMessage());" + NL + "    \t";
  protected final String TEXT_260 = NL + "    }" + NL + "    stmt_";
  protected final String TEXT_261 = ".close();\t" + NL + "    globalMap.put(\"";
  protected final String TEXT_262 = "_QUERY\", querySQL_";
  protected final String TEXT_263 = ");" + NL + "    " + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_264 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_265 = "!=null) {" + NL + "    \tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_266 = ");" + NL + "    \tglobalMap.put(\"current_client_path_separator\", null);" + NL + "    }";
  protected final String TEXT_267 = NL + "\t\tconn_";
  protected final String TEXT_268 = ".close();";
  protected final String TEXT_269 = NL + "\t\t\t\tString comment_";
  protected final String TEXT_270 = "_";
  protected final String TEXT_271 = "_";
  protected final String TEXT_272 = " = ";
  protected final String TEXT_273 = ";";
  protected final String TEXT_274 = NL + "\t\t\t\tString comment_";
  protected final String TEXT_275 = "_";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = " = ";
  protected final String TEXT_278 = ";";
  protected final String TEXT_279 = NL + "\t\t\t\tString key_";
  protected final String TEXT_280 = "_";
  protected final String TEXT_281 = "_";
  protected final String TEXT_282 = " = ";
  protected final String TEXT_283 = ";" + NL + "\t\t\t\tString value_";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = "_";
  protected final String TEXT_286 = " = ";
  protected final String TEXT_287 = ";";
  protected final String TEXT_288 = NL + "\tString tableComment_";
  protected final String TEXT_289 = " = ";
  protected final String TEXT_290 = ";";
  protected final String TEXT_291 = NL + "\tString clustededOrSkewed_";
  protected final String TEXT_292 = " = ";
  protected final String TEXT_293 = ";";
  protected final String TEXT_294 = NL + "\t\t\tString fieldChar_";
  protected final String TEXT_295 = " = ";
  protected final String TEXT_296 = ";";
  protected final String TEXT_297 = NL + "\t\t\t\tString escapeChar_";
  protected final String TEXT_298 = " = ";
  protected final String TEXT_299 = ";";
  protected final String TEXT_300 = NL + "\t\t\tString collectionChar_";
  protected final String TEXT_301 = " = ";
  protected final String TEXT_302 = ";";
  protected final String TEXT_303 = NL + "\t\t\tString mapChar_";
  protected final String TEXT_304 = " = ";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = NL + "\t\t\tString lineChar_";
  protected final String TEXT_307 = " = ";
  protected final String TEXT_308 = ";";
  protected final String TEXT_309 = NL + "\t\tString serdeName_";
  protected final String TEXT_310 = " = ";
  protected final String TEXT_311 = ";";
  protected final String TEXT_312 = NL + "\t\tString inputClass_";
  protected final String TEXT_313 = " = ";
  protected final String TEXT_314 = ";" + NL + "\t\tString outputClass_";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = ";";
  protected final String TEXT_317 = NL + "\tString storageClass_";
  protected final String TEXT_318 = " = ";
  protected final String TEXT_319 = ";";
  protected final String TEXT_320 = NL + "\tString location_";
  protected final String TEXT_321 = " = ";
  protected final String TEXT_322 = ";";
  protected final String TEXT_323 = NL + "\tString select_";
  protected final String TEXT_324 = " = ";
  protected final String TEXT_325 = ";";
  protected final String TEXT_326 = NL + "String querySQL_";
  protected final String TEXT_327 = " = \"";
  protected final String TEXT_328 = "\";" + NL + "try {" + NL + "\tstmt_";
  protected final String TEXT_329 = ".execute(querySQL_";
  protected final String TEXT_330 = ");" + NL + "} catch(java.sql.SQLException e_";
  protected final String TEXT_331 = ") {" + NL + "\t";
  protected final String TEXT_332 = NL + "\t\tthrow(e_";
  protected final String TEXT_333 = ");" + NL + "\t";
  protected final String TEXT_334 = " " + NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_335 = ".getMessage());" + NL + "\t";
  protected final String TEXT_336 = NL + "}" + NL + "stmt_";
  protected final String TEXT_337 = ".close();\t";
  protected final String TEXT_338 = NL + "\tconn_";
  protected final String TEXT_339 = ".close();";
  protected final String TEXT_340 = "    " + NL + "globalMap.put(\"";
  protected final String TEXT_341 = "_QUERY\", querySQL_";
  protected final String TEXT_342 = ");" + NL + "" + NL + "String currentClientPathSeparator_";
  protected final String TEXT_343 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_344 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_345 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_346 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_347 = "!=null) {" + NL + "\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_348 = ");" + NL + "\tglobalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_349 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_350 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_351 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_352 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_353 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jCodeGenerateUtil {
	
		INode node = null;
	    String cid = null;
		String dbproperties = null;
		String dbhost = null;
    	String dbport = null;
    	String dbname = null;
    	String dbuser = null;
 		String dbpwd = null;
		String connectionType = null;
 		String dbVersion =  null; 
 		String dbSchema = null;
 		String useCursor = null;
 		String trimAllColumn = null;
 		String noNullValues = null;
 		String dbquery= null;
 		String table = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	 		dbSchema = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
	 		useCursor = ElementParameterParser.getValue(node,"__USE_CURSOR__");
	 		trimAllColumn = ElementParameterParser.getValue(node,"__TRIM_ALL_COLUMN__");
	 		noNullValues = ElementParameterParser.getValue(node,"__NO_NULL_VALUES__");
	 		dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			table= ElementParameterParser.getValue(node, "__TABLE__");
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void infoComponentStart(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			}
		}
	
		public void dbConnectionParamsForELT(INode previousNode){
			cid = previousNode.getUniqueName();
			dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	    	dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
		}
		
		public void additionalParameter(INode node) {
			String needtoConvet2Upper= ElementParameterParser.getValue(node, "__Convert_to_UPPer__");
		}
		
		public void generateAdditionalParameters(INode node) {
			additionalParameter(node);
		}
		
		public void generateConnectionParams() {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_96);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	final String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_100);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_101);
     
	}
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_102);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_103);
    
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
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
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
		
		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
		
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

    stringBuffer.append(TEXT_124);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    
		}
		
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_130);
    
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

    stringBuffer.append(TEXT_131);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(metastorePassword);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_136);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_139);
    
			}
		}
		
		if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion))) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_140);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_141);
    
		}
		
		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_142);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_144);
    
		}		

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_151);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_155);
    
			if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,Cloudera_CDH4,Cloudera_CDH4_YARN,PIVOTAL_HD_1_0_1".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    
			}
		} else {
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_167);
    
			} else {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_173);
    
			}
		}

    stringBuffer.append(TEXT_174);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_175);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node,javaDbDriver);	
		
    stringBuffer.append(TEXT_176);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
		} else {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
		}

    stringBuffer.append(TEXT_189);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_200);
    
		}
    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
		
    	if(((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion)))) && setResourceManager) {
    		String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_204);
    
		}
		
		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_208);
    
			}
		}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(dbname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_234);
    
    			}
    		}

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
	  	}
	}

    stringBuffer.append(TEXT_237);
    
	String tableName = ElementParameterParser.getValue(node, "__TABLE__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_243);
    
List<IMetadataColumn> listColumn = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    listColumn = metadata.getListColumns();
}

StringBuilder createTableSQL = new StringBuilder();

boolean external = "true".equals(ElementParameterParser.getValue(node, "__CREATE_EXTERNAL__"));
String tableAction = ElementParameterParser.getValue(node,"__TABLEACTION__");
boolean createIfNotExist = "CREATE_IF_NOT_EXIST".equals(tableAction);
boolean setPartitioned = "true".equals(ElementParameterParser.getValue(node, "__SET_PARTITIONS__"));
boolean setClustered = false;
boolean setSkewed = false;

boolean setLocation = "true".equals(ElementParameterParser.getValue(node, "__SET_FILE_LOCATION__"));
String location = ElementParameterParser.getValue(node, "__FILE_LOCATION__");

String storedFormat = ElementParameterParser.getValue(node, "__STORAGE_FORMAT__");

List<Map<String, String>> serdeProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERDE_PROPERTIES__");

List<Map<String, String>> tableProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TABLE_PROPERTIES__");

boolean setDelimitedRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_ROW_FORMAT__"));
boolean setSerdeRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_SERDE_ROW_FORMAT__"));

boolean setRowFormat = (setDelimitedRowFormat || setSerdeRowFormat) && !"STORAGE".equals(storedFormat);

boolean storeAsAvro = "AVRO".equals(storedFormat);

createTableSQL.append("CREATE ");
createTableSQL.append(external?"EXTERNAL":"");
createTableSQL.append(" TABLE ");
createTableSQL.append(createIfNotExist?"IF NOT EXISTS":"");
createTableSQL.append(" \" + ");
createTableSQL.append("tableName_");
createTableSQL.append(cid);
createTableSQL.append(" + \"");

boolean likeTable = "true".equals(ElementParameterParser.getValue(node, "__LIKE_TABLE__"));
if(likeTable) {
	String likeTableName = ElementParameterParser.getValue(node, "__LIKE_TABLE_NAME__");

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(likeTableName);
    stringBuffer.append(TEXT_246);
    
	createTableSQL.append(" LIKE ");
	createTableSQL.append("\" + ");
	createTableSQL.append("likeTableName_");
	createTableSQL.append(cid);
	createTableSQL.append(" + \"");
	
	if(setLocation) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_249);
    
    	createTableSQL.append(" LOCATION '");
    	createTableSQL.append("\" + ");
    	createTableSQL.append("location_");
    	createTableSQL.append(cid);
    	createTableSQL.append(" + \"'");
	}

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    if(("true").equals(dieOnError)) {
    	
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
    	}else {
    	
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
    	}
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    	
	if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
	}
	return stringBuffer.toString();
}

boolean asSelect = "true".equals(ElementParameterParser.getValue(node, "__AS_SELECT__"));

if(!storeAsAvro && !asSelect) {
	createTableSQL.append("(");
}

final MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever("hive_id");

class Util {
	
	int index = 0;
	
	void generateColumnsSQL(List<IMetadataColumn> listColumn,StringBuilder createTableSQL) {
		index++;
	
		int count = 0;
		String ending = ",";
        for(IMetadataColumn metadataColumn : listColumn) {
            createTableSQL.append(metadataColumn.getOriginalDbColumnName());
            createTableSQL.append(" ");
            
            String hiveType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                hiveType = metadataColumn.getType();
            }
        	createTableSQL.append(hiveType);
        	
        	String comment = metadataColumn.getComment();
        	if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_273);
    
        		createTableSQL.append(" COMMENT '");
	    		createTableSQL.append("\" + ");
    			createTableSQL.append("comment_");
    			createTableSQL.append(index);
    			createTableSQL.append("_");
    			createTableSQL.append(count);
    			createTableSQL.append("_");
    			createTableSQL.append(cid);
        		createTableSQL.append(" + \"'");
        	}
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            createTableSQL.append(ending);
            count++;
        }
	}
	
	java.util.Map<String,String> hiveTypeToAvroType = null;
	
	void generateAvroSchema(List<IMetadataColumn> listColumn,StringBuilder schemaBuilder, String quote) {
		if(hiveTypeToAvroType == null) {
			hiveTypeToAvroType = new java.util.HashMap<String,String>();
			hiveTypeToAvroType.put("SMALLINT","int");
			hiveTypeToAvroType.put("FLOAT","float");
			hiveTypeToAvroType.put("DOUBLE","double");
			hiveTypeToAvroType.put("BIGINT","long");
			hiveTypeToAvroType.put("INT","int");
			hiveTypeToAvroType.put("TINYINT","int");
			hiveTypeToAvroType.put("STRING","string");
			hiveTypeToAvroType.put("BOOLEAN","boolean");
			hiveTypeToAvroType.put("STRUCT","record");
			hiveTypeToAvroType.put("MAP","map");
			hiveTypeToAvroType.put("ARRAY","list");
			hiveTypeToAvroType.put("TIMESTAMP","long");
		}
		
		index++;
	
		int count = 0;
		String ending = ",";
        for(IMetadataColumn metadataColumn : listColumn) {
        	schemaBuilder.append("{");
        	
        	schemaBuilder.append(quote).append("name").append(quote);
            schemaBuilder.append(" : ");
            schemaBuilder.append(quote).append(metadataColumn.getOriginalDbColumnName()).append(quote);
            
            schemaBuilder.append(", ");
            
            String hiveType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                hiveType = metadataColumn.getType();
            }
            
            String avroType = hiveTypeToAvroType.get(hiveType);
            
            schemaBuilder.append(quote).append("type").append(quote);
            schemaBuilder.append(" : ");
        	schemaBuilder.append(quote).append(avroType).append(quote);
        	
        	String comment = metadataColumn.getComment();
        	if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {
        		schemaBuilder.append(", ");

    stringBuffer.append(TEXT_274);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_278);
    
        		schemaBuilder.append(quote).append("doc").append(quote);
        		schemaBuilder.append(" : ");
        		schemaBuilder.append(quote);
        		
	    		schemaBuilder.append("\" + ");
    			schemaBuilder.append("comment_");
    			schemaBuilder.append(index);
    			schemaBuilder.append("_");
    			schemaBuilder.append(count);
    			schemaBuilder.append("_");
    			schemaBuilder.append(cid);
        		schemaBuilder.append(" + \"");
        		
        		schemaBuilder.append(quote);
        	}
            
            schemaBuilder.append("}");
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            schemaBuilder.append(ending);
            count++;
        }
	}
	
	void generatePros(String prefix, List<Map<String, String>> pros, StringBuilder createTableSQL) {
		index++;
		
		int count = 0;
		String ending = ",";
		if(pros.size() > 0){
			createTableSQL.append(prefix);
			createTableSQL.append("(");
			for(Map<String, String> item : pros){

    stringBuffer.append(TEXT_279);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_287);
    
	    		createTableSQL.append("'\" + ");
    			createTableSQL.append("key_");
    			createTableSQL.append(index);
    			createTableSQL.append("_");
    			createTableSQL.append(count);
    			createTableSQL.append("_");
    			createTableSQL.append(cid);
        		createTableSQL.append(" + \"'");
        		
        		createTableSQL.append(" = ");
        		
        		createTableSQL.append("'\" + ");
    			createTableSQL.append("value_");
    			createTableSQL.append(index);
    			createTableSQL.append("_");
    			createTableSQL.append(count);
    			createTableSQL.append("_");
    			createTableSQL.append(cid);
        		createTableSQL.append(" + \"'");
        		
        		if(count == pros.size() - 1) {
                	ending = "";
            	}
            	
	            createTableSQL.append(ending);
            	count++;
			}
			
			if(appendKeyValue!=null) {
				createTableSQL.append(",");
				createTableSQL.append(appendKeyValue);
				appendKeyValue = null;
			}
			
			createTableSQL.append(")");
		} else if(appendKeyValue!=null) {
			createTableSQL.append(prefix);
			createTableSQL.append("(");
			createTableSQL.append(appendKeyValue);
			createTableSQL.append(")");
			appendKeyValue = null;
		}
	}
	
	String appendKeyValue = null;
	
	void appendKeyValue(String appendKeyValue) {
		this.appendKeyValue = appendKeyValue;
	}
}

Util util = new Util();

if(!storeAsAvro && !asSelect) {
	util.generateColumnsSQL(listColumn,createTableSQL);
	createTableSQL.append(")");
}

String tableComment = ElementParameterParser.getValue(node, "__TABLE_COMMENT__");
if(tableComment!=null && !"".equals(tableComment) && !"\"\"".equals(tableComment)) {

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(tableComment);
    stringBuffer.append(TEXT_290);
    
	createTableSQL.append(" COMMENT '");
	createTableSQL.append("\" + ");
	createTableSQL.append("tableComment_");
	createTableSQL.append(cid);
	createTableSQL.append(" + \"'");
}

if(setPartitioned) {
    if ((metadatas!=null)&&(metadatas.size()>0)) {
    	IMetadataTable metadata = metadatas.get(1);
    	if (metadata!=null) {
    		List<IMetadataColumn> columnList = metadata.getListColumns();
    		if(columnList != null && columnList.size() > 0) {
    			createTableSQL.append(" PARTITIONED BY (");
				util.generateColumnsSQL(columnList,createTableSQL);
    			createTableSQL.append(")");
    		}
    	}
    }
}

boolean clustededOrSkewed = "true".equals(ElementParameterParser.getValue(node, "__SET_CLUSTERED_BY_AND_SKEWED_BY__"));
if(clustededOrSkewed) {
	String ddl = ElementParameterParser.getValue(node, "__CLUSTERED_BY_AND_SKEWED_BY__");
	ddl = ddl.replaceAll("\n"," ");
	ddl = ddl.replaceAll("\r"," ");

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(ddl);
    stringBuffer.append(TEXT_293);
    
	createTableSQL.append(" \" + ");
	createTableSQL.append("clustededOrSkewed_");
	createTableSQL.append(cid);
	createTableSQL.append(" + \"");
}

if(storeAsAvro) {
	createTableSQL.append(" ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.avro.AvroSerDe'");
	util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
} else if(setRowFormat) {
	createTableSQL.append(" ROW FORMAT ");
	if(setDelimitedRowFormat) {
		createTableSQL.append("DELIMITED ");
		boolean setField = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_TERMINATED_BY__"));
		if(setField) {
    		String fieldChar = ElementParameterParser.getValue(node, "__FIELD_TERMINATED_BY__");

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(fieldChar);
    stringBuffer.append(TEXT_296);
    
    		createTableSQL.append(" FIELDS TERMINATED BY '");
    		createTableSQL.append("\" + ");
			createTableSQL.append("fieldChar_");
			createTableSQL.append(cid);
    		createTableSQL.append(" + \"'");
    		
    		boolean setEscape = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_ESCAPE_BY__"));
    		if(setEscape) {
    			String escapeChar = ElementParameterParser.getValue(node, "__FIELD_ESCAPE_BY__");

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_299);
    
	    		createTableSQL.append(" ESCAPED BY '");
        		createTableSQL.append("\" + ");
    			createTableSQL.append("escapeChar_");
    			createTableSQL.append(cid);
        		createTableSQL.append(" + \"'");
    		}
		}
		
		boolean setCollection = "true".equals(ElementParameterParser.getValue(node, "__SET_COLLECTION_ITEM_TERMINATED_BY__"));
		if(setCollection) {
    		String collectionChar = ElementParameterParser.getValue(node, "__COLLECTION_ITEM_TERMINATED_BY__");

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(collectionChar);
    stringBuffer.append(TEXT_302);
    
    		createTableSQL.append(" COLLECTION ITEMS TERMINATED BY '");
    		createTableSQL.append("\" + ");
			createTableSQL.append("collectionChar_");
			createTableSQL.append(cid);
    		createTableSQL.append(" + \"'");
		}
		
		boolean setMap = "true".equals(ElementParameterParser.getValue(node, "__SET_MAP_KEY_TERMINATED_BY__"));
		if(setMap) {
    		String mapChar = ElementParameterParser.getValue(node, "__MAP_KEY_TERMINATED_BY__");

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(mapChar);
    stringBuffer.append(TEXT_305);
    
    		createTableSQL.append(" MAP KEYS TERMINATED BY '");
    		createTableSQL.append("\" + ");
			createTableSQL.append("mapChar_");
			createTableSQL.append(cid);
    		createTableSQL.append(" + \"'");
		}
		
		boolean setLine = "true".equals(ElementParameterParser.getValue(node, "__SET_LINES_TERMINATED_BY__"));
		if(setLine) {
    		String lineChar = ElementParameterParser.getValue(node, "__LINES_TERMINATED_BY__");

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(lineChar);
    stringBuffer.append(TEXT_308);
    
    		createTableSQL.append(" LINES TERMINATED BY '");
    		createTableSQL.append("\" + ");
			createTableSQL.append("lineChar_");
			createTableSQL.append(cid);
    		createTableSQL.append(" + \"'");
		}
	} else {
		createTableSQL.append("SERDE \\\"");
		createTableSQL.append("\" + ");
		String serdeName = ElementParameterParser.getValue(node, "__SERDE_NAME__");

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(serdeName);
    stringBuffer.append(TEXT_311);
    
		createTableSQL.append("serdeName_");
		createTableSQL.append(cid);
		createTableSQL.append(" + \"\\\"");
		
		util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
	}
}

if(storeAsAvro) {
	createTableSQL.append(" STORED AS INPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat'");
	createTableSQL.append(" OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat'");
} else if(!"STORAGE".equals(storedFormat)) {
	createTableSQL.append(" STORED AS ");
	if("INPUTFORMAT_AND_OUTPUTFORMAT".equals(storedFormat)) {
		String inputClass = ElementParameterParser.getValue(node, "__INPUTFORMAT_CLASS__");
		String outputClass = ElementParameterParser.getValue(node, "__OUTPUTFORMAT_CLASS__");

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(inputClass);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(outputClass);
    stringBuffer.append(TEXT_316);
    
		createTableSQL.append("INPUTFORMAT '");
		createTableSQL.append("\" + ");
        createTableSQL.append("inputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
		
		createTableSQL.append(" OUTPUTFORMAT '");
		createTableSQL.append("\" + ");
        createTableSQL.append("outputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
	} else {
		createTableSQL.append(storedFormat);
	}
} else {
	String storageClass = ElementParameterParser.getValue(node, "__STORAGE_CLASS__");

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(storageClass);
    stringBuffer.append(TEXT_319);
    
	createTableSQL.append(" STORED BY '");
	createTableSQL.append("\" + ");
    createTableSQL.append("storageClass_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");
    
    util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
}

if(setLocation) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_322);
    
	createTableSQL.append(" LOCATION '");
	createTableSQL.append("\" + ");
	createTableSQL.append("location_");
	createTableSQL.append(cid);
	createTableSQL.append(" + \"'");
}

if(storeAsAvro) {
	StringBuilder avroSchemaBuilder = new StringBuilder();
	String quote = "\\\"";
	avroSchemaBuilder.append("'avro.schema.literal'='{").append(quote).append("name").append(quote).append(" : ").append(quote).append("row").append(quote)
	.append(", ").append(quote).append("type").append(quote).append(" : ").append(quote).append("record").append(quote)
	.append(", ").append(quote).append("fields").append(quote).append(" : [");
	util.generateAvroSchema(listColumn, avroSchemaBuilder, quote);
	avroSchemaBuilder.append("] }'");
	
	util.appendKeyValue(avroSchemaBuilder.toString());
}

util.generatePros(" TBLPROPERTIES ", tableProps, createTableSQL);

if(asSelect) {
	String sql = ElementParameterParser.getValue(node, "__SELECT__");
	sql = sql.replaceAll("\n"," ");
	sql = sql.replaceAll("\r"," ");

    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_325);
    
	createTableSQL.append(" AS ");
	createTableSQL.append("\" + ");
	createTableSQL.append("select_");
	createTableSQL.append(cid);
	createTableSQL.append(" + \"");
}

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    if(("true").equals(dieOnError)) {
	
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
	}else {
	
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    
	}
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    if(!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    }
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    return stringBuffer.toString();
  }
}
