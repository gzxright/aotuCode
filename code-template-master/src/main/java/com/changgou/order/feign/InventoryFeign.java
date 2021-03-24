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
@RequestMapping("/inventory")
public interface InventoryFeign {

    /***
     * Inventory分页条件搜索实现
     * @param inventory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Inventory inventory, @PathVariable  int page, @PathVariable  int size);

    /***
     * Inventory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param inventory
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Inventory>> findList(@RequestBody(required = false) Inventory inventory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Inventory数据
     * @param inventory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Inventory inventory,@PathVariable  id);

    /***
     * 新增Inventory数据
     * @param inventory
     * @return
     */
    @PostMapping
    Result add(@RequestBody Inventory inventory);

    /***
     * 根据ID查询Inventory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Inventory> findById(@PathVariable  id);

    /***
     * 查询Inventory全部数据
     * @return
     */
    @GetMapping
    Result<List<Inventory>> findAll();
}