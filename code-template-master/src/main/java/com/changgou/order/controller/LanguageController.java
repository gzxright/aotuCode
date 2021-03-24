package com.changgou.order.controller;
import com.changgou.order.pojo.Language;
import com.changgou.order.service.LanguageService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "LanguageController")
@RestController
@RequestMapping("/language")
@CrossOrigin
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    /***
     * Language分页条件搜索实现
     * @param language
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Language条件分页查询",notes = "分页条件查询Language方法详情",tags = {"LanguageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Language对象",value = "传入JSON数据",required = false) Language language, @PathVariable  int page, @PathVariable  int size){
        //调用LanguageService实现分页条件查询Language
        PageInfo<Language> pageInfo = languageService.findPage(language, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Language分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Language分页查询",notes = "分页查询Language方法详情",tags = {"LanguageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用LanguageService实现分页查询Language
        PageInfo<Language> pageInfo = languageService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param language
     * @return
     */
    @ApiOperation(value = "Language条件查询",notes = "条件查询Language方法详情",tags = {"LanguageController"})
    @PostMapping(value = "/search" )
    public Result<List<Language>> findList(@RequestBody(required = false) @ApiParam(name = "Language对象",value = "传入JSON数据",required = false) Language language){
        //调用LanguageService实现条件查询Language
        List<Language> list = languageService.findList(language);
        return new Result<List<Language>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Language根据ID删除",notes = "根据ID删除Language方法详情",tags = {"LanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用LanguageService实现根据主键删除
        languageService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Language数据
     * @param language
     * @param id
     * @return
     */
    @ApiOperation(value = "Language根据ID修改",notes = "根据ID修改Language方法详情",tags = {"LanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Language对象",value = "传入JSON数据",required = false) Language language,@PathVariable  id){
        //设置主键值
        language.set(id);
        //调用LanguageService实现修改Language
        languageService.update(language);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Language数据
     * @param language
     * @return
     */
    @ApiOperation(value = "Language添加",notes = "添加Language方法详情",tags = {"LanguageController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Language对象",value = "传入JSON数据",required = true) Language language){
        //调用LanguageService实现添加Language
        languageService.add(language);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Language数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Language根据ID查询",notes = "根据ID查询Language方法详情",tags = {"LanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Language> findById(@PathVariable  id){
        //调用LanguageService实现根据主键查询Language
        Language language = languageService.findById(id);
        return new Result<Language>(true,StatusCode.OK,"查询成功",language);
    }

    /***
     * 查询Language全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Language",notes = "查询所Language有方法详情",tags = {"LanguageController"})
    @GetMapping
    public Result<List<Language>> findAll(){
        //调用LanguageService实现查询所有Language
        List<Language> list = languageService.findAll();
        return new Result<List<Language>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
