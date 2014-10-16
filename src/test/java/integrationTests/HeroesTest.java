package integrationTests;

import static org.junit.Assert.*;

import java.io.IOException;

import jpa.Hero;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class HeroesTest {

	@Test
	public void hero931isNamedFrankBeeh() throws ClientProtocolException, IOException{
		HttpResponse httpResponse = sendRequest("http://localhost:8080/zoin/rest-prefix/heroes/931");
		
		Hero hero = retrieveResourceFromResponse(httpResponse, Hero.class);
		//List<Hero> list = retrieve(httpResponse, new TypeReference<List<Hero>>() { });
	    assertEquals( "Frank", hero.getFirstName() );
	    assertEquals( "Beeh", hero.getLastName() );
	}

	private HttpResponse sendRequest(String uri) throws IOException,
			ClientProtocolException {
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet( uri );
	 
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
		String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		assertEquals( jsonMimeType, mimeType );
		return httpResponse;
	}

	private static <T> T retrieve(HttpResponse httpResponse, TypeReference<T> valueTypeRef) throws IOException,
			JsonParseException, JsonMappingException {
		String jsonFromResponse = EntityUtils.toString(httpResponse.getEntity());
	    ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonFromResponse, valueTypeRef);
	}
	
	private static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
	    String jsonFromResponse = EntityUtils.toString(response.getEntity());
	    ObjectMapper mapper = new ObjectMapper();
	    return mapper.readValue(jsonFromResponse, clazz);
	}
	
}
