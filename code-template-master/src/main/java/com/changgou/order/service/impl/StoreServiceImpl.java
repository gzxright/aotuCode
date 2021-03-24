package com.changgou.order.service.impl;
import com.changgou.order.dao.StoreMapper;
import com.changgou.order.pojo.Store;
import com.changgou.order.service.StoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Store业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;


    /**
     * Store条件+分页查询
     * @param store 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Store> findPage(Store store, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(store);
        //执行搜索
        return new PageInfo<Store>(storeMapper.selectByExample(example));
    }

    /**
     * Store分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Store> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Store>(storeMapper.selectAll());
    }

    /**
     * Store条件查询
     * @param store
     * @return
     */
    @Override
    public List<Store> findList(Store store){
        //构建查询条件
        Example example = createExample(store);
        //根据构建的条件查询数据
        return storeMapper.selectByExample(example);
    }


    /**
     * Store构建查询对象
     * @param store
     * @return
     */
    public Example createExample(Store store){
        Example example=new Example(Store.class);
        Example.Criteria criteria = example.createCriteria();
        if(store!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        storeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Store
     * @param store
     */
    @Override
    public void update(Store store){
        storeMapper.updateByPrimaryKey(store);
    }

    /**
     * 增加Store
     * @param store
     */
    @Override
    public void add(Store store){
        storeMapper.insert(store);
    }

    /**
     * 根据ID查询Store
     * @param id
     * @return
     */
    @Override
    public Store findById( id){
        return  storeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Store全部数据
     * @return
     */
    @Override
    public List<Store> findAll() {
        return storeMapper.selectAll();
    }
}
