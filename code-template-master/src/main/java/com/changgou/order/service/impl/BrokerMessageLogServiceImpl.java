package com.changgou.order.service.impl;
import com.changgou.order.dao.BrokerMessageLogMapper;
import com.changgou.order.pojo.BrokerMessageLog;
import com.changgou.order.service.BrokerMessageLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:BrokerMessageLog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BrokerMessageLogServiceImpl implements BrokerMessageLogService {

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;


    /**
     * BrokerMessageLog条件+分页查询
     * @param brokerMessageLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<BrokerMessageLog> findPage(BrokerMessageLog brokerMessageLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brokerMessageLog);
        //执行搜索
        return new PageInfo<BrokerMessageLog>(brokerMessageLogMapper.selectByExample(example));
    }

    /**
     * BrokerMessageLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<BrokerMessageLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<BrokerMessageLog>(brokerMessageLogMapper.selectAll());
    }

    /**
     * BrokerMessageLog条件查询
     * @param brokerMessageLog
     * @return
     */
    @Override
    public List<BrokerMessageLog> findList(BrokerMessageLog brokerMessageLog){
        //构建查询条件
        Example example = createExample(brokerMessageLog);
        //根据构建的条件查询数据
        return brokerMessageLogMapper.selectByExample(example);
    }


    /**
     * BrokerMessageLog构建查询对象
     * @param brokerMessageLog
     * @return
     */
    public Example createExample(BrokerMessageLog brokerMessageLog){
        Example example=new Example(BrokerMessageLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(brokerMessageLog!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        brokerMessageLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改BrokerMessageLog
     * @param brokerMessageLog
     */
    @Override
    public void update(BrokerMessageLog brokerMessageLog){
        brokerMessageLogMapper.updateByPrimaryKey(brokerMessageLog);
    }

    /**
     * 增加BrokerMessageLog
     * @param brokerMessageLog
     */
    @Override
    public void add(BrokerMessageLog brokerMessageLog){
        brokerMessageLogMapper.insert(brokerMessageLog);
    }

    /**
     * 根据ID查询BrokerMessageLog
     * @param id
     * @return
     */
    @Override
    public BrokerMessageLog findById( id){
        return  brokerMessageLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询BrokerMessageLog全部数据
     * @return
     */
    @Override
    public List<BrokerMessageLog> findAll() {
        return brokerMessageLogMapper.selectAll();
    }
}
