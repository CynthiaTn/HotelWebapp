package eql.Hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HotelTest {
	
	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(HotelTest.class);

	@Before

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver2.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void HotelWebappTest() throws Exception {

		driver.get("http://192.168.1.16:9999/HotelWebapp/");
		
		Select drpVille = new Select(driver.findElement(By.name("ville")));
		drpVille.selectByVisibleText("Paris");
		
		WebElement elementSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		elementSubmit.click();
		
		
		
		List<WebElement> liste = driver
				.findElements(By.xpath("//table/tbody/tr/td"));

		ArrayList<String> liste_col_ft = new ArrayList<String>();
		ArrayList<String> jdd_liste_h = new ArrayList<String>();

		for (WebElement l : liste) {
			liste_col_ft.add(l.getText());
		}

		jdd_liste_h.add("Hotel Latin");
		jdd_liste_h.add("Quartier latin");
		jdd_liste_h.add("Paris");
		jdd_liste_h.add("3 étoiles");
		jdd_liste_h.add("Hotel Etoile");
		jdd_liste_h.add("Place de l'Etoile");
		jdd_liste_h.add("Paris");
		jdd_liste_h.add("4 étoiles");
		jdd_liste_h.add("Hotel Vendome");
		jdd_liste_h.add("Place Vendome");
		jdd_liste_h.add("Paris");
		jdd_liste_h.add("5 étoiles");

		
		assertEquals("Assert KO",jdd_liste_h,liste_col_ft);
		logger.info("Tout est ok");

}
	

}
