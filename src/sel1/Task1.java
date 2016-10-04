package sel1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Task1 {
	private static double dziel = 0.58;
	private static int przesun = 0;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver ();
		driver.manage().window().maximize(); 
		String url = "http://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering";
		driver.get(url);
		WebElement formularz = driver.findElement(By.id("isc_2I"));
		formularz.sendKeys("a");
	
		WebElement slider = driver.findElement(By.xpath(".//*[@id='isc_46']"));
	
		String left = slider.getCssValue("left");
		left = left.replaceAll("\\D+","");
		double wielkosc = Double.valueOf(left);
		przesun = (int) ((int) wielkosc * (1 - dziel));
	
		//if (jaki jest value)
		//while przesun i porownuj slider value

		
		WebElement slider1 = driver.findElement(By.xpath(".//*[@id='isc_29']"));
		Actions builder = new Actions(driver);
		Action dragAndDrop = 
		builder.clickAndHold(slider1).moveByOffset(-przesun,0).release().build();
		dragAndDrop.perform();
		
		WebElement wybieralka = driver.findElement(By.xpath(".//*[@id='isc_34']"));
		wybieralka.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		
		WebElement checkbox = driver.findElement(By.id("isc_3E"));
		checkbox.click();
	
	
	}


}