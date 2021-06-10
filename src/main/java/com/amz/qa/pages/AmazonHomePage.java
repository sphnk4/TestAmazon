package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class AmazonHomePage extends TestBase {

	
	@CacheLookup
	

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchboxText;
	
	
	// Initializing the Page Objects
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
		
	}
	