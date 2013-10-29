package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLMainJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLMainJava result = new TAdvancedFileOutputXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tvalueMap_";
  protected final String TEXT_3 = ".get(\"";
  protected final String TEXT_4 = "\")";
  protected final String TEXT_5 = NL + "\t(";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null?";
  protected final String TEXT_9 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_10 = "), ";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ")\t\t\t\t\t";
  protected final String TEXT_13 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "), ";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ")\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "            String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = NL + "            ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".toString()";
  protected final String TEXT_32 = ":";
  protected final String TEXT_33 = "null";
  protected final String TEXT_34 = NL + "\t\t)";
  protected final String TEXT_35 = NL + "\t\t\t";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ".setName(\"";
  protected final String TEXT_38 = "\");";
  protected final String TEXT_39 = NL + "\t\t\tif (";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_46 = NL + "                ";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = ".remove(";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ";" + NL + "\t\tif (";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_56 = "\") == null) {";
  protected final String TEXT_57 = NL + "            ";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_60 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_63 = "\");" + NL + "        }";
  protected final String TEXT_64 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_67 = "\");";
  protected final String TEXT_68 = NL + "\t\tList currentList_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ".elements(\"";
  protected final String TEXT_72 = "\");" + NL + "\t\tint app_size_";
  protected final String TEXT_73 = " = currentList_";
  protected final String TEXT_74 = ".size();" + NL + "\t\tif(app_size_";
  protected final String TEXT_75 = " > 0){" + NL + "\t\t\torders_";
  protected final String TEXT_76 = "[";
  protected final String TEXT_77 = "] =1+ ";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = ".elements().indexOf(currentList_";
  protected final String TEXT_80 = ".get(app_size_";
  protected final String TEXT_81 = "-1));" + NL + "\t\t}else{//when the group or loop element appear first time";
  protected final String TEXT_82 = NL + "\t\t\tList allList_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = ".elements();" + NL + "\t\t\t//append tail as default action" + NL + "\t\t\torders_";
  protected final String TEXT_86 = "[";
  protected final String TEXT_87 = "] = allList_";
  protected final String TEXT_88 = ".size();";
  protected final String TEXT_89 = NL + "\t\t\tList siblingList_";
  protected final String TEXT_90 = " = null;" + NL + "\t\t\tboolean findInsertPosition_";
  protected final String TEXT_91 = " = false;";
  protected final String TEXT_92 = NL + "\t\t\tif(!findInsertPosition_";
  protected final String TEXT_93 = " && allList_";
  protected final String TEXT_94 = ".size()!=0) {" + NL + "\t\t\t\tsiblingList_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ".elements(\"";
  protected final String TEXT_98 = "\");" + NL + "\t\t\t\tif(siblingList_";
  protected final String TEXT_99 = ".size() > 0) {" + NL + "\t\t\t\t\tfindInsertPosition_";
  protected final String TEXT_100 = " = true;" + NL + "\t\t\t\t\torders_";
  protected final String TEXT_101 = "[";
  protected final String TEXT_102 = "] = allList_";
  protected final String TEXT_103 = ".indexOf(siblingList_";
  protected final String TEXT_104 = ".get(0));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_105 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ".elements().add(orders_";
  protected final String TEXT_108 = "[";
  protected final String TEXT_109 = "],";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "        if(orders_";
  protected final String TEXT_113 = "[";
  protected final String TEXT_114 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_115 = "[";
  protected final String TEXT_116 = "] = ";
  protected final String TEXT_117 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_118 = " < orders_";
  protected final String TEXT_119 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_120 = "[";
  protected final String TEXT_121 = "] = 0;" + NL + "        }";
  protected final String TEXT_122 = NL + "        ";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ".elements().add(orders_";
  protected final String TEXT_125 = "[";
  protected final String TEXT_126 = "]++,";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = ";" + NL + "\t\tif (";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_134 = "\") == null) {";
  protected final String TEXT_135 = NL + "            ";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = ".addElement(\"";
  protected final String TEXT_140 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_141 = "_";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = ".addElement(\"";
  protected final String TEXT_145 = "\");" + NL + "        }";
  protected final String TEXT_146 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = ".addElement(\"";
  protected final String TEXT_151 = "\");";
  protected final String TEXT_152 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = "_";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "\t\tif(";
  protected final String TEXT_157 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_158 = " .parseAndAdd(";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ",";
  protected final String TEXT_161 = ");" + NL + "\t\t}";
  protected final String TEXT_162 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_163 = " .parseAndAdd(";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_168 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_169 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_170 = " .setText(";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_173 = ").getDocument().getRootElement().asXML());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_174 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_175 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_176 = " .setText(";
  protected final String TEXT_177 = "_";
  protected final String TEXT_178 = ",";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_180 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_183 = "_";
  protected final String TEXT_184 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_186 = ".parseAndAdd(";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = ",\"";
  protected final String TEXT_189 = "\");" + NL;
  protected final String TEXT_190 = " " + NL + "\t\t  if (";
  protected final String TEXT_191 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = ".addAttribute(\"";
  protected final String TEXT_194 = "\", ";
  protected final String TEXT_195 = ");" + NL + "\t\t  } ";
  protected final String TEXT_196 = " else {" + NL + "\t\t    ";
  protected final String TEXT_197 = "_";
  protected final String TEXT_198 = ".addAttribute(\"";
  protected final String TEXT_199 = "\", \"\");" + NL + "          }";
  protected final String TEXT_200 = NL + "\t\t    ";
  protected final String TEXT_201 = "_";
  protected final String TEXT_202 = ".addAttribute(\"";
  protected final String TEXT_203 = "\", \"";
  protected final String TEXT_204 = "\");";
  protected final String TEXT_205 = NL + "\t\t    ";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = ".addAttribute(\"";
  protected final String TEXT_208 = "\", \"\");" + NL + "\t\t  ";
  protected final String TEXT_209 = NL + "\t\tif(";
  protected final String TEXT_210 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = ".addNamespace(\"";
  protected final String TEXT_213 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_214 = "));";
  protected final String TEXT_215 = NL + "        \t";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_218 = "_";
  protected final String TEXT_219 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_220 = "))));";
  protected final String TEXT_221 = NL + "\t\t}";
  protected final String TEXT_222 = NL + "\t\t\t";
  protected final String TEXT_223 = "_";
  protected final String TEXT_224 = ".addNamespace(\"";
  protected final String TEXT_225 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_226 = "\"));";
  protected final String TEXT_227 = NL + "        \t";
  protected final String TEXT_228 = "_";
  protected final String TEXT_229 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_230 = "_";
  protected final String TEXT_231 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_232 = "\"))));";
  protected final String TEXT_233 = "true";
  protected final String TEXT_234 = " && (";
  protected final String TEXT_235 = "(";
  protected final String TEXT_236 = "==null && ";
  protected final String TEXT_237 = " == null) || (true &&";
  protected final String TEXT_238 = "!=null" + NL + " && ";
  protected final String TEXT_239 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_240 = ".getText().equals(";
  protected final String TEXT_241 = ")";
  protected final String TEXT_242 = ")";
  protected final String TEXT_243 = NL + ")";
  protected final String TEXT_244 = " && (";
  protected final String TEXT_245 = "(";
  protected final String TEXT_246 = "==null && ";
  protected final String TEXT_247 = ".attribute(\"";
  protected final String TEXT_248 = "\") == null) || (true && ";
  protected final String TEXT_249 = ".attribute(\"";
  protected final String TEXT_250 = "\")!=null" + NL + "&& ";
  protected final String TEXT_251 = ".attribute(\"";
  protected final String TEXT_252 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_253 = ".attribute(\"";
  protected final String TEXT_254 = "\").getText().equals(";
  protected final String TEXT_255 = ")";
  protected final String TEXT_256 = ")";
  protected final String TEXT_257 = ")";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = ".element(";
  protected final String TEXT_260 = ".getQName(\"";
  protected final String TEXT_261 = "\"))";
  protected final String TEXT_262 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_263 = "[";
  protected final String TEXT_264 = "] = buf_";
  protected final String TEXT_265 = ".toString();" + NL + "        buf_";
  protected final String TEXT_266 = " = new StringBuffer();";
  protected final String TEXT_267 = NL + "\t\tstartTabs_";
  protected final String TEXT_268 = "[";
  protected final String TEXT_269 = "] = buf_";
  protected final String TEXT_270 = ".toString();" + NL + "        buf_";
  protected final String TEXT_271 = " = new StringBuffer();";
  protected final String TEXT_272 = NL + "\t\tout_";
  protected final String TEXT_273 = ".write(buf_";
  protected final String TEXT_274 = ".toString());" + NL + "        buf_";
  protected final String TEXT_275 = " = new StringBuffer();";
  protected final String TEXT_276 = NL + "\t\tif( false";
  protected final String TEXT_277 = " || valueMap_";
  protected final String TEXT_278 = ".get(\"";
  protected final String TEXT_279 = "\") != null";
  protected final String TEXT_280 = " || true " + NL + "                    \t";
  protected final String TEXT_281 = NL + "\t\t){";
  protected final String TEXT_282 = NL + "\t\t}";
  protected final String TEXT_283 = NL + "\t\tbuf_";
  protected final String TEXT_284 = ".append(\"";
  protected final String TEXT_285 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_286 = ".append(\"";
  protected final String TEXT_287 = "<";
  protected final String TEXT_288 = "\");";
  protected final String TEXT_289 = NL + "\t\tbuf_";
  protected final String TEXT_290 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_291 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+ file_";
  protected final String TEXT_292 = ".substring(file_";
  protected final String TEXT_293 = ".lastIndexOf(\"/\")+1)+\".xsd\"+\"\\\"\");";
  protected final String TEXT_294 = NL + "\t\tif(";
  protected final String TEXT_295 = " == null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_296 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_297 = NL + "\t\tbuf_";
  protected final String TEXT_298 = ".append(\">\");";
  protected final String TEXT_299 = NL + "\t\tbuf_";
  protected final String TEXT_300 = ".append(\"";
  protected final String TEXT_301 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_302 = ".append(\"";
  protected final String TEXT_303 = "</";
  protected final String TEXT_304 = ">\");";
  protected final String TEXT_305 = NL + "\t\tbuf_";
  protected final String TEXT_306 = ".append(\"</";
  protected final String TEXT_307 = ">\");";
  protected final String TEXT_308 = NL + "\t\tif(";
  protected final String TEXT_309 = "!=null){" + NL + "\t\t\tif(routines.system.XMLHelper.getInstance().isValid(";
  protected final String TEXT_310 = ")){" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_311 = ".append(";
  protected final String TEXT_312 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_313 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_314 = "));" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_315 = NL + "\t\tif(";
  protected final String TEXT_316 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_317 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_318 = "));" + NL + "\t\t}";
  protected final String TEXT_319 = NL + "\t\tif(routines.system.XMLHelper.getInstance().isValid(\"";
  protected final String TEXT_320 = "\")){" + NL + "\t\t\tbuf_";
  protected final String TEXT_321 = ".append(\"";
  protected final String TEXT_322 = "\");" + NL + "\t\t} else {" + NL + "\t\t\tbuf_";
  protected final String TEXT_323 = ".append(TalendString.checkCDATAForXML(\"";
  protected final String TEXT_324 = "\"));" + NL + "\t\t}";
  protected final String TEXT_325 = NL + "\t\t  if (";
  protected final String TEXT_326 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_327 = ".append(\" ";
  protected final String TEXT_328 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_329 = ")+\"\\\"\");" + NL + "\t\t  } ";
  protected final String TEXT_330 = " else{" + NL + "\t\t    buf_";
  protected final String TEXT_331 = ".append(\" ";
  protected final String TEXT_332 = "=\\\"\\\"\");" + NL + "\t\t  }";
  protected final String TEXT_333 = NL + "\t\t    buf_";
  protected final String TEXT_334 = ".append(\" ";
  protected final String TEXT_335 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_336 = "\")+\"\\\"\");";
  protected final String TEXT_337 = NL + "\t\t    buf_";
  protected final String TEXT_338 = ".append(\" ";
  protected final String TEXT_339 = "=\\\"\\\"\");" + NL + "\t\t  ";
  protected final String TEXT_340 = NL + "\t\tif(";
  protected final String TEXT_341 = "!=null){";
  protected final String TEXT_342 = NL + "        \tbuf_";
  protected final String TEXT_343 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_344 = ")+\"\\\"\");";
  protected final String TEXT_345 = NL + "\t\t\tbuf_";
  protected final String TEXT_346 = ".append(\" xmlns:";
  protected final String TEXT_347 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_348 = ")+\"\\\"\");";
  protected final String TEXT_349 = NL + "\t\t}";
  protected final String TEXT_350 = NL + "        \tbuf_";
  protected final String TEXT_351 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_352 = "\")+\"\\\"\");";
  protected final String TEXT_353 = NL + "\t\t\tbuf_";
  protected final String TEXT_354 = ".append(\" xmlns:";
  protected final String TEXT_355 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_356 = "\")+\"\\\"\");";
  protected final String TEXT_357 = NL;
  protected final String TEXT_358 = NL + "\tnb_line_";
  protected final String TEXT_359 = "++;" + NL + "\tvalueMap_";
  protected final String TEXT_360 = ".clear();";
  protected final String TEXT_361 = NL + "\tadvancedXMLUtil_";
  protected final String TEXT_362 = ".putValue_";
  protected final String TEXT_363 = "(";
  protected final String TEXT_364 = ",valueMap_";
  protected final String TEXT_365 = ");";
  protected final String TEXT_366 = NL + "\tvalueMap_";
  protected final String TEXT_367 = ".put(\"";
  protected final String TEXT_368 = "\", ";
  protected final String TEXT_369 = ");";
  protected final String TEXT_370 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_371 = " = null;" + NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_372 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_373 = "=false;" + NL + "\t\tif(orders_";
  protected final String TEXT_374 = ".length>0){" + NL + "\t\t\torders_";
  protected final String TEXT_375 = "[0] = 0;" + NL + "\t\t}";
  protected final String TEXT_376 = NL + "\t\troot4Group_";
  protected final String TEXT_377 = " = subTreeRootParent_";
  protected final String TEXT_378 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_379 = "=root4Group_";
  protected final String TEXT_380 = ";" + NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_381 = NL + "\t}";
  protected final String TEXT_382 = NL + "\t\tif(firstGroupPathElement_";
  protected final String TEXT_383 = " == null){" + NL + "\t\t\tfirstGroupPathElement_";
  protected final String TEXT_384 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_385 = ".selectSingleNode(\"";
  protected final String TEXT_386 = "\");" + NL + "\t\t\tif(firstGroupPathElement_";
  protected final String TEXT_387 = " == null){" + NL + "\t\t\t\tfirstGroupPathElement_";
  protected final String TEXT_388 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_389 = ".selectSingleNode(\"";
  protected final String TEXT_390 = "\");" + NL + "\t\t\t\tif(firstGroupPathElement_";
  protected final String TEXT_391 = " == null) {" + NL + "\t\t\t\t\tSystem.err.println(\"WARN : the root tag is not same when appending\");" + NL + "\t\t\t\t} else { " + NL + "\t\t\t\t\tString subRootPath = firstGroupPathElement_";
  protected final String TEXT_392 = ".getPath().replace(\"*[name()='\",\"\").replace(\"']\", \"\");" + NL + "\t\t\t\t\tif(!\"";
  protected final String TEXT_393 = "\".equals(subRootPath)) {" + NL + "\t\t\t\t\t\tSystem.err.println(\"WARN : the root tag is not same on namespace prefix when appending\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tfirstGroupPathElement_";
  protected final String TEXT_394 = " = firstGroupPathElement_";
  protected final String TEXT_395 = ".getParent();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_396 = " = firstGroupPathElement_";
  protected final String TEXT_397 = ";" + NL + "\t\t" + NL + "\t\tboolean bl_";
  protected final String TEXT_398 = "= false;//true:find the insert node;false:not";
  protected final String TEXT_399 = NL + "\t\tif(bl_";
  protected final String TEXT_400 = "==false){" + NL + "\t\t\tjava.util.List<org.dom4j.Element> listNodes= subTreeRootParent_";
  protected final String TEXT_401 = ".elements();" + NL + "\t\t\tif(listNodes!=null && listNodes.size()>0){" + NL + "\t\t\t\tint j=0;" + NL + "\t\t\t\tfor(j=0;j<listNodes.size();j++){" + NL + "\t\t\t\t\torg.dom4j.Element tempElem =listNodes.get(j);" + NL + "\t\t\t\t\tif((\"";
  protected final String TEXT_402 = "\").equals(tempElem.getPath()!=null ? tempElem.getPath().replace(\"*[name()='\",\"\").replace(\"']\", \"\") : \"\")){";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\tif(advancedXMLUtil_";
  protected final String TEXT_404 = ".generateCodeDom4j_FindInsertNode";
  protected final String TEXT_405 = "(tempElem,valueMap_";
  protected final String TEXT_406 = ")){";
  protected final String TEXT_407 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_408 = "){";
  protected final String TEXT_409 = NL + "\t\t\t\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_410 = " =  tempElem;" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(j>=listNodes.size()){" + NL + "\t\t\t\t\tbl_";
  protected final String TEXT_411 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tbl_";
  protected final String TEXT_412 = "=true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(bl_";
  protected final String TEXT_413 = "==true){";
  protected final String TEXT_414 = NL + "\t\t\t\t\t\torg.dom4j.Element group";
  protected final String TEXT_415 = "__";
  protected final String TEXT_416 = " = advancedXMLUtil_";
  protected final String TEXT_417 = ".generateCodeDom4j_UnFindInsertNode";
  protected final String TEXT_418 = "(nestXMLTool_";
  protected final String TEXT_419 = ",valueMap_";
  protected final String TEXT_420 = ",subTreeRootParent_";
  protected final String TEXT_421 = ",orders_";
  protected final String TEXT_422 = ",bl_";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "\t\t\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_425 = "=group";
  protected final String TEXT_426 = "__";
  protected final String TEXT_427 = ";";
  protected final String TEXT_428 = NL + "\t\t}";
  protected final String TEXT_429 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_430 = " = false;";
  protected final String TEXT_431 = NL + "\tif(isNewElememt_";
  protected final String TEXT_432 = " || groupbyList_";
  protected final String TEXT_433 = ".size()<=";
  protected final String TEXT_434 = " || groupbyList_";
  protected final String TEXT_435 = ".get(";
  protected final String TEXT_436 = ")==null";
  protected final String TEXT_437 = NL + "\t|| advancedXMLUtil_";
  protected final String TEXT_438 = ".getValue_";
  protected final String TEXT_439 = "_";
  protected final String TEXT_440 = "(groupbyList_";
  protected final String TEXT_441 = ",valueMap_";
  protected final String TEXT_442 = ")";
  protected final String TEXT_443 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_444 = ".get(";
  protected final String TEXT_445 = ").get(";
  protected final String TEXT_446 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_447 = ".get(";
  protected final String TEXT_448 = ").get(";
  protected final String TEXT_449 = ").equals(";
  protected final String TEXT_450 = ") " + NL + "\t\t: ";
  protected final String TEXT_451 = "!=null )";
  protected final String TEXT_452 = NL + "\t){";
  protected final String TEXT_453 = NL + "\t\t\t\torg.dom4j.Element group";
  protected final String TEXT_454 = "__";
  protected final String TEXT_455 = "=advancedXMLUtil_";
  protected final String TEXT_456 = ".generateCodeDom4j_group";
  protected final String TEXT_457 = "(nestXMLTool_";
  protected final String TEXT_458 = ",valueMap_";
  protected final String TEXT_459 = ",subTreeRootParent_";
  protected final String TEXT_460 = ",orders_";
  protected final String TEXT_461 = ");";
  protected final String TEXT_462 = NL + "\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_463 = "=group";
  protected final String TEXT_464 = "__";
  protected final String TEXT_465 = ";";
  protected final String TEXT_466 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_467 = ".size()<=";
  protected final String TEXT_468 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_469 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_470 = ".get(";
  protected final String TEXT_471 = ").clear();" + NL + "        }";
  protected final String TEXT_472 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_473 = ".setValue_";
  protected final String TEXT_474 = "_";
  protected final String TEXT_475 = "(groupbyList_";
  protected final String TEXT_476 = ",valueMap_";
  protected final String TEXT_477 = ");";
  protected final String TEXT_478 = NL + "\t\tgroupbyList_";
  protected final String TEXT_479 = ".get(";
  protected final String TEXT_480 = ").add(";
  protected final String TEXT_481 = ");";
  protected final String TEXT_482 = NL + "        isNewElememt_";
  protected final String TEXT_483 = "=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_484 = ".size()<=";
  protected final String TEXT_485 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_486 = ".add(group";
  protected final String TEXT_487 = "__";
  protected final String TEXT_488 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_489 = ".set(";
  protected final String TEXT_490 = ",group";
  protected final String TEXT_491 = "__";
  protected final String TEXT_492 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_493 = "=groupElementList_";
  protected final String TEXT_494 = ".get(";
  protected final String TEXT_495 = ");" + NL + "\t}" + NL;
  protected final String TEXT_496 = NL + "\t// build loop xml tree";
  protected final String TEXT_497 = NL + "\t\t\torg.dom4j.Element loop_";
  protected final String TEXT_498 = "=advancedXMLUtil_";
  protected final String TEXT_499 = ".generateCodeDom4j_Loop(nestXMLTool_";
  protected final String TEXT_500 = ",valueMap_";
  protected final String TEXT_501 = ",subTreeRootParent_";
  protected final String TEXT_502 = ",orders_";
  protected final String TEXT_503 = ", bl_";
  protected final String TEXT_504 = ");";
  protected final String TEXT_505 = NL + "\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_506 = "=loop_";
  protected final String TEXT_507 = ";";
  protected final String TEXT_508 = NL + "    currentRowCount_";
  protected final String TEXT_509 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_510 = " == ";
  protected final String TEXT_511 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_512 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_513 = " = file_";
  protected final String TEXT_514 = " + currentFileCount_";
  protected final String TEXT_515 = " + suffix_";
  protected final String TEXT_516 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_517 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_518 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_519 = ".clear();" + NL + "" + NL + "    \tjava.io.FileOutputStream stream_";
  protected final String TEXT_520 = " = new java.io.FileOutputStream(fileName_";
  protected final String TEXT_521 = ");" + NL + "        org.dom4j.io.XMLWriter output_";
  protected final String TEXT_522 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_523 = ", format_";
  protected final String TEXT_524 = ");";
  protected final String TEXT_525 = NL + "\t\tdoc_";
  protected final String TEXT_526 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", file_";
  protected final String TEXT_527 = ".substring(file_";
  protected final String TEXT_528 = ".lastIndexOf(\"/\")+1)+\".xsd\");" + NL + "        doc_";
  protected final String TEXT_529 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_530 = "        " + NL + "        nestXMLTool_";
  protected final String TEXT_531 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_532 = ".getRootElement());";
  protected final String TEXT_533 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_534 = ".removeEmptyElement(doc_";
  protected final String TEXT_535 = ".getRootElement());";
  protected final String TEXT_536 = NL + "        output_";
  protected final String TEXT_537 = ".write(doc_";
  protected final String TEXT_538 = ");" + NL + "        output_";
  protected final String TEXT_539 = ".close();" + NL + "        doc_";
  protected final String TEXT_540 = "  = org.dom4j.DocumentHelper.createDocument();";
  protected final String TEXT_541 = NL + "\t\t\tdoc_";
  protected final String TEXT_542 = ".addDocType(";
  protected final String TEXT_543 = ", null, ";
  protected final String TEXT_544 = ");";
  protected final String TEXT_545 = NL + "\t\t\tdoc_";
  protected final String TEXT_546 = ".addProcessingInstruction(\"xml-stylesheet\", inMap_";
  protected final String TEXT_547 = ");";
  protected final String TEXT_548 = NL + "    \tgroupElementList_";
  protected final String TEXT_549 = ".clear();" + NL + "    }";
  protected final String TEXT_550 = NL + "\tStringBuffer buf_";
  protected final String TEXT_551 = " = new StringBuffer();" + NL + "\t//init value is 0 not -1, because it will output the root tab when all the row value is null." + NL + "\tint unNullMaxIndex_";
  protected final String TEXT_552 = " = 0;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_553 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_554 = "=false;";
  protected final String TEXT_555 = NL + "\t\t\tbuf_";
  protected final String TEXT_556 = "=advancedXMLUtil_";
  protected final String TEXT_557 = ".generateCodeNull_rootEmptySpace";
  protected final String TEXT_558 = "(buf_";
  protected final String TEXT_559 = ",out_";
  protected final String TEXT_560 = ",startTabs_";
  protected final String TEXT_561 = ",endTabs_";
  protected final String TEXT_562 = ",valueMap_";
  protected final String TEXT_563 = ");";
  protected final String TEXT_564 = NL + "\t\tif( false";
  protected final String TEXT_565 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_566 = ".generateCodeNull_conditMain";
  protected final String TEXT_567 = "_";
  protected final String TEXT_568 = "(valueMap_";
  protected final String TEXT_569 = ")";
  protected final String TEXT_570 = " || valueMap_";
  protected final String TEXT_571 = ".get(\"";
  protected final String TEXT_572 = "\") != null";
  protected final String TEXT_573 = NL + "\t\t){" + NL + "\t\t\tunNullMaxIndex_";
  protected final String TEXT_574 = " = ";
  protected final String TEXT_575 = ";" + NL + "\t\t}";
  protected final String TEXT_576 = NL + "\t\tendTabs_";
  protected final String TEXT_577 = "[";
  protected final String TEXT_578 = "] = buf_";
  protected final String TEXT_579 = ".toString();" + NL + "\t\tbuf_";
  protected final String TEXT_580 = " = new StringBuffer();";
  protected final String TEXT_581 = NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_582 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_583 = " = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_584 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_585 = " = new String[";
  protected final String TEXT_586 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_587 = " = new String[";
  protected final String TEXT_588 = "];";
  protected final String TEXT_589 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_590 = " or not" + NL + "\tif(isNewElememt_";
  protected final String TEXT_591 = " || groupbyList_";
  protected final String TEXT_592 = ".size()<=";
  protected final String TEXT_593 = " || groupbyList_";
  protected final String TEXT_594 = ".get(";
  protected final String TEXT_595 = ")==null";
  protected final String TEXT_596 = NL + "\t|| advancedXMLUtil_";
  protected final String TEXT_597 = ".getValue_";
  protected final String TEXT_598 = "_";
  protected final String TEXT_599 = "(groupbyList_";
  protected final String TEXT_600 = ",valueMap_";
  protected final String TEXT_601 = ")";
  protected final String TEXT_602 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_603 = ".get(";
  protected final String TEXT_604 = ").get(";
  protected final String TEXT_605 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_606 = ".get(";
  protected final String TEXT_607 = ").get(";
  protected final String TEXT_608 = ").equals(";
  protected final String TEXT_609 = ") " + NL + "\t\t: ";
  protected final String TEXT_610 = "!=null )";
  protected final String TEXT_611 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(isNewElememt_";
  protected final String TEXT_612 = " == false && groupbyList_";
  protected final String TEXT_613 = ".size()>";
  protected final String TEXT_614 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_615 = " = ";
  protected final String TEXT_616 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_617 = ".size()<=";
  protected final String TEXT_618 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_619 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_620 = ".get(";
  protected final String TEXT_621 = ").clear();" + NL + "        }";
  protected final String TEXT_622 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_623 = ".setValue_";
  protected final String TEXT_624 = "_";
  protected final String TEXT_625 = "(groupbyList_";
  protected final String TEXT_626 = ",valueMap_";
  protected final String TEXT_627 = ");";
  protected final String TEXT_628 = NL + "\t\tgroupbyList_";
  protected final String TEXT_629 = ".get(";
  protected final String TEXT_630 = ").add(";
  protected final String TEXT_631 = ");";
  protected final String TEXT_632 = NL + "        isNewElememt_";
  protected final String TEXT_633 = "=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_634 = NL + "\t\tbuf_";
  protected final String TEXT_635 = "=advancedXMLUtil_";
  protected final String TEXT_636 = ".generateCodeNull_emptySpace";
  protected final String TEXT_637 = "(buf_";
  protected final String TEXT_638 = ",valueMap_";
  protected final String TEXT_639 = ",groupBuffer_";
  protected final String TEXT_640 = ");";
  protected final String TEXT_641 = NL + "\tif( false";
  protected final String TEXT_642 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_643 = ".generateCodeNull_conditGroup";
  protected final String TEXT_644 = "_";
  protected final String TEXT_645 = "(valueMap_";
  protected final String TEXT_646 = ")";
  protected final String TEXT_647 = " || valueMap_";
  protected final String TEXT_648 = ".get(\"";
  protected final String TEXT_649 = "\") != null";
  protected final String TEXT_650 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_651 = " = ";
  protected final String TEXT_652 = ";" + NL + "\t}";
  protected final String TEXT_653 = NL + "\t// buffer the end tabs to groupEnd buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_654 = "[";
  protected final String TEXT_655 = "] = buf_";
  protected final String TEXT_656 = ".toString();" + NL + "    buf_";
  protected final String TEXT_657 = " = new StringBuffer();";
  protected final String TEXT_658 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_659 = " >= 0) {" + NL + "        //out_";
  protected final String TEXT_660 = ".newLine();//Track code";
  protected final String TEXT_661 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_662 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_663 = " = 0; i_";
  protected final String TEXT_664 = " < startTabs_";
  protected final String TEXT_665 = ".length; i_";
  protected final String TEXT_666 = "++) {" + NL + "                if (i_";
  protected final String TEXT_667 = " <= preUnNullMaxIndex_";
  protected final String TEXT_668 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_669 = "[i_";
  protected final String TEXT_670 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_671 = ".write(startTabs_";
  protected final String TEXT_672 = "[i_";
  protected final String TEXT_673 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_674 = "[i_";
  protected final String TEXT_675 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_676 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_677 = " = 0; i_";
  protected final String TEXT_678 = " < startTabs_";
  protected final String TEXT_679 = ".length; i_";
  protected final String TEXT_680 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_681 = "[i_";
  protected final String TEXT_682 = "] != null) {" + NL + "                out_";
  protected final String TEXT_683 = ".write(startTabs_";
  protected final String TEXT_684 = "[i_";
  protected final String TEXT_685 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_686 = "[i_";
  protected final String TEXT_687 = "] = null;" + NL + "        }";
  protected final String TEXT_688 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_689 = " >= preNewTabIndex_";
  protected final String TEXT_690 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_691 = " >= ";
  protected final String TEXT_692 = " + newTabIndex_";
  protected final String TEXT_693 = ") {" + NL + "            for (int i_";
  protected final String TEXT_694 = " = preUnNullMaxIndex_";
  protected final String TEXT_695 = "; i_";
  protected final String TEXT_696 = " >= ";
  protected final String TEXT_697 = " + newTabIndex_";
  protected final String TEXT_698 = "; i_";
  protected final String TEXT_699 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_700 = "[i_";
  protected final String TEXT_701 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_702 = ".write(endTabs_";
  protected final String TEXT_703 = "[i_";
  protected final String TEXT_704 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_705 = "[i_";
  protected final String TEXT_706 = "] = null;";
  protected final String TEXT_707 = "out_";
  protected final String TEXT_708 = ".newLine(); ";
  protected final String TEXT_709 = NL + "                out_";
  protected final String TEXT_710 = ".write(endTabStrs_";
  protected final String TEXT_711 = NL + "                        .get(i_";
  protected final String TEXT_712 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_713 = NL + "            for (int i_";
  protected final String TEXT_714 = " = preNewTabIndex_";
  protected final String TEXT_715 = " - 1; i_";
  protected final String TEXT_716 = " >= ";
  protected final String TEXT_717 = " + newTabIndex_";
  protected final String TEXT_718 = "; i_";
  protected final String TEXT_719 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_720 = "[i_";
  protected final String TEXT_721 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_722 = ".write(endTabs_";
  protected final String TEXT_723 = "[i_";
  protected final String TEXT_724 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_725 = "[i_";
  protected final String TEXT_726 = "] = null;" + NL + "            \t";
  protected final String TEXT_727 = "out_";
  protected final String TEXT_728 = ".newLine(); ";
  protected final String TEXT_729 = NL + "                out_";
  protected final String TEXT_730 = ".write(endTabStrs_";
  protected final String TEXT_731 = NL + "                        .get(i_";
  protected final String TEXT_732 = "));" + NL + "            }";
  protected final String TEXT_733 = NL + "        }";
  protected final String TEXT_734 = NL + "        preNewTabIndex_";
  protected final String TEXT_735 = " = newTabIndex_";
  protected final String TEXT_736 = " + ";
  protected final String TEXT_737 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_738 = " = 0; i_";
  protected final String TEXT_739 = " < groupBuffer_";
  protected final String TEXT_740 = ".length; i_";
  protected final String TEXT_741 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_742 = " >= preNewTabIndex_";
  protected final String TEXT_743 = " - ";
  protected final String TEXT_744 = ") {" + NL + "            startTabs_";
  protected final String TEXT_745 = "[i_";
  protected final String TEXT_746 = " + ";
  protected final String TEXT_747 = "] = groupBuffer_";
  protected final String TEXT_748 = "[i_";
  protected final String TEXT_749 = "];" + NL + "            endTabs_";
  protected final String TEXT_750 = "[i_";
  protected final String TEXT_751 = " + ";
  protected final String TEXT_752 = "] = groupEndBuffer_";
  protected final String TEXT_753 = "[i_";
  protected final String TEXT_754 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_755 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_756 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_757 = "=unNullMaxIndex_";
  protected final String TEXT_758 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_759 = ">";
  protected final String TEXT_760 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_761 = "=";
  protected final String TEXT_762 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_763 = NL + "\t// build loop xml tree";
  protected final String TEXT_764 = NL + "\t\tif( false";
  protected final String TEXT_765 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_766 = ".generateCodeNull_conditLoop_";
  protected final String TEXT_767 = "(valueMap_";
  protected final String TEXT_768 = ")";
  protected final String TEXT_769 = " || valueMap_";
  protected final String TEXT_770 = ".get(\"";
  protected final String TEXT_771 = "\") != null";
  protected final String TEXT_772 = " || true " + NL + "    \t";
  protected final String TEXT_773 = NL + "\t\t){";
  protected final String TEXT_774 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_775 = ".generateCodeNull_loopEmptySpace(buf_";
  protected final String TEXT_776 = ",out_";
  protected final String TEXT_777 = ",endTabs_";
  protected final String TEXT_778 = ",valueMap_";
  protected final String TEXT_779 = ");";
  protected final String TEXT_780 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_781 = " = 0; i_";
  protected final String TEXT_782 = " < startTabs_";
  protected final String TEXT_783 = ".length; i_";
  protected final String TEXT_784 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_785 = "[i_";
  protected final String TEXT_786 = "] != null && startTabs_";
  protected final String TEXT_787 = "[i_";
  protected final String TEXT_788 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_789 = ".write(startTabs_";
  protected final String TEXT_790 = "[i_";
  protected final String TEXT_791 = "]);" + NL + "                startTabs_";
  protected final String TEXT_792 = "[i_";
  protected final String TEXT_793 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_794 = ".write(buf_";
  protected final String TEXT_795 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_796 = " = ";
  protected final String TEXT_797 = ";";
  protected final String TEXT_798 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_799 = " = ";
  protected final String TEXT_800 = ";" + NL + "\t\t}";
  protected final String TEXT_801 = NL + "    currentRowCount_";
  protected final String TEXT_802 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_803 = " == ";
  protected final String TEXT_804 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_805 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_806 = " = file_";
  protected final String TEXT_807 = " + currentFileCount_";
  protected final String TEXT_808 = " + suffix_";
  protected final String TEXT_809 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_810 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_811 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_812 = ".clear();" + NL + " ";
  protected final String TEXT_813 = "   \t" + NL + "\tif (preUnNullMaxIndex_";
  protected final String TEXT_814 = " >= 0) {" + NL + "        // output all buffer" + NL + "        for (int j_";
  protected final String TEXT_815 = " = 0; j_";
  protected final String TEXT_816 = " <= preUnNullMaxIndex_";
  protected final String TEXT_817 = "; j_";
  protected final String TEXT_818 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_819 = "[j_";
  protected final String TEXT_820 = "] != null)" + NL + "                out_";
  protected final String TEXT_821 = ".write(startTabs_";
  protected final String TEXT_822 = "[j_";
  protected final String TEXT_823 = "]);" + NL + "        }" + NL + "" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_824 = " < preNewTabIndex_";
  protected final String TEXT_825 = " ) {" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_826 = " = preNewTabIndex_";
  protected final String TEXT_827 = " - 1; i_";
  protected final String TEXT_828 = " >= 0; i_";
  protected final String TEXT_829 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_830 = "[i_";
  protected final String TEXT_831 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_832 = ".write(endTabs_";
  protected final String TEXT_833 = "[i_";
  protected final String TEXT_834 = "]);" + NL + "            \t}";
  protected final String TEXT_835 = "out_";
  protected final String TEXT_836 = ".newLine(); ";
  protected final String TEXT_837 = NL + "                out_";
  protected final String TEXT_838 = ".write(endTabStrs_";
  protected final String TEXT_839 = ".get(i_";
  protected final String TEXT_840 = "));" + NL + "            }" + NL + "        } else {" + NL + "            for (int i_";
  protected final String TEXT_841 = " = preUnNullMaxIndex_";
  protected final String TEXT_842 = "; i_";
  protected final String TEXT_843 = " >= 0; i_";
  protected final String TEXT_844 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_845 = "[i_";
  protected final String TEXT_846 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_847 = ".write(endTabs_";
  protected final String TEXT_848 = "[i_";
  protected final String TEXT_849 = "]);" + NL + "            \t}";
  protected final String TEXT_850 = "out_";
  protected final String TEXT_851 = ".newLine(); ";
  protected final String TEXT_852 = NL + "                out_";
  protected final String TEXT_853 = ".write(endTabStrs_";
  protected final String TEXT_854 = ".get(i_";
  protected final String TEXT_855 = "));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_856 = NL + "\tfor (int i_";
  protected final String TEXT_857 = " = endTabStrs_";
  protected final String TEXT_858 = ".size() - 1; i_";
  protected final String TEXT_859 = " >= 0; i_";
  protected final String TEXT_860 = "--) {" + NL + "    \tif(endTabs_";
  protected final String TEXT_861 = "[i_";
  protected final String TEXT_862 = "]!=null){" + NL + "    \t\tout_";
  protected final String TEXT_863 = ".write(endTabs_";
  protected final String TEXT_864 = "[i_";
  protected final String TEXT_865 = "]);" + NL + "    \t}";
  protected final String TEXT_866 = "out_";
  protected final String TEXT_867 = ".newLine(); ";
  protected final String TEXT_868 = NL + "        out_";
  protected final String TEXT_869 = ".write(endTabStrs_";
  protected final String TEXT_870 = ".get(i_";
  protected final String TEXT_871 = "));" + NL + "    }";
  protected final String TEXT_872 = NL + "\t    preUnNullMaxIndex_";
  protected final String TEXT_873 = " = -1;" + NL + "        preNewTabIndex_";
  protected final String TEXT_874 = " = -1;" + NL + "    \tstartTabs_";
  protected final String TEXT_875 = " = new String[endTabStrs_";
  protected final String TEXT_876 = ".size()];" + NL + "    \tendTabs_";
  protected final String TEXT_877 = " = new String[endTabStrs_";
  protected final String TEXT_878 = ".size()];" + NL + "    \t" + NL + "\t\tout_";
  protected final String TEXT_879 = ".close();" + NL + "\t\tout_";
  protected final String TEXT_880 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_881 = " + currentFileCount_";
  protected final String TEXT_882 = " + suffix_";
  protected final String TEXT_883 = "), ";
  protected final String TEXT_884 = "));" + NL + "        out_";
  protected final String TEXT_885 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_886 = "+\"\\\"?>\");" + NL + "        out_";
  protected final String TEXT_887 = ".newLine();" + NL + "        ";
  protected final String TEXT_888 = NL + "    \t\tout_";
  protected final String TEXT_889 = ".write(\"<!DOCTYPE \"+";
  protected final String TEXT_890 = "+\" SYSTEM \\\"\" + ";
  protected final String TEXT_891 = " + \"\\\">\");" + NL + "    \t\tout_";
  protected final String TEXT_892 = ".newLine();";
  protected final String TEXT_893 = NL + "\t\t\tout_";
  protected final String TEXT_894 = ".write(\"<?xml-stylesheet type=\\\"\"+";
  protected final String TEXT_895 = "+\"\\\" href=\\\"\"+";
  protected final String TEXT_896 = "+\"\\\">\");" + NL + "\t\t\tout_";
  protected final String TEXT_897 = ".newLine();";
  protected final String TEXT_898 = NL + "\t}";
  protected final String TEXT_899 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public List<XMLNode> getNextSiblings(){
            List<XMLNode> result = new ArrayList<XMLNode>();
            if(parent!=null && parent.elements!=null){
                for(XMLNode tmpNode: parent.elements){
                    if(order < tmpNode.order){
                        result.add(tmpNode);
                    }
                }
            }
            return result;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
    }

    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }

    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_4);
    
	}

	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_5);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_12);
    
    		} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_17);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_24);
    
            }else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_28);
    
        }else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_32);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_33);
    
			}
		}

    stringBuffer.append(TEXT_34);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	boolean isAppend = false;
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_38);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(isAppend && !outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_63);
    
			}else{

    stringBuffer.append(TEXT_64);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_67);
    
			}
			if(isAppend){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    
				List<XMLNode> nextSiblings = node.getNextSiblings();

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
				if(nextSiblings.size() > 0) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
				}
				
				for(XMLNode sibling : nextSiblings) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sibling.name);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
				}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
			}else{

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
			}
		}else{
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_145);
    
			}else{

    stringBuffer.append(TEXT_146);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_151);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_156);
    tool.getValue(node); 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    tool.getValue(node);
    stringBuffer.append(TEXT_161);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
				}
			}else{
				if("id_Document".equals(node.relatedColumn.getTalendType())) {

    stringBuffer.append(TEXT_168);
    tool.getValue(node); 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    tool.getValue(node);
    stringBuffer.append(TEXT_173);
    
				} else {

    stringBuffer.append(TEXT_174);
    tool.getValue(node); 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    tool.getValue(node);
    stringBuffer.append(TEXT_179);
    
				}
				if(outputAsXSD){

    stringBuffer.append(TEXT_180);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_189);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_190);
    tool.getValue(node);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_194);
    tool.getValue(node);
    stringBuffer.append(TEXT_195);
     if (bAddEmptyAttr) { 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_199);
    }
		} else { 
		  if (node.defaultValue != null && !("").equals(node.defaultValue) ){
          
    stringBuffer.append(TEXT_200);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_204);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_205);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_208);
    
		  }
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_209);
    tool.getValue(node);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_213);
    tool.getValue(node);
    stringBuffer.append(TEXT_214);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_215);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    tool.getValue(node);
    stringBuffer.append(TEXT_220);
    
			}

    stringBuffer.append(TEXT_221);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_222);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_226);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_227);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_232);
    
			}
		}
	}
}

