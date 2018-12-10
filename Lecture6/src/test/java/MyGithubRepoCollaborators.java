import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.preemptive;

public class MyGithubRepoCollaborators {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.authentication = preemptive().basic("pliskov", "vitalyp1");
    }

    @Test
    public void getListCollaborators() throws IOException {
        Response response = given().get("/repos/pliskov/AutomationSchool/collaborators");
        ObjectMapper objectMapper = new ObjectMapper();
            User[] users = objectMapper.readValue(response.asString(), User[].class);
            for (User user : users) {
                System.out.println(user.getLogin());
            }
    }

    @Test
    public void addCollaborator() {
        Response response = given().put("/repos/pliskov/AutomationSchool/collaborators/fabjke");
        int successCode = 201;
        if (response.statusCode() == successCode) {
            System.out.println("The invite has been successfully sent");
        } else {
            System.out.println("The invite has not been sent");
        }
        Assert.assertEquals(response.statusCode(), successCode);
    }
}