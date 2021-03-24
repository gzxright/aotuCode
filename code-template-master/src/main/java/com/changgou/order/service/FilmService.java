package com.changgou.order.service;
import com.changgou.order.pojo.Film;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Film业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FilmService {

    /***
     * Film多条件分页查询
     * @param film
     * @param page
     * @param size
     * @return
     */
    PageInfo<Film> findPage(Film film, int page, int size);

    /***
     * Film分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Film> findPage(int page, int size);

    /***
     * Film多条件搜索方法
     * @param film
     * @return
     */
    List<Film> findList(Film film);

    /***
     * 删除Film
     * @param id
     */
    void delete( id);

    /***
     * 修改Film数据
     * @param film
     */
    void update(Film film);

    /***
     * 新增Film
     * @param film
     */
    void add(Film film);

    /**
     * 根据ID查询Film
     * @param id
     * @return
     */
     Film findById( id);

    /***
     * 查询所有Film
     * @return
     */
    List<Film> findAll();
}
