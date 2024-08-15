package shopping.apps.shopping.security.config;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import shopping.domains.user.entity.EncryptStrategy;
import shopping.domains.user.entity.HashStrategy;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Configuration
public class SecurityConfig {
    @Value("${encrypt.aes.secret}")
    private String aesSecret;

    @Value("${encrypt.aes.salt}")
    private String aesSalt;

    @Bean
    public AesBytesEncryptor aesBytesEncryptor() {
        return new AesBytesEncryptor(aesSecret, aesSalt);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
