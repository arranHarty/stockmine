package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.mapper.MapperComponent;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.core.model.process.IConnection;
import org.talend.designer.mapper.language.ILanguage;
import org.talend.designer.mapper.language.generation.GenerationManagerFactory;
import org.talend.designer.mapper.language.generation.JavaGenerationManager;
import org.talend.designer.mapper.language.LanguageProvider;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;

public class TMapBeginJava {


  protected static String nl;
  public static synchronized TMapBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapBeginJava result = new TMapBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL;
  protected final String TEXT_4 = NL + "\tlog.info(\"";
  protected final String TEXT_5 = " - Start to work.\");" + NL + "\tStringBuffer log4jSb_";
  protected final String TEXT_6 = " = new StringBuffer();";
  protected final String TEXT_7 = NL + NL + "// ###############################" + NL + "// # Lookup's keys initialization";
  protected final String TEXT_8 = NL + NL + "\tInteger currentThreadNumber_";
  protected final String TEXT_9 = " = null;  " + NL + "\t";
  protected final String TEXT_10 = NL + "\t\tsynchronized (";
  protected final String TEXT_11 = ".this.globalMap) {" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\tsynchronized (";
  protected final String TEXT_13 = ".this.obj) {" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t" + NL + "\t\t\tcurrentThreadNumber_";
  protected final String TEXT_15 = " = (Integer) ";
  protected final String TEXT_16 = ".this.globalMap.get(\"currentThreadNumber_";
  protected final String TEXT_17 = "\");" + NL + "\t\t" + NL + "\t\t\tif(currentThreadNumber_";
  protected final String TEXT_18 = " == null) {" + NL + "\t\t\t\tcurrentThreadNumber_";
  protected final String TEXT_19 = " = 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tcurrentThreadNumber_";
  protected final String TEXT_20 = "++;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_21 = ".this.globalMap.put(\"currentThreadNumber_";
  protected final String TEXT_22 = "\", currentThreadNumber_";
  protected final String TEXT_23 = ");" + NL + "\t" + NL + "\t\t}";
  protected final String TEXT_24 = NL + NL + "\t\torg.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_25 = "LookupManager<";
  protected final String TEXT_26 = "Struct> tHash_Lookup_";
  protected final String TEXT_27 = " = " + NL + "\t\t\t(org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_28 = "LookupManager<";
  protected final String TEXT_29 = "Struct>) " + NL + "\t\t\t\t((org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_30 = "LookupManager<";
  protected final String TEXT_31 = "Struct>) " + NL + "\t\t\t\t\t globalMap.get( \"tHash_Lookup_";
  protected final String TEXT_32 = "\" ))" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t.clone()" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = ";" + NL + "\t";
  protected final String TEXT_35 = NL + "\t" + NL + "\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_36 = "Struct> tHash_Lookup_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "null;";
  protected final String TEXT_39 = "(org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_40 = "Struct>) " + NL + "\t\t\t\t((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_41 = "Struct>) " + NL + "\t\t\t\t\tglobalMap.get( \"tHash_Lookup_";
  protected final String TEXT_42 = "\" ))" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t.clone()" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t";
  protected final String TEXT_46 = NL + "\t" + NL + "\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_47 = "Struct> tHash_Lookup_Cache_";
  protected final String TEXT_48 = " = " + NL + "\t\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup." + NL + "\t\t\t\t<";
  protected final String TEXT_49 = "Struct>getLookup(org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.";
  protected final String TEXT_50 = ");" + NL + "\t" + NL + "\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_51 = "Struct> tHash_Lookup_Real_";
  protected final String TEXT_52 = " = null;" + NL + "\t" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\ttHash_Lookup_";
  protected final String TEXT_54 = ".initGet();" + NL + "\t";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = " ";
  protected final String TEXT_58 = "HashKey = new ";
  protected final String TEXT_59 = "();";
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = " ";
  protected final String TEXT_62 = "Default = new ";
  protected final String TEXT_63 = "();";
  protected final String TEXT_64 = NL + "// ###############################        " + NL + "" + NL + "// ###############################" + NL + "// # Vars initialization";
  protected final String TEXT_65 = NL + "class  ";
  protected final String TEXT_66 = "  {" + NL;
  protected final String TEXT_67 = "\t";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = ";" + NL;
  protected final String TEXT_70 = "}";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = " = new ";
  protected final String TEXT_74 = "();";
  protected final String TEXT_75 = NL + "// ###############################" + NL + "" + NL + "// ###############################" + NL + "// # Outputs initialization";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "_tmp = new ";
  protected final String TEXT_79 = "();";
  protected final String TEXT_80 = NL + "// ###############################" + NL;
  protected final String TEXT_81 = NL + "\t\tList<";
  protected final String TEXT_82 = "Struct> ";
  protected final String TEXT_83 = "_List = new java.util.ArrayList<";
  protected final String TEXT_84 = "Struct>();";
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = NL + "\t" + NL + "\t\tclass SortableRow_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = " implements Comparable<SortableRow_";
  protected final String TEXT_89 = "_";
  protected final String TEXT_90 = ">, routines.system.IPersistableRow<SortableRow_";
  protected final String TEXT_91 = "_";
  protected final String TEXT_92 = "> { // G_TM_B_001 " + NL + "" + NL + "\t\t\tboolean is__rejectedInnerJoin;" + NL + "" + NL + "\t\t";
  protected final String TEXT_93 = " exprKey_";
  protected final String TEXT_94 = "__";
  protected final String TEXT_95 = ";" + NL + "                            \t";
  protected final String TEXT_96 = NL + "\t\t\t//";
  protected final String TEXT_97 = NL + "\t\t\t";
  protected final String TEXT_98 = " ";
  protected final String TEXT_99 = "__";
  protected final String TEXT_100 = ";";
  protected final String TEXT_101 = NL + "\t\t" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t         public void fillFrom(";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = "Struct ";
  protected final String TEXT_104 = " ";
  protected final String TEXT_105 = " exprKey_";
  protected final String TEXT_106 = "__";
  protected final String TEXT_107 = ") {" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_108 = "this.";
  protected final String TEXT_109 = "__";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ";" + NL + "\t                \t\t";
  protected final String TEXT_113 = "this.exprKey_";
  protected final String TEXT_114 = "__";
  protected final String TEXT_115 = " = exprKey_";
  protected final String TEXT_116 = "__";
  protected final String TEXT_117 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "                }" + NL + "" + NL + "                public void copyDataTo(";
  protected final String TEXT_119 = "Struct ";
  protected final String TEXT_120 = ") {" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = this.";
  protected final String TEXT_123 = "__";
  protected final String TEXT_124 = ";" + NL + "\t                \t";
  protected final String TEXT_125 = NL + "                }" + NL + "" + NL + "\t\t" + NL + "    public String toString() {" + NL + "\t\t" + NL + "\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\tsb.append(super.toString());" + NL + "\t\tsb.append(\"[\");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_127 = "\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_129 = "__";
  protected final String TEXT_130 = "\");" + NL + "\t\t\t\t\t\tsb.append(\"=\");" + NL + "\t\t\t\t\t\tsb.append(String.valueOf(this.";
  protected final String TEXT_131 = "__";
  protected final String TEXT_132 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t    sb.append(\"]\");" + NL + "\t    " + NL + "\t    return sb.toString();" + NL + "    }" + NL + "" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t        public int compareTo(SortableRow_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = " other) {" + NL + "" + NL + "                    int returnValue = 0;" + NL + "                    ";
  protected final String TEXT_136 = NL + "                    " + NL + "                    \treturnValue = checkNullsAndCompare(this.exprKey_";
  protected final String TEXT_137 = "__";
  protected final String TEXT_138 = ", other.exprKey_";
  protected final String TEXT_139 = "__";
  protected final String TEXT_140 = ");" + NL + "                    \tif (returnValue != 0) {" + NL + "\t                        return returnValue;" + NL + "                    \t}" + NL + "                    ";
  protected final String TEXT_141 = NL + NL + "                    return returnValue;" + NL + "                }" + NL + "" + NL + "                private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "                    int returnValue = 0;" + NL + "                    if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "                        returnValue = ((Comparable) object1).compareTo(object2);" + NL + "                    } else if (object1 != null && object2 != null) {" + NL + "                        returnValue = compareStrings(object1.toString(), object2" + NL + "                                .toString());" + NL + "                    } else if (object1 == null && object2 != null) {" + NL + "                        returnValue = 1;" + NL + "                    } else if (object1 != null && object2 == null) {" + NL + "                        returnValue = -1;" + NL + "                    } else {" + NL + "                        returnValue = 0;" + NL + "                    }" + NL + "" + NL + "                    return returnValue;" + NL + "                }" + NL + "" + NL + "                private int compareStrings(String string1, String string2) {" + NL + "                    return string1.compareTo(string2);" + NL + "                }" + NL + "" + NL + "" + NL + "\t\t" + NL + "    public void readData(ObjectInputStream dis) {" + NL + "" + NL + "\t\tsynchronized(";
  protected final String TEXT_142 = "Struct.commonByteArrayLock_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = ") {" + NL + "" + NL + "\t        try {" + NL + "            " + NL + "\t\t\t\tint length = 0;" + NL + "\t\t\t" + NL + "\t\t\t\tthis.is__rejectedInnerJoin = dis.readBoolean();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t\t\t            this.";
  protected final String TEXT_146 = "__";
  protected final String TEXT_147 = " = dis.read";
  protected final String TEXT_148 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t            length = dis.readInt();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.";
  protected final String TEXT_150 = "__";
  protected final String TEXT_151 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t\t\tif(length > ";
  protected final String TEXT_152 = "Struct.commonByteArray_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ".length) {" + NL + "           \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_155 = "Struct.commonByteArray_";
  protected final String TEXT_156 = "_";
  protected final String TEXT_157 = ".length == 0) {" + NL + "\t               \t\t\t\t\t";
  protected final String TEXT_158 = "Struct.commonByteArray_";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = " = new byte[1024];" + NL + "           \t\t\t\t\t\t} else {" + NL + "\t               \t\t\t\t\t";
  protected final String TEXT_161 = "Struct.commonByteArray_";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = " = new byte[2 * length];" + NL + "\t               \t\t\t\t}" + NL + "           \t\t\t\t\t}" + NL + "               \t\t\t\tdis.readFully(";
  protected final String TEXT_164 = "Struct.commonByteArray_";
  protected final String TEXT_165 = "_";
  protected final String TEXT_166 = ", 0, length);" + NL + "               \t\t\t\tthis.";
  protected final String TEXT_167 = "__";
  protected final String TEXT_168 = " = new String(";
  protected final String TEXT_169 = "Struct.commonByteArray_";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ", 0, length);" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t            length = dis.readByte();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.";
  protected final String TEXT_173 = "__";
  protected final String TEXT_174 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t    \tthis.";
  protected final String TEXT_175 = "__";
  protected final String TEXT_176 = " = new Date(dis.readLong());" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t            length = dis.readInt();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.";
  protected final String TEXT_178 = "__";
  protected final String TEXT_179 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "               \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "               \t\t\t\tdis.readFully(byteArray);" + NL + "               \t\t\t\tthis.";
  protected final String TEXT_180 = "__";
  protected final String TEXT_181 = " = byteArray;" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\tthis.";
  protected final String TEXT_183 = "__";
  protected final String TEXT_184 = " = (";
  protected final String TEXT_185 = ") dis.readObject();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t            length = dis.readByte();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.";
  protected final String TEXT_187 = "__";
  protected final String TEXT_188 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t\t\tthis.";
  protected final String TEXT_189 = "__";
  protected final String TEXT_190 = " = dis.read";
  protected final String TEXT_191 = "();" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t            this.exprKey_";
  protected final String TEXT_193 = "__";
  protected final String TEXT_194 = " = dis.read";
  protected final String TEXT_195 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t            length = dis.readByte();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.exprKey_";
  protected final String TEXT_197 = "__";
  protected final String TEXT_198 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t    \tthis.exprKey_";
  protected final String TEXT_199 = "__";
  protected final String TEXT_200 = " = new Date(dis.readLong());" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t            length = dis.readInt();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.exprKey_";
  protected final String TEXT_202 = "__";
  protected final String TEXT_203 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t\t\tif(length > ";
  protected final String TEXT_204 = "Struct.commonByteArray_";
  protected final String TEXT_205 = "_";
  protected final String TEXT_206 = ".length) {" + NL + "           \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_207 = "Struct.commonByteArray_";
  protected final String TEXT_208 = "_";
  protected final String TEXT_209 = ".length == 0) {" + NL + "\t               \t\t\t\t\t";
  protected final String TEXT_210 = "Struct.commonByteArray_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = " = new byte[1024];" + NL + "           \t\t\t\t\t\t} else {" + NL + "\t               \t\t\t\t\t";
  protected final String TEXT_213 = "Struct.commonByteArray_";
  protected final String TEXT_214 = "_";
  protected final String TEXT_215 = " = new byte[2 * length];" + NL + "\t               \t\t\t\t}" + NL + "           \t\t\t\t\t}" + NL + "               \t\t\t\tdis.readFully(";
  protected final String TEXT_216 = "Struct.commonByteArray_";
  protected final String TEXT_217 = "_";
  protected final String TEXT_218 = ", 0, length);" + NL + "               \t\t\t\tthis.exprKey_";
  protected final String TEXT_219 = "__";
  protected final String TEXT_220 = " = new String(";
  protected final String TEXT_221 = "Struct.commonByteArray_";
  protected final String TEXT_222 = "_";
  protected final String TEXT_223 = ", 0, length);" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t            length = dis.readInt();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.exprKey_";
  protected final String TEXT_225 = "__";
  protected final String TEXT_226 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "               \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "               \t\t\t\tdis.readFully(byteArray);" + NL + "               \t\t\t\tthis.exprKey_";
  protected final String TEXT_227 = "__";
  protected final String TEXT_228 = " = byteArray;" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_229 = NL + "           \t\t\t\tthis.exprKey_";
  protected final String TEXT_230 = "__";
  protected final String TEXT_231 = " = (";
  protected final String TEXT_232 = ") dis.readObject();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t            length = dis.readByte();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tthis.exprKey_";
  protected final String TEXT_234 = "__";
  protected final String TEXT_235 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t\t\tthis.exprKey_";
  protected final String TEXT_236 = "__";
  protected final String TEXT_237 = " = dis.read";
  protected final String TEXT_238 = "();" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_239 = NL + "        \t} catch (IOException e) {" + NL + "        \t\t";
  protected final String TEXT_240 = NL + "        \t\t\tlog.fatal(\"";
  protected final String TEXT_241 = " - \" + e.getMessage());" + NL + "        \t\t";
  protected final String TEXT_242 = NL + "\t            throw new RuntimeException(e);";
  protected final String TEXT_243 = NL + NL + "\t\t";
  protected final String TEXT_244 = NL + "\t\t\t} catch(ClassNotFoundException eCNFE) {" + NL + "        \t\t";
  protected final String TEXT_245 = NL + "        \t\t\tlog.fatal(\"";
  protected final String TEXT_246 = " - \" + eCNFE.getMessage());" + NL + "        \t\t";
  protected final String TEXT_247 = NL + "\t\t\t\t throw new RuntimeException(eCNFE);" + NL + "\t\t";
  protected final String TEXT_248 = NL + NL + "        }" + NL + "        " + NL + "      } " + NL + "    }" + NL + "" + NL + "    public void writeData(ObjectOutputStream dos) {" + NL + "        try {" + NL + "" + NL + "           \tdos.writeBoolean(this.is__rejectedInnerJoin);" + NL + "" + NL + "\t\t";
  protected final String TEXT_249 = NL + "\t\t            \tdos.write";
  protected final String TEXT_250 = "(this.";
  protected final String TEXT_251 = "__";
  protected final String TEXT_252 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\tif(this.";
  protected final String TEXT_254 = "__";
  protected final String TEXT_255 = " == null) {" + NL + "\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t                byte[] byteArray = this.";
  protected final String TEXT_256 = "__";
  protected final String TEXT_257 = ".getBytes();" + NL + "           \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "               \t\t\t\tdos.write(byteArray);" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_258 = NL + "\t\t\t\t\t\tif(this.";
  protected final String TEXT_259 = "__";
  protected final String TEXT_260 = " == null) {" + NL + "\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "               \t\t\t\tdos.writeByte(0);" + NL + "           \t\t\t    \tdos.writeLong(this.";
  protected final String TEXT_261 = "__";
  protected final String TEXT_262 = ".getTime());" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_263 = NL + "\t\t\t\t\t\tif(this.";
  protected final String TEXT_264 = "__";
  protected final String TEXT_265 = " == null) {" + NL + "\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "           \t\t\t    \tdos.writeInt(this.";
  protected final String TEXT_266 = "__";
  protected final String TEXT_267 = ".length);" + NL + "               \t\t\t\tdos.write(this.";
  protected final String TEXT_268 = "__";
  protected final String TEXT_269 = ");" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_270 = NL + "       \t\t\t    \tdos.writeObject(this.";
  protected final String TEXT_271 = "__";
  protected final String TEXT_272 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\tif(this.";
  protected final String TEXT_274 = "__";
  protected final String TEXT_275 = " == null) {" + NL + "\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "               \t\t\t\tdos.writeByte(0);" + NL + "           \t\t\t    \tdos.write";
  protected final String TEXT_276 = "(this.";
  protected final String TEXT_277 = "__";
  protected final String TEXT_278 = ");" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_279 = NL + "\t\t            \tdos.write";
  protected final String TEXT_280 = "(this.exprKey_";
  protected final String TEXT_281 = "__";
  protected final String TEXT_282 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_284 = "__";
  protected final String TEXT_285 = " == null) {" + NL + "\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t                byte[] byteArray = this.exprKey_";
  protected final String TEXT_286 = "__";
  protected final String TEXT_287 = ".getBytes();" + NL + "           \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "               \t\t\t\tdos.write(byteArray);" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_289 = "__";
  protected final String TEXT_290 = " == null) {" + NL + "\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "               \t\t\t\tdos.writeByte(0);" + NL + "           \t\t\t    \tdos.writeLong(this.exprKey_";
  protected final String TEXT_291 = "__";
  protected final String TEXT_292 = ".getTime());" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_294 = "__";
  protected final String TEXT_295 = " == null) {" + NL + "\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "           \t\t\t    \tdos.writeInt(this.exprKey_";
  protected final String TEXT_296 = "__";
  protected final String TEXT_297 = ".length);" + NL + "               \t\t\t\tdos.write(this.exprKey_";
  protected final String TEXT_298 = "__";
  protected final String TEXT_299 = ");" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_300 = NL + "       \t\t\t    \tdos.writeObject(this.exprKey_";
  protected final String TEXT_301 = "__";
  protected final String TEXT_302 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_304 = "__";
  protected final String TEXT_305 = " == null) {" + NL + "\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t} else {" + NL + "               \t\t\t\tdos.writeByte(0);" + NL + "           \t\t\t    \tdos.write";
  protected final String TEXT_306 = "(this.exprKey_";
  protected final String TEXT_307 = "__";
  protected final String TEXT_308 = ");" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_309 = NL + "        \t} catch (IOException e) {" + NL + "        \t\t";
  protected final String TEXT_310 = NL + "        \t\t\tlog.fatal(\"";
  protected final String TEXT_311 = " - \" + e.getMessage());" + NL + "        \t\t";
  protected final String TEXT_312 = NL + "\t            throw new RuntimeException(e);";
  protected final String TEXT_313 = NL + "        }" + NL + "    }" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t} // G_TM_B_001" + NL + "\t" + NL + "\t";
  protected final String TEXT_314 = NL + "\t" + NL + "" + NL + "\torg.talend.designer.components.lookup.persistent.PersistentRowSorterIterator<SortableRow_";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = "> fsi_";
  protected final String TEXT_317 = "_";
  protected final String TEXT_318 = " = " + NL + "\t\tnew org.talend.designer.components.lookup.persistent.PersistentRowSorterIterator<SortableRow_";
  protected final String TEXT_319 = "_";
  protected final String TEXT_320 = ">(" + NL + "\t\t\t";
  protected final String TEXT_321 = " + \"/\"+ jobName +\"_tMapData_\" + pid +\"_";
  protected final String TEXT_322 = "_";
  protected final String TEXT_323 = "\", ";
  protected final String TEXT_324 = ") {" + NL + "\t\t\tpublic SortableRow_";
  protected final String TEXT_325 = "_";
  protected final String TEXT_326 = " createRowInstance() {" + NL + "\t\t\t\treturn new SortableRow_";
  protected final String TEXT_327 = "_";
  protected final String TEXT_328 = "();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t" + NL + "\tfsi_";
  protected final String TEXT_329 = "_";
  protected final String TEXT_330 = ".initPut();" + NL + "" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_331 = "        " + NL + "        " + NL + "" + NL + "" + NL + "" + NL + "        " + NL + NL + NL + NL + NL + NL + NL + NL;
  protected final String TEXT_332 = NL;

	public boolean hasConcurrencyContext(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterateForConcurrency(node, graphicalNodes);
			}
		}
		return false;
	
	}

	public boolean hasIterateConnectionBefore(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterate(node, graphicalNodes);
			}
		}
		return false;
	
	}
	
	public boolean recursiveSearchIterate(INode node, List<? extends INode> graphicalNodes) {
	
		//System.out.println(node);
	
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
				//System.out.println(connection.getName() + " connectionType=" + connectionType + " connection=" + String.valueOf(connection));
    	        return recursiveSearchIterate(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				//System.out.println("ITERATE return true");
    	        return true;
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterate(node, graphicalNodes);
				}
            }
		}
		
		//System.out.println("return false");
		return false;
	
	}

	public boolean recursiveSearchIterateForConcurrency(INode node, List<? extends INode> graphicalNodes) {
		//System.out.println(node);
	
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
				//System.out.println(connection.getName() + " connectionType=" + connectionType + " connection=" + String.valueOf(connection));
    	        return recursiveSearchIterateForConcurrency(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				//System.out.println("ITERATE return true");
				boolean parallelIterate = "true".equals(ElementParameterParser.getValue(connection, "__ENABLE_PARALLEL__"));
    	        return parallelIterate;
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterateForConcurrency(node, graphicalNodes);
				}
            }
		}
		
		//System.out.println("return false");
		return false;
	
	}

	public INode searchSubProcessStartNode(IConnection connection) {
       	INode source = connection.getSource();
    	//System.out.println(" source=" +  source);
    	INode subprocessStartNode = null;
    	if(source != null) {
			String searchedComponentName = source.getUniqueName();
        	//System.out.println(" searchedComponentName=" +  searchedComponentName);
			List<? extends INode> generatedNodes = source.getProcess().getGeneratingNodes();
			for(INode loopNode : generatedNodes) {
				if(loopNode.getUniqueName().equals(searchedComponentName)) {
					subprocessStartNode = loopNode.getSubProcessStartNode(false);
		        	//System.out.println(" subprocessStartNode=" +  subprocessStartNode.getUniqueName());
				}
			}
		}
	
		return subprocessStartNode;
	}
    public boolean hasJoinedTable(String tableNameToTest, ExternalMapperData data) {
        for (ExternalMapperTable table : data.getOutputTables()) {
            if (table.getIsJoinTableOf() != null && table.getIsJoinTableOf().equals(tableNameToTest)) {
                return true;
            }
        }
        return false;
    }
    
    
  public boolean isErrorReject(ExternalMapperTable table){
        String errorMessage = null;
        String errorStackTrace = null; 
        if(table!=null&&table.getName()!=null&&table.getName().endsWith("ErrorReject")){
            for(ExternalMapperTableEntry entry:table.getMetadataTableEntries()){
                if("errorMessage".equals(entry.getName())){
                    errorMessage = entry.getName();
                }else if("errorStackTrace".equals(entry.getName())){
                    errorStackTrace = entry.getName();
                }
            }
            if(errorMessage!=null&&errorStackTrace!=null){
                return true;
            }
        }
        return false;
    }



    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    

//org.talend.core.model.utils.NodeUtil


	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	boolean stats = codeGenArgument.isStatistics();
	
	String componentName = node.getUniqueName();
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ExternalMapperData data = (ExternalMapperData) node.getExternalData();
        List<ExternalMapperTable> varsTables = data.getVarsTables();
        ILanguage currentLanguage = LanguageProvider.getJavaLanguage();
        JavaGenerationManager gm = (JavaGenerationManager) GenerationManagerFactory.getInstance().getGenerationManager(currentLanguage);

		String tempFolder = ElementParameterParser.getValue(node, "__TEMPORARY_DATA_DIRECTORY__");
		if (("").equals(tempFolder)) {
			tempFolder=ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_FILE_DIR__") + "/temp";
			tempFolder=TalendTextUtils.addQuotes(tempFolder);
		}
		String rowsBufferSize = ElementParameterParser.getValue(node, "__ROWS_BUFFER_SIZE__");
		
		
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		

    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(componentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(componentName);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    

List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();

boolean hasConcurrencyContext = false;
boolean isVirtualIn = componentName.endsWith("TMAP_IN");
boolean isVirtualOut = componentName.endsWith("TMAP_OUT");

String uniqueNameComponent = componentName.replaceAll("_TMAP_IN", "");
uniqueNameComponent = uniqueNameComponent.replaceAll("_TMAP_OUT", "");

if(isVirtualIn) {
	List<IConnection> localInputConnections = inputConnections;
	String searchedComponentName = componentName.replaceAll("TMAP_IN", "TMAP_OUT");
	List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
	for(INode loopNode : generatedNodes) {
		if(loopNode.getUniqueName().equals(searchedComponentName)) {
			localInputConnections = (List<IConnection>) loopNode.getIncomingConnections();
			break;
		}
	}
	hasConcurrencyContext = hasConcurrencyContext(localInputConnections, node.getProcess().getGraphicalNodes());
} else {
	hasConcurrencyContext = hasConcurrencyContext(inputConnections, node.getProcess().getGraphicalNodes());
}

if(hasConcurrencyContext && !isVirtualIn) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_9);
    
	// if codeGenArgument.getIsRunInMultiThread() is true, the job.this.globalMap will wrapped with synchronizedMap, use synchronized(job.this.globalMap)
	// when codeGenArgument.getIsRunInMultiThread() is false, the job.this.globalMap is HashMap, use synchronized(job.this.object) when do the job.this.globalMap.put() operation(tMap,tIterateToFlow).
	if(codeGenArgument.getIsRunInMultiThread()){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_11);
    }else{
    stringBuffer.append(TEXT_12);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( uniqueNameComponent );
    stringBuffer.append(TEXT_23);
    
}

HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
for (IConnection connection : inputConnections) {
    hNameToConnection.put(connection.getName(), connection);
}

List<ExternalMapperTable> inputTablesWithInvalid = new ArrayList<ExternalMapperTable>(data.getInputTables());

List<ExternalMapperTable> inputTables = new ArrayList<ExternalMapperTable>();
for(int i=0; i < inputTablesWithInvalid.size(); i++) {
	ExternalMapperTable currentLoopTable = inputTablesWithInvalid.get(i);
	if(hNameToConnection.get(currentLoopTable.getName()) != null) {
		inputTables.add(currentLoopTable);
	}
}

int lstSizeInputs = inputTables.size();
for (int i = 1; i < lstSizeInputs; i++) {
    ExternalMapperTable inputTable = (ExternalMapperTable) inputTables.get(i);
    String tableName = inputTable.getName();
    List<ExternalMapperTableEntry> tableEntries = inputTable.getMetadataTableEntries();
    if (tableEntries == null) {
        continue;
    }
    String className = tableName + "Struct";
    
    boolean isAllRows = "ALL_ROWS".equals(inputTable.getMatchingMode());
    
	String lookupMode = inputTable.getLookupMode();
	boolean isReloadLookupMode = org.talend.designer.mapper.model.table.LOOKUP_MODE.RELOAD.name().equals(lookupMode);
	boolean isCacheOrReloadLookupMode = org.talend.designer.mapper.model.table.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(lookupMode);
	boolean isOneOfReloadLookupMode = isReloadLookupMode || isCacheOrReloadLookupMode;
    
    if(inputTable.isPersistent()) {

		
    stringBuffer.append(TEXT_24);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_32);
    
					if(hasConcurrencyContext) {
					
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	
	} else {
	
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_37);
    
		
		if(isOneOfReloadLookupMode) {
			 
    stringBuffer.append(TEXT_38);
    
		} else {
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_42);
    
					if(hasConcurrencyContext) {
					
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    
		}
					
	
    stringBuffer.append(TEXT_45);
    
	}

	String matchingModeStr = inputTable.getMatchingMode();
	
	if(isCacheOrReloadLookupMode) {
	
    stringBuffer.append(TEXT_46);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( matchingModeStr );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_52);
    }

	if(isAllRows && !isOneOfReloadLookupMode) {
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_54);
    
}





    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_63);
    
        }

    stringBuffer.append(TEXT_64);
    

        /////////////////////////////////////////////////////////////////////////
        gm.setVarsTables(varsTables);

        List<ExternalMapperTable> varTablesList = new ArrayList<ExternalMapperTable>(varsTables);

        // constants
        for (ExternalMapperTable table : varTablesList) {
            List<ExternalMapperTableEntry> tableEntries = table.getMetadataTableEntries();
            if (tableEntries == null) {
                continue;
            }
            String tableName = table.getName();
            
            String instanceVarName = tableName + "__" + node.getUniqueName();
            String className = instanceVarName + "__Struct";
            

    stringBuffer.append(TEXT_65);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_66);
    
            int lstSize = tableEntries.size();
            for (int i = 0; i < lstSize; i++) {
                ExternalMapperTableEntry varTableEntry = (ExternalMapperTableEntry) tableEntries.get(i);
                String javaType = varTableEntry.getType();


    stringBuffer.append(TEXT_67);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(javaType, varTableEntry.isNullable()) );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( varTableEntry.getName() );
    stringBuffer.append(TEXT_69);
    
            }

    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( instanceVarName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_74);
    
        }

