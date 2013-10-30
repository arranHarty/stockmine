package org.talend.designer.codegen.translators.processing.hadoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.pigmap.PigMapComponent;
import org.talend.designer.pigmap.model.emf.pigmap.PigMapData;
import org.talend.designer.pigmap.model.emf.pigmap.InputTable;
import org.talend.designer.pigmap.model.emf.pigmap.OutputTable;
import org.talend.designer.pigmap.model.emf.pigmap.TableNode;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TPigMapMainJava {

  protected static String nl;
  public static synchronized TPigMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigMapMainJava result = new TPigMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\t\t\t//the bag name of main input bag" + NL + "\t\t\tpigServer_";
  protected final String TEXT_4 = ".registerQuery(\"";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "_RESULT = FOREACH ";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "_RESULT GENERATE *;\");" + NL + "\t\t\tpigServer_";
  protected final String TEXT_9 = ".registerQuery(\"";
  protected final String TEXT_10 = "_RESULT = FOREACH ";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = "_RESULT GENERATE *;\");" + NL + "\t\t\t" + NL + "\t\t\tStringBuilder sb_innerJoinReject_";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "\t\t//get the scripts in the lookup process" + NL + "\t\tjava.util.List<Object[]> ps_";
  protected final String TEXT_15 = " = (java.util.List<Object[]>)globalMap.get(\"";
  protected final String TEXT_16 = "\");" + NL + "\t\t" + NL + "\t\tfor(int i_";
  protected final String TEXT_17 = "=0; i_";
  protected final String TEXT_18 = "<ps_";
  protected final String TEXT_19 = ".size(); i_";
  protected final String TEXT_20 = "++) {" + NL + "\t\t\tObject[] o_";
  protected final String TEXT_21 = " = ps_";
  protected final String TEXT_22 = ".get(i_";
  protected final String TEXT_23 = ");" + NL + "\t\t\tString type_";
  protected final String TEXT_24 = " = (String)o_";
  protected final String TEXT_25 = "[0];" + NL + "\t\t\tif(\"query\".equals(type_";
  protected final String TEXT_26 = ")) {" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_27 = ".registerQuery((String)o_";
  protected final String TEXT_28 = "[1]);" + NL + "\t\t\t} else if(\"jar\".equals(type_";
  protected final String TEXT_29 = ")) {" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_30 = ".registerJar((String)o_";
  protected final String TEXT_31 = "[1]);" + NL + "\t\t\t} else if(\"script\".equals(type_";
  protected final String TEXT_32 = ")) {" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_33 = ".registerScript((java.io.InputStream)o_";
  protected final String TEXT_34 = "[1]);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(i_";
  protected final String TEXT_35 = " == (ps_";
  protected final String TEXT_36 = ".size() - 1)) {//get the bag name of current lookup bag" + NL + "\t\t\t\tString bagName_";
  protected final String TEXT_37 = " = (String)o_";
  protected final String TEXT_38 = "[1];" + NL + "\t\t\t\tbagName_";
  protected final String TEXT_39 = " = bagName_";
  protected final String TEXT_40 = ".substring(0,bagName_";
  protected final String TEXT_41 = ".indexOf(\"_RESULT\")+7);" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_42 = ".registerQuery(\"";
  protected final String TEXT_43 = "_";
  protected final String TEXT_44 = "_RESULT = FOREACH \" + bagName_";
  protected final String TEXT_45 = " + \" GENERATE *;\");" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "\t\t\tsb_";
  protected final String TEXT_47 = ".append(\"";
  protected final String TEXT_48 = "_RESULT = JOIN ";
  protected final String TEXT_49 = "_RESULT BY (\");";
  protected final String TEXT_50 = NL + "\t\t\tpigServer_";
  protected final String TEXT_51 = ".registerQuery(\"";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_54 = "_RESULT GENERATE *;\");" + NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_55 = ".append(\"";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = "_INNER_REJECT_RESULT = JOIN ";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = "_INNER_REJECT_RESULT BY (\");";
  protected final String TEXT_60 = NL + "\t\t\t\tsb_";
  protected final String TEXT_61 = ".append(\"";
  protected final String TEXT_62 = "\");";
  protected final String TEXT_63 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_64 = ".append(\"";
  protected final String TEXT_65 = "\");\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\tsb_";
  protected final String TEXT_67 = ".append(\",\");";
  protected final String TEXT_68 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_69 = ".append(\",\");\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\tsb_";
  protected final String TEXT_71 = ".append(\") ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = "_RESULT BY (\");";
  protected final String TEXT_75 = NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_76 = ".append(\") LEFT, ";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = "_RESULT BY (\");\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\tsb_";
  protected final String TEXT_80 = ".append(\"";
  protected final String TEXT_81 = "\");";
  protected final String TEXT_82 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_83 = ".append(\"";
  protected final String TEXT_84 = "\");\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\tsb_";
  protected final String TEXT_86 = ".append(\",\");";
  protected final String TEXT_87 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_88 = ".append(\",\");\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\tsb_";
  protected final String TEXT_90 = ".append(\")\");";
  protected final String TEXT_91 = NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_92 = ".append(\")\");\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\tsb_";
  protected final String TEXT_94 = ".append(\" USING '";
  protected final String TEXT_95 = "'\");";
  protected final String TEXT_96 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_97 = ".append(\" USING '";
  protected final String TEXT_98 = "'\");\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\tsb_";
  protected final String TEXT_100 = ".append(\" PARTITION BY \").append(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_103 = ".append(\" PARTITION BY \").append(";
  protected final String TEXT_104 = ");\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\tsb_";
  protected final String TEXT_106 = ".append(\" PARALLEL \").append(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_109 = ".append(\" PARALLEL \").append(";
  protected final String TEXT_110 = ");\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\tsb_";
  protected final String TEXT_112 = ".append(\";\");" + NL + "\t\t\tpigServer_";
  protected final String TEXT_113 = ".registerQuery(sb_";
  protected final String TEXT_114 = ".toString());" + NL + "\t\t\tsb_";
  protected final String TEXT_115 = ".setLength(0);";
  protected final String TEXT_116 = NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_117 = ".append(\";\");" + NL + "\t\t\tpigServer_";
  protected final String TEXT_118 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_119 = ".toString());" + NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_120 = ".setLength(0);" + NL + "\t\t\t" + NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_121 = ".append(\"";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = "_INNER_REJECT_RESULT = FILTER ";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = "_INNER_REJECT_RESULT BY \");";
  protected final String TEXT_126 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_127 = ".append(\"(";
  protected final String TEXT_128 = " is null)\");";
  protected final String TEXT_129 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_130 = ".append(\" OR \");";
  protected final String TEXT_131 = NL + "    \t\tsb_innerJoinReject_";
  protected final String TEXT_132 = ".append(\";\");" + NL + "    \t\tpigServer_";
  protected final String TEXT_133 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_134 = ".toString());" + NL + "    \t\tsb_innerJoinReject_";
  protected final String TEXT_135 = ".setLength(0);\t\t\t\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\tpigServer_";
  protected final String TEXT_137 = ".registerQuery(\"";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = "_FILTER_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_140 = "_RESULT GENERATE *;\");" + NL + "\t\t\tpigServer_";
  protected final String TEXT_141 = ".registerQuery(\"";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = "_FILTER_INNER_REJECT_RESULT = FILTER ";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = "_FILTER_INNER_REJECT_RESULT BY (NOT (";
  protected final String TEXT_146 = "));\");" + NL + "\t\t\t//need to set the lookup columns as null" + NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_147 = ".append(\"";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = "_FILTER_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = "_FILTER_INNER_REJECT_RESULT GENERATE \");";
  protected final String TEXT_152 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_153 = ".append(\"$";
  protected final String TEXT_154 = ",\");";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_156 = ".append(\"null AS column";
  protected final String TEXT_157 = ":";
  protected final String TEXT_158 = "\");";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_160 = ".append(\",\");";
  protected final String TEXT_161 = NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_162 = ".append(\";\");" + NL + "        \t\tpigServer_";
  protected final String TEXT_163 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_164 = ".toString());" + NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_165 = ".setLength(0);";
  protected final String TEXT_166 = NL + "\t\t\t\t//init inner reject resultset" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_167 = ".registerQuery(\"";
  protected final String TEXT_168 = "_INNER_REJECT_RESULT = UNION ";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = "_INNER_REJECT_RESULT,";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = "_FILTER_INNER_REJECT_RESULT;\");";
  protected final String TEXT_173 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_174 = ".append(\"";
  protected final String TEXT_175 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_176 = "_INNER_REJECT_RESULT GENERATE \");";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_178 = ".append(\"$";
  protected final String TEXT_179 = ",\");";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_181 = ".append(\"null AS ";
  protected final String TEXT_182 = ":";
  protected final String TEXT_183 = "\");";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_185 = ".append(\",\");";
  protected final String TEXT_186 = NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_187 = ".append(\";\");" + NL + "        \t\t//syn the schema" + NL + "        \t\tpigServer_";
  protected final String TEXT_188 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_189 = ".toString());" + NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_190 = ".setLength(0);" + NL + "\t\t\t\t//union" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_191 = ".registerQuery(\"";
  protected final String TEXT_192 = "_INNER_REJECT_RESULT = UNION ";
  protected final String TEXT_193 = "_INNER_REJECT_RESULT,";
  protected final String TEXT_194 = "_";
  protected final String TEXT_195 = "_INNER_REJECT_RESULT,";
  protected final String TEXT_196 = "_";
  protected final String TEXT_197 = "_FILTER_INNER_REJECT_RESULT;\");";
  protected final String TEXT_198 = NL + "\t\t\tpigServer_";
  protected final String TEXT_199 = ".registerQuery(\"";
  protected final String TEXT_200 = "_RESULT = FILTER ";
  protected final String TEXT_201 = "_RESULT BY ";
  protected final String TEXT_202 = ";\");";
  protected final String TEXT_203 = NL + "\t\t\t\t//init inner reject resultset" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_204 = ".registerQuery(\"";
  protected final String TEXT_205 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = "_INNER_REJECT_RESULT GENERATE *;\");";
  protected final String TEXT_208 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_209 = ".append(\"";
  protected final String TEXT_210 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_211 = "_INNER_REJECT_RESULT GENERATE \");";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_213 = ".append(\"$";
  protected final String TEXT_214 = ",\");";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_216 = ".append(\"null AS ";
  protected final String TEXT_217 = ":";
  protected final String TEXT_218 = "\");";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_220 = ".append(\",\");";
  protected final String TEXT_221 = NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_222 = ".append(\";\");" + NL + "        \t\t//syn the schema" + NL + "        \t\tpigServer_";
  protected final String TEXT_223 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_224 = ".toString());" + NL + "        \t\tsb_innerJoinReject_";
  protected final String TEXT_225 = ".setLength(0);" + NL + "\t\t\t\t//union" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_226 = ".registerQuery(\"";
  protected final String TEXT_227 = "_INNER_REJECT_RESULT = UNION ";
  protected final String TEXT_228 = "_INNER_REJECT_RESULT,";
  protected final String TEXT_229 = "_";
  protected final String TEXT_230 = "_INNER_REJECT_RESULT;\");";
  protected final String TEXT_231 = NL + "\t\tsb_innerJoinReject_";
  protected final String TEXT_232 = ".append(\"";
  protected final String TEXT_233 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_234 = "_INNER_REJECT_RESULT GENERATE \");";
  protected final String TEXT_235 = NL + "\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_236 = ".append(\"$";
  protected final String TEXT_237 = ",\");";
  protected final String TEXT_238 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_239 = ".append(\"null AS ";
  protected final String TEXT_240 = ":";
  protected final String TEXT_241 = "\");";
  protected final String TEXT_242 = NL + "\t\t\t\t\tsb_innerJoinReject_";
  protected final String TEXT_243 = ".append(\",\");";
  protected final String TEXT_244 = NL + "    \t\tsb_innerJoinReject_";
  protected final String TEXT_245 = ".append(\";\");" + NL + "    \t\t//syn the schema" + NL + "    \t\tpigServer_";
  protected final String TEXT_246 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_247 = ".toString());" + NL + "    \t\tsb_innerJoinReject_";
  protected final String TEXT_248 = ".setLength(0);";
  protected final String TEXT_249 = NL + "\t\tpigServer_";
  protected final String TEXT_250 = ".registerQuery(\"";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = "_RESULT = FOREACH ";
  protected final String TEXT_253 = "_RESULT GENERATE *;\");";
  protected final String TEXT_254 = NL + "\t\tpigServer_";
  protected final String TEXT_255 = ".registerQuery(\"";
  protected final String TEXT_256 = "_";
  protected final String TEXT_257 = "_INNER_REJECT_RESULT = FOREACH ";
  protected final String TEXT_258 = "_INNER_REJECT_RESULT GENERATE *;\");";
  protected final String TEXT_259 = NL + "\t\t\tsb_";
  protected final String TEXT_260 = ".append(\"";
  protected final String TEXT_261 = "_";
  protected final String TEXT_262 = "_RESULT = FILTER ";
  protected final String TEXT_263 = "_";
  protected final String TEXT_264 = "_RESULT BY \");";
  protected final String TEXT_265 = NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_266 = ".append(\"";
  protected final String TEXT_267 = "_";
  protected final String TEXT_268 = "_INNER_REJECT_RESULT = FILTER ";
  protected final String TEXT_269 = "_";
  protected final String TEXT_270 = "_INNER_REJECT_RESULT BY \");";
  protected final String TEXT_271 = NL + "\t\t\tsb_";
  protected final String TEXT_272 = ".append(\"";
  protected final String TEXT_273 = "\");";
  protected final String TEXT_274 = NL + "\t\t\tsb_innerJoinReject_";
  protected final String TEXT_275 = ".append(\"";
  protected final String TEXT_276 = "\");";
  protected final String TEXT_277 = NL + "\t\t\tsb_";
  protected final String TEXT_278 = ".append(\" AND \");";
  protected final String TEXT_279 = NL + "\t\t\tsb_";
  protected final String TEXT_280 = ".append(\"(NOT (\");";
  protected final String TEXT_281 = NL + "\t\t\t\tsb_";
  protected final String TEXT_282 = ".append(\"";
  protected final String TEXT_283 = "\");";
  protected final String TEXT_284 = NL + "\t\t\t\tsb_";
  protected final String TEXT_285 = ".append(\" OR \");";
  protected final String TEXT_286 = NL + "\t\t\tsb_";
  protected final String TEXT_287 = ".append(\"))\");";
  protected final String TEXT_288 = NL + "\t\t\tsb_";
  protected final String TEXT_289 = ".append(\" AND \");";
  protected final String TEXT_290 = NL + "\t\t\tsb_";
  protected final String TEXT_291 = ".append(\"(1!=1)\");";
  protected final String TEXT_292 = NL + "\t\tsb_";
  protected final String TEXT_293 = ".append(\";\");" + NL + "\t\tpigServer_";
  protected final String TEXT_294 = ".registerQuery(sb_";
  protected final String TEXT_295 = ".toString());" + NL + "\t\tsb_";
  protected final String TEXT_296 = ".setLength(0);";
  protected final String TEXT_297 = NL + "\t\tsb_innerJoinReject_";
  protected final String TEXT_298 = ".append(\";\");" + NL + "\t\tpigServer_";
  protected final String TEXT_299 = ".registerQuery(sb_innerJoinReject_";
  protected final String TEXT_300 = ".toString());" + NL + "\t\tsb_innerJoinReject_";
  protected final String TEXT_301 = ".setLength(0);";
  protected final String TEXT_302 = NL + "\t\t\tpigServer_";
  protected final String TEXT_303 = ".registerQuery(\"";
  protected final String TEXT_304 = "_";
  protected final String TEXT_305 = "_RESULT = UNION ";
  protected final String TEXT_306 = "_";
  protected final String TEXT_307 = "_RESULT, ";
  protected final String TEXT_308 = "_";
  protected final String TEXT_309 = "_INNER_REJECT_RESULT;\");";
  protected final String TEXT_310 = NL + "\t\t\tpigServer_";
  protected final String TEXT_311 = ".registerQuery(\"";
  protected final String TEXT_312 = "_";
  protected final String TEXT_313 = "_RESULT = FOREACH ";
  protected final String TEXT_314 = "_";
  protected final String TEXT_315 = "_INNER_REJECT_RESULT GENERATE *;\");";
  protected final String TEXT_316 = NL + "\t\tsb_";
  protected final String TEXT_317 = ".append(\"";
  protected final String TEXT_318 = "_";
  protected final String TEXT_319 = "_RESULT = FOREACH ";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = "_RESULT GENERATE \");";
  protected final String TEXT_322 = NL + "\t\t\tsb_";
  protected final String TEXT_323 = ".append(\"";
  protected final String TEXT_324 = " AS ";
  protected final String TEXT_325 = "\");";
  protected final String TEXT_326 = NL + "\t\t\tsb_";
  protected final String TEXT_327 = ".append(\",\");";
  protected final String TEXT_328 = NL + "\t\tsb_";
  protected final String TEXT_329 = ".append(\";\");" + NL + "\t\tpigServer_";
  protected final String TEXT_330 = ".registerQuery(sb_";
  protected final String TEXT_331 = ".toString());" + NL + "\t\tsb_";
  protected final String TEXT_332 = ".setLength(0);";
  protected final String TEXT_333 = NL + NL + NL + NL + NL + NL;
  protected final String TEXT_334 = NL;

    private Map<String,Pattern> cache = new HashMap<String,Pattern>();
    
	public String convertExpression(Map<String,String> expressionConvertMap, String expression) {

		if(expression == null || "".equals(expression.trim())) {
			return "";
		}
		
		for(Map.Entry<String, String> entry : expressionConvertMap.entrySet()) {
			String key = entry.getKey();//like row1.column
			String value = entry.getValue();//like $0
			
            Pattern p = cache.get(key);
            
            if(p == null) {
                int index = key.indexOf(".");
                String tableName = key.substring(0, index);
                String columnName = key.substring(index + 1);
                
                StringBuffer pattern = new StringBuffer();
                pattern.append(tableName).append("\\s*\\.\\s*").append(columnName);
                p = Pattern.compile(pattern.toString());
                cache.put(key, p);
            }
            
            Matcher m = p.matcher(expression);

            StringBuffer sb = new StringBuffer();

            if (m.find()) {
                do {
                    if (m.start() > 0) {
                        char c = expression.charAt(m.start() - 1);
                        if (Character.isLetterOrDigit(c) || (c == '_')) {
                            continue;
                        }
                    }
                    
                    if (m.end() < expression.length()) {
                        char c = expression.charAt(m.end());
                        if (Character.isLetterOrDigit(c) || (c == '_')) {
                            continue;
                        }
                    }

                    m.appendReplacement(sb,value);
                } while (m.find());

                m.appendTail(sb);
                expression = sb.toString();
            }
			
		}
		
		return expression;
	
	}
	
   public static String getPigType(String talendType) {
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, false);
        // Integers: int(Integer), long(Long), short(Short), byte(Byte), BigDecimal, double(Double).
        if (typeToGenerate.equals("int") || typeToGenerate.equals("short") || typeToGenerate.equals("byte")) { 
            return "int"; 
        } else if (typeToGenerate.equals("long")) { 
            return "long"; 
        } else if (typeToGenerate.equals("BigDecimal") || typeToGenerate.equals("double")) { 
            return "double";
        }
    
        // Floats: float(Float)
        if (typeToGenerate.equals("float")) { 
            return "float";
        }
    
        // others treat as string
        return "chararray"; 

   }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	PigMapComponent node = (PigMapComponent) codeGenArgument.getArgument();
	PigMapData data = (PigMapData)ElementParameterParser.getObjectValueXMLTree(node);
	
	String cid = node.getUniqueName();
	
	List<InputTable> inputTablesWithUnvalid = data.getInputTables();
	List<OutputTable> outputTablesWithUnvalid = data.getOutputTables();
	
	List<IConnection> inputConnections = (List<IConnection>)node.getIncomingConnections();
	
	HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
	for(IConnection connection : inputConnections){
		hNameToConnection.put(connection.getName(), connection);
	}
	
	List<InputTable> inputTables = new ArrayList<InputTable>();
	for(int i=0; i<inputTablesWithUnvalid.size(); i++){
		InputTable  currentTable = inputTablesWithUnvalid.get(i);
		if(hNameToConnection.get(currentTable.getName()) != null){
			inputTables.add(currentTable);
		}
	}
	
	String previous_node="";
	String start_node="";

	Map<String,String> expressionConvertMap = new HashMap<String,String>();//like that : row1.id ==> $0
	int index = 0;
	
	//check whether reject or inner reject exist in output tables
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	
	HashMap<String, IConnection> hNameToOutConnection = new HashMap<String, IConnection>();
	for(IConnection connection : outputConnections){
		hNameToOutConnection.put(connection.getName(), connection);
	}
	
	List<OutputTable> outputTables = new ArrayList<OutputTable>();
	for(int i=0; i<outputTablesWithUnvalid.size(); i++){
		OutputTable currentTable = outputTablesWithUnvalid.get(i);
		if(hNameToOutConnection.get(currentTable.getName()) != null){
			outputTables.add(currentTable);
		}
	}
	
	boolean innerReject = false;
	for(OutputTable outputTable : outputTables) {
		if(outputTable.isRejectInnerJoin()) {
			innerReject = true;
		}
	}
	
	boolean existInnerJoin = false;
	int lstSizeInputs = inputTables.size();
	//prepare the flat data
	for (int i = 0; i < lstSizeInputs; i++) {
	    InputTable inputTable = inputTables.get(i);
	    String tableName = inputTable.getName();
	    
	    List<TableNode> tableNodes = inputTable.getNodes();
	    
	    if((tableNodes == null) || (tableNodes.size()) == 0) {
	    	continue;
	    }
	    
	    for(TableNode tnode : tableNodes) {
	    	String nodeName = tnode.getName();
	    	expressionConvertMap.put(tableName+"."+nodeName,"\\$"+(index++));
	    }
	    
	    String model = inputTable.getJoinModel();
	    if("Inner Join".equals(model)) {
	    	existInnerJoin = true;
	    }
	    
	    if(i == 0) {//main table
	    	IConnection connection = hNameToConnection.get(tableName);
	  		previous_node = connection.getSource().getUniqueName();
			start_node = node.getDesignSubjobStartNode().getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
	    } else {//lookup table

    stringBuffer.append(TEXT_14);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_45);
    
		}
	}
	
	//the join action
	boolean isFirstInnerReject = true;
	
	List<String> currentInnerRejectSchemaTypes = new ArrayList<String>();
	List<String> previousInnerRejectSchemaTypes = new ArrayList<String>();
	
	for (int i = 0; i < lstSizeInputs; i++) {
	    InputTable inputTable = inputTables.get(i);
	    String tableName = inputTable.getName();
	    
	    List<TableNode> tableNodes = inputTable.getNodes();
	    
	    if((tableNodes == null) || (tableNodes.size()) == 0) {
	    	continue;
	    }
	    
	    boolean isMainTable = (i == 0);
	    
	    boolean isInnerJoin = false;
	 	if (isMainTable) {//main
	 		
	 	} else {//lookup
	 		String model = inputTable.getJoinModel();
	 		String optimization = inputTable.getJoinOptimization();
	 		String partitioner = inputTable.getCustomPartitioner();
	 		String parallelism = inputTable.getIncreaseParallelism();
	 		
	 		String joinModel = "";
	 		if("Inner Join".equals(model)) {
	 			isInnerJoin = true;
	 		} else if("Left Outer Join".equals(model)) {
	 			joinModel = "LEFT";
	 		} else if("Right Outer Join".equals(model)) {
	 			joinModel = "RIGHT";
	 		} else if("Full Outer Join".equals(model)) {
	 			joinModel = "FULL";
	 		}
	 		
	 		boolean useOptimization = false;
	 		String optimizationModel = "";
	 		if("None".equalsIgnoreCase(optimization)) {
	 			//do nothing
	 		} else if("Replicated".equalsIgnoreCase(optimization)) {
	 			optimizationModel = "replicated";
	 			useOptimization = true;
	 		} else if("Skewed".equalsIgnoreCase(optimization)) {
	 			optimizationModel = "skewed";
	 			useOptimization = true;
	 		} else if("Merge".equalsIgnoreCase(optimization)) {
	 			optimizationModel = "merge";
	 			useOptimization = true;
	 		}
	 		
 			List<String> innerRejectLocationExpressions = new ArrayList<String>();
 			

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_59);
    
			}
			
			List<String> expressions = new ArrayList<String>();
			List<String> names = new ArrayList<String>();
	 		for(TableNode tnode : tableNodes) {
	 			String name = tnode.getName();
	 			String expression = tnode.getExpression();
	 			if(expression!=null && !"".equals(expression.trim())) {
					expressions.add(expression);
					names.add(name);
	 			}
	 		}
	 		
	 		for(int j=0;j<expressions.size();j++) {
	 			String expression = expressions.get(j);
	 			expression = convertExpression(expressionConvertMap,expression);

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_62);
    
				if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_65);
    
				}
				
				if(j<expressions.size()-1) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
					if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
					}
				}
	 		}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(joinModel);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_74);
    
			if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_78);
    
			}
			
	 		for(int j=0;j<names.size();j++) {
	 			String name = names.get(j);

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_81);
    
				if(existInnerJoin && innerReject && isInnerJoin) {
    				String innerRejectLocationExpression = convertExpression(expressionConvertMap,tableName + "." + name);
    				innerRejectLocationExpressions.add(innerRejectLocationExpression);

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_84);
    
				}
				
				if(j<names.size()-1) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
					if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
					}
				}
	 		}
	 		

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
	 		if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	 		}
	 		
	 		if(useOptimization) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(optimizationModel);
    stringBuffer.append(TEXT_95);
    
				if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(optimizationModel);
    stringBuffer.append(TEXT_98);
    
				}
	 		}
	 		
	 		if(partitioner!=null && !"".equals(partitioner)) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(partitioner);
    stringBuffer.append(TEXT_101);
    
				if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(partitioner);
    stringBuffer.append(TEXT_104);
    
				}
	 		}
	 		
	 		if(parallelism!=null && !"".equals(parallelism)) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(parallelism);
    stringBuffer.append(TEXT_107);
    
				if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(parallelism);
    stringBuffer.append(TEXT_110);
    
				}
	 		}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_125);
    
				for(int j=0;j<innerRejectLocationExpressions.size();j++) {
					String locationExpression = innerRejectLocationExpressions.get(j);

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(locationExpression);
    stringBuffer.append(TEXT_128);
    
					if(j<innerRejectLocationExpressions.size()-1) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
					}
				}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
			}
	 	}
	 	
	 	
	 	
	 	//filter action : first join,second filter
		boolean hasFilter = inputTable.isActivateExpressionFilter() 
	    	&& inputTable.getExpressionFilter()!=null 
	    	&& !"".equals(inputTable.getExpressionFilter());
	    
	    if(existInnerJoin && innerReject) {
	    
	 		for(TableNode tnode : tableNodes) {
	 			String type = tnode.getType();
            	currentInnerRejectSchemaTypes.add(type);
	 		}
	    }
	    
	    if(hasFilter) {
 			String expression = inputTable.getExpressionFilter();
 			//convert the expression to big expression(replace the java var to pig $n)
 			expression = convertExpression(expressionConvertMap,expression);
			if(existInnerJoin && innerReject && isInnerJoin) {

    stringBuffer.append(TEXT_136);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_151);
    
				for(int j=0;j<currentInnerRejectSchemaTypes.size();j++) {
					if(j<(currentInnerRejectSchemaTypes.size() - tableNodes.size())) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_154);
    
					} else {//the lookup columns
						String type = currentInnerRejectSchemaTypes.get(j);

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(tableName);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(getPigType(type));
    stringBuffer.append(TEXT_158);
    
						if(j < (currentInnerRejectSchemaTypes.size()-1)) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
						}
					}
				}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
				if(isFirstInnerReject) {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_172);
    
				} else {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					for(int j=0;j<currentInnerRejectSchemaTypes.size();j++) {
						if(j < previousInnerRejectSchemaTypes.size()) {//the same part

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_179);
    
						} else {//the new part
							String type = currentInnerRejectSchemaTypes.get(j);

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(tableName);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(getPigType(type));
    stringBuffer.append(TEXT_183);
    
							if(j < (currentInnerRejectSchemaTypes.size()-1)) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
							}
						}
					}

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_197);
    
				}
				isFirstInnerReject = false;
			}

    stringBuffer.append(TEXT_198);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_202);
    
	 	} else {
	 		if(existInnerJoin && innerReject && isInnerJoin) {
	 			if(isFirstInnerReject) {

    stringBuffer.append(TEXT_203);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_207);
    
				} else {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
					for(int j=0;j<currentInnerRejectSchemaTypes.size();j++) {
						if(j < previousInnerRejectSchemaTypes.size()) {//the same part

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_214);
    
						} else {//the new part
							String type = currentInnerRejectSchemaTypes.get(j);

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(tableName);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(getPigType(type));
    stringBuffer.append(TEXT_218);
    
							if(j < (currentInnerRejectSchemaTypes.size()-1)) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
							}
						}
					}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_230);
    
				}
				isFirstInnerReject = false;
			}
	 	}
	 	
	 	if((i == (lstSizeInputs - 1)) && existInnerJoin && innerReject && !isInnerJoin) {//the last input table is not inner join and inner reject exist


    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
			for(int j=0;j<currentInnerRejectSchemaTypes.size();j++) {
				if(j < previousInnerRejectSchemaTypes.size()) {//the same part

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_237);
    
				} else {//the new part
					String type = currentInnerRejectSchemaTypes.get(j);

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(tableName);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(getPigType(type));
    stringBuffer.append(TEXT_241);
    
					if(j < (currentInnerRejectSchemaTypes.size()-1)) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
					}
				}
			}

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
	 	}
	 	
	 	if(existInnerJoin && innerReject && isInnerJoin) {
	 		previousInnerRejectSchemaTypes.clear();
	 		previousInnerRejectSchemaTypes.addAll(currentInnerRejectSchemaTypes);
	 	}
	 	
	}
	
	//output action
	List<OutputTable> outputTablesSortedByReject = new ArrayList<OutputTable>(outputTables);
    Collections.sort(outputTablesSortedByReject, new Comparator<OutputTable>() {

        public int compare(OutputTable o1, OutputTable o2) {
            if (o1.isReject() != o2.isReject()) {
                if (o1.isReject()) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (o1.isRejectInnerJoin() != o2.isRejectInnerJoin()) {
                if (o1.isRejectInnerJoin()) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }

    });
    
	int size = outputTablesSortedByReject.size();
	List<String> previousFilterExpressions = new ArrayList<String>();
	boolean previousAtLeastOneTableWithoutFilterExpression = false;
	boolean previousAllOutputTableIsReject = true;
	for(int i=0;i<size;i++) {
		OutputTable outputTable = outputTablesSortedByReject.get(i);
		boolean isReject = outputTable.isReject();
		boolean isRejectInnerJoin = outputTable.isRejectInnerJoin();
		
		if(previousAllOutputTableIsReject) {
			isReject = false;//set it to code generate logic,no output reject for the first several output reject tables
		}
		
	    String tableName = outputTable.getName();
	    
	    List<TableNode> tableNodes = outputTable.getNodes();
	    
	    if((tableNodes == null) || (tableNodes.size()) == 0) {
	    	continue;
	    }
	    

    stringBuffer.append(TEXT_249);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
		if(existInnerJoin && isRejectInnerJoin) {

    stringBuffer.append(TEXT_254);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
		}
		
		boolean hasFilter = outputTable.isActivateExpressionFilter() 
	    	&& outputTable.getExpressionFilter()!=null 
	    	&& !"".equals(outputTable.getExpressionFilter());
	   	
	   	boolean noRejectDataByFilter = isReject && previousAtLeastOneTableWithoutFilterExpression;
	   	boolean hasRejectDataByFilter = isReject && !previousAtLeastOneTableWithoutFilterExpression && previousFilterExpressions.size() > 0;
	    boolean needFilterExpression = hasFilter || hasRejectDataByFilter || noRejectDataByFilter;

	    if(needFilterExpression) {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_264);
    
	    }
	    
		if(existInnerJoin && isRejectInnerJoin && hasFilter) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_270);
    
		}
	    
	    String currentExpression = "";
	    if(hasFilter) {
 			String expression = outputTable.getExpressionFilter();
 			//convert the expression to big expression(replace the java var to pig $n)
 			expression = convertExpression(expressionConvertMap,expression);
 			currentExpression = expression;

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_273);
    
			if(existInnerJoin && isRejectInnerJoin) {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_276);
    
			}
	 	}
	 	
		if(hasRejectDataByFilter) {//the common reject action
			if(hasFilter) {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
			}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    
			for(int j=0;j<previousFilterExpressions.size();j++) {
				String previousFilterExpression = previousFilterExpressions.get(j);

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(previousFilterExpression);
    stringBuffer.append(TEXT_283);
    
				if(j<previousFilterExpressions.size()-1) {

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
				}
			}

    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    
		} else if(noRejectDataByFilter) {//no data
			if(hasFilter) {

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
			}

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
		}
		
		if(needFilterExpression) {

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
		}
		
		if(existInnerJoin && isRejectInnerJoin && hasFilter) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
		}
		
		isReject = outputTable.isReject();//reset it to ui settings
		
		previousAllOutputTableIsReject = previousAllOutputTableIsReject && isReject;
		
		if(hasFilter && !(isReject || isRejectInnerJoin)) {
			previousFilterExpressions.add(currentExpression);
		} 
		
		if(!hasFilter && !(isReject || isRejectInnerJoin)){
			previousAtLeastOneTableWithoutFilterExpression = true;
		}
		
		if(existInnerJoin && isRejectInnerJoin) {
			if(isReject) {//union reject and inner reject

    stringBuffer.append(TEXT_302);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_309);
    
			} else {//only inner reject

    stringBuffer.append(TEXT_310);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_315);
    
			}
		}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_321);
    
	 	
		List<String> expressions = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
 		for(TableNode tnode : tableNodes) {
 			String name = tnode.getName();
 			String expression = tnode.getExpression();
 			if(expression!=null && !"".equals(expression.trim())) {
				expressions.add(expression);
				names.add(name);
 			}
 		}
 		
 		for(int j=0;j<expressions.size();j++) {
			String expression = expressions.get(j);
			String name = names.get(j);
			expression = convertExpression(expressionConvertMap,expression);

    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_325);
    
			if(j<expressions.size()-1) {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
			}
 		}
 		

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    
	 
	}

    stringBuffer.append(TEXT_333);
    stringBuffer.append(TEXT_334);
    return stringBuffer.toString();
  }
}