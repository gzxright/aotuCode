package com.changgou.order.controller;
import com.changgou.order.pojo.Roles;
import com.changgou.order.service.RolesService;
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
@Api(value = "RolesController")
@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolesController {

    @Autowired
    private RolesService rolesService;

    /***
     * Roles分页条件搜索实现
     * @param roles
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Roles条件分页查询",notes = "分页条件查询Roles方法详情",tags = {"RolesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Roles对象",value = "传入JSON数据",required = false) Roles roles, @PathVariable  int page, @PathVariable  int size){
        //调用RolesService实现分页条件查询Roles
        PageInfo<Roles> pageInfo = rolesService.findPage(roles, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Roles分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Roles分页查询",notes = "分页查询Roles方法详情",tags = {"RolesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RolesService实现分页查询Roles
        PageInfo<Roles> pageInfo = rolesService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param roles
     * @return
     */
    @ApiOperation(value = "Roles条件查询",notes = "条件查询Roles方法详情",tags = {"RolesController"})
    @PostMapping(value = "/search" )
    public Result<List<Roles>> findList(@RequestBody(required = false) @ApiParam(name = "Roles对象",value = "传入JSON数据",required = false) Roles roles){
        //调用RolesService实现条件查询Roles
        List<Roles> list = rolesService.findList(roles);
        return new Result<List<Roles>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Roles根据ID删除",notes = "根据ID删除Roles方法详情",tags = {"RolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用RolesService实现根据主键删除
        rolesService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Roles数据
     * @param roles
     * @param id
     * @return
     */
    @ApiOperation(value = "Roles根据ID修改",notes = "根据ID修改Roles方法详情",tags = {"RolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Roles对象",value = "传入JSON数据",required = false) Roles roles,@PathVariable  id){
        //设置主键值
        roles.set(id);
        //调用RolesService实现修改Roles
        rolesService.update(roles);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Roles数据
     * @param roles
     * @return
     */
    @ApiOperation(value = "Roles添加",notes = "添加Roles方法详情",tags = {"RolesController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Roles对象",value = "传入JSON数据",required = true) Roles roles){
        //调用RolesService实现添加Roles
        rolesService.add(roles);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Roles数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Roles根据ID查询",notes = "根据ID查询Roles方法详情",tags = {"RolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Roles> findById(@PathVariable  id){
        //调用RolesService实现根据主键查询Roles
        Roles roles = rolesService.findById(id);
        return new Result<Roles>(true,StatusCode.OK,"查询成功",roles);
    }

    /***
     * 查询Roles全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Roles",notes = "查询所Roles有方法详情",tags = {"RolesController"})
    @GetMapping
    public Result<List<Roles>> findAll(){
        //调用RolesService实现查询所有Roles
        List<Roles> list = rolesService.findAll();
        return new Result<List<Roles>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
