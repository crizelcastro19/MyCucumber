package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPages;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I want to navigate to page$")
    public void iWantToNavigateToPage() {

    System.out.print("Open Browser");
    base.Driver.navigate().to("https://demosite.executeautomation.com/Login.html");

    }

    @And("^I enter credentials$")
    public void iEnterCredentials(DataTable table) {
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);

        LoginPages pages = new LoginPages(base.Driver);
        for (User user:users) {
            pages.Login(user.username, user.password);

        }
    }


    @And("^I click button$")
    public void iClickButton() {
        LoginPages pages = new LoginPages(base.Driver);
        pages.ClickLogin();

    }

    @Then("^Success page displays$")
    public void successPageDisplays() {
       Assert.assertEquals(base.Driver.findElement(By.xpath("//h1[text()='Execute Automation Selenium Test Site']")).isDisplayed(), true);


    }

    @And("^I enter ([^\"]*) and ([^\"]*) for this features$")
    public void iEnterUserNameAndPassWordForThisFeatures(String username, String password) {
            System.out.println(username);
            System.out.println(password);
    }

    @And("^I enter user email address as Email:([^\"]*)$")
    public void iEnterUserEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) {
        System.out.print("Email Address is:" + email);
    }

    @And("^I verify the count of my salary to digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryToDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) {
        System.out.println("My Salary digits is: " + salary);
    }
    public static class User
    {
        public String username;
        public String password;

        public User(String userNames, String passWords) {
            this.username = userNames;
            this.password = passWords;
        }
    }

}
