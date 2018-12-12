import helper.HelperApacheHttpComponents;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;
import java.util.List;

public class CollaboratorsApache {
    @Test
    public void getCollaborators() throws IOException {
        HttpRequest httpRequest = new HttpGet("/repos/pliskov/AutomationSchool/collaborators");
        List<User> userList = HelperApacheHttpComponents.getUsers(httpRequest);
        HelperApacheHttpComponents.printUsers(userList);
    }

    @Test
    public void addCollaborator() throws IOException {
        HttpRequest httpRequest = new HttpPut("/repos/pliskov/AutomationSchool/collaborators/fabjke");
        int statusCode = HelperApacheHttpComponents.getResponseStatusCode(httpRequest);
        int successCode = 201;
        if (statusCode == successCode) {
            System.out.println("The invite has been successfully sent");
        } else {
            System.out.println("The invite has not been sent");
        }
        Assert.assertEquals(statusCode, successCode);
    }
}