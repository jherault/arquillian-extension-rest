package org.jboss.arquillian.example;

import org.jboss.arquillian.container.test.api.Deployment;

import org.jboss.arquillian.junit.Arquillian;

import org.jboss.arquillian.rest.annotations.*;
import org.jboss.arquillian.rest.annotations.configuration.*;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ClientFactory;

/**
 * Arquillian Extension REST API Test Case
 *
 * Annotate the TestClass's TestMethods with JAX-RS Client annotations.
 *
 * Executes the REST request in the background for so to inject back the Response into the TestMethods arguments.
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@RunWith(Arquillian.class)
public class RESTExtensionTest {

    @POSTData(id=1)
    public Person data1;

    @Deployment(testable = false)
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(Person.class.getPackage())
                //...
                ;
    }

    @Before
    @Register(provider=PersonProvider.class)
    public void setup(){

        data1 = new Person();
        //init data1 for the post request test
    }

    @Test @GET @Path("/person")
    @QueryParams({@QueryParam(name = "hair", value = "blond"),@QueryParam(name = "eye", value = "blue")})
    @Request({MediaType.APPLICATION_JSON})
    @Cookies({@Cookie(name="connected", value="true")})
    public void test1(Person person){


         //This is equivalent to:

         Client client = ClientFactory.newClient();
         Target target = client.target("http://<host>:<port>/<base-url>/person");
         target.configuration().register(PersonProvider.class);
         Person person1 = target
               .queryParam("hair","blond")
               .queryParam("eye","blue")
               .request(MediaType.APPLICATION_JSON)
               .header("User-Agent","Arquillian REST extension :-)")
               .cookie(new NewCookie("connected","true"))
               .get(Person.class);


        assertThat(person.eye).isEqualTo("blue");
        assertThat(person.hair).isEqualTo("blond");
    }

    @Test @POST @Path("/person")
    @POSTDatas({1})
    @HeaderParams({@HeaderParam(name="User-Agent", value="Arquillian REST extension :-)")})
    public void test2(String response){

       assertThat(response).isEqualTo("OK: Received a new person from Arquillian REST extension, really weird");
    }
}
