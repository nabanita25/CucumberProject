package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class successfulGroup {
	
	public WebDriver driver;
    @Given("user should have launched the application")
    public void user_should_have_launched_the_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://elearning.upskills.in/");
    }
    @When("valid details are entered and clicked on login button")
    public void valid_details_are_entered() 
    {
        driver.findElement(By.id("login")).sendKeys("teacher1234");
        driver.findElement(By.id("password")).sendKeys("teacher");
        driver.findElement(By.id("form-login_submitAuth")).click();
    }
    
        
    @When("valid details are entered to create group")
    public void valid_group_created() 
    {
    	driver.findElement(By.xpath("//*[@id=\"page\"]/div/div/div/div/div[2]/h4/a")).click();
    	driver.findElement(By.xpath("//*[@id=\"toolimage_12954\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"toolbar-groups\"]/div/div[1]/a[1]/img")).click();
    	driver.findElement(By.id("create_groups_submit")).click();
    	driver.findElement(By.id("create_groups_step2_submit")).click();
    	
    	driver.findElement(By.xpath("//img[contains(@src,'http://elearning.upskills.in/main/img/icons/22/user.png')]")).click();
    	driver.findElement(By.id("group_edit_submit")).click();
    	driver.findElement(By.xpath("//img[contains(@src,'http://elearning.upskills.in/main/img/icons/22/edit.png')]")).click();
    	driver.findElement(By.name("self_registration_allowed")).click();
    	driver.findElement(By.name("self_unregistration_allowed")).click();
    	driver.findElement(By.id("group_edit_submit")).click();
    }
    
    @Then("To verify whether application allows teacher to create a group & modify the settings")
    public void application_allows_teacher_to_create_a_group() {
        String pageTitle1=driver.getTitle();
        System.out.println(pageTitle1);
    }
}

