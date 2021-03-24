package com.changgou.order.controller;
import com.changgou.order.pojo.Store;
import com.changgou.order.service.StoreService;
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
@Api(value = "StoreController")
@RestController
@RequestMapping("/store")
@CrossOrigin
public class StoreController {

    @Autowired
    private StoreService storeService;

    /***
     * Store分页条件搜索实现
     * @param store
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Store条件分页查询",notes = "分页条件查询Store方法详情",tags = {"StoreController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Store对象",value = "传入JSON数据",required = false) Store store, @PathVariable  int page, @PathVariable  int size){
        //调用StoreService实现分页条件查询Store
        PageInfo<Store> pageInfo = storeService.findPage(store, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Store分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Store分页查询",notes = "分页查询Store方法详情",tags = {"StoreController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StoreService实现分页查询Store
        PageInfo<Store> pageInfo = storeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param store
     * @return
     */
    @ApiOperation(value = "Store条件查询",notes = "条件查询Store方法详情",tags = {"StoreController"})
    @PostMapping(value = "/search" )
    public Result<List<Store>> findList(@RequestBody(required = false) @ApiParam(name = "Store对象",value = "传入JSON数据",required = false) Store store){
        //调用StoreService实现条件查询Store
        List<Store> list = storeService.findList(store);
        return new Result<List<Store>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Store根据ID删除",notes = "根据ID删除Store方法详情",tags = {"StoreController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用StoreService实现根据主键删除
        storeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Store数据
     * @param store
     * @param id
     * @return
     */
    @ApiOperation(value = "Store根据ID修改",notes = "根据ID修改Store方法详情",tags = {"StoreController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Store对象",value = "传入JSON数据",required = false) Store store,@PathVariable  id){
        //设置主键值
        store.set(id);
        //调用StoreService实现修改Store
        storeService.update(store);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Store数据
     * @param store
     * @return
     */
    @ApiOperation(value = "Store添加",notes = "添加Store方法详情",tags = {"StoreController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Store对象",value = "传入JSON数据",required = true) Store store){
        //调用StoreService实现添加Store
        storeService.add(store);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Store数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Store根据ID查询",notes = "根据ID查询Store方法详情",tags = {"StoreController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Store> findById(@PathVariable  id){
        //调用StoreService实现根据主键查询Store
        Store store = storeService.findById(id);
        return new Result<Store>(true,StatusCode.OK,"查询成功",store);
    }

    /***
     * 查询Store全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Store",notes = "查询所Store有方法详情",tags = {"StoreController"})
    @GetMapping
    public Result<List<Store>> findAll(){
        //调用StoreService实现查询所有Store
        List<Store> list = storeService.findAll();
        return new Result<List<Store>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
