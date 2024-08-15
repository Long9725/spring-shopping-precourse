package shopping.domains.user.core.domain.command;

import lombok.Builder;

public record SignInCommand(
        String rawEmail,

        String rawPassword
) {
    @Builder(toBuilder = true)
    public SignInCommand {

    }
}
