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

public class TestEncontraContatoPorTag {

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
         LIST ALL CONTACTS IN GROUP
         *                                               *
         *************************************************/
        List fields = new ArrayList(); //What fields we will be selecting
        fields.add("ContactGroup");
        fields.add("ContactId");

        List parameters3 = new ArrayList();
        parameters3.add(key); //Secure key
        parameters3.add("ContactGroupAssign");  //What table we are looking in
        parameters3.add(new Integer(50)); //How many records to return
        parameters3.add(new Integer(0)); //Which page of results to display
        parameters3.add("GroupId"); //The field we are querying on
        String groupId = "112";
        parameters3.add(new Integer(groupId)); //THe data to query on
        parameters3.add(fields); //what fields to select on return

        //Make call - the result is an array of structs
        Object[] contacts = (Object[]) client.execute("DataService.findByField", parameters3);

        //Loop through results
        for (int i = 0; i < contacts.length; i++) {
            //Each item in the array is a struct
            Map contact = (Map) contacts[i];
            System.out.println("Contact " + contact.get("ContactId") + " was found in group " +
                    contact.get("ContactGroup"));

        }



	}

}
