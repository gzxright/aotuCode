package com.changgou.order.service.impl;
import com.changgou.order.dao.RoleFuncMapper;
import com.changgou.order.pojo.RoleFunc;
import com.changgou.order.service.RoleFuncService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:RoleFunc业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoleFuncServiceImpl implements RoleFuncService {

    @Autowired
    private RoleFuncMapper roleFuncMapper;


    /**
     * RoleFunc条件+分页查询
     * @param roleFunc 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<RoleFunc> findPage(RoleFunc roleFunc, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(roleFunc);
        //执行搜索
        return new PageInfo<RoleFunc>(roleFuncMapper.selectByExample(example));
    }

    /**
     * RoleFunc分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<RoleFunc> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<RoleFunc>(roleFuncMapper.selectAll());
    }

    /**
     * RoleFunc条件查询
     * @param roleFunc
     * @return
     */
    @Override
    public List<RoleFunc> findList(RoleFunc roleFunc){
        //构建查询条件
        Example example = createExample(roleFunc);
        //根据构建的条件查询数据
        return roleFuncMapper.selectByExample(example);
    }


    /**
     * RoleFunc构建查询对象
     * @param roleFunc
     * @return
     */
    public Example createExample(RoleFunc roleFunc){
        Example example=new Example(RoleFunc.class);
        Example.Criteria criteria = example.createCriteria();
        if(roleFunc!=null){
            // 
            if(!StringUtils.isEmpty(roleFunc.getId())){
                    criteria.andEqualTo("id",roleFunc.getId());
            }
            // 
            if(!StringUtils.isEmpty(roleFunc.getRoleId())){
                    criteria.andEqualTo("roleId",roleFunc.getRoleId());
            }
            // 
            if(!StringUtils.isEmpty(roleFunc.getFuncId())){
                    criteria.andEqualTo("funcId",roleFunc.getFuncId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        roleFuncMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改RoleFunc
     * @param roleFunc
     */
    @Override
    public void update(RoleFunc roleFunc){
        roleFuncMapper.updateByPrimaryKey(roleFunc);
    }

    /**
     * 增加RoleFunc
     * @param roleFunc
     */
    @Override
    public void add(RoleFunc roleFunc){
        roleFuncMapper.insert(roleFunc);
    }

    /**
     * 根据ID查询RoleFunc
     * @param id
     * @return
     */
    @Override
    public RoleFunc findById(Integer id){
        return  roleFuncMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询RoleFunc全部数据
     * @return
     */
    @Override
    public List<RoleFunc> findAll() {
        return roleFuncMapper.selectAll();
    }
}
