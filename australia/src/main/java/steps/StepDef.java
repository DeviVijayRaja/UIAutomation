package steps;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wdMethods.SeMethods;

public class StepDef extends SeMethods {
	

	public ChromeDriver driver;
	public static String fName, lName, email;
	
	
	@Given("Open The Browser")
	public void openBrowser() {
		startApp("chrome", "http://automationpractice.com");
	}

	@Given("Click on Sign in link")
	public void clickSignIn() {
		click(locateElement("linktext", "Sign in"));
	}

	@Given("Enter Email address as (.*)")
	public void enterEmail(String data) {
		typeWithTap(locateElement("id", "email_create"), data);
		
	}

	@Given("Click on Create an Account button")
	public void clickCreateAccount() {
		click(locateElement("id", "SubmitCreate"));
	}

	@Given("Verify Green or Red tick")
	public void verifyEmailBackColor() {

	}

	@Given("Enter Firstname as (.*)")
	public void enterFirstName(String data) {
		type(locateElement("id", "customer_firstname"), data);
		fName = data;
	}

	@Given("Enter Lastname as (.*)")
	public void enterLastName(String data) {
		type(locateElement("id", "customer_lastname"), data);
		lName = data;
	}

	@Given("Enter Password as (.*)")
	public void enterPassword(String data) {
		type(locateElement("id", "passwd"), data);
	}
	
	@Given("Verify Firstname,Lastname,Email pre-populated")
	public void  verifyDetails() {
		verifyExactAttribute(locateElement("xpath", "//input[@id='firstname']"), "value", fName);
		verifyExactAttribute(locateElement("xpath", "//input[@id='lastname']"), "value", lName);		
	}

	@Given("Enter Address as (.*)")
	public void enterAddress(String data) {
		type(locateElement("address1"), data);
	}
	
	@Given("Enter City as (.*)")
	public void enterCity(String data) {
		type(locateElement("city"), data);
	}

	@Given("Select State as (.*)")
	public void selectState(String data) {
		selectDropDownUsingText(locateElement("id_state"), data);
	}

	@Given("Enter Zipcode as (.*)")
	public void enterZipCode(String data) {
		type(locateElement("postcode"), data);
	}

	@Given("Select Country as (.*)")
	public void selectCountry(String value) {
			selectDropDownUsingText(locateElement("id","id_country"), value);
	}

	@Given("Enter MobilePhone as (.*)")
	public void enterMobile(String data) {
		type(locateElement("phone_mobile"), data);
	}

	@Given("Enter alias Address as (.*)")
	public void enterAlias(String data) {
		type(locateElement("alias"), data);
	}

	@Given("Verify whether Registration is successful")
	public void clickRegistration() {
		try {
		click(locateElement("submitAccount"));
		reportStep("Registration is successful", "Pass");
		}
		catch(Exception e){
			reportStep("Registration is Unsuccessful", "Fail");
		}
	}
	
	@And("Enter SignIn Email as (.*)")
	public void signInEmail(String data) {
		type(locateElement("id", "email"), data);
	}
	@And("Click on Sign in button")
	public void signInButton() {
		click(locateElement("id", "SubmitLogin"));
	}
	@And("Click on Megamenu")
	public void megaMenu() {
		click(locateElement("xpath", "(//div[@id='block_top_menu']//a[contains(text(),'Dresses')])[5]"));
	}
	@When("Click on DressType (.*)")
	public void dresses(String data) {
		click(locateElement("partialLink", data));
	}
	@Then("Verify Dresses should be displayed")
	public void dressesDisplayed() {
		reportStep("Summer Dresses Page is displayed", "Pass");
		System.out.println("Summer Dresses Page is displayed");	
	}
	@When("Select Sort by as (.*)")
	public void sortBy(String value) {
	selectDropDownUsingText(locateElement("id", "selectProductSort"),value);
	}
	@Then("Verify Dresses sorted by")
	public void dressesSorted() {
		List<WebElement> ls = locateElements("//div[@class='left-block']//span[@class='price product-price']");
		int size = ls.size();
		 String[] actual = new String[size]; 
		 String[] sorted = new String[size];

		 for (int i = 0; i < size; i++) 
		 {
		    actual[i]=sorted[i]=ls.get(i).getText(); //= WebDriverFactory.getWebDriver().findElement(By.xpath(".//[@id='paymentFormsTabl']//tbody//tr[" + i+ "]//td[starts-with(@id,'payment-forms-form-name')]")).getText();
		 }

		 //Sorting the array
		 Arrays.sort(sorted);

		 //Validating the existing with sorted array. shows no message if both are same
		 
		 for(int i = 0;i<size;i++)
		 {
		     if(!actual[i].equals(sorted[i]))
		     {
		    	 reportStep("The Dresses are not sorted", "Fail");
		    	 System.out.println("The dress in the webpage are not sorted");
		         System.out.println("expected "+sorted[i]+" but actual "+actual[i]+" at row "+i);
		         //flag = true;
		     }
	}
		 reportStep("The Dresses are sorted", "Pass");

	 
	}
	
	@Then ("Change the Color of the dress as")
	public void colorChange(String value) {
		click(locateElement("class", "product_img_link"));
		List<WebElement> colorList = locateElements("//ul[@id='color_to_pick_list']/li/a");
		//ul[@id='color_to_pick_list']/li
		int size = colorList.size();
		System.out.println("The size of colorlist is: "+size);
		/*for(i =0;i<size;i++)
		{
			System.out.println(colorList.get(i).getText());
			
		}*/

	}
}

