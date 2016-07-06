package br.com.abcriativa.infusion2sms.apiinfusionsoft;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

public class EscutadorDeContatosInfusionSoft {
	
	private AutenticadorAppInfusionSoft autenticador;
	
	private XmlRpcClient client = null;

	public EscutadorDeContatosInfusionSoft()  
			throws MalformedURLException, XmlRpcException {
		
		this.autenticador = new AutenticadorAppInfusionSoft();
		
		this.client = autenticador.autentica();
	}

	@SuppressWarnings("unchecked")
	public List<Contato> encontraContatosComTAG(String tag) throws XmlRpcException {
		
		//public void encontraContatosComTAG(String tag) throws XmlRpcException {
		
		@SuppressWarnings("rawtypes")
		List fields = new ArrayList(); //What fields we will be selecting
        fields.add("Contact.Id");
        fields.add("Contact.FirstName");
        fields.add("Contact.LastName");
        fields.add("Contact.Phone1");
        fields.add("ContactGroup");
        //fields.add("ContactId");

        List parameters = new ArrayList();
        parameters.add(autenticador.getKey()); //Secure key
        parameters.add("ContactGroupAssign");  //What table we are looking in
        parameters.add(new Integer(50)); //How many records to return
        parameters.add(new Integer(0)); //Which page of results to display
        parameters.add("ContactGroup"); //The field we are querying on
        String group = tag;
        parameters.add(group); //THe data to query on
        parameters.add(fields); //what fields to select on return

        //Make call - the result is an array of structs
        Object[] contacts = (Object[]) client.execute("DataService.findByField", parameters);

        List<Contato> contatos = new ArrayList<Contato>();
        //Loop through results
        for (int i = 0; i < contacts.length; i++) {
            //Each item in the array is a struct
            Map contactMap = (Map) contacts[i];
            Contato contato = new Contato();
            contato.setId(""+(Integer)contactMap.get("Contact.Id"));
            contato.setFirstName((String)contactMap.get("Contact.FirstName"));
            contato.setLastName((String)contactMap.get("Contact.LastName"));
            contato.setPhone1((String)contactMap.get("Contact.Phone1"));
            contatos.add(contato);
        }
        
        return contatos;
		
	}
	
	

	
}
