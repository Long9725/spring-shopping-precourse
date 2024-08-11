package shopping.domains.user.entity;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static shopping.domains.user.test.fixture.PasswordTestFixture.RAW_PASSWORDS;

class EncryptedPasswordTest {
    @ParameterizedTest
    @DisplayName("암호화된 비밀번호는 암호화되지 않은 비밀번호 형식일시 예외가 발생한다.")
    @MethodSource("rawPasswordParameters")
    void encryptedPasswordInvalidConstructorTest(@NonNull final String rawPassword) {
        assertThatIllegalArgumentException().isThrownBy(() -> new EncryptedPassword(rawPassword));
    }

    private static Stream<Arguments> rawPasswordParameters() {
        return RAW_PASSWORDS.stream()
                .map(Arguments::of);
    }
}
