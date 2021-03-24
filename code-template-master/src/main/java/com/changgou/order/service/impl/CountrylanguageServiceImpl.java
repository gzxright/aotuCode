package com.changgou.order.service.impl;
import com.changgou.order.dao.CountrylanguageMapper;
import com.changgou.order.pojo.Countrylanguage;
import com.changgou.order.service.CountrylanguageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Countrylanguage业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CountrylanguageServiceImpl implements CountrylanguageService {

    @Autowired
    private CountrylanguageMapper countrylanguageMapper;


    /**
     * Countrylanguage条件+分页查询
     * @param countrylanguage 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Countrylanguage> findPage(Countrylanguage countrylanguage, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(countrylanguage);
        //执行搜索
        return new PageInfo<Countrylanguage>(countrylanguageMapper.selectByExample(example));
    }

    /**
     * Countrylanguage分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Countrylanguage> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Countrylanguage>(countrylanguageMapper.selectAll());
    }

    /**
     * Countrylanguage条件查询
     * @param countrylanguage
     * @return
     */
    @Override
    public List<Countrylanguage> findList(Countrylanguage countrylanguage){
        //构建查询条件
        Example example = createExample(countrylanguage);
        //根据构建的条件查询数据
        return countrylanguageMapper.selectByExample(example);
    }


    /**
     * Countrylanguage构建查询对象
     * @param countrylanguage
     * @return
     */
    public Example createExample(Countrylanguage countrylanguage){
        Example example=new Example(Countrylanguage.class);
        Example.Criteria criteria = example.createCriteria();
        if(countrylanguage!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        countrylanguageMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Countrylanguage
     * @param countrylanguage
     */
    @Override
    public void update(Countrylanguage countrylanguage){
        countrylanguageMapper.updateByPrimaryKey(countrylanguage);
    }

    /**
     * 增加Countrylanguage
     * @param countrylanguage
     */
    @Override
    public void add(Countrylanguage countrylanguage){
        countrylanguageMapper.insert(countrylanguage);
    }

    /**
     * 根据ID查询Countrylanguage
     * @param id
     * @return
     */
    @Override
    public Countrylanguage findById( id){
        return  countrylanguageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Countrylanguage全部数据
     * @return
     */
    @Override
    public List<Countrylanguage> findAll() {
        return countrylanguageMapper.selectAll();
    }
}
