package samples;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AmazonNavigation {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String mainwindow=driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")).click();	
		Set<String> windows=driver.getWindowHandles();
		String Childwindow=null;
		for(String a:windows)
		{
			if(!a.equalsIgnoreCase(mainwindow))
			{
				Childwindow=a;
			}
		}
		  driver.switchTo().window(Childwindow);
		  WebElement we=driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		    Select se=new Select(we);
		    se.selectByIndex(1);
		    driver.findElement(By.id("add-to-cart-button")).click();
		    driver.switchTo().window(Childwindow);
		    driver.findElement(By.className("a-button-input")).submit();
		    driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();	    
		    driver.findElement(By.className("a-button-input")).click();       
		    Thread.sleep(70000);
		    Actions as=new Actions(driver);
		    as.moveToElement(driver.findElement(By.xpath("//*[@id=\"auth-create-account-link\"]"))).click().perform();
		    driver.findElement(By.id("ap_customer_name")).sendKeys("Sanjeetha");
		    driver.findElement(By.id("ap_phone_number")).sendKeys("917871256627");
		    driver.findElement(By.id("ap_email")).sendKeys("SanjeethaBanu0706.sb@gmail.com");
		    driver.findElement(By.id("ap_password")).sendKeys("Sanjeetha123");   	    	    
	    }
}
