package EdsonAnawayaTests.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Project {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int color;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment_count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String shared;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String favorite;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sync_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String inbox_project;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getSync_id() {
        return sync_id;
    }

    public void setSync_id(String sync_id) {
        this.sync_id = sync_id;
    }

    public String getInbox_project() {
        return inbox_project;
    }

    public void setInbox_project(String inbox_project) {
        this.inbox_project = inbox_project;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
