package com.changgou.order.controller;
import com.changgou.order.pojo.ResourceMenu;
import com.changgou.order.service.ResourceMenuService;
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
@Api(value = "ResourceMenuController")
@RestController
@RequestMapping("/resourceMenu")
@CrossOrigin
public class ResourceMenuController {

    @Autowired
    private ResourceMenuService resourceMenuService;

    /***
     * ResourceMenu分页条件搜索实现
     * @param resourceMenu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ResourceMenu条件分页查询",notes = "分页条件查询ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ResourceMenu对象",value = "传入JSON数据",required = false) ResourceMenu resourceMenu, @PathVariable  int page, @PathVariable  int size){
        //调用ResourceMenuService实现分页条件查询ResourceMenu
        PageInfo<ResourceMenu> pageInfo = resourceMenuService.findPage(resourceMenu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ResourceMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ResourceMenu分页查询",notes = "分页查询ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ResourceMenuService实现分页查询ResourceMenu
        PageInfo<ResourceMenu> pageInfo = resourceMenuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param resourceMenu
     * @return
     */
    @ApiOperation(value = "ResourceMenu条件查询",notes = "条件查询ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @PostMapping(value = "/search" )
    public Result<List<ResourceMenu>> findList(@RequestBody(required = false) @ApiParam(name = "ResourceMenu对象",value = "传入JSON数据",required = false) ResourceMenu resourceMenu){
        //调用ResourceMenuService实现条件查询ResourceMenu
        List<ResourceMenu> list = resourceMenuService.findList(resourceMenu);
        return new Result<List<ResourceMenu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceMenu根据ID删除",notes = "根据ID删除ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ResourceMenuService实现根据主键删除
        resourceMenuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ResourceMenu数据
     * @param resourceMenu
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceMenu根据ID修改",notes = "根据ID修改ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ResourceMenu对象",value = "传入JSON数据",required = false) ResourceMenu resourceMenu,@PathVariable  id){
        //设置主键值
        resourceMenu.set(id);
        //调用ResourceMenuService实现修改ResourceMenu
        resourceMenuService.update(resourceMenu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ResourceMenu数据
     * @param resourceMenu
     * @return
     */
    @ApiOperation(value = "ResourceMenu添加",notes = "添加ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ResourceMenu对象",value = "传入JSON数据",required = true) ResourceMenu resourceMenu){
        //调用ResourceMenuService实现添加ResourceMenu
        resourceMenuService.add(resourceMenu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ResourceMenu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ResourceMenu根据ID查询",notes = "根据ID查询ResourceMenu方法详情",tags = {"ResourceMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<ResourceMenu> findById(@PathVariable  id){
        //调用ResourceMenuService实现根据主键查询ResourceMenu
        ResourceMenu resourceMenu = resourceMenuService.findById(id);
        return new Result<ResourceMenu>(true,StatusCode.OK,"查询成功",resourceMenu);
    }

    /***
     * 查询ResourceMenu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ResourceMenu",notes = "查询所ResourceMenu有方法详情",tags = {"ResourceMenuController"})
    @GetMapping
    public Result<List<ResourceMenu>> findAll(){
        //调用ResourceMenuService实现查询所有ResourceMenu
        List<ResourceMenu> list = resourceMenuService.findAll();
        return new Result<List<ResourceMenu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
