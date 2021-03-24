package com.changgou.order.controller;
import com.changgou.order.pojo.ConfigInfoAggr;
import com.changgou.order.service.ConfigInfoAggrService;
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
@Api(value = "ConfigInfoAggrController")
@RestController
@RequestMapping("/configInfoAggr")
@CrossOrigin
public class ConfigInfoAggrController {

    @Autowired
    private ConfigInfoAggrService configInfoAggrService;

    /***
     * ConfigInfoAggr分页条件搜索实现
     * @param configInfoAggr
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr条件分页查询",notes = "分页条件查询ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ConfigInfoAggr对象",value = "传入JSON数据",required = false) ConfigInfoAggr configInfoAggr, @PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoAggrService实现分页条件查询ConfigInfoAggr
        PageInfo<ConfigInfoAggr> pageInfo = configInfoAggrService.findPage(configInfoAggr, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ConfigInfoAggr分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr分页查询",notes = "分页查询ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoAggrService实现分页查询ConfigInfoAggr
        PageInfo<ConfigInfoAggr> pageInfo = configInfoAggrService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param configInfoAggr
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr条件查询",notes = "条件查询ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @PostMapping(value = "/search" )
    public Result<List<ConfigInfoAggr>> findList(@RequestBody(required = false) @ApiParam(name = "ConfigInfoAggr对象",value = "传入JSON数据",required = false) ConfigInfoAggr configInfoAggr){
        //调用ConfigInfoAggrService实现条件查询ConfigInfoAggr
        List<ConfigInfoAggr> list = configInfoAggrService.findList(configInfoAggr);
        return new Result<List<ConfigInfoAggr>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr根据ID删除",notes = "根据ID删除ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ConfigInfoAggrService实现根据主键删除
        configInfoAggrService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ConfigInfoAggr数据
     * @param configInfoAggr
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr根据ID修改",notes = "根据ID修改ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ConfigInfoAggr对象",value = "传入JSON数据",required = false) ConfigInfoAggr configInfoAggr,@PathVariable  id){
        //设置主键值
        configInfoAggr.set(id);
        //调用ConfigInfoAggrService实现修改ConfigInfoAggr
        configInfoAggrService.update(configInfoAggr);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ConfigInfoAggr数据
     * @param configInfoAggr
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr添加",notes = "添加ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ConfigInfoAggr对象",value = "传入JSON数据",required = true) ConfigInfoAggr configInfoAggr){
        //调用ConfigInfoAggrService实现添加ConfigInfoAggr
        configInfoAggrService.add(configInfoAggr);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ConfigInfoAggr数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoAggr根据ID查询",notes = "根据ID查询ConfigInfoAggr方法详情",tags = {"ConfigInfoAggrController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ConfigInfoAggr> findById(@PathVariable  id){
        //调用ConfigInfoAggrService实现根据主键查询ConfigInfoAggr
        ConfigInfoAggr configInfoAggr = configInfoAggrService.findById(id);
        return new Result<ConfigInfoAggr>(true,StatusCode.OK,"查询成功",configInfoAggr);
    }

    /***
     * 查询ConfigInfoAggr全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ConfigInfoAggr",notes = "查询所ConfigInfoAggr有方法详情",tags = {"ConfigInfoAggrController"})
    @GetMapping
    public Result<List<ConfigInfoAggr>> findAll(){
        //调用ConfigInfoAggrService实现查询所有ConfigInfoAggr
        List<ConfigInfoAggr> list = configInfoAggrService.findAll();
        return new Result<List<ConfigInfoAggr>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
