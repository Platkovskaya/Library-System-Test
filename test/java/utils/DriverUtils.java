package utils;

import org.openqa.selenium.WebDriver;

public class DriverUtils {

	private DriverUtils() {}

	public static void openURL(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Can't open '" + url + "', try one more time...");
			driver.get(url);
		}
	}

}
