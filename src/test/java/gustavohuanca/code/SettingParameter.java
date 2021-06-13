package gustavohuanca.code;

import io.restassured.http.ContentType;

public class SettingParameter {
    private String baseURL;
    private String basePath;
    private ContentType contentType;
    private String headersKeysAndValues;

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

    public String getHeadersKeysAndValues() {
        return headersKeysAndValues;
    }

    public void setHeadersKeysAndValues(String headersKeysAndValues) {
        this.headersKeysAndValues = headersKeysAndValues;
    }
}
