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
@RequestMapping("/countrylanguage")
public interface CountrylanguageFeign {

    /***
     * Countrylanguage分页条件搜索实现
     * @param countrylanguage
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Countrylanguage countrylanguage, @PathVariable  int page, @PathVariable  int size);

    /***
     * Countrylanguage分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param countrylanguage
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Countrylanguage>> findList(@RequestBody(required = false) Countrylanguage countrylanguage);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Countrylanguage数据
     * @param countrylanguage
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Countrylanguage countrylanguage,@PathVariable  id);

    /***
     * 新增Countrylanguage数据
     * @param countrylanguage
     * @return
     */
    @PostMapping
    Result add(@RequestBody Countrylanguage countrylanguage);

    /***
     * 根据ID查询Countrylanguage数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Countrylanguage> findById(@PathVariable  id);

    /***
     * 查询Countrylanguage全部数据
     * @return
     */
    @GetMapping
    Result<List<Countrylanguage>> findAll();
}