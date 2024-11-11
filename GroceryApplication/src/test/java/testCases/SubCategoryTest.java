package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.HomePage;
import ElementRepository.LoginPage;
import ElementRepository.SubCategory;
import constant.Constant;
import utilities.ExcelUtility;

public class SubCategoryTest extends BaseClass {

	SubCategory sc;
	LoginPage lp;
	HomePage hp;
	Constant co;
	ExcelUtility eu;

	@Test(priority = 0,groups = {"group1"})
	public void createSubCategory() throws IOException {

		eu=new ExcelUtility();
		lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		sc=hp.goToSubCategory();
		sc.createItem();
		String subCategoryName = sc.getRandmelyCreatedSubCategoryName();
		String Expected = "Sub Category Created Successfully";
		String Actual = sc.readAlert();
		boolean value = Actual.contains(Expected);
		Assert.assertEquals(value, true, co.SubCategorynotcreatedalrtstatus);
		hp.goToSubCategory();
		//boolean TableStatus = sc.readTableInsertElement();
		//assertTrue(TableStatus);
		Assert.assertEquals(sc.readTableElement(1, 1), subCategoryName, co.SubCategorynameStatus);

	}

	@Test(priority = 1,groups = {"group1"})
	public void deleteItemAlertTest() throws IOException {

		
		lp = new LoginPage(driver);
		lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		sc=hp.goToSubCategory();
		hp.goToSubCategory();
		sc.delItem();
		String Expected = "Sub Category Deleted Successfully";
		String alertDel = sc.readAlert();
		boolean value = alertDel.contains(Expected);
		//assertTrue(value);
        Assert.assertEquals(value, true, co.deleteAlertStatus);
	}

	@Test(priority = 2,groups = {"group2"})
	public void checkdeletedItemExists() throws IOException {

		
		
		lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		sc=hp.goToSubCategory();
		hp.goToSubCategory();
		String subCategory = sc.readTableElement(1, 1);
		String category = sc.readTableElement(1, 2);
		sc.delTableElement(subCategory);
		String Expected = "Sub Category Deleted Successfully";
		String alertDel = sc.readAlert();
		boolean value = alertDel.contains(Expected);
		assertTrue(value);
		hp.goToSubCategory();
		sc.doSearchAfterDelete(category, subCategory);
		boolean deleteStatus=sc.readTableAfterDelete();
		//assertTrue(deleteStatus);
		Assert.assertEquals(deleteStatus, true, co.deletedItemStatus);

	}

	

	@Test(priority = 5)
	public void doinValidSearch() throws IOException {

		lp = new LoginPage(driver);		
		hp=lp.LoginData(groceryData(1,0), groceryData(1,1));
		sc=hp.goToSubCategory();
		hp.goToSubCategory();
		sc.doSearchInValid();
		boolean SearchStatus = sc.readTableSearchElementInvalid();
		//assertTrue(SearchStatus);
		Assert.assertEquals(SearchStatus, true, co.invalidSearchStatus);

	}

}
