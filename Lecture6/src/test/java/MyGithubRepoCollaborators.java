import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class MyGithubRepoCollaborators {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void getListCollaborators() throws IOException {
        Response response = given()
                .auth()
                .preemptive()
                .basic("pliskov", "ieNgahN8")
                .when()
                .get("/repos/pliskov/AutomationSchool/collaborators");
        ObjectMapper objectMapper = new ObjectMapper();
        User[] users = objectMapper.readValue(response.asString(), User[].class);
        for (User user : users) {
            System.out.println(user.getLogin());
        }
    }

    @Test
    public void addCollaborator() {
        Response response = given()
                .auth()
                .preemptive()
                .basic("pliskov", "ieNgahN8")
                .when()
                .put("/repos/pliskov/AutomationSchool/collaborators/fabjke");
        if (response.statusCode() == 201) {
            System.out.println("The invite has been successfully sent");
        } else {
            System.out.println("The invite has not been sent");
        }
        Assert.assertEquals(response.statusCode(), 201);
    }
}