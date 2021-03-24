package com.changgou.order.controller;
import com.changgou.order.pojo.Actor;
import com.changgou.order.service.ActorService;
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
@Api(value = "ActorController")
@RestController
@RequestMapping("/actor")
@CrossOrigin
public class ActorController {

    @Autowired
    private ActorService actorService;

    /***
     * Actor分页条件搜索实现
     * @param actor
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Actor条件分页查询",notes = "分页条件查询Actor方法详情",tags = {"ActorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Actor对象",value = "传入JSON数据",required = false) Actor actor, @PathVariable  int page, @PathVariable  int size){
        //调用ActorService实现分页条件查询Actor
        PageInfo<Actor> pageInfo = actorService.findPage(actor, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Actor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Actor分页查询",notes = "分页查询Actor方法详情",tags = {"ActorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ActorService实现分页查询Actor
        PageInfo<Actor> pageInfo = actorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param actor
     * @return
     */
    @ApiOperation(value = "Actor条件查询",notes = "条件查询Actor方法详情",tags = {"ActorController"})
    @PostMapping(value = "/search" )
    public Result<List<Actor>> findList(@RequestBody(required = false) @ApiParam(name = "Actor对象",value = "传入JSON数据",required = false) Actor actor){
        //调用ActorService实现条件查询Actor
        List<Actor> list = actorService.findList(actor);
        return new Result<List<Actor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Actor根据ID删除",notes = "根据ID删除Actor方法详情",tags = {"ActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用ActorService实现根据主键删除
        actorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Actor数据
     * @param actor
     * @param id
     * @return
     */
    @ApiOperation(value = "Actor根据ID修改",notes = "根据ID修改Actor方法详情",tags = {"ActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Actor对象",value = "传入JSON数据",required = false) Actor actor,@PathVariable  id){
        //设置主键值
        actor.set(id);
        //调用ActorService实现修改Actor
        actorService.update(actor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Actor数据
     * @param actor
     * @return
     */
    @ApiOperation(value = "Actor添加",notes = "添加Actor方法详情",tags = {"ActorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Actor对象",value = "传入JSON数据",required = true) Actor actor){
        //调用ActorService实现添加Actor
        actorService.add(actor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Actor数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Actor根据ID查询",notes = "根据ID查询Actor方法详情",tags = {"ActorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Actor> findById(@PathVariable  id){
        //调用ActorService实现根据主键查询Actor
        Actor actor = actorService.findById(id);
        return new Result<Actor>(true,StatusCode.OK,"查询成功",actor);
    }

    /***
     * 查询Actor全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Actor",notes = "查询所Actor有方法详情",tags = {"ActorController"})
    @GetMapping
    public Result<List<Actor>> findAll(){
        //调用ActorService实现查询所有Actor
        List<Actor> list = actorService.findAll();
        return new Result<List<Actor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
