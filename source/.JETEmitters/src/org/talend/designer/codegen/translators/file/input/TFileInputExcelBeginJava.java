package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Has finished.\");";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_14 = " + \" \" + log4jSb_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_16 = ".delete(0,log4jSb_";
  protected final String TEXT_17 = ".length());";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Writing the record \" + nb_line_";
  protected final String TEXT_20 = " + \" \" + log4jSb_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_22 = ".delete(0,log4jSb_";
  protected final String TEXT_23 = ".length());";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Written records count: \" + nb_line_";
  protected final String TEXT_26 = " + \" .\");";
  protected final String TEXT_27 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_28 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\tRegexUtil_";
  protected final String TEXT_29 = " regexUtil_";
  protected final String TEXT_30 = " = new RegexUtil_";
  protected final String TEXT_31 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_32 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_33 = ".setDrawingsDisabled(true);";
  protected final String TEXT_34 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_35 = ".setCellValidationDisabled(true);";
  protected final String TEXT_36 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_37 = ".setSuppressWarnings(true);";
  protected final String TEXT_38 = "\t\t" + NL + "        workbookSettings_";
  protected final String TEXT_39 = ".setEncoding(";
  protected final String TEXT_40 = ");" + NL + "        " + NL + "        Object source_";
  protected final String TEXT_41 = " =";
  protected final String TEXT_42 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_43 = ";" + NL + "        " + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_44 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_45 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_46 = " = (java.io.InputStream)source_";
  protected final String TEXT_47 = ";" + NL + "        \t\tworkbook_";
  protected final String TEXT_48 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_49 = "), workbookSettings_";
  protected final String TEXT_50 = ");" + NL + "            }else if(source_";
  protected final String TEXT_51 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_52 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_53 = ".toString());" + NL + "        \t\tworkbook_";
  protected final String TEXT_54 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_55 = "), workbookSettings_";
  protected final String TEXT_56 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_57 = " = null;" + NL + "            \t";
  protected final String TEXT_58 = NL + "            \t\tlog.fatal(\"";
  protected final String TEXT_59 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "            \t";
  protected final String TEXT_60 = NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            } " + NL + "        } finally {" + NL + "\t\t\tif(toClose_";
  protected final String TEXT_61 = "!=null) {" + NL + "\t\t\t\ttoClose_";
  protected final String TEXT_62 = ".close();" + NL + "    \t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_63 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_64 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_65 = ".getSheets());";
  protected final String TEXT_66 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_67 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_68 = NL + "        sheetList_";
  protected final String TEXT_69 = ".addAll(regexUtil_";
  protected final String TEXT_70 = ".getSheets(workbook_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = "));";
  protected final String TEXT_74 = NL + "        if(sheetList_";
  protected final String TEXT_75 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_77 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "        " + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_79 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_80 = " : sheetList_";
  protected final String TEXT_81 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_82 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_83 = ".add(sheet_FilterNull_";
  protected final String TEXT_84 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_85 = " = sheet_FilterNullList_";
  protected final String TEXT_86 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_87 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_88 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "0";
  protected final String TEXT_91 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = "0";
  protected final String TEXT_94 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_95 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_96 = ":sheetList_";
  protected final String TEXT_97 = "){" + NL + "        \tend_line_";
  protected final String TEXT_98 = "+=sheet_";
  protected final String TEXT_99 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_100 = " -= footer_input_";
  protected final String TEXT_101 = ";" + NL + "        int limit_";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = "-1";
  protected final String TEXT_104 = ";" + NL + "        int start_column_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = "0";
  protected final String TEXT_107 = "-1";
  protected final String TEXT_108 = ";" + NL + "        int end_column_";
  protected final String TEXT_109 = " = sheetList_";
  protected final String TEXT_110 = ".get(0).getColumns();";
  protected final String TEXT_111 = NL + "        Integer lastColumn_";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_114 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_115 = " = lastColumn_";
  protected final String TEXT_116 = ".intValue();" + NL + "        }";
  protected final String TEXT_117 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_118 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_119 = " = sheetList_";
  protected final String TEXT_120 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_121 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_122 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_123 = " = sheetList_";
  protected final String TEXT_124 = ".get(0).getRows();" + NL + "        " + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_125 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_126 = " = df_";
  protected final String TEXT_127 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_128 = NL + "        for(int i_";
  protected final String TEXT_129 = " = begin_line_";
  protected final String TEXT_130 = "; i_";
  protected final String TEXT_131 = " < end_line_";
  protected final String TEXT_132 = "; i_";
  protected final String TEXT_133 = "++){" + NL + "        " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_134 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_135 = " != -1 && nb_line_";
  protected final String TEXT_136 = " >= limit_";
  protected final String TEXT_137 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_138 = " >= rowCount_";
  protected final String TEXT_139 = " + currentRows_";
  protected final String TEXT_140 = ") {" + NL + "                rowCount_";
  protected final String TEXT_141 = " += currentRows_";
  protected final String TEXT_142 = ";" + NL + "                sheet_";
  protected final String TEXT_143 = " = sheetList_";
  protected final String TEXT_144 = ".get(++sheetIndex_";
  protected final String TEXT_145 = ");" + NL + "                currentRows_";
  protected final String TEXT_146 = " = sheet_";
  protected final String TEXT_147 = ".getRows();" + NL + "            }";
  protected final String TEXT_148 = NL + "            if (rowCount_";
  protected final String TEXT_149 = " <= i_";
  protected final String TEXT_150 = ") {" + NL + "                row_";
  protected final String TEXT_151 = " = sheet_";
  protected final String TEXT_152 = ".getRow(i_";
  protected final String TEXT_153 = " - rowCount_";
  protected final String TEXT_154 = ");" + NL + "            }";
  protected final String TEXT_155 = NL + "            if (rowCount_";
  protected final String TEXT_156 = " <= i_";
  protected final String TEXT_157 = " && i_";
  protected final String TEXT_158 = " - rowCount_";
  protected final String TEXT_159 = " >= begin_line_";
  protected final String TEXT_160 = " && currentRows_";
  protected final String TEXT_161 = " - footer_input_";
  protected final String TEXT_162 = " > i_";
  protected final String TEXT_163 = " - rowCount_";
  protected final String TEXT_164 = ") {" + NL + "                row_";
  protected final String TEXT_165 = " = sheet_";
  protected final String TEXT_166 = ".getRow(i_";
  protected final String TEXT_167 = " - rowCount_";
  protected final String TEXT_168 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_169 = "               " + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_170 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_171 = ".getName());";
  protected final String TEXT_172 = NL + "    \t\t";
  protected final String TEXT_173 = " = null;\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_175 = " = new String[";
  protected final String TEXT_176 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_177 = " = end_column_";
  protected final String TEXT_178 = " >\trow_";
  protected final String TEXT_179 = ".length ? row_";
  protected final String TEXT_180 = ".length : end_column_";
  protected final String TEXT_181 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_182 = ";i++){" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_183 = " < actual_end_column_";
  protected final String TEXT_184 = "){" + NL + "\t\t\t\t" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_185 = " = row_";
  protected final String TEXT_186 = "[i + start_column_";
  protected final String TEXT_187 = "];";
  protected final String TEXT_188 = " " + NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_189 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_190 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_191 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_192 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_193 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_194 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_195 = "[i] = df_";
  protected final String TEXT_196 = ".format(doubleCell_";
  protected final String TEXT_197 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_198 = "[i] = cell_";
  protected final String TEXT_199 = ".getContents();" + NL + "                        }";
  protected final String TEXT_200 = NL + "                        temp_row_";
  protected final String TEXT_201 = "[i] = cell_";
  protected final String TEXT_202 = ".getContents();";
  protected final String TEXT_203 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_204 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_205 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_206 = " = new ";
  protected final String TEXT_207 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_208 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_209 = " = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_210 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "]";
  protected final String TEXT_213 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_214 = "=";
  protected final String TEXT_215 = " + start_column_";
  protected final String TEXT_216 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_217 = " = \"";
  protected final String TEXT_218 = "\";";
  protected final String TEXT_219 = NL + "\t\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = temp_row_";
  protected final String TEXT_222 = "[";
  protected final String TEXT_223 = "]";
  protected final String TEXT_224 = ";";
  protected final String TEXT_225 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_226 = "<actual_end_column_";
  protected final String TEXT_227 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_228 = " = ((jxl.DateCell)row_";
  protected final String TEXT_229 = "[";
  protected final String TEXT_230 = " + start_column_";
  protected final String TEXT_231 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_234 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_235 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_238 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_239 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_240 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_242 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_243 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_244 = NL + "\t\t";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = " = ParserUtils.parseTo_";
  protected final String TEXT_247 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_248 = "[";
  protected final String TEXT_249 = "]";
  protected final String TEXT_250 = ", ";
  protected final String TEXT_251 = ", ";
  protected final String TEXT_252 = "));";
  protected final String TEXT_253 = "\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " = temp_row_";
  protected final String TEXT_256 = "[";
  protected final String TEXT_257 = "]";
  protected final String TEXT_258 = ".getBytes(";
  protected final String TEXT_259 = ");" + NL + "\t";
  protected final String TEXT_260 = NL + "\t\t\t";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = " = ParserUtils.parseTo_";
  protected final String TEXT_263 = "(temp_row_";
  protected final String TEXT_264 = "[";
  protected final String TEXT_265 = "]";
  protected final String TEXT_266 = ");";
  protected final String TEXT_267 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_268 = NL + "\t\t\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_270 = " - Value is empty for column : '";
  protected final String TEXT_271 = "' in '";
  protected final String TEXT_272 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_274 = "' in '";
  protected final String TEXT_275 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_276 = NL + "\t\t\t\t";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_280 = "++;";
  protected final String TEXT_281 = NL + "\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_282 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_283 = ".append(";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_287 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\t\t";
  protected final String TEXT_289 = " ";
  protected final String TEXT_290 = " = null; ";
  protected final String TEXT_291 = NL;
  protected final String TEXT_292 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_293 = " == ";
  protected final String TEXT_294 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_295 = "  " + NL + "\t\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_296 = " = true;";
  protected final String TEXT_297 = NL + "\t        ";
  protected final String TEXT_298 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_299 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_300 = NL + "            throw(e);";
  protected final String TEXT_301 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_302 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_303 = NL + "                    ";
  protected final String TEXT_304 = " = new ";
  protected final String TEXT_305 = "Struct();";
  protected final String TEXT_306 = NL + "                    ";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " = ";
  protected final String TEXT_309 = ".";
  protected final String TEXT_310 = ";";
  protected final String TEXT_311 = NL + "                ";
  protected final String TEXT_312 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_313 = "+ \" column: \" + curColName_";
  protected final String TEXT_314 = " + \" (No. \" + curColNum_";
  protected final String TEXT_315 = " + \")\";";
  protected final String TEXT_316 = NL + "                ";
  protected final String TEXT_317 = " = null;";
  protected final String TEXT_318 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_319 = NL + "                ";
  protected final String TEXT_320 = " = null;";
  protected final String TEXT_321 = NL + "            \t";
  protected final String TEXT_322 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_323 = "+ \" column: \" + curColName_";
  protected final String TEXT_324 = " + \" (No. \" + curColNum_";
  protected final String TEXT_325 = " + \")\";";
  protected final String TEXT_326 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_327 = NL + "\t\t";
  protected final String TEXT_328 = "if(!whetherReject_";
  protected final String TEXT_329 = ") { ";
  protected final String TEXT_330 = "      " + NL + "             if(";
  protected final String TEXT_331 = " == null){ " + NL + "            \t ";
  protected final String TEXT_332 = " = new ";
  protected final String TEXT_333 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_334 = NL + "\t    \t ";
  protected final String TEXT_335 = ".";
  protected final String TEXT_336 = " = ";
  protected final String TEXT_337 = ".";
  protected final String TEXT_338 = ";    \t\t\t\t";
  protected final String TEXT_339 = NL + "\t\t";
  protected final String TEXT_340 = " } ";
  protected final String TEXT_341 = "\t";
  protected final String TEXT_342 = NL + "\t\t\torg.apache.log4j.Logger logger_";
  protected final String TEXT_343 = " = org.apache.log4j.Logger.getLogger(\"org.openxml4j.opc\");" + NL + "\t        logger_";
  protected final String TEXT_344 = ".setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_345 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_346 = " regexUtil_";
  protected final String TEXT_347 = " = new RegexUtil_";
  protected final String TEXT_348 = "();" + NL + "\t\t" + NL + "\t\tObject source_";
  protected final String TEXT_349 = " = ";
  protected final String TEXT_350 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_351 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_352 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_353 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_354 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_355 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_356 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_357 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_358 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_359 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_360 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_361 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t";
  protected final String TEXT_362 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_363 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_364 = ":workbook_";
  protected final String TEXT_365 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_366 = ".add(sheet_";
  protected final String TEXT_367 = ");" + NL + "    \t}";
  protected final String TEXT_368 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_369 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_370 = NL + "        sheetList_";
  protected final String TEXT_371 = ".addAll(regexUtil_";
  protected final String TEXT_372 = ".getSheets(workbook_";
  protected final String TEXT_373 = ", ";
  protected final String TEXT_374 = ", ";
  protected final String TEXT_375 = "));";
  protected final String TEXT_376 = NL + "    \tif(sheetList_";
  protected final String TEXT_377 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_378 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_379 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_380 = NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "\t\t" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_381 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_382 = " : sheetList_";
  protected final String TEXT_383 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_384 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_385 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_386 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_387 = ".add(sheet_FilterNull_";
  protected final String TEXT_388 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_389 = " = sheetList_FilterNull_";
  protected final String TEXT_390 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_391 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_392 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_393 = " = ";
  protected final String TEXT_394 = "0";
  protected final String TEXT_395 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_396 = " = ";
  protected final String TEXT_397 = "0";
  protected final String TEXT_398 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_399 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_400 = ":sheetList_";
  protected final String TEXT_401 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_402 = "+=(sheet_";
  protected final String TEXT_403 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_404 = " -= footer_input_";
  protected final String TEXT_405 = ";" + NL + "        int limit_";
  protected final String TEXT_406 = " = ";
  protected final String TEXT_407 = "-1";
  protected final String TEXT_408 = ";" + NL + "        int start_column_";
  protected final String TEXT_409 = " = ";
  protected final String TEXT_410 = "0";
  protected final String TEXT_411 = "-1";
  protected final String TEXT_412 = ";" + NL + "        int end_column_";
  protected final String TEXT_413 = " = -1;";
  protected final String TEXT_414 = "       " + NL + "        Integer lastColumn_";
  protected final String TEXT_415 = " = ";
  protected final String TEXT_416 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_417 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_418 = " = lastColumn_";
  protected final String TEXT_419 = ".intValue();" + NL + "        }        ";
  protected final String TEXT_420 = NL + "        " + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_421 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_422 = " = sheetList_";
  protected final String TEXT_423 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_424 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_425 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_426 = " = (sheetList_";
  protected final String TEXT_427 = ".get(0).getLastRowNum()+1);" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_428 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_429 = " = df_";
  protected final String TEXT_430 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_431 = NL + "        for(int i_";
  protected final String TEXT_432 = " = begin_line_";
  protected final String TEXT_433 = "; i_";
  protected final String TEXT_434 = " < end_line_";
  protected final String TEXT_435 = "; i_";
  protected final String TEXT_436 = "++){" + NL + "       " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_437 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_438 = " != -1 && nb_line_";
  protected final String TEXT_439 = " >= limit_";
  protected final String TEXT_440 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_441 = " >= rowCount_";
  protected final String TEXT_442 = " + currentRows_";
  protected final String TEXT_443 = ") {" + NL + "                rowCount_";
  protected final String TEXT_444 = " += currentRows_";
  protected final String TEXT_445 = ";" + NL + "                sheet_";
  protected final String TEXT_446 = " = sheetList_";
  protected final String TEXT_447 = ".get(++sheetIndex_";
  protected final String TEXT_448 = ");" + NL + "                currentRows_";
  protected final String TEXT_449 = " = (sheet_";
  protected final String TEXT_450 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_451 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_452 = ".getSheetName());";
  protected final String TEXT_453 = NL + "            if (rowCount_";
  protected final String TEXT_454 = " <= i_";
  protected final String TEXT_455 = ") {" + NL + "                row_";
  protected final String TEXT_456 = " = sheet_";
  protected final String TEXT_457 = ".getRow(i_";
  protected final String TEXT_458 = " - rowCount_";
  protected final String TEXT_459 = ");" + NL + "            }";
  protected final String TEXT_460 = NL + "            if (rowCount_";
  protected final String TEXT_461 = " <= i_";
  protected final String TEXT_462 = " && i_";
  protected final String TEXT_463 = " - rowCount_";
  protected final String TEXT_464 = " >= begin_line_";
  protected final String TEXT_465 = " && currentRows_";
  protected final String TEXT_466 = " - footer_input_";
  protected final String TEXT_467 = " > i_";
  protected final String TEXT_468 = " - rowCount_";
  protected final String TEXT_469 = ") {" + NL + "                row_";
  protected final String TEXT_470 = " = sheet_";
  protected final String TEXT_471 = ".getRow(i_";
  protected final String TEXT_472 = " - rowCount_";
  protected final String TEXT_473 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_474 = "          ";
  protected final String TEXT_475 = NL + "\t\t    ";
  protected final String TEXT_476 = " = null;\t\t\t";
  protected final String TEXT_477 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_478 = " = new String[";
  protected final String TEXT_479 = "];";
  protected final String TEXT_480 = "\t\t\t\t" + NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_481 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_482 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_483 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_484 = ".add(";
  protected final String TEXT_485 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_486 = ".add(";
  protected final String TEXT_487 = ");";
  protected final String TEXT_488 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_489 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_490 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_491 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_492 = "=row_";
  protected final String TEXT_493 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_494 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_495 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_496 = " = excel_end_column_";
  protected final String TEXT_497 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_498 = " = end_column_";
  protected final String TEXT_499 = " >\texcel_end_column_";
  protected final String TEXT_500 = " ? excel_end_column_";
  protected final String TEXT_501 = " : end_column_";
  protected final String TEXT_502 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_503 = " = null;" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_504 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_505 = " < actual_end_column_";
  protected final String TEXT_506 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_507 = " = row_";
  protected final String TEXT_508 = ".getCell(i + start_column_";
  protected final String TEXT_509 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_510 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_511 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_512 = "[i] = cell_";
  protected final String TEXT_513 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_514 = ")) {";
  protected final String TEXT_515 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_516 = ".get(i)){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_517 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_518 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_519 = ".get(i));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_520 = "[i] = cell_";
  protected final String TEXT_521 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_522 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_523 = "[i] =cell_";
  protected final String TEXT_524 = ".getDateCellValue().toString();";
  protected final String TEXT_525 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_526 = "[i] = df_";
  protected final String TEXT_527 = ".format(cell_";
  protected final String TEXT_528 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_529 = "[i] =String.valueOf(cell_";
  protected final String TEXT_530 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_531 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_532 = "[i] = cell_";
  protected final String TEXT_533 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_534 = ")) {";
  protected final String TEXT_535 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_536 = ".get(i)){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_537 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_538 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_539 = ".get(i));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_540 = "[i] =cell_";
  protected final String TEXT_541 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_542 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_543 = "[i] =cell_";
  protected final String TEXT_544 = ".getDateCellValue().toString();";
  protected final String TEXT_545 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_546 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_547 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_548 = "[i] = ne_";
  protected final String TEXT_549 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_550 = "[i] =String.valueOf(cell_";
  protected final String TEXT_551 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_552 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_553 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_554 = "[i]=\"\";" + NL + "                \t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_555 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_556 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_557 = " = new ";
  protected final String TEXT_558 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_559 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_560 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_561 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_562 = "[";
  protected final String TEXT_563 = "]";
  protected final String TEXT_564 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_565 = "=";
  protected final String TEXT_566 = " + start_column_";
  protected final String TEXT_567 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_568 = " = \"";
  protected final String TEXT_569 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_570 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_571 = ".";
  protected final String TEXT_572 = " = temp_row_";
  protected final String TEXT_573 = "[";
  protected final String TEXT_574 = "]";
  protected final String TEXT_575 = ";";
  protected final String TEXT_576 = "\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_577 = "<actual_end_column_";
  protected final String TEXT_578 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_579 = ".getCell(";
  protected final String TEXT_580 = "+ start_column_";
  protected final String TEXT_581 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_582 = ".getCell(";
  protected final String TEXT_583 = "+ start_column_";
  protected final String TEXT_584 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_585 = ".";
  protected final String TEXT_586 = " = row_";
  protected final String TEXT_587 = ".getCell(";
  protected final String TEXT_588 = "+ start_column_";
  protected final String TEXT_589 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_590 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_591 = "[";
  protected final String TEXT_592 = "]";
  protected final String TEXT_593 = ", ";
  protected final String TEXT_594 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_595 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_596 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_597 = NL + "\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_598 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_599 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_600 = " + \" )\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_601 = NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_602 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_603 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_604 = NL + "                                ";
  protected final String TEXT_605 = ".";
  protected final String TEXT_606 = " = tempDate_";
  protected final String TEXT_607 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_608 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_609 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_610 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_611 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_612 = " + \" )\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_613 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_614 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_615 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_616 = NL + "\t\t\t\t";
  protected final String TEXT_617 = ".";
  protected final String TEXT_618 = " = ParserUtils.parseTo_";
  protected final String TEXT_619 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_620 = "[";
  protected final String TEXT_621 = "]";
  protected final String TEXT_622 = ", ";
  protected final String TEXT_623 = ", ";
  protected final String TEXT_624 = "));";
  protected final String TEXT_625 = NL + "\t\t\t\t";
  protected final String TEXT_626 = ".";
  protected final String TEXT_627 = " = ParserUtils.parseTo_";
  protected final String TEXT_628 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_629 = "[";
  protected final String TEXT_630 = "]";
  protected final String TEXT_631 = ", null, '.'==decimalChar_";
  protected final String TEXT_632 = " ? null : decimalChar_";
  protected final String TEXT_633 = "));";
  protected final String TEXT_634 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_635 = ".";
  protected final String TEXT_636 = " = temp_row_";
  protected final String TEXT_637 = "[";
  protected final String TEXT_638 = "]";
  protected final String TEXT_639 = ".getBytes(";
  protected final String TEXT_640 = ");";
  protected final String TEXT_641 = NL + "\t\t\t\t";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = " = ParserUtils.parseTo_";
  protected final String TEXT_644 = "(temp_row_";
  protected final String TEXT_645 = "[";
  protected final String TEXT_646 = "]";
  protected final String TEXT_647 = ");";
  protected final String TEXT_648 = NL + "\t\t\t}else{";
  protected final String TEXT_649 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_650 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_651 = " - Value is empty for column : '";
  protected final String TEXT_652 = "' in '";
  protected final String TEXT_653 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_654 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_655 = "' in '";
  protected final String TEXT_656 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_657 = NL + "\t\t\t\t";
  protected final String TEXT_658 = ".";
  protected final String TEXT_659 = " = ";
  protected final String TEXT_660 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_661 = "++;";
  protected final String TEXT_662 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_663 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_664 = ".append(";
  protected final String TEXT_665 = ".";
  protected final String TEXT_666 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_667 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_668 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_669 = " ";
  protected final String TEXT_670 = " = null; ";
  protected final String TEXT_671 = NL;
  protected final String TEXT_672 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_673 = " == ";
  protected final String TEXT_674 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_675 = "  " + NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_676 = " = true;";
  protected final String TEXT_677 = NL + "\t\t\t\t";
  protected final String TEXT_678 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_679 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_680 = NL + "\t            throw(e);";
  protected final String TEXT_681 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_682 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_683 = NL + "\t\t\t\t\t";
  protected final String TEXT_684 = " = new ";
  protected final String TEXT_685 = "Struct();";
  protected final String TEXT_686 = NL + "\t\t\t\t\t";
  protected final String TEXT_687 = ".";
  protected final String TEXT_688 = " = ";
  protected final String TEXT_689 = ".";
  protected final String TEXT_690 = ";";
  protected final String TEXT_691 = NL + "\t\t\t\t\t";
  protected final String TEXT_692 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_693 = "+ \" column: \" + curColName_";
  protected final String TEXT_694 = " + \" (No. \" + curColNum_";
  protected final String TEXT_695 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_696 = " = null;";
  protected final String TEXT_697 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_698 = " = null;";
  protected final String TEXT_699 = NL + "\t\t\t\t\t";
  protected final String TEXT_700 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_701 = "+ \" column: \" + curColName_";
  protected final String TEXT_702 = " + \" (No. \" + curColNum_";
  protected final String TEXT_703 = " + \")\";";
  protected final String TEXT_704 = NL + "\t\t\t}\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_705 = NL + "\t\t";
  protected final String TEXT_706 = "if(!whetherReject_";
  protected final String TEXT_707 = ") { ";
  protected final String TEXT_708 = "      " + NL + "             if(";
  protected final String TEXT_709 = " == null){ " + NL + "            \t ";
  protected final String TEXT_710 = " = new ";
  protected final String TEXT_711 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_712 = NL + "\t    \t ";
  protected final String TEXT_713 = ".";
  protected final String TEXT_714 = " = ";
  protected final String TEXT_715 = ".";
  protected final String TEXT_716 = ";    \t\t\t\t";
  protected final String TEXT_717 = NL + "\t\t";
  protected final String TEXT_718 = " } ";
  protected final String TEXT_719 = "\t";
  protected final String TEXT_720 = NL + "\t\tObject source_";
  protected final String TEXT_721 = " = ";
  protected final String TEXT_722 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_723 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_724 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_725 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_726 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_727 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_728 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_729 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {";
  protected final String TEXT_730 = NL + "\t\texcelReader_";
  protected final String TEXT_731 = ".addSheetName(\".*\",true);";
  protected final String TEXT_732 = NL + "\t\texcelReader_";
  protected final String TEXT_733 = ".addSheetName(";
  protected final String TEXT_734 = ", ";
  protected final String TEXT_735 = ");";
  protected final String TEXT_736 = NL + "\t\tint start_column_";
  protected final String TEXT_737 = " = ";
  protected final String TEXT_738 = "0";
  protected final String TEXT_739 = "-1";
  protected final String TEXT_740 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_741 = " = ";
  protected final String TEXT_742 = "-1";
  protected final String TEXT_743 = "-1";
  protected final String TEXT_744 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_745 = " >=0) {//follow start column" + NL + "\t\t\tend_column_";
  protected final String TEXT_746 = " = start_column_";
  protected final String TEXT_747 = " + ";
  protected final String TEXT_748 = " - 1;" + NL + "\t\t} else if(end_column_";
  protected final String TEXT_749 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_750 = " = end_column_";
  protected final String TEXT_751 = " - ";
  protected final String TEXT_752 = " + 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(end_column_";
  protected final String TEXT_753 = "<0 || start_column_";
  protected final String TEXT_754 = "<0) {" + NL + "\t\t\t";
  protected final String TEXT_755 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_756 = " - Error start column and end column.\");" + NL + "\t\t\t";
  protected final String TEXT_757 = NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tint header_";
  protected final String TEXT_758 = " = ";
  protected final String TEXT_759 = "0";
  protected final String TEXT_760 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_761 = " = ";
  protected final String TEXT_762 = "-1";
  protected final String TEXT_763 = ";" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_764 = " = 0;" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_765 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_766 = " = df_";
  protected final String TEXT_767 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_768 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_769 = ".parse((String)source_";
  protected final String TEXT_770 = ",";
  protected final String TEXT_771 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_772 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_773 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_774 = ",";
  protected final String TEXT_775 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\twhile((header_";
  protected final String TEXT_776 = "--)>0 && excelReader_";
  protected final String TEXT_777 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_778 = ".next();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_779 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_780 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_781 = " = 0;" + NL + "\t\t" + NL + "\t\t\tif (limit_";
  protected final String TEXT_782 = " != -1 && nb_line_";
  protected final String TEXT_783 = " >= limit_";
  protected final String TEXT_784 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_785 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_786 = " = excelReader_";
  protected final String TEXT_787 = ".next();";
  protected final String TEXT_788 = NL + "\t\t";
  protected final String TEXT_789 = " = null;\t\t\t";
  protected final String TEXT_790 = NL + "\t\tString[] temp_row_";
  protected final String TEXT_791 = " = new String[";
  protected final String TEXT_792 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_793 = "=0;i_";
  protected final String TEXT_794 = " < ";
  protected final String TEXT_795 = ";i_";
  protected final String TEXT_796 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_797 = " = i_";
  protected final String TEXT_798 = " + start_column_";
  protected final String TEXT_799 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_800 = " <= end_column_";
  protected final String TEXT_801 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_802 = " < row_";
  protected final String TEXT_803 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_804 = " = row_";
  protected final String TEXT_805 = ".get(current_";
  protected final String TEXT_806 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_807 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_808 = "[i_";
  protected final String TEXT_809 = "] = column_";
  protected final String TEXT_810 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_811 = "[i_";
  protected final String TEXT_812 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_813 = "[i_";
  protected final String TEXT_814 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_815 = "[i_";
  protected final String TEXT_816 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_817 = " = false;" + NL + "\t\t";
  protected final String TEXT_818 = " = new ";
  protected final String TEXT_819 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_820 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_821 = " = \"\";" + NL + "\t\t" + NL + "\t\ttry{";
  protected final String TEXT_822 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_823 = "[";
  protected final String TEXT_824 = "]";
  protected final String TEXT_825 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_826 = "=";
  protected final String TEXT_827 = " + start_column_";
  protected final String TEXT_828 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_829 = " = \"";
  protected final String TEXT_830 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_831 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_832 = ".";
  protected final String TEXT_833 = " = temp_row_";
  protected final String TEXT_834 = "[";
  protected final String TEXT_835 = "]";
  protected final String TEXT_836 = ";";
  protected final String TEXT_837 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_838 = ".";
  protected final String TEXT_839 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_840 = "[";
  protected final String TEXT_841 = "]";
  protected final String TEXT_842 = ", ";
  protected final String TEXT_843 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_844 = NL + "\t\t\t\t\t";
  protected final String TEXT_845 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_846 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_847 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_848 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_849 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_850 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_851 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_852 = NL + "\t\t\t\t";
  protected final String TEXT_853 = ".";
  protected final String TEXT_854 = " = ParserUtils.parseTo_";
  protected final String TEXT_855 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_856 = "[";
  protected final String TEXT_857 = "]";
  protected final String TEXT_858 = ", ";
  protected final String TEXT_859 = ", ";
  protected final String TEXT_860 = "));";
  protected final String TEXT_861 = NL + "\t\t\t\t";
  protected final String TEXT_862 = ".";
  protected final String TEXT_863 = " = ParserUtils.parseTo_";
  protected final String TEXT_864 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_865 = "[";
  protected final String TEXT_866 = "]";
  protected final String TEXT_867 = ", null, '.'==decimalChar_";
  protected final String TEXT_868 = " ? null : decimalChar_";
  protected final String TEXT_869 = "));";
  protected final String TEXT_870 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_871 = ".";
  protected final String TEXT_872 = " = temp_row_";
  protected final String TEXT_873 = "[";
  protected final String TEXT_874 = "]";
  protected final String TEXT_875 = ".getBytes(";
  protected final String TEXT_876 = ");";
  protected final String TEXT_877 = NL + "\t\t\t\t";
  protected final String TEXT_878 = ".";
  protected final String TEXT_879 = " = ParserUtils.parseTo_";
  protected final String TEXT_880 = "(temp_row_";
  protected final String TEXT_881 = "[";
  protected final String TEXT_882 = "]";
  protected final String TEXT_883 = ");";
  protected final String TEXT_884 = NL + "\t\t\t}else{";
  protected final String TEXT_885 = NL + "\t\t\t\t\t";
  protected final String TEXT_886 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_887 = " - Value is empty for column : '";
  protected final String TEXT_888 = "' in '";
  protected final String TEXT_889 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_890 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_891 = "' in '";
  protected final String TEXT_892 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_893 = NL + "\t\t\t\t";
  protected final String TEXT_894 = ".";
  protected final String TEXT_895 = " = ";
  protected final String TEXT_896 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_897 = "++;";
  protected final String TEXT_898 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_899 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_900 = ".append(";
  protected final String TEXT_901 = ".";
  protected final String TEXT_902 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_903 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_904 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_905 = NL;
  protected final String TEXT_906 = " ";
  protected final String TEXT_907 = " = null; ";
  protected final String TEXT_908 = NL;
  protected final String TEXT_909 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_910 = " == ";
  protected final String TEXT_911 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_912 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_913 = " = true;";
  protected final String TEXT_914 = NL + "\t\t\t\t";
  protected final String TEXT_915 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_916 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_917 = NL + "\t            throw(e);";
  protected final String TEXT_918 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_919 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_920 = NL + "\t\t\t\t\t";
  protected final String TEXT_921 = " = new ";
  protected final String TEXT_922 = "Struct();";
  protected final String TEXT_923 = NL + "\t\t\t\t\t";
  protected final String TEXT_924 = ".";
  protected final String TEXT_925 = " = ";
  protected final String TEXT_926 = ".";
  protected final String TEXT_927 = ";";
  protected final String TEXT_928 = NL + "\t\t\t\t\t";
  protected final String TEXT_929 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_930 = "+ \" column: \" + curColName_";
  protected final String TEXT_931 = " + \" (No. \" + curColNum_";
  protected final String TEXT_932 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_933 = " = null;";
  protected final String TEXT_934 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_935 = " = null;";
  protected final String TEXT_936 = NL + "\t\t\t\t\t";
  protected final String TEXT_937 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_938 = "+ \" column: \" + curColName_";
  protected final String TEXT_939 = " + \" (No. \" + curColNum_";
  protected final String TEXT_940 = " + \")\";";
  protected final String TEXT_941 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_942 = NL + "        \t\t";
  protected final String TEXT_943 = "if(!whetherReject_";
  protected final String TEXT_944 = ") { ";
  protected final String TEXT_945 = "      " + NL + "                     if(";
  protected final String TEXT_946 = " == null){ " + NL + "                    \t ";
  protected final String TEXT_947 = " = new ";
  protected final String TEXT_948 = "Struct();" + NL + "                     }\t\t\t\t";
  protected final String TEXT_949 = NL + "        \t    \t ";
  protected final String TEXT_950 = ".";
  protected final String TEXT_951 = " = ";
  protected final String TEXT_952 = ".";
  protected final String TEXT_953 = ";    \t\t\t\t";
  protected final String TEXT_954 = NL + "        \t\t";
  protected final String TEXT_955 = " } ";
  protected final String TEXT_956 = "\t";
  protected final String TEXT_957 = NL;
  protected final String TEXT_958 = NL;
  protected final String TEXT_959 = NL;
  protected final String TEXT_960 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    		
			}
		}
		
		//for all tFileinput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    		
			}
		}
		
		//for all tFileoutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");
	
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));
		
		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		boolean eventMode = "EVENT_MODE".equals(mode);
		
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		log4jFileUtil.componentStartInfo(node);
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    
		}

    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
          
		if(isAllSheets){

    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    
		}else{

    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_73);
    
			}
		}

    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_90);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_93);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_103);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_106);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    
	if(!affect){

    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    
	}else{

    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    
    }

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    
//begin
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
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

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_173);
    
    				}
    			}
    		}
    	}
    	
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_174);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    
                    if(bReadRealValue){

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
                    }else{

    stringBuffer.append(TEXT_200);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
                    }

    stringBuffer.append(TEXT_203);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_219);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_223);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_224);
    		
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_225);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_226);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_236);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    
//start			
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_244);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_252);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
	
    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_257);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_259);
    
			} else {
//
//end
    stringBuffer.append(TEXT_260);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_265);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_266);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_267);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_268);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_272);
    }
    stringBuffer.append(TEXT_273);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_275);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_279);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_280);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_281);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_285);
    if(i < size-1){
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    }
						}
    
