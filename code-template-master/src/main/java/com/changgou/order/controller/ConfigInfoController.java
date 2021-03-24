package com.changgou.order.controller;
import com.changgou.order.pojo.ConfigInfo;
import com.changgou.order.service.ConfigInfoService;
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
@Api(value = "ConfigInfoController")
@RestController
@RequestMapping("/configInfo")
@CrossOrigin
public class ConfigInfoController {

    @Autowired
    private ConfigInfoService configInfoService;

    /***
     * ConfigInfo分页条件搜索实现
     * @param configInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ConfigInfo条件分页查询",notes = "分页条件查询ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ConfigInfo对象",value = "传入JSON数据",required = false) ConfigInfo configInfo, @PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoService实现分页条件查询ConfigInfo
        PageInfo<ConfigInfo> pageInfo = configInfoService.findPage(configInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ConfigInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ConfigInfo分页查询",notes = "分页查询ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoService实现分页查询ConfigInfo
        PageInfo<ConfigInfo> pageInfo = configInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param configInfo
     * @return
     */
    @ApiOperation(value = "ConfigInfo条件查询",notes = "条件查询ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<ConfigInfo>> findList(@RequestBody(required = false) @ApiParam(name = "ConfigInfo对象",value = "传入JSON数据",required = false) ConfigInfo configInfo){
        //调用ConfigInfoService实现条件查询ConfigInfo
        List<ConfigInfo> list = configInfoService.findList(configInfo);
        return new Result<List<ConfigInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfo根据ID删除",notes = "根据ID删除ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ConfigInfoService实现根据主键删除
        configInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ConfigInfo数据
     * @param configInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfo根据ID修改",notes = "根据ID修改ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ConfigInfo对象",value = "传入JSON数据",required = false) ConfigInfo configInfo,@PathVariable  id){
        //设置主键值
        configInfo.set(id);
        //调用ConfigInfoService实现修改ConfigInfo
        configInfoService.update(configInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ConfigInfo数据
     * @param configInfo
     * @return
     */
    @ApiOperation(value = "ConfigInfo添加",notes = "添加ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ConfigInfo对象",value = "传入JSON数据",required = true) ConfigInfo configInfo){
        //调用ConfigInfoService实现添加ConfigInfo
        configInfoService.add(configInfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ConfigInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfo根据ID查询",notes = "根据ID查询ConfigInfo方法详情",tags = {"ConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ConfigInfo> findById(@PathVariable  id){
        //调用ConfigInfoService实现根据主键查询ConfigInfo
        ConfigInfo configInfo = configInfoService.findById(id);
        return new Result<ConfigInfo>(true,StatusCode.OK,"查询成功",configInfo);
    }

    /***
     * 查询ConfigInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ConfigInfo",notes = "查询所ConfigInfo有方法详情",tags = {"ConfigInfoController"})
    @GetMapping
    public Result<List<ConfigInfo>> findAll(){
        //调用ConfigInfoService实现查询所有ConfigInfo
        List<ConfigInfo> list = configInfoService.findAll();
        return new Result<List<ConfigInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
