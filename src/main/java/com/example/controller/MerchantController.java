package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Customer;
import com.example.model.entity.Merchant;
import com.example.service.inter.MerchantService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
    @Transactional(readOnly = true)
    public JsonResponse<List<Merchant>> getAllMerchant(@RequestParam(value = "merchantId",required = false) Integer merchantId,
                                                       @RequestParam(value = "fullName",required = false) String fullName,
                                                       @RequestParam(value = "contact",required = false) String contact) {
        QueryWrapper<Merchant> merQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (merchantId != null) {
            merQueryWrapper.eq("merchant_id",merchantId);
            flag = true;
        }
        if (fullName != null && !fullName.isEmpty()) {
            merQueryWrapper.likeLeft("full_name",fullName);
            flag = true;
        }
        if (contact != null && !contact.isEmpty()) {
            merQueryWrapper.likeLeft("contact",contact);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(merchantService.list(merQueryWrapper));
        }
        return JsonResponse.success(merchantService.list());
    }


    @RequestMapping(value = "/removeMer/{merId}",method = RequestMethod.DELETE)
    public JsonResponse<String> removeMerchant(@PathVariable Integer merId) {
        boolean removeSuccess = merchantService.removeById(merId);
        if (removeSuccess) {
            return JsonResponse.success("删除商家信息成功");
        }
        return JsonResponse.error("删除商家信息失败，请稍后重试");
    }

    @PostMapping("/saveMer")
    public JsonResponse<String> saveMerchant(Merchant merchant) {
        boolean saveSuccess = merchantService.save(merchant);
        if (saveSuccess) {
            return JsonResponse.success("商家注册成功！");
        }
        return JsonResponse.error("注册失败，请稍后重试！");
    }

    @PostMapping("/updateMer")
    public JsonResponse<String> updateMerchant(Merchant merchant) {
        boolean updateSuccess = merchantService.updateById(merchant);
        if (updateSuccess) {
            return JsonResponse.success("商家信息更新成功!");
        }
        return JsonResponse.error("商家信息更新失败，请稍后重试！");
    }

    /**
     * 获取所有的商家id，用于下拉框选取
     * @return
     */
    @GetMapping("/getIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<Merchant>> getMerIds() {
        QueryWrapper<Merchant> integerQueryWrapper = new QueryWrapper<>();
        integerQueryWrapper.select("merchant_id");
        return JsonResponse.success(merchantService.list(integerQueryWrapper));
    }

}
