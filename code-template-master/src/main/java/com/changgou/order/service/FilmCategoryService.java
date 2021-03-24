package com.changgou.order.service;
import com.changgou.order.pojo.FilmCategory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmCategory业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FilmCategoryService {

    /***
     * FilmCategory多条件分页查询
     * @param filmCategory
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmCategory> findPage(FilmCategory filmCategory, int page, int size);

    /***
     * FilmCategory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmCategory> findPage(int page, int size);

    /***
     * FilmCategory多条件搜索方法
     * @param filmCategory
     * @return
     */
    List<FilmCategory> findList(FilmCategory filmCategory);

    /***
     * 删除FilmCategory
     * @param id
     */
    void delete( id);

    /***
     * 修改FilmCategory数据
     * @param filmCategory
     */
    void update(FilmCategory filmCategory);

    /***
     * 新增FilmCategory
     * @param filmCategory
     */
    void add(FilmCategory filmCategory);

    /**
     * 根据ID查询FilmCategory
     * @param id
     * @return
     */
     FilmCategory findById( id);

    /***
     * 查询所有FilmCategory
     * @return
     */
    List<FilmCategory> findAll();
}
