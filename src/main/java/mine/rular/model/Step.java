package mine.rular.model;

import org.dom4j.Element;

public class Step {

	private String name;

	private String type;

	private String xpath;

	private String value;

	public Step(Element element) {
		this.name = element.attributeValue("name");
		this.type = element.attributeValue("type");
		this.xpath = element.attributeValue("xpath");
		this.value = element.attributeValue("value");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type.trim();
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
