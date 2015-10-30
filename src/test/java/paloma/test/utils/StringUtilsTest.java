package paloma.test.utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.paloit.paloma.utils.CustomStringUtils;

/**
 * Test class for string utils.
 * 
 * @author dtrang
 * 
 */
public class StringUtilsTest {

	@Test
	public void encryptMd5Test(){
		String encrypt = CustomStringUtils.encryptMd5("lala");
		System.out.println(encrypt);
	}
}
