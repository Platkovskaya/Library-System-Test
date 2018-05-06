package com.epam.testing.negative;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.manager.DriverManager;
import com.epam.pageobject.LoginPage;

import constants.LibraryConstants;
import utils.DriverUtils;

public class SignInPasswordTest {
	
	private LoginPage loginPage;

	@BeforeTest
	public void init() {
		WebDriver driver = DriverManager.getDriver();
		DriverUtils.openURL(driver, LibraryConstants.Url.LIBRARY_PAGE);
		loginPage = new LoginPage(driver);
	}

	@Test
	public void pageLoginTest() {
		
		loginPage.enterLogin(LibraryConstants.Authorization.LOGIN);
		loginPage.enterPassword(LibraryConstants.Authorization.PASSWORDS + "1");
		loginPage.clickButtonSingUp();

		Assert.assertFalse(DriverManager.getDriver().getPageSource().contains(LibraryConstants.PageTitle.MAIN_PAGE), "User gain access with wrong password!");
	}

	@AfterTest
	public void finalization() {
		DriverManager.closeDriver();
	}

}
