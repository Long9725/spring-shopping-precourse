package shopping.domains.user.entity;

import lombok.NonNull;

public class AuthToken {
    private String value;

    public AuthToken(@NonNull final String value) {
        this.value = value;
    }
}
