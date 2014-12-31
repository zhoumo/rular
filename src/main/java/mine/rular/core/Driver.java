package mine.rular.core;

import mine.rular.model.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Driver {

	public static WebDriver getDriver(Browser browser) {
		WebDriver driver = null;
		if (Browser.IE.equalsIgnoreCase(browser.getType())) {
			System.setProperty("webdriver.ie.driver", browser.getPath());
			driver = new InternetExplorerDriver();
		} else if (Browser.FIREFOX.equalsIgnoreCase(browser.getType())) {
			System.setProperty("webdriver.firefox.bin", browser.getPath());
			driver = new FirefoxDriver();
		} else {
			System.setProperty("phantomjs.binary.path", browser.getPath());
			driver = new PhantomJSDriver();
		}
		return driver;
	}
}
