package br.com.abcriativa.infusion2sms.apiinfusionsoft;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class AutenticadorAppInfusionSoft {
	
	//The secure encryption key
    private String key = "66c059640d5a5b9979c87c80fbf0acd0";
    
	public String getKey() {
		return key;
	}


	public XmlRpcClient autentica() throws MalformedURLException, XmlRpcException {
		
		//Sets up the java client, including the api url
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("https://ou320.infusionsoft.com/api/xmlrpc"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        
        return client;
        
	}

}
