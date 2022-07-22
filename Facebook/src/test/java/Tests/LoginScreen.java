package Tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.FaceBookHomePage;
import Pages.LoginPage;
import Pages.RegisertaionForm;
import ScreenShot.ScreenshotClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScreen {

	WebDriver driver;
	LoginPage login;
	FaceBookHomePage FbHome;
	RegisertaionForm ReisterScreen;
	ScreenshotClass Screenshots;
	
	@Test(description = "Given I am on the Facebook Login Screen, Then the user logged into Facebook Successfully")
	public void CheckThatUserSuccessfullyLoggingtoFacebook() throws IOException {
		
		Screenshots.ScreenShots("ScreenShotFromLoggingPage");
		login.EnterCredientials("rjtyirnfxr_1655931212@tfbnw.net","test@123")
		     .ClickOnSignInButton();		
		Assert.assertEquals(FbHome.WelconFaceBook(), "Welcome to Facebook, William");
		Screenshots.ScreenShots("LoggingToFacebookSucessfully");
	}

	@BeforeClass
	public void beforeClass() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		login = new LoginPage(driver);
		FbHome = new FaceBookHomePage(driver);
		ReisterScreen = new RegisertaionForm(driver);
		Screenshots = new ScreenshotClass(driver);
		login.Navigate();
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
