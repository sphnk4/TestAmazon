package com.amz.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.AmazonSearchPage;
import com.amz.qa.pages.AmazonHomePage;
import com.amz.qa.pages.AmazonResultPage;
import com.amz.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;

public class AmzonTest extends TestBase {
	
	AmazonHomePage homePage;
	TestUtil testUtil;
	AmazonSearchPage amazonSearchPage;
	AmazonResultPage resultPage;

	public AmzonTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new AmazonHomePage();
		amazonSearchPage = new AmazonSearchPage();
		resultPage = new AmazonResultPage();
		
	}
	
	
	@Test(priority=1)
	public void searchResults() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(homePage.searchboxText));
		
		homePage.searchboxText.click();
		homePage.searchboxText.sendKeys("qa testing for beginners"+Keys.ENTER);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='search']//div[@data-index='1']//span[@class='a-price']/span[@class='a-offscreen']")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String strPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElement(By.xpath("//div[@id='search']//div[@data-index='1']//span[@class='a-price']/span[@class='a-offscreen']")));
		
		//System.out.println("Price is : "+ strPrice);
		
		Thread.sleep(1000);
		((JavascriptExecutor) js).executeScript("arguments[0].click();", amazonSearchPage.weFirstRow);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
				
		resultPage.weAddToCart.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='hlb-subcart']//span[@class='a-size-medium a-align-center huc-subtotal']/span[2]")));
		
		String strCartPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElement(By.xpath("//div[@id='hlb-subcart']//span[@class='a-size-medium a-align-center huc-subtotal']/span[2]")));
		//System.out.println("Cart price is : "+ strCartPrice);
		Assert.assertEquals(strPrice, strCartPrice);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
