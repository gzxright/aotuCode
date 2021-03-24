package com.changgou.order.controller;
import com.changgou.order.pojo.Inventory;
import com.changgou.order.service.InventoryService;
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
@Api(value = "InventoryController")
@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    /***
     * Inventory分页条件搜索实现
     * @param inventory
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Inventory条件分页查询",notes = "分页条件查询Inventory方法详情",tags = {"InventoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Inventory对象",value = "传入JSON数据",required = false) Inventory inventory, @PathVariable  int page, @PathVariable  int size){
        //调用InventoryService实现分页条件查询Inventory
        PageInfo<Inventory> pageInfo = inventoryService.findPage(inventory, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Inventory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Inventory分页查询",notes = "分页查询Inventory方法详情",tags = {"InventoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用InventoryService实现分页查询Inventory
        PageInfo<Inventory> pageInfo = inventoryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param inventory
     * @return
     */
    @ApiOperation(value = "Inventory条件查询",notes = "条件查询Inventory方法详情",tags = {"InventoryController"})
    @PostMapping(value = "/search" )
    public Result<List<Inventory>> findList(@RequestBody(required = false) @ApiParam(name = "Inventory对象",value = "传入JSON数据",required = false) Inventory inventory){
        //调用InventoryService实现条件查询Inventory
        List<Inventory> list = inventoryService.findList(inventory);
        return new Result<List<Inventory>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Inventory根据ID删除",notes = "根据ID删除Inventory方法详情",tags = {"InventoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用InventoryService实现根据主键删除
        inventoryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Inventory数据
     * @param inventory
     * @param id
     * @return
     */
    @ApiOperation(value = "Inventory根据ID修改",notes = "根据ID修改Inventory方法详情",tags = {"InventoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Inventory对象",value = "传入JSON数据",required = false) Inventory inventory,@PathVariable  id){
        //设置主键值
        inventory.set(id);
        //调用InventoryService实现修改Inventory
        inventoryService.update(inventory);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Inventory数据
     * @param inventory
     * @return
     */
    @ApiOperation(value = "Inventory添加",notes = "添加Inventory方法详情",tags = {"InventoryController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Inventory对象",value = "传入JSON数据",required = true) Inventory inventory){
        //调用InventoryService实现添加Inventory
        inventoryService.add(inventory);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Inventory数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Inventory根据ID查询",notes = "根据ID查询Inventory方法详情",tags = {"InventoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Inventory> findById(@PathVariable  id){
        //调用InventoryService实现根据主键查询Inventory
        Inventory inventory = inventoryService.findById(id);
        return new Result<Inventory>(true,StatusCode.OK,"查询成功",inventory);
    }

    /***
     * 查询Inventory全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Inventory",notes = "查询所Inventory有方法详情",tags = {"InventoryController"})
    @GetMapping
    public Result<List<Inventory>> findAll(){
        //调用InventoryService实现查询所有Inventory
        List<Inventory> list = inventoryService.findAll();
        return new Result<List<Inventory>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
