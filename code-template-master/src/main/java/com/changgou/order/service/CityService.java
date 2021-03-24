package com.changgou.order.service;
import com.changgou.order.pojo.City;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:City业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CityService {

    /***
     * City多条件分页查询
     * @param city
     * @param page
     * @param size
     * @return
     */
    PageInfo<City> findPage(City city, int page, int size);

    /***
     * City分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<City> findPage(int page, int size);

    /***
     * City多条件搜索方法
     * @param city
     * @return
     */
    List<City> findList(City city);

    /***
     * 删除City
     * @param id
     */
    void delete( id);

    /***
     * 修改City数据
     * @param city
     */
    void update(City city);

    /***
     * 新增City
     * @param city
     */
    void add(City city);

    /**
     * 根据ID查询City
     * @param id
     * @return
     */
     City findById( id);

    /***
     * 查询所有City
     * @return
     */
    List<City> findAll();
}
