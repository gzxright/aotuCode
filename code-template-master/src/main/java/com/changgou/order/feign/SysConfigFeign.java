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
@RequestMapping("/sysConfig")
public interface SysConfigFeign {

    /***
     * SysConfig分页条件搜索实现
     * @param sysConfig
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysConfig sysConfig, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysConfig分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysConfig
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysConfig>> findList(@RequestBody(required = false) SysConfig sysConfig);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改SysConfig数据
     * @param sysConfig
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysConfig sysConfig,@PathVariable  id);

    /***
     * 新增SysConfig数据
     * @param sysConfig
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysConfig sysConfig);

    /***
     * 根据ID查询SysConfig数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysConfig> findById(@PathVariable  id);

    /***
     * 查询SysConfig全部数据
     * @return
     */
    @GetMapping
    Result<List<SysConfig>> findAll();
}