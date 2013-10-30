package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import java.util.List;
import java.util.Map;

public class TPigJoinMainJava
{
  protected static String nl;
  public static synchronized TPigJoinMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigJoinMainJava result = new TPigJoinMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();\t\t" + NL + "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_5 = ".append(\"";
  protected final String TEXT_6 = "_LOOKUP = load '\"+";
  protected final String TEXT_7 = "+\"' using PigStorage('\"+";
  protected final String TEXT_8 = "+\"')\");" + NL + "\t\tString schema_";
  protected final String TEXT_9 = "=\"\";";
  protected final String TEXT_10 = NL + "\t\t\t\tsb_";
  protected final String TEXT_11 = ".append(\" AS (\");";
  protected final String TEXT_12 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_13 = ".append(\"";
  protected final String TEXT_14 = ":";
  protected final String TEXT_15 = "\");";
  protected final String TEXT_16 = NL + "\t\t\t\tsb_";
  protected final String TEXT_17 = ".append(\")\");";
  protected final String TEXT_18 = NL + "\t\tsb_";
  protected final String TEXT_19 = ".append(\";\");\t\t";
  protected final String TEXT_20 = NL + "\t\t\tpigServer_";
  protected final String TEXT_21 = ".registerQuery(sb_";
  protected final String TEXT_22 = ".toString());";
  protected final String TEXT_23 = NL + "        \tpl_";
  protected final String TEXT_24 = " = new Object[2];" + NL + "        \tpl_";
  protected final String TEXT_25 = "[0] = \"query\";" + NL + "        \tpl_";
  protected final String TEXT_26 = "[1] = sb_";
  protected final String TEXT_27 = ".toString();" + NL + "        \tpigScript_";
  protected final String TEXT_28 = ".add(pl_";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_31 = " = new StringBuilder();" + NL + "\t\tsb_";
  protected final String TEXT_32 = ".append(\"";
  protected final String TEXT_33 = "_JOIN_RESULT = JOIN ";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "_RESULT BY (\");";
  protected final String TEXT_36 = NL + "\t\t\tsb_";
  protected final String TEXT_37 = ".append(\"";
  protected final String TEXT_38 = "\");";
  protected final String TEXT_39 = NL + "\t\t\tsb_";
  protected final String TEXT_40 = ".append(\",\");";
  protected final String TEXT_41 = NL + "\t\tsb_";
  protected final String TEXT_42 = ".append(\")\");";
  protected final String TEXT_43 = NL + "\t\t\tsb_";
  protected final String TEXT_44 = ".append(\" LEFT\");";
  protected final String TEXT_45 = NL + "\t\t\tsb_";
  protected final String TEXT_46 = ".append(\" RIGHT\");";
  protected final String TEXT_47 = NL + "\t\t\tsb_";
  protected final String TEXT_48 = ".append(\" FULL\");";
  protected final String TEXT_49 = NL + "\t\tsb_";
  protected final String TEXT_50 = ".append(\", ";
  protected final String TEXT_51 = "_LOOKUP BY (\");";
  protected final String TEXT_52 = NL + "\t\t\tsb_";
  protected final String TEXT_53 = ".append(\"";
  protected final String TEXT_54 = "\");";
  protected final String TEXT_55 = NL + "\t\t\tsb_";
  protected final String TEXT_56 = ".append(\",\");";
  protected final String TEXT_57 = NL + "\t\tsb_";
  protected final String TEXT_58 = ".append(\")\");";
  protected final String TEXT_59 = NL + "\t\t\tsb_";
  protected final String TEXT_60 = ".append(\" USING '";
  protected final String TEXT_61 = "'\");";
  protected final String TEXT_62 = NL + "\t\t\tsb_";
  protected final String TEXT_63 = ".append(\" PARTITION BY \"+";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\tsb_";
  protected final String TEXT_66 = ".append(\" PARALLEL ";
  protected final String TEXT_67 = "\");";
  protected final String TEXT_68 = "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_69 = ".append(\";\");";
  protected final String TEXT_70 = NL + "\t\t\tpigServer_";
  protected final String TEXT_71 = ".registerQuery(sb_";
  protected final String TEXT_72 = ".toString());";
  protected final String TEXT_73 = NL + "        \tpl_";
  protected final String TEXT_74 = " = new Object[2];" + NL + "        \tpl_";
  protected final String TEXT_75 = "[0] = \"query\";" + NL + "        \tpl_";
  protected final String TEXT_76 = "[1] = sb_";
  protected final String TEXT_77 = ".toString();" + NL + "        \tpigScript_";
  protected final String TEXT_78 = ".add(pl_";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + NL + "\t\tsb_";
  protected final String TEXT_81 = " = new StringBuilder();" + NL + "\t\tsb_";
  protected final String TEXT_82 = ".append(\"";
  protected final String TEXT_83 = "_";
  protected final String TEXT_84 = "_RESULT = FOREACH ";
  protected final String TEXT_85 = "_JOIN_RESULT GENERATE \");" + NL;
  protected final String TEXT_86 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_87 = ".append(\"";
  protected final String TEXT_88 = "$";
  protected final String TEXT_89 = " AS ";
  protected final String TEXT_90 = "\");";
  protected final String TEXT_91 = NL + "\t\tsb_";
  protected final String TEXT_92 = ".append(\";\");";
  protected final String TEXT_93 = NL + "\t\t\tpigServer_";
  protected final String TEXT_94 = ".registerQuery(sb_";
  protected final String TEXT_95 = ".toString());";
  protected final String TEXT_96 = NL + "        \tpl_";
  protected final String TEXT_97 = " = new Object[2];" + NL + "        \tpl_";
  protected final String TEXT_98 = "[0] = \"query\";" + NL + "        \tpl_";
  protected final String TEXT_99 = "[1] = sb_";
  protected final String TEXT_100 = ".toString();" + NL + "        \tpigScript_";
  protected final String TEXT_101 = ".add(pl_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String previous_node="";
	String start_node="";

	boolean inMain = true;

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();
		inMain = loadNode.isSubtreeStart();
		previousOutputConnectionName = connection.getName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}
	
