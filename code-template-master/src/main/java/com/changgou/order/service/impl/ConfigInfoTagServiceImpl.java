package com.changgou.order.service.impl;
import com.changgou.order.dao.ConfigInfoTagMapper;
import com.changgou.order.pojo.ConfigInfoTag;
import com.changgou.order.service.ConfigInfoTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoTag业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConfigInfoTagServiceImpl implements ConfigInfoTagService {

    @Autowired
    private ConfigInfoTagMapper configInfoTagMapper;


    /**
     * ConfigInfoTag条件+分页查询
     * @param configInfoTag 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ConfigInfoTag> findPage(ConfigInfoTag configInfoTag, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(configInfoTag);
        //执行搜索
        return new PageInfo<ConfigInfoTag>(configInfoTagMapper.selectByExample(example));
    }

    /**
     * ConfigInfoTag分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ConfigInfoTag> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ConfigInfoTag>(configInfoTagMapper.selectAll());
    }

    /**
     * ConfigInfoTag条件查询
     * @param configInfoTag
     * @return
     */
    @Override
    public List<ConfigInfoTag> findList(ConfigInfoTag configInfoTag){
        //构建查询条件
        Example example = createExample(configInfoTag);
        //根据构建的条件查询数据
        return configInfoTagMapper.selectByExample(example);
    }


    /**
     * ConfigInfoTag构建查询对象
     * @param configInfoTag
     * @return
     */
    public Example createExample(ConfigInfoTag configInfoTag){
        Example example=new Example(ConfigInfoTag.class);
        Example.Criteria criteria = example.createCriteria();
        if(configInfoTag!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        configInfoTagMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ConfigInfoTag
     * @param configInfoTag
     */
    @Override
    public void update(ConfigInfoTag configInfoTag){
        configInfoTagMapper.updateByPrimaryKey(configInfoTag);
    }

    /**
     * 增加ConfigInfoTag
     * @param configInfoTag
     */
    @Override
    public void add(ConfigInfoTag configInfoTag){
        configInfoTagMapper.insert(configInfoTag);
    }

    /**
     * 根据ID查询ConfigInfoTag
     * @param id
     * @return
     */
    @Override
    public ConfigInfoTag findById( id){
        return  configInfoTagMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ConfigInfoTag全部数据
     * @return
     */
    @Override
    public List<ConfigInfoTag> findAll() {
        return configInfoTagMapper.selectAll();
    }
}
