package com.changgou.order.controller;
import com.changgou.order.pojo.Permissions;
import com.changgou.order.service.PermissionsService;
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
@Api(value = "PermissionsController")
@RestController
@RequestMapping("/permissions")
@CrossOrigin
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    /***
     * Permissions分页条件搜索实现
     * @param permissions
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Permissions条件分页查询",notes = "分页条件查询Permissions方法详情",tags = {"PermissionsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Permissions对象",value = "传入JSON数据",required = false) Permissions permissions, @PathVariable  int page, @PathVariable  int size){
        //调用PermissionsService实现分页条件查询Permissions
        PageInfo<Permissions> pageInfo = permissionsService.findPage(permissions, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Permissions分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Permissions分页查询",notes = "分页查询Permissions方法详情",tags = {"PermissionsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PermissionsService实现分页查询Permissions
        PageInfo<Permissions> pageInfo = permissionsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param permissions
     * @return
     */
    @ApiOperation(value = "Permissions条件查询",notes = "条件查询Permissions方法详情",tags = {"PermissionsController"})
    @PostMapping(value = "/search" )
    public Result<List<Permissions>> findList(@RequestBody(required = false) @ApiParam(name = "Permissions对象",value = "传入JSON数据",required = false) Permissions permissions){
        //调用PermissionsService实现条件查询Permissions
        List<Permissions> list = permissionsService.findList(permissions);
        return new Result<List<Permissions>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Permissions根据ID删除",notes = "根据ID删除Permissions方法详情",tags = {"PermissionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用PermissionsService实现根据主键删除
        permissionsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Permissions数据
     * @param permissions
     * @param id
     * @return
     */
    @ApiOperation(value = "Permissions根据ID修改",notes = "根据ID修改Permissions方法详情",tags = {"PermissionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Permissions对象",value = "传入JSON数据",required = false) Permissions permissions,@PathVariable  id){
        //设置主键值
        permissions.set(id);
        //调用PermissionsService实现修改Permissions
        permissionsService.update(permissions);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Permissions数据
     * @param permissions
     * @return
     */
    @ApiOperation(value = "Permissions添加",notes = "添加Permissions方法详情",tags = {"PermissionsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Permissions对象",value = "传入JSON数据",required = true) Permissions permissions){
        //调用PermissionsService实现添加Permissions
        permissionsService.add(permissions);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Permissions数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Permissions根据ID查询",notes = "根据ID查询Permissions方法详情",tags = {"PermissionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Permissions> findById(@PathVariable  id){
        //调用PermissionsService实现根据主键查询Permissions
        Permissions permissions = permissionsService.findById(id);
        return new Result<Permissions>(true,StatusCode.OK,"查询成功",permissions);
    }

    /***
     * 查询Permissions全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Permissions",notes = "查询所Permissions有方法详情",tags = {"PermissionsController"})
    @GetMapping
    public Result<List<Permissions>> findAll(){
        //调用PermissionsService实现查询所有Permissions
        List<Permissions> list = permissionsService.findAll();
        return new Result<List<Permissions>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
