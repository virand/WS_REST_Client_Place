/**
 * Created by virand on 6/6/2017.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class App {
    private static final String URL ="http://localhost:8081/rest/places";

    public static void main(String[] args){
        Client client = Client.create();
        printList(getPlaces(client, null, "login","password"));
        System.out.println();
        printList(getPlaces(client,"Исаакиевский собор", "login", "password"));
    }

    private static List<Place> getPlaces(Client client, String name, String login, String password){
        WebResource webResource = client.resource(URL);
        if(name != null){
            webResource=webResource.queryParam("word",name);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON)
                        .header("login", "login")
                        .header("password", "password")
                        .post(ClientResponse.class);
        System.out.println(response.getStatus());

        if(response.getStatus()!=ClientResponse.Status.OK.getStatusCode()){
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Place>>type = new GenericType<List<Place>>(){};
        return response.getEntity(type);
    }

    private static void printList(List<Place> places)
    {
        for (Place place : places)
            System.out.println(place);
    }
}