package shopping.apps.shopping.security.bean.token;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

import static shopping.apps.shopping.api.constant.ApiUrls.*;

public class AccessTokenWhitelist {
    private final List<String> whitelists;


    private AccessTokenWhitelist() {
        this.whitelists = List.of(
                SWAGGER_API_DOCS,
                SWAGGER_UI,
                SWAGGER_RESOURCES,
                USER_PREFIX + USER_LOGIN,
                USER_PREFIX + USER_REGISTER
        );
    }

    // 싱글톤 인스턴스를 반환하는 메서드
    public static AccessTokenWhitelist getInstance() {
        return LazyHolder.INSTANCE;
    }

    public boolean contains(@NonNull final String value) {
        return whitelists.contains(value);
    }

    public boolean notContains(@NonNull final String value) {
        return !contains(value);
    }

    public boolean match(
            @NonNull final String value,
            @NonNull final MatchStrategy matchStrategy
    ) {
        if(notContains(value)) {
            return false;
        }
        return whitelists.stream().anyMatch(whitelist -> matchStrategy.match(whitelist, value));
    }

    public boolean noneMatch(
            @NonNull final String value,
            @NonNull final MatchStrategy matchStrategy
    ) {
       return !match(value, matchStrategy);
    }

    public String[] toArray() {
        return whitelists.toArray(new String[0]);
    }

    private static final class LazyHolder {
        private static final AccessTokenWhitelist INSTANCE = new AccessTokenWhitelist();
    }
}
