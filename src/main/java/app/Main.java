package app;


import SettingsCfg.SettingsCfg;
import lombok.extern.slf4j.Slf4j;
import removerFilesInDerectory.RemoverFilesInDerectory;
import utils.WorkWithConfigGFiles;


import java.io.IOException;

@Slf4j
public class Main {


    public static void main(String[] args) throws IOException {

        SettingsCfg cfg = WorkWithConfigGFiles.unMarshalAny(SettingsCfg.class, args[0]);

        //Загрузка файлов
        cfg.getListTo().forEach(el->{
            String command = "scp -r " + el.getPathToFilesOnMainMachine() + " "+
                    el.getUsername() +
                    "@" + el.getIp() + ":" +
                    el.getPathToFilesOnRemoteMachine();

            //Предварительное удаление каталога
//            RemoverFilesInDerectory.delAllFile(el.getPathToFilesOnRemoteMachine());

            Process process = null;
            try {
                process = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }

            log.info("Начало загрузки файлов проекта из {} в {}",el.getPathToFilesOnMainMachine(), el.getPathToFilesOnRemoteMachine());

            while (process.isAlive()) {
            }
            log.info("Загрузка файлов завершена");
        });


        //Скачивание файлов
        cfg.getListFrom().forEach(el->{
            String command = "scp -r " + el.getUsername() +
                    "@" + el.getIp() + ":" +
                    el.getPathToFilesOnRemoteMachine() + " " + el.getPathToFilesOnMainMachine();

            //Предварительное удаление каталога
//            RemoverFilesInDerectory.delAllFile(el.getPathToFilesOnMainMachine());

            Process process = null;
            try {
                process = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }

            log.info("Начало скачивания файлов проекта из {} в {}",el.getPathToFilesOnRemoteMachine(), el.getPathToFilesOnMainMachine());

            while (process.isAlive()) {
            }
            log.info("Скачивание файлов завершено");
        });




    }
}

