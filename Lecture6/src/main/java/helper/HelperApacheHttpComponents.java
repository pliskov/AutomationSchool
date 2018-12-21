package helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import user.User;

import java.io.IOException;
import java.util.List;

public class HelperApacheHttpComponents {
    public static List<User> getUsers(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = objectMapper.readValue(EntityUtils.toString(entity), new TypeReference<List<User>>() {
        });
        response.close();
        return userList;
    }

    public static int getResponseStatusCode(CloseableHttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        response.close();
        return statusCode;
    }

    public static CloseableHttpResponse sendRequest(HttpRequest httpRequest) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpHost targetHost = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials("pliskov", "vitalyp1"));
        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicScheme = new BasicScheme();
        authCache.put(targetHost, basicScheme);
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);
        context.setAuthCache(authCache);
        return httpClient.execute(targetHost, httpRequest, context);
    }

    public static void printUsers(List<User> list) {
        for (User user : list) {
            System.out.println(user.getLogin());
        }
    }
}