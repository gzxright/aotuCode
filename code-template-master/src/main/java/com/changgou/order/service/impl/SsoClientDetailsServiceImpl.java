package com.changgou.order.service.impl;
import com.changgou.order.dao.SsoClientDetailsMapper;
import com.changgou.order.pojo.SsoClientDetails;
import com.changgou.order.service.SsoClientDetailsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoClientDetails业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SsoClientDetailsServiceImpl implements SsoClientDetailsService {

    @Autowired
    private SsoClientDetailsMapper ssoClientDetailsMapper;


    /**
     * SsoClientDetails条件+分页查询
     * @param ssoClientDetails 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SsoClientDetails> findPage(SsoClientDetails ssoClientDetails, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(ssoClientDetails);
        //执行搜索
        return new PageInfo<SsoClientDetails>(ssoClientDetailsMapper.selectByExample(example));
    }

    /**
     * SsoClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SsoClientDetails> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SsoClientDetails>(ssoClientDetailsMapper.selectAll());
    }

    /**
     * SsoClientDetails条件查询
     * @param ssoClientDetails
     * @return
     */
    @Override
    public List<SsoClientDetails> findList(SsoClientDetails ssoClientDetails){
        //构建查询条件
        Example example = createExample(ssoClientDetails);
        //根据构建的条件查询数据
        return ssoClientDetailsMapper.selectByExample(example);
    }


    /**
     * SsoClientDetails构建查询对象
     * @param ssoClientDetails
     * @return
     */
    public Example createExample(SsoClientDetails ssoClientDetails){
        Example example=new Example(SsoClientDetails.class);
        Example.Criteria criteria = example.createCriteria();
        if(ssoClientDetails!=null){
            // 
            if(!StringUtils.isEmpty(ssoClientDetails.getId())){
                    criteria.andEqualTo("id",ssoClientDetails.getId());
            }
            // 接入单点登录的系统名称
            if(!StringUtils.isEmpty(ssoClientDetails.getClientName())){
                    criteria.andEqualTo("clientName",ssoClientDetails.getClientName());
            }
            // 
            if(!StringUtils.isEmpty(ssoClientDetails.getDescription())){
                    criteria.andEqualTo("description",ssoClientDetails.getDescription());
            }
            // 请求Token的回调URL
            if(!StringUtils.isEmpty(ssoClientDetails.getRedirectUrl())){
                    criteria.andEqualTo("redirectUrl",ssoClientDetails.getRedirectUrl());
            }
            // 注销URL
            if(!StringUtils.isEmpty(ssoClientDetails.getLogoutUrl())){
                    criteria.andEqualTo("logoutUrl",ssoClientDetails.getLogoutUrl());
            }
            // 0表示未开通；1表示正常使用；2表示已被禁用
            if(!StringUtils.isEmpty(ssoClientDetails.getStatus())){
                    criteria.andEqualTo("status",ssoClientDetails.getStatus());
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
        ssoClientDetailsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SsoClientDetails
     * @param ssoClientDetails
     */
    @Override
    public void update(SsoClientDetails ssoClientDetails){
        ssoClientDetailsMapper.updateByPrimaryKey(ssoClientDetails);
    }

    /**
     * 增加SsoClientDetails
     * @param ssoClientDetails
     */
    @Override
    public void add(SsoClientDetails ssoClientDetails){
        ssoClientDetailsMapper.insert(ssoClientDetails);
    }

    /**
     * 根据ID查询SsoClientDetails
     * @param id
     * @return
     */
    @Override
    public SsoClientDetails findById(Integer id){
        return  ssoClientDetailsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SsoClientDetails全部数据
     * @return
     */
    @Override
    public List<SsoClientDetails> findAll() {
        return ssoClientDetailsMapper.selectAll();
    }
}
