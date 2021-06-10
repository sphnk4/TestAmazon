package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amz.qa.base.TestBase;

public class AmazonSearchPage extends TestBase {

	@FindBy(xpath="//div[@id='search']//div[@data-index='1']//span[@class='a-price']/span[@class='a-offscreen']")
	public WebElement weFirstRow;
	
	// Initializing the Page Objects:
	public AmazonSearchPage() {
		PageFactory.initElements(driver, this);
	}

}
