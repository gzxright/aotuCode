package com.changgou.order.service;
import com.changgou.order.pojo.ConfigTagsRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigTagsRelation业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConfigTagsRelationService {

    /***
     * ConfigTagsRelation多条件分页查询
     * @param configTagsRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigTagsRelation> findPage(ConfigTagsRelation configTagsRelation, int page, int size);

    /***
     * ConfigTagsRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigTagsRelation> findPage(int page, int size);

    /***
     * ConfigTagsRelation多条件搜索方法
     * @param configTagsRelation
     * @return
     */
    List<ConfigTagsRelation> findList(ConfigTagsRelation configTagsRelation);

    /***
     * 删除ConfigTagsRelation
     * @param id
     */
    void delete( id);

    /***
     * 修改ConfigTagsRelation数据
     * @param configTagsRelation
     */
    void update(ConfigTagsRelation configTagsRelation);

    /***
     * 新增ConfigTagsRelation
     * @param configTagsRelation
     */
    void add(ConfigTagsRelation configTagsRelation);

    /**
     * 根据ID查询ConfigTagsRelation
     * @param id
     * @return
     */
     ConfigTagsRelation findById( id);

    /***
     * 查询所有ConfigTagsRelation
     * @return
     */
    List<ConfigTagsRelation> findAll();
}
