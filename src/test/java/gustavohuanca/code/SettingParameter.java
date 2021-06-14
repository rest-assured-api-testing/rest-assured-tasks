package gustavohuanca.code;

import io.restassured.http.ContentType;

public class SettingParameter {
    private String baseURL;
    private String basePath;
    private ContentType contentType;
    private String headersKeysAndValues;
    private static String tokenValue;
    private static String tokenKey;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public static String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        SettingParameter.tokenValue = tokenValue;
    }

    public void setTokenKey(String tokenKey) {
        SettingParameter.tokenKey = tokenKey;
    }

    public static String getTokenKey() {
        return tokenKey;
    }

    public String getHeadersKeysAndValues() {
        return headersKeysAndValues;
    }

    public void setHeadersKeysAndValues(String headersKeysAndValues) {
        this.headersKeysAndValues = headersKeysAndValues;
    }
}
