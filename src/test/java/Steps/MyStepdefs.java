package Steps;

import Base.Base;
import PageObjects.PageObjects;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.restassured.RestAssured.given;


public class MyStepdefs extends Base {

    public PageObjects pageObj;
    private java.lang.Object Object;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String memberNo = "13711643";
    String memberPass = "deneme91";
    String popBetsUrl = "https://www.nesine.com/iddaa/populer-bahisler";


    @Given("^Get nesine main page$")
    public void getNesineMainPage() {
        geturl();
    }

    @When("^Login as a valid user$")
    public void loginAsAValidUser() {
        Assert.assertTrue(driver.findElement(pageObj.loginButton).isDisplayed());
        driver.findElement(pageObj.userInput).sendKeys(memberNo);
        driver.findElement(pageObj.userPass).sendKeys(memberPass);
        driver.findElement(pageObj.loginButton).click();
    }

    @Then("^Check login correctly$")
    public void checkLoginCorrectly() {
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.myAccount));
        driver.findElement(pageObj.memberName).getText().contains("UFUK");
    }

    @And("^Visit 'popular bets' page$")
    public void visitPopularBetsPage() {
        driver.findElement(pageObj.popularBets).click();
    }

    @And("^Check at 'popular bets' page$")
    public void checkAtPopularBetsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.popBetsCategories));
        driver.findElement(pageObj.pageTitle).getText().contains("POPÜLER BAHİSLER");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, popBetsUrl);
    }

    @And("^Click 'futbol' tab$")
    public void clickFutbolTab() {
        driver.findElement(pageObj.footballBets).click();
    }

    @And("^Check at 'futbol' tab$")
    public void checkAtFutbolTab() {
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.couponBody));
    }

    @And("^Get 'popular bets' via api call$")
    public void getPopularBetsViaPostApiCall() {
        given()
                .contentType("application/json")
                .body("{\"eventType\":1,\"date\":null}")
                .when().post("https://www.nesine.com/Iddaa/GetPopularBets")
                //.then().assertThat().contentType(ContentType.JSON).body(notNullValue());
                .then().statusCode(200);
    }


    @And("^Logout the system$")
    public void logoutTheSystem() {
        driver.findElement(pageObj.myAccount).click();
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.logOut));
        driver.findElement(pageObj.logOut).click();
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.loginButton));
    }

    @And("^Click 'basketball' tab$")
    public void clickBasketballTab() {
        driver.findElement(pageObj.basketballBets).click();
    }

    @And("^Check at 'basketball' tab$")
    public void checkAtBasketballTab() {
        wait.until(ExpectedConditions.elementToBeClickable(pageObj.couponBody));
    }

}
