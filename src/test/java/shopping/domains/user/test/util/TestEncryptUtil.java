package shopping.domains.user.test.util;

import lombok.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestEncryptUtil {
    private static final AesBytesEncryptor encryptor = new AesBytesEncryptor("test", "123123");

    private static final BCryptPasswordEncoder hash = new BCryptPasswordEncoder();

    @NonNull
    public static final String hash(@NonNull final String origin) {
        return hash.encode(origin);
    }

    @NonNull
    public static final String encrypt(@NonNull final String origin) {
        final byte[] encrypt = encryptor.encrypt(origin.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(encrypt);
    }

    @NonNull
    public static final String decrypt(@NonNull final String encrypted) {
        final byte[] decryptBytes = stringToByteArray(encrypted);
        final byte[] decrypt = encryptor.decrypt(decryptBytes);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    private static String byteArrayToString(@NonNull final byte[] bytes) {
        final StringBuilder sb = new StringBuilder();
        for (byte abyte : bytes) {
            sb.append(abyte);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static byte[] stringToByteArray(@NonNull final String byteString) {
        final String[] split = byteString.split("\\s");
        final ByteBuffer buffer = ByteBuffer.allocate(split.length);
        for (final String s : split) {
            buffer.put((byte) Integer.parseInt(s));
        }
        return buffer.array();
    }
}
