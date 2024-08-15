package shopping.domains.user.entity;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class RawPassword {
    private String value;

    public RawPassword(@NonNull final String value) {
        this.value = value;
    }
}
