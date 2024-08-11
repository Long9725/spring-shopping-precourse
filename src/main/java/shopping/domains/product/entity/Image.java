package shopping.domains.product.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public class Image {
    public static final Pattern PATTERN = Pattern.compile("^(http|https):\\/\\/[^\\s]+\\/.*\\.(jpg|jpeg|png|gif|bmp|svg)$");

    private String url;

    public Image(@NonNull final String url) {
        validate(url);

        this.url = url.trim();
    }

    private void validate(@NonNull final String url) {
        if(PATTERN.matcher(url.trim()).matches()) {
            return;
        }
        throw new IllegalArgumentException("잘못된 이미지 경로이거나 지원하지 않는 이미지 형식입니다.");
    }
}
