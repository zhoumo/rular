package mine.rular.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mine.rular.model.Assert;
import mine.rular.model.Browser;
import mine.rular.model.Case;
import mine.rular.model.Step;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Parser {

	private static Document document;

	private static Document getDocument() {
		if (document == null) {
			try {
				document = new SAXReader().read(new File(Parser.class.getResource("/suite.xml").getFile()));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		return document;
	}

	public static Browser getBrowser() {
		Browser browser = new Browser();
		Iterator<?> settings = getDocument().getRootElement().elements("setting").iterator();
		while (settings.hasNext()) {
			Element element = (Element) settings.next();
			if (Boolean.parseBoolean(element.attributeValue("active"))) {
				browser.setType(element.attributeValue("browser-type"));
				browser.setPath(element.attributeValue("browser-path"));
			}
		}
		return browser;
	}

	public static List<Case> getCaseList() {
		List<Case> caseList = new ArrayList<Case>();
		Iterator<?> cases = getDocument().getRootElement().elements("case").iterator();
		while (cases.hasNext()) {
			Element element = (Element) cases.next();
			List<Step> stepList = new ArrayList<Step>();
			Iterator<?> steps = element.element("steps").elements("step").iterator();
			while (steps.hasNext()) {
				stepList.add(new Step((Element) steps.next()));
			}
			List<Assert> assertList = new ArrayList<Assert>();
			Iterator<?> asserts = element.elements("assert").iterator();
			while (asserts.hasNext()) {
				assertList.add(new Assert((Element) asserts.next()));
			}
			caseList.add(new Case(element.attributeValue("name"), stepList, assertList));
		}
		return caseList;
	}
}
