package shopping.domains.user.utils;

import lombok.NonNull;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final int MIN_RAW_PASSWORD_LENGTH = 8;

    public static final int MAX_RAW_PASSWORD_LENGTH = 20;

    public static final Pattern RAW_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{"
            + MIN_RAW_PASSWORD_LENGTH + ","
            + MAX_RAW_PASSWORD_LENGTH + "}$");

    public static boolean validateRawPassword(@NonNull final String rawPassword) {
        return RAW_PASSWORD_PATTERN.matcher(rawPassword).matches();
    }
}
