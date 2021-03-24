package com.changgou.order.controller;
import com.changgou.order.pojo.Rental;
import com.changgou.order.service.RentalService;
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
@Api(value = "RentalController")
@RestController
@RequestMapping("/rental")
@CrossOrigin
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /***
     * Rental分页条件搜索实现
     * @param rental
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Rental条件分页查询",notes = "分页条件查询Rental方法详情",tags = {"RentalController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Rental对象",value = "传入JSON数据",required = false) Rental rental, @PathVariable  int page, @PathVariable  int size){
        //调用RentalService实现分页条件查询Rental
        PageInfo<Rental> pageInfo = rentalService.findPage(rental, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Rental分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Rental分页查询",notes = "分页查询Rental方法详情",tags = {"RentalController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RentalService实现分页查询Rental
        PageInfo<Rental> pageInfo = rentalService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param rental
     * @return
     */
    @ApiOperation(value = "Rental条件查询",notes = "条件查询Rental方法详情",tags = {"RentalController"})
    @PostMapping(value = "/search" )
    public Result<List<Rental>> findList(@RequestBody(required = false) @ApiParam(name = "Rental对象",value = "传入JSON数据",required = false) Rental rental){
        //调用RentalService实现条件查询Rental
        List<Rental> list = rentalService.findList(rental);
        return new Result<List<Rental>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Rental根据ID删除",notes = "根据ID删除Rental方法详情",tags = {"RentalController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用RentalService实现根据主键删除
        rentalService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Rental数据
     * @param rental
     * @param id
     * @return
     */
    @ApiOperation(value = "Rental根据ID修改",notes = "根据ID修改Rental方法详情",tags = {"RentalController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Rental对象",value = "传入JSON数据",required = false) Rental rental,@PathVariable  id){
        //设置主键值
        rental.set(id);
        //调用RentalService实现修改Rental
        rentalService.update(rental);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Rental数据
     * @param rental
     * @return
     */
    @ApiOperation(value = "Rental添加",notes = "添加Rental方法详情",tags = {"RentalController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Rental对象",value = "传入JSON数据",required = true) Rental rental){
        //调用RentalService实现添加Rental
        rentalService.add(rental);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Rental数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Rental根据ID查询",notes = "根据ID查询Rental方法详情",tags = {"RentalController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Rental> findById(@PathVariable  id){
        //调用RentalService实现根据主键查询Rental
        Rental rental = rentalService.findById(id);
        return new Result<Rental>(true,StatusCode.OK,"查询成功",rental);
    }

    /***
     * 查询Rental全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Rental",notes = "查询所Rental有方法详情",tags = {"RentalController"})
    @GetMapping
    public Result<List<Rental>> findAll(){
        //调用RentalService实现查询所有Rental
        List<Rental> list = rentalService.findAll();
        return new Result<List<Rental>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
