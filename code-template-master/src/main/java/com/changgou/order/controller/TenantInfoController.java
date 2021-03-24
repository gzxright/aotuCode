package com.changgou.order.controller;
import com.changgou.order.pojo.TenantInfo;
import com.changgou.order.service.TenantInfoService;
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
@Api(value = "TenantInfoController")
@RestController
@RequestMapping("/tenantInfo")
@CrossOrigin
public class TenantInfoController {

    @Autowired
    private TenantInfoService tenantInfoService;

    /***
     * TenantInfo分页条件搜索实现
     * @param tenantInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TenantInfo条件分页查询",notes = "分页条件查询TenantInfo方法详情",tags = {"TenantInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TenantInfo对象",value = "传入JSON数据",required = false) TenantInfo tenantInfo, @PathVariable  int page, @PathVariable  int size){
        //调用TenantInfoService实现分页条件查询TenantInfo
        PageInfo<TenantInfo> pageInfo = tenantInfoService.findPage(tenantInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TenantInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TenantInfo分页查询",notes = "分页查询TenantInfo方法详情",tags = {"TenantInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TenantInfoService实现分页查询TenantInfo
        PageInfo<TenantInfo> pageInfo = tenantInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param tenantInfo
     * @return
     */
    @ApiOperation(value = "TenantInfo条件查询",notes = "条件查询TenantInfo方法详情",tags = {"TenantInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<TenantInfo>> findList(@RequestBody(required = false) @ApiParam(name = "TenantInfo对象",value = "传入JSON数据",required = false) TenantInfo tenantInfo){
        //调用TenantInfoService实现条件查询TenantInfo
        List<TenantInfo> list = tenantInfoService.findList(tenantInfo);
        return new Result<List<TenantInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantInfo根据ID删除",notes = "根据ID删除TenantInfo方法详情",tags = {"TenantInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用TenantInfoService实现根据主键删除
        tenantInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TenantInfo数据
     * @param tenantInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantInfo根据ID修改",notes = "根据ID修改TenantInfo方法详情",tags = {"TenantInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "TenantInfo对象",value = "传入JSON数据",required = false) TenantInfo tenantInfo,@PathVariable  id){
        //设置主键值
        tenantInfo.set(id);
        //调用TenantInfoService实现修改TenantInfo
        tenantInfoService.update(tenantInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TenantInfo数据
     * @param tenantInfo
     * @return
     */
    @ApiOperation(value = "TenantInfo添加",notes = "添加TenantInfo方法详情",tags = {"TenantInfoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "TenantInfo对象",value = "传入JSON数据",required = true) TenantInfo tenantInfo){
        //调用TenantInfoService实现添加TenantInfo
        tenantInfoService.add(tenantInfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TenantInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TenantInfo根据ID查询",notes = "根据ID查询TenantInfo方法详情",tags = {"TenantInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<TenantInfo> findById(@PathVariable  id){
        //调用TenantInfoService实现根据主键查询TenantInfo
        TenantInfo tenantInfo = tenantInfoService.findById(id);
        return new Result<TenantInfo>(true,StatusCode.OK,"查询成功",tenantInfo);
    }

    /***
     * 查询TenantInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TenantInfo",notes = "查询所TenantInfo有方法详情",tags = {"TenantInfoController"})
    @GetMapping
    public Result<List<TenantInfo>> findAll(){
        //调用TenantInfoService实现查询所有TenantInfo
        List<TenantInfo> list = tenantInfoService.findAll();
        return new Result<List<TenantInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
