import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEcb implements AesMode {
    private static final String MODE_NAME = "ECB";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    @Override
    public String getName() {
        return MODE_NAME;
    }

    @Override
    public EncryptionResult encrypt(byte[] plaintext, byte[] key) throws Exception {
        if (plaintext == null) {
            throw new IllegalArgumentException("???????? ????? ?? ????? ???? null");
        }
        KeyGenerator.validateKey(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherText = cipher.doFinal(plaintext);

        return new EncryptionResult(MODE_NAME, cipherText, null);
    }

    @Override
    public byte[] decrypt(EncryptionResult result, byte[] key) throws Exception {
        if (result == null) {
            throw new IllegalArgumentException("????????? ?????????? ?? ????? ???? null");
        }
        KeyGenerator.validateKey(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(result.getCipherText());
    }
}