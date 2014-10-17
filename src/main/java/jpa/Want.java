package jpa;

import javax.persistence.Basic;
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
	
	@Basic
	private int zoins;

	public Want() {
	}
	
	public Want(Hero h, Mission m, int zoins) {
		this.mission = m;
		this.hero = h;
		this.zoins = zoins;
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
	
	public int getZoins() {
		return zoins;
	}
}
