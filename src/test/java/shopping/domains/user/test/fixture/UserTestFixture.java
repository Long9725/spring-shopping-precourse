package shopping.domains.user.test.fixture;

import shopping.domains.user.core.domain.entity.EncryptedEmail;
import shopping.domains.user.core.domain.entity.EncryptedPassword;
import shopping.domains.user.core.domain.entity.User;
import shopping.domains.user.test.util.TestEncryptUtil;

import java.util.List;

import static shopping.domains.user.core.domain.entity.RawPassword.MAX_RAW_PASSWORD_LENGTH;
import static shopping.domains.user.core.domain.entity.RawPassword.MIN_RAW_PASSWORD_LENGTH;

public class UserTestFixture {
    public static final List<String> EMAILS = List.of(
            "test@example.com",
            "test@example.co.kr",
            "test@hyundai-autoever.com",
            "some.sub@hyundai-autoever.com",
            "some_underscore@example.com",
            "some+tag@example.com",
            "some%123@example.com",
            "someTest123@example.com"
    );

    public static final List<String> INVALID_EMAILS = List.of(
            "test!123@example.com",
            "test@example.com!",
            "한글@한글.com"
    );

    public static final List<String> RAW_PASSWORDS = List.of(
            "Test@123",
            "Test@123456789123456"
    );

    public static final List<String> ENCRYPTED_PASSWORDS = List.of(
            "$2a$10$DoTjpsZkMTCEDMdTuPhGTeydB3W5Y48XWaKd1xc/WdbOdJzotldcO",
            "$2a$10$76rXxoUI0Dy584A5T21xZeC5cxtw7uB3LjJvZmd/tWsST0qr7/DIi"
    );

    public static final List<String> INVALID_RAW_PASSWORDS = List.of(
            String.format("Under%s*", MIN_RAW_PASSWORD_LENGTH),
            String.format("Over%sRawPassword@123456789", MAX_RAW_PASSWORD_LENGTH),
            "NonespecialChar123",
            "nonupper@123",
            "NONLOWER@123",
            "NonNumber@"
    );

    public static final User USER;

    static {
        final String encryptedEmail = TestEncryptUtil.encrypt("Test@example.com");
        final String encryptedPassword = TestEncryptUtil.hash("Test@123");
        USER = User.builder()
                .encryptedEmail(new EncryptedEmail(encryptedEmail))
                .encryptedPassword(new EncryptedPassword(encryptedPassword))
                .build();
    }
}
