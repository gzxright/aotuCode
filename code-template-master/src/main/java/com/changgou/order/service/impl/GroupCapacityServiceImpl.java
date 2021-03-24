package com.changgou.order.service.impl;
import com.changgou.order.dao.GroupCapacityMapper;
import com.changgou.order.pojo.GroupCapacity;
import com.changgou.order.service.GroupCapacityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:GroupCapacity业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GroupCapacityServiceImpl implements GroupCapacityService {

    @Autowired
    private GroupCapacityMapper groupCapacityMapper;


    /**
     * GroupCapacity条件+分页查询
     * @param groupCapacity 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GroupCapacity> findPage(GroupCapacity groupCapacity, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(groupCapacity);
        //执行搜索
        return new PageInfo<GroupCapacity>(groupCapacityMapper.selectByExample(example));
    }

    /**
     * GroupCapacity分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GroupCapacity> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GroupCapacity>(groupCapacityMapper.selectAll());
    }

    /**
     * GroupCapacity条件查询
     * @param groupCapacity
     * @return
     */
    @Override
    public List<GroupCapacity> findList(GroupCapacity groupCapacity){
        //构建查询条件
        Example example = createExample(groupCapacity);
        //根据构建的条件查询数据
        return groupCapacityMapper.selectByExample(example);
    }


    /**
     * GroupCapacity构建查询对象
     * @param groupCapacity
     * @return
     */
    public Example createExample(GroupCapacity groupCapacity){
        Example example=new Example(GroupCapacity.class);
        Example.Criteria criteria = example.createCriteria();
        if(groupCapacity!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        groupCapacityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GroupCapacity
     * @param groupCapacity
     */
    @Override
    public void update(GroupCapacity groupCapacity){
        groupCapacityMapper.updateByPrimaryKey(groupCapacity);
    }

    /**
     * 增加GroupCapacity
     * @param groupCapacity
     */
    @Override
    public void add(GroupCapacity groupCapacity){
        groupCapacityMapper.insert(groupCapacity);
    }

    /**
     * 根据ID查询GroupCapacity
     * @param id
     * @return
     */
    @Override
    public GroupCapacity findById( id){
        return  groupCapacityMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GroupCapacity全部数据
     * @return
     */
    @Override
    public List<GroupCapacity> findAll() {
        return groupCapacityMapper.selectAll();
    }
}
