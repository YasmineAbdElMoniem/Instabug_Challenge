package Tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Data.TestDataJson;
import Pages.FaceBookHomePage;
import Pages.LoginPage;
import Pages.OTPForm;
import Pages.RegisertaionForm;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterScreen {
	WebDriver driver;
	LoginPage login;
	FaceBookHomePage FbHome;
	RegisertaionForm ReisterScreen;
	OTPForm otp_popup;

	@Test(description = "Given I am on the Facebook login page ,When user clicks on Create Account, Then the Facebook registeration form is appears Successfully")
	public void CheckThatRegiserationFormAppearsSucessfully() throws IOException {

		ReisterScreen.ClickOnCreateAccountButton();
		ReisterScreen.GetTitleOfRegisterationForm();
		Assert.assertEquals(ReisterScreen.GetTitleOfRegisterationForm(), "Create a new account");
		ReisterScreen.ScreenShots("CheckThatRegiserationFormAppearsSucessfully");
	}

	@Test(description = "Given I am on the Facebook Reisteration Form, Then the user can register to Facebook Successfully")
	public void CheckThatRegisterationOfFacebookAccountiscreatedSucessfully() throws IOException, ParseException {
		
		TestDataJson jsonReader = new TestDataJson();
		jsonReader.JsonReader();
		
		ReisterScreen.ClickOnCreateAccountButton();
		ReisterScreen.EnterCredientialsForRegisteration(jsonReader.First_Name,jsonReader.Last_Name,jsonReader.Phone_Number,jsonReader.Password,jsonReader.Day,jsonReader.Month,jsonReader.Year);
		ReisterScreen.ScreenShots("ScreenShotFromRegisteratioPage");
		ReisterScreen.ClickOnSignUptButton();
		Assert.assertTrue(otp_popup.CheckThatOtpFormIsDisplayed());
		ReisterScreen.ScreenShots("FacebookaAccountisCreatedSucessfully");
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		login = new LoginPage(driver);
		FbHome = new FaceBookHomePage(driver);
		ReisterScreen = new RegisertaionForm(driver);
		otp_popup = new OTPForm(driver);

		login.Navigate();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		driver.quit();
	}
}
