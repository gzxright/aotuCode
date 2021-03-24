package com.changgou.order.service;
import com.changgou.order.pojo.Country;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Country业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CountryService {

    /***
     * Country多条件分页查询
     * @param country
     * @param page
     * @param size
     * @return
     */
    PageInfo<Country> findPage(Country country, int page, int size);

    /***
     * Country分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Country> findPage(int page, int size);

    /***
     * Country多条件搜索方法
     * @param country
     * @return
     */
    List<Country> findList(Country country);

    /***
     * 删除Country
     * @param id
     */
    void delete( id);

    /***
     * 修改Country数据
     * @param country
     */
    void update(Country country);

    /***
     * 新增Country
     * @param country
     */
    void add(Country country);

    /**
     * 根据ID查询Country
     * @param id
     * @return
     */
     Country findById( id);

    /***
     * 查询所有Country
     * @return
     */
    List<Country> findAll();
}
