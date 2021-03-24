package com.changgou.order.service.impl;
import com.changgou.order.dao.CustomerMapper;
import com.changgou.order.pojo.Customer;
import com.changgou.order.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Customer业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    /**
     * Customer条件+分页查询
     * @param customer 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Customer> findPage(Customer customer, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(customer);
        //执行搜索
        return new PageInfo<Customer>(customerMapper.selectByExample(example));
    }

    /**
     * Customer分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Customer> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Customer>(customerMapper.selectAll());
    }

    /**
     * Customer条件查询
     * @param customer
     * @return
     */
    @Override
    public List<Customer> findList(Customer customer){
        //构建查询条件
        Example example = createExample(customer);
        //根据构建的条件查询数据
        return customerMapper.selectByExample(example);
    }


    /**
     * Customer构建查询对象
     * @param customer
     * @return
     */
    public Example createExample(Customer customer){
        Example example=new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        if(customer!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        customerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Customer
     * @param customer
     */
    @Override
    public void update(Customer customer){
        customerMapper.updateByPrimaryKey(customer);
    }

    /**
     * 增加Customer
     * @param customer
     */
    @Override
    public void add(Customer customer){
        customerMapper.insert(customer);
    }

    /**
     * 根据ID查询Customer
     * @param id
     * @return
     */
    @Override
    public Customer findById( id){
        return  customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Customer全部数据
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return customerMapper.selectAll();
    }
}
