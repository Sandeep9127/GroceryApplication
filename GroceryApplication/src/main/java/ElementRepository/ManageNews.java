package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNews {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	String addedNews;
	
	public ManageNews(WebDriver driver) {
		
		this.driver=driver;
		 PageFactory.initElements(driver, this);//with page factory,init element is staic method of page factory.
		 
	}
	
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/news/add')]")
	WebElement newNewslink;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-new')]")
	WebElement newstablink;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement enterNewsArea;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	public void createItem() {

		String newNews = "test item" + gu.generateCurrentDateAndTime();
		this.addedNews = newNews;
		newstablink.click();
		newNewslink.click();
		enterNewsArea.sendKeys(newNews);
		saveButton.click();
		

	}
	public String readAlert() {
		return alert.getText();
	}
	public boolean readTableAfterNewNewsAddsion() {
		
		newstablink.click();
		List<WebElement> tableColumn = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]"));
		int flag = 0;
		boolean value = false;
		for (int i = 0; i < tableColumn.size(); i++) {
			if (tableColumn.get(i).getText().equals(addedNews)) {

				flag = 1;
				value = true;
			}

		}
		return value;

	}
}
