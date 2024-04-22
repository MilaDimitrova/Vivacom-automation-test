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
        System.out.println("Window is maximized");

        driver.get("http://vivacom.bg/bg"); // url-a, в случая сайта на Vivacom
        System.out.println("URL is opened");

        WebElement cookieButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookieButton.click(); // "Приемаме" бисквитките
        System.out.println("Cookie Button is active");

        Thread.sleep(2000); // Изчакваме 2 секунди до следващата стъпка

        WebElement dropdownToggle = driver.findElement(className("dropdown-toggle"));
        dropdownToggle.click();
        List<WebElement> options = driver.findElements(className("dropdown"));
        for (WebElement option : options) {
            if (option.getText().equals("Устройства")) {
                option.click();
                System.out.println("Clicked on Device button ");
                break;
            }
        }   // от менюто селектираме "Устройства"

        Thread.sleep(2000); // Изчакваме 2 секунди до следващата стъпка


        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones']")).click();
        System.out.println("Clicked on mobile phones");
        // Избираме от падащото меню - "Мобилни телефони"

        Thread.sleep(2000); //Изчакваме 2 секунди до следващата стъпка


        WebElement appleOptionMenu = driver.findElement(className("custom-checkbox"));
        appleOptionMenu.click(); // Избираме първа опция от менюто в страни, която е телефонът "Apple"
        System.out.println("Clicked on Apple option");

        Thread.sleep(2000); //Изчакваме 2 секунди до следващата стъпка

        List<WebElement> color = driver.findElements(className("custom-checkbox")); // Избираме цвета "BLUE"
        if (color.size() >= 15) {
            WebElement thirdArrowIcon = color.get(14);
            thirdArrowIcon.click();
            System.out.println("Clicked on BLUE color option");
        } else {
            System.out.println("Not clicked");
        }

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebElement iphoneAppleImage = driver.findElement(By.cssSelector("img[alt='APPLE IPHONE 15 PLUS 128GB+ADAPTER']"));
        iphoneAppleImage.click();
        System.out.println("Clicked on Apple Iphone 15 plus 128BG + adapter");
        //Избираме Apple Iphone 15 plus 128GB + adapter

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebElement subscriptionPlan = driver.findElement(By.id("relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468"));
        subscriptionPlan.click(); //Избираме плана - Unlimited 300
        System.out.println("Clicked on Unlimited 300 plan");


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка



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
        } //Избираме еднократно плащане с цена от 1559.98 лв.


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebDriverWait waitSecond = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clientWithoutVivacom = waitSecond.until(ExpectedConditions.elementToBeClickable(By.id("xSellBtn")));
        clientWithoutVivacom.click(); // Избираме 49.99млв./мес. за клиенти на Vivacom.....
        System.out.println("Clicked on 49.99 price button");

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка


        WebDriverWait waitThird = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement buyButton = waitThird.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buyButton);
        jsExecutor.executeScript("arguments[0].click();", buyButton); // Натискаме бутона - "Купи"
        System.out.println("Clicked on buy button");




        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка
        System.out.println("We are in the cart");


        WebElement continueShoppingButton = waitThird.until(ExpectedConditions.elementToBeClickable(By.name("vivacom-cart-link-button-continue-shopping")));
        continueShoppingButton.click(); //Натискаме бутона за - Продължване на пазаруване
        System.out.println("Clicked on continue shopping");

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebElement dropdownToggleSecond = driver.findElement(className("dropdown-toggle"));
        dropdownToggleSecond.click();
        List<WebElement> options2 = driver.findElements(className("dropdown"));
        for (WebElement option : options2) {
            if (option.getText().equals("Устройства")) {
                option.click();
                break;
            }
        } // Отново отиваме в падащото менюто и избираме - "Устройства"
        System.out.println("Clicked on device menu");

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка
        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")).click();
        System.out.println("Clicked on accessories");
        // Избираме - "Аксесоари"


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка


        List<WebElement> optionIphone = driver.findElements(className("custom-checkbox"));
        if (optionIphone.size() >= 2) {
            WebElement thirdArrowIcon = optionIphone.get(1);
            thirdArrowIcon.click();
            System.out.println("Clicked on Apple");
        } else {
            System.out.println("Error");
        } // Избираме - "Apple"


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        List<WebElement> accesoriesPrice = driver.findElements(className("custom-checkbox"));
        if (accesoriesPrice.size() >= 14) {
            WebElement thirdArrowIcon = accesoriesPrice.get(13);
            thirdArrowIcon.click();
            System.out.println("Clicked on option - over 40 lv.");
        } else {
            System.out.println("It's not clicked");
        } // Избираме опцията - "над 40 лв."

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка


        WebElement phoneImage = driver.findElement(By.cssSelector("img[alt='APPLE iPhone 15 Plus FineWoven Taupe']"));
        phoneImage.click();
        System.out.println("Clicked on Apple Iphone 15 Plus FineWoven Taupe Case");
        //Избираме кафевия калъф за Apple Iphone 15 plus.....

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка


        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        WebElement buyButton2 = waitSecond.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-add-to-cart-btn")));
        jsExecutor2.executeScript("arguments[0].scrollIntoView(true);", buyButton2);
        jsExecutor2.executeScript("arguments[0].click();", buyButton2); // Натискаме бутона - "Купи"
        System.out.println("Clicked on buy button");


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка
        System.out.println("We are in the cart");

        try {
            WebElement totalPriceElement = driver.findElement(By.cssSelector(".summarize-order .final-price .e-care-home-big-bill-price-digits"));
            String totalPriceText = totalPriceElement.getText().trim();
            totalPriceText = totalPriceText.replaceAll("[^\\d,]+", "").replace(",", ".");
            BigDecimal totalPrice = new BigDecimal(totalPriceText);
            BigDecimal limit = new BigDecimal("1680");
            if (totalPrice.compareTo(limit) > 0) {
                WebElement removeButton = driver.findElement(By.cssSelector("button[type='submit'][class*='btn-close']"));
                removeButton.click();
                System.out.println("Apple Iphone accessories is removed");
            } else {
                System.out.println("No need to remove the item");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } // Правим проверка, ако общата цена надвишава 1680лв. се премахва аксесоарът


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebDriverWait waitButtonForVerification = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = waitButtonForVerification.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.js-checkout-btn")));
        boolean isDisabled = checkoutButton.getAttribute("class").contains("disable-elm") || checkoutButton.getAttribute("disabled") != null;
        System.out.println("The checkout buttons is disabled: " + isDisabled); //верификация, че бутоните за поръчай като настоящ и нов клиент са неактивни


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка


        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            WebDriverWait waitNext = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement termsCheckboxIcon = waitNext.until(ExpectedConditions.elementToBeClickable(By.cssSelector("em.vivacom-icon.icon-box_empty")));
            js.executeScript("arguments[0].scrollIntoView(true);", termsCheckboxIcon);
            System.out.println("Checkbox for terms and conditions is available");
            termsCheckboxIcon.click();
            System.out.println("Terms and conditions checkbox has been clicked.");
        }catch (Exception e){
            e.printStackTrace();
        }// Бутона за верификация - Terms and conditions....


        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        WebElement removeButton = driver.findElement(By.cssSelector("button[type='submit'][class*='btn-close']"));
        removeButton.click();
        System.out.println("Apple Iphone is removed");//Премахване на телефона от кошницата

        Thread.sleep(2000);//Изчакваме 2 секунди до следващата стъпка

        try {
            WebDriverWait waitNext = new WebDriverWait(driver, Duration.ofSeconds(100));
            WebElement messageElement = waitNext.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(., 'В момента кошницата ви е празна')]"))
            );
            String messageText = messageElement.getText();
            String expectedMessage = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";
            if (messageText.contains(expectedMessage)) {
                System.out.println("The message is verified and correct.");
            } else {
                System.out.println("The message does not match the expected text.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  // Верификация на съобщение


       driver.quit(); //Изключване на google chrome след успешно преминал тест
        System.out.println("Window is closed");
    }

}
