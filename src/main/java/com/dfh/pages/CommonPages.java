package com.dfh.pages;

import com.dfh.driver.DriverManager;
import com.dfh.pages.LoginPage.AgentLoginPage;
import com.dfh.pages.LoginPage.CustomerLoginPage;
import com.dfh.pages.customerDetailsPage.CustomerReviewPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public class CommonPages {

    public WebDriver driver;
    private AgentLoginPage agentLoginPage;
    private CustomerLoginPage customerPage;
    private CustomerReviewPage customerReviewPage;

    public CommonPages() {
        this.driver = DriverManager.getDriver();
        this.customerPage = new CustomerLoginPage(driver);
        this.agentLoginPage = new AgentLoginPage(driver);
        this.customerReviewPage = new CustomerReviewPage(driver);
    }

//    public CustomerLoginPage getCustomerPage() {
//        if (customerPage == null) {
//            customerPage = new CustomerLoginPage(driver);
//        }
//        return customerPage;
//    }
//
//    public AgentLoginPage getAgentLoginPage() {
//        if (agentLoginPage == null) {
//            agentLoginPage = new AgentLoginPage(driver);
//        }
//        return agentLoginPage;
//    }

}
