package shopping.domains.user.out.jpa.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import shopping.domains.user.core.domain.entity.EncryptedEmail;
import shopping.domains.user.core.domain.entity.EncryptedPassword;

@Converter(autoApply = true)
public class EncryptedPasswordConverter implements AttributeConverter<EncryptedPassword, String> {
    @Override
    public String convertToDatabaseColumn(final EncryptedPassword attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public EncryptedPassword convertToEntityAttribute(final String dbData) {
        return dbData != null ? new EncryptedPassword(dbData) : null;
    }
}