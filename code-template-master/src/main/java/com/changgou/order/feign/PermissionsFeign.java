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
@RequestMapping("/permissions")
public interface PermissionsFeign {

    /***
     * Permissions分页条件搜索实现
     * @param permissions
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Permissions permissions, @PathVariable  int page, @PathVariable  int size);

    /***
     * Permissions分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param permissions
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Permissions>> findList(@RequestBody(required = false) Permissions permissions);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Permissions数据
     * @param permissions
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Permissions permissions,@PathVariable  id);

    /***
     * 新增Permissions数据
     * @param permissions
     * @return
     */
    @PostMapping
    Result add(@RequestBody Permissions permissions);

    /***
     * 根据ID查询Permissions数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Permissions> findById(@PathVariable  id);

    /***
     * 查询Permissions全部数据
     * @return
     */
    @GetMapping
    Result<List<Permissions>> findAll();
}