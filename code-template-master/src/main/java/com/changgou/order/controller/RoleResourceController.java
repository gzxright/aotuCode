package com.changgou.order.controller;
import com.changgou.order.pojo.RoleResource;
import com.changgou.order.service.RoleResourceService;
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
@Api(value = "RoleResourceController")
@RestController
@RequestMapping("/roleResource")
@CrossOrigin
public class RoleResourceController {

    @Autowired
    private RoleResourceService roleResourceService;

    /***
     * RoleResource分页条件搜索实现
     * @param roleResource
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "RoleResource条件分页查询",notes = "分页条件查询RoleResource方法详情",tags = {"RoleResourceController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "RoleResource对象",value = "传入JSON数据",required = false) RoleResource roleResource, @PathVariable  int page, @PathVariable  int size){
        //调用RoleResourceService实现分页条件查询RoleResource
        PageInfo<RoleResource> pageInfo = roleResourceService.findPage(roleResource, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * RoleResource分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "RoleResource分页查询",notes = "分页查询RoleResource方法详情",tags = {"RoleResourceController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RoleResourceService实现分页查询RoleResource
        PageInfo<RoleResource> pageInfo = roleResourceService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param roleResource
     * @return
     */
    @ApiOperation(value = "RoleResource条件查询",notes = "条件查询RoleResource方法详情",tags = {"RoleResourceController"})
    @PostMapping(value = "/search" )
    public Result<List<RoleResource>> findList(@RequestBody(required = false) @ApiParam(name = "RoleResource对象",value = "传入JSON数据",required = false) RoleResource roleResource){
        //调用RoleResourceService实现条件查询RoleResource
        List<RoleResource> list = roleResourceService.findList(roleResource);
        return new Result<List<RoleResource>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleResource根据ID删除",notes = "根据ID删除RoleResource方法详情",tags = {"RoleResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用RoleResourceService实现根据主键删除
        roleResourceService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改RoleResource数据
     * @param roleResource
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleResource根据ID修改",notes = "根据ID修改RoleResource方法详情",tags = {"RoleResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "RoleResource对象",value = "传入JSON数据",required = false) RoleResource roleResource,@PathVariable  id){
        //设置主键值
        roleResource.set(id);
        //调用RoleResourceService实现修改RoleResource
        roleResourceService.update(roleResource);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增RoleResource数据
     * @param roleResource
     * @return
     */
    @ApiOperation(value = "RoleResource添加",notes = "添加RoleResource方法详情",tags = {"RoleResourceController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "RoleResource对象",value = "传入JSON数据",required = true) RoleResource roleResource){
        //调用RoleResourceService实现添加RoleResource
        roleResourceService.add(roleResource);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询RoleResource数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleResource根据ID查询",notes = "根据ID查询RoleResource方法详情",tags = {"RoleResourceController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<RoleResource> findById(@PathVariable  id){
        //调用RoleResourceService实现根据主键查询RoleResource
        RoleResource roleResource = roleResourceService.findById(id);
        return new Result<RoleResource>(true,StatusCode.OK,"查询成功",roleResource);
    }

    /***
     * 查询RoleResource全部数据
     * @return
     */
    @ApiOperation(value = "查询所有RoleResource",notes = "查询所RoleResource有方法详情",tags = {"RoleResourceController"})
    @GetMapping
    public Result<List<RoleResource>> findAll(){
        //调用RoleResourceService实现查询所有RoleResource
        List<RoleResource> list = roleResourceService.findAll();
        return new Result<List<RoleResource>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
