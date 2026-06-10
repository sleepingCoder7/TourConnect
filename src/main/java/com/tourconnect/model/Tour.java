package com.tourconnect.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "tours")
public class Tour {
    @Id
    private String id;

    @NotNull
    @Indexed(
            name = "tour_id_1",
            unique = true
    )
    @Field("tour_id")
    private Integer tourId;

    @NotBlank
    private String title;

    private String description;

    @Field("pick_up")
    private String pickup;

    @Field("meeting_point")
    private String meetingPoint;

    @Field("drop_off")
    private String dropOff;

    private Integer duration;

    @Field("duration_unit")
    private String durationUnit = "days";
}
