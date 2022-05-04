package newpackage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FactorialCalculator {

	public static void main(String[] args) {
		// newest version of chrome web driver
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_100\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		{
			// url under test
			driver.get("http://qainterview.pythonanywhere.com/");
			{

				// factorial of 5 is: 120 test
				driver.findElement(By.id("number")).sendKeys("7");
				driver.findElement(By.id("getFactorial")).sendKeys(Keys.ENTER);

				// set implicit wait of 5 seconds
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

				WebElement statusElement = driver.findElement(By.id("number"));
				String statusAttribute = statusElement.getAttribute("style");

				// check if red boarder returned on number box - which indicates an error - non
				// int entered
				if (!statusAttribute.contains("red")) {
					Boolean result = statusAttribute != "red";
					assertTrue(result);
					// status is Pass
					System.out.println("PASS - Valid entry has been entered and a f! result has been returned");
				} else if (statusAttribute.contains("red")) {
					Boolean result = statusAttribute == "red";
					assertFalse(result);
					// status is Fail
					System.out.println("FAIL - Invalid entry into number field and an error has been returned ");
				}

			}

		}

	}

}
