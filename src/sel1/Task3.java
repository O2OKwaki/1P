package sel1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Task3 {
    private static int index;
    private static int i;
    private static boolean klikniete;
    private static boolean odklikniete;
    private static final String itemRegex = "Correction";
    static WebDriver driver = new FirefoxDriver ();
    static Actions actions = new Actions(driver);
    
    public static String randomString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int a = 0; a < length; a++)
        {
            text[a] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

     public static void main(String[] args) throws InterruptedException {
    	 i = 1;
    	 index = 1;
    	  String url = "http://www.smartclient.com/smartgwt/showcase/#featured_nested_grid";
          driver.get(url);
          WebElement licznik = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr[1]/td[2]/div"));
          licznik.click();
          WebElement pobierz = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr[1]"));
           String przechowaj = pobierz.getAttribute("aria-setsize");
           System.out.println(przechowaj);
           int wielkosc = Integer.parseInt(przechowaj);
           //int wielkosc = (int)Double.valueOf(przechowaj);
          
          //String Comparator2 = "";
          //while (driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+index+"]/td[2]/div")).getText() != null){
        //	  String Comparator = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+index+"]/td[2]/div")).getText();
        	//  if(Comparator != Comparator2){
        	  //actions.sendKeys(Keys.DOWN).build().perform();
        	  //Comparator2 = Comparator;
        	  //index++;
        	  //if(index%5==0){
        		//  actions.sendKeys(Keys.PAGE_DOWN).build().perform(); 
        		  //Thread.sleep(500);
        	  //}
        	  //Thread.sleep(500);
        	  //}
          //}
          List<WebElement> bigs = driver.findElements(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr/div"));
          
          while (bigs != null){
        	for (i = 1; i <= wielkosc; i++){  
        		  
        	  //}
          //for (WebElement big : bigs) {
        	  try{
        		  System.out.println("Klikacz wchodzi");  
        		  klikniete = true;
        		  WebElement klikacz = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[1]/div/span"));
        		          		  klikacz.click();
        		  klikniete = false;
        		  System.out.println("Klikacz dziala");
        		  Thread.sleep(500);
        	  
        	  List<WebElement> smalls = driver.findElements(By.className("textItemLite"));    
              		for (WebElement small : smalls) {
              			System.out.println("Smalls dziala");
            
              			if(driver.findElement(By.className("textItemLite")).getText().contains(itemRegex)){
              				System.out.println("Znalazlem element");
              				WebElement zapis = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[3]/div/span/table"));
              				zapis.click();
              				String numer = String.valueOf(index) + " " + randomString(null, "abcdefghijklmnoprstuvwxyz", 10);
              				actions.sendKeys(numer);
              				actions.sendKeys(Keys.ENTER).build().perform();
              				index++;
              				}
              		Thread.sleep(1500);
              		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
              		System.out.println("Odklikacz wchodzi");
              		if(i == 10000){
              		WebElement pierwszy = 	driver.findElement(By.xpath(".//div[contains(text(),'Close')][style='display:inline-block;box-sizing:border-box;max-width:100%;vertical-align:middle;overflow:hidden;text-overflow:ellipsis']"));
              		Thread.sleep(500);

              			//WebElement pierwszy = 	driver.findElement(By.cssSelector(selector)
              					//WebElement pierwszy = 	driver.findElement(By.)		
//style="display:inline-block;box-sizing:border-box;max-width:100%;vertical-align:middle;overflow:hidden;text-overflow:ellipsis"
              		pierwszy.click();
              		//#isc_55
              	//*/fieldset[@class="openable"][@id="activityFieldset"]
              		//<div id="isc_55" style="display:inline-block;box-sizing:border-box;max-width:100%;vertical-align:middle;overflow:hidden;text-overflow:ellipsis">Close</div>
              		}
              		else{
              		odklikniete = true;
              		System.out.println(i);
              		WebElement odklikacz = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[1]/div/span"));
              		odklikniete = false;
              		//
              		//WebElement odklikacz = driver.findElement(By.xpath(".//div[contains(text(), 'Close')]"));
              		//@class, 'buttonRounded') and 
              		odklikacz.click();
              		}
              		System.out.println("Odklikacz dziala");
              		Thread.sleep(500);
              		}
              
        	  }
        	  
        	  catch (NoSuchElementException d){
        		  //String Comparator = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+index+"]/td[2]/div"));
        	  }
          
        	  catch (StaleElementReferenceException e){
                  
              }
              catch (ElementNotVisibleException f) {
            	  System.out.println("Catch ElementNotVisible wszedl");
            	  i = 1;
            	  WebElement scroller = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[1]/div"));
            	  Actions actions = new Actions(driver);
            	  actions.moveToElement(scroller);
            	  // actions.click();
            	  //Thread.sleep(500); 
              }
                  //List<WebElement> bigs = driver.findElements(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr[+i+]"));
              //}
              	catch (WebDriverException g) {
            	  System.out.println("Catch ElementNotClickable wszedl");
            	  String ClickPrint = "" + i;
            	  System.out.println(ClickPrint);
            	  if(klikniete=true){
            		  WebElement klikacz = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[1]/div/span"));
            		  klikacz.click();
            	  }
            	  else if(odklikniete=true){
            		  WebElement odklikacz = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]/td[1]/div/span"));
                	  odklikacz.click();
                	  }
            	  else {
                	  System.out.println("Catch ElementNotClickable nieobslugiwany - DORÓB!!");

            	  }
            	  WebElement big = driver.findElement(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr["+i+"]"));
            	  //actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            	  //bigs = driver.findElements(By.xpath(".//*[@id='isc_26table']/tbody[2]/tr"));
            	  //Thread.sleep(500);
              	}
        	  
        	  //actions.sendKeys(Keys.DOWN).build().perform();
        	  //i++;
          }

        	  
        	  
          
          	
     }
}
}



