package com.changgou.order.service.impl;
import com.changgou.order.dao.ConfigInfoBetaMapper;
import com.changgou.order.pojo.ConfigInfoBeta;
import com.changgou.order.service.ConfigInfoBetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoBeta业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConfigInfoBetaServiceImpl implements ConfigInfoBetaService {

    @Autowired
    private ConfigInfoBetaMapper configInfoBetaMapper;


    /**
     * ConfigInfoBeta条件+分页查询
     * @param configInfoBeta 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ConfigInfoBeta> findPage(ConfigInfoBeta configInfoBeta, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(configInfoBeta);
        //执行搜索
        return new PageInfo<ConfigInfoBeta>(configInfoBetaMapper.selectByExample(example));
    }

    /**
     * ConfigInfoBeta分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ConfigInfoBeta> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ConfigInfoBeta>(configInfoBetaMapper.selectAll());
    }

    /**
     * ConfigInfoBeta条件查询
     * @param configInfoBeta
     * @return
     */
    @Override
    public List<ConfigInfoBeta> findList(ConfigInfoBeta configInfoBeta){
        //构建查询条件
        Example example = createExample(configInfoBeta);
        //根据构建的条件查询数据
        return configInfoBetaMapper.selectByExample(example);
    }


    /**
     * ConfigInfoBeta构建查询对象
     * @param configInfoBeta
     * @return
     */
    public Example createExample(ConfigInfoBeta configInfoBeta){
        Example example=new Example(ConfigInfoBeta.class);
        Example.Criteria criteria = example.createCriteria();
        if(configInfoBeta!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        configInfoBetaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ConfigInfoBeta
     * @param configInfoBeta
     */
    @Override
    public void update(ConfigInfoBeta configInfoBeta){
        configInfoBetaMapper.updateByPrimaryKey(configInfoBeta);
    }

    /**
     * 增加ConfigInfoBeta
     * @param configInfoBeta
     */
    @Override
    public void add(ConfigInfoBeta configInfoBeta){
        configInfoBetaMapper.insert(configInfoBeta);
    }

    /**
     * 根据ID查询ConfigInfoBeta
     * @param id
     * @return
     */
    @Override
    public ConfigInfoBeta findById( id){
        return  configInfoBetaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ConfigInfoBeta全部数据
     * @return
     */
    @Override
    public List<ConfigInfoBeta> findAll() {
        return configInfoBetaMapper.selectAll();
    }
}
