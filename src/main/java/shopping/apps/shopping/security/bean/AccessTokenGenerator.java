package shopping.apps.shopping.security.bean;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shopping.domains.user.core.domain.entity.TokenGenerator;

import java.util.UUID;

@Component
public class AccessTokenGenerator implements TokenGenerator {
    @Value("${security.encrypt.token.access.secret}")
    private String secret;

    @Value("${security.encrypt.token.access.expire}")
    private String expire;

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
