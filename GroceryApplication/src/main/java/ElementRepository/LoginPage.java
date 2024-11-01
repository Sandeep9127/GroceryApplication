package ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
GeneralUtilities gu=new GeneralUtilities();
WebDriver driver;
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);//with page factory,init element is staic method of page factory.
 }
// By UserNameField=By.name("username"); with out page factory
 // WebElement element=driver.FindElement(UserNameField);
 @FindBy(name="username")
 WebElement userNameField;
 @FindBy(name="password")
 WebElement passWordField;
 @FindBy(xpath ="//button[text()=\"Sign In\"]")
 WebElement button;
 @FindBy(xpath = "//h5[text()=' Alert!']")
 WebElement inValidMessage;
 
 public String readInvalidMessage() {
	 
	 return inValidMessage.getText();
 }
public HomePage LoginData(String userName,String passWord)
 {
	// userNameField.sendKeys(userName);
	gu.sendKeyFunction(userNameField,userName);
	 passWordField.sendKeys(passWord);
	 button.click();
	 return new HomePage(driver);//chaining
 }


/*@FindBy(name="password")
 
 WebElement passWordField;
 
 public void LoginData2()
 {
	 passWordField.sendKeys("admin");
 }
@FindBy(xpath ="//button[text()=\"Sign In\"]")
 
 WebElement button;
 
 public void LoginData3()
 {
	 button.click();
 }*/
 
 

}

