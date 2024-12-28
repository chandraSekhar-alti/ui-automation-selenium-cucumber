package com.dfh.pages;

import com.dfh.driver.DriverManager;
import com.dfh.pages.LoginPage.AgentLoginPage;
import com.dfh.pages.LoginPage.CustomerLoginPage;
import com.dfh.pages.customerDetailsPage.CustomerReviewPage;
import com.dfh.pages.householdPage.HouseHoldPage;
import com.dfh.pages.summaryPage.SummaryPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public class CommonPages {

    public WebDriver driver;
    private AgentLoginPage agentLoginPage;
    private CustomerLoginPage customerPage;
    private CustomerReviewPage customerReviewPage;
    private SummaryPage summaryPage;
    private HouseHoldPage houseHoldPage;

    public CommonPages() {
        this.driver = DriverManager.getDriver();
        this.customerPage = new CustomerLoginPage(driver);
        this.agentLoginPage = new AgentLoginPage(driver);
        this.customerReviewPage = new CustomerReviewPage(driver);
        this.summaryPage = new SummaryPage(driver);
        this.houseHoldPage = new HouseHoldPage(driver);
    }


}
