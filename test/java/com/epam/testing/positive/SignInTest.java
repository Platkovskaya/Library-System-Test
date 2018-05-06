package com.epam.testing.positive;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.epam.manager.DriverManager;
import com.epam.pageobject.LoginPage;

import constants.LibraryConstants;
import utils.DriverUtils;

public class SignInTest {

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
		loginPage.enterPassword(LibraryConstants.Authorization.PASSWORDS);
		loginPage.clickButtonSingUp();

		Assert.assertTrue(DriverManager.getDriver().getPageSource().contains(LibraryConstants.PageTitle.MAIN_PAGE), "User didn't gain access!");
	}

	@AfterTest
	public void finalization() {
		DriverManager.closeDriver();
	}
	
}
