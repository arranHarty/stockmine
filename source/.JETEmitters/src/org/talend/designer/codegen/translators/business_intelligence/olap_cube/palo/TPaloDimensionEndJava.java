package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloDimensionEndJava
{
  protected static String nl;
  public static synchronized TPaloDimensionEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDimensionEndJava result = new TPaloDimensionEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tthPDims_";
  protected final String TEXT_3 = ".getAllExistPaloDimensionElements(pELMs_";
  protected final String TEXT_4 = ");" + NL + "\t\tthPDims_";
  protected final String TEXT_5 = ".buildParentChildRelationShipNormal();" + NL + "\t\tfor(org.talend.jpalo.talendHelpers.tPaloDimensionElements thPElem_";
  protected final String TEXT_6 = " : thPDims_";
  protected final String TEXT_7 = ".getParentChildList()){" + NL + "\t\t\t" + NL + "\t\t\tif(thPElem_";
  protected final String TEXT_8 = ".getElementName()!=null){" + NL + "\t\t\t\tswitch (thPElem_";
  protected final String TEXT_9 = ".getLevel()){" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\tcase ";
  protected final String TEXT_11 = ":" + NL + "\t\t\t\t\t\t\t\tpELMs_";
  protected final String TEXT_12 = ".deleteElement(thPElem_";
  protected final String TEXT_13 = ".getElementName());\t\t\t" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t\tcase ";
  protected final String TEXT_15 = ":" + NL + "\t\t\t\t\t\t\t\t//if(pELMs_";
  protected final String TEXT_16 = ".getElement(thPElem_";
  protected final String TEXT_17 = ".getElementName())==null){" + NL + "\t\t\t\t\t\t\t\tpELMs_";
  protected final String TEXT_18 = ".createElement(thPElem_";
  protected final String TEXT_19 = ".getElementName(),org.talend.jpalo.paloelements.";
  protected final String TEXT_20 = ",org.talend.jpalo.paloelements.";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\t\t\t\t//}" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t";
  protected final String TEXT_22 = "\t\t\t" + NL + "\t" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_23 = "\t" + NL + "\t\t\tfor(org.talend.jpalo.talendHelpers.tPaloDimensionElements thPElem_";
  protected final String TEXT_24 = " : thPDims_";
  protected final String TEXT_25 = ".getParentChildList()){" + NL + "\t\t\t\tthPDims_";
  protected final String TEXT_26 = ".buildConsolidationNormal(pELMs_";
  protected final String TEXT_27 = ", thPElem_";
  protected final String TEXT_28 = ".getElementName(), thPElem_";
  protected final String TEXT_29 = ".getPosition());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\t" + NL + "\t\tthPDims_";
  protected final String TEXT_31 = ".buildParentChildRelationShipReferenced();" + NL + "\t\tfor(org.talend.jpalo.talendHelpers.tPaloDimensionElements thPElem_";
  protected final String TEXT_32 = " : thPDims_";
  protected final String TEXT_33 = ".getParentChildListSorted()){" + NL + "\t\t\tpELMs_";
  protected final String TEXT_34 = ".createElement(thPElem_";
  protected final String TEXT_35 = ".getElementName(),org.talend.jpalo.paloelements.";
  protected final String TEXT_36 = ",org.talend.jpalo.paloelements.";
  protected final String TEXT_37 = ");\t\t\t\t" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_38 = "\t" + NL + "\t\tfor(org.talend.jpalo.talendHelpers.tPaloDimensionElements thPElem_";
  protected final String TEXT_39 = " : thPDims_";
  protected final String TEXT_40 = ".getParentChildList()){" + NL + "\t\t\tthPDims_";
  protected final String TEXT_41 = ".buildConsolidationNormal(pELMs_";
  protected final String TEXT_42 = ", thPElem_";
  protected final String TEXT_43 = ".getElementName(), thPElem_";
  protected final String TEXT_44 = ".getPosition());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_45 = NL + "    globalMap.put(\"";
  protected final String TEXT_46 = "_DIMENSIONNAME\",";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "}";
  protected final String TEXT_49 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String sDimensionName = ElementParameterParser.getValue(node,"__DIMENSION__");
	//String sDimensionType = ElementParameterParser.getValue(node,"__DIMENSION_TYPE__")
	String sDimensionType="NORMAL";
	boolean bCreateElements = "true".equals(ElementParameterParser.getValue(node,"__CREATE_ELEMENTS_BASED_ON_INPUT__"));
	boolean bDeleteElements = "true".equals(ElementParameterParser.getValue(node,"__DELETE_ALL_ELEMENTS_BEFORE__"));
	boolean bCreateConsolidations = "true".equals(ElementParameterParser.getValue(node,"__CREATE_CONSOLIDATIONS_BASED_ON_INPUT__"));


	String strSRDimensionElementType = ElementParameterParser.getValue(node,"__ELEMENT_TYPE__");
	String strSRDimensionUpdateMode = ElementParameterParser.getValue(node,"__CREATION_MODE__");

	boolean bHierachieNone = "true".equals(ElementParameterParser.getValue(node,"__HIERACHIE_NONE__"));
	boolean bHierachieNormal = "true".equals(ElementParameterParser.getValue(node,"__HIERACHIE_NORMAL__"));
	boolean bHierachieSelfReferenced = "true".equals(ElementParameterParser.getValue(node,"__SELF_REFERENCED__"));

	List<Map<String, String>> tDimensionElements = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ELEMENT_HIERACHIE__");
	List<Map<String, String>> tDimensionElementsSelfReferenced = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ELEMENT_HIERACHIE_SELFREFERENCED__");

	String strInputConnectionName="";
	List< ? extends IConnection> conns = node.getIncomingConnections();
 	if(conns!=null){
		if (conns.size()>0){
                IConnection conn =conns.get(0);
		    strInputConnectionName=conn.getName();
		}
	}
	
	 		
    		  
	if(bCreateElements && (bHierachieNone || bHierachieNormal) ){
		//for bug TDI-19242

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
					int iNbOfDimensionElements = tDimensionElements.size();
					for(int i=0; i<iNbOfDimensionElements; i++){
						Map<String, String> DimensionElement = tDimensionElements.get(i);
						String strDimensionElement = DimensionElement.get("SOURCE_COLUMN");
						String strDimensionElementType = DimensionElement.get("ELEMENT_TYPE");
						String strDimensionUpdateMode = DimensionElement.get("CREATION_MODE");
						if(strDimensionUpdateMode.equals("DELETE")){
				
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
				
						}else{
				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(strDimensionElementType);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(strDimensionUpdateMode);
    stringBuffer.append(TEXT_21);
    
						}
					}
				
    stringBuffer.append(TEXT_22);
    
		if(bHierachieNormal){
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
		}
	}
	else if(bCreateElements && bHierachieSelfReferenced){
		
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
    stringBuffer.append(strSRDimensionElementType);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(strSRDimensionUpdateMode);
    stringBuffer.append(TEXT_37);
    
		if(bHierachieNormal || bHierachieSelfReferenced){
		
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
		}
	}	

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_47);
     if(bCreateElements ) {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
