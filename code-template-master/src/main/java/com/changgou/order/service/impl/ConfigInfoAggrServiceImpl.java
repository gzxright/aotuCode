package com.changgou.order.service.impl;
import com.changgou.order.dao.ConfigInfoAggrMapper;
import com.changgou.order.pojo.ConfigInfoAggr;
import com.changgou.order.service.ConfigInfoAggrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoAggr业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConfigInfoAggrServiceImpl implements ConfigInfoAggrService {

    @Autowired
    private ConfigInfoAggrMapper configInfoAggrMapper;


    /**
     * ConfigInfoAggr条件+分页查询
     * @param configInfoAggr 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ConfigInfoAggr> findPage(ConfigInfoAggr configInfoAggr, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(configInfoAggr);
        //执行搜索
        return new PageInfo<ConfigInfoAggr>(configInfoAggrMapper.selectByExample(example));
    }

    /**
     * ConfigInfoAggr分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ConfigInfoAggr> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ConfigInfoAggr>(configInfoAggrMapper.selectAll());
    }

    /**
     * ConfigInfoAggr条件查询
     * @param configInfoAggr
     * @return
     */
    @Override
    public List<ConfigInfoAggr> findList(ConfigInfoAggr configInfoAggr){
        //构建查询条件
        Example example = createExample(configInfoAggr);
        //根据构建的条件查询数据
        return configInfoAggrMapper.selectByExample(example);
    }


    /**
     * ConfigInfoAggr构建查询对象
     * @param configInfoAggr
     * @return
     */
    public Example createExample(ConfigInfoAggr configInfoAggr){
        Example example=new Example(ConfigInfoAggr.class);
        Example.Criteria criteria = example.createCriteria();
        if(configInfoAggr!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        configInfoAggrMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ConfigInfoAggr
     * @param configInfoAggr
     */
    @Override
    public void update(ConfigInfoAggr configInfoAggr){
        configInfoAggrMapper.updateByPrimaryKey(configInfoAggr);
    }

    /**
     * 增加ConfigInfoAggr
     * @param configInfoAggr
     */
    @Override
    public void add(ConfigInfoAggr configInfoAggr){
        configInfoAggrMapper.insert(configInfoAggr);
    }

    /**
     * 根据ID查询ConfigInfoAggr
     * @param id
     * @return
     */
    @Override
    public ConfigInfoAggr findById( id){
        return  configInfoAggrMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ConfigInfoAggr全部数据
     * @return
     */
    @Override
    public List<ConfigInfoAggr> findAll() {
        return configInfoAggrMapper.selectAll();
    }
}
