package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class THiveInputBeginJava
{
  protected static String nl;
  public static synchronized THiveInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInputBeginJava result = new THiveInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work\");";
  protected final String TEXT_4 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_5 = " = new StringBuffer();";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Driver ClassName: ";
  protected final String TEXT_8 = ".\");";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_12 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_16 = " = log4jDebugParamters_";
  protected final String TEXT_17 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_18 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_23 = " = log4jDebugParamters_";
  protected final String TEXT_24 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_25 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_30 = " = log4jDebugParamters_";
  protected final String TEXT_31 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_32 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_37 = " = log4jDebugParamters_";
  protected final String TEXT_38 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_39 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_44 = " = log4jDebugParamters_";
  protected final String TEXT_45 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_46 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_49 = " = log4jDebugParamters_";
  protected final String TEXT_50 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_51 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_54 = " = log4jDebugParamters_";
  protected final String TEXT_55 = " + \"DBVERSION = ";
  protected final String TEXT_56 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_61 = " = log4jDebugParamters_";
  protected final String TEXT_62 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_63 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t";
  protected final String TEXT_65 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_66 = " = log4jDebugParamters_";
  protected final String TEXT_67 = " + \"USE_CURSOR = ";
  protected final String TEXT_68 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_71 = " = log4jDebugParamters_";
  protected final String TEXT_72 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_73 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_76 = " = log4jDebugParamters_";
  protected final String TEXT_77 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_78 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_83 = " = log4jDebugParamters_";
  protected final String TEXT_84 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_85 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_90 = " = log4jDebugParamters_";
  protected final String TEXT_91 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_92 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_94 = " = \"";
  protected final String TEXT_95 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_96 = ";";
  protected final String TEXT_97 = NL + "\t";
  protected final String TEXT_98 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_99 = " - Start to work.\");";
  protected final String TEXT_100 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_101 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_102 = ") {";
  protected final String TEXT_103 = NL + "                conn_";
  protected final String TEXT_104 = " = dataSources_";
  protected final String TEXT_105 = ".get(";
  protected final String TEXT_106 = ").getConnection();" + NL + "            } else {" + NL + "\t\t\t    java.lang.Class.forName(\"";
  protected final String TEXT_107 = "\");" + NL + "\t\t\t   \tString dbUser_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_114 = " - Start to work\");";
  protected final String TEXT_115 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_116 = " = new StringBuffer();";
  protected final String TEXT_117 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_118 = " - Driver ClassName: ";
  protected final String TEXT_119 = ".\");";
  protected final String TEXT_120 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_123 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_127 = " = log4jDebugParamters_";
  protected final String TEXT_128 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_129 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_132 = " = ";
  protected final String TEXT_133 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_134 = " = log4jDebugParamters_";
  protected final String TEXT_135 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_136 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_141 = " = log4jDebugParamters_";
  protected final String TEXT_142 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_143 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_148 = " = log4jDebugParamters_";
  protected final String TEXT_149 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_150 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_155 = " = log4jDebugParamters_";
  protected final String TEXT_156 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_157 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_160 = " = log4jDebugParamters_";
  protected final String TEXT_161 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_162 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_165 = " = log4jDebugParamters_";
  protected final String TEXT_166 = " + \"DBVERSION = ";
  protected final String TEXT_167 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_172 = " = log4jDebugParamters_";
  protected final String TEXT_173 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_174 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t";
  protected final String TEXT_176 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_177 = " = log4jDebugParamters_";
  protected final String TEXT_178 = " + \"USE_CURSOR = ";
  protected final String TEXT_179 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_182 = " = log4jDebugParamters_";
  protected final String TEXT_183 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_184 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_187 = " = log4jDebugParamters_";
  protected final String TEXT_188 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_189 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_194 = " = log4jDebugParamters_";
  protected final String TEXT_195 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_196 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_199 = " = ";
  protected final String TEXT_200 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_201 = " = log4jDebugParamters_";
  protected final String TEXT_202 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_203 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_205 = " = \"";
  protected final String TEXT_206 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_207 = ";";
  protected final String TEXT_208 = NL + "\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_211 = " - Connection attempt to '\" + url_";
  protected final String TEXT_212 = " + \"with the username '\"+ dbUser_";
  protected final String TEXT_213 = " +\"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\tconn_";
  protected final String TEXT_215 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_216 = ",dbUser_";
  protected final String TEXT_217 = ",dbPwd_";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\t\t\t\tconn_";
  protected final String TEXT_220 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_224 = " - Connection to '\" + url_";
  protected final String TEXT_225 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_226 = NL + "\t\t        ";
  protected final String TEXT_227 = NL + "\t\t    }";
  protected final String TEXT_228 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_229 = " = conn_";
  protected final String TEXT_230 = ".createStatement();";
  protected final String TEXT_231 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_232 = " = conn_";
  protected final String TEXT_233 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_235 = " = rs_";
  protected final String TEXT_236 = ".getString(column_index_";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "                        if(tmpContent_";
  protected final String TEXT_239 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_240 = " = tmpContent_";
  protected final String TEXT_241 = ";" + NL + "                        }";
  protected final String TEXT_242 = NL + "                    if(tmpContent_";
  protected final String TEXT_243 = " != null && tmpContent_";
  protected final String TEXT_244 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_245 = NL + "                        ";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " = tmpContent_";
  protected final String TEXT_248 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_249 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_250 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_251 = NL + "                                ";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_254 = NL + "                                ";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_257 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_258 = ")) {\t\t\t  \t\t";
  protected final String TEXT_259 = NL + "                                ";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_263 = " - Value is empty for column : '";
  protected final String TEXT_264 = "' in '";
  protected final String TEXT_265 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_267 = "' in '";
  protected final String TEXT_268 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_269 = NL + "                    }";
  protected final String TEXT_270 = NL + "\t\t\tif(rs_";
  protected final String TEXT_271 = ".getTimestamp(column_index_";
  protected final String TEXT_272 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " = new java.util.Date(rs_";
  protected final String TEXT_275 = ".getTimestamp(column_index_";
  protected final String TEXT_276 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_279 = NL + "            tmpContent_";
  protected final String TEXT_280 = " = rs_";
  protected final String TEXT_281 = ".getString(column_index_";
  protected final String TEXT_282 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_283 = " != null) {";
  protected final String TEXT_284 = NL + "                ";
  protected final String TEXT_285 = ".";
  protected final String TEXT_286 = " = tmpContent_";
  protected final String TEXT_287 = ";" + NL + "            } else {";
  protected final String TEXT_288 = NL + "                ";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = " = null;" + NL + "            }";
  protected final String TEXT_291 = NL + "            if(rs_";
  protected final String TEXT_292 = ".getObject(column_index_";
  protected final String TEXT_293 = ") != null) {";
  protected final String TEXT_294 = NL + "                ";
  protected final String TEXT_295 = ".";
  protected final String TEXT_296 = " = rs_";
  protected final String TEXT_297 = ".get";
  protected final String TEXT_298 = "(column_index_";
  protected final String TEXT_299 = ");" + NL + "            } else {";
  protected final String TEXT_300 = NL + "                    ";
  protected final String TEXT_301 = ".";
  protected final String TEXT_302 = " = null;";
  protected final String TEXT_303 = NL + "\t\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_305 = " - Null value in non-Nullable column\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_306 = "    " + NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_307 = NL + "            }";
  protected final String TEXT_308 = NL + "\t" + NL + "\t";
  protected final String TEXT_309 = NL + "\t\t\tString dbname_";
  protected final String TEXT_310 = " = (String)globalMap.get(\"";
  protected final String TEXT_311 = "\");" + NL + "        \tif(dbname_";
  protected final String TEXT_312 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_313 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_314 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_315 = " = conn_";
  protected final String TEXT_316 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_317 = ".execute(\"use \" + dbname_";
  protected final String TEXT_318 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_319 = ".close();" + NL + "        \t}" + NL + "        \t" + NL + "        \tString dbUser_";
  protected final String TEXT_320 = " = (String)globalMap.get(\"";
  protected final String TEXT_321 = "\");" + NL + "        \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_322 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "    \t\tif(dbUser_";
  protected final String TEXT_323 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_324 = ".trim())) {" + NL + "    \t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_325 = ");" + NL + "    \t\t\t//make relative file path work for hive" + NL + "    \t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_326 = ");" + NL + "    \t\t}";
  protected final String TEXT_327 = NL + "\t\t\tjava.sql.Statement init_";
  protected final String TEXT_328 = " = conn_";
  protected final String TEXT_329 = ".createStatement();";
  protected final String TEXT_330 = NL + "\t        \tinit_";
  protected final String TEXT_331 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_332 = ");" + NL + "\t\t    \tinit_";
  protected final String TEXT_333 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_334 = ");";
  protected final String TEXT_335 = NL + "            \tinit_";
  protected final String TEXT_336 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "            \tinit_";
  protected final String TEXT_337 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_338 = ");";
  protected final String TEXT_339 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_340 = ".execute(\"SET \"+";
  protected final String TEXT_341 = "+\"=\"+";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = NL + "\t\t\tinit_";
  protected final String TEXT_344 = ".close();" + NL + "\t\t\t" + NL + "        \tString dbname_";
  protected final String TEXT_345 = " = ";
  protected final String TEXT_346 = ";" + NL + "        \tif(dbname_";
  protected final String TEXT_347 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_348 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_349 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_350 = " = conn_";
  protected final String TEXT_351 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_352 = ".execute(\"use \" + dbname_";
  protected final String TEXT_353 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_354 = ".close();" + NL + "        \t}";
  protected final String TEXT_355 = NL + "    \t\t\tjava.sql.Statement statement_";
  protected final String TEXT_356 = " = conn_";
  protected final String TEXT_357 = ".createStatement();" + NL + "        \t\t";
  protected final String TEXT_358 = NL + "        \t\t\tstatement_";
  protected final String TEXT_359 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_360 = ");" + NL + "        \t\t";
  protected final String TEXT_361 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_362 = NL + "        \t\t\tstatement_";
  protected final String TEXT_363 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_364 = ");" + NL + "        \t\t";
  protected final String TEXT_365 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_366 = NL + "    \t\t\t\tstatement_";
  protected final String TEXT_367 = ".execute(\"add jar \"+";
  protected final String TEXT_368 = ");" + NL + "        \t\t";
  protected final String TEXT_369 = NL + "    \t\t\tstatement_";
  protected final String TEXT_370 = ".close();";
  protected final String TEXT_371 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_373 = " - The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_374 = NL + "\t\t\t\t\tthrow new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_375 = " " + NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_376 = " ,";
  protected final String TEXT_377 = "); ";
  protected final String TEXT_378 = " " + NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_379 = "); ";
  protected final String TEXT_380 = " " + NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_381 = "\", ";
  protected final String TEXT_382 = "); ";
  protected final String TEXT_383 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_384 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_385 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_386 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", ";
  protected final String TEXT_387 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_388 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_389 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_390 = ", ";
  protected final String TEXT_391 = ");";
  protected final String TEXT_392 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_393 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_394 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_395 = " + \":\" + ";
  protected final String TEXT_396 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_397 = " = \"jdbc:";
  protected final String TEXT_398 = "://\";";
  protected final String TEXT_399 = NL + "    \t\t\t\tif(dbUser_";
  protected final String TEXT_400 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_401 = ".trim())) {" + NL + "    \t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_402 = ");" + NL + "    \t\t\t\t\t//make relative file path work for hive" + NL + "    \t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_403 = ");" + NL + "    \t\t\t\t}";
  protected final String TEXT_404 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_405 = " = \"jdbc:";
  protected final String TEXT_406 = "://\" + ";
  protected final String TEXT_407 = " + \":\" + ";
  protected final String TEXT_408 = " + \"/\" + ";
  protected final String TEXT_409 = " + \";principal=\" + ";
  protected final String TEXT_410 = ";";
  protected final String TEXT_411 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_412 = " = \"jdbc:";
  protected final String TEXT_413 = "://\" + ";
  protected final String TEXT_414 = " + \":\" + ";
  protected final String TEXT_415 = " + \"/\" + ";
  protected final String TEXT_416 = ";";
  protected final String TEXT_417 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_418 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_419 = "); ";
  protected final String TEXT_420 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_421 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_422 = NL + "\t\t    int nb_line_";
  protected final String TEXT_423 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_424 = " = null;";
  protected final String TEXT_425 = NL + "\t\t        conn_";
  protected final String TEXT_426 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_427 = "\");" + NL + "\t\t        if (null == conn_";
  protected final String TEXT_428 = ") {";
  protected final String TEXT_429 = NL + "\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_430 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_431 = " = dataSources_";
  protected final String TEXT_432 = ".get(";
  protected final String TEXT_433 = ").getConnection();" + NL + "\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_434 = "\", conn_";
  protected final String TEXT_435 = ");" + NL + "\t\t        }" + NL + "\t\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_437 = " != null) {" + NL + "\t\t\t\t\t\tif(conn_";
  protected final String TEXT_438 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_439 = " - Uses an existing connection as \" + conn_";
  protected final String TEXT_440 = ".getMetaData().getUserName() + \". Connection URL: \" + conn_";
  protected final String TEXT_441 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_442 = NL + NL + "\t\t    ";
  protected final String TEXT_443 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_444 = " = ";
  protected final String TEXT_445 = ";";
  protected final String TEXT_446 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_447 = " - Executing the query: '\" + dbquery_";
  protected final String TEXT_448 = " + \"'.\");";
  protected final String TEXT_449 = NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_450 = "_QUERY\",dbquery_";
  protected final String TEXT_451 = ");" + NL + "\t\t    ";
  protected final String TEXT_452 = "\t\t    " + NL + "\t\ttry{";
  protected final String TEXT_453 = NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_454 = " = stmt_";
  protected final String TEXT_455 = ".executeQuery(dbquery_";
  protected final String TEXT_456 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_457 = " = rs_";
  protected final String TEXT_458 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_459 = " = rsmd_";
  protected final String TEXT_460 = ".getColumnCount();" + NL;
  protected final String TEXT_461 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_462 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_463 = ".setDbmsId(\"";
  protected final String TEXT_464 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_465 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_466 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_467 = ".add(\"";
  protected final String TEXT_468 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_469 = NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_472 = "; i <= rsmd_";
  protected final String TEXT_473 = ".getColumnCount()-";
  protected final String TEXT_474 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_475 = ".contains(rsmd_";
  protected final String TEXT_476 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_477 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_478 = ".setName(rsmd_";
  protected final String TEXT_479 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_480 = ".setDbName(rsmd_";
  protected final String TEXT_481 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_482 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_483 = "\", rsmd_";
  protected final String TEXT_484 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_485 = ".getPrecision(i), rsmd_";
  protected final String TEXT_486 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_487 = ".setDbType(rsmd_";
  protected final String TEXT_488 = ".getColumnTypeName(i));";
  protected final String TEXT_489 = NL + "                \tdcm_";
  protected final String TEXT_490 = ".setFormat(";
  protected final String TEXT_491 = ");";
  protected final String TEXT_492 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_493 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_494 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_495 = ".setLength(rsmd_";
  protected final String TEXT_496 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_497 = ".setLength(rsmd_";
  protected final String TEXT_498 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_499 = NL + "\t\t\tdcm_";
  protected final String TEXT_500 = ".setLength(rsmd_";
  protected final String TEXT_501 = ".getPrecision(i));";
  protected final String TEXT_502 = NL + "                \tdcm_";
  protected final String TEXT_503 = ".setPrecision(rsmd_";
  protected final String TEXT_504 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_505 = ".setNullable(rsmd_";
  protected final String TEXT_506 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_507 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_508 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_509 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_510 = ".metadatas.add(dcm_";
  protected final String TEXT_511 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_512 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_513 = " = null;" + NL + "\t\t    int column_index_";
  protected final String TEXT_514 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_515 = NL + "\t\t\t    StringBuffer log4jSb_";
  protected final String TEXT_516 = " = new StringBuffer();" + NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_517 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_518 = NL + "\t\t    while (rs_";
  protected final String TEXT_519 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_520 = "++;" + NL + "\t\t        ";
  protected final String TEXT_521 = NL + "\t\t                        column_index_";
  protected final String TEXT_522 = " = ";
  protected final String TEXT_523 = " + dcg_";
  protected final String TEXT_524 = ".getColumnCount(); " + NL + "\t\t                    ";
  protected final String TEXT_525 = NL + "\t\t                        column_index_";
  protected final String TEXT_526 = " = ";
  protected final String TEXT_527 = ";" + NL + "\t\t                    ";
  protected final String TEXT_528 = NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_529 = " < column_index_";
  protected final String TEXT_530 = ") {" + NL + "\t\t                        ";
  protected final String TEXT_531 = ".";
  protected final String TEXT_532 = " = ";
  protected final String TEXT_533 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_534 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_535 = "\t\t\t";
  protected final String TEXT_536 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_537 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_538 = NL + "\t\t                            ";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = " = (List)rs_";
  protected final String TEXT_541 = ".getObject(column_index_";
  protected final String TEXT_542 = ");";
  protected final String TEXT_543 = NL + "\t\t                         ";
  protected final String TEXT_544 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_545 = ".getObject(column_index_";
  protected final String TEXT_546 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_547 = NL + "                                    ";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = " = new Geometry(wktValue);";
  protected final String TEXT_550 = NL + "                                        ";
  protected final String TEXT_551 = ".";
  protected final String TEXT_552 = ".setEPSG(";
  protected final String TEXT_553 = ");";
  protected final String TEXT_554 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_555 = NL + "                                  ";
  protected final String TEXT_556 = ".";
  protected final String TEXT_557 = "=dcg_";
  protected final String TEXT_558 = ";";
  protected final String TEXT_559 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_560 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_561 = " = ";
  protected final String TEXT_562 = "; i_";
  protected final String TEXT_563 = "  <= rsmd_";
  protected final String TEXT_564 = ".getColumnCount(); i_";
  protected final String TEXT_565 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_566 = ".getColumnTypeName(i_";
  protected final String TEXT_567 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_568 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_569 = ".getClob(i_";
  protected final String TEXT_570 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_571 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_572 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_573 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_574 = ".add(tNTextImpl_";
  protected final String TEXT_575 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_576 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_577 = ".";
  protected final String TEXT_578 = ", rs_";
  protected final String TEXT_579 = ", fixedColumnCount_";
  protected final String TEXT_580 = ",list_";
  protected final String TEXT_581 = ");";
  protected final String TEXT_582 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_583 = ".";
  protected final String TEXT_584 = ", rs_";
  protected final String TEXT_585 = ", fixedColumnCount_";
  protected final String TEXT_586 = ");";
  protected final String TEXT_587 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_588 = ".getObject(column_index_";
  protected final String TEXT_589 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_590 = ".";
  protected final String TEXT_591 = " = new Geometry(sb.toString());";
  protected final String TEXT_592 = NL + "\t\t                          ";
  protected final String TEXT_593 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_594 = NL + "\t\t                    }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_595 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_596 = ".append(";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_600 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_601 = NL + "\t\t\t\t\t";
  protected final String TEXT_602 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_603 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_604 = " + \".\");" + NL + "\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_605 = " - Content of the record \" + nb_line_";
  protected final String TEXT_606 = " + \": \" + log4jSb_";
  protected final String TEXT_607 = ");" + NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_608 = ".delete(0,log4jSb_";
  protected final String TEXT_609 = ".length());" + NL + "\t\t\t\t\t";
  protected final String TEXT_610 = NL + "\t\t                            ";
  protected final String TEXT_611 = ".";
  protected final String TEXT_612 = " = ";
  protected final String TEXT_613 = ".";
  protected final String TEXT_614 = ";" + NL + "\t\t                            ";
  protected final String TEXT_615 = NL;
  protected final String TEXT_616 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
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

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_97);
    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	    	if(isLog4jEnabled){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    			}
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    }
	    
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_106);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_111);
    this.setURL(node);
    stringBuffer.append(TEXT_112);
    
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

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_119);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
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

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_208);
    log4jCodeGenerateUtil.debugConnectionParams(node,this.getDirverClassName(node));
    stringBuffer.append(TEXT_209);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    }
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
			} else {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
			}

    stringBuffer.append(TEXT_222);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    }
    stringBuffer.append(TEXT_226);
    this.afterUseNewConnection(node);
    stringBuffer.append(TEXT_227);
    
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_241);
    
                    }

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    
                        } else {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_261);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_268);
    
                        }

    stringBuffer.append(TEXT_269);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_278);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_290);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_300);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_302);
    
                } else {
                    
    stringBuffer.append(TEXT_303);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
        
                }
                
    stringBuffer.append(TEXT_307);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterGenertorType(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    stringBuffer.append(TEXT_308);
    
	class DBInputBeginUtil extends DefaultDBInputUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		private String hiveServer = "hive";
		
	
		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {
				super.createConnection(node, false);
			} else {
				super.createConnection(node);
			}
		}
		
		public void afterUseExistConnection(INode node) {
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	        String db = "db_" + connection;
	        String dbUser = "dbUser_" + connection;

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    
	    }

	    public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	    	hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			
			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion)))) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}
	    }
	    
		public void afterUseNewConnection(INode node) {
		
        	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			
        	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
        	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
        	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
        	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
        	
        	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
        	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
        	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    

		    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
		        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
		        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_334);
    
    		}
        	if(((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion)))) && setResourceManager) {
        		String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_338);
    
			}
			
            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        	if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_342);
    
				}
			}

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(dbname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
    		if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_360);
    }
    stringBuffer.append(TEXT_361);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_364);
    }
    stringBuffer.append(TEXT_365);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        			for(Map<String, String> jar : registerJarForHBase){
        				String path = jar.get("JAR_PATH");
        				if(path == null || "".equals(path) || "\"\"".equals(path)) {
        					continue;
        				}
        		
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_368);
    
        			}
        		}
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    		 	}
	    }
	
		public void setURL(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			
			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__"); 

			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdh4CanBeSecured = "Cloudera_CDH4".equals(hiveVersion) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || cdh4CanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			
			if(!isCustom && (("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			 || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MapR_EMR".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_371);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    }
    stringBuffer.append(TEXT_374);
    
			}
			
			if(hadoopProps.size() > 0){ 
				for(Map<String, String> item : hadoopProps){ 

    stringBuffer.append(TEXT_375);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_377);
     
				}  
			}
			
			if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion))) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__"); 

    stringBuffer.append(TEXT_378);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_379);
     
			} 
                        
			if(setNamenode) { 
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"); 

    stringBuffer.append(TEXT_380);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_382);
     
			}
			
			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				String metastorePassword = ElementParameterParser.getValue(node, "__METASTORE_PASSWORD__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_383);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(metastorePassword);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_388);
    
				if(useKeytab) {

    stringBuffer.append(TEXT_389);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_391);
    
				}
			}
			

    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    
			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_394);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_398);
    
				if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,Cloudera_CDH4,Cloudera_CDH4_YARN,PIVOTAL_HD_1_0_1".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    
				}
			} else {
				if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_410);
    
				} else {

    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_416);
    
				}
			}
		}
		
		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
		
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();
	
    stringBuffer.append(TEXT_417);
    
	CodeGeneratorArgument codeGenArg = (CodeGeneratorArgument) argument;
	INode hiveNode = (INode)codeGenArg.getArgument();
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(hiveNode, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(hiveNode, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_418);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_419);
     
	} 
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(hiveNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_420);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_421);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	        
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    
                    INode connectionNode = null;
                    for (INode processNode : node.getProcess().getGeneratingNodes()) {
                        if(connection.equals(processNode.getUniqueName())) {
                            connectionNode = processNode;
                            break;
                        }
                    }
                    String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_433);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
     } 
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_442);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_445);
    
			if(isLog4jEnabled && ("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    
			}

    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    
	if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_452);
    
	}

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
		    
		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_468);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_491);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    
		} else {

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    
		}

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
		    }
		    
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    }
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();
		                 
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		                    if(!("Dynamic").equals(typeToGenerate) && isDynamic && dynamic_index < currentColNo) {
		                    
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    }else{
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_527);
    }
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_533);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_534);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_535);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_536);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_537);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_538);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_543);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_549);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_550);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_552);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_553);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_554);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_555);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    
									}else{

    stringBuffer.append(TEXT_582);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_591);
    
                 	            } else {

    stringBuffer.append(TEXT_592);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_593);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_594);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_598);
    if(columnList.size() > currentColNo){
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    }
							}
      
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_601);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_610);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_612);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_614);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_615);
    stringBuffer.append(TEXT_616);
    return stringBuffer.toString();
  }
}
