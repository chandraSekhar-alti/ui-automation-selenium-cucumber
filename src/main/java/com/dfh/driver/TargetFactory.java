package com.dfh.driver;

import com.dfh.Exceptions.TargetNotValidException;
import com.dfh.constants.FrameworkConstants;
import com.dfh.enums.Target;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TargetFactory {
    private static final Logger log = LogManager.getLogger(TargetFactory.class);
    
    public WebDriver createInstance() {
        Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
        WebDriver webDriver;

        switch (target) {
            case LOCAL:
                //
                webDriver = BrowserFactory.valueOf(FrameworkConstants.BROWSER.toUpperCase()).createDriver();
                break;
            case REMOTE:
                //
                webDriver = createRemoteInstance(BrowserFactory.valueOf(FrameworkConstants.BROWSER.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webDriver;
    }

    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
        WebDriver webDriver;

        String browserName = (FrameworkConstants.BROWSER != null && FrameworkConstants.BROWSER.isEmpty()) ? FrameworkConstants.BROWSER : browser;
        switch (target) {
            case LOCAL:
                webDriver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
                break;
            case REMOTE:
                webDriver = createRemoteInstance(BrowserFactory.valueOf(browserName.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webDriver;
    }

    private WebDriver createRemoteInstance(MutableCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", FrameworkConstants.REMOTE_URL, FrameworkConstants.REMOTE_PORT);
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capabilities);
            log.info("Remote URL : " + gridURL);
        } catch (MalformedURLException e) {
            log.error("Grid URL is invalid or grid port is invalid");
            log.error("Browser :  %s " + capabilities.getBrowserName(), e);
        } catch (IllegalArgumentException e) {
            log.error(String.format("Browser %s is not valid or recognized ", capabilities.getBrowserName(), e));
        }
        return remoteWebDriver;
    }
}