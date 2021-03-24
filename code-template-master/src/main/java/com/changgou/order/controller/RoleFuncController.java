package com.changgou.order.controller;
import com.changgou.order.pojo.RoleFunc;
import com.changgou.order.service.RoleFuncService;
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
@Api(value = "RoleFuncController")
@RestController
@RequestMapping("/roleFunc")
@CrossOrigin
public class RoleFuncController {

    @Autowired
    private RoleFuncService roleFuncService;

    /***
     * RoleFunc分页条件搜索实现
     * @param roleFunc
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "RoleFunc条件分页查询",notes = "分页条件查询RoleFunc方法详情",tags = {"RoleFuncController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "RoleFunc对象",value = "传入JSON数据",required = false) RoleFunc roleFunc, @PathVariable  int page, @PathVariable  int size){
        //调用RoleFuncService实现分页条件查询RoleFunc
        PageInfo<RoleFunc> pageInfo = roleFuncService.findPage(roleFunc, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * RoleFunc分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "RoleFunc分页查询",notes = "分页查询RoleFunc方法详情",tags = {"RoleFuncController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RoleFuncService实现分页查询RoleFunc
        PageInfo<RoleFunc> pageInfo = roleFuncService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param roleFunc
     * @return
     */
    @ApiOperation(value = "RoleFunc条件查询",notes = "条件查询RoleFunc方法详情",tags = {"RoleFuncController"})
    @PostMapping(value = "/search" )
    public Result<List<RoleFunc>> findList(@RequestBody(required = false) @ApiParam(name = "RoleFunc对象",value = "传入JSON数据",required = false) RoleFunc roleFunc){
        //调用RoleFuncService实现条件查询RoleFunc
        List<RoleFunc> list = roleFuncService.findList(roleFunc);
        return new Result<List<RoleFunc>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleFunc根据ID删除",notes = "根据ID删除RoleFunc方法详情",tags = {"RoleFuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RoleFuncService实现根据主键删除
        roleFuncService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改RoleFunc数据
     * @param roleFunc
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleFunc根据ID修改",notes = "根据ID修改RoleFunc方法详情",tags = {"RoleFuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "RoleFunc对象",value = "传入JSON数据",required = false) RoleFunc roleFunc,@PathVariable Integer id){
        //设置主键值
        roleFunc.setId(id);
        //调用RoleFuncService实现修改RoleFunc
        roleFuncService.update(roleFunc);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增RoleFunc数据
     * @param roleFunc
     * @return
     */
    @ApiOperation(value = "RoleFunc添加",notes = "添加RoleFunc方法详情",tags = {"RoleFuncController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "RoleFunc对象",value = "传入JSON数据",required = true) RoleFunc roleFunc){
        //调用RoleFuncService实现添加RoleFunc
        roleFuncService.add(roleFunc);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询RoleFunc数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleFunc根据ID查询",notes = "根据ID查询RoleFunc方法详情",tags = {"RoleFuncController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<RoleFunc> findById(@PathVariable Integer id){
        //调用RoleFuncService实现根据主键查询RoleFunc
        RoleFunc roleFunc = roleFuncService.findById(id);
        return new Result<RoleFunc>(true,StatusCode.OK,"查询成功",roleFunc);
    }

    /***
     * 查询RoleFunc全部数据
     * @return
     */
    @ApiOperation(value = "查询所有RoleFunc",notes = "查询所RoleFunc有方法详情",tags = {"RoleFuncController"})
    @GetMapping
    public Result<List<RoleFunc>> findAll(){
        //调用RoleFuncService实现查询所有RoleFunc
        List<RoleFunc> list = roleFuncService.findAll();
        return new Result<List<RoleFunc>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
