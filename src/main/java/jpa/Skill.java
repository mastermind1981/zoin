package jpa;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Skill {
	Ant("Ant"), Architektur("Architektur"), DotNet(".NET"), Gradle("Gradle"), Java(
			"Java"), Maven("Maven"), SQL("SQL"), UITesting("UI Testing"), UnitTesting(
			"Unit Testing")
	// Add new skills below:
	;
	private String name;

	private Skill(String name) {
		this.name = name;
	}

	@JsonValue
	@Override
	public String toString() {
		return name;
	}

	@JsonCreator
	public static Skill create(String val) {
		Skill[] values = Skill.values();
		for (Skill value : values) {
			if (value.toString().equals(val)) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknown skill '" + val + "'!");
	}
}
