import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;


import static org.openqa.selenium.By.className;

public class DemoAutomation {

    public static void main(String[] args) throws InterruptedException {


        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximaze-ваме прозореца преди да отворим url-a

        driver.get("http://vivacom.bg/bg"); // url-a, в случая сайта на Vivacom

        WebElement cookieButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookieButton.click(); // "Приемаме" бисквитките

        Thread.sleep(2000); // Изчакваме 2 секунди до следващата стъпка

        WebElement dropdownToggle = driver.findElement(className("dropdown-toggle"));
        dropdownToggle.click();
        List<WebElement> options = driver.findElements(className("dropdown"));
        for (WebElement option : options) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        }   // от менюто селектираме "Устройства"

        Thread.sleep(2000); // Изчакваме 2 секунди до следващата стъпка


        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones']")).click();
        // Избираме от падащото меню - "Мобилни телефони"

        Thread.sleep(2000); //Изчакваме 2 секунди до следващата стъпка


        WebElement devices = driver.findElement(className("custom-checkbox"));
        devices.click();

        Thread.sleep(2000);

        List<WebElement> color = driver.findElements(className("custom-checkbox"));
        if (color.size() >= 15) {
            WebElement thirdArrowIcon = color.get(14);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_emj240105094151989465_so_waw240404165038355262']")).click();

        Thread.sleep(2000);

        WebElement subscriptionPlan = driver.findElement(By.id("relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468"));
        subscriptionPlan.click();

        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String radioButtonXpath = "//label[.//span[contains(text(), '1559.98')]]//input[@type='radio']";

        try {
            WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(radioButtonXpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

            System.out.println("Clicked the radio button for price 1559.98.");
        } catch (Exception e) {
            System.err.println("Failed to click on the radio button: " + e.getMessage());
            e.printStackTrace();
        }

        Thread.sleep(2000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clientWithoutVivacom = wait2.until(ExpectedConditions.elementToBeClickable(By.id("xSellBtn")));
        clientWithoutVivacom.click();

        Thread.sleep(2000);


        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement buyButton = wait3.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buyButton);
        jsExecutor.executeScript("arguments[0].click();", buyButton);

        // verifikaciq che sme w koshnicata

        Thread.sleep(2000);

        WebElement continueShoppingButton = wait2.until(ExpectedConditions.elementToBeClickable(By.name("vivacom-cart-link-button-continue-shopping")));
        continueShoppingButton.click();

        Thread.sleep(2000);

        WebElement dropdownToggle2 = driver.findElement(className("dropdown-toggle"));
        dropdownToggle2.click();
        List<WebElement> options2 = driver.findElements(className("dropdown"));
        for (WebElement option : options2) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")).click();

        Thread.sleep(2000);


        List<WebElement> optionIphone = driver.findElements(className("custom-checkbox"));
        if (optionIphone.size() >= 2) {
            WebElement thirdArrowIcon = optionIphone.get(1);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        Thread.sleep(2000);

        List<WebElement> upperPriceAccesories = driver.findElements(className("custom-checkbox"));
        if (upperPriceAccesories.size() >= 14) {
            WebElement thirdArrowIcon = upperPriceAccesories.get(13);
            thirdArrowIcon.click();
        } else {
            System.out.println("");
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/online/shop/devices/product-category-accessories/apple-iphone-15-pro-finewoven-case-taupe?offer=epc_simfreedevice00000001_so_jee230921123929324872']")).click();

        Thread.sleep(2000);


        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        WebElement buyButton2 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor2.executeScript("arguments[0].scrollIntoView(true);", buyButton2);
        jsExecutor2.executeScript("arguments[0].click();", buyButton2);

        Thread.sleep(2000);
        //verifikaciq che sme v koshnicata

        try {


            WebElement totalPriceElement = driver.findElement(By.cssSelector(".summarize-order .final-price .e-care-home-big-bill-price-digits"));
            String totalPriceText = totalPriceElement.getText().trim();
            totalPriceText = totalPriceText.replaceAll("[^\\d,]+", "").replace(",", ".");
            BigDecimal totalPrice = new BigDecimal(totalPriceText);
            BigDecimal limit = new BigDecimal("1680");
            if (totalPrice.compareTo(limit) > 0) {
                WebElement removeButton = driver.findElement(By.cssSelector("button[type='submit'][class*='btn-close']"));
                removeButton.click();
                System.out.println("Item removed");
            } else {
                System.out.println("No need to remove the item");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        Thread.sleep(2000);
        //верификация, че бутоните за поръчай като настоящ и нов клиент са неактивни

        WebDriverWait waitButtonForVerification = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = waitButtonForVerification.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-checkout-btn")));
        boolean isDisabled = checkoutButton.getAttribute("class").contains("disable-elm") || checkoutButton.getAttribute("disabled") != null;
        System.out.println("The checkout button is disabled: " + isDisabled);
//


        Thread.sleep(2000);
        //обши условия


        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Using WebDriverWait to wait for the checkbox to be present and clickable
            WebDriverWait wait22 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement termsCheckboxIcon = wait22.until(ExpectedConditions.elementToBeClickable(By.cssSelector("em.vivacom-icon.icon-box_empty")));
            js.executeScript("arguments[0].scrollIntoView(true);", termsCheckboxIcon);
            termsCheckboxIcon.click();
            System.out.println("Terms and conditions checkbox has been clicked.");
        }catch (Exception e){
            e.printStackTrace();
        }
        // Proceed with additional actions here


        Thread.sleep(2000);

        //Премахване на телефона от кошницата

        WebElement removeButton = driver.findElement(By.cssSelector("button[type='submit'][class*='btn-close']"));
        removeButton.click();
        System.out.println("Item removed");
        Thread.sleep(2000);

        // Верификация на съобщение
        try {
            // Wait for the element that contains the message to be present
            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(100));
            WebElement messageElement = wait4.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(., 'В момента кошницата ви е празна')]"))
            );

            // Retrieve the full text content from the element
            String messageText = messageElement.getText();
            String expectedMessage = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";

            if (messageText.contains(expectedMessage)) {
                System.out.println("The message is verified and correct.");
            } else {
                System.out.println("The message does not match the expected text.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        //Изключване на google chrome след успешно преминал тест
//        driver.quit();

    }

}
