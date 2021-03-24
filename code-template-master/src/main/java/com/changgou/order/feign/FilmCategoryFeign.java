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
@RequestMapping("/filmCategory")
public interface FilmCategoryFeign {

    /***
     * FilmCategory分页条件搜索实现
     * @param filmCategory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) FilmCategory filmCategory, @PathVariable  int page, @PathVariable  int size);

    /***
     * FilmCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param filmCategory
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<FilmCategory>> findList(@RequestBody(required = false) FilmCategory filmCategory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改FilmCategory数据
     * @param filmCategory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody FilmCategory filmCategory,@PathVariable  id);

    /***
     * 新增FilmCategory数据
     * @param filmCategory
     * @return
     */
    @PostMapping
    Result add(@RequestBody FilmCategory filmCategory);

    /***
     * 根据ID查询FilmCategory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<FilmCategory> findById(@PathVariable  id);

    /***
     * 查询FilmCategory全部数据
     * @return
     */
    @GetMapping
    Result<List<FilmCategory>> findAll();
}