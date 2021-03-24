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
@RequestMapping("/authClientUser")
public interface AuthClientUserFeign {

    /***
     * AuthClientUser分页条件搜索实现
     * @param authClientUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AuthClientUser authClientUser, @PathVariable  int page, @PathVariable  int size);

    /***
     * AuthClientUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param authClientUser
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<AuthClientUser>> findList(@RequestBody(required = false) AuthClientUser authClientUser);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改AuthClientUser数据
     * @param authClientUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AuthClientUser authClientUser,@PathVariable Integer id);

    /***
     * 新增AuthClientUser数据
     * @param authClientUser
     * @return
     */
    @PostMapping
    Result add(@RequestBody AuthClientUser authClientUser);

    /***
     * 根据ID查询AuthClientUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<AuthClientUser> findById(@PathVariable Integer id);

    /***
     * 查询AuthClientUser全部数据
     * @return
     */
    @GetMapping
    Result<List<AuthClientUser>> findAll();
}