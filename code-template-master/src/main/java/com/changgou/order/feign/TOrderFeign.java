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
@RequestMapping("/tOrder")
public interface TOrderFeign {

    /***
     * TOrder分页条件搜索实现
     * @param tOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) TOrder tOrder, @PathVariable  int page, @PathVariable  int size);

    /***
     * TOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param tOrder
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<TOrder>> findList(@RequestBody(required = false) TOrder tOrder);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改TOrder数据
     * @param tOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody TOrder tOrder,@PathVariable  id);

    /***
     * 新增TOrder数据
     * @param tOrder
     * @return
     */
    @PostMapping
    Result add(@RequestBody TOrder tOrder);

    /***
     * 根据ID查询TOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<TOrder> findById(@PathVariable  id);

    /***
     * 查询TOrder全部数据
     * @return
     */
    @GetMapping
    Result<List<TOrder>> findAll();
}