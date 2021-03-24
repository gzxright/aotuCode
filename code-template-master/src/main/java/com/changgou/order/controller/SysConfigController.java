package com.changgou.order.controller;
import com.changgou.order.pojo.SysConfig;
import com.changgou.order.service.SysConfigService;
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
@Api(value = "SysConfigController")
@RestController
@RequestMapping("/sysConfig")
@CrossOrigin
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    /***
     * SysConfig分页条件搜索实现
     * @param sysConfig
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysConfig条件分页查询",notes = "分页条件查询SysConfig方法详情",tags = {"SysConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysConfig对象",value = "传入JSON数据",required = false) SysConfig sysConfig, @PathVariable  int page, @PathVariable  int size){
        //调用SysConfigService实现分页条件查询SysConfig
        PageInfo<SysConfig> pageInfo = sysConfigService.findPage(sysConfig, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysConfig分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysConfig分页查询",notes = "分页查询SysConfig方法详情",tags = {"SysConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysConfigService实现分页查询SysConfig
        PageInfo<SysConfig> pageInfo = sysConfigService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysConfig
     * @return
     */
    @ApiOperation(value = "SysConfig条件查询",notes = "条件查询SysConfig方法详情",tags = {"SysConfigController"})
    @PostMapping(value = "/search" )
    public Result<List<SysConfig>> findList(@RequestBody(required = false) @ApiParam(name = "SysConfig对象",value = "传入JSON数据",required = false) SysConfig sysConfig){
        //调用SysConfigService实现条件查询SysConfig
        List<SysConfig> list = sysConfigService.findList(sysConfig);
        return new Result<List<SysConfig>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysConfig根据ID删除",notes = "根据ID删除SysConfig方法详情",tags = {"SysConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用SysConfigService实现根据主键删除
        sysConfigService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysConfig数据
     * @param sysConfig
     * @param id
     * @return
     */
    @ApiOperation(value = "SysConfig根据ID修改",notes = "根据ID修改SysConfig方法详情",tags = {"SysConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysConfig对象",value = "传入JSON数据",required = false) SysConfig sysConfig,@PathVariable  id){
        //设置主键值
        sysConfig.set(id);
        //调用SysConfigService实现修改SysConfig
        sysConfigService.update(sysConfig);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysConfig数据
     * @param sysConfig
     * @return
     */
    @ApiOperation(value = "SysConfig添加",notes = "添加SysConfig方法详情",tags = {"SysConfigController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysConfig对象",value = "传入JSON数据",required = true) SysConfig sysConfig){
        //调用SysConfigService实现添加SysConfig
        sysConfigService.add(sysConfig);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysConfig数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysConfig根据ID查询",notes = "根据ID查询SysConfig方法详情",tags = {"SysConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<SysConfig> findById(@PathVariable  id){
        //调用SysConfigService实现根据主键查询SysConfig
        SysConfig sysConfig = sysConfigService.findById(id);
        return new Result<SysConfig>(true,StatusCode.OK,"查询成功",sysConfig);
    }

    /***
     * 查询SysConfig全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysConfig",notes = "查询所SysConfig有方法详情",tags = {"SysConfigController"})
    @GetMapping
    public Result<List<SysConfig>> findAll(){
        //调用SysConfigService实现查询所有SysConfig
        List<SysConfig> list = sysConfigService.findAll();
        return new Result<List<SysConfig>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
