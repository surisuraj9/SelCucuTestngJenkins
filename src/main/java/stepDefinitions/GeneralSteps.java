package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import base.TestBase;
import base.TestUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class GeneralSteps extends TestBase {
	
	@Given("^user opens browser with url$")
	public void openUrl(){
		driver.get(prop.getProperty("url"));	
	}
	
	//Then user enters "surajp" as "username" and "suraj@1995" as "password" in "login" page
	@Then("^user enters \"([^\"]*)\" as \"([^\"]*)\" and \"([^\"]*)\" as \"([^\"]*)\" in \"([^\"]*)\" page$")
	public void validateLogin(String uname,String uElementName,String pass, String pElementName,String pageName){
		TestUtil.getPageDescriptor(uElementName, pageName).clear();
		TestUtil.getPageDescriptor(uElementName, pageName).sendKeys(uname);
		TestUtil.getPageDescriptor(pElementName, pageName).clear();
		TestUtil.getPageDescriptor(pElementName, pageName).sendKeys(pass);   
	}
	
	@Then("^user clicks on \"([^\"]*)\" in \"([^\"]*)\" page$")
	public void clickMethod(String elementName,String pageName){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", TestUtil.getPageDescriptor(elementName, pageName));
//		TestUtil.getPageDescriptor(elementName, pageName).click();
	}
	
	@Then("^user validates \"([^\"]*)\" as \"([^\"]*)\" in \"([^\"]*)\" page$")
	public void validateMethod(String elementName,String value,String pageName){
		Assert.assertEquals(TestUtil.getPageDescriptor(elementName, pageName).getText(), value);
	}

}
