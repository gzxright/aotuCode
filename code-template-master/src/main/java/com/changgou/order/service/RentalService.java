package com.changgou.order.service;
import com.changgou.order.pojo.Rental;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Rental业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RentalService {

    /***
     * Rental多条件分页查询
     * @param rental
     * @param page
     * @param size
     * @return
     */
    PageInfo<Rental> findPage(Rental rental, int page, int size);

    /***
     * Rental分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Rental> findPage(int page, int size);

    /***
     * Rental多条件搜索方法
     * @param rental
     * @return
     */
    List<Rental> findList(Rental rental);

    /***
     * 删除Rental
     * @param id
     */
    void delete( id);

    /***
     * 修改Rental数据
     * @param rental
     */
    void update(Rental rental);

    /***
     * 新增Rental
     * @param rental
     */
    void add(Rental rental);

    /**
     * 根据ID查询Rental
     * @param id
     * @return
     */
     Rental findById( id);

    /***
     * 查询所有Rental
     * @return
     */
    List<Rental> findAll();
}
