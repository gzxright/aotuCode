package com.changgou.order.controller;
import com.changgou.order.pojo.Users;
import com.changgou.order.service.UsersService;
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
@Api(value = "UsersController")
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UsersService usersService;

    /***
     * Users分页条件搜索实现
     * @param users
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Users条件分页查询",notes = "分页条件查询Users方法详情",tags = {"UsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Users对象",value = "传入JSON数据",required = false) Users users, @PathVariable  int page, @PathVariable  int size){
        //调用UsersService实现分页条件查询Users
        PageInfo<Users> pageInfo = usersService.findPage(users, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Users分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Users分页查询",notes = "分页查询Users方法详情",tags = {"UsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UsersService实现分页查询Users
        PageInfo<Users> pageInfo = usersService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param users
     * @return
     */
    @ApiOperation(value = "Users条件查询",notes = "条件查询Users方法详情",tags = {"UsersController"})
    @PostMapping(value = "/search" )
    public Result<List<Users>> findList(@RequestBody(required = false) @ApiParam(name = "Users对象",value = "传入JSON数据",required = false) Users users){
        //调用UsersService实现条件查询Users
        List<Users> list = usersService.findList(users);
        return new Result<List<Users>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Users根据ID删除",notes = "根据ID删除Users方法详情",tags = {"UsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用UsersService实现根据主键删除
        usersService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Users数据
     * @param users
     * @param id
     * @return
     */
    @ApiOperation(value = "Users根据ID修改",notes = "根据ID修改Users方法详情",tags = {"UsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Users对象",value = "传入JSON数据",required = false) Users users,@PathVariable  id){
        //设置主键值
        users.set(id);
        //调用UsersService实现修改Users
        usersService.update(users);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Users数据
     * @param users
     * @return
     */
    @ApiOperation(value = "Users添加",notes = "添加Users方法详情",tags = {"UsersController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Users对象",value = "传入JSON数据",required = true) Users users){
        //调用UsersService实现添加Users
        usersService.add(users);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Users数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Users根据ID查询",notes = "根据ID查询Users方法详情",tags = {"UsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Users> findById(@PathVariable  id){
        //调用UsersService实现根据主键查询Users
        Users users = usersService.findById(id);
        return new Result<Users>(true,StatusCode.OK,"查询成功",users);
    }

    /***
     * 查询Users全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Users",notes = "查询所Users有方法详情",tags = {"UsersController"})
    @GetMapping
    public Result<List<Users>> findAll(){
        //调用UsersService实现查询所有Users
        List<Users> list = usersService.findAll();
        return new Result<List<Users>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
