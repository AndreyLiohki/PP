package decryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Decryptor {
    private static final String ALGORITHM = "AES";

    public byte[] decryptFile(byte[] encryptedData, String key) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher  = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }

}
