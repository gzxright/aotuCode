package com.changgou.order.service.impl;
import com.changgou.order.dao.CityMapper;
import com.changgou.order.pojo.City;
import com.changgou.order.service.CityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:City业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;


    /**
     * City条件+分页查询
     * @param city 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<City> findPage(City city, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(city);
        //执行搜索
        return new PageInfo<City>(cityMapper.selectByExample(example));
    }

    /**
     * City分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<City> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<City>(cityMapper.selectAll());
    }

    /**
     * City条件查询
     * @param city
     * @return
     */
    @Override
    public List<City> findList(City city){
        //构建查询条件
        Example example = createExample(city);
        //根据构建的条件查询数据
        return cityMapper.selectByExample(example);
    }


    /**
     * City构建查询对象
     * @param city
     * @return
     */
    public Example createExample(City city){
        Example example=new Example(City.class);
        Example.Criteria criteria = example.createCriteria();
        if(city!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        cityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改City
     * @param city
     */
    @Override
    public void update(City city){
        cityMapper.updateByPrimaryKey(city);
    }

    /**
     * 增加City
     * @param city
     */
    @Override
    public void add(City city){
        cityMapper.insert(city);
    }

    /**
     * 根据ID查询City
     * @param id
     * @return
     */
    @Override
    public City findById( id){
        return  cityMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询City全部数据
     * @return
     */
    @Override
    public List<City> findAll() {
        return cityMapper.selectAll();
    }
}
