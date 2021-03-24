package com.changgou.order.controller;
import com.changgou.order.pojo.TOrder;
import com.changgou.order.service.TOrderService;
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
@Api(value = "TOrderController")
@RestController
@RequestMapping("/tOrder")
@CrossOrigin
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

    /***
     * TOrder分页条件搜索实现
     * @param tOrder
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TOrder条件分页查询",notes = "分页条件查询TOrder方法详情",tags = {"TOrderController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TOrder对象",value = "传入JSON数据",required = false) TOrder tOrder, @PathVariable  int page, @PathVariable  int size){
        //调用TOrderService实现分页条件查询TOrder
        PageInfo<TOrder> pageInfo = tOrderService.findPage(tOrder, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TOrder分页查询",notes = "分页查询TOrder方法详情",tags = {"TOrderController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TOrderService实现分页查询TOrder
        PageInfo<TOrder> pageInfo = tOrderService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param tOrder
     * @return
     */
    @ApiOperation(value = "TOrder条件查询",notes = "条件查询TOrder方法详情",tags = {"TOrderController"})
    @PostMapping(value = "/search" )
    public Result<List<TOrder>> findList(@RequestBody(required = false) @ApiParam(name = "TOrder对象",value = "传入JSON数据",required = false) TOrder tOrder){
        //调用TOrderService实现条件查询TOrder
        List<TOrder> list = tOrderService.findList(tOrder);
        return new Result<List<TOrder>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TOrder根据ID删除",notes = "根据ID删除TOrder方法详情",tags = {"TOrderController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用TOrderService实现根据主键删除
        tOrderService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TOrder数据
     * @param tOrder
     * @param id
     * @return
     */
    @ApiOperation(value = "TOrder根据ID修改",notes = "根据ID修改TOrder方法详情",tags = {"TOrderController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "TOrder对象",value = "传入JSON数据",required = false) TOrder tOrder,@PathVariable  id){
        //设置主键值
        tOrder.set(id);
        //调用TOrderService实现修改TOrder
        tOrderService.update(tOrder);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TOrder数据
     * @param tOrder
     * @return
     */
    @ApiOperation(value = "TOrder添加",notes = "添加TOrder方法详情",tags = {"TOrderController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "TOrder对象",value = "传入JSON数据",required = true) TOrder tOrder){
        //调用TOrderService实现添加TOrder
        tOrderService.add(tOrder);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TOrder数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TOrder根据ID查询",notes = "根据ID查询TOrder方法详情",tags = {"TOrderController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<TOrder> findById(@PathVariable  id){
        //调用TOrderService实现根据主键查询TOrder
        TOrder tOrder = tOrderService.findById(id);
        return new Result<TOrder>(true,StatusCode.OK,"查询成功",tOrder);
    }

    /***
     * 查询TOrder全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TOrder",notes = "查询所TOrder有方法详情",tags = {"TOrderController"})
    @GetMapping
    public Result<List<TOrder>> findAll(){
        //调用TOrderService实现查询所有TOrder
        List<TOrder> list = tOrderService.findAll();
        return new Result<List<TOrder>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
