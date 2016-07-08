package br.com.abcriativa.infusion2sms.testes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class TestAddTAGAoContato {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws MalformedURLException, XmlRpcException {
		
		//Sets up the java client, including the api url
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("https://ou320.infusionsoft.com/api/xmlrpc"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        //The secure encryption key
        String key = "66c059640d5a5b9979c87c80fbf0acd0";
        
        /*************************************************
         *                                               *
         *   ADD TAG TO A CONTACT
         *                                               *
         *************************************************/

        List parameters = new ArrayList();
        parameters.add(key); //Secure key
        parameters.add(8); // Contact Id
        parameters.add(114); // TEST_APL_TAG_API TAG Id
        

        //Make call - the result is an array of structs
        Boolean tagAplicada = (Boolean)client.execute("ContactService.addToGroup", parameters);
        
        if(tagAplicada) {
        	System.out.println("TAG TEST_APL_TAG_API Aplicada!!!");
        }
        
	}

}
