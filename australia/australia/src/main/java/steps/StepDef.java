package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
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
		click(locateElement("submitAccount"));
	}

}
