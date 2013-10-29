package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_3 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\t\tint maxColumnCount_";
  protected final String TEXT_5 = " = dynamic_";
  protected final String TEXT_6 = ".getColumnCount();" + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_7 = ".clearColumnValues();";
  protected final String TEXT_8 = NL + "int nb_line_";
  protected final String TEXT_9 = " = 0;" + NL + "int footer_";
  protected final String TEXT_10 = "  = ";
  protected final String TEXT_11 = ";" + NL + "int nb_limit_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL;
  protected final String TEXT_14 = NL + "class Arrays_";
  protected final String TEXT_15 = "{" + NL + "    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "        int newLength = to - from;" + NL + "        if (newLength < 0)" + NL + "            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "        byte[] copy = new byte[newLength];" + NL + "        System.arraycopy(original, from, copy, 0," + NL + "                         Math.min(original.length - from, newLength));" + NL + "        return copy;" + NL + "    }" + NL + "}" + NL + "Arrays_";
  protected final String TEXT_16 = " arrays_";
  protected final String TEXT_17 = " = new Arrays_";
  protected final String TEXT_18 = "();";
  protected final String TEXT_19 = NL + NL + NL + "class PositionalUtil_";
  protected final String TEXT_20 = "{";
  protected final String TEXT_21 = NL + "                  void setValue_";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = "Struct ";
  protected final String TEXT_24 = ",int[] begins_";
  protected final String TEXT_25 = ",int[] ends_";
  protected final String TEXT_26 = ",int rowLen_";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = "byte[] byteArray_";
  protected final String TEXT_29 = ",Arrays_";
  protected final String TEXT_30 = " arrays_";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = "String column_";
  protected final String TEXT_33 = ",String row_";
  protected final String TEXT_34 = ")throws java.lang.Exception {             ";
  protected final String TEXT_35 = NL + "    if(begins_";
  protected final String TEXT_36 = "[";
  protected final String TEXT_37 = "] < rowLen_";
  protected final String TEXT_38 = "){";
  protected final String TEXT_39 = NL + "\t\tbyteArray_";
  protected final String TEXT_40 = "=arrays_";
  protected final String TEXT_41 = ".copyOfRange(row_";
  protected final String TEXT_42 = ".getBytes(";
  protected final String TEXT_43 = "),begins_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "],rowLen_";
  protected final String TEXT_46 = ");" + NL + "    \tcolumn_";
  protected final String TEXT_47 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = "), ";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\tcolumn_";
  protected final String TEXT_53 = " = TalendString.talendTrim(row_";
  protected final String TEXT_54 = ".substring(begins_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "]), ";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_60 = " = \"\";" + NL + "    }";
  protected final String TEXT_61 = NL + "\tif(begins_";
  protected final String TEXT_62 = "[";
  protected final String TEXT_63 = "] < rowLen_";
  protected final String TEXT_64 = "){" + NL + "        if(ends_";
  protected final String TEXT_65 = "[";
  protected final String TEXT_66 = "] <= rowLen_";
  protected final String TEXT_67 = "){" + NL + "        \tbyteArray_";
  protected final String TEXT_68 = " = arrays_";
  protected final String TEXT_69 = ".copyOfRange(row_";
  protected final String TEXT_70 = ".getBytes(";
  protected final String TEXT_71 = "),begins_";
  protected final String TEXT_72 = "[";
  protected final String TEXT_73 = "],ends_";
  protected final String TEXT_74 = "[";
  protected final String TEXT_75 = "]);" + NL + "        }else{" + NL + "        \tbyteArray_";
  protected final String TEXT_76 = " = arrays_";
  protected final String TEXT_77 = ".copyOfRange(row_";
  protected final String TEXT_78 = ".getBytes(";
  protected final String TEXT_79 = "),begins_";
  protected final String TEXT_80 = "[";
  protected final String TEXT_81 = "],rowLen_";
  protected final String TEXT_82 = ");" + NL + "\t\t}" + NL + "\t\tcolumn_";
  protected final String TEXT_83 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = "), ";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ");" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_88 = " = \"\";" + NL + "    }";
  protected final String TEXT_89 = NL + "\tif(begins_";
  protected final String TEXT_90 = "[";
  protected final String TEXT_91 = "] < rowLen_";
  protected final String TEXT_92 = "){" + NL + "        if(ends_";
  protected final String TEXT_93 = "[";
  protected final String TEXT_94 = "] <= rowLen_";
  protected final String TEXT_95 = "){" + NL + "        \tcolumn_";
  protected final String TEXT_96 = " = TalendString.talendTrim(row_";
  protected final String TEXT_97 = ".substring(begins_";
  protected final String TEXT_98 = "[";
  protected final String TEXT_99 = "], ends_";
  protected final String TEXT_100 = "[";
  protected final String TEXT_101 = "]), ";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ");" + NL + "        }else{" + NL + "        \tcolumn_";
  protected final String TEXT_104 = " = TalendString.talendTrim(row_";
  protected final String TEXT_105 = ".substring(begins_";
  protected final String TEXT_106 = "[";
  protected final String TEXT_107 = "]), ";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");" + NL + "\t\t}" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_110 = " = \"\";" + NL + "    }";
  protected final String TEXT_111 = NL + "\tcolumn_";
  protected final String TEXT_112 = " = column_";
  protected final String TEXT_113 = ".trim();";
  protected final String TEXT_114 = NL + "\t";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " = column_";
  protected final String TEXT_117 = ";";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_119 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_120 = "\");" + NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_121 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_122 = " = dynamic_";
  protected final String TEXT_123 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\tint substringBegin";
  protected final String TEXT_124 = " = begins_";
  protected final String TEXT_125 = "[";
  protected final String TEXT_126 = "]; int substringEnd";
  protected final String TEXT_127 = " =0;" + NL + "\t\t\t\t\t\t\tfor (int i";
  protected final String TEXT_128 = "=0;i";
  protected final String TEXT_129 = "<maxColumnCount_";
  protected final String TEXT_130 = ";i";
  protected final String TEXT_131 = "++) {" + NL + "\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_132 = " = dynamic_";
  protected final String TEXT_133 = ".getColumnMetadata(i";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_135 = " = dynamicMetadataColumn_";
  protected final String TEXT_136 = ".getLength();" + NL + "\t\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_137 = " = substringBegin";
  protected final String TEXT_138 = "+currentFieldLength_";
  protected final String TEXT_139 = ";" + NL + "\t\t\t\t\t\t\t\tif(substringEnd";
  protected final String TEXT_140 = " > rowLen_";
  protected final String TEXT_141 = "){" + NL + "\t\t\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_142 = " = rowLen_";
  protected final String TEXT_143 = ";" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_145 = " = arrays_";
  protected final String TEXT_146 = ".copyOfRange(row_";
  protected final String TEXT_147 = ".getBytes(";
  protected final String TEXT_148 = "),substringBegin";
  protected final String TEXT_149 = ", substringEnd";
  protected final String TEXT_150 = ");" + NL + "\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_151 = " = new String(temp_byteArray_";
  protected final String TEXT_152 = ",";
  protected final String TEXT_153 = ");\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_155 = " = row_";
  protected final String TEXT_156 = ".substring(substringBegin";
  protected final String TEXT_157 = ", substringEnd";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_160 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_161 = ", ";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_165 = " = currentColumnValue_";
  protected final String TEXT_166 = ".trim();";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\t\t\tString type_";
  protected final String TEXT_168 = " = dynamicMetadataColumn_";
  protected final String TEXT_169 = ".getType();" + NL + "\t\t\t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_170 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_171 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_172 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_173 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_174 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_175 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_176 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = ", ";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_181 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_183 = " = substringEnd";
  protected final String TEXT_184 = "; " + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = dynamic_";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "\tif(column_";
  protected final String TEXT_189 = ".length() > 0) {";
  protected final String TEXT_190 = NL + "\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_193 = ", ";
  protected final String TEXT_194 = ",false);";
  protected final String TEXT_195 = NL + "\t\t";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_198 = ", ";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " = ParserUtils.parseTo_";
  protected final String TEXT_203 = "(ParserUtils.parseTo_Number(column_";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = ", ";
  protected final String TEXT_206 = "));";
  protected final String TEXT_207 = NL + "\t\t";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = column_";
  protected final String TEXT_210 = ".getBytes(";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "\t\t";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = " = ParserUtils.parseTo_";
  protected final String TEXT_215 = "(column_";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "    }else{" + NL + "    \t";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = " = ";
  protected final String TEXT_220 = ";" + NL + "    }";
  protected final String TEXT_221 = NL + "                    }";
  protected final String TEXT_222 = NL + "                }";
  protected final String TEXT_223 = NL + "                     void setValue_";
  protected final String TEXT_224 = "(";
  protected final String TEXT_225 = "Struct ";
  protected final String TEXT_226 = ",String[] columnValue";
  protected final String TEXT_227 = ")throws java.lang.Exception{";
  protected final String TEXT_228 = NL + "\t                    ";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = columnValue";
  protected final String TEXT_231 = "[";
  protected final String TEXT_232 = "];";
  protected final String TEXT_233 = NL + "\t                    if(columnValue";
  protected final String TEXT_234 = "[";
  protected final String TEXT_235 = "].length() > 0) {";
  protected final String TEXT_236 = "\t" + NL + "\t\t                            ";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_239 = "[";
  protected final String TEXT_240 = "], ";
  protected final String TEXT_241 = ",false);";
  protected final String TEXT_242 = NL + "\t\t                            ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_245 = "[";
  protected final String TEXT_246 = "], ";
  protected final String TEXT_247 = ");\t";
  protected final String TEXT_248 = NL + "\t\t                        ";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = ParserUtils.parseTo_";
  protected final String TEXT_251 = "(ParserUtils.parseTo_Number(columnValue";
  protected final String TEXT_252 = "[";
  protected final String TEXT_253 = "], ";
  protected final String TEXT_254 = ", ";
  protected final String TEXT_255 = "));";
  protected final String TEXT_256 = "\t" + NL + "\t\t                        ";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = columnValue";
  protected final String TEXT_259 = "[";
  protected final String TEXT_260 = "].getBytes(";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = "\t" + NL + "\t\t                        ";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " = ParserUtils.parseTo_";
  protected final String TEXT_265 = "(columnValue";
  protected final String TEXT_266 = "[";
  protected final String TEXT_267 = "].trim());";
  protected final String TEXT_268 = NL + "                        }else{" + NL + "        \t                ";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";" + NL + "                        }";
  protected final String TEXT_272 = NL;
  protected final String TEXT_273 = NL + "                     }";
  protected final String TEXT_274 = NL;
  protected final String TEXT_275 = NL + "                     }";
  protected final String TEXT_276 = NL;
  protected final String TEXT_277 = NL + "}" + NL + "" + NL + "PositionalUtil_";
  protected final String TEXT_278 = " positionalUtil_";
  protected final String TEXT_279 = "=new PositionalUtil_";
  protected final String TEXT_280 = "();" + NL;
  protected final String TEXT_281 = NL + NL + "int[] sizes_";
  protected final String TEXT_282 = " = new int[";
  protected final String TEXT_283 = "];" + NL + "int[] begins_";
  protected final String TEXT_284 = " = new int[";
  protected final String TEXT_285 = "];" + NL + "int[] ends_";
  protected final String TEXT_286 = " = new int[";
  protected final String TEXT_287 = "];";
  protected final String TEXT_288 = NL + "sizes_";
  protected final String TEXT_289 = "[";
  protected final String TEXT_290 = "] = ";
  protected final String TEXT_291 = ";";
  protected final String TEXT_292 = NL + "sizes_";
  protected final String TEXT_293 = "[";
  protected final String TEXT_294 = "] = ";
  protected final String TEXT_295 = ";\t\t\t\t";
  protected final String TEXT_296 = NL + "begins_";
  protected final String TEXT_297 = "[";
  protected final String TEXT_298 = "] = 0;" + NL + "ends_";
  protected final String TEXT_299 = "[";
  protected final String TEXT_300 = "] = sizes_";
  protected final String TEXT_301 = "[";
  protected final String TEXT_302 = "];";
  protected final String TEXT_303 = NL + "begins_";
  protected final String TEXT_304 = "[";
  protected final String TEXT_305 = "] = begins_";
  protected final String TEXT_306 = "[";
  protected final String TEXT_307 = "] + sizes_";
  protected final String TEXT_308 = "[";
  protected final String TEXT_309 = "];" + NL + "ends_";
  protected final String TEXT_310 = "[";
  protected final String TEXT_311 = "] = -1;";
  protected final String TEXT_312 = NL + "begins_";
  protected final String TEXT_313 = "[";
  protected final String TEXT_314 = "] = begins_";
  protected final String TEXT_315 = "[";
  protected final String TEXT_316 = "] + sizes_";
  protected final String TEXT_317 = "[";
  protected final String TEXT_318 = "];" + NL + "ends_";
  protected final String TEXT_319 = "[";
  protected final String TEXT_320 = "] = ends_";
  protected final String TEXT_321 = "[";
  protected final String TEXT_322 = "] + sizes_";
  protected final String TEXT_323 = "[";
  protected final String TEXT_324 = "];";
  protected final String TEXT_325 = NL + "Object filename_";
  protected final String TEXT_326 = " = ";
  protected final String TEXT_327 = ";" + NL + "java.io.BufferedReader in_";
  protected final String TEXT_328 = " = null;" + NL + "org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_329 = " = null; ";
  protected final String TEXT_330 = NL + "java.util.zip.ZipInputStream zis_";
  protected final String TEXT_331 = " = null;" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_332 = " instanceof java.io.InputStream){" + NL + "\t\tzis_";
  protected final String TEXT_333 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_334 = "));" + NL + "\t}else{" + NL + "\t\tzis_";
  protected final String TEXT_335 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_336 = "))));" + NL + "\t}" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_337 = NL + "\tthrow e;" + NL + "\t";
  protected final String TEXT_338 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_339 = NL + "}" + NL + "java.util.zip.ZipEntry entry_";
  protected final String TEXT_340 = " = null;" + NL + "while (true) {" + NL + "\ttry {" + NL + "\t\tentry_";
  protected final String TEXT_341 = " = zis_";
  protected final String TEXT_342 = ".getNextEntry();" + NL + "\t} catch(java.lang.Exception e) {" + NL + "\t\t";
  protected final String TEXT_343 = NL + "\t\tthrow e;" + NL + "\t\t";
  protected final String TEXT_344 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t\tbreak;" + NL + "\t\t";
  protected final String TEXT_345 = NL + "\t}" + NL + "\tif(entry_";
  protected final String TEXT_346 = " == null) {" + NL + "\t\tbreak;" + NL + "\t}" + NL + "\tif(entry_";
  protected final String TEXT_347 = ".isDirectory()){ //directory" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tString row_";
  protected final String TEXT_348 = " = null;" + NL + "\tint rowLen_";
  protected final String TEXT_349 = " = 0;" + NL + "\t";
  protected final String TEXT_350 = NL + "\tbyte[] byteArray_";
  protected final String TEXT_351 = " = new byte[0];" + NL + "\t";
  protected final String TEXT_352 = NL + "\tString column_";
  protected final String TEXT_353 = " = null;" + NL + "\t";
  protected final String TEXT_354 = NL + "\tbyte[][] byteArray_";
  protected final String TEXT_355 = " = new byte[";
  protected final String TEXT_356 = "][];" + NL + "\t";
  protected final String TEXT_357 = NL + "\tString[] columnValue";
  protected final String TEXT_358 = "=new String[";
  protected final String TEXT_359 = "];" + NL + "\t";
  protected final String TEXT_360 = NL + "\ttry {//TD110 begin" + NL + "\t\tin_";
  protected final String TEXT_361 = " = new java.io.BufferedReader(new java.io.InputStreamReader(zis_";
  protected final String TEXT_362 = ", ";
  protected final String TEXT_363 = "));";
  protected final String TEXT_364 = NL + "String row_";
  protected final String TEXT_365 = " = null;" + NL + "int rowLen_";
  protected final String TEXT_366 = " = 0;";
  protected final String TEXT_367 = NL + "byte[] byteArray_";
  protected final String TEXT_368 = " = new byte[0];";
  protected final String TEXT_369 = NL + "String column_";
  protected final String TEXT_370 = " = null;";
  protected final String TEXT_371 = NL + "byte[][] byteArray_";
  protected final String TEXT_372 = " = new byte[";
  protected final String TEXT_373 = "][];";
  protected final String TEXT_374 = NL + "String[] columnValue";
  protected final String TEXT_375 = "=new String[";
  protected final String TEXT_376 = "];";
  protected final String TEXT_377 = " " + NL + "try {//TD110 begin" + NL + "\tif(filename_";
  protected final String TEXT_378 = " instanceof java.io.InputStream){" + NL + "\t\tin_";
  protected final String TEXT_379 = " = " + NL + "\t\t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_380 = ", ";
  protected final String TEXT_381 = "));" + NL + "\t}else{" + NL + "\t\tin_";
  protected final String TEXT_382 = " = " + NL + "\t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_383 = ")), ";
  protected final String TEXT_384 = "));" + NL + "\t}" + NL;
  protected final String TEXT_385 = NL + "int rowLength_";
  protected final String TEXT_386 = " = 0;";
  protected final String TEXT_387 = NL + "rowLength_";
  protected final String TEXT_388 = " += sizes_";
  protected final String TEXT_389 = "[";
  protected final String TEXT_390 = "];";
  protected final String TEXT_391 = NL + "rowLength_";
  protected final String TEXT_392 = " += ";
  protected final String TEXT_393 = ";";
  protected final String TEXT_394 = NL + "reader_";
  protected final String TEXT_395 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_396 = ", rowLength_";
  protected final String TEXT_397 = ");";
  protected final String TEXT_398 = NL + "reader_";
  protected final String TEXT_399 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_400 = ", ";
  protected final String TEXT_401 = ", ";
  protected final String TEXT_402 = ");";
  protected final String TEXT_403 = NL + "reader_";
  protected final String TEXT_404 = ".setSafetySwitch(";
  protected final String TEXT_405 = ");" + NL + "reader_";
  protected final String TEXT_406 = ".skipHeaders(";
  protected final String TEXT_407 = ");" + NL + "if(footer_";
  protected final String TEXT_408 = " > 0){" + NL + "\tint available_";
  protected final String TEXT_409 = " = (int)reader_";
  protected final String TEXT_410 = ".getAvailableRowCount(footer_";
  protected final String TEXT_411 = ");" + NL + "\treader_";
  protected final String TEXT_412 = ".close();" + NL + "\tif(filename_";
  protected final String TEXT_413 = " instanceof java.io.InputStream){" + NL + "\t\tin_";
  protected final String TEXT_414 = " = new java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_415 = ", ";
  protected final String TEXT_416 = "));" + NL + "\t}else{" + NL + "\t\tin_";
  protected final String TEXT_417 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_418 = ")), ";
  protected final String TEXT_419 = "));" + NL + "\t}";
  protected final String TEXT_420 = NL + "\treader_";
  protected final String TEXT_421 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_422 = ", rowLength_";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "\treader_";
  protected final String TEXT_425 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_426 = ", ";
  protected final String TEXT_427 = ", ";
  protected final String TEXT_428 = ");";
  protected final String TEXT_429 = "\t" + NL + "\treader_";
  protected final String TEXT_430 = ".skipHeaders(";
  protected final String TEXT_431 = ");" + NL + "\t" + NL + "\tif ( nb_limit_";
  protected final String TEXT_432 = " >= 0 ){" + NL + "\t\tnb_limit_";
  protected final String TEXT_433 = " = ( nb_limit_";
  protected final String TEXT_434 = " > available_";
  protected final String TEXT_435 = ") ? available_";
  protected final String TEXT_436 = " : nb_limit_";
  protected final String TEXT_437 = ";" + NL + "\t}else{" + NL + "\t\tnb_limit_";
  protected final String TEXT_438 = " = available_";
  protected final String TEXT_439 = ";" + NL + "\t}" + NL + "}" + NL + "" + NL + "} catch(java.lang.Exception e) {//TD110 end" + NL + "\t";
  protected final String TEXT_440 = NL + "\tthrow e;" + NL + "\t";
  protected final String TEXT_441 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_442 = NL + "}" + NL;
  protected final String TEXT_443 = NL + "\t\tString arrFieldSeparator";
  protected final String TEXT_444 = "[] = \"";
  protected final String TEXT_445 = "\".split(\",\");";
  protected final String TEXT_446 = "\t\t" + NL + "\t\tString arrFieldSeparator";
  protected final String TEXT_447 = "[] = ";
  protected final String TEXT_448 = ".split(\",\");";
  protected final String TEXT_449 = " " + NL + "" + NL + "Integer star_";
  protected final String TEXT_450 = " = Integer.valueOf(-1);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "Integer[] tmpAry_";
  protected final String TEXT_451 = " = new Integer[arrFieldSeparator";
  protected final String TEXT_452 = ".length];\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "for (int i";
  protected final String TEXT_453 = " = 0; i";
  protected final String TEXT_454 = " < arrFieldSeparator";
  protected final String TEXT_455 = ".length; i";
  protected final String TEXT_456 = "++ ){\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\tif ((\"*\").equals(arrFieldSeparator";
  protected final String TEXT_457 = "[i";
  protected final String TEXT_458 = "])) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\ttmpAry_";
  protected final String TEXT_459 = "[i";
  protected final String TEXT_460 = "] = star_";
  protected final String TEXT_461 = ";\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t}else{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\ttmpAry_";
  protected final String TEXT_462 = "[i";
  protected final String TEXT_463 = "] = Integer.parseInt(arrFieldSeparator";
  protected final String TEXT_464 = "[i";
  protected final String TEXT_465 = "]);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "}\t";
  protected final String TEXT_466 = NL + "while (nb_limit_";
  protected final String TEXT_467 = " != 0 && reader_";
  protected final String TEXT_468 = "!=null && reader_";
  protected final String TEXT_469 = ".readRecord()) {" + NL + "\trow_";
  protected final String TEXT_470 = " = reader_";
  protected final String TEXT_471 = ".getRowRecord();";
  protected final String TEXT_472 = NL + "\trowLen_";
  protected final String TEXT_473 = " = row_";
  protected final String TEXT_474 = ".getBytes(";
  protected final String TEXT_475 = ").length;";
  protected final String TEXT_476 = NL + "\trowLen_";
  protected final String TEXT_477 = " = row_";
  protected final String TEXT_478 = ".length();";
  protected final String TEXT_479 = NL + "    \t\t";
  protected final String TEXT_480 = " = null;\t\t\t";
  protected final String TEXT_481 = NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_482 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_483 = " = new ";
  protected final String TEXT_484 = "Struct();" + NL + "\t\t\ttry {" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_485 = NL + "                  positionalUtil_";
  protected final String TEXT_486 = ".setValue_";
  protected final String TEXT_487 = "(";
  protected final String TEXT_488 = ",begins_";
  protected final String TEXT_489 = ",ends_";
  protected final String TEXT_490 = ",rowLen_";
  protected final String TEXT_491 = ",";
  protected final String TEXT_492 = "byteArray_";
  protected final String TEXT_493 = ",arrays_";
  protected final String TEXT_494 = ",";
  protected final String TEXT_495 = "column_";
  protected final String TEXT_496 = ",row_";
  protected final String TEXT_497 = ");          ";
  protected final String TEXT_498 = NL + "\tint substringBegin";
  protected final String TEXT_499 = "=0,substringEnd";
  protected final String TEXT_500 = "=0;" + NL + "\tint[]begin_end_";
  protected final String TEXT_501 = "=new int[2];" + NL + "\t";
  protected final String TEXT_502 = "\t" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_503 = "[";
  protected final String TEXT_504 = "]=\"\";";
  protected final String TEXT_505 = " " + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_506 = ".clearColumnValues();" + NL + "\t\t\t\tfor (int i";
  protected final String TEXT_507 = "=0;i";
  protected final String TEXT_508 = "<maxColumnCount_";
  protected final String TEXT_509 = ";i";
  protected final String TEXT_510 = "++) {" + NL + "\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_511 = " = dynamic_";
  protected final String TEXT_512 = ".getColumnMetadata(i";
  protected final String TEXT_513 = ");" + NL + "\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_514 = " = dynamicMetadataColumn_";
  protected final String TEXT_515 = ".getLength();" + NL + "\t\t\t\t\tsubstringEnd";
  protected final String TEXT_516 = " = substringBegin";
  protected final String TEXT_517 = "+currentFieldLength_";
  protected final String TEXT_518 = ";" + NL + "\t\t\t\t\tif(substringEnd";
  protected final String TEXT_519 = " > rowLen_";
  protected final String TEXT_520 = "){" + NL + "\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_521 = " = rowLen_";
  protected final String TEXT_522 = ";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_523 = NL + "\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_524 = "= arrays_";
  protected final String TEXT_525 = ".copyOfRange(row_";
  protected final String TEXT_526 = ".getBytes(";
  protected final String TEXT_527 = "),substringBegin";
  protected final String TEXT_528 = ", substringEnd";
  protected final String TEXT_529 = ");" + NL + "\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_530 = " = new String(temp_byteArray_";
  protected final String TEXT_531 = ",";
  protected final String TEXT_532 = ");\t\t\t\t\t\t";
  protected final String TEXT_533 = NL + "\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_534 = " = row_";
  protected final String TEXT_535 = ".substring(substringBegin";
  protected final String TEXT_536 = ", substringEnd";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = "\t\t\t" + NL + "\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_539 = " = currentColumnValue_";
  protected final String TEXT_540 = ".trim();";
  protected final String TEXT_541 = " " + NL + "\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_542 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_543 = ", ";
  protected final String TEXT_544 = ", ";
  protected final String TEXT_545 = ");";
  protected final String TEXT_546 = NL + "\t\t\t\t\t\tString type_";
  protected final String TEXT_547 = " = dynamicMetadataColumn_";
  protected final String TEXT_548 = ".getType();" + NL + "\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_549 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_550 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_551 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_552 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_553 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_554 = ")){" + NL + "\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_555 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_556 = ", ";
  protected final String TEXT_557 = ", ";
  protected final String TEXT_558 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_559 = NL + "\t\t\t\t\tdynamic_";
  protected final String TEXT_560 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_561 = ");" + NL + "\t\t\t\t\tsubstringBegin";
  protected final String TEXT_562 = " = substringEnd";
  protected final String TEXT_563 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_564 = NL + "\t\t    if(substringBegin";
  protected final String TEXT_565 = " >= rowLen_";
  protected final String TEXT_566 = "){" + NL + "\t\t    \tcolumnValue";
  protected final String TEXT_567 = "[";
  protected final String TEXT_568 = "]= \"\";" + NL + "    \t\t}else{";
  protected final String TEXT_569 = NL + "        \t\t\t \tsubstringEnd";
  protected final String TEXT_570 = "=rowLen_";
  protected final String TEXT_571 = ";";
  protected final String TEXT_572 = NL + "        \t\t\t\tsubstringEnd";
  protected final String TEXT_573 = " = substringEnd";
  protected final String TEXT_574 = " + ";
  protected final String TEXT_575 = ";" + NL + "        " + NL + "\t\t\t\t        if(substringEnd";
  protected final String TEXT_576 = " > rowLen_";
  protected final String TEXT_577 = "){" + NL + "\t\t\t\t        \tsubstringEnd";
  protected final String TEXT_578 = " = rowLen_";
  protected final String TEXT_579 = ";" + NL + "\t\t\t\t    \t}";
  protected final String TEXT_580 = NL + "\t\t\t\t\tbyteArray_";
  protected final String TEXT_581 = "[";
  protected final String TEXT_582 = "] = arrays_";
  protected final String TEXT_583 = ".copyOfRange(row_";
  protected final String TEXT_584 = ".getBytes(";
  protected final String TEXT_585 = "),substringBegin";
  protected final String TEXT_586 = ", substringEnd";
  protected final String TEXT_587 = ");" + NL + "\t\t\t\t\tcolumnValue";
  protected final String TEXT_588 = "[";
  protected final String TEXT_589 = "] = new String(byteArray_";
  protected final String TEXT_590 = "[";
  protected final String TEXT_591 = "],";
  protected final String TEXT_592 = ");";
  protected final String TEXT_593 = NL + "        \t\t\tcolumnValue";
  protected final String TEXT_594 = "[";
  protected final String TEXT_595 = "] = row_";
  protected final String TEXT_596 = ".substring(substringBegin";
  protected final String TEXT_597 = ", substringEnd";
  protected final String TEXT_598 = ");";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_600 = "[";
  protected final String TEXT_601 = "] = columnValue";
  protected final String TEXT_602 = "[";
  protected final String TEXT_603 = "].trim();";
  protected final String TEXT_604 = "    \t" + NL + "        \t\t\tsubstringBegin";
  protected final String TEXT_605 = " = substringEnd";
  protected final String TEXT_606 = ";" + NL + "\t\t\t}";
  protected final String TEXT_607 = NL + "\t\tfor (int i_";
  protected final String TEXT_608 = " = 0; i_";
  protected final String TEXT_609 = " < ";
  protected final String TEXT_610 = "; i_";
  protected final String TEXT_611 = "++) {" + NL + "\t\t\tif (i_";
  protected final String TEXT_612 = " >= arrFieldSeparator";
  protected final String TEXT_613 = ".length ){" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_614 = "[i_";
  protected final String TEXT_615 = "]=\"\";" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t ";
  protected final String TEXT_616 = NL + "\t\t\t\tif(i_";
  protected final String TEXT_617 = "==";
  protected final String TEXT_618 = "){" + NL + "\t\t\t\t\tdynamic_";
  protected final String TEXT_619 = ".clearColumnValues();" + NL + "\t\t\t \t\tfor (int i";
  protected final String TEXT_620 = "=0;i";
  protected final String TEXT_621 = "<maxColumnCount_";
  protected final String TEXT_622 = ";i";
  protected final String TEXT_623 = "++) {" + NL + "\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_624 = " = dynamic_";
  protected final String TEXT_625 = ".getColumnMetadata(i";
  protected final String TEXT_626 = ");" + NL + "\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_627 = " = dynamicMetadataColumn_";
  protected final String TEXT_628 = ".getLength();" + NL + "\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_629 = " = substringBegin";
  protected final String TEXT_630 = "+currentFieldLength_";
  protected final String TEXT_631 = ";" + NL + "\t\t\t\t\t\tif(substringEnd";
  protected final String TEXT_632 = " > rowLen_";
  protected final String TEXT_633 = "){" + NL + "\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_634 = " = rowLen_";
  protected final String TEXT_635 = ";" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_636 = NL + "\t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_637 = " = arrays_";
  protected final String TEXT_638 = ".copyOfRange(row_";
  protected final String TEXT_639 = ".getBytes(";
  protected final String TEXT_640 = "),substringBegin";
  protected final String TEXT_641 = ", substringEnd";
  protected final String TEXT_642 = ");" + NL + "\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_643 = " = new String(temp_byteArray_";
  protected final String TEXT_644 = ",";
  protected final String TEXT_645 = ");\t\t\t\t\t\t";
  protected final String TEXT_646 = NL + "\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_647 = " = row_";
  protected final String TEXT_648 = ".substring(substringBegin";
  protected final String TEXT_649 = ", substringEnd";
  protected final String TEXT_650 = ");";
  protected final String TEXT_651 = NL + "\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_652 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_653 = ", ";
  protected final String TEXT_654 = ", ";
  protected final String TEXT_655 = ");";
  protected final String TEXT_656 = NL + "\t\t\t\t\t\t\tString type_";
  protected final String TEXT_657 = " = dynamicMetadataColumn_";
  protected final String TEXT_658 = ".getType();" + NL + "\t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_659 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_660 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_661 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_662 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_663 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_664 = ")){" + NL + "\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_665 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_666 = ", ";
  protected final String TEXT_667 = ", ";
  protected final String TEXT_668 = ");" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_669 = NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_670 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_671 = ");" + NL + "\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_672 = " = substringEnd";
  protected final String TEXT_673 = "; " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_674 = NL + "\t\t    if (substringBegin";
  protected final String TEXT_675 = " >= rowLen_";
  protected final String TEXT_676 = ") {" + NL + "\t\t    \tcolumnValue";
  protected final String TEXT_677 = "[i_";
  protected final String TEXT_678 = "] = \"\";" + NL + "\t\t    } else{" + NL + "\t\t    " + NL + "\t\t\t\tif ((star_";
  protected final String TEXT_679 = ").equals(tmpAry_";
  protected final String TEXT_680 = "[i_";
  protected final String TEXT_681 = "])){" + NL + "\t\t\t\t\tsubstringEnd";
  protected final String TEXT_682 = " = rowLen_";
  protected final String TEXT_683 = ";" + NL + "\t\t\t\t} else{" + NL + "\t    \t\t\tsubstringEnd";
  protected final String TEXT_684 = " = substringEnd";
  protected final String TEXT_685 = " +tmpAry_";
  protected final String TEXT_686 = "[i_";
  protected final String TEXT_687 = "];" + NL + "\t\t\t        if(substringEnd";
  protected final String TEXT_688 = " > rowLen_";
  protected final String TEXT_689 = ")" + NL + "\t\t\t        \tsubstringEnd";
  protected final String TEXT_690 = " = rowLen_";
  protected final String TEXT_691 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_692 = NL + "\t\t\t\tbyteArray_";
  protected final String TEXT_693 = "[i_";
  protected final String TEXT_694 = "] = arrays_";
  protected final String TEXT_695 = ".copyOfRange(row_";
  protected final String TEXT_696 = ".getBytes(";
  protected final String TEXT_697 = "),substringBegin";
  protected final String TEXT_698 = ", substringEnd";
  protected final String TEXT_699 = ");" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_700 = "[i_";
  protected final String TEXT_701 = "] = new String(byteArray_";
  protected final String TEXT_702 = "[i_";
  protected final String TEXT_703 = "],";
  protected final String TEXT_704 = ");";
  protected final String TEXT_705 = NL + "\t        \tcolumnValue";
  protected final String TEXT_706 = "[i_";
  protected final String TEXT_707 = "] = row_";
  protected final String TEXT_708 = ".substring(substringBegin";
  protected final String TEXT_709 = ", substringEnd";
  protected final String TEXT_710 = ");\t";
  protected final String TEXT_711 = NL + "\t        \tif (";
  protected final String TEXT_712 = ")" + NL + "\t        \t\tcolumnValue";
  protected final String TEXT_713 = "[i_";
  protected final String TEXT_714 = "] = columnValue";
  protected final String TEXT_715 = "[i_";
  protected final String TEXT_716 = "].trim();" + NL + "\t        \t" + NL + "\t        \tsubstringBegin";
  protected final String TEXT_717 = " = substringEnd";
  protected final String TEXT_718 = ";" + NL + "\t        }" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_719 = NL + "   positionalUtil_";
  protected final String TEXT_720 = ".setValue_";
  protected final String TEXT_721 = "(";
  protected final String TEXT_722 = ",columnValue";
  protected final String TEXT_723 = ");";
  protected final String TEXT_724 = NL + "\t\t\t";
  protected final String TEXT_725 = ".";
  protected final String TEXT_726 = "=dynamic_";
  protected final String TEXT_727 = ";";
  protected final String TEXT_728 = NL + "        \t\t\t";
  protected final String TEXT_729 = " ";
  protected final String TEXT_730 = " = null; ";
  protected final String TEXT_731 = "        \t\t\t" + NL + "        \t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_732 = " = true;";
  protected final String TEXT_733 = NL + "            throw(e);";
  protected final String TEXT_734 = NL + "                    ";
  protected final String TEXT_735 = " = new ";
  protected final String TEXT_736 = "Struct();";
  protected final String TEXT_737 = NL + "                    ";
  protected final String TEXT_738 = ".";
  protected final String TEXT_739 = " = ";
  protected final String TEXT_740 = ".";
  protected final String TEXT_741 = ";";
  protected final String TEXT_742 = NL + "                ";
  protected final String TEXT_743 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_744 = ";";
  protected final String TEXT_745 = NL + "                ";
  protected final String TEXT_746 = " = null;";
  protected final String TEXT_747 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_748 = NL + "                ";
  protected final String TEXT_749 = " = null;";
  protected final String TEXT_750 = NL + "            \t";
  protected final String TEXT_751 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_752 = ";";
  protected final String TEXT_753 = NL + "    }" + NL + "        \t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_754 = NL + "\t\t";
  protected final String TEXT_755 = "if(!whetherReject_";
  protected final String TEXT_756 = ") { ";
  protected final String TEXT_757 = "      " + NL + "             if(";
  protected final String TEXT_758 = " == null){ " + NL + "            \t ";
  protected final String TEXT_759 = " = new ";
  protected final String TEXT_760 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_761 = NL + "\t    \t ";
  protected final String TEXT_762 = ".";
  protected final String TEXT_763 = " = ";
  protected final String TEXT_764 = ".";
  protected final String TEXT_765 = ";    \t\t\t\t";
  protected final String TEXT_766 = NL + "\t\t";
  protected final String TEXT_767 = " } ";
  protected final String TEXT_768 = "\t";
  protected final String TEXT_769 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<? extends IConnection> connsFlow = node.getOutgoingConnections("FLOW");

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern1 = ElementParameterParser.getValue(node, "__PATTERN__");
            
            boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
            boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && ("false").equals(trimAll)){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		if ("".equals(limit.trim())) limit = "-1";
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
        	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    		
    		//need to process rows longger than 100 000 characters, the property SafetySwitch(in talend_file_enhanced_20070724.jar) should be sent to false.(the default is true)
    		//that means if check the option(true), the logic value of bSafetySwitch should be changed to false (XOR with 'true')
    		boolean bSafetySwitch = (("true").equals(ElementParameterParser.getValue(node, "__PROCESS_LONG_ROW__")) ^ true);    		
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);    		  
			
			String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
			boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
			
			boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
			
    		if(("").equals(header)){
    			header = "0";
    		}
    			
    		if(("").equals(footer)){
    			footer = "0";
    		}
    		
    		boolean useStar = false;
    		
    		String pattern=TalendTextUtils.removeQuotes(pattern1);
    		String[] positions=(pattern.trim()).split(",");
    		for(int i=0;i<positions.length;i++){
            	if(("").equals(positions[i])){
               	 	positions[i]="0";
            	}
            	if(("*").equals(positions[i])){
            		useStar = true;
            	}
            }
			boolean hasDynamic = metadata.isDynamicSchema();
			String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
			boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
            String dyn = dynamic+"_DYNAMIC";
			if(useExistingDynamic){
				useStar = true;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_13);
    
		if(useByte){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
		}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
