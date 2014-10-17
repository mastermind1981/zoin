package jpa;

import org.codehaus.jackson.annotate.JsonValue;

public enum Skill {
	Ant("Ant"),
	Architektur("Architektur"),
	DotNet(".NET"),
	Gradle("Gradle"),
	Java("Java"),
	Maven("Maven"),
	SQL("SQL"),
	UITesting("UI Testing"),
	UnitTesting("Unit Testing")
	// Add new skills below:
	;
	private String name;
	
	private Skill(String name){
		this.name = name;
	}
	
	@JsonValue
	public String toString() {
		return name;
	}
}
