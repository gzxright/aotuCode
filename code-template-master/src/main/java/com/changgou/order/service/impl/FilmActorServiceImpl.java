package com.changgou.order.service.impl;
import com.changgou.order.dao.FilmActorMapper;
import com.changgou.order.pojo.FilmActor;
import com.changgou.order.service.FilmActorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:FilmActor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FilmActorServiceImpl implements FilmActorService {

    @Autowired
    private FilmActorMapper filmActorMapper;


    /**
     * FilmActor条件+分页查询
     * @param filmActor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FilmActor> findPage(FilmActor filmActor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(filmActor);
        //执行搜索
        return new PageInfo<FilmActor>(filmActorMapper.selectByExample(example));
    }

    /**
     * FilmActor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FilmActor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FilmActor>(filmActorMapper.selectAll());
    }

    /**
     * FilmActor条件查询
     * @param filmActor
     * @return
     */
    @Override
    public List<FilmActor> findList(FilmActor filmActor){
        //构建查询条件
        Example example = createExample(filmActor);
        //根据构建的条件查询数据
        return filmActorMapper.selectByExample(example);
    }


    /**
     * FilmActor构建查询对象
     * @param filmActor
     * @return
     */
    public Example createExample(FilmActor filmActor){
        Example example=new Example(FilmActor.class);
        Example.Criteria criteria = example.createCriteria();
        if(filmActor!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        filmActorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FilmActor
     * @param filmActor
     */
    @Override
    public void update(FilmActor filmActor){
        filmActorMapper.updateByPrimaryKey(filmActor);
    }

    /**
     * 增加FilmActor
     * @param filmActor
     */
    @Override
    public void add(FilmActor filmActor){
        filmActorMapper.insert(filmActor);
    }

    /**
     * 根据ID查询FilmActor
     * @param id
     * @return
     */
    @Override
    public FilmActor findById( id){
        return  filmActorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FilmActor全部数据
     * @return
     */
    @Override
    public List<FilmActor> findAll() {
        return filmActorMapper.selectAll();
    }
}