    stringBuffer.append(TEXT_75);
    

		  List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
		  Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection connection : outputConnections) {
		  		nameToOutputConnection.put(connection.getName(), connection);
		  }

        List<ExternalMapperTable> outputTablesList = new ArrayList<ExternalMapperTable>(data.getOutputTables());
        // constants
        for (ExternalMapperTable table : outputTablesList) {
        
            List<ExternalMapperTableEntry> tableEntries = table.getMetadataTableEntries();
            if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
                continue;
            }
            String tableName = table.getName();
            
            String instanceVarName = tableName + "__" + node.getUniqueName();
            String className = tableName + "Struct";
            

    stringBuffer.append(TEXT_76);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_79);
    
        }

    stringBuffer.append(TEXT_80);
    
        for (ExternalMapperTable table : data.getOutputTables()) {
            if (hasJoinedTable(table.getName(),data)&&nameToOutputConnection.get(table.getName())!=null) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append( table.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append( table.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append( table.getName());
    stringBuffer.append(TEXT_84);
    
            }
        }


    stringBuffer.append(TEXT_85);
    

HashMap<String, ExternalMapperTableEntry> hExternalInputTableEntries = new HashMap<String, ExternalMapperTableEntry>();

int currentJoinedTableIndex = 0;

int sizeInputTables = inputTables.size();
        
List<IConnection> cumulatedInputConnections = new ArrayList<IConnection>();

String comma;
for (int iInputTable = 0; iInputTable < sizeInputTables - 1; iInputTable++) { // T_TM_B_101
        
	ExternalMapperTable currentInputTable = inputTables.get(iInputTable);
	ExternalMapperTable nextInputTable = null; 
	
	if(sizeInputTables > 1) {
		nextInputTable = inputTables.get(iInputTable + 1);
	}
	
	currentJoinedTableIndex++;

	String currentTableName = currentInputTable.getName();
    IConnection currentConection = hNameToConnection.get(currentTableName);
    if (currentConection == null) {
        continue;
    }
	
	
    cumulatedInputConnections.add(currentConection);
	
	if(nextInputTable != null && nextInputTable.isPersistent()) { // T_TM_B_103
	
		List<IMetadataColumn> nextColumnsKeys = new ArrayList<IMetadataColumn>();

	        String nextTableName = nextInputTable.getName();
            IConnection nextConection = hNameToConnection.get(nextTableName);
            if (nextConection == null) {
                continue;
            }
	
		
    stringBuffer.append(TEXT_86);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_92);
    
	        
	        
                IMetadataTable nextMetadataTable = nextConection.getMetadataTable();
                if (nextInputTable != null) {
                    hExternalInputTableEntries.clear();
                    List<ExternalMapperTableEntry> metadataTableEntries = nextInputTable.getMetadataTableEntries();
                    if (metadataTableEntries == null) {
                        continue;
                    }
                    for (ExternalMapperTableEntry nextInputTableEntry : metadataTableEntries) {
                        hExternalInputTableEntries.put(nextInputTableEntry.getName(), nextInputTableEntry);
                    }
                    List<IMetadataColumn> listColumns = nextMetadataTable.getListColumns();
                    for (IMetadataColumn column : listColumns) {
                        String columnName = column.getLabel();
                        ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
                        if (externalInputTableEntry != null) {
                            String expressionKey = externalInputTableEntry.getExpression();
                            if (expressionKey != null && !"".equals(expressionKey.trim())) {
                            
                            	nextColumnsKeys.add(column);
                            
                            	
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    
 		                           
                            }
                        }
                    }
				}
			
			
			// properties declarations 
			
    stringBuffer.append(TEXT_96);
    stringBuffer.append( currentInputTable.getName() );
    stringBuffer.append(TEXT_97);
    
			
        
                IMetadataTable currentMetadataTable = currentConection.getMetadataTable();
                if (currentInputTable != null) {

					for(IConnection connection : cumulatedInputConnections) {
                    	IMetadataTable joinedTable = connection.getMetadataTable();
	                    List<IMetadataColumn> listColumns = joinedTable.getListColumns();
                    	for (IMetadataColumn column : listColumns) {
	                        String columnName = column.getLabel();
                            
                            
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
						}
                    }

                    hExternalInputTableEntries.clear();
                    List<ExternalMapperTableEntry> metadataTableEntries = currentInputTable.getMetadataTableEntries();
                    if (metadataTableEntries == null) {
                        continue;
                    }
                    for (ExternalMapperTableEntry currentInputTableEntry : metadataTableEntries) {
                        hExternalInputTableEntries.put(currentInputTableEntry.getName(), currentInputTableEntry);
                    }

				}
				
		
    stringBuffer.append(TEXT_101);
    
		         
			        comma = "";
		         	for(IConnection connection : cumulatedInputConnections) {
		         	
		         		IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
		         	
			        	
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_102);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( connection.getName() );
    
		         		comma = ", ";
		         	}
                    int sizeNextColumns = nextColumnsKeys.size();
                    for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_B_105
                    	IMetadataColumn column = nextColumnsKeys.get(iColumn);

		         		
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    
                    
                    } // T_TM_B_105
                    
		         
    stringBuffer.append(TEXT_107);
    
		        	for(IConnection connection : cumulatedInputConnections) {
		        	
		        		IMetadataTable table = connection.getMetadataTable();
						List<IMetadataColumn> listColumns = table.getListColumns();
                    	for (IMetadataColumn column : listColumns) {
							
    stringBuffer.append(TEXT_108);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_112);
    
                		}
                	}
                	
    
                    sizeNextColumns = nextColumnsKeys.size();
                    for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_B_104
                    	IMetadataColumn column = nextColumnsKeys.get(iColumn);

						
    stringBuffer.append(TEXT_113);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    
                    
                    } // T_TM_B_104
                    
    stringBuffer.append(TEXT_118);
    
		         
		         comma = "";
		         for(IConnection connection : cumulatedInputConnections) {

		            IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);

			         
    stringBuffer.append(comma);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( connection.getName() );
    
		         	comma = ", ";
		         }
		         
    stringBuffer.append(TEXT_120);
    
		        	for(IConnection connection : cumulatedInputConnections) {
		        	
		        		IMetadataTable table = connection.getMetadataTable();
						List<IMetadataColumn> listColumns = table.getListColumns();
                    	for (IMetadataColumn column : listColumns) {
						
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_124);
    
                		}
                	}
                	
    stringBuffer.append(TEXT_125);
    	
		comma = "";
       	for(IConnection connection : cumulatedInputConnections) {
		        	
       		IMetadataTable metadata = connection.getMetadataTable();
			if (metadata !=null) {
				for (IMetadataColumn column: metadata.getListColumns()) {
						if(comma.length() > 0) {
						
    stringBuffer.append(TEXT_126);
    stringBuffer.append( comma );
    stringBuffer.append(TEXT_127);
    
						}
						
    stringBuffer.append(TEXT_128);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_132);
    
					comma = ", ";
				}
    		}
    	}
	    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_135);
    
                    sizeNextColumns = nextColumnsKeys.size();
                    for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_B_102
                    	IMetadataColumn column = nextColumnsKeys.get(iColumn);
                    
    stringBuffer.append(TEXT_136);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    
                    } // T_TM_B_102
                    
    stringBuffer.append(TEXT_141);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_144);
    	
		boolean hasAtLeastOneRead = false;
		boolean hasAtLeastOneObjectType = false;
		if (currentMetadataTable !=null) {
		
		        	for(IConnection connection : cumulatedInputConnections) {
		        	
		        	
		        	
		        		IMetadataTable table = connection.getMetadataTable();
						List<IMetadataColumn> listColumns = table.getListColumns();
                    	for (IMetadataColumn column : listColumns) {
			  	hasAtLeastOneRead = true;
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			 	
				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_145);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_148);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_149);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_171);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_172);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_176);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_181);
    
				} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
			 		hasAtLeastOneObjectType = true;
					
    stringBuffer.append(TEXT_182);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_185);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_186);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_191);
    
				}


                		}
                	}
                	
    
                    sizeNextColumns = nextColumnsKeys.size();
                    for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_B_104
                    	IMetadataColumn column = nextColumnsKeys.get(iColumn);

			  	hasAtLeastOneRead = true;
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_192);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_195);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_196);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_200);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_201);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_223);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_224);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_228);
    
				} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
			 		hasAtLeastOneObjectType = true;
					
    stringBuffer.append(TEXT_229);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_232);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_233);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_238);
    
				}
                    
                    } // T_TM_B_104
		
		
		



    	}
	    if(hasAtLeastOneRead) {
	    
    stringBuffer.append(TEXT_239);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(componentName);
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    
        }
        
    stringBuffer.append(TEXT_243);
    
		if(hasAtLeastOneObjectType) {
		
    stringBuffer.append(TEXT_244);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_245);
    stringBuffer.append(componentName);
    stringBuffer.append(TEXT_246);
    }
    stringBuffer.append(TEXT_247);
    
		}
		
    stringBuffer.append(TEXT_248);
    	
		boolean hasAtLeastOneWrite = false;
		if (currentMetadataTable !=null) {
			
			
		        	for(IConnection connection : cumulatedInputConnections) {
		        	
		        		IMetadataTable table = connection.getMetadataTable();
						List<IMetadataColumn> listColumns = table.getListColumns();
                    	for (IMetadataColumn column : listColumns) {
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				hasAtLeastOneWrite = true;
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_249);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_252);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_253);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_256);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_257);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_258);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_261);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_262);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_263);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_269);
    
				} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_270);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_272);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_273);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_275);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_276);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_278);
    
				
				}
                		}
                	}
                	
    
                    sizeNextColumns = nextColumnsKeys.size();
                    for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_B_104
                    	IMetadataColumn column = nextColumnsKeys.get(iColumn);

				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				hasAtLeastOneWrite = true;
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_279);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_280);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_282);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_283);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_285);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_286);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_287);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_288);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_289);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_290);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_292);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_293);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_295);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_296);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_299);
    
				} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_300);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_302);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_303);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_304);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_306);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_307);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_308);
    
				
				}
                    
                    } // T_TM_B_104
			
			


    	}
	    if(hasAtLeastOneWrite) {
	    
    stringBuffer.append(TEXT_309);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_310);
    stringBuffer.append(componentName);
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    
        }
        
    stringBuffer.append(TEXT_313);
    
	String threadInsertedString = "thread\" + currentThreadNumber_" + uniqueNameComponent + " + \""; 
	
    stringBuffer.append(TEXT_314);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_320);
    stringBuffer.append( tempFolder );
    stringBuffer.append(TEXT_321);
    stringBuffer.append( hasConcurrencyContext ? threadInsertedString + "_" : "" );
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_323);
    stringBuffer.append( rowsBufferSize );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_330);
    
	} // T_TM_B_103
} // T_TM_B_101      


    stringBuffer.append(TEXT_331);
    stringBuffer.append(TEXT_332);
    return stringBuffer.toString();
  }
}