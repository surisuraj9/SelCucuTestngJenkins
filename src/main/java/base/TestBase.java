package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileReader input = new FileReader("src/main/resources/config.properties");
			prop.load(input);
			//System.out.println(prop.getProperty("username"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.firefox.marionatte","src/main/resources/geckodriver.exe");
			driver  = new FirefoxDriver();
			
		}
		if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
			driver  = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
}
