package jetaudio.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {

	public AppiumDriver<?> driver;

	public Utilities(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public void waitforVisiblity(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean findStringClick(String text) {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"))
					.click();
			System.out.println(text + " Found and selected");
			return true;
		} catch (Exception e) {
			System.out.println("Unable to find the text" + text);
			return false;
		}
	}

	public void taponCoordinates(int x, int y) {
		TouchAction<?> actions = new TouchAction(driver);
		try {
			actions.press(PointOption.point(x, y)).release().perform();
		} catch (Exception e) {
			System.out.println("Touch Action Failed...");
		}
	}

	public void scroll(Integer x, Integer y) {
		
		try {
		
			 TouchAction action = new TouchAction(driver);
	            //WebElement element = driver.findElement(By.xpath("//android.widget.ListView"));
	            action.press(PointOption.point(0, y)).moveTo(PointOption.point(0, x)).release().perform();			
		} catch (Exception e) {
			System.out.println("Scroll Action Failed...");
		}
	}
	
	public boolean findString(String text) {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"));
			System.out.println(text + " Found");
			return true;
		} catch (Exception e) {
			System.out.println("Unable to find the text" + text);
			return false;
		}
	}

}
