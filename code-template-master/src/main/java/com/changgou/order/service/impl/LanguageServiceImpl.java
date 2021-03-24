package com.changgou.order.service.impl;
import com.changgou.order.dao.LanguageMapper;
import com.changgou.order.pojo.Language;
import com.changgou.order.service.LanguageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Language业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageMapper languageMapper;


    /**
     * Language条件+分页查询
     * @param language 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Language> findPage(Language language, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(language);
        //执行搜索
        return new PageInfo<Language>(languageMapper.selectByExample(example));
    }

    /**
     * Language分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Language> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Language>(languageMapper.selectAll());
    }

    /**
     * Language条件查询
     * @param language
     * @return
     */
    @Override
    public List<Language> findList(Language language){
        //构建查询条件
        Example example = createExample(language);
        //根据构建的条件查询数据
        return languageMapper.selectByExample(example);
    }


    /**
     * Language构建查询对象
     * @param language
     * @return
     */
    public Example createExample(Language language){
        Example example=new Example(Language.class);
        Example.Criteria criteria = example.createCriteria();
        if(language!=null){
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete( id){
        languageMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Language
     * @param language
     */
    @Override
    public void update(Language language){
        languageMapper.updateByPrimaryKey(language);
    }

    /**
     * 增加Language
     * @param language
     */
    @Override
    public void add(Language language){
        languageMapper.insert(language);
    }

    /**
     * 根据ID查询Language
     * @param id
     * @return
     */
    @Override
    public Language findById( id){
        return  languageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Language全部数据
     * @return
     */
    @Override
    public List<Language> findAll() {
        return languageMapper.selectAll();
    }
}
