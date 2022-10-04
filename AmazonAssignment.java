package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//search
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("Oneplus 9 pro");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='oneplus 9 pro']")).click();
		Thread.sleep(5000);
		
		String price = driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span")).getText();
		System.out.println(price);
		
		Thread.sleep(5000);
		String ratings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println(ratings);
		
		driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span")).click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		Set<String> Windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(Windows);
		driver.switchTo().window(window.get(1));
		
		//Take Screenshot
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/MobProduct.png");
		FileUtils.copyFile(source, destination);
		
		//Click Add to Cart button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		String total = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']/following::span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(total);
		
		
		//driver.close();
		
		
		
	}

}
