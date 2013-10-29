package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TStewardshipTaskInputBeginJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskInputBeginJava result = new TStewardshipTaskInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tint nb_line_";
  protected final String TEXT_2 = " = 0;\t" + NL + "                java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "                    protected java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "                    \treturn new java.net.PasswordAuthentication(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ".toCharArray());" + NL + "                }});" + NL + "\t\t\t\t" + NL + "\t\t\t\tjava.net.URL wsdlUrl_";
  protected final String TEXT_5 = " = new java.net.URL(\"http://\"+";
  protected final String TEXT_6 = "+\":\"+";
  protected final String TEXT_7 = "+\"/org.talend.datastewardship/services/TDSCWS?wsdl\");" + NL + "\t\t\t\torg.talend.datastewardship.server.ws.TDSCWS_Service service_";
  protected final String TEXT_8 = " = new org.talend.datastewardship.server.ws.TDSCWS_Service(wsdlUrl_";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\torg.talend.datastewardship.server.ws.TDSCWS TDSCWS_";
  protected final String TEXT_10 = " = service_";
  protected final String TEXT_11 = ".getTDSCWSImplPort();" + NL + "\t\t\t\t" + NL + "\t\t\t\tString startDateString_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "\t\t\t\tString endDateString_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "\t\t\t\tjavax.xml.datatype.DatatypeFactory factory_";
  protected final String TEXT_16 = " = javax.xml.datatype.DatatypeFactory.newInstance();" + NL + "            \tjavax.xml.datatype.XMLGregorianCalendar startXMLGregorianCalendar_";
  protected final String TEXT_17 = " = null;" + NL + "            \tjavax.xml.datatype.XMLGregorianCalendar endXMLGregorianCalendar_";
  protected final String TEXT_18 = " = null;" + NL + "            \tif(startDateString_";
  protected final String TEXT_19 = "!=null && !startDateString_";
  protected final String TEXT_20 = ".equals(\"\")){" + NL + "            \t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_21 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t\t\tstartdf_";
  protected final String TEXT_22 = ".parse(startDateString_";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\tjava.util.Calendar startCal_";
  protected final String TEXT_24 = " = startdf_";
  protected final String TEXT_25 = ".getCalendar();" + NL + "\t\t\t\t\tjava.util.GregorianCalendar startDate_";
  protected final String TEXT_26 = " = (java.util.GregorianCalendar) startCal_";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t\tstartXMLGregorianCalendar_";
  protected final String TEXT_28 = " = factory_";
  protected final String TEXT_29 = ".newXMLGregorianCalendar(startDate_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t}" + NL + "            \tif(endDateString_";
  protected final String TEXT_31 = "!=null && !endDateString_";
  protected final String TEXT_32 = ".equals(\"\")){" + NL + "                \tjava.text.SimpleDateFormat enddf_";
  protected final String TEXT_33 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "                    enddf_";
  protected final String TEXT_34 = ".parse(endDateString_";
  protected final String TEXT_35 = ");" + NL + "                    java.util.Calendar endCal_";
  protected final String TEXT_36 = " = enddf_";
  protected final String TEXT_37 = ".getCalendar();" + NL + "                    java.util.GregorianCalendar endDate_";
  protected final String TEXT_38 = " = (java.util.GregorianCalendar) endCal_";
  protected final String TEXT_39 = ";" + NL + "\t\t\t\t\tendXMLGregorianCalendar_";
  protected final String TEXT_40 = " = factory_";
  protected final String TEXT_41 = ".newXMLGregorianCalendar(endDate_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tjava.util.List<org.talend.datastewardship.server.ws.StringArray> tasksResult_";
  protected final String TEXT_43 = " = TDSCWS_";
  protected final String TEXT_44 = ".searchTasks(";
  protected final String TEXT_45 = ",";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ",startXMLGregorianCalendar_";
  protected final String TEXT_48 = ",endXMLGregorianCalendar_";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\tfor(org.talend.datastewardship.server.ws.StringArray taskResult_";
  protected final String TEXT_53 = ":tasksResult_";
  protected final String TEXT_54 = "){" + NL + "\t\t\t\t\tjava.util.List<String> taskCols_";
  protected final String TEXT_55 = " = taskResult_";
  protected final String TEXT_56 = ".getItem();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tjava.util.List<java.util.Map<String,String>> records_";
  protected final String TEXT_57 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t\t\t\tjava.util.Map<String,String> recordTmp_";
  protected final String TEXT_58 = "  = null;" + NL + "\t\t\t\t\tjava.util.List<org.talend.datastewardship.server.ws.StringArray> tgtRecord_";
  protected final String TEXT_59 = " = TDSCWS_";
  protected final String TEXT_60 = ".getTgtRecord(taskCols_";
  protected final String TEXT_61 = ".get(0));" + NL + "\t\t\t\t\trecordTmp_";
  protected final String TEXT_62 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\t\tif(tgtRecord_";
  protected final String TEXT_63 = " != null){" + NL + "\t\t\t\t\t\trecordTmp_";
  protected final String TEXT_64 = ".put(\"TARGET\",\"true\");" + NL + "\t\t\t\t\t\tfor(org.talend.datastewardship.server.ws.StringArray tgtCols_";
  protected final String TEXT_65 = ":tgtRecord_";
  protected final String TEXT_66 = "){" + NL + "\t\t\t\t\t\t\tjava.util.List<String> tgtCol_";
  protected final String TEXT_67 = " = tgtCols_";
  protected final String TEXT_68 = ".getItem();" + NL + "\t\t\t\t\t\t\tif(tgtCol_";
  protected final String TEXT_69 = "!=null && !tgtCol_";
  protected final String TEXT_70 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t recordTmp_";
  protected final String TEXT_71 = ".put(tgtCol_";
  protected final String TEXT_72 = ".get(0),tgtCol_";
  protected final String TEXT_73 = ".get(3));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trecords_";
  protected final String TEXT_74 = ".add(recordTmp_";
  protected final String TEXT_75 = ");// out of if statement is for return task info." + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tjava.util.List<org.talend.datastewardship.server.ws.StringArrayArray> srcRecords_";
  protected final String TEXT_77 = " = TDSCWS_";
  protected final String TEXT_78 = ".getSrcRecord(taskCols_";
  protected final String TEXT_79 = ".get(0));" + NL + "\t\t\t            for (org.talend.datastewardship.server.ws.StringArrayArray srcRecord_";
  protected final String TEXT_80 = " : srcRecords_";
  protected final String TEXT_81 = ") {" + NL + "\t\t\t                java.util.List<org.talend.datastewardship.server.ws.StringArray> srcRecordItem_";
  protected final String TEXT_82 = " = srcRecord_";
  protected final String TEXT_83 = ".getItem();" + NL + "\t\t\t                recordTmp_";
  protected final String TEXT_84 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\t\t\t\trecordTmp_";
  protected final String TEXT_85 = ".put(\"TARGET\",\"false\");" + NL + "\t\t\t\t\t\t\tString srcRecordName_";
  protected final String TEXT_86 = " = \"\";" + NL + "\t\t\t                for (org.talend.datastewardship.server.ws.StringArray srcCols_";
  protected final String TEXT_87 = " : srcRecordItem_";
  protected final String TEXT_88 = ") {" + NL + "\t\t\t                    java.util.List<String> srcCol_";
  protected final String TEXT_89 = " = srcCols_";
  protected final String TEXT_90 = ".getItem();" + NL + "\t\t\t                    if(srcCol_";
  protected final String TEXT_91 = "!=null && !srcCol_";
  protected final String TEXT_92 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t recordTmp_";
  protected final String TEXT_93 = ".put(srcCol_";
  protected final String TEXT_94 = ".get(0),srcCol_";
  protected final String TEXT_95 = ".get(3));" + NL + "\t\t\t\t\t\t\t\t\t srcRecordName_";
  protected final String TEXT_96 = " = srcCol_";
  protected final String TEXT_97 = ".get(4);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t                }" + NL + "\t\t\t                recordTmp_";
  protected final String TEXT_98 = ".put(\"SOURCE\",srcRecordName_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t                records_";
  protected final String TEXT_100 = ".add(recordTmp_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t            }" + NL + "\t\t            ";
  protected final String TEXT_102 = NL + "\t\t            for(java.util.Map<String,String> record_";
  protected final String TEXT_103 = " : records_";
  protected final String TEXT_104 = "){" + NL + "\t\t            " + NL + "\t\t            \t";
  protected final String TEXT_105 = ".TASK_ID = taskCols_";
  protected final String TEXT_106 = ".get(0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_107 = ".TASK_TYPE = taskCols_";
  protected final String TEXT_108 = ".get(1);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = ".TASK_CREATEDBY = taskCols_";
  protected final String TEXT_110 = ".get(2);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_111 = ".TASK_CREATEDON = ParserUtils.parseTo_Date(taskCols_";
  protected final String TEXT_112 = ".get(3),\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_113 = ".TASK_OWNER = taskCols_";
  protected final String TEXT_114 = ".get(4);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_115 = ".TASK_STATUS = taskCols_";
  protected final String TEXT_116 = ".get(5);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_117 = ".TASK_STARS = Integer.valueOf(taskCols_";
  protected final String TEXT_118 = ".get(6));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".TARGET = Boolean.valueOf(record_";
  protected final String TEXT_121 = ".get(\"TARGET\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ".SOURCE = record_";
  protected final String TEXT_123 = ".get(\"SOURCE\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tnb_line_";
  protected final String TEXT_125 = " ++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t\t\tif(record_";
  protected final String TEXT_127 = ".get(\"";
  protected final String TEXT_128 = "\")!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = record_";
  protected final String TEXT_132 = ".get(\"";
  protected final String TEXT_133 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = ParserUtils.parseTo_Date(record_";
  protected final String TEXT_137 = ".get(\"";
  protected final String TEXT_138 = "\"), ";
  protected final String TEXT_139 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ParserUtils.parseTo_";
  protected final String TEXT_143 = "(record_";
  protected final String TEXT_144 = ".get(\"";
  protected final String TEXT_145 = "\"));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t    \t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ";" + NL + "\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

			String host = ElementParameterParser.getValue(node, "__HOST__");
			String port = ElementParameterParser.getValue(node, "__PORT__");
			String taskType = ElementParameterParser.getValue(node, "__TASKTYPE__");
			String owner = ElementParameterParser.getValue(node,"__OWNER__");
			String tag = ElementParameterParser.getValue(node, "__TAG__");
			String startDate = ElementParameterParser.getValue(node, "__START_DATETIME__");
			String endDate = ElementParameterParser.getValue(node, "__END_DATETIME__");
			String starRanking = ElementParameterParser.getValue(node, "__STAR_RANKING__");
			String limit = ElementParameterParser.getValue(node,"__LIMIT__");
			String status = ElementParameterParser.getValue(node,"__STATUS__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
    		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			boolean targetRecordOnly = ("true").equals(ElementParameterParser.getValue(node,"__TARGET_RECORD_ONLY__"));
			
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(startDate.equals("")?null:startDate);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(endDate.equals("")?null:endDate);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
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
    stringBuffer.append(taskType);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(owner.equals("")?null:owner);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(tag.equals("")?null:tag);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(starRanking);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(status.equals("null")?null:"\""+status+"\"");
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    if(!targetRecordOnly){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    if(!targetRecordOnly){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
						for( int i = 0; i < columnList.size(); i++) {
							IMetadataColumn column = columnList.get(i);
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
							if(!"TASK_ID".equals(column.getLabel()) 
								&& !"TASK_TYPE".equals(column.getLabel()) 
								&& !"TASK_CREATEDBY".equals(column.getLabel()) 
								&& !"TASK_CREATEDON".equals(column.getLabel()) 
								&& !"TASK_OWNER".equals(column.getLabel()) 
								&& !"TASK_STATUS".equals(column.getLabel()) 
								&& !"TASK_STARS".equals(column.getLabel())
								&& !"TARGET".equals(column.getLabel())
								&& !"SOURCE".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
									
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_133);
    
									} else if(javaType == JavaTypesManager.DATE) { // Date
									
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_138);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_139);
    						
									}else{
									
    stringBuffer.append(TEXT_140);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_142);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    
									}
									
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_149);
    
							}
						}
						
    
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
