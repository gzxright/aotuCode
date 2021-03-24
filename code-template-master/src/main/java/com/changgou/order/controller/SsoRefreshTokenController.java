package com.changgou.order.controller;
import com.changgou.order.pojo.SsoRefreshToken;
import com.changgou.order.service.SsoRefreshTokenService;
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
@Api(value = "SsoRefreshTokenController")
@RestController
@RequestMapping("/ssoRefreshToken")
@CrossOrigin
public class SsoRefreshTokenController {

    @Autowired
    private SsoRefreshTokenService ssoRefreshTokenService;

    /***
     * SsoRefreshToken分页条件搜索实现
     * @param ssoRefreshToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken条件分页查询",notes = "分页条件查询SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SsoRefreshToken对象",value = "传入JSON数据",required = false) SsoRefreshToken ssoRefreshToken, @PathVariable  int page, @PathVariable  int size){
        //调用SsoRefreshTokenService实现分页条件查询SsoRefreshToken
        PageInfo<SsoRefreshToken> pageInfo = ssoRefreshTokenService.findPage(ssoRefreshToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SsoRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken分页查询",notes = "分页查询SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SsoRefreshTokenService实现分页查询SsoRefreshToken
        PageInfo<SsoRefreshToken> pageInfo = ssoRefreshTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param ssoRefreshToken
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken条件查询",notes = "条件查询SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<SsoRefreshToken>> findList(@RequestBody(required = false) @ApiParam(name = "SsoRefreshToken对象",value = "传入JSON数据",required = false) SsoRefreshToken ssoRefreshToken){
        //调用SsoRefreshTokenService实现条件查询SsoRefreshToken
        List<SsoRefreshToken> list = ssoRefreshTokenService.findList(ssoRefreshToken);
        return new Result<List<SsoRefreshToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken根据ID删除",notes = "根据ID删除SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SsoRefreshTokenService实现根据主键删除
        ssoRefreshTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SsoRefreshToken数据
     * @param ssoRefreshToken
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken根据ID修改",notes = "根据ID修改SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SsoRefreshToken对象",value = "传入JSON数据",required = false) SsoRefreshToken ssoRefreshToken,@PathVariable Integer id){
        //设置主键值
        ssoRefreshToken.setId(id);
        //调用SsoRefreshTokenService实现修改SsoRefreshToken
        ssoRefreshTokenService.update(ssoRefreshToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SsoRefreshToken数据
     * @param ssoRefreshToken
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken添加",notes = "添加SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SsoRefreshToken对象",value = "传入JSON数据",required = true) SsoRefreshToken ssoRefreshToken){
        //调用SsoRefreshTokenService实现添加SsoRefreshToken
        ssoRefreshTokenService.add(ssoRefreshToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SsoRefreshToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SsoRefreshToken根据ID查询",notes = "根据ID查询SsoRefreshToken方法详情",tags = {"SsoRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<SsoRefreshToken> findById(@PathVariable Integer id){
        //调用SsoRefreshTokenService实现根据主键查询SsoRefreshToken
        SsoRefreshToken ssoRefreshToken = ssoRefreshTokenService.findById(id);
        return new Result<SsoRefreshToken>(true,StatusCode.OK,"查询成功",ssoRefreshToken);
    }

    /***
     * 查询SsoRefreshToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SsoRefreshToken",notes = "查询所SsoRefreshToken有方法详情",tags = {"SsoRefreshTokenController"})
    @GetMapping
    public Result<List<SsoRefreshToken>> findAll(){
        //调用SsoRefreshTokenService实现查询所有SsoRefreshToken
        List<SsoRefreshToken> list = ssoRefreshTokenService.findAll();
        return new Result<List<SsoRefreshToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
