package backend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import objects.SomeResult;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import jpa.SomeEntity;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("helloWorld")
public class HelloWorldSql {

private static final String encoding  = "UTF-8";
	
	@PersistenceContext
	EntityManager em;
	
	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("text/plain;charset=" + encoding)
	public String getClichedMessage() throws JsonGenerationException, JsonMappingException, IOException {
		
		SomeEntity entity = new SomeEntity();
		em.persist(entity);
		
		TypedQuery<SomeEntity> q1 = em.createQuery(
				"SELECT x FROM SomeEntity x",
				SomeEntity.class);
		List<SomeEntity> results = q1.getResultList();
		
		SomeResult r = new SomeResult(results.size());
		
		return mapper.writeValueAsString(r);
	}

}
