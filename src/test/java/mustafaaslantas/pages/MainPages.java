package mustafaaslantas.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MainPages {
    String selectedBookTitle;
    AppiumDriver driver;
    WebDriverWait wait;

    public MainPages(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginButton = MobileBy.AccessibilityId("Hesabım"); ;
    By emailField = MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/inputEditText\").instance(0)");
    By passwordField = MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/inputEditText\").instance(1)");
    By submitButton = MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/btnLogin\")");
    By successfulLoginSign = MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/ln_active_login\")");
    By homePageLink = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Ana Sayfa\"]");
    By searchLink = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Ara\"]");
    By kitapLink = MobileBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.mobisoft.kitapyurdu:id/mainLayout\"])[1]");
    By edebiyatLink = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewName\" and @text=\"Edebiyat\"]");
    By showAllLink = MobileBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Tüm Ürünleri Göster\"]");
    By AddToCartButton = MobileBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.mobisoft.kitapyurdu:id/addToCartNormalView\"]");
    By cartButton = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Sepetim\"]");
    By productName = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewProductName\"]");
    By removeButton = MobileBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.mobisoft.kitapyurdu:id/buttonDelete\"]");
    By removeButton2 = MobileBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Sil\"]");
    By emptyText = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewErrorMessage\"]");
    By searchField = MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/searchEditText\")");
    By searchResultTile = MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\")");


    public void HomePage() {
        driver.findElement(homePageLink).click();

    }
    public void Login() {
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys("email ");
        driver.findElement(passwordField).sendKeys("****");
        driver.findElement(submitButton).click();

        if (driver.findElement(successfulLoginSign).isDisplayed())
        {System.out.println("Giriş başarılı");
        }
        else {
            System.out.println("Giriş başarısız");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Search() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLink));
        driver.findElement(searchLink).click();
        driver.findElement(searchLink).click();
        driver.findElement(searchLink).click();


    }

    public void Kitap() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(kitapLink));
        driver.findElement(kitapLink).click();
    }

    public void Edebiyat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(edebiyatLink));
        driver.findElement(edebiyatLink).click();
    }

    public void ShowAll() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllLink));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(showAllLink).click();
    }


    public void RandomBook() {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.RelativeLayout")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        WebElement selectedBook = elements.get(randomIndex);
        selectedBook.click();

        this.selectedBookTitle = (driver.findElement(MobileBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/textViewProductName\")"))).getText();
        driver.findElement(AddToCartButton).click();

    }

    public void CheckBooks() {
        driver.findElement(cartButton).click();
        String bookName = driver.findElement(productName).getText();
        if (selectedBookTitle.contains(bookName)){
            System.out.println("Sepetteki ürünle seçilen ürün aynı.");
        }
        else {
            System.out.println("Sepetteki ürünle seçilen ürün aynı değil.");
        }

    }

    public void Remove() {
        driver.findElement(removeButton).click();
        driver.findElement(removeButton2).click();
    }

    public void IsEmpty() {
        if (driver.findElement(emptyText).isDisplayed()){
            System.out.println("Sepet boş");
        }
        else {
            System.out.println("Sepet dolu");
        }

    }
    public void SearchFor() {
        driver.findElement(searchField).sendKeys("Orhan Pamuk");

    }

    public void Verify() {
        String searchTerm = "Orhan Pamuk";
        List<WebElement> productNames = driver.findElements(searchResultTile);

        boolean allProductsRelated = true;
        for (WebElement productName : productNames) {
            String nameText = productName.getText();
            System.out.println("Ürün İsmi: " + nameText);
            if (!nameText.toLowerCase().contains(searchTerm.toLowerCase())) {
                allProductsRelated = false;
                break;
            }
        }
        if (allProductsRelated) {
            System.out.println("Tüm ürünler arama terimi ile ilgili.");
        } else {
            System.out.println("Bazı ürünler arama terimi ile ilgili değil.");
        }
        driver.quit();
    }
}
