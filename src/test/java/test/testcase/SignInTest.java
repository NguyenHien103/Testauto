package test.testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.common.ValidateHelpers;
import test.pages.DashboardPage;
import test.pages.SignPage;

public class SignInTest {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignPage signInPage;
    private DashboardPage dashboardPage;
    @BeforeMethod
    public void setUp() {
        // Cài đặt ChromeDriver

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Điều hướng tới trang đăng nhập
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Khởi tạo các đối tượng trang và trợ giúp
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignPage(driver);
        dashboardPage= new DashboardPage(driver);
    }
    @Test
    public void testSignInAndOpenPIM() {
        // Thực hiện đăng nhập với tài khoản Admin
        signInPage.SignIn("Admin", "admin123");
        dashboardPage.opendPIM();

    }

    // Đóng trình duyệt sau mỗi bài test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Đảm bảo thoát khỏi trình duyệt sau khi hoàn thành bài test
        }
    }
}
