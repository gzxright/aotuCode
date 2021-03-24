package com.changgou.order.service.impl;
import com.changgou.order.dao.FilmCategoryMapper;
import com.changgou.order.pojo.FilmCategory;
import com.changgou.order.service.FilmCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmCategory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FilmCategoryServiceImpl implements FilmCategoryService {

    @Autowired
    private FilmCategoryMapper filmCategoryMapper;


    /**
     * FilmCategory条件+分页查询
     * @param filmCategory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FilmCategory> findPage(FilmCategory filmCategory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(filmCategory);
        //执行搜索
        return new PageInfo<FilmCategory>(filmCategoryMapper.selectByExample(example));
    }

    /**
     * FilmCategory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FilmCategory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FilmCategory>(filmCategoryMapper.selectAll());
    }

    /**
     * FilmCategory条件查询
     * @param filmCategory
     * @return
     */
    @Override
    public List<FilmCategory> findList(FilmCategory filmCategory){
        //构建查询条件
        Example example = createExample(filmCategory);
        //根据构建的条件查询数据
        return filmCategoryMapper.selectByExample(example);
    }


    /**
     * FilmCategory构建查询对象
     * @param filmCategory
     * @return
     */
    public Example createExample(FilmCategory filmCategory){
        Example example=new Example(FilmCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(filmCategory!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        filmCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FilmCategory
     * @param filmCategory
     */
    @Override
    public void update(FilmCategory filmCategory){
        filmCategoryMapper.updateByPrimaryKey(filmCategory);
    }

    /**
     * 增加FilmCategory
     * @param filmCategory
     */
    @Override
    public void add(FilmCategory filmCategory){
        filmCategoryMapper.insert(filmCategory);
    }

    /**
     * 根据ID查询FilmCategory
     * @param id
     * @return
     */
    @Override
    public FilmCategory findById( id){
        return  filmCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FilmCategory全部数据
     * @return
     */
    @Override
    public List<FilmCategory> findAll() {
        return filmCategoryMapper.selectAll();
    }
}
