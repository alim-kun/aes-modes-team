import java.security.SecureRandom;
import java.util.Base64;

public class CryptoUtils {
    public static final int AES_BLOCK_SIZE = 16;
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static byte[] randomBytes(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("????? ??????? ?? ????? ???? ?????????????");
        }
        byte[] bytes = new byte[length];
        SECURE_RANDOM.nextBytes(bytes);
        return bytes;
    }

    public static byte[] xor(byte[] a, byte[] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("??????? ??? XOR ?? ????? ???? null");
        }
        if (a.length != b.length) {
            throw new IllegalArgumentException(
                "?????? ????? ???????? ??? XOR: " + a.length + " ? " + b.length
            );
        }
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }

    public static String toHex(byte[] data) {
        if (data == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static byte[] fromHex(String hex) {
        if (hex == null || hex.length() % 2 != 0) {
            throw new IllegalArgumentException("???????????? HEX-??????");
        }
        byte[] out = new byte[hex.length() / 2];
        for (int i = 0; i < out.length; i++) {
            out[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16);
        }
        return out;
    }

    public static String toBase64(byte[] data) {
        return data == null ? "" : Base64.getEncoder().encodeToString(data);
    }

    public static byte[] fromBase64(String base64) {
        return base64 == null ? new byte[0] : Base64.getDecoder().decode(base64);
    }
}