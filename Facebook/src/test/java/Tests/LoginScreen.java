package Tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.FaceBookHomePage;
import Pages.LoginPage;
import Pages.RegisertaionForm;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScreen {

	WebDriver driver;
	LoginPage login;
	FaceBookHomePage FbHome;
	RegisertaionForm ReisterScreen;
	
	@Test(description = "Given I am on the Facebook Login Screen, Then the user logged into Facebook Successfully")
	public void CheckThatUserSuccessfullyLoggingtoFacebook() throws IOException {
		
		login.EnterCredientials("rjtyirnfxr_1655931212@tfbnw.net","test@123");
		
		login.ScreenShots("ScreenShotFromLoggingPage");
		login.ClickOnSignInButton();
		Assert.assertEquals(FbHome.WelconFaceBook(), "Welcome to Facebook, William");
		FbHome.ScreenShots("LoggingToFacebookSucessfully");
	}

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		login = new LoginPage(driver);
		FbHome = new FaceBookHomePage(driver);
		ReisterScreen = new RegisertaionForm(driver);
		login.Navigate();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		driver.quit();
	}
}
