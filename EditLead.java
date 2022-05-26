package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//open browser chrome
		ChromeDriver driver = new ChromeDriver();
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		//maximize the window
		driver.manage().window().maximize();
		//login into application
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Open the CRMSFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on leads link
		driver.findElement(By.linkText("Leads")).click();
		// Click on create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter mandatory fields in form Company name,firstname and last name and 
		//click submit
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");// enter company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vamsi");//firstname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Krishna");// last name
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Technology");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is test leaf description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vamsikrishna2927@gmail.com");
		//select state as Newyork
		WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select city = new Select(ele);
		city.selectByVisibleText("New York");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("NewYork");
		//create lead
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();// clear the description
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("This importance note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		// get title
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		driver.close();

	}

}
