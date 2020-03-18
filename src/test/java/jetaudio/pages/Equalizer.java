package jetaudio.pages;

import java.util.List;
import java.util.Set;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jetaudio.utilities.Utilities;

public class Equalizer extends ObjectExplorer {
		
		protected AppiumDriver<?> driver;
		public Set<MobileElement> completeBusList;
		public List<MobileElement> buslist;
		public List<MobileElement> fullBusList;
		public static Boolean assertion;
		public Utilities util;

		public Equalizer(AppiumDriver<?> driver) {
			super(driver);
			this.driver = driver;
			util = new Utilities(driver);
		}

		@AndroidFindBy(id = "eq_enabled")
		MobileElement equalizer_Icon_on_off;
		
		@AndroidFindBy(id = "presets_spinner")
		MobileElement equalizer_Present_List;
		
		@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.CheckedTextView")
		MobileElement equalizer_Present_List_values;
		
		@AndroidFindBy(id = "com.jetappfactory.jetaudioplus:id/eq_volumeboost")
		MobileElement equalizer_Present_Volume_roundbutton;
		
		
		
		public void equalizerEnable() {
			equalizer_Icon_on_off.click();
		}
		
		public void selectPresentModes(List<String> present) throws InterruptedException {
			util.waitforVisiblity(equalizer_Present_List);
			equalizer_Present_List.click();
			for(int i=0; i< present.size(); i++) {
				util.findStringClick(present.get(i).toString());
				Thread.sleep(5000);
			}
		}
		
		
		public void adjustVolume_EqualizerMode() {
			util.waitforVisiblity(equalizer_Present_Volume_roundbutton);
		}
		
}

