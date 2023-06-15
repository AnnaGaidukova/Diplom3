package stellarburgers.pages.extentions;

import org.openqa.selenium.WebDriver;


public class WebDriverFactory {
    private static final String YANDEX_BROWSER_PATH = "C:\\Users\\krist\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
    //C:\Users\krist\AppData\Local\Yandex\YandexBrowser\Application
    public static void initWebDriver() {
        String browser = System.getProperty("browser"); //запуск для яндекс mvn clean test -Dbrowser=yandex для хром mvn clean test -Dbrowser=chrome
        if (browser.equals("yandex")){
            createYandexDriver();
        }
    }
    private static void createYandexDriver() {
        System.setProperty("webdriver.chrome.driver",  "src/main/resources/chromedriver.exe");
        //Configuration.browserBinary = YANDEX_BROWSER_PATH;
    }
}