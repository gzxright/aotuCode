package com.changgou.order.controller;
import com.changgou.order.pojo.TenantCapacity;
import com.changgou.order.service.TenantCapacityService;
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
@Api(value = "TenantCapacityController")
@RestController
@RequestMapping("/tenantCapacity")
@CrossOrigin
public class TenantCapacityController {

    @Autowired
    private TenantCapacityService tenantCapacityService;

    /***
     * TenantCapacity分页条件搜索实现
     * @param tenantCapacity
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TenantCapacity条件分页查询",notes = "分页条件查询TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TenantCapacity对象",value = "传入JSON数据",required = false) TenantCapacity tenantCapacity, @PathVariable  int page, @PathVariable  int size){
        //调用TenantCapacityService实现分页条件查询TenantCapacity
        PageInfo<TenantCapacity> pageInfo = tenantCapacityService.findPage(tenantCapacity, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TenantCapacity分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TenantCapacity分页查询",notes = "分页查询TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TenantCapacityService实现分页查询TenantCapacity
        PageInfo<TenantCapacity> pageInfo = tenantCapacityService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param tenantCapacity
     * @return
     */
    @ApiOperation(value = "TenantCapacity条件查询",notes = "条件查询TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @PostMapping(value = "/search" )
    public Result<List<TenantCapacity>> findList(@RequestBody(required = false) @ApiParam(name = "TenantCapacity对象",value = "传入JSON数据",required = false) TenantCapacity tenantCapacity){
        //调用TenantCapacityService实现条件查询TenantCapacity
        List<TenantCapacity> list = tenantCapacityService.findList(tenantCapacity);
        return new Result<List<TenantCapacity>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantCapacity根据ID删除",notes = "根据ID删除TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用TenantCapacityService实现根据主键删除
        tenantCapacityService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TenantCapacity数据
     * @param tenantCapacity
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantCapacity根据ID修改",notes = "根据ID修改TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "TenantCapacity对象",value = "传入JSON数据",required = false) TenantCapacity tenantCapacity,@PathVariable  id){
        //设置主键值
        tenantCapacity.set(id);
        //调用TenantCapacityService实现修改TenantCapacity
        tenantCapacityService.update(tenantCapacity);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TenantCapacity数据
     * @param tenantCapacity
     * @return
     */
    @ApiOperation(value = "TenantCapacity添加",notes = "添加TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "TenantCapacity对象",value = "传入JSON数据",required = true) TenantCapacity tenantCapacity){
        //调用TenantCapacityService实现添加TenantCapacity
        tenantCapacityService.add(tenantCapacity);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TenantCapacity数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantCapacity根据ID查询",notes = "根据ID查询TenantCapacity方法详情",tags = {"TenantCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<TenantCapacity> findById(@PathVariable  id){
        //调用TenantCapacityService实现根据主键查询TenantCapacity
        TenantCapacity tenantCapacity = tenantCapacityService.findById(id);
        return new Result<TenantCapacity>(true,StatusCode.OK,"查询成功",tenantCapacity);
    }

    /***
     * 查询TenantCapacity全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TenantCapacity",notes = "查询所TenantCapacity有方法详情",tags = {"TenantCapacityController"})
    @GetMapping
    public Result<List<TenantCapacity>> findAll(){
        //调用TenantCapacityService实现查询所有TenantCapacity
        List<TenantCapacity> list = tenantCapacityService.findAll();
        return new Result<List<TenantCapacity>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
