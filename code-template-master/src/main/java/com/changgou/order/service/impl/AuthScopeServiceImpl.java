package com.changgou.order.service.impl;
import com.changgou.order.dao.AuthScopeMapper;
import com.changgou.order.pojo.AuthScope;
import com.changgou.order.service.AuthScopeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthScope业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AuthScopeServiceImpl implements AuthScopeService {

    @Autowired
    private AuthScopeMapper authScopeMapper;


    /**
     * AuthScope条件+分页查询
     * @param authScope 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AuthScope> findPage(AuthScope authScope, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(authScope);
        //执行搜索
        return new PageInfo<AuthScope>(authScopeMapper.selectByExample(example));
    }

    /**
     * AuthScope分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AuthScope> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AuthScope>(authScopeMapper.selectAll());
    }

    /**
     * AuthScope条件查询
     * @param authScope
     * @return
     */
    @Override
    public List<AuthScope> findList(AuthScope authScope){
        //构建查询条件
        Example example = createExample(authScope);
        //根据构建的条件查询数据
        return authScopeMapper.selectByExample(example);
    }


    /**
     * AuthScope构建查询对象
     * @param authScope
     * @return
     */
    public Example createExample(AuthScope authScope){
        Example example=new Example(AuthScope.class);
        Example.Criteria criteria = example.createCriteria();
        if(authScope!=null){
            // 
            if(!StringUtils.isEmpty(authScope.getId())){
                    criteria.andEqualTo("id",authScope.getId());
            }
            // 可被访问的用户的权限范围，比如：basic、super
            if(!StringUtils.isEmpty(authScope.getScopeName())){
                    criteria.andEqualTo("scopeName",authScope.getScopeName());
            }
            // 
            if(!StringUtils.isEmpty(authScope.getDescription())){
                    criteria.andEqualTo("description",authScope.getDescription());
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
        authScopeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AuthScope
     * @param authScope
     */
    @Override
    public void update(AuthScope authScope){
        authScopeMapper.updateByPrimaryKey(authScope);
    }

    /**
     * 增加AuthScope
     * @param authScope
     */
    @Override
    public void add(AuthScope authScope){
        authScopeMapper.insert(authScope);
    }

    /**
     * 根据ID查询AuthScope
     * @param id
     * @return
     */
    @Override
    public AuthScope findById(Integer id){
        return  authScopeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AuthScope全部数据
     * @return
     */
    @Override
    public List<AuthScope> findAll() {
        return authScopeMapper.selectAll();
    }
}
