package info.reusables;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class reusable implements DriverSource {

	@Override
	public WebDriver newDriver() {

		String browserType = "";
		WebDriver driver = null;
		String strExecutionPlatform = GlobalSettingsConfig.getInstance().getProperty("EXECUTION_PLATFORM");
		System.out.println(System.getProperty("user.dir") + File.separator + "SeleniumDrivers");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
				+ "SeleniumDrivers" + File.separator + "chromedriver.exe");
		try {
			ChromeOptions chromeOptions;
			switch (strExecutionPlatform) {
			case "LOCAL_CHROME":
				chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("start-maximized");
				// WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver(chromeOptions);
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver = new ChromeDriver();
		return driver;
	}

	@Override
	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return false;
	}

	public final static String PROPERTY_PATH = "testproperties/";

	public String readProperty(String fileName, String propertyName) {
		String propertyValue = "";
		InputStream inputStream;

		try {
			Properties prop = new Properties();
			String propFileName = PROPERTY_PATH + fileName;

			inputStream = ClassLoader.getSystemClassLoader().getSystemResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			}
			propertyValue = prop.getProperty(propertyName);
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Issue with properties" + e.getMessage());
		}
		return propertyValue;
	}

}
