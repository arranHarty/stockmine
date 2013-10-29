package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Has finished.\");";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_12 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_13 = " + \" \" + log4jSb_";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_15 = ".delete(0,log4jSb_";
  protected final String TEXT_16 = ".length());";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Writing the record \" + nb_line_";
  protected final String TEXT_19 = " + \" \" + log4jSb_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Written records count: \" + nb_line_";
  protected final String TEXT_25 = " + \" .\");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\t\tint nb_line_";
  protected final String TEXT_28 = " = 0;" + NL;
  protected final String TEXT_29 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_30 = "=";
  protected final String TEXT_31 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_32 = " = new java.io.File(fileName_";
  protected final String TEXT_33 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_34 = " = true;";
  protected final String TEXT_35 = NL + "\t\tif(file_";
  protected final String TEXT_36 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_37 = " = false;" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_39 = " = file_";
  protected final String TEXT_40 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_41 = " != null && !parentFile_";
  protected final String TEXT_42 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_43 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_45 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "             parentFile_";
  protected final String TEXT_47 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_48 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_49 = " - Create directory '\"+parentFile_";
  protected final String TEXT_50 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "          }";
  protected final String TEXT_52 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_53 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_54 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_55 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_56 = ".setEncoding(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_59 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_60 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = "  " + NL + "        if (file_";
  protected final String TEXT_63 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_64 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_65 = ",workbookSettings_";
  protected final String TEXT_66 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_67 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_68 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_69 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_70 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_71 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_72 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_73 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_74 = ");        " + NL + "        }     ";
  protected final String TEXT_75 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_76 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_77 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = "       " + NL + "" + NL + "        writableSheet_";
  protected final String TEXT_80 = " = writeableWorkbook_";
  protected final String TEXT_81 = ".getSheet(";
  protected final String TEXT_82 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_83 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_84 = " = writeableWorkbook_";
  protected final String TEXT_85 = ".createSheet(";
  protected final String TEXT_86 = ", writeableWorkbook_";
  protected final String TEXT_87 = ".getNumberOfSheets());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_88 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_89 = " = writeableWorkbook_";
  protected final String TEXT_90 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_91 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_92 = "[i].equals(";
  protected final String TEXT_93 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_94 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_95 = " = writeableWorkbook_";
  protected final String TEXT_96 = ".createSheet(";
  protected final String TEXT_97 = ", writeableWorkbook_";
  protected final String TEXT_98 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_99 = NL + NL + "        //modif start";
  protected final String TEXT_100 = NL + "\t\tint startRowNum_";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "        int startRowNum_";
  protected final String TEXT_104 = " = writableSheet_";
  protected final String TEXT_105 = ".getRows();";
  protected final String TEXT_106 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_107 = " = new int[";
  protected final String TEXT_108 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_109 = "=0;i_";
  protected final String TEXT_110 = "<";
  protected final String TEXT_111 = ";i_";
  protected final String TEXT_112 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_113 = "=writableSheet_";
  protected final String TEXT_114 = ".getColumnView(i_";
  protected final String TEXT_115 = "+";
  protected final String TEXT_116 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_117 = "[i_";
  protected final String TEXT_118 = "]=fitCellViewSize_";
  protected final String TEXT_119 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_120 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_121 = "[i_";
  protected final String TEXT_122 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_123 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_124 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_125 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_126 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_127 = "); ";
  protected final String TEXT_128 = NL;
  protected final String TEXT_129 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_132 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_133 = "));";
  protected final String TEXT_134 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_135 = "_";
  protected final String TEXT_136 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_137 = "));";
  protected final String TEXT_138 = NL + "\t\tif(true){" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_140 = " - Date pattern must be set for column ";
  protected final String TEXT_141 = " in the schema of component ";
  protected final String TEXT_142 = "!\");" + NL + "\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_144 = " in the schema of component ";
  protected final String TEXT_145 = "!\");" + NL + "\t\t}";
  protected final String TEXT_146 = "\t\t" + NL;
  protected final String TEXT_147 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_148 = "{";
  protected final String TEXT_149 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_150 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_151 = ",final int rowNum_";
  protected final String TEXT_152 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_153 = ",final int[] fitWidth_";
  protected final String TEXT_154 = ") throws java.lang.Exception {";
  protected final String TEXT_155 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_156 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_157 = " + ";
  protected final String TEXT_158 = ", rowNum_";
  protected final String TEXT_159 = ", \"";
  protected final String TEXT_160 = "\"";
  protected final String TEXT_161 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_162 = NL + "\t\t\t));\t\t";
  protected final String TEXT_163 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_164 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_165 = ", rowNum_";
  protected final String TEXT_166 = ", \"";
  protected final String TEXT_167 = "\"";
  protected final String TEXT_168 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_169 = NL + "\t\t\t));";
  protected final String TEXT_170 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_171 = "[";
  protected final String TEXT_172 = "]=fitWidth_";
  protected final String TEXT_173 = "[";
  protected final String TEXT_174 = "]>";
  protected final String TEXT_175 = "?fitWidth_";
  protected final String TEXT_176 = "[";
  protected final String TEXT_177 = "]:";
  protected final String TEXT_178 = ";";
  protected final String TEXT_179 = NL + "\t\t\t}";
  protected final String TEXT_180 = NL + "\t\t\t}";
  protected final String TEXT_181 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_182 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_183 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_184 = ") throws java.lang.Exception {";
  protected final String TEXT_185 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_186 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_187 = ".setColumnView(";
  protected final String TEXT_188 = " + ";
  protected final String TEXT_189 = ", fitWidth_";
  protected final String TEXT_190 = "[";
  protected final String TEXT_191 = "]);" + NL + "        \t\t";
  protected final String TEXT_192 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_193 = ".setColumnView(";
  protected final String TEXT_194 = ", fitWidth_";
  protected final String TEXT_195 = "[";
  protected final String TEXT_196 = "]);" + NL + "        \t\t";
  protected final String TEXT_197 = NL + "    \t\t\t//modif end";
  protected final String TEXT_198 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_199 = ".setColumnView(";
  protected final String TEXT_200 = ", fitWidth_";
  protected final String TEXT_201 = "[";
  protected final String TEXT_202 = "]);";
  protected final String TEXT_203 = NL + "\t\t\t}";
  protected final String TEXT_204 = NL + "\t\t\t}";
  protected final String TEXT_205 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_206 = "(final ";
  protected final String TEXT_207 = "Struct ";
  protected final String TEXT_208 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_209 = ",final int startRowNum_";
  protected final String TEXT_210 = ",final int nb_line_";
  protected final String TEXT_211 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_212 = ",int[] fitWidth_";
  protected final String TEXT_213 = ") throws java.lang.Exception {";
  protected final String TEXT_214 = NL + "\t\t\t";
  protected final String TEXT_215 = "\t\t\t\t";
  protected final String TEXT_216 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_220 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_223 = "_";
  protected final String TEXT_224 = " = writableSheet_";
  protected final String TEXT_225 = ".getWritableCell(";
  protected final String TEXT_226 = " + ";
  protected final String TEXT_227 = ", startRowNum_";
  protected final String TEXT_228 = " + nb_line_";
  protected final String TEXT_229 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_231 = "_";
  protected final String TEXT_232 = " = new jxl.write.";
  protected final String TEXT_233 = "(";
  protected final String TEXT_234 = " + ";
  protected final String TEXT_235 = ", startRowNum_";
  protected final String TEXT_236 = " + nb_line_";
  protected final String TEXT_237 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_239 = "_";
  protected final String TEXT_240 = " = new jxl.write.";
  protected final String TEXT_241 = "(";
  protected final String TEXT_242 = ", startRowNum_";
  protected final String TEXT_243 = " + nb_line_";
  protected final String TEXT_244 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_245 = NL + "//modif end";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = ", cell_format_";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = ")";
  protected final String TEXT_253 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = ".toString()";
  protected final String TEXT_256 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = ")).toString()";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_261 = "), ";
  protected final String TEXT_262 = ", ";
  protected final String TEXT_263 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = "), ";
  protected final String TEXT_267 = ", ";
  protected final String TEXT_268 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_269 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_270 = ").doubleValue()";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_274 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_278 = "_";
  protected final String TEXT_279 = ".setCellFormat( existingCell_";
  protected final String TEXT_280 = "_";
  protected final String TEXT_281 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_282 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_283 = ".addCell(cell_";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = ");";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_287 = "_";
  protected final String TEXT_288 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_289 = "_";
  protected final String TEXT_290 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_291 = "_";
  protected final String TEXT_292 = "=currentWith_";
  protected final String TEXT_293 = "_";
  protected final String TEXT_294 = ">10?10:currentWith_";
  protected final String TEXT_295 = "_";
  protected final String TEXT_296 = ";";
  protected final String TEXT_297 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_298 = "_";
  protected final String TEXT_299 = " = cell_";
  protected final String TEXT_300 = "_";
  protected final String TEXT_301 = ".getContents().trim().length();";
  protected final String TEXT_302 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_303 = "[";
  protected final String TEXT_304 = "]=fitWidth_";
  protected final String TEXT_305 = "[";
  protected final String TEXT_306 = "]>currentWith_";
  protected final String TEXT_307 = "_";
  protected final String TEXT_308 = "?fitWidth_";
  protected final String TEXT_309 = "[";
  protected final String TEXT_310 = "]:currentWith_";
  protected final String TEXT_311 = "_";
  protected final String TEXT_312 = "+2;";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_314 = "_";
  protected final String TEXT_315 = "=";
  protected final String TEXT_316 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_317 = "[";
  protected final String TEXT_318 = "]=fitWidth_";
  protected final String TEXT_319 = "[";
  protected final String TEXT_320 = "]>currentWith_";
  protected final String TEXT_321 = "_";
  protected final String TEXT_322 = "?fitWidth_";
  protected final String TEXT_323 = "[";
  protected final String TEXT_324 = "]:currentWith_";
  protected final String TEXT_325 = "_";
  protected final String TEXT_326 = "+2;";
  protected final String TEXT_327 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t}";
  protected final String TEXT_329 = NL + "\t\t\t}";
  protected final String TEXT_330 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_331 = " fileOutputExcelUtil_";
  protected final String TEXT_332 = "=new FileOutputExcelUtil_";
  protected final String TEXT_333 = "();";
  protected final String TEXT_334 = NL;
  protected final String TEXT_335 = NL + "\tboolean needDel_";
  protected final String TEXT_336 = " = false;";
  protected final String TEXT_337 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_338 = " == ";
  protected final String TEXT_339 = "){";
  protected final String TEXT_340 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_341 = " == 0){";
  protected final String TEXT_342 = NL + "\t//modif end";
  protected final String TEXT_343 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_344 = ".putHeaderValue_";
  protected final String TEXT_345 = "(writableSheet_";
  protected final String TEXT_346 = ",startRowNum_";
  protected final String TEXT_347 = ",";
  protected final String TEXT_348 = "format_";
  protected final String TEXT_349 = "null";
  protected final String TEXT_350 = ",fitWidth_";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_353 = ".putHeaderValue_";
  protected final String TEXT_354 = "(writableSheet_";
  protected final String TEXT_355 = ",nb_line_";
  protected final String TEXT_356 = ",";
  protected final String TEXT_357 = "format_";
  protected final String TEXT_358 = "null";
  protected final String TEXT_359 = ",fitWidth_";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + "\t\t//modif start";
  protected final String TEXT_362 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_363 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_364 = " + ";
  protected final String TEXT_365 = ", startRowNum_";
  protected final String TEXT_366 = ", \"";
  protected final String TEXT_367 = "\"";
  protected final String TEXT_368 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_369 = NL + "\t\t\t));\t\t";
  protected final String TEXT_370 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_371 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_372 = ", nb_line_";
  protected final String TEXT_373 = ", \"";
  protected final String TEXT_374 = "\"";
  protected final String TEXT_375 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_376 = NL + "\t\t\t));";
  protected final String TEXT_377 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_378 = "[";
  protected final String TEXT_379 = "]=fitWidth_";
  protected final String TEXT_380 = "[";
  protected final String TEXT_381 = "]>";
  protected final String TEXT_382 = "?fitWidth_";
  protected final String TEXT_383 = "[";
  protected final String TEXT_384 = "]:";
  protected final String TEXT_385 = ";";
  protected final String TEXT_386 = NL + "\t\tneedDel_";
  protected final String TEXT_387 = " = true;";
  protected final String TEXT_388 = NL + "\t\tnb_line_";
  protected final String TEXT_389 = "++;" + NL + "\t}";
  protected final String TEXT_390 = NL + "\t\t";
  protected final String TEXT_391 = NL + "\t\tString fileName_";
  protected final String TEXT_392 = "=";
  protected final String TEXT_393 = ";";
  protected final String TEXT_394 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_395 = " = new java.io.File(fileName_";
  protected final String TEXT_396 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_397 = " = true;";
  protected final String TEXT_398 = NL + "\t\tif(file_";
  protected final String TEXT_399 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_400 = " = false;" + NL + "\t\t}";
  protected final String TEXT_401 = NL + "\t\tint nb_line_";
  protected final String TEXT_402 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_403 = " = new org.talend.ExcelTool();";
  protected final String TEXT_404 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_405 = "=";
  protected final String TEXT_406 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_407 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_408 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_409 = NL + "\t\txlsxTool_";
  protected final String TEXT_410 = ".setSheet(";
  protected final String TEXT_411 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_412 = ".setAppend(";
  protected final String TEXT_413 = ",";
  protected final String TEXT_414 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_415 = ".setXY(";
  protected final String TEXT_416 = ",";
  protected final String TEXT_417 = ",";
  protected final String TEXT_418 = ",";
  protected final String TEXT_419 = ");" + NL + "\t\t";
  protected final String TEXT_420 = NL + "\t\txlsxTool_";
  protected final String TEXT_421 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_422 = ");" + NL + "\t\t";
  protected final String TEXT_423 = NL + "\t\txlsxTool_";
  protected final String TEXT_424 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_425 = NL + "\t\txlsxTool_";
  protected final String TEXT_426 = ".setFont(\"";
  protected final String TEXT_427 = "\");" + NL + "\t\t";
  protected final String TEXT_428 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_429 = "{";
  protected final String TEXT_430 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_431 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_432 = ") throws java.lang.Exception {";
  protected final String TEXT_433 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_434 = ".addCellValue(\"";
  protected final String TEXT_435 = "\");";
  protected final String TEXT_436 = NL + "\t\t\t\t}";
  protected final String TEXT_437 = NL + "\t\t\t\t}";
  protected final String TEXT_438 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_439 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_440 = ") throws java.lang.Exception {";
  protected final String TEXT_441 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_442 = ".setColAutoSize(";
  protected final String TEXT_443 = ");";
  protected final String TEXT_444 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_445 = ".setColAutoSize(";
  protected final String TEXT_446 = ");";
  protected final String TEXT_447 = NL + "\t\t\t\t}";
  protected final String TEXT_448 = NL + "\t\t\t\t}";
  protected final String TEXT_449 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_450 = "(final ";
  protected final String TEXT_451 = "Struct ";
  protected final String TEXT_452 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_453 = ") throws java.lang.Exception {";
  protected final String TEXT_454 = NL + "\t\t\t\t";
  protected final String TEXT_455 = "\t\t\t\t\t";
  protected final String TEXT_456 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_460 = ".addCellValue(";
  protected final String TEXT_461 = ".";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = ");";
  protected final String TEXT_464 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_465 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = ")).toString());";
  protected final String TEXT_468 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_469 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_470 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_471 = "), ";
  protected final String TEXT_472 = ", ";
  protected final String TEXT_473 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_474 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_475 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = "), ";
  protected final String TEXT_478 = ", ";
  protected final String TEXT_479 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_480 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_481 = ".addCellValue((";
  protected final String TEXT_482 = ").doubleValue());";
  protected final String TEXT_483 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_484 = ".addCellValue(";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = ");";
  protected final String TEXT_487 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_488 = ".addCellValue(";
  protected final String TEXT_489 = ".";
  protected final String TEXT_490 = ");";
  protected final String TEXT_491 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_492 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = ")));";
  protected final String TEXT_495 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_496 = ".addCellValue(String.valueOf(";
  protected final String TEXT_497 = ".";
  protected final String TEXT_498 = "));";
  protected final String TEXT_499 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_500 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_501 = NL + "\t\t\t\t}";
  protected final String TEXT_502 = NL + "\t\t\t\t}";
  protected final String TEXT_503 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_504 = " fileOutputExcelUtil_";
  protected final String TEXT_505 = "=new FileOutputExcelUtil_";
  protected final String TEXT_506 = "();";
  protected final String TEXT_507 = NL + "\t\tboolean needDel_";
  protected final String TEXT_508 = " = false;" + NL + "\t\t";
  protected final String TEXT_509 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_510 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_511 = NL + "\t\txlsxTool_";
  protected final String TEXT_512 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_513 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_514 = ".putHeaderValue_";
  protected final String TEXT_515 = "(xlsxTool_";
  protected final String TEXT_516 = ");";
  protected final String TEXT_517 = NL + "\t\txlsxTool_";
  protected final String TEXT_518 = ".addCellValue(\"";
  protected final String TEXT_519 = "\");" + NL + "\t\t";
  protected final String TEXT_520 = NL + "\t\tneedDel_";
  protected final String TEXT_521 = " = true;" + NL + "\t\t";
  protected final String TEXT_522 = NL + "\t\tnb_line_";
  protected final String TEXT_523 = "++;" + NL + "\t\t";
  protected final String TEXT_524 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_525 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    		
			}
		}
		
		//for all tFileinput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    		
			}
		}
		
		//for all tFileoutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_26);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		log4jFileUtil.componentStartInfo(node);
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    
			}
		}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_57);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    
			} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    
			}
		}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_102);
    }else{
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if(font !=null && font.length()!=0){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(font !=null && font.length()!=0){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_133);
    
					}else{

    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_137);
    	
					}
				}else{

    stringBuffer.append(TEXT_138);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_146);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_149);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_160);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_162);
    
			}else{

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_169);
    
			}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_178);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_179);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_180);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
				}
			}
			
			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_185);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_191);
    }else{
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    
            		}
        		}
     		}
     		
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_203);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_204);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
			}

    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_216);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    
    				} 
    				
    stringBuffer.append(TEXT_219);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
   				
    stringBuffer.append(TEXT_220);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_221);
    if(keepCellFormating){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    }else{
    stringBuffer.append(TEXT_238);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_256);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_259);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_261);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_263);
     } else { 
    stringBuffer.append(TEXT_264);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_268);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_270);
    
					}else {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_274);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    
							}
							
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
					if(isNumber){

    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
					}else{

    stringBuffer.append(TEXT_297);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
					}else{

    stringBuffer.append(TEXT_313);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_327);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_328);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_329);
    
     	}

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
	}//TD64

    stringBuffer.append(TEXT_334);
    
