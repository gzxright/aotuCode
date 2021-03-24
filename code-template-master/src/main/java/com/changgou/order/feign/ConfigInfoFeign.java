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
@RequestMapping("/configInfo")
public interface ConfigInfoFeign {

    /***
     * ConfigInfo分页条件搜索实现
     * @param configInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ConfigInfo configInfo, @PathVariable  int page, @PathVariable  int size);

    /***
     * ConfigInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param configInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ConfigInfo>> findList(@RequestBody(required = false) ConfigInfo configInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ConfigInfo数据
     * @param configInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ConfigInfo configInfo,@PathVariable  id);

    /***
     * 新增ConfigInfo数据
     * @param configInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody ConfigInfo configInfo);

    /***
     * 根据ID查询ConfigInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ConfigInfo> findById(@PathVariable  id);

    /***
     * 查询ConfigInfo全部数据
     * @return
     */
    @GetMapping
    Result<List<ConfigInfo>> findAll();
}