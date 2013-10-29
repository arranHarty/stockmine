package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TAggregateInMainJava
{
  protected static String nl;
  public static synchronized TAggregateInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateInMainJava result = new TAggregateInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            \t\t\t\t    ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = aggregated_row_";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";" + NL + "            \t\t\t\t    ";
  protected final String TEXT_7 = NL + "            \t\t\t\t    String s_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ");" + NL + "            \t\t\t\t    ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "s_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = "s_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ".getBytes()";
  protected final String TEXT_22 = "(\"null\").equals(s_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = ") ? null : ParserUtils.parseTo_Date(s_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ")";
  protected final String TEXT_30 = "ParserUtils.parseTo_";
  protected final String TEXT_31 = "(s_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = ";" + NL + "            \t\t\t\t    ";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_37 = " - Group colum value is : \" + ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_40 = ".delete(0,log4jSb_";
  protected final String TEXT_41 = ".length());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "                                if(aggregated_row_";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = "_count > 0){" + NL + "                                \t";
  protected final String TEXT_45 = NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = aggregated_row_";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = "_sum.divide(new BigDecimal(String.valueOf(aggregated_row_";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = "_count)), ";
  protected final String TEXT_52 = ", BigDecimal.ROUND_HALF_UP)" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t    \t\t\t\t\t\t\t\t\t.";
  protected final String TEXT_54 = "Value()" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t    \t\t\t\t\t\t\t\t;" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t    \t\t\t\t\t\t\t\tdouble ";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = "_temp = (double) aggregated_row_";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = "_sum / (double) aggregated_row_";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = "_count;" + NL + "\t    \t\t\t\t\t\t\t\t" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = String.valueOf(";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = "_temp);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = (";
  protected final String TEXT_70 = ") ";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = "_temp;" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_74 = NL + "                                } else {" + NL + "                                \t\tString count = \"0\";" + NL + "   \t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "    \t\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = count;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "    \t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = ParserUtils.parseTo_";
  protected final String TEXT_81 = "(count);" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_82 = NL + "                                }";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_86 = ".count);" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = "_clmCount);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_93 = ".count);" + NL + "\t    \t\t\t\t\t\t\t\t  ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "_clmCount);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = (";
  protected final String TEXT_100 = ") aggregated_row_";
  protected final String TEXT_101 = ".count;" + NL + "\t                                \t";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " = (";
  protected final String TEXT_104 = ") aggregated_row_";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = "_clmCount;" + NL + "\t                                \t";
  protected final String TEXT_107 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_110 = ".distinctValues_";
  protected final String TEXT_111 = ".size());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_114 = ".distinctValues_";
  protected final String TEXT_115 = ".size());" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = (";
  protected final String TEXT_118 = ") aggregated_row_";
  protected final String TEXT_119 = ".distinctValues_";
  protected final String TEXT_120 = ".size();" + NL + "\t                                \t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "    \t\t\t\t\t\t\t\tif(aggregated_row_";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = " != null) {" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = aggregated_row_";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = "Value();" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = NL + "    \t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = null;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = 0;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "    \t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = aggregated_row_";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = ";" + NL + "                                \t";
  protected final String TEXT_149 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = " = aggregated_row_";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ".toString();" + NL + "\t    \t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " = aggregated_row_";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ";" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_161 = "double result_";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = " = utilClass_";
  protected final String TEXT_165 = ".sd(aggregated_row_";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = "_";
  protected final String TEXT_168 = ".toArray(new Double[0]));" + NL + "\t\t    \t\t\t\t\t\t\tif(((Double)result_";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ").equals((Double)Double.NaN)) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = null;" + NL + "\t\t    \t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = new BigDecimal(result_";
  protected final String TEXT_176 = "_";
  protected final String TEXT_177 = "_";
  protected final String TEXT_178 = ");" + NL + "\t\t    \t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = (";
  protected final String TEXT_181 = ") utilClass_";
  protected final String TEXT_182 = ".sd(aggregated_row_";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = "_";
  protected final String TEXT_185 = ".toArray(new Double[0]));" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = String.valueOf(utilClass_";
  protected final String TEXT_188 = ".sd(aggregated_row_";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = "_";
  protected final String TEXT_191 = ".toArray(new Double[0])));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "                                ";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = " = aggregated_row_";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = "_";
  protected final String TEXT_197 = ";";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_199 = " - Operation function is : '";
  protected final String TEXT_200 = "' and column value is : \" +  ";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_203 = ".delete(0,log4jSb_";
  protected final String TEXT_204 = ".length());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String origin = ElementParameterParser.getValue(node, "__ORIGIN__");
String cid = origin;

boolean useFinancialPrecision = "true".equals(ElementParameterParser.getValue(node, "__USE_FINANCIAL_PRECISION__"));

String SUM = "sum";
String COUNT = "count";
String MAX = "max";
String MIN = "min";
String FIRST = "first";
String LAST = "last";
String AVG = "avg";
String COUNT_DISTINCT = "distinct";
String UNION = "union";
String LIST = "list";
String LIST_OBJECT = "list_object";
String STD_DEV = "std_dev";

List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
int sizeOperations = operations.size();
java.util.Map<String,IMetadataColumn> inputValuesColumns = new java.util.HashMap<String,IMetadataColumn>();
IConnection inputConn = null;
IMetadataTable inputMetadataTable = null;
java.util.List<IMetadataColumn> inputColumns = null;



String searchedComponentName = cid + "_AGGOUT";
List<? extends IConnection> incomingConnections = null;
List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
for(INode loopNode : generatedNodes) {
	if(loopNode.getUniqueName().equals(searchedComponentName)) {
		incomingConnections = (List<IConnection>) loopNode.getIncomingConnections();
		break;
	}
}

if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		inputConn = conn;
		inputMetadataTable = conn.getMetadataTable();
		inputColumns = inputMetadataTable.getListColumns();
		break;
	}
}
if(inputColumns != null) { // T_AggR_144
	for (IMetadataColumn column: inputColumns) { // T_AggR_145

		for(int i = 0; i < sizeOperations; i++){ // T_AggR_713
			String columnname = operations.get(i).get("INPUT_COLUMN");
        	if(column.getLabel().equals(columnname)){ // T_AggR_714
       			inputValuesColumns.put(columnname, column);
				break;
       		} // T_AggR_714
		} // T_AggR_713
				
	} // T_AggR_145
} // T_AggR_144



List<IMetadataTable> mestadataTableListOut = node.getMetadataList();

if (mestadataTableListOut!=null && mestadataTableListOut.size()>0) { // T_InMain_AggR_600
    IMetadataTable metadataTableOutput = mestadataTableListOut.get(0);
    if (metadataTableOutput!=null) { // T_InMain_AggR_601
        List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		int sizeGroupbys = groupbys.size();
		
		IConnection outputConn = null;
		List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
		if (outConns!=null) {
			if (outConns.size()>0) {
				IConnection conn = outConns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					outputConn = conn;    					
				}
			}
		}
		//fix bug 22089,if only choose iterator,the NPE will not occured.
		if(outputConn!=null){ // T_InMain_AggR_602
		List<IMetadataColumn> outputColumns = metadataTableOutput.getListColumns();
		int sizeColumns = outputColumns.size();
		if(sizeOperations > 0 || sizeGroupbys > 0){ // T_InMain_AggR_603

    			next_column:
    			for(int c = 0; c < sizeColumns; c++){ // T_InMain_AggR_604
    				IMetadataColumn outputColumn = outputColumns.get(c);
    				String outputColumnName = outputColumn.getLabel();
    				String outputTypeToGenerate = JavaTypesManager.getTypeToGenerate(outputColumn.getTalendType(), outputColumn.isNullable());
    				String primitiveOutputType = JavaTypesManager.getTypeToGenerate(outputColumn.getTalendType(), false);
    				JavaType outputJavaType = JavaTypesManager.getJavaTypeFromId(outputColumn.getTalendType());
    				String patternValue = outputColumn.getPattern() == null || outputColumn.getPattern().trim().length() == 0 ? null : outputColumn.getPattern();
    				
    				JavaType inputJavaType = null;
    				
    				for(int g = 0; g < sizeGroupbys; g++){ // T_InMain_AggR_605
    					Map<String, String> groupby = groupbys.get(g);
    					String inputColumn = groupby.get("INPUT_COLUMN");
    					String outputGroupColumn = groupby.get("OUTPUT_COLUMN");
    					if(outputGroupColumn.equals(outputColumnName)){ // T_InMain_AggR_606
    						Boolean sameType = false;
                			
            				if (incomingConnections != null && !incomingConnections.isEmpty()) {
            					loop:
            					for (IConnection conn : incomingConnections) {
            						IMetadataTable inMetadata = conn.getMetadataTable();
            						for (IMetadataColumn inColumn: inMetadata.getListColumns()) {
            							if(inColumn.getLabel().equals(inputColumn)){
            								inputJavaType = JavaTypesManager.getJavaTypeFromId(inColumn.getTalendType());
            								sameType = (inputJavaType == outputJavaType);
            								if(!sameType && inColumn.getTalendType().equals("id_Dynamic") && outputColumn.getTalendType().equals("id_Dynamic")) {
            									sameType = true;
            								}
            								break loop;
            							}
            						}
                				}
            				}
            				if(sameType){
            				    
    stringBuffer.append(TEXT_2);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_6);
      					
            				}else{
            				    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_14);
    
    							if(outputJavaType == JavaTypesManager.STRING || outputJavaType == JavaTypesManager.OBJECT) {
    								
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    
    							}else if(outputJavaType == JavaTypesManager.BYTE_ARRAY){
    								
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
    							} else if(outputJavaType == JavaTypesManager.DATE) {
    								
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_29);
    
    							} else {
    								
    stringBuffer.append(TEXT_30);
    stringBuffer.append( outputTypeToGenerate );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
    							}
            				    
    stringBuffer.append(TEXT_35);
    
    						}
							if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    						continue next_column;
    					} // T_InMain_AggR_606
    				} // T_InMain_AggR_605
				
    				for(int o = 0; o < sizeOperations; o++){ // T_InMain_AggR_615
    					Map<String, String> operation = operations.get(o);
                		String function = operation.get("FUNCTION");
                		String outOperation = operation.get("OUTPUT_COLUMN");
                		String inOperation = operation.get("INPUT_COLUMN");
						boolean ignoreNull = ("true").equals(operation.get("IGNORE_NULL"));

                		if(outOperation.equals(outputColumnName)){ // T_InMain_AggR_616

							IMetadataColumn inputColumn = inputValuesColumns.get(inOperation);
							inputJavaType = JavaTypesManager.getJavaTypeFromId(inputColumn.getTalendType());

							boolean outputIsNumber = JavaTypesManager.isNumberType(outputJavaType, false);
							boolean outputIsObject = outputJavaType == JavaTypesManager.OBJECT;
							boolean outputIsGeometry = false;
							boolean inputIsGeometry = false;
							try {
								outputIsGeometry = outputJavaType == JavaTypesManager.getJavaTypeFromId("id_Geometry");
							} catch (IllegalArgumentException e) {
							}
							boolean outputIsList = outputJavaType == JavaTypesManager.LIST;
							boolean outputIsString = outputJavaType == JavaTypesManager.STRING;
							boolean outputIsBigDecimal = outputJavaType == JavaTypesManager.BIGDECIMAL;
							boolean outputIsDate = outputJavaType == JavaTypesManager.DATE;
							boolean outputIsLong = outputJavaType == JavaTypesManager.LONG;
							boolean outputIsDecimal = outputJavaType == JavaTypesManager.FLOAT || outputJavaType == JavaTypesManager.DOUBLE || outputIsBigDecimal;
							boolean inputIsNumber = JavaTypesManager.isNumberType(inputJavaType, false);
							boolean inputIsObject = inputJavaType == JavaTypesManager.OBJECT;
							try {
								inputIsGeometry = inputJavaType == JavaTypesManager.getJavaTypeFromId("id_Geometry");
							} catch (IllegalArgumentException e) {
							}
							boolean inputIsBoolean = inputJavaType == JavaTypesManager.BOOLEAN;
							boolean inputIsList = inputJavaType == JavaTypesManager.LIST;
							boolean inputIsString = inputJavaType == JavaTypesManager.STRING;
							boolean inputIsDate = inputJavaType == JavaTypesManager.DATE;
							boolean inputIsBigDecimal = inputJavaType == JavaTypesManager.BIGDECIMAL;
							boolean inputIsByteArray = inputJavaType == JavaTypesManager.BYTE_ARRAY;
							boolean inputIsDecimal = inputJavaType == JavaTypesManager.FLOAT || inputJavaType == JavaTypesManager.DOUBLE || inputIsBigDecimal;
				
							boolean forceUseBigDecimal = 
								(function.equals(SUM) || function.equals(AVG)) 
								&& inputIsDecimal
								&& outputIsDecimal
								&& useFinancialPrecision
							;
							if(AVG.equals(function) && !forceUseBigDecimal) {
								forceUseBigDecimal = outputIsLong;
							}
							boolean sameInOutType = outputJavaType == inputJavaType;
					
							boolean isValidTypeForOperation = 
								(function.equals(SUM) || function.equals(AVG)) && inputIsNumber && outputIsNumber
								|| function.equals(MIN) && sameInOutType && !inputIsList && !inputIsByteArray && !inputIsBoolean 
								|| function.equals(MAX) && sameInOutType && !inputIsList && !inputIsByteArray && !inputIsBoolean
								|| function.equals(FIRST) && sameInOutType
								|| function.equals(LAST) && sameInOutType
								|| function.equals(LIST) && outputIsString
								|| function.equals(UNION) && outputIsGeometry
								|| function.equals(LIST_OBJECT) && outputIsList
								|| function.equals(COUNT) && outputIsNumber
								|| function.equals(COUNT_DISTINCT) && outputIsNumber
								|| function.equals(STD_DEV) && inputIsNumber && outputIsNumber
							;
	
							if(!isValidTypeForOperation) {
								continue;
							}
            				
                			if(function.equals(AVG)){ // T_InMain_AggR_617
                			
                				int pre = 10;
                       		 	Integer precision = outputColumn.getPrecision();
                           		 if(precision!=null && precision!=0) { 
                           		 	pre = precision;
                           		 }               				

                			    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_44);
    
									if(outputIsBigDecimal || forceUseBigDecimal) {
									
    stringBuffer.append(TEXT_45);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(pre );
    stringBuffer.append(TEXT_52);
     if(!outputIsBigDecimal) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_54);
     } 
    stringBuffer.append(TEXT_55);
    
									} else {
									
    stringBuffer.append(TEXT_56);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_62);
     
	    								if(outputIsString) {
	    								
		    								
    stringBuffer.append(TEXT_63);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_67);
    
											
										} else {
		    							
		    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_72);
    
										
										}
										
    stringBuffer.append(TEXT_73);
    
    								}
    								
    stringBuffer.append(TEXT_74);
     
    	    								if(outputIsString) {
    		    						
    stringBuffer.append(TEXT_75);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_77);
    
    										} else {
    		    						
    stringBuffer.append(TEXT_78);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( outputTypeToGenerate );
    stringBuffer.append(TEXT_81);
    
    										}
    									
    stringBuffer.append(TEXT_82);
    
                			}  // T_InMain_AggR_617
                			else if(function.equals(COUNT)) { // T_InMain_AggR_638
                			
								if(outputIsBigDecimal) {
								
    stringBuffer.append(TEXT_83);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_90);
    
								} else {
            			
									if(outputIsString) {
									
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_97);
    
										
									} else {
	    							
	                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_106);
    
									
									}
								}

							} // T_InMain_AggR__638
                			else if(function.equals(COUNT_DISTINCT)) { // T_InMain_AggR_658
                			
								if(outputIsBigDecimal) {
								
    stringBuffer.append(TEXT_107);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_111);
    
								} else {
            			
									if(outputIsString) {
									
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_115);
    
										
									} else {
	    							
	                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_120);
    
									
									}
								}

							} // T_InMain_AggR__638
                			else if(function.equals(SUM)) { // T_InMain_AggR_618

								if(outputIsString) {
								
    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_125);
    
									
								} else if(forceUseBigDecimal && !outputIsBigDecimal) {

    								
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_129);
    
    								
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_135);
    

    								
    stringBuffer.append(TEXT_136);
    
    									if(!JavaTypesManager.isJavaPrimitiveType(outputJavaType, outputColumn.isNullable())){// is Object
    stringBuffer.append(TEXT_137);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_139);
    
    									}else{
    stringBuffer.append(TEXT_140);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    
								
								} else {
    							
                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_148);
    
								
								}
									
    						} // T_InMain_AggR_618 
    						else if(function.equals(LIST)) { // T_InMain_AggR_679
    							
    stringBuffer.append(TEXT_149);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_154);
     
    						}  // T_InMain_AggR_679
    						else if(("list_object").equals(function)) { // T_InMain_AggR_619
    							
    stringBuffer.append(TEXT_155);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_160);
     
    						}  // T_InMain_AggR_619
    						else if(function.equals(STD_DEV)) { // T_InMain_AggR_620
    						
    						
    							if(outputIsNumber || outputIsObject){ // T_InMain_AggR_621

									if(outputIsBigDecimal) {
										
		    							
    stringBuffer.append(TEXT_161);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    
										
									} else {
	            			
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_185);
    
    								 		
									}

    							} // T_InMain_AggR_621
    							
    							else if(outputIsString){ // T_InMain_AggR_622
								
									
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_191);
    
									
    							} // T_InMain_AggR_622
    							
    						} // T_InMain_AggR_620
    						
    						else { // T_InMain_AggR_636
    							
								
    stringBuffer.append(TEXT_192);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_197);
    
                                
    							
    						} // T_InMain_AggR_636
							if(isLog4jEnabled){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_200);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
                			continue next_column;                			
                		} // T_InMain_AggR_616

                		
                } // T_InMain_AggR_615
    		
    		} // T_InMain_AggR_604

		} // T_InMain_AggR_603
	  } // T_InMain_AggR_602
	} // T_InMain_AggR_601
} // T_InMain_AggR_600

    stringBuffer.append(TEXT_205);
    return stringBuffer.toString();
  }
}
