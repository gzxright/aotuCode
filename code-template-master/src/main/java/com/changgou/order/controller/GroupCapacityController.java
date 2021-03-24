package com.changgou.order.controller;
import com.changgou.order.pojo.GroupCapacity;
import com.changgou.order.service.GroupCapacityService;
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
@Api(value = "GroupCapacityController")
@RestController
@RequestMapping("/groupCapacity")
@CrossOrigin
public class GroupCapacityController {

    @Autowired
    private GroupCapacityService groupCapacityService;

    /***
     * GroupCapacity分页条件搜索实现
     * @param groupCapacity
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GroupCapacity条件分页查询",notes = "分页条件查询GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GroupCapacity对象",value = "传入JSON数据",required = false) GroupCapacity groupCapacity, @PathVariable  int page, @PathVariable  int size){
        //调用GroupCapacityService实现分页条件查询GroupCapacity
        PageInfo<GroupCapacity> pageInfo = groupCapacityService.findPage(groupCapacity, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GroupCapacity分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GroupCapacity分页查询",notes = "分页查询GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GroupCapacityService实现分页查询GroupCapacity
        PageInfo<GroupCapacity> pageInfo = groupCapacityService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param groupCapacity
     * @return
     */
    @ApiOperation(value = "GroupCapacity条件查询",notes = "条件查询GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @PostMapping(value = "/search" )
    public Result<List<GroupCapacity>> findList(@RequestBody(required = false) @ApiParam(name = "GroupCapacity对象",value = "传入JSON数据",required = false) GroupCapacity groupCapacity){
        //调用GroupCapacityService实现条件查询GroupCapacity
        List<GroupCapacity> list = groupCapacityService.findList(groupCapacity);
        return new Result<List<GroupCapacity>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GroupCapacity根据ID删除",notes = "根据ID删除GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用GroupCapacityService实现根据主键删除
        groupCapacityService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GroupCapacity数据
     * @param groupCapacity
     * @param id
     * @return
     */
    @ApiOperation(value = "GroupCapacity根据ID修改",notes = "根据ID修改GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "GroupCapacity对象",value = "传入JSON数据",required = false) GroupCapacity groupCapacity,@PathVariable  id){
        //设置主键值
        groupCapacity.set(id);
        //调用GroupCapacityService实现修改GroupCapacity
        groupCapacityService.update(groupCapacity);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GroupCapacity数据
     * @param groupCapacity
     * @return
     */
    @ApiOperation(value = "GroupCapacity添加",notes = "添加GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "GroupCapacity对象",value = "传入JSON数据",required = true) GroupCapacity groupCapacity){
        //调用GroupCapacityService实现添加GroupCapacity
        groupCapacityService.add(groupCapacity);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GroupCapacity数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GroupCapacity根据ID查询",notes = "根据ID查询GroupCapacity方法详情",tags = {"GroupCapacityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<GroupCapacity> findById(@PathVariable  id){
        //调用GroupCapacityService实现根据主键查询GroupCapacity
        GroupCapacity groupCapacity = groupCapacityService.findById(id);
        return new Result<GroupCapacity>(true,StatusCode.OK,"查询成功",groupCapacity);
    }

    /***
     * 查询GroupCapacity全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GroupCapacity",notes = "查询所GroupCapacity有方法详情",tags = {"GroupCapacityController"})
    @GetMapping
    public Result<List<GroupCapacity>> findAll(){
        //调用GroupCapacityService实现查询所有GroupCapacity
        List<GroupCapacity> list = groupCapacityService.findAll();
        return new Result<List<GroupCapacity>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
