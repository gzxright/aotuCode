package com.changgou.order.controller;
import com.changgou.order.pojo.ConfigInfoBeta;
import com.changgou.order.service.ConfigInfoBetaService;
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
@Api(value = "ConfigInfoBetaController")
@RestController
@RequestMapping("/configInfoBeta")
@CrossOrigin
public class ConfigInfoBetaController {

    @Autowired
    private ConfigInfoBetaService configInfoBetaService;

    /***
     * ConfigInfoBeta分页条件搜索实现
     * @param configInfoBeta
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta条件分页查询",notes = "分页条件查询ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ConfigInfoBeta对象",value = "传入JSON数据",required = false) ConfigInfoBeta configInfoBeta, @PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoBetaService实现分页条件查询ConfigInfoBeta
        PageInfo<ConfigInfoBeta> pageInfo = configInfoBetaService.findPage(configInfoBeta, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ConfigInfoBeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta分页查询",notes = "分页查询ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoBetaService实现分页查询ConfigInfoBeta
        PageInfo<ConfigInfoBeta> pageInfo = configInfoBetaService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param configInfoBeta
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta条件查询",notes = "条件查询ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @PostMapping(value = "/search" )
    public Result<List<ConfigInfoBeta>> findList(@RequestBody(required = false) @ApiParam(name = "ConfigInfoBeta对象",value = "传入JSON数据",required = false) ConfigInfoBeta configInfoBeta){
        //调用ConfigInfoBetaService实现条件查询ConfigInfoBeta
        List<ConfigInfoBeta> list = configInfoBetaService.findList(configInfoBeta);
        return new Result<List<ConfigInfoBeta>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta根据ID删除",notes = "根据ID删除ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ConfigInfoBetaService实现根据主键删除
        configInfoBetaService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ConfigInfoBeta数据
     * @param configInfoBeta
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta根据ID修改",notes = "根据ID修改ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ConfigInfoBeta对象",value = "传入JSON数据",required = false) ConfigInfoBeta configInfoBeta,@PathVariable  id){
        //设置主键值
        configInfoBeta.set(id);
        //调用ConfigInfoBetaService实现修改ConfigInfoBeta
        configInfoBetaService.update(configInfoBeta);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ConfigInfoBeta数据
     * @param configInfoBeta
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta添加",notes = "添加ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ConfigInfoBeta对象",value = "传入JSON数据",required = true) ConfigInfoBeta configInfoBeta){
        //调用ConfigInfoBetaService实现添加ConfigInfoBeta
        configInfoBetaService.add(configInfoBeta);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ConfigInfoBeta数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoBeta根据ID查询",notes = "根据ID查询ConfigInfoBeta方法详情",tags = {"ConfigInfoBetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ConfigInfoBeta> findById(@PathVariable  id){
        //调用ConfigInfoBetaService实现根据主键查询ConfigInfoBeta
        ConfigInfoBeta configInfoBeta = configInfoBetaService.findById(id);
        return new Result<ConfigInfoBeta>(true,StatusCode.OK,"查询成功",configInfoBeta);
    }

    /***
     * 查询ConfigInfoBeta全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ConfigInfoBeta",notes = "查询所ConfigInfoBeta有方法详情",tags = {"ConfigInfoBetaController"})
    @GetMapping
    public Result<List<ConfigInfoBeta>> findAll(){
        //调用ConfigInfoBetaService实现查询所有ConfigInfoBeta
        List<ConfigInfoBeta> list = configInfoBetaService.findAll();
        return new Result<List<ConfigInfoBeta>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
