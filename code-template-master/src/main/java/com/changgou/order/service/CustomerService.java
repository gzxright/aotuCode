package com.changgou.order.service;
import com.changgou.order.pojo.Customer;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Customer业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CustomerService {

    /***
     * Customer多条件分页查询
     * @param customer
     * @param page
     * @param size
     * @return
     */
    PageInfo<Customer> findPage(Customer customer, int page, int size);

    /***
     * Customer分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Customer> findPage(int page, int size);

    /***
     * Customer多条件搜索方法
     * @param customer
     * @return
     */
    List<Customer> findList(Customer customer);

    /***
     * 删除Customer
     * @param id
     */
    void delete( id);

    /***
     * 修改Customer数据
     * @param customer
     */
    void update(Customer customer);

    /***
     * 新增Customer
     * @param customer
     */
    void add(Customer customer);

    /**
     * 根据ID查询Customer
     * @param id
     * @return
     */
     Customer findById( id);

    /***
     * 查询所有Customer
     * @return
     */
    List<Customer> findAll();
}
