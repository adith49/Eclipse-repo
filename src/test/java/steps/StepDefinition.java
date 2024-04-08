package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	@When("Click Shop now button")
	public void clickShopNow() throws InterruptedException {
		
		//driver.findElement(By.xpath("//div[@class='swiper-wrapper']/div/div/a")).click();
		WebElement ShopNow = driver.findElement(By.linkText("Shop now"));
		driver.executeScript("arguments[0].click();", ShopNow);
		Thread.sleep(3000);
		takeScreenshot();		
	}
		
	@And("Click Products under Hair Products section")
	public void clickHairProducts() {
		driver.findElement(By.xpath("//p[text()='Hair Products']/following-sibling::a")).click();
		takeScreenshot();		
	}
	
	@And("Click Hair Beauty Bath product")
	public void clickProduct() {
		driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']")).click();
		takeScreenshot();	
	}

	@And("Click Add to cart button")
	public void addToCart() throws InterruptedException 
	{
	driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
	
	Thread.sleep(5000);
	
	takeScreenshot();	
	}

	@And("Navigate to Cart")
	public void navigateCart() throws InterruptedException 
	{
	driver.findElement(By.xpath("//div[@class='cart-animation']")).click();	
	
	Thread.sleep(3000);
	
	takeScreenshot();	
	}

	@And("Check out the product")
	public void checkoutProduct() {
		driver.findElement(By.xpath("//a[text()=\"Checkout\"]")).click();
		
		takeScreenshot();
	}

	@And("Select Shipping Method as Worldwide - 5.00 USD")
	public void shippingMethod() {
		
		WebElement sm = driver.findElement(By.xpath("//select[contains(@name,'fulfillment')]"));
		Select dd = new Select(sm);
		dd.selectByVisibleText("Worldwide - $5.00 USD");
		
		takeScreenshot();
	}

	@And("Click Make payment")
	public void makePayment() {
		driver.findElement(By.xpath("//button[text()='Make payment']")).click();
		
		takeScreenshot();
	}

	@Then("Verify if the order is placed and get the Order ID")
	public void getOrderId() {
		String order = driver.findElement(By.xpath("//h4[text()='Your order completed successfully']/following-sibling::p")).getText();
		System.out.println(order);
		
		takeScreenshot();
	}

}
