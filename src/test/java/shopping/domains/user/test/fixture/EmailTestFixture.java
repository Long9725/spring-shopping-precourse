package shopping.domains.user.test.fixture;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class EmailTestFixture {
    public static final List<String> EMAILS = List.of(
           "test@example.com",
           "test@example.co.kr",
           "test@hyundai-autoever.com",
           "some.sub@hyundai-autoever.com",
           "some_underscore@example.com",
           "some+tag@example.com",
           "some%123@example.com",
           "someTest123@example.com"
    );

    public static final List<String> INVALID_EMAILS = List.of(
           "test!123@example.com",
           "test@example.com!",
           "한글@한글.com"
    );
}
