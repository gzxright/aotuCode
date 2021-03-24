package com.changgou.order.service;
import com.changgou.order.pojo.TOrder;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TOrder业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TOrderService {

    /***
     * TOrder多条件分页查询
     * @param tOrder
     * @param page
     * @param size
     * @return
     */
    PageInfo<TOrder> findPage(TOrder tOrder, int page, int size);

    /***
     * TOrder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<TOrder> findPage(int page, int size);

    /***
     * TOrder多条件搜索方法
     * @param tOrder
     * @return
     */
    List<TOrder> findList(TOrder tOrder);

    /***
     * 删除TOrder
     * @param id
     */
    void delete( id);

    /***
     * 修改TOrder数据
     * @param tOrder
     */
    void update(TOrder tOrder);

    /***
     * 新增TOrder
     * @param tOrder
     */
    void add(TOrder tOrder);

    /**
     * 根据ID查询TOrder
     * @param id
     * @return
     */
     TOrder findById( id);

    /***
     * 查询所有TOrder
     * @return
     */
    List<TOrder> findAll();
}
