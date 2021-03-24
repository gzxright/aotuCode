package com.changgou.order.service.impl;
import com.changgou.order.dao.RentalMapper;
import com.changgou.order.pojo.Rental;
import com.changgou.order.service.RentalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Rental业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalMapper rentalMapper;


    /**
     * Rental条件+分页查询
     * @param rental 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Rental> findPage(Rental rental, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(rental);
        //执行搜索
        return new PageInfo<Rental>(rentalMapper.selectByExample(example));
    }

    /**
     * Rental分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Rental> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Rental>(rentalMapper.selectAll());
    }

    /**
     * Rental条件查询
     * @param rental
     * @return
     */
    @Override
    public List<Rental> findList(Rental rental){
        //构建查询条件
        Example example = createExample(rental);
        //根据构建的条件查询数据
        return rentalMapper.selectByExample(example);
    }


    /**
     * Rental构建查询对象
     * @param rental
     * @return
     */
    public Example createExample(Rental rental){
        Example example=new Example(Rental.class);
        Example.Criteria criteria = example.createCriteria();
        if(rental!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        rentalMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Rental
     * @param rental
     */
    @Override
    public void update(Rental rental){
        rentalMapper.updateByPrimaryKey(rental);
    }

    /**
     * 增加Rental
     * @param rental
     */
    @Override
    public void add(Rental rental){
        rentalMapper.insert(rental);
    }

    /**
     * 根据ID查询Rental
     * @param id
     * @return
     */
    @Override
    public Rental findById( id){
        return  rentalMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Rental全部数据
     * @return
     */
    @Override
    public List<Rental> findAll() {
        return rentalMapper.selectAll();
    }
}
