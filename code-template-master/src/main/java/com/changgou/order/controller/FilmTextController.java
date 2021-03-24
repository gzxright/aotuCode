package com.changgou.order.controller;
import com.changgou.order.pojo.FilmText;
import com.changgou.order.service.FilmTextService;
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
@Api(value = "FilmTextController")
@RestController
@RequestMapping("/filmText")
@CrossOrigin
public class FilmTextController {

    @Autowired
    private FilmTextService filmTextService;

    /***
     * FilmText分页条件搜索实现
     * @param filmText
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "FilmText条件分页查询",notes = "分页条件查询FilmText方法详情",tags = {"FilmTextController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "FilmText对象",value = "传入JSON数据",required = false) FilmText filmText, @PathVariable  int page, @PathVariable  int size){
        //调用FilmTextService实现分页条件查询FilmText
        PageInfo<FilmText> pageInfo = filmTextService.findPage(filmText, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FilmText分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "FilmText分页查询",notes = "分页查询FilmText方法详情",tags = {"FilmTextController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FilmTextService实现分页查询FilmText
        PageInfo<FilmText> pageInfo = filmTextService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param filmText
     * @return
     */
    @ApiOperation(value = "FilmText条件查询",notes = "条件查询FilmText方法详情",tags = {"FilmTextController"})
    @PostMapping(value = "/search" )
    public Result<List<FilmText>> findList(@RequestBody(required = false) @ApiParam(name = "FilmText对象",value = "传入JSON数据",required = false) FilmText filmText){
        //调用FilmTextService实现条件查询FilmText
        List<FilmText> list = filmTextService.findList(filmText);
        return new Result<List<FilmText>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmText根据ID删除",notes = "根据ID删除FilmText方法详情",tags = {"FilmTextController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用FilmTextService实现根据主键删除
        filmTextService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FilmText数据
     * @param filmText
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmText根据ID修改",notes = "根据ID修改FilmText方法详情",tags = {"FilmTextController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "FilmText对象",value = "传入JSON数据",required = false) FilmText filmText,@PathVariable  id){
        //设置主键值
        filmText.set(id);
        //调用FilmTextService实现修改FilmText
        filmTextService.update(filmText);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FilmText数据
     * @param filmText
     * @return
     */
    @ApiOperation(value = "FilmText添加",notes = "添加FilmText方法详情",tags = {"FilmTextController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "FilmText对象",value = "传入JSON数据",required = true) FilmText filmText){
        //调用FilmTextService实现添加FilmText
        filmTextService.add(filmText);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FilmText数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmText根据ID查询",notes = "根据ID查询FilmText方法详情",tags = {"FilmTextController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<FilmText> findById(@PathVariable  id){
        //调用FilmTextService实现根据主键查询FilmText
        FilmText filmText = filmTextService.findById(id);
        return new Result<FilmText>(true,StatusCode.OK,"查询成功",filmText);
    }

    /***
     * 查询FilmText全部数据
     * @return
     */
    @ApiOperation(value = "查询所有FilmText",notes = "查询所FilmText有方法详情",tags = {"FilmTextController"})
    @GetMapping
    public Result<List<FilmText>> findAll(){
        //调用FilmTextService实现查询所有FilmText
        List<FilmText> list = filmTextService.findAll();
        return new Result<List<FilmText>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
