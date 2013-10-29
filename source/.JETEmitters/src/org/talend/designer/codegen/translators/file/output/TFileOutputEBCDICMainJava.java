package org.talend.designer.codegen.translators.file.output;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputEBCDICMainJava
{
  protected static String nl;
  public static synchronized TFileOutputEBCDICMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputEBCDICMainJava result = new TFileOutputEBCDICMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t\tjava.util.List record_";
  protected final String TEXT_2 = " = new java.util.ArrayList();";
  protected final String TEXT_3 = NL + "\t\t\trecord_";
  protected final String TEXT_4 = ".add(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ") ;";
  protected final String TEXT_7 = NL + "        \trwriter_";
  protected final String TEXT_8 = ".writeRecord(record_";
  protected final String TEXT_9 = ");\t" + NL + "        \tnb_line_";
  protected final String TEXT_10 = "++;\t\t";
  protected final String TEXT_11 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_12 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = " = new byte[";
  protected final String TEXT_16 = "];";
  protected final String TEXT_17 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_18 = " < ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".length()) {" + NL + "                 \t\t   \t\tthrow new java.lang.Exception(\"Value length must be less than the length in schema.\");" + NL + "                \t\t\t}" + NL + "\t\t\t\t\t\t\twhile(";
  protected final String TEXT_21 = " > ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ".length()){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " + \" \";\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tbb_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".getBytes(";
  protected final String TEXT_32 = ");" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_33 = ".write(bb_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\tjava.math.BigDecimal ";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ";" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = " = cobolConversion.EBCDICType3.writeType3Value(";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = ",";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_48 = ".write(bb_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t\t\tjava.math.BigDecimal ";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ";" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = " = cobolConversion.EBCDICType9.writeType9Value(";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_65 = ".write(bb_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\tjava.math.BigInteger ";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".toBigInteger() ;" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ".compareTo(new java.math.BigInteger(\"0\")) < 0 ){" + NL + "\t\t\t\t\t\t\t\tfor(int i=0;i< ";
  protected final String TEXT_75 = ";i++){" + NL + "\t\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = "[i] = (byte)0xFF;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tbyte[] bArr_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = ".toByteArray();" + NL + "\t\t\t\t\t\t\tfor(int j=0;j<bArr_";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = ".length;j++){" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = "[bb_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ".length-(j+1)] = bArr_";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = "[bArr_";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = ".length - (j+1)];" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_92 = ".write(bb_";
  protected final String TEXT_93 = "_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\tbyte[] bArr_";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = ";" + NL + "\t\t\t\t\t\t\tfor(int j=0;j<bArr_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = ".length;j++){" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = "[j] = bArr_";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = "[j];" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_106 = ".write(bb_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_110 = " should be X, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_112 = ".flush();" + NL;
  protected final String TEXT_113 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String incomingName = (String)codeGenArgument.getIncomingName();
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
if(!customSetOriginalLength){//------11111
		List< ? extends IConnection> conns = node.getIncomingConnections();
    	List<IMetadataTable> preMetadatas = null;
		
		for (int i=0;i<conns.size();i++) {
			IConnection conn = conns.get(i);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    			
				if( conn.getName() == incomingName ) {				
					preMetadatas = conn.getSource().getMetadataList();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
			for (IMetadataColumn column: preMetadatas.get(0).getListColumns()) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    
			}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
				}
			}
		}
}else{//------1111
	List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//------2222
		List< ? extends IConnection> conns = node.getIncomingConnections();
       	for (IConnection conn : conns) {//------3333
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//------4444
    			if( conn.getName() == incomingName ) {	//------5555
	    			IMetadataTable metadata = metadatas.get(0);
	    			List<IMetadataColumn> columns = metadata.getListColumns();
	    			List<IMetadataColumn> extColumns = new java.util.ArrayList<IMetadataColumn>();
	    			for (IMetadataColumn tempColumn : columns) {
	    				extColumns.add(tempColumn);
	    			}
	    			List<IMetadataColumn> inColumns = conn.getMetadataTable().getListColumns();
	    			for (IMetadataColumn inColumn: inColumns) {//------6666
						IMetadataColumn column = null;
						for (int j = 0; j < extColumns.size(); j++) {// search the corresponding metadata column for the input column
							if(inColumn.getLabel().equals(extColumns.get(j).getLabel()) ) {
								column = extColumns.remove(j);
								break;
							}
						}
						// if not find, then the first one of the metadata columns is used to correspond the input column
						if (column==null && !extColumns.isEmpty()) { 
							column = extColumns.remove(0);
						}
						if (column != null ) { //------77777
							Integer orgainLength = column.getOriginalLength();
							Integer length = column.getLength();
							String orgainType = column.getType();
							Integer precision = column.getPrecision();
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    
								continue;
	 						}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_16);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(length );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(length);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								String isSignedStr = column.getAdditionalField().get("Signed");
								boolean isSigned = (isSignedStr!=null&&!("").equals(isSignedStr))?("true").equals(isSignedStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(orgainLength);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(isSigned );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
								}else {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(length );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(isSigned );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
								}
							}else if(orgainType.equals("B")) {
								String isSignedStr = column.getAdditionalField().get("Signed");

    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(orgainLength);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
							}else {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    
							}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
						} //-----77777
					}//------66666
				}//------5555
			}//------4444
		}//------3333
	}//------2222
}//------1111

    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}
