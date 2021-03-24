package com.changgou.order.controller;
import com.changgou.order.pojo.UserRole;
import com.changgou.order.service.UserRoleService;
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
@Api(value = "UserRoleController")
@RestController
@RequestMapping("/userRole")
@CrossOrigin
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /***
     * UserRole分页条件搜索实现
     * @param userRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "UserRole条件分页查询",notes = "分页条件查询UserRole方法详情",tags = {"UserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "UserRole对象",value = "传入JSON数据",required = false) UserRole userRole, @PathVariable  int page, @PathVariable  int size){
        //调用UserRoleService实现分页条件查询UserRole
        PageInfo<UserRole> pageInfo = userRoleService.findPage(userRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * UserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "UserRole分页查询",notes = "分页查询UserRole方法详情",tags = {"UserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UserRoleService实现分页查询UserRole
        PageInfo<UserRole> pageInfo = userRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param userRole
     * @return
     */
    @ApiOperation(value = "UserRole条件查询",notes = "条件查询UserRole方法详情",tags = {"UserRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<UserRole>> findList(@RequestBody(required = false) @ApiParam(name = "UserRole对象",value = "传入JSON数据",required = false) UserRole userRole){
        //调用UserRoleService实现条件查询UserRole
        List<UserRole> list = userRoleService.findList(userRole);
        return new Result<List<UserRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "UserRole根据ID删除",notes = "根据ID删除UserRole方法详情",tags = {"UserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用UserRoleService实现根据主键删除
        userRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改UserRole数据
     * @param userRole
     * @param id
     * @return
     */
    @ApiOperation(value = "UserRole根据ID修改",notes = "根据ID修改UserRole方法详情",tags = {"UserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "UserRole对象",value = "传入JSON数据",required = false) UserRole userRole,@PathVariable Integer id){
        //设置主键值
        userRole.setId(id);
        //调用UserRoleService实现修改UserRole
        userRoleService.update(userRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增UserRole数据
     * @param userRole
     * @return
     */
    @ApiOperation(value = "UserRole添加",notes = "添加UserRole方法详情",tags = {"UserRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "UserRole对象",value = "传入JSON数据",required = true) UserRole userRole){
        //调用UserRoleService实现添加UserRole
        userRoleService.add(userRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询UserRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "UserRole根据ID查询",notes = "根据ID查询UserRole方法详情",tags = {"UserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<UserRole> findById(@PathVariable Integer id){
        //调用UserRoleService实现根据主键查询UserRole
        UserRole userRole = userRoleService.findById(id);
        return new Result<UserRole>(true,StatusCode.OK,"查询成功",userRole);
    }

    /***
     * 查询UserRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有UserRole",notes = "查询所UserRole有方法详情",tags = {"UserRoleController"})
    @GetMapping
    public Result<List<UserRole>> findAll(){
        //调用UserRoleService实现查询所有UserRole
        List<UserRole> list = userRoleService.findAll();
        return new Result<List<UserRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
