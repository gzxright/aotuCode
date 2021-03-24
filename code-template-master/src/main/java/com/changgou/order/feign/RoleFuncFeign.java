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
@RequestMapping("/roleFunc")
public interface RoleFuncFeign {

    /***
     * RoleFunc分页条件搜索实现
     * @param roleFunc
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) RoleFunc roleFunc, @PathVariable  int page, @PathVariable  int size);

    /***
     * RoleFunc分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param roleFunc
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<RoleFunc>> findList(@RequestBody(required = false) RoleFunc roleFunc);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改RoleFunc数据
     * @param roleFunc
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody RoleFunc roleFunc,@PathVariable Integer id);

    /***
     * 新增RoleFunc数据
     * @param roleFunc
     * @return
     */
    @PostMapping
    Result add(@RequestBody RoleFunc roleFunc);

    /***
     * 根据ID查询RoleFunc数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<RoleFunc> findById(@PathVariable Integer id);

    /***
     * 查询RoleFunc全部数据
     * @return
     */
    @GetMapping
    Result<List<RoleFunc>> findAll();
}