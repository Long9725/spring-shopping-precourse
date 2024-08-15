package shopping.domains.user.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public class EncryptedEmail {
    private String value;

    public EncryptedEmail(@NonNull final String value) {
        validate(value);

        this.value = value;
    }

    private void validate(@NonNull final String email) {
        if(RawEmail.PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("암호화되지 않은 이메일 형식입니다.");
        }
    }
}
