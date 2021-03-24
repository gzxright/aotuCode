package com.changgou.order.service.impl;
import com.changgou.order.dao.TOrderMapper;
import com.changgou.order.pojo.TOrder;
import com.changgou.order.service.TOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TOrder业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TOrderServiceImpl implements TOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;


    /**
     * TOrder条件+分页查询
     * @param tOrder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TOrder> findPage(TOrder tOrder, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(tOrder);
        //执行搜索
        return new PageInfo<TOrder>(tOrderMapper.selectByExample(example));
    }

    /**
     * TOrder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TOrder> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TOrder>(tOrderMapper.selectAll());
    }

    /**
     * TOrder条件查询
     * @param tOrder
     * @return
     */
    @Override
    public List<TOrder> findList(TOrder tOrder){
        //构建查询条件
        Example example = createExample(tOrder);
        //根据构建的条件查询数据
        return tOrderMapper.selectByExample(example);
    }


    /**
     * TOrder构建查询对象
     * @param tOrder
     * @return
     */
    public Example createExample(TOrder tOrder){
        Example example=new Example(TOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if(tOrder!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        tOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TOrder
     * @param tOrder
     */
    @Override
    public void update(TOrder tOrder){
        tOrderMapper.updateByPrimaryKey(tOrder);
    }

    /**
     * 增加TOrder
     * @param tOrder
     */
    @Override
    public void add(TOrder tOrder){
        tOrderMapper.insert(tOrder);
    }

    /**
     * 根据ID查询TOrder
     * @param id
     * @return
     */
    @Override
    public TOrder findById( id){
        return  tOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TOrder全部数据
     * @return
     */
    @Override
    public List<TOrder> findAll() {
        return tOrderMapper.selectAll();
    }
}
