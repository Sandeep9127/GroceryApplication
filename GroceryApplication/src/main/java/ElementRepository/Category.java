package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category {
	WebDriver driver;
	String selectedItemToSearch;
	public Category(WebDriver driver) {
		
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	

	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')]")
	WebElement categorylink;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[1]")
	WebElement button;
	@FindBy(xpath="//input[@id='category']")
	WebElement cate;
	@FindBy(xpath="//a[contains(@href,'javascript:void(0)')]")
	WebElement searchButton;
	@FindBy(xpath="//input[@name='un']")
	WebElement categorySearchbox;
	@FindBy(xpath="//button[@name='Search']")
	WebElement finalSearchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[1]")
	List<WebElement> Firstcolumn;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;
	public void validSearch()
	{  
		
		
		categorylink.click();
		searchButton.click();
		WebElement senditem=Firstcolumn.get(4);
		selectedItemToSearch=senditem.getText();
		categorySearchbox.sendKeys(selectedItemToSearch);
		finalSearchButton.click();
		
	}
	public void invalidSearch()
	{  
		
		
		categorylink.click();
		searchButton.click();
		categorySearchbox.sendKeys("###");
		finalSearchButton.click();
		
	}
	public boolean readtabelValidSearch()
	{
		boolean read = false;
		WebElement tableColumn = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		if (tableColumn.getText().contains(selectedItemToSearch)) {
			read = true;
		}

		return read;

	}
	
	public boolean readtabelinValidSearch()
	{
		boolean read = false;
		WebElement tableColumn = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center"));
		if (tableColumn.getText().contains("RESULT NOT FOUND")) {
			read = true;
		}

		return read;

	}
	}
	

