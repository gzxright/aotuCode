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
@RequestMapping("/ssoRefreshToken")
public interface SsoRefreshTokenFeign {

    /***
     * SsoRefreshToken分页条件搜索实现
     * @param ssoRefreshToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SsoRefreshToken ssoRefreshToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * SsoRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param ssoRefreshToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SsoRefreshToken>> findList(@RequestBody(required = false) SsoRefreshToken ssoRefreshToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SsoRefreshToken数据
     * @param ssoRefreshToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SsoRefreshToken ssoRefreshToken,@PathVariable Integer id);

    /***
     * 新增SsoRefreshToken数据
     * @param ssoRefreshToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody SsoRefreshToken ssoRefreshToken);

    /***
     * 根据ID查询SsoRefreshToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SsoRefreshToken> findById(@PathVariable Integer id);

    /***
     * 查询SsoRefreshToken全部数据
     * @return
     */
    @GetMapping
    Result<List<SsoRefreshToken>> findAll();
}