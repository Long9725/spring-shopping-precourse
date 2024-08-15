package shopping.domains.user.core.in;

import lombok.NonNull;
import shopping.domains.user.core.domain.command.SignInCommand;
import shopping.domains.user.core.domain.command.SignUpCommand;
import shopping.domains.user.core.domain.dto.TokenDto;

public interface UserInAdapter {
    @NonNull TokenDto signUp(@NonNull final SignUpCommand signUpCommand);

    @NonNull TokenDto signIn(@NonNull final SignInCommand signInCommand);
}
