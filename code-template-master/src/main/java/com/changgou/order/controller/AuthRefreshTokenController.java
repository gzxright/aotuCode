package com.changgou.order.controller;
import com.changgou.order.pojo.AuthRefreshToken;
import com.changgou.order.service.AuthRefreshTokenService;
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
@Api(value = "AuthRefreshTokenController")
@RestController
@RequestMapping("/authRefreshToken")
@CrossOrigin
public class AuthRefreshTokenController {

    @Autowired
    private AuthRefreshTokenService authRefreshTokenService;

    /***
     * AuthRefreshToken分页条件搜索实现
     * @param authRefreshToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken条件分页查询",notes = "分页条件查询AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AuthRefreshToken对象",value = "传入JSON数据",required = false) AuthRefreshToken authRefreshToken, @PathVariable  int page, @PathVariable  int size){
        //调用AuthRefreshTokenService实现分页条件查询AuthRefreshToken
        PageInfo<AuthRefreshToken> pageInfo = authRefreshTokenService.findPage(authRefreshToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AuthRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken分页查询",notes = "分页查询AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AuthRefreshTokenService实现分页查询AuthRefreshToken
        PageInfo<AuthRefreshToken> pageInfo = authRefreshTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param authRefreshToken
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken条件查询",notes = "条件查询AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<AuthRefreshToken>> findList(@RequestBody(required = false) @ApiParam(name = "AuthRefreshToken对象",value = "传入JSON数据",required = false) AuthRefreshToken authRefreshToken){
        //调用AuthRefreshTokenService实现条件查询AuthRefreshToken
        List<AuthRefreshToken> list = authRefreshTokenService.findList(authRefreshToken);
        return new Result<List<AuthRefreshToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken根据ID删除",notes = "根据ID删除AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AuthRefreshTokenService实现根据主键删除
        authRefreshTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AuthRefreshToken数据
     * @param authRefreshToken
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken根据ID修改",notes = "根据ID修改AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AuthRefreshToken对象",value = "传入JSON数据",required = false) AuthRefreshToken authRefreshToken,@PathVariable Integer id){
        //设置主键值
        authRefreshToken.setId(id);
        //调用AuthRefreshTokenService实现修改AuthRefreshToken
        authRefreshTokenService.update(authRefreshToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AuthRefreshToken数据
     * @param authRefreshToken
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken添加",notes = "添加AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AuthRefreshToken对象",value = "传入JSON数据",required = true) AuthRefreshToken authRefreshToken){
        //调用AuthRefreshTokenService实现添加AuthRefreshToken
        authRefreshTokenService.add(authRefreshToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AuthRefreshToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthRefreshToken根据ID查询",notes = "根据ID查询AuthRefreshToken方法详情",tags = {"AuthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AuthRefreshToken> findById(@PathVariable Integer id){
        //调用AuthRefreshTokenService实现根据主键查询AuthRefreshToken
        AuthRefreshToken authRefreshToken = authRefreshTokenService.findById(id);
        return new Result<AuthRefreshToken>(true,StatusCode.OK,"查询成功",authRefreshToken);
    }

    /***
     * 查询AuthRefreshToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AuthRefreshToken",notes = "查询所AuthRefreshToken有方法详情",tags = {"AuthRefreshTokenController"})
    @GetMapping
    public Result<List<AuthRefreshToken>> findAll(){
        //调用AuthRefreshTokenService实现查询所有AuthRefreshToken
        List<AuthRefreshToken> list = authRefreshTokenService.findAll();
        return new Result<List<AuthRefreshToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
