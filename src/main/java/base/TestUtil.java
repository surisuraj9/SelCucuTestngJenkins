package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import pages.*;


public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT =60;
	public static long IMPLICIT_WAIT=60;
	public static String TESTDATA_SHEET_PATH = "src/main/resources/FreeCRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	public static WebElement element;
	
	public void switchToFrame() {
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='mainpanel']")));
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest(String screenshotName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("target/screenshots/" + screenshotName + ".png"));
	}
	
	public static WebElement getPageDescriptor(String elementName, String pageName){
		switch (pageName) {
		case "login":
			LoginPage loginPage=new LoginPage(elementName);
			element=driver.findElement(loginPage.elementIdentifier);
			break;
		case "home":
			HomePage homePage=new HomePage(elementName);
			element=driver.findElement(homePage.elementIdentifier);
			break;
		}
		
		return element;
	}
	

}
