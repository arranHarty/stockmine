package org.talend.designer.codegen.translators.databases.amazonrds.mysql;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IProcess;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TAmazonMysqlOutputMainJava {
  protected static String nl;
  public static synchronized TAmazonMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonMysqlOutputMainJava result = new TAmazonMysqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        ";
  protected final String TEXT_3 = NL + "            ";
  protected final String TEXT_4 = " = null;            ";
  protected final String TEXT_5 = NL + "\t\tif(nb_line_";
  protected final String TEXT_6 = "==0) {" + NL + "\t";
  protected final String TEXT_7 = NL + "    \t";
  protected final String TEXT_8 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_9 = " = conn_";
  protected final String TEXT_10 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Droping table '\" + tableName_";
  protected final String TEXT_13 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "            stmtDrop_";
  protected final String TEXT_15 = ".execute(\"";
  protected final String TEXT_16 = "\");" + NL + "        \t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_18 = " - Drop table '\" + tableName_";
  protected final String TEXT_19 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "            stmtDrop_";
  protected final String TEXT_21 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_22 = " = conn_";
  protected final String TEXT_23 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Creating table '\" + tableName_";
  protected final String TEXT_26 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_28 = ".execute(\"";
  protected final String TEXT_29 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ", \"";
  protected final String TEXT_32 = "\")+\")";
  protected final String TEXT_33 = "\");";
  protected final String TEXT_34 = "\t\t\t\t" + NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_35 = ".execute(\"";
  protected final String TEXT_36 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ", \"";
  protected final String TEXT_39 = "\")+\")";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_42 = ".execute(\"";
  protected final String TEXT_43 = ")\");";
  protected final String TEXT_44 = NL + "        \t";
  protected final String TEXT_45 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_46 = " - Create table '\" + tableName_";
  protected final String TEXT_47 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_49 = ".close();";
  protected final String TEXT_50 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_51 = " = conn_";
  protected final String TEXT_52 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_53 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Creating table '\" + tableName_";
  protected final String TEXT_55 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_57 = ".execute(\"";
  protected final String TEXT_58 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ", \"";
  protected final String TEXT_61 = "\")+\")";
  protected final String TEXT_62 = "\");";
  protected final String TEXT_63 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_64 = ".execute(\"";
  protected final String TEXT_65 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ", \"";
  protected final String TEXT_68 = "\")+\")";
  protected final String TEXT_69 = "\");";
  protected final String TEXT_70 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_71 = ".execute(\"";
  protected final String TEXT_72 = ")\");";
  protected final String TEXT_73 = NL + "        \t";
  protected final String TEXT_74 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_75 = " - Create table '\" + tableName_";
  protected final String TEXT_76 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "            stmtCreate_";
  protected final String TEXT_78 = ".close();";
  protected final String TEXT_79 = "\t         " + NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_80 = NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_81 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_82 = "+\"][\"+";
  protected final String TEXT_83 = "+\"][\"+";
  protected final String TEXT_84 = "+\"][\"+";
  protected final String TEXT_85 = "+\"][\"+";
  protected final String TEXT_86 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_87 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_88 = NL + "\t\t    // [%connection%][checktable][tableName]" + NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_89 = " = conn_";
  protected final String TEXT_90 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_91 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_92 = NL + "\t\t    " + NL + "\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_93 = ")== null){" + NL + "\t\t\t" + NL + "\t\t\t\tsynchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_94 = ")) {" + NL + "\t\t\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_95 = ")== null){";
  protected final String TEXT_96 = "              ";
  protected final String TEXT_97 = NL + "\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_98 = " = conn_";
  protected final String TEXT_99 = ".createStatement();" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_100 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tisExistStmt_";
  protected final String TEXT_101 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_102 = " + \"]\" );" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_103 = " = true;" + NL + "\t\t\t\t} catch (java.lang.Exception e){" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_104 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tisExistStmt_";
  protected final String TEXT_105 = ".close();";
  protected final String TEXT_106 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_108 = " = conn_";
  protected final String TEXT_109 = ".getMetaData();" + NL + "\t            if(tableNameForSearch_";
  protected final String TEXT_110 = ".indexOf(\"\\\"\")==-1){" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_111 = " = tableNameForSearch_";
  protected final String TEXT_112 = ".toUpperCase();" + NL + "            \t}else{" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_113 = " = tableNameForSearch_";
  protected final String TEXT_114 = ".replaceAll(\"\\\"\",\"\");" + NL + "            \t}" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_115 = " = dbMetaData_";
  protected final String TEXT_116 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_117 = ", tableNameForSearch_";
  protected final String TEXT_118 = ", new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_119 = " = false;" + NL + "\t            if(rsTable_";
  protected final String TEXT_120 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_121 = " = true;" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_122 = ".close();" + NL + "\t            ";
  protected final String TEXT_123 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_124 = " = conn_";
  protected final String TEXT_125 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_126 = " = dbMetaData_";
  protected final String TEXT_127 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_128 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_129 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_130 = " = rsTable_";
  protected final String TEXT_131 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_132 = " = rsTable_";
  protected final String TEXT_133 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_134 = ".equals";
  protected final String TEXT_135 = "IgnoreCase";
  protected final String TEXT_136 = "(";
  protected final String TEXT_137 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_138 = ".equals";
  protected final String TEXT_139 = "IgnoreCase";
  protected final String TEXT_140 = "(dbschema_";
  protected final String TEXT_141 = ") || dbschema_";
  protected final String TEXT_142 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_143 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_144 = ".close();";
  protected final String TEXT_145 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_146 = " = conn_";
  protected final String TEXT_147 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_148 = " = dbMetaData_";
  protected final String TEXT_149 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_150 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_151 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_152 = " = rsTable_";
  protected final String TEXT_153 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_154 = " = rsTable_";
  protected final String TEXT_155 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_156 = ".equals";
  protected final String TEXT_157 = "IgnoreCase";
  protected final String TEXT_158 = "(";
  protected final String TEXT_159 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_160 = ".equals";
  protected final String TEXT_161 = "IgnoreCase";
  protected final String TEXT_162 = "(dbschema_";
  protected final String TEXT_163 = ") || (dbschema_";
  protected final String TEXT_164 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_165 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_166 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_167 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_168 = ".close();";
  protected final String TEXT_169 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_170 = " = conn_";
  protected final String TEXT_171 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_172 = " = dbMetaData_";
  protected final String TEXT_173 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_174 = " = false;" + NL + "\t            String defaultSchema_";
  protected final String TEXT_175 = " = \"public\";" + NL + "\t            if(dbschema_";
  protected final String TEXT_176 = " == null || dbschema_";
  protected final String TEXT_177 = ".trim().length() == 0) {" + NL + "\t            \tjava.sql.Statement stmtSchema_";
  protected final String TEXT_178 = " = conn_";
  protected final String TEXT_179 = ".createStatement();" + NL + "\t            \tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_180 = " = stmtSchema_";
  protected final String TEXT_181 = ".executeQuery(\"select current_schema() \");" + NL + "\t            \twhile(rsSchema_";
  protected final String TEXT_182 = ".next()){" + NL + "\t            \t\tdefaultSchema_";
  protected final String TEXT_183 = " = rsSchema_";
  protected final String TEXT_184 = ".getString(\"current_schema\");" + NL + "\t            \t}" + NL + "\t            \trsSchema_";
  protected final String TEXT_185 = ".close();" + NL + "\t            \tstmtSchema_";
  protected final String TEXT_186 = ".close();" + NL + "\t            }" + NL + "\t            while(rsTable_";
  protected final String TEXT_187 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_188 = " = rsTable_";
  protected final String TEXT_189 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_190 = " = rsTable_";
  protected final String TEXT_191 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_192 = ".equals";
  protected final String TEXT_193 = "IgnoreCase";
  protected final String TEXT_194 = "(";
  protected final String TEXT_195 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_196 = ".equals";
  protected final String TEXT_197 = "IgnoreCase";
  protected final String TEXT_198 = "(dbschema_";
  protected final String TEXT_199 = ") || ((dbschema_";
  protected final String TEXT_200 = " ==null || dbschema_";
  protected final String TEXT_201 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_202 = ".equals";
  protected final String TEXT_203 = "IgnoreCase";
  protected final String TEXT_204 = "(schema_";
  protected final String TEXT_205 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_206 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_207 = ".close();";
  protected final String TEXT_208 = "      " + NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_209 = " = conn_";
  protected final String TEXT_210 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_211 = " = dbMetaData_";
  protected final String TEXT_212 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_213 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_214 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_215 = " = rsTable_";
  protected final String TEXT_216 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_217 = ".equalsIgnoreCase(";
  protected final String TEXT_218 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_219 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_220 = ".close();";
  protected final String TEXT_221 = NL + "                if(!whetherExist_";
  protected final String TEXT_222 = ") {" + NL + "                    java.sql.Statement stmtCreate_";
  protected final String TEXT_223 = " = conn_";
  protected final String TEXT_224 = ".createStatement();" + NL + "        \t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_226 = " - Creating table '\" + tableName_";
  protected final String TEXT_227 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_229 = ".execute(\"";
  protected final String TEXT_230 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = ", \"";
  protected final String TEXT_233 = "\")+\")";
  protected final String TEXT_234 = "\");";
  protected final String TEXT_235 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_236 = ".execute(\"";
  protected final String TEXT_237 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = ", \"";
  protected final String TEXT_240 = "\")+\")";
  protected final String TEXT_241 = "\");";
  protected final String TEXT_242 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_243 = ".execute(\"";
  protected final String TEXT_244 = ")\");";
  protected final String TEXT_245 = NL + "    \t\t   \t";
  protected final String TEXT_246 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_247 = " - Create table '\" + tableName_";
  protected final String TEXT_248 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_249 = NL + "                    stmtCreate_";
  protected final String TEXT_250 = ".close();            " + NL + "                }                ";
  protected final String TEXT_251 = NL + "                if(whetherExist_";
  protected final String TEXT_252 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_253 = " = conn_";
  protected final String TEXT_254 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_256 = " - Droping table '\" + tableName_";
  protected final String TEXT_257 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_258 = NL + "                    stmtDrop_";
  protected final String TEXT_259 = ".execute(\"";
  protected final String TEXT_260 = "\");" + NL + "\t    \t    \t";
  protected final String TEXT_261 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_262 = " - Drop table '\" + tableName_";
  protected final String TEXT_263 = "+ \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_264 = NL + "                    stmtDrop_";
  protected final String TEXT_265 = ".close();" + NL + "                }" + NL + "                java.sql.Statement stmtCreate_";
  protected final String TEXT_266 = " = conn_";
  protected final String TEXT_267 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_268 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_269 = " - Creating table '\" + tableName_";
  protected final String TEXT_270 = " + \"'.\" );" + NL + "\t\t\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_272 = ".execute(\"";
  protected final String TEXT_273 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = ", \"";
  protected final String TEXT_276 = "\")+\")";
  protected final String TEXT_277 = "\");";
  protected final String TEXT_278 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_279 = ".execute(\"";
  protected final String TEXT_280 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_281 = ".";
  protected final String TEXT_282 = ", \"";
  protected final String TEXT_283 = "\")+\")";
  protected final String TEXT_284 = "\");";
  protected final String TEXT_285 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_286 = ".execute(\"";
  protected final String TEXT_287 = ")\");";
  protected final String TEXT_288 = NL + "\t    \t    \t";
  protected final String TEXT_289 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_290 = " - Create table '\" + tableName_";
  protected final String TEXT_291 = " + \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_292 = NL + "                stmtCreate_";
  protected final String TEXT_293 = ".close();";
  protected final String TEXT_294 = NL + "\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_295 = ", true);" + NL + "" + NL + "\t\t\t\t\t} // end of if" + NL + "\t\t\t\t} // end synchronized" + NL + "\t\t\t}";
  protected final String TEXT_296 = "            ";
  protected final String TEXT_297 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_298 = " = conn_";
  protected final String TEXT_299 = ".createStatement();" + NL + "    \t   ";
  protected final String TEXT_300 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_301 = " - Clearing table '\" + tableName_";
  protected final String TEXT_302 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_303 = NL + "            stmtClear_";
  protected final String TEXT_304 = ".executeUpdate(\"";
  protected final String TEXT_305 = "\");" + NL + "   \t    \t";
  protected final String TEXT_306 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_307 = "- Clear table '\" + tableName_";
  protected final String TEXT_308 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_309 = NL + "            stmtClear_";
  protected final String TEXT_310 = ".close();";
  protected final String TEXT_311 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_312 = " = conn_";
  protected final String TEXT_313 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_314 = " = stmtTruncCount_";
  protected final String TEXT_315 = ".executeQuery(\"";
  protected final String TEXT_316 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_317 = " = conn_";
  protected final String TEXT_318 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_319 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_320 = " - Trancating table '\" + tableName_";
  protected final String TEXT_321 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\tconn_";
  protected final String TEXT_324 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_325 = NL + "            stmtTrunc_";
  protected final String TEXT_326 = ".executeUpdate(\"";
  protected final String TEXT_327 = "\");" + NL + "   \t    \t";
  protected final String TEXT_328 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_329 = " - Truncate table '\" + tableName_";
  protected final String TEXT_330 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_331 = NL + "            while(rsTruncCount_";
  protected final String TEXT_332 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_333 = " += rsTruncCount_";
  protected final String TEXT_334 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_335 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_336 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_337 = ".close();            ";
  protected final String TEXT_338 = NL + "\t\t \tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_339 = " = conn_";
  protected final String TEXT_340 = ".createStatement();" + NL + "\t\t \tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_341 = " = stmtTruncCount_";
  protected final String TEXT_342 = ".executeQuery(\"";
  protected final String TEXT_343 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_344 = " = conn_";
  protected final String TEXT_345 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_346 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_347 = " - Truncating reuse stroage table '\" + tableName_";
  protected final String TEXT_348 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t";
  protected final String TEXT_350 = NL + "\t\t\tconn_";
  protected final String TEXT_351 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_352 = NL + "            stmtTrunc_";
  protected final String TEXT_353 = ".executeUpdate(\"";
  protected final String TEXT_354 = "\");" + NL + "   \t    \t";
  protected final String TEXT_355 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_356 = " - Truncate reuse stroage table '\" + tableName_";
  protected final String TEXT_357 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_358 = NL + "             while(rsTruncCount_";
  protected final String TEXT_359 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_360 = " += rsTruncCount_";
  protected final String TEXT_361 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_362 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_363 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_364 = ".close();";
  protected final String TEXT_365 = NL + "\t\t\tStringBuffer duplidateClause_";
  protected final String TEXT_366 = " = new StringBuffer(\" ON DUPLICATE KEY UPDATE \");\t" + NL + "\t\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_368 = ".append(\",\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_369 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_370 = ".append (\"`\" +  ";
  protected final String TEXT_371 = " + \"`\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_372 = ".append (\"=\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_373 = ".append (";
  protected final String TEXT_374 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\t\t       ";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_377 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_378 = " + \"` (";
  protected final String TEXT_379 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_380 = ".";
  protected final String TEXT_381 = ", \"";
  protected final String TEXT_382 = "\")+\") VALUES (";
  protected final String TEXT_383 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_384 = ".";
  protected final String TEXT_385 = ")+\")\";";
  protected final String TEXT_386 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_387 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_388 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_389 = ".";
  protected final String TEXT_390 = ", \"";
  protected final String TEXT_391 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_392 = ".";
  protected final String TEXT_393 = ")+\")\";";
  protected final String TEXT_394 = "            " + NL + "\t\t\t\tinsert_";
  protected final String TEXT_395 = " += \tduplidateClause_";
  protected final String TEXT_396 = ".toString();";
  protected final String TEXT_397 = NL + "\t\t\t\t";
  protected final String TEXT_398 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_399 = " = new StringBuffer(insert_";
  protected final String TEXT_400 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_401 = ".insert(insert_";
  protected final String TEXT_402 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_403 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_404 = " =insertStringBuffer_";
  protected final String TEXT_405 = ".toString(); ";
  protected final String TEXT_406 = "    " + NL;
  protected final String TEXT_407 = NL + "                        pstmt_";
  protected final String TEXT_408 = " = conn_";
  protected final String TEXT_409 = ".prepareStatement(insert_";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "                        ";
  protected final String TEXT_412 = NL + "                \t\tpstmt_";
  protected final String TEXT_413 = " = null;         " + NL + "                        // [%connection%][psmt][tableName]" + NL + "                        String keyPsmt_";
  protected final String TEXT_414 = " = conn_";
  protected final String TEXT_415 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_416 = " + \"]\";" + NL + "                \t\tif(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_417 = ")== null){" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_418 = " = conn_";
  protected final String TEXT_419 = ".prepareStatement(insert_";
  protected final String TEXT_420 = ");\t\t" + NL + "                \t\t\tGlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_421 = ", pstmt_";
  protected final String TEXT_422 = ");" + NL + "                \t\t}else{" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_423 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_424 = ");\t\t\t\t" + NL + "                \t\t}";
  protected final String TEXT_425 = NL + "\t        \t        ";
  protected final String TEXT_426 = "\t            " + NL + "\t            ////////////////////////////////////////////////////////////////////////////////////////////" + NL + "\t            " + NL + "\t            " + NL + "\t            StringBuilder extendInsertValueStmt_";
  protected final String TEXT_427 = " = new StringBuilder();" + NL + "                for(int i=0;i < ";
  protected final String TEXT_428 = ";i++){";
  protected final String TEXT_429 = NL + "                    extendInsertValueStmt_";
  protected final String TEXT_430 = ".append(\"(";
  protected final String TEXT_431 = ",\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_432 = ".";
  protected final String TEXT_433 = ")+\")\");";
  protected final String TEXT_434 = NL + "\t\t\t\t    extendInsertValueStmt_";
  protected final String TEXT_435 = ".append(\"(";
  protected final String TEXT_436 = ")\");";
  protected final String TEXT_437 = NL + "                if (i!=";
  protected final String TEXT_438 = "-1) extendInsertValueStmt_";
  protected final String TEXT_439 = ".append(\",\");" + NL + "                }";
  protected final String TEXT_440 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_441 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_442 = " + \"` (";
  protected final String TEXT_443 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_444 = ".";
  protected final String TEXT_445 = ", \"";
  protected final String TEXT_446 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_447 = ".toString();";
  protected final String TEXT_448 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_449 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_450 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = ", \"";
  protected final String TEXT_453 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_454 = ".toString();";
  protected final String TEXT_455 = "            " + NL + "\t\t\t\t    insert_";
  protected final String TEXT_456 = " += \tduplidateClause_";
  protected final String TEXT_457 = ".toString();";
  protected final String TEXT_458 = NL + "\t\t\t\t\t";
  protected final String TEXT_459 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_460 = " = new StringBuffer(insert_";
  protected final String TEXT_461 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_462 = ".insert(insert_";
  protected final String TEXT_463 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_464 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_465 = " =insertStringBuffer_";
  protected final String TEXT_466 = ".toString(); ";
  protected final String TEXT_467 = "    " + NL + "\t\t\t\t    pstmt_";
  protected final String TEXT_468 = " =  conn_";
  protected final String TEXT_469 = ".prepareStatement(insert_";
  protected final String TEXT_470 = ");";
  protected final String TEXT_471 = NL + "\t\t    " + NL + "\t\t\t\t    insertColName";
  protected final String TEXT_472 = " = \"";
  protected final String TEXT_473 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_474 = ".";
  protected final String TEXT_475 = ", \"";
  protected final String TEXT_476 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_477 = " =  \"";
  protected final String TEXT_478 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = "); ";
  protected final String TEXT_481 = NL + "\t      \t\t\tinsertColName";
  protected final String TEXT_482 = " = DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_483 = ".";
  protected final String TEXT_484 = ", \"";
  protected final String TEXT_485 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_486 = " =  DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_487 = ".";
  protected final String TEXT_488 = "); ";
  protected final String TEXT_489 = NL + "\t\t\t    rowCount";
  protected final String TEXT_490 = " = 0;";
  protected final String TEXT_491 = NL + "\t            int rowCount";
  protected final String TEXT_492 = " = 0;\t ";
  protected final String TEXT_493 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_494 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_495 = " + \"` (";
  protected final String TEXT_496 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_497 = ".";
  protected final String TEXT_498 = ", \"";
  protected final String TEXT_499 = "\")+\") VALUES (";
  protected final String TEXT_500 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_501 = ".";
  protected final String TEXT_502 = ")+\")\";";
  protected final String TEXT_503 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_504 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_505 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = ", \"";
  protected final String TEXT_508 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_509 = ".";
  protected final String TEXT_510 = ")+\")\";";
  protected final String TEXT_511 = "            " + NL + "\t\t\t\t\t    insert_";
  protected final String TEXT_512 = " += \tduplidateClause_";
  protected final String TEXT_513 = ".toString();";
  protected final String TEXT_514 = NL + "\t\t\t\t\t    batchSize_";
  protected final String TEXT_515 = " = ";
  protected final String TEXT_516 = ";" + NL + "\t\t   \t\t\t    batchSizeCounter_";
  protected final String TEXT_517 = "=0;";
  protected final String TEXT_518 = NL + "\t\t\t\t\t    int batchSize_";
  protected final String TEXT_519 = " = ";
  protected final String TEXT_520 = ";" + NL + "\t\t   \t\t\t    int batchSizeCounter_";
  protected final String TEXT_521 = "=0;";
  protected final String TEXT_522 = NL + "\t\t        ";
  protected final String TEXT_523 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_524 = " = new StringBuffer(insert_";
  protected final String TEXT_525 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_526 = ".insert(insert_";
  protected final String TEXT_527 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_528 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_529 = " =insertStringBuffer_";
  protected final String TEXT_530 = ".toString(); ";
  protected final String TEXT_531 = "    " + NL + "\t\t        pstmt_";
  protected final String TEXT_532 = " = conn_";
  protected final String TEXT_533 = ".prepareStatement(insert_";
  protected final String TEXT_534 = ");" + NL + "\t\t        " + NL + "\t\t\t\t";
  protected final String TEXT_535 = NL + "\t\t\t\tString update_";
  protected final String TEXT_536 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_537 = " + \"` SET ";
  protected final String TEXT_538 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = ", \"";
  protected final String TEXT_541 = "\")+\" WHERE ";
  protected final String TEXT_542 = "\";";
  protected final String TEXT_543 = NL + "\t\t\t\tString update_";
  protected final String TEXT_544 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_545 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = ", \"";
  protected final String TEXT_548 = "\")+\" WHERE ";
  protected final String TEXT_549 = "\";";
  protected final String TEXT_550 = NL + "\t    ";
  protected final String TEXT_551 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_552 = " = new StringBuffer(update_";
  protected final String TEXT_553 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_554 = ".insert(update_";
  protected final String TEXT_555 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_556 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_557 = " =updateStringBuffer_";
  protected final String TEXT_558 = ".toString(); ";
  protected final String TEXT_559 = NL + "\t    pstmt_";
  protected final String TEXT_560 = " = conn_";
  protected final String TEXT_561 = ".prepareStatement(update_";
  protected final String TEXT_562 = ");" + NL + "\t    ";
  protected final String TEXT_563 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_564 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_565 = " + \"` (";
  protected final String TEXT_566 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_567 = ".";
  protected final String TEXT_568 = ", \"";
  protected final String TEXT_569 = "\")+\") VALUES (";
  protected final String TEXT_570 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_571 = ".";
  protected final String TEXT_572 = ")+\")\";";
  protected final String TEXT_573 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_574 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_575 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_576 = ".";
  protected final String TEXT_577 = ", \"";
  protected final String TEXT_578 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_579 = ".";
  protected final String TEXT_580 = ")+\")\";";
  protected final String TEXT_581 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_582 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_583 = " + \"` SET ";
  protected final String TEXT_584 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_585 = ".";
  protected final String TEXT_586 = ", \"";
  protected final String TEXT_587 = "\")+\" WHERE ";
  protected final String TEXT_588 = "\";";
  protected final String TEXT_589 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_590 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_591 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_592 = ".";
  protected final String TEXT_593 = ", \"";
  protected final String TEXT_594 = "\")+\" WHERE ";
  protected final String TEXT_595 = "\";";
  protected final String TEXT_596 = NL + "\t    pstmt_";
  protected final String TEXT_597 = " = conn_";
  protected final String TEXT_598 = ".prepareStatement(\"SELECT COUNT(1) FROM `\" + ";
  protected final String TEXT_599 = " + \"` WHERE ";
  protected final String TEXT_600 = "\");//String insert_";
  protected final String TEXT_601 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_602 = " + \"` (";
  protected final String TEXT_603 = ") VALUES (";
  protected final String TEXT_604 = ")\";" + NL + "\t    ";
  protected final String TEXT_605 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_606 = " = new StringBuffer(insert_";
  protected final String TEXT_607 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_608 = ".insert(insert_";
  protected final String TEXT_609 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_610 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_611 = " =insertStringBuffer_";
  protected final String TEXT_612 = ".toString(); ";
  protected final String TEXT_613 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_614 = " = conn_";
  protected final String TEXT_615 = ".prepareStatement(insert_";
  protected final String TEXT_616 = ");" + NL + "\t    ";
  protected final String TEXT_617 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_618 = " = new StringBuffer(update_";
  protected final String TEXT_619 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_620 = ".insert(update_";
  protected final String TEXT_621 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_622 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_623 = " =updateStringBuffer_";
  protected final String TEXT_624 = ".toString(); ";
  protected final String TEXT_625 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_626 = " = conn_";
  protected final String TEXT_627 = ".prepareStatement(update_";
  protected final String TEXT_628 = ");\t\t" + NL + "\t    ";
  protected final String TEXT_629 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_630 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_631 = " + \"` (";
  protected final String TEXT_632 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_633 = ".";
  protected final String TEXT_634 = ", \"";
  protected final String TEXT_635 = "\")+\") VALUES (";
  protected final String TEXT_636 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_637 = ".";
  protected final String TEXT_638 = ")+\")\";";
  protected final String TEXT_639 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_640 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_641 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = ", \"";
  protected final String TEXT_644 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_645 = ".";
  protected final String TEXT_646 = ")+\")\";";
  protected final String TEXT_647 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_648 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_649 = " + \"` SET ";
  protected final String TEXT_650 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_651 = ".";
  protected final String TEXT_652 = ", \"";
  protected final String TEXT_653 = "\")+\" WHERE ";
  protected final String TEXT_654 = "\";";
  protected final String TEXT_655 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_656 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_657 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_658 = ".";
  protected final String TEXT_659 = ", \"";
  protected final String TEXT_660 = "\")+\" WHERE ";
  protected final String TEXT_661 = "\";";
  protected final String TEXT_662 = NL + "\t    ";
  protected final String TEXT_663 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_664 = " = new StringBuffer(update_";
  protected final String TEXT_665 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_666 = ".insert(update_";
  protected final String TEXT_667 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_668 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_669 = " =updateStringBuffer_";
  protected final String TEXT_670 = ".toString(); ";
  protected final String TEXT_671 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_672 = " = conn_";
  protected final String TEXT_673 = ".prepareStatement(update_";
  protected final String TEXT_674 = ");" + NL + "\t    ";
  protected final String TEXT_675 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_676 = " = new StringBuffer(insert_";
  protected final String TEXT_677 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_678 = ".insert(insert_";
  protected final String TEXT_679 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_680 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_681 = " =insertStringBuffer_";
  protected final String TEXT_682 = ".toString(); ";
  protected final String TEXT_683 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_684 = " = conn_";
  protected final String TEXT_685 = ".prepareStatement(insert_";
  protected final String TEXT_686 = ");\t\t\t\t" + NL + "\t    ";
  protected final String TEXT_687 = NL + "\t    String delete_";
  protected final String TEXT_688 = " = \"DELETE  FROM `\" + ";
  protected final String TEXT_689 = " + \"` WHERE ";
  protected final String TEXT_690 = "\";" + NL + "\t    ";
  protected final String TEXT_691 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_692 = " = new StringBuffer(delete_";
  protected final String TEXT_693 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_694 = ".insert(delete_";
  protected final String TEXT_695 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_696 = "  + \" \" );" + NL + "    delete_";
  protected final String TEXT_697 = " =deleteStringBuffer_";
  protected final String TEXT_698 = ".toString();  ";
  protected final String TEXT_699 = NL + "\t    pstmt_";
  protected final String TEXT_700 = " = conn_";
  protected final String TEXT_701 = ".prepareStatement(delete_";
  protected final String TEXT_702 = ");" + NL + "\t    ";
  protected final String TEXT_703 = NL + "\t    String replace_";
  protected final String TEXT_704 = " = \"REPLACE INTO `\" + ";
  protected final String TEXT_705 = " + \"` (";
  protected final String TEXT_706 = ") VALUES (";
  protected final String TEXT_707 = ")\";" + NL + "\t    pstmt_";
  protected final String TEXT_708 = " = conn_";
  protected final String TEXT_709 = ".prepareStatement(replace_";
  protected final String TEXT_710 = ");" + NL + "\t    ";
  protected final String TEXT_711 = NL + "\t    String insertIgnore_";
  protected final String TEXT_712 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_713 = " + \"` (";
  protected final String TEXT_714 = ") VALUES (";
  protected final String TEXT_715 = ") ON DUPLICATE KEY UPDATE ";
  protected final String TEXT_716 = "\";" + NL + "\t    pstmt_";
  protected final String TEXT_717 = " = conn_";
  protected final String TEXT_718 = ".prepareStatement(insertIgnore_";
  protected final String TEXT_719 = ");" + NL + "\t    ";
  protected final String TEXT_720 = NL + "\t    String insert_";
  protected final String TEXT_721 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_722 = " + \"` (";
  protected final String TEXT_723 = ") VALUES (";
  protected final String TEXT_724 = ")\";" + NL + "\t    ";
  protected final String TEXT_725 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_726 = " = new StringBuffer(insert_";
  protected final String TEXT_727 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_728 = ".insert(insert_";
  protected final String TEXT_729 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_730 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_731 = " =insertStringBuffer_";
  protected final String TEXT_732 = ".toString(); ";
  protected final String TEXT_733 = "    " + NL + "\t    pstmt_";
  protected final String TEXT_734 = " = conn_";
  protected final String TEXT_735 = ".prepareStatement(insert_";
  protected final String TEXT_736 = ");" + NL + "\t    ";
  protected final String TEXT_737 = NL + "        StringBuffer query_";
  protected final String TEXT_738 = " = null;" + NL + "       \t";
  protected final String TEXT_739 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_740 = " = insert_";
  protected final String TEXT_741 = ".split(\"\\\\?\");";
  protected final String TEXT_742 = NL + "\t\t\tupdate_";
  protected final String TEXT_743 = " += \" \";" + NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_744 = " = update_";
  protected final String TEXT_745 = ".split(\"\\\\?\");";
  protected final String TEXT_746 = NL + "\t\t\tupdate_";
  protected final String TEXT_747 = " += \" \";" + NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_748 = " = update_";
  protected final String TEXT_749 = ".split(\"\\\\?\");" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_750 = " = insert_";
  protected final String TEXT_751 = ".split(\"\\\\?\");";
  protected final String TEXT_752 = NL + "\t\t\tdelete_";
  protected final String TEXT_753 = " += \" \";" + NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_754 = " = delete_";
  protected final String TEXT_755 = ".split(\"\\\\?\");";
  protected final String TEXT_756 = NL + "\t\t\treplace_";
  protected final String TEXT_757 = " += \" \";" + NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_758 = " = replace_";
  protected final String TEXT_759 = ".split(\"\\\\?\");";
  protected final String TEXT_760 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_761 = " += \" \";" + NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_762 = " = insertIgnore_";
  protected final String TEXT_763 = ".split(\"\\\\?\");";
  protected final String TEXT_764 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_765 = " = insert_";
  protected final String TEXT_766 = ".split(\"\\\\?\");";
  protected final String TEXT_767 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_768 = NL + "    ";
  protected final String TEXT_769 = NL + "                if(";
  protected final String TEXT_770 = ".";
  protected final String TEXT_771 = "==null){";
  protected final String TEXT_772 = NL + "                    ";
  protected final String TEXT_773 = ".setNull(counter";
  protected final String TEXT_774 = ",java.sql.Types.CHAR);";
  protected final String TEXT_775 = NL + "                if(";
  protected final String TEXT_776 = ".";
  protected final String TEXT_777 = "==null){";
  protected final String TEXT_778 = NL + "                    ";
  protected final String TEXT_779 = ".setNull(counter";
  protected final String TEXT_780 = ",java.sql.Types.DATE);";
  protected final String TEXT_781 = NL + "                if(";
  protected final String TEXT_782 = ".";
  protected final String TEXT_783 = "==null){";
  protected final String TEXT_784 = NL + "                    ";
  protected final String TEXT_785 = ".setNull(counter";
  protected final String TEXT_786 = ",java.sql.Types.ARRAY);         ";
  protected final String TEXT_787 = NL + "                if(";
  protected final String TEXT_788 = ".";
  protected final String TEXT_789 = "==null){";
  protected final String TEXT_790 = NL + "                    ";
  protected final String TEXT_791 = ".setNull(counter";
  protected final String TEXT_792 = ",java.sql.Types.INTEGER);";
  protected final String TEXT_793 = NL + "                if(";
  protected final String TEXT_794 = ".";
  protected final String TEXT_795 = "==null){";
  protected final String TEXT_796 = NL + "                    ";
  protected final String TEXT_797 = ".setNull(counter";
  protected final String TEXT_798 = ",java.sql.Types.VARCHAR);";
  protected final String TEXT_799 = NL + "                if(";
  protected final String TEXT_800 = ".";
  protected final String TEXT_801 = "==null){";
  protected final String TEXT_802 = NL + "                    ";
  protected final String TEXT_803 = ".setNull(counter";
  protected final String TEXT_804 = ",java.sql.Types.OTHER);";
  protected final String TEXT_805 = NL + "                if(";
  protected final String TEXT_806 = ".";
  protected final String TEXT_807 = "==null){";
  protected final String TEXT_808 = NL + "                    ";
  protected final String TEXT_809 = ".setNull(counter";
  protected final String TEXT_810 = ",java.sql.Types.BOOLEAN);   ";
  protected final String TEXT_811 = NL + "                if(";
  protected final String TEXT_812 = ".";
  protected final String TEXT_813 = "==null){";
  protected final String TEXT_814 = NL + "                    ";
  protected final String TEXT_815 = ".setNull(counter";
  protected final String TEXT_816 = ",java.sql.Types.DOUBLE);    ";
  protected final String TEXT_817 = NL + "                if(";
  protected final String TEXT_818 = ".";
  protected final String TEXT_819 = "==null){";
  protected final String TEXT_820 = NL + "                    ";
  protected final String TEXT_821 = ".setNull(counter";
  protected final String TEXT_822 = ",java.sql.Types.FLOAT); ";
  protected final String TEXT_823 = NL + "                }else{";
  protected final String TEXT_824 = NL + "                    if(";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = "==null){";
  protected final String TEXT_827 = NL + "                    if((\"null\").equals(String.valueOf(";
  protected final String TEXT_828 = ".";
  protected final String TEXT_829 = ").toLowerCase())){";
  protected final String TEXT_830 = NL + "                ";
  protected final String TEXT_831 = ".setNull(counter";
  protected final String TEXT_832 = ",java.sql.Types.CHAR);" + NL + "            " + NL + "                }else if(";
  protected final String TEXT_833 = ".";
  protected final String TEXT_834 = " == '\\0'){" + NL + "        ";
  protected final String TEXT_835 = NL + "                    ";
  protected final String TEXT_836 = ".setString(counter";
  protected final String TEXT_837 = ",\"\");" + NL + "            " + NL + "                }else{" + NL + "            ";
  protected final String TEXT_838 = NL + "                    ";
  protected final String TEXT_839 = ".setString(counter";
  protected final String TEXT_840 = ",String.valueOf(";
  protected final String TEXT_841 = ".";
  protected final String TEXT_842 = "));" + NL + "                }";
  protected final String TEXT_843 = NL + "                if(";
  protected final String TEXT_844 = ".";
  protected final String TEXT_845 = "!=null){" + NL + "                    // timestamp < min java date value (year 1) || timestamp > max mysql value (year 10000) => set 0000-00-00 as date in MySQL" + NL + "                    date_";
  protected final String TEXT_846 = " = ";
  protected final String TEXT_847 = ".";
  protected final String TEXT_848 = ".getTime();" + NL + "                    if (date_";
  protected final String TEXT_849 = " < year1_";
  protected final String TEXT_850 = " || date_";
  protected final String TEXT_851 = " >= year10000_";
  protected final String TEXT_852 = ") {";
  protected final String TEXT_853 = NL + "                        ";
  protected final String TEXT_854 = ".setString(counter";
  protected final String TEXT_855 = ", \"0000-00-00 00:00:00\");" + NL + "                    } else {";
  protected final String TEXT_856 = NL + "                        ";
  protected final String TEXT_857 = ".setTimestamp(counter";
  protected final String TEXT_858 = ", new java.sql.Timestamp(date_";
  protected final String TEXT_859 = "));" + NL + "                    }" + NL + "                }else{" + NL + "        ";
  protected final String TEXT_860 = NL + "                    ";
  protected final String TEXT_861 = ".setNull(counter";
  protected final String TEXT_862 = ",java.sql.Types.DATE);" + NL + "            " + NL + "                }";
  protected final String TEXT_863 = NL + "                ";
  protected final String TEXT_864 = ".set";
  protected final String TEXT_865 = "(counter";
  protected final String TEXT_866 = ",";
  protected final String TEXT_867 = ".";
  protected final String TEXT_868 = ");";
  protected final String TEXT_869 = NL + "            " + NL + "                }" + NL + "        ";
  protected final String TEXT_870 = NL + "\t\tquery_";
  protected final String TEXT_871 = " = new StringBuffer(\"\");";
  protected final String TEXT_872 = NL + "\t\t\t\tcommitEvery_";
  protected final String TEXT_873 = " = buffersSize_";
  protected final String TEXT_874 = ";";
  protected final String TEXT_875 = NL + "\t\t\t\t\tbatchSize_";
  protected final String TEXT_876 = " = buffersSize_";
  protected final String TEXT_877 = ";";
  protected final String TEXT_878 = NL + "\t\t";
  protected final String TEXT_879 = NL + "        whetherReject_";
  protected final String TEXT_880 = " = false;";
  protected final String TEXT_881 = "                " + NL + "\t                \tint counter";
  protected final String TEXT_882 = " = rowCount";
  protected final String TEXT_883 = " * ";
  protected final String TEXT_884 = " + 1;" + NL + "\t                ";
  protected final String TEXT_885 = NL + "\t                        counter";
  protected final String TEXT_886 = "++;" + NL + "\t                        ";
  protected final String TEXT_887 = NL + "\t\t\t\t\t\t\tint count_dyn_";
  protected final String TEXT_888 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_889 = ".";
  protected final String TEXT_890 = ", pstmt_";
  protected final String TEXT_891 = ", counter";
  protected final String TEXT_892 = "-1, \"";
  protected final String TEXT_893 = "\");" + NL + "\t\t\t\t\t\t\tcounter";
  protected final String TEXT_894 = "+=count_dyn_";
  protected final String TEXT_895 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_896 = NL + "\t             " + NL + "\t                exInsertColValue";
  protected final String TEXT_897 = " = new BufferLine_";
  protected final String TEXT_898 = "(" + NL + "\t                ";
  protected final String TEXT_899 = NL + "\t                            ," + NL + "\t                            ";
  protected final String TEXT_900 = NL + "\t                        ";
  protected final String TEXT_901 = ".";
  protected final String TEXT_902 = "              " + NL + "\t                        ";
  protected final String TEXT_903 = NL + "\t\t\t\t\t, ";
  protected final String TEXT_904 = ".";
  protected final String TEXT_905 = NL + "\t\t\t\t";
  protected final String TEXT_906 = "  " + NL + "\t                ); " + NL + "\t               " + NL + "\t                exInsertColValueList";
  protected final String TEXT_907 = ".add(exInsertColValue";
  protected final String TEXT_908 = ");" + NL + "\t    " + NL + "\t                rowCount";
  protected final String TEXT_909 = "++;";
  protected final String TEXT_910 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_911 = "++;";
  protected final String TEXT_912 = "\t         " + NL + "\t                if(rowCount";
  protected final String TEXT_913 = " == ";
  protected final String TEXT_914 = "){ " + NL + "\t                    insertedCount_";
  protected final String TEXT_915 = " = insertedCount_";
  protected final String TEXT_916 = " + pstmt_";
  protected final String TEXT_917 = ".executeUpdate();" + NL + "\t                    exInsertColValueList";
  protected final String TEXT_918 = ".clear();" + NL + "\t                    rowCount";
  protected final String TEXT_919 = " = 0;" + NL + "\t\t\t    counter";
  protected final String TEXT_920 = "=1;" + NL + "\t                }    ";
  protected final String TEXT_921 = NL + "\t                        ";
  protected final String TEXT_922 = NL + "\t                        ";
  protected final String TEXT_923 = NL + "\t                            query_";
  protected final String TEXT_924 = " = ";
  protected final String TEXT_925 = ";" + NL + "\t                            ";
  protected final String TEXT_926 = NL + "\t\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_927 = ".";
  protected final String TEXT_928 = ", pstmt_";
  protected final String TEXT_929 = ", ";
  protected final String TEXT_930 = ", \"";
  protected final String TEXT_931 = "\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_932 = NL + "\t                    globalMap.put(\"";
  protected final String TEXT_933 = "_QUERY\", query_";
  protected final String TEXT_934 = ".toString().trim());" + NL + "\t                    ";
  protected final String TEXT_935 = NL + "\t\t\t\t\t";
  protected final String TEXT_936 = NL + "\t\t    \t\tpstmt_";
  protected final String TEXT_937 = ".addBatch();" + NL + "\t\t    \t\tnb_line_";
  protected final String TEXT_938 = "++;    \t\t " + NL + "\t\t\t\t\t" + NL + "\t\t    \t\t  ";
  protected final String TEXT_939 = NL + "\t\t    \t\t  batchSizeCounter_";
  protected final String TEXT_940 = "++;" + NL + "\t\t    \t\t  ";
  protected final String TEXT_941 = "    \t\t" + NL + "\t\t    \t\t";
  protected final String TEXT_942 = NL + "\t                try {" + NL + "\t                    nb_line_";
  protected final String TEXT_943 = "++;" + NL + "\t                    insertedCount_";
  protected final String TEXT_944 = " = insertedCount_";
  protected final String TEXT_945 = " + pstmt_";
  protected final String TEXT_946 = ".executeUpdate();" + NL + "\t                } catch(java.lang.Exception e) {" + NL + "\t                    whetherReject_";
  protected final String TEXT_947 = " = true;" + NL + "\t                    ";
  protected final String TEXT_948 = NL + "\t                        throw(e);" + NL + "\t                        ";
  protected final String TEXT_949 = NL + "\t                            ";
  protected final String TEXT_950 = " = new ";
  protected final String TEXT_951 = "Struct();" + NL + "\t                            ";
  protected final String TEXT_952 = NL + "\t                                ";
  protected final String TEXT_953 = ".";
  protected final String TEXT_954 = " = ";
  protected final String TEXT_955 = ".";
  protected final String TEXT_956 = ";" + NL + "\t                            ";
  protected final String TEXT_957 = NL + "\t                            ";
  protected final String TEXT_958 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_959 = ";" + NL + "\t                            ";
  protected final String TEXT_960 = NL + "\t                            System.err.print(e.getMessage());" + NL + "\t                            ";
  protected final String TEXT_961 = NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_962 = NL + "                        ";
  protected final String TEXT_963 = NL + "                            query_";
  protected final String TEXT_964 = " = ";
  protected final String TEXT_965 = ";";
  protected final String TEXT_966 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_967 = ".";
  protected final String TEXT_968 = ", pstmt_";
  protected final String TEXT_969 = ", ";
  protected final String TEXT_970 = ", \"";
  protected final String TEXT_971 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_972 = NL + "                    globalMap.put(\"";
  protected final String TEXT_973 = "_QUERY\", query_";
  protected final String TEXT_974 = ".toString().trim());";
  protected final String TEXT_975 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_976 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_977 = " = insertedCount_";
  protected final String TEXT_978 = " + pstmt_";
  protected final String TEXT_979 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_980 = " = true;";
  protected final String TEXT_981 = NL + "                        throw(e);";
  protected final String TEXT_982 = NL + "                            ";
  protected final String TEXT_983 = " = new ";
  protected final String TEXT_984 = "Struct();";
  protected final String TEXT_985 = NL + "                                ";
  protected final String TEXT_986 = ".";
  protected final String TEXT_987 = " = ";
  protected final String TEXT_988 = ".";
  protected final String TEXT_989 = ";";
  protected final String TEXT_990 = NL + "                            ";
  protected final String TEXT_991 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_992 = ";";
  protected final String TEXT_993 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_994 = NL + "                }";
  protected final String TEXT_995 = NL + "    \t\t\t    ";
  protected final String TEXT_996 = NL + "    \t\t\t    ";
  protected final String TEXT_997 = NL + "                        query_";
  protected final String TEXT_998 = " = ";
  protected final String TEXT_999 = ";";
  protected final String TEXT_1000 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_1001 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1002 = ".";
  protected final String TEXT_1003 = ", pstmt_";
  protected final String TEXT_1004 = ", ";
  protected final String TEXT_1005 = ", \"";
  protected final String TEXT_1006 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_1007 = NL + "                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_1008 = NL + "                    \t";
  protected final String TEXT_1009 = NL + "                        query_";
  protected final String TEXT_1010 = " = ";
  protected final String TEXT_1011 = ";";
  protected final String TEXT_1012 = "  " + NL + "    \t\t\t    ";
  protected final String TEXT_1013 = NL + "    \t\t\t    ";
  protected final String TEXT_1014 = NL + "                       query_";
  protected final String TEXT_1015 = " = ";
  protected final String TEXT_1016 = ";";
  protected final String TEXT_1017 = NL + "                globalMap.put(\"";
  protected final String TEXT_1018 = "_QUERY\", query_";
  protected final String TEXT_1019 = ".toString().trim());";
  protected final String TEXT_1020 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1021 = NL + "    \t\tpstmt_";
  protected final String TEXT_1022 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_1023 = "++;    \t\t " + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_1024 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1025 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1026 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1027 = NL + "            try {" + NL + "                nb_line_";
  protected final String TEXT_1028 = "++;" + NL + "                updatedCount_";
  protected final String TEXT_1029 = " = updatedCount_";
  protected final String TEXT_1030 = " + pstmt_";
  protected final String TEXT_1031 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1032 = " = true;";
  protected final String TEXT_1033 = NL + "                    throw(e);";
  protected final String TEXT_1034 = NL + "                        ";
  protected final String TEXT_1035 = " = new ";
  protected final String TEXT_1036 = "Struct();";
  protected final String TEXT_1037 = NL + "                            ";
  protected final String TEXT_1038 = ".";
  protected final String TEXT_1039 = " = ";
  protected final String TEXT_1040 = ".";
  protected final String TEXT_1041 = ";";
  protected final String TEXT_1042 = NL + "                        ";
  protected final String TEXT_1043 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1044 = ";";
  protected final String TEXT_1045 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1046 = NL + "            }";
  protected final String TEXT_1047 = NL + "\t\t\t\t\t";
  protected final String TEXT_1048 = NL + "                    \t";
  protected final String TEXT_1049 = NL + "    \t\t\t    ";
  protected final String TEXT_1050 = NL + "    \t\t\t    ";
  protected final String TEXT_1051 = NL + "    " + NL + "    \t\tjava.sql.ResultSet rs_";
  protected final String TEXT_1052 = " = pstmt_";
  protected final String TEXT_1053 = ".executeQuery();" + NL + "    \t\tint checkCount_";
  protected final String TEXT_1054 = " = -1;" + NL + "    \t\twhile(rs_";
  protected final String TEXT_1055 = ".next()) {" + NL + "    \t\t\tcheckCount_";
  protected final String TEXT_1056 = " = rs_";
  protected final String TEXT_1057 = ".getInt(1);" + NL + "    \t\t}" + NL + "    \t\tif(checkCount_";
  protected final String TEXT_1058 = " > 0) {" + NL + "    \t\t\t";
  protected final String TEXT_1059 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1060 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1061 = NL + "                            query_";
  protected final String TEXT_1062 = " = ";
  protected final String TEXT_1063 = ";";
  protected final String TEXT_1064 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_1065 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1066 = ".";
  protected final String TEXT_1067 = ", pstmtUpdate_";
  protected final String TEXT_1068 = ", ";
  protected final String TEXT_1069 = ", \"";
  protected final String TEXT_1070 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1071 = NL + "\t                    \t";
  protected final String TEXT_1072 = NL + "\t                    ";
  protected final String TEXT_1073 = NL + "\t                        query_";
  protected final String TEXT_1074 = " = ";
  protected final String TEXT_1075 = ";" + NL + "\t                        ";
  protected final String TEXT_1076 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1077 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1078 = NL + "                            query_";
  protected final String TEXT_1079 = " = ";
  protected final String TEXT_1080 = ";";
  protected final String TEXT_1081 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1082 = "_QUERY\", query_";
  protected final String TEXT_1083 = ".toString().trim());";
  protected final String TEXT_1084 = NL + "                try {" + NL + "                    updatedCount_";
  protected final String TEXT_1085 = " = updatedCount_";
  protected final String TEXT_1086 = " + pstmtUpdate_";
  protected final String TEXT_1087 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1088 = " = true;";
  protected final String TEXT_1089 = NL + "                        throw(e);";
  protected final String TEXT_1090 = NL + "                        ";
  protected final String TEXT_1091 = " = new ";
  protected final String TEXT_1092 = "Struct();";
  protected final String TEXT_1093 = NL + "                                ";
  protected final String TEXT_1094 = ".";
  protected final String TEXT_1095 = " = ";
  protected final String TEXT_1096 = ".";
  protected final String TEXT_1097 = ";";
  protected final String TEXT_1098 = NL + "                            ";
  protected final String TEXT_1099 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1100 = ";";
  protected final String TEXT_1101 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1102 = NL + "                }" + NL + "    \t\t} else {" + NL + "    \t\t\t";
  protected final String TEXT_1103 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1104 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1105 = NL + "                            query_";
  protected final String TEXT_1106 = " = ";
  protected final String TEXT_1107 = ";";
  protected final String TEXT_1108 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1109 = ".";
  protected final String TEXT_1110 = ", pstmtInsert_";
  protected final String TEXT_1111 = ", ";
  protected final String TEXT_1112 = ", \"";
  protected final String TEXT_1113 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1114 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1115 = "_QUERY\", query_";
  protected final String TEXT_1116 = ".toString().trim());";
  protected final String TEXT_1117 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1118 = " = insertedCount_";
  protected final String TEXT_1119 = " + pstmtInsert_";
  protected final String TEXT_1120 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1121 = " = true;";
  protected final String TEXT_1122 = NL + "                        throw(e);";
  protected final String TEXT_1123 = NL + "                        ";
  protected final String TEXT_1124 = " = new ";
  protected final String TEXT_1125 = "Struct();";
  protected final String TEXT_1126 = NL + "                                ";
  protected final String TEXT_1127 = ".";
  protected final String TEXT_1128 = " = ";
  protected final String TEXT_1129 = ".";
  protected final String TEXT_1130 = ";";
  protected final String TEXT_1131 = NL + "                            ";
  protected final String TEXT_1132 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1133 = ";";
  protected final String TEXT_1134 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1135 = NL + "                }" + NL + "    \t\t}" + NL + "    \t\tnb_line_";
  protected final String TEXT_1136 = "++;" + NL + "    \t\t";
  protected final String TEXT_1137 = NL + "    \t    int updateFlag_";
  protected final String TEXT_1138 = "=0;" + NL + "    \t    ";
  protected final String TEXT_1139 = NL + "    \t\t\t    ";
  protected final String TEXT_1140 = NL + "    \t\t\t    ";
  protected final String TEXT_1141 = NL + "                        query_";
  protected final String TEXT_1142 = " = ";
  protected final String TEXT_1143 = ";";
  protected final String TEXT_1144 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_1145 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1146 = ".";
  protected final String TEXT_1147 = ", pstmtUpdate_";
  protected final String TEXT_1148 = ", ";
  protected final String TEXT_1149 = ", \"";
  protected final String TEXT_1150 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_1151 = NL + "\t\t\t\t\t";
  protected final String TEXT_1152 = NL + "                    \t";
  protected final String TEXT_1153 = NL + "\t                        query_";
  protected final String TEXT_1154 = " = ";
  protected final String TEXT_1155 = ";" + NL + "\t                        ";
  protected final String TEXT_1156 = NL + "                    " + NL + "    \t\t\t    ";
  protected final String TEXT_1157 = NL + "    \t\t\t    ";
  protected final String TEXT_1158 = NL + "                        query_";
  protected final String TEXT_1159 = " = ";
  protected final String TEXT_1160 = ";";
  protected final String TEXT_1161 = NL + "                globalMap.put(\"";
  protected final String TEXT_1162 = "_QUERY\", query_";
  protected final String TEXT_1163 = ".toString().trim());";
  protected final String TEXT_1164 = NL + "    \t" + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_1165 = "=pstmtUpdate_";
  protected final String TEXT_1166 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_1167 = " = updatedCount_";
  protected final String TEXT_1168 = "+updateFlag_";
  protected final String TEXT_1169 = ";" + NL + "                " + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1170 = " = true;";
  protected final String TEXT_1171 = NL + "                    throw(e);";
  protected final String TEXT_1172 = NL + "                        ";
  protected final String TEXT_1173 = " = new ";
  protected final String TEXT_1174 = "Struct();";
  protected final String TEXT_1175 = NL + "                            ";
  protected final String TEXT_1176 = ".";
  protected final String TEXT_1177 = " = ";
  protected final String TEXT_1178 = ".";
  protected final String TEXT_1179 = ";";
  protected final String TEXT_1180 = NL + "                        ";
  protected final String TEXT_1181 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1182 = ";";
  protected final String TEXT_1183 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1184 = NL + "            }" + NL + "            if(updateFlag_";
  protected final String TEXT_1185 = " == 0) {" + NL + "            " + NL + "            \t";
  protected final String TEXT_1186 = NL + "\t\t\t\tquery_";
  protected final String TEXT_1187 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_1188 = NL + "        \t\t\t    ";
  protected final String TEXT_1189 = NL + "        \t\t\t    ";
  protected final String TEXT_1190 = NL + "                            query_";
  protected final String TEXT_1191 = " = ";
  protected final String TEXT_1192 = ";";
  protected final String TEXT_1193 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1194 = ".";
  protected final String TEXT_1195 = ", pstmtInsert_";
  protected final String TEXT_1196 = ", ";
  protected final String TEXT_1197 = ", \"";
  protected final String TEXT_1198 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1199 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1200 = "_QUERY\", query_";
  protected final String TEXT_1201 = ".toString().trim());";
  protected final String TEXT_1202 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1203 = " = insertedCount_";
  protected final String TEXT_1204 = " + pstmtInsert_";
  protected final String TEXT_1205 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1206 = " = true;";
  protected final String TEXT_1207 = NL + "                        throw(e);";
  protected final String TEXT_1208 = NL + "                        ";
  protected final String TEXT_1209 = " = new ";
  protected final String TEXT_1210 = "Struct();";
  protected final String TEXT_1211 = NL + "                                ";
  protected final String TEXT_1212 = ".";
  protected final String TEXT_1213 = " = ";
  protected final String TEXT_1214 = ".";
  protected final String TEXT_1215 = ";";
  protected final String TEXT_1216 = NL + "                            ";
  protected final String TEXT_1217 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1218 = ";";
  protected final String TEXT_1219 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1220 = NL + "                }" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_1221 = "++;";
  protected final String TEXT_1222 = NL + "\t\t\t\t\t";
  protected final String TEXT_1223 = NL + "                    \t";
  protected final String TEXT_1224 = NL + "\t                        query_";
  protected final String TEXT_1225 = " = ";
  protected final String TEXT_1226 = ";" + NL + "\t                        ";
  protected final String TEXT_1227 = NL + "    \t\t\t    ";
  protected final String TEXT_1228 = NL + "    \t\t\t    ";
  protected final String TEXT_1229 = NL + "                        query_";
  protected final String TEXT_1230 = " = ";
  protected final String TEXT_1231 = ";";
  protected final String TEXT_1232 = NL + "                globalMap.put(\"";
  protected final String TEXT_1233 = "_QUERY\", query_";
  protected final String TEXT_1234 = ".toString().trim());";
  protected final String TEXT_1235 = NL + "        \t";
  protected final String TEXT_1236 = NL + "    \t\tpstmt_";
  protected final String TEXT_1237 = ".addBatch();" + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_1238 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1239 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1240 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1241 = NL + "            try {" + NL + "        \t    deletedCount_";
  protected final String TEXT_1242 = " = deletedCount_";
  protected final String TEXT_1243 = " + pstmt_";
  protected final String TEXT_1244 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1245 = " = true;";
  protected final String TEXT_1246 = NL + "                    throw(e);";
  protected final String TEXT_1247 = NL + "                        ";
  protected final String TEXT_1248 = " = new ";
  protected final String TEXT_1249 = "Struct();";
  protected final String TEXT_1250 = NL + "                            ";
  protected final String TEXT_1251 = ".";
  protected final String TEXT_1252 = " = ";
  protected final String TEXT_1253 = ".";
  protected final String TEXT_1254 = ";" + NL + "                            ";
  protected final String TEXT_1255 = NL + "                        rejectedCount_";
  protected final String TEXT_1256 = " =  rejectedCount_";
  protected final String TEXT_1257 = "+ 1;";
  protected final String TEXT_1258 = NL + "                        ";
  protected final String TEXT_1259 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1260 = ";" + NL + "                       ";
  protected final String TEXT_1261 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1262 = NL + "            }";
  protected final String TEXT_1263 = NL + "            nb_line_";
  protected final String TEXT_1264 = "++;" + NL + "        \t";
  protected final String TEXT_1265 = NL + "                    ";
  protected final String TEXT_1266 = NL + "                        query_";
  protected final String TEXT_1267 = " = ";
  protected final String TEXT_1268 = ";";
  protected final String TEXT_1269 = NL + "                globalMap.put(\"";
  protected final String TEXT_1270 = "_QUERY\", query_";
  protected final String TEXT_1271 = ".toString().trim());";
  protected final String TEXT_1272 = NL + "            int replaceCount_";
  protected final String TEXT_1273 = " = 0;" + NL + "            try {" + NL + "                replaceCount_";
  protected final String TEXT_1274 = " = pstmt_";
  protected final String TEXT_1275 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1276 = " = true;";
  protected final String TEXT_1277 = NL + "                    throw(e);";
  protected final String TEXT_1278 = NL + "                        ";
  protected final String TEXT_1279 = " = new ";
  protected final String TEXT_1280 = "Struct();";
  protected final String TEXT_1281 = NL + "                            ";
  protected final String TEXT_1282 = ".";
  protected final String TEXT_1283 = " = ";
  protected final String TEXT_1284 = ".";
  protected final String TEXT_1285 = ";";
  protected final String TEXT_1286 = NL + "                        rejectedCount_";
  protected final String TEXT_1287 = " =  rejectedCount_";
  protected final String TEXT_1288 = "+ 1;";
  protected final String TEXT_1289 = NL + "                        ";
  protected final String TEXT_1290 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1291 = ";";
  protected final String TEXT_1292 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1293 = "                " + NL + "            }" + NL + "            if(replaceCount_";
  protected final String TEXT_1294 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1295 = " += replaceCount_";
  protected final String TEXT_1296 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1297 = " += 1;" + NL + "                deletedCount_";
  protected final String TEXT_1298 = " += replaceCount_";
  protected final String TEXT_1299 = " - 1;" + NL + "            }";
  protected final String TEXT_1300 = NL + "                    ";
  protected final String TEXT_1301 = NL + "                        query_";
  protected final String TEXT_1302 = " = ";
  protected final String TEXT_1303 = ";";
  protected final String TEXT_1304 = NL + "                    ";
  protected final String TEXT_1305 = NL + "                        query_";
  protected final String TEXT_1306 = " = ";
  protected final String TEXT_1307 = ";";
  protected final String TEXT_1308 = NL + "                globalMap.put(\"";
  protected final String TEXT_1309 = "_QUERY\", query_";
  protected final String TEXT_1310 = ".toString().trim());";
  protected final String TEXT_1311 = NL + "            int count_on_duplicate_key_";
  protected final String TEXT_1312 = " = 0;" + NL + "            try {" + NL + "                count_on_duplicate_key_";
  protected final String TEXT_1313 = " = pstmt_";
  protected final String TEXT_1314 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1315 = " = true;";
  protected final String TEXT_1316 = NL + "                    throw(e);";
  protected final String TEXT_1317 = NL + "                        ";
  protected final String TEXT_1318 = " = new ";
  protected final String TEXT_1319 = "Struct();";
  protected final String TEXT_1320 = NL + "                            ";
  protected final String TEXT_1321 = ".";
  protected final String TEXT_1322 = " = ";
  protected final String TEXT_1323 = ".";
  protected final String TEXT_1324 = ";";
  protected final String TEXT_1325 = NL + "                        rejectedCount_";
  protected final String TEXT_1326 = " =  rejectedCount_";
  protected final String TEXT_1327 = "+ 1;";
  protected final String TEXT_1328 = NL + "                        ";
  protected final String TEXT_1329 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1330 = ";";
  protected final String TEXT_1331 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1332 = "                " + NL + "            }" + NL + "            if(count_on_duplicate_key_";
  protected final String TEXT_1333 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1334 = " += count_on_duplicate_key_";
  protected final String TEXT_1335 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1336 = " += 1;" + NL + "                updatedCount_";
  protected final String TEXT_1337 = " += count_on_duplicate_key_";
  protected final String TEXT_1338 = " - 1;" + NL + "            }";
  protected final String TEXT_1339 = NL + "                        ";
  protected final String TEXT_1340 = NL + "                            query_";
  protected final String TEXT_1341 = " = ";
  protected final String TEXT_1342 = ";";
  protected final String TEXT_1343 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1344 = "_QUERY\", query_";
  protected final String TEXT_1345 = ".toString().trim());";
  protected final String TEXT_1346 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_1347 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_1348 = " = insertedCount_";
  protected final String TEXT_1349 = " + pstmt_";
  protected final String TEXT_1350 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1351 = " = true;";
  protected final String TEXT_1352 = NL + "                        throw(e);";
  protected final String TEXT_1353 = NL + "                            ";
  protected final String TEXT_1354 = " = new ";
  protected final String TEXT_1355 = "Struct();";
  protected final String TEXT_1356 = NL + "                                ";
  protected final String TEXT_1357 = ".";
  protected final String TEXT_1358 = " = ";
  protected final String TEXT_1359 = ".";
  protected final String TEXT_1360 = ";";
  protected final String TEXT_1361 = NL + "                            rejectedCount_";
  protected final String TEXT_1362 = " =  rejectedCount_";
  protected final String TEXT_1363 = "+ 1;";
  protected final String TEXT_1364 = NL + "                            ";
  protected final String TEXT_1365 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1366 = ";";
  protected final String TEXT_1367 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1368 = NL + "                }";
  protected final String TEXT_1369 = NL + "            if(!whetherReject_";
  protected final String TEXT_1370 = ") {";
  protected final String TEXT_1371 = NL + "                            ";
  protected final String TEXT_1372 = " = new ";
  protected final String TEXT_1373 = "Struct();";
  protected final String TEXT_1374 = NL + "                                ";
  protected final String TEXT_1375 = ".";
  protected final String TEXT_1376 = " = ";
  protected final String TEXT_1377 = ".";
  protected final String TEXT_1378 = ";";
  protected final String TEXT_1379 = NL + "            }";
  protected final String TEXT_1380 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1381 = " <= batchSizeCounter_";
  protected final String TEXT_1382 = ") {                ";
  protected final String TEXT_1383 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tint countSum_";
  protected final String TEXT_1384 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1385 = ": pstmt_";
  protected final String TEXT_1386 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1387 = " += (countEach_";
  protected final String TEXT_1388 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1389 = ");" + NL + "\t\t\t\t\t\t}                  \t" + NL + "            \t    \t";
  protected final String TEXT_1390 = NL + "            \t    \tinsertedCount_";
  protected final String TEXT_1391 = " += countSum_";
  protected final String TEXT_1392 = ";" + NL + "            \t    \t";
  protected final String TEXT_1393 = "                         \t    \t" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1394 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1395 = NL + "                \tint countSum_";
  protected final String TEXT_1396 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1397 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1398 = " += (countEach_";
  protected final String TEXT_1399 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1400 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1401 = NL + "            \t    insertedCount_";
  protected final String TEXT_1402 = " += countSum_";
  protected final String TEXT_1403 = ";" + NL + "\t    \t    \t";
  protected final String TEXT_1404 = "  " + NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1405 = NL + "                }";
  protected final String TEXT_1406 = "    " + NL + "                \t\t\t" + NL + "    \t\t\tbatchSizeCounter_";
  protected final String TEXT_1407 = " = 0;" + NL + "    \t\t}" + NL + "    \t\t";
  protected final String TEXT_1408 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1409 = " <= batchSizeCounter_";
  protected final String TEXT_1410 = ") {                ";
  protected final String TEXT_1411 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tint countSum_";
  protected final String TEXT_1412 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1413 = ": pstmt_";
  protected final String TEXT_1414 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1415 = " += (countEach_";
  protected final String TEXT_1416 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1417 = ");" + NL + "\t\t\t\t\t\t}              \t" + NL + "            \t    \t";
  protected final String TEXT_1418 = NL + "            \t    \tupdatedCount_";
  protected final String TEXT_1419 = " += countSum_";
  protected final String TEXT_1420 = ";" + NL + "            \t    \t";
  protected final String TEXT_1421 = NL + "            \t    \tdeletedCount_";
  protected final String TEXT_1422 = " += countSum_";
  protected final String TEXT_1423 = ";" + NL + "            \t    \t";
  protected final String TEXT_1424 = "                         \t    \t" + NL + "            \t    \tbatchSizeCounter_";
  protected final String TEXT_1425 = " = 0;             \t                \t                \t" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1426 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1427 = NL + "                \tint countSum_";
  protected final String TEXT_1428 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1429 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1430 = " += (countEach_";
  protected final String TEXT_1431 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1432 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1433 = NL + "            \t    updatedCount_";
  protected final String TEXT_1434 = " += countSum_";
  protected final String TEXT_1435 = ";" + NL + "            \t    ";
  protected final String TEXT_1436 = NL + "            \t    deletedCount_";
  protected final String TEXT_1437 = " += countSum_";
  protected final String TEXT_1438 = ";" + NL + "            \t    ";
  protected final String TEXT_1439 = NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1440 = NL + "                }";
  protected final String TEXT_1441 = "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_1442 = NL + "        \t    commitCounter_";
  protected final String TEXT_1443 = "++;" + NL + "       " + NL + "                if(commitEvery_";
  protected final String TEXT_1444 = " <= commitCounter_";
  protected final String TEXT_1445 = ") {" + NL + "                ";
  protected final String TEXT_1446 = NL + "                try {" + NL + "                \t\tint countSum_";
  protected final String TEXT_1447 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1448 = ": pstmt_";
  protected final String TEXT_1449 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1450 = " += (countEach_";
  protected final String TEXT_1451 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1452 = ");" + NL + "\t\t\t\t\t\t}" + NL + "            \t    \t";
  protected final String TEXT_1453 = NL + "            \t    \tinsertedCount_";
  protected final String TEXT_1454 = " += countSum_";
  protected final String TEXT_1455 = ";" + NL + "            \t    \t";
  protected final String TEXT_1456 = "            \t    \t\t" + NL + "            \t    \tupdatedCount_";
  protected final String TEXT_1457 = " += countSum_";
  protected final String TEXT_1458 = ";" + NL + "            \t    \t";
  protected final String TEXT_1459 = NL + "            \t    \tdeletedCount_";
  protected final String TEXT_1460 = " += countSum_";
  protected final String TEXT_1461 = ";" + NL + "            \t    \t";
  protected final String TEXT_1462 = "            \t    " + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1463 = NL + "\t\t\t\t\t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1464 = NL + "                \tint countSum_";
  protected final String TEXT_1465 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1466 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1467 = " += (countEach_";
  protected final String TEXT_1468 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1469 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1470 = NL + "        \t    \tinsertedCount_";
  protected final String TEXT_1471 = " += countSum_";
  protected final String TEXT_1472 = ";" + NL + "        \t    \t";
  protected final String TEXT_1473 = "            \t    \t\t" + NL + "        \t    \tupdatedCount_";
  protected final String TEXT_1474 = " += countSum_";
  protected final String TEXT_1475 = ";" + NL + "        \t    \t";
  protected final String TEXT_1476 = NL + "        \t    \tdeletedCount_";
  protected final String TEXT_1477 = " += countSum_";
  protected final String TEXT_1478 = ";" + NL + "        \t    \t";
  protected final String TEXT_1479 = NL + "                    System.out.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1480 = NL + "                " + NL + "                }            \t                              ";
  protected final String TEXT_1481 = NL + "                \tconn_";
  protected final String TEXT_1482 = ".commit();" + NL + "                \t" + NL + "                \tcommitCounter_";
  protected final String TEXT_1483 = "=0;" + NL + "                " + NL + "                }\t" + NL + "    ";
  protected final String TEXT_1484 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
	public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
			if(this.getColumn()!=null) {
				if (this.getColumn().getTalendType().equals("id_Geometry")) {
				    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
	    			    return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
					return this.sqlStmt;
				}
			} else {
				return this.sqlStmt;
			}
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient

        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
    	  return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
    	  return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                        	// move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                    		if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                    			String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                        		int index = pkList.indexOf(columnStr);
                        		if(index !=-1){
                    				for (int i=index;i>0;i--) {
                    					pkList.set(i, pkList.get(i-1));
                    				}
                    				pkList.set(0, columnStr);
                        		}
                    		}
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            //createSQL.append(")");
            
            // add VectorWise option
            //if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            //	createSQL.append("WITH STRUCTURE = VECTORWISE");
            //}
            
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
        	if("sybase_id".equalsIgnoreCase(getDBMSId())){
        		return " IDENTITY NOT NULL";
        	} else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
        		return " AUTO_INCREMENT";
        	} else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
        		return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
        	} else {
        		return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
        	}
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();
            for(IMetadataColumn column : columnList) {
                Column skeletonColumn = getColumn(column);
                skeletonColumn.setOperator("=");
                stmtStructure.add(skeletonColumn);
            }
            for(IMetadataColumn column : columnList) {
                if(addCols != null && addCols.size() > 0) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;      
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacedCol.replace(replacementCol);
                            }
                        }                        
                    }
                }
            }
            return stmtStructure;
        }
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.getColumnName().equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
				if(!("id_Dynamic".equals(column.getTalendType()))) {
					Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
					skeletonColumn.setOperator("=");
					skeletonColumn.setDataType(column.getType());
					stmtStructure.add(skeletonColumn);
				}
            }
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                            }                            
                        }
                    }
                }
            }
            return stmtStructure;
        }
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
            	actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
            	actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
	            for(Column column : stmtStructure) {
	            	if(column.isReplaced()) {
	                    List<Column> replacedColumns = column.getReplacement();
	                    for(Column replacedColumn : replacedColumns) {
	                        actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
	                    }
	                } else {
	                    actionSQLMap = processSQLClause(column, actionSQLMap);        
	                }
	            }
            }
            return actionSQLMap;
        }
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            if(column.isInsertable()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
		
		public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
			} else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
        		} else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
		
		public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
            		if (index == 1) {
            			return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		} else {
            			return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		}
            }else {
            	if (index == 1) {
            		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	} else {
            		return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	}
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
        	if (index == 1) {
        		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
        	} else {
        		return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+index+"])";
        	}
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            System.out.println(column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable());
            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        }     
        
		public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
				String fieldDelimiter, 
				String newLineChar,
				String nullIndicator) {
		return null;
			
		}
		
		public String generateCode4TabelExist() {
		    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
		    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		    StringBuilder code = new StringBuilder();  
		    code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
		    if (hasSchema()) {
    		    code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
    		    code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("} else {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("}\r\n");
		    }
		    return code.toString();
		}
		
		protected String getTableName4Search(boolean useExistingConnection, String connection) {
		    return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
		}
		
	    protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
	    }

	    /*
	     * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
	     * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
	     * 
	     * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
	    */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }	
        
        protected boolean hasSchema() {
            return false;
        }
	    
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
            	if (typeToGenerate.equals("Long")) {
            		setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
            	} else {
            		setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            	}
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
         	//createSQL.append(")");
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            	createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
    	String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
	
	public class HiveManager extends Manager {
    	String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
    	boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
        	this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
    	public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
				String recordDelimiter, String nullIndicator) {		
    		StringBuilder copyBulkSQL = new StringBuilder();
			copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
			copyBulkSQL.append(" (\"+");	            
			int counter = 0;
			for(IMetadataColumn column : columnList) {
				counter++;
				// add each table field and separator
				copyBulkSQL.append( 
				"\n\"\\n" +
				  column.getOriginalDbColumnName() 
				+ "="
				+ (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
			
				// add these only if not last entry
				if (counter < columnList.size()){
					copyBulkSQL.append(
					//convertDelim(fieldDelimiter)
					fieldDelimiter
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					+ " ,"
					+ "\""
					+ "+"
					);
				} else {
					copyBulkSQL.append(
					recordDelimiter
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					);
					copyBulkSQL.append(")");
				}     	
			} 
			return copyBulkSQL.toString();
		} 

    	public String getTruncateTableSQL() {
    		StringBuilder truncateTableSQL = new StringBuilder();
    		truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
    		+ cid + " + \"\\\" TO TRUNCATED");
    		return truncateTableSQL.toString();
		}				        
    }
    
    public class VectorWiseManager extends IngresManager {
		public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
	}	
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
        	return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + index + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                	MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
					dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){
                	String pattern = column.getColumn().getPattern();
                	setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                	if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                	   setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                	}
                	setStmt.append("}else{\r\n");
					setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
					if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
					setStmt.append(");\r\n");
                	setStmt.append("}\r\n");
                }else{
                	setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                	if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
                	setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            //createSQL.append(")");
            
            // add VectorWise option
            //if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            //  createSQL.append("WITH STRUCTURE = VECTORWISE");
            //}
            
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
    	  private String[] oracleKeyWords= {
    		    	"ACCESS" ,"AUDIT","COMPRESS","DESC" , 
    		    	"ADD","CONNECT","DISTINCT" ,
    		    	"ALL","BY","CREATE","DROP",
    		    	"ALTER","CHAR","CURRENT","ELSE",
    		    	"AND","CHECK","DATE","EXCLUSIVE",
    		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
    		    	"AS","COLUMN","DEFAULT","FILE",
    		    	"ASC","COMMENT","DELETE","FLOAT",
    		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
    		    	"FROM","MAXEXTENTS","PRIOR","SYNONYM",
    		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
    		    	"GROUP","MODE","PUBLIC","TABLE",
    		    	"HAVING","MODIFY","RAW","THEN",
    		    	"IDENTIFIED","NETWORK","RENAME","TO",
    				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
    				"IN","NOCOMPRESS","REVOKE","UID",
    				"INCREMENT","NOT","ROW","UNION",
    				"INDEX","NOWAIT","ROWID","UNIQUE",
    				"INITIAL","NULL","ROWNUM","UPDATE",
    				"INSERT","NUMBER","ROWS","USER",
    				"INTEGER","OF","SELECT","VALIDATE",
    				"INTERSECT","OFFLINE","SESSION","VALUES",
    				"INTO","ON","SET","VARCHAR",
    				"IS","ONLINE","SHARE","VARCHAR2",
    				"LEVEL","OPTION","SIZE","VIEW",
    				"LIKE","OR","SMALLINT","WHENEVER",
    				"LOCK","ORDER","START","WHERE","WITH"
    		    	};
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
        		} else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__").equals("true")) {
                        setStmt.append(prefix + cid + ".setDate(" + index + ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                	   setStmt.append(prefix + cid + ".setObject(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("XMLTYPE"))) {
                setStmt.append("if (" + incomingConnName + "." + column.getName() + " instanceof String) {\r\n");
                setStmt.append(prefix + cid + ".setObject(" + index + ",  xmlTypeUtil_" + cid + ".getCLOB((String)" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                setStmt.append("}\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
			boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
			if(convertToUppercase){
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
			}else{
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
			}
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
			String columnName = column.getColumnName();
			String dataType = column.getDataType();
			if(dataType!=null)
			{
			boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
			if(trimChar && "char".equals(dataType.toLowerCase()))
			{
				columnName = "trim("+columnName+")";
			}
			}
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class GreenplumManager extends PostgrePlusManager {
    	 public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
    	 private String[] sybaseKeyWords= {
    			 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
 		    	"ADD","CONNECT","COUNT","DISTINCT" ,
 		    	"ALL","BY","CREATE","DROP",
 		    	"ALTER","CHAR","CURRENT","ELSE",
 		    	"AND","CHECK","DATE","EXCLUSIVE",
 		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
 		    	"AS","COLUMN","DEFAULT","FILE",
 		    	"ASC","COMMENT","DELETE","FLOAT",
 		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
 		    	"FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
 		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
 		    	"GROUP","MODE","PUBLIC","TABLE",
 		    	"HAVING","MODIFY","RAW","THEN",
 		    	"IDENTIFIED","NETWORK","RENAME","TO",
 				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
 				"IN","NOCOMPRESS","REVOKE","UID",
 				"INCREMENT","NOT","ROW","UNION",
 				"INDEX","NOWAIT","ROWID","UNIQUE",
 				"INITIAL","NULL","ROWNUM","UPDATE",
 				"INSERT","NUMBER","ROWS","USER",
 				"INTEGER","OF","SELECT","VALIDATE",
 				"INTERSECT","OFFLINE","SESSION","VALUES",
 				"INTO","ON","SET","VARCHAR",
 				"IS","ONLINE","SHARE",
 				"LEVEL","OPTION","SIZE","VIEW",
 				"LIKE","OR","SMALLINT","WHENEVER",
 				"LOCK","ORDER","START","WHERE","WITH"
    			 
    	 };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal") && column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            //createSQL.append(")");
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }

    }    
    
    public class ExasolManager extends Manager{
   	 	public ExasolManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }  
   }
    public class UnDefinedManager extends Manager{
    	
    	private String dbmsId = "";
    	
    	public UnDefinedManager(String cid) {
            super(cid);
        }
    	public void setDBMSId(String dbmsId){
    		this.dbmsId = dbmsId;
    	}
    	protected String getDBMSId() {
            return this.dbmsId;
        }
    	protected String getLProtectedChar() {
    		return "";
    	}
    	protected String getRProtectedChar() {
    		return "";
    	}
    }
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                List<IMetadataColumn> columnList2 = metadata.getListColumns();
                if( columnList2 == null || columnList2.size()<2 ||!metadata.isDynamicSchema() || "id_Dynamic".equals(columnList2.get(columnList2.size()-1).getTalendType())){
                    return columnList2;
                }else{
                    columnList = new java.util.ArrayList<IMetadataColumn>();
                    IMetadataColumn dyncolumn = null;
                    for(IMetadataColumn column:columnList2){
                        if(column.getTalendType().equals("id_Dynamic")){
                            dyncolumn = column;
                        }else{
                            columnList.add(column);
                        }
                    }
                    columnList.add(dyncolumn);
                }
            }
        }
        return columnList;
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	IProcess process = node.getProcess();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");
	
    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
    
    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
    
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    
    boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
        
        //to fixed: bug8422
        if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))||(!("INSERT").equals(dataAction))){
        	extendedInsert = false;
        }    
    
    String numPerInsert = ElementParameterParser.getValue(node, "__NB_ROWS_PER_INSERT__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
	
	//feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
	
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = getColumnList(node);
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
		
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();	    
	}
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
          
        }
    }
	
	List<Column> stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
	
	Manager manager = null;
	boolean isDynamic = false;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		isDynamic = metadata.isDynamicSchema(); 
	}
	
	if(isDynamic) {
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		///// hint options/////
boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
Map<String, String> hintsValues = null; 
if (useHintOptions) {
	List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
	hintsValues = new HashMap<String, String>();
	String hintValue = null;
	boolean firstInsert = true;
	boolean firstUpdate = true;
	boolean firstDelete = true;
	boolean firstTableName = true;
	for(java.util.Map<String, String> option : hintOptions) {
		//get
		hintValue = option.get("HINT");	
		//set
		if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
			if(firstInsert){
				hintsValues.put("INSERT", hintValue) ;
				firstInsert = false;
			}else {
				hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
			}									
		}else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if(firstUpdate){
				hintsValues.put("UPDATE", hintValue) ;
				firstUpdate = false;
			}else {
				hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
			}
		}else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if (firstDelete){
				hintsValues.put("DELETE", hintValue) ;
				firstDelete =false;
			}else {
				hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
			}		
		}
	}
} 
//// hint options end ////

