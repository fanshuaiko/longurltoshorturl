package com.fanshuaiko;

import javax.persistence.*;

/**
 * @ClassName URLEntity
 * @author fanshuaiko
 * @date 2018年11月1日 上午0：20：10
 * 这是链接实体类
 */
@Entity
@Table(name = "URLEntity")
public class URLEntity {
   private Integer id;//id

    private String longURL;//长链接

    private String shortURL;//短链接

    private String shortURLEncode;//短链接的字符集

    private int shortURLLength;//短链接的长度

    private int visitCount;//访问次数
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getShortURLEncode() {
        return shortURLEncode;
    }

    public void setShortURLEncode(String shortURLEncode) {
        this.shortURLEncode = shortURLEncode;
    }

    public int getShortURLLength() {
        return shortURLLength;
    }

    public void setShortURLLength(int shortURLLength) {
        this.shortURLLength = shortURLLength;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
