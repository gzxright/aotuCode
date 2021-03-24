package com.changgou.order.service.impl;
import com.changgou.order.dao.SsoAccessTokenMapper;
import com.changgou.order.pojo.SsoAccessToken;
import com.changgou.order.service.SsoAccessTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoAccessToken业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SsoAccessTokenServiceImpl implements SsoAccessTokenService {

    @Autowired
    private SsoAccessTokenMapper ssoAccessTokenMapper;


    /**
     * SsoAccessToken条件+分页查询
     * @param ssoAccessToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SsoAccessToken> findPage(SsoAccessToken ssoAccessToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(ssoAccessToken);
        //执行搜索
        return new PageInfo<SsoAccessToken>(ssoAccessTokenMapper.selectByExample(example));
    }

    /**
     * SsoAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SsoAccessToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SsoAccessToken>(ssoAccessTokenMapper.selectAll());
    }

    /**
     * SsoAccessToken条件查询
     * @param ssoAccessToken
     * @return
     */
    @Override
    public List<SsoAccessToken> findList(SsoAccessToken ssoAccessToken){
        //构建查询条件
        Example example = createExample(ssoAccessToken);
        //根据构建的条件查询数据
        return ssoAccessTokenMapper.selectByExample(example);
    }


    /**
     * SsoAccessToken构建查询对象
     * @param ssoAccessToken
     * @return
     */
    public Example createExample(SsoAccessToken ssoAccessToken){
        Example example=new Example(SsoAccessToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(ssoAccessToken!=null){
            // id
            if(!StringUtils.isEmpty(ssoAccessToken.getId())){
                    criteria.andEqualTo("id",ssoAccessToken.getId());
            }
            // Access Token
            if(!StringUtils.isEmpty(ssoAccessToken.getAccessToken())){
                    criteria.andEqualTo("accessToken",ssoAccessToken.getAccessToken());
            }
            // 关联的用户ID
            if(!StringUtils.isEmpty(ssoAccessToken.getUserId())){
                    criteria.andEqualTo("userId",ssoAccessToken.getUserId());
            }
            // 用户名
            if(!StringUtils.isEmpty(ssoAccessToken.getUserName())){
                    criteria.andEqualTo("userName",ssoAccessToken.getUserName());
            }
            // 用户来源IP
            if(!StringUtils.isEmpty(ssoAccessToken.getIp())){
                    criteria.andEqualTo("ip",ssoAccessToken.getIp());
            }
            // 
            if(!StringUtils.isEmpty(ssoAccessToken.getClientId())){
                    criteria.andEqualTo("clientId",ssoAccessToken.getClientId());
            }
            // 表示这个Token用于什么渠道，比如：官网、APP1、APP2等等
            if(!StringUtils.isEmpty(ssoAccessToken.getChannel())){
                    criteria.andEqualTo("channel",ssoAccessToken.getChannel());
            }
            // 过期时间戳
            if(!StringUtils.isEmpty(ssoAccessToken.getExpiresIn())){
                    criteria.andEqualTo("expiresIn",ssoAccessToken.getExpiresIn());
            }
            // 创建用户
            if(!StringUtils.isEmpty(ssoAccessToken.getCreateUser())){
                    criteria.andEqualTo("createUser",ssoAccessToken.getCreateUser());
            }
            // 创建时间
            if(!StringUtils.isEmpty(ssoAccessToken.getCreateTime())){
                    criteria.andEqualTo("createTime",ssoAccessToken.getCreateTime());
            }
            // 最后更新用户
            if(!StringUtils.isEmpty(ssoAccessToken.getUpdateUser())){
                    criteria.andEqualTo("updateUser",ssoAccessToken.getUpdateUser());
            }
            // 最后更新时间
            if(!StringUtils.isEmpty(ssoAccessToken.getUpdateTime())){
                    criteria.andEqualTo("updateTime",ssoAccessToken.getUpdateTime());
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
        ssoAccessTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SsoAccessToken
     * @param ssoAccessToken
     */
    @Override
    public void update(SsoAccessToken ssoAccessToken){
        ssoAccessTokenMapper.updateByPrimaryKey(ssoAccessToken);
    }

    /**
     * 增加SsoAccessToken
     * @param ssoAccessToken
     */
    @Override
    public void add(SsoAccessToken ssoAccessToken){
        ssoAccessTokenMapper.insert(ssoAccessToken);
    }

    /**
     * 根据ID查询SsoAccessToken
     * @param id
     * @return
     */
    @Override
    public SsoAccessToken findById(Integer id){
        return  ssoAccessTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SsoAccessToken全部数据
     * @return
     */
    @Override
    public List<SsoAccessToken> findAll() {
        return ssoAccessTokenMapper.selectAll();
    }
}
