package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Customer;
import com.example.model.entity.Merchant;
import com.example.service.inter.MerchantService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
@Slf4j(topic = "Merchant Operator")
public class MerchantController {

    @Resource
    private MerchantService merchantService;

    @GetMapping("/listMerchant")
    @PreAuthorize("hasAnyAuthority('/merchant/**','merchant:query')")
    @Transactional(readOnly = true)
    public JsonResponse<Page<Merchant>> getAllMerchant(@RequestParam(value = "merchantId", required = false) Integer merchantId,
                                                       @RequestParam(value = "fullName", required = false) String fullName,
                                                       @RequestParam(value = "contact", required = false) String contact,
                                                       @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        QueryWrapper<Merchant> merQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (merchantId != null) {
            merQueryWrapper.eq("merchant_id", merchantId);
            flag = true;
        }
        if (fullName != null && !fullName.isEmpty()) {
            merQueryWrapper.likeLeft("full_name", fullName);
            flag = true;
        }
        if (contact != null && !contact.isEmpty()) {
            merQueryWrapper.likeLeft("contact", contact);
            flag = true;
        }
        Page<Merchant> page = new Page<>(pageNo,pageSize);
        if (flag) {
            merchantService.page(page,merQueryWrapper);
            return JsonResponse.success(page);
        }
        merchantService.page(page);
        return JsonResponse.success(page);
    }


    @RequestMapping(value = "/removeMer/{merId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('/merchant/**','merchant:delete')")
    public JsonResponse<String> removeMerchant(@PathVariable Integer merId) {
        boolean removeSuccess = merchantService.removeById(merId);
        if (removeSuccess) {
            return JsonResponse.success("删除商家信息成功");
        }
        return JsonResponse.error("删除商家信息失败，请稍后重试");
    }

    @PostMapping("/saveMer")
    @PreAuthorize("hasAnyAuthority('/merchant/**','merchant:add')")
    public JsonResponse<String> saveMerchant(Merchant merchant) {
        boolean saveSuccess = merchantService.save(merchant);
        if (saveSuccess) {
            return JsonResponse.success("商家注册成功！");
        }
        return JsonResponse.error("注册失败，请稍后重试！");
    }

    @PostMapping("/updateMer")
    @PreAuthorize("hasAnyAuthority('/merchant/**','merchant:update')")
    public JsonResponse<String> updateMerchant(Merchant merchant) {
        boolean updateSuccess = merchantService.updateById(merchant);
        if (updateSuccess) {
            return JsonResponse.success("商家信息更新成功!");
        }
        return JsonResponse.error("商家信息更新失败，请稍后重试！");
    }

    /**
     * 获取所有的商家id，用于下拉框选取
     *
     * @return
     */
    @GetMapping("/getIds")
    @PreAuthorize("hasAnyAuthority('/merchant/**','merchant:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Merchant>> getMerIds() {
        QueryWrapper<Merchant> integerQueryWrapper = new QueryWrapper<>();
        integerQueryWrapper.select("merchant_id");
        return JsonResponse.success(merchantService.list(integerQueryWrapper));
    }

}
