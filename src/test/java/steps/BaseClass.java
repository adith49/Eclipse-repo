package steps;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;

public class BaseClass extends AbstractTestNGCucumberTests {

	public static ChromeDriver driver;
	public static WebDriverWait wait;

	public static void takeScreenshot() {

		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			Allure.addAttachment("src", new FileInputStream(src));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.get("https://commercejs-demo-store.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
