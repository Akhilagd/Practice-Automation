package steps;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by karthik on 9/2/17.
 */
public class LocalDriver {

    public WebDriver getApplicationDriver() {
        String browser = System.getProperty("browser");
        System.out.println("Browser to be tested on --" + browser);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browser.equals("chrome")) {
            setChromeDriverBasedOnOperatingSystem();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("allow-running-insecure-content");
            options.addArguments("--disable-extensions");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            return new ChromeDriver(capabilities);
        }

        throw new RuntimeException("Not a supported driver");
    }


    private void setChromeDriverBasedOnOperatingSystem() {
        if (isWindows()) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            return;
        }
        if (isMac()) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
            return;
        }

        if (isLinux()) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver_linux");
            return;

        }
    }

    private boolean isWindows() {
        return SystemUtils.IS_OS_WINDOWS;
    }

    private boolean isLinux() {
        return SystemUtils.IS_OS_LINUX;
    }

    private boolean isMac() {
        return SystemUtils.IS_OS_MAC;
    }

  }



