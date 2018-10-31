package com.fanshuaiko;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


/**
 * @author fanshuaiko
 * @ClassName URLEntity
 * @date 2018年11月1日 上午0：21：10
 * 这是链接dao层
 */
@org.springframework.stereotype.Repository
@Transactional
public interface Repository extends CrudRepository<URLEntity, Integer> {
    /**
     * 根据长链接查询数据库是否存在这条记录
     */
    public URLEntity findByLongURL(String longURL);

    /**
     * 更新访问次数
     * @param longURL
     */
    @Modifying
    @Query("update URLEntity u set u.visitCount = u.visitCount + 1 where u.longURL = ?1")
    public void updateURLEntityByLongURL(String longURL);
}
