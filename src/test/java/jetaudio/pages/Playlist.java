package jetaudio.pages;

import java.util.List;
import java.util.Set;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jetaudio.utilities.Utilities;

public class Playlist extends ObjectExplorer {

	protected AppiumDriver<?> driver;
	public Set<MobileElement> completeBusList;
	public List<MobileElement> buslist;
	public List<MobileElement> fullBusList;
	public static Boolean assertion;
	public Utilities util;

	public Playlist(AppiumDriver<?> driver) {
		super(driver);
		this.driver = driver;
		util = new Utilities(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]")
	MobileElement playlist_RecentlyAdded;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]")
	MobileElement playlist_RecentlyPlayed;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout[2]")
	MobileElement playlist_MostPlayed;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout[4]/android.widget.RelativeLayout/android.widget.LinearLayout[2]")
	MobileElement playlist_NowPlaying;
	
	
	@AndroidFindBy(id = "action_search")
	MobileElement playlist_searchSong_icon;
	
	@AndroidFindBy(id = "search_src_text")
	MobileElement playlist_searchSong_text;
	

	public void recentlyAdded() {
		util.waitforVisiblity(playlist_RecentlyAdded);
		playlist_RecentlyAdded.click();
	}

	public void recentlyPlayed() {

	}

	public void mostPlayed() {

	}

	public void nowPlaying() {

	}
	
	public void searchSongs() {
		util.waitforVisiblity(playlist_searchSong_icon);
		playlist_searchSong_icon.click();
	}
	
	public void searchGivenSongs(String songName) throws InterruptedException {
		//util.waitforVisiblity(playlist_searchSong_text);
		//playlist_searchSong_text.click();
		
		//playlist_searchSong_text.sendKeys(songName);
		//playlist_searchSong_text.sendKeys(Keys.RETURN);
		//Thread.sleep(2000);
		//List<String> songsinlist = (List<String>) driver.findElements(By.id("list")); 
		//for(int i=1; i<=songsinlist.size(); i++) {
		//	String song = "line"+1;
		//	if (driver.findElement(By.id(song)).getText().contains(songName)) {
		//		driver.findElement(By.id(song)).click();
		//	}
		//}
		util.findStringClick(songName);
	}

}
