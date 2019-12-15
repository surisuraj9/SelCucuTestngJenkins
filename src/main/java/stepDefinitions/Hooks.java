package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import base.TestBase;
import base.TestUtil;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends TestBase {
	
	public  Hooks() {
		super();
	}

	@Before
	public void setUP(){
		System.out.println("launching chrome");
		TestBase.initialization();
	}
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			String encodedBase64 = null;
			FileInputStream fileInputStream = null;
			try {   
				TestUtil.takeScreenshotAtEndOfTest(screenshotName);
				File destinationPath = new File("target/screenshots/" + screenshotName + ".png");
				fileInputStream =new FileInputStream(destinationPath);
		        byte[] bytes =new byte[(int)destinationPath.length()];
		        fileInputStream.read(bytes);
		        encodedBase64 = new String(Base64.encodeBase64(bytes));
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(encodedBase64);
			} catch (IOException e) {
			} 
		}
	}
	@After(order = 0)
	public void tearDown(){
		System.out.println("closing the browser");
		TestBase.driver.quit();
	}
}