//----------** add by wliu dom4j to genenrate get function for node **-------//
class GenerateExprCmpByDom4j{
//	String cid = null;
	XMLTool tool = null;
	XMLNode groupNode = null;
	boolean needEmptyNode = true;
	public void generateCode(XMLNode node, String parentName){
		String tmpPath = node.path.replaceFirst(groupNode.path,"");
		String[] arrNames = tmpPath.split("/");
		if(node==groupNode){

    stringBuffer.append(TEXT_233);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_234);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_235);
    tool.getValue(node); 
    stringBuffer.append(TEXT_236);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_237);
    			}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_238);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_239);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_240);
    tool.getValue(node); 
    stringBuffer.append(TEXT_241);
    if(!needEmptyNode){
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_244);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_245);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_246);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_248);
    					}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_249);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_250);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_252);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_254);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_255);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_256);
    }

    stringBuffer.append(TEXT_257);
    
				}
			}
		}
		
		if(node.elements!=null){
			for(XMLNode child:node.elements){
				if(!child.isMainNode()){
					generateCode(child,parentName);
				}
			}
		}		
	}
	
	private void generateCmnExpr(String[] arrNames, String parentName){

    stringBuffer.append(TEXT_258);
    stringBuffer.append(parentName );
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){

    stringBuffer.append(TEXT_259);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_261);
    
		}
	}
}

// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	
	boolean isCompact = false;
	
	public void generateCode(XMLNode node, String emptySpace){	
		if(("ELEMENT").equals(node.type)){
			startElement(node,emptySpace);
			setText(node);
			XMLNode mainChild = null;
			for(XMLNode child:node.elements){
				if(child.isMainNode()){ //loop dosen't have a main child node
					mainChild = child;
					break;
				}
			}
			for(XMLNode child:node.elements){
				if(mainChild!=null && mainChild.order<=child.order){ //loop dosen't have a main child node
					if(1==(node.special & 1)){ // group

    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
						}else{

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty 
						&& (child.relatedColumn != null || child.childrenColumnList.size()>0
							 || child.hasDefaultValue == true ) ){

    stringBuffer.append(TEXT_276);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_279);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_281);
    
						if(isCompact==false)
							generateCode(child,emptySpace+"  ");
						else
							generateCode(child,emptySpace);

    stringBuffer.append(TEXT_282);
    
            		}else{
            			if(isCompact==false)
            				generateCode(child,emptySpace+"  ");
            			else
            				generateCode(child,emptySpace);
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_288);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_294);
    tool.getValue(node); 
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
		}

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_304);
    
		}else{

    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_307);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_308);
    tool.getValue(node);
    stringBuffer.append(TEXT_309);
    tool.getValue(node);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    tool.getValue(node);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    tool.getValue(node);
    stringBuffer.append(TEXT_314);
    
			}else{

    stringBuffer.append(TEXT_315);
    tool.getValue(node);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    tool.getValue(node);
    stringBuffer.append(TEXT_318);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_319);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_324);
    
		}
	}
	private void addAttribute(XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_325);
    tool.getValue(node); 
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_328);
    tool.getValue(node);
    stringBuffer.append(TEXT_329);
     if (bAddEmptyAttr){
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_332);
    }
		} else {
		  if (node.defaultValue != null && !("").equals(node.defaultValue)){
          
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_336);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_339);
    
		  }
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_340);
    tool.getValue(node);
    stringBuffer.append(TEXT_341);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    tool.getValue(node);
    stringBuffer.append(TEXT_344);
    
			}else{

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_347);
    tool.getValue(node);
    stringBuffer.append(TEXT_348);
    
			}

    stringBuffer.append(TEXT_349);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_352);
    
			}else{

    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_356);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

    stringBuffer.append(TEXT_357);
    
