package com.changgou.order.service;
import com.changgou.order.pojo.FilmText;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmText业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FilmTextService {

    /***
     * FilmText多条件分页查询
     * @param filmText
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmText> findPage(FilmText filmText, int page, int size);

    /***
     * FilmText分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmText> findPage(int page, int size);

    /***
     * FilmText多条件搜索方法
     * @param filmText
     * @return
     */
    List<FilmText> findList(FilmText filmText);

    /***
     * 删除FilmText
     * @param id
     */
    void delete( id);

    /***
     * 修改FilmText数据
     * @param filmText
     */
    void update(FilmText filmText);

    /***
     * 新增FilmText
     * @param filmText
     */
    void add(FilmText filmText);

    /**
     * 根据ID查询FilmText
     * @param id
     * @return
     */
     FilmText findById( id);

    /***
     * 查询所有FilmText
     * @return
     */
    List<FilmText> findAll();
}