//start
//
					}
    stringBuffer.append(TEXT_288);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_290);
    }
    stringBuffer.append(TEXT_291);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_292);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_294);
    
	}

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_297);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    }
    stringBuffer.append(TEXT_300);
    
        } else {
	        if(isLog4jEnabled){
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_303);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_305);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_306);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_308);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_310);
    
                }
                
    stringBuffer.append(TEXT_311);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_317);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_318);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_320);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    }
        } 
        
    stringBuffer.append(TEXT_326);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_327);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_333);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_334);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_338);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_339);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_340);
     } 
    stringBuffer.append(TEXT_341);
    
		}
		}

    	
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    }
    stringBuffer.append(TEXT_361);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_362);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
		}else{

    stringBuffer.append(TEXT_368);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_369);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_370);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_375);
    
			}
		}

    stringBuffer.append(TEXT_376);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_377);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    }
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_393);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_394);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_395);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_396);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_397);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_398);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_406);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_407);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_408);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_409);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_410);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_411);
    }
    stringBuffer.append(TEXT_412);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_413);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    }
    stringBuffer.append(TEXT_420);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_431);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    
	if(!affect){

    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_459);
    
	}else{

    stringBuffer.append(TEXT_460);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_473);
    
    }

    stringBuffer.append(TEXT_474);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String rejectConnName = "";
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
		if (conns!=null) {
			if (conns.size()>0) {
		    	for (int i=0;i<conns.size();i++) {
		    		IConnection connTemp = conns.get(i);
		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_475);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_476);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3	 
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_477);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_479);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    	
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");				
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_487);
    
						}
					}
				}	
			}

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_504);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
								if(converDatetoString){

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
								}else{

    stringBuffer.append(TEXT_522);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
								}

    stringBuffer.append(TEXT_525);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
										if(converDatetoString){

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    
										}else{

    stringBuffer.append(TEXT_542);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    
										}

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_563);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_566);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_569);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_570);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_574);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_575);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_576);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_577);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_580);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_583);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_586);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_588);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_592);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_593);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    }
    stringBuffer.append(TEXT_601);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_608);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    }
    stringBuffer.append(TEXT_613);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_616);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_618);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_621);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_622);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_623);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_624);
    
							} else {

    stringBuffer.append(TEXT_625);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_627);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_630);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_634);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_638);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_640);
    
						} else {

    stringBuffer.append(TEXT_641);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_643);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_646);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_647);
    
						}

    stringBuffer.append(TEXT_648);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_649);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_653);
    }
    stringBuffer.append(TEXT_654);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_655);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_656);
    
						} else {

    stringBuffer.append(TEXT_657);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_660);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_661);
    
						}

    stringBuffer.append(TEXT_662);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_665);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_666);
    if(i < size-1){
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    }
						}
    
					}

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_669);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_670);
    }
    stringBuffer.append(TEXT_671);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_672);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_674);
    
	}

    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_677);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    }
    stringBuffer.append(TEXT_680);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_683);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_685);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_686);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_690);
    
					    }//16

    stringBuffer.append(TEXT_691);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_696);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_697);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_698);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_699);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    
					}//15
				}

    stringBuffer.append(TEXT_704);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_705);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_708);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_711);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_712);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_716);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_717);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_718);
     } 
    stringBuffer.append(TEXT_719);
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    }
    stringBuffer.append(TEXT_729);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_734);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_735);
    
				}
			}

    stringBuffer.append(TEXT_736);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_737);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_738);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_739);
    }
    stringBuffer.append(TEXT_740);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_741);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_742);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_743);
    }
    stringBuffer.append(TEXT_744);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_745);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_746);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_748);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_749);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_750);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_752);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_753);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_754);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    }
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_759);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_762);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_763);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_770);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_778);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_781);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_782);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			
			String rejectConnName = "";
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
    		
    		if (conns!=null) {
    			if (conns.size()>0) {
    		    	for (int i=0;i<conns.size();i++) {
    		    		IConnection connTemp = conns.get(i);
    		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_788);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_789);
    
    		    		}
    		    	}
    		    }
			}
			
			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256

    stringBuffer.append(TEXT_790);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_791);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_817);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_821);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_823);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_824);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_826);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_827);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_829);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_830);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_831);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_832);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_834);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_835);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_836);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_837);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_838);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_840);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_841);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_842);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_843);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_844);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_848);
    }
    stringBuffer.append(TEXT_849);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_851);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_852);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_853);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_854);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_856);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_857);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_858);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_859);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_860);
    
							} else {

    stringBuffer.append(TEXT_861);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_863);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_865);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_866);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_869);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_870);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_871);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_873);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_874);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_875);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_876);
    
						} else {

    stringBuffer.append(TEXT_877);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_878);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_879);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_880);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_881);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_882);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_883);
    
						}

    stringBuffer.append(TEXT_884);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_885);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_888);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_889);
    }
    stringBuffer.append(TEXT_890);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_891);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_892);
    
						} else {

    stringBuffer.append(TEXT_893);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_894);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_895);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_896);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_897);
    
						}

    stringBuffer.append(TEXT_898);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_901);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_902);
    if(i < size-1){
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    }
						}
    
					}//TD128

    stringBuffer.append(TEXT_905);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_906);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_907);
    }
    stringBuffer.append(TEXT_908);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_909);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_910);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_911);
    
	}

    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_914);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    }
    stringBuffer.append(TEXT_917);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_920);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_921);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_922);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_923);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_925);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_927);
    
					    }//16

    stringBuffer.append(TEXT_928);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_932);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_933);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_934);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_935);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_936);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_940);
    
					}//15
				}

    stringBuffer.append(TEXT_941);
    
    				}//TD256
				}//TD528
				
        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_942);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_943);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_944);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_946);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_947);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_948);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_949);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_950);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_951);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_952);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_953);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_954);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_955);
     } 
    stringBuffer.append(TEXT_956);
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_957);
    
		}//end version judgement

    stringBuffer.append(TEXT_958);
    
	}
}
//
//end
    stringBuffer.append(TEXT_959);
    stringBuffer.append(TEXT_960);
    return stringBuffer.toString();
  }
}
