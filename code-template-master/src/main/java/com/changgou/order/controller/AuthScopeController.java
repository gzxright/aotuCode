package com.changgou.order.controller;
import com.changgou.order.pojo.AuthScope;
import com.changgou.order.service.AuthScopeService;
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
@Api(value = "AuthScopeController")
@RestController
@RequestMapping("/authScope")
@CrossOrigin
public class AuthScopeController {

    @Autowired
    private AuthScopeService authScopeService;

    /***
     * AuthScope分页条件搜索实现
     * @param authScope
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AuthScope条件分页查询",notes = "分页条件查询AuthScope方法详情",tags = {"AuthScopeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AuthScope对象",value = "传入JSON数据",required = false) AuthScope authScope, @PathVariable  int page, @PathVariable  int size){
        //调用AuthScopeService实现分页条件查询AuthScope
        PageInfo<AuthScope> pageInfo = authScopeService.findPage(authScope, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AuthScope分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AuthScope分页查询",notes = "分页查询AuthScope方法详情",tags = {"AuthScopeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AuthScopeService实现分页查询AuthScope
        PageInfo<AuthScope> pageInfo = authScopeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param authScope
     * @return
     */
    @ApiOperation(value = "AuthScope条件查询",notes = "条件查询AuthScope方法详情",tags = {"AuthScopeController"})
    @PostMapping(value = "/search" )
    public Result<List<AuthScope>> findList(@RequestBody(required = false) @ApiParam(name = "AuthScope对象",value = "传入JSON数据",required = false) AuthScope authScope){
        //调用AuthScopeService实现条件查询AuthScope
        List<AuthScope> list = authScopeService.findList(authScope);
        return new Result<List<AuthScope>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthScope根据ID删除",notes = "根据ID删除AuthScope方法详情",tags = {"AuthScopeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AuthScopeService实现根据主键删除
        authScopeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AuthScope数据
     * @param authScope
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthScope根据ID修改",notes = "根据ID修改AuthScope方法详情",tags = {"AuthScopeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AuthScope对象",value = "传入JSON数据",required = false) AuthScope authScope,@PathVariable Integer id){
        //设置主键值
        authScope.setId(id);
        //调用AuthScopeService实现修改AuthScope
        authScopeService.update(authScope);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AuthScope数据
     * @param authScope
     * @return
     */
    @ApiOperation(value = "AuthScope添加",notes = "添加AuthScope方法详情",tags = {"AuthScopeController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AuthScope对象",value = "传入JSON数据",required = true) AuthScope authScope){
        //调用AuthScopeService实现添加AuthScope
        authScopeService.add(authScope);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AuthScope数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthScope根据ID查询",notes = "根据ID查询AuthScope方法详情",tags = {"AuthScopeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AuthScope> findById(@PathVariable Integer id){
        //调用AuthScopeService实现根据主键查询AuthScope
        AuthScope authScope = authScopeService.findById(id);
        return new Result<AuthScope>(true,StatusCode.OK,"查询成功",authScope);
    }

    /***
     * 查询AuthScope全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AuthScope",notes = "查询所AuthScope有方法详情",tags = {"AuthScopeController"})
    @GetMapping
    public Result<List<AuthScope>> findAll(){
        //调用AuthScopeService实现查询所有AuthScope
        List<AuthScope> list = authScopeService.findAll();
        return new Result<List<AuthScope>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
