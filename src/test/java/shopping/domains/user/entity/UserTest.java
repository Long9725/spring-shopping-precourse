package shopping.domains.user.entity;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shopping.domains.product.entity.Image;
import shopping.domains.product.entity.Name;
import shopping.domains.product.entity.Price;
import shopping.domains.product.entity.Product;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static shopping.domains.product.test.fixture.ProductTestFixture.*;
import static shopping.domains.user.test.fixture.EmailTestFixture.EMAILS;
import static shopping.domains.user.test.fixture.PasswordTestFixture.ENCRYPTED_PASSWORDS;
import static shopping.domains.user.test.fixture.PasswordTestFixture.RAW_PASSWORDS;

class UserTest {
    @Test
    @DisplayName("회원은 이메일, 비밀번호를 가진다.")
    void constructorTest() {
        // given
        final Email email = new Email(EMAILS.get(0));
        final EncryptedPassword encryptedPassword = new EncryptedPassword(ENCRYPTED_PASSWORDS.get(0));

        // when & then
        assertThatNoException().isThrownBy(() -> new User(email, encryptedPassword));
    }

    @Test
    @DisplayName("회원이 올바른 이메일과 비밀번호를 보내면 토큰을 발급한다.")
    void signInTest() {
        // given
        final Email email = new Email(EMAILS.get(0));
        final RawPassword rawPassword = new RawPassword(RAW_PASSWORDS.get(0));
        final EncryptedPassword encryptedPassword = new EncryptedPassword(ENCRYPTED_PASSWORDS.get(0));
        final User user = new User(email, encryptedPassword);
        final AuthToken token = new AuthToken("authToken");
        final SignInStrategy signInStrategy = new SignInStrategy() {
            @Override
            public boolean signIn(
                    @NonNull final Email email,
                    @NonNull final RawPassword rawPassword,
                    @NonNull final EncryptedPassword encryptedPassword,
                    @NonNull final MatchPasswordStrategy encryptPasswordStrategy
            ) {
                return true;
            }
        };
        final MatchPasswordStrategy matchPasswordStrategy = new MatchPasswordStrategy() {
            @Override
            public @NonNull boolean encrypt(
                    @NonNull final RawPassword rawPassword,
                    @NonNull final EncryptedPassword encryptedPassword
            ) {
                return true;
            }
        };

        // when
        final AuthToken actual = user.signIn(rawPassword, signInStrategy, matchPasswordStrategy, token);

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("회원이 올바르지 않은 이메일과 비밀번호를 보내면 예외가 발생한다.")
    void signInExceptionTest() {
        // given
        final Email email = new Email(EMAILS.get(0));
        final RawPassword rawPassword = new RawPassword(RAW_PASSWORDS.get(0));
        final EncryptedPassword encryptedPassword = new EncryptedPassword(ENCRYPTED_PASSWORDS.get(0));
        final User user = new User(email, encryptedPassword);
        final AuthToken token = new AuthToken("authToken");
        final SignInStrategy signInStrategy = new SignInStrategy() {
            @Override
            public boolean signIn(
                    @NonNull final Email email,
                    @NonNull final RawPassword rawPassword,
                    @NonNull final EncryptedPassword encryptedPassword,
                    @NonNull final MatchPasswordStrategy encryptPasswordStrategy
            ) {
                return false;
            }
        };
        final MatchPasswordStrategy matchPasswordStrategy = new MatchPasswordStrategy() {
            @Override
            public boolean encrypt(
                    @NonNull final RawPassword rawPassword,
                    @NonNull final EncryptedPassword encryptedPassword
            ) {
                return true;
            }
        };

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> user.signIn(rawPassword, signInStrategy, matchPasswordStrategy, token));
    }

    @ParameterizedTest
    @DisplayName("상품 생성자 NPE 테스트")
    @MethodSource("constructorNullParameters")
    void constructorNPETest(
            final Email email,
            final EncryptedPassword encryptedPassword
    ) {
        assertThatNullPointerException().isThrownBy(() -> User.builder()
                .email(email)
                .encryptedPassword(encryptedPassword)
                .build());
    }

    private static Stream<Arguments> constructorNullParameters() {
        // given
        final Email email = new Email(EMAILS.get(0));
        final EncryptedPassword encryptedPassword = new EncryptedPassword(ENCRYPTED_PASSWORDS.get(0));

        return Stream.of(
                Arguments.of(null, encryptedPassword),
                Arguments.of(email, null)
        );
    }
}
