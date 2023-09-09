package praktikum;

import org.junit.Before;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {

    WebDriver driver;


    // выбор окружеия через конфигурацию
    @Override
    protected void before() throws Throwable {
        if ("firefox".equals(System.getProperty("browser")))
            setUpFirefox();
        else {
            setUpChrome();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    public void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        var service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/araikov/webdriver/chromedriver-mac-x64-116/chromedriver"))
                .build();

        var options = new ChromeOptions()
                .setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        driver = new ChromeDriver(service, options);
    }

    public void setUpFirefox() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("/Users/araikov/webdriver/geckodriver-116/geckodriver"))
                .build();

        var options = new FirefoxOptions()
                .setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

        driver = new FirefoxDriver(service, options);
    }



    @Override
    protected void after() {
        driver.quit();
    }



    public  WebDriver getDriver() {
        return driver;
    }
}
