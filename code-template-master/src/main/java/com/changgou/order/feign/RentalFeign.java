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
@RequestMapping("/rental")
public interface RentalFeign {

    /***
     * Rental分页条件搜索实现
     * @param rental
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Rental rental, @PathVariable  int page, @PathVariable  int size);

    /***
     * Rental分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param rental
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Rental>> findList(@RequestBody(required = false) Rental rental);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Rental数据
     * @param rental
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Rental rental,@PathVariable  id);

    /***
     * 新增Rental数据
     * @param rental
     * @return
     */
    @PostMapping
    Result add(@RequestBody Rental rental);

    /***
     * 根据ID查询Rental数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Rental> findById(@PathVariable  id);

    /***
     * 查询Rental全部数据
     * @return
     */
    @GetMapping
    Result<List<Rental>> findAll();
}