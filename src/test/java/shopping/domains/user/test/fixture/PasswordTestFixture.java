package shopping.domains.user.test.fixture;

import java.util.List;

import static shopping.domains.user.utils.ValidateUtils.MAX_RAW_PASSWORD_LENGTH;
import static shopping.domains.user.utils.ValidateUtils.MIN_RAW_PASSWORD_LENGTH;

public class PasswordTestFixture {
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
}
