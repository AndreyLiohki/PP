import decryptor.Decryptor;
import org.junit.Test;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class DecryptorTest {

    private final Decryptor decryptor = new Decryptor();

    @Test
    public void testDecryptFile() throws Exception {
        String originalText = "Hello, World!";
        String key = "1234567890123456";
        byte[] encryptedData;
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        encryptedData = cipher.doFinal(originalText.getBytes());
        byte[] result = decryptor.decryptFile(encryptedData, key);
        assertArrayEquals(originalText.getBytes(), result);
    }

    @Test
    public void testDecryptFileWithWrongKey() {
        String originalText = "Hello, World!";
        String key = "1234567890123456";
        String wrongKey = "wrong_key_12345";
        byte[] encryptedData;

        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedData = cipher.doFinal(originalText.getBytes());
            decryptor.decryptFile(encryptedData, wrongKey);
            fail("Expected Exception was not thrown.");
        } catch (Exception e) {
        }
    }

    @Test
    public void testDecryptFileWithEmptyData() {
        String key = "1234567890123456";
        byte[] emptyData = new byte[0];

        try {
            byte[] result = decryptor.decryptFile(emptyData, key);
            assertArrayEquals(new byte[0], result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }
}