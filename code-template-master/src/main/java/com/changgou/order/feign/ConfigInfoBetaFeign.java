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
@RequestMapping("/configInfoBeta")
public interface ConfigInfoBetaFeign {

    /***
     * ConfigInfoBeta分页条件搜索实现
     * @param configInfoBeta
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ConfigInfoBeta configInfoBeta, @PathVariable  int page, @PathVariable  int size);

    /***
     * ConfigInfoBeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param configInfoBeta
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ConfigInfoBeta>> findList(@RequestBody(required = false) ConfigInfoBeta configInfoBeta);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ConfigInfoBeta数据
     * @param configInfoBeta
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ConfigInfoBeta configInfoBeta,@PathVariable  id);

    /***
     * 新增ConfigInfoBeta数据
     * @param configInfoBeta
     * @return
     */
    @PostMapping
    Result add(@RequestBody ConfigInfoBeta configInfoBeta);

    /***
     * 根据ID查询ConfigInfoBeta数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ConfigInfoBeta> findById(@PathVariable  id);

    /***
     * 查询ConfigInfoBeta全部数据
     * @return
     */
    @GetMapping
    Result<List<ConfigInfoBeta>> findAll();
}