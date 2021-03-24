package com.changgou.order.service.impl;
import com.changgou.order.dao.InventoryMapper;
import com.changgou.order.pojo.Inventory;
import com.changgou.order.service.InventoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Inventory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;


    /**
     * Inventory条件+分页查询
     * @param inventory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Inventory> findPage(Inventory inventory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(inventory);
        //执行搜索
        return new PageInfo<Inventory>(inventoryMapper.selectByExample(example));
    }

    /**
     * Inventory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Inventory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Inventory>(inventoryMapper.selectAll());
    }

    /**
     * Inventory条件查询
     * @param inventory
     * @return
     */
    @Override
    public List<Inventory> findList(Inventory inventory){
        //构建查询条件
        Example example = createExample(inventory);
        //根据构建的条件查询数据
        return inventoryMapper.selectByExample(example);
    }


    /**
     * Inventory构建查询对象
     * @param inventory
     * @return
     */
    public Example createExample(Inventory inventory){
        Example example=new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        if(inventory!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        inventoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Inventory
     * @param inventory
     */
    @Override
    public void update(Inventory inventory){
        inventoryMapper.updateByPrimaryKey(inventory);
    }

    /**
     * 增加Inventory
     * @param inventory
     */
    @Override
    public void add(Inventory inventory){
        inventoryMapper.insert(inventory);
    }

    /**
     * 根据ID查询Inventory
     * @param id
     * @return
     */
    @Override
    public Inventory findById( id){
        return  inventoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Inventory全部数据
     * @return
     */
    @Override
    public List<Inventory> findAll() {
        return inventoryMapper.selectAll();
    }
}
