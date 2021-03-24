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
@RequestMapping("/staff")
public interface StaffFeign {

    /***
     * Staff分页条件搜索实现
     * @param staff
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Staff staff, @PathVariable  int page, @PathVariable  int size);

    /***
     * Staff分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param staff
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Staff>> findList(@RequestBody(required = false) Staff staff);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Staff数据
     * @param staff
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Staff staff,@PathVariable  id);

    /***
     * 新增Staff数据
     * @param staff
     * @return
     */
    @PostMapping
    Result add(@RequestBody Staff staff);

    /***
     * 根据ID查询Staff数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Staff> findById(@PathVariable  id);

    /***
     * 查询Staff全部数据
     * @return
     */
    @GetMapping
    Result<List<Staff>> findAll();
}