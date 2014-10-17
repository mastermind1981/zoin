package jpa;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Role {
	JuniorSoftwareEngineer("Junior Software Engineer"), SoftwareEngineer(
			"Software Engineer"), SeniorSoftwareEngineer(
			"Senior Software Engineer"), LeadSoftwareArchitect(
			"Lead Software Architect"), LeadEngineer("Lead Engineer"), PrincipalConsultant(
			"Principal Consultant");
	private String name;

	private Role(String name) {
		this.name = name;
	}

	@JsonValue
	public String stringRep() {
		return name;
	}
	
	@JsonCreator
	public static Role create(String val) {
		Role[] values = Role.values();
		for (Role value : values) {
			if (value.stringRep().equals(val) || value.toString().equals(val)) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknown role '" + val + "'!");
	}
}
