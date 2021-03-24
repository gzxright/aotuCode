package com.changgou.order.service.impl;
import com.changgou.order.dao.SysConfigMapper;
import com.changgou.order.pojo.SysConfig;
import com.changgou.order.service.SysConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysConfig业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;


    /**
     * SysConfig条件+分页查询
     * @param sysConfig 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysConfig> findPage(SysConfig sysConfig, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysConfig);
        //执行搜索
        return new PageInfo<SysConfig>(sysConfigMapper.selectByExample(example));
    }

    /**
     * SysConfig分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysConfig> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysConfig>(sysConfigMapper.selectAll());
    }

    /**
     * SysConfig条件查询
     * @param sysConfig
     * @return
     */
    @Override
    public List<SysConfig> findList(SysConfig sysConfig){
        //构建查询条件
        Example example = createExample(sysConfig);
        //根据构建的条件查询数据
        return sysConfigMapper.selectByExample(example);
    }


    /**
     * SysConfig构建查询对象
     * @param sysConfig
     * @return
     */
    public Example createExample(SysConfig sysConfig){
        Example example=new Example(SysConfig.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysConfig!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        sysConfigMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysConfig
     * @param sysConfig
     */
    @Override
    public void update(SysConfig sysConfig){
        sysConfigMapper.updateByPrimaryKey(sysConfig);
    }

    /**
     * 增加SysConfig
     * @param sysConfig
     */
    @Override
    public void add(SysConfig sysConfig){
        sysConfigMapper.insert(sysConfig);
    }

    /**
     * 根据ID查询SysConfig
     * @param id
     * @return
     */
    @Override
    public SysConfig findById( id){
        return  sysConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysConfig全部数据
     * @return
     */
    @Override
    public List<SysConfig> findAll() {
        return sysConfigMapper.selectAll();
    }
}
