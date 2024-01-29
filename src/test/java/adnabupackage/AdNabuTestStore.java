package adnabupackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdNabuTestStore {
	 
	  @Parameters("browser")
					public void setup(String browser) throws Exception{
		          
					if(browser.equalsIgnoreCase("Edge")) {
						System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\msedgedriver.exe");
					    WebDriver driver= new EdgeDriver();
						
					}
					else if (browser.equalsIgnoreCase("Chrome")){
						System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
					    WebDriver driver= new ChromeDriver();
						}
					else {
						throw new Exception("webdriver not found");
					}		
	}
	
  @Test()
  public void f() throws InterruptedException {
	  // test cases will run on chrome browser if you want to run it on other browser then use the below comment code
	  WebDriver driver= new ChromeDriver();
	  // WebDriver driver-= new FirefoxDriver();
	  // WebDriver driver-= new EdgeDriver();
	  
	    // Function to navigate to the application's home page
	    driver.get("https://adnabu-arjun.myshopify.com/account/login");
	    // Maximize the webpage
	    driver.manage().window().maximize();
	    // Enter the login-id username
	    driver.findElement(By.id("CustomerEmail")).sendKeys("amanverma1280@gmail.com");
	    // Enter the login-id password
	    driver.findElement(By.id("CustomerPassword")).sendKeys("#Verma99");
	    // Click on the signin button 
	    driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	    //it will wait for 20sec 
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    // Click on the search icon to search the existing product name
        driver.findElement(By.cssSelector(".modal__toggle-open.icon.icon-search")).click();
        // Search the product name which ever you want to search
        driver.findElement(By.cssSelector(".search__input.field__input")).sendKeys("14k Interlinked Earrings");
        // Click on the search icon
        driver.findElement(By.cssSelector("button.search__button.field__button")).click();// button.search__button.field__button, //button.search__button
      
        // Now you can see the product and click on the product 
        driver.findElement(By.id("CardLink--6876454486113")).click();
        //  Click on the add to cart button 
       driver.findElement(By.xpath("//button[@id='ProductSubmitButton-template--14768207495265__main']")).click();     
       // Product got added into cart successfully
       driver.findElement(By.cssSelector(".icon.icon-cart-empty")).click(); 
       driver.get("https://adnabu-arjun.myshopify.com/cart");
       // Click on the delete button to delete the added product from the card
       driver.findElement(By.cssSelector(".icon.icon-remove")).click();
       Thread.sleep(2000);
       driver.close();
   
	    }
	
}
