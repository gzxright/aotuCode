package com.changgou.order.controller;
import com.changgou.order.pojo.SsoClientDetails;
import com.changgou.order.service.SsoClientDetailsService;
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
@Api(value = "SsoClientDetailsController")
@RestController
@RequestMapping("/ssoClientDetails")
@CrossOrigin
public class SsoClientDetailsController {

    @Autowired
    private SsoClientDetailsService ssoClientDetailsService;

    /***
     * SsoClientDetails分页条件搜索实现
     * @param ssoClientDetails
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SsoClientDetails条件分页查询",notes = "分页条件查询SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SsoClientDetails对象",value = "传入JSON数据",required = false) SsoClientDetails ssoClientDetails, @PathVariable  int page, @PathVariable  int size){
        //调用SsoClientDetailsService实现分页条件查询SsoClientDetails
        PageInfo<SsoClientDetails> pageInfo = ssoClientDetailsService.findPage(ssoClientDetails, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SsoClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SsoClientDetails分页查询",notes = "分页查询SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SsoClientDetailsService实现分页查询SsoClientDetails
        PageInfo<SsoClientDetails> pageInfo = ssoClientDetailsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param ssoClientDetails
     * @return
     */
    @ApiOperation(value = "SsoClientDetails条件查询",notes = "条件查询SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @PostMapping(value = "/search" )
    public Result<List<SsoClientDetails>> findList(@RequestBody(required = false) @ApiParam(name = "SsoClientDetails对象",value = "传入JSON数据",required = false) SsoClientDetails ssoClientDetails){
        //调用SsoClientDetailsService实现条件查询SsoClientDetails
        List<SsoClientDetails> list = ssoClientDetailsService.findList(ssoClientDetails);
        return new Result<List<SsoClientDetails>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoClientDetails根据ID删除",notes = "根据ID删除SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SsoClientDetailsService实现根据主键删除
        ssoClientDetailsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SsoClientDetails数据
     * @param ssoClientDetails
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoClientDetails根据ID修改",notes = "根据ID修改SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SsoClientDetails对象",value = "传入JSON数据",required = false) SsoClientDetails ssoClientDetails,@PathVariable Integer id){
        //设置主键值
        ssoClientDetails.setId(id);
        //调用SsoClientDetailsService实现修改SsoClientDetails
        ssoClientDetailsService.update(ssoClientDetails);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SsoClientDetails数据
     * @param ssoClientDetails
     * @return
     */
    @ApiOperation(value = "SsoClientDetails添加",notes = "添加SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SsoClientDetails对象",value = "传入JSON数据",required = true) SsoClientDetails ssoClientDetails){
        //调用SsoClientDetailsService实现添加SsoClientDetails
        ssoClientDetailsService.add(ssoClientDetails);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SsoClientDetails数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoClientDetails根据ID查询",notes = "根据ID查询SsoClientDetails方法详情",tags = {"SsoClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<SsoClientDetails> findById(@PathVariable Integer id){
        //调用SsoClientDetailsService实现根据主键查询SsoClientDetails
        SsoClientDetails ssoClientDetails = ssoClientDetailsService.findById(id);
        return new Result<SsoClientDetails>(true,StatusCode.OK,"查询成功",ssoClientDetails);
    }

    /***
     * 查询SsoClientDetails全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SsoClientDetails",notes = "查询所SsoClientDetails有方法详情",tags = {"SsoClientDetailsController"})
    @GetMapping
    public Result<List<SsoClientDetails>> findAll(){
        //调用SsoClientDetailsService实现查询所有SsoClientDetails
        List<SsoClientDetails> list = ssoClientDetailsService.findAll();
        return new Result<List<SsoClientDetails>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
