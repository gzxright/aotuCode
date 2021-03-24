package com.changgou.order.controller;
import com.changgou.order.pojo.ConfigInfoTag;
import com.changgou.order.service.ConfigInfoTagService;
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
@Api(value = "ConfigInfoTagController")
@RestController
@RequestMapping("/configInfoTag")
@CrossOrigin
public class ConfigInfoTagController {

    @Autowired
    private ConfigInfoTagService configInfoTagService;

    /***
     * ConfigInfoTag分页条件搜索实现
     * @param configInfoTag
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag条件分页查询",notes = "分页条件查询ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ConfigInfoTag对象",value = "传入JSON数据",required = false) ConfigInfoTag configInfoTag, @PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoTagService实现分页条件查询ConfigInfoTag
        PageInfo<ConfigInfoTag> pageInfo = configInfoTagService.findPage(configInfoTag, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ConfigInfoTag分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag分页查询",notes = "分页查询ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConfigInfoTagService实现分页查询ConfigInfoTag
        PageInfo<ConfigInfoTag> pageInfo = configInfoTagService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param configInfoTag
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag条件查询",notes = "条件查询ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @PostMapping(value = "/search" )
    public Result<List<ConfigInfoTag>> findList(@RequestBody(required = false) @ApiParam(name = "ConfigInfoTag对象",value = "传入JSON数据",required = false) ConfigInfoTag configInfoTag){
        //调用ConfigInfoTagService实现条件查询ConfigInfoTag
        List<ConfigInfoTag> list = configInfoTagService.findList(configInfoTag);
        return new Result<List<ConfigInfoTag>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag根据ID删除",notes = "根据ID删除ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ConfigInfoTagService实现根据主键删除
        configInfoTagService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ConfigInfoTag数据
     * @param configInfoTag
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag根据ID修改",notes = "根据ID修改ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ConfigInfoTag对象",value = "传入JSON数据",required = false) ConfigInfoTag configInfoTag,@PathVariable  id){
        //设置主键值
        configInfoTag.set(id);
        //调用ConfigInfoTagService实现修改ConfigInfoTag
        configInfoTagService.update(configInfoTag);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ConfigInfoTag数据
     * @param configInfoTag
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag添加",notes = "添加ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ConfigInfoTag对象",value = "传入JSON数据",required = true) ConfigInfoTag configInfoTag){
        //调用ConfigInfoTagService实现添加ConfigInfoTag
        configInfoTagService.add(configInfoTag);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ConfigInfoTag数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ConfigInfoTag根据ID查询",notes = "根据ID查询ConfigInfoTag方法详情",tags = {"ConfigInfoTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ConfigInfoTag> findById(@PathVariable  id){
        //调用ConfigInfoTagService实现根据主键查询ConfigInfoTag
        ConfigInfoTag configInfoTag = configInfoTagService.findById(id);
        return new Result<ConfigInfoTag>(true,StatusCode.OK,"查询成功",configInfoTag);
    }

    /***
     * 查询ConfigInfoTag全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ConfigInfoTag",notes = "查询所ConfigInfoTag有方法详情",tags = {"ConfigInfoTagController"})
    @GetMapping
    public Result<List<ConfigInfoTag>> findAll(){
        //调用ConfigInfoTagService实现查询所有ConfigInfoTag
        List<ConfigInfoTag> list = configInfoTagService.findAll();
        return new Result<List<ConfigInfoTag>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
