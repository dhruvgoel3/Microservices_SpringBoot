package com.ms.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
