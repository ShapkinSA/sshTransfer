package SettingsCfg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class RequestCfg {


    @XmlAttribute
    private String username;
    @XmlAttribute
    private String ip;
    @XmlAttribute
    private String password;
    @XmlAttribute
    private int portSSH;
    @XmlAttribute
    private String pathToFilesOnRemoteMachine;
    @XmlAttribute
    private String pathToFilesOnMainMachine;





}
