package com.example.form_dang_nhap.dto;

import com.example.form_dang_nhap.validator.Age18Plus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "tên không được để trống")
    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\s]{5,45}$", message = "Chỉ nhập chữ và khoảng trắng, độ dài 5-45 ký tự")
    private String lastName;
    @NotBlank(message = "tên không được để trống")
    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\s]{5,45}$", message = "Chỉ nhập chữ và khoảng trắng, độ dài 5-45 ký tự")
    private String firstName;
    @NotBlank(message = "sdt không được để trống")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9}$", message = "Số điện thoại phải bắt đầu bằng 0 hoặc +84 và có đúng 9 chữ số sau đó")
    private String phone;
   @Past(message = "tuổi phải ở quá khứ")
   @Age18Plus(message = "lớn hơn 18 tuổi")
   @NotNull(message = "không được để trống")
    private LocalDate birthDay;
    @NotNull(message = "email không được để trống")
    @Pattern(regexp ="^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Nhập đúng định dạng email.vd:Lethuthao@gmail.com")
    private String email;
}
