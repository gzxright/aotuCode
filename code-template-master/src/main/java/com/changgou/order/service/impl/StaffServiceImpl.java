package com.changgou.order.service.impl;
import com.changgou.order.dao.StaffMapper;
import com.changgou.order.pojo.Staff;
import com.changgou.order.service.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Staff业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;


    /**
     * Staff条件+分页查询
     * @param staff 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Staff> findPage(Staff staff, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(staff);
        //执行搜索
        return new PageInfo<Staff>(staffMapper.selectByExample(example));
    }

    /**
     * Staff分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Staff> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Staff>(staffMapper.selectAll());
    }

    /**
     * Staff条件查询
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findList(Staff staff){
        //构建查询条件
        Example example = createExample(staff);
        //根据构建的条件查询数据
        return staffMapper.selectByExample(example);
    }


    /**
     * Staff构建查询对象
     * @param staff
     * @return
     */
    public Example createExample(Staff staff){
        Example example=new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        if(staff!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        staffMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Staff
     * @param staff
     */
    @Override
    public void update(Staff staff){
        staffMapper.updateByPrimaryKey(staff);
    }

    /**
     * 增加Staff
     * @param staff
     */
    @Override
    public void add(Staff staff){
        staffMapper.insert(staff);
    }

    /**
     * 根据ID查询Staff
     * @param id
     * @return
     */
    @Override
    public Staff findById( id){
        return  staffMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Staff全部数据
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return staffMapper.selectAll();
    }
}
