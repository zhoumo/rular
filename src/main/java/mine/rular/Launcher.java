package mine.rular;

import java.util.Date;

import mine.rular.core.Driver;
import mine.rular.core.Parser;
import mine.rular.model.Assert;
import mine.rular.model.Case;
import mine.rular.model.Step;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Launcher {

	public static void main(String[] args) {
		Long start = new Date().getTime();
		System.out.println("open browser...");
		WebDriver webdriver = Driver.getDriver(Parser.getBrowser());
		for (Case testCase : Parser.getCaseList()) {
			System.out.println("case: " + testCase.getName());
			executeCase(webdriver, testCase);
			assertCase(webdriver, testCase);
		}
		System.out.println("spend: " + (new Date().getTime() - start) + "ms");
		webdriver.close();
	}

	private static void executeCase(WebDriver webdriver, Case testCase) {
		for (Step step : testCase.getSteps()) {
			System.out.println("  step: " + step.getName());
			if ("OPEN".equalsIgnoreCase(step.getType())) {
				webdriver.get(step.getValue());
			} else if ("INPUT".equalsIgnoreCase(step.getType())) {
				webdriver.findElement(By.xpath(step.getXpath())).sendKeys(step.getValue());
			} else if ("CLICK".equalsIgnoreCase(step.getType())) {
				webdriver.findElement(By.xpath(step.getXpath())).click();
			}
		}
	}

	private static void assertCase(WebDriver webdriver, Case testCase) {
		for (Assert assert_ : testCase.getAsserts()) {
			if (!StringUtils.isEmpty(assert_.getSizeGt())) {
				if (webdriver.findElements(By.xpath(assert_.getXpath())).size() > Integer.parseInt(assert_.getSizeGt())) {
					System.out.println("  success: " + assert_.getName());
				} else {
					System.out.println("  fail: " + assert_.getName());
				}
			}
		}
	}
}
