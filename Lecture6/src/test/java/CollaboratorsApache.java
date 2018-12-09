import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;

public class CollaboratorsApache {
    @Test
    public static void getCollaborators() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpHost targetHost = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials("pliskov", "ieNgahN8"));

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicScheme = new BasicScheme();
        authCache.put(targetHost, basicScheme);

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);
        context.setAuthCache(authCache);

        HttpGet httpGet = new HttpGet("/repos/pliskov/AutomationSchool/collaborators");
        CloseableHttpResponse response = httpClient.execute(targetHost, httpGet, context);
        HttpEntity entity = response.getEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        User[] users = objectMapper.readValue(EntityUtils.toString(entity), User[].class);
        for (User user : users) {
            System.out.println(user.getLogin());
        }
        response.close();
    }

    @Test
    public static void addCollaborator() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpHost targetHost = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials("pliskov", "ieNgahN8"));

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicScheme = new BasicScheme();
        authCache.put(targetHost, basicScheme);

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);
        context.setAuthCache(authCache);

        HttpPut httpPut = new HttpPut("/repos/pliskov/AutomationSchool/collaborators/fabjke");
        CloseableHttpResponse response = httpClient.execute(targetHost, httpPut, context);
        int statusCode = response.getStatusLine().getStatusCode();
        response.close();
        if (statusCode == 201) {
            System.out.println("The invite has been successfully sent");
        } else {
            System.out.println("The invite has not been sent");
        }
        Assert.assertEquals(statusCode, 201);
    }
}