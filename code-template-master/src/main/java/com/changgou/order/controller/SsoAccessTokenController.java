package com.changgou.order.controller;
import com.changgou.order.pojo.SsoAccessToken;
import com.changgou.order.service.SsoAccessTokenService;
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
@Api(value = "SsoAccessTokenController")
@RestController
@RequestMapping("/ssoAccessToken")
@CrossOrigin
public class SsoAccessTokenController {

    @Autowired
    private SsoAccessTokenService ssoAccessTokenService;

    /***
     * SsoAccessToken分页条件搜索实现
     * @param ssoAccessToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SsoAccessToken条件分页查询",notes = "分页条件查询SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SsoAccessToken对象",value = "传入JSON数据",required = false) SsoAccessToken ssoAccessToken, @PathVariable  int page, @PathVariable  int size){
        //调用SsoAccessTokenService实现分页条件查询SsoAccessToken
        PageInfo<SsoAccessToken> pageInfo = ssoAccessTokenService.findPage(ssoAccessToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SsoAccessToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SsoAccessToken分页查询",notes = "分页查询SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SsoAccessTokenService实现分页查询SsoAccessToken
        PageInfo<SsoAccessToken> pageInfo = ssoAccessTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param ssoAccessToken
     * @return
     */
    @ApiOperation(value = "SsoAccessToken条件查询",notes = "条件查询SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<SsoAccessToken>> findList(@RequestBody(required = false) @ApiParam(name = "SsoAccessToken对象",value = "传入JSON数据",required = false) SsoAccessToken ssoAccessToken){
        //调用SsoAccessTokenService实现条件查询SsoAccessToken
        List<SsoAccessToken> list = ssoAccessTokenService.findList(ssoAccessToken);
        return new Result<List<SsoAccessToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoAccessToken根据ID删除",notes = "根据ID删除SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SsoAccessTokenService实现根据主键删除
        ssoAccessTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SsoAccessToken数据
     * @param ssoAccessToken
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoAccessToken根据ID修改",notes = "根据ID修改SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SsoAccessToken对象",value = "传入JSON数据",required = false) SsoAccessToken ssoAccessToken,@PathVariable Integer id){
        //设置主键值
        ssoAccessToken.setId(id);
        //调用SsoAccessTokenService实现修改SsoAccessToken
        ssoAccessTokenService.update(ssoAccessToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SsoAccessToken数据
     * @param ssoAccessToken
     * @return
     */
    @ApiOperation(value = "SsoAccessToken添加",notes = "添加SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SsoAccessToken对象",value = "传入JSON数据",required = true) SsoAccessToken ssoAccessToken){
        //调用SsoAccessTokenService实现添加SsoAccessToken
        ssoAccessTokenService.add(ssoAccessToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SsoAccessToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoAccessToken根据ID查询",notes = "根据ID查询SsoAccessToken方法详情",tags = {"SsoAccessTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<SsoAccessToken> findById(@PathVariable Integer id){
        //调用SsoAccessTokenService实现根据主键查询SsoAccessToken
        SsoAccessToken ssoAccessToken = ssoAccessTokenService.findById(id);
        return new Result<SsoAccessToken>(true,StatusCode.OK,"查询成功",ssoAccessToken);
    }

    /***
     * 查询SsoAccessToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SsoAccessToken",notes = "查询所SsoAccessToken有方法详情",tags = {"SsoAccessTokenController"})
    @GetMapping
    public Result<List<SsoAccessToken>> findAll(){
        //调用SsoAccessTokenService实现查询所有SsoAccessToken
        List<SsoAccessToken> list = ssoAccessTokenService.findAll();
        return new Result<List<SsoAccessToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
