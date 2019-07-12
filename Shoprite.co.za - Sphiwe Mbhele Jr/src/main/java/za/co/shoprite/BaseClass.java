package za.co.shoprite;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected static WebDriver driver;
    protected String APP_URL = "http://www.way2automation.com/angularjs-protractor/webtables/";
    protected Iterator usersToAdd ;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        try {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--start-maximized");
            System.out.println("Operating System:" + System.getProperty("os.name"));
            System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver.exe");
            System.out.println("******************************************");
            System.out.println("Launching Chrome browser");
            try {
                driver = new ChromeDriver(options);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            //Setting up Users from the Excel File

            String workingDir = System.getProperty("user.dir");

            Xcelite xcelite = new Xcelite(new File(workingDir+"\\src\\main\\resources\\Users.xlsx"));
            XceliteSheet sheet = xcelite.getSheet(0);

            SheetReader<User> reader = sheet.getBeanReader(User.class);
            reader.skipHeaderRow(true);
            Collection<User> users  = reader.read();
            usersToAdd = users.iterator();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public WebElement addUserButton(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button"));
    }

    public WebElement firstName(WebDriver driver) {
        return driver.findElement(By.name("FirstName"));
    }

    public WebElement lastName(WebDriver driver) {
        return driver.findElement(By.name("LastName"));
    }

    public WebElement userName(WebDriver driver) {
        return driver.findElement(By.name("UserName"));
    }


    public WebElement password(WebDriver driver) {
        return driver.findElement(By.name("Password"));
    }


    public WebElement roleId(WebDriver driver) {
        return driver.findElement(By.name("RoleId"));
    }

    public WebElement email(WebDriver driver) {
        return driver.findElement(By.name("Email"));
    }

    public WebElement mobilePhone(WebDriver driver) {
        return driver.findElement(By.name("Mobilephone"));
    }
    public WebElement saveButton(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]"));
    }

    public WebElement customerSelectionCompanyAAA(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]/input"));
    }

    public WebElement customerSelectionCompanyBBB(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[2]/input"));
    }

    public String getUniqueNumber()
    {
        Random random=new Random();
        int randomNumber=(random.nextInt(65536)-32768);

        return String.valueOf(randomNumber);
    }



    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
