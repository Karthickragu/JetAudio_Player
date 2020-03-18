package jetaudio.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import jetaudio.base.TestEngine;

public class ObjectExplorer extends TestEngine {
	
public AppiumDriver<?> driver; 
	
	public ObjectExplorer(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
