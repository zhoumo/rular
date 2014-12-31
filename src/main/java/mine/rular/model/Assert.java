package mine.rular.model;

import org.dom4j.Element;

public class Assert {

	private String name;

	private String xpath;

	private String sizeGt;

	public Assert(Element element) {
		this.name = element.attributeValue("name");
		this.xpath = element.attributeValue("xpath");
		this.sizeGt = element.attributeValue("size-gt");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getSizeGt() {
		return sizeGt;
	}

	public void setSizeGt(String sizeGt) {
		this.sizeGt = sizeGt;
	}
}
