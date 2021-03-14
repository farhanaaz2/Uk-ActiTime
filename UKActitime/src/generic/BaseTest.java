package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst1{
 
 public WebDriver driver;
 
 static {
  System.setProperty(CHROME_KEY, CHROME_VALUE);
 }
 
 @BeforeMethod
 public void openApp(){
  
  driver = new ChromeDriver();//open browser
  driver.manage().timeouts().implicitlyWait(ITime, TimeUnit.SECONDS);
  driver.get(APP_URL);
 }
 
 @AfterMethod
 public void closeApp(ITestResult ItestResult) {
  
  int status = ItestResult.getStatus();
  String name = ItestResult.getName();
  if(status==1)
  {
   Reporter.log("Test"+name+"is pass",true);
  }
  else 
  {
   Reporter.log("test"+name+"is fail/skipped");
   AutoLib.getPhoto(driver, IMAGE_PATH+name+".png");
  }
  driver.close();
 }

}
