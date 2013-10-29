package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;

public class TNormalizeMainJava
{
  protected static String nl;
  public static synchronized TNormalizeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNormalizeMainJava result = new TNormalizeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            if(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null && ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ".trim().length() > 0) {";
  protected final String TEXT_7 = NL + "                        com.talend.csv.CSVReader reader_";
  protected final String TEXT_8 = " = new com.talend.csv.CSVReader(new java.io.StringReader(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "), '";
  protected final String TEXT_11 = "');" + NL + "                        reader_";
  protected final String TEXT_12 = ".setTrimWhitespace(false);";
  protected final String TEXT_13 = NL + "                        reader_";
  protected final String TEXT_14 = ".setEscapeChar('\\\\');";
  protected final String TEXT_15 = NL + "                     \treader_";
  protected final String TEXT_16 = ".setEscapeChar('";
  protected final String TEXT_17 = "');";
  protected final String TEXT_18 = NL + "                        reader_";
  protected final String TEXT_19 = ".setQuoteChar('";
  protected final String TEXT_20 = "');" + NL + "                        if (reader_";
  protected final String TEXT_21 = ".readNext()) {" + NL + "                            normalizeRecord_";
  protected final String TEXT_22 = " = reader_";
  protected final String TEXT_23 = ".getValues();" + NL + "                        } else {" + NL + "                            normalizeRecord_";
  protected final String TEXT_24 = " = new String[1];" + NL + "                        }";
  protected final String TEXT_25 = NL + "                    " + NL + "                        \tnormalizeRecord_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ".split(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                    \t\tnormalizeRecord_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ".split(";
  protected final String TEXT_34 = ",-1);";
  protected final String TEXT_35 = "               " + NL + "            } else {" + NL + "                normalizeRecord_";
  protected final String TEXT_36 = " = new String[1];" + NL + "            }";
  protected final String TEXT_37 = NL + "  \t\t\t";
  protected final String TEXT_38 = NL + "  \t\t\tint lastNoEmptyIndex_";
  protected final String TEXT_39 = "=0;" + NL + "            for(int i_";
  protected final String TEXT_40 = "=normalizeRecord_";
  protected final String TEXT_41 = ".length;i_";
  protected final String TEXT_42 = " > 0;i_";
  protected final String TEXT_43 = "--){" + NL + "            \tif(!\"\".equals(normalizeRecord_";
  protected final String TEXT_44 = "[i_";
  protected final String TEXT_45 = " - 1])){" + NL + "            \t\tlastNoEmptyIndex_";
  protected final String TEXT_46 = "=i_";
  protected final String TEXT_47 = ";" + NL + "            \t\tbreak;" + NL + "            \t}" + NL + "            }";
  protected final String TEXT_48 = NL + "             int lastNoEmptyIndex_";
  protected final String TEXT_49 = "=normalizeRecord_";
  protected final String TEXT_50 = ".length;";
  protected final String TEXT_51 = NL + "            for(int i_";
  protected final String TEXT_52 = " = 0 ; i_";
  protected final String TEXT_53 = " < lastNoEmptyIndex_";
  protected final String TEXT_54 = " ; i_";
  protected final String TEXT_55 = "++) {" + NL + "  \t\t\t";
  protected final String TEXT_56 = NL + "            \tif(normalizeRecord_";
  protected final String TEXT_57 = "[i_";
  protected final String TEXT_58 = "]!=null){" + NL + "            \t\tnormalizeRecord_";
  protected final String TEXT_59 = "[i_";
  protected final String TEXT_60 = "]=normalizeRecord_";
  protected final String TEXT_61 = "[i_";
  protected final String TEXT_62 = "].trim();" + NL + "            \t}";
  protected final String TEXT_63 = NL + "                currentRecord_";
  protected final String TEXT_64 = " = new StringBuilder();" + NL + "                nb_line_";
  protected final String TEXT_65 = "++;               ";
  protected final String TEXT_66 = NL + "                                tmp_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " == null ? null : String.valueOf(";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ".getTime());";
  protected final String TEXT_72 = NL + "                                    tmp_";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " == null ? null : ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ".toString();";
  protected final String TEXT_78 = NL + "                                    tmp_";
  protected final String TEXT_79 = " = String.valueOf(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "                                tmp_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " == null ? null : new String(";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "                                tmp_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " == null ? null : String.valueOf(";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "                                tmp_";
  protected final String TEXT_95 = " = String.valueOf(";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "                            if(tmp_";
  protected final String TEXT_99 = " != null){" + NL + "                                currentRecord_";
  protected final String TEXT_100 = ".append(tmp_";
  protected final String TEXT_101 = " + tmp_";
  protected final String TEXT_102 = ".length());" + NL + "                            }";
  protected final String TEXT_103 = NL + "                            if(normalizeRecord_";
  protected final String TEXT_104 = "[i_";
  protected final String TEXT_105 = "] != null) {" + NL + "                                currentRecord_";
  protected final String TEXT_106 = ".append(normalizeRecord_";
  protected final String TEXT_107 = "[i_";
  protected final String TEXT_108 = "] + normalizeRecord_";
  protected final String TEXT_109 = "[i_";
  protected final String TEXT_110 = "].length());" + NL + "                            }";
  protected final String TEXT_111 = NL + "                    if(!recordSet_";
  protected final String TEXT_112 = ".contains(currentRecord_";
  protected final String TEXT_113 = ".toString())) {" + NL + "                        recordSet_";
  protected final String TEXT_114 = ".add(currentRecord_";
  protected final String TEXT_115 = ".toString());" + NL + "                    } else {" + NL + "                        continue;" + NL + "                    }                    ";
  protected final String TEXT_116 = NL + "                        ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = normalizeRecord_";
  protected final String TEXT_119 = "[i_";
  protected final String TEXT_120 = "];";
  protected final String TEXT_121 = NL + "                        ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL;
  protected final String TEXT_127 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);    
    if (metadata!=null) {//2
       
        String cid = node.getUniqueName();
        String normalizeColumn = ElementParameterParser.getValue(node, "__NORMALIZE_COLUMN__");
        String deduplicate = ElementParameterParser.getValue(node, "__DEDUPLICATE__");
        boolean useCSV = ("true").equals(ElementParameterParser.getValue(node, "__CSV_OPTION__"));
        String escapeMode = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        
        String delim = ElementParameterParser.getValue(node, "__ITEMSEPARATOR__");
        
        boolean isDiscardTrailingEmptyStr=("true").equals(ElementParameterParser.getValue(node, "__DISCARD_TRAILING_EMPTY_STR__"));
        boolean isTrim=("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));
        if(useCSV){
        	delim = delim.substring(1,delim.length()-1);
        	if(("'").equals(delim)){
        		delim = "\\'";
        	}
        }
        
    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    	if ("".equals(textEnclosure)) textEnclosure = "\0";
    	if(("'").equals(textEnclosure)){
    		textEnclosure = "\\'";
    	}        
        
        String incomingConnName = null;
        String outgoingConnName = null;

        List< ? extends IConnection> inConns = node.getIncomingConnections();
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            incomingConnName = inConn.getName();
        }
        
        List< ? extends IConnection> outConns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
        if (outConns != null && !outConns.isEmpty()) {
            IConnection outConn = outConns.get(0);
            outgoingConnName = outConn.getName();
        }
        List< ? extends IConnection> outIterate = NodeUtil.getOutgoingConnections(node, IConnectionCategory.USE_ITERATE);
        List<IMetadataColumn> metadataColumns = metadata.getListColumns();
        if(incomingConnName != null && 
                metadataColumns != null && !metadataColumns.isEmpty()) {//3
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_6);
     if(useCSV){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
                        if("ESCAPE_MODE_BACKSLASH".equals(escapeMode)) {
                        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_17);
    } 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
     
                    } else { 
                    		if(isDiscardTrailingEmptyStr){
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_29);
    
                    		}else{
                    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_34);
    
                    		}
                    }
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
            if(!outIterate.isEmpty()||outgoingConnName != null){
            
    stringBuffer.append(TEXT_37);
    
  				if(useCSV && isDiscardTrailingEmptyStr){
  			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
            	}else{
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
       			}
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    if(isTrim){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
                if(outgoingConnName != null ){
                if(("true").equals(deduplicate)) {//check deduplicate start
                    for(int i = 0 ; i < metadataColumns.size() ; i++) {
                        IMetadataColumn metadataColumn = (IMetadataColumn)metadataColumns.get(i);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
                        String typeName = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                        if(!metadataColumn.getLabel().equals(normalizeColumn)) {
                            if(javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_71);
    
                            } else if(javaType == JavaTypesManager.BYTE || 
                                    javaType == JavaTypesManager.SHORT || 
                                    javaType == JavaTypesManager.FLOAT ||
                                    javaType == JavaTypesManager.DOUBLE ||
                                    javaType == JavaTypesManager.LONG ||
                                    javaType == JavaTypesManager.INTEGER || 
                                    javaType == JavaTypesManager.BOOLEAN) {
                                if(("Byte").equals(typeName) || 
                                        ("Short").equals(typeName) || 
                                        ("Float").equals(typeName) || 
                                        ("Double").equals(typeName) || 
                                        ("Long").equals(typeName) || 
                                        ("Integer").equals(typeName) || 
                                        ("Boolean").equals(typeName)) {                    
                                    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_77);
    
                                } else {
                                    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_81);
    
                                }
                            } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                                
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_87);
    
                            } else if(javaType == JavaTypesManager.STRING){
                                
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_93);
    
                            } else {
                                
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_97);
    
                            }
                            
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
                        } else {
                            
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
                }//check deduplicate end                
                for(IMetadataColumn metadataColumn : metadataColumns) {
                    if(metadataColumn.getLabel().equals(normalizeColumn)) {
                        
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
                    } else {
                        
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_125);
    
                    }
                }
                }
                
    stringBuffer.append(TEXT_126);
    
            }
        }
        //3
    }
    //2    
}
//1

    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}
