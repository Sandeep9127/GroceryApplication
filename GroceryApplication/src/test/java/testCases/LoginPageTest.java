package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementRepository.HomePage;
import ElementRepository.LoginPage;
import constant.Constant;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	@DataProvider(name="data")
	public Object[][] details()
	{
		return new Object[][] {{"asdf","ddff"},{"cvbn","zxc"},{"ccvv","sssd"}};
	}
  @Test(groups = {"group1"})
  public void verifyLoginWithValidCredentials() {
	  lp=new LoginPage(driver);
	  hp=lp.LoginData("admin","admin");
	  String actual=hp.readHeading();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidCredentials);//to compare actual and expected result,if assersion pass test case will consider as pass.
  }
  @Test(dataProvider = "data")
  public void verifyLoginWithInValidCredentials(String a,String b) {
	  lp=new LoginPage(driver);
	  lp.LoginData(a,b);
	 Assert.assertEquals(lp.readInvalidMessage(),"Alert!", ": Heading Text not As Expected");	  
  }

}
