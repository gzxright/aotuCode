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
@RequestMapping("/payment")
public interface PaymentFeign {

    /***
     * Payment分页条件搜索实现
     * @param payment
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Payment payment, @PathVariable  int page, @PathVariable  int size);

    /***
     * Payment分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param payment
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Payment>> findList(@RequestBody(required = false) Payment payment);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Payment数据
     * @param payment
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Payment payment,@PathVariable  id);

    /***
     * 新增Payment数据
     * @param payment
     * @return
     */
    @PostMapping
    Result add(@RequestBody Payment payment);

    /***
     * 根据ID查询Payment数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Payment> findById(@PathVariable  id);

    /***
     * 查询Payment全部数据
     * @return
     */
    @GetMapping
    Result<List<Payment>> findAll();
}