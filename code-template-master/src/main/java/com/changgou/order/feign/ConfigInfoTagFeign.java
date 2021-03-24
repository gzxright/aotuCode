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
@RequestMapping("/configInfoTag")
public interface ConfigInfoTagFeign {

    /***
     * ConfigInfoTag分页条件搜索实现
     * @param configInfoTag
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ConfigInfoTag configInfoTag, @PathVariable  int page, @PathVariable  int size);

    /***
     * ConfigInfoTag分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param configInfoTag
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ConfigInfoTag>> findList(@RequestBody(required = false) ConfigInfoTag configInfoTag);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ConfigInfoTag数据
     * @param configInfoTag
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ConfigInfoTag configInfoTag,@PathVariable  id);

    /***
     * 新增ConfigInfoTag数据
     * @param configInfoTag
     * @return
     */
    @PostMapping
    Result add(@RequestBody ConfigInfoTag configInfoTag);

    /***
     * 根据ID查询ConfigInfoTag数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ConfigInfoTag> findById(@PathVariable  id);

    /***
     * 查询ConfigInfoTag全部数据
     * @return
     */
    @GetMapping
    Result<List<ConfigInfoTag>> findAll();
}