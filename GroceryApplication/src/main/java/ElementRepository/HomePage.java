package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath ="//span[text()='7rmart supermarket']")
	 WebElement heading;
	 @FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
		WebElement link1subCategoryMenu;
	 public String readHeading()
	 {
		 return heading.getText();
	 }
	 public SubCategory goToSubCategory() {

			link1subCategoryMenu.click();
			return new SubCategory(driver);

		}

}
