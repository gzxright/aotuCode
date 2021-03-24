package com.changgou.order.service.impl;
import com.changgou.order.dao.FuncMapper;
import com.changgou.order.pojo.Func;
import com.changgou.order.service.FuncService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Func业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FuncServiceImpl implements FuncService {

    @Autowired
    private FuncMapper funcMapper;


    /**
     * Func条件+分页查询
     * @param func 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Func> findPage(Func func, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(func);
        //执行搜索
        return new PageInfo<Func>(funcMapper.selectByExample(example));
    }

    /**
     * Func分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Func> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Func>(funcMapper.selectAll());
    }

    /**
     * Func条件查询
     * @param func
     * @return
     */
    @Override
    public List<Func> findList(Func func){
        //构建查询条件
        Example example = createExample(func);
        //根据构建的条件查询数据
        return funcMapper.selectByExample(example);
    }


    /**
     * Func构建查询对象
     * @param func
     * @return
     */
    public Example createExample(Func func){
        Example example=new Example(Func.class);
        Example.Criteria criteria = example.createCriteria();
        if(func!=null){
            // 
            if(!StringUtils.isEmpty(func.getId())){
                    criteria.andEqualTo("id",func.getId());
            }
            // 
            if(!StringUtils.isEmpty(func.getName())){
                    criteria.andLike("name","%"+func.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(func.getDescription())){
                    criteria.andEqualTo("description",func.getDescription());
            }
            // 
            if(!StringUtils.isEmpty(func.getCode())){
                    criteria.andEqualTo("code",func.getCode());
            }
            // 
            if(!StringUtils.isEmpty(func.getUrl())){
                    criteria.andEqualTo("url",func.getUrl());
            }
            // 1表示正常使用；2表示已被禁用
            if(!StringUtils.isEmpty(func.getStatus())){
                    criteria.andEqualTo("status",func.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        funcMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Func
     * @param func
     */
    @Override
    public void update(Func func){
        funcMapper.updateByPrimaryKey(func);
    }

    /**
     * 增加Func
     * @param func
     */
    @Override
    public void add(Func func){
        funcMapper.insert(func);
    }

    /**
     * 根据ID查询Func
     * @param id
     * @return
     */
    @Override
    public Func findById(Integer id){
        return  funcMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Func全部数据
     * @return
     */
    @Override
    public List<Func> findAll() {
        return funcMapper.selectAll();
    }
}
