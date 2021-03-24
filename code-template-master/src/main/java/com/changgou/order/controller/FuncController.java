package com.changgou.order.controller;
import com.changgou.order.pojo.Func;
import com.changgou.order.service.FuncService;
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
@Api(value = "FuncController")
@RestController
@RequestMapping("/func")
@CrossOrigin
public class FuncController {

    @Autowired
    private FuncService funcService;

    /***
     * Func分页条件搜索实现
     * @param func
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Func条件分页查询",notes = "分页条件查询Func方法详情",tags = {"FuncController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Func对象",value = "传入JSON数据",required = false) Func func, @PathVariable  int page, @PathVariable  int size){
        //调用FuncService实现分页条件查询Func
        PageInfo<Func> pageInfo = funcService.findPage(func, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Func分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Func分页查询",notes = "分页查询Func方法详情",tags = {"FuncController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FuncService实现分页查询Func
        PageInfo<Func> pageInfo = funcService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param func
     * @return
     */
    @ApiOperation(value = "Func条件查询",notes = "条件查询Func方法详情",tags = {"FuncController"})
    @PostMapping(value = "/search" )
    public Result<List<Func>> findList(@RequestBody(required = false) @ApiParam(name = "Func对象",value = "传入JSON数据",required = false) Func func){
        //调用FuncService实现条件查询Func
        List<Func> list = funcService.findList(func);
        return new Result<List<Func>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Func根据ID删除",notes = "根据ID删除Func方法详情",tags = {"FuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FuncService实现根据主键删除
        funcService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Func数据
     * @param func
     * @param id
     * @return
     */
    @ApiOperation(value = "Func根据ID修改",notes = "根据ID修改Func方法详情",tags = {"FuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Func对象",value = "传入JSON数据",required = false) Func func,@PathVariable Integer id){
        //设置主键值
        func.setId(id);
        //调用FuncService实现修改Func
        funcService.update(func);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Func数据
     * @param func
     * @return
     */
    @ApiOperation(value = "Func添加",notes = "添加Func方法详情",tags = {"FuncController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Func对象",value = "传入JSON数据",required = true) Func func){
        //调用FuncService实现添加Func
        funcService.add(func);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Func数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Func根据ID查询",notes = "根据ID查询Func方法详情",tags = {"FuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Func> findById(@PathVariable Integer id){
        //调用FuncService实现根据主键查询Func
        Func func = funcService.findById(id);
        return new Result<Func>(true,StatusCode.OK,"查询成功",func);
    }

    /***
     * 查询Func全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Func",notes = "查询所Func有方法详情",tags = {"FuncController"})
    @GetMapping
    public Result<List<Func>> findAll(){
        //调用FuncService实现查询所有Func
        List<Func> list = funcService.findAll();
        return new Result<List<Func>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
