package com.changgou.order.service.impl;
import com.changgou.order.dao.HisConfigInfoMapper;
import com.changgou.order.pojo.HisConfigInfo;
import com.changgou.order.service.HisConfigInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:HisConfigInfo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class HisConfigInfoServiceImpl implements HisConfigInfoService {

    @Autowired
    private HisConfigInfoMapper hisConfigInfoMapper;


    /**
     * HisConfigInfo条件+分页查询
     * @param hisConfigInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<HisConfigInfo> findPage(HisConfigInfo hisConfigInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(hisConfigInfo);
        //执行搜索
        return new PageInfo<HisConfigInfo>(hisConfigInfoMapper.selectByExample(example));
    }

    /**
     * HisConfigInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<HisConfigInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<HisConfigInfo>(hisConfigInfoMapper.selectAll());
    }

    /**
     * HisConfigInfo条件查询
     * @param hisConfigInfo
     * @return
     */
    @Override
    public List<HisConfigInfo> findList(HisConfigInfo hisConfigInfo){
        //构建查询条件
        Example example = createExample(hisConfigInfo);
        //根据构建的条件查询数据
        return hisConfigInfoMapper.selectByExample(example);
    }


    /**
     * HisConfigInfo构建查询对象
     * @param hisConfigInfo
     * @return
     */
    public Example createExample(HisConfigInfo hisConfigInfo){
        Example example=new Example(HisConfigInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(hisConfigInfo!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        hisConfigInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改HisConfigInfo
     * @param hisConfigInfo
     */
    @Override
    public void update(HisConfigInfo hisConfigInfo){
        hisConfigInfoMapper.updateByPrimaryKey(hisConfigInfo);
    }

    /**
     * 增加HisConfigInfo
     * @param hisConfigInfo
     */
    @Override
    public void add(HisConfigInfo hisConfigInfo){
        hisConfigInfoMapper.insert(hisConfigInfo);
    }

    /**
     * 根据ID查询HisConfigInfo
     * @param id
     * @return
     */
    @Override
    public HisConfigInfo findById( id){
        return  hisConfigInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询HisConfigInfo全部数据
     * @return
     */
    @Override
    public List<HisConfigInfo> findAll() {
        return hisConfigInfoMapper.selectAll();
    }
}
