package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SubCategory {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	String subCategoryName;

	public SubCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	LoginPage lp;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Subcategory/add')]")
	WebElement link2subCategoryAddbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategory;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del')]")
	List<WebElement> del;
	@FindBy(xpath = "//a[contains(@href,'javascript:void(0)')]")
	WebElement search;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchCategory;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement searchInput;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]")
	List<WebElement> SubCategoryColumn;

	public void createItem() {

		String subCategoryName = "test item" + gu.generateCurrentDateAndTime();
		this.subCategoryName = subCategoryName;
		link2subCategoryAddbutton.click();
		gu.selectDropdownWithIndex(category, 3);
		subCategory.sendKeys(subCategoryName);
		button.click();

	}

	public String getRandmelyCreatedSubCategoryName() {
		return subCategoryName;
	}

	

	public String readAlert() {
		return alert.getText();
	}

	public boolean readTableInsertElement() {

		List<WebElement> tableColumn = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]"));
		int flag = 0;
		boolean value = false;
		for (int i = 0; i < tableColumn.size(); i++) {
			if (tableColumn.get(i).getText().equals(subCategoryName)) {

				flag = 1;
				value = true;
			}

		}
		return value;

	}

	public String readTableElement(int row, int column) {

		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();

	}

	public void delItem() {

		del.get(0).click();
		driver.switchTo().alert().accept();

	}

	public boolean readTableDeleteElement() {

		List<WebElement> tableColumn = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]"));
		int flag = 0;
		boolean value = true;
		for (int i = 0; i < tableColumn.size(); i++) {
			if (tableColumn.get(i).getText().equals(subCategoryName)) {

				flag = 1;
				value = false;
			}

		}
		return value;
	}

	public void doSearchValid() {
		search.click();
		gu.selectDropdownWithIndex(searchCategory, 6);
		searchInput.sendKeys("blanche");
		searchbutton.click();

	}
	
	public void doSearchAfterDelete(String categoryDelValue,String SubCategoryDelValue) {
		search.click();
		gu.selectFromDropDownByVisibleText(searchCategory, categoryDelValue, driver);
		searchInput.sendKeys(SubCategoryDelValue);
		searchbutton.click();

	}
	

	

	public void doSearchInValid() {
		search.click();
		gu.selectDropdownWithIndex(searchCategory, 3);
		searchInput.sendKeys("####");
		searchbutton.click();

	}

	public boolean readTableSearchElementInvalid() {
		boolean read = false;
		WebElement tableColumn = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center"));
		if (tableColumn.getText().contains("RESULT NOT FOUND")) {
			read = true;
		}

		return read;

	}
	public boolean readTableAfterDelete() {
		boolean read = false;
		WebElement tableColumn = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center"));
		if (tableColumn.getText().contains("RESULT NOT FOUND")) {
			read = true;
		}

		return read;

	}

	public void delTableElement(String subCategory) {
		for (int i = 0; i < SubCategoryColumn.size(); i++) {
			if (SubCategoryColumn.get(i).getText().equals(subCategory)) {
				String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a[2]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
		}
	}

}
