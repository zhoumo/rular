package mine.rular.model;

import java.util.List;

public class Case {

	private String name;

	private List<Step> steps;

	private List<Assert> asserts;

	public Case(String name, List<Step> steps, List<Assert> asserts) {
		this.name = name;
		this.steps = steps;
		this.asserts = asserts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<Assert> getAsserts() {
		return asserts;
	}

	public void setAsserts(List<Assert> asserts) {
		this.asserts = asserts;
	}
}
