package com.changgou.order.controller;
import com.changgou.order.pojo.Film;
import com.changgou.order.service.FilmService;
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
@Api(value = "FilmController")
@RestController
@RequestMapping("/film")
@CrossOrigin
public class FilmController {

    @Autowired
    private FilmService filmService;

    /***
     * Film分页条件搜索实现
     * @param film
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Film条件分页查询",notes = "分页条件查询Film方法详情",tags = {"FilmController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Film对象",value = "传入JSON数据",required = false) Film film, @PathVariable  int page, @PathVariable  int size){
        //调用FilmService实现分页条件查询Film
        PageInfo<Film> pageInfo = filmService.findPage(film, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Film分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Film分页查询",notes = "分页查询Film方法详情",tags = {"FilmController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FilmService实现分页查询Film
        PageInfo<Film> pageInfo = filmService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param film
     * @return
     */
    @ApiOperation(value = "Film条件查询",notes = "条件查询Film方法详情",tags = {"FilmController"})
    @PostMapping(value = "/search" )
    public Result<List<Film>> findList(@RequestBody(required = false) @ApiParam(name = "Film对象",value = "传入JSON数据",required = false) Film film){
        //调用FilmService实现条件查询Film
        List<Film> list = filmService.findList(film);
        return new Result<List<Film>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Film根据ID删除",notes = "根据ID删除Film方法详情",tags = {"FilmController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用FilmService实现根据主键删除
        filmService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Film数据
     * @param film
     * @param id
     * @return
     */
    @ApiOperation(value = "Film根据ID修改",notes = "根据ID修改Film方法详情",tags = {"FilmController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Film对象",value = "传入JSON数据",required = false) Film film,@PathVariable  id){
        //设置主键值
        film.set(id);
        //调用FilmService实现修改Film
        filmService.update(film);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Film数据
     * @param film
     * @return
     */
    @ApiOperation(value = "Film添加",notes = "添加Film方法详情",tags = {"FilmController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Film对象",value = "传入JSON数据",required = true) Film film){
        //调用FilmService实现添加Film
        filmService.add(film);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Film数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Film根据ID查询",notes = "根据ID查询Film方法详情",tags = {"FilmController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Film> findById(@PathVariable  id){
        //调用FilmService实现根据主键查询Film
        Film film = filmService.findById(id);
        return new Result<Film>(true,StatusCode.OK,"查询成功",film);
    }

    /***
     * 查询Film全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Film",notes = "查询所Film有方法详情",tags = {"FilmController"})
    @GetMapping
    public Result<List<Film>> findAll(){
        //调用FilmService实现查询所有Film
        List<Film> list = filmService.findAll();
        return new Result<List<Film>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
