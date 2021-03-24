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
@RequestMapping("/authAccessToken")
public interface AuthAccessTokenFeign {

    /***
     * AuthAccessToken分页条件搜索实现
     * @param authAccessToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AuthAccessToken authAccessToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * AuthAccessToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param authAccessToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<AuthAccessToken>> findList(@RequestBody(required = false) AuthAccessToken authAccessToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改AuthAccessToken数据
     * @param authAccessToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AuthAccessToken authAccessToken,@PathVariable Integer id);

    /***
     * 新增AuthAccessToken数据
     * @param authAccessToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody AuthAccessToken authAccessToken);

    /***
     * 根据ID查询AuthAccessToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<AuthAccessToken> findById(@PathVariable Integer id);

    /***
     * 查询AuthAccessToken全部数据
     * @return
     */
    @GetMapping
    Result<List<AuthAccessToken>> findAll();
}