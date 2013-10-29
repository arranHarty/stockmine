package org.talend.designer.codegen.translators.esb.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_5 = " = null;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tif (null != ";
  protected final String TEXT_7 = ".body) {" + NL + "\t\t\trequestDoc_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".body.getDocument();" + NL + "\t\t}" + NL + "\t\trequestString_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".string;" + NL + "\t";
  protected final String TEXT_12 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_13 = " = requestDoc_";
  protected final String TEXT_14 = " != null ? requestDoc_";
  protected final String TEXT_15 = " : requestString_";
  protected final String TEXT_16 = ";" + NL + "" + NL + "\t// expected response body" + NL + "\tObject responseDoc_";
  protected final String TEXT_17 = " = null;" + NL + "\t";
  protected final String TEXT_18 = NL + "\tClass<?> responseClass_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "String.class";
  protected final String TEXT_21 = "org.dom4j.Document.class";
  protected final String TEXT_22 = ";" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_23 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "\t";
  protected final String TEXT_24 = NL + "\t\t// set BASIC auth" + NL + "\t\tfactoryBean_";
  protected final String TEXT_25 = ".setUsername(";
  protected final String TEXT_26 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_27 = ".setPassword(";
  protected final String TEXT_28 = ");" + NL + "\t";
  protected final String TEXT_29 = NL + NL + "\tfinal java.util.List<org.apache.cxf.feature.Feature> features_";
  protected final String TEXT_30 = " =" + NL + "\t\t\tnew java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL + "" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tboolean inOSGi = false;" + NL + "\t\ttry {" + NL + "\t\t\tinOSGi = (null != factoryBean_";
  protected final String TEXT_32 = ".getBus().getExtension(Class.forName(\"org.osgi.framework.BundleContext\")));" + NL + "\t\t} catch (ClassNotFoundException e_";
  protected final String TEXT_33 = ") {" + NL + "\t\t\t; // ignore" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tfactoryBean_";
  protected final String TEXT_36 = ".setAddress(\"locator://rest\");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_37 = ".setServiceName(new javax.xml.namespace.QName(" + NL + "\t\t\t";
  protected final String TEXT_38 = "," + NL + "\t\t\t";
  protected final String TEXT_39 = "));" + NL + "" + NL + "\t\tif (!inOSGi) {" + NL + "\t\t\tfactoryBean_";
  protected final String TEXT_40 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "\t\t}" + NL + "" + NL + "\t\torg.talend.esb.servicelocator.cxf.LocatorFeature feature_";
  protected final String TEXT_41 = " =" + NL + "\t\t\t\tnew org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tfinal java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_43 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\tslCustomProps_";
  protected final String TEXT_45 = ".put(";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tfeature_";
  protected final String TEXT_49 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_50 = ");" + NL + "\t\t";
  protected final String TEXT_51 = NL + NL + "\t\tfeatures_";
  protected final String TEXT_52 = ".add(feature_";
  protected final String TEXT_53 = ");" + NL + "\t";
  protected final String TEXT_54 = NL + "\t\tString url = ";
  protected final String TEXT_55 = ";" + NL + "\t\t// {baseUri}tRESTClient" + NL + "\t\tfactoryBean_";
  protected final String TEXT_56 = ".setServiceName(new javax.xml.namespace.QName(url, \"tRESTClient\"));" + NL + "\t\tfactoryBean_";
  protected final String TEXT_57 = ".setAddress(url);" + NL + "\t";
  protected final String TEXT_58 = NL + NL + "\t";
  protected final String TEXT_59 = NL + "\t\torg.talend.esb.sam.agent.feature.EventFeature samEventFeature = null;" + NL + "\t\tif (null == eventFeature) {" + NL + "\t\t\torg.springframework.context.support.ClassPathXmlApplicationContext context = null;" + NL + "\t\t//\tif (inOSGi) {" + NL + "\t\t//\t\tcontext = new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-osgi.xml\");" + NL + "\t\t//\t} else {" + NL + "\t\t\t\tcontext = new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "\t\t//\t}" + NL + "\t\t\tsamEventFeature = context.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t} else {" + NL + "\t\t\tsamEventFeature = (org.talend.esb.sam.agent.feature.EventFeature) eventFeature;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\torg.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "\t\t\tjava.util.Map<String, String> samCustomProps_";
  protected final String TEXT_61 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tsamCustomProps_";
  protected final String TEXT_63 = ".put(";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ");" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\tciHandler.setCustomInfo(samCustomProps_";
  protected final String TEXT_67 = ");" + NL + "\t\t\tsamEventFeature.setHandler(ciHandler);" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\tfeatures_";
  protected final String TEXT_69 = ".add(samEventFeature);" + NL + "\t";
  protected final String TEXT_70 = NL + NL + "\t";
  protected final String TEXT_71 = NL + "\t\tfeatures_";
  protected final String TEXT_72 = ".add(new org.apache.cxf.feature.LoggingFeature());" + NL + "\t";
  protected final String TEXT_73 = NL + NL + "\t";
  protected final String TEXT_74 = NL + "\t   class EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "                    private String correlationId;" + NL + "                    public EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "                        if (null != correlationId && correlationId.length() > 0) {" + NL + "                            this.correlationId = correlationId;" + NL + "                        }" + NL + "                    }" + NL + "                    public String getCorrelationId() {" + NL + "                        return correlationId;" + NL + "                    };" + NL + "                }" + NL + "        final Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_75 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_76 = ".getProperties(true).put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, " + NL + "\t\t\tcorrelationIDCallbackHandler);" + NL + "\t\tfeatures_";
  protected final String TEXT_77 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());" + NL + "\t";
  protected final String TEXT_78 = NL + "\t" + NL + "\tfactoryBean_";
  protected final String TEXT_79 = ".setFeatures(features_";
  protected final String TEXT_80 = ");" + NL + "" + NL + "" + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_81 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_82 = ".add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {" + NL + "\t\t// workaround for https://jira.talendforge.org/browse/TESB-7276" + NL + "\t\tpublic org.dom4j.Document readFrom(Class<org.dom4j.Document> cls," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.reflect.Type type," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.annotation.Annotation[] anns," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MediaType mt," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MultivaluedMap<String, String> headers," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.io.InputStream is)" + NL + "\t\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\t\tString contentLength = headers.getFirst(\"Content-Length\");" + NL + "\t\t\tif (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)" + NL + "\t\t\t\t&& Integer.valueOf(contentLength) <= 0) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\treturn org.dom4j.DocumentHelper.parseText(\"<root/>\");" + NL + "\t\t\t\t} catch (org.dom4j.DocumentException e_";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t\t\te_";
  protected final String TEXT_84 = ".printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn super.readFrom(cls, type, anns, mt, headers, is);" + NL + "\t\t}" + NL + "\t});" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_85 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\t\tjsonProvider_";
  protected final String TEXT_86 = ".setIgnoreNamespaces(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_87 = ".setAttributesToElements(true);" + NL + "\t";
  protected final String TEXT_88 = NL + "\t";
  protected final String TEXT_89 = NL + "\t\tjsonProvider_";
  protected final String TEXT_90 = ".setSupportUnwrapped(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_91 = ".setWrapperName(\"root\");" + NL + "\t";
  protected final String TEXT_92 = NL + "\t";
  protected final String TEXT_93 = NL + "\t\tjsonProvider_";
  protected final String TEXT_94 = ".setDropRootElement(";
  protected final String TEXT_95 = ");" + NL + "\tproviders_";
  protected final String TEXT_96 = ".add(jsonProvider_";
  protected final String TEXT_97 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_98 = ".setProviders(providers_";
  protected final String TEXT_99 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_100 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_101 = " = factoryBean_";
  protected final String TEXT_102 = ".createWebClient();" + NL + "" + NL + "\t// set request path" + NL + "\twebClient_";
  protected final String TEXT_103 = ".path(";
  protected final String TEXT_104 = ");" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_";
  protected final String TEXT_105 = " = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_106 = ");" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_107 = " = clientConfig_";
  protected final String TEXT_108 = ".getHttpConduit();" + NL + "\tconduit_";
  protected final String TEXT_109 = ".getClient().setReceiveTimeout((long)(";
  protected final String TEXT_110 = " * 1000L));" + NL + "\tconduit_";
  protected final String TEXT_111 = ".getClient().setConnectionTimeout((long)(";
  protected final String TEXT_112 = " * 1000L));" + NL + "\t";
  protected final String TEXT_113 = NL + "\t\tconduit_";
  protected final String TEXT_114 = ".getClient().setAutoRedirect(true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_115 = ".getRequestContext().put(\"http.redirect.relative.uri\", true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_116 = ".getRequestContext().put(\"http.redirect.same.host.only\", ";
  protected final String TEXT_117 = ");" + NL + "\t";
  protected final String TEXT_118 = NL + "\t";
  protected final String TEXT_119 = NL + "\t\tconduit_";
  protected final String TEXT_120 = ".getClient().setProxyServer(";
  protected final String TEXT_121 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_122 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_123 = "));" + NL + "\t\tconduit_";
  protected final String TEXT_124 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_125 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_126 = ".getProxyAuthorization().setPassword(";
  protected final String TEXT_127 = ");" + NL + "\t";
  protected final String TEXT_128 = NL + NL + "\t";
  protected final String TEXT_129 = NL + "\t\t// set Content-Type" + NL + "\t\twebClient_";
  protected final String TEXT_130 = ".type(\"";
  protected final String TEXT_131 = "\");" + NL + "\t";
  protected final String TEXT_132 = NL + NL + "\t";
  protected final String TEXT_133 = NL + "\t\t// set Accept-Type" + NL + "\t\twebClient_";
  protected final String TEXT_134 = ".accept(\"";
  protected final String TEXT_135 = "\");" + NL + "\t";
  protected final String TEXT_136 = NL + NL + "\t";
  protected final String TEXT_137 = NL + "\t\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_138 = NL + "\t\twebClient_";
  protected final String TEXT_139 = ".header(";
  protected final String TEXT_140 = ", ";
  protected final String TEXT_141 = ");" + NL + "\t";
  protected final String TEXT_142 = NL + NL + "\t";
  protected final String TEXT_143 = NL + "\t\t// set oAuth2 bearer token" + NL + "\t\twebClient_";
  protected final String TEXT_144 = ".header(\"Authorization\", \"Bearer \" + ";
  protected final String TEXT_145 = ");" + NL + "\t";
  protected final String TEXT_146 = NL + NL + "\t";
  protected final String TEXT_147 = NL + "\t\tif (null != stsProps) {" + NL + "\t\t\t// set SAML Token authentication" + NL + "\t\t\tSTSRESTOutInterceptor outInterceptor = new STSRESTOutInterceptor();" + NL + "\t\t\toutInterceptor.setStsClient(createStsClient(factoryBean_";
  protected final String TEXT_148 = ".getBus(), stsProps," + NL + "\t\t\t\t\t";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = "));" + NL + "\t\t\tclientConfig_";
  protected final String TEXT_151 = ".getOutInterceptors().add(outInterceptor);" + NL + "\t\t\tclientConfig_";
  protected final String TEXT_152 = ".getOutInterceptors().add(new org.apache.cxf.rs.security.saml.SamlHeaderOutInterceptor());" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_153 = NL + NL + "\t";
  protected final String TEXT_154 = NL + "\tif (null != stsProps) {" + NL + "\t \tSTSRESTOutInterceptor outInterceptor = new STSRESTOutInterceptor();" + NL + "\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = createStsClient(factoryBean_";
  protected final String TEXT_155 = ".getBus(), stsProps," + NL + "\t\t\t";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = ");" + NL + "\t\t\t\t\t" + NL + "\t\torg.w3c.dom.Document doc = org.apache.cxf.helpers.DOMUtils.createDocument();" + NL + "        org.w3c.dom.Element claimsElement = doc.createElementNS(\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\", \"Claims\");" + NL + "        claimsElement.setAttributeNS(null, \"Dialect\", \"http://schemas.xmlsoap.org/ws/2005/05/identity\");" + NL + "        String role = ";
  protected final String TEXT_158 = ";" + NL + "        if (\"\" != role && null != role){" + NL + "        \torg.w3c.dom.Element claimValueElement = doc.createElementNS(\"http://schemas.xmlsoap.org/ws/2005/05/identity\", \"ClaimValue\");" + NL + "        \tclaimValueElement.setAttributeNS(null, \"Uri\", \"http://schemas.xmlsoap.org/ws/2005/05/identity/claims/role\");" + NL + "        " + NL + "       \t\torg.w3c.dom.Element value = doc.createElementNS(\"http://schemas.xmlsoap.org/ws/2005/05/identity\", \"Value\");" + NL + "       \t\tvalue.setTextContent(role);" + NL + "      \t\tclaimValueElement.appendChild(value);" + NL + "\t        claimsElement.appendChild(claimValueElement);" + NL + "\t    }else{" + NL + "\t    \torg.w3c.dom.Element claimType = doc.createElementNS(\"http://schemas.xmlsoap.org/ws/2005/05/identity\", \"ClaimType\");" + NL + "         \tclaimType.setAttributeNS(null, \"Uri\", \"http://schemas.xmlsoap.org/ws/2005/05/identity/claims/role\");" + NL + "\t \t\tclaimsElement.appendChild(claimType);" + NL + "\t    }" + NL + "        stsClient.setClaims(claimsElement);" + NL + "\t \toutInterceptor.setStsClient(stsClient);" + NL + "\t \tclientConfig_";
  protected final String TEXT_159 = ".getOutInterceptors().add(outInterceptor);" + NL + "\t \tclientConfig_";
  protected final String TEXT_160 = ".getOutInterceptors().add(new org.apache.cxf.rs.security.saml.SamlHeaderOutInterceptor());" + NL + "\t     " + NL + "\t }" + NL + "\t";
  protected final String TEXT_161 = NL + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_162 = NL + "\t\torg.apache.cxf.jaxrs.ext.form.Form form_";
  protected final String TEXT_163 = " = new org.apache.cxf.jaxrs.ext.form.Form();" + NL + "\t\t";
  protected final String TEXT_164 = NL + "\t\t\tform_";
  protected final String TEXT_165 = ".set(";
  protected final String TEXT_166 = " ,";
  protected final String TEXT_167 = ");" + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\trequestBody_";
  protected final String TEXT_169 = " = form_";
  protected final String TEXT_170 = ";" + NL + "\t";
  protected final String TEXT_171 = NL + "\t\t";
  protected final String TEXT_172 = NL + "\t\t\twebClient_";
  protected final String TEXT_173 = ".query(";
  protected final String TEXT_174 = " ,";
  protected final String TEXT_175 = ");" + NL + "\t\t";
  protected final String TEXT_176 = NL + "\t";
  protected final String TEXT_177 = NL + NL + NL + "\ttry {" + NL + "\t\t// start send request" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_179 = " = webClient_";
  protected final String TEXT_180 = ".get(responseClass_";
  protected final String TEXT_181 = ");" + NL + "\t\t";
  protected final String TEXT_182 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_183 = " = webClient_";
  protected final String TEXT_184 = ".post(requestBody_";
  protected final String TEXT_185 = ", responseClass_";
  protected final String TEXT_186 = ");" + NL + "\t\t";
  protected final String TEXT_187 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_188 = " = webClient_";
  protected final String TEXT_189 = ".put(requestBody_";
  protected final String TEXT_190 = ", responseClass_";
  protected final String TEXT_191 = ");" + NL + "\t\t";
  protected final String TEXT_192 = NL + "\t\t\twebClient_";
  protected final String TEXT_193 = ".invoke(\"";
  protected final String TEXT_194 = "\", requestBody_";
  protected final String TEXT_195 = ");" + NL + "\t\t";
  protected final String TEXT_196 = NL + NL + NL + "\t\tint webClientResponseStatus_";
  protected final String TEXT_197 = " = webClient_";
  protected final String TEXT_198 = ".getResponse().getStatus();" + NL + "\t\tif (webClientResponseStatus_";
  protected final String TEXT_199 = " >= 300) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(webClient_";
  protected final String TEXT_200 = ".getResponse());" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_201 = NL + "\t\t\tif (";
  protected final String TEXT_202 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_203 = " = new ";
  protected final String TEXT_204 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_205 = ".statusCode = webClientResponseStatus_";
  protected final String TEXT_206 = ";" + NL + "\t\t\tif (responseDoc_";
  protected final String TEXT_207 = " != null) {" + NL + "\t\t\t\tif (responseClass_";
  protected final String TEXT_208 = " == String.class) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_209 = ".string = (String) responseDoc_";
  protected final String TEXT_210 = ";" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\troutines.system.Document responseTalendDoc_";
  protected final String TEXT_211 = " = null;" + NL + "\t\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_212 = ") {" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_213 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_214 = ".setDocument((org.dom4j.Document) responseDoc_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_216 = ".body = responseTalendDoc_";
  protected final String TEXT_217 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_218 = "_HEADERS\", webClient_";
  protected final String TEXT_219 = ".getResponse().getHeaders());" + NL + "\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\tif (null != webClient_";
  protected final String TEXT_221 = ".getResponse().getHeaders().get(\"CorrelationID\")){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_222 = "_CORRELATION_ID\", webClient_";
  protected final String TEXT_223 = ".getResponse().getHeaders().get(\"CorrelationID\").get(0));" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_224 = NL + "\t\t";
  protected final String TEXT_225 = NL + NL + "\t} catch (javax.ws.rs.WebApplicationException ex_";
  protected final String TEXT_226 = ") {" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t\t\tif (";
  protected final String TEXT_228 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_229 = " = new ";
  protected final String TEXT_230 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_231 = ".errorCode = ex_";
  protected final String TEXT_232 = ".getResponse().getStatus();" + NL + "" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_233 = " = ex_";
  protected final String TEXT_234 = ".getMessage();" + NL + "\t\t\tif (null == errorMessage_";
  protected final String TEXT_235 = " || 0 == errorMessage_";
  protected final String TEXT_236 = ".trim().length()) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\terrorMessage_";
  protected final String TEXT_237 = " = ex_";
  protected final String TEXT_238 = ".getResponse().readEntity(String.class);" + NL + "\t\t\t\t} catch (Exception exe_";
  protected final String TEXT_239 = ") {" + NL + "\t\t\t\t\t// ignore" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_240 = ".errorMessage = errorMessage_";
  protected final String TEXT_241 = ";" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_242 = "_HEADERS\", ex_";
  protected final String TEXT_243 = ".getResponse().getHeaders());" + NL + "\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\tif (null != webClient_";
  protected final String TEXT_245 = ".getResponse().getHeaders().get(\"CorrelationID\")){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_246 = "_CORRELATION_ID\", webClient_";
  protected final String TEXT_247 = ".getResponse().getHeaders().get(\"CorrelationID\").get(0));" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_248 = NL + "\t\t";
  protected final String TEXT_249 = NL + "\t\t\tthrow ex_";
  protected final String TEXT_250 = ";" + NL + "\t\t";
  protected final String TEXT_251 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_252 = ") {" + NL + "\t";
  protected final String TEXT_253 = NL + "\t\tthrow new TalendException(e_";
  protected final String TEXT_254 = ", currentComponent, globalMap);" + NL + "\t";
  protected final String TEXT_255 = NL + "\t\tnew TalendException(e_";
  protected final String TEXT_256 = ", currentComponent, globalMap).printStackTrace();" + NL + "\t";
  protected final String TEXT_257 = NL + "}";
  protected final String TEXT_258 = NL;

	private INode node;
	private IConnection inputConn;
	private IConnection connResponse;
	private IConnection connFault;
	private List<IConnection> dataOutputs;
	private NodeParamsHelper paramsHelper;

	//code generation options:
	String cid;
	String method;
	String acceptType;
	String contentType;
	boolean useAuth;
	boolean useAuthorization;
	String authType; 
	boolean isSLEnable;
	boolean isSAMEnable;
	boolean isStudioEEVersion;
	boolean useBusinessCorrelation;

	private void clearCache() {
		node = null;
		inputConn = null;
		connFault = null;
		connResponse = null;
		dataOutputs = null;
		paramsHelper = null;
	}

	public void initOptions(INode node) {
		clearCache();
		setNode(node);
		initConnections();
		initProps();
	}

	public void setNode(INode node) {
		this.node = node;
		paramsHelper = new NodeParamsHelper(node);
	}

	private void initConnections() {
		NodeConnectionsHelper connections = new NodeConnectionsHelper(node);
		inputConn = connections.getInputConn();
		connResponse = connections.getOutputConnResponse();
		connFault = connections.getOutputConnFault();
		dataOutputs = connections.getDataOutputs();
	}

	private void initProps() {
		cid = node.getUniqueName();

		method = getStringParam("__METHOD__");
		acceptType = getStringParam("__ACCEPT_TYPE__");
		if(acceptType == null) {
			acceptType = "application/xml";
		}
		contentType = getStringParam("__CONTENT_TYPE__");
		if(contentType == null) {
			contentType = "application/xml";
		}
		useAuth = getBoolParam("__NEED_AUTH__");
		useAuthorization = getVisibleBoolParam("__NEED_AUTHORIZATION__");
		authType = getStringParam("__AUTH_TYPE__");
		isSLEnable = getBoolParam("__SERVICE_LOCATOR__");
		isSAMEnable = getBoolParam("__SERVICE_ACTIVITY_MONITOR__");
		useBusinessCorrelation = getBoolParam("__USE_BUSINESS_CORRELATION__");
	}

	private List<Entry<String, String>> getSLProperties(){
		return getPropertiesPram("__SERVICE_LOCATOR_CUSTOM_PROPERTIES__");
	}

	private List<Entry<String, String>> getSAMProperties(){
		return getPropertiesPram("__SERVICE_ACTIVITY_MONITOR_CUSTOM_PROPERTIES__");
	}

	private <T> T getObjectParam(String key) {
		return paramsHelper.getObjectParam(key);
	}

	private String getStringParam(String key) {
		return paramsHelper.getStringParam(key);
	}

	private String getVisibleStringParam(String key) {
		return paramsHelper.getVisibleStringParam(key);
	}

	private boolean getBoolParam(String key) {
		return paramsHelper.getBoolParam(key);
	}

	private boolean getVisibleBoolParam(String key) {
		return paramsHelper.getVisibleBoolParam(key);
	}

	private List<Entry<String, String>> getPropertiesPram(String key){
		return paramsHelper.getPropertiesPram(key);
	}

	public String generate(CodeGeneratorArgument argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
INode node = (INode) argument.getArgument();
initOptions(node);

//clear connection row data
for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
}


    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
     if (null != inputConn) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		String convertResponseToDomProperty = getStringParam("__CONVERT_RESPONSE_TO_DOM__");
		boolean convertResponseToDom = convertResponseToDomProperty == null ? true : Boolean.valueOf(convertResponseToDomProperty);
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
     if ("*/*".equals(acceptType) || !convertResponseToDom) { 
    stringBuffer.append(TEXT_20);
     } else { 
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
     if (useAuth && "BASIC".equals(authType)) { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(getStringParam("__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if (isSLEnable || isSAMEnable) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
     } 
    stringBuffer.append(TEXT_34);
     if (isSLEnable) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(getStringParam("__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(getStringParam("__SERVICE_NAME__"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     List<Entry<String, String>> customProperties = getSLProperties();
		if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
     for (Entry<String,String> prop : customProperties) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_47);
     } 
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
     } else { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(getStringParam("__URL__"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
     if (isSAMEnable) { 
    stringBuffer.append(TEXT_59);
     List<Entry<String, String>> samCustomProperties = getSAMProperties();
		if (!samCustomProperties.isEmpty()) { 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
     for (Entry<String,String> prop : samCustomProperties) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_65);
     } 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
     } 
    stringBuffer.append(TEXT_70);
     if (getBoolParam("__LOG_MESSAGES__")) { 
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(getStringParam("__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
     } 
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
    
		String wrapJsonResponseProperty = getStringParam("__WRAP_JSON_RESPONSE__");
		boolean wrapJsonResponse = wrapJsonResponseProperty == null ? true : Boolean.valueOf(wrapJsonResponseProperty);
	
    stringBuffer.append(TEXT_88);
     if (wrapJsonResponse) { 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
     } 
    stringBuffer.append(TEXT_92);
    
		boolean dropJsonRoot = (("POST".equals(method) || "PUT".equals(method)) && "application/json".equals(contentType))
				? getBoolParam("__UNWRAP_JSON_REQUEST__") : false;
	
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(dropJsonRoot);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(getStringParam("__PATH__"));
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
    stringBuffer.append(getStringParam("__RECEIVE_TIMEOUT__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(getStringParam("__CONNECTION_TIMEOUT__"));
    stringBuffer.append(TEXT_112);
     if (getBoolParam("__FOLLOW_REDIRECTS__")) { 
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(!getBoolParam("__REDIRECT_NON_SAME_HOST__"));
    stringBuffer.append(TEXT_117);
     } 
    stringBuffer.append(TEXT_118);
     if (getBoolParam("__USE_PROXY__")) { 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(getStringParam("__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_127);
     } 
    stringBuffer.append(TEXT_128);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_131);
     } 
    stringBuffer.append(TEXT_132);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_135);
     } 
    stringBuffer.append(TEXT_136);
     List<Map<String, String>> headers = getObjectParam("__HEADERS__"); 
    stringBuffer.append(TEXT_137);
     for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(header.get("NAME"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(header.get("VALUE"));
    stringBuffer.append(TEXT_141);
     } 
    stringBuffer.append(TEXT_142);
     if (useAuth && "OAUTH2_BEARER".equals(authType)) { 
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(getStringParam("__AUTH_BEARER_TOKEN__"));
    stringBuffer.append(TEXT_145);
     } 
    stringBuffer.append(TEXT_146);
     if (useAuth && "SAML".equals(authType) && !useAuthorization) { 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(getStringParam("__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
     } 
    stringBuffer.append(TEXT_153);
     if (useAuth && "SAML".equals(authType) && useAuthorization) { 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(getStringParam("__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(getStringParam("__ROLE__"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
     } 
    stringBuffer.append(TEXT_161);
     List<Map<String, String>> queries = getObjectParam("__QUERY__");
		if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_167);
     } 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
     } else { 
    stringBuffer.append(TEXT_171);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_175);
     } 
    stringBuffer.append(TEXT_176);
     } 
    stringBuffer.append(TEXT_177);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
     } else if ("PUT".equals(method)) { 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
     } else { 
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
     } 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_201);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
     } 
    stringBuffer.append(TEXT_224);
     } 
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
     } 
    stringBuffer.append(TEXT_248);
     } else { 
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
     } 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
     if (getBoolParam( "__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
     } else { 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
     } 
    stringBuffer.append(TEXT_257);
     clearCache(); 
    stringBuffer.append(TEXT_258);
    return stringBuffer.toString();
  }
}