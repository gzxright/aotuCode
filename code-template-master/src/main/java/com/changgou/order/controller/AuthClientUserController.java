package com.changgou.order.controller;
import com.changgou.order.pojo.AuthClientUser;
import com.changgou.order.service.AuthClientUserService;
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
@Api(value = "AuthClientUserController")
@RestController
@RequestMapping("/authClientUser")
@CrossOrigin
public class AuthClientUserController {

    @Autowired
    private AuthClientUserService authClientUserService;

    /***
     * AuthClientUser分页条件搜索实现
     * @param authClientUser
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AuthClientUser条件分页查询",notes = "分页条件查询AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AuthClientUser对象",value = "传入JSON数据",required = false) AuthClientUser authClientUser, @PathVariable  int page, @PathVariable  int size){
        //调用AuthClientUserService实现分页条件查询AuthClientUser
        PageInfo<AuthClientUser> pageInfo = authClientUserService.findPage(authClientUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AuthClientUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AuthClientUser分页查询",notes = "分页查询AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AuthClientUserService实现分页查询AuthClientUser
        PageInfo<AuthClientUser> pageInfo = authClientUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param authClientUser
     * @return
     */
    @ApiOperation(value = "AuthClientUser条件查询",notes = "条件查询AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @PostMapping(value = "/search" )
    public Result<List<AuthClientUser>> findList(@RequestBody(required = false) @ApiParam(name = "AuthClientUser对象",value = "传入JSON数据",required = false) AuthClientUser authClientUser){
        //调用AuthClientUserService实现条件查询AuthClientUser
        List<AuthClientUser> list = authClientUserService.findList(authClientUser);
        return new Result<List<AuthClientUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientUser根据ID删除",notes = "根据ID删除AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AuthClientUserService实现根据主键删除
        authClientUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AuthClientUser数据
     * @param authClientUser
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientUser根据ID修改",notes = "根据ID修改AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AuthClientUser对象",value = "传入JSON数据",required = false) AuthClientUser authClientUser,@PathVariable Integer id){
        //设置主键值
        authClientUser.setId(id);
        //调用AuthClientUserService实现修改AuthClientUser
        authClientUserService.update(authClientUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AuthClientUser数据
     * @param authClientUser
     * @return
     */
    @ApiOperation(value = "AuthClientUser添加",notes = "添加AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AuthClientUser对象",value = "传入JSON数据",required = true) AuthClientUser authClientUser){
        //调用AuthClientUserService实现添加AuthClientUser
        authClientUserService.add(authClientUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AuthClientUser数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientUser根据ID查询",notes = "根据ID查询AuthClientUser方法详情",tags = {"AuthClientUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AuthClientUser> findById(@PathVariable Integer id){
        //调用AuthClientUserService实现根据主键查询AuthClientUser
        AuthClientUser authClientUser = authClientUserService.findById(id);
        return new Result<AuthClientUser>(true,StatusCode.OK,"查询成功",authClientUser);
    }

    /***
     * 查询AuthClientUser全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AuthClientUser",notes = "查询所AuthClientUser有方法详情",tags = {"AuthClientUserController"})
    @GetMapping
    public Result<List<AuthClientUser>> findAll(){
        //调用AuthClientUserService实现查询所有AuthClientUser
        List<AuthClientUser> list = authClientUserService.findAll();
        return new Result<List<AuthClientUser>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
