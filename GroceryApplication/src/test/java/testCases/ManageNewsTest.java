package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.Category;
import ElementRepository.HomePage;
import ElementRepository.LoginPage;
import ElementRepository.ManageNews;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {
	ManageNews mn;
	LoginPage lp;
	HomePage hp;
	Constant co;
	ExcelUtility eu;
  @Test
  public void addNewNews() throws IOException {
	  lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		mn=new ManageNews(driver);
		mn.createItem();
		String Actual = mn.readAlert();
		boolean TableStatus=mn.readTableAfterNewNewsAddsion();
		Assert.assertEquals(TableStatus, true, co.Newsaddedstatus);
		String Expected = "News Created Successfully";
		
		boolean value = Actual.contains(Expected);
		Assert.assertEquals(value, true, co.newsaddisionStatus);
  }
}
