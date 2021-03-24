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
@RequestMapping("/tenantInfo")
public interface TenantInfoFeign {

    /***
     * TenantInfo分页条件搜索实现
     * @param tenantInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) TenantInfo tenantInfo, @PathVariable  int page, @PathVariable  int size);

    /***
     * TenantInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param tenantInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<TenantInfo>> findList(@RequestBody(required = false) TenantInfo tenantInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改TenantInfo数据
     * @param tenantInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody TenantInfo tenantInfo,@PathVariable  id);

    /***
     * 新增TenantInfo数据
     * @param tenantInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody TenantInfo tenantInfo);

    /***
     * 根据ID查询TenantInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<TenantInfo> findById(@PathVariable  id);

    /***
     * 查询TenantInfo全部数据
     * @return
     */
    @GetMapping
    Result<List<TenantInfo>> findAll();
}