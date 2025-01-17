package model;

import java.util.Date;

public class Article {

    public int id;
    public String articlename;
    public Date datetime;
    public String author;
    public int authorid;
    public String text;
    public String Image;
    public int likecount;

    public String img;

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articlename='" + articlename + '\'' +
                ", datetime=" + datetime +
                ", author='" + author + '\'' +
                ", authorid=" + authorid +
                ", text='" + text + '\'' +
                ", Image='" + Image + '\'' +
                ", likecount=" + likecount +
                ", img='" + img + '\'' +
                '}';
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

}
