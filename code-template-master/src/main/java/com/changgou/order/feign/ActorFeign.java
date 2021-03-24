package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/actor")
public interface ActorFeign {

    /***
     * Actor分页条件搜索实现
     * @param actor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Actor actor, @PathVariable  int page, @PathVariable  int size);

    /***
     * Actor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param actor
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Actor>> findList(@RequestBody(required = false) Actor actor);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Actor数据
     * @param actor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Actor actor,@PathVariable  id);

    /***
     * 新增Actor数据
     * @param actor
     * @return
     */
    @PostMapping
    Result add(@RequestBody Actor actor);

    /***
     * 根据ID查询Actor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Actor> findById(@PathVariable  id);

    /***
     * 查询Actor全部数据
     * @return
     */
    @GetMapping
    Result<List<Actor>> findAll();
}