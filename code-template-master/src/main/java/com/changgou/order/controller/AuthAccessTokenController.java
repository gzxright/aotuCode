package com.changgou.order.controller;
import com.changgou.order.pojo.AuthAccessToken;
import com.changgou.order.service.AuthAccessTokenService;
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
@Api(value = "AuthAccessTokenController")
@RestController
@RequestMapping("/authAccessToken")
@CrossOrigin
public class AuthAccessTokenController {

    @Autowired
    private AuthAccessTokenService authAccessTokenService;

    /***
     * AuthAccessToken分页条件搜索实现
     * @param authAccessToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AuthAccessToken条件分页查询",notes = "分页条件查询AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AuthAccessToken对象",value = "传入JSON数据",required = false) AuthAccessToken authAccessToken, @PathVariable  int page, @PathVariable  int size){
        //调用AuthAccessTokenService实现分页条件查询AuthAccessToken
        PageInfo<AuthAccessToken> pageInfo = authAccessTokenService.findPage(authAccessToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AuthAccessToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AuthAccessToken分页查询",notes = "分页查询AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AuthAccessTokenService实现分页查询AuthAccessToken
        PageInfo<AuthAccessToken> pageInfo = authAccessTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param authAccessToken
     * @return
     */
    @ApiOperation(value = "AuthAccessToken条件查询",notes = "条件查询AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<AuthAccessToken>> findList(@RequestBody(required = false) @ApiParam(name = "AuthAccessToken对象",value = "传入JSON数据",required = false) AuthAccessToken authAccessToken){
        //调用AuthAccessTokenService实现条件查询AuthAccessToken
        List<AuthAccessToken> list = authAccessTokenService.findList(authAccessToken);
        return new Result<List<AuthAccessToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthAccessToken根据ID删除",notes = "根据ID删除AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AuthAccessTokenService实现根据主键删除
        authAccessTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AuthAccessToken数据
     * @param authAccessToken
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthAccessToken根据ID修改",notes = "根据ID修改AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AuthAccessToken对象",value = "传入JSON数据",required = false) AuthAccessToken authAccessToken,@PathVariable Integer id){
        //设置主键值
        authAccessToken.setId(id);
        //调用AuthAccessTokenService实现修改AuthAccessToken
        authAccessTokenService.update(authAccessToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AuthAccessToken数据
     * @param authAccessToken
     * @return
     */
    @ApiOperation(value = "AuthAccessToken添加",notes = "添加AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AuthAccessToken对象",value = "传入JSON数据",required = true) AuthAccessToken authAccessToken){
        //调用AuthAccessTokenService实现添加AuthAccessToken
        authAccessTokenService.add(authAccessToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AuthAccessToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthAccessToken根据ID查询",notes = "根据ID查询AuthAccessToken方法详情",tags = {"AuthAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AuthAccessToken> findById(@PathVariable Integer id){
        //调用AuthAccessTokenService实现根据主键查询AuthAccessToken
        AuthAccessToken authAccessToken = authAccessTokenService.findById(id);
        return new Result<AuthAccessToken>(true,StatusCode.OK,"查询成功",authAccessToken);
    }

    /***
     * 查询AuthAccessToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AuthAccessToken",notes = "查询所AuthAccessToken有方法详情",tags = {"AuthAccessTokenController"})
    @GetMapping
    public Result<List<AuthAccessToken>> findAll(){
        //调用AuthAccessTokenService实现查询所有AuthAccessToken
        List<AuthAccessToken> list = authAccessTokenService.findAll();
        return new Result<List<AuthAccessToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
