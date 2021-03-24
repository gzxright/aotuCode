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
@RequestMapping("/roles")
public interface RolesFeign {

    /***
     * Roles分页条件搜索实现
     * @param roles
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Roles roles, @PathVariable  int page, @PathVariable  int size);

    /***
     * Roles分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param roles
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Roles>> findList(@RequestBody(required = false) Roles roles);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Roles数据
     * @param roles
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Roles roles,@PathVariable  id);

    /***
     * 新增Roles数据
     * @param roles
     * @return
     */
    @PostMapping
    Result add(@RequestBody Roles roles);

    /***
     * 根据ID查询Roles数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Roles> findById(@PathVariable  id);

    /***
     * 查询Roles全部数据
     * @return
     */
    @GetMapping
    Result<List<Roles>> findAll();
}