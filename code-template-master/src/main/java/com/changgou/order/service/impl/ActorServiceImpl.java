package com.changgou.order.service.impl;
import com.changgou.order.dao.ActorMapper;
import com.changgou.order.pojo.Actor;
import com.changgou.order.service.ActorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Actor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorMapper actorMapper;


    /**
     * Actor条件+分页查询
     * @param actor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Actor> findPage(Actor actor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(actor);
        //执行搜索
        return new PageInfo<Actor>(actorMapper.selectByExample(example));
    }

    /**
     * Actor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Actor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Actor>(actorMapper.selectAll());
    }

    /**
     * Actor条件查询
     * @param actor
     * @return
     */
    @Override
    public List<Actor> findList(Actor actor){
        //构建查询条件
        Example example = createExample(actor);
        //根据构建的条件查询数据
        return actorMapper.selectByExample(example);
    }


    /**
     * Actor构建查询对象
     * @param actor
     * @return
     */
    public Example createExample(Actor actor){
        Example example=new Example(Actor.class);
        Example.Criteria criteria = example.createCriteria();
        if(actor!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        actorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Actor
     * @param actor
     */
    @Override
    public void update(Actor actor){
        actorMapper.updateByPrimaryKey(actor);
    }

    /**
     * 增加Actor
     * @param actor
     */
    @Override
    public void add(Actor actor){
        actorMapper.insert(actor);
    }

    /**
     * 根据ID查询Actor
     * @param id
     * @return
     */
    @Override
    public Actor findById( id){
        return  actorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Actor全部数据
     * @return
     */
    @Override
    public List<Actor> findAll() {
        return actorMapper.selectAll();
    }
}
