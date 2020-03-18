package jetaudio.pages;

import java.util.List;
import java.util.Set;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jetaudio.utilities.Utilities;

public class MainScreen extends ObjectExplorer {
	
	protected AppiumDriver<?> driver;
	public Set<MobileElement> completeBusList;
	public List<MobileElement> buslist;
	public List<MobileElement> fullBusList;
	public static Boolean assertion;
	public Equalizer equalizer;
	public Utilities util;

	public MainScreen(AppiumDriver<?> driver) {
		super(driver);
		this.driver = driver;
		util = new Utilities(driver);
		equalizer = new Equalizer(driver);
	}

	@AndroidFindBy(id = "btnFX")
	MobileElement list_soundSettings_Icon;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]//android.widget.TextView")
	MobileElement list_equalizer_Icon;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]//android.widget.TextView")
	MobileElement list_jetAudiosoundeffect;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]//android.widget.TextView")
	MobileElement list_aM3d;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]//android.widget.TextView")
	MobileElement list_Bongovi;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]//android.widget.TextView")
	MobileElement list_Crystaliser;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]//android.widget.TextView")
	MobileElement soundSettings_Icon;
	
	@AndroidFindBy(id = "android:id/alertTitle")
	MobileElement soundPreferecePopUp;
	
	@AndroidFindBy(id = "android:id/message")
	MobileElement soundPreferecePopUp_message;
	
	@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/statusbar_background")
	MobileElement notification_PlayerBar;
	
	@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/control_play")
	MobileElement notification_Player_Play;
	
	@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/control_play")
	MobileElement notification_Player_PlayOrPause;
	
	@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/control_next")
	MobileElement notification_Player_PlayNext;
	
	@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/control_prev")
	MobileElement notification_Player_PlayPrevious;
	
	

	public void soundSettingsIcon() {
		util.waitforVisiblity(list_soundSettings_Icon);
		list_soundSettings_Icon.click();
	}
	
	
	public void verifySoundPreferences() throws InterruptedException {
		util.waitforVisiblity(soundSettings_Icon);
		soundSettings_Icon.click();
		Thread.sleep(2000);
		String preferences_header = soundPreferecePopUp.getText();
		String preferences_message = soundPreferecePopUp_message.getText();
		if(preferences_header.equalsIgnoreCase("Sound effects")) {
			if(preferences_message.contains("Equalizer: OFF")) {
				driver.navigate().back();
				util.waitforVisiblity(list_soundSettings_Icon);
				list_soundSettings_Icon.click();
				util.waitforVisiblity(list_equalizer_Icon);
				list_equalizer_Icon.click();
				equalizer.equalizerEnable();
			} else {
				navigateBack();
				list_soundSettings_Icon.click();
				util.waitforVisiblity(list_equalizer_Icon);
				list_equalizer_Icon.click();
			}
		}
	}
	
	
	public void equaliser() {
		util.waitforVisiblity(list_equalizer_Icon);
		list_equalizer_Icon.click();
	}
	
	public void checkNotifications() {
		((AndroidDriver<?>) driver).openNotifications();
	}

	
	public void nextSong() {
		util.waitforVisiblity(notification_PlayerBar);
		notification_Player_PlayNext.click();
	}
	
	public void previousSong() {
		util.waitforVisiblity(notification_PlayerBar);
		notification_Player_PlayPrevious.click();
	}
	
	public void notification_pause_or_Play_Song() {
		util.waitforVisiblity(notification_PlayerBar);
		notification_Player_PlayOrPause.click();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
}




