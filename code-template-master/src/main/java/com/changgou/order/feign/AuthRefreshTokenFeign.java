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
@RequestMapping("/authRefreshToken")
public interface AuthRefreshTokenFeign {

    /***
     * AuthRefreshToken分页条件搜索实现
     * @param authRefreshToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AuthRefreshToken authRefreshToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * AuthRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param authRefreshToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<AuthRefreshToken>> findList(@RequestBody(required = false) AuthRefreshToken authRefreshToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改AuthRefreshToken数据
     * @param authRefreshToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AuthRefreshToken authRefreshToken,@PathVariable Integer id);

    /***
     * 新增AuthRefreshToken数据
     * @param authRefreshToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody AuthRefreshToken authRefreshToken);

    /***
     * 根据ID查询AuthRefreshToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<AuthRefreshToken> findById(@PathVariable Integer id);

    /***
     * 查询AuthRefreshToken全部数据
     * @return
     */
    @GetMapping
    Result<List<AuthRefreshToken>> findAll();
}