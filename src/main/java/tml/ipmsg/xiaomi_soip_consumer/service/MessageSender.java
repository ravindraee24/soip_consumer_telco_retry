package tml.ipmsg.xiaomi_soip_consumer.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Optional;

import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import tml.ipmsg.xiaomi_soip.model.WebRequest;

import tml.ipmsg.xiaomi_soip_consumer.Dao.MessageDao;
import tml.ipmsg.xiaomi_soip_consumer.entity.ClientMaster;
import tml.ipmsg.xiaomi_soip_consumer.entity.Message;
import tml.ipmsg.xiaomi_soip_consumer.model.PushResponse;
import tml.ipmsg.xiaomi_soip_consumer.model.submitResponses;
import tml.ipmsg.xiaomi_soip_consumer.repository.ClientRepository;
import tml.ipmsg.xiaomi_soip.entity.client;
@Service
public class MessageSender {
	@Value("${pro.connect.timeout}")
	private int proConnectTimeout;
	@Value("${pro.url}")
	private String proURL;
	@Value("${pro.read.timeout}")
	
	private int proReadTimeout;
	@Autowired 
	private ClientCache clientcache;
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private Environment env;
	@Autowired
	ClientRepository clientRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	public String SendmessageToPro(WebRequest webRequest) throws IOException
	{
	 
		Optional<ClientMaster> clientMaster=clientRepository.findById(Long.valueOf( webRequest.getUsername()));
		ClientMaster clientEntity = clientMaster.get();
		client objcnt=(client) clientcache.findByName("clientCache",clientEntity.getUsername());
		 Gson gson = new Gson();
		 JsonParser parser =new  JsonParser();
		 //JsonObject object = (JsonObject) parser.parse(objclnt.getCredentials());// response will be the json String
		 tml.ipmsg.xiaomi_soip_consumer.model.Credentials objcredentials = gson.fromJson(objcnt.getCredentials(),tml.ipmsg.xiaomi_soip_consumer.model.Credentials.class); 
		
		String smsUser=objcredentials.getSms_api_uid();
		String smsPassword=objcredentials.getSms_api_pwd();
		
		String plateformurl=env.getProperty(objcnt.getSms_platform()+".url").replace("{username}", smsUser)
				.replace("{password}", smsPassword)
				.replace("{unicode}", webRequest.getUnicode())
				.replace("{from}", webRequest.getFrom())
				.replace("{msisdn}", webRequest.getMsisdn())
				.replace("{msg}", webRequest.getMessage())
				.replace("{templateid}", webRequest.getTemplateid())
				.replace("{corelationid}", webRequest.getCorelationid())
				//.replace("{templateid}", webRequest.getTemplateid())
				;
		String responseString="";
		submitResponses result =new submitResponses();
		URL url = new URL(plateformurl);
		System.out.println(url+";;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		RestTemplate restTemplate;
		try {
			restTemplate = restTemplate();
			 result =restTemplate.getForObject(plateformurl, submitResponses.class);
			LOGGER.info(""+result);
			
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
			

                 responseString =ex.getMessage().replace("400 : [", "").replace("}]", "}");
                 ObjectMapper objectMapper = new ObjectMapper();
                 submitResponses res = objectMapper.readValue(responseString, submitResponses.class);
                 Message msg=new Message();
                 msg.setPhone(webRequest.getMsisdn());
                 msg.setMessage_type(1);
                 msg.setBizExtra(objcnt.getId()+"|"+webRequest.getUuid()+"|"+webRequest.getCorelationid());
         		msg.setBizMsgId(webRequest.getUuid());
         		msg.setBizNum(webRequest.getFrom());
         		msg.setClient_id(objcnt.getId());
         		msg.setContent(webRequest.getMessage());
         		msg.setDelivery_status("SUBMIT_FAILED");
         		msg.setDlttemplateid(webRequest.getTemplateid());
         		msg.setUnicode(webRequest.getUnicode());
         		msg.setMsgId(String.valueOf( res.getTransactionId()));
         		msg.setResponse(res.toString());
         		//msg.
         		messageDao.Save(msg);
                 return res.toString();
                
            
		}
		
  			
        
       
        Message msg=new Message();
        msg.setPhone(webRequest.getMsisdn());
        msg.setMessage_type(1);
        msg.setBizExtra(objcnt.getId()+"|"+webRequest.getUuid()+"|"+webRequest.getCorelationid());
		msg.setBizMsgId(webRequest.getUuid());
		msg.setBizNum(webRequest.getFrom());
		msg.setClient_id(objcnt.getId());
		msg.setContent(webRequest.getMessage());
		msg.setDelivery_status("SUBMIT_ACCEPTED");
		msg.setDlttemplateid(webRequest.getTemplateid());
		msg.setUnicode(webRequest.getUnicode());
		msg.setMsgId(String.valueOf( result.getTransactionId()));
		msg.setResponse(result.toString());
		//msg.
		messageDao.Save(msg);
        return result.toString();
	}
	public RestTemplate restTemplate() 
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
			TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

			SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

				SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

				CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                
                .build();

				HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

				requestFactory.setHttpClient(httpClient);
				RestTemplate restTemplate = new RestTemplate(requestFactory);
				return restTemplate;
}
}
