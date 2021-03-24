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
@RequestMapping("/film")
public interface FilmFeign {

    /***
     * Film分页条件搜索实现
     * @param film
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Film film, @PathVariable  int page, @PathVariable  int size);

    /***
     * Film分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param film
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Film>> findList(@RequestBody(required = false) Film film);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Film数据
     * @param film
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Film film,@PathVariable  id);

    /***
     * 新增Film数据
     * @param film
     * @return
     */
    @PostMapping
    Result add(@RequestBody Film film);

    /***
     * 根据ID查询Film数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Film> findById(@PathVariable  id);

    /***
     * 查询Film全部数据
     * @return
     */
    @GetMapping
    Result<List<Film>> findAll();
}