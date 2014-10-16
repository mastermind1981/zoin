package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Want {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Mission mission;
	
	@ManyToOne
	private Hero hero;

	public Want() {
	}
	
	public Want(Hero h, Mission m) {
		mission = m;
		hero = h;
	}

	public Long getId() {
		return id;
	}

	public Mission getMission() {
		return mission;
	}

	public Hero getHero() {
		return hero;
	}
}
