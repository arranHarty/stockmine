package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloCubeListBeginJava
{
  protected static String nl;
  public static synchronized TPaloCubeListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloCubeListBeginJava result = new TPaloCubeListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int NB_CUBES";
  protected final String TEXT_3 = " = 0;  " + NL + "org.talend.jpalo.palo p_";
  protected final String TEXT_4 = " = null;" + NL + "org.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_5 = " = null;" + NL;
  protected final String TEXT_6 = NL + "\t// Use Existing" + NL + "\tp_";
  protected final String TEXT_7 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "\tpConn_";
  protected final String TEXT_9 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_10 = "\");";
  protected final String TEXT_11 = NL + "\t// Initialize jpalo" + NL + "\tp_";
  protected final String TEXT_12 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_13 = ");" + NL + "\t// Open the connection" + NL + "\tpConn_";
  protected final String TEXT_14 = " = p_";
  protected final String TEXT_15 = ".connect(";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL;
  protected final String TEXT_21 = NL + NL + "org.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_22 = " = pConn_";
  protected final String TEXT_23 = ".getDatabases();" + NL + "org.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_24 = " = pDBs_";
  protected final String TEXT_25 = ".getDatabase(";
  protected final String TEXT_26 = ");" + NL + "" + NL + "if(pDB_";
  protected final String TEXT_27 = " == null){" + NL + "\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_28 = " + \"' not found. exiting...\");" + NL + "}" + NL + NL;
  protected final String TEXT_29 = NL + "for(int i_";
  protected final String TEXT_30 = "=0;i_";
  protected final String TEXT_31 = "<4;i_";
  protected final String TEXT_32 = "++){" + NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_33 = " = pDB_";
  protected final String TEXT_34 = ".getCubes(i_";
  protected final String TEXT_35 = ");" + NL + "\tfor(int j_";
  protected final String TEXT_36 = "=0;j_";
  protected final String TEXT_37 = "< pCUBs_";
  protected final String TEXT_38 = ".getNumberOfCubes();j_";
  protected final String TEXT_39 = "++){" + NL + "\t\torg.talend.jpalo.palocube pCUB_";
  protected final String TEXT_40 = "=pCUBs_";
  protected final String TEXT_41 = ".getCube(j_";
  protected final String TEXT_42 = ");" + NL + "\t\tNB_CUBES";
  protected final String TEXT_43 = "++;";
  protected final String TEXT_44 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_45 = ".cube_id=pCUB_";
  protected final String TEXT_46 = ".getCubeId();" + NL + "\t\t\t";
  protected final String TEXT_47 = ".cube_name=pCUB_";
  protected final String TEXT_48 = ".getName();" + NL + "\t\t\t";
  protected final String TEXT_49 = ".cube_dimensions=pCUB_";
  protected final String TEXT_50 = ".getNumberOfDimensions();" + NL + "\t\t\t";
  protected final String TEXT_51 = ".cube_cells=pCUB_";
  protected final String TEXT_52 = ".getNumberOfCells();" + NL + "\t\t\t";
  protected final String TEXT_53 = ".cube_filled_cells=pCUB_";
  protected final String TEXT_54 = ".getNumberOfFilledCells();" + NL + "\t\t\t";
  protected final String TEXT_55 = ".cube_status=pCUB_";
  protected final String TEXT_56 = ".getCubeStatus();" + NL + "\t\t\t";
  protected final String TEXT_57 = ".cube_type=pCUB_";
  protected final String TEXT_58 = ".getCubeType();";
  protected final String TEXT_59 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_60 = "_CUBEID\", pCUB_";
  protected final String TEXT_61 = ".getCubeId());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_62 = "_CUBENAME\", pCUB_";
  protected final String TEXT_63 = ".getName());" + NL + "\t\t";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));


    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");
    String sPassword = ElementParameterParser.getValue(node, "__PASS__");

    String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    

    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
if(useExistingConnection){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String p = "p_" + connection;
	String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_10);
    
}else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sPassword);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    
String outputConnName = null;
boolean bIterate=false;
boolean bData=false;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns!=null) {
	if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				outputConnName = connTemp.getName();
				bData=true;
				//break;
			}
		}
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if(connTemp.getLineStyle().toString().equals("ITERATE")) {
				bIterate=true;
				//break;
			}
		}

	}
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_28);
    
if (outputConnName != null || bIterate){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		if(bData){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
		}
		if(bIterate){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
		}
}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
