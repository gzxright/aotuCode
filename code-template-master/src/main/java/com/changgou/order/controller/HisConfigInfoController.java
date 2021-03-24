package com.changgou.order.controller;
import com.changgou.order.pojo.HisConfigInfo;
import com.changgou.order.service.HisConfigInfoService;
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
@Api(value = "HisConfigInfoController")
@RestController
@RequestMapping("/hisConfigInfo")
@CrossOrigin
public class HisConfigInfoController {

    @Autowired
    private HisConfigInfoService hisConfigInfoService;

    /***
     * HisConfigInfo分页条件搜索实现
     * @param hisConfigInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "HisConfigInfo条件分页查询",notes = "分页条件查询HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "HisConfigInfo对象",value = "传入JSON数据",required = false) HisConfigInfo hisConfigInfo, @PathVariable  int page, @PathVariable  int size){
        //调用HisConfigInfoService实现分页条件查询HisConfigInfo
        PageInfo<HisConfigInfo> pageInfo = hisConfigInfoService.findPage(hisConfigInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * HisConfigInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "HisConfigInfo分页查询",notes = "分页查询HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用HisConfigInfoService实现分页查询HisConfigInfo
        PageInfo<HisConfigInfo> pageInfo = hisConfigInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param hisConfigInfo
     * @return
     */
    @ApiOperation(value = "HisConfigInfo条件查询",notes = "条件查询HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<HisConfigInfo>> findList(@RequestBody(required = false) @ApiParam(name = "HisConfigInfo对象",value = "传入JSON数据",required = false) HisConfigInfo hisConfigInfo){
        //调用HisConfigInfoService实现条件查询HisConfigInfo
        List<HisConfigInfo> list = hisConfigInfoService.findList(hisConfigInfo);
        return new Result<List<HisConfigInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "HisConfigInfo根据ID删除",notes = "根据ID删除HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用HisConfigInfoService实现根据主键删除
        hisConfigInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改HisConfigInfo数据
     * @param hisConfigInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "HisConfigInfo根据ID修改",notes = "根据ID修改HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "HisConfigInfo对象",value = "传入JSON数据",required = false) HisConfigInfo hisConfigInfo,@PathVariable  id){
        //设置主键值
        hisConfigInfo.set(id);
        //调用HisConfigInfoService实现修改HisConfigInfo
        hisConfigInfoService.update(hisConfigInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增HisConfigInfo数据
     * @param hisConfigInfo
     * @return
     */
    @ApiOperation(value = "HisConfigInfo添加",notes = "添加HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "HisConfigInfo对象",value = "传入JSON数据",required = true) HisConfigInfo hisConfigInfo){
        //调用HisConfigInfoService实现添加HisConfigInfo
        hisConfigInfoService.add(hisConfigInfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询HisConfigInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "HisConfigInfo根据ID查询",notes = "根据ID查询HisConfigInfo方法详情",tags = {"HisConfigInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<HisConfigInfo> findById(@PathVariable  id){
        //调用HisConfigInfoService实现根据主键查询HisConfigInfo
        HisConfigInfo hisConfigInfo = hisConfigInfoService.findById(id);
        return new Result<HisConfigInfo>(true,StatusCode.OK,"查询成功",hisConfigInfo);
    }

    /***
     * 查询HisConfigInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有HisConfigInfo",notes = "查询所HisConfigInfo有方法详情",tags = {"HisConfigInfoController"})
    @GetMapping
    public Result<List<HisConfigInfo>> findAll(){
        //调用HisConfigInfoService实现查询所有HisConfigInfo
        List<HisConfigInfo> list = hisConfigInfoService.findAll();
        return new Result<List<HisConfigInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
