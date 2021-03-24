package com.changgou.order.service.impl;
import com.changgou.order.dao.AuthRefreshTokenMapper;
import com.changgou.order.pojo.AuthRefreshToken;
import com.changgou.order.service.AuthRefreshTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthRefreshToken业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AuthRefreshTokenServiceImpl implements AuthRefreshTokenService {

    @Autowired
    private AuthRefreshTokenMapper authRefreshTokenMapper;


    /**
     * AuthRefreshToken条件+分页查询
     * @param authRefreshToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AuthRefreshToken> findPage(AuthRefreshToken authRefreshToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(authRefreshToken);
        //执行搜索
        return new PageInfo<AuthRefreshToken>(authRefreshTokenMapper.selectByExample(example));
    }

    /**
     * AuthRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AuthRefreshToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AuthRefreshToken>(authRefreshTokenMapper.selectAll());
    }

    /**
     * AuthRefreshToken条件查询
     * @param authRefreshToken
     * @return
     */
    @Override
    public List<AuthRefreshToken> findList(AuthRefreshToken authRefreshToken){
        //构建查询条件
        Example example = createExample(authRefreshToken);
        //根据构建的条件查询数据
        return authRefreshTokenMapper.selectByExample(example);
    }


    /**
     * AuthRefreshToken构建查询对象
     * @param authRefreshToken
     * @return
     */
    public Example createExample(AuthRefreshToken authRefreshToken){
        Example example=new Example(AuthRefreshToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(authRefreshToken!=null){
            // id
            if(!StringUtils.isEmpty(authRefreshToken.getId())){
                    criteria.andEqualTo("id",authRefreshToken.getId());
            }
            // 表auth_access_token对应的Access Token记录
            if(!StringUtils.isEmpty(authRefreshToken.getTokenId())){
                    criteria.andEqualTo("tokenId",authRefreshToken.getTokenId());
            }
            // Refresh Token
            if(!StringUtils.isEmpty(authRefreshToken.getRefreshToken())){
                    criteria.andEqualTo("refreshToken",authRefreshToken.getRefreshToken());
            }
            // 过期时间戳
            if(!StringUtils.isEmpty(authRefreshToken.getExpiresIn())){
                    criteria.andEqualTo("expiresIn",authRefreshToken.getExpiresIn());
            }
            // 创建用户
            if(!StringUtils.isEmpty(authRefreshToken.getCreateUser())){
                    criteria.andEqualTo("createUser",authRefreshToken.getCreateUser());
            }
            // 创建时间
            if(!StringUtils.isEmpty(authRefreshToken.getCreateTime())){
                    criteria.andEqualTo("createTime",authRefreshToken.getCreateTime());
            }
            // 最后更新用户
            if(!StringUtils.isEmpty(authRefreshToken.getUpdateUser())){
                    criteria.andEqualTo("updateUser",authRefreshToken.getUpdateUser());
            }
            // 最后更新时间
            if(!StringUtils.isEmpty(authRefreshToken.getUpdateTime())){
                    criteria.andEqualTo("updateTime",authRefreshToken.getUpdateTime());
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
        authRefreshTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AuthRefreshToken
     * @param authRefreshToken
     */
    @Override
    public void update(AuthRefreshToken authRefreshToken){
        authRefreshTokenMapper.updateByPrimaryKey(authRefreshToken);
    }

    /**
     * 增加AuthRefreshToken
     * @param authRefreshToken
     */
    @Override
    public void add(AuthRefreshToken authRefreshToken){
        authRefreshTokenMapper.insert(authRefreshToken);
    }

    /**
     * 根据ID查询AuthRefreshToken
     * @param id
     * @return
     */
    @Override
    public AuthRefreshToken findById(Integer id){
        return  authRefreshTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AuthRefreshToken全部数据
     * @return
     */
    @Override
    public List<AuthRefreshToken> findAll() {
        return authRefreshTokenMapper.selectAll();
    }
}
