package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import org.talend.core.model.process.IProcess;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tString log4jFileOutputDelimitedParamters_";
  protected final String TEXT_3 = " = \"\";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_4 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_5 = " + \"FILENAME = \" + ";
  protected final String TEXT_6 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_7 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_8 = " + \"CSV_OPTION = \" + ";
  protected final String TEXT_9 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_10 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_11 = " + \"FIELDSEPARATOR = \" + ";
  protected final String TEXT_12 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_13 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_14 = " + \"INCLUDE_HEADER = \" + ";
  protected final String TEXT_15 = " + \" | \";";
  protected final String TEXT_16 = NL + "\t\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_17 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_18 = " + \"COMPRESS = \" + ";
  protected final String TEXT_19 = " + \" | \";";
  protected final String TEXT_20 = NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_21 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_22 = " + \"APPEND = \" + ";
  protected final String TEXT_23 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_24 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_25 = " + \"CREATE_DIRECTORY_IF_NOT_EXISTS = \" + ";
  protected final String TEXT_26 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_27 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_28 = " + \"SPLIT_INTO_SEVERAL_FILES = \" + ";
  protected final String TEXT_29 = " + \" | \";" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_30 = " = log4jFileOutputDelimitedParamters_";
  protected final String TEXT_31 = " + \"OUTPUT_IN_ROW_MODE = \" + ";
  protected final String TEXT_32 = " + \" | \";" + NL + "\t\t" + NL + "\t\tlog4jFileOutputDelimitedParamters_";
  protected final String TEXT_33 = " = \"";
  protected final String TEXT_34 = " - Parameters:\" + log4jFileOutputDelimitedParamters_";
  protected final String TEXT_35 = ";" + NL + "\t\tlog.debug(log4jFileOutputDelimitedParamters_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\tStringBuffer log4jSb_";
  protected final String TEXT_38 = " = new StringBuffer();" + NL + "\tlog.info(\"";
  protected final String TEXT_39 = " - Start to work.\");";
  protected final String TEXT_40 = NL + "String fileName_";
  protected final String TEXT_41 = " = \"\";";
  protected final String TEXT_42 = NL + "        int dynamic_column_count_";
  protected final String TEXT_43 = " = 1;";
  protected final String TEXT_44 = NL + "\tclass FileOutputDelimitedUtil_";
  protected final String TEXT_45 = "{";
  protected final String TEXT_46 = NL + "\t\tpublic void putHeaderValue_";
  protected final String TEXT_47 = "(java.io.Writer out";
  protected final String TEXT_48 = ",final String OUT_DELIM_";
  protected final String TEXT_49 = ",final ";
  protected final String TEXT_50 = "Struct ";
  protected final String TEXT_51 = ")throws java.lang.Exception{";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_53 = ".write(\"";
  protected final String TEXT_54 = "\");";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ", out";
  protected final String TEXT_58 = ", OUT_DELIM_";
  protected final String TEXT_59 = "); ";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_61 = ".write(OUT_DELIM_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\t}";
  protected final String TEXT_64 = NL + "\t\t}";
  protected final String TEXT_65 = NL + "\t\tpublic void putValue_";
  protected final String TEXT_66 = "(final ";
  protected final String TEXT_67 = "Struct ";
  protected final String TEXT_68 = ",StringBuilder sb_";
  protected final String TEXT_69 = ",final String OUT_DELIM_";
  protected final String TEXT_70 = ")throws java.lang.Exception {";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " != null) {";
  protected final String TEXT_74 = NL + "    \t\t\t\t    \t\troutines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = ", sb_";
  protected final String TEXT_77 = ", OUT_DELIM_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_80 = ".append(";
  protected final String TEXT_81 = NL + "    \t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ", ";
  protected final String TEXT_84 = ")";
  protected final String TEXT_85 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_86 = ".toPlainString(), ";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ")\t\t\t\t\t";
  protected final String TEXT_89 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ")).toPlainString(), ";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ")\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_95 = ".toPlainString()";
  protected final String TEXT_96 = NL + "    \t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_97 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = ")).toString()";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = NL + "    \t\t\t\t\t\t\t);";
  protected final String TEXT_103 = NL + "    \t\t\t\t\t    } ";
  protected final String TEXT_104 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_105 = ".append(OUT_DELIM_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t\t}";
  protected final String TEXT_109 = NL + "\t\tpublic void putHeaderValue_";
  protected final String TEXT_110 = "(String[] headColu";
  protected final String TEXT_111 = ",final ";
  protected final String TEXT_112 = "Struct ";
  protected final String TEXT_113 = ",int dynamic_column_count_";
  protected final String TEXT_114 = " ";
  protected final String TEXT_115 = ")throws java.lang.Exception{";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_117 = "[";
  protected final String TEXT_118 = "+dynamic_column_count_";
  protected final String TEXT_119 = "]=\"";
  protected final String TEXT_120 = "\";";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_122 = "[";
  protected final String TEXT_123 = "]=\"";
  protected final String TEXT_124 = "\";";
  protected final String TEXT_125 = NL + "                                dynamic_column_count_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\tfor(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_129 = ";mi++){" + NL + "        \t    \t\t     \t\t\theadColu";
  protected final String TEXT_130 = "[";
  protected final String TEXT_131 = "+mi]=";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     \t\t}";
  protected final String TEXT_134 = NL + "\t\t}";
  protected final String TEXT_135 = NL + "\t\t}";
  protected final String TEXT_136 = NL + "\t\tpublic void putValue_";
  protected final String TEXT_137 = "(final ";
  protected final String TEXT_138 = "Struct ";
  protected final String TEXT_139 = ",String[] row";
  protected final String TEXT_140 = ",int dynamic_column_count_";
  protected final String TEXT_141 = " ";
  protected final String TEXT_142 = "){";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " != null) {" + NL + "\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ".getColumnCount();" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = ", row";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");" + NL + "                            }";
  protected final String TEXT_153 = " " + NL + "                \t\t    row";
  protected final String TEXT_154 = "[";
  protected final String TEXT_155 = "+dynamic_column_count_";
  protected final String TEXT_156 = "]=";
  protected final String TEXT_157 = NL + "                \t\t\trow";
  protected final String TEXT_158 = "[";
  protected final String TEXT_159 = "]=";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ";";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = "\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ")).toString();";
  protected final String TEXT_170 = NL + "        \t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_171 = ".toPlainString(), ";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ")).toPlainString(), ";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = ");\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".toPlainString();";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\t}";
  protected final String TEXT_186 = NL + "\t}" + NL + "\tFileOutputDelimitedUtil_";
  protected final String TEXT_187 = " fileOutputDelimitedUtil_";
  protected final String TEXT_188 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_189 = "();";
  protected final String TEXT_190 = NL + "fileName_";
  protected final String TEXT_191 = " = (new java.io.File(";
  protected final String TEXT_192 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "String fullName_";
  protected final String TEXT_193 = " = null;" + NL + "String extension_";
  protected final String TEXT_194 = " = null;" + NL + "String directory_";
  protected final String TEXT_195 = " = null;" + NL + "if((fileName_";
  protected final String TEXT_196 = ".indexOf(\"/\") != -1)) {" + NL + "    if(fileName_";
  protected final String TEXT_197 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_198 = ".lastIndexOf(\"/\")) {" + NL + "        fullName_";
  protected final String TEXT_199 = " = fileName_";
  protected final String TEXT_200 = ";" + NL + "        extension_";
  protected final String TEXT_201 = " = \"\";" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_202 = " = fileName_";
  protected final String TEXT_203 = ".substring(0, fileName_";
  protected final String TEXT_204 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_205 = " = fileName_";
  protected final String TEXT_206 = ".substring(fileName_";
  protected final String TEXT_207 = ".lastIndexOf(\".\"));" + NL + "    }           " + NL + "    directory_";
  protected final String TEXT_208 = " = fileName_";
  protected final String TEXT_209 = ".substring(0, fileName_";
  protected final String TEXT_210 = ".lastIndexOf(\"/\"));            " + NL + "} else {" + NL + "    if(fileName_";
  protected final String TEXT_211 = ".lastIndexOf(\".\") != -1) {" + NL + "        fullName_";
  protected final String TEXT_212 = " = fileName_";
  protected final String TEXT_213 = ".substring(0, fileName_";
  protected final String TEXT_214 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_215 = " = fileName_";
  protected final String TEXT_216 = ".substring(fileName_";
  protected final String TEXT_217 = ".lastIndexOf(\".\"));" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_218 = " = fileName_";
  protected final String TEXT_219 = ";" + NL + "        extension_";
  protected final String TEXT_220 = " = \"\";" + NL + "    }" + NL + "    directory_";
  protected final String TEXT_221 = " = \"\";" + NL + "}" + NL + "boolean isFileGenerated_";
  protected final String TEXT_222 = " = true;" + NL + "java.io.File file";
  protected final String TEXT_223 = " = new java.io.File(fileName_";
  protected final String TEXT_224 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_225 = "_FILE_NAME\",fileName_";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "if(file";
  protected final String TEXT_228 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_229 = " = false;" + NL + "}";
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_232 = "= true;";
  protected final String TEXT_233 = NL + "    \t\tint nb_line_";
  protected final String TEXT_234 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_235 = " = ";
  protected final String TEXT_236 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_237 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_238 = " = 0;\t\t" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = ";" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_241 = " = ";
  protected final String TEXT_242 = ";" + NL;
  protected final String TEXT_243 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_244 = " != null && directory_";
  protected final String TEXT_245 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_246 = " = new java.io.File(directory_";
  protected final String TEXT_247 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_248 = ".exists()) {" + NL + "                    \t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_250 = " - Creating directory '\" + dir_";
  protected final String TEXT_251 = ".getCanonicalPath() +\"'.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "                        dir_";
  protected final String TEXT_253 = ".mkdirs();" + NL + "                    \t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_255 = " - The directoy '\"+ dir_";
  protected final String TEXT_256 = ".getCanonicalPath() + \"' has been created successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_257 = NL + "                    }" + NL + "                }";
  protected final String TEXT_258 = NL + "    ";
  protected final String TEXT_259 = NL + "\t\t\t\tfile";
  protected final String TEXT_260 = " = new java.io.File(fileName_";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_262 = " = fullName_";
  protected final String TEXT_263 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_264 = " = new java.io.File(zipName_";
  protected final String TEXT_265 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_266 = "= null;    \t\t    " + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_267 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_268 = "= new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_269 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_270 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_271 = ".getName()));" + NL + "    \t\t    \tout";
  protected final String TEXT_272 = " = new ";
  protected final String TEXT_273 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_274 = ",";
  protected final String TEXT_275 = "));";
  protected final String TEXT_276 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_277 = " = null;" + NL + "            \ttry {" + NL + "            \t\tout";
  protected final String TEXT_278 = " = new ";
  protected final String TEXT_279 = "(new java.io.OutputStreamWriter(" + NL + "            \t\tnew java.io.FileOutputStream(fileName_";
  protected final String TEXT_280 = ", ";
  protected final String TEXT_281 = "),";
  protected final String TEXT_282 = "));";
  protected final String TEXT_283 = NL + "                java.io.Writer out";
  protected final String TEXT_284 = " = null;" + NL + "                file";
  protected final String TEXT_285 = " = new java.io.File(fullName_";
  protected final String TEXT_286 = " + splitedFileNo_";
  protected final String TEXT_287 = " + extension_";
  protected final String TEXT_288 = ");" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_289 = " = new ";
  protected final String TEXT_290 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_291 = " + splitedFileNo_";
  protected final String TEXT_292 = " + extension_";
  protected final String TEXT_293 = ", ";
  protected final String TEXT_294 = "),";
  protected final String TEXT_295 = "));";
  protected final String TEXT_296 = NL + "\t\t\t\t";
  protected final String TEXT_297 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_299 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_300 = NL + "    \t\t    if(file_";
  protected final String TEXT_301 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t    ";
  protected final String TEXT_302 = NL + "    \t\t    if(file";
  protected final String TEXT_303 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t        ";
  protected final String TEXT_304 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_305 = ".putHeaderValue_";
  protected final String TEXT_306 = "(out";
  protected final String TEXT_307 = ",OUT_DELIM_";
  protected final String TEXT_308 = ");";
  protected final String TEXT_309 = NL + "\t    \t\t            out";
  protected final String TEXT_310 = ".write(\"";
  protected final String TEXT_311 = "\");" + NL + "\t    \t\t            ";
  protected final String TEXT_312 = NL + "\t    \t\t                out";
  protected final String TEXT_313 = ".write(OUT_DELIM_";
  protected final String TEXT_314 = ");" + NL + "\t    \t\t                ";
  protected final String TEXT_315 = NL + "    \t\t        out";
  protected final String TEXT_316 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_317 = ");" + NL + "    \t\t        out";
  protected final String TEXT_318 = ".flush();" + NL + "    \t\t    }" + NL + "\t\t        ";
  protected final String TEXT_319 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_320 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_321 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_322 = NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_323 = "= null;    \t\t    " + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_324 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_325 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_326 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_327 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_328 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \twriter_";
  protected final String TEXT_329 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_330 = ",";
  protected final String TEXT_331 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_332 = " = new ";
  protected final String TEXT_333 = "(writer_";
  protected final String TEXT_334 = ");";
  protected final String TEXT_335 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_336 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_337 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \twriter_";
  protected final String TEXT_338 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_339 = ",";
  protected final String TEXT_340 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_341 = " = new ";
  protected final String TEXT_342 = "(writer_";
  protected final String TEXT_343 = ");";
  protected final String TEXT_344 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_345 = ".putHeaderValue_";
  protected final String TEXT_346 = "(out";
  protected final String TEXT_347 = ",OUT_DELIM_";
  protected final String TEXT_348 = ");";
  protected final String TEXT_349 = NL + "    \t\t            out";
  protected final String TEXT_350 = ".write(\"";
  protected final String TEXT_351 = "\");" + NL + "    \t\t            ";
  protected final String TEXT_352 = NL + "    \t\t                out";
  protected final String TEXT_353 = ".write(OUT_DELIM_";
  protected final String TEXT_354 = ");" + NL + "    \t\t                ";
  protected final String TEXT_355 = NL + "    \t\t        out";
  protected final String TEXT_356 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_357 = ");";
  protected final String TEXT_358 = NL;
  protected final String TEXT_359 = NL;
  protected final String TEXT_360 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_361 = "= true;" + NL + "            String[] headColu";
  protected final String TEXT_362 = " = null;";
  protected final String TEXT_363 = NL + "            String[] headColu";
  protected final String TEXT_364 = "=new String[";
  protected final String TEXT_365 = "];";
  protected final String TEXT_366 = "   \t    \t\t" + NL + "            class CSVBasicSet_";
  protected final String TEXT_367 = "{          \t" + NL + "            \tprivate char field_Delim;            \t" + NL + "            \tprivate char row_Delim;            \t" + NL + "            \tprivate char escape;            \t" + NL + "            \tprivate char textEnclosure;" + NL + "            \tprivate boolean useCRLFRecordDelimiter;" + NL + "            \t" + NL + "            \tpublic boolean isUseCRLFRecordDelimiter() {" + NL + "            \t\treturn useCRLFRecordDelimiter;" + NL + "            \t}" + NL + "            \t          \t" + NL + "            \tpublic void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_368 = "[] = null;" + NL + "                    " + NL + "            \t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "            \t\tif (fieldSep.length() > 0 ){" + NL + "            \t\t\tfield_Delim_";
  protected final String TEXT_369 = " = fieldSep.toCharArray();" + NL + "            \t\t}else { " + NL + "\t\t            \t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_371 = " - The field separator must be a character.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_372 = NL + "            \t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.field_Delim = field_Delim_";
  protected final String TEXT_373 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getFieldDelim(){" + NL + "            \t\tif(this.field_Delim==0){" + NL + "            \t\t\tsetFieldSeparator(";
  protected final String TEXT_374 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.field_Delim;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic void setRowSeparator(String rowSep){" + NL + "            \t\tif(\"\\r\\n\".equals(rowSep)) {" + NL + "            \t\t\tuseCRLFRecordDelimiter = true;" + NL + "            \t\t\treturn;" + NL + "            \t\t}" + NL + "            \t\tchar row_Delim";
  protected final String TEXT_375 = "[] = null;" + NL + "                 " + NL + "            \t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'.  " + NL + "            \t\tif (rowSep.length() > 0 ){ " + NL + "            \t\t\trow_Delim";
  protected final String TEXT_376 = " = rowSep.toCharArray();" + NL + "            \t\t}else {" + NL + "\t\t            \t";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_378 = " - The row separator must be a character.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_379 = NL + "            \t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.row_Delim = row_Delim";
  protected final String TEXT_380 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getRowDelim(){" + NL + "            \t\tif(this.row_Delim==0){" + NL + "            \t\t\tsetRowSeparator(";
  protected final String TEXT_381 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.row_Delim;" + NL + "            \t}" + NL + "            \t       \t        " + NL + "        \t    public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "        \t        if(strEscape.length() <= 0 ){ " + NL + "\t\t            \t";
  protected final String TEXT_382 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_383 = " - The escape character must be a character.\"); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_384 = NL + "        \t            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        \t        }" + NL + "        \t        " + NL + "                \tif (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "        \t\t\tchar textEnclosure_";
  protected final String TEXT_385 = "[] = null;" + NL + "        \t        " + NL + "        \t        if(strTextEnclosure.length() > 0 ){ " + NL + "              \t\t\ttextEnclosure_";
  protected final String TEXT_386 = " = strTextEnclosure.toCharArray(); " + NL + "        \t\t\t}else { " + NL + "\t\t            \t";
  protected final String TEXT_387 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_388 = " - The text enclosure must be a character.\"); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_389 = NL + "        \t            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        \t        }" + NL + "" + NL + "\t\t\t\t\tthis.textEnclosure = textEnclosure_";
  protected final String TEXT_390 = "[0];" + NL + "" + NL + "        \t\t\tif((\"\\\\\").equals(strEscape)){" + NL + "        \t\t\t\tthis.escape = '\\\\';" + NL + "        \t\t\t}else if(strEscape.equals(strTextEnclosure)){" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\t//the default escape mode is double escape" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t}" + NL + "        \t\t\t" + NL + "        \t\t\t" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getEscapeChar(){" + NL + "            \t\treturn (char)this.escape;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getTextEnclosure(){" + NL + "            \t\treturn this.textEnclosure;" + NL + "            \t}" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_391 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_392 = " = ";
  protected final String TEXT_393 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_394 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_395 = " = 0;" + NL + "            " + NL + "            " + NL + "            CSVBasicSet_";
  protected final String TEXT_396 = " csvSettings_";
  protected final String TEXT_397 = " = new CSVBasicSet_";
  protected final String TEXT_398 = "();" + NL + "            csvSettings_";
  protected final String TEXT_399 = ".setFieldSeparator(";
  protected final String TEXT_400 = ");" + NL + "            csvSettings_";
  protected final String TEXT_401 = ".setRowSeparator(";
  protected final String TEXT_402 = ");" + NL + "\t\t\tcsvSettings_";
  protected final String TEXT_403 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_404 = ",";
  protected final String TEXT_405 = ");";
  protected final String TEXT_406 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_407 = " != null && directory_";
  protected final String TEXT_408 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_409 = " = new java.io.File(directory_";
  protected final String TEXT_410 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_411 = ".exists()) {";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_413 = " - Creating directory '\" +dir_";
  protected final String TEXT_414 = ".getCanonicalPath() +\"'.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_415 = NL + "                        dir_";
  protected final String TEXT_416 = ".mkdirs();" + NL + "                    \t";
  protected final String TEXT_417 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_418 = " - The directory '\" + dir_";
  protected final String TEXT_419 = ".getCanonicalPath() + \"' has been created successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_420 = NL + "                    }" + NL + "                }";
  protected final String TEXT_421 = NL + "\t\t\t\tfile";
  protected final String TEXT_422 = " = new java.io.File(fileName_";
  protected final String TEXT_423 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_424 = " = fullName_";
  protected final String TEXT_425 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_426 = " = new java.io.File(zipName_";
  protected final String TEXT_427 = ");\t\t\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_428 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_429 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_430 = " = null; " + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_431 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_432 = ")));" + NL + "\t    \t\t    zipOut_";
  protected final String TEXT_433 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_434 = ".getName()));" + NL + "\t    \t\t    out";
  protected final String TEXT_435 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_436 = ", ";
  protected final String TEXT_437 = "));" + NL + "\t    \t\t    java.io.StringWriter strWriter";
  protected final String TEXT_438 = " = new java.io.StringWriter();" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_439 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_440 = ");" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_441 = ".setSeparator(csvSettings_";
  protected final String TEXT_442 = ".getFieldDelim());";
  protected final String TEXT_443 = "\t\t" + NL + "                java.io.Writer out";
  protected final String TEXT_444 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_445 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_446 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_447 = ", ";
  protected final String TEXT_448 = "), ";
  protected final String TEXT_449 = "));" + NL + "\t\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_450 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_451 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_452 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_453 = ".setSeparator(csvSettings_";
  protected final String TEXT_454 = ".getFieldDelim());";
  protected final String TEXT_455 = NL + "\t\t\t\tfile";
  protected final String TEXT_456 = " = new java.io.File(fileName_";
  protected final String TEXT_457 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_458 = " = fullName_";
  protected final String TEXT_459 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_460 = " = new java.io.File(zipName_";
  protected final String TEXT_461 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_462 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_463 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_464 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_465 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_466 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_467 = ".getName()));" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_468 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    zipOut_";
  protected final String TEXT_469 = ", ";
  protected final String TEXT_470 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_471 = ".setSeparator(csvSettings_";
  protected final String TEXT_472 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_473 = NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_474 = " = null;" + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_475 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_476 = ", ";
  protected final String TEXT_477 = "), ";
  protected final String TEXT_478 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_479 = ".setSeparator(csvSettings_";
  protected final String TEXT_480 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_481 = NL + "                file";
  protected final String TEXT_482 = " = new java.io.File(fullName_";
  protected final String TEXT_483 = " + splitedFileNo_";
  protected final String TEXT_484 = " + extension_";
  protected final String TEXT_485 = ");" + NL + "                java.io.Writer out";
  protected final String TEXT_486 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_487 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_488 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_489 = " + splitedFileNo_";
  protected final String TEXT_490 = " + extension_";
  protected final String TEXT_491 = ", ";
  protected final String TEXT_492 = "),";
  protected final String TEXT_493 = "));" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_494 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_495 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_496 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_497 = ".setSeparator(csvSettings_";
  protected final String TEXT_498 = ".getFieldDelim());";
  protected final String TEXT_499 = NL + "                file";
  protected final String TEXT_500 = " = new java.io.File(fullName_";
  protected final String TEXT_501 = " + splitedFileNo_";
  protected final String TEXT_502 = " + extension_";
  protected final String TEXT_503 = ");" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_504 = " = null; " + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_505 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_506 = " + splitedFileNo_";
  protected final String TEXT_507 = " + extension_";
  protected final String TEXT_508 = ", ";
  protected final String TEXT_509 = "),";
  protected final String TEXT_510 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_511 = ".setSeparator(csvSettings_";
  protected final String TEXT_512 = ".getFieldDelim());";
  protected final String TEXT_513 = NL + "    \t    \tif(csvSettings_";
  protected final String TEXT_514 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_515 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_516 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_517 = ".getRowDelim());" + NL + "    \t    \t}" + NL + "\t    \t\t";
  protected final String TEXT_518 = NL + "\t    \t\tif(!csvSettings_";
  protected final String TEXT_519 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_520 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_521 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_522 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_523 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_524 = "\t\t   " + NL + "\t\t\t";
  protected final String TEXT_525 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_526 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t        ";
  protected final String TEXT_527 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_528 = NL + "\t        \tif(file_";
  protected final String TEXT_529 = ".length()==0)" + NL + "\t        \t{" + NL + "\t        ";
  protected final String TEXT_530 = NL + "    \t        if(file";
  protected final String TEXT_531 = ".length()==0)  " + NL + "    \t        {" + NL + "    \t            ";
  protected final String TEXT_532 = NL + "                        fileOutputDelimitedUtil_";
  protected final String TEXT_533 = ".putHeaderValue_";
  protected final String TEXT_534 = "(headColu";
  protected final String TEXT_535 = ");";
  protected final String TEXT_536 = "\t      \t" + NL + "        \t\t\t\theadColu";
  protected final String TEXT_537 = "[";
  protected final String TEXT_538 = "]=\"";
  protected final String TEXT_539 = "\";" + NL + "        \t\t\t\t";
  protected final String TEXT_540 = "\t " + NL + "    \t            CsvWriter";
  protected final String TEXT_541 = ".writeNext(headColu";
  protected final String TEXT_542 = ");" + NL + "    \t            CsvWriter";
  protected final String TEXT_543 = ".flush();" + NL + "    \t            \t";
  protected final String TEXT_544 = NL + "    \t            out";
  protected final String TEXT_545 = ".write(strWriter";
  protected final String TEXT_546 = ".getBuffer().toString());" + NL + "    \t            out";
  protected final String TEXT_547 = ".flush();" + NL + "                \tstrWriter";
  protected final String TEXT_548 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_549 = ".getBuffer().length()); \t" + NL + "                \t\t";
  protected final String TEXT_550 = NL + "                }" + NL + "\t        ";
  protected final String TEXT_551 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_552 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_553 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_554 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_555 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_556 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_557 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_558 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_559 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_560 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_561 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \toutWriter_";
  protected final String TEXT_562 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_563 = ", ";
  protected final String TEXT_564 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_565 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_566 = ");" + NL + "    \t\t    \tjava.io.StringWriter strWriter";
  protected final String TEXT_567 = " = new java.io.StringWriter();" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_568 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_569 = ");" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_570 = ".setSeparator(csvSettings_";
  protected final String TEXT_571 = ".getFieldDelim());";
  protected final String TEXT_572 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_573 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_574 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_575 = " = null;  " + NL + "                try {" + NL + "                \toutWriter_";
  protected final String TEXT_576 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_577 = ", ";
  protected final String TEXT_578 = ");" + NL + "                \tout";
  protected final String TEXT_579 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_580 = ");" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_581 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_582 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_583 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_584 = ".setSeparator(csvSettings_";
  protected final String TEXT_585 = ".getFieldDelim());";
  protected final String TEXT_586 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_587 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_588 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_589 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_590 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tzipOut_";
  protected final String TEXT_591 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_592 = "));" + NL + "    \t\t   \t\tzipOut_";
  protected final String TEXT_593 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t   \t\toutWriter_";
  protected final String TEXT_594 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_595 = ", ";
  protected final String TEXT_596 = ");" + NL + "    \t\t   \t\tbufferWriter_";
  protected final String TEXT_597 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_598 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_599 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_600 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_601 = ".setSeparator(csvSettings_";
  protected final String TEXT_602 = ".getFieldDelim());";
  protected final String TEXT_603 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_604 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_605 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_606 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\toutWriter_";
  protected final String TEXT_607 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_608 = ", ";
  protected final String TEXT_609 = ");" + NL + "\t\t\t\t\tbufferWriter_";
  protected final String TEXT_610 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_611 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_612 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_613 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_614 = ".setSeparator(csvSettings_";
  protected final String TEXT_615 = ".getFieldDelim());";
  protected final String TEXT_616 = NL + "       \t    \tif(csvSettings_";
  protected final String TEXT_617 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_618 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_619 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_620 = ".getRowDelim());   \t    \t" + NL + "    \t    \t}" + NL + "    \t    \t";
  protected final String TEXT_621 = NL + "    \t    \tif(!csvSettings_";
  protected final String TEXT_622 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_623 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_624 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_625 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_626 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "    \t    \t";
  protected final String TEXT_627 = NL + "                     fileOutputDelimitedUtil_";
  protected final String TEXT_628 = ".putHeaderValue_";
  protected final String TEXT_629 = "(headColu";
  protected final String TEXT_630 = ");";
  protected final String TEXT_631 = NL + "       \t\t\t\theadColu";
  protected final String TEXT_632 = "[";
  protected final String TEXT_633 = "]=\"";
  protected final String TEXT_634 = "\";" + NL + "       \t\t\t\t";
  protected final String TEXT_635 = NL + "        \t\tCsvWriter";
  protected final String TEXT_636 = ".writeNext(headColu";
  protected final String TEXT_637 = ");\t" + NL + "        \t\t\t";
  protected final String TEXT_638 = NL + "        \t\tout";
  protected final String TEXT_639 = ".write(strWriter";
  protected final String TEXT_640 = ".getBuffer().toString());" + NL + "                strWriter";
  protected final String TEXT_641 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_642 = ".getBuffer().length());" + NL + "        \t\t\t";
  protected final String TEXT_643 = NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_644 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_645 = ".getEscapeChar());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_646 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_647 = ".getTextEnclosure());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_648 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_649 = NL + NL;
  protected final String TEXT_650 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
IProcess process = node.getProcess();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

if(isLog4jEnabled) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CSV_OPTION__"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
    stringBuffer.append(TEXT_15);
    
		if(!"true".equals(ElementParameterParser.getValue(node, "__APPEND__"))) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__COMPRESS__"));
    stringBuffer.append(TEXT_19);
    
		}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__APPEND__"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CREATE__"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT__"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_MODE__"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}
	

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
	IMetadataTable metadata = metadatas.get(0);
	boolean hasDynamic = metadata.isDynamicSchema();
	if(hasDynamic && ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
	}
	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
	for (IConnection conn : conns) {//B1
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
	    	List<IMetadataColumn> columns = metadata.getListColumns();
	       	int sizeColumns = columns.size();
			if(sizeColumns> schemaOptNum){//D1

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
				if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
					if(isIncludeHeader){//F1
						for (int i = 0; i < sizeColumns; i++) {//H1
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    if(hasDynamic){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_51);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
							}else{

    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
							}
							if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_63);
    
							}
						}//H1
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_64);
    
						}
					}//F1
        			for (int i = 0; i < sizeColumns; i++) {//F2
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
						}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
    				    }else{

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_84);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
								if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_88);
     
        						} else { 

    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_93);
     
        						}
							} else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_95);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    
    			        	} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    				
    			        	}

    stringBuffer.append(TEXT_102);
    
    					}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_103);
    
    			        } 
    			        if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
    			        }
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_107);
    
						}
    		        }//F2
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_108);
    
					}
				}else{
					//E2 use CSV Option
					if(isIncludeHeader){//F3
						for (int i = 0; i < sizeColumns; i++) {//H3
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {
							    if(hasDynamic){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_120);
    
							    }else{

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    
							    }
							}else{

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_133);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_134);
    
							}
						}//H3
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_135);
    
						}
					}//F3
        			for (int i = 0; i < sizeColumns; i++) {//F4
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    
						}
    					if(("id_Dynamic").equals(column.getTalendType())) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_152);
    
                		}else{
                		    if(hasDynamic){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    
                		    }else{

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                		    }
                			if(javaType == JavaTypesManager.STRING ){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    
                			}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_163);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_166);
    
                			}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_167);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    
                			} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        						if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_171);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_173);
      	
								} else { 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_178);
    		
								}
        					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_180);
    
                			} else{

    stringBuffer.append(TEXT_181);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    
                			}
                		}
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_184);
    
						}
    		        }//F4
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_185);
    
					}
				}

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
			}//D1
		}//C1
	}//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
	if(isAppend){

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    
	}
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_230);
    
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
           
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    	}
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_242);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
			
    			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    
    			}

    stringBuffer.append(TEXT_258);
     	
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(!split){
    				if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_275);
    
    				}else{

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_282);
     
					}
    			} else {

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_295);
    
    			}
    			
    			if(isIncludeHeader && !hasDynamic){
    		    
    stringBuffer.append(TEXT_296);
    
					if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_297);
    
					}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_298);
     
		        	}
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_299);
     
					}
					if(!split && compress && !isAppend){
		        
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
    		    	}else{
    		    	
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
    		        }		
	    		        List<IMetadataColumn> columns = metadata.getListColumns();
	    		        int sizeColumns = columns.size();
	    		        for (int i = 0; i < sizeColumns; i++) {
	    		            IMetadataColumn column = columns.get(i);
                            if(sizeColumns > schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    
                            	}
                            }else{//AA
	    		            
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_311);
    
	    		            if(i != sizeColumns - 1) {
	    		                
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
	    		            }
	    		            }//AA
	    		        }
    		        
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
     
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_319);
    
		        	}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_320);
    
		        	}
		        	if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_321);
    
					}
		        
    
    			}

    		}else{
    		//***********************the following is the part of output Stream**************************************
    		
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(compress){// compress the dest output stream
 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    
    			}else{

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    
				}
    			if(isIncludeHeader && !hasDynamic){
    		        List<IMetadataColumn> columns = metadata.getListColumns();
    		        int sizeColumns = columns.size();
    		        for (int i = 0; i < sizeColumns; i++) {
    		            IMetadataColumn column = columns.get(i);
  						if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    
                            }
                        }else{//BB
    		            
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_351);
    
    		            if(i != sizeColumns - 1) {
    		                
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    
    		            }
    		            }//BB
    		        }
    		        
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    
    		    }
    		}// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_358);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_359);
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                       
        	List<IMetadataColumn> columns = metadata.getListColumns();
	    	int sizeColumns = columns.size(); 
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    		String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
    		boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));
    		
        	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        	
 			if(escapeChar1.equals("\"\"\"")){
 				escapeChar1 = "\"\\\"\"";
 			}
        	
        	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
 			if(textEnclosure1.equals("\"\"\"")){
 				textEnclosure1 = "\"\\\"\"";
 			}
 			
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
            	}else{
            
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_365);
    
            	}
    	    
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    }
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    }
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_381);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    }
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    }
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_405);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
            	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    }
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    }
    stringBuffer.append(TEXT_420);
    
            	}
    	
	            if(!split){
	            	if(isInRowMode){
    					if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    
    					}else{

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    
                		}
                	}else{
                		if(compress && !isAppend){// compress the dest file
				
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    
						}else{
				
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    
						}
                	}
	            }else{
	            	if(isInRowMode){
                
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    
                	}else{
                
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
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
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    
                	}
	            }
	            
	            if(!useOSLineSeparator) {
	    		
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    
	    		} else {
	    		
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    
	    		}
	    		
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
    	        
    stringBuffer.append(TEXT_524);
    
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_525);
    
				}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_526);
     
	        	}
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_527);
     
				}
				if(!split && compress && !isAppend){
	        
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
	        	}else{
	        
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    
    	        }			
	         			for(int i = 0 ; i < sizeColumns ; i++)
	        			{
	        				IMetadataColumn column = columns.get(i);
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    
                            	}
                           	}else{//CC
        				
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_539);
    
        					}//CC
         				}
    	            
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    if(isInRowMode){
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    }
    stringBuffer.append(TEXT_550);
     
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_551);
    
	        	}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_552);
    
	        	}
	        	if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_553);
    
				}
	        
    		  
	    	    }
	    	}else{
    		//***********************the following is the part of output Stream**************************************
	            if(isInRowMode){
	            	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    
	            	}else{

    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    
					}
                }else{
                	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    
                	}else{

    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    
					}
                }
                
                if(!useOSLineSeparator) {

    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    
    	    	} else {
    	    	
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    
    	    	}
    	    	
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
	    	        for(int i = 0; i < sizeColumns; i++)
	        		{
	        			IMetadataColumn column = columns.get(i);
						if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    
                            }
                       	}else{//DD
        			
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_634);
    
       					}//DD
	        		}
    	        
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    if(isInRowMode){
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    }
	    	    }
	    	}//*****************************csv mode under output stream end********************************************************
	    	
	    	if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""

    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    
			}
	    }
    }
    
    stringBuffer.append(TEXT_649);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_650);
    return stringBuffer.toString();
  }
}
