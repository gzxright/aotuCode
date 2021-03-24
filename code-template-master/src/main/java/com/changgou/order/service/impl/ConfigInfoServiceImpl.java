package com.changgou.order.service.impl;
import com.changgou.order.dao.ConfigInfoMapper;
import com.changgou.order.pojo.ConfigInfo;
import com.changgou.order.service.ConfigInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConfigInfoServiceImpl implements ConfigInfoService {

    @Autowired
    private ConfigInfoMapper configInfoMapper;


    /**
     * ConfigInfo条件+分页查询
     * @param configInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ConfigInfo> findPage(ConfigInfo configInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(configInfo);
        //执行搜索
        return new PageInfo<ConfigInfo>(configInfoMapper.selectByExample(example));
    }

    /**
     * ConfigInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ConfigInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ConfigInfo>(configInfoMapper.selectAll());
    }

    /**
     * ConfigInfo条件查询
     * @param configInfo
     * @return
     */
    @Override
    public List<ConfigInfo> findList(ConfigInfo configInfo){
        //构建查询条件
        Example example = createExample(configInfo);
        //根据构建的条件查询数据
        return configInfoMapper.selectByExample(example);
    }


    /**
     * ConfigInfo构建查询对象
     * @param configInfo
     * @return
     */
    public Example createExample(ConfigInfo configInfo){
        Example example=new Example(ConfigInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(configInfo!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        configInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ConfigInfo
     * @param configInfo
     */
    @Override
    public void update(ConfigInfo configInfo){
        configInfoMapper.updateByPrimaryKey(configInfo);
    }

    /**
     * 增加ConfigInfo
     * @param configInfo
     */
    @Override
    public void add(ConfigInfo configInfo){
        configInfoMapper.insert(configInfo);
    }

    /**
     * 根据ID查询ConfigInfo
     * @param id
     * @return
     */
    @Override
    public ConfigInfo findById( id){
        return  configInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ConfigInfo全部数据
     * @return
     */
    @Override
    public List<ConfigInfo> findAll() {
        return configInfoMapper.selectAll();
    }
}
