package com.changgou.order.controller;
import com.changgou.order.pojo.Country;
import com.changgou.order.service.CountryService;
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
@Api(value = "CountryController")
@RestController
@RequestMapping("/country")
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryService countryService;

    /***
     * Country分页条件搜索实现
     * @param country
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Country条件分页查询",notes = "分页条件查询Country方法详情",tags = {"CountryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Country对象",value = "传入JSON数据",required = false) Country country, @PathVariable  int page, @PathVariable  int size){
        //调用CountryService实现分页条件查询Country
        PageInfo<Country> pageInfo = countryService.findPage(country, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Country分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Country分页查询",notes = "分页查询Country方法详情",tags = {"CountryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CountryService实现分页查询Country
        PageInfo<Country> pageInfo = countryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param country
     * @return
     */
    @ApiOperation(value = "Country条件查询",notes = "条件查询Country方法详情",tags = {"CountryController"})
    @PostMapping(value = "/search" )
    public Result<List<Country>> findList(@RequestBody(required = false) @ApiParam(name = "Country对象",value = "传入JSON数据",required = false) Country country){
        //调用CountryService实现条件查询Country
        List<Country> list = countryService.findList(country);
        return new Result<List<Country>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Country根据ID删除",notes = "根据ID删除Country方法详情",tags = {"CountryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用CountryService实现根据主键删除
        countryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Country数据
     * @param country
     * @param id
     * @return
     */
    @ApiOperation(value = "Country根据ID修改",notes = "根据ID修改Country方法详情",tags = {"CountryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Country对象",value = "传入JSON数据",required = false) Country country,@PathVariable  id){
        //设置主键值
        country.set(id);
        //调用CountryService实现修改Country
        countryService.update(country);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Country数据
     * @param country
     * @return
     */
    @ApiOperation(value = "Country添加",notes = "添加Country方法详情",tags = {"CountryController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Country对象",value = "传入JSON数据",required = true) Country country){
        //调用CountryService实现添加Country
        countryService.add(country);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Country数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Country根据ID查询",notes = "根据ID查询Country方法详情",tags = {"CountryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Country> findById(@PathVariable  id){
        //调用CountryService实现根据主键查询Country
        Country country = countryService.findById(id);
        return new Result<Country>(true,StatusCode.OK,"查询成功",country);
    }

    /***
     * 查询Country全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Country",notes = "查询所Country有方法详情",tags = {"CountryController"})
    @GetMapping
    public Result<List<Country>> findAll(){
        //调用CountryService实现查询所有Country
        List<Country> list = countryService.findAll();
        return new Result<List<Country>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
