package com.changgou.order.service.impl;
import com.changgou.order.dao.AuthClientDetailsMapper;
import com.changgou.order.pojo.AuthClientDetails;
import com.changgou.order.service.AuthClientDetailsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthClientDetails业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AuthClientDetailsServiceImpl implements AuthClientDetailsService {

    @Autowired
    private AuthClientDetailsMapper authClientDetailsMapper;


    /**
     * AuthClientDetails条件+分页查询
     * @param authClientDetails 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AuthClientDetails> findPage(AuthClientDetails authClientDetails, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(authClientDetails);
        //执行搜索
        return new PageInfo<AuthClientDetails>(authClientDetailsMapper.selectByExample(example));
    }

    /**
     * AuthClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AuthClientDetails> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AuthClientDetails>(authClientDetailsMapper.selectAll());
    }

    /**
     * AuthClientDetails条件查询
     * @param authClientDetails
     * @return
     */
    @Override
    public List<AuthClientDetails> findList(AuthClientDetails authClientDetails){
        //构建查询条件
        Example example = createExample(authClientDetails);
        //根据构建的条件查询数据
        return authClientDetailsMapper.selectByExample(example);
    }


    /**
     * AuthClientDetails构建查询对象
     * @param authClientDetails
     * @return
     */
    public Example createExample(AuthClientDetails authClientDetails){
        Example example=new Example(AuthClientDetails.class);
        Example.Criteria criteria = example.createCriteria();
        if(authClientDetails!=null){
            // id
            if(!StringUtils.isEmpty(authClientDetails.getId())){
                    criteria.andEqualTo("id",authClientDetails.getId());
            }
            // 接入的客户端ID
            if(!StringUtils.isEmpty(authClientDetails.getClientId())){
                    criteria.andEqualTo("clientId",authClientDetails.getClientId());
            }
            // 
            if(!StringUtils.isEmpty(authClientDetails.getClientName())){
                    criteria.andEqualTo("clientName",authClientDetails.getClientName());
            }
            // 接入的客户端的密钥
            if(!StringUtils.isEmpty(authClientDetails.getClientSecret())){
                    criteria.andEqualTo("clientSecret",authClientDetails.getClientSecret());
            }
            // 回调地址
            if(!StringUtils.isEmpty(authClientDetails.getRedirectUri())){
                    criteria.andEqualTo("redirectUri",authClientDetails.getRedirectUri());
            }
            // 描述信息
            if(!StringUtils.isEmpty(authClientDetails.getDescription())){
                    criteria.andEqualTo("description",authClientDetails.getDescription());
            }
            // 创建用户
            if(!StringUtils.isEmpty(authClientDetails.getCreateUser())){
                    criteria.andEqualTo("createUser",authClientDetails.getCreateUser());
            }
            // 创建时间
            if(!StringUtils.isEmpty(authClientDetails.getCreateTime())){
                    criteria.andEqualTo("createTime",authClientDetails.getCreateTime());
            }
            // 最后更新用户
            if(!StringUtils.isEmpty(authClientDetails.getUpdateUser())){
                    criteria.andEqualTo("updateUser",authClientDetails.getUpdateUser());
            }
            // 最后更新时间
            if(!StringUtils.isEmpty(authClientDetails.getUpdateTime())){
                    criteria.andEqualTo("updateTime",authClientDetails.getUpdateTime());
            }
            // 0表示未开通；1表示正常使用；2表示已被禁用
            if(!StringUtils.isEmpty(authClientDetails.getStatus())){
                    criteria.andEqualTo("status",authClientDetails.getStatus());
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
        authClientDetailsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AuthClientDetails
     * @param authClientDetails
     */
    @Override
    public void update(AuthClientDetails authClientDetails){
        authClientDetailsMapper.updateByPrimaryKey(authClientDetails);
    }

    /**
     * 增加AuthClientDetails
     * @param authClientDetails
     */
    @Override
    public void add(AuthClientDetails authClientDetails){
        authClientDetailsMapper.insert(authClientDetails);
    }

    /**
     * 根据ID查询AuthClientDetails
     * @param id
     * @return
     */
    @Override
    public AuthClientDetails findById(Integer id){
        return  authClientDetailsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AuthClientDetails全部数据
     * @return
     */
    @Override
    public List<AuthClientDetails> findAll() {
        return authClientDetailsMapper.selectAll();
    }
}
