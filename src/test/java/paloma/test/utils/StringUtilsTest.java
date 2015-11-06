package paloma.test.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.paloit.paloma.utils.CustomStringUtils;

import junit.framework.Assert;

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
