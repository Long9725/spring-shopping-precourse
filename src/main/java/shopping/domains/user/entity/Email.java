package shopping.domains.user.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public class Email {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    private String email;

    public Email(@NonNull final String email) {
        validate(email);

        this.email = email;
    }

    private void validate(@NonNull final String email) {
        if(PATTERN.matcher(email).matches()) {
            return;
        }

        throw new IllegalArgumentException("올바르지 않은 이메일 형식입니다.");
    }
}
