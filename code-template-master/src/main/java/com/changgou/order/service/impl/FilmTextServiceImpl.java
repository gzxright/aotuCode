package com.changgou.order.service.impl;
import com.changgou.order.dao.FilmTextMapper;
import com.changgou.order.pojo.FilmText;
import com.changgou.order.service.FilmTextService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmText业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FilmTextServiceImpl implements FilmTextService {

    @Autowired
    private FilmTextMapper filmTextMapper;


    /**
     * FilmText条件+分页查询
     * @param filmText 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FilmText> findPage(FilmText filmText, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(filmText);
        //执行搜索
        return new PageInfo<FilmText>(filmTextMapper.selectByExample(example));
    }

    /**
     * FilmText分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FilmText> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FilmText>(filmTextMapper.selectAll());
    }

    /**
     * FilmText条件查询
     * @param filmText
     * @return
     */
    @Override
    public List<FilmText> findList(FilmText filmText){
        //构建查询条件
        Example example = createExample(filmText);
        //根据构建的条件查询数据
        return filmTextMapper.selectByExample(example);
    }


    /**
     * FilmText构建查询对象
     * @param filmText
     * @return
     */
    public Example createExample(FilmText filmText){
        Example example=new Example(FilmText.class);
        Example.Criteria criteria = example.createCriteria();
        if(filmText!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        filmTextMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FilmText
     * @param filmText
     */
    @Override
    public void update(FilmText filmText){
        filmTextMapper.updateByPrimaryKey(filmText);
    }

    /**
     * 增加FilmText
     * @param filmText
     */
    @Override
    public void add(FilmText filmText){
        filmTextMapper.insert(filmText);
    }

    /**
     * 根据ID查询FilmText
     * @param id
     * @return
     */
    @Override
    public FilmText findById( id){
        return  filmTextMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FilmText全部数据
     * @return
     */
    @Override
    public List<FilmText> findAll() {
        return filmTextMapper.selectAll();
    }
}
