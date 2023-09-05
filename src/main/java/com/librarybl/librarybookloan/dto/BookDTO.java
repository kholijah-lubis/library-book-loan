package com.librarybl.librarybookloan.dto;
import javax.validation.constraints.Min;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class BookDTO {
    private UUID id;
    @NotNull
    private String title;

    @NotNull
    private String author;

    @Min(0)
    private int stockAvailable;
}
