package MyRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport="target/cucumber-reports/CucumberTestReport.json",
						retryCount=2,
						detailedReport=true,
						detailedAggregatedReport=true,
						overviewReport=true,
						coverageReport=true,
						jsonUsageReport="target/cucumber-reports/CucumberTestReport.json",
						usageReport=true,
						toPDF=true,
						outputFolder="target")
@CucumberOptions(
		features = "src/main/java/features", //the path of the feature files
		glue={"stepdefinations"}, //the path of the step definition files
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/extent_report.html",
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
				"junit:target/junit_xml/cucumber.xml",
				}, //to generate different types of reporting
//		dryRun = false, //to check the mapping is proper between feature file and step def file
		monochrome = true //display the console output in a proper readable format
//		strict = false //it will check if any step is not defined in step definition file
//		tags = {"~@SmokeTest" }
	)

public class RerunTestRunner {
	@AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }

}
