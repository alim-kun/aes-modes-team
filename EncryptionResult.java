import java.util.Arrays;

public class EncryptionResult {
    private final String modeName;
    private final byte[] cipherText;
    private final byte[] ivOrNonce;

    public EncryptionResult(String modeName, byte[] cipherText, byte[] ivOrNonce) {
        this.modeName = modeName;
        this.cipherText = cipherText == null ? new byte[0] : Arrays.copyOf(cipherText, cipherText.length);
        this.ivOrNonce = ivOrNonce == null ? null : Arrays.copyOf(ivOrNonce, ivOrNonce.length);
    }

    public String getModeName() {
        return modeName;
    }

    public byte[] getCipherText() {
        return Arrays.copyOf(cipherText, cipherText.length);
    }

    public byte[] getIvOrNonce() {
        return ivOrNonce == null ? null : Arrays.copyOf(ivOrNonce, ivOrNonce.length);
    }
}