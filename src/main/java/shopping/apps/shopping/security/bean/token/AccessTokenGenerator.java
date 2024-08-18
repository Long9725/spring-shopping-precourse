package shopping.apps.shopping.security.bean.token;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shopping.domains.user.core.domain.entity.TokenGenerator;

import java.util.UUID;

public class AccessTokenGenerator implements TokenGenerator {
    private final String secret;

    private final String expire;

    public AccessTokenGenerator(
            final String secret,
            final String expire
    ) {
        this.secret = secret;
        this.expire = expire;
    }

    @Override
    public @NonNull String createToken(@NonNull UUID uuid) {
        return null;
    }

    @Override
    public @NonNull boolean verifyToken(@NonNull String token) {
        return false;
    }

    @Override
    public @NonNull boolean verifyTokenNotExpired(@NonNull String token) {
        return false;
    }

    @Override
    public @NonNull UUID getUuidFromToken(@NonNull String token) {
        return null;
    }
}
