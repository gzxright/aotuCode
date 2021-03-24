package com.changgou.order.controller;
import com.changgou.order.pojo.AuthClientDetails;
import com.changgou.order.service.AuthClientDetailsService;
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
@Api(value = "AuthClientDetailsController")
@RestController
@RequestMapping("/authClientDetails")
@CrossOrigin
public class AuthClientDetailsController {

    @Autowired
    private AuthClientDetailsService authClientDetailsService;

    /***
     * AuthClientDetails分页条件搜索实现
     * @param authClientDetails
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AuthClientDetails条件分页查询",notes = "分页条件查询AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AuthClientDetails对象",value = "传入JSON数据",required = false) AuthClientDetails authClientDetails, @PathVariable  int page, @PathVariable  int size){
        //调用AuthClientDetailsService实现分页条件查询AuthClientDetails
        PageInfo<AuthClientDetails> pageInfo = authClientDetailsService.findPage(authClientDetails, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AuthClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AuthClientDetails分页查询",notes = "分页查询AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AuthClientDetailsService实现分页查询AuthClientDetails
        PageInfo<AuthClientDetails> pageInfo = authClientDetailsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param authClientDetails
     * @return
     */
    @ApiOperation(value = "AuthClientDetails条件查询",notes = "条件查询AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @PostMapping(value = "/search" )
    public Result<List<AuthClientDetails>> findList(@RequestBody(required = false) @ApiParam(name = "AuthClientDetails对象",value = "传入JSON数据",required = false) AuthClientDetails authClientDetails){
        //调用AuthClientDetailsService实现条件查询AuthClientDetails
        List<AuthClientDetails> list = authClientDetailsService.findList(authClientDetails);
        return new Result<List<AuthClientDetails>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientDetails根据ID删除",notes = "根据ID删除AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AuthClientDetailsService实现根据主键删除
        authClientDetailsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AuthClientDetails数据
     * @param authClientDetails
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientDetails根据ID修改",notes = "根据ID修改AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AuthClientDetails对象",value = "传入JSON数据",required = false) AuthClientDetails authClientDetails,@PathVariable Integer id){
        //设置主键值
        authClientDetails.setId(id);
        //调用AuthClientDetailsService实现修改AuthClientDetails
        authClientDetailsService.update(authClientDetails);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AuthClientDetails数据
     * @param authClientDetails
     * @return
     */
    @ApiOperation(value = "AuthClientDetails添加",notes = "添加AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AuthClientDetails对象",value = "传入JSON数据",required = true) AuthClientDetails authClientDetails){
        //调用AuthClientDetailsService实现添加AuthClientDetails
        authClientDetailsService.add(authClientDetails);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AuthClientDetails数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AuthClientDetails根据ID查询",notes = "根据ID查询AuthClientDetails方法详情",tags = {"AuthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AuthClientDetails> findById(@PathVariable Integer id){
        //调用AuthClientDetailsService实现根据主键查询AuthClientDetails
        AuthClientDetails authClientDetails = authClientDetailsService.findById(id);
        return new Result<AuthClientDetails>(true,StatusCode.OK,"查询成功",authClientDetails);
    }

    /***
     * 查询AuthClientDetails全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AuthClientDetails",notes = "查询所AuthClientDetails有方法详情",tags = {"AuthClientDetailsController"})
    @GetMapping
    public Result<List<AuthClientDetails>> findAll(){
        //调用AuthClientDetailsService实现查询所有AuthClientDetails
        List<AuthClientDetails> list = authClientDetailsService.findAll();
        return new Result<List<AuthClientDetails>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
