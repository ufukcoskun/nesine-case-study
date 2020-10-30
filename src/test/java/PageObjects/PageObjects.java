package PageObjects;

import org.openqa.selenium.By;

public class PageObjects{

    public static By loginButton = By.cssSelector("#header-login a[name='natu']");
    public static By userInput = By.id("txtUsername");
    public static By userPass = By.id("realpass");
    public static By myAccount = By.linkText("Hesabım");
    public static By memberName = By.id("spnMemberName");
    public static By popularBets = By.cssSelector(".popular-bets>a");
    public static By pageTitle = By.className("page-title");
    public static By popBetsCategories = By.className("category-web-tabs");
    public static By footballBets = By.cssSelector("a[href='#football']");
    public static By basketballBets = By.cssSelector("a[href='#basketball']");
    public static By couponBody = By.className("coupon-body");
    public static By logOut = By.linkText("Çıkış");

}
