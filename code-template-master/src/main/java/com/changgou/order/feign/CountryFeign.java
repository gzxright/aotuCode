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
@RequestMapping("/country")
public interface CountryFeign {

    /***
     * Country分页条件搜索实现
     * @param country
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Country country, @PathVariable  int page, @PathVariable  int size);

    /***
     * Country分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param country
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Country>> findList(@RequestBody(required = false) Country country);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Country数据
     * @param country
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Country country,@PathVariable  id);

    /***
     * 新增Country数据
     * @param country
     * @return
     */
    @PostMapping
    Result add(@RequestBody Country country);

    /***
     * 根据ID查询Country数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Country> findById(@PathVariable  id);

    /***
     * 查询Country全部数据
     * @return
     */
    @GetMapping
    Result<List<Country>> findAll();
}