package request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private String username;
    private String ip;
    private String password;
    private int portSSH;
    private String pathToFilesOnVB;
    private String pathToFilesOnWindows;

}
