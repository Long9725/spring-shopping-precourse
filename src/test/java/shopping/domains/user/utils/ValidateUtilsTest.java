package shopping.domains.user.utils;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static shopping.domains.user.test.fixture.UserTestFixture.INVALID_RAW_PASSWORDS;
import static shopping.domains.user.test.fixture.UserTestFixture.RAW_PASSWORDS;


class ValidateUtilsTest {
    @ParameterizedTest
    @DisplayName("비밀번호는 8자 이상, 20자 이하이면서 알파벳 대소문자, 숫자, 특수문자 하나씩 포함해야만 한다.")
    @MethodSource("validateRawPasswordParameters")
    void validateRawPasswordTest(
            final String given,
            @NonNull final boolean expected
    ) {
        // when
        final boolean actual = ValidateUtils.validateRawPassword(given);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> validateRawPasswordParameters() {
        return Stream.concat(
                RAW_PASSWORDS.stream()
                        .map(password -> new Object[] {password, true}),
                INVALID_RAW_PASSWORDS.stream()
                        .map(password -> new Object[] {password, false})
        ).map(Arguments::of);
    }
}
