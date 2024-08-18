package shopping.apps.shopping.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.apps.shopping.api.constant.ApiUrls;
import shopping.apps.shopping.api.docs.UserApiDocs;
import shopping.apps.shopping.api.request.RegisterRequest;
import shopping.apps.shopping.api.response.TokenResponse;
import shopping.domains.user.core.domain.dto.TokenDto;
import shopping.domains.user.core.in.adapter.UserInAdapter;

@Tag(name = "user-controller", description = "사용자 컨트롤러")
@RestController
@RequestMapping(ApiUrls.USER_PREFIX)
@RequiredArgsConstructor
public class UserController {
    private final UserInAdapter userInAdapter;

    @Operation(summary = UserApiDocs.Register.SUMMARY, description = UserApiDocs.Register.DESCRIPTION)
    @PostMapping(ApiUrls.USER_REGISTER)
    public ResponseEntity<TokenResponse> register(
            @Valid
            @RequestBody
            final RegisterRequest request
    ) {
        final TokenDto tokenDto = userInAdapter.signUp(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(new TokenResponse(tokenDto));
    }
}
