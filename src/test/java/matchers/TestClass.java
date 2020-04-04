package matchers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestClass {

    @Test
    public void testContainsStringIgnoringCaseMatcher() {
        String someStr = "Java is a general-purpose programming language that is class-based, object-oriented.";
        String substr = "pRograMming langUage";

        assertThat(someStr, ContainsStringIgnoringCaseMatcher.containsStringIgnoringCase(substr));
    }

    @Test
    public void testWebElementHasTextMatcher() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://pn.com.ua/");
        WebElement webElement = driver.findElement(By.xpath("//li[@class='active']//span"));
        String expectedText = "ТОВАРЫ И УСЛУГИ";

        assertThat(webElement, HasTextMatcher.hasText(expectedText));

        driver.quit();
    }
}