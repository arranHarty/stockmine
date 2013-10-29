package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
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
  protected final String TEXT_26 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_27 = ".putValue_";
  protected final String TEXT_28 = "(";
  protected final String TEXT_29 = ",writableSheet_";
  protected final String TEXT_30 = "," + NL + "\t\t\t\t\tstartRowNum_";
  protected final String TEXT_31 = ",nb_line_";
  protected final String TEXT_32 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = "format_";
  protected final String TEXT_34 = "null";
  protected final String TEXT_35 = ",fitWidth_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\t\t\t";
  protected final String TEXT_38 = "\t\t\t\t";
  protected final String TEXT_39 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = " = writableSheet_";
  protected final String TEXT_48 = ".getWritableCell(";
  protected final String TEXT_49 = " + ";
  protected final String TEXT_50 = ", startRowNum_";
  protected final String TEXT_51 = " + nb_line_";
  protected final String TEXT_52 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = " = new jxl.write.";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = " + ";
  protected final String TEXT_58 = ", startRowNum_";
  protected final String TEXT_59 = " + nb_line_";
  protected final String TEXT_60 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = " = new jxl.write.";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = ", startRowNum_";
  protected final String TEXT_66 = " + nb_line_";
  protected final String TEXT_67 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "//modif end";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ", cell_format_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ")";
  protected final String TEXT_76 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ".toString()";
  protected final String TEXT_79 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ")).toString()";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_84 = "), ";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "), ";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_92 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_93 = ").doubleValue()";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = ".setCellFormat( existingCell_";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_105 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_106 = ".addCell(cell_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = "=currentWith_";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = ">10?10:currentWith_";
  protected final String TEXT_118 = "_";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = " = cell_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ".getContents().trim().length();";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "]=fitWidth_";
  protected final String TEXT_128 = "[";
  protected final String TEXT_129 = "]>currentWith_";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = "?fitWidth_";
  protected final String TEXT_132 = "[";
  protected final String TEXT_133 = "]:currentWith_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = "+2;";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = "=";
  protected final String TEXT_139 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_140 = "[";
  protected final String TEXT_141 = "]=fitWidth_";
  protected final String TEXT_142 = "[";
  protected final String TEXT_143 = "]>currentWith_";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = "?fitWidth_";
  protected final String TEXT_146 = "[";
  protected final String TEXT_147 = "]:currentWith_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = "+2;";
  protected final String TEXT_150 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t                log4jSb_";
  protected final String TEXT_153 = ".append(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ");" + NL + "\t                ";
  protected final String TEXT_156 = NL + "\t                \tlog4jSb_";
  protected final String TEXT_157 = ".append(\"|\");" + NL + "\t                ";
  protected final String TEXT_158 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_159 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_161 = ".addRow();";
  protected final String TEXT_162 = NL + "   \t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_163 = ".putValue_";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = ",xlsxTool_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\t\t\t";
  protected final String TEXT_168 = "\t\t\t\t\t";
  protected final String TEXT_169 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_173 = ".addCellValue(";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ", ";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_178 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = ")).toString());";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_183 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_184 = "), ";
  protected final String TEXT_185 = ", ";
  protected final String TEXT_186 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_188 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = "), ";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_193 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_194 = ".addCellValue((";
  protected final String TEXT_195 = ").doubleValue());";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_197 = ".addCellValue(";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_201 = ".addCellValue(";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_205 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = ")));";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_209 = ".addCellValue(String.valueOf(";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = "));";
  protected final String TEXT_212 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_213 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t";
  protected final String TEXT_215 = NL + "\t                log4jSb_";
  protected final String TEXT_216 = ".append(";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ");" + NL + "\t                ";
  protected final String TEXT_219 = NL + "\t                \tlog4jSb_";
  protected final String TEXT_220 = ".append(\"|\");" + NL + "\t                ";
  protected final String TEXT_221 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_222 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\tbufferCount_";
  protected final String TEXT_224 = "++;" + NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_225 = " >= flushRowNum_";
  protected final String TEXT_226 = "){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_227 = ".flushRowInMemory();" + NL + "    \t\t\t\t\tbufferCount_";
  protected final String TEXT_228 = "=0;" + NL + "    \t\t\t\t}";

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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
String font = ElementParameterParser.getValue(node, "__FONT__"); 
//modif start
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
//modif end
boolean keepCellFormating =  ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__").equals("true");
boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		if(!version07){//version judgement
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
    					}
    					continue;
    				}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    
    				} 
    				
    stringBuffer.append(TEXT_42);
    
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
   				
    stringBuffer.append(TEXT_43);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_44);
    if(keepCellFormating){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    }else{
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_75);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_82);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_86);
     } else { 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_91);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_93);
    
					}else {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_97);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
							}
							
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
					if(isNumber){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
					}else{

    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
					}else{

    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_150);
    
    				} 
    			
    stringBuffer.append(TEXT_151);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    if(i < sizeColumns-1){
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    }
				}
    
				}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    log4jFileUtil.debugWriteData(node);
    
    		}
    	}
    	}else{ //version judgement /***excel 2007 xlsx*****/

		List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
    					}
    					continue;
	        		}

    stringBuffer.append(TEXT_167);
    stringBuffer.append(TEXT_168);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_169);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_176);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_180);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_181);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_186);
     } else { 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_192);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_195);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_207);
    
					}else{	

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
    				} 
    				
    stringBuffer.append(TEXT_214);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    if(i < sizeColumns-1){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    }
				}
    
    			}
    			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    log4jFileUtil.debugWriteData(node);
    
				if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
				}
    		}
    	}

    	}
    }
}

    return stringBuffer.toString();
  }
}
