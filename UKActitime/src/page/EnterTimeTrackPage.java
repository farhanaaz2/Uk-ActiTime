package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
 
 
 public EnterTimeTrackPage(WebDriver driver) {
  PageFactory.initElements(driver,this);
 }
 
 public void verifyHomePageIsDisplayed(WebDriver driver,long time,String title) {
  WebDriverWait wait = new WebDriverWait(driver, time);
  try {
   wait.until(ExpectedConditions.titleContains(title));
   Reporter.log("Home page is Displayed",true);
  }
  catch (Exception e) {
   Reporter.log("Homepage is not displayed",true);
   Assert.fail();
  }
 }

}