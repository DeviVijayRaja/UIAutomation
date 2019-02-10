package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class SeMethods extends Reporter{
	public int i = 1;
	public static RemoteWebDriver driver;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The browser: "+browser+" launched successfully", "pass");
		} catch (WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "fail");
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "name" : return driver.findElementByName(locValue);
			case "linktext" : return driver.findElementByLinkText(locValue);
			case "partialLink" : return driver.findElementByPartialLinkText(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "cssSelect" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "fail");
		}
		return null;
	}
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}
	//Added by Devi
	public List<WebElement> locateElements(String locValue) {
		return driver.findElements(By.xpath(locValue));
	}
	//

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}

	public void typeWithTap(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.TAB);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "fail");
		} 
	}
	//Added by Devi Raja 
	public void click(WebElement ele,String data) {
		String text = "";
		try {			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "fail");
		} 
	}
	//

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		}
		return bReturn;
	}


	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		} 
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"pass");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		}
	}


	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"pass");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "fail");
		} 

	}


	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "fail");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "fail");
		}
	}


	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","pass");
		} catch (Exception e) {
			reportStep("The browser could not be closed","fail");
		}
	}


}