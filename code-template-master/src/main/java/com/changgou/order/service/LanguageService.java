package com.changgou.order.service;
import com.changgou.order.pojo.Language;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Language业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface LanguageService {

    /***
     * Language多条件分页查询
     * @param language
     * @param page
     * @param size
     * @return
     */
    PageInfo<Language> findPage(Language language, int page, int size);

    /***
     * Language分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Language> findPage(int page, int size);

    /***
     * Language多条件搜索方法
     * @param language
     * @return
     */
    List<Language> findList(Language language);

    /***
     * 删除Language
     * @param id
     */
    void delete( id);

    /***
     * 修改Language数据
     * @param language
     */
    void update(Language language);

    /***
     * 新增Language
     * @param language
     */
    void add(Language language);

    /**
     * 根据ID查询Language
     * @param id
     * @return
     */
     Language findById( id);

    /***
     * 查询所有Language
     * @return
     */
    List<Language> findAll();
}
