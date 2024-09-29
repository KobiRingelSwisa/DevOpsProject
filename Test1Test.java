import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Test1Test {
  private WebDriver driver;
  private JavascriptExecutor js;
  
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void test1() {
    driver.get("https://c156-46-117-198-107.ngrok-free.app/KobiSwisaOzYosefAsherFinkelstein/index.jsp");
    driver.manage().window().setSize(new Dimension(1293, 712));

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Visit Site']")));
    button.click();

    assertThat(driver.getTitle(), is("Simple JSP Web App"));

    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("test");

    WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
    submitButton.click();

    try {
      Thread.sleep(2000); 
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    WebElement resultHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
    assertThat(resultHeader.getText(), is("Form Submitted Successfully!"));
  }
}
