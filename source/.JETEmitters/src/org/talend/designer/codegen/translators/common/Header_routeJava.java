package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.core.model.process.EParameterFieldType;

public class Header_routeJava
{
  protected static String nl;
  public static synchronized Header_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_routeJava result = new Header_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = " ;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_7 = " Purpose: ";
  protected final String TEXT_8 = "<br>" + NL + " * Description: ";
  protected final String TEXT_9 = " <br>" + NL + " * @author ";
  protected final String TEXT_10 = NL + " * @version ";
  protected final String TEXT_11 = NL + " * @status ";
  protected final String TEXT_12 = NL + " */" + NL + " public class ";
  protected final String TEXT_13 = " extends SpringRouteBuilder implements TalendESBRoute {" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_14 = "(){" + NL + "\t}" + NL;
  protected final String TEXT_15 = NL + "\t\t\tprivate org.osgi.framework.BundleContext bundleContext;" + NL + "" + NL + "\t\t\tpublic void setBundleContext(org.osgi.framework.BundleContext bundleContext) {" + NL + "\t\t\t\tthis.bundleContext = bundleContext;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\t\t\t//ESB Service Activity Monitor Feature" + NL + "\t\t\tprivate org.apache.cxf.feature.Feature eventFeature;" + NL + "" + NL + "\t\t\tpublic void setEventFeature(org.apache.cxf.feature.Feature eventFeature) {" + NL + "\t\t\t\tthis.eventFeature = eventFeature;" + NL + "\t\t\t}" + NL + "" + NL + "// https://issues.apache.org/jira/browse/CAMEL-6783" + NL + "static class FeatureWrapper extends org.apache.cxf.feature.AbstractFeature {" + NL + "" + NL + "\tprivate final org.apache.cxf.feature.Feature f;" + NL + "" + NL + "\tpublic FeatureWrapper(org.apache.cxf.feature.Feature f) {" + NL + "\t\tthis.f = f;" + NL + "\t}" + NL + "" + NL + "\tpublic void initialize(org.apache.cxf.endpoint.Server server, org.apache.cxf.Bus bus) {" + NL + "\t\tf.initialize(server, bus);" + NL + "\t}" + NL + "" + NL + "\tpublic void initialize(org.apache.cxf.endpoint.Client client, org.apache.cxf.Bus bus) {" + NL + "\t\tf.initialize(client, bus);" + NL + "\t}" + NL + "" + NL + "\tpublic void initialize(org.apache.cxf.interceptor.InterceptorProvider interceptorProvider, org.apache.cxf.Bus bus) {" + NL + "\t\tf.initialize(interceptorProvider, bus);" + NL + "\t}" + NL + "" + NL + "\tpublic void initialize(org.apache.cxf.Bus bus) {" + NL + "\t\tf.initialize(bus);" + NL + "\t}" + NL + "}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + NL + "\tprivate Map<String, String> uriMap;" + NL + "" + NL + "\tpublic Map<String,String> getUriMap() {" + NL + "\t\treturn this.uriMap;" + NL + "\t}" + NL + "" + NL + "\tpublic void loadCustomUriMap(Map<String,String> newMap) {" + NL + "\t\tif(newMap == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfor(Map.Entry<String, String> entry: newMap.entrySet()) {" + NL + "\t\t\turiMap.put(entry.getKey(), entry.getValue());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t* the readContextValues(contextName) may have to invoked first before this" + NL + "\t*/" + NL + "\tpublic void initUriMap() {" + NL + "\t\turiMap = new HashMap<String, String>();";
  protected final String TEXT_19 = NL + "\t\turiMap.put(\"";
  protected final String TEXT_20 = "\", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t}";
  protected final String TEXT_23 = NL;

   	private static String getValue(INode node,String __ID__){
   		return ElementParameterParser.getValue(node, __ID__);
   	}
   	
	private static boolean getBoolValue(INode node,String __ID__){
		return "true".equals(getValue(node,__ID__));
	}
	
	private static <T> T getObjectValue(INode node,String __ID__){
		return (T)ElementParameterParser.getObjectValue(node, __ID__);
	}
	
	private static void appendParamWhenNotDefaultNorEmpty(StringBuilder sb,String param,String paramV,String defaultV){
		if(paramV!=null && !paramV.trim().equals("") && !defaultV.equals(paramV)){
					sb.append("+\"&"+param+"=\"+");
					//the first '&' should replace to '?' later.
					sb.append(paramV);
				}
	}
	
	private static void appendTableParams(StringBuilder sb,List<Map<String, String>> tableValues){
		for (Map<String, String> map : tableValues) {
				String argName = map.get("NAME").trim();
				String argValue = map.get("VALUE").trim();
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
		}
	}
	
	//the generate method.
	public String generate(CodeGeneratorArgument argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

	boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();
	
	List<? extends INode> processNodes = (List<? extends INode>) process.getGeneratingNodes();
	List<? extends INode> graphicalNodes = (List<? extends INode>) process.getGraphicalNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
	params=process.getContextManager().getDefaultContext().getContextParameterList();

    
IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if (service instanceof AbstractBrandingService) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}

	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    
	java.util.Set<String> importsSet = new java.util.TreeSet<String>();
/*	for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
		if (!routine.equals(ITalendSynchronizer.TEMPLATE)) {
			importsSet.add("import routines."+routine);
		}
	}
*/
	importsSet.add("import java.util.HashMap");
	importsSet.add("import java.util.Map");
	importsSet.add("import javax.xml.bind.JAXBException");
	importsSet.add("import org.apache.camel.ProducerTemplate");
	importsSet.add("import org.apache.camel.impl.DefaultCamelContext");
	importsSet.add("import org.apache.camel.main.MainSupport");
	importsSet.add("import routines.TalendString");
	importsSet.add("import routines.system.api.TalendESBRoute");
	importsSet.add("import routines.*");
	importsSet.add("import routines.system.*");
	importsSet.add("import java.text.ParseException");
	importsSet.add("import org.apache.camel.view.ModelFileGenerator");
	importsSet.add("import org.apache.camel.spi.Registry");
	importsSet.add("import org.apache.camel.impl.DefaultCamelContext");
	importsSet.add("import org.apache.camel.spring.SpringRouteBuilder");
	importsSet.add("import org.apache.camel.osgi.CamelContextFactoryBean");
	importsSet.add("import org.apache.camel.osgi.SpringCamelContextFactory");
	importsSet.add("import org.springframework.context.support.ClassPathXmlApplicationContext");
	importsSet.add("import  org.apache.camel.CamelContext");
	importsSet.add("import  java.util.Properties");
	importsSet.add("import  org.apache.camel.management.JmxNotificationEventNotifier");
	importsSet.add("import  org.springframework.osgi.context.support.OsgiBundleXmlApplicationContext");
	importsSet.add("import  org.apache.camel.impl.SimpleRegistry");
	importsSet.add("import  java.util.Set");
	
	String headerImports = ElementParameterParser.getValue(process, "__HEADER_IMPORT__");
	if(headerImports!=null && !"".equals(headerImports.trim())){
		String[] imports = headerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}
	String footerImports = ElementParameterParser.getValue(process, "__FOOTER_IMPORT__");
	if(footerImports!=null && !"".equals(footerImports.trim())){
		String[] imports = footerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}

	List<? extends INode> generatingNodes = process.getGeneratingNodes();
	for(INode n: generatingNodes){
		List<? extends IElementParameter> elementParameters = n.getElementParameters();
		for(IElementParameter p: elementParameters){
			if(p.getShowIf() != null && !p.isShow(elementParameters)){
				continue;
			}
			if(EParameterFieldType.MEMO_IMPORT == p.getFieldType()){
				Object value = p.getValue();
				if(value == null || !(value instanceof String) || "".equals(((String)value).trim())){
					continue;
				}
				String[] imports = ((String)value).trim().split(";");
				for(String s: imports){
					if(s!=null && !"".equals(s.trim())){
						importsSet.add(s.trim());
					}
				}
			}
		}
		
	}
	
	for(String s: importsSet){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(s);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_14);
    
	for (INode node : graphicalNodes) {
		Object value = node.getPropertyValue("STARTABLE");
		if (null != value && (Boolean) value) { 
    stringBuffer.append(TEXT_15);
     break;
		}
	}

    stringBuffer.append(TEXT_16);
    

	for (INode node : graphicalNodes) {
		String useRegistry = "false";
		String dataFormat = ElementParameterParser.getValue(node, "__DATAFORMAT__");
		if(isStudioEEVersion && !"RAW".equals(dataFormat) && !"CXF_MESSAGE".equals(dataFormat)){
		 	useRegistry = ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__");
		}
		if("cCXF".equals(node.getComponent().getName()) 
							&& "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SAM__"))  
							&& !"RAW".equals(ElementParameterParser.getValue(node, "__DATAFORMAT__"))&& !"true".equals(useRegistry) ) { 
    stringBuffer.append(TEXT_17);
     break;
		}
	}

    stringBuffer.append(TEXT_18);
    
String cid = "";
String componentName = "";
String uri = "";
for (INode node : graphicalNodes) {
	if(!node.isActivate()){
		continue;
	}
   	cid = node.getUniqueName();
//  http://jira.talendforge.org/browse/TESB-5241
	/*
   	 * change to use label + unique to make it unique but readable
   	 */
	IElementParameter param = node.getElementParameter("LABEL");
	if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
		cid = (String)param.getValue()+"_"+cid;	
	}
   	
	componentName = node.getComponent().getName();
	uri = "";
	if ("cMessagingEndpoint".equals(componentName)) {
		uri = ElementParameterParser.getValue(node, "__URI__");
	}else if("cDirect".equals(componentName)){
		if(node.getIncomingConnections().size()>0){
			continue;//is productor node. use exist endpoint.
		}
		String directName=getValue(node, "__NAME__");
		uri="\"direct:\"+"+directName;
		StringBuilder sb=new StringBuilder();
		List<Map<String, String>> tableValues = getObjectValue(node, "__ADVARGUMENTS__");
		appendTableParams(sb,tableValues);
		if(sb.length()>0){
			sb.setCharAt(sb.indexOf("&"),'?');
			uri = uri + sb.toString();
		}
	}else if("cVM".equals(componentName)||"cSEDA".equals(componentName)){
		boolean inputName=getBoolValue(node, "____INPUT_ENDPOINT_NAME____");
		if(node.getIncomingConnections().size()>0 && (!inputName)){
			continue;//is productor node. and use exist endpoint.
		}
		String endpointName=getValue(node, "__NAME__");
		uri="\""
			+ ("cVM".equals(componentName) ? "vm":"seda" )
			+ ":\"+" + endpointName;
		if(!inputName){
			//consumer
			StringBuilder sb=new StringBuilder();
			boolean  specifySize=getBoolValue(node, "__SPECIFY_SIZE__");
			if(specifySize){
				String size=getValue(node, "__SIZE__");
				appendParamWhenNotDefaultNorEmpty(sb,"size",size,"0");
			}
			String concurCnsmrs=getValue(node, "__CONCURRENT_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"concurrentConsumers",concurCnsmrs,"1");

			String waitForTaskToComplete=getValue(node, "__WAIT_FOR_TASK_TO_COMPLETE__");
			appendParamWhenNotDefaultNorEmpty(sb,"waitForTaskToComplete",waitForTaskToComplete,"\"IfReplyExpected\"");

			String timeout=getValue(node, "__TIMEOUT__");
			appendParamWhenNotDefaultNorEmpty(sb,"timeout",timeout,"30000");

			String multipleConsumers=getValue(node, "__MULTIPLE_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"multipleConsumers",multipleConsumers,"false");

			String limitConcurrentConsumers=getValue(node, "__LIMIT_CONCURRENT_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"limitConcurrentConsumers",limitConcurrentConsumers,"true");

			String blockWhenFull=getValue(node, "__BLOCK_WHEN_FULL__");
			appendParamWhenNotDefaultNorEmpty(sb,"blockWhenFull",blockWhenFull,"false");

			String pollTimeout=getValue(node, "__POLLTIMEOUT__");
			appendParamWhenNotDefaultNorEmpty(sb,"pollTimeout",pollTimeout,"1000");

			List<Map<String, String>> tableValues = getObjectValue(node, "__ADVARGUMENTS__");
			appendTableParams(sb,tableValues);
			
			if(sb.length()>0){
				sb.setCharAt(sb.indexOf("&"),'?');
				uri = uri + sb.toString();
			}
		}
	}else if("cDirectVM".equals(componentName)){
		boolean inputName= getBoolValue(node, "____INPUT_ENDPOINT_NAME____");
		boolean isProducer = node.getIncomingConnections().size()>0;
		
		INode consumerNode = node;
		if(isProducer && !inputName){
			String desNodeName= (String)getValue(node, "____ROUTE_COMPONENT_TYPE_ID____");
			if(desNodeName!=null){
				List<? extends INode> allNodes = node.getProcess().getGraphicalNodes();
				for(INode aNode : allNodes){
					if(aNode.getUniqueName().equals(desNodeName)){
						consumerNode=aNode;
						break;
					}
				}
			}
		}
		
		String endpointName=getValue(consumerNode, "__ENDPOINT_NAME__");
		
		uri="\"direct-vm:\"+" + endpointName;
		
		if(isProducer){
			boolean isBlock= getBoolValue(node, "____BLOCK____");
			if(isBlock){
				uri += "+\"?block=true&timeout="+getValue(consumerNode, "__TIMEOUT__")+"\"";
			}
		}
			
	}else if("cTimer".equals(componentName)){
		uri = "\"timer:\"+\""+node.getUniqueName()+"\"";
		StringBuilder sb = new StringBuilder();
		String period = ElementParameterParser.getValue(node, "__PERIOD__");
		if(period!=null && !period.trim().equals("") && !"1000".equals(period)){
			sb.append("+\"?period=\"+");
			sb.append(period);
		}
		String repeat = ElementParameterParser.getValue(node, "__REPEATCOUNT__");
		if(repeat!=null && !repeat.trim().equals("") && !"0".equals(repeat)){
			if(sb.length()==0){
				sb.append("+\"?repeatCount=\"+");
				sb.append(repeat);
			}else{
				sb.append("+\"&repeatCount=\"+");
				sb.append(repeat);
			}
		}
		String delay = ElementParameterParser.getValue(node, "__DELAY__");
		if(delay!=null && !delay.trim().equals("")){
			if(sb.length()==0){
				sb.append("+\"?delay=\"+");
				sb.append(delay);
			}else{
				sb.append("+\"&delay=\"+");
				sb.append(delay);
			}
		}
		String fixedRate = ElementParameterParser.getValue(node, "__FIXEDRATE__");
		if("true".equals(fixedRate)){
			if(sb.length()==0){
				sb.append("+\"?fixedRate=true\"");
			}else{
				sb.append("+\"&fixedRate=true\"");
			}
		}
		String daemon = ElementParameterParser.getValue(node, "__DAEMON__");
		if("false".equals(daemon)){
			if(sb.length()==0){
				sb.append("+\"?daemon=false\"");
			}else{
				sb.append("+\"&daemon=false\"");
			}
		}
		String setTime = ElementParameterParser.getValue(node, "__SET_TIME__");
		if("true".equals(setTime)){
			String time = ElementParameterParser.getValue(node, "__TIME__");
			if(sb.length()==0){
				sb.append("+\"?time=\"+");
				sb.append(time);
			}else{
				sb.append("+\"&time=\"+");
				sb.append(time);
			}
		}
		if(sb.length()>0){
			uri = uri + sb.toString();
		}
	}else if("cDataset".equals(componentName)){
		uri = "\"dataset:\"+"+ElementParameterParser.getValue(node, "__DATASET_NAME__");
		StringBuilder sb = new StringBuilder();
		String produceDelay = ElementParameterParser.getValue(node, "__PRODUCE_DELAY__");
		if(produceDelay!=null && !produceDelay.trim().equals("") && !"3".equals(produceDelay)){
			sb.append("+\"?produceDelay=\"+");
			sb.append(produceDelay);
		}
		String consumeDelay = ElementParameterParser.getValue(node, "__CONSUME_DELAY__");
		if(consumeDelay!=null && !consumeDelay.trim().equals("") && !"0".equals(consumeDelay)){
			if(sb.length()==0){
				sb.append("+\"?consumeDelay=\"+");
				sb.append(consumeDelay);
			}else{
				sb.append("+\"&consumeDelay=\"+");
				sb.append(consumeDelay);
			}
		}
		String preloadSize = ElementParameterParser.getValue(node, "__PRELOAD_SIZE__");
		if(preloadSize!=null && !preloadSize.trim().equals("") && !"0".equals(preloadSize)){
			if(sb.length()==0){
				sb.append("+\"?preloadSize=\"+");
				sb.append(preloadSize);
			}else{
				sb.append("+\"&preloadSize=\"+");
				sb.append(preloadSize);
			}
		}
		String initialDelay = ElementParameterParser.getValue(node, "__INITIAL_DELAY__");
		if(initialDelay!=null && !initialDelay.trim().equals("") && !"1000".equals(initialDelay)){
			if(sb.length()==0){
				sb.append("+\"?initialDelay=\"+");
				sb.append(initialDelay);
			}else{
				sb.append("+\"&initialDelay=\"+");
				sb.append(initialDelay);
			}
		}
		String minRate = ElementParameterParser.getValue(node, "__MIN_RATE__");
		if(minRate!=null && !minRate.trim().equals("") && !"0".equals(minRate)){
			if(sb.length()==0){
				sb.append("+\"?minRate=\"+");
				sb.append(minRate);
			}else{
				sb.append("+\"&minRate=\"+");
				sb.append(minRate);
			}
		}
		
		if(sb.length()>0){
			uri = uri + sb.toString();
		}
	} else if ("cFile".equals(componentName)) {
		String filePath = ElementParameterParser.getValue(node, "__URI__");
		String noop = ElementParameterParser.getValue(node, "__NOOP__");
		String flatten = ElementParameterParser.getValue(node, "__FLATTEN__");
		String bufferSize = ElementParameterParser.getValue(node, "__BUFFER_SIZE__");
		String autoCreate = ElementParameterParser.getValue(node, "__AUTOCREATE__");
		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
		String charset = ElementParameterParser.getValue(node, "__ENCODING__");

		StringBuffer arguments = new StringBuffer();

		uri = "\"file://\"+" + filePath;

		if ("true".equals(noop)) {
			arguments.append("\"noop=true\"+");
		} else {
			arguments.append("\"noop=false\"+");
		}

		if ("false".equals(autoCreate)) {// default true, ignore.
			arguments.append("\"&autoCreate=false\"+");
		}

		if ("true".equals(flatten)) {// default false, ignore.
			arguments.append("\"&flatten=true\"+");
		}

		if (fileName != null && !fileName.equals("\"\"") && fileName.length() > 0 ) {
			arguments.append("\"&fileName=\"+").append(fileName).append("+");
		}

		if (charset != null  && !charset.equals("\"\"") && charset.length() > 0) {
			arguments.append("\"&charset=\"+").append(charset).append("+");
		}

		if (bufferSize != null && !bufferSize.equals("\"\"") && bufferSize.length() > 0) {
			arguments.append("\"&bufferSize=\"+").append(bufferSize).append("+");
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME");
			String argValue = map.get("VALUE");
			arguments.append("\"&\"+").append(argName).append("+\"=\"+").append(argValue).append("+");
		}

		if (arguments.length() > 0) {
			arguments.deleteCharAt(arguments.length() - 1);
			uri = uri + "+\"?\"+" + arguments.toString();
		}
		System.out.println(uri);

	} else if ("cCXF".equals(componentName)) {
		String url = ElementParameterParser.getValue(node, "__ADDRESS__").trim();
		
		
		String dataformat = ElementParameterParser.getValue(node, "__DATAFORMAT__");
		
		String useServiceRegistry = ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__");
		if(!isStudioEEVersion || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
			useServiceRegistry = "false";
		}
		
		String useSecurity = ElementParameterParser.getValue(node, "__ENABLE_SECURITY__");
		if("true".equals(useServiceRegistry) || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
			useSecurity = "false";
		}
		
		List<? extends IConnection> conns = node.getIncomingConnections();
		if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SL__")) 
				&&  "false".equals(useServiceRegistry)) {
			if (!conns.isEmpty()) {
				// consumer role
				url = "((null == bundleContext) ? " + url + " : \"locator://locator/\")";
			}
		}

		String serviceType = ElementParameterParser.getValue(node, "__SERVICE_TYPE__");

		StringBuilder sb = new StringBuilder();
		sb.append("\"cxf://\"+").append(url).append("+\"?" + serviceType + "=\"");

		if ("wsdlURL".equals(serviceType)) {
		
			//http://jira.talendforge.org/browse/TESB-6226
		    String filePath = "";
			
			String wsdlType = ElementParameterParser.getValue(node, "__WSDL_TYPE__");
			if("file".equals(wsdlType)){
			  filePath =  ElementParameterParser.getValue(node, "__WSDL_FILE__");
			}else{
				filePath =  ElementParameterParser.getValue(node, "__ROUTE_RESOURCE_TYPE_RES_URI__");
				filePath = "\"classpath:" + filePath + "\"";
			}
			filePath.replaceAll("\\\\","/");
			sb.append("+").append(filePath);
		} else {
			sb.append("+" + ElementParameterParser.getValue(node, "__SERVICE_CLASS__"));
		}



		sb.append("+\"&dataFormat=" + dataformat + "\"");

		String specifyService = ElementParameterParser.getValue(node, "__SPECIFY_SERVICE__");
		if("true".equals(specifyService)){
			sb.append("+\"&serviceName=\"+").append(ElementParameterParser.getValue(node, "__SERVICE_NAME__").trim());
			sb.append("+\"&portName=\"+").append(ElementParameterParser.getValue(node, "__PORT_NAME__").trim());
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
		}
		
		if(!conns.isEmpty()){
			sb.append("+\"&headerFilterStrategy=#CXF_PAYLOAD_HEADER_FILTER\"");
		}else if("true".equals(useServiceRegistry) || ("true".equals(useSecurity) && "SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__")))) {
			sb.append("+\"&cxfBinding=#DEFAULT_CXF_BINDING\"");
		}
		uri = sb.toString();

	} else if ("cFtp".equals(componentName)) {
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String username = ElementParameterParser.getValue(node, "__USERNAME__");
		String server = ElementParameterParser.getValue(node, "__SERVER__");
		String port = ElementParameterParser.getValue(node, "__PORT__");
		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");

		StringBuffer fragments = new StringBuffer();
		fragments.append("\"" + type + "://\"");
		fragments.append("+\"");
		fragments.append("ftpServer");
		fragments.append("\"");

/*		if (username.trim().length() > 0) {
			fragments.append("+" + username.trim()).append("+\"@\"");
		}

		fragments.append("+" + server.trim());
*/
		if (port.trim().length() > 0) {
			fragments.append("+\":\"").append("+" + port.trim());
		}
/*
		if (directory.trim().length() > 0) {
			fragments.append("+\"/\"").append("+" + directory.trim());
		}
*/
		boolean hasArg = false;
/*		if (password.trim().length() > 0) {
			hasArg = true;
			fragments.append("+\"?password=\"+" + password);
		}
*/
		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (!hasArg) {
				fragments.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasArg = true;
			} else {
				fragments.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}
		uri = fragments.toString();

	} else if("cJMS".equals(componentName)) {
		//http://jira.talendforge.org/browse/TESB-4861
		String name = ElementParameterParser.getValue(node, "__ROUTE_COMPONENT_TYPE_ID__");
		if (name == null || name.equals("")) {
			name = "jms";
		}
		name = name.replace("_", "");
		name = "\"" + name + "\"";
		//String name = ElementParameterParser.getValue(node, "__NAME__").trim();
		//Remove unnecessary subfix
		//name += "+";
		//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String destination = ElementParameterParser.getValue(node, "__DESTINATION__").trim();

		boolean hasOptions = false;

		StringBuffer sb = new StringBuffer();
		sb.append(name).append("+\":" + type + ":\"").append("+" + destination);

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();

			if (!hasOptions) {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasOptions = true;
			} else {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}

		uri = sb.toString();

	} else if ("cLog".equals(componentName)) {
		String useLogEIP = ElementParameterParser.getValue(node, "__USE_LOGEIP__");
		if ("true".equals(useLogEIP)) {
			continue;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("\"log:").append(cid);

		String level = ElementParameterParser.getValue(node, "__LEVEL_TYPE__");
		sb.append("?").append("level=").append(level);

		String isSize = ElementParameterParser.getValue(node, "__GROUP_SIZE__");
		String isInterval = ElementParameterParser.getValue(node, "__GROUP_INTERVAL__");
		String isFormat = ElementParameterParser.getValue(node, "__FORMAT__");

		if ("true".equals(isSize)) {
			String groupSize = ElementParameterParser.getValue(node, "__SIZE__");
			sb.append("&groupSize=").append(groupSize).append("\"");
		} else if ("true".equals(isInterval)) {
			String interval = ElementParameterParser.getValue(node, "__INTERVAL__");
			sb.append("&groupInterval=").append(interval);
			String delay = ElementParameterParser.getValue(node, "__DELAY__");
			if (!"0".equals(delay)) {
				sb.append("&groupDelay=").append(delay);
			}
			String activeOnly = ElementParameterParser.getValue(node, "__ACTIVE_ONLY__");
			if (!"true".equals(activeOnly)) {
				sb.append("&groupActiveOnly=").append(activeOnly);
			}
			sb.append("\"");
		} else if ("true".equals(isFormat)) {
			sb.append("\"");
			List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
			for (Map<String, String> map : formatValues) {
				String argName = map.get("NAME").trim();
				String argValue = map.get("VALUE").trim();
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		} else {
			sb.append("\"");
		}

		uri = sb.toString();

	} else if ("cMail".equals(componentName)) {

		StringBuffer sb = new StringBuffer();

		String protocols = ElementParameterParser.getValue(node, "__PROTOCOLS__");
		sb.append("\"").append(protocols).append("://");

		String host = ElementParameterParser.getValue(node, "__HOST__");
		sb.append("\"+").append(host);

		String port = ElementParameterParser.getValue(node, "__PORT__");
		if (!"\"\"".equals(port)) {
			sb.append("+\":\"+").append(port);
		}

		boolean hasParam = false;
/*		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
		if (!"\"\"".equals(userName)) {
			sb.append("+\"?username=\"+").append(userName);
			hasParam = true;
		}

		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		if (!"\"\"".equals(password)) {
			if (hasParam) {
				sb.append("+\"&password=\"+");
			} else {
				sb.append("+\"?password=\"+");
			}
			sb.append(password);
			hasParam = true;
		}

		String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
		if (!"\"\"".equals(subject)) {
			if (hasParam) {
				sb.append("+\"&subject=\"+");
			} else {
				sb.append("+\"?subject=\"+");
			}
			sb.append(subject);
			hasParam = true;
		}

		String from = ElementParameterParser.getValue(node, "__FROM__");
		if (!"\"\"".equals(from)) {
			if (hasParam) {
				sb.append("+\"&from=\"+");
			} else {
				sb.append("+\"?from=\"+");
			}
			sb.append(from);
			hasParam = true;
		}

		String to = ElementParameterParser.getValue(node, "__TO__");
		if (!"\"\"".equals(to)) {
			if (hasParam) {
				sb.append("+\"&to=\"+");
			} else {
				sb.append("+\"?to=\"+");
			}
			sb.append(to);
			hasParam = true;
		}
*/

		String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
		if (!"\"\"".equals(contentType)) {
			if (hasParam) {
				sb.append("+\"&contentType=\"+");
			} else {
				sb.append("+\"?contentType=\"+");
			}
			sb.append(contentType);
			hasParam = true;
		}

/*		String cc = ElementParameterParser.getValue(node, "__CC__");
		if (!"\"\"".equals(cc)) {
			if (hasParam) {
				sb.append("+\"&CC=\"+");
			} else {
				sb.append("+\"?CC=\"+");
			}
			sb.append(cc);
			hasParam = true;
		}

		String bcc = ElementParameterParser.getValue(node, "__BCC__");
		if (!"\"\"".equals(bcc)) {
			if (hasParam) {
				sb.append("+\"&BCC=\"+");
			} else {
				sb.append("+\"?BCC=\"+");
			}
			sb.append(bcc);
			hasParam = true;
		}
*/
		List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
		for (Map<String, String> map : formatValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (hasParam) {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			} else {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasParam = true;
			}
		}

		//sb.append("+\"");
		uri = sb.toString();
	} else if ("cHttp".equals(componentName)) {

		String isServer = ElementParameterParser.getValue(node, "__SERVER__");
		String resourceUri = ElementParameterParser.getValue(node, "__URI__");
		
		StringBuffer sb = new StringBuffer();


		boolean hasParam = resourceUri==null?false:resourceUri.contains("?");
		
		if("true".equals(isServer)){
			sb.append("\"jetty://\"+");
			sb.append(resourceUri);
			String disableStream = ElementParameterParser.getValue(node, "__DISABLE_STREAM__");
			String sessionSupport = ElementParameterParser.getValue(node, "__SESSION_SUPPORT__");
			String chunked = ElementParameterParser.getValue(node, "__CHUNKED__");
			String enableJmx = ElementParameterParser.getValue(node, "__ENABLEJMX__");
			String matchOnUriPrefix = ElementParameterParser.getValue(node, "__MATCH_ON_URI_PREFIX__");
			String traceEnable = ElementParameterParser.getValue(node, "__TRACE_ENABLE__");
			String useContinuation = ElementParameterParser.getValue(node, "__USE_CONTINUATION__");
			
			if("true".equals(disableStream)){
				if(hasParam){
					sb.append("+\"&disableStreamCache=true\"");
				}else{
					sb.append("+\"?disableStreamCache=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(sessionSupport)){
				if(hasParam){
					sb.append("+\"&sessionSupport=true\"");
				}else{
					sb.append("+\"?sessionSupport=true\"");
				}
				hasParam = true;
			}
			
			if("false".equals(chunked)){
				if(hasParam){
					sb.append("+\"&chunked=false\"");
				}else{
					sb.append("+\"?chunked=false\"");
				}
				hasParam = true;
			}
			
			if("true".equals(enableJmx)){
				if(hasParam){
					sb.append("+\"&enableJmx=true\"");
				}else{
					sb.append("+\"?enableJmx=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(matchOnUriPrefix)){
				if(hasParam){
					sb.append("+\"&matchOnUriPrefix=true\"");
				}else{
					sb.append("+\"?matchOnUriPrefix=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(traceEnable)){
				if(hasParam){
					sb.append("+\"&traceEnabled=true\"");
				}else{
					sb.append("+\"?traceEnabled=true\"");
				}
				hasParam = true;
			}
			
			if("false".equals(useContinuation)){
				if(hasParam){
					sb.append("+\"&useContinuation=false\"");
				}else{
					sb.append("+\"?useContinuation=false\"");
				}
				hasParam = true;
			}
			
			List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__HEADERS__");
			for (Map<String, String> map : arguments) {
				String argName = map.get("KEY").trim();
				String argValue = map.get("VALUE").trim();

				if (hasParam) {
					sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
				} else {
					sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
					hasParam = true;
				}
			}
			
		}else{
			sb.append(resourceUri);
			String method = ElementParameterParser.getValue(node, "__METHOD__");
			if("GET".equals(method)||"HEAD".equals(method) || "DELETE".equals(method)){
				List<Map<String, String>> parameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
				String encodeCharset = ElementParameterParser.getValue(node, "__ENCODER_CHARSET__");
	
				for (Map<String, String> map : parameters) {
					String argName = map.get("KEY").trim();
					String argValue = map.get("VALUE").trim();
					try{
						if(argName.startsWith("\"")&&argName.endsWith("\"")&&argName.length()>=2){
							argName = URLEncoder.encode(argName.substring(1, argName.length()-1),encodeCharset);
							argName = "\""+argName+"\"";
						}else{
							argName = URLEncoder.encode(argName,encodeCharset);
						}
						if(argValue.startsWith("\"")&&argValue.endsWith("\"")&&argValue.length()>=2){
							argValue = URLEncoder.encode(argValue.substring(1, argValue.length()-1),encodeCharset);
							argValue = "\""+argValue+"\"";
						}else{
							argValue = URLEncoder.encode(argValue,encodeCharset);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (hasParam) {
						sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
					} else {
						sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
						hasParam = true;
					}
				}
			}
	
		}
		uri = sb.toString();
	} else {
		continue;
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_21);
    
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}