package shopping.domains.user.core.domain.command;

import lombok.Builder;

public record SignUpCommand (
        String rawEmail,

        String rawPassword
) {
    @Builder(toBuilder = true)
    public SignUpCommand {

    }
}
