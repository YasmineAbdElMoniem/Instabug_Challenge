package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisertaionForm {

	WebDriver driver;

	String URL = "https://www.facebook.com/";
	String NmeOFregisterationform;

	By CreateButton = By.xpath("//a[@class='_42ft _4jy0 _16jx _4jy6 _4jy2 selected _51sy']");

	By PopForSignUp = By.xpath("//div[@class='mbs _52lq _9bp_ fsl fwb fcb']");

	By FirstName = By.xpath("//input[@name='firstname']");

	By LastName = By.xpath("//input[@name='lastname']");

	By PhoneNumber = By.xpath("//input[@name='reg_email__']");

	By pass = By.xpath("//input[@id='password_step_input']");

	By day = By.xpath("//select[@id='day']");
	By month = By.xpath("//select[@id='month']");
	By year = By.xpath("//select[@id='year']");

	By Gender = By.xpath("//input[@value='1']");
	
	By UseDateOfBirthLink = By.xpath("//a[@id='age_to_birthday_link']");

	By SignUpButton = By.xpath("//button[@type='submit']");

	By OtpForm = By.xpath("//h2[@class='uiHeaderTitle']");

	public RegisertaionForm(WebDriver driver) {
		this.driver = driver;
	}

	public void Navigate() {
		driver.navigate().to(URL);
	}

	public void ClickOnCreateAccountButton() {
		driver.findElement(CreateButton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(PopForSignUp));
	}

	public String GetTitleOfRegisterationForm() {
		
		return NmeOFregisterationform = driver.findElement(PopForSignUp).getText();
	}

	public void EnterCredientialsForRegisteration(String First_Name, String Last_Name, String Phone_Number, String Password, String Day, String Month, String Year) 
	{
		
		driver.findElement(FirstName).sendKeys(First_Name + Keys.ENTER);
		driver.findElement(LastName).sendKeys(Last_Name + Keys.ENTER);
		driver.findElement(PhoneNumber).sendKeys(Phone_Number);
		driver.findElement(pass).sendKeys(Password);
		driver.findElement(UseDateOfBirthLink).click();
		driver.findElement(day).sendKeys(Day + Keys.ENTER);
		driver.findElement(month).sendKeys(Month + Keys.ENTER);
		driver.findElement(UseDateOfBirthLink).click();
		driver.findElement(year).sendKeys(Year + Keys.ENTER);
		driver.findElement(Gender).click();
	}

	public void ClickOnSignUptButton() {
		driver.findElement(SignUpButton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(OtpForm));
	}
}
