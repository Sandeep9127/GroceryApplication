package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageContact;
import ElementRepository.SubCategory;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageContactTest extends BaseClass{
	ManageContact mc;
	LoginPage lp;
	Constant co;
	ExcelUtility eu;
  @Test(priority = 1)
  public void UpdateItemAlertCheck() throws IOException {
	  mc = new ManageContact(driver);
		lp = new LoginPage(driver);
		eu=new ExcelUtility();
		lp.LoginData(groceryData(1,0), groceryData(1,1));
		mc.UpdateTableDetail();
		String Expected = "Contact Updated Successfully";
		String Actual = mc.readAlert();
		boolean value = Actual.contains(Expected);
		Assert.assertEquals(value, true, co.invalidUpdateContactStatus);
  }
  @Test(priority = 2)
  public void checktableAfterUpdate() throws IOException {
	  mc = new ManageContact(driver);
		lp = new LoginPage(driver);
		eu=new ExcelUtility();
		lp.LoginData(groceryData(1,0), groceryData(1,1));
		mc.goToContacts();
		boolean searchStatus=mc.readTableForUpdatedItem();
		Assert.assertEquals(searchStatus, true, co.tablenotcontainsupdateditem);
		
  }
}
