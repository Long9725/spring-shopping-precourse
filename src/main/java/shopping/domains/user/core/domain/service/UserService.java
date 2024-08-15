package shopping.domains.user.core.domain.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shopping.domains.common.core.domain.entity.ResourceNotFoundException;
import shopping.domains.common.core.domain.enums.CommonErrorCode;
import shopping.domains.user.core.domain.command.SignInCommand;
import shopping.domains.user.core.domain.command.SignUpCommand;
import shopping.domains.user.core.domain.dto.TokenDto;
import shopping.domains.user.core.domain.dto.UserDto;
import shopping.domains.user.core.domain.entity.*;
import shopping.domains.user.core.domain.mapper.TokenMapper;
import shopping.domains.user.core.domain.mapper.UserMapper;
import shopping.domains.user.core.in.UserInAdapter;
import shopping.domains.user.core.out.TokenOutAdapter;
import shopping.domains.user.core.out.UserOutAdapter;

@Service
@Slf4j
public class UserService implements UserInAdapter {
    private final UserOutAdapter userOutAdapter;

    private final TokenOutAdapter tokenOutAdapter;

    private final UserMapper userMapper;

    private final TokenMapper tokenMapper;

    private final EncryptStrategy encryptStrategy;

    private final HashStrategy hashStrategy;

    private final TokenGenerator accessTokenGenerator;

    private final TokenGenerator refreshTokenGenerator;

    public UserService(
            @NonNull final UserOutAdapter userOutAdapter,
            @NonNull final TokenOutAdapter tokenOutAdapter,
            @NonNull final UserMapper userMapper,
            @NonNull final TokenMapper tokenMapper,
            @NonNull final EncryptStrategy encryptStrategy,
            @NonNull final HashStrategy hashStrategy,
            @Qualifier("accessTokenGenerator") @NonNull final TokenGenerator accessTokenGenerator,
            @Qualifier("refreshTokenGenerator") @NonNull final TokenGenerator refreshTokenGenerator
    ) {
        this.userOutAdapter = userOutAdapter;
        this.tokenOutAdapter = tokenOutAdapter;
        this.userMapper = userMapper;
        this.tokenMapper = tokenMapper;
        this.encryptStrategy = encryptStrategy;
        this.hashStrategy = hashStrategy;
        this.accessTokenGenerator = accessTokenGenerator;
        this.refreshTokenGenerator = refreshTokenGenerator;
    }

    @Override
    public @NonNull TokenDto signUp(@NonNull final SignUpCommand signUpCommand) {
        final RawPassword rawPassword = new RawPassword(signUpCommand.rawPassword());
        final EncryptedEmail encryptedEmail = EncryptedEmail.encryptBuilder()
                .rawEmail(new RawEmail(signUpCommand.rawEmail()))
                .encryptStrategy(encryptStrategy)
                .build();
        final EncryptedPassword encryptedPassword = EncryptedPassword.encryptBuilder()
                .rawPassword(rawPassword)
                .hashStrategy(hashStrategy)
                .build();
        final User user = User.builder()
                .encryptedEmail(encryptedEmail)
                .encryptedPassword(encryptedPassword)
                .build();
        final UserDto savedUserDto = userOutAdapter.save(userMapper.entityToDto(user));
        return saveToken(savedUserDto, user, rawPassword);
    }

    @Override
    public @NonNull TokenDto signIn(@NonNull final SignInCommand signInCommand) {
        final UserDto userDto = userOutAdapter.findUser(encryptStrategy.encrypt(signInCommand.rawEmail()))
                .orElseThrow(() -> new ResourceNotFoundException(CommonErrorCode.NOT_EXIST));
        final User user = UserMapper.INSTANCE.dtoToEntity(userDto);
        return saveToken(userDto, user, new RawPassword(signInCommand.rawPassword()));
    }

    @NonNull
    private TokenDto saveToken(
            @NonNull final UserDto userDto,
            @NonNull final User user,
            @NonNull final RawPassword rawPassword
    ) {
        final AuthToken authToken = AuthToken.builder()
                .accessToken(accessTokenGenerator.createToken(userDto.getId()))
                .refreshToken(refreshTokenGenerator.createToken(userDto.getId()))
                .build();
        final AuthToken validAuthToken = user.signIn(rawPassword, hashStrategy, authToken);
        return tokenOutAdapter.save(tokenMapper.entityToDto(validAuthToken));
    }
}
