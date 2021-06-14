package JorgeCaceres.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","order", "color","name","comment_count","shared","favorite","sync_id","inbox_project","url"})
public class JsonProjectBody {
    private String id;
    private int order;
    private int color;
    private String name;
    private int comment_count;
    private String shared;
    private String favorite;
    private int sync_id;
    private String inbox_project;
    private String url;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public JsonProjectBody() {

    }

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

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
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

    public int getSync_id() {
        return sync_id;
    }

    public void setSync_id(int sync_id) {
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
