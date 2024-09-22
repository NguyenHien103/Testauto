package test.pages;

import org.openqa.selenium.WebDriver;
import test.common.ValidateHelpers;

public class ProjectPim {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    public ProjectPim(WebDriver driver){
        this.driver= driver;
        validateHelpers = new ValidateHelpers(driver);

    }
}
