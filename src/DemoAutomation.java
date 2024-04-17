import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoAutomation {

    public static void main(String[] args) {


        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://vivacom.bg/bg");

        WebElement cookieButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookieButton.click();


        WebElement dropdownToggle = driver.findElement(By.className("dropdown-toggle"));
        dropdownToggle.click();
        List<WebElement> options = driver.findElements(By.className("dropdown"));
        for (WebElement option : options) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        }


        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones']")).click();


        WebElement devices = driver.findElement(By.className("custom-checkbox"));
        devices.click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        List<WebElement> color = driver.findElements(By.className("custom-checkbox"));
        if (color.size() >= 16) {
            WebElement thirdArrowIcon = color.get(15);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }


        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_emj240105094151989465_so_waw240404165038355262']")).click();



        WebElement subscriptionPlan = driver.findElement(By.id("relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468"));
        subscriptionPlan.click();

//        List<WebElement> priceButtons = driver.findElements(By.className("class-for-price-buttons"));
//        for (WebElement button : priceButtons) {
//            if (button.getText().contains("1559.98")) {
//                button.click();
//                break;
//            }
//        }

        WebElement withoutClientPlan = driver.findElement(By.id("xSellBtn"));
        withoutClientPlan.click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement buyButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buyButton);
        jsExecutor.executeScript("arguments[0].click();", buyButton);

        WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("vivacom-cart-link-button-continue-shopping")));
        continueShoppingButton.click();

        WebElement dropdownToggle2 = driver.findElement(By.className("dropdown-toggle"));
        dropdownToggle2.click();
        List<WebElement> options2 = driver.findElements(By.className("dropdown"));
        for (WebElement option : options2) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        }

        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")).click();

        List<WebElement> optionIphone = driver.findElements(By.className("custom-checkbox"));
        if (optionIphone.size() >= 2) {
            WebElement thirdArrowIcon = optionIphone.get(1);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        List<WebElement> upperPriceAccesories = driver.findElements(By.className("custom-checkbox"));
        if (upperPriceAccesories.size() >= 14) {
            WebElement thirdArrowIcon = upperPriceAccesories.get(13);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-accessories/apple-iphone-15-pro-finewoven-case-taupe?offer=epc_simfreedevice00000001_so_jee230921123929324872']")).click();

        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        WebElement buyButton2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor2.executeScript("arguments[0].scrollIntoView(true);", buyButton2);
        jsExecutor2.executeScript("arguments[0].click();", buyButton2);

//        WebElement nextBuy = driver.findElement(By.cssSelector("see-more"));
//        nextBuy.click();
      //  driver.quit();

    }

}
