package com.example.quan_ly_con_heo.dto;

import com.example.quan_ly_con_heo.entity.CountryOrigin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BigDTO {
    private String idBig;
    @NotNull(message = "Ngày nhập chuồng không được để trống")
    @PastOrPresent(message = "Ngày nhập chuồng không được là tương lai")
    private LocalDate dateOfEntry;

    @Positive(message = "Trọng lượng nhập phải lớn hơn 0")
    private double entryWeight;

    @PastOrPresent(message = "Ngày xuất chuồng không được là tương lai")
    private LocalDate dateOfExit;

    @Positive(message = "Trọng lượng nhập phải lớn hơn 0")
    private double exitWeight;

    @NotNull(message = "Vui lòng chọn xuất xứ")
    private CountryOrigin countryOrigin;
}