	String lookup_filename = ElementParameterParser.getValue(node, "__LOOKUP_FILENAME__");
	String lookup_separator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR_LOOKUP__");
	
	List<Map<String, String>> joinKeyColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
	String joinMode = ElementParameterParser.getValue(node, "__JOIN_MODE__");
	
	boolean optimize = "true".equals(ElementParameterParser.getValue(node, "__OPTIMIZE__"));
	String using = ElementParameterParser.getValue(node, "__USING__");
	
	boolean usePartition = "true".equals(ElementParameterParser.getValue(node, "__USE_PARTITION__"));
	String partition = ElementParameterParser.getValue(node, "__PARTITION__");
	
	boolean useParallel = "true".equals(ElementParameterParser.getValue(node, "__INCREASE_PARALLELISM__"));
	String reduce_number = ElementParameterParser.getValue(node, "__REDUCE_NUMBER__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(lookup_filename);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lookup_separator);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if(metadatas != null && metadatas.size() > 2) {
		    metadata = metadatas.get(2);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_15);
    

				}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_20);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		} else {//lookup process

    stringBuffer.append(TEXT_23);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_29);
    
		}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_35);
    
		for(int i=0;i<joinKeyColumns.size();i++){
			Map<String, String> line = joinKeyColumns.get(i);

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(line.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_38);
    
			if(i!=joinKeyColumns.size()-1){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			}
		}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
		if("left-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		}
		if("right-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		}
		if("full-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		for(int i=0;i<joinKeyColumns.size();i++){
			Map<String, String> line = joinKeyColumns.get(i);

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(line.get("LOOKUP_COLUMN"));
    stringBuffer.append(TEXT_54);
    
			if(i!=joinKeyColumns.size()-1){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			}
		}
		

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
		if(optimize) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(using);
    stringBuffer.append(TEXT_61);
    
		}
		
		if(usePartition && !("skewed".equals(using))) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_64);
    
		}
		
		if(useParallel) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(reduce_number);
    stringBuffer.append(TEXT_67);
    
		}
		

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_70);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
		} else {//lookup process

    stringBuffer.append(TEXT_73);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_79);
    
		}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		if(metadatas != null && metadatas.size() > 0) {
		    metadata = metadatas.get(0);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_90);
    

				}
			}
		}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
		if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_93);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
		} else {//lookup process

    stringBuffer.append(TEXT_96);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_102);
    
		}

    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}
