package shopping.apps.shopping.api.constant;

import lombok.NonNull;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ApiUrls {
    public static String API_PREFIX;

    public static final String SWAGGER_API_DOCS = "/v3/api-docs/**";

    public static final String SWAGGER_UI = "/swagger-ui/**";

    public static final String SWAGGER_RESOURCES =   "/swagger-resources/**";

    public static final String ACTUATOR =   "/actuator/**";

    public static final String USER_PREFIX = "/members";

    public static final String USER_REGISTER = "/register";

    public static final String USER_LOGIN = "/login";

    public static final String PRODUCT_PREFIX = "/products";

    public static final String GET_PRODUCT_INFO = "/{productId}";

    public static final String GET_ALL_PRODUCT_INFO = "";

    public static final String CREATE_PRODUCT = "";

    public static final String UPDATE_PRODUCT = "";

    public static final String DELETE_PRODUCT = "/{productId}";

    public static final String WISHLIST_PREFIX = "/wishes";

    public static final String CREATE_WISHLIST = "";

    public static final String DELETE_WISHLIST = "/{wishId}";

    public static final String GET_ALL_WISHLIST_INFO = "";

    static {
        final Yaml yaml = new Yaml();
        try (final InputStream in = ApiUrls.class.getClassLoader().getResourceAsStream("application.yaml")) {
            if (in == null) {
                throw new RuntimeException("application.yaml not found");
            }

            handleProperty(yaml.load(in));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load application.yaml", e);
        }
    }

    private static void handleProperty(@NonNull final Map<String, Object> property) {
        final Map<String, Object> server = (Map<String, Object>) property.get("server");
        final Map<String, Object> servlet = (Map<String, Object>) server.get("servlet");

        API_PREFIX = (String) servlet.get("context-path");
    }
}
