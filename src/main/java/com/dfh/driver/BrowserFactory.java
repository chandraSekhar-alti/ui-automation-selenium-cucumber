package com.dfh.driver;

import com.dfh.constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum BrowserFactory {


    CHROME{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.chromedriver().create();
            return new ChromeDriver();
        }

        @Override
        public ChromeOptions getOptions(){
            ChromeOptions options = new ChromeOptions();
            Map<String, Objects> preferences = new HashMap<>();

            if (Boolean.valueOf(FrameworkConstants.HEADLESS)){
                options.addArguments("--headless=new");
            }
            return options;
        }
    },FIREFOX{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.firefoxdriver().create();
            return new FirefoxDriver();
        }

        @Override
        public FirefoxOptions getOptions(){
            FirefoxOptions options = new FirefoxOptions();
            Map<String, Objects> preferences = new HashMap<>();

            if (Boolean.valueOf(FrameworkConstants.HEADLESS)){
                options.addArguments("--headless=new");
            }
            return options;
        }
    },
    EDGE{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.firefoxdriver().create();
            return new FirefoxDriver();
        }

        @Override
        public EdgeOptions getOptions(){
            EdgeOptions options = new EdgeOptions();
            Map<String, Objects> preferences = new HashMap<>();

            if (Boolean.valueOf(FrameworkConstants.HEADLESS)){
                options.addArguments("--headless=new");
            }
            return options;
        }
    };


    public abstract WebDriver createDriver();

    public abstract MutableCapabilities getOptions();

//    public abstract Dimension setBrowserDimensions(int width, int height);

}
