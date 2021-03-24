package com.changgou.order.service.impl;
import com.changgou.order.dao.TenantInfoMapper;
import com.changgou.order.pojo.TenantInfo;
import com.changgou.order.service.TenantInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TenantInfo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TenantInfoServiceImpl implements TenantInfoService {

    @Autowired
    private TenantInfoMapper tenantInfoMapper;


    /**
     * TenantInfo条件+分页查询
     * @param tenantInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TenantInfo> findPage(TenantInfo tenantInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(tenantInfo);
        //执行搜索
        return new PageInfo<TenantInfo>(tenantInfoMapper.selectByExample(example));
    }

    /**
     * TenantInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TenantInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TenantInfo>(tenantInfoMapper.selectAll());
    }

    /**
     * TenantInfo条件查询
     * @param tenantInfo
     * @return
     */
    @Override
    public List<TenantInfo> findList(TenantInfo tenantInfo){
        //构建查询条件
        Example example = createExample(tenantInfo);
        //根据构建的条件查询数据
        return tenantInfoMapper.selectByExample(example);
    }


    /**
     * TenantInfo构建查询对象
     * @param tenantInfo
     * @return
     */
    public Example createExample(TenantInfo tenantInfo){
        Example example=new Example(TenantInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(tenantInfo!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        tenantInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TenantInfo
     * @param tenantInfo
     */
    @Override
    public void update(TenantInfo tenantInfo){
        tenantInfoMapper.updateByPrimaryKey(tenantInfo);
    }

    /**
     * 增加TenantInfo
     * @param tenantInfo
     */
    @Override
    public void add(TenantInfo tenantInfo){
        tenantInfoMapper.insert(tenantInfo);
    }

    /**
     * 根据ID查询TenantInfo
     * @param id
     * @return
     */
    @Override
    public TenantInfo findById( id){
        return  tenantInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TenantInfo全部数据
     * @return
     */
    @Override
    public List<TenantInfo> findAll() {
        return tenantInfoMapper.selectAll();
    }
}
