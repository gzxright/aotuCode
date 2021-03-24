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
@RequestMapping("/hisConfigInfo")
public interface HisConfigInfoFeign {

    /***
     * HisConfigInfo分页条件搜索实现
     * @param hisConfigInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) HisConfigInfo hisConfigInfo, @PathVariable  int page, @PathVariable  int size);

    /***
     * HisConfigInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param hisConfigInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<HisConfigInfo>> findList(@RequestBody(required = false) HisConfigInfo hisConfigInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改HisConfigInfo数据
     * @param hisConfigInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody HisConfigInfo hisConfigInfo,@PathVariable  id);

    /***
     * 新增HisConfigInfo数据
     * @param hisConfigInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody HisConfigInfo hisConfigInfo);

    /***
     * 根据ID查询HisConfigInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<HisConfigInfo> findById(@PathVariable  id);

    /***
     * 查询HisConfigInfo全部数据
     * @return
     */
    @GetMapping
    Result<List<HisConfigInfo>> findAll();
}