// ------------------- *** Common code start *** ------------------- //
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
            	List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                boolean bAddEmptyAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_EMPTY_ATTRIBUTE__"));
                boolean bAddUnmappedAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_UNMAPPED_ATTRIBUTE__"));
                
                String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
                
                String split = ElementParameterParser.getValue(node, "__SPLIT__");
                String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
				
        		boolean isMerge= ("true").equals(ElementParameterParser.getValue(node, "__MERGE__"));        		
        		boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));
        		
        		//*****************add for the feature:8873 to support output steam *****************
        		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
				String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
				//*******************add for feature:8873 end ****************
				
				boolean needFileValid = ("true").equals(ElementParameterParser.getValue(node, "__FILE_VALID__"));
				
				boolean needDTDValid = ("true").equals(ElementParameterParser.getValue(node, "__DTD_VALID__"));
				String dtdRootName = ElementParameterParser.getValue(node, "__DTD_NAME__");
        		String dtdFileName = ElementParameterParser.getValue(node, "__DTD_SYSTEMID__");
        		
        		boolean needXSLValid = ("true").equals(ElementParameterParser.getValue(node, "__XSL_VALID__"));
        		String xslType = ElementParameterParser.getValue(node, "__XSL_TYPE__");
				String xslHref = ElementParameterParser.getValue(node, "__XSL_HREF__");
				
				int schemaOptNum=100;
				boolean isOptimizeCode=false;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				} 
				if(metadata.getListColumns().size()> schemaOptNum){
					isOptimizeCode=true;
				}
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = NodeUtil.getPrivateConnClassName(conn);
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
				
				if(treeObjs == null || treeObjs.length == 0){
					return "";
				}
				
            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);                
            	XMLNode loop = (XMLNode)treeObjs[2];
                
                if(!("true").equals(allowEmpty)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }

    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
				int colNum=0;
				for(IMetadataColumn column :metadata.getListColumns()){
					if(isOptimizeCode){
						if(colNum%schemaOptNum==0){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(colNum/schemaOptNum);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
						}
					}else{

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_368);
     tool.getValue(column); 
    stringBuffer.append(TEXT_369);
    
					}
					colNum++;
				}
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
if(("Dom4j").equals(mode)){

	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
    if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
    	generateToolByDom4j.outputAsXSD = true;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByDom4j.allowEmpty = true;
    }
    generateToolByDom4j.bAddEmptyAttr = bAddEmptyAttr;
    generateToolByDom4j.bAddUnmappedAttr = bAddUnmappedAttr;
    generateToolByDom4j.cid = cid;
    generateToolByDom4j.tool = tool;
    
    //start generate code

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
     
	generateToolByDom4j.generateCode(root,"root","doc");
	if(!isMerge || useStream){ // add a prerequisite useStream to ignore the append mode

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
	}else{

    stringBuffer.append(TEXT_381);
    
	}
	