if(isIncludeHeader){
	if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    
	}
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_339);
    
	}else{

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    
	}

    stringBuffer.append(TEXT_342);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_349);
    }
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
        		} else {

    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_361);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_367);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_369);
    
		}else{

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_374);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_376);
    
		}

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_385);
    
	}
		if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    		}
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    
}

    stringBuffer.append(TEXT_390);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_393);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    
					}
				}
			}

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    		
		} 

    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_419);
    if(!useStream){
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    }else{
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    }
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_427);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_430);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
    			}

    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_435);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_436);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_437);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_438);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
        			
					}
    			}
    			
    			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_443);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_446);
    
            		}
    			}
    			
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_447);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_448);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_449);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
        			
    			}

    stringBuffer.append(TEXT_454);
    stringBuffer.append(TEXT_455);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_456);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_458);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_463);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_467);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_468);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_471);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_473);
     } else { 
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_478);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_479);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_482);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_486);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_490);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_494);
    
					}else{	

    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_498);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_501);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_502);
        		
    		}

    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
		}//TD1
		
		if(isIncludeHeader){
			if(isDeleteEmptyFile){
		
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    
			}
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
			}
		
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_519);
    
			}
			if(isDeleteEmptyFile){
		
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    		
			}
		
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_524);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_525);
    return stringBuffer.toString();
  }
}
