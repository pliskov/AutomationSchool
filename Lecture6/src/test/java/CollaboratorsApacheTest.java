import helper.HelperApacheHttpComponents;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;
import java.util.List;

public class CollaboratorsApacheTest {
    @Test
    public void getCollaborators() throws IOException {
        HttpRequest httpRequest = new HttpGet("/repos/pliskov/AutomationSchool/collaborators");
        CloseableHttpResponse response = HelperApacheHttpComponents.sendRequest(httpRequest);
        List<User> userList = HelperApacheHttpComponents.getUsers(response);
        HelperApacheHttpComponents.printUsers(userList);
    }

    @Test
    public void addCollaborator() throws IOException {
        HttpRequest httpRequest = new HttpPut("/repos/pliskov/AutomationSchool/collaborators/fabjke");
        CloseableHttpResponse response = HelperApacheHttpComponents.sendRequest(httpRequest);
        int statusCode = HelperApacheHttpComponents.getResponseStatusCode(response);
        int successCode = 201;
        if (statusCode == successCode) {
            System.out.println("The invite has been successfully sent");
        } else {
            System.out.println("The invite has not been sent");
        }
        Assert.assertEquals(statusCode, successCode);
    }
}