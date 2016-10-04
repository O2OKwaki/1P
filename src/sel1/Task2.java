package sel1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Task2 {
    private static int index;
    private static String id;
    private static final String itemRegex = "Exercise";
    private static final String unitRegex = "Ea";
    private static final String tagRegex = "<.+?>";
    private static final int Row_Count = 0;
    static WebDriver driver = new FirefoxDriver ();
    static Actions actions = new Actions(driver);

    private static boolean checkRow(WebElement row) throws StaleElementReferenceException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String doubleString = row.findElement(By.xpath(".//td[3]")).getText().replaceAll(tagRegex, "");

        if(!doubleString.isEmpty()) {
            Double d = Double.valueOf(doubleString);
            if (row.findElement(By.xpath(".//td[1]")).getText().contains(itemRegex) &&
row.findElement(By.xpath(".//td[2]")).getText().contains(unitRegex) &&
                d > 1.1) {
                id = row.getAttribute("id");
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) throws InterruptedException {

        String url = "http://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category";
        driver.get(url);
        WebElement tabela = driver.findElement(By.id("isc_22"));
        //WebElement tabela = driver.findElement(By.cssSelector())
        tabela.click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='isc_3Gtable']//tr"));
            while (id == null) {
            try{
                for(WebElement row : rows) {
                    if(checkRow(row)) {
                        row.click();
                        break;
                    }
                    actions.sendKeys(Keys.DOWN).build().perform();
                }
            }
            catch (StaleElementReferenceException e){
                rows = driver.findElements(By.xpath("//table[@id='isc_3Gtable']//tr"));
            }
        }



          

    Thread.sleep(100);

    }
}
