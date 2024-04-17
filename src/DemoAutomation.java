import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        if (color.size() >= 15) {
            WebElement thirdArrowIcon = color.get(15);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }


        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_emj240105094151989465_so_waw240404165038355262']")).click();


// dfosd
//        WebElement subscriptionPlan = driver.findElement(By.id("relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468"));
//        subscriptionPlan.click();
//        List<WebElement> planPrice = driver.findElements(By.className("simple-radio-btns-wrapper-label"));
//        if (!planPrice.isEmpty()) {
//            WebElement thirdArrowIcon = planPrice.get(0);
//            thirdArrowIcon.click();
//        } else {
//            System.out.println("");
//        }


       // driver.quit();

    }

}