if(columnList != null && columnList.size() > 0) {
    
    stringBuffer.append(TEXT_7);
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean isLog4jEnabled_tableAction = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);
	String ending="";
	
	if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
		ending="WITH STRUCTURE = VECTORWISE";
	}

	if(!("NONE").equals(tableAction)) {

        if(("DROP_CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_33);
    
					} else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_40);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_43);
    
			}

    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    				

        } else if(("CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_62);
    
					} else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_69);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_72);
    
			}

    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
        	boolean tableNameCaseSensitive=false;
    		if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
    			tableNameCaseSensitive=true;
    		}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_79);
    //bug22719: informix use independent connection, should remove this code after use shared connection
		    if(INFORMIX.equalsIgnoreCase(dbmsId)){
			    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
	    		String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
			    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
				String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
				String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
		    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_87);
    }else{
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
			}

    stringBuffer.append(TEXT_96);
     
			/*
				case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
				so in mssql use "Select" checked the table whether exist.
			*/
			//TODO we will use like "select" sql intead of use system table to checked table?
			if(MSSQL.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
			} else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
			} else if ( SYBASE.equalsIgnoreCase(dbmsId)
						|| INFORMIX.equalsIgnoreCase(dbmsId) ) {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    			
			} else if( DB2.equalsIgnoreCase(dbmsId) ){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
			} else if ( GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    			
			} else {

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
    stringBuffer.append(table);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
			}

    
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_234);
    
					} else {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_241);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_244);
    
			}

    stringBuffer.append(TEXT_245);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
            } else {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_260);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_277);
    
					} else {

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_284);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_287);
    
			}

    stringBuffer.append(TEXT_288);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
			}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    
			}

    stringBuffer.append(TEXT_296);
    
        } else if(("CLEAR").equals(tableAction)) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_305);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    }
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
        }else if(("TRUNCATE").equals(tableAction)) {

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_327);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    }
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
		} else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {

    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    }
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_354);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    }
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
		}         
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);   
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);    
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);    
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
    
    boolean supportDuplicateUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ON_DUPLICATE_KEY_UPDATE__"));
    
	if(("INSERT").equals(dataAction)) {
	
		if (supportDuplicateUpdate) {
			List<Map<String, String>> duplicateKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue( node,"__DUPLICATED_KEYS__" );
			          			
			if (duplicateKeys.size() > 0) {
			
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
				for (int i=0; i< duplicateKeys.size() ; i++) {
					if (i >0) {
					
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    
					}
					
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_KEY"));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_VALUE"));
    stringBuffer.append(TEXT_374);
    
				}
			}
		}

    stringBuffer.append(TEXT_375);
    				       
		    if(!extendedInsert) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);

					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_383);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_384);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_385);
    					} else {

    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_393);
    
					}
				}
			
		        
    	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    	
				}

    stringBuffer.append(TEXT_397);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    }
    stringBuffer.append(TEXT_406);
    
                //to fixed: bug8422
                if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    }
    stringBuffer.append(TEXT_411);
    
                //to fixed: bug8422
                if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){ 
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    }
    stringBuffer.append(TEXT_425);
    
	    } else {//extended-insert mode(begin)
	    	if ("MYSQL_4".equals(dbVersion)) {

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_428);
    
			if(isDynamic) {
			     List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			     if(conns_dynamic!=null && conns_dynamic.size()>0){
			     	IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_431);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_432);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_433);
    
				}			
			} else {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_436);
    
			}

    stringBuffer.append(TEXT_437);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_443);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    					} else {

    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_451);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    
					}	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    	
				}

    stringBuffer.append(TEXT_458);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    }
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_474);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_478);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_480);
    
					} else {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_483);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_487);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_488);
    
					}
				}
		    if(isDynamic) {

    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    
		    } else {

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    
		    }
		} else if ("MYSQL_5".equals(dbVersion)) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_496);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_497);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_500);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_501);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_502);
    					} else {

    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_510);
    
					}
				}
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    	
				}
				if(isDynamic) {

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    
				} else {

    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
				}

    stringBuffer.append(TEXT_522);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    }
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
	       	} 
	    }//extended-insert mode(end)
	} else if (("UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);
			if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_538);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_542);
    			} else {

    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_549);
    
			}
		}		
	    
    stringBuffer.append(TEXT_550);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    }
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    		
	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_566);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_570);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_572);
    					} else {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_576);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_579);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_580);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_585);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_588);
    				} else {

    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_595);
    
				}
			}
	    
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_604);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    }
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    }
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    
	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_632);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_636);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_637);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_638);
    					} else {

    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_642);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_645);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_646);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_650);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_651);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_654);
    				} else {

    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_658);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_661);
    
				}
			}	
	    
    stringBuffer.append(TEXT_662);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    }
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    }
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    			
	} else if (("DELETE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_690);
    if(useHintOptions && hintsValues.get("DELETE") != null) {
  
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    
  }
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    		
	} else if(("REPLACE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_706);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    
	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_714);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_715);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    
	} else if(("INSERT_IGNORE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_723);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_724);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    }
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    
	}
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_763);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    
		}

    
    }
}
	
    stringBuffer.append(TEXT_767);
    
	}
	
	
    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure){
    	if(!colStmt.isReplaced() && !colStmt.isAddCol()){
    		colStruct.add(colStmt);
    	}
    }

	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	if(("true").equals(useExistingConn)) {
		List<? extends INode> nodes =  process.getNodesOfType("tAmazonMysqlConnection");
		for (INode ne:nodes) {
			if (connection.equals(ne.getUniqueName())) {
				dbVersion = ElementParameterParser.getValue(ne, "__DB_VERSION__");
			}
		}
	} else {
		dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}

    class ExtendInsertOperation{
        public String generateType(String typeToGenerate){
            if(("byte[]").equals(typeToGenerate)){
                typeToGenerate = "Bytes";
            }else if(("java.util.Date").equals(typeToGenerate)){
                typeToGenerate = "Date";
            }else if(("Integer").equals(typeToGenerate)){
                typeToGenerate = "Int";
            }else if(("List").equals(typeToGenerate)){  
                typeToGenerate = "Object";                 
            }else{
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public void generateSetStmt(String typeToGenerate, Column column, String incomingConnName, String cid){
            boolean isObject = false;                               
            String prefix = "pstmt_";                             
            
    stringBuffer.append(TEXT_768);
    
            if(("Character").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_769);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_771);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    
            }else if(("Date").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_775);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_777);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    
            }else if(("byte[]").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_781);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    
            }else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_787);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_789);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_792);
    
            }else if(("String").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_793);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_795);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    
            }else if(("Object").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_799);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_801);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    
            }else if(("Boolean").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_805);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_807);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    
            }else if(("Double").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_811);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_813);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    
            }else if(("Float").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_817);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_819);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_823);
    
            }
            typeToGenerate = generateType(typeToGenerate);
        
            if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
                
    
                if(isObject) {
                    
    stringBuffer.append(TEXT_824);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_826);
    
                } else {
                    
    stringBuffer.append(TEXT_827);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_829);
    
                }
                
    stringBuffer.append(TEXT_830);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_834);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_842);
    
            }else if(("Date").equals(typeToGenerate)){
                
    stringBuffer.append(TEXT_843);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_846);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_859);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_862);
    
            }else{
                
    stringBuffer.append(TEXT_863);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_866);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_868);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_869);
    
            }
        }
    }
    
	if(isEnableDebug) {

    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    
	}

	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	
	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!"true".equals(useExistingConn)) {
	    	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_874);
    
	    	}
	    }
	    if ("MYSQL_5".equals(dbVersion)) {
	    	if ((extendedInsert&&"INSERT".equals(dataAction)) || (useBatchSize&&("UPDATE".equals(dataAction)||"DELETE".equals(dataAction)))) {
			    if((!("").equals(numPerInsert)&&!("0").equals(numPerInsert))
			    	||(!("").equals(batchSize)&&!("0").equals(batchSize))) {

    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_877);
    
			    }
	    	}
    	}

    stringBuffer.append(TEXT_878);
    
	}

    if(incomingConnName != null && columnList != null){
        
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    	
        if(("INSERT").equals(dataAction)) {
            if(extendedInsert) {//extended-insert mode(begin)
            	if ("MYSQL_4".equals(dbVersion)) {
	                ExtendInsertOperation eiOperation = new ExtendInsertOperation(); 
	                int insertableCount = 0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        insertableCount++;
	                    }
	                }
			if(!isDynamic) {
	                
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(insertableCount);
    stringBuffer.append(TEXT_884);
    
			}   
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        eiOperation.generateSetStmt(typeToGenerate,column,incomingConnName,cid);
	                        
    stringBuffer.append(TEXT_885);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_886);
    
	                    }
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_892);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_895);
    
						}
					}
	                
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
     
	                int count =0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        if(count != 0) {
	                            
    stringBuffer.append(TEXT_899);
    
	                        }                        
	                        
    stringBuffer.append(TEXT_900);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_902);
                            
	                        count++;                    
	                    }   
	                }
			if(isDynamic) {
			    	Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_903);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_905);
    
				}
			    }
	                
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    
			if(isDynamic) {

    stringBuffer.append(TEXT_910);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_911);
    
			}

    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_920);
     
				} else if ("MYSQL_5".equals(dbVersion)) {
	 				int counter = 1;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        
    stringBuffer.append(TEXT_921);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_922);
    
	                        if(isEnableDebug) {
	                            
    stringBuffer.append(TEXT_923);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_925);
    
	                        }                        
	                        counter++;                        
	                    }		
	
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_926);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_931);
    
						}
					}
					
	                if(isEnableDebug) {
	                    
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_934);
    
	                }                
	                
    stringBuffer.append(TEXT_935);
    if (rejectConnName == null) { // modification one
		    		
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_938);
    if (!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
		    		  
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_940);
    
		    		  }
    stringBuffer.append(TEXT_941);
    
		    		}else {    		
		    		
    stringBuffer.append(TEXT_942);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    
	                    if (("true").equals(dieOnError)) {
	                        
    stringBuffer.append(TEXT_948);
    
	                    } else {
	                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_949);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_950);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_951);
    
	                            for(IMetadataColumn column : columnList) {
	                             
    stringBuffer.append(TEXT_952);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_954);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_956);
    
	                            }
	                            
    stringBuffer.append(TEXT_957);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_958);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_959);
    
	                        } else {
	                            
    stringBuffer.append(TEXT_960);
    
	                        }
	                    } 
	                    
    stringBuffer.append(TEXT_961);
    
    			}
    			
    
				}
            } else {//extended-insert mode(end)
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_962);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_964);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_965);
    
                        }                        
                        counter++;                        
                    }		

                }
				
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_966);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_968);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_969);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_971);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_974);
    
                }                
                
    stringBuffer.append(TEXT_975);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_981);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_982);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_983);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_984);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_985);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_987);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_989);
    
                            }
                            
    stringBuffer.append(TEXT_990);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_992);
    
                        } else {
                            
    stringBuffer.append(TEXT_993);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_994);
    
            }
    	} else if(("UPDATE").equals(dataAction)) {
    	    int counterCol = 1;    		
    		for(Column column : colStruct) {
    			if(column.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_995);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_996);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_997);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_998);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_999);
    
                    }    	
                    counterCol++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1006);
    
				}
			}
    
    		for(Column column:colStruct){
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1007);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
      
					if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1011);
    
                    }
                    	counterCol++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    stringBuffer.append(TEXT_1013);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1016);
    
                    }    			    
    			    counterCol++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1019);
    
            }    
    		
    stringBuffer.append(TEXT_1020);
    if (rejectConnName == null && useBatchSize && "MYSQL_5".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1023);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1025);
    
    		  }
    stringBuffer.append(TEXT_1026);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1032);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1033);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1036);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1041);
    
                        }
                        
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1044);
    
                    } else {
                        
    stringBuffer.append(TEXT_1045);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1046);
    
            } // end whether use batch
            
    
    	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
    		int columnIndex = 1;
    		for(Column column : colStruct) {
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1047);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
      
                    	columnIndex++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1050);
    
    			    columnIndex++;
    			}
    		}
    		
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1058);
    
    			int counterCol = 1;
    			for(Column column : colStruct) {
    				if(column.isUpdatable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1060);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1063);
    
                        }    				    
    				    counterCol++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1070);
    
					}
				}
    			for(Column column : colStruct) {
    				if(column.isUpdateKey()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    String dbType = column.getColumn().getType();
                        
     
	                    //#############for feature:2880
	                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1072);
      
		                     if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1075);
    
	                    	} 
	                    	counterCol++;
	                       }
	                     //#############                      
	                    
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_1077);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1080);
    
                        }    				    
    				    counterCol++;				    
    				}
    			}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1083);
    
                }    			
    			
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1088);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1089);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1092);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1097);
    
                            }
                            
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1100);
    
                        } else {
                            
    stringBuffer.append(TEXT_1101);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1102);
    
    			int counterInsert = 1;
    			for(Column columnInsert : colStruct)
    			{
    				if(columnInsert.isInsertable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_1104);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1107);
    
                        }    				    
    				    counterInsert++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1113);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1116);
    
                }    			
    			
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1122);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1125);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1130);
    
                            }
                            
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1133);
    
                        } else {
                            
    stringBuffer.append(TEXT_1134);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1136);
    
    	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1138);
    
    		int counterColUpdate = 1;
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1140);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1143);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1150);
    
				}
			}
    
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    String dbType = columnUpdate.getColumn().getType();
                    
    stringBuffer.append(TEXT_1151);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && columnUpdate.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1155);
    
	                    	}
                    	counterColUpdate++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_1157);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1160);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1163);
    
            }    		
    		
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1170);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1171);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1174);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1179);
    
                        }
                        
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1182);
    
                    } else {
                        
    stringBuffer.append(TEXT_1183);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1185);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1187);
    
        		}
        		int counter = 1;
        		
        		for(Column column : colStruct) {
        			if(column.isInsertable()) {
        			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
        			    
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_1189);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1192);
    
                        }        			    
        			    counter++;
        			}
        		}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1198);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1201);
    
                }        		
        		
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1206);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1207);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1210);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1215);
    
                            }
                            
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1218);
    
                        } else {
                            
    stringBuffer.append(TEXT_1219);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1221);
    
    	
    	} else if (("DELETE").equals(dataAction)) {
    	    int keyCounter = 1;
    		for(Column column : colStruct) {
    			if(column.isDeleteKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1222);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1226);
    
	                    	}
                    	 keyCounter++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1228);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_1231);
    
                    }    			    
    			    keyCounter++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1234);
    
            }    		
        	
    stringBuffer.append(TEXT_1235);
    if (rejectConnName == null && useBatchSize && "MYSQL_5".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1237);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1239);
    
    		  }
    stringBuffer.append(TEXT_1240);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1245);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1246);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1249);
    
                        for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1254);
    
                        }
                        
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1260);
    
                    } else {
                        
    stringBuffer.append(TEXT_1261);
    
                    }
                }
                
    stringBuffer.append(TEXT_1262);
    
            } // end whether use batch
            
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1264);
    
    	} else if(("REPLACE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "replaceSQLSplits_"));
    stringBuffer.append(TEXT_1268);
    
                    }                    
                    counter++;                        
                }       

            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1271);
    
            }            
            
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1276);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1277);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1280);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1285);
    
                        }
                        
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1291);
    
                    } else {
                        
    stringBuffer.append(TEXT_1292);
    
                    }
                }
                
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1299);
    
    	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1303);
    
                    }                    
                    counter++;                        
                }       

            }
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1307);
    
                    }                    
                    counter++;                   
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1310);
    
            }            
            
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1315);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1316);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1319);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1324);
    
                        }
                        
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1330);
    
                    } else {
                        
    stringBuffer.append(TEXT_1331);
    
                    }
                }
                
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1338);
    
    	}else if(("INSERT_IGNORE").equals(dataAction)) {
    	int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1342);
    
                        }                        
                        counter++;                        
                    }		

                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1345);
    
                }                
                
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1351);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1352);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1355);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1360);
    
                            }
                            
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1366);
    
                        } else {
                            
    stringBuffer.append(TEXT_1367);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1368);
    
    	}
    	
        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1370);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
                            
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1373);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1378);
                      
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1379);
    
        }	
        	//////////batch execute by batch size///////
    	if (extendedInsert && "MYSQL_5".equals(dbVersion) && ("INSERT").equals(dataAction)) {
    		if(!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
    		
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1382);
    if ( (rejectConnName==null)) {
                
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1389);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1392);
    
            	    	}
            	    	
    stringBuffer.append(TEXT_1393);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1394);
    
                	}else {
                	
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1400);
    if (("INSERT").equals(dataAction)) {
            	    
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1403);
    
	    	    	}
	    	    	
    stringBuffer.append(TEXT_1404);
    
                	}
    stringBuffer.append(TEXT_1405);
    
                }
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1407);
    	
    		}
    	
    	}
    	if (useBatchSize && "MYSQL_5".equals(dbVersion) &&(rejectConnName==null)&& (("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
    		if(!("").equals(batchSize) && !("0").equals(batchSize)) {
    		
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1410);
    if (rejectConnName==null) {
                
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1417);
    
            	    	 if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1420);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1423);
    
            	    	}
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1425);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1426);
    
                	}else {
                	
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1432);
    if (("UPDATE").equals(dataAction)) {
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1435);
     }else if (("DELETE").equals(dataAction)) {
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1438);
    }
    stringBuffer.append(TEXT_1439);
    
                	}
    stringBuffer.append(TEXT_1440);
    
                }
    stringBuffer.append(TEXT_1441);
    	
    		}
    	
    	}	
    	////////////commit every////////////
    	if(!("true").equals(useExistingConn)) {
    		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    		    
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1445);
    if ((rejectConnName==null && useBatchSize && "MYSQL_5".equals(dbVersion)) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ) {
                
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1452);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1455);
    
            	    	}else if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1458);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1461);
    
            	    	}
    stringBuffer.append(TEXT_1462);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1463);
    
                	}else {
                	
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1469);
    if (("INSERT").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1472);
    
        	    	}else if (("UPDATE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1475);
    
        	    	}else if (("DELETE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1478);
    
        	    	}
    stringBuffer.append(TEXT_1479);
    
                	}
    stringBuffer.append(TEXT_1480);
    
                }
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1483);
    
    		}
    	}
    }

    stringBuffer.append(TEXT_1484);
    return stringBuffer.toString();
  }
}
