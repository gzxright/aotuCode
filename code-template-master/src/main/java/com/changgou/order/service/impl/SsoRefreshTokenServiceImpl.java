package com.changgou.order.service.impl;
import com.changgou.order.dao.SsoRefreshTokenMapper;
import com.changgou.order.pojo.SsoRefreshToken;
import com.changgou.order.service.SsoRefreshTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoRefreshToken业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SsoRefreshTokenServiceImpl implements SsoRefreshTokenService {

    @Autowired
    private SsoRefreshTokenMapper ssoRefreshTokenMapper;


    /**
     * SsoRefreshToken条件+分页查询
     * @param ssoRefreshToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SsoRefreshToken> findPage(SsoRefreshToken ssoRefreshToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(ssoRefreshToken);
        //执行搜索
        return new PageInfo<SsoRefreshToken>(ssoRefreshTokenMapper.selectByExample(example));
    }

    /**
     * SsoRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SsoRefreshToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SsoRefreshToken>(ssoRefreshTokenMapper.selectAll());
    }

    /**
     * SsoRefreshToken条件查询
     * @param ssoRefreshToken
     * @return
     */
    @Override
    public List<SsoRefreshToken> findList(SsoRefreshToken ssoRefreshToken){
        //构建查询条件
        Example example = createExample(ssoRefreshToken);
        //根据构建的条件查询数据
        return ssoRefreshTokenMapper.selectByExample(example);
    }


    /**
     * SsoRefreshToken构建查询对象
     * @param ssoRefreshToken
     * @return
     */
    public Example createExample(SsoRefreshToken ssoRefreshToken){
        Example example=new Example(SsoRefreshToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(ssoRefreshToken!=null){
            // id
            if(!StringUtils.isEmpty(ssoRefreshToken.getId())){
                    criteria.andEqualTo("id",ssoRefreshToken.getId());
            }
            // 表sso_access_token对应的Access Token记录
            if(!StringUtils.isEmpty(ssoRefreshToken.getTokenId())){
                    criteria.andEqualTo("tokenId",ssoRefreshToken.getTokenId());
            }
            // Refresh Token
            if(!StringUtils.isEmpty(ssoRefreshToken.getRefreshToken())){
                    criteria.andEqualTo("refreshToken",ssoRefreshToken.getRefreshToken());
            }
            // 过期时间戳
            if(!StringUtils.isEmpty(ssoRefreshToken.getExpiresIn())){
                    criteria.andEqualTo("expiresIn",ssoRefreshToken.getExpiresIn());
            }
            // 创建用户
            if(!StringUtils.isEmpty(ssoRefreshToken.getCreateUser())){
                    criteria.andEqualTo("createUser",ssoRefreshToken.getCreateUser());
            }
            // 创建时间
            if(!StringUtils.isEmpty(ssoRefreshToken.getCreateTime())){
                    criteria.andEqualTo("createTime",ssoRefreshToken.getCreateTime());
            }
            // 最后更新用户
            if(!StringUtils.isEmpty(ssoRefreshToken.getUpdateUser())){
                    criteria.andEqualTo("updateUser",ssoRefreshToken.getUpdateUser());
            }
            // 最后更新时间
            if(!StringUtils.isEmpty(ssoRefreshToken.getUpdateTime())){
                    criteria.andEqualTo("updateTime",ssoRefreshToken.getUpdateTime());
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
        ssoRefreshTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SsoRefreshToken
     * @param ssoRefreshToken
     */
    @Override
    public void update(SsoRefreshToken ssoRefreshToken){
        ssoRefreshTokenMapper.updateByPrimaryKey(ssoRefreshToken);
    }

    /**
     * 增加SsoRefreshToken
     * @param ssoRefreshToken
     */
    @Override
    public void add(SsoRefreshToken ssoRefreshToken){
        ssoRefreshTokenMapper.insert(ssoRefreshToken);
    }

    /**
     * 根据ID查询SsoRefreshToken
     * @param id
     * @return
     */
    @Override
    public SsoRefreshToken findById(Integer id){
        return  ssoRefreshTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SsoRefreshToken全部数据
     * @return
     */
    @Override
    public List<SsoRefreshToken> findAll() {
        return ssoRefreshTokenMapper.selectAll();
    }
}
