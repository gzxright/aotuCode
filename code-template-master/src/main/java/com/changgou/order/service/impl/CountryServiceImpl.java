package com.changgou.order.service.impl;
import com.changgou.order.dao.CountryMapper;
import com.changgou.order.pojo.Country;
import com.changgou.order.service.CountryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Country业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;


    /**
     * Country条件+分页查询
     * @param country 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Country> findPage(Country country, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(country);
        //执行搜索
        return new PageInfo<Country>(countryMapper.selectByExample(example));
    }

    /**
     * Country分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Country> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Country>(countryMapper.selectAll());
    }

    /**
     * Country条件查询
     * @param country
     * @return
     */
    @Override
    public List<Country> findList(Country country){
        //构建查询条件
        Example example = createExample(country);
        //根据构建的条件查询数据
        return countryMapper.selectByExample(example);
    }


    /**
     * Country构建查询对象
     * @param country
     * @return
     */
    public Example createExample(Country country){
        Example example=new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if(country!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        countryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Country
     * @param country
     */
    @Override
    public void update(Country country){
        countryMapper.updateByPrimaryKey(country);
    }

    /**
     * 增加Country
     * @param country
     */
    @Override
    public void add(Country country){
        countryMapper.insert(country);
    }

    /**
     * 根据ID查询Country
     * @param id
     * @return
     */
    @Override
    public Country findById( id){
        return  countryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Country全部数据
     * @return
     */
    @Override
    public List<Country> findAll() {
        return countryMapper.selectAll();
    }
}
