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
@RequestMapping("/resourceMenu")
public interface ResourceMenuFeign {

    /***
     * ResourceMenu分页条件搜索实现
     * @param resourceMenu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ResourceMenu resourceMenu, @PathVariable  int page, @PathVariable  int size);

    /***
     * ResourceMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param resourceMenu
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ResourceMenu>> findList(@RequestBody(required = false) ResourceMenu resourceMenu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ResourceMenu数据
     * @param resourceMenu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ResourceMenu resourceMenu,@PathVariable  id);

    /***
     * 新增ResourceMenu数据
     * @param resourceMenu
     * @return
     */
    @PostMapping
    Result add(@RequestBody ResourceMenu resourceMenu);

    /***
     * 根据ID查询ResourceMenu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ResourceMenu> findById(@PathVariable  id);

    /***
     * 查询ResourceMenu全部数据
     * @return
     */
    @GetMapping
    Result<List<ResourceMenu>> findAll();
}