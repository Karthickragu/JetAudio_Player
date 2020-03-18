package jetaudio.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestEngine {
	
	
	public static AppiumDriver<?> driver;
	public static DesiredCapabilities cap;
	public AppiumServiceBuilder appiumBuilder;
	public AppiumDriverLocalService appiumServer;
	

	
	@BeforeSuite
	public void SetUp() {
		String Appium_Node_Path = "C:\\Program Files\\nodejs\\node.exe";
		String Appium_JS_Path = "C:\\Users\\sathiyar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		
			try {
				cap = new DesiredCapabilities();
				// cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
				// properties.getProperty("PLATFORM_NAME"));
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "5642c6b9");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
				cap.setCapability("appActivity", "com.jetappfactory.jetaudioplus.PlaylistBrowserActivity");
				cap.setCapability("appPackage", "com.jetappfactory.jetaudioplus");
				
				cap.setCapability("noReset", true);
				cap.setCapability("autoLaunch", false);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				appiumBuilder = new AppiumServiceBuilder();
				appiumBuilder.withAppiumJS(new File(Appium_JS_Path));
				appiumBuilder.usingDriverExecutable(new File(Appium_Node_Path));
				appiumBuilder.withIPAddress("127.0.0.2");
				appiumBuilder.usingAnyFreePort();
				appiumBuilder.withCapabilities(cap);
				appiumBuilder.withStartUpTimeOut(3, TimeUnit.MINUTES);
				appiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				appiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				appiumServer = AppiumDriverLocalService.buildService(appiumBuilder);
				appiumServer.start();
				driver = new AndroidDriver<AndroidElement>(appiumServer, cap);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	


