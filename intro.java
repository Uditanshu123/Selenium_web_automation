package selenium_package;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class web_automation {
	public static void main(String[] args) throws InterruptedException {
		
		
// TODO Auto-generated method stub
		System.setProperty("wendriver.chrome.driver", "C:\\Users\\UditanshuDixit\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
// Thread.sleep(6000);
		String fname = "Uditanshu";
		String lname = "Dixit";
		int number = 949494949;
		String country = "India";
		String city = "NYC";
		String email = "test@gmail.com";
		
		
// Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame-one1434677811']")));
// First Name
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys(fname);
// Last Name
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys(lname);
// Phone
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("" + number);
// Country
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys(country);
// City
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys(city);
// Email
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys(email);
// Gender - Male
		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']")).click();
		
//Scrolling down using JS
		js.executeScript("window.scrollBy(0,300)");
		
// Selecting all the days
		List<WebElement> days = driver.findElements(By.xpath("//label[contains(@for,'RESULT_CheckBox-8')]"));
		for (int i = 0; i < days.size(); i++) {
			Thread.sleep(1000);
			days.get(i).click();
			System.out.println(days.get(i).getText());
			Thread.sleep(1000);
		}
//Selecting Dropdown
		Select dropdown = new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
		dropdown.selectByValue("Radio-2");
		
//Uploading the File
		driver.findElement(By.id("RESULT_FileUpload-10"))
				.sendKeys("C:\\Users\\UditanshuDixit\\Downloads\\imageedit_2_2472935156.jpg");
		
//Getting out of iframe
		driver.switchTo().defaultContent();
		
//Left Pane scraping and fill Up
//Search and pick the first search
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("Apple");
		driver.findElement(By.className("wikipedia-search-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id=\"wikipedia-search-result-link\"][1]/a")).click();
		
//Get back to Parent Page
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		driver.switchTo().window(parentId);
		
//Handling Alert
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
//Assuming the year(2022) is same
		String month = "June";
		String date = "24";
		driver.findElement(By.cssSelector("input#datepicker")).click();
//Selecting Month
		while (!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().contains(month)) {
			driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			Thread.sleep(1000);
		}
//Selecting Date
		List<WebElement> dates_available = driver.findElements(By.cssSelector("a.ui-state-default"));
		for (int i = 0; i < dates_available.size(); i++) {
			if (dates_available.get(i).getText().contains(date)) {
				dates_available.get(i).click();
				break;
			}
		}
		js.executeScript("window.scrollBy(0,300)");
		
//Menu selection
		Select speed = new Select(driver.findElement(By.id("speed")));
		speed.selectByIndex(2);
		
//Select a file
		Select file = new Select(driver.findElement(By.id("files")));
		file.selectByIndex(1);
		
//Select a number
		Select numbers = new Select(driver.findElement(By.id("number")));
		numbers.selectByIndex(4);
		
//Select a product
		Select product = new Select(driver.findElement(By.id("products")));
		product.selectByValue("Apple");
		
//Select an animal
		Select animal = new Select(driver.findElement(By.id("animals")));
		animal.selectByValue("big baby cat");
		
//Scraping text labels
		List<WebElement> text_Labels = driver.findElements(By.xpath("//span[@style='font-family: Georgia, serif;']"));
		for (int i = 0; i < text_Labels.size(); i++) {
			System.out.println(text_Labels.get(i).getText());
		}
		
//Right side portion(Double Click)
		driver.findElement(By.id("field1")).clear();
		driver.findElement(By.id("field1")).sendKeys("Uditanshu Dixit");
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"))).build().perform();
		Thread.sleep(2000);
		
//Drag the element
		WebElement source = driver.findElement((By.id("draggable")));
		WebElement destination = driver.findElement((By.id("droppable")));
		js.executeScript("arguments[0].scrollIntoView(true);", source);
		a.dragAndDrop(source, destination).build().perform();
		
//Dragging and dropping images in bin
		WebElement source1 = driver.findElement(By.xpath("//h5[text()='Mr John']"));
		WebElement source2 = driver.findElement(By.xpath("//h5[text()='Mary']"));
		js.executeScript("arguments[0].scrollIntoView(true);", source1);
		WebElement destination2 = driver.findElement(By.id("trash"));
		a.dragAndDrop(source1, destination2).build().perform();
		Thread.sleep(2000);
		a.dragAndDrop(source2, destination2).build().perform();
//Working with Slider
		
		WebElement slider = driver.findElement(By.cssSelector("span.ui-slider-handle.ui-corner-all.ui-state-default"));
		js.executeScript("arguments[0].scrollIntoView(true);", slider);
		a.dragAndDropBy(slider, 100, 0).build().perform();
		
//Resizable element
		WebElement resize = driver.findElement(
				By.cssSelector("div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
		a.dragAndDropBy(resize, 10, 0).build().perform();
		
//Working with tables
		js.executeScript("window.scrollBy(0,1800)");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td"));
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());
		}
		
//Gather tool tip data and populate the age
		System.out.println(driver.findElement(By.xpath("//input[@id='age']")).getAttribute("title"));
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("22");
	}
}
