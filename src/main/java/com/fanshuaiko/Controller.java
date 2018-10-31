package com.fanshuaiko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.Random;
/**
 * @ClassName URLEntity
 * @author fanshuaiko
 * @date 2018年11月1日 上午0：20：40
 * 这是链接Controller层
 */
@RestController
@RequestMapping("/LongToShortController")
public class Controller {
    @Autowired
    private Repository repository;

    /**
     * 实现长链接转换为短链接的主方法
     * @param urlEntity
     * @return
     */
    @RequestMapping("/LongToShort")
    public URLEntity LongToShort(@RequestBody URLEntity urlEntity) {
        //先判断输入的长链接是否在数据库中已经存在
        URLEntity exits = repository.findByLongURL(urlEntity.getLongURL());
        //若存在返回链接实体类
        if (exits != null) {
            return exits;
        } else {
            //若没有输入要创建的短链接的长度，则默认创建长度为4个字符（不包含https://）
            if (urlEntity.getShortURLLength() < 1) {
                urlEntity = createShortURL(4, urlEntity);

            } else {
                //根据输入长度创建短链接
                urlEntity = createShortURL(urlEntity.getShortURLLength(), urlEntity);
            }
        }
        return urlEntity;
    }

    /**
     * 创建指定长度和字符集的短链接
     * @param length 长度
     * @param urlEntity 链接实体
     * @return URLEntity 链接实体
     */
    public URLEntity createShortURL(int length, URLEntity urlEntity) {
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D",
                "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
        StringBuffer shortURL = new StringBuffer("https://");
        for (int i = 0; i < length; i++) {
            shortURL.append(str[new Random().nextInt(62)]);//根据输入的长度创建短链接
        }
        try {
            //根据字符集创建短链接
            urlEntity.setShortURL(new String(shortURL.toString().getBytes(), urlEntity.getShortURLEncode()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //将链接实体持久化到数据库
        repository.save(urlEntity);
        return urlEntity;
    }

    /**
     * 重定向到长链接页面并且更新访问次数
     * @param urlEntity
     * @return
     */
    @RequestMapping("/redirectToLongURL")
    public ModelAndView redirectToLongURL(@RequestBody URLEntity urlEntity) {
        //更新访问次数
        repository.updateURLEntityByLongURL(urlEntity.getLongURL());
        return new ModelAndView("redirect:" + urlEntity.getLongURL());
    }

    /**
     * 自己创建短链接保存到数据库
     * @param urlEntity
     * @return
     */
    @RequestMapping("/saveShortURL")
    public URLEntity saveShortURL(@RequestBody URLEntity urlEntity){
        URLEntity exits = repository.findByLongURL(urlEntity.getLongURL());
        if(exits==null){
            URLEntity re = repository.save(urlEntity);
            return re;
        }
        return exits;
    }
}
