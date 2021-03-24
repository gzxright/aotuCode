package com.changgou.order.service;
import com.changgou.order.pojo.FilmActor;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmActor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FilmActorService {

    /***
     * FilmActor多条件分页查询
     * @param filmActor
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmActor> findPage(FilmActor filmActor, int page, int size);

    /***
     * FilmActor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FilmActor> findPage(int page, int size);

    /***
     * FilmActor多条件搜索方法
     * @param filmActor
     * @return
     */
    List<FilmActor> findList(FilmActor filmActor);

    /***
     * 删除FilmActor
     * @param id
     */
    void delete( id);

    /***
     * 修改FilmActor数据
     * @param filmActor
     */
    void update(FilmActor filmActor);

    /***
     * 新增FilmActor
     * @param filmActor
     */
    void add(FilmActor filmActor);

    /**
     * 根据ID查询FilmActor
     * @param id
     * @return
     */
     FilmActor findById( id);

    /***
     * 查询所有FilmActor
     * @return
     */
    List<FilmActor> findAll();
}
