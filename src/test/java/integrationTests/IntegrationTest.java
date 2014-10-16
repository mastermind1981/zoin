package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import jpa.Hero;
import jpa.Mission;
import jpa.Role;
import jpa.Skill;
import objects.Match;
import objects.Score;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class IntegrationTest {
	private static final String REST_PREFIX = "http://localhost:8080/zoin/rest-prefix/";
	private static final Long HERO_FRANK_ID = 931l;
	private static final Long HERO_FLORIAN_ID = 100l;
	private static final Long MISSION_JUNIOR_JAVA_DEVELOPER_ID = 10001l;
	private static final String MISSION_JUNIOR_JAVA_DEVELOPER_NAME = "Junior Java Developer";

	@Test
	public void heroFrankBeeh() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest(getHeroesUrl() + "/"
				+ HERO_FRANK_ID);

		final Hero hero = retrieveResourceFromResponse(httpResponse, Hero.class);
		assertEquals("Frank", hero.getFirstName());
		assertEquals("Beeh", hero.getLastName());
		assertEquals(Role.PrincipalConsultant, hero.getRole());
		assertEquals(
				new HashSet<Skill>(Arrays.asList(Skill.Java, Skill.Ant,
						Skill.Architektur, Skill.UITesting, Skill.UnitTesting)),
				hero.getSkillSet().getSkills());
	}

	@Test
	public void missionJuniorJavaDeveloper() throws Exception {
		HttpResponse httpResponse = getRequest(getMissionsUrl() + "/"
				+ MISSION_JUNIOR_JAVA_DEVELOPER_ID);

		final Mission mission = retrieve(httpResponse,
				new TypeReference<Mission>() {
				});
		assertEquals("Junior Java Developer", mission.getShortName());
		assertEquals("Swisscom", mission.getCompanyName());
		assertEquals("Einfache Java-Entwicklung im SAM-Team.",
				mission.getDescription());
		assertEquals(Role.JuniorSoftwareEngineer, mission.getRole());
		assertEquals(
				new HashSet<Skill>(Arrays.asList(Skill.UnitTesting, Skill.Ant,
						Skill.SQL, Skill.Java)), mission.getSkillSet()
						.getSkills());
	}

	@Test
	public void missionCatalogContainsJuniorJavaDeveloper()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest(getMissionsUrl());

		List<Mission> list = retrieve(httpResponse,
				new TypeReference<List<Mission>>() {
				});
		boolean contains = false;
		for (Mission mission : list) {
			if (mission.getShortName().contains(
					MISSION_JUNIOR_JAVA_DEVELOPER_NAME)) {
				contains = true;
			}
		}
		assertTrue(contains);
	}

	@Test
	public void matchesForFlorianBesserContainJuniorJavaDeveloper()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest(getMatchesUrl() + "?heroId="
				+ HERO_FLORIAN_ID);

		List<Match> list = retrieve(httpResponse,
				new TypeReference<List<Match>>() {
				});
		boolean contains = false;
		for (Match match : list) {
			assertEquals(HERO_FLORIAN_ID, match.getHeroId());
			if (match.getMissionID().equals(MISSION_JUNIOR_JAVA_DEVELOPER_ID)) {
				assertEquals(new Score(14, true).toString(), match.getScore().toString());
				contains = true;
			}

		}
		assertTrue(contains);
	}

	@Test
	public void matchesForJuniorJavaDeveloperContainFlorianBesser()
			throws ClientProtocolException, IOException {
		HttpResponse httpResponse = getRequest(getMatchesUrl() + "?missionId="
				+ MISSION_JUNIOR_JAVA_DEVELOPER_ID);

		List<Match> list = retrieve(httpResponse,
				new TypeReference<List<Match>>() {
				});
		boolean contains = false;
		for (Match match : list) {
			assertEquals(MISSION_JUNIOR_JAVA_DEVELOPER_ID, match.getMissionID());
			if (match.getHeroId().equals(HERO_FLORIAN_ID)) {
				assertEquals(new Score(14, true).toString(), match.getScore().toString());
				contains = true;
			}
		}
		assertTrue(contains);
	}

	@Test
	public void setAndReadWant() throws ClientProtocolException, IOException {
		postRequest(getWantsUrl() + "/" + HERO_FLORIAN_ID + "/"
				+ MISSION_JUNIOR_JAVA_DEVELOPER_ID);
		HttpResponse httpResponse = getRequest(getWantsUrl() + "/"
				+ HERO_FLORIAN_ID);

		List<Long> list = retrieve(httpResponse,
				new TypeReference<List<Long>>() {
				});
		boolean contains = false;
		for (Long match : list) {
			if (MISSION_JUNIOR_JAVA_DEVELOPER_ID.equals(match)) {
				contains = true;
			}
		}
		assertTrue(contains);
	}

	private String getWantsUrl() {
		return REST_PREFIX + "wants";
	}

	private String getHeroesUrl() {
		return REST_PREFIX + "heroes";
	}

	private String getMatchesUrl() {
		return REST_PREFIX + "matches";
	}

	private String getMissionsUrl() {
		return REST_PREFIX + "missions";
	}

	@Test
	public void setAndReadWantJSON() throws ClientProtocolException,
			IOException {
		HttpPost request = new HttpPost(getWantsUrl());

		request.setEntity(new StringEntity("{\"heroId\":\"" + HERO_FLORIAN_ID
				+ "\",\"missionId\":\"" + MISSION_JUNIOR_JAVA_DEVELOPER_ID
				+ "\"}", ContentType.create("application/json")));

		HttpResponse r = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_NO_CONTENT, r.getStatusLine()
				.getStatusCode());

		HttpResponse httpResponse = getRequest(getWantsUrl() + "/"
				+ HERO_FLORIAN_ID);

		List<Long> list = retrieve(httpResponse,
				new TypeReference<List<Long>>() {
				});
		boolean contains = false;
		for (Long match : list) {
			if (MISSION_JUNIOR_JAVA_DEVELOPER_ID.equals(match)) {
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

		HttpResponse httpResponse = HttpClientBuilder.create().build()
				.execute(request);

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
