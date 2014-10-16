package integrationTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import jpa.Hero;
import jpa.Mission;

import objects.Match;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class IntegrationTest {
	private static final int HERO_FRANK_ID = 931;
	private static final int HERO_FLORIAN_ID = 100;
	private static final int MISSION_JUNIOR_JAVA_DEVELOPER_ID = 1;
	private static final String MISSION_JUNIOR_JAVA_DEVELOPER_NAME = "Junior Java Developer";

	@Test
	public void heroFrankBeeh() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest("http://localhost:8080/zoin/rest-prefix/heroes/"
				+ HERO_FRANK_ID);

		final Hero hero = retrieveResourceFromResponse(httpResponse, Hero.class);
		assertEquals("Frank", hero.getFirstName());
		assertEquals("Beeh", hero.getLastName());
	}

	@Test
	public void missionCatalogContainsJuniorJavaDeveloper()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest("http://localhost:8080/zoin/rest-prefix/missions");

		List<Mission> list = retrieve(httpResponse,
				new TypeReference<List<Mission>>() {
				});
		boolean contains = false;
		for (Mission mission : list) {
			if (mission.getName().contains(MISSION_JUNIOR_JAVA_DEVELOPER_NAME)) {
				contains = true;
			}
		}
		assertTrue(contains);
	}

	@Test
	public void matchesForFlorianBesserContainJuniorJavaDeveloper()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest("http://localhost:8080/zoin/rest-prefix/matches?heroId="
				+ HERO_FLORIAN_ID);

		List<Match> list = retrieve(httpResponse,
				new TypeReference<List<Match>>() {
				});
		boolean contains = false;
		for (Match match : list) {
			assertEquals(HERO_FLORIAN_ID, match.getHeroId());
			if (match.getMissionID() == MISSION_JUNIOR_JAVA_DEVELOPER_ID) {
				contains = true;
			}
		}
		assertTrue(contains);
	}

	@Test
	public void matchesForJuniorJavaDeveloperContainFlorianBesser()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest("http://localhost:8080/zoin/rest-prefix/matches?missionId="
				+ MISSION_JUNIOR_JAVA_DEVELOPER_ID);

		List<Match> list = retrieve(httpResponse,
				new TypeReference<List<Match>>() {
				});
		boolean contains = false;
		for (Match match : list) {
			assertEquals(MISSION_JUNIOR_JAVA_DEVELOPER_ID, match.getMissionID());
			if (match.getHeroId() == HERO_FLORIAN_ID) {
				contains = true;
			}
		}
		assertTrue(contains);
	}
	
	@Test
	public void like()
			throws ClientProtocolException, IOException {
		postRequest("http://localhost:8080/zoin/rest-prefix/want/100/1");
		HttpResponse httpResponse = getRequest("http://localhost:8080/zoin/rest-prefix/want/100");

		List<Long> list = retrieve(httpResponse,
				new TypeReference<List<Long>>() {
				});
		boolean contains = false;
		for (Long match : list) {
			if (match == 1) {
				contains = true;
			}
		}
		assertTrue(contains);
	}

	private HttpResponse getRequest(String uri) throws IOException,
			ClientProtocolException {
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet(uri);

		HttpResponse httpResponse = HttpClientBuilder.create().build()
				.execute(request);

		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine()
				.getStatusCode());
		String mimeType = ContentType.getOrDefault(httpResponse.getEntity())
				.getMimeType();
		assertEquals(jsonMimeType, mimeType);
		return httpResponse;
	}

	private void postRequest(String uri) throws IOException,
			ClientProtocolException {
		HttpUriRequest request = new HttpPost(uri);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(HttpStatus.SC_NO_CONTENT, httpResponse.getStatusLine()
				.getStatusCode());
	}

	private static <T> T retrieve(HttpResponse httpResponse,
			TypeReference<T> valueTypeRef) throws IOException,
			JsonParseException, JsonMappingException {
		String jsonFromResponse = EntityUtils
				.toString(httpResponse.getEntity());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonFromResponse, valueTypeRef);
	}

	private static <T> T retrieveResourceFromResponse(HttpResponse response,
			Class<T> clazz) throws IOException {
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonFromResponse, clazz);
	}

}
