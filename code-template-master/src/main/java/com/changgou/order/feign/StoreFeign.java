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
@RequestMapping("/store")
public interface StoreFeign {

    /***
     * Store分页条件搜索实现
     * @param store
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Store store, @PathVariable  int page, @PathVariable  int size);

    /***
     * Store分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param store
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Store>> findList(@RequestBody(required = false) Store store);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Store数据
     * @param store
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Store store,@PathVariable  id);

    /***
     * 新增Store数据
     * @param store
     * @return
     */
    @PostMapping
    Result add(@RequestBody Store store);

    /***
     * 根据ID查询Store数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Store> findById(@PathVariable  id);

    /***
     * 查询Store全部数据
     * @return
     */
    @GetMapping
    Result<List<Store>> findAll();
}