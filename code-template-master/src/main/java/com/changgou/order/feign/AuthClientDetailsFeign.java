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
@RequestMapping("/authClientDetails")
public interface AuthClientDetailsFeign {

    /***
     * AuthClientDetails分页条件搜索实现
     * @param authClientDetails
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AuthClientDetails authClientDetails, @PathVariable  int page, @PathVariable  int size);

    /***
     * AuthClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param authClientDetails
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<AuthClientDetails>> findList(@RequestBody(required = false) AuthClientDetails authClientDetails);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改AuthClientDetails数据
     * @param authClientDetails
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AuthClientDetails authClientDetails,@PathVariable Integer id);

    /***
     * 新增AuthClientDetails数据
     * @param authClientDetails
     * @return
     */
    @PostMapping
    Result add(@RequestBody AuthClientDetails authClientDetails);

    /***
     * 根据ID查询AuthClientDetails数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<AuthClientDetails> findById(@PathVariable Integer id);

    /***
     * 查询AuthClientDetails全部数据
     * @return
     */
    @GetMapping
    Result<List<AuthClientDetails>> findAll();
}