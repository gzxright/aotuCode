package com.changgou.order.controller;
import com.changgou.order.pojo.FilmActor;
import com.changgou.order.service.FilmActorService;
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
@Api(value = "FilmActorController")
@RestController
@RequestMapping("/filmActor")
@CrossOrigin
public class FilmActorController {

    @Autowired
    private FilmActorService filmActorService;

    /***
     * FilmActor分页条件搜索实现
     * @param filmActor
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "FilmActor条件分页查询",notes = "分页条件查询FilmActor方法详情",tags = {"FilmActorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "FilmActor对象",value = "传入JSON数据",required = false) FilmActor filmActor, @PathVariable  int page, @PathVariable  int size){
        //调用FilmActorService实现分页条件查询FilmActor
        PageInfo<FilmActor> pageInfo = filmActorService.findPage(filmActor, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FilmActor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "FilmActor分页查询",notes = "分页查询FilmActor方法详情",tags = {"FilmActorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FilmActorService实现分页查询FilmActor
        PageInfo<FilmActor> pageInfo = filmActorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param filmActor
     * @return
     */
    @ApiOperation(value = "FilmActor条件查询",notes = "条件查询FilmActor方法详情",tags = {"FilmActorController"})
    @PostMapping(value = "/search" )
    public Result<List<FilmActor>> findList(@RequestBody(required = false) @ApiParam(name = "FilmActor对象",value = "传入JSON数据",required = false) FilmActor filmActor){
        //调用FilmActorService实现条件查询FilmActor
        List<FilmActor> list = filmActorService.findList(filmActor);
        return new Result<List<FilmActor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmActor根据ID删除",notes = "根据ID删除FilmActor方法详情",tags = {"FilmActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用FilmActorService实现根据主键删除
        filmActorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FilmActor数据
     * @param filmActor
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmActor根据ID修改",notes = "根据ID修改FilmActor方法详情",tags = {"FilmActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "FilmActor对象",value = "传入JSON数据",required = false) FilmActor filmActor,@PathVariable  id){
        //设置主键值
        filmActor.set(id);
        //调用FilmActorService实现修改FilmActor
        filmActorService.update(filmActor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FilmActor数据
     * @param filmActor
     * @return
     */
    @ApiOperation(value = "FilmActor添加",notes = "添加FilmActor方法详情",tags = {"FilmActorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "FilmActor对象",value = "传入JSON数据",required = true) FilmActor filmActor){
        //调用FilmActorService实现添加FilmActor
        filmActorService.add(filmActor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FilmActor数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FilmActor根据ID查询",notes = "根据ID查询FilmActor方法详情",tags = {"FilmActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<FilmActor> findById(@PathVariable  id){
        //调用FilmActorService实现根据主键查询FilmActor
        FilmActor filmActor = filmActorService.findById(id);
        return new Result<FilmActor>(true,StatusCode.OK,"查询成功",filmActor);
    }

    /***
     * 查询FilmActor全部数据
     * @return
     */
    @ApiOperation(value = "查询所有FilmActor",notes = "查询所FilmActor有方法详情",tags = {"FilmActorController"})
    @GetMapping
    public Result<List<FilmActor>> findAll(){
        //调用FilmActorService实现查询所有FilmActor
        List<FilmActor> list = filmActorService.findAll();
        return new Result<List<FilmActor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
