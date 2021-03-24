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
@RequestMapping("/tenantCapacity")
public interface TenantCapacityFeign {

    /***
     * TenantCapacity分页条件搜索实现
     * @param tenantCapacity
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) TenantCapacity tenantCapacity, @PathVariable  int page, @PathVariable  int size);

    /***
     * TenantCapacity分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param tenantCapacity
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<TenantCapacity>> findList(@RequestBody(required = false) TenantCapacity tenantCapacity);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改TenantCapacity数据
     * @param tenantCapacity
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody TenantCapacity tenantCapacity,@PathVariable  id);

    /***
     * 新增TenantCapacity数据
     * @param tenantCapacity
     * @return
     */
    @PostMapping
    Result add(@RequestBody TenantCapacity tenantCapacity);

    /***
     * 根据ID查询TenantCapacity数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<TenantCapacity> findById(@PathVariable  id);

    /***
     * 查询TenantCapacity全部数据
     * @return
     */
    @GetMapping
    Result<List<TenantCapacity>> findAll();
}