package shopping.domains.user.entity;

import lombok.NonNull;

public class RawPassword {
    private String value;

    public RawPassword(@NonNull final String value) {
        this.value = value;
    }
}
