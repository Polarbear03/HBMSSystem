package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.model.entity.Review;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import com.example.service.inter.ReviewService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@Slf4j(topic = "Review Operator")
public class ReviewController {

    @Resource
    private ReviewService reviewService;

    @GetMapping("/listReview")
    //@PreAuthorize("hasAnyAuthority('/review/**','review:query')")
    @Transactional(readOnly = true)
    public JsonResponse<Page<Review>> getAllReview(@RequestParam(value = "reviewId", required = false) Integer reviewId,
                                                   @RequestParam(value = "reviewContent", required = false) String reviewContent,
                                                   @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (reviewId != null) {
            queryWrapper.eq("review_id", reviewId);
            flag = true;
        }
        if (reviewContent != null && !reviewContent.isEmpty()) {
            queryWrapper.like("review_content", reviewContent);
        }
        Page<Review> page = new Page<>(pageNo,pageSize);
        if (flag) {
            reviewService.page(page,queryWrapper);
            return JsonResponse.success(page);
        }
        reviewService.page(page);
        return JsonResponse.success(page);
    }

    @PostMapping("/modifyRev")
    @PreAuthorize("hasAnyAuthority('/review/**','review:update')")
    public JsonResponse<String> updateAdmin(@Validated(EditGroup.class) @RequestBody Review review) {
        boolean updateSuccess = reviewService.updateById(review);
        if (updateSuccess) {
            return JsonResponse.success("评论修改成功！");
        }
        return JsonResponse.error("评论暂时无法修改，请稍后重试！");
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('/review/**','review:add')")
    public JsonResponse<String> saveRev(@Validated(AddGroup.class) @RequestBody Review review) {
        boolean saveSuccess = reviewService.save(review);
        if (saveSuccess) {
            return JsonResponse.success("评论成功！");
        }
        return JsonResponse.error("评论失败，请稍后重试！");
    }

    @RequestMapping(value = "/removeRev/{revId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('/review/**','review:delete')")
    public JsonResponse<String> deleteRev(@PathVariable Integer revId) {
        boolean removeSuccess = reviewService.removeById(revId);
        if (removeSuccess) {
            return JsonResponse.success("删除评论成功！");
        }
        return JsonResponse.error("删除评论时出现错误，请稍后重试！");
    }

    @GetMapping("/getRevIds")
    @PreAuthorize("hasAnyAuthority('/review/**','review:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Review>> getRevIds() {
        QueryWrapper<Review> revQueryWrapper = new QueryWrapper<>();
        revQueryWrapper.select("review_id");
        return JsonResponse.success(reviewService.list(revQueryWrapper));
    }
}