if(groupTable.size()>0){					//init the generate tool.
	if(!useStream && isMerge){//merge into the file and add a prerequisite:useStream to ignore the append mode
		generateToolByDom4j.isAppend= true;
	    String firstGroupPath = groupList.get(0).path;

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(firstGroupPath );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(firstGroupPath.substring(0,firstGroupPath.lastIndexOf("/")) );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(firstGroupPath.substring(0,firstGroupPath.lastIndexOf("/")) );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    
		for( int i=0; i<groupList.size();i++){
			XMLNode groupNode= groupList.get(i);
			GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
			generateExprCmpByDom4j.tool = tool;
			generateExprCmpByDom4j.groupNode = groupNode;
			generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(groupNode.path);
    stringBuffer.append(TEXT_402);
    
					if(isOptimizeCode){

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    
					}else{

    stringBuffer.append(TEXT_407);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_408);
    
					}

    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    
					if(isOptimizeCode){

    stringBuffer.append(TEXT_414);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    
						if(("ELEMENT").equals(groupList.get(i).type) && (0!=(groupList.get(i).special & 2))){

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    
						}
					}else{
						generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");
					}

    stringBuffer.append(TEXT_428);
    
 		}//for
 	}else{//last group code

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
     
		for(int i=0;i<groupList.size();i++){
			XMLNode groupRootNode = groupList.get(i);
			int nodeNum=0;

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_436);
     
			for(int j=0;j<groupbyNodeList.get(i).size();j++){
				XMLNode attr = groupbyNodeList.get(i).get(j);
				if(attr.relatedColumn!=null){
					if(isOptimizeCode){
						if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
						}
						nodeNum++;
					}else{

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_449);
    tool.getValue(attr);
    stringBuffer.append(TEXT_450);
    tool.getValue(attr);
    stringBuffer.append(TEXT_451);
     
					}
				}
			}

    stringBuffer.append(TEXT_452);
     
			if(isOptimizeCode){

    stringBuffer.append(TEXT_453);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    
				if(("ELEMENT").equals(groupRootNode.type) && (0!=(groupRootNode.special & 2))){

    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
				}
			}else{
				generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");
			}

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_471);
     
			for(int j=0;j<groupbyNodeList.get(i).size();j++){
				XMLNode attr = groupbyNodeList.get(i).get(j);
				if(isOptimizeCode){
					if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    
					}
				}else{

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_480);
    tool.getValue(attr);
    stringBuffer.append(TEXT_481);
     
				}
			}

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_495);
    
		}//for
 	}//if merge=true 	
}


    stringBuffer.append(TEXT_496);
    
	if(loopTable!=null && loopTable.size()>0){
		if(isOptimizeCode){

    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    if(!useStream && isMerge && groupTable.size()>0){
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_504);
    
				if(("ELEMENT").equals(loop.type) && (0!=(loop.special & 2))){

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    
				}
		}else{
		 	generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
		}
	}
	//file split
	if(!useStream && ("true").equals(split)){ //add a prerequisite:useStream to ignore the append mode

    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
		}

    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    
		if(!("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    
		}

    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    
		if (!isMerge && needFileValid) {
			if(needDTDValid) {

    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_544);
    
			} else if(needXSLValid) {

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    			
			}
		}

    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
