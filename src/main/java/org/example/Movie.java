package org.example;

public class Movie {
    private String id;
    private String title;
    private String tag;
    private String episodes;
    private String year;
    private String rate;
    private String img;
    private String videoUrl;
    private String desc;

    public Movie() {}

    public Movie(String id, String title, String tag, String episodes, String year, String rate, String img, String videoUrl, String desc) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.episodes = episodes;
        this.year = year;
        this.rate = rate;
        this.img = img;
        this.videoUrl = videoUrl;
        this.desc = desc;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getEpisodes() { return episodes; }
    public void setEpisodes(String episodes) { this.episodes = episodes; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}