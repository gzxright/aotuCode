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
@RequestMapping("/filmActor")
public interface FilmActorFeign {

    /***
     * FilmActor分页条件搜索实现
     * @param filmActor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) FilmActor filmActor, @PathVariable  int page, @PathVariable  int size);

    /***
     * FilmActor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param filmActor
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<FilmActor>> findList(@RequestBody(required = false) FilmActor filmActor);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改FilmActor数据
     * @param filmActor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody FilmActor filmActor,@PathVariable  id);

    /***
     * 新增FilmActor数据
     * @param filmActor
     * @return
     */
    @PostMapping
    Result add(@RequestBody FilmActor filmActor);

    /***
     * 根据ID查询FilmActor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<FilmActor> findById(@PathVariable  id);

    /***
     * 查询FilmActor全部数据
     * @return
     */
    @GetMapping
    Result<List<FilmActor>> findAll();
}