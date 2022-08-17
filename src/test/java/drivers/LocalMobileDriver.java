package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
public class LocalMobileDriver implements WebDriverProvider {
    private static WebDriver driver;

    public static AndroidDriver getDriver(){
        return (AndroidDriver) driver;
    }
    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        String appPath = "src/test/resources/apps/bcc-dev-1.0.39.apk";
        File app = new File(appPath);

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setPlatformName("Android");
        options.setDeviceName("Galaxy Nexus API 30");
        options.setPlatformVersion("11.0");

        options.setApp(app.getAbsolutePath());
        options.setAppPackage("com.ronte.blackcatcard.dev");
        options.setAppActivity("com.ronte.blackcatcard.dev.MainActivity");

        driver = new AndroidDriver(getAppiumServerUrl(), options);

        return driver;
    }

}
