package com.changgou.order.service;
import com.changgou.order.pojo.BrokerMessageLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:BrokerMessageLog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BrokerMessageLogService {

    /***
     * BrokerMessageLog多条件分页查询
     * @param brokerMessageLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<BrokerMessageLog> findPage(BrokerMessageLog brokerMessageLog, int page, int size);

    /***
     * BrokerMessageLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<BrokerMessageLog> findPage(int page, int size);

    /***
     * BrokerMessageLog多条件搜索方法
     * @param brokerMessageLog
     * @return
     */
    List<BrokerMessageLog> findList(BrokerMessageLog brokerMessageLog);

    /***
     * 删除BrokerMessageLog
     * @param id
     */
    void delete( id);

    /***
     * 修改BrokerMessageLog数据
     * @param brokerMessageLog
     */
    void update(BrokerMessageLog brokerMessageLog);

    /***
     * 新增BrokerMessageLog
     * @param brokerMessageLog
     */
    void add(BrokerMessageLog brokerMessageLog);

    /**
     * 根据ID查询BrokerMessageLog
     * @param id
     * @return
     */
     BrokerMessageLog findById( id);

    /***
     * 查询所有BrokerMessageLog
     * @return
     */
    List<BrokerMessageLog> findAll();
}
