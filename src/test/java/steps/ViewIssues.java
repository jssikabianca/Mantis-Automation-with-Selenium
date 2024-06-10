package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunCucumberTest;
import support.Utils;

public class ViewIssues extends RunCucumberTest {
    private Utils utils;

    public ViewIssues() {
        this.utils = new Utils();
    }

    @Given("^that I am logged into the application$")
    public void that_I_am_logged_into_the_application() {
        getDriver(Browser.CHROME).get("https://mantis-prova.base2.com.br/");
        utils.successfulLogin();
    }

    @Given("^a issue has been created with category$")
    public void a_issue_has_been_created_with_category() throws InterruptedException {
        utils.createTask();
    }

    @When("^I create a new task")
    public void i_create_a_new_task() throws InterruptedException {
        utils.createTask();
    }

    @Then("^I should see the issue with the main information$")
    public void i_should_see_the_issue_with_the_main_information() throws InterruptedException {
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
