package jetaudio.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import jetaudio.base.TestEngine;
import jetaudio.pages.Equalizer;
import jetaudio.pages.MainScreen;
import jetaudio.pages.Playlist;

public class Regression extends TestEngine {
	public Playlist playlist;
	public MainScreen mainscreen;
	public Equalizer equalizer;
	
	@BeforeClass
	public void initPages() {
		playlist = new Playlist(driver);
		mainscreen = new MainScreen(driver);
		equalizer = new Equalizer(driver);
	}

	@BeforeMethod
	public void startTestcase() {
		try {
			driver.launchApp();
		} catch (Exception e) {
			System.out.println("Unable to Launch the App");
		}
	}

	@AfterMethod
	public void finishTestcase() {
		try {
			//driver.close();
		} catch (Exception e) {
			System.out.println("Unable to Launch the App");
		}
	}
	
	
	@Test(description = "Search for Busses for the given routes and date")
	public void test_TC001() throws InterruptedException {
		Thread.sleep(2000);
		playlist.recentlyAdded();
		
		//playlist.searchSongs();
		playlist.searchGivenSongs("Oh Sukumari");
		Thread.sleep(2000);
		mainscreen.navigateBack();
		playlist.searchGivenSongs("Usalampatti");
		Thread.sleep(2000);
		mainscreen.navigateBack();
		playlist.searchGivenSongs("Ladio");
		/*
		mainscreen.soundSettingsIcon();
		mainscreen.verifySoundPreferences();		
		List<String> present = new ArrayList<String>();
		present.add("Dance");
		present.add("User 4");
		present.add("Rap 2");
		present.add("Jazz");
		present.add("Bass Booster");
		present.add("Heavy Metal");
		equalizer.selectPresentModes(present);
		mainscreen.checkNotifications();
		mainscreen.nextSong();
		Thread.sleep(20000);
		mainscreen.previousSong();
		Thread.sleep(20000);
		mainscreen.notification_pause_or_Play_Song();
		Thread.sleep(5000);
		mainscreen.notification_pause_or_Play_Song();
		*/
	}

}

