package api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

@JsonInclude( JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "color",
        "name",
        "comment_count",
        "shared",
        "favorite",
        "sync_id",
        "inbox_project",
        "url"
})
//@JsonIgnoreProperties({ "id", "comment_count", "sync_id", "inbox_project", "url" })
public class Project {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("color")
    private Integer color;
    @JsonProperty("name")
    private String name;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("shared")
    private Boolean shared;
    @JsonProperty("favorite")
    private Boolean favorite;
    @JsonProperty("sync_id")
    private Integer syncId;
    @JsonProperty("inbox_project")
    private Boolean inboxProject;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("color")
    public Integer getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(Integer color) {
        this.color = color;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("shared")
    public Boolean getShared() {
        return shared;
    }

    @JsonProperty("shared")
    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    @JsonProperty("favorite")
    public Boolean getFavorite() {
        return favorite;
    }

    @JsonProperty("favorite")
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @JsonProperty("sync_id")
    public Integer getSyncId() {
        return syncId;
    }

    @JsonProperty("sync_id")
    public void setSyncId(Integer syncId) {
        this.syncId = syncId;
    }

    @JsonProperty("inbox_project")
    public Boolean getInboxProject() {
        return inboxProject;
    }

    @JsonProperty("inbox_project")
    public void setInboxProject(Boolean inboxProject) {
        this.inboxProject = inboxProject;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}