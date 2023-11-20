package dev.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LibrarySeleniumtest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLibrarySearch() {
        driver.get("https://www.um.edu.ar/biblio/");

        // Encontrar el campo de búsqueda y escribir "Ingeniería de Software"
        WebElement searchInput = driver.findElement(By.id("id_del_campo_de_busqueda"));
        searchInput.sendKeys("Ingeniería de Software");

        // Realizar la búsqueda
        WebElement searchButton = driver.findElement(By.id("id_del_boton_de_busqueda"));
        searchButton.click();

        // Verificar que el libro existe en los resultados
        WebElement result = driver.findElement(By.xpath("//div[contains(text(),'Ingeniería de Software')]"));
        assertTrue(result.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
