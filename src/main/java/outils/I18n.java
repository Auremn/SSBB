package outils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
	
	private static final String FILE_BASE_NAME = "messages";


	private static ResourceBundle rb;
	
	static {
		I18n.rb = ResourceBundle.getBundle(I18n.FILE_BASE_NAME);
	}
	
	public static void changeLocal(Locale pLocale) {
		I18n.rb = ResourceBundle.getBundle(I18n.FILE_BASE_NAME, pLocale);
	}
	
	public static String get(String pKey) {
		return I18n.rb.getString(pKey);
	}
	
	public static String[] getTableau(String key) {
		return I18n.rb.getString(key).split("\\|");
	}
	
}
