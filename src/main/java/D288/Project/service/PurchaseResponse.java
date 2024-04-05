package D288.Project.service;

import D288.Project.entity.StatusType;
import lombok.*;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;
    private StatusType status;

}
