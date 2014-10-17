package jpa;

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
	public String toString() {
		return name;
	}
}
