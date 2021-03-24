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
@RequestMapping("/ssoAccessToken")
public interface SsoAccessTokenFeign {

    /***
     * SsoAccessToken分页条件搜索实现
     * @param ssoAccessToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SsoAccessToken ssoAccessToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * SsoAccessToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param ssoAccessToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SsoAccessToken>> findList(@RequestBody(required = false) SsoAccessToken ssoAccessToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SsoAccessToken数据
     * @param ssoAccessToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SsoAccessToken ssoAccessToken,@PathVariable Integer id);

    /***
     * 新增SsoAccessToken数据
     * @param ssoAccessToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody SsoAccessToken ssoAccessToken);

    /***
     * 根据ID查询SsoAccessToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SsoAccessToken> findById(@PathVariable Integer id);

    /***
     * 查询SsoAccessToken全部数据
     * @return
     */
    @GetMapping
    Result<List<SsoAccessToken>> findAll();
}