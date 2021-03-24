package com.changgou.order.controller;
import com.changgou.order.pojo.FilmCategory;
import com.changgou.order.service.FilmCategoryService;
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
@Api(value = "FilmCategoryController")
@RestController
@RequestMapping("/filmCategory")
@CrossOrigin
public class FilmCategoryController {

    @Autowired
    private FilmCategoryService filmCategoryService;

    /***
     * FilmCategory分页条件搜索实现
     * @param filmCategory
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "FilmCategory条件分页查询",notes = "分页条件查询FilmCategory方法详情",tags = {"FilmCategoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "FilmCategory对象",value = "传入JSON数据",required = false) FilmCategory filmCategory, @PathVariable  int page, @PathVariable  int size){
        //调用FilmCategoryService实现分页条件查询FilmCategory
        PageInfo<FilmCategory> pageInfo = filmCategoryService.findPage(filmCategory, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FilmCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "FilmCategory分页查询",notes = "分页查询FilmCategory方法详情",tags = {"FilmCategoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FilmCategoryService实现分页查询FilmCategory
        PageInfo<FilmCategory> pageInfo = filmCategoryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param filmCategory
     * @return
     */
    @ApiOperation(value = "FilmCategory条件查询",notes = "条件查询FilmCategory方法详情",tags = {"FilmCategoryController"})
    @PostMapping(value = "/search" )
    public Result<List<FilmCategory>> findList(@RequestBody(required = false) @ApiParam(name = "FilmCategory对象",value = "传入JSON数据",required = false) FilmCategory filmCategory){
        //调用FilmCategoryService实现条件查询FilmCategory
        List<FilmCategory> list = filmCategoryService.findList(filmCategory);
        return new Result<List<FilmCategory>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmCategory根据ID删除",notes = "根据ID删除FilmCategory方法详情",tags = {"FilmCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用FilmCategoryService实现根据主键删除
        filmCategoryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FilmCategory数据
     * @param filmCategory
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmCategory根据ID修改",notes = "根据ID修改FilmCategory方法详情",tags = {"FilmCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "FilmCategory对象",value = "传入JSON数据",required = false) FilmCategory filmCategory,@PathVariable  id){
        //设置主键值
        filmCategory.set(id);
        //调用FilmCategoryService实现修改FilmCategory
        filmCategoryService.update(filmCategory);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FilmCategory数据
     * @param filmCategory
     * @return
     */
    @ApiOperation(value = "FilmCategory添加",notes = "添加FilmCategory方法详情",tags = {"FilmCategoryController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "FilmCategory对象",value = "传入JSON数据",required = true) FilmCategory filmCategory){
        //调用FilmCategoryService实现添加FilmCategory
        filmCategoryService.add(filmCategory);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FilmCategory数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmCategory根据ID查询",notes = "根据ID查询FilmCategory方法详情",tags = {"FilmCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<FilmCategory> findById(@PathVariable  id){
        //调用FilmCategoryService实现根据主键查询FilmCategory
        FilmCategory filmCategory = filmCategoryService.findById(id);
        return new Result<FilmCategory>(true,StatusCode.OK,"查询成功",filmCategory);
    }

    /***
     * 查询FilmCategory全部数据
     * @return
     */
    @ApiOperation(value = "查询所有FilmCategory",notes = "查询所FilmCategory有方法详情",tags = {"FilmCategoryController"})
    @GetMapping
    public Result<List<FilmCategory>> findAll(){
        //调用FilmCategoryService实现查询所有FilmCategory
        List<FilmCategory> list = filmCategoryService.findAll();
        return new Result<List<FilmCategory>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
