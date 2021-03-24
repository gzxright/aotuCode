package com.changgou.order.service.impl;
import com.changgou.order.dao.UsersMapper;
import com.changgou.order.pojo.Users;
import com.changgou.order.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Users业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    /**
     * Users条件+分页查询
     * @param users 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Users> findPage(Users users, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(users);
        //执行搜索
        return new PageInfo<Users>(usersMapper.selectByExample(example));
    }

    /**
     * Users分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Users> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Users>(usersMapper.selectAll());
    }

    /**
     * Users条件查询
     * @param users
     * @return
     */
    @Override
    public List<Users> findList(Users users){
        //构建查询条件
        Example example = createExample(users);
        //根据构建的条件查询数据
        return usersMapper.selectByExample(example);
    }


    /**
     * Users构建查询对象
     * @param users
     * @return
     */
    public Example createExample(Users users){
        Example example=new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        if(users!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        usersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Users
     * @param users
     */
    @Override
    public void update(Users users){
        usersMapper.updateByPrimaryKey(users);
    }

    /**
     * 增加Users
     * @param users
     */
    @Override
    public void add(Users users){
        usersMapper.insert(users);
    }

    /**
     * 根据ID查询Users
     * @param id
     * @return
     */
    @Override
    public Users findById( id){
        return  usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Users全部数据
     * @return
     */
    @Override
    public List<Users> findAll() {
        return usersMapper.selectAll();
    }
}
