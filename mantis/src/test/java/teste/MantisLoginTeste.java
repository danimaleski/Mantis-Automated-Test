package teste;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MantisLoginTeste {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mantis-prova.base2.com.br/login_page.php");
		Thread.sleep(3000);

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void valid_login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella.maleski");
		driver.findElement(By.name("password")).sendKeys("86BQWsHG6ccS");

		driver.findElement(By.tagName("input")).submit();
		
		String myUrl = driver.getCurrentUrl();
		String expectedUrl = "https://mantis-prova.base2.com.br/my_view_page.php";
		assertEquals("my_view_page", myUrl, expectedUrl);
		Thread.sleep(3000);
	}
	
	@Test
	public void empty_username() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(" ");
		driver.findElement(By.name("password")).sendKeys("86BQWsHG6ccS");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro username vazio");
		Thread.sleep(3000);
	}
	
	@Test
	public void empty_password() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella.maleski");
		driver.findElement(By.name("password")).sendKeys(" ");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro senha vazia");
		Thread.sleep(3000);
	}
	
	@Test
	public void incorrect_username() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella");
		driver.findElement(By.name("password")).sendKeys("86BQWsHG6ccS");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro username incorreto");
		Thread.sleep(3000);
	}
	
	@Test
	public void incorrect_password() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella.maleski");
		driver.findElement(By.name("password")).sendKeys("12345");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro senha incorreta");
		Thread.sleep(3000);
	}
	
	@Test
	public void incorrect_login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella");
		driver.findElement(By.name("password")).sendKeys("12345");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro login incorreto");
		Thread.sleep(3000);
	}
	
	@Test
	public void empty_login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(" ");
		driver.findElement(By.name("password")).sendKeys(" ");

		driver.findElement(By.tagName("input")).submit();
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
		assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
		
		System.out.println("Erro login vazio");
		Thread.sleep(3000);
	}
	
	@Test
	public void logout() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("daniella.maleski");
		driver.findElement(By.name("password")).sendKeys("86BQWsHG6ccS");

		driver.findElement(By.tagName("input")).submit();
		
		String myUrl = driver.getCurrentUrl();
		String expectedUrl = "https://mantis-prova.base2.com.br/my_view_page.php";
		assertEquals("my_view_page", myUrl, expectedUrl);
		Thread.sleep(1000);	
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[7]")).click();
		
		myUrl = driver.getCurrentUrl();
		expectedUrl = "https://mantis-prova.base2.com.br/login_page.php";
		assertEquals("login_page", myUrl, expectedUrl);
		
		Thread.sleep(3000);
	}	
}
