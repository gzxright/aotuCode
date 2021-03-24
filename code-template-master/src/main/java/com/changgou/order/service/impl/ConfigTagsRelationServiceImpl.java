package com.changgou.order.service.impl;
import com.changgou.order.dao.ConfigTagsRelationMapper;
import com.changgou.order.pojo.ConfigTagsRelation;
import com.changgou.order.service.ConfigTagsRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigTagsRelation业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConfigTagsRelationServiceImpl implements ConfigTagsRelationService {

    @Autowired
    private ConfigTagsRelationMapper configTagsRelationMapper;


    /**
     * ConfigTagsRelation条件+分页查询
     * @param configTagsRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ConfigTagsRelation> findPage(ConfigTagsRelation configTagsRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(configTagsRelation);
        //执行搜索
        return new PageInfo<ConfigTagsRelation>(configTagsRelationMapper.selectByExample(example));
    }

    /**
     * ConfigTagsRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ConfigTagsRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ConfigTagsRelation>(configTagsRelationMapper.selectAll());
    }

    /**
     * ConfigTagsRelation条件查询
     * @param configTagsRelation
     * @return
     */
    @Override
    public List<ConfigTagsRelation> findList(ConfigTagsRelation configTagsRelation){
        //构建查询条件
        Example example = createExample(configTagsRelation);
        //根据构建的条件查询数据
        return configTagsRelationMapper.selectByExample(example);
    }


    /**
     * ConfigTagsRelation构建查询对象
     * @param configTagsRelation
     * @return
     */
    public Example createExample(ConfigTagsRelation configTagsRelation){
        Example example=new Example(ConfigTagsRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(configTagsRelation!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        configTagsRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ConfigTagsRelation
     * @param configTagsRelation
     */
    @Override
    public void update(ConfigTagsRelation configTagsRelation){
        configTagsRelationMapper.updateByPrimaryKey(configTagsRelation);
    }

    /**
     * 增加ConfigTagsRelation
     * @param configTagsRelation
     */
    @Override
    public void add(ConfigTagsRelation configTagsRelation){
        configTagsRelationMapper.insert(configTagsRelation);
    }

    /**
     * 根据ID查询ConfigTagsRelation
     * @param id
     * @return
     */
    @Override
    public ConfigTagsRelation findById( id){
        return  configTagsRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ConfigTagsRelation全部数据
     * @return
     */
    @Override
    public List<ConfigTagsRelation> findAll() {
        return configTagsRelationMapper.selectAll();
    }
}
