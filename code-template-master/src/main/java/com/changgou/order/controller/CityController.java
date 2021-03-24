package com.changgou.order.controller;
import com.changgou.order.pojo.City;
import com.changgou.order.service.CityService;
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
@Api(value = "CityController")
@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    /***
     * City分页条件搜索实现
     * @param city
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "City条件分页查询",notes = "分页条件查询City方法详情",tags = {"CityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "City对象",value = "传入JSON数据",required = false) City city, @PathVariable  int page, @PathVariable  int size){
        //调用CityService实现分页条件查询City
        PageInfo<City> pageInfo = cityService.findPage(city, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * City分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "City分页查询",notes = "分页查询City方法详情",tags = {"CityController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CityService实现分页查询City
        PageInfo<City> pageInfo = cityService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param city
     * @return
     */
    @ApiOperation(value = "City条件查询",notes = "条件查询City方法详情",tags = {"CityController"})
    @PostMapping(value = "/search" )
    public Result<List<City>> findList(@RequestBody(required = false) @ApiParam(name = "City对象",value = "传入JSON数据",required = false) City city){
        //调用CityService实现条件查询City
        List<City> list = cityService.findList(city);
        return new Result<List<City>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "City根据ID删除",notes = "根据ID删除City方法详情",tags = {"CityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用CityService实现根据主键删除
        cityService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改City数据
     * @param city
     * @param id
     * @return
     */
    @ApiOperation(value = "City根据ID修改",notes = "根据ID修改City方法详情",tags = {"CityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "City对象",value = "传入JSON数据",required = false) City city,@PathVariable  id){
        //设置主键值
        city.set(id);
        //调用CityService实现修改City
        cityService.update(city);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增City数据
     * @param city
     * @return
     */
    @ApiOperation(value = "City添加",notes = "添加City方法详情",tags = {"CityController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "City对象",value = "传入JSON数据",required = true) City city){
        //调用CityService实现添加City
        cityService.add(city);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询City数据
     * @param id
     * @return
     */
    @ApiOperation(value = "City根据ID查询",notes = "根据ID查询City方法详情",tags = {"CityController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<City> findById(@PathVariable  id){
        //调用CityService实现根据主键查询City
        City city = cityService.findById(id);
        return new Result<City>(true,StatusCode.OK,"查询成功",city);
    }

    /***
     * 查询City全部数据
     * @return
     */
    @ApiOperation(value = "查询所有City",notes = "查询所City有方法详情",tags = {"CityController"})
    @GetMapping
    public Result<List<City>> findAll(){
        //调用CityService实现查询所有City
        List<City> list = cityService.findAll();
        return new Result<List<City>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
