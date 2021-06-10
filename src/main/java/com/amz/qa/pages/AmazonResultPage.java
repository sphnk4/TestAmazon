package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class AmazonResultPage  extends TestBase {

	@FindBy(id = "add-to-cart-button")
	public WebElement weAddToCart;
	
	@FindBy(xpath="//div[@id='hlb-subcart']//span[@class='a-size-medium a-align-center huc-subtotal']/span[2]")
	public WebElement weCartTotal;
	
	// Initializing the Page Objects:
		public AmazonResultPage() {
			PageFactory.initElements(driver, this);
		}
	
}
