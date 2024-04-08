package runner;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;

@CucumberOptions(features = "src/test/java/features/CommerceJS.feature",
				glue = "steps",
				plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
				monochrome = true,
				publish = true
		)

public class Runner extends BaseClass {

}
