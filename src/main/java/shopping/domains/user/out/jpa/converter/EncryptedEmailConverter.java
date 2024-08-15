package shopping.domains.user.out.jpa.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import shopping.domains.user.core.domain.entity.EncryptedEmail;

@Converter(autoApply = true)
public class EncryptedEmailConverter implements AttributeConverter<EncryptedEmail, String> {
    @Override
    public String convertToDatabaseColumn(final EncryptedEmail attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public EncryptedEmail convertToEntityAttribute(final String dbData) {
        return dbData != null ? new EncryptedEmail(dbData) : null;
    }
}