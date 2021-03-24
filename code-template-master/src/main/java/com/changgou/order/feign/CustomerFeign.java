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
@RequestMapping("/customer")
public interface CustomerFeign {

    /***
     * Customer分页条件搜索实现
     * @param customer
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Customer customer, @PathVariable  int page, @PathVariable  int size);

    /***
     * Customer分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param customer
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Customer>> findList(@RequestBody(required = false) Customer customer);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Customer数据
     * @param customer
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Customer customer,@PathVariable  id);

    /***
     * 新增Customer数据
     * @param customer
     * @return
     */
    @PostMapping
    Result add(@RequestBody Customer customer);

    /***
     * 根据ID查询Customer数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Customer> findById(@PathVariable  id);

    /***
     * 查询Customer全部数据
     * @return
     */
    @GetMapping
    Result<List<Customer>> findAll();
}