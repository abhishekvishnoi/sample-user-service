package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class UserResource {

    private static List<User> users = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(UserResource.class);


    static{
        User user = new User() ;
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@hotmail.com");
        user.setPassword("password1");

        User user1 = new User() ;
        user1.setFirstName("Jane");
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@hotmail.com");
        user1.setPassword("password1");

        users.add(user);
        users.add(user1);
    }

    @GET
    @Path("/getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {

        logger.info("Fetching a record for the Users");
        return users;
    }


    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> addUsers(User user) {
        users.add(user);
        return users;
    }


   /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CriminalRecord getUserCriminalRecord() {

        CriminalRecord cr = new CriminalRecord() ;

        cr.setFirstName("Arushi");
        cr.setLastName("Goyal");
        cr .setFirstTimeOffender(false);

        ArrayList<String> offences = new ArrayList<>();
        offences.add("drink and drive");
        offences.add("loot");

        cr.setOffences(offences);
        return cr;
    }*/

}