else if(("Null").equals(mode)){

	//init the generate tool.
	GenerateToolByNull generateToolByNull = new GenerateToolByNull();
    if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
    	generateToolByNull.outputAsXSD = true;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByNull.allowEmpty = true;
    }
    generateToolByNull.bAddEmptyAttr = bAddEmptyAttr;
    generateToolByNull.bAddUnmappedAttr = bAddUnmappedAttr;
    generateToolByNull.cid = cid;
    generateToolByNull.tool = tool;
    generateToolByNull.isCompact = isCompact;

    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    
	String rootEmptySpace = "";
	for(int i=0;i < mainList.size();i++){
		if(isOptimizeCode){

    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    
		}else{
			generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		}
		if(isCompact==false){//generate pretty file
			rootEmptySpace+="  ";
		}
		
		if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
			if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){

    stringBuffer.append(TEXT_564);
    
					int columnNum=0;
                	for(IMetadataColumn column : mainList.get(i).childrenColumnList){
                		if(isOptimizeCode){
                			if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    
                			}
                			columnNum++;
                		}else{
                		
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_572);
    
                		}
                	}

    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_575);
    
			}
		}

    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    
	}

    stringBuffer.append(TEXT_581);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_588);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);
		int nodeNum=0;

    stringBuffer.append(TEXT_589);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_595);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){
				if(isOptimizeCode){
					if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
					}
					nodeNum++;
				}else{

    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_608);
    tool.getValue(attr);
    stringBuffer.append(TEXT_609);
    tool.getValue(attr);
    stringBuffer.append(TEXT_610);
    
				}
			}
		}

    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_621);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
				if(isOptimizeCode){
					if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    
					}
				}else{

    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_630);
    tool.getValue(attr);
    stringBuffer.append(TEXT_631);
    
				}
		}

    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    
		String emptySpace = "";
		
		if(isCompact==false){//generate pretty file
			for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
				emptySpace +="  ";
			}
		}
		if(isOptimizeCode){

    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    
		}else{
			generateToolByNull.generateCode(groupList.get(i),emptySpace);
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_641);
    
				int columnNum=0;
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
					if(isOptimizeCode){
            			if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    
            			}
                		columnNum++;
        			}else{
                		
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_649);
    
        			}
            	}

    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_652);
    
			}
		}

    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    
		}else{

    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    if(isCompact==false){
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    }
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    
		}

    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    if(isCompact==false){
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    }
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_733);
    
		}

    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_762);
    
	}

    stringBuffer.append(TEXT_763);
    
	String emptySpace = "";
	if(isCompact==false){//generate pretty file
		for(int len =loop.path.split("/").length-1;len>1;len--){
			emptySpace +="  ";
		}
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_764);
    
		int columnNum=0;
    	for(IMetadataColumn column : loop.childrenColumnList){
			if(isOptimizeCode){
            	if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    
            	}
                columnNum++;
        	}else{
                	
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_771);
    
        	}
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_772);
    }
    stringBuffer.append(TEXT_773);
    
	}
	if(isOptimizeCode){

    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    
	}else{
		generateToolByNull.generateCode(loop,emptySpace);
		generateToolByNull.endElement(loop,emptySpace);
	}

    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_797);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_800);
    
	}
	
	//file split 
	if(!useStream && ("true").equals(split)){ // add a new prerequisite:useStream to ignore the split condition

    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_803);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    if(isCompact==false){
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_836);
    }
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    if(isCompact==false){
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_851);
    }
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_855);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    if(isCompact==false){
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    }
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    
			}
		}

    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_883);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    
		if (needFileValid) {
			if (needDTDValid) {

    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_890);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_892);
    
			} else if (needXSLValid) {

    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_895);
    stringBuffer.append(xslHref);
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    			
			}
		}

    stringBuffer.append(TEXT_898);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_899);
    return stringBuffer.toString();
  }
}