String firstConnName = "";
if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
    			if(advanced){// custom part start
    				for (int valueN=0; valueN<sizeListColumns; valueN++) {
    					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
    					String align = formats.get(valueN).get("ALIGN");
    					if(("'L'").equals(align)){
    						align = "-1";
    					}else if(("'C'").equals(align)){
    						align = "0";
    					}else{
    						align = "1";
    					}
    					if(valueN%100==0){

    stringBuffer.append(TEXT_21);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
     if(useByte){ 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
     } 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
}
    					if(valueN == sizeListColumns - 1 && useStar){ //last column

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
							if(useByte){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_51);
    
							}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_58);
    
							}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
						}else{//other column
							if(useByte){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
							}else{

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
							}
						}
						if(isTrimAll || ("true").equals(trimSelects.get(valueN).get("TRIM"))){

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
						}
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
					} else if("id_Dynamic".equals(column.getTalendType())){
						if(useExistingDynamic){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    
								if(useByte){

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_153);
    
								}else{

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    
								}
								if(advanced){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_163);
    
								}
								if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
								}
								if(advancedSeparator) { 

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
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
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_179);
    
								}

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    
						}
					} else {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    
						if(javaType == JavaTypesManager.DATE) {
							if(checkDate) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_194);
    
							} else {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_199);
    
							}
						}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_200);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_206);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_211);
    
							} else {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    
							}

    stringBuffer.append(TEXT_217);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_220);
    					
					}
					if((valueN+1)%100==0){

    stringBuffer.append(TEXT_221);
                      }
				}//end for_
				if(sizeListColumns>0&&(sizeListColumns%100)>0){

    stringBuffer.append(TEXT_222);
    
				}
	}//custom end
    else{//custom not check
				for (int valueN=0; valueN<sizeListColumns; valueN++) {	
				    if(valueN%100==0){

    stringBuffer.append(TEXT_223);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    
                    }	

    
                    IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_232);
    
					}else if("id_Dynamic".equals(column.getTalendType())){
						
					} else {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_235);
    
					        if(javaType == JavaTypesManager.DATE) {
								if(checkDate) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_240);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_241);
    
								} else {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_246);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_247);
    
								}
							}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_253);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_255);
    
					        }else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_256);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_261);
    
							} else {

    stringBuffer.append(TEXT_262);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_267);
    
							}

    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_271);
    
        			}

    stringBuffer.append(TEXT_272);
    
             if((valueN+1)%100==0){

    stringBuffer.append(TEXT_273);
    
             }
         }

    stringBuffer.append(TEXT_274);
    
            if(sizeListColumns>0&&(sizeListColumns%100)>0){

    stringBuffer.append(TEXT_275);
    
             }

    stringBuffer.append(TEXT_276);
              }//custom not check
		}
	}
}

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    
		if(advanced){

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_287);
    
			for(int i = 0; i < formats.size(); i++){ 
				if(i == formats.size() - 1 && !(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
					if(("*").equals(formats.get(i).get("SIZE"))){ 
						useStar = true;
					}

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(useStar ? -1 :  formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_291);
    
				}else{

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_295);
    
				}
			}
			for(int i = 0; i < formats.size(); i++){ 
				if(i == 0){

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_302);
    
				}else if(i == formats.size() - 1 && useStar){

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_311);
    
				}else{

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_324);
    
				}
			}
		}//end if(advanced)

    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    
		if(uncompress){

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
     if(dieOnError) {
    stringBuffer.append(TEXT_337);
     } else { 
    stringBuffer.append(TEXT_338);
     } 
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
     if(dieOnError) {
    stringBuffer.append(TEXT_343);
     } else { 
    stringBuffer.append(TEXT_344);
     } 
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    
	if(advanced){
		if(useByte){
	
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    
	}
	
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    
	}else{
		if(useByte){
	
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_356);
    
		}
	
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_359);
    
	}
	
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_363);
    
		}else{

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    
if(advanced){
	if(useByte){

    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    
}

    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    
}else{
	if(useByte){

    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_373);
    
	}

    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_376);
    
}

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_384);
    
		}
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 

    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_390);
    
					}
				}else{
    				for(int i=0;i<positions.length;i++){

    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(positions[i] );
    stringBuffer.append(TEXT_393);
    
        			}
				}

    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    
			}else{

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_402);
    
			}

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_419);
    
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    
			}else{

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_428);
    
			}

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
     if(dieOnError) {
    stringBuffer.append(TEXT_440);
     } else { 
    stringBuffer.append(TEXT_441);
     } 
    stringBuffer.append(TEXT_442);
    
