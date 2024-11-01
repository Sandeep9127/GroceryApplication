package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContact {
	
	GeneralUtilities gu = new GeneralUtilities();
		WebDriver driver;
		static String DeliveryChargeLimitFiledAfterUpdate;
		 public ManageContact(WebDriver driver)
		 {
			 this.driver=driver;
			 PageFactory.initElements(driver, this);//with page factory,init element is staic method of page factory.
		 }
		 
		 @FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-contact')]")
		 WebElement ManageContactLink;
		 @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[6]//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1')]")
		 WebElement editButton;
		 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[5]")
		 WebElement deliveryChargeLimitField;
		 @FindBy(xpath = "//input[@name='del_limit']")
		 WebElement limitEditFiled;
		 @FindBy(xpath = "//button[@name='Update']")
		 WebElement updateButton;
		 @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
			WebElement alert;
		 
		 /*public void getDetailBeforeUpdate()
		 {   
			 ManageContactLink.click();
			 DeliveryChargeLimitFiledBeforeUpdate=deliveryChargeLimitField.getText(); 
		 }*/
		 
		 public void UpdateTableDetail()
		 {
			 goToContacts();
			 editButton.click();
			 String updatedValue = gu.generateCurrentDateAndTime();
			 this.DeliveryChargeLimitFiledAfterUpdate=updatedValue;
			 
			 limitEditFiled.clear();
			 limitEditFiled.sendKeys(this.DeliveryChargeLimitFiledAfterUpdate);
			 updateButton.click();
		 }
		 public String readAlert()
		 {
				return alert.getText();
			}
		 
		 public boolean readTableForUpdatedItem() {

				List<WebElement> updatedColumn = driver
						.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[5]"));
				
				boolean value = false;
				for (int i = 0; i < updatedColumn.size(); i++) {
					
					if (updatedColumn.get(i).getText().equals(DeliveryChargeLimitFiledAfterUpdate.toString())) {

						value = true;
						System.out.println(DeliveryChargeLimitFiledAfterUpdate);
					}

				}
				return value;
				

			}
		 public void goToContacts()
		 {
			 ManageContactLink.click();
			}
		 
		 

}
