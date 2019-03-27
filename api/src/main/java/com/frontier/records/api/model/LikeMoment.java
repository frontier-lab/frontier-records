package com.frontier.records.api.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class LikeMoment implements Serializable {

    private static final long serialVersionUID = -3L;

    private int moment;
    private int likeCount;
}
