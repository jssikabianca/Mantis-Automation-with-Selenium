package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunCucumberTest;
import java.util.Random;
import static org.junit.Assert.assertTrue;

public class Utils extends RunCucumberTest {

    public Utils() {
    }

    public void enterUsername(String usernameII) {
        WebElement usernameField = getDriver().findElement(By.id("username"));
        usernameField.sendKeys(usernameII);
    }

    public void enterPassword(String passwordII) {
        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.sendKeys(passwordII);
    }

    public void clickButton() {
        getDriver().findElement(By.cssSelector("input[value='Login']")).click();
    }

    public void successfulLogin() {
        this.enterUsername("Jessika_Pereira");
        this.clickButton();
        this.enterPassword("epM200806");
        this.clickButton();
    }

    public void issueButton() throws InterruptedException {
        //Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/bug_report_page.php']")));
        WebElement issueButton = getDriver().findElement(By.cssSelector("a[href='/bug_report_page.php']"));
        issueButton.click();
    }

    public void viewIssueButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/view_all_bug_page.php']")));
        WebElement viewIssueButton = getDriver().findElement(By.cssSelector("a[href='/view_all_bug_page.php']"));
        viewIssueButton.click();
    }

    public void getSelectorValue(String id, String text) {
        WebElement categorySelectElement = getDriver().findElement(By.id(id));
        Select categorySelect = new Select(categorySelectElement);
        categorySelect.selectByVisibleText(text);
    }

    public void getTextValue(String inputValue) {
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        String combinedText = inputValue + " " + randomNumber;
        WebElement input = getDriver().findElement(By.id(inputValue));
        input.sendKeys(combinedText);
    }

    public void fillFormIssue() {
        this.getSelectorValue("category_id", "[All Projects] categoria teste");
        this.getSelectorValue("reproducibility", "always");
        this.getSelectorValue("severity", "major");
        this.getSelectorValue("priority", "urgent");
        this.getTextValue("platform");
        this.getTextValue("os");
        this.getTextValue("os_build");
        this.getTextValue("summary");
        this.getTextValue("description");
        this.getTextValue("steps_to_reproduce");
        this.getTextValue("additional_info");
        this.getSelectorValue("tag_select", "Desenvolvimento");
    }

    public void createTask() throws InterruptedException {
        this.issueButton();
        this.fillFormIssue();
        WebElement submitButton = getDriver().findElement(By.cssSelector("input[value='Submit Issue']"));
        submitButton.click();
    }

    public void validateMainInformation(String identifier, String expectedText) {
        WebElement element = getDriver().findElement(By.cssSelector(identifier));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, actualText);
    }

    public void validateInformationByXpath(String path, String session) {
        WebElement unassignedLink = getDriver().findElement(By.xpath(path));
        assertTrue("The " + session + " is not displayed.", unassignedLink.isDisplayed());
    }
}