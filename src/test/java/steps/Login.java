package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunCucumberTest;
import support.Utils;

public class Login extends RunCucumberTest {
    private Utils utils;
    public Login() {
        this.utils = new Utils();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        getDriver(Browser.CHROME).get("https://mantis-prova.base2.com.br/");
    }

    @When("the user enters a valid username and click the \"Login\" button")
    public void the_user_enters_a_valid_username_and_click_the_Login_button() {
        String username = "Jessika_Pereira";
        utils.enterUsername(username);
        utils.clickButton();
    }

    @When("the user enters a valid password and click the \"Login\" button")
    public void the_user_enters_a_valid_password_and_click_the_Login_button() throws InterruptedException {
        String passwordII = "epM200806";
        utils.enterPassword(passwordII);
        utils.clickButton();
    }

    @When("the user enters an invalid username and click the \"Login\" button")
    public void the_user_enters_an_invalid_username_and_click_the_Login_button() {
        String username = "Jessika_Pereir";
        utils.enterUsername(username);
        utils.clickButton();
    }

    @When("the user enters an invalid password and click the \"Login\" button")
    public void the_user_enters_an_invalid_password_and_click_the_Login_button() {
        String passwordII = "1111";
        utils.enterPassword(passwordII);
        utils.clickButton();
    }

    @When("the user clicks the \"Login\" button without entering credentials")
    public void the_user_clicks_the_Login_button_without_entering_credentials() {
        utils.clickButton();
    }

    @Then("^the user should be redirected to the dashboard page$")
    public void the_user_should_be_redirected_to_the_dashboard_page() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Unassigned')]")));
        utils.validateInformationByXpath("//a[contains(text(),'Unassigned')]", "Unassigned");
        utils.validateInformationByXpath("//a[contains(text(),'Reported by Me')]", "Reported by Me");
        utils.validateInformationByXpath("//a[contains(text(),'Resolved')]", "Resolved");
        utils.validateInformationByXpath("//a[contains(text(),'Recently Modified (30 Days)')]", "Recently Modified (30 Days)");
        utils.validateInformationByXpath("//a[contains(text(),'Monitored by Me')]", "Monitored by Me");
    }

    @Then("^the user should see an error message$")
    public void the_user_should_see_an_error_message() {
        utils.validateInformationByXpath("//p[contains(text(),'Your account may be disabled or blocked or the username/password you entered is incorrect.')]", "message");
    }
}

