package org.example;

public class AudioItem {
    private String id;
    private String title;
    private String author;
    private String img;
    private String videoUrl;

    public AudioItem() {}

    public AudioItem(String id, String title, String author, String img, String videoUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.img = img;
        this.videoUrl = videoUrl;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
}