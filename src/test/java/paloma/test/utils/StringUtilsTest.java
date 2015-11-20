package paloma.test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.paloit.paloma.utils.CustomStringUtils;

/**
 * Test class for string utils.
 * 
 * @author dtrang
 * 
 */
public class StringUtilsTest {

	@Test
	public void encryptMd5Test() throws Exception{
		String password = "lala";
		byte[] encrypt = CustomStringUtils.encryptAes(password);
		String decrypt = CustomStringUtils.decryptAes(encrypt.toString());
		assertEquals(decrypt, password);
	}
}
