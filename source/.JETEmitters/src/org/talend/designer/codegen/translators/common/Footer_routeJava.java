package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;

import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.JavaResourcesHelper;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;

public class Footer_routeJava
{
  protected static String nl;
  public static synchronized Footer_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Footer_routeJava result = new Footer_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "protected void doStart() throws java.lang.Exception {" + NL + "\t\t// init uriMap first" + NL + "\t\tinitUriMap();" + NL + "\t\t" + NL + "\t\t//add route" + NL + "\t\taddRouteBuilder(";
  protected final String TEXT_2 = ".this);" + NL + "" + NL + "\t\t//prepare camel contexts" + NL + "\t\tsuper.doStart();" + NL + "\t\tpostProcessContext();" + NL + "" + NL + "\t\t//add jmx notification" + NL + "\t\tJmxNotificationEventNotifier notifier = new JmxNotificationEventNotifier();" + NL + "\t\tnotifier.setSource(\"MyCamel\");" + NL + "\t\tnotifier.setIgnoreCamelContextEvents(true);" + NL + "\t\tnotifier.setIgnoreRouteEvents(true);" + NL + "\t\tnotifier.setIgnoreServiceEvents(true);" + NL + "" + NL + "\t\tgetCamelContexts().get(0).getManagementStrategy().addEventNotifier(notifier);" + NL;
  protected final String TEXT_3 = NL + "\t\t// add external libraries" + NL + "\t\tjava.net.URLClassLoader sysloader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "\t\tjava.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "\t\tmethod.setAccessible(true);" + NL + "\t\tString[] libPaths = new String[] {";
  protected final String TEXT_4 = "};" + NL + "\t\tfor (String lib : libPaths) {" + NL + "\t\t\tString separator = System.getProperty(\"path.separator\");" + NL + "\t\t\tString[] jarFiles = lib.split(separator);" + NL + "\t\t\tfor (String jarFile : jarFiles) {" + NL + "\t\t\t\tmethod.invoke(sysloader, new Object[] { new java.io.File(jarFile).toURL() });" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_5 = NL + NL + "\t\t// add statistics which shows on the connection" + NL + "\t\tfinal routines.system.CamelStat runStat = new routines.system.CamelStat(getCamelContexts().get(0));" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\trunStat.addConnectionMapping(\"";
  protected final String TEXT_7 = "\", \"";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + NL + "\t\trunStat.initStatisticsInterceptor();";
  protected final String TEXT_10 = NL + "\t\t//start camel context\t" + NL + "\t\tgetCamelContexts().get(0).start();";
  protected final String TEXT_11 = NL + "\t\trunStat.openSocket(true);" + NL + "\t\trunStat.setAllPID(pid, pid, pid, jobName);" + NL + "\t\trunStat.startThreadStat(clientHost, portStats);" + NL + "\t\trunStat.updateStatOnJob(routines.system.RunStat.JOBSTART, \"\");" + NL + "" + NL + "\t\tnew Thread(new MyStatThread(runStat)).start();";
  protected final String TEXT_12 = NL + NL + "\t}" + NL + "" + NL + "\tprotected void doStop() throws java.lang.Exception {" + NL + "\t\tsuper.doStop();" + NL + "\t\tgetCamelContexts().get(0).stop();" + NL + "\t}" + NL + "" + NL + "\tprotected ProducerTemplate findOrCreateCamelTemplate() {" + NL + "\t\treturn getCamelContexts().get(0).createProducerTemplate();" + NL + "\t}" + NL + "\t" + NL + "\tprotected ModelFileGenerator createModelFileGenerator()" + NL + "\t\tthrows JAXBException {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_13 = NL + NL + "\tclass MyStatThread implements Runnable {" + NL + "" + NL + "\t\troutines.system.CamelStat stats;" + NL + "" + NL + "\t\tpublic MyStatThread(routines.system.CamelStat stats) {" + NL + "\t\t\tthis.stats = stats;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void run() {" + NL + "\t\t\twhile (true) {" + NL + "\t\t\t\ttry {";
  protected final String TEXT_14 = NL + "\t\t\t\t\tstats.updateStatOnConnection(\"";
  protected final String TEXT_15 = "\", 1, \"";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "\t\t\t\t\tThread.sleep(1000);" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_18 = NL + NL + "};" + NL + "\tmainSupport.run();" + NL + "}" + NL + "\tpublic void stop() throws java.lang.Exception{" + NL + "\t\tif(mainSupport != null){" + NL + "\t\t\tmainSupport.stop();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void shutdown() throws java.lang.Exception{" + NL + "\t\tif(mainSupport != null){" + NL + "\t\t\tmainSupport.shutdown();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tprivate Properties defaultProps = new Properties();" + NL + "" + NL + "\tpublic class ContextProperties extends Properties {" + NL + "" + NL + "\t\tpublic ContextProperties(Properties properties) {" + NL + "\t\t\tsuper(properties);" + NL + "\t\t}" + NL + "\t\tpublic ContextProperties() {" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void synchronizeContext() {" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tif(";
  protected final String TEXT_20 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tString pattern_";
  protected final String TEXT_22 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\tString value_";
  protected final String TEXT_23 = " = \"";
  protected final String TEXT_24 = "\";" + NL + "\t\t\t\tString[] parts_";
  protected final String TEXT_25 = " = value_";
  protected final String TEXT_26 = ".split(\";\");" + NL + "\t\t\t\tif (parts_";
  protected final String TEXT_27 = ".length > 1) {" + NL + "\t\t\t\t\tpattern_";
  protected final String TEXT_28 = " = parts_";
  protected final String TEXT_29 = "[0];" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_30 = "\", pattern_";
  protected final String TEXT_31 = " + \";\" + FormatterUtils.format_Date(";
  protected final String TEXT_32 = ", pattern_";
  protected final String TEXT_33 = "));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_34 = "\", FormatterUtils.format_Date(";
  protected final String TEXT_35 = ", pattern_";
  protected final String TEXT_36 = "));" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_38 = "\", ";
  protected final String TEXT_39 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t}" + NL;
  protected final String TEXT_42 = NL + "\t\tpublic String ";
  protected final String TEXT_43 = ";" + NL + "\t\tpublic String get";
  protected final String TEXT_44 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_45 = ";" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "\t\tpublic ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = ";" + NL + "\t\tpublic ";
  protected final String TEXT_49 = " get";
  protected final String TEXT_50 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_51 = ";" + NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t}" + NL + "" + NL + "\tprivate ContextProperties context = new ContextProperties();" + NL + "\t" + NL + "\t//private final String jobVersion = \"";
  protected final String TEXT_53 = "\";" + NL + "\tprivate final String jobName = \"";
  protected final String TEXT_54 = "\";" + NL + "\t//private final String projectName = \"";
  protected final String TEXT_55 = "\";" + NL + "\t" + NL + "\tpublic Integer errorCode = null;" + NL + "\t" + NL + "\tpublic boolean watch = false;" + NL + "\t//portStats is null, it means don't execute the statistics" + NL + "\tpublic Integer portStats = null;" + NL + "\tpublic int portTraces = 4334;" + NL + "\tpublic String clientHost;" + NL + "\tpublic String defaultClientHost = \"localhost\";" + NL + "\tpublic String contextStr = \"Default\";" + NL + "\tpublic String pid = \"0\";" + NL + "\tpublic long startTime = 0;" + NL + "\t" + NL + "\tprivate Properties context_param = new Properties();" + NL + "    public Map<String, Object> parentContextMap = new HashMap<String, Object>();" + NL + "    " + NL + "    public static void main(String[] args){" + NL + "    \tfinal ";
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = "Class = new ";
  protected final String TEXT_58 = "();" + NL + "    " + NL + "        int exitCode = ";
  protected final String TEXT_59 = "Class.runJobInTOS(args);" + NL + "         " + NL + "         if(exitCode==1)" + NL + "       System.exit(exitCode);" + NL + "    }    " + NL + "   " + NL + " " + NL + "    public String[][] runJob(String[] args) {  " + NL + "    " + NL + "\t\tint exitCode = runJobInTOS(args);" + NL + "\t\tString[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };" + NL + "\t\treturn bufferValue;" + NL + "    }" + NL + "    " + NL + "    public int runJobInTOS(String[] args) {\t" + NL + "\t" + NL + "\t\tString lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "        \tif (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL + "\t\t" + NL + "\t\tif(clientHost == null) {" + NL + "    \t\tclientHost = defaultClientHost;" + NL + "    \t}" + NL + "    \t" + NL + "    \tif(pid == null || \"0\".equals(pid)) {" + NL + "\t    \tpid = TalendString.getAsciiRandomString(6);" + NL + "\t    }" + NL + "" + NL + "\t\t//read context values" + NL + "\t\treadContextValues(contextStr);" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\trun();" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t\treturn 1;" + NL + "\t\t}" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* read context values from specified context" + NL + "\t* @parameter contextName : the name of context while will be used" + NL + "\t*/" + NL + "\tpublic void readContextValues(String contextName){" + NL + "\t\t\t" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.InputStream inContext = ";
  protected final String TEXT_60 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_61 = "/";
  protected final String TEXT_62 = "/contexts/\"+contextName+\".properties\");" + NL + "\t\t\t" + NL + "\t\t\tif (inContext!=null) {" + NL + "\t    \t\t//defaultProps is in order to keep the original context value" + NL + "\t    \t\tdefaultProps.load(inContext);" + NL + "    \t\t\tinContext.close();" + NL + "\t    \t\tcontext = new ContextProperties(defaultProps);" + NL + "\t    \t}else{" + NL + "\t    \t\t//print info and job continue to run, for case: context_param is not empty." + NL + "\t    \t\tSystem.err.println(\"Could not find the context \" + contextName);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(!context_param.isEmpty()) {\t\t\t\t\t\t" + NL + "\t\t\t    context.putAll(context_param);\t\t" + NL + "\t\t\t}";
  protected final String TEXT_63 = NL + "\t\t\ttry{" + NL + "\t\t\t\tString context_";
  protected final String TEXT_64 = "_value = context.getProperty(\"";
  protected final String TEXT_65 = "\");" + NL + "\t\t\t\tif (context_";
  protected final String TEXT_66 = "_value == null){" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_67 = "_value = \"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t\tint context_";
  protected final String TEXT_68 = "_pos = context_";
  protected final String TEXT_69 = "_value.indexOf(\";\");" + NL + "\t\t\t\tString context_";
  protected final String TEXT_70 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\tif(context_";
  protected final String TEXT_71 = "_pos > -1){" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_72 = "_pattern = context_";
  protected final String TEXT_73 = "_value.substring(0, context_";
  protected final String TEXT_74 = "_pos);" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_75 = "_value = context_";
  protected final String TEXT_76 = "_value.substring(context_";
  protected final String TEXT_77 = "_pos + 1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t    context.";
  protected final String TEXT_78 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_79 = "_pattern).parse(context_";
  protected final String TEXT_80 = "_value));" + NL + "\t\t\t   " + NL + "\t\t\t}catch(ParseException e)" + NL + "\t\t\t{" + NL + "\t\t\t    context.";
  protected final String TEXT_81 = "=null;" + NL + "\t\t\t}";
  protected final String TEXT_82 = NL + "\t\t\t    \tcontext.";
  protected final String TEXT_83 = "=(";
  protected final String TEXT_84 = ") context.getProperty(\"";
  protected final String TEXT_85 = "\");";
  protected final String TEXT_86 = NL + "\t\t\t \tcontext.";
  protected final String TEXT_87 = "= new java.text.StringCharacterIterator(context.getProperty(\"";
  protected final String TEXT_88 = "\")).first();\t\t\t ";
  protected final String TEXT_89 = " " + NL + "\t\t\t \t\ttry{" + NL + "\t\t\t     \t\tcontext.";
  protected final String TEXT_90 = "=routines.system.ParserUtils.parseTo_";
  protected final String TEXT_91 = " (context.getProperty(\"";
  protected final String TEXT_92 = "\"));" + NL + "\t\t\t \t\t}catch(NumberFormatException e){" + NL + "\t\t\t     \t\tcontext.";
  protected final String TEXT_93 = "=null;" + NL + "\t\t\t \t\t}";
  protected final String TEXT_94 = NL + "    \t} catch (java.io.IOException ie) {" + NL + "    \t\tSystem.err.println(\"Could not load context \"+contextName);" + NL + "    \t\tie.printStackTrace();" + NL + "    \t}" + NL + "    \t" + NL + "    \t" + NL + "\t\t// get context value from parent directly" + NL + "\t\tif (parentContextMap != null && !parentContextMap.isEmpty()) {";
  protected final String TEXT_95 = "\t\t\t\tif (parentContextMap.containsKey(\"";
  protected final String TEXT_96 = "\")) {" + NL + "\t\t\t\tcontext.";
  protected final String TEXT_97 = " = (";
  protected final String TEXT_98 = ") parentContextMap.get(\"";
  protected final String TEXT_99 = "\");" + NL + "\t\t\t}";
  protected final String TEXT_100 = NL + "\t\t}    " + NL + "\t}" + NL + "" + NL + "\tprivate void evalParam(String arg) {" + NL + "\tif (arg.startsWith(\"--watch\")) {" + NL + "    \t\twatch = true;" + NL + "    \t} else if (arg.startsWith(\"--stat_port=\")) {" + NL + "\t\t\tString portStatsStr = arg.substring(12);" + NL + "\t\t\tif (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "\t\t\t\tportStats = Integer.parseInt(portStatsStr);" + NL + "\t\t\t}    \t\t" + NL + "    \t} else if (arg.startsWith(\"--trace_port=\")) {" + NL + "    \t\tportTraces = Integer.parseInt(arg.substring(13));" + NL + "    \t} else if (arg.startsWith(\"--client_host=\")) {" + NL + "    \t\tclientHost = arg.substring(14);" + NL + "    \t} else if (arg.startsWith(\"--context=\")) {" + NL + "    \t\tcontextStr = arg.substring(10);" + NL + "    \t}if (arg.startsWith(\"--pid=\")) {" + NL + "    \t\tpid = arg.substring(6);" + NL + "    \t} else if (arg.startsWith(\"--context_param\")) {   \t\t " + NL + "            String keyValue = arg.substring(16);           " + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));" + NL + "            }" + NL + "    \t}\t" + NL + "\t}" + NL + "}" + NL + "" + NL + "class ";
  protected final String TEXT_101 = "_Registry extends SimpleRegistry {" + NL + "" + NL + "\tprivate Registry wrapped = null;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_102 = "_Registry() {" + NL + "\t\tthis(new SimpleRegistry());" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_103 = "_Registry(Registry wrapped) {" + NL + "\t\tthis.wrapped = wrapped;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic Object lookupByName(String name) {" + NL + "\t\tObject obj = null;" + NL + "\t\tif (wrapped != null) {" + NL + "\t\t\tobj = wrapped.lookupByName(name);" + NL + "\t\t}" + NL + "\t\tif (obj == null) {" + NL + "\t\t\tobj = super.lookupByName(name);" + NL + "\t\t}" + NL + "\t\treturn obj;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic <T> T lookupByNameAndType(String name, Class<T> type) {" + NL + "\t\tT t = null;" + NL + "\t\tif (wrapped != null) {" + NL + "\t\t\tt = wrapped.lookupByNameAndType(name, type);" + NL + "\t\t}" + NL + "\t\tif (t == null) {" + NL + "\t\t\tt = super.lookupByNameAndType(name, type);" + NL + "\t\t}" + NL + "\t\treturn t;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic <T> Map<String, T> findByTypeWithName(Class<T> type) {" + NL + "\t\tMap<String, T> result = null;" + NL + "\t\tif (wrapped != null) {" + NL + "\t\t\tresult = wrapped.findByTypeWithName(type);" + NL + "\t\t}" + NL + "\t\tif (result == null) {" + NL + "\t\t\tresult = super.findByTypeWithName(type);" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic <T> Set<T> findByType(Class<T> type){" + NL + "\t\tSet<T> result = null;" + NL + "\t\tif (wrapped != null) {" + NL + "\t\t\tresult = wrapped.findByType(type);" + NL + "\t\t}" + NL + "\t\tif (result == null) {" + NL + "\t\t\tresult = super.findByType(type);" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void register(String name, Object instance) {" + NL + "\t\tput(name, instance);" + NL + "\t}" + NL + "" + NL + "}";

    private static String end_multiThread = "if ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {\n((java.util.Map) threadLocal.get()).put(\"status\", \"end\");\n}";
    private static String end_singleThread = "if(!\"failure\".equals(status)) { status = \"end\"; }";
    private static String failure_multiThread = "((java.util.Map) threadLocal.get()).put(\"status\", \"failure\");";
    private static String failure_singleThread = "status = \"failure\";";
    private static String errorCode_multiThread = "((java.util.Map) threadLocal.get()).put(\"errorCode\", null);";
    private static String errorCode_singleThread = "errorCode = null;";
    
    // add the list of the connection names to avoid to declare two times the same name.
    public String createCallProcess(INode rootNode, String className, boolean isMultiThread) {
        String toReturn = "";
        toReturn =  "try {\n";
        if(isMultiThread) {
            toReturn +=  errorCode_multiThread;
        }else{
            toReturn +=  errorCode_singleThread;
        }        
        
        toReturn += rootNode.getUniqueName() + "Process(globalMap);\n";
        
        if(isMultiThread) {
            toReturn +=  end_multiThread;
        }else{
            toReturn +=  end_singleThread;
        }
        
        toReturn += "\n}catch (TalendException e_" + rootNode.getUniqueName() + ") {\n";
        
//        if(isMultiThread) {
//            toReturn +=  failure_multiThread;
//        }else{
//            toReturn +=  failure_singleThread;
//        }
        
        toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        
        toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
      
       //List< ? extends IConnection> onSubJobErrorConns = rootNode.getOutgoingConnections(EConnectionType.ON_SUBJOB_ERROR);
       //if(onSubJobErrorConns!=null){
       //    for(IConnection conn : onSubJobErrorConns) {               
       //        toReturn += createCallProcess(conn.getTarget(),  className, isMultiThread);
       //    }
       //}            
        if(isMultiThread){
            toReturn += "\n}catch (Error e_" + rootNode.getUniqueName() + ") {\n";
            toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
            toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
        }
       toReturn += "\n}"; 
       return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);

	List<? extends INode> processNodes = (List<? extends INode>) process.getGeneratingNodes();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	
	boolean stats = codeGenArgument.isStatistics();
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_2);
    
StringBuilder librariesSb = new StringBuilder();
for (INode node : processNodes) {
	if (node.isActivate()) {
		if (node.getComponent().getName().equals("cMessagingEndpoint")) {
			List<Map<String, String>> dependencies = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__HOTLIBS__");
			for(Map<String, String> dependencie : dependencies){
				String librarieJar = dependencie.get("LIBPATH");
				librariesSb.append("\"");
				librariesSb.append(librarieJar);
				librariesSb.append("\",");
			}
		}
	}
}
if(librariesSb.length()>0){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(librariesSb.toString());
    stringBuffer.append(TEXT_4);
    
}
	if(stats) { 
    stringBuffer.append(TEXT_5);
    
		for (INode node : processNodes) {
			if (node.isActivate()) {
				for(int i=0; i<node.getIncomingConnections().size(); i++) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(node.getIncomingConnections().get(i).getUniqueName());
    stringBuffer.append(TEXT_8);
    
				}
			}
		}

    stringBuffer.append(TEXT_9);
     } //if stats 
    stringBuffer.append(TEXT_10);
     if(stats) { 
    stringBuffer.append(TEXT_11);
     } //if stats 
    stringBuffer.append(TEXT_12);
     if(stats) { 
    stringBuffer.append(TEXT_13);
    
		for (INode node : processNodes) {
			if (node.isActivate()) {
				for(int i=0; i<node.getIncomingConnections().size(); i++) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(node.getIncomingConnections().get(i).getUniqueName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_16);
    
				}
			}
		}

    stringBuffer.append(TEXT_17);
     } //if stats 
    stringBuffer.append(TEXT_18);
     for (IContextParameter ctxParam : params){
			String cParaName = ctxParam.getName(); 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_20);
     if(ctxParam.getType().equals("id_Date")){ 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_36);
     } else { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
     } 
    stringBuffer.append(TEXT_41);
    
for (IContextParameter ctxParam : params) {
	if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")) { 
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_45);
    	} else { 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_51);
    	}
}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(jobFolderName );
    stringBuffer.append(TEXT_62);
     
			//for bug TDI-22398
			for (IContextParameter ctxParam :params){ //start for
			    String typeToGenerate ="String";
			    if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value")))
			    {
			       typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
			    }
			    if(typeToGenerate.equals("java.util.Date")){ // start if
			        

    stringBuffer.append(TEXT_63);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_81);
    
		    	}else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String") ){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_85);
    
				}else if(typeToGenerate.equals("Character")&&ctxParam.getName()!=null){

    stringBuffer.append(TEXT_86);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_88);
    
            	}else{

    stringBuffer.append(TEXT_89);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_93);
    
			    } //end if
			} //end for

    stringBuffer.append(TEXT_94);
     
			for (IContextParameter ctxParam :params){
				//about the type, they are same as header.javajet
				String typeToGenerate = "String";
				if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
					typeToGenerate = "String";
				}else{			 
					typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
				}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_99);
    
		}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}