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
@RequestMapping("/userRole")
public interface UserRoleFeign {

    /***
     * UserRole分页条件搜索实现
     * @param userRole
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) UserRole userRole, @PathVariable  int page, @PathVariable  int size);

    /***
     * UserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param userRole
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<UserRole>> findList(@RequestBody(required = false) UserRole userRole);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改UserRole数据
     * @param userRole
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UserRole userRole,@PathVariable Integer id);

    /***
     * 新增UserRole数据
     * @param userRole
     * @return
     */
    @PostMapping
    Result add(@RequestBody UserRole userRole);

    /***
     * 根据ID查询UserRole数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<UserRole> findById(@PathVariable Integer id);

    /***
     * 查询UserRole全部数据
     * @return
     */
    @GetMapping
    Result<List<UserRole>> findAll();
}