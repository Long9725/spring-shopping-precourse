package shopping.domains.user.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class AuthTokenTest {
    @Test
    @DisplayName("토큰 생성 테스트")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> new AuthToken("authToken"));
    }
}
