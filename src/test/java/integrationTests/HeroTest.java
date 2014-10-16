package integrationTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class HeroTest {

	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	      throws ClientProtocolException, IOException{
	   // Given
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/zoin/rest-prefix/heroBench" );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
	}
	
}
