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
@RequestMapping("/users")
public interface UsersFeign {

    /***
     * Users分页条件搜索实现
     * @param users
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Users users, @PathVariable  int page, @PathVariable  int size);

    /***
     * Users分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param users
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Users>> findList(@RequestBody(required = false) Users users);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Users数据
     * @param users
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Users users,@PathVariable  id);

    /***
     * 新增Users数据
     * @param users
     * @return
     */
    @PostMapping
    Result add(@RequestBody Users users);

    /***
     * 根据ID查询Users数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Users> findById(@PathVariable  id);

    /***
     * 查询Users全部数据
     * @return
     */
    @GetMapping
    Result<List<Users>> findAll();
}