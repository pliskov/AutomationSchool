package helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import user.User;

import java.io.IOException;
import java.util.List;

public class HelperRestAssured {
    public static List<User> getUsers(Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.asString(), new TypeReference<List<User>>(){});
    }

    public static void printUsers(List<User> list) {
        for (User user : list) {
            System.out.println(user.getLogin());
        }
    }
}