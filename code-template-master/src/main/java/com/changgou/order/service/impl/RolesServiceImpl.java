package com.changgou.order.service.impl;
import com.changgou.order.dao.RolesMapper;
import com.changgou.order.pojo.Roles;
import com.changgou.order.service.RolesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Roles业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;


    /**
     * Roles条件+分页查询
     * @param roles 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Roles> findPage(Roles roles, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(roles);
        //执行搜索
        return new PageInfo<Roles>(rolesMapper.selectByExample(example));
    }

    /**
     * Roles分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Roles> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Roles>(rolesMapper.selectAll());
    }

    /**
     * Roles条件查询
     * @param roles
     * @return
     */
    @Override
    public List<Roles> findList(Roles roles){
        //构建查询条件
        Example example = createExample(roles);
        //根据构建的条件查询数据
        return rolesMapper.selectByExample(example);
    }


    /**
     * Roles构建查询对象
     * @param roles
     * @return
     */
    public Example createExample(Roles roles){
        Example example=new Example(Roles.class);
        Example.Criteria criteria = example.createCriteria();
        if(roles!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        rolesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Roles
     * @param roles
     */
    @Override
    public void update(Roles roles){
        rolesMapper.updateByPrimaryKey(roles);
    }

    /**
     * 增加Roles
     * @param roles
     */
    @Override
    public void add(Roles roles){
        rolesMapper.insert(roles);
    }

    /**
     * 根据ID查询Roles
     * @param id
     * @return
     */
    @Override
    public Roles findById( id){
        return  rolesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Roles全部数据
     * @return
     */
    @Override
    public List<Roles> findAll() {
        return rolesMapper.selectAll();
    }
}
