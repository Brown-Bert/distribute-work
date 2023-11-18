package org.example.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterEntity implements Serializable {
    private static final long serialVersionUID = -14464576089987243L;

    private String serverName;

    private String serverPort;
}
