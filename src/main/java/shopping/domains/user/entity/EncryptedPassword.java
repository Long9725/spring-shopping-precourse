package shopping.domains.user.entity;

import lombok.Getter;
import lombok.NonNull;
import shopping.domains.user.utils.ValidateUtils;

@Getter
public class EncryptedPassword {
    private String value;

    public EncryptedPassword(@NonNull final String value) {
        validate(value);

        this.value = value;
    }

    private void validate(@NonNull final String value) {
        if(ValidateUtils.validateRawPassword(value)) {
            throw new IllegalArgumentException("암호화되지 않은 비밀번호 입니다.");
        }
    }
}
