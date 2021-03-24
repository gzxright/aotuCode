package com.changgou.order.service.impl;
import com.changgou.order.dao.TenantCapacityMapper;
import com.changgou.order.pojo.TenantCapacity;
import com.changgou.order.service.TenantCapacityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TenantCapacity业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TenantCapacityServiceImpl implements TenantCapacityService {

    @Autowired
    private TenantCapacityMapper tenantCapacityMapper;


    /**
     * TenantCapacity条件+分页查询
     * @param tenantCapacity 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TenantCapacity> findPage(TenantCapacity tenantCapacity, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(tenantCapacity);
        //执行搜索
        return new PageInfo<TenantCapacity>(tenantCapacityMapper.selectByExample(example));
    }

    /**
     * TenantCapacity分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TenantCapacity> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TenantCapacity>(tenantCapacityMapper.selectAll());
    }

    /**
     * TenantCapacity条件查询
     * @param tenantCapacity
     * @return
     */
    @Override
    public List<TenantCapacity> findList(TenantCapacity tenantCapacity){
        //构建查询条件
        Example example = createExample(tenantCapacity);
        //根据构建的条件查询数据
        return tenantCapacityMapper.selectByExample(example);
    }


    /**
     * TenantCapacity构建查询对象
     * @param tenantCapacity
     * @return
     */
    public Example createExample(TenantCapacity tenantCapacity){
        Example example=new Example(TenantCapacity.class);
        Example.Criteria criteria = example.createCriteria();
        if(tenantCapacity!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        tenantCapacityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TenantCapacity
     * @param tenantCapacity
     */
    @Override
    public void update(TenantCapacity tenantCapacity){
        tenantCapacityMapper.updateByPrimaryKey(tenantCapacity);
    }

    /**
     * 增加TenantCapacity
     * @param tenantCapacity
     */
    @Override
    public void add(TenantCapacity tenantCapacity){
        tenantCapacityMapper.insert(tenantCapacity);
    }

    /**
     * 根据ID查询TenantCapacity
     * @param id
     * @return
     */
    @Override
    public TenantCapacity findById( id){
        return  tenantCapacityMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TenantCapacity全部数据
     * @return
     */
    @Override
    public List<TenantCapacity> findAll() {
        return tenantCapacityMapper.selectAll();
    }
}
