import java.security.SecureRandom;

public class KeyGenerator {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static byte[] generateKey() {
        return generateKey(16);
    }

    public static byte[] generateKey(int keyLengthBytes) {
        validateKeyLength(keyLengthBytes);
        byte[] key = new byte[keyLengthBytes];
        SECURE_RANDOM.nextBytes(key);
        return key;
    }

    public static void validateKey(byte[] key) {
        if (key == null) {
            throw new IllegalArgumentException("???? ?? ????? ???? null");
        }
        validateKeyLength(key.length);
    }

    private static void validateKeyLength(int length) {
        if (length != 16 && length != 24 && length != 32) {
            throw new IllegalArgumentException(
                "???????????? ????? ????? AES: " + length + " ???? (????????? 16, 24 ??? 32)"
            );
        }
    }
}