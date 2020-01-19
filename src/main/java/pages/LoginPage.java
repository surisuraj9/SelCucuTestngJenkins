package pages;

import org.openqa.selenium.By;

public class LoginPage {
	public By elementIdentifier;
	public LoginPage(String elementName){
		switch (elementName) {
		case "username":
			this.elementIdentifier=By.name("username");
			break;
		case "password":
			this.elementIdentifier=By.name("password");
			break;
		case "login_button":
			this.elementIdentifier=By.xpath("//input[@value='Login']");
			break;
		case "signUpBtn":
			this.elementIdentifier=By.linkText("Sign Up");
			break;
		case "crmLogo":
			this.elementIdentifier=By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']");
			break;
		}
	}

}
