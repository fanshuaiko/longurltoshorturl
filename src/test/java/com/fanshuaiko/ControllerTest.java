package com.fanshuaiko;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 测试用例
 * 前端页面也有jQuery对输入的合法性进行校验
 */
public class ControllerTest {
    @Autowired
    private Controller controller;

    URLEntity urlEntity = new URLEntity();

    /**
     * 随机生成模式：
     * 什么都不输入
     */
    @Test
    public void longToShort() {
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     * 随机生成模式：
     *输入正确的长链接和选择UTF-8字符集，输入短链接长度为5
     */
    @Test
    public void longToShort2() {
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(5);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     * 随机生成模式：
     *输入短链接长度为0
     */
    @Test
    public void longToShort3(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(0);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     * 随机生成模式：
     *输入短链接长度为9999999
     */
    @Test
    public void longToShort4(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(999999999);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *输入非法的长链接
     */
    @Test
    public void longToShort5(){
        urlEntity.setLongURL("dfgfgsdg");
        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(5);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *
     * 随机生成模式：
     *不选择字符集
     */
    @Test
    public void longToShort6(){
        urlEntity.setLongURL("http://www.baidu.com");
//        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(5);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     * 随机生成模式：
     * 输入数据库已有的长链接
     */
    @Test
    public void longToShort7(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURLEncode("UTF-8");
        urlEntity.setShortURLLength(5);
        URLEntity result = controller.LongToShort(urlEntity);
        System.out.println(result.getShortURL());
    }
    /**
     *自定义短链接模式
     * 长链接和短链接都输入正确的网址
     */
    @Test
    public void longToShort8(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURL("https://sdfsa2");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *自定义短链接模式
     * 长链接输入不正确的网址，短链接输入正确
     */
    @Test
    public void longToShort9(){
        urlEntity.setLongURL("sddddddddddd");
        urlEntity.setShortURL("https://sdfsa2");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *自定义短链接模式
     * 长链接输入正确，短链接输入非法的网址
     */
    @Test
    public void longToShort10(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURL("////////sdfsa2");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *自定义短链接模式
     * 输入数据库已有的长链接和短链接
     */
    @Test
    public void longToShort11(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURL("http://sdfsa2");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *自定义短链接模式
     * 输入数据库已有的长链接和没有的短链接
     */
    @Test
    public void longToShort12(){
        urlEntity.setLongURL("http://www.baidu.com");
        urlEntity.setShortURL("http://dd456");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }

    /**
     *自定义短链接模式
     * 输入数据库没有的长链接，输入数据库已有的短链接
     */
    @Test
    public void longToShort13(){
        urlEntity.setLongURL("http://www.wangyi.com");
        urlEntity.setShortURL("http://sdfsa2");
        URLEntity result = controller.saveShortURL(urlEntity);
        System.out.println(result.getShortURL());
    }
}