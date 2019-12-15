package pages;

import org.openqa.selenium.By;

public class HomePage {
	public By elementIdentifier;
	public HomePage(String elementName){
		switch (elementName) {
		case "title":
			this.elementIdentifier=By.xpath("//title");
			break;
		case "userNameLabel":
			this.elementIdentifier=By.xpath("//td[contains(text(),'User: padmanabhuni suraj')]");
			break;
		case "contactsLink":
			this.elementIdentifier=By.xpath("//a[contains(text(),'Contacts')]");
			break;
		case "dealsLink":
			this.elementIdentifier=By.xpath("//a[contains(text(),'Deals')]");
			break;
		case "tasksLink":
			this.elementIdentifier=By.xpath("//a[contains(text(),'Tasks')]");
			break;
		}
		
	}

}
