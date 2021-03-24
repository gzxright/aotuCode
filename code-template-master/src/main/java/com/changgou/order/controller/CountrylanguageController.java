package com.changgou.order.controller;
import com.changgou.order.pojo.Countrylanguage;
import com.changgou.order.service.CountrylanguageService;
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
@Api(value = "CountrylanguageController")
@RestController
@RequestMapping("/countrylanguage")
@CrossOrigin
public class CountrylanguageController {

    @Autowired
    private CountrylanguageService countrylanguageService;

    /***
     * Countrylanguage分页条件搜索实现
     * @param countrylanguage
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Countrylanguage条件分页查询",notes = "分页条件查询Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Countrylanguage对象",value = "传入JSON数据",required = false) Countrylanguage countrylanguage, @PathVariable  int page, @PathVariable  int size){
        //调用CountrylanguageService实现分页条件查询Countrylanguage
        PageInfo<Countrylanguage> pageInfo = countrylanguageService.findPage(countrylanguage, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Countrylanguage分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Countrylanguage分页查询",notes = "分页查询Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CountrylanguageService实现分页查询Countrylanguage
        PageInfo<Countrylanguage> pageInfo = countrylanguageService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param countrylanguage
     * @return
     */
    @ApiOperation(value = "Countrylanguage条件查询",notes = "条件查询Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @PostMapping(value = "/search" )
    public Result<List<Countrylanguage>> findList(@RequestBody(required = false) @ApiParam(name = "Countrylanguage对象",value = "传入JSON数据",required = false) Countrylanguage countrylanguage){
        //调用CountrylanguageService实现条件查询Countrylanguage
        List<Countrylanguage> list = countrylanguageService.findList(countrylanguage);
        return new Result<List<Countrylanguage>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Countrylanguage根据ID删除",notes = "根据ID删除Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用CountrylanguageService实现根据主键删除
        countrylanguageService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Countrylanguage数据
     * @param countrylanguage
     * @param id
     * @return
     */
    @ApiOperation(value = "Countrylanguage根据ID修改",notes = "根据ID修改Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Countrylanguage对象",value = "传入JSON数据",required = false) Countrylanguage countrylanguage,@PathVariable  id){
        //设置主键值
        countrylanguage.set(id);
        //调用CountrylanguageService实现修改Countrylanguage
        countrylanguageService.update(countrylanguage);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Countrylanguage数据
     * @param countrylanguage
     * @return
     */
    @ApiOperation(value = "Countrylanguage添加",notes = "添加Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Countrylanguage对象",value = "传入JSON数据",required = true) Countrylanguage countrylanguage){
        //调用CountrylanguageService实现添加Countrylanguage
        countrylanguageService.add(countrylanguage);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Countrylanguage数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Countrylanguage根据ID查询",notes = "根据ID查询Countrylanguage方法详情",tags = {"CountrylanguageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Countrylanguage> findById(@PathVariable  id){
        //调用CountrylanguageService实现根据主键查询Countrylanguage
        Countrylanguage countrylanguage = countrylanguageService.findById(id);
        return new Result<Countrylanguage>(true,StatusCode.OK,"查询成功",countrylanguage);
    }

    /***
     * 查询Countrylanguage全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Countrylanguage",notes = "查询所Countrylanguage有方法详情",tags = {"CountrylanguageController"})
    @GetMapping
    public Result<List<Countrylanguage>> findAll(){
        //调用CountrylanguageService实现查询所有Countrylanguage
        List<Countrylanguage> list = countrylanguageService.findAll();
        return new Result<List<Countrylanguage>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
