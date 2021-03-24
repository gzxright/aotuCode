package com.changgou.order.service.impl;
import com.changgou.order.dao.AuthAccessTokenMapper;
import com.changgou.order.pojo.AuthAccessToken;
import com.changgou.order.service.AuthAccessTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthAccessToken业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AuthAccessTokenServiceImpl implements AuthAccessTokenService {

    @Autowired
    private AuthAccessTokenMapper authAccessTokenMapper;


    /**
     * AuthAccessToken条件+分页查询
     * @param authAccessToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AuthAccessToken> findPage(AuthAccessToken authAccessToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(authAccessToken);
        //执行搜索
        return new PageInfo<AuthAccessToken>(authAccessTokenMapper.selectByExample(example));
    }

    /**
     * AuthAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AuthAccessToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AuthAccessToken>(authAccessTokenMapper.selectAll());
    }

    /**
     * AuthAccessToken条件查询
     * @param authAccessToken
     * @return
     */
    @Override
    public List<AuthAccessToken> findList(AuthAccessToken authAccessToken){
        //构建查询条件
        Example example = createExample(authAccessToken);
        //根据构建的条件查询数据
        return authAccessTokenMapper.selectByExample(example);
    }


    /**
     * AuthAccessToken构建查询对象
     * @param authAccessToken
     * @return
     */
    public Example createExample(AuthAccessToken authAccessToken){
        Example example=new Example(AuthAccessToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(authAccessToken!=null){
            // id
            if(!StringUtils.isEmpty(authAccessToken.getId())){
                    criteria.andEqualTo("id",authAccessToken.getId());
            }
            // Access Token
            if(!StringUtils.isEmpty(authAccessToken.getAccessToken())){
                    criteria.andEqualTo("accessToken",authAccessToken.getAccessToken());
            }
            // 关联的用户ID
            if(!StringUtils.isEmpty(authAccessToken.getUserId())){
                    criteria.andEqualTo("userId",authAccessToken.getUserId());
            }
            // 用户名
            if(!StringUtils.isEmpty(authAccessToken.getUserName())){
                    criteria.andEqualTo("userName",authAccessToken.getUserName());
            }
            // 接入的客户端ID
            if(!StringUtils.isEmpty(authAccessToken.getClientId())){
                    criteria.andEqualTo("clientId",authAccessToken.getClientId());
            }
            // 过期时间戳
            if(!StringUtils.isEmpty(authAccessToken.getExpiresIn())){
                    criteria.andEqualTo("expiresIn",authAccessToken.getExpiresIn());
            }
            // 授权类型，比如：authorization_code
            if(!StringUtils.isEmpty(authAccessToken.getGrantType())){
                    criteria.andEqualTo("grantType",authAccessToken.getGrantType());
            }
            // 可被访问的用户的权限范围，比如：basic、super
            if(!StringUtils.isEmpty(authAccessToken.getScope())){
                    criteria.andEqualTo("scope",authAccessToken.getScope());
            }
            // 创建用户
            if(!StringUtils.isEmpty(authAccessToken.getCreateUser())){
                    criteria.andEqualTo("createUser",authAccessToken.getCreateUser());
            }
            // 创建时间
            if(!StringUtils.isEmpty(authAccessToken.getCreateTime())){
                    criteria.andEqualTo("createTime",authAccessToken.getCreateTime());
            }
            // 最后更新用户
            if(!StringUtils.isEmpty(authAccessToken.getUpdateUser())){
                    criteria.andEqualTo("updateUser",authAccessToken.getUpdateUser());
            }
            // 最后更新时间
            if(!StringUtils.isEmpty(authAccessToken.getUpdateTime())){
                    criteria.andEqualTo("updateTime",authAccessToken.getUpdateTime());
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
        authAccessTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AuthAccessToken
     * @param authAccessToken
     */
    @Override
    public void update(AuthAccessToken authAccessToken){
        authAccessTokenMapper.updateByPrimaryKey(authAccessToken);
    }

    /**
     * 增加AuthAccessToken
     * @param authAccessToken
     */
    @Override
    public void add(AuthAccessToken authAccessToken){
        authAccessTokenMapper.insert(authAccessToken);
    }

    /**
     * 根据ID查询AuthAccessToken
     * @param id
     * @return
     */
    @Override
    public AuthAccessToken findById(Integer id){
        return  authAccessTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AuthAccessToken全部数据
     * @return
     */
    @Override
    public List<AuthAccessToken> findAll() {
        return authAccessTokenMapper.selectAll();
    }
}
