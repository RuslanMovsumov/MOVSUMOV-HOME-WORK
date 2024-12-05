import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com/";

    @Test
    public void testGetMethod() throws Exception {
        String endpoint = "get?foo1=bar1&foo2=bar2";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        Assert.assertEquals(200, statusCode); // Проверка кода ответа

        String responseBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseBody);
        
        Assert.assertEquals("bar1", jsonResponse.getJSONObject("args").getString("foo1"));
        Assert.assertEquals("bar2", jsonResponse.getJSONObject("args").getString("foo2"));

        httpClient.close();
    }

    @Test
    public void testPostMethod() throws Exception {
        String endpoint = "post";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(BASE_URL + endpoint);
        
        JSONObject json = new JSONObject();
        json.put("foo", "bar");
        StringEntity entity = new StringEntity(json.toString());
        request.setEntity(entity);
        request.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        Assert.assertEquals(200, statusCode); // Проверка кода ответа

        String responseBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseBody);
        
        Assert.assertEquals("bar", jsonResponse.getJSONObject("json").getString("foo"));

        httpClient.close();
    }

    @Test
    public void testPutMethod() throws Exception {
        String endpoint = "put";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(BASE_URL + endpoint);
        
        JSONObject json = new JSONObject();
        json.put("foo", "updatedBar");
        StringEntity entity = new StringEntity(json.toString());
        request.setEntity(entity);
        request.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        Assert.assertEquals(200, statusCode); // Проверка кода ответа

        String responseBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseBody);
        
        Assert.assertEquals("updatedBar", jsonResponse.getJSONObject("json").getString("foo"));

        httpClient.close();
    }

    @Test
    public void testDeleteMethod() throws Exception {
        String endpoint = "delete?foo=bar";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete request = new HttpDelete(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        Assert.assertEquals(200, statusCode); // Проверка кода ответа

        String responseBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseBody);
        
        Assert.assertEquals("bar", jsonResponse.getJSONObject("args").getString("foo"));

        httpClient.close();
    }
}
