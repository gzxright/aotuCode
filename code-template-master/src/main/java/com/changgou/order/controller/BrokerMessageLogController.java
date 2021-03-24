package com.changgou.order.controller;
import com.changgou.order.pojo.BrokerMessageLog;
import com.changgou.order.service.BrokerMessageLogService;
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
@Api(value = "BrokerMessageLogController")
@RestController
@RequestMapping("/brokerMessageLog")
@CrossOrigin
public class BrokerMessageLogController {

    @Autowired
    private BrokerMessageLogService brokerMessageLogService;

    /***
     * BrokerMessageLog分页条件搜索实现
     * @param brokerMessageLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog条件分页查询",notes = "分页条件查询BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "BrokerMessageLog对象",value = "传入JSON数据",required = false) BrokerMessageLog brokerMessageLog, @PathVariable  int page, @PathVariable  int size){
        //调用BrokerMessageLogService实现分页条件查询BrokerMessageLog
        PageInfo<BrokerMessageLog> pageInfo = brokerMessageLogService.findPage(brokerMessageLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * BrokerMessageLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog分页查询",notes = "分页查询BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BrokerMessageLogService实现分页查询BrokerMessageLog
        PageInfo<BrokerMessageLog> pageInfo = brokerMessageLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param brokerMessageLog
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog条件查询",notes = "条件查询BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @PostMapping(value = "/search" )
    public Result<List<BrokerMessageLog>> findList(@RequestBody(required = false) @ApiParam(name = "BrokerMessageLog对象",value = "传入JSON数据",required = false) BrokerMessageLog brokerMessageLog){
        //调用BrokerMessageLogService实现条件查询BrokerMessageLog
        List<BrokerMessageLog> list = brokerMessageLogService.findList(brokerMessageLog);
        return new Result<List<BrokerMessageLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog根据ID删除",notes = "根据ID删除BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用BrokerMessageLogService实现根据主键删除
        brokerMessageLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改BrokerMessageLog数据
     * @param brokerMessageLog
     * @param id
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog根据ID修改",notes = "根据ID修改BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "BrokerMessageLog对象",value = "传入JSON数据",required = false) BrokerMessageLog brokerMessageLog,@PathVariable  id){
        //设置主键值
        brokerMessageLog.set(id);
        //调用BrokerMessageLogService实现修改BrokerMessageLog
        brokerMessageLogService.update(brokerMessageLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增BrokerMessageLog数据
     * @param brokerMessageLog
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog添加",notes = "添加BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "BrokerMessageLog对象",value = "传入JSON数据",required = true) BrokerMessageLog brokerMessageLog){
        //调用BrokerMessageLogService实现添加BrokerMessageLog
        brokerMessageLogService.add(brokerMessageLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询BrokerMessageLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "BrokerMessageLog根据ID查询",notes = "根据ID查询BrokerMessageLog方法详情",tags = {"BrokerMessageLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<BrokerMessageLog> findById(@PathVariable  id){
        //调用BrokerMessageLogService实现根据主键查询BrokerMessageLog
        BrokerMessageLog brokerMessageLog = brokerMessageLogService.findById(id);
        return new Result<BrokerMessageLog>(true,StatusCode.OK,"查询成功",brokerMessageLog);
    }

    /***
     * 查询BrokerMessageLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有BrokerMessageLog",notes = "查询所BrokerMessageLog有方法详情",tags = {"BrokerMessageLogController"})
    @GetMapping
    public Result<List<BrokerMessageLog>> findAll(){
        //调用BrokerMessageLogService实现查询所有BrokerMessageLog
        List<BrokerMessageLog> list = brokerMessageLogService.findAll();
        return new Result<List<BrokerMessageLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
