package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ExcelUtility;
import utilities.ScreenShotCapture;

public class BaseClass {
	ExcelUtility eu=new ExcelUtility();
  WebDriver driver;
  ScreenShotCapture sc;
  public static Properties pro;

  public String groceryData(int row,int column) throws IOException {
   String path=System.getProperty("user.dir")+"\\src\\main\\resources\\Excel\\Input sheet.xlsx";
   return eu.readGroceryData(path, row, column);
  
  }

  public static void testBasic() throws IOException {

  		pro = new Properties();
  		FileInputStream fp = new FileInputStream(
  				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
  		pro.load(fp);
  	}
  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void beforeMethod(String browsername) throws IOException {
	   testBasic();
	  if(browsername.equals("chrome"))
	  {
		  
	  driver=new ChromeDriver();
		
	  }
	  else if(browsername.equals("edge"))
	  {
	  driver=new EdgeDriver();
	  }
	  driver.get(pro.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
  }

  @AfterMethod(alwaysRun = true)

	public void afterMethode(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			sc = new ScreenShotCapture();

			sc.captureFailureScreenShot(driver, iTestResult.getName());

		}

		driver.quit();

	}

}
