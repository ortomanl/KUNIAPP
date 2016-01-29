package jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import com.unisys.fondiapp.jto.JtoAddressDetails;
import com.unisys.fondiapp.jto.JtoAnagrafica;
import com.unisys.fondiapp.jto.JtoAzienda;
import com.unisys.fondiapp.jto.JtoContactDetails;

@Path("azienda")
public class AziendaRestService {
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response createJsonAzienda(JtoAzienda azienda){
		List<JtoAzienda> listAzienda = new ArrayList<JtoAzienda>();
		listAzienda = createAziendaList();
		
		for (JtoAzienda az: listAzienda) {
			if(az.getUsername().equals(azienda.getUsername()) && az.getPassword().equals(azienda.getPassword())){
				return Response.status(200).entity("OK").build() ;
			}
			
		}
		return Response.status(404).entity("NE").build();
		
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JtoAzienda createJsonAz(JtoAzienda azienda){
		List<JtoAzienda> listAzienda = new ArrayList<JtoAzienda>();
		listAzienda = createAziendaList();
		
		for (JtoAzienda az: listAzienda) {
			if(az.getUsername().equals(azienda.getUsername()) && az.getPassword().equals(azienda.getPassword())){
				return az ;
			}
			
		}
		return null;
		
	}
	
	@POST
	@Path("/user/{userName}/{pass}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public JtoAzienda login(@PathParam("userName") String userName, @PathParam("pass") String pass){
		List<JtoAzienda> listAzienda = new ArrayList<JtoAzienda>();
		listAzienda = createAziendaList();
		
		for (JtoAzienda az: listAzienda) {
			if(userName.equals(az.getUsername()) && az.getPassword().equals(pass)){
				return az ;
			}
			
		}
		return null;
		
	}
	
	

	

	private List<JtoAzienda> createAziendaList() {
		
		JtoAzienda az1 = new JtoAzienda();
		JtoAzienda az2 = new JtoAzienda();
		JtoAzienda az3 = new JtoAzienda();
		
		
		az1.setUsername("az1");
		az1.setPassword("az1");
		az1.setCompanyCode("AZ12345FT");
		
		az2.setUsername("az2");
		az2.setPassword("az2");
		
		JtoAnagrafica an1 = new JtoAnagrafica();
		an1.setCompanyName("company1");
		an1.setCorporateLegalForm("d.o.o.");
		JtoContactDetails con1 = new JtoContactDetails();
		con1.setEmail("email@gmail.com");
		an1.setJtoContactDetails(con1);
		
		
		
		JtoAddressDetails address1 = new JtoAddressDetails();
		address1.setAddress("adress1");
		address1.setCity("Nis");
		address1.setStreetNumber("18");
		address1.setPostcode("18000");
		
		an1.setJtoAddressDetails(address1);
		
		az1.setJtoAnagrafica(an1);
		
		
		
		
		List<JtoAzienda> listAz = new ArrayList<JtoAzienda>();
		listAz.add(az1);
		listAz.add(az2);
		
		return listAz;
	}

}
