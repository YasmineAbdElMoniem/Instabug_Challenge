package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	String URL = "https://www.facebook.com/login/";

	By UsernameText = By.xpath("//input[@name='email']");

	By Password = By.xpath("//input[@name='pass']");

	By SignInButton = By.xpath("//button[@name='login']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Navigate() {
		driver.navigate().to(URL);

	}

	public LoginPage EnterCredientials(String Username, String Pass) {
		driver.findElement(UsernameText).sendKeys(Username);
		driver.findElement(Password).sendKeys(Pass);
		return this;
	}

	public LoginPage ClickOnSignInButton() {
		driver.findElement(SignInButton).click();
		return this;
	}
}
