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
@RequestMapping("/ssoClientDetails")
public interface SsoClientDetailsFeign {

    /***
     * SsoClientDetails分页条件搜索实现
     * @param ssoClientDetails
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SsoClientDetails ssoClientDetails, @PathVariable  int page, @PathVariable  int size);

    /***
     * SsoClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param ssoClientDetails
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SsoClientDetails>> findList(@RequestBody(required = false) SsoClientDetails ssoClientDetails);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SsoClientDetails数据
     * @param ssoClientDetails
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SsoClientDetails ssoClientDetails,@PathVariable Integer id);

    /***
     * 新增SsoClientDetails数据
     * @param ssoClientDetails
     * @return
     */
    @PostMapping
    Result add(@RequestBody SsoClientDetails ssoClientDetails);

    /***
     * 根据ID查询SsoClientDetails数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SsoClientDetails> findById(@PathVariable Integer id);

    /***
     * 查询SsoClientDetails全部数据
     * @return
     */
    @GetMapping
    Result<List<SsoClientDetails>> findAll();
}