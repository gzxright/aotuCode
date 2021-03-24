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
@RequestMapping("/city")
public interface CityFeign {

    /***
     * City分页条件搜索实现
     * @param city
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) City city, @PathVariable  int page, @PathVariable  int size);

    /***
     * City分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param city
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<City>> findList(@RequestBody(required = false) City city);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改City数据
     * @param city
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody City city,@PathVariable  id);

    /***
     * 新增City数据
     * @param city
     * @return
     */
    @PostMapping
    Result add(@RequestBody City city);

    /***
     * 根据ID查询City数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<City> findById(@PathVariable  id);

    /***
     * 查询City全部数据
     * @return
     */
    @GetMapping
    Result<List<City>> findAll();
}