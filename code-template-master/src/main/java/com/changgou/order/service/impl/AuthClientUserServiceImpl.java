package com.changgou.order.service.impl;
import com.changgou.order.dao.AuthClientUserMapper;
import com.changgou.order.pojo.AuthClientUser;
import com.changgou.order.service.AuthClientUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthClientUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AuthClientUserServiceImpl implements AuthClientUserService {

    @Autowired
    private AuthClientUserMapper authClientUserMapper;


    /**
     * AuthClientUser条件+分页查询
     * @param authClientUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AuthClientUser> findPage(AuthClientUser authClientUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(authClientUser);
        //执行搜索
        return new PageInfo<AuthClientUser>(authClientUserMapper.selectByExample(example));
    }

    /**
     * AuthClientUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AuthClientUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AuthClientUser>(authClientUserMapper.selectAll());
    }

    /**
     * AuthClientUser条件查询
     * @param authClientUser
     * @return
     */
    @Override
    public List<AuthClientUser> findList(AuthClientUser authClientUser){
        //构建查询条件
        Example example = createExample(authClientUser);
        //根据构建的条件查询数据
        return authClientUserMapper.selectByExample(example);
    }


    /**
     * AuthClientUser构建查询对象
     * @param authClientUser
     * @return
     */
    public Example createExample(AuthClientUser authClientUser){
        Example example=new Example(AuthClientUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(authClientUser!=null){
            // 
            if(!StringUtils.isEmpty(authClientUser.getId())){
                    criteria.andEqualTo("id",authClientUser.getId());
            }
            // 
            if(!StringUtils.isEmpty(authClientUser.getAuthClientId())){
                    criteria.andEqualTo("authClientId",authClientUser.getAuthClientId());
            }
            // 
            if(!StringUtils.isEmpty(authClientUser.getUserId())){
                    criteria.andEqualTo("userId",authClientUser.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(authClientUser.getAuthScopeId())){
                    criteria.andEqualTo("authScopeId",authClientUser.getAuthScopeId());
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
        authClientUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AuthClientUser
     * @param authClientUser
     */
    @Override
    public void update(AuthClientUser authClientUser){
        authClientUserMapper.updateByPrimaryKey(authClientUser);
    }

    /**
     * 增加AuthClientUser
     * @param authClientUser
     */
    @Override
    public void add(AuthClientUser authClientUser){
        authClientUserMapper.insert(authClientUser);
    }

    /**
     * 根据ID查询AuthClientUser
     * @param id
     * @return
     */
    @Override
    public AuthClientUser findById(Integer id){
        return  authClientUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AuthClientUser全部数据
     * @return
     */
    @Override
    public List<AuthClientUser> findAll() {
        return authClientUserMapper.selectAll();
    }
}
