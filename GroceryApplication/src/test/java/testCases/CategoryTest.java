package testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.Category;
import ElementRepository.HomePage;
import ElementRepository.LoginPage;
import constant.Constant;


public class CategoryTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	Category ct;
	Constant co;
	
  @Test
  public void categoryValidSearch() throws IOException {
	  
	  lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		ct=new Category(driver);
		ct.validSearch();
		boolean tableValueMatch=ct.readtabelValidSearch();
		Assert.assertEquals(tableValueMatch, true, co.serchnotcontainsearcheditem);
	  
  }
  @Test
  public void categoryInvalidSearch() throws IOException {
	  
	  lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		ct=new Category(driver);
		ct.invalidSearch();
		boolean tableValueMatchDelete=ct.readtabelinValidSearch();
		Assert.assertEquals(tableValueMatchDelete, true, co.invalidSearchStatus);
	  
  }
}