if ( !(java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches() )){
		if(pattern1.startsWith("\"")){

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(positions[0] );
    stringBuffer.append(TEXT_445);
     
		}else{

    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(positions[0]);
    stringBuffer.append(TEXT_448);
     
		}

    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
}	

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    
	if(useByte){

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_475);
    
	}else{

    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    
	}

    
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_479);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_480);
    
    				}
    			}
    		}
    	}
    	
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_484);
    
    			if(advanced){
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
   				   int sizeListColumns = listColumns.size();
    				for (int valueN=0; valueN<sizeListColumns; valueN++) {
    					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
    					String align = formats.get(valueN).get("ALIGN");
    					if(("'L'").equals(align)){
    						align = "-1";
    					}else if(("'C'").equals(align)){
    						align = "0";
    					}else{
    						align = "1";
    					}
                   if(valueN%100==0){

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
     if(useByte){ 
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
     } 
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    
                  }
				}
			}else{// end if(advance)

    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    
	///////////////////
	//Branch: first item is a numberic, not '((String)globalMap.get("global_variable"))' or 'context.Separator'
	if ( java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches() ){
	///////////////////
	
	    List<IMetadataColumn> columnList = metadata.getListColumns();
		for(int i=0;i <	columnList.size();i++){
		    IMetadataColumn column = columnList.get(i);
		    if(i >=positions.length){

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_504);
    
				continue;
			}
			if("id_Dynamic".equals(column.getTalendType()) && useExistingDynamic){
				String paddingChar = formats.get(i).get("PADDING_CHAR");
				String align = formats.get(i).get("ALIGN");

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    
					if(useByte){

    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_532);
    
					}else{

    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    
					}
					if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    
					}
					if(advanced){

    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_545);
    
					}
					if(advancedSeparator) { 

    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_558);
    
					}

    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    
                continue;
			}

    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_568);
    
					if(("*").equals(positions[i])){

    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    
					} else{

    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(positions[i]);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    
					}
					if(useByte){

    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_592);
    
					}else{

    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
     
					}
       				if(isTrimAll || ("true").equals(trimSelects.get(i).get("TRIM"))){

    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_603);
    
					}

    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    
	
		}//for(...)
				
	///////////////
	} else{
	    List<IMetadataColumn> listColumns = metadata.getListColumns();
	    int column_index=listColumns.size()-1;
	    for(int i = 0;i<listColumns.size();i++){
	        if("id_Dynamic".equals(listColumns.get(i).getTalendType())){
	            column_index = i;
	        }
	    }

    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    
			if(useExistingDynamic){
				String paddingChar = formats.get(formats.size()-1).get("PADDING_CHAR");
				String align = formats.get(formats.size()-1).get("ALIGN");

    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(column_index);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    
						if(useByte){

    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_645);
    
						}else{

    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    
						}
						if(advanced){

    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_655);
    
						}
						if(advancedSeparator) { 

    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_667);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_668);
    
						}

    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    
			}

    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    
		if(useByte){

    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_696);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_704);
    
		}else{

    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    
		}

    stringBuffer.append(TEXT_711);
    stringBuffer.append(isTrimAll);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_718);
    
	}
	///////////////
	List<IMetadataColumn> listColumns = metadata.getListColumns();
	int sizeListColumns = listColumns.size();
	for (int valueN=0; valueN<sizeListColumns; valueN++) {	
		if(valueN%100==0){

    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    
	    
	    }
				
        }
		if(useExistingDynamic && !advanced){

    stringBuffer.append(TEXT_724);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(metadata.getDynamicColumn().getLabel());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_727);
    		}
    }

    stringBuffer.append(TEXT_728);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_729);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_730);
    }
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_733);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_734);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_736);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_737);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_739);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_741);
    
                }
                
    stringBuffer.append(TEXT_742);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_746);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_747);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_749);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_750);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_752);
    }
        } 
        
    stringBuffer.append(TEXT_753);
            			
        		}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_754);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_757);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_759);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_760);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_761);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_762);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_765);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_766);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_767);
     } 
    stringBuffer.append(TEXT_768);
    
		}
        	}
		}
	}
}

    stringBuffer.append(TEXT_769);
    return stringBuffer.toString();
  }
}
