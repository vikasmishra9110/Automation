package nagp.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyReader {
	private static Properties property;
	private static PropertyReader propertyReader = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyReader.class);

	private PropertyReader() {
	}

	public static PropertyReader getProperyReaderInstance() throws IOException {
		FileInputStream fis = null;
		try {
			if (propertyReader == null) {
				propertyReader = new PropertyReader();
				property = new Properties();
				LOGGER.info("File path is : " + System.getProperty("user.dir")
						+ "\\src\\test\\resources\\config.properties");

				fis = new FileInputStream(
						new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"));
				property.load(fis);
			}
		} catch (Exception e) {
			LOGGER.error("Error encounetred while reading propery file : " + e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				LOGGER.error("Error encounetred while closing file input steam : " + e);
			}
		}
		return propertyReader;
	}

	public static String getValue(String key) {
		return property.get(key).toString();
	}
}
