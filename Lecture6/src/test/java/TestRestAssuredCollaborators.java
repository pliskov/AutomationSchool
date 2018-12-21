import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import helper.HelperRestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.preemptive;

public class TestRestAssuredCollaborators {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.authentication = preemptive().basic("pliskov", "vitalyp1");
    }

    @Test
    public void getListCollaborators() throws IOException {
        Response response = given().get("/repos/pliskov/AutomationSchool/collaborators");
        List<User> userList = HelperRestAssured.getUsers(response);
        HelperRestAssured.printUsers(userList);
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