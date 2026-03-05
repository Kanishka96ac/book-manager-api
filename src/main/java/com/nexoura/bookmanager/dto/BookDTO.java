package com.nexoura.bookmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Book Data Transfer Object")
public class BookDTO {

    @Schema(description = "Unique ID of the book", example = "1")
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Schema(description = "Title of the book", example = "Clean Code")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    @Schema(description = "Author of the book", example = "Robert C Martin")
    private String author;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Schema(description = "Price of the book", example = "45.5")
    private Double price;

    @NotNull(message = "Published year is required")
    @Min(value = 1000, message = "Invalid year")
    @Max(value = 2100, message = "Invalid year")
    @Schema(description = "Year the book was published", example = "2008")
    private Integer publishedYear;
}