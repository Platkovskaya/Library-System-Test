package com.epam.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(name = "login")
	private WebElement inputLogin;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@id='login_form']/button")
	private WebElement inputSignUp;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterLogin(String login) {
		inputLogin.sendKeys(login);
	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void clickButtonSingUp() {
		inputSignUp.click();
	}
	
}
