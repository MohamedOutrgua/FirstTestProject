import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;

public class FirstTest {
        public static void main(String[] args) throws InterruptedException, IOException, CsvValidationException {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://only-testing-blog.blogspot.com/");
            CSVReader reader = new CSVReader((new FileReader("C:\\Users\\moham\\OneDrive\\Bureau\\ExcelReader.csv")));
            String line[];
            while ((line = reader.readNext()) != null) {
                String Fname = line[0];
                String Lname = line[1];
                String Email = line[2];
                String Mob = line[3];
                String Company = line[4];
                driver.findElement(By.name("FirstName")).sendKeys(Fname);
                driver.findElement(By.name("LastName")).sendKeys(Lname);
                driver.findElement(By.name("EmailID")).sendKeys(Email);
                driver.findElement(By.name("MobNo")).sendKeys(Mob);
                driver.findElement(By.name("Company")).sendKeys(Company);
                driver.findElement(By.xpath("//body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[6]")).click();
                Thread.sleep(1000);
                driver.switchTo().alert().accept();
            }
        }
}
