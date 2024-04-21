import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TimeoutException;
import java.math.BigDecimal;




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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement devices = driver.findElement(By.className("custom-checkbox"));
        devices.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> color = driver.findElements(By.className("custom-checkbox"));
        if (color.size() >= 15) {
            WebElement thirdArrowIcon = color.get(14);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_emj240105094151989465_so_waw240404165038355262']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement subscriptionPlan = driver.findElement(By.id("relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468"));
        subscriptionPlan.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String radioButtonXpath = "//label[.//span[contains(text(), '1559.98')]]//input[@type='radio']";

        try {
            WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(radioButtonXpath)));

            // Scroll into view and click using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

            System.out.println("Clicked the radio button for price 1559.98.");
        } catch (Exception e) {
            System.err.println("Failed to click on the radio button: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clientWithoutVivacom = wait2.until(ExpectedConditions.elementToBeClickable(By.id("xSellBtn")));
        clientWithoutVivacom.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement buyButton = wait3.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buyButton);
        jsExecutor.executeScript("arguments[0].click();", buyButton);

        // verifikaciq che sme w koshnicata

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement continueShoppingButton = wait2.until(ExpectedConditions.elementToBeClickable(By.name("vivacom-cart-link-button-continue-shopping")));
        continueShoppingButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement dropdownToggle2 = driver.findElement(By.className("dropdown-toggle"));
        dropdownToggle2.click();
        List<WebElement> options2 = driver.findElements(By.className("dropdown"));
        for (WebElement option : options2) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<WebElement> optionIphone = driver.findElements(By.className("custom-checkbox"));
        if (optionIphone.size() >= 2) {
            WebElement thirdArrowIcon = optionIphone.get(1);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<WebElement> upperPriceAccesories = driver.findElements(By.className("custom-checkbox"));
        if (upperPriceAccesories.size() >= 14) {
            WebElement thirdArrowIcon = upperPriceAccesories.get(13);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-accessories/apple-iphone-15-pro-finewoven-case-taupe?offer=epc_simfreedevice00000001_so_jee230921123929324872']")).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        WebElement buyButton2 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor2.executeScript("arguments[0].scrollIntoView(true);", buyButton2);
        jsExecutor2.executeScript("arguments[0].click();", buyButton2);


        //verifikaciq che sme v koshnicata


        // проверка, ако се надвишава 1680 лв.




    //верификация, че бутоните за поръчай като настоящ и нов клиент са неактивни

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement checkoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-checkout-btn")));
//        boolean isDisabled = checkoutButton.getAttribute("class").contains("disable-elm") || checkoutButton.getAttribute("disabled") != null;
//        System.out.println("The checkout button is disabled: " + isDisabled);
//

        //обши условия

//        WebElement termes = driver.findElement(By.className("vivacom-icon icon-box_empty"));
//        termes.click();


        //Премахване на телефона от кошницата

//        WebElement removePhoneFromBasket = driver.findElement(By.className("vivacom-icons icon-close_x"));
//        removePhoneFromBasket.click();


        // Верификация на съобщение
//        WebElement messageElement = driver.findElement(By.xpath("//*[contains(text(), 'Вижте актуалните ни оферти')]"));
//        String messageText = messageElement.getText();
//        String expectedText = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";
//
//        if(messageText.contains(expectedText)) {
//            System.out.println("The message is displayed correctly.");
//        } else {
//            System.out.println("The message is NOT displayed correctly.");
//        }



        //Изключване на google chrome след успешно преминал тест
//        driver.quit();

    }

}
