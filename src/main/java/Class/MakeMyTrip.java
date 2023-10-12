package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class MakeMyTrip{
	
	
	
	public static void main (String[] args) throws ParseException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Girish\\eclipse-workspace\\New_Project\\src\\test\\resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		
		WebElement login=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Sign up/Login now to']"))));
		if(login.isDisplayed()) {
			WebElement logo= driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
			j.executeScript("arguments[0].click();", logo);
		}
		
		WebElement Departure = driver.findElement(By.xpath("//div//label[@for=('departure')]//span[contains(text(),('Departure'))]"));
		
		Departure.click();
		
        String date= "22 November 2023"; 
        String[] dateArr=date.split(" ");
        String month= dateArr[1];
        String date2=dateArr[0];
        System.out.println(month);
        Boolean foundM;
		
        while(true) {
        	int i=0;
        	
        	List<WebElement> monthHeadings=driver.findElements(By.xpath("//div[@role='heading']"));
            WebElement next = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
            String currentM=monthHeadings.get(i).getText().toLowerCase().split(" ")[0];
            String nextM=monthHeadings.get(i+1).getText().toLowerCase().split(" ")[0];
            	if(currentM.equalsIgnoreCase(month) || nextM.equalsIgnoreCase(month)) {
            		foundM=true;
            		break;
            	}else {
            		next.click();
            	}
            
        }
        if(foundM) {
        	WebElement d= driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]/..//following-sibling::div//p[text()='"+date2+"']"));
        	d.click();
        }

//		WebElement datepicker = driver.findElement(By.xpath("//div[@class='DayPicker-Month']"));
//		
//		if(driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[contains(text(),('September'))]")).isDisplayed())
//		{
//			WebElement date= driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[contains(text(),('September'))]//following::p[contains(text(),('28'))]"));
//			date.click();
//			
//		}
//		else
//		{
//			WebElement next = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
//			next.click();
//		}
		
		
		
		
		
		
		
	}

}
