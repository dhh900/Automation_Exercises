import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;


public class AutomationExercises {
    ChromeDriver driver = new ChromeDriver();

    @BeforeMethod
    public void main() {
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    @Test
    public void registerUser1() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText().contains("New User Signup!"));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ENTER ACCOUNT INFORMATION"));

        driver.findElement(By.id("id_gender2")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("Value"), "Dina");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("Value"), "tijak12151@ofionk.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement daysList = driver.findElement(By.id("days"));
        daysList.click();
        Select selectDay = new Select(daysList);
        selectDay.selectByIndex(18);

        WebElement monthsList = driver.findElement(By.id("months"));
        monthsList.click();
        Select selectMonth = new Select(monthsList);
        selectMonth.selectByVisibleText("December");

        WebElement yearsList = driver.findElement(By.id("years"));
        yearsList.click();
        Select selectYear = new Select(yearsList);
        selectYear.selectByValue("1991");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Dina");
        driver.findElement(By.id("last_name")).sendKeys("Hussien");
        driver.findElement(By.id("company")).sendKeys("abc");
        driver.findElement(By.id("address1")).sendKeys("abcdef");
        driver.findElement(By.id("country")).click();
        WebElement countryList = driver.findElement(By.id("country"));
        countryList.click();
        Select selectCountry = new Select(countryList);
        selectCountry.selectByIndex(1);
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Account Created!']")).getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));
        driver.findElement(By.className("fa-trash-o")).click();
        WebElement deleteAccount = driver.findElement(By.cssSelector("h2.title.text-center"));
        Assert.assertEquals(deleteAccount.getText(), "ACCOUNT DELETED!");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.className("btn-primary")).click();
    }

    @Test
    public void LoginCorrectEmailAndPassword2() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText().contains("Login to your account"));
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));
        driver.findElement(By.className("fa-trash-o")).click();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void LogininCorrectEmailAndPassword3() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText().contains("Login to your account"));
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("4964486444");
        driver.findElement(By.cssSelector("button[data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("p[style=\"color: red;\"]")).getText().contains("Your email or password is incorrect!"));
        System.out.println("Warning Message!");
    }

    @Test
    public void Logout() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText().contains("Login to your account"));
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void registerWithExistingEmail5() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText().contains("New User Signup!"));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("p[style=\"color: red;\"]")).getText().contains("Email Address already exist!"));
    }

    @Test
    public void contactUs() {
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[href=\"/contact_us\"]")).click();
        WebElement getInTouch = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        Assert.assertEquals(getInTouch.getText(), "GET IN TOUCH");

        driver.findElement(By.name("name")).sendKeys("Dina");
        driver.findElement(By.name("email")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.name("subject")).sendKeys("Help me!");
        driver.findElement(By.name("message")).sendKeys("Could you stop Subscription and Marketing Emails!");

        String imageName = "person.png";
        String imagePath = "G:\\SenSe\\Imp\\TESTING\\DEPI\\TestingEngMohamedElShafey\\Automation1\\src\\test\\Uploads\\" + imageName;

        File file = new File(imagePath);
        Assert.assertTrue(file.exists(), "File does not exist at the specified path.");

        WebElement uploadFile = driver.findElement(By.name("upload_file"));
        uploadFile.sendKeys(imagePath);

        driver.findElement(By.name("submit")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("div[class=\"status alert alert-success\"]"));
        Assert.assertEquals("Success! Your details have been submitted successfully.", message.getText());
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
    }

    @Test
    public void verifyTestCasesPage7() {
        Assert.assertEquals(driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).getText(), "Test Cases");
        WebElement TestCasesBtn = driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]"));
        TestCasesBtn.click();
        Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"#collapse1\"]")).getText(), "Test Case 1: Register User");
    }

    @Test
    public void verifyProductsandproductdetailpage8() {
        Assert.assertEquals(driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).getText(), "Test Cases");
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");

        WebElement searchBar = driver.findElement(By.id("sale_image"));
        Assert.assertTrue(searchBar.isDisplayed());

        WebElement viewProductBtn = driver.findElement(By.cssSelector("a[href=\"/product_details/1\"]"));
        viewProductBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']")).getText().contains("Blue Top"));
    }

    @Test
    public void searchProduct9() {
        Assert.assertEquals(driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).getText(), "Test Cases");
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
        WebElement searchBar = driver.findElement(By.id("search_product"));
        searchBar.sendKeys("dress");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"product-overlay\"]")).isDisplayed());
    }

    @Test
    public void verifySubscriptionInHome10() {
        System.out.println(driver.getCurrentUrl());

        WebElement element1 = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Point point = element1.getLocation();
        System.out.println(point);

        JavascriptExecutor js = driver;
        js.executeScript("scrollBy(287, 8675)");

        WebElement subscription1 = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertEquals(subscription1.getText(), "SUBSCRIPTION");
    }

    @Test
    public void verifySubscriptionInCart11() {
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("i[class=\"fa fa-shopping-cart\"]")).click();

        WebElement element2 = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Point point = element2.getLocation();
        System.out.println(point);
        JavascriptExecutor js = driver;
        js.executeScript("scrollBy(287, 8675)");

        WebElement subscription2 = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertEquals(subscription2.getText(), "SUBSCRIPTION");

        driver.findElement(By.id("susbscribe_email")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.id("subscribe")).click();

        WebElement subscriptionMsg = driver.findElement(By.id("success-subscribe"));
        Assert.assertEquals(subscriptionMsg.getText(), "You have been successfully subscribed!");
    }

    @Test
    public void addProductsinCart12() {
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click();

        driver.findElement(By.cssSelector("a[data-product-id=\"2\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();

        System.out.println(driver.findElement(By.cssSelector("a[href=\"/product_details/1\"]")).getText());
        System.out.println(driver.findElement(By.cssSelector("a[href=\"/product_details/2\"]")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 500')]")).getText(), "Rs. 500");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 500']")).getText(), "Rs. 500");

        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 400')]")).getText(), "Rs. 400");
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='1']")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 400']")).getText(), "Rs. 400");
    }

    @Test
    public void verifyProductQuantityInCart13() {
        driver.findElement(By.cssSelector("a[href=\"/product_details/8\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/8");
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4");
        driver.findElement(By.cssSelector("button[class=\"btn btn-default cart\"]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.cssSelector("button[class=\"disabled\"]")).getText(), "4");
    }

    @Test
    public void placeOrder_RegisterWhileCheckout14() {
        driver.findElement(By.cssSelector("a[data-product-id=\"41\"]")).click();
        driver.findElement(By.cssSelector("i[class=\"fa fa-shopping-cart\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();

        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        //Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ACCOUNT CREATED!"));
        //driver.findElement(By.cssSelector("button[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ENTER ACCOUNT INFORMATION"));

        driver.findElement(By.id("id_gender2")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("Value"), "Dina");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("Value"), "tijak12151@ofionk.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement daysList = driver.findElement(By.id("days"));
        daysList.click();
        Select selectDay = new Select(daysList);
        selectDay.selectByIndex(18);

        WebElement monthsList = driver.findElement(By.id("months"));
        monthsList.click();
        Select selectMonth = new Select(monthsList);
        selectMonth.selectByVisibleText("December");

        WebElement yearsList = driver.findElement(By.id("years"));
        yearsList.click();
        Select selectYear = new Select(yearsList);
        selectYear.selectByValue("1991");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Dina");
        driver.findElement(By.id("last_name")).sendKeys("Hussien");
        driver.findElement(By.id("company")).sendKeys("abc");
        driver.findElement(By.id("address1")).sendKeys("abcdef");
        driver.findElement(By.id("country")).click();
        WebElement countryList = driver.findElement(By.id("country"));
        countryList.click();
        Select selectCountry = new Select(countryList);
        selectCountry.selectByIndex(1);
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Account Created!']")).getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));

        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();

        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class=\"address_address1 address_address2\"]")).getText(), "abc");
        System.out.println(driver.findElement(By.cssSelector("div[class=\"col-xs-12 col-sm-6\"]")).getText());

        driver.findElement(By.cssSelector("textarea[class=\"form-control\"]")).sendKeys("VERY BIG COMMENT");
        driver.findElement(By.cssSelector("a[href=\"/payment\"]")).click();

        driver.findElement(By.name("name_on_card")).sendKeys("Dina");
        driver.findElement(By.name("card_number")).sendKeys("123456");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("1212");
        driver.findElement(By.id("submit")).click();

        WebElement successMsg = driver.findElement(By.cssSelector("p[style=\"font-size: 20px; font-family: garamond;\"]"));
        Assert.assertEquals(successMsg.getText(), "Congratulations! Your order has been confirmed!");
        driver.findElement(By.className("fa-trash-o")).click();
        WebElement deleteAccount = driver.findElement(By.cssSelector("h2.title.text-center"));
        Assert.assertEquals(deleteAccount.getText(), "ACCOUNT DELETED!");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.className("btn-primary")).click();
    }


    @Test
    public void placeOrder_RegisterBeforeCheckout15() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText().contains("New User Signup!"));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ENTER ACCOUNT INFORMATION"));

        driver.findElement(By.id("id_gender2")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("Value"), "Dina");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("Value"), "tijak12151@ofionk.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement daysList = driver.findElement(By.id("days"));
        daysList.click();
        Select selectDay = new Select(daysList);
        selectDay.selectByIndex(18);

        WebElement monthsList = driver.findElement(By.id("months"));
        monthsList.click();
        Select selectMonth = new Select(monthsList);
        selectMonth.selectByVisibleText("December");

        WebElement yearsList = driver.findElement(By.id("years"));
        yearsList.click();
        Select selectYear = new Select(yearsList);
        selectYear.selectByValue("1991");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Dina");
        driver.findElement(By.id("last_name")).sendKeys("Hussien");
        driver.findElement(By.id("company")).sendKeys("abc");
        driver.findElement(By.id("address1")).sendKeys("abcdef");
        driver.findElement(By.id("country")).click();
        WebElement countryList = driver.findElement(By.id("country"));
        countryList.click();
        Select selectCountry = new Select(countryList);
        selectCountry.selectByIndex(1);
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Account Created!']")).getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));
        driver.findElement(By.cssSelector("a[data-product-id=\"11\"]")).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"12\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/view_cart\"]"))).click();

        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        WebElement address = driver.findElement(By.cssSelector("ul[id=\"address_delivery\"]"));
        Assert.assertTrue(address.getText().contains("abcdef"));
        System.out.println(driver.findElement(By.cssSelector("div[class=\"col-xs-12 col-sm-6\"]")).getText());

        driver.findElement(By.cssSelector("textarea[class=\"form-control\"]")).sendKeys("VERY BIG COMMENT");
        driver.findElement(By.cssSelector("a[href=\"/payment\"]")).click();

        driver.findElement(By.name("name_on_card")).sendKeys("Dina");
        driver.findElement(By.name("card_number")).sendKeys("123456");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("1212");
        driver.findElement(By.id("submit")).click();

        WebElement successMsg = driver.findElement(By.cssSelector("p[style=\"font-size: 20px; font-family: garamond;\"]"));
        Assert.assertEquals(successMsg.getText(), "Congratulations! Your order has been confirmed!");
        driver.findElement(By.className("fa-trash-o")).click();
        WebElement deleteAccount = driver.findElement(By.cssSelector("h2.title.text-center"));
        Assert.assertEquals(deleteAccount.getText(), "ACCOUNT DELETED!");
        driver.findElement(By.className("btn-primary")).click();
    }


    @Test
    public void placeOrder_LoginBeforeCheckout16() {
        System.out.println(driver.getCurrentUrl());
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));

        driver.findElement(By.cssSelector("a[data-product-id=\"11\"]")).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"12\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/view_cart\"]"))).click();

        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        WebElement address = driver.findElement(By.cssSelector("ul[id=\"address_delivery\"]"));
        Assert.assertTrue(address.getText().contains("abcdef"));
        System.out.println(driver.findElement(By.cssSelector("div[class=\"col-xs-12 col-sm-6\"]")).getText());

        driver.findElement(By.cssSelector("textarea[class=\"form-control\"]")).sendKeys("VERY BIG COMMENT");
        driver.findElement(By.cssSelector("a[href=\"/payment\"]")).click();

        driver.findElement(By.name("name_on_card")).sendKeys("Dina");
        driver.findElement(By.name("card_number")).sendKeys("123456");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("1212");
        driver.findElement(By.id("submit")).click();

        WebElement successMsg = driver.findElement(By.cssSelector("p[style=\"font-size: 20px; font-family: garamond;\"]"));
        Assert.assertEquals(successMsg.getText(), "Congratulations! Your order has been confirmed!");
        driver.findElement(By.className("fa-trash-o")).click();
        WebElement deleteAccount = driver.findElement(By.cssSelector("h2.title.text-center"));
        Assert.assertEquals(deleteAccount.getText(), "ACCOUNT DELETED!");
        driver.findElement(By.className("btn-primary")).click();

    }

    @Test
    public void removeProductsFromCart17() {
        driver.findElement(By.cssSelector("a[data-product-id=\"5\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-success close-modal btn-block']"))).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"2\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/view_cart\"]"))).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        WebElement tableBefore = driver.findElement(By.id("cart_info"));
        System.out.println("Table Before " + tableBefore.getText());
        driver.findElement(By.xpath("//*[@data-product-id=\"2\"]")).click();
        driver.navigate().refresh();
        WebElement tableAfter = driver.findElement(By.id("cart_info_table"));
        System.out.println("Table After " + tableAfter.getText());
    }

    @Test
    public void viewCategoryProducts18() {
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Category']")).getText(), "CATEGORY");
        driver.findElement(By.cssSelector("a[href=\"#Women\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/category_products/1\"]")).click();
        System.out.println("WOMEN--DRESSES \n" + driver.findElement(By.cssSelector("div[class=\"features_items\"]")).getText());

        driver.findElement(By.cssSelector("a[href=\"#Men\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/category_products/3\"]")).click();
        System.out.println("MEN--TSHIRTS \n" + driver.findElement(By.cssSelector("div[class=\"features_items\"]")).getText());
    }

    @Test
    public void viewAndCartBrandProducts19() {
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Brands']")).getText(), "BRANDS");
        driver.findElement(By.cssSelector("a[href=\"/brand_products/Polo\"]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Polo"));
        driver.findElement(By.cssSelector("a[href=\"/brand_products/Biba\"]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Biba"));
    }

    @Test
    public void searchProductsAndVerifyCartAfterLogin20() {
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
        driver.findElement(By.id("search_product")).sendKeys("top");
        driver.findElement(By.cssSelector("i[class=\"fa fa-search\"]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("search=top"));
        System.out.println(driver.findElement(By.cssSelector("div[class=\"features_items\"]")).getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"5\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']"))).click();
        driver.findElement(By.cssSelector("a[data-product-id=\"6\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/view_cart\"]"))).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));

        driver.findElement(By.className("fa-shopping-cart")).click();
        System.out.println(driver.findElement(By.className("cart_info")).getText());
    }

    @Test
    public void addReviewOnProduct21() {
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");

        driver.findElement(By.cssSelector("a[href=\"/product_details/4\"]")).click();

        Assert.assertTrue(driver.findElement(By.className("nav-tabs")).isDisplayed());

        driver.findElement(By.id("name")).sendKeys("Dina");
        driver.findElement(By.id("email")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.id("review")).sendKeys("HEY NEW REVIEW!!");
        driver.findElement(By.id("button-review")).click();
        WebElement message = driver.findElement(By.cssSelector("span[style=\"font-size: 20px;\"]"));
        Assert.assertEquals(message.getText(), "Thank you for your review.");
    }

    @Test
    public void addToCartFromRecommendedItems22() {
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='recommended items']"));
        Point point = element.getLocation();
        System.out.println(point);
        JavascriptExecutor js = driver;
        js.executeScript("scrollBy(497, 7583)");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='recommended items']")).isDisplayed());
        driver.findElement(By.cssSelector("a[data-product-id=\"4\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/view_cart\"]"))).click();
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(By.id("cart_info")).getText().contains("Stylish Dress"));
        System.out.println("Table" + driver.findElement(By.id("cart_info")).getText());
    }

    @Test
    public void verifyAddressDetailsInCheckoutPpage23() {
        WebElement signup = driver.findElement(By.className("fa-lock"));
        signup.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText().contains("New User Signup!"));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ENTER ACCOUNT INFORMATION"));

        driver.findElement(By.id("id_gender2")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("Value"), "Dina");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("Value"), "tijak12151@ofionk.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement daysList = driver.findElement(By.id("days"));
        daysList.click();
        Select selectDay = new Select(daysList);
        selectDay.selectByIndex(18);

        WebElement monthsList = driver.findElement(By.id("months"));
        monthsList.click();
        Select selectMonth = new Select(monthsList);
        selectMonth.selectByVisibleText("December");

        WebElement yearsList = driver.findElement(By.id("years"));
        yearsList.click();
        Select selectYear = new Select(yearsList);
        selectYear.selectByValue("1991");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Dina");
        driver.findElement(By.id("last_name")).sendKeys("Hussien");
        driver.findElement(By.id("company")).sendKeys("abc");
        driver.findElement(By.id("address1")).sendKeys("abcdef");
        driver.findElement(By.id("country")).click();
        WebElement countryList = driver.findElement(By.id("country"));
        countryList.click();
        Select selectCountry = new Select(countryList);
        selectCountry.selectByIndex(1);
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Account Created!']")).getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));

        driver.findElement(By.cssSelector("a[data-product-id=\"11\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("ul[id=\"address_delivery\"]")).getText().contains("abcdef"));
        driver.findElement(By.className("fa-trash-o")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h2.title.text-center")).getText(), "ACCOUNT DELETED!");
        driver.findElement(By.className("btn-primary")).click();
    }

    @Test
    public void downloadInvoiceAfterPurchaseOrder24() {
        driver.findElement(By.cssSelector("a[data-product-id=\"11\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();
        driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();

        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys("Dina");
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("tijak12151@ofionk.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        //Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ACCOUNT CREATED!"));
        //driver.findElement(By.cssSelector("button[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("h2.title.text-center")).getText().contains("ENTER ACCOUNT INFORMATION"));

        driver.findElement(By.id("id_gender2")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("Value"), "Dina");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("Value"), "tijak12151@ofionk.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement daysList = driver.findElement(By.id("days"));
        daysList.click();
        Select selectDay = new Select(daysList);
        selectDay.selectByIndex(18);

        WebElement monthsList = driver.findElement(By.id("months"));
        monthsList.click();
        Select selectMonth = new Select(monthsList);
        selectMonth.selectByVisibleText("December");

        WebElement yearsList = driver.findElement(By.id("years"));
        yearsList.click();
        Select selectYear = new Select(yearsList);
        selectYear.selectByValue("1991");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Dina");
        driver.findElement(By.id("last_name")).sendKeys("Hussien");
        driver.findElement(By.id("company")).sendKeys("abc");
        driver.findElement(By.id("address1")).sendKeys("abcdef");
        driver.findElement(By.id("country")).click();
        WebElement countryList = driver.findElement(By.id("country"));
        countryList.click();
        Select selectCountry = new Select(countryList);
        selectCountry.selectByIndex(1);
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Account Created!']")).getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']/parent::a")).getText().contains("Logged in as Dina"));

        driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();

        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class=\"address_address1 address_address2\"]")).getText(), "abc");
        System.out.println(driver.findElement(By.cssSelector("div[class=\"col-xs-12 col-sm-6\"]")).getText());

        driver.findElement(By.cssSelector("textarea[class=\"form-control\"]")).sendKeys("VERY BIG COMMENT");
        driver.findElement(By.cssSelector("a[href=\"/payment\"]")).click();

        driver.findElement(By.name("name_on_card")).sendKeys("Dina");
        driver.findElement(By.name("card_number")).sendKeys("123456");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("1212");
        driver.findElement(By.id("submit")).click();

        WebElement successMsg = driver.findElement(By.cssSelector("p[style=\"font-size: 20px; font-family: garamond;\"]"));
        Assert.assertEquals(successMsg.getText(), "Congratulations! Your order has been confirmed!");

        //driver.findElement(By.className("invoice")).click();
        System.out.println("invoiceeeeeeeee");

        driver.findElement(By.className("fa-trash-o")).click();
        WebElement deleteAccount = driver.findElement(By.cssSelector("h2.title.text-center"));
        Assert.assertEquals(deleteAccount.getText(), "ACCOUNT DELETED!");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.className("btn-primary")).click();
    }

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality25() {
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Point point = element.getLocation();
        System.out.println(point);

        JavascriptExecutor js = driver;
        js.executeScript("scrollBy(287, 8675)");

        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText(), "SUBSCRIPTION");
        driver.findElement(By.id("scrollUp")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("img[src=\"/static/images/home/logo.png\"]")).isDisplayed());

    }

    @Test
    public void verifyScrollUpWOArrowButtonAndScrollDownFunctionality26() {
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Point point = element.getLocation();
        System.out.println(point);

        JavascriptExecutor js = driver;
        js.executeScript("scrollBy(287, 8675)");

        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText(), "SUBSCRIPTION");
        js.executeScript("scrollBy(0, 0)");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")).getText().contains("Full-Fledged practice website for Automation Engineers"));

    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}

