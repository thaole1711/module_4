package com.example.thong_tin_bai_hat.global_exception_handler;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@EnableJpaAuditing
public class GlobalExceptionHandler {

    // 1. Lỗi binding (form không hợp lệ – validation sai kiểu, sai định dạng)
    @ExceptionHandler(BindException.class)
    public String handleValidation(BindException ex, Model model) {
        model.addAttribute("errorMessage", "Dữ liệu nhập vào không hợp lệ. Vui lòng kiểm tra lại.");
        return "error/400";
    }

    // 3. Lỗi hệ thống chung (NullPointer, lỗi bất ngờ)
    @ExceptionHandler(Exception.class)
    public String handleServerError(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Đã xảy ra lỗi hệ thống. Vui lòng thử lại sau.");
        return "error/500";
    }

    // 2. Lỗi 404 – không tìm thấy đường dẫn
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex, Model model) {
        model.addAttribute("errorMessage", "Trang bạn yêu cầu không tồn tại.");
        return "error/404";
    }
}
