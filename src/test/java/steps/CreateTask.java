package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunCucumberTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import support.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTask extends RunCucumberTest {
    private Utils utils;
    public CreateTask() {
        this.utils = new Utils();
    }


    @Given("the user is logged into the application")
    public void the_user_is_logged_into_the_application() {
        getDriver(Browser.CHROME).get("https://mantis-prova.base2.com.br/");
        utils.successfulLogin();
    }

    @When("^the user clicks the Report Issue button$")
    public void the_user_clicks_the_Report_Issue_button() throws InterruptedException {
        utils.issueButton();
    }

    @Given("^the user is on the create new task page$")
    public void the_user_is_on_the_create_new_task_page() throws Throwable {
        utils.issueButton();
    }

    @When("^the user fills out the new task form$")
    public void the_user_fills_out_the_new_task_form() {
        utils.fillFormIssue();
    }

    @When("^click on the submit issue")
    public void click_on_the_submit_issue() {
        WebElement submitButton = getDriver().findElement(By.cssSelector("input[value='Submit Issue']"));
        submitButton.click();
    }

    @Then("^the user should be redirected to the new task registration page$")
    public void the_user_should_be_redirected_to_the_new_task_registration_page() {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue("A URL atual não contém 'bug_report_page.php'.", currentUrl.contains("bug_report_page.php"));
    }

    @Then("^the user should remain on the create new task page$")
    public void the_user_should_remain_on_the_create_new_task_page() throws Throwable {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue("A URL atual não contém 'bug_report_page.php'.", currentUrl.contains("bug_report_page.php"));
    }

    @Then("^the user should see a success message confirming the task creation$")
    public void the_user_should_see_a_success_message_confirming_the_task_creation() {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue("A URL atual não contém 'bug_report.php?posted=1'.", currentUrl.contains("bug_report.php?posted=1"));
    }

    @Then("^the view Issue details appear in the screen$")
    public void the_view_Issue_details_appear_in_the_screen() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td.bug-category")));

        utils.validateMainInformation("td.bug-category", "[All Projects] categoria teste");
        utils.validateMainInformation("td.bug-project", "Jessika Pereira´s Project\"");
        utils.validateMainInformation("td.bug-view-status", "public");
        utils.validateMainInformation("td.bug-priority", "urgent");
        utils.validateMainInformation("td.bug-severity", "major");
        utils.validateMainInformation("td.bug-reproducibility", "always");
    }
}
