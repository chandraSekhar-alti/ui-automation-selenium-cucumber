package com.dfh.pages;

import com.dfh.driver.DriverManager;
import com.dfh.pages.LoginPage.LoginPage;
import com.dfh.utils.UI;
import com.dfh.utils.Assertions;
import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public class CommonPages {

    public WebDriver driver;
    private UI UI;
    private Assertions assertions;
    private LoginPage loginPage;

    public CommonPages() {
        this.driver = DriverManager.getDriver();
        this.UI = new UI(driver);
        this.assertions = new Assertions(driver);
        this.loginPage = new LoginPage(driver);
    }
}
