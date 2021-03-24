package com.changgou.order.controller;
import com.changgou.order.pojo.ConfigTagsRelation;
import com.changgou.order.service.ConfigTagsRelationService;
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
@Api(value = "ConfigTagsRelationController")
@RestController
@RequestMapping("/configTagsRelation")
@CrossOrigin
public class ConfigTagsRelationController {

    @Autowired
    private ConfigTagsRelationService configTagsRelationService;

    /***
     * ConfigTagsRelation分页条件搜索实现
     * @param configTagsRelation
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation条件分页查询",notes = "分页条件查询ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ConfigTagsRelation对象",value = "传入JSON数据",required = false) ConfigTagsRelation configTagsRelation, @PathVariable  int page, @PathVariable  int size){
        //调用ConfigTagsRelationService实现分页条件查询ConfigTagsRelation
        PageInfo<ConfigTagsRelation> pageInfo = configTagsRelationService.findPage(configTagsRelation, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ConfigTagsRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation分页查询",notes = "分页查询ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConfigTagsRelationService实现分页查询ConfigTagsRelation
        PageInfo<ConfigTagsRelation> pageInfo = configTagsRelationService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param configTagsRelation
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation条件查询",notes = "条件查询ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @PostMapping(value = "/search" )
    public Result<List<ConfigTagsRelation>> findList(@RequestBody(required = false) @ApiParam(name = "ConfigTagsRelation对象",value = "传入JSON数据",required = false) ConfigTagsRelation configTagsRelation){
        //调用ConfigTagsRelationService实现条件查询ConfigTagsRelation
        List<ConfigTagsRelation> list = configTagsRelationService.findList(configTagsRelation);
        return new Result<List<ConfigTagsRelation>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation根据ID删除",notes = "根据ID删除ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ConfigTagsRelationService实现根据主键删除
        configTagsRelationService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ConfigTagsRelation数据
     * @param configTagsRelation
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation根据ID修改",notes = "根据ID修改ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ConfigTagsRelation对象",value = "传入JSON数据",required = false) ConfigTagsRelation configTagsRelation,@PathVariable  id){
        //设置主键值
        configTagsRelation.set(id);
        //调用ConfigTagsRelationService实现修改ConfigTagsRelation
        configTagsRelationService.update(configTagsRelation);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ConfigTagsRelation数据
     * @param configTagsRelation
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation添加",notes = "添加ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ConfigTagsRelation对象",value = "传入JSON数据",required = true) ConfigTagsRelation configTagsRelation){
        //调用ConfigTagsRelationService实现添加ConfigTagsRelation
        configTagsRelationService.add(configTagsRelation);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ConfigTagsRelation数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigTagsRelation根据ID查询",notes = "根据ID查询ConfigTagsRelation方法详情",tags = {"ConfigTagsRelationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ConfigTagsRelation> findById(@PathVariable  id){
        //调用ConfigTagsRelationService实现根据主键查询ConfigTagsRelation
        ConfigTagsRelation configTagsRelation = configTagsRelationService.findById(id);
        return new Result<ConfigTagsRelation>(true,StatusCode.OK,"查询成功",configTagsRelation);
    }

    /***
     * 查询ConfigTagsRelation全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ConfigTagsRelation",notes = "查询所ConfigTagsRelation有方法详情",tags = {"ConfigTagsRelationController"})
    @GetMapping
    public Result<List<ConfigTagsRelation>> findAll(){
        //调用ConfigTagsRelationService实现查询所有ConfigTagsRelation
        List<ConfigTagsRelation> list = configTagsRelationService.findAll();
        return new Result<List<ConfigTagsRelation>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
