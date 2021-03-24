package com.changgou.order.controller;
import com.changgou.order.pojo.Resource;
import com.changgou.order.service.ResourceService;
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
@Api(value = "ResourceController")
@RestController
@RequestMapping("/resource")
@CrossOrigin
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /***
     * Resource分页条件搜索实现
     * @param resource
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Resource条件分页查询",notes = "分页条件查询Resource方法详情",tags = {"ResourceController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Resource对象",value = "传入JSON数据",required = false) Resource resource, @PathVariable  int page, @PathVariable  int size){
        //调用ResourceService实现分页条件查询Resource
        PageInfo<Resource> pageInfo = resourceService.findPage(resource, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Resource分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Resource分页查询",notes = "分页查询Resource方法详情",tags = {"ResourceController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ResourceService实现分页查询Resource
        PageInfo<Resource> pageInfo = resourceService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param resource
     * @return
     */
    @ApiOperation(value = "Resource条件查询",notes = "条件查询Resource方法详情",tags = {"ResourceController"})
    @PostMapping(value = "/search" )
    public Result<List<Resource>> findList(@RequestBody(required = false) @ApiParam(name = "Resource对象",value = "传入JSON数据",required = false) Resource resource){
        //调用ResourceService实现条件查询Resource
        List<Resource> list = resourceService.findList(resource);
        return new Result<List<Resource>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Resource根据ID删除",notes = "根据ID删除Resource方法详情",tags = {"ResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ResourceService实现根据主键删除
        resourceService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Resource数据
     * @param resource
     * @param id
     * @return
     */
    @ApiOperation(value = "Resource根据ID修改",notes = "根据ID修改Resource方法详情",tags = {"ResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Resource对象",value = "传入JSON数据",required = false) Resource resource,@PathVariable  id){
        //设置主键值
        resource.set(id);
        //调用ResourceService实现修改Resource
        resourceService.update(resource);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Resource数据
     * @param resource
     * @return
     */
    @ApiOperation(value = "Resource添加",notes = "添加Resource方法详情",tags = {"ResourceController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Resource对象",value = "传入JSON数据",required = true) Resource resource){
        //调用ResourceService实现添加Resource
        resourceService.add(resource);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Resource数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Resource根据ID查询",notes = "根据ID查询Resource方法详情",tags = {"ResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Resource> findById(@PathVariable  id){
        //调用ResourceService实现根据主键查询Resource
        Resource resource = resourceService.findById(id);
        return new Result<Resource>(true,StatusCode.OK,"查询成功",resource);
    }

    /***
     * 查询Resource全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Resource",notes = "查询所Resource有方法详情",tags = {"ResourceController"})
    @GetMapping
    public Result<List<Resource>> findAll(){
        //调用ResourceService实现查询所有Resource
        List<Resource> list = resourceService.findAll();
        return new Result<List<Resource>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
