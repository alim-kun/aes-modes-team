public interface AesMode {
    String getName();

    EncryptionResult encrypt(byte[] plaintext, byte[] key) throws Exception;

    byte[] decrypt(EncryptionResult result, byte[] key) throws Exception;
}