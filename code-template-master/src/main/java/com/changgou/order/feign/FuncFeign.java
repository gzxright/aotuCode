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
@RequestMapping("/func")
public interface FuncFeign {

    /***
     * Func分页条件搜索实现
     * @param func
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Func func, @PathVariable  int page, @PathVariable  int size);

    /***
     * Func分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param func
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Func>> findList(@RequestBody(required = false) Func func);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Func数据
     * @param func
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Func func,@PathVariable Integer id);

    /***
     * 新增Func数据
     * @param func
     * @return
     */
    @PostMapping
    Result add(@RequestBody Func func);

    /***
     * 根据ID查询Func数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Func> findById(@PathVariable Integer id);

    /***
     * 查询Func全部数据
     * @return
     */
    @GetMapping
    Result<List<Func>> findAll();
}