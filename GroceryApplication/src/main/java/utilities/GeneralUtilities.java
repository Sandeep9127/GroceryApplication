package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public void sendKeyFunction(WebElement element,String text) {
		
		element.sendKeys(text);
	}
public void clickButton(WebElement element) {
		
		element.click();
	}
public void alertClick(String value,WebDriver driver) {
	
	if(value.equalsIgnoreCase("accept"))
	{
		driver.switchTo().alert().accept();
	}
	if(value.equalsIgnoreCase("reject"))
	{
		driver.switchTo().alert().dismiss();
	}
}
public String alerttext(WebDriver driver) {
	
	return driver.switchTo().alert().getText();
}
public void dragAndDrop1(WebElement sorce, WebElement target,WebDriver driver) {
	
	Actions obj1=new Actions(driver);
	obj1.dragAndDrop(sorce, target).perform();
}
public void selectFromDropDownByIndex(WebElement DropList,int index,WebDriver driver) {
	
	Select selectObject=new Select(DropList);
	selectObject.selectByIndex(index);
}
public void selectFromDropDownByVisibleText(WebElement DropList,String text,WebDriver driver) {
	
	Select selectObject=new Select(DropList);
	selectObject.selectByVisibleText(text);
}
public int randon(int limit) {
	Random random = new Random();
	// int limit = 1000;
	int randomNumber = random.nextInt(limit);
	return randomNumber;
}
public String generateCurrentDateAndTime() {
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
	return formatter.format(date);
}
public String generateCurrentDateByPattern(String pattern) {
	LocalDate currentDate = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);	
	String formattedDate = currentDate.format(formatter);
	return formattedDate;
}
public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", element);
}

}
