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
@RequestMapping("/authScope")
public interface AuthScopeFeign {

    /***
     * AuthScope分页条件搜索实现
     * @param authScope
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AuthScope authScope, @PathVariable  int page, @PathVariable  int size);

    /***
     * AuthScope分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param authScope
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<AuthScope>> findList(@RequestBody(required = false) AuthScope authScope);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改AuthScope数据
     * @param authScope
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AuthScope authScope,@PathVariable Integer id);

    /***
     * 新增AuthScope数据
     * @param authScope
     * @return
     */
    @PostMapping
    Result add(@RequestBody AuthScope authScope);

    /***
     * 根据ID查询AuthScope数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<AuthScope> findById(@PathVariable Integer id);

    /***
     * 查询AuthScope全部数据
     * @return
     */
    @GetMapping
    Result<List<AuthScope>> findAll();
}