package SettingsCfg;

import lombok.Data;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cfg")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SettingsCfg {

    @XmlElementWrapper(name = "toRemoteMachine")
    @XmlElement(name = "item")
    private List<RequestCfg> listTo;


    @XmlElementWrapper(name = "fromRemoteMachine")
    @XmlElement(name = "item")
    private List<RequestCfg> listFrom;

}
