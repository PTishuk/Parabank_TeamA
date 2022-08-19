package cucumberframework.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;

	@Before
	public void setup() throws IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Given("User navigates to Parabank website")
	public void user_navigates_to_parabank_website() {
		this.driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}

	@Given("User enters valid username")
	public void user_enters_valid_username() {
		this.driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("test");
	}

	@Given("User enters valid password")
	public void user_enters_valid_password() {
		this.driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("test");
	}

	@When("User clicks Log In button")
	public void user_clicks_log_in_button() {
		this.driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}

	@Then("User is taken to Accounts Overview successfully")
	public void user_is_taken_to_accounts_overview_successfully() {
		WebElement accountOverviewTitle = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
		assertEquals(true, accountOverviewTitle.isDisplayed());
	}

	@Given("User navigates to Open New Account Page")
	public void user_navigates_to_open_new_account_page() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")).click();
	}

	@Then("User is taken to Open New Account Page")
	public void user_is_taken_to_open_new_account_page() {
		WebElement openNewAcctTitle = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));
		assertEquals(true, openNewAcctTitle.isDisplayed());
	}

	@When("User selects checking")
	public void user_selects_checking() {
		WebElement e = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select s = new Select(e);
		s.selectByIndex(1);
		s.selectByIndex(0);
	}

	@When("User selects second account")
	public void user_selects_second_account() {
		WebElement e = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));
		Select s = new Select(e);
		s.selectByIndex(1);
	}

	@When("User clicks on Open New Account button")
	public void user_clicks_on_open_new_account_button() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input")).click();
	}

	@Then("User is taken to confirmation page")
	public void user_is_taken_to_confirmation_page() {
		WebElement acctConfirmation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));
		assertEquals(true, acctConfirmation.isDisplayed());
	}

	@Given("User navigates to Transfer Funds Page")
	public void user_navigates_to_transfer_funds_page() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[3]/a")).click();		
	}

	@Then("User is taken to Transfer Funds Page")
	public void user_is_taken_to_transfer_funds_page() throws Throwable {
		WebElement transferPageTitle = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));
		assertEquals(true, transferPageTitle.isDisplayed());
		Thread.sleep(500);
	}

	@When("User enters amount")
	public void user_enters_amount() {
		this.driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("100");
	}

	@When("User selects to withdraw from second acount")
	public void user_selects_to_withdraw_from_second_acount() {
		WebElement e = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));
		Select s = new Select(e);
		s.selectByIndex(2);
		s.selectByIndex(1);
	}

	@When("User selects to deposit to third account")
	public void user_selects_to_deposit_to_third_account() {
		WebElement e = driver.findElement(By.xpath("//*[@id=\"toAccountId\"]"));
		Select s = new Select(e);
		s.selectByIndex(3);
		s.selectByIndex(2);
	}

	@When("User clicks transfer button1")
	public void user_clicks_transfer_button1() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[2]/input")).click();
	}

	@Then("User is taken to transfer confirmation page")
	public void user_is_taken_to_transfer_confirmation_page() {
		WebElement transferConfirmation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));
		assertEquals(true, transferConfirmation.isDisplayed());
	}
	
	@When("User clicks on Contact button")
	public void user_clicks_on_contact_button() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[2]/li[3]/a")).click();
	}

	@Then("User is navigated to Customer Care page")
	public void user_is_navigated_to_customer_care_page() {
		WebElement customerCareTitle = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/h1"));
		assertEquals(true, customerCareTitle.isDisplayed());
	}

	@When("User enters name")
	public void user_enters_name() {
		this.driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("name");
	}

	@When("User enters email")
	public void user_enters_email() {
		this.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("email@mail.com");
	}

	@When("User enters phone nummber")
	public void user_enters_phone_nummber() {
		this.driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("7041234567");
	}

	@When("User enters message")
	public void user_enters_message() {
		this.driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("customer care message");
	}

	@When("User clicks Send To button")
	public void user_clicks_send_to_button() {
		this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/input")).click();
	}

	@Then("User is navigated to Customer Care confirmation page")
	public void user_is_navigated_to_customer_care_confirmation_page() {
		WebElement customerCareConfirmation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p[2]"));
		assertEquals(true, customerCareConfirmation.isDisplayed());
	}
}
