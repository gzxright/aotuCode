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
@RequestMapping("/groupCapacity")
public interface GroupCapacityFeign {

    /***
     * GroupCapacity分页条件搜索实现
     * @param groupCapacity
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) GroupCapacity groupCapacity, @PathVariable  int page, @PathVariable  int size);

    /***
     * GroupCapacity分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param groupCapacity
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<GroupCapacity>> findList(@RequestBody(required = false) GroupCapacity groupCapacity);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改GroupCapacity数据
     * @param groupCapacity
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody GroupCapacity groupCapacity,@PathVariable  id);

    /***
     * 新增GroupCapacity数据
     * @param groupCapacity
     * @return
     */
    @PostMapping
    Result add(@RequestBody GroupCapacity groupCapacity);

    /***
     * 根据ID查询GroupCapacity数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<GroupCapacity> findById(@PathVariable  id);

    /***
     * 查询GroupCapacity全部数据
     * @return
     */
    @GetMapping
    Result<List<GroupCapacity>> findAll();
}