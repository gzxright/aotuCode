package com.changgou.order.service.impl;
import com.changgou.order.dao.FilmMapper;
import com.changgou.order.pojo.Film;
import com.changgou.order.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Film业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;


    /**
     * Film条件+分页查询
     * @param film 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Film> findPage(Film film, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(film);
        //执行搜索
        return new PageInfo<Film>(filmMapper.selectByExample(example));
    }

    /**
     * Film分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Film> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Film>(filmMapper.selectAll());
    }

    /**
     * Film条件查询
     * @param film
     * @return
     */
    @Override
    public List<Film> findList(Film film){
        //构建查询条件
        Example example = createExample(film);
        //根据构建的条件查询数据
        return filmMapper.selectByExample(example);
    }


    /**
     * Film构建查询对象
     * @param film
     * @return
     */
    public Example createExample(Film film){
        Example example=new Example(Film.class);
        Example.Criteria criteria = example.createCriteria();
        if(film!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        filmMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Film
     * @param film
     */
    @Override
    public void update(Film film){
        filmMapper.updateByPrimaryKey(film);
    }

    /**
     * 增加Film
     * @param film
     */
    @Override
    public void add(Film film){
        filmMapper.insert(film);
    }

    /**
     * 根据ID查询Film
     * @param id
     * @return
     */
    @Override
    public Film findById( id){
        return  filmMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Film全部数据
     * @return
     */
    @Override
    public List<Film> findAll() {
        return filmMapper.selectAll();
    }
}
