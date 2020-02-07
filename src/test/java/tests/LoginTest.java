package tests;

import Framework.BasePage;
import config.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	LoginPage loginPage;
	HomePage objHomePage;
	BasePage objBasePage;

	//arrenge
	@BeforeTest
	public void setup() {
		loginPage = new LoginPage(getDriver());
		System.out.println("before Test");
	}


	//act
//	@Test
//	public void test_Login_To_Home_Page() {
//		driver.get("http://demo.guru99.com/V4/");
//		loginPage.loginToGuru99("mgr123", "mgr!23");
//	}
//
//	@Test
//	public void test_Login_To_Home_Page2() {
//	driver.get("http://demo.guru99.com/V4/");
//	loginPage.loginToGuru99("mgr123", "mgr!23");
//	}

	@Test
	public void testLoginToHomePage3() {
		driver.get(Configuration.getURL());
		loginPage.loginToGuru99(Configuration.getUsername(),Configuration.GetPassword());
	}
	
	//Verify home page
	@Test
	public void  verifications() {
		objHomePage = new HomePage(getDriver());
		objBasePage = new BasePage(getDriver());
		//Assert.assertTrue(Guru99HomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		//Assert.assertTrue(Guru99HomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		Assert.assertEquals(objHomePage.getHomePageDashboardUserName(),"Manger Id : "+Configuration.getUsername());
		Assert.assertEquals(objBasePage.readText(objHomePage.managerTitleText),"Manger Id : mgr123");
		objBasePage.assertEqualss(objHomePage.managerTitleText,"Manger Id : mgr123");
	}


	
}	
