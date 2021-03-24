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
@RequestMapping("/configInfoAggr")
public interface ConfigInfoAggrFeign {

    /***
     * ConfigInfoAggr分页条件搜索实现
     * @param configInfoAggr
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ConfigInfoAggr configInfoAggr, @PathVariable  int page, @PathVariable  int size);

    /***
     * ConfigInfoAggr分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param configInfoAggr
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ConfigInfoAggr>> findList(@RequestBody(required = false) ConfigInfoAggr configInfoAggr);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ConfigInfoAggr数据
     * @param configInfoAggr
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ConfigInfoAggr configInfoAggr,@PathVariable  id);

    /***
     * 新增ConfigInfoAggr数据
     * @param configInfoAggr
     * @return
     */
    @PostMapping
    Result add(@RequestBody ConfigInfoAggr configInfoAggr);

    /***
     * 根据ID查询ConfigInfoAggr数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ConfigInfoAggr> findById(@PathVariable  id);

    /***
     * 查询ConfigInfoAggr全部数据
     * @return
     */
    @GetMapping
    Result<List<ConfigInfoAggr>> findAll();
}