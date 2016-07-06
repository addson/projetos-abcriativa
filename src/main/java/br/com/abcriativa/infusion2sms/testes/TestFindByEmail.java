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

public class TestFindByEmail {

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
         *   FIND BY EMAIL
         *                                               *
         *************************************************/
        List fields = new ArrayList();
        fields.add("Id");
        fields.add("FirstName");
        fields.add("LastName");
        fields.add("Phone1");

        List parameters = new ArrayList();
        parameters.add(key); //Secure key
        parameters.add("addson@gmail.com");
        parameters.add(fields);
        

        //Make call - the result is an array of structs
        Object[] contacts = (Object[]) client.execute("ContactService.findByEmail", parameters);
        
        List<Object> listContacts = Arrays.asList(contacts);
        
        for (Object contactObj : listContacts) {
        	
        	Map contact = (Map) contactObj;
			System.out.println(contact.get("Id"));
			System.out.println(contact.get("FirstName"));
			System.out.println(contact.get("LastName"));
			System.out.println(contact.get("Phone1"));
		}


	}

}
